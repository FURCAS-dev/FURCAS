package com.sap.furcas.textual.common.exceptions;


/**
 * superclass for all Exceptions thrown by classes of the textual tooling framework.
 * 
 * The framework shall not log exceptions that occured in its code or in called code.
 * Exceptions that are caught from other code shall be wrapped.
 * 
 * @author C5107456
 */
public abstract class AbstractToolGenerationException extends Exception {

    	private static final long serialVersionUID = 2812137804098951970L;

	/**
	 * Instantiates a new abstract tool generation exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public AbstractToolGenerationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new abstract tool generation exception.
	 * 
	 * @param message the message
	 */
	public AbstractToolGenerationException(String message) {
		super(message);
	}

    public AbstractToolGenerationException(Throwable cause) {
        super(cause);
    }
	
	

}
