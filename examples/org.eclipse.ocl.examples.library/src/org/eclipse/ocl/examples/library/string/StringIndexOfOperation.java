/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: StringIndexOfOperation.java,v 1.3 2011/02/08 17:47:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * OrderedSetSubOrderedSetOperation realises the OrderedSet::subOrderedSet() library operation.
 * 
 * @since 3.1
 */
public class StringIndexOfOperation extends AbstractBinaryOperation
{
	public static final StringIndexOfOperation INSTANCE = new StringIndexOfOperation();

	public Value evaluate(ValueFactory valueFactory, Value left, Value right) {
		String leftString = left.asString();
		if (leftString == null) {
			return valueFactory.createInvalidValue(left, null, "non-string indexOf source", null);
		}
		String rightString = right.asString();
		if (rightString == null) {
			return valueFactory.createInvalidValue(right, null, "non-string indexOf argument", null);
		}
		if (leftString.length() <= 0) {
			return valueFactory.integerValueOf(0);
		}
		else if (rightString.length() <= 0) {
			return valueFactory.integerValueOf(1);
		}
		else {
			int index = leftString.indexOf(rightString);
			if (index >= 0) {
				return valueFactory.integerValueOf(index+1);
			}
			else {
				return valueFactory.integerValueOf(0);
			}
		}
	}
}
