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
 * $Id: AbstractValue.java,v 1.3 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.StringValue;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractValue implements Value
{
	protected final ValueFactory valueFactory;

	protected AbstractValue(ValueFactory valueFactory) {
		this.valueFactory = valueFactory;
	}

	public BagValue asBagValue() throws InvalidValueException {
		throw new InvalidValueException("Bag Value Required", this);
	}

	public boolean asBoolean() throws InvalidValueException {
		throw new InvalidValueException("Boolean Value Required", this);
	}

	public BooleanValue asBooleanValue() throws InvalidValueException {
		throw new InvalidValueException("Boolean Value Required", this);
	}

	public CollectionValue asCollectionValue() throws InvalidValueException {
		throw new InvalidValueException("Collection Value Required", this);
	}

	public Double asDouble() throws InvalidValueException {
		throw new InvalidValueException("Double Value Required", this);
	}

	public Element asElement() {
		return null;
	}

	public Integer asInteger() throws InvalidValueException {
		throw new InvalidValueException("Integer Value Required", this);
	}

	public IntegerValue asIntegerValue() throws InvalidValueException {
		throw new InvalidValueException("Integer Value Required", this);
	}

	public OrderedCollectionValue asOrderedCollectionValue() throws InvalidValueException {
		throw new InvalidValueException("Ordered Collection Value Required", this);
	}

	public OrderedSetValue asOrderedSetValue() throws InvalidValueException {
		throw new InvalidValueException("OrderedSet Value Required", this);
	}

	public RealValue asRealValue() throws InvalidValueException {
		throw new InvalidValueException("Real Value Required", this);
	}

	public SequenceValue asSequenceValue() throws InvalidValueException {
		throw new InvalidValueException("Sequence Value Required", this);
	}

	public SetValue asSetValue() throws InvalidValueException {
		throw new InvalidValueException("Set Value Required", this);
	}

	public String asString() throws InvalidValueException {
		throw new InvalidValueException("String Value Required", this);
	}

	public StringValue asStringValue() throws InvalidValueException {
		throw new InvalidValueException("String Value Required", this);
	}

	public TypeValue asTypeValue() throws InvalidValueException {
		throw new InvalidValueException("Type Value Required", this);
	}

	public UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException {
		throw new InvalidValueException("Unique Collection Value Required", this);
	}
	
	public ValueFactory getValueFactory() {
		return valueFactory;
	}

	public CollectionValue isCollectionValue() {
		return null;
	}

	public boolean isFalse() {
		return false;
	}

	public IntegerValue isIntegerValue() {
		return null;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isNull() {
		return false;
	}

	public RealValue isRealValue() {
		return null;
	}

	public boolean isTrue() {
		return false;
	}

	public boolean isUndefined() {
		return false;
	}

	public boolean isUnlimited() {
		return false;
	}
	
	public boolean isUnlimitedNatural() {
		return false;
	}

	public String oclToString() {
		return toString();
	}

	public IntegerValue toIntegerValue() throws InvalidValueException {
		throw new InvalidValueException("Integer Value Required", this);
	}

	public RealValue toRealValue() throws InvalidValueException {
		throw new InvalidValueException("Real Value Required", this);
	}

	public void toString(StringBuffer s, int sizeLimit) {
		s.append(toString());
	}
}
