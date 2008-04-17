/**
 * <copyright>
 *
 * Copyright (c) 2002, 2008 IBM Corporation and others.
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
 * $Id: OCLHelperImpl.java,v 1.6 2008/04/17 19:38:15 cdamus Exp $
 */

package org.eclipse.ocl.internal.helper;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.helper.Choice;
import org.eclipse.ocl.helper.ConstraintKind;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Default implementation of the {@link OCLHelper} interface.
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
class OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		implements OCLHelper<C, O, P, CT> {
	
	private final EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	environmentFactory;
    private final UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> uml;
    private final OCLFactory oclFactory;
	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env;

	private OCLSyntaxHelper<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> syntaxHelper;
	
	private boolean validating = true;
    private final OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> ocl;
    
    private Diagnostic problems;
    
	/**
	 * Initializes me with my environment.
	 * 
	 * @param ocl the OCL environment
	 */
	OCLHelperImpl(OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> ocl) {
        this.ocl = ocl;
        
        uml = ocl.getEnvironment().getUMLReflection();
        oclFactory = ocl.getEnvironment().getOCLFactory();
		environmentFactory = ocl.getEnvironment().getFactory();
	}
	
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	getEnvironment() {
		return env == null? ocl.getEnvironment() : env;
	}
	
    public OCL<?, C, O, P, ?, ?, ?, ?, ?, CT, ?, ?> getOCL() {
        return ocl;
    }
    
	public boolean isValidating() {
		return validating;
	}
	
	public void setValidating(boolean validating) {
		this.validating = validating;
	}
	
	/**
	 * Strips any leading, trailing, or embedded comments from the specified OCL
	 * expression text.
	 * 
	 * @param txt an OCL expression
	 * @return the same, but without any comments.  Note that the result
	 *     may be an empty String if <code>txt</code> has only comments
	 */
	private String removeOCLComments(String txt) {
		try {
			return HelperUtil.getLogicalLine(txt);
		} catch (Exception ex) {
			HelperUtil.catchException(ex, getClass(), "removeOCLComments");//$NON-NLS-1$
		}
		return HelperUtil.EMPTY;
	}

	private void setEnvironment(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		this.env = env;
		
		// forget the cached syntax helper, as its environment is now obsolete
		syntaxHelper = null;
	}
	
	public void setContext(C context) {
		setEnvironment(environmentFactory.createClassifierContext(
            ocl.getEnvironment(), context));
	}
	
	public void setOperationContext(C context, O operation) {
        setContext(context);
		setEnvironment(environmentFactory.createOperationContext(env, operation));
	}
	
	public void setAttributeContext(C context, P property) {
        setContext(context);
		setEnvironment(environmentFactory.createAttributeContext(env, property));
	}
    
    public void setInstanceContext(Object instance) {
        setEnvironment(environmentFactory.createInstanceContext(
            ocl.getEnvironment(), instance));
    }
    
