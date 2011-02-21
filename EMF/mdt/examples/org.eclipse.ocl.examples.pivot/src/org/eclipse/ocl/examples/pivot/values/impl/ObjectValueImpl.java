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
 * $Id: ObjectValueImpl.java,v 1.5 2011/02/21 08:37:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
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
			Type type = PivotUtil.findTypeOf(((EObject)object).eClass());
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
		if (object instanceof ENamedElement) {
			ENamedElement eNamedElement = (ENamedElement)object;
			return eNamedElement.getName() + ":" + eNamedElement.eClass().getName();
		}
		else if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			EClass eClass = eObject.eClass();
			EAttribute idAttribute = eClass.getEIDAttribute();
			if (idAttribute == null) {
				for (EAttribute eAttribute : eClass.getEAllAttributes()) {
					if (eAttribute.getEType() == EcorePackage.Literals.ESTRING) {
						idAttribute = eAttribute;
						break;
					}
				}
			}
			if (idAttribute != null) {
				return eObject.eGet(idAttribute) + ":" + eClass.getName();
			}
			else {
				return "?:" + eClass.getName();
			}
		}
		else {
			return object.toString();
		}
	}
}
