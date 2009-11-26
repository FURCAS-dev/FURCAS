package com.sap.tc.logging.tools.lv;

/**
 *  Copyright:   Copyright (c) 2004
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
 * @version 		 $Id:$
 * @author			 Robert Boban			
 */

import com.sap.tc.logging.exceptions.LoggingBaseException;

class LVException extends LoggingBaseException{
	
	public LVException(Throwable ex) {
		super(ex);
	}
		
	public LVException(String msg) {
		super(msg);
	}
	
	public LVException(String msg, Throwable ex) {
		super(msg);
	}
	
	public LVException(String messageID, String message) {
		super (messageID, message);
	}

	public LVException(String messageID, String message, Throwable ex) {
		super (messageID, message, ex);
	}
	
	public LVException(String messageID, String message, Object[] msgArgs) {
		super (messageID, message, msgArgs);
	}
	
	public LVException(String messageID, String message, Object[] msgArgs, Throwable ex) {
		super (messageID, message, msgArgs, ex);
	}

}
