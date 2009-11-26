package com.sap.tc.logging.tools.lv;
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

public class CmdOptionPrefixes {
	
	private static final String UNKNOWN_OPTION_EMSG = "Unknown tool option";
	
	private static HashMap options = new HashMap();

	public static String parse(String name){
		try {
			String _name = name.toUpperCase().trim().toUpperCase();
			return ((String) options.get(_name));
		}
		catch (NullPointerException exc) {
		  throw new IllegalArgumentException(UNKNOWN_OPTION_EMSG + " (name) !" );
		}
	}
	
	public static void setPrefixes(Map optionPrefixes) {
		options = (HashMap)optionPrefixes;
	}

}
