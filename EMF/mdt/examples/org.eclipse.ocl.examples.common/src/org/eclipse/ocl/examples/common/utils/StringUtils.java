/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: StringUtils.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.utils;

import java.util.List;


public class StringUtils
{	
	/**
	 * Return a composite string comprising each element od strings separated by separator.
	 * A null strings is returned as a null string. An empty strings as an empty string.
	 * 
	 * @param strings strings to be spliced
	 * @param separator between elements
	 * @return spliced string
	 */
	public static String splice(List<String> strings, String separator) {
		if (strings == null)
			return null;
		int iMax = strings.size();
		if (iMax <= 0)
			return "";
		if (iMax == 1)
			return strings.get(0);
		StringBuffer s = new StringBuffer();
		s.append(strings.get(0));
		for (int i = 1; i < iMax; i++) {
			s.append(separator);
			s.append(strings.get(i));
		}
		return s.toString();
	}
}
