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
 * $Id: AbstractStringUnaryOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.string;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AbstractStringBinaryOperation dispatches a binary string library operation to
 * matching-type-specific call-backs.
 * 
 * @since 3.1
 */
public abstract class AbstractStringUnaryOperation extends AbstractUnaryOperation
{
	public Value evaluate(ValueFactory valueFactory, Value sourceVal) {
		if (sourceVal.isInvalid()) {
			return evaluateInvalid(valueFactory, sourceVal);
		}
		else if (sourceVal.isNull()) {
			return evaluateNull(valueFactory, sourceVal);
		}
		String sourceString = sourceVal.asString();
		if (sourceString == null) {
			return valueFactory.createInvalidValue("non-String source");
		}
		return evaluateString(valueFactory, sourceString);
	}
	
	/**
	 * Evaluate an operation for which the left is invalid.
	 * @param left argument
	 * @return result
	 */
	protected Value evaluateInvalid(ValueFactory valueFactory, Value left) {
		return null;
	}
	
	/**
	 * Evaluate an operation for which the left is null
	 * @param left argument
	 * @return result
	 */
	protected Value evaluateNull(ValueFactory valueFactory, Value left) {
		return valueFactory.createInvalidValue(left, null, "null-source", null);
	}
	
	/**
	 * Evaluate an operation for which left is a String.
	 * @param left argument
	 * @return result
	 */
	protected abstract Value evaluateString(ValueFactory valueFactory, String left);
}
