package com.sap.furcas.parsergenerator.tcs.t2m.validation;

import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;


/**
 * to be thrown when syntax definition is invalid. Use for either internal inconsistency (i.e. referenced template does not exist)
 * or for inconsistency to a given metamodel (i.e. class type does not exist)
 * 
 * @author C5107456
 */
public class SyntaxDefValidationException extends
		SyntaxElementException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3680277831150252135L;

	/**
	 * Instantiates a new syntax def validation exception.
	 * 
	 * @param message the message
	 * @param syntaxModelElement 
	 */
	public SyntaxDefValidationException(String message, Object syntaxModelElement) {
		super(message, syntaxModelElement);
	}


}
