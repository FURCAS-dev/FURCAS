package com.sap.ide.refactoring.core.model.rename;

import com.sap.ide.refactoring.core.model.RefactoringModelElement;

/**
 * Represents an entity which can be renamed.
 *
 * @author D049157
 *
 */
public interface NamedElement extends RefactoringModelElement {

    public String getName();

    public void setName(String newName);

}