    public void setInstanceOperationContext(Object instance, O operation) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createOperationContext(env, operation));
    }
    
    public void setInstanceAttributeContext(Object instance, P property) {
        setInstanceContext(instance);
        setEnvironment(environmentFactory.createAttributeContext(env, property));
    }
	
	public C getContextClassifier() {
		return env.getContextClassifier();
	}
	
	public O getContextOperation() {
		return env.getContextOperation();
	}
	
	public P getContextAttribute() {
		return env.getContextProperty();
	}

	public List<Choice> getSyntaxHelp(ConstraintKind constraintType, String txt) {
	    if (constraintType == null) {
	        // query expressions cannot use post-condition constructs such
	        // as @pre or oclIsNew(), so pretend an invariant constraint
	        constraintType = ConstraintKind.INVARIANT;
	    }
	    
		return createSyntaxHelper().getSyntaxHelp(constraintType, txt);
	}

    public OCLExpression<C>
    createQuery(String expression) throws ParserException {
        if (removeOCLComments(expression).length() > 0) {
            // be sure to pass the original expression along to get the right
            //    position information when parse fails
            try {
                return HelperUtil.parseQuery(
                    this, expression, validating, ocl.isParseTracingEnabled());
            } catch (RuntimeException e) {
                propagate(e, "createQuery"); //$NON-NLS-1$
            }
        }
        
        // may as well create a boolean-valued expression if none was supplied
        return uml.getSpecification(
                createNullCondition(
                        env.getOCLStandardLibrary().getBoolean())).getBodyExpression();
    }

    public CT createConstraint(ConstraintKind kind, String expression)
        throws ParserException {
        
        switch (kind) {
        case PRECONDITION:
            return createPrecondition(expression);
        case BODYCONDITION:
            return createBodyCondition(expression);
        case POSTCONDITION:
            return createPostcondition(expression);
        case INITIAL:
            return createInitialValueExpression(expression);
        case DERIVATION:
            return createDerivedValueExpression(expression);
        case DEFINITION:
            return HelperUtil.parseDefExpression(
                this, expression, validating, ocl.isParseTracingEnabled());
        default:
            return createInvariant(expression);
        }
    }
    
	public CT createInvariant(String expression) throws ParserException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return HelperUtil.parseInvariant(
                    this, expression, validating, ocl.isParseTracingEnabled());
			} catch (RuntimeException e) {
				propagate(e, "createInvariant"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(env.getOCLStandardLibrary().getBoolean());
	}

	public CT createPrecondition(String expression) throws ParserException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return HelperUtil.parsePrecondition(
                    this, expression, validating, ocl.isParseTracingEnabled());
			} catch (RuntimeException e) {
				propagate(e, "createPrecondition"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(env.getOCLStandardLibrary().getBoolean());
	}
	
	public CT createPostcondition(String expression) throws ParserException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return HelperUtil.parsePostcondition(
                    this, expression, validating, ocl.isParseTracingEnabled());
			} catch (RuntimeException e) {
				propagate(e, "createPostcondition"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(env.getOCLStandardLibrary().getBoolean());
	}
	
	public CT createBodyCondition(String expression) throws ParserException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return HelperUtil.parseBodyCondition(
                    this, expression, validating, ocl.isParseTracingEnabled());
			} catch (RuntimeException e) {
				propagate(e, "createBodyCondition"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(env.getOCLStandardLibrary().getOclVoid());
	}
	
	public CT createInitialValueExpression(String expression) throws ParserException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return HelperUtil.parseInitialValueExpression(
                    this, expression, validating, ocl.isParseTracingEnabled());
			} catch (RuntimeException e) {
				propagate(e, "createInitialValueExpression"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(env.getOCLStandardLibrary().getOclVoid());
	}
	
	public CT createDerivedValueExpression(String expression) throws ParserException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return HelperUtil.parseDerivedValueExpression(
                    this, expression, validating, ocl.isParseTracingEnabled());
			} catch (RuntimeException e) {
				propagate(e, "createDerivedValueExpression"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(env.getOCLStandardLibrary().getOclVoid());
	}
	
	@SuppressWarnings("unchecked")
	public O defineOperation(String defExpression) throws ParserException {
		try {
			EObject operation = define(defExpression);
			
			if (!uml.isOperation(operation)) {
				// assert that the correct type of feature was defined
				throw new ClassCastException();
			}
			
			return (O) operation;
		} catch (RuntimeException e) {
			propagate(e, "define"); //$NON-NLS-1$
		}
		
		return null;  // make the compiler happy
	}
	
	@SuppressWarnings("unchecked")
	public P defineAttribute(String defExpression) throws ParserException {
		try {
			EObject property = define(defExpression);
			
			if (!uml.isProperty(property)) {
				// assert that the correct type of feature was defined
				throw new ClassCastException();
			}
			
			return (P) property;
		} catch (RuntimeException e) {
			propagate(e, "define"); //$NON-NLS-1$
		}
		
		return null;  // make the compiler happy
	}
	
	EObject define(String defExpression) throws ParserException {
		CT constraint = HelperUtil.parseDefExpression(
            this, defExpression, validating, ocl.isParseTracingEnabled());
		
		List<EObject> constrainedElement = uml.getConstrainedElements(constraint);
		EObject result = constrainedElement.get(1);
		
		if (!ParsingOptions.getValue(getEnvironment(), ParsingOptions.DEFINITION_CONSTRAINS_FEATURE)) {
		    // remove it for good measure
		    constrainedElement.remove(result);
		}
		
		return result;
	}

	/**
	 * Creates a null condition of the specified <code>type</code>.
	 * 
	 * @param type the condition type
	 * 
	 * @return an expression whose value is <code>false</code> for boolean type
	 *     or <code>null</code> for anything else
	 */
	private CT createNullCondition(C type) {
		OCLExpression<C> condition;
		
        OCLStandardLibrary<C> stdlib = env.getOCLStandardLibrary();
        
		if (type == stdlib.getBoolean()) {
			BooleanLiteralExp<C> literal =
				oclFactory.createBooleanLiteralExp();
			condition = literal;
			uml.setType(literal, env.getOCLStandardLibrary().getBoolean());
			literal.setBooleanSymbol(Boolean.FALSE);
		} else {
			UnspecifiedValueExp<C> unspec =
				oclFactory.createUnspecifiedValueExp();
			condition = unspec;
			
			if (type == null) {
				type = env.getOCLStandardLibrary().getOclVoid();
			}
			
			uml.setType(unspec, type);
		}
		
		CT result = uml.createConstraint();
		
		ExpressionInOCL<C, PM> spec = uml.createExpressionInOCL();
		spec.setBodyExpression(condition);
		spec.setContextVariable(env.getSelfVariable());
		
		uml.setSpecification(result, spec);
		return result;
	}
	
	/**
	 * Propagates the specified exception as a parsing exception, with
	 * the requisite tracing.
	 * 
	 * @param e the exception to propagate
	 * @param method the name of the method that caught the exception
	 * 
	 * @throws the exception wrapped in an {@link ParserException}
	 */
	private void propagate(Exception e, String method) throws ParserException {
		OCLPlugin.catching(getClass(), method, e);
		ParserException ope = new ParserException(e.getLocalizedMessage(), e);
		OCLPlugin.throwing(getClass(), method, ope);
		
		throw ope;
	}

	/**
	 * returns the ocl syntax helper object
	 * 
	 * @return OCLSyntaxHelper
	 */
	protected OCLSyntaxHelper<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createSyntaxHelper() {
		if (syntaxHelper == null) {
			syntaxHelper = new OCLSyntaxHelper<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
					getEnvironment());
		}
		return syntaxHelper;
	}
	
	public Diagnostic getProblems() {
		return problems;
	}
	
	void setProblems(Diagnostic problems) {
		this.problems = problems;
	}
}