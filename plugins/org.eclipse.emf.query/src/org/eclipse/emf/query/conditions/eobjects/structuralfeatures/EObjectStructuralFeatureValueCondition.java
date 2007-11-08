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
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.ConditionPolicy;
import org.eclipse.emf.query.conditions.ObjectInstanceCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectInstanceCondition;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * An <code>EObjectStructuralFeatureCondition</code> specialization and the
 * base class of conditions that test for the values held by the various
 * <code>EStructuralFeature</code>. This condition can handle both
 * single-valued and multiple-valued EStructuralFeatures.
 * 
 * It is important to know the following about how evaluation is carried out by
 * this condition:
 * <ul>
 * <li>If a contextEObjectCondition is supplied, the <code>EObject</code>
 * being evaluated will have to satisfy it first before having its
 * <code>EStructuralFeature</code> examined.
 * <li>
 * <li>If the <code>EObject</code> passed for the isSatisfied(EObject) method
 * of this condition does not have the <code>EStructuralFeature</code> in
 * question then resultant evaluation of this condition will be
 * <code>false</code>.</li>
 * 
 * <li>If the <code>EStructuralFeature</code> in question in not set -i.e.,
 * calling eIsSet() method on the <code>EStructuralFeature</code> returns
 * <code>false</code>, no further evaluation is done on the
 * <code>EStructuralFeature</code> and the resultant evaluation of this
 * condition will be <code>false</code></li>.
 * 
 * <li>If the value of a single-valued <code>EStructuralFeature</code> is
 * <code>null</code>, then no further evaluation is done on the
 * <code>EStructuralFeature</code> and the resultant evaluation of this
 * condition will be <code>false</code></li>
 * 
 * <li>If the collection returned as a value of a multiple-valued
 * <code>EStructuralFeature</code> is empty, then no further evaluation is
 * done on the <code>EStructuralFeature</code> and the resultant evaluation of
 * this condition will be <code>false</code></li>
 * </ul>
 * 
 * @see IEStructuralFeatureValueGetter
 * @see ConditionPolicy
 */
