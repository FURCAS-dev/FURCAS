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
 * $Id: NumericValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import java.math.BigDecimal;

import org.eclipse.ocl.examples.pivot.InvalidValueException;


public interface NumericValue extends Value, Comparable<NumericValue>
{
	NumericValue abs() throws InvalidValueException;
	BigDecimal bigDecimalValue();
	NumericValue negate() throws InvalidValueException;
	double doubleValue();
	int signum() throws InvalidValueException;
	IntegerValue toIntegerValue() throws InvalidValueException;
}
