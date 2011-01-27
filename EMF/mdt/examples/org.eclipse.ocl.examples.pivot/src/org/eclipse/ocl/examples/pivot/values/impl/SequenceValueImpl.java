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
 * $Id: SequenceValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class SequenceValueImpl
	extends AbstractCollectionValue<List<Value>>
	implements SequenceValue
{
	public static SequenceValue union(ValueFactory valueFactory, CollectionValue left, CollectionValue right) {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asSequenceValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asSequenceValue();
        }    	
    	else {
    		List<Value> result = new ArrayList<Value>(leftElements);
			result.addAll(rightElements);
    		return new SequenceValueImpl(valueFactory, result);
        } 
    }
	
	public static class Accumulator extends SequenceValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(ValueFactory valueFactory) {
			super(valueFactory);
		}

		public boolean add(Value value) {
			return elements.add(value);			
		}		
	}
    
	public SequenceValueImpl(ValueFactory valueFactory, Value... elements) {
		super(valueFactory, new ArrayList<Value>());
		if (elements != null) {
			for (Value element : elements) {
				this.elements.add(element);
			}
		}
	}

	public SequenceValueImpl(ValueFactory valueFactory, Collection<? extends Value> elements) {
		super(valueFactory, new ArrayList<Value>(elements));
	}

	public SequenceValueImpl(ValueFactory valueFactory, List<Value> elements) {
		super(valueFactory, elements);
	}
	
	@Override
	public List<Value> asList() {
		return elements != null ? elements : Collections.<Value>emptyList();
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
        return new SequenceValueImpl(valueFactory, result);
    }

    public Value at(int index) {
        if (elements == null) {
            return null;
        }
        index = index - 1;        
        if (index < 0 || index >= elements.size()) {
			throw new IndexOutOfBoundsException(
				"index: " + (index + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
		}        
        return elements.get(index);
    }

	public SequenceValue createNew() {
		return new SequenceValueImpl(valueFactory);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SequenceValueImpl)) {
			return false;
		}
		return elements.equals(((SequenceValueImpl)obj).elements);
	}

	public SequenceValue excluding(Value value) {
		List<Value> result = new ArrayList<Value>();
		for (Value element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new SequenceValueImpl(valueFactory, result);
		}
		else {
			return this;
		}
	}

    public Value first() {
        if ((elements == null) || (elements.size() <= 0)) {
            return null;
        }
        return elements.get(0);
    }

    public SequenceValue flatten() {
    	List<Value> flattened = new ArrayList<Value>();
    	if (flatten(flattened)) {
    		return new SequenceValueImpl(valueFactory, flattened);
    	}
    	else {
    		return this;
    	}
    }
	
	public CollectionKind getKind() {
	    return CollectionKind.SEQUENCE;
	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return staticType; // standardLibrary.getSequenceType();
	}
   
	public SequenceValue including(Value value) {
		List<Value> result = new ArrayList<Value>(elements);
		result.add(value);
		return new SequenceValueImpl(valueFactory, result);
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
		return new SequenceValueImpl(valueFactory, result);
    }

  
    public Value last() {
        if (elements == null) {
            return null;
        }
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
        return new SequenceValueImpl(valueFactory, result);
    }

	public SequenceValue reverse() {
		List<Value> elements = new ArrayList<Value>(this.elements);
		Collections.reverse(elements);
        return new SequenceValueImpl(valueFactory, elements);
    }
	   
    public SequenceValue sort(Comparator<Value> comparator) {
    	List<Value> values = new ArrayList<Value>(elements);
    	Collections.sort(values, comparator);
    	return new SequenceValueImpl(valueFactory, values);
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
        return new SequenceValueImpl(valueFactory, result);
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
