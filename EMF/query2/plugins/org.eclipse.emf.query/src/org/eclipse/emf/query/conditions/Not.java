/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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
 * A <code>Condition</code> that negates the result of evaluation of another
 * <code>Condition</code>
 */
public class Not
	extends Condition {

	private Condition condition;

	/**
	 * Constructor of this negating <code>Condition</code>
	 * 
	 * @param condition
	 *            The <code>Condition</code> whose evaluation result is
	 *            negated
	 */
	public Not(Condition condition) {
		this.condition = condition;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
	 */
	@Override
	public boolean isSatisfied(Object object) {
		return !(condition.isSatisfied(object));
	}

}