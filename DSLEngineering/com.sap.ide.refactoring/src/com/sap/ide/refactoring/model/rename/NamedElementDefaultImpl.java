package com.sap.ide.refactoring.model.rename;

import org.eclipse.emf.ecore.EObject;

import com.sap.ide.refactoring.model.IllegalRefactoringModelOperationException;

public class NamedElementDefaultImpl implements NamedElement {

    protected final EObject wrapped;
    private final String attributeName;

    public NamedElementDefaultImpl(EObject wrapped, String attributeName) {
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
    public EObject getWrappedModelElement() {
	return wrapped;
    }

}
