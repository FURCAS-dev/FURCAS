package com.sap.ide.refactoring.model.move;

import com.sap.ide.refactoring.model.RefactoringModelElement;

public interface MovableElementTarget extends RefactoringModelElement {

    public String getName();

    public String getType();

    public String getRole();

    public void movetoHere();
}
