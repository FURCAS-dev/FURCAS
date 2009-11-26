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

public abstract class CommonCategory extends BaseCategory {
	
	//================================================ declaration > ====
	
	private String hostName;
	private String hostAddress;
	private String nodeName;
	private String nodeAddress;
	private String sysName;
	private String sysInstanceName;
	
  //==== < declaration ============================ constructors > ====
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
  /**
   * @return
   */
  public String getHostAddress() {
	  return hostAddress;
  }
  
  /**
   * @return
   */
  public String getHostName() {
	  return hostName;
  }

  /**
   * @return
   */
  public String getNodeAddress() {
	  return nodeAddress;
  }

  /**
   * @return
   */
  public String getNodeName() {
	  return nodeName;
  }

  /**
   * @return
   */
  public String getSysInstanceName() {
	  return sysInstanceName;
  }

  /**
   * @return
   */
  public String getSysName() {
	  return sysName;
  }

  //==== < public ==================================== protected > ====
  
  /**
	 * @param string
	 */
	protected void setHostAddress(String value) {
		hostAddress = value;
	}
  
	/**
	 * @param string
	 */
	protected void setHostName(String value) {
		hostName = value;
	}

	/**
	 * @param string
	 */
	protected void setNodeAddress(String value) {
		nodeAddress = value;
	}

	/**
	 * @param string
	 */
	protected void setNodeName(String value) {
		nodeName = value;
	}

	/**
	 * @param string
	 */
	protected void setSysInstanceName(String value) {
		sysInstanceName = value;
	}

	/**
	 * @param string
	 */
	protected void setSysName(String value) {
		sysName = value;
	}
  
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====
    
}
