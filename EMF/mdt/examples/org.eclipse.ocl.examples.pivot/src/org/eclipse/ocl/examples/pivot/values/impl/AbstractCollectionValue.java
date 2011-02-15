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
 * $Id: AbstractCollectionValue.java,v 1.4 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.TupleValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractCollectionValue<C extends Collection<Value>>
	extends AbstractedCollectionValue
{
	protected final C elements;
	
	protected AbstractCollectionValue(ValueFactory valueFactory, C elements) {
		super(valueFactory);
		this.elements = elements;
		assert elements != null;
		assert valueFactory.isValid(elements);		// FIXME Debugging
	}
	
	/**
	 * Add a value to a working collection, returning true if the working
	 * collection is changed by the addition.
	 * <p>
	 * The default implementation is appropriate for non-unique collections and
	 * must be overridden to support OCL rather than Java uniqueness semantics.
	 */
//	protected boolean add(C values, Value value) {
//		return values.add(value);
//	}

    /**
     * Implementation of the OCL
     * <tt>Collection::count(object : T) : Integer</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return the number of occurrences of the object in the collection
     */
    public IntegerValue count(Value value) {
        long count = 0;
        for (Value next : elements) {
            if (next.equals(value)) {
                count++;
            }
        }        
        return valueFactory.integerValueOf(count);
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::excludes(object : T) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param object an object
     * @return whether the collection does not include the object
     */
    public BooleanValue excludes(Value value) {
    	return valueFactory.booleanValueOf(!elements.contains(value));
    }

	/**
     * Implementation of the OCL
     * <tt>Collection::excludesAll(c : Collection(T)) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param c another collection
     * @return whether the source collection does not contain any of the
     *     elements of the other
     */
    public BooleanValue excludesAll(CollectionValue c) {
        for (Value next : c) {
            if (elements.contains(next)) {
                return valueFactory.getFalse();
            }
        }
        return valueFactory.getTrue();
    }

    /**
     * Returns true if any element flattened.
     */
	public boolean flatten(Collection<Value> flattenedElements) {
		boolean flattened = false;
		for (Value element : elements) {
			CollectionValue collectionElement = element.asCollectionValue();
			if (collectionElement != null) {
				flattened = true;
				collectionElement.flatten(flattenedElements);
			}
			else {
				flattenedElements.add(element);
			}
		}
		return flattened;
	}

	@Override
	protected Collection<Value> getElements() {
		return elements;
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

    public BooleanValue includes(Value value) {
		return valueFactory.booleanValueOf(elements.contains(value));
    }

    /**
     * Implementation of the OCL
     * <tt>Collection::includesAll(c : Collection(T)) : Boolean</tt>
     * operation.
     * 
     * @param self the source collection
     * @param c another collection
     * @return whether the source collection includes all of the elements
     *     of the other
     */
    public BooleanValue includesAll(CollectionValue c) {
    	for (Value next : c) {
    		if (!elements.contains(next)) {
    			return valueFactory.getFalse();
    		}
    	}   	
        return valueFactory.getTrue();
    }

	public int intSize() {
		return elements.size();
	}

	public CollectionValue intersection(CollectionValue c) {
        if (this instanceof UniqueCollectionValue || c instanceof UniqueCollectionValue) {
            return SetValueImpl.intersection(valueFactory, this, c);
        }
        else {
            return BagValueImpl.intersection(valueFactory, this, c);
        }
	}

	public Iterator<Value> iterator() {
		return elements != null ? elements.iterator() : Collections.<Value>emptyList().iterator();
	}

	public Value maxMin(BinaryOperation binaryOperation) {
		Value result = null;
        for (Value element : elements) {
        	if (result == null) {
        		result = element;
        	}
        	else {
        		result = binaryOperation.evaluate(valueFactory, result, element);
        		if (result == null) {
        			return valueFactory.createInvalidValue(element, null, "max/min evaluation failure", null);
        		}
        		if (result.isUndefined()) {
        			return result.toInvalidValue();
        		}
        	}
        }
		if (result == null) {
			return valueFactory.createInvalidValue(this, null, "max/min or empty collection", null);
		}
		else {
			return result;
		}
    }

    public Set<TupleValue> product(CollectionValue c, TupleType tupleType) {   	
    	Set<TupleValue> result = new HashSet<TupleValue>();		
        for (Value next1 : this) {
        	for (Value next2 : c) {
        		result.add(new TupleValueImpl(valueFactory, tupleType, next1, next2));
        	}
        }
        return result;
    }

	public Value sum(BinaryOperation binaryOperation, Value zero) {
		Value result = zero;
        for (Value element : elements) {
        	result = binaryOperation.evaluate(valueFactory, result, element);
        }
        return result;
    }

    public CollectionValue union(CollectionValue c) {
        if (this instanceof BagValue || c instanceof BagValue) {
            return BagValueImpl.union(valueFactory, this, c);
        }
        else if (this instanceof SequenceValue || c instanceof SequenceValue) {
            return SequenceValueImpl.union(valueFactory, this, c);
        }
        else if (this instanceof OrderedSetValue || c instanceof OrderedSetValue) {
            return OrderedSetValueImpl.union(valueFactory, this, c);
        }
        else {
            return SetValueImpl.union(valueFactory, this, c);
        }
    }
}
