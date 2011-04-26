package org.eclipse.emf.query.index.ui.internal.properties;


import java.util.HashMap;

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
	private HashMap<String, String> propertiesMap = new HashMap<String,String>();
	private String PROPERTY_URI = Messages.Query2Index_ResourceIndexProperties_ResourceURI; 

	public ResourceIndexProperties(ResourceDescriptor resourceDescriptor) {
		this.resourceDescriptor = resourceDescriptor;
		
		initProperties();
	}

	private void initProperties() {
		addToProperties(PROPERTY_URI, uri);
	}
	
	public void addToProperties(String property, String value) {
		
		if (property.equals(PROPERTY_URI)) {
			value = resourceDescriptor.getURI().toString();
			propertiesMap.put(property,value);
		}
		return;
	}
	
	public HashMap<String,String> getProperties() {
		return propertiesMap;
	}

}
