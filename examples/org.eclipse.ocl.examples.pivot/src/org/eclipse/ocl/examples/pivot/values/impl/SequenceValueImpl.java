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
 * $Id: SequenceValueImpl.java,v 1.3 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class SequenceValueImpl extends AbstractSequenceValue<List<Value>>
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
	public boolean equals(Object obj) {
		if (obj instanceof SequenceValueImpl) {
			return elements.equals(((SequenceValueImpl)obj).elements);
		}
		else {
			return super.equals(obj);
		}
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return staticType; // standardLibrary.getSequenceType();
	}
}
