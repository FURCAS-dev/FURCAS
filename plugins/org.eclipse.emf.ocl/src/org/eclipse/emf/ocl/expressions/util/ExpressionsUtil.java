/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.expressions.impl.ValidationVisitorImpl;
import org.eclipse.emf.ocl.internal.OCLDebugOptions;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.parser.CompatibilityParser;
import org.eclipse.emf.ocl.internal.parser.CompatibilityUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.UMLPackage;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.internal.parser.OCLLexer;

/**
 * Static utilities for working with expressions.
 *
 * @deprecated Use the {@link OCL} and {@link OCLHelper} APIs, instead.
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
	 * @param operation the operation context
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
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>classifier</code> and <code>property</code>.
	 * This is useful when defining constraints on the redefinition of a
	 * property in the context of a classifier that inherits it (i.e.,
	 * different from the classifier that defines the property).
	 * 
	 * @param classifier the context classifier
	 * @param property the property context
	 * @return the OCL environment
	 * 
	 * @see #createPropertyContext(EStructuralFeature)
	 */
	public static Environment createPropertyContext(EClassifier classifier,
			EStructuralFeature property) {
		return EnvironmentFactory.ECORE_INSTANCE.createPropertyContext(
			classifier,
			property);
	}

	/**
	 * Creates an environment for OCL constraints in the context of the
	 * specified <code>property</code>.  The implied classifier context is
	 * the classifier that defines the property.
	 * 
	 * @param property the property context
	 * @return the OCL environment
	 * 
	 * @see #createPropertyContext(EClassifier, EStructuralFeature)
	 */
	public static Environment createPropertyContext(EStructuralFeature property) {
		return EnvironmentFactory.ECORE_INSTANCE.createPropertyContext(
			property.getEContainingClass(),
			property);
	}

	/**
	 * Creates a query expression with an arbitrary result type.
	 * 
	 * @param context the invariant's classifier context
	 * @param expression the expression (without any <code>"inv:"</code> or
	 *     similar preamble)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createQuery(EClassifier context,
			String expression, boolean validate) throws ParserException {
		
		Environment env = createClassifierContext(context);
		
		return createQuery(env, expression, validate);
	}
	
	/**
	 * Creates a query expression with an arbitrary result type in the
	 * specified environment.
	 * 
	 * @param env the OCL environment
	 * @param expression the expression (without any <code>"inv:"</code> or
	 *     similar preamble)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createQuery(
			Environment env,
			String expression, boolean validate) throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "inv:", expression); //$NON-NLS-1$
		
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parseInvOrDefCS(env));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		// this is not a constraint
		constraint.setBody(null);
		
		if (validate) {
			// validate only the result, not the constraint
			result.accept(ValidationVisitorImpl.getInstance(env));
		}
		
		return result;
	}

	/**
	 * Creates an invariant constraint expression.
	 * 
	 * @param context the invariant's classifier context
	 * @param expression the expression (without the <code>"inv:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createInvariant(EClassifier context,
			String expression, boolean validate) throws ParserException {
		
		Environment env = createClassifierContext(context);
		
		return createInvariant(env, expression, validate);
	}
	
	/**
	 * Creates an invariant constraint expression in the specified environment.
	 * 
	 * @param env the OCL environment
	 * @param expression the expression (without the <code>"inv:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createInvariant(
			Environment env,
			String expression, boolean validate) throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "inv:", expression); //$NON-NLS-1$
		
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parseInvOrDefCS(env));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance(env));
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
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createPrecondition(EOperation context,
			String expression, boolean validate) throws ParserException {
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
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createPrecondition(
			EClassifier classifier, EOperation context,
			String expression, boolean validate) throws ParserException {
		Environment env = ExpressionsUtil.createOperationContext(
			classifier, context);
		
		return createPrecondition(env, expression, validate);
	}
	
	/**
	 * Creates an operation precondition constraint expression in the
	 * specified environment.
	 * 
	 * @param env the OCL environment
	 * @param expression the expression (without the <code>"pre:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createPrecondition(Environment env,
			String expression, boolean validate)
			throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "pre:", expression); //$NON-NLS-1$
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parsePrePostOrBodyDeclCS(env, env.getContextOperation()));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance(env));
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
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createPostcondition(EOperation context,
			String expression, boolean validate) throws ParserException {
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
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createPostcondition(
			EClassifier classifier, EOperation context,
			String expression, boolean validate) throws ParserException {
		
		Environment env = ExpressionsUtil.createOperationContext(
			classifier, context);
		
		return createPostcondition(env, expression, validate);
	}
	
	/**
	 * Creates an operation postcondition constraint expression in the
	 * specified environment.
	 * 
	 * @param env the OCL environment
	 * @param expression the expression (without the <code>"post:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createPostcondition(Environment env,
			String expression, boolean validate)
			throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "post:", expression); //$NON-NLS-1$
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parsePrePostOrBodyDeclCS(env, env.getContextOperation()));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance(env));
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
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createBodyCondition(EOperation context,
			String expression, boolean validate) throws ParserException {
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
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createBodyCondition(
			EClassifier classifier, EOperation context,
			String expression, boolean validate) throws ParserException {
		Environment env = ExpressionsUtil.createOperationContext(
			classifier, context);
		
		return createBodyCondition(env, expression, validate);
	}
	
	/**
	 * Creates an operation body condition expression in the
	 * specified environment.
	 * 
	 * @param env the OCL environment
	 * @param expression the expression (without the <code>"body:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createBodyCondition(Environment env,
			String expression, boolean validate)
			throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "body:", expression); //$NON-NLS-1$
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parsePrePostOrBodyDeclCS(env, env.getContextOperation()));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance(env));
		}
		
		return result;
	}
	
	/**
	 * Creates a property initial value expression.
	 * 
	 * @param context the property context
	 * @param expression the expression (without the <code>"init:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createInitialValueExpression(EStructuralFeature context,
			String expression, boolean validate) throws ParserException {
		return createInitialValueExpression(
			context.getEContainingClass(),
			context,
			expression,
			validate);
	}
	
	/**
	 * Creates an property initial value expression.
	 * 
	 * @param classifier the context classifier
	 * @param context the property context
	 * @param expression the expression (without the <code>"init:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createInitialValueExpression(
			EClassifier classifier, EStructuralFeature context,
			String expression, boolean validate) throws ParserException {
		Environment env = ExpressionsUtil.createPropertyContext(
			classifier, context);
		
		return createInitialValueExpression(env, expression, validate);
	}
	
	/**
	 * Creates a property initial value expression in the
	 * specified environment.
	 * 
	 * @param env the OCL property environment
	 * @param expression the expression (without the <code>"init:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createInitialValueExpression(Environment env,
			String expression, boolean validate)
			throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "init:", expression); //$NON-NLS-1$
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parseInitOrDerValueCS(env, env.getContextProperty()));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance(env));
		}
		
		return result;
	}
	
	/**
	 * Creates a property derived value expression.
	 * 
	 * @param context the property context
	 * @param expression the expression (without the <code>"derive:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createDerivedValueExpression(EStructuralFeature context,
			String expression, boolean validate) throws ParserException {
		return createDerivedValueExpression(
			context.getEContainingClass(),
			context,
			expression,
			validate);
	}
	
	/**
	 * Creates an property derived value expression.
	 * 
	 * @param classifier the context classifier
	 * @param context the property context
	 * @param expression the expression (without the <code>"derive:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createDerivedValueExpression(
			EClassifier classifier, EStructuralFeature context,
			String expression, boolean validate) throws ParserException {
		Environment env = ExpressionsUtil.createPropertyContext(
			classifier, context);
		
		return createDerivedValueExpression(env, expression, validate);
	}
	
	/**
	 * Creates a property derived value expression in the
	 * specified environment.
	 * 
	 * @param env the OCL property environment
	 * @param expression the expression (without the <code>"derive:"</code>)
	 * @param validate whether to validate the result or not
	 * 
	 * @return the corresponding OCL expression
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static OCLExpression createDerivedValueExpression(Environment env,
			String expression, boolean validate)
			throws ParserException {
		
		CompatibilityParser parser = createParser(
				env.getFactory(), "derive:", expression); //$NON-NLS-1$
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parseInitOrDerValueCS(env, env.getContextProperty()));
		constraint.setInstanceVarName(SELF_NAME);
		
		OCLExpression result = constraint.getBody();
		
		if (validate) {
			constraint.accept(ValidationVisitorImpl.getInstance(env));
		}
		
		return result;
	}

	/**
	 * Defines a property or an operation of the specified signature.
	 * 
	 * @param context the classifier context to own the new property or operation
	 * @param expression the expression (without the <code>"def:"</code>
	 *     preamble but including the <code>"name(...) : type ="</code> part)
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static void define(EClassifier context, String expression) throws ParserException {
		
		Environment env = createClassifierContext(context);
		
		define(env, expression);
	}
	
	/**
	 * Defines a property or operation of the specified signature.
	 * 
	 * @param env the OCL classifier environment
	 * @param defExpression the definition expression (without the <code>"def:"</code>
	 *     preamble but including the <code>"name(...) : type ="</code> part)
	 * 
	 * @return the newly defined {@link EOperation} or {@link EStructuralFeature}
	 * 
	 * @throws ParserException if the expression fails to parse
	 * @throws IllegalArgumentException if the expression fails to validate
	 */
	public static ETypedElement define(
			Environment env,
			String defExpression) throws ParserException {
		
		CompatibilityParser parser = createParser("def:", env.getFactory(), defExpression); //$NON-NLS-1$
		
		Constraint constraint = (Constraint) CompatibilityUtil.getOldAS(
				env, parser.parseInvOrDefCS(env));
		constraint.setInstanceVarName(SELF_NAME);
		
		constraint.accept(ValidationVisitorImpl.getInstance(env));
		
		return (ETypedElement) constraint.getConstrainedElement().get(1);
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
	private static CompatibilityParser createParser(EnvironmentFactory factory, String prefix, String text) {
		return createParser(prefix, factory, text);
	}

	/**
	 * Initializes a parser on the specified <code>text</code> and environment
	 * factory.
	 * 
	 * @param prefix the constraint prefix (e.g., <code>"inv:"</code> or
	 *     <code>"pre:"</code>).  The prefix must not contain newlines
	 * @param environmentFactory the parser's environment factory
	 * @param text the OCL constraint text
	 * 
	 * @return the parser
	 */
	private static CompatibilityParser createParser(String prefix,
			EnvironmentFactory environmentFactory, String text) {
		
		OCLLexer lexer = new OCLLexer((prefix + '\n' + text).toCharArray());
		CompatibilityParser result = new CompatibilityParser(lexer, environmentFactory);
		
		// we prefix the constraint with "inv:", "pre:", "def:", etc. which the
		//    user cannot see, so we want error resporting to be relative
		//    to line 0, not line 1
		result.setErrorReportLineOffset(-1);
		
		// offset the character position by the length of the extra text
		result.setCharacterOffset(-(prefix.length() + 1)); // one for the newline
		
		result.setTraceFlag(OCLPlugin.shouldTrace(OCLDebugOptions.DEBUG));
		
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
	public static boolean isInPostcondition(OCLExpression exp) {
		Constraint constraint = (Constraint) containerOfType(
			UMLPackage.Literals.CONSTRAINT, exp);
		
		return (constraint != null)
				&& Constraint.POSTCONDITION.equals(constraint.getStereotype());
	}
    
    /**
     * Converts the specified expression to the generic AST model.  Useful for
     * migration from the pre-1.1 API.
     * 
     * @param env the OCL environment
     * @param expression an expression to convert to the 1.1-version generic
     *     model
     * 
     * @return the converted expression
     * 
     * @since 1.1
     */
    @SuppressWarnings("unchecked")
    public static org.eclipse.ocl.expressions.OCLExpression<EClassifier>
    toGenericAST(Environment env, OCLExpression expression) {
        
        return (org.eclipse.ocl.expressions.OCLExpression<EClassifier>)
            CompatibilityUtil.getNewAS(env, expression);
    }
    
    /**
     * Converts the specified variable to the generic AST model.  Useful for
     * migration from the pre-1.1 API.
     * 
     * @param env the OCL environment
     * @param variable a variable to convert to the 1.1-version generic model
     * 
     * @return the converted variable
     * 
     * @since 1.1
     */
    @SuppressWarnings("unchecked")
    public static org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>
    toGenericAST(Environment env, Variable variable) {
        
        return (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
            CompatibilityUtil.getNewAS(env, variable);
    }
    
    /**
     * Converts the specified constraint to the generic AST model.  Useful for
     * migration from the pre-1.1 API.
     * 
     * @param env the OCL environment
     * @param constraint a constraint to convert to the 1.1-version generic model
     * 
     * @return the converted constraint
     * 
     * @since 1.1
     */
    public static org.eclipse.ocl.ecore.Constraint toGenericAST(
        Environment env,
        Constraint constraint) {
        
        return (org.eclipse.ocl.ecore.Constraint)
            CompatibilityUtil.getNewAS(env, constraint);
    }
}
