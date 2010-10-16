/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.exceptions;


/**
 * To be used for Exceptions that occur during model creation while parsing.Runtime Exception is used as the Parser thread
 * and code should not need to know about these exceptions happening.
 * 
 * @author C5107456
 */
public class ModelCreationOntheFlyRuntimeException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -747345815397490397L;

	/**
	 * Instantiates a new model creation onthe fly runtime exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public ModelCreationOntheFlyRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
}
