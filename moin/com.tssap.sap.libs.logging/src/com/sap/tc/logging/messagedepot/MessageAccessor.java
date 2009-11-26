/*
 * Created on Oct 14, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.sap.tc.logging.messagedepot;

/**
 * @author I803971
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public interface MessageAccessor {

	/**
	 * Get a LocaledMessage that contains the localized text for the locale
	 * of the MessageAccessor. The locale of the MessageAccessor is set
	 * when the contructor of the implementation is called.
	 */
	public LocalizedMessage getLocalizedMessage(MessageID messageID);
}