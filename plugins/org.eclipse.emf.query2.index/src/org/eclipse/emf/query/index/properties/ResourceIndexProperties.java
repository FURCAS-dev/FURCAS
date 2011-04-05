package org.eclipse.emf.query.index.properties;


import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;


public class ResourceIndexProperties implements IPropertySource {

	final protected ResourceDescriptor resourceDescriptor;
	private String uri;

	protected static final String PROPERTY_URI = "uri";

	public ResourceIndexProperties(ResourceDescriptor resourceDescriptor) {
		super();
		this.resourceDescriptor = resourceDescriptor;
		initProperties();
	}

	private void initProperties() {
		setPropertyValue(PROPERTY_URI, uri);

	}

	private final Object PropertiesTable[][] = { { PROPERTY_URI, new PropertyDescriptor(PROPERTY_URI, "Resource URI") }, };

	
	/**
	 * Creates a new ResourceIndexProperties.
	 * 
	 * @param element
	 *            the element whose properties this instance represents
	 */

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
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
		if (name.equals(PROPERTY_URI))
			return uri;
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

		if (name.equals(PROPERTY_URI)) {
			uri = resourceDescriptor.getURI().toString();
			return;
		}

	}

//	/**
//	 * Returns the mocha element.
//	 * 
//	 * @return MochaElement
//	 */
//	public ResourceIndex getResourceIndex() {
//		return resindex;
//	}

}
