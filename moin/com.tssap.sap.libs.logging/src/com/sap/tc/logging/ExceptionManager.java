package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id: $
 */

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.io.*;

public class ExceptionManager {
	
	//================================================ declaration > ====
		
	private static LinkedList  exObjects 	= new LinkedList();
	
	private final static int 	ERR_ITEMS 	= 5;
	
	public final static int 	ERR_RESET 	= -1;
	public final static int 	ERR_UNKNOWN	= 0;
	public final static int 	ERR_OPEN 		= 1;
	public final static int	 	ERR_CLOSE 	= 2;
	public final static int 	ERR_WRITE 	= 3;
	public final static int 	ERR_VALUE 	= 4;
	public final static int 	ERR_FORMAT 	= 5;	
	
	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	/**
	* Get last thrown exception.
	*/
	public static synchronized Exception getException() {
		return (Exception) exObjects.getLast();
	}
	
	/**
	* Get a list of last thrown exceptions.
	*/
	public static synchronized List getExceptions() {
		if (exObjects != null){
			return Collections.unmodifiableList(exObjects);
		}
		return Collections.EMPTY_LIST;
	}
	
	/**
  * Resets the last exception thrown.
  * @see    #getException()
  * @see    #throwException()
  */
	public static synchronized void resetException() {
		exObjects.clear();
	}

	/**
	* Fills a string with the stack trace of an exception.
	* @return Stack trace
	*/
	public static String getStackTrace(Throwable throwable) {
	  Writer      stack  = new StringWriter();
	  PrintWriter writer = new PrintWriter(stack);

	  throwable.printStackTrace(writer);
	  return stack.toString() + Formatter.EOL;
	}

	/**
	* Handles exception.
	* @param  e exception thrown
	*/
	public static void handleException(Exception exc) {
		handleException(exc, ExceptionManager.ERR_UNKNOWN);
	}

	/**
	* Handles exception.
	* @param  e exception thrown
	*/
	public static void handleException(Exception exc, int code) {
		saveException(exc, code);
	}
	
	// Helper methods
	public static void UNEXPECTED_EXCEPTION(Location location, 
																					String method, 
																					String[] args, 
																					Exception ex) {
			APILogger
				.logIntByAPI(Severity.PATH,
										 location,
										 method,
										 MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
										 MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
										 args);
			APILogger.catchingIntByAPI(ex);
			handleException(ex);
		}
	

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	/**
	* Save last thrown exception.
	*/
	private static synchronized void saveException(Exception ex, int code) {
		// Only first ERR_ITEMS exception are kept
		if (exObjects.size() == ERR_ITEMS) {
			return;
		} 
		// Check is already in collection
		if (exObjects.contains(ex)) return;
		
		exObjects.add(ex);
	}
	
	//==== < private ================================== deprecated > ====
}
