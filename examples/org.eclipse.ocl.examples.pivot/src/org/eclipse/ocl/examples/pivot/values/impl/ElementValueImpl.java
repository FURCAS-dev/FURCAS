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
 * $Id: ElementValueImpl.java,v 1.5 2011/03/12 13:21:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.ElementValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class ElementValueImpl<E extends Element>
		extends ObjectValueImpl
		implements ElementValue<E> {

	public ElementValueImpl(ValueFactory valueFactory, E element) {
		super(valueFactory, element);
	}

	@Override
	public Element asElement() {
		return (Element) object;
	}

	@Override
	public ElementValue<E> asElementValue() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ElementValue)) {
			return super.equals(obj);
		}
		return object.equals(((ElementValue<?>) obj).getElement());
	}

	@SuppressWarnings("unchecked")
	public E getElement() {
		return (E) object;
	}

	@Override
	public Type getType(TypeManager typeManager, Type staticType) {
		EClass eClass = ((EObject)object).eClass();
		return typeManager.getPivotType(eClass.getName());
	}
}
