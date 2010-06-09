package com.sap.ide.refactoring.core.model;

import com.sap.ide.refactoring.core.RefactoringCoreException;

public class IllegalRefactoringModelOperationException extends RefactoringCoreException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public IllegalRefactoringModelOperationException(String message) {
	super(message);
    }

    public IllegalRefactoringModelOperationException(Throwable cause) {
	super(cause);
    }

    public IllegalRefactoringModelOperationException(String message, Throwable cause) {
	super(message, cause);
    }

}
