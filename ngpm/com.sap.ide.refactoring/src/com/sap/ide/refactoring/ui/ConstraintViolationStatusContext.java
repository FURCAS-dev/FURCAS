package com.sap.ide.refactoring.ui;

import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;

import com.sap.ide.refactoring.core.constraints.ConstraintViolation;

public class ConstraintViolationStatusContext extends RefactoringStatusContext {

    private final ConstraintViolation constraintViolation;

    public ConstraintViolationStatusContext(ConstraintViolation constraintViolation) {
	this.constraintViolation = constraintViolation;
    }

    @Override
    public Object getCorrespondingElement() {
	return constraintViolation;
    }
    
}
