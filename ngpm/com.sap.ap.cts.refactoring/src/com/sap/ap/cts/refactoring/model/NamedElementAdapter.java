package com.sap.ap.cts.refactoring.model;

import com.sap.ide.refactoring.core.model.NamedElement;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class NamedElementAdapter implements NamedElement {

    private final modelmanagement.NamedElement wrapped;

    public NamedElementAdapter(modelmanagement.NamedElement wrapped) {
	this.wrapped = wrapped;
    }

    @Override
    public String getName() {
	return wrapped.getName();
    }

    @Override
    public void setName(String newName) {
	wrapped.setName(newName);
    }

    @Override
    public RefObject getOriginalElement() {
	return wrapped;
    }

}
