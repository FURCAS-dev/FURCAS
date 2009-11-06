package com.sap.mi.tools.cockpit.editor.model.properties;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.command.SetAttributeCommand;
import com.sap.mi.tools.cockpit.editor.provider.MOINBrowserLabelProvider;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * @author d003456
 * 
 */
public class RefObjectPropertySource implements IPropertySource {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MODELBROWSER);

	private static final String CAT_MODEL_ATTRIBUTES = Messages.RefObjectPropertySource_0_xhed;

	private static final String CAT_META_MODEL_INFO = Messages.RefObjectPropertySource_1_xhed;

	private static final IPropertyDescriptor[] NO_PROPERTIES = new IPropertyDescriptor[0];

	private final Map<List<?>, IPropertyDescriptor[]> mofClassToDescriptors = new HashMap<List<?>, IPropertyDescriptor[]>();

	//
	// to do: when MOIN terminology available, change strings below
	//
	private static final String P_ID_NAME = "P_ID_NAME"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_NAME = "Name"; //$NON-NLS-1$

	private static final String P_ID_QUALIFIED_NAME = "P_ID_QUALIFIED_NAME"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_QUALIFIED_NAME = "Qualified Name"; //$NON-NLS-1$

	private static final String P_ID_META_MODEL_NAME = "P_ID_META_MODEL_NAME"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_META_MODEL_NAME = "Meta Model Name"; //$NON-NLS-1$

	private static final String P_ID_CONTAINER = "P_ID_CONTAINER"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_CONTAINER = "Container"; //$NON-NLS-1$

	private static final String P_ID_PARTITION_NAME = "P_ID_PARTITION_NAME"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_PARTITION_NAME = "Partition Name"; //$NON-NLS-1$

	private static final String P_ID_MOF_ID = "P_ID_MOF_ID"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_MOF_ID = "Mof Id"; //$NON-NLS-1$

	private static final String P_ID_PACKAGE = "P_ID_PACKAGE"; //$NON-NLS-1$
	
	private static final String P_DISPLAY_PACKAGE = "Package Hierarchy"; //$NON-NLS-1$

	private final RefObject refObj;

	private final boolean isReadOnly;

	private PropertyHelper propHelper = null;

	/**
	 * This indicates that this method has already been called and a moin cmd is currently executing the execution of this cmd causes
	 * property change events which cause the prop sheet to refresh. In turn when the prop sheet refreshes it tries to save first which
	 * causes setPropValue to be called which ultimately leads to an infinite loop. This check breaks the infinite loop!
	 */
	private boolean runningMoinCmd;

	/**
	 * Creates the {@link IPropertySource} using the given {@link RefObject} and {@link IModelEditor}
	 * 
	 * @param refObj
	 *            The object to use
	 * @param editor
	 *            The editor which triggered the property sheet to appear
	 */
	public RefObjectPropertySource(RefObject refObj, boolean readOnly) {

		this.isReadOnly = false;
		this.refObj = refObj;
		this.propHelper = new PropertyHelper();
	}

	public Object getEditableValue() {

		return null;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {

		if (!((Partitionable) this.refObj).is___Alive()) {
			return RefObjectPropertySource.NO_PROPERTIES; // may happen for just deleted objects
		}

		final RefObject metaObject = this.refObj.refMetaObject();
		if (!(metaObject instanceof MofClass)) {
			return RefObjectPropertySource.NO_PROPERTIES;
		}

		// cache descriptors globally in the factory
		final List<String> qualifiedName = ((MofClass) metaObject).getQualifiedName();
		IPropertyDescriptor[] descriptors = this.mofClassToDescriptors.get(qualifiedName);

		if (descriptors == null) {
			final JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(this.refObj);
			final List<Attribute> attributes = jmiHelper.getAttributes((MofClass) metaObject, true);
			final List<IPropertyDescriptor> descriptorList = new ArrayList<IPropertyDescriptor>(attributes.size());

			// category general
			createPropertyDescriptorsForCategoryGeneral(descriptorList);

			// category attributes
			for (final Attribute attr : attributes) {
				final Classifier type = jmiHelper.getNonAliasType(attr.getType());
				PropertyDescriptor desc = null;
				final String attrName = attr.getName();

				// no editor so all fields will be read only
				if (this.isReadOnly) {
					desc = new PropertyDescriptor(attrName, attrName + ": " + type.getName()); //$NON-NLS-1$
				} else {
					if (attr.getMultiplicity().getUpper() == 1) {

						if (type instanceof PrimitiveType) {
							if (type.getName().equals("Boolean")) { //$NON-NLS-1$
								// although a primitive it will be handled like
								// an enumeration
								desc = new ComboBoxPropertyDescriptor(attrName, attrName + ": " + type.getName(), this.propHelper //$NON-NLS-1$
										.getLabelsForEnumerationOrBoolean(attrName, this.refObj));
							} else {
								// create an input field for all other
								// primitives
								final Class<?> typeClass = jmiHelper.getJavaPrimitiveOrWrapperType(attr);
								final ICellEditorValidator validator = DynamicCellValidatorFactory.getInstance(typeClass);
								desc = new TextPropertyDescriptor(attrName, attrName + ": " + type.getName()); //$NON-NLS-1$
								desc.setValidator(validator);
							}
						} else if (type instanceof EnumerationType) {

							desc = new ComboBoxPropertyDescriptor(attrName, attrName + ": " + type.getName(), this.propHelper //$NON-NLS-1$
									.getLabelsForEnumerationOrBoolean(attrName, this.refObj));

						} else if (type instanceof MofClass) {
							// it is an object
							final Object o = this.refObj.refGetValue(attrName);
							final Collection<RefObject> isObject = new ArrayList<RefObject>();
							isObject.add((RefObject) o);
							final String propValue = getLabelForCollection(attr, isObject);
							desc = new PropertyDescriptor(attrName, propValue);
						} else {
							// all other types are displayed as read only field
							// showing their name and value
							desc = new PropertyDescriptor(attrName, attrName + ": " + type.getName()); //$NON-NLS-1$
						}

					} else if (attr.getMultiplicity().getUpper() != 1) {
						// Collection with attributes or objects!
						final Collection<?> childValues = (Collection<?>) this.refObj.refGetValue(attr);
						final String propValue = getLabelForCollection(attr, childValues);
						desc = new PropertyDescriptor(attrName, propValue);

					}

				}

				desc.setDescription(attr.getAnnotation());
				desc.setCategory(RefObjectPropertySource.CAT_MODEL_ATTRIBUTES);
				descriptorList.add(desc);
			}

			descriptors = descriptorList.toArray(new IPropertyDescriptor[descriptorList.size()]);
			this.mofClassToDescriptors.put(qualifiedName, descriptors);
		}
		return descriptors;
	}

	private void createPropertyDescriptorsForCategoryGeneral(List<IPropertyDescriptor> descriptorList) {

		PropertyDescriptor currProp;
		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_NAME, RefObjectPropertySource.P_DISPLAY_NAME);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_QUALIFIED_NAME, RefObjectPropertySource.P_DISPLAY_QUALIFIED_NAME);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_CONTAINER, RefObjectPropertySource.P_DISPLAY_CONTAINER);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_PARTITION_NAME, RefObjectPropertySource.P_DISPLAY_PARTITION_NAME);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_PACKAGE, RefObjectPropertySource.P_DISPLAY_PACKAGE);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_META_MODEL_NAME, RefObjectPropertySource.P_DISPLAY_META_MODEL_NAME);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

		currProp = new PropertyDescriptor(RefObjectPropertySource.P_ID_MOF_ID, RefObjectPropertySource.P_DISPLAY_MOF_ID);
		currProp.setCategory(RefObjectPropertySource.CAT_META_MODEL_INFO);
		descriptorList.add(currProp);

	}

	private String getLabelForCollection(Attribute attribute, Collection<?> childValues) {

		final ModelElement element = this.propHelper.getMetaClass(attribute.getType());
		String collectionTypeName = element.getName();
		if (collectionTypeName == null) {
			collectionTypeName = MOINBrowserLabelProvider.UNKNOWN_LABEL;
		}
		String upperValue = null;
		if (attribute.getMultiplicity().getUpper() == -1) {
			upperValue = "*"; //$NON-NLS-1$
		} else {
			upperValue = Integer.toString(attribute.getMultiplicity().getUpper());
		}
		String propValue = null;
		if (attribute.getMultiplicity().isOrdered()) {
			if (attribute.getMultiplicity().isUnique()) {
				propValue = Messages.RefObjectPropertySource_8_xcel;
			} else {
				propValue = Messages.RefObjectPropertySource_9_xcel;
			}
		} else {
			if (attribute.getMultiplicity().isUnique()) {
				propValue = Messages.RefObjectPropertySource_10_xcel;
			} else {
				propValue = Messages.RefObjectPropertySource_11_xcel;
			}
		}
		// + (childValues.isEmpty() ? " <Empty>" : "");
		return MessageFormat.format(propValue, new Object[] { attribute.getName(), attribute.getType().getName(), collectionTypeName,
				attribute.getMultiplicity().getLower(), upperValue });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {

		if (id.equals(RefObjectPropertySource.P_ID_CONTAINER)) {
			return this.propHelper.getContainerName(this.refObj);
		}
		if (id.equals(RefObjectPropertySource.P_ID_PARTITION_NAME)) {
			return this.propHelper.getPartitionName(this.refObj);
		}
		if (id.equals(RefObjectPropertySource.P_ID_PACKAGE)) {
			return this.propHelper.getPackage(this.refObj);
		}
		if (id.equals(RefObjectPropertySource.P_ID_NAME)) {
			return this.propHelper.getName(this.refObj);
		}
		if (id.equals(RefObjectPropertySource.P_ID_QUALIFIED_NAME)) {
			return this.propHelper.getQualifiedName(this.refObj);
		}
		if (id.equals(RefObjectPropertySource.P_ID_META_MODEL_NAME)) {
			return this.propHelper.getMetaModelName(this.refObj);
		}
		if (id.equals(RefObjectPropertySource.P_ID_MOF_ID)) {
			return this.refObj.refMofId();
		}

		final String attrName = (String) id;
		final Object value = this.refObj.refGetValue(attrName);

		if (!this.isReadOnly) {

			// handle collection with multiple values
			if (value instanceof Collection) {
				final Collection<?> coll = (Collection<?>) value;
				return new MultiValuedAttributePropertySource(attrName, coll, this.refObj);
			}

			// handle Boolean or boolean, where 0 indicates
			// empty (null); or an Enumeration,
			final String[] labels = this.propHelper.getLabelsForEnumerationOrBoolean(attrName, this.refObj);
			if (labels.length > 0) {
				if (value == null) {
					return 0;
				} else {
					// find label and return index
					final int pos = this.propHelper.findLabelPos(labels, value);
					if (pos < 0) {
						return MOINBrowserLabelProvider.ERROR_LABEL;
					}
					return pos;
				}
			}

			// handle all others
			if (value != null) {
				final String name = ModelManager.getInstance().getObjectName(value);
				return name;
			}
		}
		return ""; //$NON-NLS-1$
	}

	public boolean isPropertySet(Object id) {

		return false;
	}

	public void resetPropertyValue(Object id) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {

		if (this.runningMoinCmd) {
			return;
		}
		this.runningMoinCmd = true;

		Object newValue = null;
		Connection con = null;
		Attribute attr = null;
		try {
			final String attrName = (String) id;
			final RefObject metaObject = this.refObj.refMetaObject();
			con = ModelAdapterUI.getInstance().getConnection(this.refObj);
			final JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(this.refObj);
			attr = jmiHelper.getAttributeByName((MofClass) metaObject, attrName, true);

			if (value instanceof Integer) {
				final String[] labels = this.propHelper.getLabelsForEnumerationOrBoolean(attrName, this.refObj);
				if (labels.length > 0) {
					newValue = ModelManager.getInstance().getRefValueObject(this.refObj, attr, labels[(Integer) value]);
				}
			} else {
				newValue = ModelManager.getInstance().getRefValueObject(this.refObj, attr, value.toString());
			}

			final SetAttributeCommand command = new SetAttributeCommand(this.refObj, attr, newValue);
			command.execute();
			ConnectionManagerUI.getInstance().save(con, null);
		}
		catch (final Exception e) {
			RefObjectPropertySource.tracer.log(Level.SEVERE, "Error while changing property '" + id + "'. " + e.getLocalizedMessage(), e); //$NON-NLS-1$ //$NON-NLS-2$
		}
		finally {
			this.runningMoinCmd = false;
		}
	}

}
