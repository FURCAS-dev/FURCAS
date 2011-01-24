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
 * $Id: IntegerValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
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

	public IntegerValue add(IntegerValue right) {
		return valueFactory.integerValueOf(value.add(right.bigIntegerValue()));
	}
	
	@Override
	public Integer asInteger() {
		return value.intValue();
	}

	@Override
	public IntegerValue asIntegerValue() {
		return this;
	}

	public Object asObject() {
		return value;
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

	public IntegerValue div(IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			return null;
		}
		return valueFactory.integerValueOf(value.divide(right.bigIntegerValue()));
	}

	public RealValue divide(IntegerValue right) {
		BigDecimal bigLeft = bigDecimalValue();
		BigDecimal bigRight = right.bigDecimalValue();
		return RealValueImpl.divideBigDecimal(valueFactory, bigLeft, bigRight);
	}

	public double doubleValue() {
		return value.doubleValue();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NumericValue) {
			obj = ((NumericValue)obj).toIntegerValue();
		}
		if (!(obj instanceof IntegerValue)) {
			return false;
		}
		return value.equals(((IntegerValue)obj).bigIntegerValue());
	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return value.signum() >= 0 ? standardLibrary.getUnlimitedNaturalType() : standardLibrary.getIntegerType();
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean isUnlimitedNatural() {
		return value.signum() >= 0;
	}

	public IntegerValue max(IntegerValue right) {
		return valueFactory.integerValueOf(value.max(right.bigIntegerValue()));
	}

	public IntegerValue min(IntegerValue right) {
		return valueFactory.integerValueOf(value.min(right.bigIntegerValue()));
	}

	public IntegerValue mod(IntegerValue right) {
		if (right.bigIntegerValue().signum() == 0) {
			return null;
		}
		return valueFactory.integerValueOf(value.remainder(right.bigIntegerValue()));
	}

	public IntegerValue multiply(IntegerValue right) {
		return valueFactory.integerValueOf(value.multiply(right.bigIntegerValue()));
	}

	public IntegerValue negate() {
		return valueFactory.integerValueOf(value.negate());
	}

	public int signum() {
		return value.signum();
	}

	public IntegerValue subtract(IntegerValue right) {
		return valueFactory.integerValueOf(value.subtract(right.bigIntegerValue()));
	}

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

//	public <T extends NumericValue> T toValue(Class<T> numericClass) {
//		if (numericClass.isAssignableFrom(IntegerValue.class)) {
//			return (T) this;
//		}
//		if (numericClass.isAssignableFrom(RealValue.class)) {
//			return (T) toRealValue();
//		}
//		return (T) ValueUtils.createInvalidValue(numericClass, null, "unsupported IntegerValue", null);
//	}
}
