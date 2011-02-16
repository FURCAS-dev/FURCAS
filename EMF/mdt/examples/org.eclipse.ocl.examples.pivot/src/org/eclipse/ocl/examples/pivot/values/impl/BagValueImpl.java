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
 * $Id: BagValueImpl.java,v 1.3 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.ocl.examples.pivot.CollectionKind;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Bag;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class BagValueImpl
	extends AbstractCollectionValue<Bag<Value>>
	implements BagValue
{
    public static BagValue intersection(ValueFactory valueFactory, CollectionValue left, CollectionValue right)
    {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
        int leftSize = leftElements.size();
        int rightSize = rightElements.size();
    	if ((leftSize == 0) || (rightSize == 0)) {
            return valueFactory.getEmptyBagValue();
        }    	
        Bag<Value> results = new BagImpl<Value>();
        // loop over the smaller collection and add only elements
        // that are in the larger collection
        Set<Value> minElements = new HashSet<Value>(leftSize < rightSize ? leftElements : rightElements);
        for (Value e : minElements) {
        	IntegerValue leftCount = left.count(e);
        	IntegerValue rightCount = right.count(e);
        	for (int i = Math.min(leftCount.asInteger(), rightCount.asInteger()); i > 0; i--) {
        		results.add(e);
        	}
        }
    	return results.size() > 0 ? new BagValueImpl(valueFactory, results) : valueFactory.getEmptyBagValue();
    }

    public static BagValue union(ValueFactory valueFactory, CollectionValue left, CollectionValue right) {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asBagValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asBagValue();
        }    	
    	else {
			Bag<Value> result = new BagImpl<Value>(leftElements);
			result.addAll(rightElements);
    		return new BagValueImpl(valueFactory, result);
        } 
    }
	
	public static class Accumulator extends BagValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(ValueFactory valueFactory) {
			super(valueFactory);
		}

		public boolean add(Value value) {
			return elements.add(value);			
		}		
	}
	
	public BagValueImpl(ValueFactory valueFactory, Value... elements) {
		super(valueFactory, new BagImpl<Value>());
		if (elements != null) {
			for (Value element : elements) {
				this.elements.add(element);
			}
		}
	}

	public BagValueImpl(ValueFactory valueFactory, Collection<? extends Value> elements) {
		super(valueFactory, new BagImpl<Value>(elements));
	}

//	public BagValue(CollectionValue c) {
//		this(c.asCollection());
//	}

	public BagValueImpl(ValueFactory valueFactory, Bag<Value> elements) {
		super(valueFactory, elements);
	}

    @Override
	public BagValue asBagValue() {
        return this;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BagValueImpl)) {
			return false;
		}
		return elements.equals(((BagValueImpl)obj).elements);
	}

	public BagValue excluding(Value value) {
		Bag<Value> result = new BagImpl<Value>();
		for (Value element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new BagValueImpl(valueFactory, result);
		}
		else {
			return this;
		}
	}

    public BagValue flatten() {
    	Bag<Value> flattened = new BagImpl<Value>();
    	if (flatten(flattened)) {
    		return new BagValueImpl(valueFactory, flattened);
    	}
    	else {
    		return this;
    	}
    }
	
	public CollectionKind getKind() {
	    return CollectionKind.BAG;
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return staticType; // standardLibrary.getBagType();
	}

	public BagValue including(Value value) {
		Bag<Value> result = new BagImpl<Value>(elements);
		result.add(value);
		return new BagValueImpl(valueFactory, result);
	}
	   
    public SequenceValue sort(Comparator<Value> comparator) {
    	List<Value> values = new ArrayList<Value>(elements);
    	Collections.sort(values, comparator);
    	return new SequenceValueImpl(valueFactory, values);
    }
    
	public OrderedCollectionValue toOrderedCollectionValue() {
		return new SequenceValueImpl(valueFactory, elements);
	}

	@Override
	public void toString(StringBuffer s, int lengthLimit) {
		s.append("Bag");
		super.toString(s, lengthLimit);
	}
}
