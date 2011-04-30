/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Stan Sutton (suttons@us.ibm.com) - initial API and implementation
*    based on usage proposed by E. D. Willink  (Eclipse bug report #245296)
*
*******************************************************************************/

package org.eclipse.imp.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class for recording limits on the number of errors, of various levels
 * of severity, that should be processed by a client such as a marker creator or
 * other form of error-message handler.
 * 
 * Developed to support org.eclipse.imp.builder.MarkerCreatorWithBatching.
 */
public class ProblemLimit
{
	// TODO:  Consider updating preliminary implementation
	
	Map<Integer, Integer> limitsBySeverity = new HashMap<Integer, Integer>();
	Map<Integer, String>  messagesBySeverity = new HashMap<Integer, String>();
	
	
	public String check(int severity, String message) {
		return message;
	}
	
	
	public void setLimit(int severity, int limit, String message) {
		if (severity < 0)
			throw new IllegalArgumentException("Given severity is less than 0--must be 0 or greater");
		if (limit < 0)
			throw new IllegalArgumentException("Given limit is less than 0--must be 0 or greater");
		if (message == null)
			throw new IllegalArgumentException("Given memssage is null; must not be null");
		
		limitsBySeverity.remove(severity);
		limitsBySeverity.put(severity, limit);
		
		messagesBySeverity.remove(severity);
		messagesBySeverity.put(severity, message);
	}
	
	
	public void clearLimit(int severity) {
		limitsBySeverity.remove(severity);
		messagesBySeverity.remove(severity);
	}
	
	
	public void clearAllLimits() {
		limitsBySeverity.clear();
		messagesBySeverity.clear();
	}
	
	
	public boolean isLimited(int severity) {
		return limitsBySeverity.containsKey(severity);
	}
	
	
	public int getLimit(int severity, int defaultLimit) {
		if (!isLimited(severity))
			return defaultLimit;
		else
			return limitsBySeverity.get(severity);
	}
	
	
	public String getMessage(int severity, String defaultMessage) {
		if (!isLimited(severity))
			return defaultMessage;
		else
			return messagesBySeverity.get(severity);
	}
	
	
	public static class LimitExceededException extends Exception {
		/*
		 * TODO:  treat this seriously, if warranted 
		 */
		private static final long serialVersionUID = 1L;

		LimitExceededException(String message) {
			super(message);
		}
	}
	
}
