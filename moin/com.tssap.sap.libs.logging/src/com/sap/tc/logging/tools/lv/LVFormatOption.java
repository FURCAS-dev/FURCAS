package com.sap.tc.logging.tools.lv;

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

class LVFormatOption 
{
	
	//================================================ declaration > ====
	
	public String		name;
	public int			type;
	public int			width;
	public int 			align;
	public boolean 	isEnabled;
	
	//==== < declaration ============================ constructors > ====
	
	public LVFormatOption(String name, int type, int witdh, int align) 
	{
		this.name		= name;
		this.type 	= type;
		this.width	= witdh;
		this.align	= align;
	}
	
	//==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  //==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====
	
}
