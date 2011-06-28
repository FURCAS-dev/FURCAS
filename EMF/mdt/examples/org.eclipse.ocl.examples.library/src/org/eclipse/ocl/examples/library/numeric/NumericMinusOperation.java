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
 * $Id: NumericMinusOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;


/**
 * MinusOperation realises the -() library operation.
 * 
 * @since 3.1
 */
@Deprecated
public class NumericMinusOperation extends AbstractNumericBinaryOperation
{
	public static final NumericMinusOperation INSTANCE = new NumericMinusOperation();

	@Override
	protected Value evaluateInteger(ValueFactory valueFactory, IntegerValue left, IntegerValue right) throws InvalidValueException {
		return left.subtract(right);
	}

	@Override
	protected Value evaluateReal(ValueFactory valueFactory, RealValue left, RealValue right) throws InvalidValueException {
		return left.subtract(right);
	}
}
