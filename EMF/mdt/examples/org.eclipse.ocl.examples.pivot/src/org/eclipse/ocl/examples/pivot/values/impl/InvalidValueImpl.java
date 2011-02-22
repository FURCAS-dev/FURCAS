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
 * $Id: InvalidValueImpl.java,v 1.5 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.InvalidValue;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class InvalidValueImpl extends AbstractUndefinedCollectionValue implements InvalidValue
{	
	public InvalidValueImpl(ValueFactory valueFactory) {
		super(valueFactory);
	}

	public Value asValidValue() throws InvalidValueException {
		throw new InvalidValueException("Valid Value Required", this);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof InvalidValue;
	}

	public Type getType(TypeManager typeManager, Type staticType) {
		return staticType; // standardLibrary.getInvalidType();
	}

	@Override
	public int hashCode() {
		return 0x22222222;
	}

	@Override
	public boolean isInvalid() {
		return true;
	}

	@Override
	public String toString() {
		return "invalid";
	}
}
