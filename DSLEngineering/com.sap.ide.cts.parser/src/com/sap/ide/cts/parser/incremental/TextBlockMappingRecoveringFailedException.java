package com.sap.ide.cts.parser.incremental;

public class TextBlockMappingRecoveringFailedException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -8576201423606884528L;

    public TextBlockMappingRecoveringFailedException(Exception e) {
	super(e);
    }
    
    public TextBlockMappingRecoveringFailedException(String string) {
        super(string);
    }

    public TextBlockMappingRecoveringFailedException(Exception cause, String string) {
	super(string, cause);
    }

}
