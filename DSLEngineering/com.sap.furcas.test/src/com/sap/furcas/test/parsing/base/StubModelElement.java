package com.sap.furcas.test.parsing.base;

import java.util.HashMap;
import java.util.Map;

public class StubModelElement {

	private Map<String, Object> strucFeatures = new HashMap<String, Object>();
	public String type;
	
	public StubModelElement(String type) {
		
		this.type = type;

	}

	public void set(String strucFeatureName, Object strucFeature) {
//		System.out.println("Object of type: "+type+"; Setting feature '" + strucFeatureName + "' to new value: '" + strucFeature + "'");
		strucFeatures.put(strucFeatureName, strucFeature);
	}

	public String toString() {
	    if (strucFeatures.get("name") != null) {
            return type + "("+ strucFeatures.get("name") + ")"; //TODO removed because it caused stack overflow with bidirectional references + strucFeatures.toString();
        }
	    return type + strucFeatures.toString();
	}

	public Object get(String propertyName) {
		
		return strucFeatures.get(propertyName);
	}


	public boolean conformsTo(Object arg0) {
		// TODO Auto-generated method stub
		return true;
	}




	public Object getPropertyType(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	
}
