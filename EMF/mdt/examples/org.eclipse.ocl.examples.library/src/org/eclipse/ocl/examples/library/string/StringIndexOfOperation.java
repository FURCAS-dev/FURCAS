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
 * $Id: StringIndexOfOperation.java,v 1.4 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
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

	public Value evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		String leftString = left.asString();
		String rightString = right.asString();
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
