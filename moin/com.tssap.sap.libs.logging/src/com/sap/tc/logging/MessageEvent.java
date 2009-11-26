package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2004
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
 * This event will be fired when an message is being processed.
 * This can happen when:<br>
 * Event will be fired only if MessageEventListener.beRead() return true.
 */
public class MessageEvent  implements Event {

	private LogRecord record;
	
	public MessageEvent(LogRecord record) {
		this.record = record;
	}
	
	public LogRecord getLogRecord(){
	  return record;
	}
	
}
