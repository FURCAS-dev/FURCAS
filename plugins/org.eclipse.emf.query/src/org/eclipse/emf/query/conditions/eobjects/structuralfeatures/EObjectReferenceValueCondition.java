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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.query.conditions.ConditionPolicy;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * An <code>EObjectStructuralFeatureValueCondition</code> subclass used to
 * handle evaluation of the value held by an <code>EReference</code>
 */
public class EObjectReferenceValueCondition
	extends EObjectStructuralFeatureValueCondition {

	/**
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * PruneHandler and the sets resolving to <code>true</code>
	 * 
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EReference</code> from a
	 *            given context object
	 */
	public EObjectReferenceValueCondition(EReference reference,
		EObjectCondition valueCondition,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(null, reference, valueCondition, eStructuralFeatureValueGetter);
	}
	
	/**
	 * <p>
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * PruneHandler and the sets resolving to <code>true</code>
	 * </p>
	 * <p>
	 * The default {@link EStructuralFeatureValueGetter} will be used when accessing the
	 *  value of the EObject's EReference.
	 * </p>
	 * 
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 */
	public EObjectReferenceValueCondition(EReference reference,
		EObjectCondition valueCondition) {
		this(null, reference, valueCondition, EStructuralFeatureValueGetter.getInstance());
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using the PruneHandler.NEVER for the PruneHandler and the
	 * sets resolving to <code>true</code>
	 * 
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EReference</code> from a
	 *            given context object
	 */
	public EObjectReferenceValueCondition(EReference reference,
		EObjectCondition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(null, reference, valueCondition, policy,
			eStructuralFeatureValueGetter);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * PruneHandler and the sets resolving to <code>true</code>
	 * 
	 * @param contextEObjectCondition
	 *            An optional -could be <code>null</code>-
	 *            <code>EObjectCondition</code> to be applied on the eObject
	 *            argument of the isSatisified(EObject) method. If this
	 *            contextEObjectCondition is supplied, then only those EObjects
	 *            who satisfy it will have the values of their
	 *            <code>EReference</code> examined further, otherwise the
	 *            resultant evaluation of this
	 *            <code>EObjectReferenceValueCondition</code> will be false.
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            The <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EReference</code> from a
	 *            given context object
	 */
	public EObjectReferenceValueCondition(
		EObjectCondition contextEObjectCondition, EReference reference,
		EObjectCondition valueCondition,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(contextEObjectCondition, reference, valueCondition,
			ConditionPolicy.ANY, eStructuralFeatureValueGetter);
	}
	
	/**
	 * <p>
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * PruneHandler and the sets resolving to <code>true</code>
	 * </p>
	 * <p>
	 * The default {@link EStructuralFeatureValueGetter} will be used when accessing the
	 *  value of the EObject's EReference.
	 * </p>
	 * 
	 * @param contextEObjectCondition
	 *            An optional -could be <code>null</code>-
	 *            <code>EObjectCondition</code> to be applied on the eObject
	 *            argument of the isSatisified(EObject) method. If this
	 *            contextEObjectCondition is supplied, then only those EObjects
	 *            who satisfy it will have the values of their
	 *            <code>EReference</code> examined further, otherwise the
	 *            resultant evaluation of this
	 *            <code>EObjectReferenceValueCondition</code> will be false.
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            The <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 */
	public EObjectReferenceValueCondition(
		EObjectCondition contextEObjectCondition, EReference reference,
		EObjectCondition valueCondition) {
		this(contextEObjectCondition, reference, valueCondition,
			ConditionPolicy.ANY, EStructuralFeatureValueGetter.getInstance());
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using the PruneHandler.NEVER for the PruneHandler and the
	 * sets resolving to <code>true</code>
	 * 
	 * @param contextEObjectCondition
	 *            An optional -- could be <code>null</code>-
	 *            <code>EObjectCondition</code> to be applied on the eObject
	 *            argument of the isSatisified(EObject) method. If this
	 *            contextEObjectCondition is supplied, then only those EObjects
	 *            who satisfy it will have the values of their
	 *            <code>EReference</code> examined further, otherwise the
	 *            resultant evaluation of this
	 *            <code>EObjectReferenceValueCondition</code> will be false.
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            The <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EReference</code> from a
	 *            given context object
	 */
	public EObjectReferenceValueCondition(
		EObjectCondition contextEObjectCondition, EReference reference,
		EObjectCondition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(contextEObjectCondition, reference, valueCondition, policy,
			eStructuralFeatureValueGetter, true);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values. It
	 * defaults to using the PruneHandler.NEVER for the PruneHandler
	 * 
	 * @param contextEObjectCondition
	 *            An optional -- could be <code>null</code>-
	 *            <code>EObjectCondition</code> to be applied on the eObject
	 *            argument of the isSatisified(EObject) method. If this
	 *            contextEObjectCondition is supplied, then only those EObjects
	 *            who satisfy it will have the values of their
	 *            <code>EReference</code> examined further, otherwise the
	 *            resultant evaluation of this
	 *            <code>EObjectReferenceValueCondition</code> will be false.
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            The <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EReference</code> from a
	 *            given context object
	 * @param resolve
	 *            The flag to indicate whether to resolve or not the values of
	 *            the <code>EReference</code> before subjecting them to
	 *            evaluation by this condition.
	 */
	public EObjectReferenceValueCondition(
		EObjectCondition contextEObjectCondition, EReference reference,
		EObjectCondition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		boolean resolve) {
		this((contextEObjectCondition == null) ? PruneHandler.NEVER
			: contextEObjectCondition.getPruneHandler(),
			contextEObjectCondition, reference, valueCondition, policy,
			eStructuralFeatureValueGetter, resolve);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectReferenceValueCondition</code> with the passed values.
	 * 
	 * @param pruneHandler
	 *            The PruneHandler to use.
	 * @param contextEObjectCondition
	 *            An optional -- could be <code>null</code>-
	 *            <code>EObjectCondition</code> to be applied on the eObject
	 *            argument of the isSatisified(EObject) method. If this
	 *            contextEObjectCondition is supplied, then only those EObjects
	 *            who satisfy it will have the values of their
	 *            <code>EReference</code> examined further, otherwise the
	 *            resultant evaluation of this
	 *            <code>EObjectReferenceValueCondition</code> will be false.
	 * @param reference
	 *            The <code>EReference</code> whose value is to be tested
	 * @param valueCondition
	 *            The <code>EObjectCondition</code> object to use for
	 *            evaluating the <code>EReference</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EReference</code> from a
	 *            given context object
	 * @param resolve
	 *            The flag to indicate whether to resolve or not the values of
	 *            the <code>EReference</code> before subjecting them to
	 *            evaluation by this condition.
	 */
	public EObjectReferenceValueCondition(PruneHandler pruneHandler,
		EObjectCondition contextEObjectCondition, EReference reference,
		EObjectCondition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		boolean resolve) {
		super(pruneHandler, contextEObjectCondition, reference,
			eStructuralFeatureValueGetter, resolve, valueCondition, policy);
	}

	/**
	 * Accessor method for the <code>EReference</code> to whose value is to be
	 * used in the evaluation of this condition
	 * 
	 * @return EReference The <code>EReference</code> used in initialization
	 *         of this condition
	 */
	protected EReference getReference() {
		return (EReference) super.getFeature();
	}

	/**
	 * Overrides the parent to return the list of all EReferences only as
	 * opposed to the entire all EStructuralFeatures.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectStructuralFeatureCondition#getFeatures(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	protected final List<EReference> getFeatures(EClass eClass) {
		return eClass.getEAllReferences();
	}

}