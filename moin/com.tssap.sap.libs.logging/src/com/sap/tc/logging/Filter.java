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
 * Provides, in addition to effective severities, control of writing log records
 * to logs or log controllers.
 * @see�   Log
 * @see�   LogController
 * @see�   LogRecord
 */
public interface Filter {

  /**
   * Decides whether a log record should be written to a log.
   * @param  rec Log record about to be written
   * @return Decision
   */
  public boolean beLogged(LogRecord rec);

}