/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: RealValueImpl.java,v 1.3 2011/01/30 11:17:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class RealValueImpl extends AbstractValue implements RealValue
{
	private static final int MINIMUM_SCALE = Double.SIZE/2;		// Gives nearly twice the precision of Double

	protected static RealValue divideBigDecimal(ValueFactory valueFactory, BigDecimal left, BigDecimal right) {
		try {
			if (right.signum() == 0) {
				return null;
			}
			int scale = Math.max(left.scale() - right.scale(), MINIMUM_SCALE);
			BigDecimal result = left.divide(right, scale, RoundingMode.HALF_EVEN);
			return valueFactory.realValueOf(result);
		} catch (ArithmeticException e) {
			return valueFactory.createInvalidValue(null, null, "Divide failure", e);
		}
	}

	private final BigDecimal value;
	private IntegerValue integerValue = null;	// Lazily computed exact IntegerValue or InvalidValue
	
	public RealValueImpl(ValueFactory valueFactory, double value) {
		this(valueFactory, BigDecimal.valueOf(value));
	}

	public RealValueImpl(ValueFactory valueFactory, BigDecimal value) {
		super(valueFactory);
		this.value = value;
		assert value != null;
	}

	public RealValue abs() {
		return valueFactory.realValueOf(value.abs());
	}

	public RealValue add(RealValue right) {
		return valueFactory.realValueOf(value.add(right.bigDecimalValue()));
	}

	public Double asDouble() {
		return value.doubleValue();
	}

	public Object asObject() {
		return value;
	}

	@Override
	public RealValue asRealValue() {
		return this;
	}

	public BigDecimal bigDecimalValue() {
		return value;
	}

	public int compareTo(NumericValue o) {
		RealValue that = o.toRealValue();
		if (that instanceof RealValue) {
			return value.compareTo(((RealValue)that).bigDecimalValue());
		}
		else {
			return Double.compare(doubleValue(), o.doubleValue());
		}
	}

	public RealValue divide(RealValue right) {
		return divideBigDecimal(valueFactory, value, right.bigDecimalValue());
	}

	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RealValue) {
			BigDecimal bigDecimalValue = ((RealValue)obj).bigDecimalValue();
			return (bigDecimalValue != null) && (value.compareTo(bigDecimalValue) == 0);
		}
		if (obj instanceof IntegerValue) {
			return toIntegerValue().equals(obj);
		}
		if (obj instanceof NumericValue) {
			RealValue thatValue = ((NumericValue) obj).toRealValue();
			if (thatValue != null) {
				BigDecimal bigDecimalValue = ((RealValue)thatValue).bigDecimalValue();
				return (bigDecimalValue != null) && (value.compareTo(bigDecimalValue) == 0);
			}
		}
		return false;
	}

	public IntegerValue floor() {
		return valueFactory.integerValueOf(value.setScale(0, RoundingMode.FLOOR).toBigInteger());
	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return standardLibrary.getRealType();
	}

	@Override
	public int hashCode() {
		IntegerValue intValue = toIntegerValue();
		return intValue.hashCode();
	}

	public RealValue max(RealValue right) {
		return valueFactory.realValueOf(value.max(right.bigDecimalValue()));
	}

	public RealValue min(RealValue right) {
		return valueFactory.realValueOf(value.min(right.bigDecimalValue()));
	}

	public RealValue multiply(RealValue right) {
		return valueFactory.realValueOf(value.multiply(right.bigDecimalValue()));
	}

	public RealValue negate() {
		return valueFactory.realValueOf(value.negate());
	}
	
	public IntegerValue round() {
		BigDecimal rounded;
		if (value.signum() >= 0) {
			rounded = value.setScale(0, RoundingMode.HALF_UP);		// functions as HALF_AWAY
		}
		else {
			rounded = value.negate().setScale(0, RoundingMode.HALF_DOWN).negate();
		}
		return valueFactory.integerValueOf(rounded.toBigInteger());
	}

	public int signum() {
		return value.signum();
	}

	public RealValue subtract(RealValue right) {
		return valueFactory.realValueOf(value.subtract(right.bigDecimalValue()));
	}

	public IntegerValue toIntegerValue() {
		if (integerValue == null) {
			try {
				BigInteger intValue = value.toBigIntegerExact();
				integerValue = valueFactory.integerValueOf(intValue);
			}
			catch (ArithmeticException e) {
				integerValue = valueFactory.createInvalidValue(this, null, "not integer", e);			
			}
		}
		return integerValue;
	}

	@Override
	public RealValue toRealValue() {
		return this;
	}

	@Override
	public String toString() {
		return value.toString();
	}

//	public <T extends NumericValue> T toValue(Class<T> numericClass) {
//		if (numericClass.isAssignableFrom(RealValue.class)) {
//			return (T) this;
//		}
//		if (numericClass.isAssignableFrom(IntegerValue.class)) {
//			return (T) toIntegerValue();
//		}
//		return (T) ValueUtils.createInvalidValue(numericClass, null, "unsupported RealValue", null);
//	}
}
