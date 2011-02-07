/**
 * <copyright>
 * 
 * Copyright (c) 2010,2011 Kenn Hussey and others.
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
 * $Id: OCLQueryDelegate.java,v 1.1 2011/01/30 11:16:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * An implementation of a query delegate for OCL expressions.
 * 
 * @see OCLQueryDelegateFactory
 * @since 3.1
 */
public class OCLQueryDelegate implements QueryDelegate
{
	protected final OCLDelegateDomain delegateDomain;
	protected final Type context;
	protected final Map<String, Variable> variables;
	protected final String expression;

	private ExpressionInOcl query = null;

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
			Type context, Map<String, Variable> variables,
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
		OCLHelper helper = ocl.createOCLHelper();
		helper.setContext(context);

		if (variables != null) {
			// install variables with specified names and types
			Environment environment = helper.getEnvironment();
			for (Map.Entry<String, Variable> entry : variables.entrySet()) {
				environment.addElement(entry.getKey(), entry.getValue(), true);
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

		EvaluationEnvironment evalEnv = oclQuery.getEvaluationEnvironment();
		Environment env = ocl.getEnvironment();
		Type contextType = evalEnv.getType(target);
		TypeManager typeManager = evalEnv.getTypeManager();
		if (!typeManager.conformsTo(context, contextType)) {
			String message = OCLMessages.bind(OCLMessages.WrongContextClassifier_ERROR_,
				contextType.getName(), context.getName());
			throw new InvocationTargetException(new ParserException(message));
		}
		if (variables != null) {
			// check variables defined
			for (Map.Entry<String, Variable> entry : variables.entrySet()) {
				String key = entry.getKey();
				if ((arguments == null) || !arguments.containsKey(key)) {
					String message = OCLMessages.bind(OCLMessages.BadArg_ERROR_, key);
					throw new InvocationTargetException(new ParserException(message));
				}
			}
		}
		if (arguments != null) {
			ValueFactory valueFactory = evalEnv.getValueFactory();
			// bind values to variable names
			for (Map.Entry<String, ?> entry : arguments.entrySet()) {
				String key = entry.getKey();
				Variable variable = variables != null ? variables.get(key) : null;
				Type variableType = variable != null ? variable.getType() : null;
				if (variableType == null) {
					String message = OCLMessages.bind(OCLMessages.ExtraArg_ERROR_, key);
					throw new InvocationTargetException(new LookupException(message));
				}
				Value newValue = valueFactory.valueOf(entry.getValue());
				Type valueType = evalEnv.getType(newValue);
				if (!typeManager.conformsTo(valueType, variableType)) {
					String message = OCLMessages.bind(OCLMessages.TypeConformanceInit_ERROR_, key);
					throw new InvocationTargetException(new ParserException(message));
				}
				evalEnv.replace(variable, newValue);
			}
		}
		return oclQuery.evaluate(target);
	}

	@Override
	public String toString() {
		return "<" + delegateDomain.getURI() + ":query> " + expression; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
