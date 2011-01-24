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
 * $Id: AbstractDependency.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

public abstract class AbstractDependency<T> implements Dependency
{
	protected final T element;
	
	public AbstractDependency(T element) {
		this.element = element;
		assert element != null;
	}

	public abstract boolean canExecute();

	public T getElement() {
		return element;
	}		
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + '(' + element + ')';
	}

	public static AbstractDependency<?>[] combine(AbstractDependency<?> dependency1, AbstractDependency<?> dependency2) {
		if (dependency1 != null) {
			if (dependency2 != null) {
				return new AbstractDependency<?>[] {dependency1, dependency2};
			}
			else {
				return new AbstractDependency<?>[] {dependency1};
			}
		}
		else {
			if (dependency2 != null) {
				return new AbstractDependency<?>[] {dependency2};
			}
			else {
				return new AbstractDependency<?>[] {};
			}
		}
	}		
}