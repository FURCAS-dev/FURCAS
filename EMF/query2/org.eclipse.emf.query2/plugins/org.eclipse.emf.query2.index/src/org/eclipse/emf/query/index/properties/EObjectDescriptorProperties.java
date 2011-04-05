package org.eclipse.emf.query.index.properties;

import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class EObjectDescriptorProperties implements IPropertySource {

	final protected EObjectDescriptor objDesc;
	private String objName;
	private String fragment;

	protected static final String PROPERTY_NAME = "name";
	protected static final String PROPERTY_FRAGMENT = "fragment";

	public EObjectDescriptorProperties(EObjectDescriptor eObjectDescriptor) {
		super();
		this.objDesc = eObjectDescriptor;
		initProperties();
	}

	private void initProperties() {
		setPropertyValue(PROPERTY_NAME, objName);
		setPropertyValue(PROPERTY_FRAGMENT, fragment);

	}

	private final Object PropertiesTable[][] = { { PROPERTY_NAME, new PropertyDescriptor(PROPERTY_NAME, "Name") },
			{ PROPERTY_FRAGMENT, new PropertyDescriptor(PROPERTY_FRAGMENT, "Fragment") } };

	public Object getEditableValue() {
		return this;
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		// Create the property vector.
		IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

		for (int i = 0; i < PropertiesTable.length; i++) {
			// Add each property supported.

			PropertyDescriptor descriptor;

			descriptor = (PropertyDescriptor) PropertiesTable[i][1];
			propertyDescriptors[i] = (IPropertyDescriptor) descriptor;
			descriptor.setCategory("Basic");
		}

		// Return it.
		return propertyDescriptors;

	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(Object)
	 */
	public Object getPropertyValue(Object name) {
		if (name.equals(PROPERTY_NAME))
			return objName;
		if (name.equals(PROPERTY_FRAGMENT))
			return fragment;
		return null;
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(Object)
	 */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(Object)
	 */
	public void resetPropertyValue(Object id) {
	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(Object,
	 *      Object)
	 */
	public void setPropertyValue(Object name, Object value) {
		// firePropertyChanged((String) name, value);

		if (name.equals(PROPERTY_NAME)) {
			objName = objDesc.getName();
			return;
		}if (name.equals(PROPERTY_FRAGMENT)) {
			fragment = objDesc.getFragment();
			return;
		}

	}

	/**
	 * Returns the mocha element.
	 * 
	 * @return MochaElement
	 */
	public EObjectDescriptor getResourceIndex() {
		return objDesc;
	}

}
