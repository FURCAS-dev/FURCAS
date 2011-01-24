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
 * $Id: OrderedSetValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.values.OrderedSet;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class OrderedSetValueImpl
	extends AbstractCollectionValue<OrderedSet<Value>>
	implements OrderedSetValue
{
    public static OrderedSetValue union(ValueFactory valueFactory, CollectionValue left, CollectionValue right) {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asOrderedSetValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asOrderedSetValue();
        }    	
    	else {
			OrderedSet<Value> result = new OrderedSetImpl<Value>(leftElements);
			result.addAll(rightElements);
    		return new OrderedSetValueImpl(valueFactory, result);
        } 
    }
	
	public static class Accumulator extends OrderedSetValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(ValueFactory valueFactory) {
			super(valueFactory);
		}

		public boolean add(Value value) {
			return elements.add(value);			
		}		
	}
    
	public OrderedSetValueImpl(ValueFactory valueFactory, Value... elements) {
		super(valueFactory, new OrderedSetImpl<Value>());
		if (elements != null) {
			for (Value element : elements) {
				this.elements.add(element);		// FIXME equals
			}
		}
	}

	public OrderedSetValueImpl(ValueFactory valueFactory, Collection<? extends Value> elements) {
		super(valueFactory, new OrderedSetImpl<Value>(elements));
	}

	public OrderedSetValueImpl(ValueFactory valueFactory, OrderedSet<Value> elements) {
		super(valueFactory, elements);
	}

    public OrderedSetValue append(Value object) {
    	OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);
        result.remove(object);  // appended object must be last
        result.add(object);
        return new OrderedSetValueImpl(valueFactory, result);
    }

	@Override
	public OrderedCollectionValue asOrderedCollectionValue() {
		return this;
	}

	@Override
	public OrderedSetValueImpl asOrderedSetValue() {
		return this;
	}

	@Override
	public UniqueCollectionValue asUniqueCollectionValue() {
        return this;
	}
	
    public Value at(int index) {
        index = index - 1;        
        if (index < 0 || index >= elements.size()) {
			throw new IndexOutOfBoundsException(
				"index: " + (index + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
		}        
        int curr = 0;
        for (Iterator<Value> it = iterator(); it.hasNext();) {
        	Value object = it.next();
            if (curr++ == index) {
                return object;
            }
        }
        return null; // undefined
    }

	public OrderedSetValue createNew() {
		return new OrderedSetValueImpl(valueFactory);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OrderedSetValueImpl)) {
			return false;
		}
		return elements.equals(((OrderedSetValueImpl)obj).elements);
	}

	public OrderedSetValue excluding(Value value) {
		OrderedSet<Value> result = new OrderedSetImpl<Value>();
		for (Value element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new OrderedSetValueImpl(valueFactory, result);
		}
		else {
			return this;
		}
	}

    public Value first() {
        if ((elements == null) || (elements.size() <= 0)) {
            return null;
        }
        return elements.iterator().next();
    }

    public OrderedSetValue flatten() {
    	OrderedSet<Value> flattened = new OrderedSetImpl<Value>();
    	if (flatten(flattened)) {
    		return new OrderedSetValueImpl(valueFactory, flattened);
    	}
    	else {
    		return this;
    	}
    }
	
	public CollectionKind getKind() {
	    return CollectionKind.ORDERED_SET;
	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return staticType; // standardLibrary.getOrderedSetType();
	}

	public OrderedSetValue including(Value value) {
		OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);
		result.add(value);
		return new OrderedSetValueImpl(valueFactory, result);
	}


    public IntegerValue indexOf(Value object) {
        int index = 1;        
        for (Value next : elements) {
            if (object.equals(next)) {
                return valueFactory.integerValueOf(index);
            }
            index++;
        }        
        return valueFactory.createInvalidValue("missing element");
    }

    public OrderedSetValue insertAt(int index, Value object) {
        index = index - 1;
        boolean isContained = elements.contains(object);
        int effectiveSize = elements.size() - (isContained ? 1 : 0);
        if ((index < 0) || (effectiveSize < index)) {
			throw new IndexOutOfBoundsException(
				"index: " + (index + 1) + ", size: " //$NON-NLS-1$ //$NON-NLS-2$
					+ size());
        }
        
        OrderedSet<Value> result = new OrderedSetImpl<Value>();
        int curr = 0;
        for (Iterator<Value> it = iterator(); it.hasNext();) {
            if (curr == index) {
                result.add(object);
            }
            Value next = it.next();
            if (!next.equals(object)) {
				result.add(next);
	            curr++;
            }
        }
        
        if (index == effectiveSize) {
        	// the loop finished before we could add the object
        	result.add(object);
        }
        return new OrderedSetValueImpl(valueFactory, result);
    }

    public Value last() {
        if ((elements == null) || (elements.size() <= 0)) {
            return null;
        }
        Value result = null;
        for (Value next : elements) {
            result = next;
        }
        return result;
    }

    public OrderedSetValue minus(UniqueCollectionValue set) {
    	OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);
        result.removeAll(set.asCollection());
        return new OrderedSetValueImpl(valueFactory, result);
    }

    public OrderedSetValue prepend(Value object) {
    	OrderedSet<Value> result = new OrderedSetImpl<Value>();
        result.add(object);
        result.addAll(elements);
        return new OrderedSetValueImpl(valueFactory, result);
    }

	public OrderedSetValue reverse() {
		List<Value> elements = asList();
		Collections.reverse(elements);
        return new OrderedSetValueImpl(valueFactory, elements);
    }
    
    public OrderedSetValue sort(Comparator<Value> comparator) {
    	List<Value> values = new ArrayList<Value>(elements);
    	Collections.sort(values, comparator);
    	return new OrderedSetValueImpl(valueFactory, values);
    }

    public OrderedSetValue subOrderedSet(int lower, int upper) {
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
        
        OrderedSet<Value> result = new OrderedSetImpl<Value>();
        int curr = 0;
        for (Iterator<Value> it = elements.iterator(); it.hasNext();) {
        	Value object = it.next();
            if (curr >= lower && curr <= upper) {
                result.add(object);
            }
            curr++;
        }
        return new OrderedSetValueImpl(valueFactory, result);
    }

    public OrderedSetValue symmetricDifference(UniqueCollectionValue set) {       
    	OrderedSet<Value> result = new OrderedSetImpl<Value>(elements);       
        for (Value e : set) {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        }        
        return new OrderedSetValueImpl(valueFactory, result);
    }

	public OrderedCollectionValue toOrderedCollectionValue() {
		return this;
	}

	@Override
	public void toString(StringBuffer s, int lengthLimit) {
		s.append("OrderedSet");
		super.toString(s, lengthLimit);
	}
}
