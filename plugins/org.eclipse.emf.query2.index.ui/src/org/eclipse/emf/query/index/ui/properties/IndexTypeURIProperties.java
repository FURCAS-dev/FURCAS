package org.eclipse.emf.query.index.ui.properties;

import org.eclipse.emf.query.index.ui.Messages;
import org.eclipse.emf.query.index.ui.view.tree.nodes.IndexTypeURI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

public class IndexTypeURIProperties implements IPropertySource {

	protected IndexTypeURI typeIndex;
	private String uri;
	protected static final String PROPERTY_URI = "uri"; //$NON-NLS-1$
	private final Object PropertiesTable[][] = { { PROPERTY_URI, new PropertyDescriptor(PROPERTY_URI, Messages.Query2IndexUI_ResourceURI) }, };

	public IndexTypeURIProperties(IndexTypeURI typeIndex) {
		super();
		this.typeIndex = typeIndex;
		initProperties();
	}

	private void initProperties() {
		setPropertyValue(PROPERTY_URI, uri);
	}

	
	public Object getEditableValue() {
		return null;
	}

	
	public IPropertyDescriptor[] getPropertyDescriptors() {
		IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

		for (int i = 0; i < PropertiesTable.length; i++) {
			// Add each property supported.
			PropertyDescriptor descriptor;
			descriptor = (PropertyDescriptor) PropertiesTable[i][1];
			propertyDescriptors[i] = (IPropertyDescriptor) descriptor;
			descriptor.setCategory(Messages.Query2IndexUI_Basic);
		}

		// Return it.
		return propertyDescriptors;
	}

	
	public Object getPropertyValue(Object name) {
		if (name.equals(PROPERTY_URI))
			return uri;
		return null;
	}

	
	public boolean isPropertySet(Object id) {
		return false;
	}

	
	public void resetPropertyValue(Object id) {
	}

	
	public void setPropertyValue(Object name, Object value) {
		if (name.equals(PROPERTY_URI)) {
			uri = typeIndex.getURI().toString();
			return;
		}
	}

}
