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

package org.eclipse.emf.query.conditions.eobjects.structuralfeatures;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * A subclass of <code>EObjectCondition</code> that tests for the containing
 * feature of a given <code>EObject</code> to see if it is the same as a
 * specific <code>EReference</code>
 */
public class EObjectContainmentFeatureCondition
	extends EObjectCondition {

	private EReference containmentFeature;

	/**
	 * A simple constructor, it defaults to using PruneHandler.NEVER
	 * 
	 * @param containmentFeature
	 *            The <code>EReference</code> to check for
	 */
	public EObjectContainmentFeatureCondition(EReference containmentFeature) {
		this(containmentFeature, PruneHandler.NEVER);
	}

	/**
	 * A simple constructor, it initializes this
	 * <code>EObjectContainmentFeatureCondition</code> with the passed
	 * arguments.
	 * 
	 * @param containmentFeature
	 *            The <code>EReference</code> to check for
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to use
	 */
	public EObjectContainmentFeatureCondition(EReference containmentFeature,
		PruneHandler pruneHandler) {
		super(pruneHandler);
		this.containmentFeature = containmentFeature;
	}

	/**
	 * Answers whether the argument eObject containing <code>EReference</code>
	 * is the same as the one used in the initialization of this condition.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return containmentFeature.equals(eObject.eContainingFeature());
	}

}