package org.eclipse.emf.query.index.ui.internal.properties;

import java.util.ArrayList;

import org.eclipse.emf.query.index.Messages;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
/**
 * Properties of Incoming and Outgoing link table objects displayed in Index View
 * @author I055826
 *
 */
public class ReferenceDescriptorProperties {

	private EReferenceDescriptor RefDesc;
	private String refuri;
	private String sourceFragment;
	private String sourceResource;
	private String targetFragment;
	private String targetResource;
	private ArrayList<IndexViewProperty> properties = new ArrayList<IndexViewProperty>();
	

	private String PROPERTY_REF_URI = Messages.Query2Index_ReferenceDescriptorProperties_ReferenceURI;
	private String PROPERTY_SRC_FRAGMENT = Messages.Query2Index_ReferenceDescriptorProperties_SourceFragment;
	private String PROPERTY_SRC_RESOURCE = Messages.Query2Index_ReferenceDescriptorProperties_SourceResource; 
	private String PROPERTY_TAR_FRAGMENT = Messages.Query2Index_ReferenceDescriptorProperties_TargetFragment; 
	private String PROPERTY_TAR_RESOURCE = Messages.Query2Index_ReferenceDescriptorProperties_TargetResource; 

	public ReferenceDescriptorProperties(EReferenceDescriptor RefDesc) {
		this.RefDesc = RefDesc;
		initProperties();
	}

	private void initProperties() {
		addToProperties(PROPERTY_REF_URI, refuri);
		addToProperties(PROPERTY_SRC_FRAGMENT, sourceFragment);
		addToProperties(PROPERTY_SRC_RESOURCE, sourceResource);
		addToProperties(PROPERTY_TAR_FRAGMENT, targetFragment);
		addToProperties(PROPERTY_TAR_RESOURCE, targetResource);

	}

	public void addToProperties(String property, String value) {
		if(property!=null){
			if (property.equals(PROPERTY_REF_URI)) {
				value = RefDesc.getEReferenceURI();
			}else if(property.equals(PROPERTY_SRC_FRAGMENT)){
				value= RefDesc.getSourceFragment();
			}else if(property.equals(PROPERTY_SRC_RESOURCE)){
				value = RefDesc.getSourceResourceURI().toString();
			}else if(property.equals(PROPERTY_TAR_FRAGMENT)){
				value = RefDesc.getTargetFragment();
			}else if(property.equals(PROPERTY_TAR_RESOURCE)){
				value = RefDesc.getTargetResourceURI().toString();
			}
			properties.add(new IndexViewProperty(property, value));
		}
		return;
	}
	
	public ArrayList<IndexViewProperty> getProperties() {
		return properties;
	}


}
