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
 * This event will be fired when an existing logfile is being cleaned up and
 * overwritten with new messages.<br>
 * This can happen when:<br>
 * When a filelog has been defined with rotating feature, and existing file in
 * the rotating sequence is overwritten by the continuous growth of messages. <br>
 * Or even for a single logfile, if it already exists, for example from the previous
 * run of the application and has not been physically removed.
 */
public class OverwriteLogfileEvent implements Event{

	//================================================ declaration > ====
	
	private FileLog mFileLog;
	
	//==== < declaration ============================ constructors > ====
		
  public OverwriteLogfileEvent(FileLog fileLog) {
	  mFileLog = fileLog;
	}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	/**
   * @deprecated Use <event>.getFileLog().getLimit()
   * @see    #FileLog.getLimit()
   */  
  public int getFileLimit(){
		return mFileLog.getLimit();
  }

  /**
	 * @deprecated Use <event>.getFileLog().getCnt()
	 * @see    #FileLog.getCnt()
	 */  
  public int getFileCnt(){
		return mFileLog.getCnt();
  }

  /**
	 * @deprecated Use <event>.getFileLog().getFileName()
	 * @see    #FileLog.getFileName()
	 */  
  public String getFileName(){
		return mFileLog.getFileName();
  }

  public FileLog getFileLog(){
	  return mFileLog;
	}

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
		
}