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

public class LVActionConstants
{
    /* =============================================================== */

    // Action defining constants

    static public final int ACTION_UNKNOWN       		= -1;
    static public final int ACTION_VERSION       		=  ACTION_UNKNOWN + 1;
		static public final int ACTION_HELP       	 		=  ACTION_VERSION + 1;

		static public final int ACTION_READ_FILE_PATH	 	=  ACTION_HELP + 1;

    /* =============================================================== */

    static final String DESC_ACTION_UNKNOWN       	= "Unknown";
    static final String DESC_ACTION_VERSION       	= "Version";
		static final String DESC_ACTION_HELP       			= "Help";
		
		static final String DESC_ACTION_READ_FILE_PATH  = "Read file/path";
		
    /* =============================================================== */

}
