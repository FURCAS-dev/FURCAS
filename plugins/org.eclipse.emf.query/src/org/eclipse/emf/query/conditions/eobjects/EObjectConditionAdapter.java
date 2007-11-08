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

import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * This is an adapter class that takes in a <code>Condition</code> object and
 * wraps it in order to adapt it to an <code>EObjectCondition</code>.
 * Evaluation is forwarded to the adapted <code>Condition</code> object, while
 * the <code>PruneHandler<code>
 * used defaults to PruneHandler.NEVER
 */
public class EObjectConditionAdapter
	extends EObjectCondition {

	private Condition condition;

	/**
	 * A simple constructor that takes in the <code>Condition</code> object to
	 * adapt. It uses PruneHandler.NEVER as its prune-handler.
	 * 
	 * @param condition
	 *            The <code>Condition</code> object to be adapted
	 */
	public EObjectConditionAdapter(Condition condition) {
		this(condition, PruneHandler.NEVER);
	}

	/**
	 * A constructor that takes in the <code>Condition</code> object to adapt,
	 * and the <code>PruneHandler</code> to use.
	 * 
	 * @param condition
	 *            The <code>Condition</code> object to be adapted
	 * @param pruneHandler
	 *            the <code>PruneHandler</code> to consult for pruning
	 */
	public EObjectConditionAdapter(Condition condition,
		PruneHandler pruneHandler) {
		super(pruneHandler);
		this.condition = condition;
	}

	/**
	 * The implementation of this function simply forwards the actual evaluation
	 * to the adapted <code>Condition</code>.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return condition.isSatisfied(eObject);
	}

}