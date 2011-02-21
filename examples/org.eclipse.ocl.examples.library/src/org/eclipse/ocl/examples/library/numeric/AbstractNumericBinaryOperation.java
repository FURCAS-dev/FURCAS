/**
 * <copyright>
 *
 * Copyright (c) 2009,2011 E.D.Willink and others.
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
 * $Id: AbstractNumericBinaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AbstractNumericBinaryOperation dispatches a binary library operation to
 * matching-type-specific call-backs.
 * 
 * @since 3.1
 */
public abstract class AbstractNumericBinaryOperation extends AbstractBinaryOperation
{
	public Value evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		if (left.isUnlimited() || right.isUnlimited()) {
			return evaluateUnlimited(valueFactory, left, right);
		}
		IntegerValue leftInteger = left.isIntegerValue();
		IntegerValue rightInteger = right.isIntegerValue();
		if ((leftInteger != null) && (rightInteger != null)) {
			return evaluateInteger(valueFactory, leftInteger, rightInteger);
		}
		RealValue leftReal = left.toRealValue();
		RealValue rightReal = right.toRealValue();
		return evaluateReal(valueFactory, leftReal, rightReal);
	}
	
	/**
	 * Evaluate an operation for which both left and right are Integer.
	 * @param left argument
	 * @param right argument
	 * @return result
	 * @throws InvalidValueException 
	 */
	protected Value evaluateInteger(ValueFactory valueFactory, IntegerValue left, IntegerValue right) throws InvalidValueException {
		return evaluate(valueFactory, left, right);
	}

	/**
	 * Evaluate an operation for which both left and right are Real.
	 * @param left argument
	 * @param right argument
	 * @return result
	 * @throws InvalidValueException 
	 */
	protected Value evaluateReal(ValueFactory valueFactory, RealValue left, RealValue right) throws InvalidValueException {
		return evaluate(valueFactory, left, right);
	}
	
	/**
	 * Evaluate an operation for which at least one of left and right are unlimited
	 * and for which neither left nor right are invalid or null.
	 * @param left argument
	 * @param right argument
	 * @return result
	 */
	protected Value evaluateUnlimited(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		return null;
	}
	
	/**
	 * Return the result of evaluating the operation on left and right which are both
	 * of the same derived Number type. 
	 * A null return or an exception may be used for invalid.
	 */
	protected <T extends Number & Comparable<T>> Object evaluate(ValueFactory valueFactory, T left, T right) throws InvalidValueException {
		return null;
	}
}
