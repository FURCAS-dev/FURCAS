
package com.sap.tc.logging;

/*
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @author			 Robert Boban	
 */
 
import com.sap.tc.logging.interfaces.IBaseLog;

public interface LogEvents {
	public void eventLogIsOpen(IBaseLog log);
	public void eventLogIsClosed(IBaseLog log);
}
