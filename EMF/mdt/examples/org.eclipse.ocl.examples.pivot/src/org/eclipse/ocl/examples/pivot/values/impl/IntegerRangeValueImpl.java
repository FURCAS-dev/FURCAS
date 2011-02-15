/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - split off from EvaluationVisitor
 *
 * </copyright>
 *
 * $Id: IntegerRangeValueImpl.java,v 1.3 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class IntegerRangeValueImpl extends AbstractSequenceValue<IntegerRangeImpl>
{	// FIXME Should be AbstractOrderedSet ...
	private Type type = null;
	
	public IntegerRangeValueImpl(ValueFactory valueFactory, int first, int last) {
		super(valueFactory, new IntegerRangeImpl(valueFactory, first, last));
	}

	@Override
	public SequenceValue append(Value value) {
		IntegerValue integerValue = value.asIntegerValue();
		if (integerValue == null) {
			return valueFactory.createInvalidValue("non-Integer argument");
		}
		else if (integerValue.isUndefined()) {
			return value.toInvalidValue();
		}
		int intValue = integerValue.asInteger();
		int nextValue = elements.getLast() + elements.getDelta();
		if (intValue == nextValue) {
			return new IntegerRangeValueImpl(valueFactory, elements.getFirst(), nextValue);
		}
		else {
			List<Value> elements = createElements();
			elements.add(value);
			return valueFactory.createSequenceValue(elements);
		}
	}

	@Override
	public IntegerValue count(Value value) {
		IntegerValue integerValue = value.asIntegerValue();
		if ((integerValue != null) && !integerValue.isUndefined()) {
			BigInteger first = BigInteger.valueOf(elements.getFirst());
			BigInteger last = BigInteger.valueOf(elements.getLast());
			BigInteger val = integerValue.bigIntegerValue();
			if (elements.getDelta() > 0) {
				if ((first.compareTo(val) <= 0) && (val.compareTo(last) <= 0)) {
					return valueFactory.integerValueOf(1);
				}
			}
			else {
				if ((last.compareTo(val) <= 0) && (val.compareTo(first) <= 0)) {
					return valueFactory.integerValueOf(1);
				}
			}
		}
		return valueFactory.integerValueOf(0);
	}

	protected List<Value> createElements() {
		List<Value> elements = new ArrayList<Value>(intSize());
		for (Value value : this) {
			elements.add(value);
		}
		return elements;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IntegerRangeValueImpl) {
			IntegerRangeValueImpl that = (IntegerRangeValueImpl)obj;
			return this.elements.equals(that.elements);
		}
		else {
			return super.equals(obj);
		}
	}

//	public BooleanValue excludes(Value value) {
		// TODO Auto-generated method stub
//		return null;
//	}

//	public BooleanValue excludesAll(CollectionValue c) {
		// TODO Auto-generated method stub
//		return null;
//	}

//	public CollectionValue excluding(Value value) {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Value first() {
		return valueFactory.integerValueOf(elements.getFirst());
	}

	@Override
	public SequenceValue flatten() {
		return this;
	}

	@Override
	public List<Value> getElements() {
		if (elements == null) {
			createElements();
		}
		return (List<Value>)elements;
	}

    public Type getType(TypeManager typeManager, Type staticType) {
    	if (type == null) {
    		if ((elements.getFirst() >= 0) && (elements.getLast() >= 0)) {
    			type = typeManager.getCollectionType(true, false, typeManager.getUnlimitedNaturalType());
    		}
    		else{
    			type = typeManager.getCollectionType(true, false, typeManager.getIntegerType());
    		}
    	}
		return type;
	}

//	public BooleanValue includes(Value value) {
		// TODO Auto-generated method stub
//		return null;
//	}

//	public BooleanValue includesAll(CollectionValue c) {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public SequenceValue including(Value value) {
		return append(value);
	}

//	public IntegerValue indexOf(Value object) {
		// TODO Auto-generated method stub
//		return null;
//	}

//	public OrderedCollectionValue insertAt(int index, Value object) {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Value last() {
		return valueFactory.integerValueOf(elements.getLast());
	}

	@Override
	public SequenceValue prepend(Value value) {
		IntegerValue integerValue = value.asIntegerValue();
		if (integerValue == null) {
			return valueFactory.createInvalidValue("non-Integer argument");
		}
		else if (integerValue.isUndefined()) {
			return value.toInvalidValue();
		}
		int intValue = integerValue.asInteger();
		int previousValue = elements.getFirst() - elements.getDelta();
		if (intValue == previousValue) {
			return new IntegerRangeValueImpl(valueFactory, previousValue, elements.getLast());
		}
		else {
			List<Value> elements = createElements();
			elements.add(0, value);
			return valueFactory.createSequenceValue(elements);
		}
	}

	@Override
	public SequenceValue reverse() {
		return new IntegerRangeValueImpl(valueFactory, elements.getLast(), elements.getFirst());
	}

//	public SequenceValue subSequence(int lower, int upper) {
		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void toString(StringBuffer s, int lengthLimit) {
		s.append("Sequence{");
		s.append(elements.getFirst());
		s.append("..");
		s.append(elements.getLast());
		s.append("}");
		s.toString();
	}
}