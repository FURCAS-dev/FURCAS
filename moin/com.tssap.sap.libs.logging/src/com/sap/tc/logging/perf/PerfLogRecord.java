package com.sap.tc.logging.perf;

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
 * @author			 Refactored by Robert Boban
 */

import java.util.*;
import java.io.*;

import com.sap.tc.logging.*;
import com.sap.tc.logging.messagedepot.MessageAccessor;

public class PerfLogRecord extends LogRecord implements Serializable
{
	//$JL-SER$
	//================================================ declaration > ====

	static final String EMPTY_STRING = "";
	
	private SatRecord satRecord;

	//==== < declaration ============================ constructors > ====
	
	protected PerfLogRecord(String 		msgID,
													int				size,
												  Date  		time,
												  String 		source,
												  int    		severity,
												  String 		loc,
												  String [] relatives,
												  String	 	groupId,
												  int    		level,
												  int    		indent,
												  String 		thr,
												  int 			msgType,
												  String 		msgCode,
												  String 		msgAlias,
												  String 		resourceBundleName,
												  String 		msgClear,
												  String[] 	args,
												  String 		application,
												  String 		user,
												  String 		session,
												  String 		transaction,
                                                  String        dsrTransaction,
                                                  String        dsrRootContextID,
                                                  String        dsrConnection,
                                                  int           dsrCounter,
												  MessageAccessor msgAccessor){
							
		super (msgID,
                null, //correlation ID
                size,
                time,
                null, //timezone
                source,
                severity,
                loc,
                relatives,
                thr,
                msgType,
                msgCode,
                msgAlias,
                resourceBundleName,
                msgClear,
                args,
                application,
                user,
                session,
                transaction,
                dsrTransaction,
                dsrRootContextID,
                dsrConnection,
                dsrCounter,
                msgAccessor,
                null, //csnComponent
                null);	//dcName
						
		initSatRecord(args);							
	}
	
		
  protected PerfLogRecord(String 		msgID,
  												int				size,
                          Date  		time,
                          String 		source,
                          int    		severity,
                          String 		loc,
                          String [] relatives,
                          String	 	groupId,
                          int    		level,
                          int    		indent,
                          String 		thr,
                          int 			msgType,
                          String 		msgCode,
                          String 		resourceBundleName,
                          String 		msgClear,
                          String[] 	args,
                          String 		application,
                          String 		user,
                          String 		session,
                          String 		transaction,
                          String        dsrTransaction,
                          String        dsrRootContextID,
                          String        dsrConnection,
                          int           dsrCounter)
 {
     this	(msgID,
     				size,
          	time,
          	source,
          	severity,
          	loc,
          	relatives,
          	groupId,
          	level,
          	indent,
          	thr,
          	msgType,
          	msgCode,
						null,
          	resourceBundleName,
          	msgClear,
          	args,
          	application,
          	user,
          	session,
          	transaction,
            dsrTransaction,
            dsrRootContextID,
            dsrConnection,
            dsrCounter,
						null);
  }
  
  //==== < constructors =============================== abstarct > ====
  
  public ISatRecord getSatRecord()
	{
		return satRecord;
	}
  
  //==== < abstract ===================================== public > ====
  //==== < public ==================================== protected > ====
  
  protected void initSatRecord(String args [])
	{
		satRecord = new SatRecord(args);
	}
  
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====

}