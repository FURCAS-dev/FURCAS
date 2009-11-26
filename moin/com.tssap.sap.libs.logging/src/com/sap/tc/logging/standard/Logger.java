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
import java.util.Map;
import java.util.HashMap;

import com.sap.tc.logging.schema.BaseCategory;
import com.sap.tc.logging.interfaces.IFilter;

public class Logger implements ILoggerWriter, ILoggerConfigurator 
{

	//================================================ declaration > ====
	
	private Map controlers = new HashMap();
	
	//==== < declaration ============================ constructors > ====
	
	protected Logger(String name) {
		this(name, null);
	}
	
	protected Logger(String name, String description) {
		this(LoggingManager.DEFAULT_PROFILE, name, description);
	}
	
	private Logger(String profile, String name, String description) {
		controlers.put(profile, new LoggerController(name, description));
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====

	public Logger getLogger() {
		return getLogger(LoggingManager.DEFAULT_PROFILE);
	}

	public Logger getLogger(String profile) {
		if (controlers.containsKey(profile)) {
			return (Logger) controlers.get(profile);
		}
		return null;
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#catching(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Object[], java.lang.Throwable)
	 */
	public void catching(BaseCategory category, Message message, Object[] arguments, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#catching(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Throwable)
	 */
	public void catching(BaseCategory category, Message message, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#catching(com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Object[], java.lang.Throwable)
	 */
	public void catching(BaseCategory category, String message, Object[] arguments, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#catching(com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Throwable)
	 */
	public void catching(BaseCategory category, String message, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#throwing(com.sap.tc.logging.standard.Message, java.lang.Object[], java.lang.Throwable)
	 */
	public void throwing(Message message, Object[] arguments, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#throwing(com.sap.tc.logging.standard.Message, java.lang.Throwable)
	 */
	public void throwing(Message message, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#throwing(java.lang.String, java.lang.Object[], java.lang.Throwable)
	 */
	public void throwing(String message, Object[] arguments, Throwable thw) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILoggerWriter#throwing(java.lang.String, java.lang.Throwable)
	 */
	public void throwing(String message, Throwable thw) {

	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#error(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void error(BaseCategory category, Message message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#error(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message)
	 */
	public void error(BaseCategory category, Message message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#error(com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Object[])
	 */
	public void error(BaseCategory category, String message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#error(com.sap.tc.logging.standard.BaseCategory, java.lang.String)
	 */
	public void error(BaseCategory category, String message) {
	
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#fatal(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void fatal(BaseCategory category, Message message, Object[] arguments) {
	
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#fatal(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message)
	 */
	public void fatal(BaseCategory category, Message message) {
	
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#fatal(com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Object[])
	 */
	public void fatal(BaseCategory category, String message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#fatal(com.sap.tc.logging.standard.BaseCategory, java.lang.String)
	 */
	public void fatal(BaseCategory category, String message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#info(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void info(BaseCategory category,	Message message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#info(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message)
	 */
	public void info(BaseCategory category, Message message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#info(com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Object[])
	 */
	public void info(BaseCategory category, String message,	Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#info(com.sap.tc.logging.standard.BaseCategory, java.lang.String)
	 */
	public void info(BaseCategory category, String message) {
	
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#warning(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void warning(BaseCategory category, Message message, Object[] arguments) {
	
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#warning(com.sap.tc.logging.standard.BaseCategory, com.sap.tc.logging.standard.Message)
	 */
	public void warning(BaseCategory category, Message message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#warning(com.sap.tc.logging.standard.BaseCategory, java.lang.String, java.lang.Object[])
	 */
	public void warning(BaseCategory category, String message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ILogger#warning(com.sap.tc.logging.standard.BaseCategory, java.lang.String)
	 */
	public void warning(BaseCategory category, String message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#debug(com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void debug(Message message, Object[] arguments) {

	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#debug(com.sap.tc.logging.standard.Message)
	 */
	public void debug(Message message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#debug(java.lang.String, java.lang.Object[])
	 */
	public void debug(String message, Object[] arguments) {
	
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#debug(java.lang.String)
	 */
	public void debug(String message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#info(com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void info(Message message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#info(com.sap.tc.logging.standard.Message)
	 */
	public void info(Message message) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#info(java.lang.String, java.lang.Object[])
	 */
	public void info(String message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#info(java.lang.String)
	 */
	public void info(String message) {

	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#path(com.sap.tc.logging.standard.Message, java.lang.Object[])
	 */
	public void path(Message message, Object[] arguments) {

	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#path(com.sap.tc.logging.standard.Message)
	 */
	public void path(Message message) {

	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#path(java.lang.String, java.lang.Object[])
	 */
	public void path(String message, Object[] arguments) {
		
	}

	/**
	 * @see com.sap.tc.logging.standard.ITracer#path(java.lang.String)
	 */
	public void path(String message) {
		
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

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====

}