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
import com.sap.tc.logging.interfaces.*;
import com.sap.tc.logging.exceptions.*;

import java.io.*;
import java.util.*;

public abstract class ReadLog extends 		BaseLog
															implements 	IReadLog {

	//================================================ declaration > ====
	
	private static String strLoc = "ReadLog";

	private long				bookMark;
	
	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	
	protected abstract long getBookMarkInt() 						throws DataException;
	protected abstract void setBookMarkInt(long value) 	throws DataException;
	
	//==== < abstract ===================================== public > ====
	
	/**
	 * @see com.sap.tc.logging.interfaces.IReadLog#readNext()
	 */
	public ILoggingResultSet readNext() throws DataException {
		return readNext(1);
	}
	
	/**
	 * @see com.sap.tc.logging.interfaces.IReadLog#readPrevious()
	 */
	public ILoggingResultSet readPrevious() throws DataException {
		return readPrevious(1);
	}
	
  public synchronized void setBookMark(long value) throws DataException{
		setBookMarkInt(value);
	}
	
	public synchronized long getBookMark() throws DataException{
		return getBookMarkInt();
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====

}
