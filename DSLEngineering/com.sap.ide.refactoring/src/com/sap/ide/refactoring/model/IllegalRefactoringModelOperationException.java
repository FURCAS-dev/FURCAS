package com.sap.ide.refactoring.model;


public class IllegalRefactoringModelOperationException extends RuntimeException {

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
