/**
 * <copyright>
 *
 * Copyright (c) 2002, 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.query.conditions;

/**
 * A <code>Condition</code> that tests whether the argument object instance
 * equals a given object.
 */
public class ObjectInstanceCondition
	extends Condition {

	private Object object;

	/**
	 * A simple constructor. Initializes the object instance to use for equality
	 * tests
	 * 
	 * @param object
	 *            The given object instance to test equality for
	 */
	public ObjectInstanceCondition(Object object) {
		this.object = object;
	}

	/**
	 * Tests whether the argument <code>Object</code> instance equals this
	 * <code>ObjectInstanceCondition</code>'s own <code>Object</code>
	 * instance.
	 * 
	 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
	 */
	public boolean isSatisfied(Object obj) {
		return getObject().equals(obj);
	}

	/**
	 * A getter function for the <code>Object</code> instance used by this
	 * <code>ObjectInstanceCondition</code>
	 * 
	 * @return <code>Object</code> the given object instance which we test
	 *         equality for
	 */
	protected final Object getObject() {
		return object;
	}

}