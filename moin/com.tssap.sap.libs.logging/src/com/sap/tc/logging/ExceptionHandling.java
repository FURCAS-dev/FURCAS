package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 */

import java.util.*;

public class ExceptionHandling {
	
	//================================================ declaration > ====
	
	protected static final String EX_NO_FORMATTER_EMSG = "No formatter",
																EX_NO_INSTANCE_EMSG  = "No instance",
																EX_NO_FILTER_EMSG    = "No filter"; 
	
	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public void handleException(Exception exc, int code) {
		ExceptionManager.handleException(exc, code);
	}

	public void handleException(Exception exc) {
			ExceptionManager.handleException(exc);
	}

	/**
   * Resets the last exception thrown.
   * @see    #getException()
   * @see    #throwException()
   */
  public void resetException() {
		ExceptionManager.resetException();
  }

  /**
   * Fetches the last exception thrown
   * @return Last exception thrown
   * @see    #resetException()
   */
  public Exception getException() {
		return ExceptionManager.getException();
  }

  /**
		 * Fetches the List of the last thrown exceptions.
		 * @return List of the last throw exceptions.
		 * @see    #resetException()
		 */
  public List getExceptions() {
		return ExceptionManager.getExceptions();
  }

  /**
   * Rethrows the last exception thrown.
   * This method is useful if an exception is supposed to be dealt with according
   * to a hierarchy of handlers already declared in a context.
   * @throws Exception Last exception thrown
   * @see    #resetException()
   */
  public void throwException() throws Exception {
		Exception lastExc = getException();
		if (lastExc != null) {
			throw lastExc;
		}
  }

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
		
}
