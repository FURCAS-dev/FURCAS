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
 * $Id: AbstractSequenceValue.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.NullValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractSequenceValue<L extends List<Value>>
	extends AbstractCollectionValue<L>
	implements SequenceValue
{
	public AbstractSequenceValue(ValueFactory valueFactory, L elements) {
		super(valueFactory, elements);
	}
	
	@Override
	public List<Value> asList() {
		return elements;
	}

	@Override
	public OrderedCollectionValue asOrderedCollectionValue() {
		return this;
	}

    @Override
	public SequenceValue asSequenceValue() {
        return this;
    }

    public SequenceValue append(Value object) {
    	List<Value> result = new ArrayList<Value>(elements);
        result.add(object);
        return valueFactory.createSequenceValue(result);
    }

    public Value at(int index) {
        index = index - 1;        
        if (index < 0 || elements.size() <= index) {
			throw new IndexOutOfBoundsException(
				"index: " + (index + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
		}        
        return elements.get(index);
    }

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NullValue) {
			return false;
		}
		else if (obj instanceof SequenceValue) {
			SequenceValue that = (SequenceValue)obj;
			int i = 0;
			for (Value thisValue : this) {
				Value thatValue = that.at(i++);
				if (!thisValue.equals(thatValue)) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}

	public SequenceValue excluding(Value value) {
		List<Value> result = new ArrayList<Value>();
		for (Value element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return valueFactory.createSequenceValue(result);
		}
		else {
			return this;
		}
	}

    public Value first() {
        if (elements.size() <= 0) {
            return null;
        }
        return elements.get(0);
    }

    public SequenceValue flatten() {
    	List<Value> flattened = new ArrayList<Value>();
    	if (flatten(flattened)) {
    		return valueFactory.createSequenceValue(flattened);
    	}
    	else {
    		return this;
    	}
    }
	
	public CollectionKind getKind() {
	    return CollectionKind.SEQUENCE;
	}
	   
	public SequenceValue including(Value value) {
		List<Value> result = new ArrayList<Value>(elements);
		result.add(value);
		return valueFactory.createSequenceValue(result);
	}

    public IntegerValue indexOf(Value object) {
        int index = elements.indexOf(object);
        return index >= 0 ? valueFactory.integerValueOf(index+1) : valueFactory.createInvalidValue("missing object");
    }

    public SequenceValue insertAt(int index, Value object) {
        index = index - 1;        
        if (index < 0 || index > elements.size()) {
			throw new IndexOutOfBoundsException(
				"index: " + (index + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
        }        
		List<Value> result = new ArrayList<Value>(elements);
		result.add(index, object);
		return valueFactory.createSequenceValue(result);
    }
    
    public Value last() {
        int size = elements.size();
		if (size <= 0) {
            return null;
        }
        return elements.get(size-1);
    }
    
    public SequenceValue prepend(Value object) {
    	List<Value> result = new ArrayList<Value>();
        result.add(object);
        result.addAll(elements);
        return valueFactory.createSequenceValue(result);
    }

	public SequenceValue reverse() {
		List<Value> elements = new ArrayList<Value>(this.elements);
		Collections.reverse(elements);
        return valueFactory.createSequenceValue(elements);
    }
	   
    public SequenceValue sort(Comparator<Value> comparator) {
    	List<Value> values = new ArrayList<Value>(elements);
    	Collections.sort(values, comparator);
    	return valueFactory.createSequenceValue(values);
    }
	
    /**
     * Implementation of the OCL
     * <tt>Sequence::subSequence(lower : Integer, upper : Integer) : Sequence(T)</tt></li>
     * operation.
     * 
     * @param self the source sequence
     * @param lower the 1-based (in OCL fashion) inclusive lower bound
     * @param upper the 1-based (in OCL fashion) inclusive upper bound
     * @return the source collection with the object inserted at the index
     * 
     * @throws IndexOutOfBoundsException if an index is out of bounds
     * @throws IllegalArgumentException if the lower bound is greater than the upper
     */
    public SequenceValue subSequence(int lower, int upper) {
        lower = lower - 1;
        upper = upper - 1;
        
        if (lower < 0) {
			throw new IndexOutOfBoundsException("lower: " + (lower + 1)); //$NON-NLS-1$
        } else if (upper >= elements.size()) {
			throw new IndexOutOfBoundsException(
				"upper: " + (upper + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
        } else if (upper < lower) {
			throw new IllegalArgumentException(
				"lower: " + (lower + 1) + ", upper: " //$NON-NLS-1$ //$NON-NLS-2$
					+ (upper + 1));
        }
        
		List<Value> result = new ArrayList<Value>();
        int curr = 0;
        for (Iterator<Value> it = iterator(); it.hasNext();) {
        	Value object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return valueFactory.createSequenceValue(result);
    }

	public OrderedCollectionValue toOrderedCollectionValue() {
		return this;
	}

	@Override
	public void toString(StringBuffer s, int lengthLimit) {
		s.append("Sequence");
		super.toString(s, lengthLimit);
	}
}
