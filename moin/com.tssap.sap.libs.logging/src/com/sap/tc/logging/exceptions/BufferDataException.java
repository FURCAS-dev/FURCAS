package com.sap.tc.logging.exceptions;

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

import com.sap.tc.logging.MsgObject;

public class BufferDataException extends DataException{

	private static final String SOURCE_NAME = "buffer";
	
	public BufferDataException(String sourceName) {
	  super(SOURCE_NAME, sourceName);
	}
	
	public BufferDataException(String sourceName, Exception ex) {
		  super(SOURCE_NAME, sourceName, ex);
	}
}


