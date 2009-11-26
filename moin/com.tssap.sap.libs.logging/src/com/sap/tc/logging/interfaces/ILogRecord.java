package com.sap.tc.logging.interfaces;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAPMarkets Inc. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 */

import java.util.Date;
import java.util.List;

import com.sap.tc.logging.GUId;
import com.sap.tc.logging.LogController;

public interface ILogRecord {

	/**
	 * Gets the message identification of this log record.
	 * This identification is written to logs via most formatters and allows for
	 * unambiguous cross-referencing among messages in different logs.
	 * @return Unique message id
	 */
	 GUId getId();

	/**
	 * Gets the instantiation date of this log record in milliseconds.
	 * @return Instantiation date in milliseconds
	 */
	 Date getTime();

	/**
	 * Gets the log controller this log record came from.
	 * @return Log controller
	 */
	 LogController getSource();

	/**
	 * Gets the name of the log controller this log record came from.
	 * @return Name of log controller
	 */
	 String getSourceName();

	/**
	 * Gets the name of the location the message belonging to this log record
	 * came from.
	 * @return Name of location
	 */
	 String getLocationName();
	  
	/**
	 * Gets the thread this log record belongs to if it still runs.
	 * @return Thread, or <code>null</code> if meanwhile the thread terminated
	 */
	 Thread getThread();
		 
	/**
	 * Gets the name of the thread this log record belongs to
	 * @return Name of the thread
	 */
	 String getThreadName();
		 
	/**
	 * Gets the severity of this log record.
	 * @return Severity
	 */
	 int getSeverity();

	/**
	 * Gets the type of the message text of this log record.
	 * @return Type of message text
	 */
	 int getMsgType();

	/**
	 * Gets the <code>toString</code> result of the language-independent message
	 * code of this log record.
	 * @return Code of language-independent message
	 */
	 String getMsgCode();

	/**
	 * Gets the clear text version of this log record.
	 * @return Clear text version
	 */
	 String getMsgClear();

	/**
	 * Gets the name of the resource bundle assigned to the language-independent
	 * message belonging to this log record.
	 * @return Name of resource bundle
	 */
	 String getResourceBundleName();

	/**
	 * Gets the <code>toString</code> results of the argument objects of the
	 * template-based message belonging to this log record.
	 * @return Unmodifiable list of message argument strings
	 */
	 List getArgs();
		
	/**
	 * Gets the argument objects of the template-based message belonging to this
	 * log record. Please note that there are no defensive copies made of these
	 * objects, so all modifications made after generating this log record are
	 * reflected in the result of this method.
	 * @return Unmodifiable list of message argument objects
	 */
	 List getArgObjs();
	
	/**
	 * Gets the identification of the group.
	 * @return Unique top group id
	 */
	GUId getGroupId();

	/**
	 * Gets the level of nested groups. 
	 * @return Level of nested groups
	 */
	boolean isGroupActive();

	/**
	 * Gets the level of nested groups. 
	 * @return Level of nested groups
	 */
	int getGroupLevel();

	/**
	 * Gets the indentation of nested groups. This is the level
	 * @return Indentation of nested groups
	 */
	int getGroupIndent();
		
}
