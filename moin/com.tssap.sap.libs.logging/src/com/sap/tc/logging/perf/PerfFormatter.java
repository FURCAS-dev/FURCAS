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
 * @author			 Refactored by Robert Boban
 */

import java.text.ParseException;

import com.sap.tc.logging.LogRecord;
import com.sap.tc.logging.ListFormatter;
import com.sap.tc.logging.interfaces.IMessageBuilder;

public class PerfFormatter extends ListFormatter
{
	//================================================ declaration > ====  
	//==== < declaration ============================ constructors > ====
	
	public LogRecord parseMsg(IMessageBuilder message) throws ParseException  {
			LogRecord logRec = super.parseMsg(message);
			if (logRec != null) {
				return createPerfLogRecord(logRec, message.message().length);
			}
			else {
				throw new ParseException("Parsing PerfLogRecord failed!", 0);
			}
	}
	
	public LogRecord parseMsg(byte[] msgChunk) throws ParseException {
		LogRecord logRec = super.parseMsg(msgChunk);
		
		if (logRec != null) {
			return createPerfLogRecord(logRec, msgChunk.length);
		}
		else {
			throw new ParseException("Parsing PerfLogRecord failed!", 0);
		}
	} 
	
  public LogRecord parseMsg(String completeMsgData) throws ParseException {
      LogRecord logRec = super.parseMsg(completeMsgData);

			if (logRec != null) {
				return createPerfLogRecord(logRec, completeMsgData.length());
			}
			else {
				throw new ParseException("Parsing PerfLogRecord failed!", 0);
			}
  }

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
  
	public String toString()
	{
		return this.getFormatterType().toString();
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private PerfLogRecord createPerfLogRecord(LogRecord logRec, int msgLenght) {
		return new PerfLogRecord (logRec.getId().toString(),
															msgLenght,
												      logRec.getTime(),
												      logRec.getSourceName(),
												      logRec.getSeverity(),
												      logRec.getLocationName(),
														  (String [])logRec.getRelatives().toArray(new String[0]),
												      null,
												      logRec.getGroupLevel(),
												      logRec.getGroupIndent(),
												      logRec.getThreadName(),
												      logRec.getMsgType(),
												      logRec.getMsgCode(),
												      logRec.getMsgAlias(),
												      logRec.getResourceBundleName(),
												      logRec.getMsgClear(),
												      (String [])logRec.getArgs().toArray(new String[0]),
												      logRec.getApplication(),
												      logRec.getUser(),
												      logRec.getSession(),
												      logRec.getTransaction(),
												      logRec.getDSRTransactionID(),
												      logRec.getDSRRootContextID(),
												      logRec.getDSRConnection(),
                                                      logRec.getDSRCounter(),
												      getMessageAccessor());
	}
	
	//==== < private ================================== deprecated > ====

}