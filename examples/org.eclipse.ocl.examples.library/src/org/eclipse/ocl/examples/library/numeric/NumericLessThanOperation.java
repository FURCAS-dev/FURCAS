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
 * $Id: NumericLessThanOperation.java,v 1.2 2011/01/24 19:56:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.numeric;

import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;


/**
 * LessThanOperation realises the <() library operation.
 * 
 * @since 3.1
 */
public class NumericLessThanOperation extends AbstractNumericBinaryOperation
{
	public static final NumericLessThanOperation INSTANCE = new NumericLessThanOperation();

	@Override
	protected BooleanValue evaluateInteger(ValueFactory valueFactory, IntegerValue left, IntegerValue right) {
		return valueFactory.booleanValueOf(left.compareTo(right) < 0);
	}

	@Override
	protected BooleanValue evaluateReal(ValueFactory valueFactory, RealValue left, RealValue right) {
		return valueFactory.booleanValueOf(left.compareTo(right) < 0);
	}

	@Override
	protected BooleanValue evaluateUnlimited(ValueFactory valueFactory, Value left, Value right) {
		return valueFactory.booleanValueOf(!left.isUnlimited() && right.isUnlimited());
	}
}
