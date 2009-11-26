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

public class CreateLogfileEvent implements Event{

	//================================================ declaration > ====
	
	private String mRotatedFileName;
	private int mLimit;
	private int mCnt;
	
	//==== < declaration ============================ constructors > ====

  public CreateLogfileEvent(String fileName,
                             int limit,
                             int cnt) {
    mRotatedFileName = fileName;
    mLimit = limit;
    mCnt = cnt;
  }
  
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====

  public int getFileLimit(){
    return mLimit;
  }

  public int getFileCnt(){
    return mCnt;
  }

  public String getFileName(){
    return mRotatedFileName;
  }
  
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	
}
