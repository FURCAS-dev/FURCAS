/**
 * <copyright>
 *
 * Copyright (c) 2004-2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.helper;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;

/**
 * A utility object that provides OCL syntax completion suggestions for OCL
 * expressions on the metamodel and user model levels.  Metamodel OCL help is
 * available for any EMF metamodel, but user model help is only available for
 * metamodels for which an
 * {@link org.eclipse.gmf.runtime.emf.core.usermodel.IUserModelSupport} extension is
 * available.
 * <p>
 * Helpers of these two flavours can be created via the
 * {@link HelperUtil#createOclHelper(ModelingLevel)} method, which accepts
 * an enumerated modeling level parameter to indicate metamodel or user-model
 * level.
 * </p>
 * <p>
 * <b>Note</b> that this interface is not intended to be implemented
 * by clients.
 * </p>
 * 
 * @see HelperUtil#createOclHelper(EnvironmentFactory)
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
public interface IOclHelper {

	/**
	 * Sets the context of the OCL expression for which syntax or parsing help is
	 * to be provided.  The context may be either the specific model element
	 * on which an OCL expression would be evaluated, or it may be an
	 * {@link EClassifier} of the target metamodel against which an OCL
	 * expression would be parsed.  Note that, in the former case, the actual
	 * OCL context classifier (as an OCL type or {@link EClassifier}) will be
	 * inferred from the context object according to the nature of the
	 * {@linkplain #getEnvironmentFactory() environment factory}.
	 *
	 * @param context the OCL context object or classifier
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	public void setContext(Object context);

	/**
	 * Obtains my OCL context classifier as an EMF classifier.
	 * 
	 * @return my context classifier (never <code>null</code>)
	 */
	public EClassifier getContextClassifier();
	
	/**
	 * Sets the context of the OCL expression for which syntax or parsing help is
	 * to be provided.  The operation is the model element against which
	 * the OCL will be parsed as an operation applicable to an OCL classifier;
	 * this model element must be able to be represented as an OCL operation.
	 *
	 * @param context the OCL context object
	 * @param operation the OCL context operation
	 * 
	 * @see #setContext(Object)
	 */
	public void setContextOperation(Object context, Object operation);

	/**
	 * Obtains my context operation as an EMF operation, if my environment is
	 * an operation context.
	 * 
	 * @return my context operation, or <code>null</code> if there is only a
	 *     classifier context
	 */
	public EOperation getContextOperation();

	/**
	 * Obtains syntax completion choices for the specified fragment of an OCL
	 * expression.  The choices returned (if any) will be appropriate for
	 * appending to the end of the specified text.
	 *
	 * @param txt a partial OCL expression for which to seek choices that
	 *      could be appended to it
	 * @return a list of {@link Choice}s, possibly empty.  The ordering of the
	 *      list may or may not indicate relative relevance or frequency of
	 *      a choice
	 */
	public List getSyntaxHelp(String txt);

	/**
	 * Creates an invariant constraint in the current classifier context.
	 * 
	 * @param expression the constraint expression (without any context declaration)
	 * 
	 * @return the invariant condition
	 * 
	 * @throws OclParsingException if the <code>expression</code> fails to parse
	 */
	OclExpression createInvariant(String expression) throws OclParsingException;

	/**
	 * Creates an operation precondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context declaration)
	 * 
	 * @return the precondition
	 * 
	 * @throws OclParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	OclExpression createPrecondition(String expression) throws OclParsingException;

	/**
	 * Creates an operation postcondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context declaration)
	 * 
	 * @return the postcondition
	 * 
	 * @throws OclParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	OclExpression createPostcondition(String expression) throws OclParsingException;

	/**
	 * Creates an operation body.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context declaration)
	 * 
	 * @return the body.  Note that it is not a constraint condition because
	 *     it may have a non-boolean value
	 * 
	 * @throws OclParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	OclExpression createBodyCondition(String expression) throws OclParsingException;

	/**
	 * Evaluates the specified parsed OCL expression on an instance of my
	 * context classifier.  This expression needs not be a boolean-valued
	 * constraint.
	 * 
	 * @param context the context object on which to evaluate the expression.
	 *     This is the <tt>self</tt> object, if the expression requires one.
	 *     Note the it is required even for expressions that use the
	 *     <tt>allInstances()</tt> operation to get the instances of an OCL
	 *     classifier, in order to find resources to search for instances
	 *     (unless the context is a data type, in which case the instances are
	 *     not enumerated by models)
	 * @param expr an expression to evaluate
	 * 
	 * @return the result of the expression evaluation.  This can be a single
	 *     object, a collection of objects, or even <code>null</code>
	 */
	Object evaluate(Object context, OclExpression expression);

	/**
	 * Evaluates the specified expression on an instance of my context
	 * classifier.  This expression needs not be a boolean-valued constraint.
	 * This method parses and evaluates the OCL expression in one step.
	 * 
	 * @param context the context object on which to evaluate the expression.
	 *     This is the <tt>self</tt> object, if the expression requires one.
	 *     Note the it is required even for expressions that use the
	 *     <tt>allInstances()</tt> operation to get the instances of an OCL
	 *     classifier, in order to find resources to search for instances
	 *     (unless the context is a data type, in which case the instances are
	 *     not enumerated by models)
	 * @param expr an expression to evaluate
	 * 
	 * @return the result of the expression evaluation.  This can be a single
	 *     object, a collection of objects, or even <code>null</code>
	 * 
	 * @throws OclParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #evaluate(Object, OclExpression)
	 */
	Object evaluate(Object context, String expression) throws OclParsingException;

	/**
	 * Evaluates the specified constraint on an instance of my context
	 * classifier and returns whether the constraint is satisfied.  This
	 * expression must be boolean-valued.
	 * 
	 * @param context the context object on which to evaluate the expression.
	 *     This is the <tt>self</tt> object, if the expression requires one.
	 *     Note the it is required even for expressions that use the
	 *     <tt>allInstances()</tt> operation to get the instances of an OCL
	 *     classifier, in order to find resources to search for instances
	 *     (unless the context is a data type, in which case the instances are
	 *     not enumerated by models)
	 * @param constraint a constraint expression to evaluate
	 * 
	 * @return <code>true</code> if the <code>context</code> object satisfies
	 *     the <code>constraint</code>; <code>false</code>, otherwise
	 * 
	 * @throws IllegalArgumentException if the <code>constraint</code> is not
	 *     boolean-valued
	 */
	boolean check(Object context, OclExpression constraint);

	/**
	 * Evaluates the specified constraint on an instance of my context
	 * classifier and returns whether the constraint is satisfied.  This
	 * expression must be boolean-valued.  This method parses and evaluates the
	 * OCL constraint in one step.
	 * 
	 * @param context the context object on which to evaluate the expression.
	 *     This is the <tt>self</tt> object, if the expression requires one.
	 *     Note the it is required even for expressions that use the
	 *     <tt>allInstances()</tt> operation to get the instances of an OCL
	 *     classifier, in order to find resources to search for instances
	 *     (unless the context is a data type, in which case the instances are
	 *     not enumerated by models)
	 * @param constraint a constraint expression to evaluate
	 * 
	 * @return <code>true</code> if the <code>context</code> object satisfies
	 *     the <code>constraint</code>; <code>false</code>, otherwise
	 * 
	 * @throws OclParsingException if the <code>expression</code> fails to parse
	 * @throws IllegalArgumentException if the <code>constraint</code> is not
	 *     boolean-valued
	 *     
	 * @see #check(Object, OclExpression)
	 */
	boolean check(Object context, String constraint) throws OclParsingException;
	
	/**
	 * Retrieves the environment factory for the metamodel that I am helping.
	 * 
	 * @return my environment factory (never <code>null</code>)
	 */
	EnvironmentFactory getEnvironmentFactory();
}