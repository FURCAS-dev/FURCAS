package org.eclipse.emf.query.index.properties;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class ReferenceDescriptorProperties implements IPropertySource {

	final protected EReferenceDescriptor RefDesc;
	private String refuri;
	private String sourceFragment;
	private String sourceResource;
	private String targetFragment;
	private String targetResource;

	protected static final String PROPERTY_REF_URI = "refuri"; //$NON-NLS-1$
	protected static final String PROPERTY_SRC_FRAGMENT = "srcFragment"; //$NON-NLS-1$
	protected static final String PROPERTY_SRC_RESOURCE = "srcResource"; //$NON-NLS-1$
	protected static final String PROPERTY_TAR_FRAGMENT = "targetFragment"; //$NON-NLS-1$
	protected static final String PROPERTY_TAR_RESOURCE = "targetResource"; //$NON-NLS-1$

	public ReferenceDescriptorProperties(EReferenceDescriptor RefDesc) {
		super();
		this.RefDesc = RefDesc;
		initProperties(RefDesc);
	}

	private void initProperties(EReferenceDescriptor RefDesc) {
		setPropertyValue(PROPERTY_REF_URI, refuri);
		setPropertyValue(PROPERTY_SRC_FRAGMENT, sourceFragment);
		setPropertyValue(PROPERTY_SRC_RESOURCE, sourceResource);
		setPropertyValue(PROPERTY_TAR_FRAGMENT, targetFragment);
		setPropertyValue(PROPERTY_TAR_RESOURCE, targetResource);

	}

	private final Object PropertiesTable[][] = { { PROPERTY_REF_URI, new PropertyDescriptor(PROPERTY_REF_URI, Messages.Query2Index_ReferenceDescriptorProperties_ReferenceURI) },
			{ PROPERTY_SRC_FRAGMENT, new PropertyDescriptor(PROPERTY_SRC_FRAGMENT, Messages.Query2Index_ReferenceDescriptorProperties_SourceFragment) },
			{ PROPERTY_SRC_RESOURCE, new PropertyDescriptor(PROPERTY_SRC_RESOURCE, Messages.Query2Index_ReferenceDescriptorProperties_SourceResource) },
			{ PROPERTY_TAR_FRAGMENT, new PropertyDescriptor(PROPERTY_TAR_FRAGMENT, Messages.Query2Index_ReferenceDescriptorProperties_TargetFragment) },
			{ PROPERTY_TAR_RESOURCE, new PropertyDescriptor(PROPERTY_TAR_RESOURCE, Messages.Query2Index_ReferenceDescriptorProperties_TargetResource) } };

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
			descriptor.setCategory(Messages.Query2Index_ReferenceDescriptorProperties_Basic);
		}

		// Return it.
		return propertyDescriptors;

	}

	/**
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(Object)
	 */
	public Object getPropertyValue(Object name) {
		if (name.equals(PROPERTY_REF_URI))
			return refuri;
		if (name.equals(PROPERTY_SRC_FRAGMENT))
			return sourceFragment;
		if (name.equals(PROPERTY_SRC_RESOURCE))
			return sourceResource;
		if (name.equals(PROPERTY_TAR_FRAGMENT))
			return targetFragment;
		if (name.equals(PROPERTY_TAR_RESOURCE))
			return targetResource;
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

		if (name.equals(PROPERTY_REF_URI)) {
			refuri = RefDesc.getEReferenceURI();
			return;
		}
		if (name.equals(PROPERTY_SRC_FRAGMENT)) {
			sourceFragment = RefDesc.getSourceFragment();
			if(sourceFragment.equals("/")) //$NON-NLS-1$
				sourceFragment = null;
			return;
		}
		if (name.equals(PROPERTY_SRC_RESOURCE)) {
			sourceResource = RefDesc.getSourceResourceURI().toString();
			return;
		}
		if (name.equals(PROPERTY_TAR_FRAGMENT)) {
			targetFragment = RefDesc.getTargetFragment();
			return;
		}
		if (name.equals(PROPERTY_TAR_RESOURCE)) {
			targetResource = RefDesc.getTargetResourceURI().toString();
			return;
		}

	}


}
