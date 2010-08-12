package com.sap.ide.refactoring.model.rename;

import com.sap.ide.refactoring.model.IllegalRefactoringModelOperationException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class NamedElementDefaultImpl implements NamedElement {

    protected final RefObject wrapped;
    private final String attributeName;

    public NamedElementDefaultImpl(RefObject wrapped, String attributeName) {
	this.wrapped = wrapped;
	this.attributeName = attributeName;
    }

    @Override
    public String getName() {
	try {
	    return (String) wrapped.refGetValue(attributeName);
	} catch (Exception e) {
	    throw new IllegalRefactoringModelOperationException("Unable to retrieve model element name", e);
	}
    }

    @Override
    public void setName(String newName) {
	if (!isValidName(newName)) {
	    throw new IllegalRefactoringModelOperationException("Given name <" + newName + "> is Invalid");
	}
	try {
	    wrapped.refSetValue(attributeName, newName);
	} catch (Exception e) {
	    throw new IllegalRefactoringModelOperationException("Unable to set new name", e);
	}
    }

    protected boolean isValidName(String string) {
	return true;
    }

    @Override
    public RefObject getWrappedModelElement() {
	return wrapped;
    }

}
