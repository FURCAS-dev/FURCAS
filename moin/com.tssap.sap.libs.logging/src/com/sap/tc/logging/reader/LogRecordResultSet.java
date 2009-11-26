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

import java.io.*;
import java.util.*;

import com.sap.tc.logging.LogRecord;
import com.sap.tc.logging.interfaces.*;

public final class LogRecordResultSet 
																			implements ILoggingResultSet {
		/**
		 * The requested records are entirely invalid, mostly likely due to
		 * overwriting by the rotating feature.
		 */
		public static final int INVALID = -1;

		/**
		 * The returning number of message record equals to the requested number
		 */
		public static final int VALID = INVALID + 1;
		private List results;
		private int status = VALID;
		private int numReq;
		private Exception invalidReason;

		LogRecordResultSet()
		{
			results = new ArrayList();
		}
		
		LogRecordResultSet(List _results, int reqNum)
		{
			if(_results == null){ //in case of overwriting
				_results = new ArrayList();
			}

			results = _results;
			numReq = reqNum;
		}

		public void add(LogRecord record) {
			results.add(record);
		}
		
		public List getResults()
		{
			return results;
		}

		public boolean isEmpty()
		{
			return results.isEmpty();
		}

		public int getSize()
		{
			return results.size();
		}

		public boolean isValid()
		{
			return (status == VALID) ? true : false;
		}

		public int numRequested()
		{ //optional
			return numReq;
		}

		public Exception getException()
		{
			return invalidReason;
		}

		public void setResults(List results)
		{
			this.results = results;
		}

		public void setException(Exception e)
		{
			invalidReason = e;
		}

		public void setStatus(int status)
		{
			this.status = status;
		}
}
