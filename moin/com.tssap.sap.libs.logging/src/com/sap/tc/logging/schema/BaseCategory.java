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
 * @version $Id:$
 * @author			 Robert Boban			
 */

import com.sap.tc.logging.interfaces.IObjectInfo;

public abstract class BaseCategory implements IObjectInfo {
	
	//================================================ declaration > ====
	private String catName;
	private String catDescription;
	private String catVerInUse;
	
  //==== < declaration ============================ constructors > ====
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====

  /**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#getName()
   */
  public String getName() {
	  return catName;
  }
	    
	/**
	 * @see com.sap.tc.logging.interfaces.IObjectInfo#getDescription()
	 */
	public String getDescription() {
		return catDescription;
	}

	/**
	 * @see com.sap.tc.logging.interfaces.IObjectInfo#getVerInUse()
	 */
	public String getVerInUse() {
		return catVerInUse;
	}
	
	//==== < public ==================================== protected > ====
	
	/**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#setName(java.lang.String)
   */
	protected void setName(String value) {
		catName = value;
 	}
	
	/**
	 * @see com.sap.tc.logging.interfaces.IObjectInfo#setDescription(java.lang.String)
	 */
	protected void setDescription(String value) {
		catDescription = value;
	}
	
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	
}
