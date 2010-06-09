package com.sap.ide.refactoring.core;

import org.eclipse.ltk.core.refactoring.RefactoringStatus;

public class RefactoringCoreException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public RefactoringCoreException(String message) {
	super(message);
    }

    public RefactoringCoreException(Throwable cause) {
	super(cause);
    }

    public RefactoringCoreException(String message, Throwable cause) {
	super(message, cause);
    }

    public RefactoringStatus asRefactoringStatus() {
	return RefactoringStatus.createFatalErrorStatus("An exception occured: " + this.getMessage());
    }
}
