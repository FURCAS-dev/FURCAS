package com.sap.mi.fwk.ui.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.MiFwkUiExtensionFactory;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.internal.properties.DynamicCellValidatorFactory;
import com.sap.mi.fwk.ui.internal.properties.SetAttributeCommand;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Property provider for {@link RefObject RefObjects}
 * 
 * @author d024127
 * @author d031150
 */
// TODO [Properties] remove adapter factory access
// as soon as TreeNodes in tgbase moved to this plugin
public final class RefObjectPropertySourceManager implements IPropertySourceProvider, IAdapterFactory {

    private final static String[] EMPTY_STRING_ARRAY = new String[0];
    private final static String[] defaultBooleanTypeLabels = { Boolean.TRUE.toString(), Boolean.FALSE.toString() };
    private final static String[] defaultBooleanClassLabels = { "", Boolean.TRUE.toString(), Boolean.FALSE.toString() }; //$NON-NLS-1$

    private static final TracerI sTracer = TracingManager.getTracer(RefObjectPropertySourceManager.class);

    /**
     * Creates a property manager. It is able to decide on its own, based on the
     * selection, whether the properties are read-only or not.
     */
    public RefObjectPropertySourceManager() {
    }

    public IPropertySource getPropertySource(Object object) {
	RefObject refObj = ModelAdapterUI.getInstance().getRefObject(object);
	if (refObj != null) {
	    Collection<IModelEditor> editors = ModelEditorManager.getInstance().getAllActiveModelEditors(
		    ((Partitionable) refObj).get___Connection());
	    boolean readOnly = editors.isEmpty();
	    return new RefObjectPropertySource(refObj, readOnly);
	}
	return null;
    }

    /**
     * Returns a {@link RefObjectPropertySource} that has editable attributes.
     * 
     * @author D046040 - Jan Karstens: added to support always editable
     *         properties
     * @param object
     * @return a {@link IPropertySource} or <code>null</code>
     */
    public IPropertySource getEditablePropertySource(Object object) {
	RefObject refObj = ModelAdapterUI.getInstance().getRefObject(object);
	if (refObj != null) {
	    return new RefObjectPropertySource(refObj, false);
	}
	return null;
    }

    public Object getAdapter(Object adaptableObject, Class adapterType) {
	// delegate to central extension factory
	return new MiFwkUiExtensionFactory().getAdapter(adaptableObject, adapterType);
    }

    public Class[] getAdapterList() {
	// delegate to central extension factory
	return new MiFwkUiExtensionFactory().getAdapterList();
    }

    private static class RefObjectPropertySource implements IPropertySource {

	private static final String GROUP_ATTRIBUTES = MiFwkUiMessages.RefObjectPropertySource_groupAttributes_label;
	private static final String GROUP_PARITION = MiFwkUiMessages.RefObjectPropertySource_groupPartition_label;
	private static final String DESC_ID_PARTITION_PRI = "partition.pri"; //$NON-NLS-1$
	private static final String DESC_NAME_PARTITION_PRI = MiFwkUiMessages.RefObjectPropertySource_id_label;
	private static final String DESC_ID_PARTITION_TYPE = "partition.type"; //$NON-NLS-1$
	private static final String DESC_NAME_PARTITION_TYPE = MiFwkUiMessages.RefObjectPropertySource_type_label;
	private static final Object DESC_ID_PARTITION_FILE = "partition.file"; //$NON-NLS-1$
	private static final String DESC_NAME_PARTITION_FILE = MiFwkUiMessages.RefObjectPropertySource_file_label;

	private static final IPropertyDescriptor[] NO_PROPERTIES = new IPropertyDescriptor[0];
	private final Map<String, String[]> attrNameToLabels = new HashMap<String, String[]>();
	private final Map<List<String>, IPropertyDescriptor[]> mofClassToDescriptors = new HashMap<List<String>, IPropertyDescriptor[]>();

	private final RefObject refObj;
	private final boolean isReadOnly;

	// this flag is set when setPropertyValue is executed
	private boolean runningMoinCmd;

	/**
	 * Creates the {@link IPropertySource} using the given {@link RefObject}
	 * and {@link IModelEditor}
	 * 
	 * @param refObj
	 *            The object to use
	 * @param readOnly
	 *            <code>true</code> iff properties are not supposed to be
	 *            modified
	 */
	public RefObjectPropertySource(RefObject refObj, boolean readOnly) {
	    this.isReadOnly = readOnly;
	    this.refObj = refObj;
	}

