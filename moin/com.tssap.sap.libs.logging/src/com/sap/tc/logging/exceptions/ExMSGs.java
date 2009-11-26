package com.sap.tc.logging.exceptions;

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

import com.sap.tc.logging.*;

class ExMSGs {
	
	public static String LOGGING_MSG_ID_EXCEPTION_LOG 			= "1645F078-11CF-411e-A666-3381448EF7B1";
	public static String LOGGING_MSG_STR_EXCEPTION_LOG    	= "Unexcepted error!";

	public static String LOGGING_MSG_ID_EXCEPTION_INFO 			= "DD8A041C-FC7C-46f1-B8A1-A1DB21198BF1";
	public static String LOGGING_MSG_STR_EXCEPTION_INFO    	= "For additional info see the messages:\n [MSG_ID = {0}] \n [MSG_ID = {1}] \n in the log: {2}!";	
	public static String LOGGING_MSG_ID_EX_OPEN							= "7D4E986F-B684-4942-B3E7-FEDA3AB57100";
	public static String LOGGING_MSG_STR_EX_OPEN	  				= "Error in opening {0}({1})!";
	public static String LOGGING_MSG_ID_EX_CLOSE						= "C068DC27-2F1B-451d-90A7-23C11EA0EB85";
	public static String LOGGING_MSG_STR_EX_CLOSE	  				= "Error in closing {0}({1})!";
	public static String LOGGING_MSG_ID_EX_DATA							= "D4F3EDFD-F981-4572-8771-B20DCEA6DC96";
	public static String LOGGING_MSG_STR_EX_DATA	  				= "Error during browsing {0} data ({1})!";

}
