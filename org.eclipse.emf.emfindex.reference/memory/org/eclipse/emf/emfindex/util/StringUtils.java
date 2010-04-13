/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.util;

/**
 * @author koehnlein
 * 
 */
public class StringUtils {

	public static String toStringNotNull(Object o) {
		if (o == null)
			return "null";
		String oAsString = o.toString();
		if (oAsString == null)
			return "null";
		return oAsString;
	}

	public static String concat(Object... objects) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Object object : objects) {
			stringBuilder.append(toStringNotNull(object));
		}
		return stringBuilder.toString();
	}

	public static boolean equalsNullSafe(String s0, String s1) {
		if (s0 == null)
			return s1 == null;
		return s0.equals(s1);
	}
}
