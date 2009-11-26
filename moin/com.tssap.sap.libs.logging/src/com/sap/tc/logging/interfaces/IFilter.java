package com.sap.tc.logging.interfaces;

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


public interface IFilter {

	/**
   * Is filter enabled!?
   * @return true / false
   */
  public boolean isFilterEnabled();

	/**
	 * Enable or disable configured filter
	 */
	public boolean setEnableFilter(boolean value);

  /**
   * Decides whether a log record should be read from a log.
   * @param  record which must be evaluated
   * @return Decision
   */
  public boolean beRead(byte[] record);

}