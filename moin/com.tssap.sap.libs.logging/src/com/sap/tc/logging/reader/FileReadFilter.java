package com.sap.tc.logging.reader;

/*
 *  Copyright:   Copyright (c) 2003
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
 * @version $Id:$
 */

import java.util.*;

import com.sap.tc.logging.interfaces.IFilter;


class FileReadFilter implements IFilter 
{ //$JL-EQUALS$
	//================================================ declaration > ====
	
	public static int	LOG_OPERATER_AND 	= 1;
	public static int	LOG_OPERATER_OR		= 2;
	
	private int 			logOperator				= LOG_OPERATER_OR;
	private	String[] 	conditions; 
	private boolean 	isCaseSensitive;
	private boolean		isFilterEnabled;
	
	//==== < declaration ============================ constructors > ====
	
	public FileReadFilter(String[] 	conditions, int logOperator, boolean isCaseSensitive) {
		this.conditions 			= conditions;
		this.isCaseSensitive	= isCaseSensitive;
		setLogOperator(logOperator);
		this.isFilterEnabled = isConditionsOk(conditions);
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public void setCaseSensitive(boolean isCaseSensitive) {
		this.isCaseSensitive = isCaseSensitive;
	}

	public boolean isCaseSensitive() {
		return this.isCaseSensitive;
	}
	
	public void setLogOperator(int operator) {
		if (operator < LOG_OPERATER_AND || operator > LOG_OPERATER_OR) {
			operator = LOG_OPERATER_OR;
		}
		this.logOperator = operator;
	}
	
	public int getLogOperator() {
		return this.logOperator;
	}
	
	/**
	 * @see com.sap.tc.logging.interfaces.IFilter#isFilterEnabled()
	 */
	public boolean isFilterEnabled() {
		return isFilterEnabled;
	}

	/**
	 * @see com.sap.tc.logging.interfaces.IFilter#setEnableFilter(boolean)
	 */
	public boolean setEnableFilter(boolean value) {
		return isFilterEnabled = value;
	}
	
	/**
	 * @see com.sap.tc.logging.interfaces.IFilter#beRead(java.lang.String[], java.lang.String)
	 */
	public boolean beRead(byte[] record) {
		
		String 	token 	= null;
		boolean result 	= false;
		
		// Guardian...
		if (record == null || record.length == 0) return false;
		
		String strRecord = new String(record).trim();
		
		if (!isCaseSensitive) strRecord = strRecord.toUpperCase();
		for (int i = 0; i < conditions.length; i++) {
			token = conditions[i];
			if (!isCaseSensitive) token = token.toUpperCase();
			if (strRecord.indexOf(token) > 0) {
				if (logOperator == LOG_OPERATER_OR) {
					result = true;
				}
			}
			else {
				if (logOperator == LOG_OPERATER_AND) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public boolean equals(Object object) {
		
		boolean result = false;
		
		if (object instanceof IFilter) {
			FileReadFilter filter = (FileReadFilter) object;
			
			// Compare Conditions
			result = (this.getConditions() != null && filter.getConditions() != null);
			result = result & Arrays.equals(this.getConditions(), filter.getConditions());
			
			// Compare Operators
			result = result & (this.getLogOperator() == filter.getLogOperator());
			
			// Compare case
			result = result & (this.isCaseSensitive == filter.isCaseSensitive());
		}
		return result;
	}
	
	//==== < public ==================================== protected > ====
	
	protected String[] getConditions() {
		return conditions;
	}
	
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private boolean isConditionsOk(String[] conditions) {
		boolean result = false;
		if (conditions != null) {
			result = true;
			for (int i = 0; i < conditions.length; i++) {
				result = result && (conditions[i] != null && conditions[i].length() > 0);
			}
		}
		return result;
	}
	
	//==== < private ================================== deprecated > ====
	
}
