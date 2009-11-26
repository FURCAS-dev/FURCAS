package com.sap.tc.logging.standard;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2004
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

public class MsgObject {
	
	//================================================ declaration > ====
  //==== < declaration ============================ constructors > ====
  
  private String msgID;
  private String msgText;
  
  public MsgObject (String messageID, String messageText) {
		msgID		= messageID;
		msgText = messageText;
  }
  
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  //==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====

}
