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
import java.text.*;
import java.io.*;

/**
 * Collects constants for internal use as message format types as well as some
 * static utility methods.
 */
public class MsgType {

	//================================================ declaration > ====
	
  /**
   * Message type of messages in plain text format.
   */
  public static final int PLAIN = 0;

  /**
   * Message type of messages in <code>java.text.MessageFormat</code> format.
   */
  public static final int JAVA = 1;
  
  private static HashMap msgTypes = new HashMap();
  
  static {
		msgTypes.put("PLAIN", new Integer(PLAIN));
		msgTypes.put("JAVA",  new Integer(JAVA));
  }

	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====

  public static String toString(int msgType) {
    switch (msgType) {
      case PLAIN: return "Plain";
      case JAVA : return "Java";
      default   : return "Unknown";
    }
  }

  /**
   * Gets the message type of the symbolic constant with the specified name.
   * @param  name Name of symbolic message type constant. Case INSENSITIVE.
   * @throws IllegalArgumentException Specified name is not a symbolic message
   *                                  type constant
   */
  public static int parse(String name){
    //YUE: since there exists discrepancy on case sensitivity between defined values
    //     in HashMap severities and 'toString' method. For backward compatibility,
    //     make changes here to gap the difference, by allowing severity
    //     constant string to be case INsensitive.
    try {
      return ((Integer) msgTypes.get(name.toUpperCase().trim())).intValue();
    }
    catch (NullPointerException exc) {
      throw new IllegalArgumentException();
    }
  }

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
  
}