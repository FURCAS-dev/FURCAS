/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
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
 * $Id: AbstractEvaluationVisitor.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.evaluation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.InvalidLiteralExp;
import org.eclipse.ocl.examples.pivot.NullLiteralExp;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;
import org.eclipse.ocl.examples.pivot.options.EvaluationOptions;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.AbstractVisitor2;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;

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
public abstract class AbstractEvaluationVisitor
	extends AbstractVisitor2<Value> implements EvaluationVisitor {

	public static final Logger logger = Logger.getLogger(AbstractEvaluationVisitor.class);

    // stereotypes associated with boolean-valued constraints
	private static Set<String> BOOLEAN_CONSTRAINTS;
	
	private EvaluationEnvironment evalEnv;
	private Environment env;
	protected final TypeManager typeManager;
	
	private ModelManager modelManager;

    private EvaluationVisitor undecoratedVisitor;
    
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
	 * @param modelManager a map of classes to their instance sets
	 */
	protected AbstractEvaluationVisitor(
			Environment env,
			EvaluationEnvironment evalEnv,
			ModelManager modelManager) {
        super(null);
        this.evalEnv = evalEnv;
        this.env = env;
        this.typeManager = env.getTypeManager();
        this.modelManager = modelManager;
        
        this.undecoratedVisitor = this;  // assume I have no decorator
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
    protected Object call(Operation operation, OclExpression body, Value target, Value[] args) {
    	// create a nested evaluation environment for this operation call
    	EvaluationVisitor nestedVisitor = getUndecoratedVisitor().createNestedVisitor();		
    	EvaluationEnvironment nestedEvalEnv = nestedVisitor.getEvaluationEnvironment();
    	
    	// bind "self"
    	nestedEvalEnv.add(Environment.SELF_VARIABLE_NAME, target);
    	
    	// add the parameter bindings to the local variables
    	if (args.length > 0) {
    		UMLReflection umlReflection = getEnvironment().getUMLReflection();
    		int i = 0;
 			for (Parameter param : umlReflection.getParameters(operation)) {
    			nestedEvalEnv.add(umlReflection.getName(param), args[i++]);
    		}
    	}
		return body.accept(nestedVisitor);
    }

	public Value createInvalidValue(Object object, OclExpression expression, String reason, Throwable throwable) {
        return getValueFactory().createInvalidValue(object, expression, reason, throwable);
	}
   
    /**
     * Obtains my environment's implementation of the OCL <tt>Boolean</tt> type.
     * 
     * @return the boolean type
     */
	public final Type getBooleanType() {
        return getStandardLibrary().getBooleanType();
    }

//	public Object getBooleanValue(boolean value) {
//		return value;
//	}

    // implements the interface method
	public Environment getEnvironment() {
		return env;
	}
    
    // implements the interface method
	public EvaluationEnvironment getEvaluationEnvironment() {
		return evalEnv;
	}
	
    // implements the interface method
	public ModelManager getModelManager() {
		return modelManager;
	}
    
    /**
     * Obtains my environment's implementation of the OCL <tt>Integer</tt> type.
     * 
     * @return the integer type
     */
    public final Type getIntegerType() {
        return getStandardLibrary().getIntegerType();
    }

	public Object getIntegerValue(BigInteger value) {
		return value;
	}
	
    public final Type getInvalidType() {
        return getStandardLibrary().getOclInvalidType();
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
	
    public final Type getNullType() {
        return getStandardLibrary().getOclVoidType();
    }
    
    /**
     * Obtains the body of the specified operation's def or body expression,
     * if any.
     * 
     * @param operation an operation
     * 
     * @return its value expression, if any
     */
    protected OclExpression getOperationBody(Operation operation) {
    	OclExpression result = null;
    	
    	Constraint body = env.getDefinition(operation);
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
    protected OclExpression getPropertyBody(Property property) {
    	OclExpression result = null;
    	
    	Constraint body = env.getDefinition(property);
    	if (body == null) {
    		body = env.getDeriveConstraint(property);
    	}
    	
    	if (body != null) {
    		result = env.getUMLReflection().getSpecification(body).getBodyExpression();
    	}
    	
    	return result;
    }
    
    /**
     * Obtains my environment's implementation of the OCL <tt>Real</tt> type.
     * 
     * @return the real type
     */
    public final Type getRealType() {
        return getStandardLibrary().getRealType();
    }

	public Object getRealValue(BigDecimal value) {
		return value;
	}
    
    // overrides the inherited no-op implementation
    @Override
    protected ExpressionInOcl getSpecification(Constraint constraint) {
        return getEnvironment().getUMLReflection().getSpecification(constraint);
    }

    /**
     * Obtains my environment's OCL Standard Library implementation.
     * 
     * @return the OCL standard library
     */
	public StandardLibrary getStandardLibrary() {
		return typeManager;
	}
    
    /**
     * Obtains my environment's implementation of the OCL <tt>String</tt> type.
     * 
     * @return the string type
     */
    public final Type getStringType() {
        return getStandardLibrary().getStringType();
    }

	public Object getStringValue(String value) {
		return value;
	}
    
    protected UMLReflection getUMLReflection() {
        return env.getUMLReflection();
    }
    
    /**
     * Obtains my environment's implementation of the OCL <tt>UnlimitedNatural</tt> type.
     * 
     * @return the unlimited natural type
     */
    public final Type getUnlimitedNaturalType() {
        return getStandardLibrary().getUnlimitedNaturalType();
    }

	public Object getUnlimitedNaturalValue(BigInteger value) {
		return value;
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
    protected final EvaluationVisitor getUndecoratedVisitor() {
        return undecoratedVisitor;
    }
    
    /**
     * Obtains the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.  This
     * handles the case in which I am decorated by another visitor that must
     * intercept every <tt>visitXxx()</tt> method.  If I internally just
     * recursively visit myself, then this decorator is cut out of the picture.
     * 
     * @return my delegate visitor, which may be my own self or some other
     * 
     * @deprecated use {@link #getUndecoratedVisitor}
     */
	@Deprecated
    protected final EvaluationVisitor getVisitor() {
        return undecoratedVisitor;
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

	@Deprecated
	public boolean isDefined(Object value) {
		if (value == null) {
			return false;
		}
		if (value instanceof InvalidLiteralExp) {
			return false;
		}
		if (value instanceof NullLiteralExp) {
			return false;
		}
		return true;
	}
	
	/**
	 * Convenience method to determine whether the specified value is the null
     * or <tt>OclInvalid</tt>.
	 * 
	 * @param value a value
	 * 
	 * @return whether it is undefined
	 */
//	@Deprecated
//	protected boolean isUndefined(Object value) {
//		return (value == null) || 
//			(value == getEnvironment().getOCLStandardLibrary().getInvalidValue());
//	}

    /**
     * Obtains an object's value of the specified additional property.
     * 
     * @param property the property to navigate
     * @param derivation the expression that computes its value
     * @param target the object in which context to evaluate the derivation
     * 
     * @return the property's value
     */
    protected Value navigate(Property property, OclExpression derivation, Value target) {
    	// create a nested evaluation environment for this property call
    	EvaluationVisitor nestedVisitor = getUndecoratedVisitor().createNestedVisitor();		
    	EvaluationEnvironment nestedEvalEnv = nestedVisitor.getEvaluationEnvironment();    	
    	// bind "self"
    	nestedEvalEnv.add(Environment.SELF_VARIABLE_NAME, target);
		return derivation.accept(nestedVisitor);
    }

	/**
	 * Checks whether the supplied value is an instance of the supplied type or
	 * one of its super types.
	 * 
	 * @param value the value to check
	 * @param typeArg the type to check
	 * @return true iff the value is of the type or one of its super types.
	 *
	protected Boolean oclIsKindOf(Object value, Object typeArg) {
		Type type = (Type) typeArg;
		
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
	} */

	/**
	 * Checks whether the supplied object is an instance of the supplied type.
	 * 
	 * @param value the value to check
	 * @param typeArg the type to check
	 * @return true if the object is an instance of the type, false otherwise.
	 *
	protected Boolean oclIsTypeOf(Object value, Object typeArg) {
		Type type = (Type) typeArg;
		
		// regardless of the source value, if the type is undefined, then so
		//    is oclIsTypeOf
		if (type == null) {
		    return null;
		}
		
		// the type of null is OclVoid, except that we aren't even allowed to
		// ask if not lax-null-handling
		if (value == null) {
			return isLaxNullHandling()
				? Boolean.valueOf(type instanceof VoidType)
				: null;
		}

		// the type of invalid is OclInvalid, except that we aren't even allowed
		// to ask if not lax-null-handling
		if (value == stdlib.getInvalidValue()) {
			return isLaxNullHandling()
				? Boolean.valueOf(type instanceof InvalidType)
				: null;
		}

		return Boolean.valueOf(getEvaluationEnvironment().isTypeOf(value, type));
	} */

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
			EvaluationEnvironment evaluationEnvironment) {
		
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
     * @see #getUndecoratedVisitor()
     */
	public void setUndecoratedVisitor(EvaluationVisitor evaluationVisitor) {
        this.undecoratedVisitor = evaluationVisitor;
	}
    
    /**
     * Sets the visitor on which I perform nested
     * {@link Visitable#accept(org.eclipse.ocl.utilities.Visitor)} calls.
     * 
     * @param visitor my delegate visitor
     * 
     * @see #getVisitor()
     * 
     * @deprecated use {@link #setUndecoratedVisitor}
     */
	@Deprecated
    void setVisitor(EvaluationVisitor visitor) {
		setUndecoratedVisitor(visitor);
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
	 * This default implementation asserts that the <tt>constraint</tt> is
	 * boolean-valued if it is an invariant, pre-condition, or post-condition
	 * constraint and returns the value of its body expression by delegation to
	 * {@link #visitExpression(OCLExpression)}.
	 */
	@Override
    public Value visitConstraint(Constraint constraint) {
		OclExpression body = getSpecification(constraint).getBodyExpression();
		boolean isBoolean = BOOLEAN_CONSTRAINTS.contains(
				getEnvironment().getUMLReflection().getStereotype(constraint));
		
		if (body == null) {
			throw new IllegalArgumentException("constraint has no body expression"); //$NON-NLS-1$
		}
		
		if (isBoolean && (body.getType() != getBooleanType())) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		
		Value result = body.accept(getUndecoratedVisitor());
		
		return isBoolean ? result.asTrue() : result;
	}

	/**
	 * This default implementation simply asks the <tt>expression</tt> to
	 * {@linkplain Visitable#accept(org.eclipse.ocl.utilities.Visitor) accept}
	 * me.
	 * 
	 * @param expression an OCL expression to evaluate
	 * 
	 * @return the result of the evaluation
	 *
	public Object visitExpression(OclExpression expression) {
        try {
            return expression.accept(getUndecoratedVisitor());
        } catch (EvaluationHaltedException e) {
        	// evaluation stopped on demand, propagate further
        	throw e;
        } catch (RuntimeException e) {
            String msg = e.getLocalizedMessage();
            if (msg == null) {
                msg = OCLMessages.no_message;
            }
            PivotPlugin.log(Diagnostic.ERROR, OCLStatusCodes.IGNORED_EXCEPTION_WARNING,
                OCLMessages.bind(OCLMessages.EvaluationFailed_ERROR_, msg), e);
            
            // failure to evaluate results in invalid
            return getInvalidValue();
        }
	} */

	@Deprecated
	public Value visitExpression(OclExpression expression) {
		return expression.accept(this);
	}

	public Value visiting(Visitable visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

} //EvaluationVisitorImpl
