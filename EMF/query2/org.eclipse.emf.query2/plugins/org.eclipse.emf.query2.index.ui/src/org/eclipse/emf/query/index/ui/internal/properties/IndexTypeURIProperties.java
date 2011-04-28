package org.eclipse.emf.query.index.ui.internal.properties;

import java.util.HashMap;

import org.eclipse.emf.query.index.ui.internal.Messages;
import org.eclipse.emf.query.index.ui.internal.view.tree.nodes.IndexTypeURI;

/**
 * Properties of type indices displayed in Index View
 * @author I055826
 *
 */
public class IndexTypeURIProperties {

	private IndexTypeURI typeIndex;
	private String uri;
	private HashMap<String, String> propertiesMap = new HashMap<String,String>();
	
	private String PROPERTY_URI = Messages.Query2IndexUI_ResourceURI;

	public IndexTypeURIProperties(IndexTypeURI typeIndex) {
		this.typeIndex = typeIndex;
		initProperties();
	}

	private void initProperties() {
		addToProperties(PROPERTY_URI, uri);
	}
	
	public void addToProperties(String property, String value) {
		if(property!=null){
			if (property.equals(PROPERTY_URI)) {
					value = typeIndex.getURI().toString();
			 }
			propertiesMap.put(property,value);
		}
		return;
	}
	
	public HashMap<String,String> getProperties() {
		return propertiesMap;
	}

	
	
}
