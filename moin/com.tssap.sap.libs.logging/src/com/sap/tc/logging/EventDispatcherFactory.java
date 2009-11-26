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
 * This factory manages the event dispatcher of the logging tool.
 * Users can get handle to the event dispatcher and add listners to it.
 */
public class EventDispatcherFactory {

  private EventDispatcherFactory() { }

  /**
   * Returns the Event Dispatcher of the logging tool, for users to add or remove
   * listeners to the logging tool.
   */
  public static EventDispatcher getEventDispatcher(){
    return LoggingManager.getLoggingManager();
  }
}