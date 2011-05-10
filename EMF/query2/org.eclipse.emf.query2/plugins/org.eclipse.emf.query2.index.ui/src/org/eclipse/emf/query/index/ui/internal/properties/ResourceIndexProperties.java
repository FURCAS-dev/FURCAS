package org.eclipse.emf.query.index.ui.internal.properties;


import java.util.ArrayList;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
/**
 * Properties of ResourceIndex objects, displayed in Index View
 * @author I055826
 *
 */

public class ResourceIndexProperties {

	private ResourceDescriptor resourceDescriptor;
	private String uri;
	private ArrayList<IndexViewProperty> properties = new ArrayList<IndexViewProperty>();
	private String PROPERTY_URI = Messages.Query2Index_ResourceIndexProperties_ResourceURI; 

	public ResourceIndexProperties(ResourceDescriptor resourceDescriptor) {
		this.resourceDescriptor = resourceDescriptor;
		
		initProperties();
	}

	private void initProperties() {
		addToProperties(PROPERTY_URI, uri);
	}
	
	public void addToProperties(String property, String value) {
	if(property!=null){
		if (property.equals(PROPERTY_URI)) {
			value = resourceDescriptor.getURI().toString();
			}
		properties.add(new IndexViewProperty(property, value));
	}
		return;
	}
	
	public ArrayList<IndexViewProperty> getProperties() {
		return properties;
	}

}
