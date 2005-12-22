/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
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
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * Default implementation of the {@link IOclHelper} interface.
 * 
 * @author Yasser Lulu
 * @author Christian W. Damus (cdamus)
 */
class OclHelper
	implements IOclHelper {

	private EnvironmentFactory environmentFactory;
	private Environment environment;

	private OclSyntaxHelper oclSyntaxHelper;
	
	/**
	 * Initializes me with my environment factory.
	 * 
	 * @param factory used to create OCL environments
	 */
	OclHelper(EnvironmentFactory factory) {
		if (factory == null) {
			HelperUtil.throwException(new IllegalArgumentException(
				"OclHelper"), getClass(), "OclHelper"); //$NON-NLS-2$//$NON-NLS-1$        	
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

	public List getSyntaxHelp(String txt) {
		return getOclSyntaxHelper().getSyntaxHelp(environment, txt);
	}

	public OclExpression createInvariant(String expression) throws OclParsingException {
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

	public OclExpression createPrecondition(String expression) throws OclParsingException {
		if (removeOclComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createPrecondition(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createInvariant"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(EcorePackage.eINSTANCE.getEBoolean());
	}
	
	public OclExpression createPostcondition(String expression) throws OclParsingException {
		if (removeOclComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createPostcondition(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createInvariant"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(EcorePackage.eINSTANCE.getEBoolean());
	}
	
	public OclExpression createBodyCondition(String expression) throws OclParsingException {
		if (removeOclComments(expression).length() > 0) {
			// be sure to pass the original expression along to get the right
			//    position information when parse fails
			try {
				return ExpressionsUtil.createBodyCondition(environment, expression, true);
			} catch (Exception e) {
				propagate(e, "createInvariant"); //$NON-NLS-1$
			}
		}
		
		return createNullCondition(Types.OCL_VOID);
	}
	
	public Object evaluate(Object context, OclExpression expr) {
		Object result = null;
		
		Query q = QueryFactory.eINSTANCE.createQuery(expr);
		q.setExtentMap(environmentFactory.createExtentMap(context));
		q.setEvaluationEnvironment(environmentFactory.createEvaluationEnvironment());
		
		result = q.evaluate(context);
		
		return result;
	}
	
	public Object evaluate(Object context, String expr) throws OclParsingException {
		OclExpression ocl = null;
		
		try {
			ocl = ExpressionsUtil.createInvariant(
				environment,
				expr,
				true);
		} catch (Exception e) {
			propagate(e, "evaluate"); //$NON-NLS-1$
		}
		
		return evaluate(context, ocl);
	}
	
	public boolean check(Object context, OclExpression constraint) {
		
		if (!(constraint.getType() instanceof PrimitiveBoolean)) {
			throw new IllegalArgumentException("constraint is not boolean"); //$NON-NLS-1$
		}
		
		Object result = evaluate(context, constraint);
		
		return ((Boolean) result).booleanValue();
	}
	
	public boolean check(Object context, String constraint)
		throws OclParsingException {
		
		OclExpression ocl = null;
		
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
	private OclExpression createNullCondition(EClassifier type) {
		OclExpression result;
		
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
	 * @throws the exception wrapped in an {@link OclParsingException}
	 */
	private void propagate(Exception e, String method) throws OclParsingException {
		OclEnginePlugin.catching(getClass(), method, e);
		OclParsingException ope = new OclParsingException(e.getLocalizedMessage(), e);
		OclEnginePlugin.throwing(getClass(), method, ope);
		
		throw ope;
	}

	/**
	 * returns the ocl syntax helper object
	 * 
	 * @return OclSyntaxHelper
	 */
	protected OclSyntaxHelper getOclSyntaxHelper() {
		if (oclSyntaxHelper == null) {
			oclSyntaxHelper = new OclSyntaxHelper(getEnvironmentFactory());
		}
		return oclSyntaxHelper;
	}
}