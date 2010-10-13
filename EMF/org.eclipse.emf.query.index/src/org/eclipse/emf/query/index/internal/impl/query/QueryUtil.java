/*******************************************************************************
 * Copyright (c) 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query.index.internal.impl.query;
/**
 * @author Martin Strenge - Initial API and implementation
 * @author Bernd Kolb - Initial API and implementation
 * 
 */
public class QueryUtil {

	public static final char WILDCARD = '*';

	public static boolean matchesGlobbing(String testString, String pattern) {
		if (pattern == null)
			return true;
		if (testString == null || "".equals(pattern))
			return false;
		int patternLength = pattern.length();
		if (pattern.charAt(0) == WILDCARD) {
			if (patternLength > 1 && pattern.charAt(patternLength - 1) == WILDCARD) {
				return testString.contains(pattern.substring(1, patternLength - 2));
			}
			return testString.endsWith(pattern.substring(1));
		}
		if (pattern.charAt(patternLength - 1) == WILDCARD) {
			return testString.startsWith(pattern.substring(0, patternLength - 1));
		}
		return testString.equals(pattern);
	}
}
