/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.expressions.util;

import java.io.StringReader;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

import antlr.ANTLRException;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.internal.impl.ValidationVisitorImpl;
import org.eclipse.emf.ocl.internal.OclEngineDebugOptions;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.parser.OclLexer;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.UmlPackage;

/**
 * Static utilities for working with expressions.
 *
 * @author Christian W. Damus (cdamus)
 */
public class ExpressionsUtil {
	private static final String SELF_NAME = "self"; //$NON-NLS-1$
	
	/**
	 * Not instantiable by clients.
	 */
	private ExpressionsUtil() {
		super();
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code>.
	 * 
	 * @param classifier the context classifier
	 * @return the OCL environment
	 */
	public static Environment createClassifierContext(EClassifier classifier) {
		return EnvironmentFactory.ECORE_INSTANCE.createClassifierContext(
			classifier);
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code> and <code>operation</code>.
	 * This is useful when defining constraints on the redefinition of an
	 * operation in the context of a classifier that inherits it (i.e.,
	 * different from the classifier that defines the operation).
	 * 
	 * @param classifier the context classifier
	 * @param operation the operation context
	 * @return the OCL environment
	 * 
	 * @see #createOperationContext(EOperation)
	 */
	public static Environment createOperationContext(EClassifier classifier,
			EOperation operation) {
		return EnvironmentFactory.ECORE_INSTANCE.createOperationContext(
			classifier,
			operation);
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>operation</code>.  The implied classifier context is
	 * the classifier that defines the operation.
	 * 
	 * @param operation the operation classifier
	 * @return the OCL environment
	 * 
	 * @see #createOperationContext(EClassifier, EOperation)
	 */
	public static Environment createOperationContext(EOperation operation) {
		return EnvironmentFactory.ECORE_INSTANCE.createOperationContext(
			operation.getEContainingClass(),
			operation);
	}

	/**
	 * Creates an invariant constraint expression.
	 * 
	 * @param context the invariant's classifier context
	 * @param expression the expression (without the <code>"inv:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createInvariant(EClassifier context,
			String expression, boolean validate) throws ANTLRException {
		
		Environment env = createClassifierContext(context);
		
		return createInvariant(env, expression, validate);
	}
	
	/**
	 * Creates an invariant constraint expression in the specified environment.
	 * 
	 * @param environment the OCL environment
	 * @param expression the expression (without the <code>"inv:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createInvariant(
			Environment env,
			String expression, boolean validate) throws ANTLRException {
		
		OclParser parser = createParser("inv:", expression); //$NON-NLS-1$
		
		Constraint constraint = parser.invOrDefCS(env);
		constraint.setInstanceVarName(SELF_NAME);
		
		OclExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance());
		}
		
		return result;
	}
	
	/**
	 * Creates an operation precondition constraint expression.
	 * 
	 * @param context the precondition's operation context
	 * @param expression the expression (without the <code>"pre:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createPrecondition(EOperation context,
			String expression, boolean validate) throws ANTLRException {
		return createPrecondition(
			context.getEContainingClass(),
			context,
			expression,
			validate);
	}
	
	/**
	 * Creates an operation precondition constraint expression.
	 * 
	 * @param classifier the context classifier
	 * @param context the precondition's operation context
	 * @param expression the expression (without the <code>"pre:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createPrecondition(
			EClassifier classifier, EOperation context,
			String expression, boolean validate) throws ANTLRException {
		Environment env = ExpressionsUtil.createOperationContext(
			classifier, context);
		
		return createPrecondition(env, expression, validate);
	}
	
	/**
	 * Creates an operation precondition constraint expression in the
	 * specified environment.
	 * 
	 * @param environment the OCL environment
	 * @param expression the expression (without the <code>"pre:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createPrecondition(Environment env,
			String expression, boolean validate)
			throws ANTLRException {
		
		OclParser parser = createParser("pre:", expression); //$NON-NLS-1$
		Constraint constraint = parser.prePostOrBodyDeclCS(
			env,
			env.getContextOperation());
		constraint.setInstanceVarName(SELF_NAME);
		
		OclExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance());
		}
		
		return result;
	}
	
	/**
	 * Creates an operation postcondition constraint expression.
	 * 
	 * @param context the postcondition's operation context
	 * @param expression the expression (without the <code>"post:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createPostcondition(EOperation context,
			String expression, boolean validate) throws ANTLRException {
		return createPostcondition(
			context.getEContainingClass(),
			context,
			expression,
			validate);
	}
	
	/**
	 * Creates an operation postcondition constraint expression.
	 * 
	 * @param classifier the context classifier
	 * @param context the postcondition's operation context
	 * @param expression the expression (without the <code>"post:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createPostcondition(
			EClassifier classifier, EOperation context,
			String expression, boolean validate) throws ANTLRException {
		
		Environment env = ExpressionsUtil.createOperationContext(
			classifier, context);
		
		return createPostcondition(env, expression, validate);
	}
	
	/**
	 * Creates an operation postcondition constraint expression in the
	 * specified environment.
	 * 
	 * @param environment the OCL environment
	 * @param expression the expression (without the <code>"post:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createPostcondition(Environment env,
			String expression, boolean validate)
			throws ANTLRException {
		
		OclParser parser = createParser("post:", expression); //$NON-NLS-1$
		Constraint constraint = parser.prePostOrBodyDeclCS(
			env,
			env.getContextOperation());
		constraint.setInstanceVarName(SELF_NAME);
		
		OclExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance());
		}
		
		return result;
	}
	
	/**
	 * Creates an operation body condition expression.
	 * 
	 * @param context the body's operation context
	 * @param expression the expression (without the <code>"body:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createBodyCondition(EOperation context,
			String expression, boolean validate) throws ANTLRException {
		return createBodyCondition(
			context.getEContainingClass(),
			context,
			expression,
			validate);
	}
	
	/**
	 * Creates an operation body condition expression.
	 * 
	 * @param classifier the context classifier
	 * @param context the body's operation context
	 * @param expression the expression (without the <code>"body:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createBodyCondition(
			EClassifier classifier, EOperation context,
			String expression, boolean validate) throws ANTLRException {
		Environment env = ExpressionsUtil.createOperationContext(
			classifier, context);
		
		return createBodyCondition(env, expression, validate);
	}
	
	/**
	 * Creates an operation body condition expression in the
	 * specified environment.
	 * 
	 * @param environment the OCL environment
	 * @param context the body condition's operation context
	 * @param expression the expression (without the <code>"body:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ANTLRException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OclExpression createBodyCondition(Environment env,
			String expression, boolean validate)
			throws ANTLRException {
		
		OclParser parser = createParser("body:", expression); //$NON-NLS-1$
		Constraint constraint = parser.prePostOrBodyDeclCS(
			env,
			env.getContextOperation());
		constraint.setInstanceVarName(SELF_NAME);
		
		OclExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance());
		}
		
		return result;
	}

	/**
	 * Initializes a parser on the specified <code>text</code>.
	 * 
	 * @param prefix the constraint prefix (e.g., <code>"inv:"</code> or
	 *     <code>"pre:"</code>).  The prefix must not contain newlines
	 * @param text the OCL constraint text
	 * 
	 * @return the parser
	 */
	private static OclParser createParser(String prefix, String text) {
		OclLexer lexer = new OclLexer(new StringReader(prefix + '\n' + text));
		
		// we prefix the constraint with "inv:", "pre:", etc. which the
		//    user cannot see, so we want error resporting to be relative
		//    to line 0, not line 1
		lexer.setLine(0);
		
		// also offset the character position by the length of the extra text
		lexer.setCharacterCount(-(prefix.length() + 1)); // one for the newline
		
		OclParser result = new OclParser(lexer);
		result.setTraceFlag(OclEnginePlugin.shouldTrace(
			OclEngineDebugOptions.DEBUG));
		
		return result;
	}
	
	/**
	 * Computes the nearest container of an <code>eObject</code> that has the
	 * specified <code>type</code>.
	 * 
	 * @param type the container type to look for
	 * @param eObject the object for which we seek a container
	 * 
	 * @return the nearest container of the specified <code>type</code>, or
	 *     <code>null</code> if no such container is found
	 */
	public static EObject containerOfType(EClass type, EObject eObject) {
		EObject result = eObject.eContainer();
		
		while (result != null) {
			if (type.isInstance(result)) {
				break;
			} else {
				result = result.eContainer();
			}
		}
		
		return result;
	}

	/**
	 * Checks whether the specified OCL expression is in an operation
	 * postcondition constraint.
	 * 
	 * @param exp an OCL expression
	 * @return <code>true</code> if it is in a postcondition constraint;
	 *    <code>false</code>, otherwise (including case of no constraint at all)
	 */
	public static boolean isInPostcondition(OclExpression exp) {
		Constraint constraint = (Constraint) containerOfType(
			UmlPackage.eINSTANCE.getConstraint(), exp);
		
		return (constraint != null)
				&& Constraint.POSTCONDITION.equals(constraint.getStereotype());
	}
}
