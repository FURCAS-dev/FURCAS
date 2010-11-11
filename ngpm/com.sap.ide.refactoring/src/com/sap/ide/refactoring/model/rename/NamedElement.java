package com.sap.ide.refactoring.model.rename;

import com.sap.ide.refactoring.model.RefactoringModelElement;

public interface NamedElement extends RefactoringModelElement {

    public String getName();

    public void setName(String newName);

}