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
 * $Id: IntegerValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import java.math.BigInteger;

import org.eclipse.ocl.examples.pivot.InvalidValueException;

public interface IntegerValue extends NumericValue
{	
	BigInteger bigIntegerValue();
	IntegerValue add(IntegerValue right) throws InvalidValueException;
	IntegerValue div(IntegerValue right) throws InvalidValueException;
	RealValue divide(IntegerValue right) throws InvalidValueException;
	IntegerValue max(IntegerValue right) throws InvalidValueException;
	IntegerValue min(IntegerValue right) throws InvalidValueException;
	IntegerValue mod(IntegerValue right) throws InvalidValueException;
	IntegerValue multiply(IntegerValue right) throws InvalidValueException;
	IntegerValue negate() throws InvalidValueException;
	IntegerValue subtract(IntegerValue right) throws InvalidValueException;
}
