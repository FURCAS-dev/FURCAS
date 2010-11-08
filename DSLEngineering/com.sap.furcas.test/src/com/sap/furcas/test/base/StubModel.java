package com.sap.furcas.test.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StubModel {

    private final HashMap<String, List<StubModelElement>> elementListMap = new HashMap<String, List<StubModelElement>>();

    public StubModelElement create(String type) {
        // System.out.println("--Creating object of type " + type);
        StubModelElement element = new StubModelElement(type);
        addToList(type, element);
        return element;
    }

    private void addToList(String type, StubModelElement element) {
        List<StubModelElement> elementsOfType = elementListMap.get(type);
        if (elementsOfType == null) {
            elementsOfType = new ArrayList<StubModelElement>();
            elementListMap.put(type, elementsOfType);
        }
        elementsOfType.add(element);
    }

    public Set<StubModelElement> getElementsByType(String typeName) {
        List<StubModelElement> list = elementListMap.get(typeName);
        if (list != null) {
            return new HashSet<StubModelElement>(list);
        } else {
            return null;
        }
    }

    // public Object newModelElement(Object arg0) {
    // return create(arg0.getName());
    // }

    public Object newModelElement(String typeName) {

        return create(typeName);
    }

}
