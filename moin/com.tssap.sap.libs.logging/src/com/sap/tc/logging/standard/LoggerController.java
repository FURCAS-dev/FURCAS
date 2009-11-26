package com.sap.tc.logging.standard;

/**
 *  Copyright:   Copyright (c) 2004
 *
 *  Company:     SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @version 		 $Id:$
 * @author			 Robert Boban			
 */

import java.util.Collection;

import com.sap.tc.logging.interfaces.IFilter;
import com.sap.tc.logging.interfaces.ILog;
import com.sap.tc.logging.schema.BaseCategory;

class LoggerController implements IWriter, ILoggerConfigurator {

	protected LoggerController(String name, String description) {
	}
	/**
	 * @see com.sap.tc.logging.standard.IWriter#log(int, com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void log(int severity,	BaseCategory category, Message message,	Object[] args) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.IWriter#log(int, com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message)
	 */
	public void log(int severity, BaseCategory category, Message message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.IWriter#log(int, com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Object[])
	 */
	public void log(int severity,	BaseCategory category, String message, Object[] args) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.IWriter#log(int, com.sap.tc.logging.standard.BaseCategory, java.lang.String)
	 */
	public void log(int severity, BaseCategory category, String message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#addFilter(com.sap.tc.logging.interfaces.IFilter)
	 */
	public void addFilter(IFilter filter) {
		
	}


	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#getAllFilters()
	 */
	public Collection getAllFilters() {
		return null;
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#getMaxSeverity()
	 */
	public int getMaxSeverity() {
		return 0;
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#getMinSeverity()
	 */
	public int getMinSeverity() {
		return 0;
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#getSeverity()
	 */
	public int getSeverity() {
		return 0;
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#removeFilter(com.sap.tc.logging.interfaces.IFilter)
	 */
	public void removeFilter(IFilter filter) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#setMaxSeverity(int)
	 */
	public void setMaxSeverity(int value) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#setMinSeverity(int)
	 */
	public void setMinSeverity(int value) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerConfigurator#setSeverity(int)
	 */
	public void setSeverity(int value) {
		
	}

}