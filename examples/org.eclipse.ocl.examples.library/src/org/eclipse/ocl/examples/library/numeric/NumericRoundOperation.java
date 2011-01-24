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
 * $Id: NumericRoundOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

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
	protected Value evaluateReal(RealValue left) {
		return left.round();
	}
}
