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
 * $Id: SetValueImpl.java,v 1.3 2011/02/11 20:00:28 ewillink Exp $
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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

//
//	Note that it is not necessary to adjust set uniqueness for OCL value equivalence
//	since Value.equals realises OCL equivalence, and so Collection operations that
//	inherently use Object.equals automatically observe OCL uniqueness.
//
public class SetValueImpl extends AbstractCollectionValue<Set<Value>>
	implements SetValue
{
    public static SetValue intersection(ValueFactory valueFactory, CollectionValue left, CollectionValue right)
    {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
        int leftSize = leftElements.size();
        int rightSize = rightElements.size();
    	if ((leftSize == 0) || (rightSize == 0)) {
            return valueFactory.getEmptySetValue();
        }    	
        Set<Value> results = new HashSet<Value>();
        // loop over the smaller collection and add only elements
        // that are in the larger collection
        if (leftSize <= rightSize) {
            results = new HashSet<Value>(leftElements);
        	results.retainAll(rightElements);
        }
        else {
            results = new HashSet<Value>(rightElements);
        	results.retainAll(leftElements);
        }
    	return results.size() > 0 ? new SetValueImpl(valueFactory, results) : valueFactory.getEmptySetValue();
    }

	public static SetValue union(ValueFactory valueFactory, CollectionValue left, CollectionValue right) {
    	assert !left.isUndefined() && !right.isUndefined();
		Collection<Value> leftElements = left.asCollection();
        Collection<Value> rightElements = right.asCollection();
    	if (leftElements.isEmpty()) {
            return right.asSetValue();
        }
    	else if (rightElements.isEmpty()) {
            return left.asSetValue();
        }    	
    	else {
			Set<Value> result = new HashSet<Value>(leftElements);
			result.addAll(rightElements);
    		return new SetValueImpl(valueFactory, result);
        } 
    }   

	public static SetValue valueOfElements(ValueFactory valueFactory, Collection<? extends Element> elements) {
		Set<Value> results = new HashSet<Value>();
		for (Element element : elements) {
			results.add(valueFactory.createElementValue(element));
		}
		return new SetValueImpl(valueFactory, results);
	}

	public static SetValue valueOfObjects(ValueFactory valueFactory, Collection<? extends Object> objects) {
		Set<Value> results = new HashSet<Value>();
		for (Object object : objects) {
			results.add(valueFactory.createObjectValue(object));
		}
		return new SetValueImpl(valueFactory, results);
	}
	
	public static class Accumulator extends SetValueImpl implements CollectionValue.Accumulator
	{
		public Accumulator(ValueFactory valueFactory) {
			super(valueFactory);
		}

		public boolean add(Value value) {
			return elements.add(value);			
		}		
	}
	
	public SetValueImpl(ValueFactory valueFactory, Value... elements) {
		super(valueFactory, new HashSet<Value>());
		if (elements != null) {
			for (Value element : elements) {
				this.elements.add(element);			// FIXME equals
			}
		}
	}

	public SetValueImpl(ValueFactory valueFactory, Collection<? extends Value> elements) {
		super(valueFactory, new HashSet<Value>(elements));
	}

//	public SetValue(CollectionValue c) {
//		this(c.asCollection());
//	}

	public SetValueImpl(ValueFactory valueFactory, Set<Value> elements) {
		super(valueFactory, elements);
	}

    @Override
	public UniqueCollectionValue asUniqueCollectionValue() {
        return this;
	}

    @Override
	public SetValue asSetValue() {
        return this;
    }

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof SetValueImpl)) {
			return false;
		}
		return elements.equals(((SetValueImpl)obj).elements);
	}

	public SetValue excluding(Value value) {
		Set<Value> result = new HashSet<Value>();
		for (Value element : elements) {
			if (!element.equals(value)) {
				result.add(element);
			}
		}
		if (result.size() < elements.size()) {
			return new SetValueImpl(valueFactory, result);
		}
		else {
			return this;
		}
	}

    public SetValue flatten() {
    	Set<Value> flattened = new HashSet<Value>();
    	if (flatten(flattened)) {
    		return new SetValueImpl(valueFactory, flattened);
    	}
    	else {
    		return this;
    	}
    }
	
	public CollectionKind getKind() {
	    return CollectionKind.SET;
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return staticType; // standardLibrary.getSetType();
	}

	public SetValue including(Value value) {
		Set<Value> result = new HashSet<Value>(elements);
		result.add(value);
		return new SetValueImpl(valueFactory, result);
	}

    public SetValue minus(UniqueCollectionValue set) {
    	Set<Value> result = new HashSet<Value>(elements);
        result.removeAll(set.asCollection());
        return new SetValueImpl(valueFactory, result);
    }
    
    public OrderedSetValue sort(Comparator<Value> comparator) {
    	List<Value> values = new ArrayList<Value>(elements);
    	Collections.sort(values, comparator);
    	return new OrderedSetValueImpl(valueFactory, values);
    }

    public SetValue symmetricDifference(UniqueCollectionValue set) {       
    	Set<Value> result = new HashSet<Value>(elements);       
        for (Value e : set) {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        }        
        return new SetValueImpl(valueFactory, result);
    }
    
	public OrderedCollectionValue toOrderedCollectionValue() {
		return new OrderedSetValueImpl(valueFactory, elements);
	}

	@Override
	public void toString(StringBuffer s, int lengthLimit) {
		s.append("Set");
		super.toString(s, lengthLimit);
	}
}
