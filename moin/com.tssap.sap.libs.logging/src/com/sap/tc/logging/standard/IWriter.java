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

public interface IWriter {
	public void log(int severity, BaseCategory category, String  message);
	public void log(int severity, BaseCategory category, String  message,  Object[] args);
	public void log(int severity, BaseCategory category, Message  message);
	public void log(int severity, BaseCategory category, Message  message,  Object[] args);
}
