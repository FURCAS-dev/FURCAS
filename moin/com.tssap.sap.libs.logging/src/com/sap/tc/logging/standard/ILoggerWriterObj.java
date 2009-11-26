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

public interface ILoggerWriterObj extends ILoggerObj, ITracerObj {
	void throwing(Message message, Throwable thw);
	void throwing(Message message, Object[] arguments, Throwable thw);
	
	void catching(BaseCategory category, Message message, Throwable thw);
	void catching(BaseCategory category, Message message, Object[] arguments, Throwable thw);
}
