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
 * $Id: RealValueImpl.java,v 1.5 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class RealValueImpl extends AbstractValue implements RealValue
{
	private static final int MINIMUM_SCALE = Double.SIZE/2;		// Gives nearly twice the precision of Double

	protected static RealValue divideBigDecimal(ValueFactory valueFactory, BigDecimal left, BigDecimal right) throws InvalidValueException {
		try {
			if (right.signum() == 0) {
				return null;
			}
			int scale = Math.max(left.scale() - right.scale(), MINIMUM_SCALE);
			BigDecimal result = left.divide(right, scale, RoundingMode.HALF_EVEN);
			return valueFactory.realValueOf(result);
		} catch (ArithmeticException e) {
			throw new InvalidValueException(e);
		}
	}

	private final BigDecimal value;
	private Object integerValue = null;	// Lazily computed exact IntegerValue or Exception
	
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

	@Override
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

	public Value asValidValue() {
		return this;
	}

	public BigDecimal bigDecimalValue() {
		return value;
	}

	public int compareTo(NumericValue o) {
		try {
			RealValue that = o.toRealValue();
			return value.compareTo(that.bigDecimalValue());
		} catch (InvalidValueException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public RealValue divide(RealValue right) throws InvalidValueException {
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
			BigDecimal bigDecimalValue = ((IntegerValue)obj).bigDecimalValue();
			return (bigDecimalValue != null) && (value.compareTo(bigDecimalValue) == 0);
		}
/*		try {
			if (obj instanceof NumericValue) {
				RealValue thatValue = ((NumericValue) obj).toRealValue();
				if (thatValue != null) {
					BigDecimal bigDecimalValue = ((RealValue)thatValue).bigDecimalValue();
					return (bigDecimalValue != null) && (value.compareTo(bigDecimalValue) == 0);
				}
			}
		} catch (InvalidValueException e) {
			throw new IllegalArgumentException(e);
		} */
		return false;
	}

	public IntegerValue floor() {
		return valueFactory.integerValueOf(value.setScale(0, RoundingMode.FLOOR).toBigInteger());
	}

	protected Object getIntegerValue() {
		if (integerValue == null) {
			try {
				BigInteger intValue = value.toBigIntegerExact();
				integerValue = valueFactory.integerValueOf(intValue);
			}
			catch (ArithmeticException e) {
				integerValue = e;			
			}
		}
		return integerValue;
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return typeManager.getRealType();
	}

	@Override
	public int hashCode() {
		Object intValue = getIntegerValue();
		if (intValue instanceof IntegerValue) {
			return intValue.hashCode();
		} 
		else {
			return value.hashCode();
		}
	}

	@Override
	public RealValue isRealValue() {
		return this;
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

	@Override
	public IntegerValue toIntegerValue() throws InvalidValueException {
		Object intValue = getIntegerValue();
		if (integerValue instanceof Exception) {
			throw new InvalidValueException((Exception)intValue);			
		}
		else {
			return (IntegerValue) intValue;
		}
	}

	@Override
	public RealValue toRealValue() {
		return this;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
