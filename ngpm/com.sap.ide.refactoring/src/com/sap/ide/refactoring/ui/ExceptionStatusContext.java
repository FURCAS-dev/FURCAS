package com.sap.ide.refactoring.ui;

import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;

public class ExceptionStatusContext extends RefactoringStatusContext {

    private final Throwable exception;

    public ExceptionStatusContext(Throwable throwable) {
	this.exception = throwable;
    }
    
    @Override
    public Object getCorrespondingElement() {
	return exception;
    }
    
    @Override
    public String toString() {
	return exception.getMessage();
    }

}
