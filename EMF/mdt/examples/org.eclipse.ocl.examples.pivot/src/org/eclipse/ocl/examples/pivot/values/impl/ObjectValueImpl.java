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
 * $Id: ObjectValueImpl.java,v 1.9 2011/04/20 19:02:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.ObjectValue;
import org.eclipse.ocl.examples.pivot.values.Value;
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
	public ObjectValue asObjectValue() {
		return this;
	}

	public Value asValidValue() {
		return this;
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

	public Type getType(TypeManager typeManager, Type staticType) {
		if (object instanceof EObject) {
			Type type = PivotUtil.findTypeOf(typeManager, ((EObject)object).eClass());
			if (type != null) {
				return type;
			}
		}
		return typeManager.getClassifierType();
	}

	@Override
	public int hashCode() {
		return object.hashCode();
	}

	@Override
	public String toString() {
		if (object instanceof EObject) {
			return PivotUtil.getLabel((EObject) object);
		}
		else {
			return String.valueOf(object);
		}
	}
}
