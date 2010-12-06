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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.ConditionPolicy;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * An <code>EObjectStructuralFeatureValueCondition</code> subclass used to
 * handle evaluation of the value held by an <code>EAttribute</code>
 */
public class EObjectAttributeValueCondition
	extends EObjectStructuralFeatureValueCondition {

	/**
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * <code>PruneHandler</code> and the sets resolving to <code>true</code>
	 * 
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EAttribute</code> from a
	 *            given context object
	 */
	public EObjectAttributeValueCondition(EAttribute attribute,
		Condition valueCondition,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(null, attribute, valueCondition, eStructuralFeatureValueGetter);
	}
	
	/**
	 * <p>
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * <code>PruneHandler</code> and the sets resolving to <code>true</code>
	 * </p>
	 * <p>
	 * The default {@link EStructuralFeatureValueGetter} will be used when accessing the
	 *  value of the EObject's attribute.
	 * </p>
	 * 
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 */
	public EObjectAttributeValueCondition(EAttribute attribute,
		Condition valueCondition) {
		this(null, attribute, valueCondition, EStructuralFeatureValueGetter.getInstance());
	}


	/**
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values. It
	 * defaults to using the PruneHandler.NEVER for the
	 * <code>PruneHandler</code> and the sets resolving to <code>true</code>
	 * 
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EAttribute</code> from a
	 *            given context object
	 */
	public EObjectAttributeValueCondition(EAttribute attribute,
		Condition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(null, attribute, valueCondition, policy,
			eStructuralFeatureValueGetter);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values. It
	 * defaults to using ConditionPolicy.ANY for the
	 * <code>ConditionPolicy</code> policy, the PruneHandler.NEVER for the
	 * <code>PruneHandler</code> and the sets resolving to <code>true</code>
	 * 
	 * @param contextEObjectCondition
	 *            An optional -could be <code>null</code>- EObjectCondition
	 *            to be applied on the eObject argument of the
	 *            isSatisified(EObject) method. If this contextEObjectCondition
	 *            is supplied, then only those EObjects who satisfy it will have
	 *            the values of their <code>EAttribute</code> examined
	 *            further, otherwise the resultant evaluation of this
	 *            <code>EObjectAttributeValueCondition</code> will be false.
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EAttribute</code> from a
	 *            given context object
	 */
	public EObjectAttributeValueCondition(
		EObjectCondition contextEObjectCondition, EAttribute attribute,
		Condition valueCondition,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(contextEObjectCondition, attribute, valueCondition,
			ConditionPolicy.ANY, eStructuralFeatureValueGetter);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values. It
	 * defaults to using the PruneHandler.NEVER for the
	 * <code>PruneHandler</code> and the sets resolving to <code>true</code>
	 * 
	 * @param contextEObjectCondition
	 *            An optional -- could be <code>null</code>- EObjectCondition
	 *            to be applied on the eObject argument of the
	 *            isSatisified(EObject) method. If this contextEObjectCondition
	 *            is supplied, then only those EObjects who satisfy it will have
	 *            the values of their <code>EAttribute</code> examined
	 *            further, otherwise the resultant evaluation of this
	 *            <code>EObjectAttributeValueCondition</code> will be false.
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EAttribute</code> from a
	 *            given context object
	 */
	public EObjectAttributeValueCondition(
		EObjectCondition contextEObjectCondition, EAttribute attribute,
		Condition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(contextEObjectCondition, attribute, valueCondition, policy,
			eStructuralFeatureValueGetter, true);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values. It
	 * defaults to using the PruneHandler.NEVER for the
	 * <code>PruneHandler</code>
	 * 
	 * @param contextEObjectCondition
	 *            An optional -- could be <code>null</code>- EObjectCondition
	 *            to be applied on the eObject argument of the
	 *            isSatisified(EObject) method. If this contextEObjectCondition
	 *            is supplied, then only those EObjects who satisfy it will have
	 *            the values of their <code>EAttribute</code> examined
	 *            further, otherwise the resultant evaluation of this
	 *            <code>EObjectAttributeValueCondition</code> will be false.
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EAttribute</code> from a
	 *            given context object
	 * @param resolve
	 *            The flag to indicate whether to resolve or not the values of
	 *            the <code>EAttribute</code> before subjecting them to
	 *            evaluation by this condition.
	 */
	public EObjectAttributeValueCondition(
		EObjectCondition contextEObjectCondition, EAttribute attribute,
		Condition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		boolean resolve) {
		this((contextEObjectCondition == null) ? PruneHandler.NEVER
			: contextEObjectCondition.getPruneHandler(),
			contextEObjectCondition, attribute, valueCondition, policy,
			eStructuralFeatureValueGetter, resolve);
	}

	/**
	 * A constructor that initializes this
	 * <code>EObjectAttributeValueCondition</code> with the passed values.
	 * 
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to use.
	 * @param contextEObjectCondition
	 *            An optional -- could be <code>null</code>- EObjectCondition
	 *            to be applied on the eObject argument of the
	 *            isSatisified(EObject) method. If this contextEObjectCondition
	 *            is supplied, then only those EObjects who satisfy it will have
	 *            the values of their <code>EAttribute</code> examined
	 *            further, otherwise the resultant evaluation of this
	 *            <code>EObjectAttributeValueCondition</code> will be false.
	 * @param attribute
	 *            The <code>EAttribute</code> whose value is to be tested
	 * @param valueCondition
	 *            the <code>Condition</code> object to use for evaluating the
	 *            <code>EAttribute</code> value
	 * @param policy
	 *            The <code>ConditionPolicy</code> to use
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> used to
	 *            extract the value of the <code>EAttribute</code> from a
	 *            given context object
	 * @param resolve
	 *            The flag to indicate whether to resolve or not the values of
	 *            the <code>EAttribute</code> before subjecting them to
	 *            evaluation by this condition.
	 */
	public EObjectAttributeValueCondition(PruneHandler pruneHandler,
		EObjectCondition contextEObjectCondition, EAttribute attribute,
		Condition valueCondition, ConditionPolicy policy,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		boolean resolve) {
		super(pruneHandler, contextEObjectCondition, attribute,
			eStructuralFeatureValueGetter, resolve, valueCondition, policy);
	}

	/**
	 * Accessor method for the <code>EAttribute</code> to whose value is to be
	 * used in the evaluation of this condition
	 * 
	 * @return EAttribute The <code>EAttribute</code> used in initialization
	 *         of this condition
	 */
	protected EAttribute getAttribute() {
		return (EAttribute) super.getFeature();
	}

	/**
	 * Overrides the parent to return the list of all EAttributes only as
	 * opposed to the entire all EStructuralFeatures.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectStructuralFeatureCondition#getFeatures(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	protected final List<EAttribute> getFeatures(EClass eClass) {
		return eClass.getEAllAttributes();
	}
}