public abstract class EObjectStructuralFeatureValueCondition
	extends EObjectStructuralFeatureCondition {

	private StructuralFeatureValueEvaluator evaluator;

	private EObjectCondition featureCondition;

	/**
	 * The constructor of this EObjectStructuralFeatureValueCondition object, it
	 * initializes it with the proper values.
	 * 
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to use
	 * @param contextEObjectCondition
	 *            an optional <code>EObjectCondition</code> to use to check
	 *            the context <code>EObject</code> which is the
	 *            <code>EObject</code> passed to the isSatisfied(EObject)
	 *            method for evaluation, which also serves as the context within
	 *            which the <code>EStructuralFeature</code>'s value exists
	 *            -and hence the name. This contextEObjectCondition is optional
	 *            and hence could be <code>null</code>
	 * @param feature
	 *            The <code>EStructuralFeature</code> to check its value
	 * @param eStructuralFeatureValueGetter
	 *            The <code>IEStructuralFeatureValueGetter</code> to be used
	 *            by this <code>EObjectStructuralFeatureValueCondition</code>
	 *            to extract the value of the <code>EStructuralFeature</code>
	 *            of interest. It serves as a layer of indirection to allow
	 *            clients to intervene between this condition object and the way
	 *            it extracts the <code>EStructuralFeature</code>'s value so
	 *            as to allow for possible messaging of such value before
	 *            subjecting it to evaluation.
	 * @param resolve
	 *            A boolean flag to instruct this condition on whether or not it
	 *            should resolve a given value before evaluating it or not. This
	 *            flag will be passed to the eStructuralFeatureValueGetter since
	 *            it is the one responsible for getting EStructuralFeatures
	 *            values.
	 * @param valueCondition
	 *            The primary condition to be employed in checking the
	 *            EStructuralFeatures values
	 * @param policy
	 *            The <code>ConditionPolicy</code> to be used to determine how
	 *            to interpret the evaluation results as returned by the
	 *            valueCondition especially in the case of EStructuralFeatures
	 *            that hold collection of values.
	 */
	public EObjectStructuralFeatureValueCondition(PruneHandler pruneHandler,
		EObjectCondition contextEObjectCondition, EStructuralFeature feature,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		boolean resolve, Condition valueCondition, ConditionPolicy policy) {
		super(pruneHandler, feature);
		
		if (feature.getUpperBound() == ETypedElement.UNSPECIFIED_MULTIPLICITY) {
			evaluator = new UnspecifiedStructuralFeatureValueEvaluator(valueCondition,
				policy, feature, eStructuralFeatureValueGetter, resolve);
		} else {
			evaluator = (feature.isMany()) ? new MultipleStructuralFeatureValueEvaluator(
				valueCondition, policy, feature, eStructuralFeatureValueGetter,
				resolve)
				: new StructuralFeatureValueEvaluator(valueCondition, policy,
					feature, eStructuralFeatureValueGetter, resolve);
		}
		
		featureCondition = (contextEObjectCondition == null) ? evaluator
			: contextEObjectCondition.AND(evaluator);
	}

	/**
	 * Checks the value held by the initialization
	 * <code>EStructuralFeature</code> to see if it satisfies this condition.
	 * If the eObject passed for evaluation does not have the
	 * <code>EStructuralFeature</code> in question the result of this
	 * evaluation will be <code>false</code>.
	 * 
	 * @see org.eclipse.emf.query.conditions.eobjects.EObjectCondition#isSatisfied(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isSatisfied(EObject eObject) {
		if (super.isSatisfied(eObject)) {
			return featureCondition.isSatisfied(eObject);
		}
		return false;
	}

	/**
	 * Accessor method for the the <code>EObjectCondition</code> that is used
	 * for actual testing of <code>EStructuralFeature</code>'s value in order
	 * to determine if it satisfies this condition or not.
	 * 
	 * @return EObjectCondition the <code>EObjectCondition</code> used to
	 *         evaluate the <code>EStructuralFeature</code>
	 */
	protected final EObjectCondition getStructuralFeatureCondition() {
		return featureCondition;
	}

	/**
	 * Accessor method for the resolve argument used in initialization of this
	 * condition
	 * 
	 * @return boolean the value resolve argument used in initialization of this
	 *         condition
	 */
	protected final boolean isResolve() {
		return evaluator.resolve;
	}

	/**
	 * Accessor method for the policy argument used in initialization of this
	 * condition
	 * 
	 * @return ConditionPolicy the policy used in evaluation
	 */
	public final ConditionPolicy getPolicy() {
		return evaluator.policy;
	}

	private static class StructuralFeatureValueEvaluator
		extends EObjectCondition {

		Condition valueCondition;

		ConditionPolicy policy;

		EStructuralFeature feature;

		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;

		boolean resolve;

		StructuralFeatureValueEvaluator(Condition valueCondition,
			ConditionPolicy policy, EStructuralFeature feature,
			IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
			boolean resolve) {
			this.valueCondition = valueCondition;
			this.policy = policy;
			this.feature = feature;
			this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
			this.resolve = resolve;
		}

        @Override
		public boolean isSatisfied(EObject eObject) {
            Object featureValue = null;
            if (eObject.eIsSet(feature)) {
                featureValue = eStructuralFeatureValueGetter.eGet(eObject,
                    feature, resolve);
            } else if (feature.getDefaultValue() != null) {
                featureValue = feature.getDefaultValue();
            }

            if (featureValue == null) {
                // are we looking for null via the supported means?
                if (isNullSearchCondition(valueCondition)) {
                    return policy.isSatisfied(valueCondition, featureValue);
                }

                return false;
            }

            return policy.isSatisfied(valueCondition, featureValue);
        }

        private boolean isNullSearchCondition(Condition cond) {
            return (cond == ObjectInstanceCondition.IS_NULL)
                || (cond == EObjectInstanceCondition.IS_NULL);
        }
	}

	private static class MultipleStructuralFeatureValueEvaluator
		extends StructuralFeatureValueEvaluator {

		MultipleStructuralFeatureValueEvaluator(Condition valueCondition,
			ConditionPolicy policy, EStructuralFeature feature,
			IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
			boolean resolve) {
			super(valueCondition, policy, feature,
				eStructuralFeatureValueGetter, resolve);
		}

		@Override
		public boolean isSatisfied(EObject eObject) {
			List<?> list = null;
			if (eObject.eIsSet(feature)) {
				list = (List<?>) eStructuralFeatureValueGetter.eGet(eObject,
					feature, resolve);
			} else if (feature.getDefaultValue() != null) {
				list = (List<?>) feature.getDefaultValue();
			}
			
			return (list == null || list.isEmpty()) ? false : policy.isSatisfied(
					valueCondition, list);
		}
	}
	
	private static class UnspecifiedStructuralFeatureValueEvaluator
		extends StructuralFeatureValueEvaluator {
		
		private MultipleStructuralFeatureValueEvaluator multipleEvaluator;
		private StructuralFeatureValueEvaluator singleEvaluator;
		
		UnspecifiedStructuralFeatureValueEvaluator(Condition valueCondition,
			ConditionPolicy policy, EStructuralFeature feature,
			IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
			boolean resolve) {
			super(valueCondition, policy, feature,
				eStructuralFeatureValueGetter, resolve);
			
			multipleEvaluator = new MultipleStructuralFeatureValueEvaluator(valueCondition,
				policy, feature, eStructuralFeatureValueGetter, resolve);
			
			singleEvaluator = new StructuralFeatureValueEvaluator(valueCondition,
				policy, feature, eStructuralFeatureValueGetter, resolve);
		}
		
		@Override
		public boolean isSatisfied(EObject eObject) {
			if (FeatureMapUtil.isMany(eObject, feature)) {
				return multipleEvaluator.isSatisfied(eObject);
			} else {
				return singleEvaluator.isSatisfied(eObject);
			}
		}
	}

}