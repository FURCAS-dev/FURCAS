package com.sap.mi.tools.diagnostics.internal.properties;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;

import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;
import com.sap.mi.tools.diagnostics.internal.model.PartitionableNode;

/**
 * Source for properties of a partitionable node
 * 
 * @author d031150
 */
public final class PartitionableNodePropertySource implements IPropertySource2 {

	static final String PROPERTY_MOFID = "MofID"; //$NON-NLS-1$
	static final String PROPERTY_MOFID_LABEL = DiagnosticsMessages.PartitionableNodePropertySource_mofId_label;
	static final String PROPERTY_MRI = "Mri"; //$NON-NLS-1$
	static final String PROPERTY_MRI_LABEL = DiagnosticsMessages.PartitionableNodePropertySource_mri_label;
	static final String PROPERTY_TYPE = "Type"; //$NON-NLS-1$
	static final String PROPERTY_TYPE_LABEL = DiagnosticsMessages.PartitionableNodePropertySource_type_label;
	static final String PROPERTY_ATTRIBUTES = "Attributes"; //$NON-NLS-1$
	static final String PROPERTY_ATTRIBUTES_LABEL = DiagnosticsMessages.PartitionableNodePropertySource_attributes_label;

	private final PartitionableNode mNode;

	public PartitionableNodePropertySource(PartitionableNode node) {
		mNode = node;
	}

	public Object getEditableValue() {
		return this;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		PropertyDescriptor[] descs = new PropertyDescriptor[4];
		descs[0] = new MoinPropertyDescriptor(PROPERTY_MOFID, PROPERTY_MOFID_LABEL);
		descs[1] = new MoinPropertyDescriptor(PROPERTY_MRI, PROPERTY_MRI_LABEL);
		descs[2] = new MoinPropertyDescriptor(PROPERTY_TYPE, PROPERTY_TYPE_LABEL);
		descs[3] = new MoinPropertyDescriptor(PROPERTY_ATTRIBUTES, PROPERTY_ATTRIBUTES_LABEL);
		return descs;
	}

	public Object getPropertyValue(Object id) {
		if (PROPERTY_MOFID.equals(id)) {
			String mofId = mNode.getMofId();
			return mofId;
		} else if (PROPERTY_MRI.equals(id)) {
			String mri = mNode.getMri();
			return mri;
		} else if (PROPERTY_TYPE.equals(id)) {
			String type = mNode.getType();
			return type;
		} else if (PROPERTY_ATTRIBUTES.equals(id)) {
			String[][] attributeValues = mNode.getAttributeValues();
			return new ModelElementAttributePropertySource(attributeValues);
		}
		return null;
	}

	public boolean isPropertyResettable(Object id) {
		return false;
	}

	public boolean isPropertySet(Object id) {
		return true;
	}

	public void resetPropertyValue(Object id) {
	}

	public void setPropertyValue(Object id, Object value) {
	}

}
