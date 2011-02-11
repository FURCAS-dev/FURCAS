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
 * $Id: AbstractedCollectionValue.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractedCollectionValue
	extends AbstractValue
	implements CollectionValue
{
	protected AbstractedCollectionValue(ValueFactory valueFactory) {
		super(valueFactory);
	}

    @Override
    public BagValue asBagValue() {
        return valueFactory.createBagValue(getElements());
    }

	public Collection<Value> asCollection() {
		return getElements();
	}

	@Override
	public CollectionValue asCollectionValue() {
		return this;
	}

	public List<Value> asList() {
		return new ArrayList<Value>(getElements());
	}

	public Object asObject() {
		return getElements();
	}

    @Override
	public OrderedSetValue asOrderedSetValue() {
        return valueFactory.createOrderedSetValue(getElements());
    }

    @Override
    public SequenceValue asSequenceValue() {
        return valueFactory.createSequenceValue(getElements());
    }

    @Override
    public SetValue asSetValue() {
        return valueFactory.createSetValue(getElements());
    }

	protected abstract Collection<Value> getElements();

	public BooleanValue isEmpty() {
		return valueFactory.booleanValueOf(intSize() == 0);
	}

	public BooleanValue notEmpty() {
		return valueFactory.booleanValueOf(intSize() != 0);
	}

	public IntegerValue size() {
		return valueFactory.integerValueOf(intSize());
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		toString(s, 100);
		return s.toString();
	}

	@Override
	public void toString(StringBuffer s, int lengthLimit) {
		s.append("{");
		boolean isFirst = true;
		for (Value element : this) {
			if (!isFirst) {
				s.append(",");
			}
			if (s.length() < lengthLimit) {
				element.toString(s, lengthLimit-1);
			}
			else {
				s.append("...");
				break;
			}
			isFirst = false;
		}
		s.append("}");		
	}
}
