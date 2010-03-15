package com.sap.tc.moin.ocl.ia.instancescope;

import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;

public class AnnotatedRefObjectImpl {
    private final String annotation;
    private final RefObjectImpl element;
    public AnnotatedRefObjectImpl(String annotation, RefObjectImpl element) {
	super();
	this.annotation = annotation;
	this.element = element;
    }
    public String getAnnotation() {
        return annotation;
    }
    public RefObjectImpl getElement() {
        return element;
    }
    
    @Override
    public String toString() {
	return getElement() + " ("+getAnnotation()+")";
    }
}
