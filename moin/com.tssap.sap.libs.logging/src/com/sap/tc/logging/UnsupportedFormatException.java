package com.sap.tc.logging;

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

/**
 * @deprecated Use the com.sap.tc.logging.exception.UnsupportedFormatException class
 */
public class UnsupportedFormatException extends com.sap.tc.logging.exceptions.ReadException{

  public UnsupportedFormatException() {
    super();
  }

  public UnsupportedFormatException(String msg) {
    super(msg);
  }
}