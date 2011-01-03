package com.sap.furcas.runtime.parser.testbase.stubs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class StubModel {

    private final HashMap<String, List<StubModelElement>> elementListMap = new HashMap<String, List<StubModelElement>>();

    public StubModelElement create(String type) {
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

    public Collection<StubModelElement> getElementsOfType(String typeName) {
        List<StubModelElement> list = elementListMap.get(typeName);
        if (list != null) {
            return new HashSet<StubModelElement>(list);
        } else {
            return null;
        }
    }

    public Object newModelElement(String typeName) {
        return create(typeName);
    }

}
