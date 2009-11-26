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
 * Manage the general event notification mechanism
 * @see�   LoggingManager
 */
public interface EventDispatcher {

  /**
   * To add a listener to the logging tool
   * @param  listener The event listener to be added
   * @throws IllegalArgumentException Invalid listener type
   */
  public void addListener(EventListener listener)
                          throws IllegalArgumentException;
  /**
   * To remove a listener from the logging tool.
   * @param  listener The event listener to be removed
   * @throws IllegalArgumentException Invalid listener type
   */
  public void removeListener(EventListener listener)
                          throws IllegalArgumentException;
}