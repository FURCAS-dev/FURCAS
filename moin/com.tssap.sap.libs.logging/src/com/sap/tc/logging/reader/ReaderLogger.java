package com.sap.tc.logging.reader;

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
 
class ReaderLogger extends APILogger {
	
	public static Location ReaderLocation = Location.getLocation(ReaderLogger.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	
	public static LogRecord logIntByAPI(int  			severity,
																	Location  loc,
																	String    subloc,
																	Object    msgCode,
																	String    msgClear,
																	Object[]  args) {
		return APILogger.logIntByAPI(severity, loc, subloc, msgCode.toString(), msgClear, args);
	}
	
	public static LogRecord catchingIntByAPI(Throwable exc) {
		return APILogger.catchingIntByAPI(exc);
	}
	
	protected static LogRecord instrumentIntByAPI(String    subloc,
																								MsgObject msgObject,
																								Object[]  args) {
		return APILogger.instrumentIntByAPI(subloc, msgObject, args);
	}
	
	public static boolean beLogged(int severity) {
		return Category.SYS_LOGGING.beLogged(severity);
	}

}
