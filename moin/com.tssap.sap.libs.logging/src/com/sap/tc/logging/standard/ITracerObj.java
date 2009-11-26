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

public interface ITracerObj {
	
	void path(Message message);
	void path(Message message, Object[] arguments);
	
	void debug(Message message);
	void debug(Message message, Object[] arguments);
	
	void info(Message message);
	void info(Message message, Object[] arguments);
}
