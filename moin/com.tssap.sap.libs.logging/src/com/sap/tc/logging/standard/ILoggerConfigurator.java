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

public interface ILoggerConfigurator {
	
	int getSeverity();	
	void setSeverity(int value);
	
	int getMaxSeverity();	
	void setMaxSeverity(int value);
		
	int getMinSeverity();	
	void setMinSeverity(int value);
	
	void addFilter(IFilter filter);
	void removeFilter(IFilter filter);
	Collection getAllFilters();
	
}
