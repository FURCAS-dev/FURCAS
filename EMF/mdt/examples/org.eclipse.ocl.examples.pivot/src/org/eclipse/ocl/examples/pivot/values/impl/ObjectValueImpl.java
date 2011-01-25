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
 * $Id: ObjectValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.ObjectValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;



public class ObjectValueImpl extends AbstractValue implements ObjectValue
{
	protected final Object object;
	
	public ObjectValueImpl(ValueFactory valueFactory, Object object) {
		super(valueFactory);
		this.object = object;
	}

	public Object asObject() {
		return object;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ObjectValue)) {
			return false;
		}
		return object.equals(((ObjectValue)obj).getObject());
	}

	public Object getObject() {
		return object;
	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		return standardLibrary.getClassifierType();
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}

	@Override
	public String toString() {
		return object.toString();
	}
}
