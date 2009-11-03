package com.sap.mi.tools.diagnostics.internal.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * Source for attributes as properties of a partitionable 
 * 
 * @author d031150
 */
public final class ModelElementAttributePropertySource implements IPropertySource2 {

	//private static final TracerI sTracer = TracingManager.getTracer(AttributePropertySource.class);
	
	private final String[][] mAttributes;

	public ModelElementAttributePropertySource(String[][] attributes) {
		mAttributes = attributes;
	}

	public Object getEditableValue() {
		return null;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		List<PropertyDescriptor> descs = new ArrayList<PropertyDescriptor>(mAttributes.length);
		for (int i = 0; i < mAttributes.length; i++) {
			String[] attr = mAttributes[i];
			descs.add(new MoinPropertyDescriptor(i, attr[0]));
		}
		return descs.toArray(new IPropertyDescriptor[descs.size()]);
	}

	public Object getPropertyValue(Object id) {
		if (id instanceof Integer) {
			int i = (Integer) id;
			String value = mAttributes[i][1];
			return value;
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
