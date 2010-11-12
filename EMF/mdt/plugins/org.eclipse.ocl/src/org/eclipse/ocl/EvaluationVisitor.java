/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: EvaluationVisitor.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
 */

package org.eclipse.ocl;

import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * A specialized visitor that is used for evaluation an
 * {@linkplain OCLExpression OCL expression} by walking its AST.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public interface EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> 
		extends Visitor<Object, C, O, P, EL, PM, S, COA, SSA, CT> {
	
	/**
     * Obtains the environment that provides the metamodel semantics for the
     * expression to be evaluated.
     *  
	 * @return the environment
	 */
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getEnvironment();

	/**
     * Obtains the evaluation environment that keeps track of variable values
     * and knows how to call operations, navigate properties, etc.
     * 
	 * @return the evaluation environment
	 */
	public EvaluationEnvironment<C, O, P, CLS, E> getEvaluationEnvironment();
	
	/**
     * Obtains the mapping of model classes to their extends.
     * 
	 * @return the extent map
	 */
	public Map<? extends CLS, ? extends Set<? extends E>> getExtentMap();
	
	/**
	 * Evaluates the specified <tt>expression</tt> on the current "self" context
	 * object.  This result type of this expression may be any type.  An
	 * implementation will typically just call {@link Visitable#accept(Visitor)}
	 * on the <tt>expression</tt>, but is free to elaborate on that.  Thus,
	 * clients should not simply ask the <tt>expression</tt> to accept this
	 * visitor.
	 * 
	 * @param expression the expression to evaluate
	 * 
	 * @return the value of the expression
	 */
	public Object visitExpression(OCLExpression<C> expression);
	
	/**
	 * Checks that the specified <tt>constraint</tt> is satisfied by the
	 * current "self" context object or, in the case of an operation body
	 * condition, evaluates the body expression.
	 * 
	 * @return for boolean-valued constraints (invariant, precondition, postcondition)
	 *     <tt>Boolean.TRUE</tt> if the constraint holds and <tt>Boolean.FALSE</tt>
	 *     if it is violated (including evaluations that result in <tt>OclInvalid</tt>).
	 *     For operation body conditions, the value of the operation result
	 * 
	 * @throws IllegalArgumentException if the constraint is one that must
	 *    be boolean-valued but the computed result is not of boolean type
	 *    (or <tt>OclInvalid</tt>)
	 */
	public Object visitConstraint(CT constraint);
}
