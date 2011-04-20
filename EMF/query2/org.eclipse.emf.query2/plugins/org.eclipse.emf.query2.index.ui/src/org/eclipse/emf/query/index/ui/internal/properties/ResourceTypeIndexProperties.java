package org.eclipse.emf.query.index.ui.internal.properties;

import java.util.HashMap;

import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.ResourceType;

/**
 * Properties of Resource types in Index View
 * @author I055826
 *
 */
public class ResourceTypeIndexProperties {

	private ResourceType typeIndex;
	private String uri;
	private HashMap<String, String> propertiesMap = new HashMap<String,String>();

	private String PROPERTY_URI = Messages.Query2IndexUI_ResourceURI;

	public ResourceTypeIndexProperties(ResourceType typeIndex) {
		this.typeIndex = typeIndex;
		initProperties();
	}

	private void initProperties() {
		addToProperties(PROPERTY_URI, uri);
	}
	
	public void addToProperties(String property, String value) {
		if(property!=null){
			if (property.equals(PROPERTY_URI)) {
					value = typeIndex.getElementType().toString();
				}
			propertiesMap.put(property,value);
		}
		return;
	}
	
	public HashMap<String,String> getProperties() {
		return propertiesMap;
	}
	
	

}
