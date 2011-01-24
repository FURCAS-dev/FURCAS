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
 * $Id: AbstractUndefinedValue.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.NullValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.StringValue;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractUndefinedValue implements NullValue
{	
	protected final ValueFactory valueFactory;
	
	protected AbstractUndefinedValue(ValueFactory valueFactory) {
		this.valueFactory = valueFactory;
	}

	public InvalidValue abs() {
		return toInvalidValue();
	}

	public InvalidValue add(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue add(RealValue right) {
		return toInvalidValue();
	}

	public BooleanValue asBooleanValue() {
		return toInvalidValue();
	}

	public BooleanValue asFalse() {
		return this;
	}

	public Integer asInteger() {
		return null;
	}

	public IntegerValue asIntegerValue() {
		return toInvalidValue();
	}

	public Object asObject() {
		return null;
	}

	public RealValue asRealValue() {
		return toInvalidValue();
	}

	public String asString() {
		return null;
	}

	public StringValue asStringValue() {
		return this;
	}

	public BooleanValue asTrue() {
		return this;
	}

	public TypeValue asTypeValue() {
		return null;
	}

	public BigDecimal bigDecimalValue() {
		return null;
	}

	public BigInteger bigIntegerValue() {
		return null;
	}

	public int compareTo(NumericValue o) {
		throw new UnsupportedOperationException("AbstractUndefinedValue.compareTo");
	}

	public InvalidValue div(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue divide(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue divide(RealValue right) {
		return toInvalidValue();
	}

	public double doubleValue() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public InvalidValue floor() {
		return toInvalidValue();
	}

	public Type getElement() {
		return null;
	}

	public Object getObject() {
		return null;
	}

	public Type getType() {
		return null;
	}

	public ValueFactory getValueFactory() {
		return valueFactory;
	}

	public boolean isFalse() {
		return false;
	}

	public boolean isTrue() {
		return false;
	}

	public boolean isUndefined() {
		return true;
	}

	public boolean isUnlimited() {
		return false;
	}

	public boolean isUnlimitedNatural() {
		return false;
	}

	public InvalidValue max(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue max(RealValue right) {
		return toInvalidValue();
	}

	public InvalidValue min(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue min(RealValue right) {
		return toInvalidValue();
	}

	public InvalidValue mod(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue multiply(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue multiply(RealValue right) {
		return toInvalidValue();
	}

	public InvalidValue negate() {
		return toInvalidValue();
	}

	public InvalidValue round() {
		return toInvalidValue();
	}

	public int signum() {
		throw new UnsupportedOperationException("InvalidValue.compareTo");
	}

	public InvalidValue subtract(IntegerValue right) {
		return toInvalidValue();
	}

	public InvalidValue subtract(RealValue right) {
		return toInvalidValue();
	}

	public IntegerValue toIntegerValue() {
		return this;
	}

	public RealValue toRealValue() {
		return this;
	}

	public void toString(StringBuffer s, int sizeLimit) {
		s.append(toString());
	}

//	public <T extends NumericValue> T toValue(Class<T> numericClass) {
//		throw new UnsupportedOperationException("AbstractUndefinedValue.toValue");
//	}
}
