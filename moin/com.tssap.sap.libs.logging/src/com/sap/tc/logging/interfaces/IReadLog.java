package com.sap.tc.logging.interfaces;

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

import java.io.*;

import com.sap.tc.logging.*;
import com.sap.tc.logging.exceptions.*;
 
public interface IReadLog extends IBaseLog{
	
	public void moveToEOF() throws DataException;;
	public void moveToBOF() throws DataException;;
	
	public ILoggingResultSet readNext() throws DataException;											
	public ILoggingResultSet readNext(int numberOfRecords) throws DataException;
	  	
	public ILoggingResultSet readPrevious() throws DataException;	
	public ILoggingResultSet readPrevious(int numberOfRecords) throws DataException;
	  
	public boolean isBOF() throws DataException;
	public boolean isEOF() throws DataException;
		
	public void 							seek	(long filePointer) throws DataException;
	public ILoggingResultSet 	search(String condition) throws DataException;
	public long 							find	(String condition) throws DataException;
	
	public int 	getMode();
	public void setMode(int mode);
	
	public long getBookMark() 					throws DataException;
	public void setBookMark(long value) throws DataException;
  
}
