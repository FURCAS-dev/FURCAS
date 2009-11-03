package com.sap.mi.tools.cockpit.editor.model.properties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.tools.cockpit.editor.model.command.SetAttributeCommand;
import com.sap.mi.tools.cockpit.editor.model.command.SetMultiValuedAttributeCommand;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.Partitionable;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * @author d003456
 * 
 */
public class MultiValuedAttributePropertySource implements IPropertySource {

	private static final TracerI tracer = TracingManager.getTracer(MiLocations.MI_MODELBROWSER);

	private Collection<?> coll = null;

	private String attrName = null;

	private final RefObject refObject;

	private final Map<Object, IPropertyDescriptor> valueToDescriptor = new HashMap<Object, IPropertyDescriptor>();

	/**
	 * This indicates that this method has already been called and a moin cmd is currently executing the execution of this cmd causes
	 * property change events which cause the prop sheet to refresh. In turn when the prop sheet refreshes it tries to save first which
	 * causes setPropValue to be called which ultimately leads to an infinite loop. This check breaks the infinite loop!
	 */
	private boolean runningMoinCmd;

	private PropertyHelper propHelper = null;

	/**
	 * Constructor
	 * 
	 * @param attrName
	 * @param coll
	 */
	public MultiValuedAttributePropertySource(String attrName, Collection<?> coll, RefObject refObj) {

		this.coll = coll;
		this.attrName = attrName;
		this.refObject = refObj;
		this.propHelper = new PropertyHelper();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {

		// otherwise value field of "plus" object is filled
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {

		final List<IPropertyDescriptor> descriptorList = new ArrayList<IPropertyDescriptor>(this.coll.size());

		final RefObject metaObject = this.refObject.refMetaObject();
		final JmiHelper jmiHelper = ((Partitionable) this.refObject).get___Connection().getJmiHelper();
		final Attribute attribute = jmiHelper.getAttributeByName((MofClass) metaObject, this.attrName, true);
		final Classifier type = jmiHelper.getNonAliasType(attribute.getType());

		int j = 0;
		for (final Object object : this.coll) {

			if (type instanceof StructureType || type instanceof MofClass) {

				final ModelBrowserPropertyDescriptor desc = new ModelBrowserPropertyDescriptor(object, Integer.toString(j));
				desc.setDescription(Integer.toString(j));
				desc.setIsAttribute(false);
				desc.setIsEditable(false);
				desc.setIsMultiValued(true);
				desc.setIndex(j);
				desc.setType(AttributeValueType.structure_type);
				descriptorList.add(desc);
				this.valueToDescriptor.put(object, desc);

			} else if (type instanceof EnumerationType) {
				final String[] labels = this.propHelper.getLabelsForEnumerationOrBoolean(this.attrName, this.refObject);
				if (labels.length > 0) {
					final ComboBoxPropertyDescriptor comboDesc = new ComboBoxPropertyDescriptor(object, Integer.toString(j), labels);
					descriptorList.add(comboDesc);
					this.valueToDescriptor.put(object, comboDesc);

				} else {// this should not happen
					ModelBrowserPropertyDescriptor desc = null;
					desc = new ModelBrowserPropertyDescriptor(object, Integer.toString(j));
					descriptorList.add(desc);
					this.valueToDescriptor.put(object, desc);
				}

			} else if (type instanceof PrimitiveType) {
				final String[] labels = this.propHelper.getLabelsForEnumerationOrBoolean(this.attrName, this.refObject);
				if (labels.length > 0) {// Boolean
					final ComboBoxPropertyDescriptor comboDesc = new ComboBoxPropertyDescriptor(object, Integer.toString(j), labels);
					descriptorList.add(comboDesc);
					this.valueToDescriptor.put(object, comboDesc);

				} else {
					ModelBrowserTextPropertyDescriptor desc = null;
					final Class<?> typeClass = jmiHelper.getJavaPrimitiveOrWrapperType(attribute);
					final ICellEditorValidator validator = DynamicCellValidatorFactory.getInstance(typeClass);
					desc = new ModelBrowserTextPropertyDescriptor(object, Integer.toString(j));
					desc.setValidator(validator);
					desc.setIsAttribute(false);
					desc.setIsEditable(true);
					desc.setIsMultiValued(true);
					desc.setIndex(j);
					descriptorList.add(desc);
					this.valueToDescriptor.put(object, desc);
				}
			}
			j = j + 1;
		}
		return descriptorList.toArray(new IPropertyDescriptor[descriptorList.size()]);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	@SuppressWarnings("nls")
	public Object getPropertyValue(Object id) {

		String res = "";
		if (id instanceof RefObject) {
			res = getNameOfRefObject(id);
			final String name = this.propHelper.tryGetUsefulName((RefObject) id);
			if (!name.equals("")) {
				res = res + name;
			}
		} else if (id instanceof Boolean) {
			if (((Boolean) id).equals(Boolean.TRUE)) {
				return 1; // index for "true"
			}
			if (((Boolean) id).equals(Boolean.FALSE)) {
				return 2; // index for "false"
			}
			return 0; // index for empty string (null)
		} else {
			return id.toString();
		}
		return res;
	}

	@SuppressWarnings("nls")
	private String getNameOfRefObject(Object id) {

		final List<String> qualifiedName = ((ModelElement) ((RefObject) id).refMetaObject()).getQualifiedName();
		String finalName = "";
		for (final String name : qualifiedName) {
			finalName = finalName + name;
			finalName = finalName + ".";
		}

		// Omit last "."
		finalName = finalName.substring(0, finalName.lastIndexOf("."));
		return finalName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(Object id) {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
	 */
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
		Attribute attribute = null;
		try {
			final RefObject metaObject = this.refObject.refMetaObject();
			con = ModelAdapterUI.getInstance().getConnection(this.refObject);
			final JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(this.refObject);
			attribute = jmiHelper.getAttributeByName((MofClass) metaObject, this.attrName, true);

			// labels for Boolean or EnumerationType
			if (value instanceof Integer) {
				final String[] labels = this.propHelper.getLabelsForEnumerationOrBoolean(this.attrName, this.refObject);
				if (labels.length > 0) {
					newValue = ModelManager.getInstance().getRefValueObject(this.refObject, attribute, labels[(Integer) value]);
				}
				final SetAttributeCommand command = new SetAttributeCommand(this.refObject, attribute, newValue);
				command.execute();

			} else {
				final ModelBrowserTextPropertyDescriptor desc = (ModelBrowserTextPropertyDescriptor) this.valueToDescriptor.get(id);
				newValue = ModelManager.getInstance().getRefValueObject(this.refObject, attribute, value.toString());
				final SetMultiValuedAttributeCommand command = new SetMultiValuedAttributeCommand(this.refObject, attribute, id, newValue,
						desc.getIndex());
				command.execute();
			}

			ConnectionManagerUI.getInstance().save(con, null);

		}
		catch (final Exception e) {
			MultiValuedAttributePropertySource.tracer.error("Error while changing property '" + id + "'. " + e.getLocalizedMessage(), e); //$NON-NLS-1$ //$NON-NLS-2$
		}
		finally {
			this.runningMoinCmd = false;
		}

	}
}
