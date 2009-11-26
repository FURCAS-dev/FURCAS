package com.sap.tc.logging.interfaces;

/**
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
 * @version      $Id:$
 */

public interface IRPRecord {
    
    
    String getDSRRootContextID();
    void setDSRRootContextID(String value);
    String getDSRTransactionID();
    void setDSRTransactionID(String value);
    String getDSRConnection();
    void setDSRConnection(String value);
    int getDSRCounter();
    void setDSRCounter(int value);
    
	String getUser();
	void   setUser(String value);
	String getApplication();
	void   setApplication(String value);
	String getSession();
	void   setSession(String value);
	String getTransaction();
	void   setTransaction(String value);
    
    /**
     * @deprecated
     */
	String getDsrComponent();
    /**
     * @deprecated
     */    
	void   setDsrComponent(String value);
    /**
     * @deprecated
     */    
	String getDsrUser();
    /**
     * @deprecated
     */    
	void   setDsrUser(String value);
    /**
     * @deprecated
     */    
	String getDsrTransaction();
    /**
     * @deprecated
     */
	void   setDsrTransaction(String value);
    
	long	getCorrelatorID();
 	void   setCorrelatorID(long value);

	
	String getSysInstanceName();
	void setSysInstanceName(String value);
	String getSysName() ;	
	void setSysName(String value);
	String getSysHostName();
	void setSysHostName(String value);
	String getSysNodeID();
	void setSysNodeID(String value);
	
}
