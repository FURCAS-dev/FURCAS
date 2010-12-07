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
 * $Id: BooleanOCLCondition.java,v 1.3 2007/11/14 18:21:54 cdamus Exp $
 */

package org.eclipse.emf.query.ocl.conditions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.handlers.PruneHandler;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;

/**
 * A specialized OCL condition class that is used to apply boolean-valued OCL
 * expressions to <code>EObject</code>s.  These are commonly used to express
 * invariant constraints; they are not typically
 * {@linkplain AbstractOCLCondition#evaluate(EObject) evaluated} but are usually
 * checked for {@link #isSatisfied(EObject)}.
 */
public class BooleanOCLCondition<C, CLS, E>
	extends AbstractOCLCondition<C, CLS, E> {

    /**
     * Initializes a constraint condition with an OCL expression string, a context
     * classifier representing the type of "self" in the OCL expression, and an
     * <code>IEStructuralFeatureValueGetter</code> to use to resolve the context
     * element for safe access to structural features.
     * It defaults to using <code>PruneHandler.NEVER</code> to consult
     * for pruning.
     * <p>
     * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
     * then this becomes a context-free OCL condition.
     * </p>
     * 
     * @param env an OCL environment in which to parse the expression.
     *            Must not be <code>null</code>
     * @param oclExpressionString
     *            The OCL expression to apply when evaluating this
     *            <code>OCLCondition</code>
     * @param contextClassifier
     *            The OCL context classifier.
     *            Use <code>null</code> to create a context-free condition.
     * @param eStructuralFeatureValueGetter
     *            The strategy for accessing structural feature values. It
     *            serves as a layer of indirection to allow clients to intervene
     *            between this condition object and the way it extracts the
     *            structural features' values so
     *            as to allow for manipulation of such values before subjecting
     *            them to evaluation by the OCL interpreter.
     * 
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
     */
	public BooleanOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            String oclExpressionString,
            C contextClassifier,
            IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) throws ParserException {
		this(env, oclExpressionString, contextClassifier,
			eStructuralFeatureValueGetter, PruneHandler.NEVER);
	}
	
    /**
     * Initializes a constraint condition with an OCL expression string and a context
     * classifier representing the type of "self" in the OCL expression.  A default
     * <code>IEStructuralFeatureValueGetter</code> is used to resolve the context
     * element for safe access to structural features.
     * It also defaults to using <code>PruneHandler.NEVER</code> to consult
     * for pruning.
     * <p>
     * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
     * then this becomes a context-free OCL condition.
     * </p>
     * 
     * @param env an OCL environment in which to parse the expression.
     *            Must not be <code>null</code>
     * @param oclExpressionString
     *            The OCL expression to apply when evaluating this
     *            <code>OCLCondition</code>
     * @param contextClassifier
     *            The OCL context classifier.
     *            Use <code>null</code> to create a context-free condition.
     * 
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
     */
	public BooleanOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            String oclExpressionString,
            C contextClassifier) throws ParserException {
		this(env, oclExpressionString, contextClassifier,
			EStructuralFeatureValueGetter.getInstance(), PruneHandler.NEVER);
	}

    /**
     * Initializes a constraint condition with an OCL expression string, a context
     * classifier representing the type of "self" in the OCL expression, an
     * <code>IEStructuralFeatureValueGetter</code> to use to resolve the context
     * element for safe access to structural features, and a
     * <code>PruneHandler.NEVER</code> to consult for pruning the content tree.
     * <p>
     * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
     * then this becomes a context-free OCL condition.
     * </p>
     * 
     * @param env an OCL environment in which to parse the expression.
     *            Must not be <code>null</code>
     * @param oclExpressionString
     *            The OCL expression to apply when evaluating this
     *            <code>OCLCondition</code>
     * @param contextClassifier
     *            The OCL context classifier.
     *            Use <code>null</code> to create a context-free condition.
     * @param eStructuralFeatureValueGetter
     *            The strategy for accessing structural feature values. It
     *            serves as a layer of indirection to allow clients to intervene
     *            between this condition object and the way it extracts the
     *            structural features' values so
     *            as to allow for manipulation of such values before subjecting
     *            them to evaluation by the OCL interpreter.
     * @param pruneHandler
     *            The <code>PruneHandler</code> to consult when pruning
     * 
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
     */
	public BooleanOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            String oclExpressionString,
            C contextClassifier,
            IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
            PruneHandler pruneHandler) throws ParserException {
		super(env, oclExpressionString, contextClassifier,
			eStructuralFeatureValueGetter, pruneHandler);
	}

    /**
     * Initializes a constraint condition with an OCL expression string, a context
     * classifier representing the type of "self" in the OCL expression, an
     * <code>IEStructuralFeatureValueGetter</code> to use to resolve the context
     * element for safe access to structural features, and a
     * <code>PruneHandler.NEVER</code> to consult for pruning the content tree.
     * <p>
     * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
     * then this becomes a context-free OCL condition.
     * </p>
     * 
     * @param env the OCL environment in which the OCL query was parsed.
     *            Must not be <code>null</code>
     * @param oclQuery
     *            The OCL query to apply when evaluating this condition
     * @param contextClassifier
     *            The OCL context classifier.  Must not be <code>null</code>
     * @param eStructuralFeatureValueGetter
     *            The strategy for accessing structural feature values. It
     *            serves as a layer of indirection to allow clients to intervene
     *            between this condition object and the way it extracts the
     *            structural features' values so
     *            as to allow for manipulation of such values before subjecting
     *            them to evaluation by the OCL interpreter.
     * @param pruneHandler
     *            The <code>PruneHandler</code> to consult when pruning
     * 
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
     */
	public BooleanOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            Query<C, CLS, E> oclQuery,
            C contextClassifier,
            IEStructuralFeatureValueGetter eStructuralFeatureValueGetter,
            PruneHandler pruneHandler) {
		
		super(env, oclQuery, contextClassifier, eStructuralFeatureValueGetter,
			pruneHandler);
	}
	
    /**
     * Initializes a constraint condition with an OCL expression string, a context
     * classifier representing the type of "self" in the OCL expression, and a
     * <code>PruneHandler.NEVER</code> to consult for pruning the content tree.
     * <p>
     * <b>NOTE: </b> if <code>contextClassifier</code> is <code>null</code>,
     * then this becomes a context-free OCL condition.
     * </p>
     * 
     * @param env the OCL environment in which the OCL query was parsed.
     *            Must not be <code>null</code>
     * @param oclQuery
     *            The OCL query to apply when evaluating this condition
     * @param contextClassifier
     *            The OCL context classifier.  Must not be <code>null</code>
     * @param pruneHandler
     *            The <code>PruneHandler</code> to consult when pruning
     * 
     * @throws ParserException on failure to parse the specified expression in
     *     the given classifier context, if this is not a context-free query
     */
	public BooleanOCLCondition(
            Environment<?, C, ?, ?, ?, ?, ?, ?, ?, ?, CLS, E> env,
            Query<C, CLS, E> oclQuery,
            C contextClassifier,
            PruneHandler pruneHandler) {
		
		super(env, oclQuery, contextClassifier, EStructuralFeatureValueGetter.getInstance(),
			pruneHandler);
	}

	/**
	 * Computes the boolean value resulting from evaluating the constraint
	 * condition on the specified <code>eObject</code>.
	 */
	@Override
    public boolean isSatisfied(EObject eObject) {
		if (super.isSatisfied(eObject)) {
			return getOCLQuery().check(
				getEStructuralFeatureValueGetter().resolve(eObject));
		}
		return false;
	}

}

