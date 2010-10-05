package com.sap.furcas.textual.common.exceptions;


/**
 * to be thrown for exception caused by independent code that cannot be handled reasonably.
 * 
 * @author C5107456
 */
public class WrappedException extends AbstractToolGenerationException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -76099205309087708L;

	/**
	 * Instantiates a new wrapped exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public WrappedException(String message, Throwable cause) {
		super(message, cause);
	}

}
