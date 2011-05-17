package com.sap.ide.cts.parser.incremental;


public class IncrementalParsingException extends RuntimeException {

    private static final long serialVersionUID = -6808709784795050127L;

    public IncrementalParsingException(String message) {
        super(message);
    }

    public IncrementalParsingException(Throwable e) {
        super(e);
    }

    public IncrementalParsingException(String message, Throwable e) {
        super(message, e);
    }

}
