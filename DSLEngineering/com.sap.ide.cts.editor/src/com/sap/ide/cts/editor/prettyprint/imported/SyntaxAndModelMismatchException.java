package com.sap.ide.cts.editor.prettyprint.imported;

public class SyntaxAndModelMismatchException extends Exception {

    String message;

    public SyntaxAndModelMismatchException(String message) {
	this.message = message;
    }

    public SyntaxAndModelMismatchException(Exception cause) {
	super(cause);
    }

    @Override
    public String getMessage() {
	return message != null ? message : super.getMessage();
    }

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

}
