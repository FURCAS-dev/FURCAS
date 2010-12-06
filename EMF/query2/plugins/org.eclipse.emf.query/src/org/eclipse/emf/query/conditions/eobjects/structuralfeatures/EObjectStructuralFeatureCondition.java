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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * <p>
 * The base abstract class of all conditions pertaining to EStructuralFeatures.
 * </p>
 * <p>
 * This class is intended to be extended by clients.
 * </p>
 */
public abstract class EObjectStructuralFeatureCondition
	extends EObjectCondition {

	private EStructuralFeature feature;

	/**
	 * A constructor, initializes the
	 * <code>EObjectStructuralFeatureCondition</code> with basic values.
	 * 
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 * @param feature
	 *            The <code>EStructuralFeature</code> used for evaluation by
	 *            this <code>EObjectStructuralFeatureCondition</code>
	 */
	public EObjectStructuralFeatureCondition(PruneHandler pruneHandler,
		EStructuralFeature feature) {
		super(pruneHandler);
		this.feature = feature;
	}

	/**
	 * Answers whether the argument eObject has the
	 * <code>EStructuralFeature</code> used in initialization of this
	 * <code>EObjectStructuralFeatureCondition</code>
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		return getFeatures(eObject.eClass()).contains(feature);
	}

	/**
	 * A getter for the <code>EStructuralFeature</code> used in initialization
	 * of this <code>EObjectStructuralFeatureCondition</code>
	 * 
	 * @return <code>EStructuralFeature</code> the feature used in
	 *         initialization of this
	 *         <code>EObjectStructuralFeatureCondition</code>
	 */
	protected final EStructuralFeature getFeature() {
		return feature;
	}

	/**
	 * Returns the list of all EStructuralFeatures of the given EClass that are
	 * consequently to be used for testing and evaluation of this condition
	 * object
	 * 
	 * @param eClass
	 *            the Eclass from which to get all the EStructuralFeatures to be
	 *            used for testing and evaluation of this condition object
	 * @return List a list of the all the EStructuralFeatures from the argument
	 *         EClass and are consequently to be used for testing and evaluation
	 *         of this condition object
	 */
	protected List<? extends EStructuralFeature> getFeatures(EClass eClass) {
		return eClass.getEAllStructuralFeatures();
	}

}