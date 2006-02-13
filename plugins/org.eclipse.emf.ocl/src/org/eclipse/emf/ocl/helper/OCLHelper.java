/**
 * <copyright>
 *
 * Copyright (c) 2002-2006 IBM Corporation and others.
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
 * $Id: OCLHelper.java,v 1.2 2006/02/13 19:48:04 cdamus Exp $
 */

package org.eclipse.emf.ocl.helper;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

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

	private OCLSyntaxHelper oclSyntaxHelper;
	
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
	
	/**
	 * Strips any leading, trailing, or embedded comments from the specified OCL
	 * expression text.
	 * 
	 * @param txt an OCL expression
	 * @return the same, but without any comments.  Note that the result
	 *     may be an empty String if <code>txt</code> has only comments
	 */
	public String removeOclComments(String txt) {
		try {
			return HelperUtil.getLogicalLine(txt);
		} catch (Exception ex) {
			HelperUtil.catchException(ex, getClass(), "removeOclComments");//$NON-NLS-1$
		}
		return HelperUtil.EMPTY;
	}

	public void setContext(Object context) {
		environment = environmentFactory.createClassifierContext(context);
	}
	
	public void setContextOperation(Object context, Object operation) {
		environment = environmentFactory.createOperationContext(context, operation);
	}
	
	public EClassifier getContextClassifier() {
		return environment.getContextClassifier();
	}
	
	public EOperation getContextOperation() {
		return environment.getContextOperation();
	}

	/** @deprecated */
	public List getSyntaxHelp(String txt) {
		return (getContextOperation() != null)?
			getSyntaxHelp(ConstraintType.POSTCONDITION, txt) :
			getSyntaxHelp(ConstraintType.INVARIANT, txt);
	}

	public List getSyntaxHelp(ConstraintType constraintType, String txt) {
		return getOclSyntaxHelper().getSyntaxHelp(environment, constraintType, txt);
	}

	public OCLExpression createQuery(String expression) throws OCLParsingException {
		if (removeOclComments(expression).length() > 0) {
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
		if (removeOclComments(expression).length() > 0) {
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
		if (removeOclComments(expression).length() > 0) {
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
		if (removeOclComments(expression).length() > 0) {
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
		if (removeOclComments(expression).length() > 0) {
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
		
		return ((Boolean) result).booleanValue();
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

	/**
	 * returns the ocl syntax helper object
	 * 
	 * @return OCLSyntaxHelper
	 */
	protected OCLSyntaxHelper getOclSyntaxHelper() {
		if (oclSyntaxHelper == null) {
			oclSyntaxHelper = new OCLSyntaxHelper(getEnvironmentFactory());
		}
		return oclSyntaxHelper;
	}
}