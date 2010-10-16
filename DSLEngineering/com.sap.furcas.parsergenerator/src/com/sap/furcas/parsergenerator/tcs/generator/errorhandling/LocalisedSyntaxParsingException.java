package com.sap.furcas.parsergenerator.tcs.generator.errorhandling;


/**
 * The Class LocalisedSyntaxParsingException.
 */
public class LocalisedSyntaxParsingException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1566983651956202346L;

	/** The message. */
	private String message;
	
	/** The line number. */
	private int lineNumber;

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Gets the line number.
	 * 
	 * @return the line number
	 */
	public int getLineNumber() {
		return lineNumber;
	}
	
	/**
	 * Instantiates a new localised syntax parsing exception.
	 * 
	 * @param message the message
	 * @param lineNumber the line number
	 */
	public LocalisedSyntaxParsingException(String message, int lineNumber) {
		super();
		this.message = message;
		this.lineNumber = lineNumber;
	}

	
	
	
}
