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

import java.util.Set;

import org.eclipse.emf.ecore.EObject;


/**
 * An <code>EObjectCondition</code> specialization used to test whether a
 * given <code>EObject</code> is present in a collection of EObjects
 */
public class IN
	extends EObjectCondition {

	private IEObjectSource eObjectSource;

	/**
	 * A constructor, takes in the initial EObjects set to use for evaluation
	 * 
	 * @param eObjects
	 *            The set of EObjects to check if they contain amongst them some
	 *            other <code>EObject</code>
	 */
	public IN(Set<? extends EObject> eObjects) {
		this(new EObjectSource(eObjects));
	}

	/**
	 * A simple constructor, takes in a single <code>EObject</code> to use for
	 * evaluation. In effect this makes this <code>EObjectCondition</code>
	 * behaves like <code>EObjectInstanceCondition</code>
	 * 
	 * @param eObject
	 *            The <code>EObject</code> to test for.
	 * @see EObjectInstanceCondition
	 */
	public IN(EObject eObject) {
		this(new EObjectSource(eObject));
	}

	/**
	 * A constructor, takes in the initial IEObjectSource whose supplied
	 * EObjects are to be used for evaluation
	 * 
	 * @param eObjectSource
	 *            The supplier of EObjects to use in test
	 */
	public IN(IEObjectSource eObjectSource) {
		this.eObjectSource = eObjectSource;
	}

	/**
	 * Answers whether the argument eObject exist in the initial set of EObjects
	 * held by this IN condition.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return eObjectSource.getEObjects().contains(eObject);
	}
}