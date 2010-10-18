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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;

/**
 * <p>
 * An interface used to allow clients more control over the process of
 * iteracting with <code>EObject</code> being evaluated by some
 * EObjectConditions. It acts as a layer of indirection and EObjectConditions
 * that make use of it will always be calling this interfaces methods instead of
 * invoking them directly on the <code>EObject</code> they are testing.
 * </p>
 * <p>
 * Clients may provide their own implementation.
 * </p>
 */
public interface IEStructuralFeatureValueGetter {

	/**
	 * Extract the contained EObjects of the argument eObject. and return them
	 * as a list. It uses an -optional- <code>EObjectCondition</code> as a
	 * filtering condition of the content list where only those children
	 * EObjects that satisfy the filterCondition will be returned to the caller
	 * 
	 * @param eObject
	 *            The <code>EObject</code> to extract children from
	 * @param filterCondition
	 *            The <code>EObjectCondition</code> to apply on the children
	 *            in order to remove out those that don't satisfy it. It could
	 *            be <code>null</code>.
	 * 
	 * @return List The list of children of the argument eObject.
	 */
	List<EObject> eContents(EObject eObject, EObjectCondition filterCondition);

	/**
	 * An <code>EStructuralFeature</code>'s value getter.
	 * 
	 * @param eObject
	 *            The context eObject whose <code>EStructuralFeature</code>'s
	 *            value is to be returned
	 * @param eFeature
	 *            The <code>EStructuralFeature</code> whose value is to be
	 *            returned
	 * @param resolve
	 *            A boolean flag indicating whether to resolve or not when
	 *            extracting the value.
	 * @return Object the value held by the eFeature argument
	 */
	Object eGet(EObject eObject, EStructuralFeature eFeature, boolean resolve);

	/**
	 * Prepares the argument eObject for being tested by a given
	 * <code>EObjectCondition</code> so that it won't be necessary to use this
	 * getter to call eContents or eGet on it. This function is used whenever
	 * the eObject is being passed by some <code>EObjectCondition</code> to
	 * some other evaluator that does not know about this interface, and thus,
	 * we must prepare the eObject to have its methods invoked directly. The
	 * prepared <code>EObject</code> that is returned by this function will be
	 * used for evaluation.
	 * 
	 * @param eObject
	 *            The <code>EObject</code> to be prepared
	 * @return EObject the prepared <code>EObject</code>
	 */
	EObject resolve(EObject eObject);

}