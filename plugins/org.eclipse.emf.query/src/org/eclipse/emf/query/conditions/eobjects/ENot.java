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

package org.eclipse.emf.query.conditions.eobjects;

import org.eclipse.emf.ecore.EObject;

/**
 * An <code>EObjectCondition</code> that negates the result of evaluation of
 * another <code>EObjectCondition</code>. This <code>EObjectCondition</code>
 * never prune
 */
public class ENot
	extends EObjectCondition {

	private EObjectCondition condition;

	/**
	 * Constructor of this negating <code>EObjectCondition</code>
	 * 
	 * @param condition
	 *            The <code>EObjectCondition</code> whose evaluation result is
	 *            negated
	 */
	public ENot(EObjectCondition condition) {
		this.condition = condition;
	}

	/**
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(java.lang.Object)
	 */
	@Override
	public boolean isSatisfied(Object object) {
		return !(condition.isSatisfied(object));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return !(condition.isSatisfied(eObject));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#shouldPrune(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean shouldPrune(EObject eObject) {
		return false;
	}

}