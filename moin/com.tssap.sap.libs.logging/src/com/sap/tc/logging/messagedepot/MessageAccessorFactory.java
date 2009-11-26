/*
 * Created on Oct 14, 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.sap.tc.logging.messagedepot;

import java.util.*;

import com.sap.tc.logging.messagedepot.impl.*;

/**
 * @author I803971
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageAccessorFactory {
	
	/**
	 * Create a {@link MessageAccessor} for Message retrieval.
	 */
	public static MessageAccessor createMessageAccessor() {
		return createMessageAccessor(null);
	}

	/**
	 * Create a {@link MessageAccessor} for Message retrieval.
	 * 
	 * @param locale locale of the client. The resource bundle messages_*.properties
	 * needs to be in the classpath. If the resource bundle is in a jar, the jar
	 * needs to be in the classpath and the resource bundle(s) needs to be in the
	 * base directory of the jar file.
	 */
	public static MessageAccessor createMessageAccessor(Locale locale) {
		
		return new MessageAccessorImpl(locale);
	}
}