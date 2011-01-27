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
 * $Id: AbstractValue.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.values.BagValue;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.values.IntegerValue;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.OrderedCollectionValue;
import org.eclipse.ocl.examples.pivot.values.OrderedSetValue;
import org.eclipse.ocl.examples.pivot.values.RealValue;
import org.eclipse.ocl.examples.pivot.values.SequenceValue;
import org.eclipse.ocl.examples.pivot.values.SetValue;
import org.eclipse.ocl.examples.pivot.values.StringValue;
import org.eclipse.ocl.examples.pivot.values.TypeValue;
import org.eclipse.ocl.examples.pivot.values.UniqueCollectionValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public abstract class AbstractValue implements Value
{
	protected final ValueFactory valueFactory;

	protected AbstractValue(ValueFactory valueFactory) {
		this.valueFactory = valueFactory;
	}

//	public boolean and(Value v) {
//		return false;
//	}

	public BagValue asBagValue() {
		return null;
	}

	public BooleanValue asBooleanValue() {
		return null;
	}

	public CollectionValue asCollectionValue() {
		return null;
	}

	public Element asElement() {
		return null;
	}

	public BooleanValue asFalse() {
		return valueFactory.getFalse();
	}

	public Integer asInteger() {
		return null;
	}

	public IntegerValue asIntegerValue() {
		return null;
	}

	public InvalidValue asInvalidValue() {
		return null;
	}

	public OrderedCollectionValue asOrderedCollectionValue() {
		return null;
	}

	public OrderedSetValue asOrderedSetValue() {
		return null;
	}

	public RealValue asRealValue() {
		return null;
	}

	public SequenceValue asSequenceValue() {
		return null;
	}

	public SetValue asSetValue() {
		return null;
	}

	public String asString() {
		return null;
	}

	public StringValue asStringValue() {
		return null;
	}

	public BooleanValue asTrue() {
		return valueFactory.getFalse();
	}

	public TypeValue asTypeValue() {
		return null;
	}

	public UniqueCollectionValue asUniqueCollectionValue() {
		return null;
	}
	
	public ValueFactory getValueFactory() {
		return valueFactory;
	}

	public boolean isFalse() {
		return false;
	}

	public boolean isInvalid() {
		return false;
	}

	public boolean isNull() {
		return false;
	}

	public boolean isTrue() {
		return false;
	}

	public boolean isUndefined() {
		return false;
	}

	public boolean isUnlimited() {
		return false;
	}
	
	public boolean isUnlimitedNatural() {
		return false;
	}

	public String oclToString() {
		return toString();
	}

	public InvalidValue toInvalidValue() {
		return valueFactory.createInvalidValue(this, null, "bad value", null);
	}

	public RealValue toRealValue() {
		return null;
	}

	public void toString(StringBuffer s, int sizeLimit) {
		s.append(toString());
	}
}
