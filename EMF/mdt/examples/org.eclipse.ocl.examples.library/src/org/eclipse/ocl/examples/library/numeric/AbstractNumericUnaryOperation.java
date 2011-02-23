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
 * $Id: AbstractNumericUnaryOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * AbstractNumericUnaryOperation dispatches a unary library operation to
 * matching-type-specific call-backs.
 * 
 * @since 3.1
 */
public abstract class AbstractNumericUnaryOperation extends AbstractUnaryOperation
{
	public Value evaluate(ValueFactory valueFactory, Value sourceVal) throws InvalidValueException {
		if (sourceVal.isUnlimited()) {
			return evaluateUnlimited(sourceVal);			
		}
		IntegerValue integerValue = sourceVal.isIntegerValue(); 
		if (integerValue != null) {
			return evaluateInteger(integerValue);			
		}
		RealValue realValue = sourceVal.toRealValue(); 
		return evaluateReal(realValue);
	}

	protected Value evaluateReal(RealValue left) throws InvalidValueException {
		return evaluateNumeric(left);
	}
	
	protected Value evaluateInteger(IntegerValue left) throws InvalidValueException {
		return evaluateNumeric(left);
	}
	
	protected Value evaluateUnlimited(Object left) throws InvalidValueException {
		return null;
	}
	
	/**
	 * Return the result of evaluating the operation on left. 
	 * A null return or an exception may be used for invalid.
	 * @throws InvalidValueException 
	 */
	protected <T extends NumericValue> Value evaluateNumeric(T left) throws InvalidValueException {
		return null;
	}
}
