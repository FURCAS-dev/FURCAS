/**
 * <copyright>
 * 
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLHelper.java,v 1.11 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.parser.CompatibilityUtil;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;

/**
 * Default implementation of the {@link IOCLHelper} interface.
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
class OCLHelper
	implements IOCLHelper {

	private EnvironmentFactory environmentFactory;
	private Environment environment;
	
	/**
	 * Initializes me with my environment factory.
	 * 
	 * @param factory used to create OCL environments
	 */
	OCLHelper(EnvironmentFactory factory) {
		if (factory == null) {
			HelperUtil.throwException(new IllegalArgumentException(
				"OCLHelper"), getClass(), "OCLHelper"); //$NON-NLS-2$//$NON-NLS-1$        	
		}
		
		environmentFactory = factory;
	}

	public EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}
	
	public Environment getEnvironment() {
		return environment;
	}
	
	/**
	 * Strips any leading, trailing, or embedded comments from the specified OCL
	 * expression text.
	 * 
	 * @param txt an OCL expression
	 * @return the same, but without any comments.  Note that the result
	 *     may be an empty String if <code>txt</code> has only comments
	 */
	public String removeOCLComments(String txt) {
		try {
			return HelperUtil.getLogicalLine(txt);
		} catch (Exception ex) {
			HelperUtil.catchException(ex, getClass(), "removeOCLComments");//$NON-NLS-1$
		}
		return HelperUtil.EMPTY;
	}

	public void setContext(Object context) {
		environment = environmentFactory.createClassifierContext(context);
        adjustEnvironmentFactory(environment, environmentFactory);
	}

    /**
     * In case the particular environment factory didn't correctly assign the
     * factory back-reference of the environments that it creates, force
     * consistency in case of an <code>EcoreEnvironment</code>.  We do this
     * because, prior to the introduction of this compatibility layer, the
     * {@link Environment#getFactory()} API was never actually used by the
     * helper.
     * 
     * @param env an environment
     * @param factory the factory that I used to create it
     */
    private void adjustEnvironmentFactory(Environment env, EnvironmentFactory factory) {
        if (env instanceof EcoreEnvironment) {
            ((EcoreEnvironment) env).new Access() {
                @Override
                public void setFactory(EnvironmentFactory factory) {
                    super.setFactory(factory);
                }
            }.setFactory(factory);
        }
    }
    
	public void setContextOperation(Object context, Object operation) {
		environment = environmentFactory.createOperationContext(context, operation);
        adjustEnvironmentFactory(environment, environmentFactory);
	}
	
	public void setContextProperty(Object context, Object property) {
		environment = environmentFactory.createPropertyContext(context, property);
        adjustEnvironmentFactory(environment, environmentFactory);
	}
	
	public EClassifier getContextClassifier() {
		return environment.getContextClassifier();
	}
	
	public EOperation getContextOperation() {
		return environment.getContextOperation();
	}
	
	public EStructuralFeature getContextProperty() {
		return environment.getContextProperty();
	}

	/** @deprecated */
	@Deprecated
    public List getSyntaxHelp(String txt) {
		return (getContextOperation() != null)?
			getSyntaxHelp(ConstraintType.POSTCONDITION, txt) :
			getSyntaxHelp(ConstraintType.INVARIANT, txt);
	}

	public List getSyntaxHelp(ConstraintType constraintType, String txt) {
		org.eclipse.ocl.EnvironmentFactory<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject> factory =
			CompatibilityUtil.getCompatibilityFactory(environmentFactory);
		
		org.eclipse.ocl.helper.OCLHelper<EClassifier, EOperation, EStructuralFeature, Constraint>
		helper = org.eclipse.ocl.internal.helper.HelperUtil.createOCLHelper(
					OCL.newInstance(CompatibilityUtil.getCompatibilityEnvironment(
							null,
							environment, factory)));
		
		List<org.eclipse.ocl.helper.Choice> choices = helper.getSyntaxHelp(
				convertConstraintType(constraintType), txt);
		return convertChoices(choices);
	}

	public OCLExpression createQuery(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createQuery(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createQuery"); //$NON-NLS-1$
			}
		}
		
		// may as well create a boolean-valued expression if none was supplied
		return createNullCondition(EcorePackage.eINSTANCE.getEBoolean());
	}

	public OCLExpression createInvariant(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createInvariant(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createInvariant"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(EcorePackage.eINSTANCE.getEBoolean());
	}

	public OCLExpression createPrecondition(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createPrecondition(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createPrecondition"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(EcorePackage.eINSTANCE.getEBoolean());
	}
	
	public OCLExpression createPostcondition(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createPostcondition(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createPostcondition"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(EcorePackage.eINSTANCE.getEBoolean());
	}
	
	public OCLExpression createBodyCondition(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createBodyCondition(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createBodyCondition"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(Types.OCL_VOID);
	}
	
	public OCLExpression createInitialValueExpression(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createInitialValueExpression(
						environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createInitialValueExpression"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(Types.OCL_VOID);
	}
	
	public OCLExpression createDerivedValueExpression(String expression) throws OCLParsingException {
		if (removeOCLComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createDerivedValueExpression(
						environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createDerivedValueExpression"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(Types.OCL_VOID);
	}
	
	public ETypedElement define(String defExpression) throws OCLParsingException {
		try {
			return ExpressionsUtil.define(environment, defExpression);
		} catch (Exception e) {
			propagate(e, "define"); //$NON-NLS-1$
		}
		
		return null;  // make the compiler happy
	}
	
	public Object evaluate(Object context, OCLExpression expr) {
		Object result = null;
		
		Query q = QueryFactory.eINSTANCE.createQuery(expr);
		q.setExtentMap(environmentFactory.createExtentMap(context));
		q.setEvaluationEnvironment(environmentFactory.createEvaluationEnvironment());
		
		result = q.evaluate(context);
		
		return result;
	}
	
	public Object evaluate(Object context, String expr) throws OCLParsingException {
		OCLExpression ocl = null;
		
		try {
			ocl = ExpressionsUtil.createQuery(
				environment,
				expr,
				true);
		} catch (Exception e) {
			propagate(e, "evaluate"); //$NON-NLS-1$
		}
		
		return evaluate(context, ocl);
	}
	
	public boolean check(Object context, OCLExpression constraint) {
		
		if (!(constraint.getType() instanceof PrimitiveBoolean)) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		
		Object result = evaluate(context, constraint);
		
		return Boolean.TRUE.equals(result);
	}
	
	public boolean check(Object context, String constraint)
		throws OCLParsingException {
		
		OCLExpression ocl = null;
		
		try {
			ocl = ExpressionsUtil.createInvariant(
				environment,
				constraint,
				true);
		} catch (Exception e) {
			propagate(e, "evaluate"); //$NON-NLS-1$
		}
		
		return check(context, ocl);
	}
	
	/**
	 * Creates a null condition of the specified <code>type</code>.
	 * 
	 * @param type the condition type
	 * 
	 * @return an expression whose value is <code>false</code> for boolean type
	 *     or <code>null</code> for anything else
	 */
	private OCLExpression createNullCondition(EClassifier type) {
		OCLExpression result;
		
		if (isBoolean(type)) {
			BooleanLiteralExp literal = ExpressionsFactory.eINSTANCE.createBooleanLiteralExp();
			result = literal;
			literal.setType(EcorePackage.eINSTANCE.getEBoolean());
			literal.setBooleanSymbol(Boolean.FALSE);
		} else {
			UnspecifiedValueExp unspec = ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp();
			result = unspec;
			
			if (type == null) {
				type = Types.OCL_VOID;
			}
			
			unspec.setType(type);
		}
		
		return result;
	}
	
	/**
	 * Determines whether the specified type is an OCL boolean type.
	 * 
	 * @param type an OCL type (may be <code>null</code>)
	 * @return whether it is an OCL boolean type
	 */
	private static boolean isBoolean(EClassifier type) {
		boolean result =
			TypesPackage.eINSTANCE.getPrimitiveBoolean().isInstance(type);
		
		if (!result && (type != null)) {
			// is it some other representation of boolean (e.g., EBoolean)?
			Class javaClass = type.getInstanceClass();
			result = (javaClass == boolean.class) || (javaClass == Boolean.class);
		}
		
		return result;
	}
	
	/**
	 * Propagates the specified exception as a parsing exception, with
	 * the requisite tracing.
	 * 
	 * @param e the exception to propagate
	 * @param method the name of the method that caught the exception
	 * 
	 * @throws the exception wrapped in an {@link OCLParsingException}
	 */
	private void propagate(Exception e, String method) throws OCLParsingException {
		OCLPlugin.catching(getClass(), method, e);
		OCLParsingException ope = new OCLParsingException(e.getLocalizedMessage(), e);
		OCLPlugin.throwing(getClass(), method, ope);
		
		throw ope;
	}
	
	private static List<Choice> convertChoices(
			List<org.eclipse.ocl.helper.Choice> choices) {
		
		List<Choice> result = new ArrayList<Choice>(choices.size());
		
		for (org.eclipse.ocl.helper.Choice choice : choices) {
			result.add(new Choice(
					choice.getName(),
					choice.getDescription(),
					convertKind(choice)));
		}
		
		return result;
	}
	
	private static ChoiceType convertKind(org.eclipse.ocl.helper.Choice choice) {
		switch (choice.getKind()) {
		case PROPERTY:
			if (choice.getElement() instanceof EAttribute) {
				EAttribute attr = (EAttribute) choice.getElement();
				
				if (attr.getEType() instanceof EEnum) {
					// maintain the old mapping of enumeration-type attributes
					return ChoiceType.ENUMERATION_LITERAL;
				}
			}
			// other properties are just the old structural-feature kind
			return ChoiceType.STRUCTURAL_FEATURE;
		case OPERATION:
		case SIGNAL:
			return ChoiceType.BEHAVIORAL_FEATURE;
		case VARIABLE:
			return ChoiceType.VARIABLE;
		case TYPE:
		case STATE:
		case ASSOCIATION_CLASS:
		case PACKAGE:
		case ENUMERATION_LITERAL: // maintain the old mapping of enumeration values
			return ChoiceType.STRUCTURAL_FEATURE;
		default:
			return ChoiceType.UNCATEGORIZED;
		}
	}
	
	private static org.eclipse.ocl.helper.ConstraintKind convertConstraintType(
			ConstraintType kind) {
		
		switch (kind.getValue()) {
		case ConstraintType.PRECONDITION_VALUE:
			return org.eclipse.ocl.helper.ConstraintKind.PRECONDITION;
		case ConstraintType.BODYCONDITION_VALUE:
			return org.eclipse.ocl.helper.ConstraintKind.BODYCONDITION;
		case ConstraintType.POSTCONDITION_VALUE:
			return org.eclipse.ocl.helper.ConstraintKind.POSTCONDITION;
		default:
			return org.eclipse.ocl.helper.ConstraintKind.INVARIANT;
		}
	}
}
