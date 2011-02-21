/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: BooleanValueImpl.java,v 1.4 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.BooleanValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class BooleanValueImpl extends AbstractValue implements BooleanValue
{
	private final boolean value;
	
	public BooleanValueImpl(ValueFactory valueFactory, boolean value) {
		super(valueFactory);
		this.value = value;
	}

	@Override
	public boolean asBoolean() {
		return value;
	}

	@Override
	public BooleanValueImpl asBooleanValue() {
		return this;
	}

	public Object asObject() {
		return value;
	}

	public Value asValidValue() {
		return this;
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return typeManager.getBooleanType();
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
