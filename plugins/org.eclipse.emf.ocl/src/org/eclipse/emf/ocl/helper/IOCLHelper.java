/**
 * <copyright>
 *
 * Copyright (c) 2004, 2008 IBM Corporation and others.
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
 * $Id: IOCLHelper.java,v 1.12 2008/03/26 21:20:15 cdamus Exp $
 */

package org.eclipse.emf.ocl.helper;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;

/**
 * A utility object that provides OCL syntax completion suggestions for OCL
 * expressions on the metamodel and user model levels.  Metamodel OCL help is
 * available for any EMF metamodel via the {@link EcoreEnvironmentFactory}, but
 * user model help is only available for metamodels for which an appropriate
 * specialized {@link EnvironmentFactory} is available.
 * <p>
 * Helpers of these two flavours can be created via the
 * {@link HelperUtil#createOCLHelper(EnvironmentFactory)} method.
 * </p>
 * <p>
 * <b>Note</b> that this interface is not intended to be implemented
 * by clients.
 * </p>
 * 
 * @deprecated Use the {@link org.eclipse.ocl.helper.OCLHelper} interface, instead.
 * 
 * @see HelperUtil#createOCLHelper(EnvironmentFactory)
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
@Deprecated
public interface IOCLHelper {

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
	 *     classifier or property context
	 */
	public EOperation getContextOperation();
	
	/**
	 * Sets the context of the OCL expression for which syntax or parsing help is
	 * to be provided.  The property is the model element against which
	 * the OCL will be parsed as an property available in an OCL classifier;
	 * this model element must be able to be represented as an OCL property.
	 *
	 * @param context the OCL context object
	 * @param property the OCL context property
	 * 
	 * @see #setContext(Object)
	 */
	public void setContextProperty(Object context, Object property);

	/**
	 * Obtains my context operation as an EMF property, if my environment is
	 * a property context.
	 * 
	 * @return my context property, or <code>null</code> if there is only a
	 *     classifier or operation context
	 */
	public EStructuralFeature getContextProperty();

	/**
	 * Obtains the environment defining my current context classifier, operation,
	 * or property.  I do not have an environment until my context is set.
	 * 
	 * @return my current environment, or <code>null</code> if I have none
	 * 
	 * @see #setContext(Object)
	 * @see #setContextOperation(Object, Object)
	 * @see #setContextProperty(Object, Object)
	 */
	public Environment getEnvironment();
	
	/**
	 * Obtains syntax completion choices for the specified fragment of an OCL
	 * expression that is to be used for an invariant constraint (in case of a
	 * classifier context) or a postcondition constraint (in case of an operation
	 * context).  For completion of other operation constraint types, use the
	 * {@link #getSyntaxHelp(ConstraintType, String)} method as it will provide
	 * completions for syntax only available in these constraints.
	 *
	 * @param txt a partial OCL expression for which to seek choices that
	 *      could be appended to it
	 * @return a list of {@link Choice}s, possibly empty.  The ordering of the
	 *      list may or may not indicate relative relevance or frequency of
	 *      a choice
	 *      
	 * @deprecated Use the {@link #getSyntaxHelp(ConstraintType, String)}
	 *    method, instead, to get the correct completions for the context
	 */
	@Deprecated
    public List getSyntaxHelp(String txt);

	/**
	 * Obtains syntax completion choices for the specified fragment of an OCL
	 * expression given that it is intended for a constraint of the specified
	 * kind.  The choices returned (if any) will be appropriate for
	 * appending to the end of the specified text in the context of this kind
	 * of constraint.
	 *
	 * @param constraintType the kind of constraint that is being composed
	 * @param txt a partial OCL expression for which to seek choices that
	 *      could be appended to it
	 * @return a list of {@link Choice}s, possibly empty.  The ordering of the
	 *      list may or may not indicate relative relevance or frequency of
	 *      a choice
	 */
	public List getSyntaxHelp(ConstraintType constraintType, String txt);

	/**
	 * Creates a query expression in the current classifier context.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This expression can have any result type; it needs not
	 *    be a boolean
	 * 
	 * @return the query expression
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 */
	OCLExpression createQuery(String expression) throws OCLParsingException;

	/**
	 * Creates an invariant constraint in the current classifier context.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the invariant condition
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 */
	OCLExpression createInvariant(String expression) throws OCLParsingException;

	/**
	 * Creates an operation precondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the precondition
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	OCLExpression createPrecondition(String expression) throws OCLParsingException;

	/**
	 * Creates an operation postcondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the postcondition
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	OCLExpression createPostcondition(String expression) throws OCLParsingException;

	/**
	 * Creates an operation body.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the body condition
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #setContextOperation(Object, Object)
	 */
	OCLExpression createBodyCondition(String expression) throws OCLParsingException;

	/**
	 * Creates a property initial value expression.  This is appropriate only
	 * if my context is a property.
	 * 
	 * @param expression the initial value expression (without any context
	 *    declaration).  This must conform to my context property type
	 * 
	 * @return the initial value expression
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 *    or is not valid for my context property
	 * 
	 * @see #setContextProperty(Object, Object)
	 */
	OCLExpression createInitialValueExpression(String expression) throws OCLParsingException;

	/**
	 * Creates a property derived value expression.  This is appropriate only
	 * if my context is a property.
	 * 
	 * @param expression the derived value expression (without any context
	 *    declaration).  This must conform to my context property type
	 * 
	 * @return the derived value expression
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 *    or is not valid for my context property
	 * 
	 * @see #setContextProperty(Object, Object)
	 */
	OCLExpression createDerivedValueExpression(String expression) throws OCLParsingException;

	/**
	 * Defines an additional property or operation in the context classifier,
	 * for use in formulating OCL queries and constraints.  This is a
	 * "def expression", taking the form of either:
	 * <blockquote><pre>
	 *     <i>operation-name</i>(<i>parameters?</i>) : <i>type</i> = <i>expr</i>
	 * </pre></blockquote>
	 * or
	 * <blockquote><pre>
	 *     <i>property-name</i> : <i>type</i> = <i>expr</i>
	 * </pre></blockquote>
	 * 
	 * @param defExpression the definition expression (without any other context
	 *    declaration).
	 * @return the newly defined {@link EOperation} or {@link EStructuralFeature}
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 */
	ETypedElement define(String defExpression) throws OCLParsingException;

	/**
	 * Evaluates the specified parsed OCL expression on an instance of my
	 * context classifier.  This expression needs not be a boolean-valued
	 * constraint.
	 * 
	 * @param context the context object on which to evaluate the expression.
	 *     This is the <tt>self</tt> object, if the expression requires one.
	 *     Note that a context is required even for expressions that use the
	 *     <tt>allInstances()</tt> operation to get the instances of an OCL
	 *     classifier, in order to find resources to search for instances
	 *     (unless the context is a data type, in which case the instances are
	 *     not enumerated by models)
	 * @param expression an expression to evaluate
	 * 
	 * @return the result of the expression evaluation.  This can be a single
	 *     object, a collection of objects, or even <code>null</code>
	 */
	Object evaluate(Object context, OCLExpression expression);

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
	 * @param expression an expression to evaluate
	 * 
	 * @return the result of the expression evaluation.  This can be a single
	 *     object, a collection of objects, or even <code>null</code>
	 * 
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 * 
	 * @see #evaluate(Object, OCLExpression)
	 */
	Object evaluate(Object context, String expression) throws OCLParsingException;

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
	boolean check(Object context, OCLExpression constraint);

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
	 * @throws OCLParsingException if the <code>expression</code> fails to parse
	 * @throws IllegalArgumentException if the <code>constraint</code> is not
	 *     boolean-valued
	 *     
	 * @see #check(Object, OCLExpression)
	 */
	boolean check(Object context, String constraint) throws OCLParsingException;
	
	/**
	 * Retrieves the environment factory for the metamodel that I am helping.
	 * 
	 * @return my environment factory (never <code>null</code>)
	 */
	EnvironmentFactory getEnvironmentFactory();
}