/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: ValueFactoryImpl.java,v 1.3 2011/01/30 11:17:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.examples.pivot.values.Bag;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.ElementValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.NullValue;
import org.eclipse.ocl.examples.pivot.values.NumericValue;
import org.eclipse.ocl.examples.pivot.values.ObjectValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.StringValue;
import org.eclipse.ocl.examples.pivot.values.UnlimitedValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class ValueFactoryImpl implements ValueFactory
{
	private static final String maxLongValue = Long.toString(Long.MAX_VALUE);
	private static final int maxLongSize = maxLongValue.length();	
	
	public final BagValue emptyBagValue = new BagValueImpl(this);
	public final OrderedSetValue emptyOrderedSetValue = new OrderedSetValueImpl(this);
	public final SequenceValue emptySequenceValue = new SequenceValueImpl(this);	
	public final SetValue emptySetValue = new SetValueImpl(this);
	public final BooleanValue falseValue = new BooleanValueImpl(this, false); 
	public final NullValue nullValue = new NullValueImpl(this); 
	public final BooleanValue trueValue = new BooleanValueImpl(this, true); 
	public final UnlimitedValue unlimitedValue = new UnlimitedValueImpl(this); 
	public final NumericValue zeroValue = integerValueOf(0);

	protected final String name;
	
	public ValueFactoryImpl(String name) {
		this.name = name;
	}

	public BooleanValue booleanValueOf(boolean value) {
		return value ? trueValue : falseValue;
	}

    public BagValue createBagOf(Object... objects) {
    	Bag<Value> collection = new BagImpl<Value>();
    	if (objects != null) {
    		for (Object object : objects) {
    			collection.add(valueOf(object));
    		}
    	}
    	return createBagValue(collection);
    }
	
	public BagValue createBagValue(Value... values) {
		if (!isValid(values)) {
			return createInvalidValue("bag-of-invalid");
		}
		return new BagValueImpl(this, values);
	}

	public BagValue createBagValue(Bag<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("bag-of-invalid");
		}
		return new BagValueImpl(this, values);
	}

	public BagValue createBagValue(Collection<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("bag-of-invalid");
		}
		return new BagValueImpl(this, values);
	}
    
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified ordering and uniqueness.
     * 
	 * @param isOrdered the required collection ordering
	 * @param isUnique the required collection uniqueness
	 * @param values the required collection contents
	 * @return the new collection
	 * @since 3.1
	 */
	public CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, Value... values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(values);
			}
			else {
				return createSequenceValue(values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(values);
			}
			else {
				return createBagValue(values);
			}
		}
	}

    
	/**
	 * Creates a new OCL <tt>Collection</tt> of the specified ordering and uniqueness.
     * 
	 * @param isOrdered the required collection ordering
	 * @param isUnique the required collection uniqueness
	 * @param values the required collection contents
	 * @return the new collection
	 * @since 3.1
	 */
	public CollectionValue createCollectionValue(boolean isOrdered, boolean isUnique, Collection<Value> values) {
		if (isOrdered) {
			if (isUnique) {
				return createOrderedSetValue(values);
			}
			else {
				return createSequenceValue(values);
			}
		}
		else {
			if (isUnique) {
				return createSetValue(values);
			}
			else {
				return createBagValue(values);
			}
		}
	}
	
	public CollectionValue createCollectionValue(CollectionKind kind, Value... values) {
		switch (kind) {
			case BAG: return createBagValue(values);
			case ORDERED_SET: return createOrderedSetValue(values);
			case SEQUENCE: return createSequenceValue(values);
			case SET: return createSetValue(values);
		}
		String message = OCLMessages.bind(OCLMessages.OCLCollectionKindNotImpl_ERROR_, kind);
		IllegalArgumentException error = new IllegalArgumentException(message);
		PivotPlugin.throwing(ValueFactoryImpl.class, "createNewCollection", error);//$NON-NLS-1$
		throw error;
	}

	public CollectionValue createCollectionValue(CollectionKind kind, Collection<Value> values) {
		switch (kind) {
			case BAG: return createBagValue(values);
			case ORDERED_SET: return createOrderedSetValue(values);
			case SEQUENCE: return createSequenceValue(values);
			case SET: return createSetValue(values);
		}
		String message = OCLMessages.bind(OCLMessages.OCLCollectionKindNotImpl_ERROR_, kind);
		IllegalArgumentException error = new IllegalArgumentException(message);
		PivotPlugin.throwing(ValueFactoryImpl.class, "createNewCollection", error);//$NON-NLS-1$
		throw error;
	}

	
	public <E extends Element> ElementValue<E> createElementValue(E element) {
		return new ElementValueImpl<E>(this, element);
	}

	public InvalidValue createInvalidValue(String reason) {
		return new InvalidValueImpl(this, null, null, reason, null);
	}

	public InvalidValue createInvalidValue(Object object, OclExpression expression, String reason, Throwable throwable) {
		return new InvalidValueImpl(this, object, expression, reason, throwable);
	}

	public ObjectValue createObjectValue(Object object) {
		return new ObjectValueImpl(this, object);
	}

    public OrderedSetValue createOrderedSetOf(Object... objects) {
    	LinkedHashSet<Value> collection = new LinkedHashSet<Value>();
    	if (objects != null) {
    		for (Object object : objects) {
    			collection.add(valueOf(object));
    		}
    	}
    	return createOrderedSetValue(collection);
    }

	public OrderedSetValue createOrderedSetValue(Value... values) {
		if (!isValid(values)) {
			return createInvalidValue("ordered-set-of-invalid");
		}
		return new OrderedSetValueImpl(this, values);
	}

	public OrderedSetValue createOrderedSetValue(LinkedHashSet<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("ordered-set-of-invalid");
		}
		return new OrderedSetValueImpl(this, values);
	}

	public OrderedSetValue createOrderedSetValue(Collection<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("ordered-set-of-invalid");
		}
		return new OrderedSetValueImpl(this, values);
	}

    public SequenceValue createSequenceOf(Object... objects) {
    	List<Value> collection = new ArrayList<Value>();
    	if (objects != null) {
    		for (Object object : objects) {
    			collection.add(valueOf(object));
    		}
    	}
    	return createSequenceValue(collection);
    }

	public SequenceValue createSequenceValue(Value... values) {
		if (!isValid(values)) {
			return createInvalidValue("sequence-of-invalid");
		}
		return new SequenceValueImpl(this, values);
	}

	public SequenceValue createSequenceValue(List<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("sequence-of-invalid");
		}
		return new SequenceValueImpl(this, values);
	}

	public SequenceValue createSequenceValue(Collection<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("sequence-of-invalid");
		}
		return new SequenceValueImpl(this, values);
	}

    public SetValue createSetOf(Object... objects) {
    	Set<Value> collection = new HashSet<Value>();
    	if (objects != null) {
    		for (Object object : objects) {
    			collection.add(valueOf(object));
    		}
    	}
    	return createSetValue(collection);
    }

	public SetValue createSetValue(Value... values) {
		if (!isValid(values)) {
			return createInvalidValue("set-of-invalid");
		}
		return new SetValueImpl(this, values);
	}

	public SetValue createSetValue(Set<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("set-of-invalid");
		}
		return new SetValueImpl(this, values);
	}

	public SetValue createSetValue(Collection<? extends Value> values) {
		if (!isValid(values)) {
			return createInvalidValue("set-of-invalid");
		}
		return new SetValueImpl(this, values);
	}

	public Value createTupleValue(TupleType type, Map<? extends TypedElement, Value> values) {
		return new TupleValueImpl(this, type, values);
	}

	public Value createTypeValue(Type type) {
		return new TypeValueImpl(this, type);
	}

	public Object getEcoreValueOf(Value value) {
		if (value instanceof InvalidValue) {
			return value;		// ?? DelegateException
		}
		else if (value instanceof NullValue) {
			return null;
		}
		else if (value instanceof CollectionValue) {
			CollectionValue collectionValue = (CollectionValue) value;
			List<Object> ecoreResult = new BasicEList<Object>(collectionValue.intSize());
			for (Value elementValue : collectionValue) {
				ecoreResult.add(getEcoreValueOf(elementValue));
			}
			return ecoreResult;
		}
		else if (value instanceof IntegerValue) {
			return ((IntegerValue)value).asInteger();
		}
		else if (value instanceof RealValue) {
			return ((RealValue)value).asDouble();
		}
		else {
			return value.asObject();
		}
	}

	public BagValue getEmptyBagValue() {
		return emptyBagValue;
	}

	public OrderedSetValue getEmptyOrderedSetValue() {
		return emptyOrderedSetValue;
	}

	public SequenceValue getEmptySequenceValue() {
		return emptySequenceValue;
	}

	public SetValue getEmptySetValue() {
		return emptySetValue;
	}

	public BooleanValue getFalse() {
		return falseValue;
	}

	public NullValue getNull() {
		return nullValue;
	}

	public BooleanValue getTrue() {
		return trueValue;
	}

	public UnlimitedValue getUnlimited() {
		return unlimitedValue;
	}

	public NumericValue getZero() {
		return zeroValue;
	}

	public IntegerValue integerValueOf(long value) {
		return new IntegerValueImpl(this, value);
	}
	
	public IntegerValue integerValueOf(BigInteger value) {
		return new IntegerValueImpl(this, value);
	}
	
	/**
	 * Creates a BigInteger representation for aValue.
	 * @param aValue the string representation of a (non-negative) integer number
	 * @return the numeric representation
	 * @throws NumberFormatException if representation cannot be created
	 * @since 3.1
	 */
	public IntegerValue integerValueOf(String aValue) {
		int len = aValue.length();
		if ((len < maxLongSize) || ((len == maxLongSize) && (maxLongValue.compareTo(aValue) >= 0))) {
			return new IntegerValueImpl(this, BigInteger.valueOf(Long.parseLong(aValue)));
		}
		else {
			return new IntegerValueImpl(this, new BigInteger(aValue));
		}
	}

	public boolean isValid(Value[] elements) {
		if (elements == null) {
			return false;			
		}
		for (Value element : elements) {
			if (element.isInvalid()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValid(Collection<? extends Value> elements) {
		if (elements == null) {
			return false;			
		}
		for (Value element : elements) {
			if (element.isInvalid()) {
				return false;
			}
		}
		return true;
	}

	public RealValue realValueOf(double value) {
		return new RealValueImpl(this, value);
	}

	public RealValue realValueOf(BigDecimal value) {
		return new RealValueImpl(this, value);
	}

//	public static RealValue realValueOf(IntegerValue value) {
//		return new RealValueImpl(value.bigDecimalValue());
//	}

	public RealValue realValueOf(IntegerValue integerValue) {
		return realValueOf(integerValue.bigDecimalValue());
	}
	
	public RealValue realValueOf(String aValue) {
		return new RealValueImpl(this, new BigDecimal(aValue.trim()));
	}
	
	public StringValue stringValueOf(String value) {
		return new StringValueImpl(this, value);
	}

	@Override
	public String toString() {
		return "ValueFactory : " + name;
	}

	public Value valueOf(Object object) {
		if (object instanceof Value) {
			return (Value) object;
		}
		if (object instanceof Number) {
			if ((object instanceof Integer) || (object instanceof Long)
					|| (object instanceof Short)) {
				return integerValueOf(((Number) object).longValue());
			}
			if ((object instanceof Float) || (object instanceof Double)) {
				return realValueOf(((Number) object).doubleValue());
			}
			if (object instanceof BigDecimal) {
				return realValueOf((BigDecimal) object);
			}
			if (object instanceof BigInteger) {
				return integerValueOf((BigInteger) object);
			}			
		}
		if (object instanceof String) {
			return stringValueOf((String) object);
		}
		if (object instanceof Boolean) {
			return booleanValueOf((Boolean) object);
		}
		if (object instanceof Element) {
			if (object instanceof Type) {
				return createTypeValue((Type) object);
			}
			return createElementValue((Element) object);
		}
		if (object == null) {
			return nullValue;
		}
		if (object.getClass().isArray()) {
			try {
				int length = Array.getLength(object);
				List<Value> values = new ArrayList<Value>();
				for (int i = 0; i < length; i++) {
					Value v = valueOf(Array.get(object, i));
					values.add(v);
				}
				return createSequenceValue(values);
			} 
			catch (IllegalArgumentException e) {}
		}
		if (object instanceof Collection) {
			Collection<?> objects = (Collection<?>) object;
			List<Value> values = new ArrayList<Value>(objects.size());
			for (Object obj : objects) {
				values.add(valueOf(obj));
			}
			if (object instanceof LinkedHashSet) {
				return createOrderedSetValue(values);
			}
			else if (object instanceof Bag) {
				return createBagValue(values);
			}
			else if (object instanceof Set) {
				return createSetValue(values);
			}
			else {
				return createSequenceValue(values);
			}
		}
		return createObjectValue(object);
	}

	public Value valueOf(Object eValue, ETypedElement eFeature) {
		if (eFeature.isMany()) {
			Collection<?> eValues = (Collection<?>) eValue;
			ArrayList<Value> values = new ArrayList<Value>(eValues.size());
			for (Object eVal : eValues) {
				values.add(valueOf(eVal));
			}
			boolean isOrdered = eFeature.isOrdered();
			boolean isUnique = eFeature.isUnique();
			return createCollectionValue(isOrdered, isUnique, values);
		}
		else if (eValue instanceof Value) {
			return (Value) eValue;		
		}
		else {
			return valueOf(eValue);
		}
	}
}
 