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
 * $Id: AbstractUndefinedCollectionValue.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
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

	public OrderedCollectionValue append(Value object) {
		return toInvalidValue();
	}

    public BagValue asBagValue() {
        return toInvalidValue();
    }

	public Collection<Value> asCollection() {
		return null;
	}

	public CollectionValue asCollectionValue() {
		return toInvalidValue();
	}

	public List<Value> asList() {
		return null;
	}

	public OrderedCollectionValue asOrderedCollectionValue() {
		return toInvalidValue();
	}

	public Value at(int index) {
		return toInvalidValue();
	}

	public OrderedSetValue asOrderedSetValue() {
        return toInvalidValue();
    }

    public SequenceValue asSequenceValue() {
        return toInvalidValue();
    }

    public SetValue asSetValue() {
        return toInvalidValue();
    }

	public UniqueCollectionValue asUniqueCollectionValue() {
        return toInvalidValue();
	}

    public IntegerValue count(Value value) {
        return toInvalidValue();
    }

	public CollectionValue createNew() {
		return toInvalidValue();
	}

//	@Override
//	public int hashCode() {
//		return elements.hashCode();
//	}

    public BooleanValue excludes(Value value) {
    	return toInvalidValue();
    }


    public BooleanValue excludesAll(CollectionValue c) {
    	return toInvalidValue();
    }

	public CollectionValue excluding(Value value) {
		return toInvalidValue();
	}

    public Value first() {
		return toInvalidValue();
	}

	public CollectionValue flatten() {
    	return toInvalidValue();
    }

	public boolean flatten(Collection<Value> flattenedElements) {
		return false;
	}
	
	public CollectionKind getKind() {
	    return CollectionKind.COLLECTION;		// FIXME UOE ??
	}

    public BooleanValue includes(Value value) {
    	return toInvalidValue();
    }

    public BooleanValue includesAll(CollectionValue c) {
    	return toInvalidValue();
   }

	public CollectionValue including(Value value) {
		return toInvalidValue();
	}

	public IntegerValue indexOf(Value object) {
		return toInvalidValue();
	}

	public OrderedCollectionValue insertAt(int index, Value object) {
		return toInvalidValue();
	}

	public CollectionValue intersection(CollectionValue c) {
		return toInvalidValue();
	}

	public BooleanValue isEmpty() {
    	return toInvalidValue();
	}

	public Iterator iterator() {
		return new Iterator();
	}
	
	public Value last() {
		return toInvalidValue();
	}

	public Value maxMin(BinaryOperation binaryOperation) {
    	return toInvalidValue();
	}

	public InvalidValue minus(UniqueCollectionValue set) {
		return toInvalidValue();
	}

	public BooleanValue notEmpty() {
    	return toInvalidValue();
	}

	public OrderedCollectionValue prepend(Value object) {
		return toInvalidValue();
	}

	public Set<TupleValue> product(CollectionValue c, TupleType tupleType) {
		return null;
	}

	public OrderedCollectionValue reverse() {
		return toInvalidValue();
	}

	public IntegerValue size() {
    	return toInvalidValue();
	}

    public OrderedCollectionValue sort(Comparator<Value> comparator) {
		return toInvalidValue();
	}

	public InvalidValue subOrderedSet(int lower, int upper) {
		return toInvalidValue();
	}

	public InvalidValue subSequence(int lower, int upper) {
		return toInvalidValue();
	}

	public Value sum(BinaryOperation binaryOperation, Value zero) {
    	return toInvalidValue();
	}

	public InvalidValue symmetricDifference(UniqueCollectionValue set) {
		return toInvalidValue();
	}
    
	public OrderedCollectionValue toOrderedCollectionValue() {
		return this;
	}

	public CollectionValue union(CollectionValue c) {
        return this;
    }
}
