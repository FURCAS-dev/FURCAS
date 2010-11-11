package com.sap.ap.cts.refactoring.model;

import org.eclipse.emf.ecore.EObject;

import com.sap.ide.refactoring.model.rename.NamedElementDefaultImpl;


public class NamedElementAdapter extends NamedElementDefaultImpl {

    public NamedElementAdapter(EObject wrapped) {
    	super(wrapped, /*feature holding the element name*/ "name");
    }


}
