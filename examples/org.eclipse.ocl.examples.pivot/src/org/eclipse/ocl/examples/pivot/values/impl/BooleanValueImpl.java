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
 * $Id: BooleanValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class BooleanValueImpl extends AbstractValue implements BooleanValue
{
	private final boolean value;
	
	public BooleanValueImpl(ValueFactory valueFactory, boolean value) {
		super(valueFactory);
		this.value = value;
	}

//	@Override
//	public boolean and(Value v) {
//		return (v instanceof BooleanValue) && (value && ((BooleanValue)v).value);
//	}

	@Override
	public BooleanValueImpl asBooleanValue() {
		return this;
	}

	@Override
	public BooleanValue asFalse() {
		return valueFactory.booleanValueOf(!value);
	}

	public Object asObject() {
		return value;
	}

	@Override
	public BooleanValue asTrue() {
		return this;
	}

//	public boolean booleanValue() {
//		return value;
//	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return standardLibrary.getBooleanType();
	}

	@Override
	public boolean isFalse() {
		return !value;
	}

	@Override
	public boolean isTrue() {
		return value;
	}

	@Override
	public String toString() {
		return Boolean.toString(value);
	}
}
