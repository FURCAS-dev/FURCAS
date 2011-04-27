package org.eclipse.emf.query.index.ui.internal.properties;

import java.util.ArrayList;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
/**
 * Properties of  Eobject table objects in Index View
 * @author I055826
 *
 */
public class EObjectDescriptorProperties{

	private EObjectDescriptor objDesc;
	private String objName;
	private String fragment;
	private ArrayList<IndexViewProperty> properties = new ArrayList<IndexViewProperty>();
	
	private String PROPERTY_NAME =  Messages.Query2Index_EObjectDescriptorProperties_Name;
	private String PROPERTY_FRAGMENT = Messages.Query2Index_EObjectDescriptorProperties_Fragment;

	public EObjectDescriptorProperties(EObjectDescriptor eObjectDescriptor) {
		this.objDesc = eObjectDescriptor;
		
		initProperties();
	}

	private void initProperties() {
		addToProperties(PROPERTY_NAME, objName);
		addToProperties(PROPERTY_FRAGMENT, fragment);
		}
	
	public void addToProperties(String property, String value) {
		if(property!=null){
			if (property.equals(PROPERTY_NAME)) {
				value = objDesc.getName();
			}else if(property.equals(PROPERTY_FRAGMENT)){
				value= objDesc.getFragment();
			}
			properties.add(new IndexViewProperty(property,value));
		}
		return;
	}
	
	public ArrayList<IndexViewProperty> getProperties() {
		return properties;
	}
}
