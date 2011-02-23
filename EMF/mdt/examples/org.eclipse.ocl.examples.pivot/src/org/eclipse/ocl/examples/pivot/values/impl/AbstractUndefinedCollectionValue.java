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
 * $Id: AbstractUndefinedCollectionValue.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NullValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.TupleValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractUndefinedCollectionValue extends AbstractUndefinedValue
{	
	private static class Iterator implements java.util.Iterator<Value>
	{
		public boolean hasNext() {
			return false;
		}

		public Value next() {
			return null;
		}

		public void remove() {
		}
	}
	
	protected AbstractUndefinedCollectionValue(ValueFactory valueFactory) {
		super(valueFactory);
	}

	public OrderedCollectionValue append(Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public Collection<Value> asCollection() {
		return null;
	}

	public List<Value> asList() {
		return null;
	}

	public Value at(int index) throws InvalidValueException {
		return toInvalidValue();
	}

    public IntegerValue count(Value value) throws InvalidValueException {
        return toInvalidValue();
    }

	public CollectionValue createNew() throws InvalidValueException {
		return toInvalidValue();
	}

//	@Override
//	public int hashCode() {
//		return elements.hashCode();
//	}

    public BooleanValue excludes(Value value) throws InvalidValueException {
    	return toInvalidValue();
    }


    public BooleanValue excludesAll(CollectionValue c) throws InvalidValueException {
    	return toInvalidValue();
    }

	public CollectionValue excluding(Value value) throws InvalidValueException {
		return toInvalidValue();
	}

    public Value first() throws InvalidValueException {
		return toInvalidValue();
	}

	public CollectionValue flatten() throws InvalidValueException {
    	return toInvalidValue();
    }

	public boolean flatten(Collection<Value> flattenedElements) {
		return false;
	}
	
	public CollectionKind getKind() {
	    return CollectionKind.COLLECTION;		// FIXME UOE ??
	}

    public BooleanValue includes(Value value) throws InvalidValueException {
    	return toInvalidValue();
    }

    public BooleanValue includesAll(CollectionValue c) throws InvalidValueException {
    	return toInvalidValue();
   }

	public CollectionValue including(Value value) throws InvalidValueException {
		return toInvalidValue();
	}

	public IntegerValue indexOf(Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public OrderedCollectionValue insertAt(int index, Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public int intSize() {
		return 0;
	}

	public CollectionValue intersection(CollectionValue c) throws InvalidValueException {
		return toInvalidValue();
	}

	public BooleanValue isEmpty() throws InvalidValueException {
    	return toInvalidValue();
	}

	public Iterator iterator() {
		return new Iterator();
	}
	
	public Value last() throws InvalidValueException {
		return toInvalidValue();
	}

	public Value maxMin(BinaryOperation binaryOperation) throws InvalidValueException {
    	return toInvalidValue();
	}

	public NullValue minus(UniqueCollectionValue set) throws InvalidValueException {
		return toInvalidValue();
	}

	public BooleanValue notEmpty() throws InvalidValueException {
    	return toInvalidValue();
	}

	public OrderedCollectionValue prepend(Value object) throws InvalidValueException {
		return toInvalidValue();
	}

	public Set<TupleValue> product(CollectionValue c, TupleType tupleType) {
		return null;
	}

	public OrderedCollectionValue reverse() throws InvalidValueException {
		return toInvalidValue();
	}

	public IntegerValue size() throws InvalidValueException {
    	return toInvalidValue();
	}

    public OrderedCollectionValue sort(Comparator<Value> comparator) throws InvalidValueException {
		return toInvalidValue();
	}

	public NullValue subOrderedSet(int lower, int upper) throws InvalidValueException {
		return toInvalidValue();
	}

	public NullValue subSequence(int lower, int upper) throws InvalidValueException {
		return toInvalidValue();
	}

	public Value sum(BinaryOperation binaryOperation, Value zero) throws InvalidValueException {
    	return toInvalidValue();
	}

	public NullValue symmetricDifference(UniqueCollectionValue set) throws InvalidValueException {
		return toInvalidValue();
	}
    
	public OrderedCollectionValue toOrderedCollectionValue() {
		return this;
	}

	public CollectionValue union(CollectionValue c) {
        return this;
    }
}
