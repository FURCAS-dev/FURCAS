/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: StringCharactersOperation.java,v 1.3 2011/02/21 08:37:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.StringValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OrderedSetSubOrderedSetOperation realises the OrderedSet::subOrderedSet() library operation.
 * 
 * @since 3.1
 */
public class StringCharactersOperation extends AbstractUnaryOperation
{
	public static final StringCharactersOperation INSTANCE = new StringCharactersOperation();

	public Value evaluate(ValueFactory valueFactory, Value sourceVal) throws InvalidValueException {
		String sourceString = sourceVal.asString();
		List<StringValue> results = new ArrayList<StringValue>(sourceString.length());
		for (int i = 0; i < sourceString.length(); i++) {
			String s = sourceString.substring(i, i+1);
			results.add(valueFactory.stringValueOf(s));
		}
		return valueFactory.createSequenceValue(results);
	}
}
