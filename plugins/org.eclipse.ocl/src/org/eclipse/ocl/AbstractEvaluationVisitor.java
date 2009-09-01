/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 238050, 253252
 *   Radek Dvorak - Bugs 261128, 265066
 *
 * </copyright>
 *
 * $Id: AbstractEvaluationVisitor.java,v 1.11 2009/09/01 20:11:23 ewillink Exp $
 */
package org.eclipse.ocl;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.OCLStatusCodes;
import org.eclipse.ocl.internal.evaluation.NumberUtil;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.options.EvaluationOptions;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.utilities.AbstractVisitor;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.Visitable;

/**
 * An evaluation visitor implementation for OCL expressions.
 * <p>
 * <b>Note</b> that this class is not intended to be used or extended by
 * clients.  Use the {@link AbstractEvaluationVisitor} interface, instead.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	extends AbstractVisitor<Object, C, O, P, EL, PM, S, COA, SSA, CT>
	implements EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

    // stereotypes associated with boolean-valued constraints
	private static Set<String> BOOLEAN_CONSTRAINTS;
	
	private EvaluationEnvironment<C, O, P, CLS, E> evalEnv;
	private Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env;
	private OCLStandardLibrary<C> stdlib;
	
	private Map<? extends CLS, ? extends Set<? extends E>> extentMap;

    private EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> visitor;
    
	static {
		BOOLEAN_CONSTRAINTS = new java.util.HashSet<String>();
		BOOLEAN_CONSTRAINTS.add(UMLReflection.INVARIANT);
		BOOLEAN_CONSTRAINTS.add(UMLReflection.PRECONDITION);
		BOOLEAN_CONSTRAINTS.add(UMLReflection.POSTCONDITION);
	}
	
	/**
	 * Initializes me.
	 * 
     * @param env the current environment
	 * @param evalEnv an evaluation environment (map of variable names to values)
	 * @param extentMap a map of classes to their instance sets
	 */
	protected AbstractEvaluationVisitor(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			EvaluationEnvironment<C, O, P, CLS, E> evalEnv,
			Map<? extends CLS, ? extends Set<? extends E>> extentMap) {
        
        this.evalEnv = evalEnv;
        this.env = env;
        stdlib = env.getOCLStandardLibrary();
        this.extentMap = extentMap;
        
        this.visitor = this;  // assume I have no decorator
    }
    
    /**
     * Obtains the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.  This
     * handles the case in which I am decorated by another visitor that must
     * intercept every <tt>visitXxx()</tt> method.  If I internally just
     * recursively visit myself, then this decorator is cut out of the picture.
     * 
     * @return my delegate visitor, which may be my own self or some other
     */
    protected final EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
    getVisitor() {
        return visitor;
    }

	/**
	 * Sets the evaluation environment to be used by this visitor during
	 * evaluation.
	 * 
	 * @param evaluationEnvironment
	 *            non-null evaluation environment
	 * @throws IllegalArgumentException
	 *             if the passed <code>evaluationEnvironment</code> is
	 *             <code>null</code>
	 * 
	 * @since 1.3
	 */
	protected void setEvaluationEnvironment(
			EvaluationEnvironment<C, O, P, CLS, E> evaluationEnvironment) {
		
		if (evaluationEnvironment == null) {
			throw new IllegalArgumentException("null evaluation environment"); //$NON-NLS-1$
		}

		this.evalEnv = evaluationEnvironment;
	}
    
    /**
     * Sets the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.
     * 
     * @param visitor my delegate visitor
     * 
     * @see #getVisitor()
     */
    void setVisitor(EvaluationVisitor<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> visitor) {
        this.visitor = visitor;
    }
    
    // implements the interface method
	public EvaluationEnvironment<C, O, P, CLS, E> getEvaluationEnvironment() {
		return evalEnv;
	}

    // implements the interface method
	public Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getEnvironment() {
		return env;
	}
    
    protected UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> getUMLReflection() {
        return env.getUMLReflection();
    }
	
    // implements the interface method
	public Map<? extends CLS, ? extends Set<? extends E>> getExtentMap() {
		return extentMap;
	}

    /**
     * Obtains my environment's OCL Standard Library implementation.
     * 
     * @return the OCL standard library
     */
	protected OCLStandardLibrary<C> getStandardLibrary() {
		return stdlib;
	}
	
    /**
     * Obtains my environment's implementation of the <tt>OclInvalid</tt> value.
     * 
     * @return the invalid result
     * @since 3.0
     */
	protected final Object getInvalid() {
		return getStandardLibrary().getInvalid();
	}
    
    /**
     * Obtains my environment's implementation of the OCL <tt>Boolean</tt> type.
     * 
     * @return the boolean type
     */
    protected final C getBoolean() {
        return getStandardLibrary().getBoolean();
    }
    
    /**
     * Obtains my environment's implementation of the OCL <tt>String</tt> type.
     * 
     * @return the string type
     */
    protected final C getString() {
        return getStandardLibrary().getString();
    }
    
    /**
     * Obtains my environment's implementation of the OCL <tt>Integer</tt> type.
     * 
     * @return the integer type
     */
    protected final C getInteger() {
        return getStandardLibrary().getInteger();
    }
    
    /**
     * Obtains my environment's implementation of the OCL <tt>UnlimitedNatural</tt> type.
     * 
     * @return the unlimited natural type
     */
    protected final C getUnlimitedNatural() {
        return getStandardLibrary().getUnlimitedNatural();
    }
    
    /**
     * Obtains my environment's implementation of the OCL <tt>Real</tt> type.
     * 
     * @return the real type
     */
    protected final C getReal() {
        return getStandardLibrary().getReal();
    }
	
    /**
     * Obtains the name of the specified element, if it has one.
     * 
     * @param namedElement a named element
     * @return its name, or <code>null</code> if it has none
     */
	protected String getName(Object namedElement) {
		return getEnvironment().getUMLReflection().getName(namedElement);
	}

	/**
	 * This default implementation simply asks the <tt>expression</tt> to
	 * {@linkplain Visitable#accept(org.eclipse.ocl.utilities.Visitor) accept}
	 * me.
	 * 
	 * @param expression an OCL expression to evaluate
	 * 
	 * @return the result of the evaluation
	 */
	public Object visitExpression(OCLExpression<C> expression) {
        try {
            return expression.accept(getVisitor());
        } catch (EvaluationHaltedException e) {
        	// evaluation stopped on demand, propagate further
        	throw e;
        } catch (RuntimeException e) {
            String msg = e.getLocalizedMessage();
            if (msg == null) {
                msg = OCLMessages.no_message;
            }
            OCLPlugin.log(Diagnostic.ERROR, OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
                OCLMessages.bind(OCLMessages.EvaluationFailed_ERROR_, msg), e);
            
            // failure to evaluate results in invalid
            return getInvalid();
        }
	}
	
	/**
	 * This default implementation asserts that the <tt>constraint</tt> is
	 * boolean-valued if it is an invariant, pre-condition, or post-condition
	 * constraint and returns the value of its body expression by delegation to
	 * {@link #visitExpression(OCLExpression)}.
	 */
	@Override
    public Object visitConstraint(CT constraint) {
		OCLExpression<C> body = getSpecification(constraint).getBodyExpression();
		boolean isBoolean = BOOLEAN_CONSTRAINTS.contains(
				getEnvironment().getUMLReflection().getStereotype(constraint));
		
		if (body == null) {
			throw new IllegalArgumentException("constraint has no body expression"); //$NON-NLS-1$
		}
		
		if (isBoolean && (body.getType() != getBoolean())) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		
		Object result = getVisitor().visitExpression(body);
		
		return isBoolean? Boolean.TRUE.equals(result) : result;
	}
    
    // overrides the inherited no-op implementation
    @Override
    protected ExpressionInOCL<C, PM> getSpecification(CT constraint) {
        return getEnvironment().getUMLReflection().getSpecification(constraint);
    }
	
	@Override
    public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (evaluation environment: ");//$NON-NLS-1$
		result.append(getEvaluationEnvironment());
		result.append(')');
		return result.toString();
	}
	
	/**
	 * Convenience method to determine whether the specified value is the null
     * or <tt>OclInvalid</tt>.
	 * 
	 * @param value a value
	 * 
	 * @return whether it is undefined
	 */
	protected boolean isUndefined(Object value) {
		return (value == null) || 
			(value == getEnvironment().getOCLStandardLibrary().getInvalid());
	}
    
    /**
     * Invokes the specified additional operation on a target object.
     * The invocation is performed in a nested evaluation environment.
     * 
     * @param operation the operation to invoke
     * @param body the operation's body expression
     * @param target the object on which to evaluate the operation body
     * @param args the arguments to the operation call
     */
    protected Object call(O operation, OCLExpression<C> body, Object target, Object[] args) {
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> myEnv =
			getEnvironment();

		EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> factory =
			myEnv.getFactory();

    	// create a nested evaluation environment for this operation call
    	EvaluationEnvironment<C, O, P, CLS, E> nested =
    		factory.createEvaluationEnvironment(getEvaluationEnvironment());
    	
    	// bind "self"
    	nested.add(Environment.SELF_VARIABLE_NAME, target);
    	
    	// add the parameter bindings to the local variables
    	if (args.length > 0) {
    		int i = 0;
    		for (PM param : myEnv.getUMLReflection().getParameters(operation)) {
    			nested.add(myEnv.getUMLReflection().getName(param), args[i++]);
    		}
    	}
    	
    	return factory.createEvaluationVisitor(
    			myEnv, nested, getExtentMap()).visitExpression(body);
    }
    
    /**
     * Obtains the body of the specified operation's def or body expression,
     * if any.
     * 
     * @param operation an operation
     * 
     * @return its value expression, if any
     */
    protected OCLExpression<C> getOperationBody(O operation) {
    	OCLExpression<C> result = null;
    	
    	CT body = env.getDefinition(operation);
    	if (body == null) {
    		body = env.getBodyCondition(operation);
    	}
    	
    	if (body != null) {
    		result = env.getUMLReflection().getSpecification(body).getBodyExpression();
    	}
    	
    	return result;
    }
    
    /**
     * Obtains the body of the specified property's def or der expression,
     * if any.
     * 
     * @param property a property
     * 
     * @return its value expression, if any
     */
    protected OCLExpression<C> getPropertyBody(P property) {
    	OCLExpression<C> result = null;
    	
    	CT body = env.getDefinition(property);
    	if (body == null) {
    		body = env.getDeriveConstraint(property);
    	}
    	
    	if (body != null) {
    		result = env.getUMLReflection().getSpecification(body).getBodyExpression();
    	}
    	
    	return result;
    }

    /**
     * Obtains an object's value of the specified additional property.
     * 
     * @param property the property to navigate
     * @param derivation the expression that computes its value
     * @param target the object in which context to evaluate the derivation
     * 
     * @return the property's value
     */
    protected Object navigate(P property, OCLExpression<C> derivation, Object target) {
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> myEnv =
			getEnvironment();

		EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> factory =
			myEnv.getFactory();

    	// create a nested evaluation environment for this property call
    	EvaluationEnvironment<C, O, P, CLS, E> nested =
    		factory.createEvaluationEnvironment(getEvaluationEnvironment());
    	
    	// bind "self"
    	nested.add(Environment.SELF_VARIABLE_NAME, target);
    	
    	return factory.createEvaluationVisitor(
    			myEnv, nested, getExtentMap()).visitExpression(derivation);
    }

	/**
	 * Checks whether the supplied object is an instance of the supplied type.
	 * 
	 * @param value the value to check
	 * @param typeArg the type to check
	 * @return true if the object is an instance of the type, false otherwise.
	 */
	protected Boolean oclIsTypeOf(Object value, Object typeArg) {
		@SuppressWarnings("unchecked")
		C type = (C) typeArg;
		
		// regardless of the source value, if the type is undefined, then so
		//    is oclIsTypeOf
		if (type == null) {
		    return null;
		}
		
		// the type of null is OclVoid, except that we aren't even allowed to
		// ask if not lax-null-handling
		if (value == null) {
			return isLaxNullHandling()
				? Boolean.valueOf(type instanceof VoidType<?>)
				: null;
		}

		// the type of invalid is OclInvalid, except that we aren't even allowed
		// to ask if not lax-null-handling
		if (value == stdlib.getInvalid()) {
			return isLaxNullHandling()
				? Boolean.valueOf(type instanceof InvalidType<?>)
				: null;
		}

		return Boolean.valueOf(getEvaluationEnvironment().isTypeOf(value, type));
	}

	/**
	 * Checks whether the supplied value is an instance of the supplied type or
	 * one of its super types.
	 * 
	 * @param value the value to check
	 * @param typeArg the type to check
	 * @return true iff the value is of the type or one of its super types.
	 */
	protected Boolean oclIsKindOf(Object value, Object typeArg) {
		@SuppressWarnings("unchecked")
		C type = (C) typeArg;
		
		// regardless of the source value, if the type is undefined, then so
		//    is oclIsTypeOf
		if (type == null) {
			return null;
		}
		
		// OclVoid and Invalid conform to all classifiers but their instances
		// aren't actually useful as any type but their own.  So, in case of lax
		// null handling, return TRUE.  Otherwise, oclIsKindOf isn't even
		// permitted, so return null to generate an OclInvalid down the line
		if (isUndefined(value)) {
			return isLaxNullHandling()
				? Boolean.TRUE
				: null;
		}

		return Boolean.valueOf(getEvaluationEnvironment().isKindOf(value, type));
	}
	
    /**
     * <p>
     * Tests whether a given number can be safely coerced to <tt>Double</tt> or
     * <tt>Integer</tt> without changing the value of the number.  Safe means 
     * that coercing a number to <tt>Double</tt> or <tt>Integer</tt> and then
     * coercing it back to the original type will result in the same value (no
     * loss of precision).  This is trivial for types, which have a smaller
     * domain then <tt>Integer</tt> or <tt>Double</tt>, but for
     * example a <tt>Long</tt> number may not be safely coerced to
     * <tt>Integer</tt>.
     * </p><p>
     * If the coercion is safe, the number will be returned as either
     * <tt>Double</tt> or <tt>Integer</tt>, as appropriate to the original
     * precision.  Otherwise the original number is returned. 
     * </p>
     * 
     * @param number a number to coerce to <tt>Integer</tt> or <tt>Double</tt>
     * @return the coerced number, or the original number, if coercion was not safe
     * 
     * @since 1.2
     */
	protected Number coerceNumber(Number number) {
	    return NumberUtil.coerceNumber(number);
	}
    
    /**
     * <p>
     * Coerces the given number to <tt>Double</tt> or <tt>Long</tt> precision,
     * if possible.  Note that this is only impossible for <tt>BigDecimal</tt>
     * or <tt>BigInteger</tt> values, respectively, that are out of range of
     * their primitive counterparts.
     * </p>
     * 
     * @param number a number to coerce to <tt>Long</tt> or <tt>Double</tt>
     * @return the coerced number, or the original number, in case of overflow
     * 
     * @since 1.2
     */
    protected Number higherPrecisionNumber(Number number) {
        return NumberUtil.higherPrecisionNumber(number);
    }
	
	/**
	 * Queries whether our evaluation environment has the option for
	 * {@linkplain EvaluationOptions#LAX_NULL_HANDLING lax null handling}
	 * enabled.
	 * 
	 * @since 1.3
	 * @return whether lax null handling is enabled
	 */
	protected boolean isLaxNullHandling() {
	    return EvaluationOptions.getValue(getEvaluationEnvironment(),
	        EvaluationOptions.LAX_NULL_HANDLING);
	}
} //EvaluationVisitorImpl
