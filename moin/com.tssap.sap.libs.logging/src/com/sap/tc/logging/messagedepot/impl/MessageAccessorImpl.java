/*
 * Created on Oct 14, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.sap.tc.logging.messagedepot.impl;

import java.io.*;
import java.util.*;

import com.sap.tc.logging.messagedepot.*;

/**
 * @author I803971
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageAccessorImpl implements MessageAccessor {
	//$JL-EXC$
	private ResourceBundle resBundle_;

	/**
	 * Use
	 * {@link com.sap.tc.logging.messagedepot.MessageAccessorFactory#createMessageAccessor(Locale, File)}
	 * to create this class.
	 */
	public MessageAccessorImpl(Locale locale) {
		if (locale == null) {
			resBundle_ = null;
			return;
		}
		try {
			resBundle_ = ResourceBundle.getBundle("messages", locale);
		} catch (MissingResourceException ex) {
			resBundle_ = null;
		}
	}

	protected String getString(String key) {
		if (resBundle_ == null) {
			return null;
		}
		try {
			return resBundle_.getString(key);
		} catch (MissingResourceException ex) {
			return null;
		}
	}

	public LocalizedMessage getLocalizedMessage(MessageID messageID) {
		if (messageID == null || resBundle_ == null) {
			return null;
		}
		String longText = getString("MSG_" + messageID.getID() + "_LONGTXT");
		if (longText == null) {
			// If longText is null, then it means there no text for this message ID.
			return null;
		}
		// If  there is no shortText, that's ok. Just return null for shortText.
		String shortText = getString("MSG_" + messageID.getID() + "_SHORTTXT");
		return new LocalizedMessage(messageID, longText, shortText);
	}
}