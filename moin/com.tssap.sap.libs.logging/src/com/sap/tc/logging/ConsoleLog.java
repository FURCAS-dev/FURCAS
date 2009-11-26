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

import java.lang.*;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Writes log records to <code>System.err</code>.
 */
public class ConsoleLog extends StreamLog 
{ 
	//$JL-SYS_OUT_ERR$ $JL-EQUALS$ $JL-CONSOLE_LOG$
	//================================================ declaration > ====
	
	private static Location classLoc = Location.getLocation(ConsoleLog.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	private static final OutputStream NULL_STREAM = null;  
	private static boolean enableConsoleLog = true;  
	
	//==== < declaration ============================ constructors > ====
	
  /**
   * Configures this console log.
   * @see    #ConsoleLog(Formatter)
   */
  public ConsoleLog() {
    super(getStream(), new TraceFormatter());
	setName("Console Log");
  }

  /**
   * Configures this console log for writing with a custom formatter.
   * @param  formatter Formatter
   * @see    #ConsoleLog()
   */
  public ConsoleLog(Formatter formatter) {
    super(getStream(), formatter);
	setName("Console Log");
  }

  private static OutputStream getStream() {
	if (enableConsoleLog) { 
      return System.err;
	} else {
      return NULL_STREAM;
	}
  }
  
  public static boolean isEnable() {
	return enableConsoleLog; 
  }
  
  public static void setEnable(boolean enable) {
    enableConsoleLog = enable;
  }
  
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
  protected synchronized void closeInt() throws IOException {
	  // Do not close the public System.err stream.
	}

	public boolean equals(Object object) {
	  return object instanceof ConsoleLog;
	}
	
  //==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====

  void setOutputStream(OutputStream stream)  {
	  // It is not possible to set a new stream.
	}

  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====
 
}