	public Object getEditableValue() {
	    return null;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
	    if (!((Partitionable) refObj).is___Alive()) {
		return NO_PROPERTIES; // may happen for just deleted objects
	    }

	    RefObject metaObject = refObj.refMetaObject();
	    if (!(metaObject instanceof MofClass)) {
		return NO_PROPERTIES;
	    }

	    // cache descriptors globally in the factory
	    List<String> qualifiedName = ((MofClass) metaObject).getQualifiedName();
	    IPropertyDescriptor[] descriptors = mofClassToDescriptors.get(qualifiedName);
	    if (descriptors == null) {
		JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(refObj);
		List<Attribute> attributes = jmiHelper.getAttributes((MofClass) metaObject, true);
		List<IPropertyDescriptor> descriptorList = new ArrayList<IPropertyDescriptor>(attributes.size());

		for (Attribute attr : attributes) {
		    Classifier type = jmiHelper.getNonAliasType(attr.getType());
		    PropertyDescriptor desc = null;
		    String attrName = attr.getName();

		    // no editor so all fields will be read only
		    if (isReadOnly) {
			desc = new PropertyDescriptor(attrName, attrName);
		    } else {
			// is primitive ?
			if (type instanceof PrimitiveType) {
			    if (type.getName().equals("Boolean")) { //$NON-NLS-1$
				// although a primitive it will be handled like
				// an enumeration
				desc = new ComboBoxPropertyDescriptor(attrName, attrName, getLabels(attrName));
			    } else {
				// create an input field for all other
				// primitives
				Class<?> typeClass = jmiHelper.getJavaPrimitiveOrWrapperType(attr);
				ICellEditorValidator validator = DynamicCellValidatorFactory.getInstance(typeClass);
				desc = new TextPropertyDescriptor(attrName, attrName);
				desc.setValidator(validator);
			    }
			}
			// check for enumeration
			else if (type instanceof EnumerationType) {
			    desc = new ComboBoxPropertyDescriptor(attrName, attrName, getLabels(attrName));
			} else {
			    // all other types are displayed as read only field
			    // showing their object name
			    desc = new PropertyDescriptor(attrName, attrName);
			}
		    }
		    desc.setCategory(GROUP_ATTRIBUTES);
		    // sets status bar text
		    desc.setDescription(attr.getAnnotation());
		    descriptorList.add(desc);
		}

		// partition descriptors
		PropertyDescriptor priDesc = new PartitionPropertyDescriptor(DESC_ID_PARTITION_PRI, DESC_NAME_PARTITION_PRI, true);
		descriptorList.add(priDesc);
		PropertyDescriptor kindDesc = new PartitionPropertyDescriptor(DESC_ID_PARTITION_TYPE, DESC_NAME_PARTITION_TYPE, true);
		descriptorList.add(kindDesc);
		PropertyDescriptor fileDesc = new PartitionPropertyDescriptor(DESC_ID_PARTITION_FILE, DESC_NAME_PARTITION_FILE, false);
		descriptorList.add(fileDesc);

		descriptors = descriptorList.toArray(new IPropertyDescriptor[descriptorList.size()]);
		mofClassToDescriptors.put(qualifiedName, descriptors);
	    }
	    return descriptors;
	}

	public Object getPropertyValue(Object id) {
	    ModelAdapterUI adapter = ModelAdapterUI.getInstance();
	    if (DESC_ID_PARTITION_PRI.equals(id)) {
		PRI pri = adapter.getPri(refObj);
		return pri.toString();
	    } else if (DESC_ID_PARTITION_TYPE.equals(id)) {
		PRI pri = adapter.getPri(refObj);
		if (pri.isNullPartition()) {
		    String value = MiFwkUiMessages.bind(MiFwkUiMessages.RefObjectPropertySource_nullPartition_value, adapter
			    .getConnection(refObj));
		    return value;
		}
		if (pri.isVolatilePartition()) {
		    return MiFwkUiMessages.RefObjectPropertySource_transientPartition_value;
		}
		if (pri.isMetaModelPartition()) {
		    return MiFwkUiMessages.RefObjectPropertySource_metamodelPartition_value;
		}
		return MiFwkUiMessages.RefObjectPropertySource_partition_value;
	    } else if (DESC_ID_PARTITION_FILE.equals(id)) {
		IFile file = adapter.getFile(refObj);
		if (file != null && file.exists()) {
		    return file.getLocation().toOSString();
		}
		return null;
	    }

	    String attrName = (String) id;
	    Object value = refObj.refGetValue(attrName);
	    if (!isReadOnly) {
		String[] labels = getLabels(attrName);
		// if this thing has labels return value is the label index,
		// where 0 indicates empty (null)
		if (labels.length > 0) {
		    if (value == null) {
			return 0;
		    } else {
			// find label and return index
			int pos = findLabelPos(labels, value);
			return pos;
		    }
		}
	    }
	    if (value instanceof Collection) {
		Collection<?> c = (Collection<?>) value;
		if (c.isEmpty()) {
		    // avoid [] to be printed
		    return ""; //$NON-NLS-1$
		}
		if (c.size() == 1) {
		    Object v = c.iterator().next();
		    return String.valueOf(v);
		}
		return c.toString();
	    }

	    if (value != null) {
		String name = ModelManager.getInstance().getObjectName(value);
		return name;
	    }
	    return ""; // $NON-NLS-1$ //$NON-NLS-1$
	}

