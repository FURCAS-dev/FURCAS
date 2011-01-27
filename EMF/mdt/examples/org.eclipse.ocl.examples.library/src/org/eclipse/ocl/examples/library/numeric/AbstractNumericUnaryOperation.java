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
 * $Id: AbstractNumericUnaryOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.library.AbstractUnaryOperation;
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
	public Value evaluate(ValueFactory valueFactory, Value sourceVal) {
		if (sourceVal.isUnlimited()) {
			return evaluateUnlimited(sourceVal);			
		}
		if (!sourceVal.isUndefined()) {
			IntegerValue integerValue = sourceVal.asIntegerValue(); 
			if (integerValue != null) {
				return evaluateInteger(integerValue);			
			}
			RealValue realValue = sourceVal.asRealValue(); 
			if (realValue != null) {
				return evaluateReal(realValue);
			}
		}
		return null;
	}

	protected Value evaluateReal(RealValue left) {
		return evaluateNumeric(left);
	}
	
	protected Value evaluateInteger(IntegerValue left) {
		return evaluateNumeric(left);
	}
	
	protected Value evaluateUnlimited(Object left) {
		return null;
	}
	
	/**
	 * Return the result of evaluating the operation on left. 
	 * A null return or an exception may be used for invalid.
	 */
	protected <T extends NumericValue> Value evaluateNumeric(T left) {
		return null;
	}
}
