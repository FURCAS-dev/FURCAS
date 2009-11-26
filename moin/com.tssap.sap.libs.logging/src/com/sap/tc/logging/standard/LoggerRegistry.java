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

class LoggerRegistry implements IRegistry {
	
	//================================================ declaration > ====
	
	private static List profiles 	= new LinkedList();
	private static Map 	loggers 	= new HashMap ();
		
	//==== < declaration ============================ constructors > ====
	
	public LoggerRegistry () {
	
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public synchronized void clear () {
		loggers.clear ();
		profiles.clear();
	}

	public void insert (Logger logger, String profile) {
		if (!profiles.contains(profile)) {
			profiles.add(profile);
		}
		loggers.put (logger, logger);
  }

  public synchronized void remove (Logger logger) {
		if (logger != null) {
			loggers.remove (logger);
		}
	}
	
	public synchronized void remove (String name) {
		if (name != null) {
			loggers.remove (name);
		}
	}
	
	public synchronized void removeAll (String profile) {
		if (profile != null) {
			loggers.remove (profile);
		}
	}

	public Logger get (String name) {
		// Guardian
		if (name == null) return null;
		
		if (loggers.containsKey(name)) {
			return (Logger) loggers.get (name);
		}	
		return null;
	}
	
	public Collection getAll () {	
		return null;
	}
	
	public Collection getAll (String profile) {	
		return null;
	}

	public boolean contains (Logger logger) {
		return loggers.containsValue(logger);
  }
  
  public boolean contains (String name) {
		return loggers.containsValue(name);
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	/* (non-Javadoc)
	 * @see com.sap.tc.logging.standard.IRegistry#insert(com.sap.tc.logging.standard.Logger)
	 */
	public void insert(Logger logger) {
		// TODO Auto-generated method stub

	}

}
