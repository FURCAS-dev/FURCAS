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
 * An event indicating a log is ready to be used to output logging messages.
 * In the current implementation: when the log gets assigned to a log controller
 * (source area).
 */
public class NewLogEvent implements Event{
	
	//================================================ declaration > ====
	
	private Log newLog;
	
	//==== < declaration ============================ constructors > ====
	
  public NewLogEvent(Log aNewLog) {
    this.newLog = aNewLog;
  }

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
  public Log getNewLog(){
    return this.newLog;
  }
  
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	
}