/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: StringSubstringOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.ocl.examples.library.AbstractTernaryOperation;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * StringSubstringOperation realises the String::substring() library operation.
 * 
 * @since 3.1
 */
public class StringSubstringOperation extends AbstractTernaryOperation
{
	public static final StringSubstringOperation INSTANCE = new StringSubstringOperation();

	public Value evaluate(ValueFactory valueFactory, Value source, Value arg1, Value arg2) {
		String sourceString = source.asString();
		Integer startInteger = arg1.asInteger();
		Integer endInteger = arg2.asInteger();
		if ((sourceString != null) && (startInteger != null) && (endInteger != null)) {
			int size = sourceString.length();
			int lower = startInteger.intValue();
			int upper = endInteger.intValue();
			if ((0 < lower) && (lower <= upper) && (upper <= size))
				return valueFactory.stringValueOf(sourceString.substring(lower-1, upper));
		}			
		return null;
	}
}
