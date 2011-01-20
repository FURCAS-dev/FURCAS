/**
 * <copyright>
 * 
 * Copyright (c) 2010 Kenn Hussey and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Kenn Hussey - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLQueryDelegate.java,v 1.1 2010/12/09 17:16:18 ewillink Exp $
 */
package org.eclipse.ocl.ecore.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * An implementation of a query delegate for OCL expressions.
 * 
 * @see OCLQueryDelegateFactory
 * @since 3.1
 */
public class OCLQueryDelegate implements QueryDelegate
{
	protected final OCLDelegateDomain delegateDomain;
	protected final EClassifier context;
	protected final Map<String, EClassifier> variables;
	protected final String expression;

	private OCLExpression query = null;

	/**
	 * Initializes me with my domain, context, variables, and expression.
	 * 
	 * @param delegateDomain
	 *            my domain
	 * @param context
	 *            my context
	 * @param variables
	 *            name and types of variables used in my expression
	 * @param expression
	 *            the expression that I handle
	 * 
	 * @throws ParserException
	 *             if the expression is invalid
	 */
	public OCLQueryDelegate(OCLDelegateDomain delegateDomain,
			EClassifier context, Map<String, EClassifier> variables,
			String expression) {
		this.delegateDomain = delegateDomain;
		this.context = context;
		this.variables = variables;
		this.expression = expression;
	}

	/**
	 * Prepares the query wrapping any exceptions as InvocationTargetException.
	 * This method is lazily invoked from execute, but may be invoked eagerly
	 * to detect compilation errors earlier or incur compilation costs at a more
	 * convenient time.
	 *  
	 * @throws InvocationTargetException wrapping any parser, io exceptions
	 */
	public void prepare() throws InvocationTargetException {
		OCL ocl = delegateDomain.getOCL();
		OCL.Helper helper = ocl.createOCLHelper();
		helper.setContext(context);

		if (variables != null) {
			// create variables with specified names and types
			@SuppressWarnings("unchecked")
			Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?> environment = (Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?>) helper
				.getEnvironment();
			OCLFactory oclFactory = environment.getOCLFactory();
			UMLReflection<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?> umlReflection = environment
				.getUMLReflection();

			for (Map.Entry<String, EClassifier> entry : variables.entrySet()) {
				Variable<EClassifier,EParameter> variable = oclFactory.createVariable();
				variable.setName(entry.getKey());
				variable.setType(umlReflection.getOCLType(entry.getValue()));

				environment.addElement(entry.getKey(), variable, true);
			}
		}

		try {
			query = helper.createQuery(expression);
		} catch (ParserException e) {
			throw new InvocationTargetException(e);
		}
	}

	/**
	 * Executes the query for the specified <tt>target</tt> object. The result
	 * is the OCL evaluation result which may be a Number, String, Collection or
	 * other object for normal returns or a NullLiteralExp for null, or an
	 * InvalidLiteralExp for invalid.
	 * 
	 * @param target
	 *            the object on which to execute the query; this must be an
	 *            instance of the context with which the delegate was created
	 * @param arguments
	 *            a map of variable names to values; these must correspond to
	 *            the variables with which the delegate was created
	 * @return the query's result
	 * @throws InvocationTargetException
	 *             in case of failure to prepare or execute the query, usually
	 *             because of an exception
	 */
	public Object execute(Object target, Map<String, ?> arguments)
			throws InvocationTargetException {
		if (query == null) {
			prepare();
		}
		OCL ocl = delegateDomain.getOCL();
		OCL.Query oclQuery = ocl.createQuery(query);

		EvaluationEnvironment<EClassifier, ?, ?, ?, ?> evalEnv = oclQuery.getEvaluationEnvironment();
		Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = ocl.getEnvironment();
		EClassifier contextType = evalEnv.getType(target);
		if (!TypeUtil.compatibleTypeMatch(env, contextType, context)) {
			String message = OCLMessages.bind(OCLMessages.WrongContextClassifier_ERROR_,
				contextType.getName(), context.getName());
			throw new InvocationTargetException(new ParserException(message));
		}
		if (variables != null) {
			// check variables defined
			for (Map.Entry<String, ?> entry : variables.entrySet()) {
				String key = entry.getKey();
				if ((arguments == null) || !arguments.containsKey(key)) {
					String message = OCLMessages.bind(OCLMessages.BadArg_ERROR_, key);
					throw new InvocationTargetException(new ParserException(message));
				}
			}
		}
		if (arguments != null) {
			// bind values to variable names
			for (Map.Entry<String, ?> entry : arguments.entrySet()) {
				String key = entry.getKey();
				EClassifier variableType = variables != null ? variables.get(key) : null;
				if (variableType == null) {
					String message = OCLMessages.bind(OCLMessages.ExtraArg_ERROR_, key);
					throw new InvocationTargetException(new LookupException(message));
				}
				Object newValue = entry.getValue();
				EClassifier valueType = evalEnv.getType(newValue);
				if (!TypeUtil.compatibleTypeMatch(env, valueType, variableType)) {
					String message = OCLMessages.bind(OCLMessages.TypeConformanceInit_ERROR_, key);
					throw new InvocationTargetException(new ParserException(message));
				}
				evalEnv.replace(key, newValue);
			}
		}
		return oclQuery.evaluate(target);
	}

	@Override
	public String toString() {
		return "<" + delegateDomain.getURI() + ":query> " + expression; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
