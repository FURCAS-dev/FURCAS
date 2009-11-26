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

public interface ITracerTxt {
	void path(String message);
	void path(String message, Object[] arguments);
	
	void debug(String message);
	void debug(String message, Object[] arguments);
	
	void info(String message);
	void info(String message, Object[] arguments);
}
