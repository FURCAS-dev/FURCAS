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

import com.sap.tc.logging.*;

public class CloseException extends LoggingBaseException{

  public CloseException(String source, String destination, Exception ex) {
		super(ExMSGs.LOGGING_MSG_ID_EX_CLOSE, 
					ExMSGs.LOGGING_MSG_STR_EX_CLOSE, 
					new Object[] {source, destination}, ex);
  }
 
}