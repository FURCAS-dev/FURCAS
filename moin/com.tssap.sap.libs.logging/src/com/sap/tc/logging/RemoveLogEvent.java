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

/**
 * An event indicating a log is no longer in use to output logging messages.
 * In the current implementation: when the log is not assigned to ANY log controller
 * (source area) anymore.
 */
public class RemoveLogEvent implements Event{

	//================================================ declaration > ====
	
	private Log removeLog;
	
	//==== < declaration ============================ constructors > ====
	
	public RemoveLogEvent(Log aRemoveLog) {
		this.removeLog = aRemoveLog;
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
  public Log getRemoveLog(){
    return this.removeLog;
  }

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
  
}