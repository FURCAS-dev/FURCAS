package com.sap.ide.cts.editor.contentassist.modeladapter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StubModelElement {

	private Map<String, Object> strucFeatures = new HashMap<String, Object>();
	public String type;

	public StubModelElement(String type) {

		this.type = type;

	}

	public void set(String strucFeatureName, Object strucFeature) {
		// System.out.println("Object of type: "+type+"; Setting feature '" +
		// strucFeatureName + "' to new value: '" + strucFeature + "'");
		strucFeatures.put(strucFeatureName, strucFeature);
	}

	public String toString() {
		if (strucFeatures.get("name") != null) {
			return type + "(" + strucFeatures.get("name") + ")";
		}
		return type;
	}

	public Object get(String propertyName) {

		return strucFeatures.get(propertyName);
	}

	public Collection<Object> getAllContained() {
		return this.strucFeatures.values();
	}

}
