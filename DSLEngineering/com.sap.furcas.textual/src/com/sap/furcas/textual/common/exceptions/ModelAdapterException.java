/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-30 09:50:43 +0200 (So, 30 Aug 2009) $
 * Revision: $Revision: 7766 $
 * Author: $Author: c5127705 $
 *******************************************************************************/
package com.sap.furcas.textual.common.exceptions;




/**
 * to becom.sap.mi.textual.common.exceptionsannot be performed, either due to 
 * model inconsistency, or other Exceptions.
 */
public class ModelAdapterException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3946766193639084806L;

	/**
	 * Instantiates a new model handler exception.
	 * 
	 * @param message the message
	 * @param cause the cause
	 */
	public ModelAdapterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new model handler exception.
	 * 
	 * @param message the message
	 */
	public ModelAdapterException(String message) {
		super(message);
	}
	

}