	public boolean isPropertySet(Object id) {
	    return false;
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {

	    if (runningMoinCmd) {
		// this indicates that this method has already been called and a
		// moin cmd is currently executing
		// the execution of this cmd causes property change events which
		// cause the prop sheet to refresh.
		// In turn when the prop sheet refreshes it tries to save first
		// which causes setPropValue to be
		// called which ultimately leads to an infinite loop. This check
		// breaks the infinite loop ... !
		return;
	    }
	    runningMoinCmd = true;

	    Object newValue = null;
	    // refObject's connection is always the right one, see constructor
	    Connection con = null;
	    Attribute attr = null;
	    try {
		String attrName = (String) id;
		RefObject metaObject = refObj.refMetaObject();
		con = ModelAdapterUI.getInstance().getConnection(refObj);
		JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(refObj);
		attr = jmiHelper.getAttributeByName((MofClass) metaObject, attrName, true);
		if (value instanceof Integer) {
		    String[] labels = getLabels(attrName);
		    if (labels.length > 0) {
			newValue = ModelManager.getInstance().getRefValueObject(refObj, attr, labels[(Integer) value]);
		    }
		} else {
		    newValue = ModelManager.getInstance().getRefValueObject(refObj, attr, value.toString());
		}
		sTracer.debug(RefObjectPropertySource.class, "setPropertyValue", "Setting value for '" + attrName //$NON-NLS-1$ //$NON-NLS-2$
			+ "', using connection: " + con); //$NON-NLS-1$
		SetAttributeCommand command = new SetAttributeCommand(refObj, attr, newValue);
		command.execute();
	    } catch (Exception e) {
		// newValue is not logged due to security issues
		sTracer.error(RefObjectPropertySource.class, "setPropertyValue", //$NON-NLS-1$
			"Property could not be set. connection: " + con + ", id: " + id + ", refObj: " + refObj //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ ", attribute: " + attr, e); //$NON-NLS-1$
		ModelManagerUI.getEditorManager().getActiveStatusLineManager().setErrorMessage(
			"Error while changing property '" + id + "'. " + e.getLocalizedMessage()); //$NON-NLS-1$ //$NON-NLS-2$
	    } finally {
		runningMoinCmd = false;
	    }
	}

	// oh well, not nice but faster than getting type infos from Moin all
	// the time
	private final int findLabelPos(String[] labels, Object value) {
	    if (labels == defaultBooleanClassLabels) {
		if (value.equals(Boolean.TRUE)) {
		    return 1; // index for "true"
		}
		if (value.equals(Boolean.FALSE)) {
		    return 2; // index for "false"
		}
		return 0; // index for empty string
	    }

	    if (labels == defaultBooleanTypeLabels) {
		if (value.equals(Boolean.TRUE)) {
		    return 0; // index for "true"
		}
		return 1; // index for "false"
	    }

	    return Arrays.binarySearch(labels, value.toString());
	}

	/**
	 * Returns all labels for a given attribute name for the current
	 * refObject. To represent the value null an empty entry is added at the
	 * head of the list.
	 * 
	 * @param attrName
	 *            The attribute name
	 * @return The label list (might be empty)
	 */
	private final String[] getLabels(String attrName) {
	    String[] result = attrNameToLabels.get(attrName);
	    if (result != null) {
		return result;
	    }
	    RefObject metaObject = refObj.refMetaObject();
	    JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(refObj);
	    Attribute attr = jmiHelper.getAttributeByName((MofClass) metaObject, attrName, true);
	    Classifier type = jmiHelper.getNonAliasType(attr.getType());
	    if (type instanceof EnumerationType) {
		List<String> labelList = new ArrayList<String>(((EnumerationType) type).getLabels());
		Collections.sort(labelList);
		labelList.add(0, ""); //$NON-NLS-1$
		result = labelList.toArray(new String[labelList.size()]);
	    } else if (type.getName().equals("Boolean")) { //$NON-NLS-1$
		Class<?> typeClass = jmiHelper.getJavaPrimitiveOrWrapperType(attr);
		if (typeClass.equals(Boolean.class)) {
		    result = defaultBooleanClassLabels;
		} else {
		    result = defaultBooleanTypeLabels;
		}
	    } else {
		result = EMPTY_STRING_ARRAY;
	    }
	    attrNameToLabels.put(attrName, result);
	    return result;
	}

	private static final class PartitionPropertyDescriptor extends PropertyDescriptor {
	    public PartitionPropertyDescriptor(Object id, String displayName, boolean advanced) {
		super(id, displayName);
		setCategory(GROUP_PARITION);
	    }
	}
    }
}