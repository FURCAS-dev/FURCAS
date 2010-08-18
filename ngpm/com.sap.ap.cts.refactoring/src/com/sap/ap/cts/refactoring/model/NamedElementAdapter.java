package com.sap.ap.cts.refactoring.model;

import org.eclipse.emf.ecore.EObject;

import com.sap.ide.refactoring.core.model.rename.NamedElementDefaultImpl;


public class NamedElementAdapter extends NamedElementDefaultImpl {

    public NamedElementAdapter(EObject wrapped) {
	super(wrapped, "name");
    }


}
