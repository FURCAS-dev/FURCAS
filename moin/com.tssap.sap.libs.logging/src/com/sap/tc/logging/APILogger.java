package com.sap.tc.logging;

/*
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
 * @author			 Robert Boban	
 */

public class APILogger {
	
	protected static Location APILocation = Location.getLocation(APILogger.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	protected static Location loggingPachkageLocation = Location.getLocation("com.sap.tc.logging", "tc~logging~java", "BC-JAS-ADM-LOG-API");

	protected static LogRecord logIntByAPI(int  			severity,
																					Location  loc,
																					String    subloc,
																					String    msgCode,
																					String    msgClear,
																					Object[]  args) {
		init();
		if (Category.SYS_LOGGING.beLogged(severity)) {
			return Category.SYS_LOGGING.logIntByAPI(severity, loc, subloc, msgCode, msgClear, args);
		} else if (APILocation.beLogged(severity)) {
			return APILocation.logIntByAPI(severity, loc, subloc, msgCode, msgClear, args);
		} else {
			return null;
		}
	}

	protected static LogRecord logIntByAPI(int  			severity,
																		String    subloc,
																		String    msgCode,
																		String    msgClear,
																		Object[]  args) {
		init();
		if (Category.SYS_LOGGING.beLogged(severity)) {
			return Category.SYS_LOGGING.logIntByAPI(severity, APILocation, subloc, msgCode, msgClear, args);
		} else if (APILocation.beLogged(severity)) {
			return APILocation.logIntByAPI(severity, APILocation, subloc, msgCode, msgClear, args);
		} else {
			return null;
		}
	}
	
	public static LogRecord traceThrowableIntByAPI(int  			severity,
			String    loc,
			String    msgClear,
			Exception exc) {
		init();
		return loggingPachkageLocation.logTInt(severity,
				                                   APILocation,
				                                   null, loc,
				                                   msgClear,
				                                   MsgType.JAVA,
				                                   new Object[] {ExceptionManager.getStackTrace(exc)});
		
	}
	
	protected static LogRecord logIntByAPI(int  			severity,
																					String    subloc,
																					MsgObject msgObject,
																					Object[]  args) {
		init();
		if (Category.SYS_LOGGING.beLogged(severity)) {		
          return Category.SYS_LOGGING.logIntByAPI(severity, 
											   	  APILocation, 
												  subloc, 
											      msgObject.getMsgKeyAndID(), 
												  msgObject.getMsgText(), 
												  args);
		} else if (APILocation.beLogged(severity)) {
			return APILocation.logIntByAPI(severity, 
					                       APILocation, 
					                       subloc, 
					                       msgObject.getMsgKeyAndID(), 
					                       msgObject.getMsgText(), 
					                       args);
		} else {
			return null;
		}
	}
	
	protected static LogRecord instrumentIntByAPI(String    subloc,
																								MsgObject msgObject,
																								Object[]  args) {
		init();
 	    return APILocation.debugT(msgObject.getMsgText(), args);
	}
    
    protected static LogRecord instrumentIntByAPI(int sev, String message, Object[]  args) {
      init();
      return APILocation.logT(sev, message, args);
    }    

	protected static LogRecord catchingIntByAPI(Throwable exc) {
		if (Category.SYS_LOGGING.bePath()) {
			return Category.SYS_LOGGING.catchingIntByAPI(exc);
		} else if (APILocation.bePath()) {
			return APILocation.catchingIntByAPI(exc);
		} else {
			return null;
		}
	}
	
	protected static boolean beLogged(int severity) {
		return Category.SYS_LOGGING.beLogged(severity);
	}
	
	private static void init() {
		if (APILocation == null) {
			APILocation = Location.getLocation(APILogger.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
		}
	}
	
}