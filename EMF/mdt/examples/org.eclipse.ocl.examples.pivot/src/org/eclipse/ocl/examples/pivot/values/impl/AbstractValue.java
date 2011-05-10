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
 * $Id: AbstractValue.java,v 1.5 2011/05/07 16:41:18 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.messages.EvaluatorMessages;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.ElementValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.ObjectValue;
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
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Bag");
	}

	public boolean asBoolean() throws InvalidValueException {
		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Boolean");
		return false;
	}

	public BooleanValue asBooleanValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Boolean");
	}

	public CollectionValue asCollectionValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Collection");
	}

	public Double asDouble() throws InvalidValueException {
		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Double");
		return null;
	}

	public Element asElement() {
		return null;
	}

	public ElementValue<?> asElementValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Element");
	}

	public Integer asInteger() throws InvalidValueException {
		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Integer");
		return null;
	}

	public IntegerValue asIntegerValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Integer");
	}

	public ObjectValue asObjectValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Object");
	}

	public OrderedCollectionValue asOrderedCollectionValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Ordered Collection");
	}

	public OrderedSetValue asOrderedSetValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "OrderedSet");
	}

	public RealValue asRealValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Real");
	}

	public SequenceValue asSequenceValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Sequence");
	}

	public SetValue asSetValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Set");
	}

	public String asString() throws InvalidValueException {
		valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "String");
		return null;
	}

	public StringValue asStringValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "String");
	}

	public TypeValue asTypeValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Type");
	}

	public UniqueCollectionValue asUniqueCollectionValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.TypedValueRequired, "Unique Collection");
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
		return valueFactory.throwInvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Integer");
	}

	public RealValue toRealValue() throws InvalidValueException {
		return valueFactory.throwInvalidValueException(EvaluatorMessages.ConvertibleValueRequired, "Real");
	}

	public void toString(StringBuffer s, int sizeLimit) {
		s.append(toString());
	}
}
