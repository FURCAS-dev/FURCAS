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

public class OpenException extends LoggingBaseException{

	public OpenException(String source, String destination, Exception ex) {
		  super(ExMSGs.LOGGING_MSG_ID_EX_OPEN, 
					  ExMSGs.LOGGING_MSG_STR_EX_OPEN, 
					  new Object[] {source, destination}, ex);
	}
 
}