package com.sap.tc.logging.exceptions;

/*
 *  Copyright:   Copyright (c) 2003
 *
 *  Company:     SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @version $Id:$
 */
 
import com.sap.tc.logging.*;
 
class ExceptionLogger extends APILogger {
	
	public static Location ExceptionLocation = Location.getLocation(ExceptionLogger.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	
	public static LogRecord writeLog(int  			severity,
																		Location  loc,
																		String    subloc,
																		Object    msgCode,
																		String    msgClear,
																		Object[]  args) {
		return APILogger.logIntByAPI(severity, loc, subloc, msgCode.toString(), msgClear, args);
	}
	
	public static LogRecord catching(Throwable exc) {
		return APILogger.catchingIntByAPI(exc);
	}
	
	public static boolean beLogged(int severity) {
		return APILogger.beLogged(severity);
	}
	
}
