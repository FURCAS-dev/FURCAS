package com.sap.tc.logging;

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
 */

public class MsgObject {
	
	//================================================ declaration > ====
  //==== < declaration ============================ constructors > ====

  private String msgID;
  private String msgText;
  private String msgKey;
  private String msgKeyAndID;
  
  public MsgObject (String messageID, String messageText) {
		this(messageID, messageText, "UNKNOWN");
  }
  
  public MsgObject (String messageID, String messageText, String messageKey) {
  	this.msgID			 = messageID;
  	this.msgText 		 = messageText;
  	this.msgKey 		 = messageKey;
  	this.msgKeyAndID = buildMessageKeyAndID(messageID, messageKey);
  }
  
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
  public String getMsgText() {
	  return this.msgText;
	}

  public String getMsgKey() {
      return this.msgKey;
    }

  //==== < public ==================================== protected > ====
  
  protected String getMsgID() {
  	return this.msgID;
  }
  
  protected void setMsgKey(String value) {
	  this.msgKey 			= value;
	  this.msgKeyAndID 	= buildMessageKeyAndID(this.msgID, value);
	}
  
  protected String getMsgKeyAndID() {
	  return msgKeyAndID;
	}
  
  protected static String buildMessageKeyAndID(String messageID, String messageKey) {
  	// Create message alias and message id string
		StringBuffer tmpBuffer = new StringBuffer();
		tmpBuffer.append(messageKey);
  	tmpBuffer.append("[");
  	tmpBuffer.append(messageID);
  	tmpBuffer.append("]");
  	return tmpBuffer.toString();
  }
  
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====

}
