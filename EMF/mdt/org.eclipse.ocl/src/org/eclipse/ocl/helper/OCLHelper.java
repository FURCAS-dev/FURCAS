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
 * $Id: OCLHelper.java,v 1.5 2008/04/17 19:38:15 cdamus Exp $
 */

package org.eclipse.ocl.helper;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;


/**
 * A utility object that provides OCL syntax completion suggestions for OCL
 * expressions and convenient API for parsing OCL constraint expressions without
 * the encumbrance of context declarations.  The latter is most useful for
 * processing OCL constraints and expressions embedded in the user model, where
 * the context is implied by the placement of the constraint in the model.
 * <p>
 * An OCL helper is created by the {@link OCL#createOCLHelper()} factory method
 * and inherits the current context {@link Environment} of the {@link OCL} that
 * created it.
 * </p><p>
 * Since 1.2, the helper supplies {@linkplain #getProblems() diagnostics}
 * indicating any problems encountered while parsing.  The diagnostics pertain
 * always to the most recently executed parse operation.
 * </p>
 * <p>
 * <b>Note</b> that this interface is not intended to be implemented
 * by clients.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @see OCL#createOCLHelper()
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
public interface OCLHelper<C, O, P, CT> {
    
	/**
	 * Sets the classifier context of the OCL expression for which syntax or
     * parsing help is to be provided.
	 *
	 * @param context the OCL context classifier
	 * 
	 * @see #setOperationContext(Object, Object)
     * @see #setAttributeContext(Object, Object)
	 */
	void setContext(C context);

	/**
	 * Obtains my OCL context classifier as a classifier.
	 * 
	 * @return my context classifier (never <code>null</code>)
	 */
	C getContextClassifier();
	
	/**
	 * Sets the operation context of the OCL expression for which syntax or
     * parsing help is to be provided.  The operation is the model element
     * against which the OCL will be parsed as an operation applicable to an
     * OCL type.  Note that the operation needs not necessarily be defined by
     * the specified context classifier; it could be inherited.
	 *
	 * @param context the OCL context classifier
	 * @param operation the OCL context operation
	 * 
	 * @see #setContext(Object)
	 */
	void setOperationContext(C context, O operation);

	/**
	 * Obtains my context operation, if my environment is an operation context.
	 * 
	 * @return my context operation, or <code>null</code> if there is only a
	 *     classifier or attribute context
	 */
	O getContextOperation();
	
	/**
	 * Sets the attribute context of the OCL expression for which syntax or
     * parsing help is to be provided.  The attribute is the model element
     * against which the OCL will be parsed as an attribute available in an OCL
     * classifier.  Note that the attribute needs not necessarily be defined by
     * the specified context classifier; it could be inherited.
	 *
	 * @param context the OCL context classifier
	 * @param property the OCL context attribute
	 * 
	 * @see #setContext(Object)
	 */
	void setAttributeContext(C context, P property);

	/**
	 * Obtains my context attribute, if my environment is an attribute context.
	 * 
	 * @return my context attribute, or <code>null</code> if there is only a
	 *     classifier or operation context
	 */
	P getContextAttribute();
    
    /**
     * Sets the classifier context implied by the specified instance.  The
     * appropriate classifier will be determined from the run-time type of this
     * object, if possible.  If not possible, <tt>OclAny</tt> is assumed.
     * <p>
     * This method is convenient for ad hoc parsing and evaluation of
     * OCL constraints or expressions in the context of a model instance.
     * </p>
     * 
     * @param instance the OCL context instance
     * 
     * @see #setContext(Object)
     */
    void setInstanceContext(Object instance);
    
    /**
     * Sets the operation context implied by the specified instance.  The
     * appropriate classifier will be determined from the run-time type of this
     * object, if possible.  If not possible, <tt>OclAny</tt> is assumed.
     * <p>
     * This method is convenient for ad hoc parsing and evaluation of
     * OCL constraints or expressions in the context of a model instance.
     * </p>
     * 
     * @param instance the OCL context instance
     * @param operation the OCL context operation
     * 
     * @see #setOperationContext(Object, Object)
     */
    void setInstanceOperationContext(Object instance, O operation);
    
    /**
     * Sets the operation context implied by the specified instance.  The
     * appropriate classifier will be determined from the run-time type of this
     * object, if possible.  If not possible, <tt>OclAny</tt> is assumed.
     * <p>
     * This method is convenient for ad hoc parsing and evaluation of
     * OCL constraints or expressions in the context of a model instance.
     * </p>
     * 
     * @param instance the OCL context instance
     * @param property the OCL context attribute
     * 
     * @see #setAttributeContext(Object, Object)
     */
    void setInstanceAttributeContext(Object instance, P property);
	
    /**
     * Obtains the OCL instance that created me.  Note that many of the generic
     * type parameter bindings will not be known, so clients should keep track
     * of the OCL instance themselves where that is a problem.
     * 
     * @return the OCL instance that created me
     */
    OCL<?, C, O, P, ?, ?, ?, ?, ?, CT, ?, ?> getOCL();
    
    /**
     * Obtains the environment defining my current
     * {@linkplain #getContextClassifier() classifier},
     * {@linkplain #getContextOperation() operation}, or
     * {@linkplain #getContextAttribute() attribute} context.  Accessing the
     * environment is convenient for, e.g., adding variable definitions to
     * insert global objects into the OCL context.
     * 
     * @return my current context environment, or <code>null</code> if I have
     *    not yet been assigned a context
     * 
     * @see #setContext(Object)
     * @see #setOperationContext(Object, Object)
     * @see #setAttributeContext(Object, Object)
     * 
     * @since 1.2
     */
    Environment<?, C, O, P, ?, ?, ?, ?, ?, CT, ?, ?> getEnvironment();
    
	/**
	 * Queries whether I validate the expressions that I parse.  Validation
	 * applies more well-formedness checks than are implied by parsing, especially
	 * because parsing supports partial (incomplete) expressions for syntax
	 * completion.  Validation adds some amount of processing, which is not
	 * necessary in all cases.
	 * 
	 * @return whether I validate the expressions that I parse.  Validation is
	 *    on by default
	 */
	boolean isValidating();
	
	/**
	 * Sets whether I should validate the expressions that I parse.
	 * 
	 * @param validating whether I should validate parsed expressions
	 */
	void setValidating(boolean validating);

    /**
     * Creates a query expression in the current classifier context.  This may
     * be specified, for example, as an expression value in the model.
     * 
     * @param expression the expression (without any context declaration).
     *    This expression can have any result type; it needs not be a boolean
     * 
     * @return the query expression
     * 
     * @throws ParserException if the <code>expression</code> fails to parse
     */
    OCLExpression<C> createQuery(String expression) throws ParserException;

    /**
     * Creates a constraint of the specified kind, by parsing the given
     * expression.  In the case of additional attribute or operation definition
     * constraints, the expression must be prefixed by the signature of the
     * feature as follows:
     * <blockquote><pre>
     *     <i>attribute-name</i> : <i>type</i> = <i>expr</i>
     * </pre></blockquote>
     * <blockquote><pre>
     *     <i>operation-name</i>(<i>parameters?</i>) : <i>type</i> = <i>expr</i>
     * </pre></blockquote>
     *  
     * @param kind the kind of constraint to create
     * @param expression the constraint body
     * @return the constraint
     * 
     * @throws ParserException on failure to parse the constraint
     */
    CT createConstraint(ConstraintKind kind, String expression) throws ParserException;
    
	/**
	 * Creates an invariant constraint in the current classifier context.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the invariant constraint
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
	CT createInvariant(String expression) throws ParserException;

	/**
	 * Creates an operation precondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the precondition
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 * 
	 * @see #setOperationContext(Object, Object)
	 */
	CT createPrecondition(String expression) throws ParserException;

	/**
	 * Creates an operation postcondition constraint.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  This must be a boolean-valued expression
	 * 
	 * @return the postcondition
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 * 
	 * @see #setOperationContext(Object, Object)
	 */
	CT createPostcondition(String expression) throws ParserException;

	/**
	 * Creates an operation body.  This is appropriate only
	 * if my context is an operation.
	 * 
	 * @param expression the constraint expression (without any context
	 *    declaration).  Ordinarily, this is an expression of the same type
	 *    as the operation, specifying the value of the operation.
	 *    Alternatively, this may be a boolean-valued expression phrased like
	 *    a post-condition (according to the well-formedness rules of UML
	 *    constraints)
	 * 
	 * @return the body condition
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 * 
	 * @see #setOperationContext(Object, Object)
	 */
	CT createBodyCondition(String expression) throws ParserException;

	/**
	 * Creates a property initial value expression.  This is appropriate only
	 * if my context is a property.
	 * 
	 * @param expression the initial value expression (without any context
	 *    declaration).  This must conform to my context property type
	 * 
	 * @return the initial value expression
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 *    or is not valid for my context property
	 * 
	 * @see #setAttributeContext(Object, Object)
	 */
	CT createInitialValueExpression(String expression) throws ParserException;

	/**
	 * Creates a property derived value expression.  This is appropriate only
	 * if my context is a property.
	 * 
	 * @param expression the derived value expression (without any context
	 *    declaration).  This must conform to my context property type
	 * 
	 * @return the derived value expression
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 *    or is not valid for my context property
	 * 
	 * @see #setAttributeContext(Object, Object)
	 */
	CT createDerivedValueExpression(String expression) throws ParserException;

	/**
	 * Defines an additional operation in the context classifier,
	 * for use in formulating OCL queries and constraints.  This is a
	 * "def expression", taking the form of:
	 * <blockquote><pre>
	 *     <i>operation-name</i>(<i>parameters?</i>) : <i>type</i> = <i>expr</i>
	 * </pre></blockquote>
	 * 
	 * @param defExpression the definition expression (without any other context
	 *    declaration).
	 * @return the newly defined operation
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
	O defineOperation(String defExpression) throws ParserException;

	/**
	 * Defines an additional attribute in the context classifier,
	 * for use in formulating OCL queries and constraints.  This is a
	 * "def expression", taking the form of:
	 * <blockquote><pre>
	 *     <i>attribute-name</i> : <i>type</i> = <i>expr</i>
	 * </pre></blockquote>
	 * 
	 * @param defExpression the definition expression (without any other context
	 *    declaration).
	 * @return the newly defined attribute
	 * 
	 * @throws ParserException if the <code>expression</code> fails to parse
	 */
	P defineAttribute(String defExpression) throws ParserException;
    
    /**
     * Obtains syntax completion choices for the specified fragment of an OCL
     * expression given that it is intended for a constraint of the specified
     * kind.  The choices returned (if any) will be appropriate for
     * appending to the end of the specified text in the context of this kind
     * of constraint.
     *
     * @param constraintType the kind of constraint that is being composed,
     *      or <code>null</code> to indicate completions for a query expression
     * @param txt a partial OCL expression for which to seek choices that
     *      could be appended to it
     * @return a list of {@link Choice}s, possibly empty.  The ordering of the
     *      list may or may not indicate relative relevance or frequency of
     *      a choice
     */
    List<Choice> getSyntaxHelp(ConstraintKind constraintType, String txt);
    
    /**
     * Obtains problems, if any, found in parsing the last OCL constraint or
     * query expression.
     * 
     * @return parsing problems or <code>null</code> if all was OK
     * 
     * @since 1.2
     */
    Diagnostic getProblems();
}