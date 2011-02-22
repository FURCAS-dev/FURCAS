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
 * $Id: NumericRoundOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;

/**
 * RoundOperation realises the round() library operation.
 * 
 * @since 3.1
 */
public class NumericRoundOperation extends AbstractNumericUnaryOperation
{
	public static final NumericRoundOperation INSTANCE = new NumericRoundOperation();

	@Override
	protected Value evaluateInteger(IntegerValue left) {
		return left;
	}
	
	@Override
	protected Value evaluateReal(RealValue left) throws InvalidValueException {
		return left.round();
	}
}
