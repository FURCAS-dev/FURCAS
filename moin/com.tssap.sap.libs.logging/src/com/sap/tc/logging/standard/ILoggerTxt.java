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

import com.sap.tc.logging.schema.BaseCategory;

public interface ILoggerTxt {
	
	void info(BaseCategory category, String message);
	void info(BaseCategory category, String message, Object[] arguments);
	
	void warning(BaseCategory category, String message);
	void warning(BaseCategory category, String message, Object[] arguments);
	
	void error(BaseCategory category, String message);
	void error(BaseCategory category, String message, Object[] arguments);
	
	void fatal(BaseCategory category, String message);
	void fatal(BaseCategory category, String message, Object[] arguments);
}
