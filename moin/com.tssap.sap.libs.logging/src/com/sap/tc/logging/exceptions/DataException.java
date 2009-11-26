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

public abstract class DataException extends LoggingBaseException{

	protected DataException(String source, String destination) {
		  super(ExMSGs.LOGGING_MSG_ID_EX_DATA, 
					  ExMSGs.LOGGING_MSG_STR_EX_DATA, 
					  new Object[] {source, destination});
  }
  protected DataException(String source, String destination, Exception ex) {
		  super(ExMSGs.LOGGING_MSG_ID_EX_DATA, 
					  ExMSGs.LOGGING_MSG_STR_EX_DATA, 
					  new Object[] {source, destination}, ex);
  }
}