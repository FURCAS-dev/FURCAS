package com.sap.tc.logging.standard;

/**
 *  Copyright:   Copyright (c) 2004
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
 * @version 		 $Id:$
 * @author			 Robert Boban			
 */

import java.util.*;

import com.sap.tc.logging.*;

public class LoggingManager {
	
	//================================================ declaration > ====
	public static final String DEFAULT_PROFILE = "DEFAULT";
	
	private static LoggingManager loggerManager;
	
	private IRegistry loggerRegistry;
	
	private Log myLog;
	
	//==== < declaration ============================ constructors > ====
	
	protected LoggingManager () {
		loggerRegistry = new LoggerRegistry();
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====	
	
	public static synchronized void register(IRegistry registry) {
		LoggingManager.getInstance().registerInt(registry);
	}
	
	public static ILoggerWriter getLogger(String name) {
		return getLoggerInt(name, DEFAULT_PROFILE);
	}
	
	public static ILoggerWriter getLogger(String name, String profile) {
		return getLoggerInt(name, profile);
	}
	
	public static Collection getAllLoggers() {
		return Collections.EMPTY_LIST;
	}
	
	public static Collection getAllLoggers(String profile) {
		/*if (profiles.isEmpty() || !profiles.contains(profile)) {
			return Collections.EMPTY_LIST;
		}*/
		return null;
	}
	
	public static Collection getProfiles() {
		/*if (!profiles.isEmpty()) {
			return Collections.unmodifiableList(profiles);
		}*/
		return Collections.EMPTY_LIST;
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private static synchronized LoggingManager getInstance() {
		if (loggerManager == null) {  //singleton
			loggerManager = new LoggingManager ();
		}
		return loggerManager;
	}
	
	private void registerInt(IRegistry registry) {
		loggerRegistry = registry;
	}
	
	private static Logger getLoggerInt(String name, String profile) {
		// Register profile
		/*if (!profiles.contains(profile)) {
			profiles.add(profile);
		}*/
		return new Logger("TEST");
	}
	
	//==== < private ================================== deprecated > ====	
	
}
