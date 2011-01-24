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
 * $Id: ElementValueImpl.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.values.ElementValue;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;

public class ElementValueImpl<E extends Element> extends AbstractValue implements ElementValue<E>
{
	protected final E element;
	
	public ElementValueImpl(ValueFactory valueFactory, E element) {
		super(valueFactory);
		this.element = element;
	}

	@Override
	public Element asElement() {
		return element;
	}

	public Object asObject() {
		return element;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ElementValue)) {
			return false;
		}
		return element.equals(((ElementValue<?>)obj).getElement());
	}

	public E getElement() {
		return element;
	}

	public Type getType(StandardLibrary standardLibrary, Type staticType) {
		EClass eClass = element.eClass();
		return standardLibrary.getPivotType(eClass.getName());
//		return standardLibrary.getClassifierType();
	}

	@Override
	public int hashCode() {
		return element.hashCode();
	}

	@Override
	public String toString() {
		return element.toString();
	}
}
