package com.sap.furcas.test.base;

import java.util.HashMap;
import java.util.Map;

public class StubModelElement {

    private final Map<String, Object> strucFeatures = new HashMap<String, Object>();
    public String type;

    public StubModelElement(String type) {
        this.type = type;
    }

    public void set(String strucFeatureName, Object strucFeature) {
        // System.out.println("Object of type: "+type+"; Setting feature '" + strucFeatureName + "' to new value: '" +
        // strucFeature + "'");
        strucFeatures.put(strucFeatureName, strucFeature);
    }

    @Override
    public String toString() {
        if (strucFeatures.get("name") != null) {
            return type + "(" + strucFeatures.get("name") + ")"; // TODO removed because it caused stack overflow with
                                                                 // bidirectional references + strucFeatures.toString();
        }
        return type + strucFeatures.toString();
    }

    public Object get(String propertyName) {

        return strucFeatures.get(propertyName);
    }

}
