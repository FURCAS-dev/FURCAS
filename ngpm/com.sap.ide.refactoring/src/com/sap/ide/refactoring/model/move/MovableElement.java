package com.sap.ide.refactoring.model.move;

import java.util.Collection;

import com.sap.ide.refactoring.model.RefactoringModelElement;


public interface MovableElement extends RefactoringModelElement {

    public Collection<MovableElementTarget> getPotentialMovingTargets();
    
    public String getName();

    public String getType(); 

}
