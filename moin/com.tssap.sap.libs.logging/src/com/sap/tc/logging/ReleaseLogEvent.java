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
 * This event will be fired before an existing logfile is being cleaned up and
 * overwritten with new messages, before OwerwriteLogfileEvent.<br>
 * This can happen when:<br>
 * When a filelog has been defined with rotating feature, and existing file in
 * the rotating sequence is overwritten by the continuous growth of messages. <br>
 * Or even for a single logfile, if it already exists, for example from the previous
 * run of the application and has not been physically removed.
 * The main propose of this event is to invoke releasing / closing 
 * a log before proceeding with an overwriting event.
 */
public class ReleaseLogEvent implements Event{

	//================================================ declaration > ====
	
	private FileLog mFileLog;
	
	//==== < declaration ============================ constructors > ====
		
  public ReleaseLogEvent(FileLog fileLog) {
	  mFileLog = fileLog;
	}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
  public FileLog getFileLog(){
	  return mFileLog;
	}

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
		
}