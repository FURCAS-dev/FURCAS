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

import java.util.HashMap;

class GroupFactory {
	//$JL-EXC$
	//================================================ declaration > ====
	
	private static String strLoc = "GroupFactory";
	
  //==== < declaration ============================ constructors > ====
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
	
	/**
	 * @deprecated Groups are not used and implementation was removed for memory usage improvement,
	 *             Instead use correlation id.
	 */
	public static Group openGroup(int							size,
																LogController 	src,
																LogController[] relatives,
																String 					name,
																String					description,
																int							severity,
																String  				subLoc) {
      return null; 
	}
	
	/**
	 * @deprecated Groups are not used and implementation was removed for memory usage improvement
	 *             Instead use correlation id.
	 */
	public static boolean closeGroup(LogController src) {
      return false;
	}
	
	/**
	 * @deprecated Groups are not used and implementation was removed for memory usage improvement
	 *             Instead use correlation id.
     */
	public static boolean closeGroup(LogController src, Group group) {
      return false;
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
}
