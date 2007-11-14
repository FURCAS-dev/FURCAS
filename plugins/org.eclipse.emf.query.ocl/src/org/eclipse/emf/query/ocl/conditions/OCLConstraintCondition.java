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
 * $Id: OCLConstraintCondition.java,v 1.4 2007/11/14 18:21:54 cdamus Exp $
 */

package org.eclipse.emf.query.ocl.conditions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.handlers.PruneHandler;

/**
 * A specialized OCL condition class that is used to apply boolean-valued OCL
 * expressions to <code>EObject</code>s.  These are commonly used to express
 * invariant constraints; they are not typically
 * {@linkplain OCLCondition#evaluate(EObject) evaluated} but are usually checked
 * for {@link #isSatisfied(EObject)}.
 * 
 * @deprecated Prefer the {@link BooleanOCLCondition} class, which supports
 *     customization of the OCL parsing environment as well as other metamodels
 *     than Ecore
 */
@Deprecated
public class OCLConstraintCondition
	extends OCLCondition {

	/**
	 * A simple condition constant that represents an
	 * <code>OCLConstraintCondition</code> that is always
	 * satisfied.  Functions as a literal "true".
	 */
	public static final OCLConstraintCondition NULL_CONDITION = new OCLConstraintCondition(
		null, null, (EStructuralFeatureValueGetter)null) {

		@Override
        public Object evaluate(EObject eObject) {
			return null;
		}

		@Override
        public boolean isSatisfied(EObject eObject) {
			return true;
		}
	};

	/**
	 * Initializes a constraint condition with an OCL expression string, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, and an
	 * <code>IEStructuralFeatureValueGetter</code> to use to get values of
	 * <code>StructuralFeature</code>s referenced by the OCL
	 * expression. It defaults to using <code>PruneHandler.NEVER</code> to consult
	 * for pruning.
	 * <p>
	 * <b>NOTE: </b> if <code>contextEObjectType</code> is <code>null</code>,
	 * then this becomes a context-free OCL constraint condition.
	 * </p>
	 * 
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Use <code>null</code> to create a context-free
	 *            <code>OCLCondition</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            <code>StructuralFeature</code>s' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 */
	public OCLConstraintCondition(String oclExpressionString,
		EClass contextEObjectType,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
		this(oclExpressionString, contextEObjectType,
			eStructuralFeatureValueGetter, PruneHandler.NEVER);
	}
	
	/**
	 * Initializes a constraint condition with an OCL expression string, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, and an
	 * <code>IEStructuralFeatureValueGetter</code> to use to get values of
	 * <code>StructuralFeature</code>s referenced by the OCL
	 * expression. It defaults to using <code>PruneHandler.NEVER</code> to consult
	 * for pruning.
	 * <p>
	 * <b>NOTE: </b> if <code>contextEObjectType</code> is <code>null</code>,
	 * then this becomes a context-free OCL constraint condition.
	 * </p>
	 * <p>
	 * This constructor implicitly uses the default {@link EStructuralFeatureValueGetter}
	 *  to access any EAttributes or EReferences of EObjects.
	 * </p>
	 * 
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Use <code>null</code> to create a context-free
	 *            <code>OCLCondition</code>.
	 */
	public OCLConstraintCondition(String oclExpressionString,
		EClass contextEObjectType) {
		this(oclExpressionString, contextEObjectType,
			EStructuralFeatureValueGetter.getInstance(), PruneHandler.NEVER);
	}

	/**
	 * Initializes a constraint condition with an OCL expression string, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, an <code>IEStructuralFeatureValueGetter</code>
	 * to use to get values of <code>StructuralFeature</code>s
	 * referenced by the OCL expression, and a <code>PruneHandler</code> to consult
	 * for pruning the content tree.
	 * <p>
	 * <b>NOTE: </b> if <code>contextEObjectType</code> is <code>null</code>,
	 * then this becomes a context-free OCL constraint condition.
	 * </p>
	 * 
	 * @param oclExpressionString
	 *            The OCL expression to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Use <code>null</code> to create a context-free
	 *            <code>OCLCondition</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            <code>StructuralFeature</code>s' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 */
	public OCLConstraintCondition(String oclExpressionString,
		EClass contextEObjectType,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		PruneHandler pruneHandler) {
		super(oclExpressionString, contextEObjectType,
			eStructuralFeatureValueGetter, pruneHandler);
	}

	/**
	 * Initializes a constraint condition with a compiled OCL query, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, an <code>IEStructuralFeatureValueGetter</code>
	 * to use to get values of <code>StructuralFeature</code>s
	 * referenced by the OCL expression, and a <code>PruneHandler</code> to consult
	 * for pruning the content tree.
	 * 
	 * @param oclQuery
	 *            The OCL query to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Must not be <code>null</code>.
	 * @param eStructuralFeatureValueGetter
	 *            The strategy for accessing structural feature values. It
	 *            serves as a layer of indirection to allow clients to intervene
	 *            between this condition object and the way it extracts the
	 *            <code>StructuralFeature</code>s' values so
	 *            as to allow for manipulation of such values before subjecting
	 *            them to evaluation by the OCL interpreter.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 */
	public OCLConstraintCondition(Query oclQuery,
		EClass contextEObjectType,
		IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
		PruneHandler pruneHandler) {
		
		super(oclQuery, contextEObjectType, eStructuralFeatureValueGetter,
			pruneHandler);
	}
	
	/**
	 * <p>
	 * Initializes a constraint condition with a compiled OCL query, an
	 * <code>EClass</code> representing the <code>EObject</code> type which the OCL
	 * expression uses as a context, an <code>IEStructuralFeatureValueGetter</code>
	 * to use to get values of <code>StructuralFeature</code>s
	 * referenced by the OCL expression, and a <code>PruneHandler</code> to consult
	 * for pruning the content tree.
	 * </p>
	 * <p>
	 * This constructor implicitly uses the default {@link EStructuralFeatureValueGetter}
	 *  to retrieve the values of an EObject's structural feature values.
	 * </p>
	 * 
	 * @param oclQuery
	 *            The OCL query to apply when evaluating this
	 *            <code>OCLCondition</code>
	 * @param contextEObjectType
	 *            The <code>EClass</code> representing the OCL context classifier.
	 *            Must not be <code>null</code>.
	 * @param pruneHandler
	 *            The <code>PruneHandler</code> to consult when pruning
	 */
	public OCLConstraintCondition(Query oclQuery,
		EClass contextEObjectType,
		PruneHandler pruneHandler) {
		
		super(oclQuery, contextEObjectType, EStructuralFeatureValueGetter.getInstance(),
			pruneHandler);
	}

	/**
	 * Computes the boolean value resulting from evaluating the constraint
	 * condition on the specified <code>eObject</code>.
	 */
	@Override
    public boolean isSatisfied(EObject eObject) {
		if (super.isSatisfied(eObject)) {
			return getOclQuery().check(
				getEStructuralFeatureValueGetter().resolve(eObject));
		}
		return false;
	}

}

