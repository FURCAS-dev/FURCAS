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
 * $Id: ObjectValueImpl.java,v 1.3 2011/01/30 11:17:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
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
		if (object instanceof EObject) {
			EClass eClass = ((EObject)object).eClass();
			Resource resource = eClass.eResource();
			if (resource != null) {
				Ecore2Pivot adapter = Ecore2Pivot.findAdapter(resource);
				if (adapter != null) {
					Type type = adapter.getCreated(Type.class, eClass);
					if (type != null) {
						return type;
					}
				}
			}
		}
		return standardLibrary.getClassifierType();
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
