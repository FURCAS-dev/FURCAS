/*
 * Created on Oct 19, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.sap.tc.logging.messagedepot;

/**
 * @author I803971
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class LocalizedMessage {

	private MessageID messageID_;
	private String longText_;
	private String shortText_;

	public LocalizedMessage(MessageID messageID, String longText, String shortText) {
		messageID_ = messageID;
		longText_ = longText;
		shortText_ = shortText;
	}
	
	public MessageID getID() {
		return messageID_;
	}

	public String getShortText() {
		return shortText_;
	}
	
	public String getLongText() {
		return longText_;
	}
}
	
