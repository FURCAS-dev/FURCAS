package com.sap.tc.logging.schema;

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

public abstract class DiagnosticCategory extends CommonCategory {
	
	//================================================ declaration > ====
	private String threadName;
	private String sessionName;
	private String transactionName;
	
	private String applicationName;
	private String componentName;
	
	private String userName;
	
	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	/**
	 * @return
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @return
	 */
	public String getComponentName() {
		return componentName;
	}

	/**
	 * @return
	 */
	public String getSessionName() {
		return sessionName;
	}

	/**
	 * @return
	 */
	public String getThreadName() {
		return threadName;
	}

	/**
	 * @return
	 */
	public String getTransactionName() {
		return transactionName;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	//==== < public ==================================== protected > ====
	
	/**
	 * @param string
	 */
	protected void setApplicationName(String string) {
		applicationName = string;
	}

	/**
	 * @param string
	 */
	protected void setComponentName(String string) {
		componentName = string;
	}

	/**
	 * @param string
	 */
	protected void setSessionName(String string) {
		sessionName = string;
	}

	/**
	 * @param string
	 */
	protected void setThreadName(String string) {
		threadName = string;
	}

	/**
	 * @param string
	 */
	protected void setTransactionName(String string) {
		transactionName = string;
	}

	/**
	 * @param string
	 */
	protected void setUserName(String string) {
		userName = string;
	}
	
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====

}
