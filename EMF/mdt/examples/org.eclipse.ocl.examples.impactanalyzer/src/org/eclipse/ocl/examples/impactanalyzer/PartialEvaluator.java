/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.CallExp;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;

/**
 * A partial evaluator can be used to evaluate an expression at a hypothetical model
 * state as it has been before a change, as described by an EMF {@link Notification},
 * has taken place. A partial evaluator can also attempt an expression evaluation
 * without all variables being set. If an undefined variable is accessed, a
 * {@link ValueNotFoundException} is thrown, indicating the offending variable.<p>
 * 
 * With a partial evaluator it is also possible to evaluate a {@link CallExp} whose
 * {@link CallExp#getSource() source expression}'s evaluation result is already known,
 * in such a way that the source expression is not evaluated again but the value known
 * in advanced is used instead.<p>
 * 
 * Instances of the default implementation to this interface can be created using
 * the {@link PartialEvaluatorFactory}.
 * 
 * @author Axel Uhl
 *
 */
public interface PartialEvaluator {

	/**
	 * Performs a normal OCL evaluation of expression <code>c</code>. If the
	 * context object is not currently known, it's ok to pass <code>null</code>
	 * for <code>context</code>. The evaluation may fail with a
	 * {@link ValueNotFoundException} in case a variable that is accessed hasn't
	 * been defined yet. The <code>e</code> expression may therefore be some
	 * subexpression of a containing expression. To set variable values for the
	 * initial evaluation scope, use {@link #getOcl()}.
	 * {@link OCL#getEvaluationEnvironment()}.
	 * {@link EvaluationEnvironment#add(String, Object)}.
	 */
    public abstract Object evaluate(Object context, OCLExpression e);

	/**
	 * Evaluates <tt>e</tt>, assuming <tt>valueOfSourceExpression</tt> is the
	 * value to which {@link CallExp#getSource() e's source expression}
	 * evaluates. This means that during <tt>e</tt>'s evaluation the evaluator
	 * won't attempt to evaluate the source expression but uses the value
	 * provided in <tt>valueOfSourceExpression</tt> instead.
	 * <p>
	 * 
	 * @param context
	 *            a value for <tt>self</tt> can optionally be provided here. If
	 *            <tt>null</tt> is specified, a {@link ValueNotFoundException}
	 *            will be thrown upon trying to fetch the <tt>self</tt> value.
	 * @throws ValueNotFoundException
	 *             in case a variable is accessed that hasn't previously been
	 *             defined. This can happen during partial evaluation when a
	 *             variable would have been defined by a superior expression of
	 *             which <tt>e</tt> is only a subexpression.
	 */
    public abstract Object evaluate(Object context, CallExp e, Object valueOfSourceExpression);

    public abstract Helper getHelper();

    public abstract OCL getOcl();

}
