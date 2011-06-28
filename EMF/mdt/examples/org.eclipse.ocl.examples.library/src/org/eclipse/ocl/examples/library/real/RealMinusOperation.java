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
 * $Id: NumericPlusOperation.java,v 1.3 2011/02/21 08:37:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.library.real;

import org.eclipse.ocl.examples.library.AbstractBinaryOperation;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

/**
 * RealMinusOperation realizes the Real::-() library operation.
 * 
 * @since 3.1
 */
public class RealMinusOperation extends AbstractBinaryOperation
{
	public static final RealMinusOperation INSTANCE = new RealMinusOperation();

	public Value evaluate(ValueFactory valueFactory, Value left, Value right) throws InvalidValueException {
		RealValue leftValue = left.toRealValue();
		RealValue rightValue = right.toRealValue();
		if ((leftValue != null) && (rightValue != null)) {
			return leftValue.subtract(rightValue);
		}
		return null;
	}
}
