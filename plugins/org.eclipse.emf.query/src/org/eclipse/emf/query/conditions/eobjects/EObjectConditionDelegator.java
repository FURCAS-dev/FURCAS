/******************************************************************************
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.query.conditions.eobjects;

import org.eclipse.emf.ecore.EObject;

/**
 * A utility <code>EObjectCondition</code> class to act as a place holder for
 * another <code>EObjectCondition</code> condition object where all the calls
 * to it is simply forwarded to the wrapped <code>EObjectCondition</code>.
 * Helps if when clients need an <code>EObjectCondition</code> to hold onto at
 * a time when the actual <code>EObjectCondition</code> cannot be constructed
 * for some reason or another, this way, a
 * <code>EObjectConditionDelegator</code> can be returned while the delegated
 * to <code>EObjectCondition</code> could be constructed later when more info
 * is available. One other use is that when the client will hold on to an
 * <code>EObjectCondition</code> while the requirements dictate that the
 * <code>EObjectCondition</code> to use for evaluation could change over time,
 * if the supplier of the <code>EObjectCondition</code> has no way of
 * informing the clients of the change in the implementation of the
 * <code>EObjectCondition</code>, it can pass on this
 * <code>EObjectConditionDelegator</code> as wrapper for the
 * <code>EObjectCondition</code> to use at the time of the request, and later
 * on, the supplier can change the <code>EObjectCondition</code> to use at a
 * later time and all the clients out there will be getting the latest version
 * of the <code>EObjectCondition</code> to use for evaluation.
 * 
 * Please note that it is the responsibility of the supplier of this
 * <code>EObjectConditionDelegator</code> to ensure that it is properly
 * initialized with the real <code>EObjectCondition</code> before the
 * <code>EObjectConditionDelegator</code> is being used for evaluation by
 * clients since this <code>EObjectConditionDelegator</code> will simply
 * forward the evaluation call to the wrapped <code>EObjectCondition</code>.
 *  
 */
public class EObjectConditionDelegator
	extends EObjectCondition {

	private EObjectCondition eObjectCondition;

	/**
	 * A simple constructor, initializes the wrapped
	 * <code>EObjectCondition</code> to <code>null</code>. The supplier of
	 * this <code>EObjectConditionDelegator</code> must ensure that a valid
	 * <code>EObjectCondition</code> is passed to this
	 * <code>EObjectConditionDelegator</code> before any calls for evaluation
	 * are made on it.
	 */
	public EObjectConditionDelegator() {
		this(null);
	}

	/**
	 * A constructor that uses the argument <code>EObjectCondition</code> as
	 * its wrapped <code>EObjectCondition</code>.
	 * 
	 * @param eObjectCondition
	 *            the delegated-to <code>EObjectCondition</code> where all
	 *            calls made on this <code>EObjectConditionDelegator</code>
	 *            will be forwarded to.
	 */
	public EObjectConditionDelegator(EObjectCondition eObjectCondition) {
		this.eObjectCondition = eObjectCondition;
	}

	/**
	 * Overrides the parent's implementation by simply forwarding the actual
	 * evaluation to the wrapped <code>EObjectCondition</code>.
	 * 
	 * @see org.eclipse.emf.query.conditions.Condition#isSatisfied(java.lang.Object)
	 */
	@Override
	public boolean isSatisfied(Object object) {
		return eObjectCondition.isSatisfied(object);
	}

	/**
	 * The implementation of this function simply forwards the actual evaluation
	 * to the wrapped <code>EObjectCondition</code>.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return eObjectCondition.isSatisfied(eObject);
	}

	/**
	 * The implementation of this function simply forwards the actual evaluation
	 * to the wrapped <code>EObjectCondition</code>.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#shouldPrune(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean shouldPrune(EObject eObject) {
		return eObjectCondition.shouldPrune(eObject);
	}

	/**
	 * Sets the wrapped <code>EObjectCondition</code> used by this
	 * <code>EObjectConditionDelegator</code>. Could be completely different
	 * than the original one passed when constructing.
	 * 
	 * @param eObjectCondition
	 *            the <code>EObjectCondition</code> to forward calls to by
	 *            this <code>EObjectConditionDelegator</code>
	 */
	public void setEObjectCondition(EObjectCondition eObjectCondition) {
		this.eObjectCondition = eObjectCondition;
	}

}
