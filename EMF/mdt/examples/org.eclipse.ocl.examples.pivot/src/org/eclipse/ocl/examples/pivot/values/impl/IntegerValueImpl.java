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
 * $Id: IntegerValueImpl.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;


public class IntegerValueImpl extends AbstractValue implements IntegerValue
{
	private final BigInteger value;
	
	public IntegerValueImpl(ValueFactory valueFactory, long value) {
		this(valueFactory, BigInteger.valueOf(value));
	}

	public IntegerValueImpl(ValueFactory valueFactory, BigInteger value) {
		super(valueFactory);
		this.value = value;
		assert value != null;
	}

	public IntegerValue abs() {
		return valueFactory.integerValueOf(value.abs());
	}

	public IntegerValue add(IntegerValue right) throws InvalidValueException {
		return valueFactory.integerValueOf(value.add(right.bigIntegerValue()));
	}

	@Override
	public Double asDouble() {
		return value.doubleValue();
	}
	
	@Override
	public Integer asInteger() {
		return value.intValue();	// FIXME throw if out of range
	}

	@Override
	public IntegerValue asIntegerValue() {
		return this;
	}

	public Object asObject() {
		return value;
	}

	public Value asValidValue() {
		return this;
	}

	public BigDecimal bigDecimalValue() {
		return new BigDecimal(value);
	}

	public BigInteger bigIntegerValue() {
		return value;
	}

	public int compareTo(NumericValue o) {
		if (o instanceof IntegerValue) {
			return value.compareTo(((IntegerValue)o).bigIntegerValue());
		}
		else {
			return Double.compare(doubleValue(), o.doubleValue());
		}
	}

	public IntegerValue div(IntegerValue right) throws InvalidValueException {
		if (right.bigIntegerValue().signum() == 0) {
			return null;
		}
		return valueFactory.integerValueOf(value.divide(right.bigIntegerValue()));
	}

	public RealValue divide(IntegerValue right) throws InvalidValueException {
		BigDecimal bigLeft = bigDecimalValue();
		BigDecimal bigRight = right.bigDecimalValue();
		return RealValueImpl.divideBigDecimal(valueFactory, bigLeft, bigRight);
	}

	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IntegerValue) {
			BigInteger bigIntegerValue = ((IntegerValue)obj).bigIntegerValue();
			return (bigIntegerValue != null) && (value.compareTo(bigIntegerValue) == 0);
		}
		if (obj instanceof RealValue) {
			BigDecimal bigDecimalValue = ((RealValue)obj).bigDecimalValue();
			return (bigDecimalValue != null) && (bigDecimalValue().compareTo(bigDecimalValue) == 0);
		}
/*		if (obj instanceof NumericValue) {
			try {
				obj = ((NumericValue)obj).toIntegerValue();
				if (obj instanceof IntegerValue) {
					return value.equals(((IntegerValue)obj).bigIntegerValue());
				}
			} catch (InvalidValueException e) {
				throw new IllegalArgumentException(e);
			}
		} */
		return false;
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return value.signum() >= 0 ? typeManager.getUnlimitedNaturalType() : typeManager.getIntegerType();
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	public int intValue() {
		return value.intValue();	// FIXME throw if out of range
	}

	@Override
	public IntegerValue isIntegerValue() {
		return this;
	}

	@Override
	public boolean isUnlimitedNatural() {
		return value.signum() >= 0;
	}

	public IntegerValue max(IntegerValue right) throws InvalidValueException {
		return valueFactory.integerValueOf(value.max(right.bigIntegerValue()));
	}

	public IntegerValue min(IntegerValue right) throws InvalidValueException {
		return valueFactory.integerValueOf(value.min(right.bigIntegerValue()));
	}

	public IntegerValue mod(IntegerValue right) throws InvalidValueException {
		if (right.bigIntegerValue().signum() == 0) {
			return null;
		}
		return valueFactory.integerValueOf(value.remainder(right.bigIntegerValue()));
	}

	public IntegerValue multiply(IntegerValue right) throws InvalidValueException {
		return valueFactory.integerValueOf(value.multiply(right.bigIntegerValue()));
	}

	public IntegerValue negate() {
		return valueFactory.integerValueOf(value.negate());
	}

	public int signum() {
		return value.signum();
	}

	public IntegerValue subtract(IntegerValue right) throws InvalidValueException {
		return valueFactory.integerValueOf(value.subtract(right.bigIntegerValue()));
	}

	@Override
	public IntegerValue toIntegerValue() {
		return this;
	}

	@Override
	public RealValue toRealValue() {
		return valueFactory.realValueOf(this);
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
