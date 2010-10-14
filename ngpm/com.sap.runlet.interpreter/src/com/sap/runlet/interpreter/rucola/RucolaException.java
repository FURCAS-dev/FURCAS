package com.sap.runlet.interpreter.rucola;

public class RucolaException extends RuntimeException {
    private static final long serialVersionUID = 1874908539358526838L;

    public RucolaException(String message) {
	super(message);
    }
    
    public RucolaException(String message, Throwable cause) {
	super(message, cause);
    }
}
