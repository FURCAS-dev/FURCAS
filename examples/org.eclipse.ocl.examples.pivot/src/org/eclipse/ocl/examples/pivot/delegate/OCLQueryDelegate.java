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
 * $Id: OCLQueryDelegate.java,v 1.4 2011/04/20 19:02:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.QueryDelegate;
import org.eclipse.ocl.examples.pivot.EvaluationException;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.values.Value;
import org.eclipse.ocl.examples.pivot.values.ValueFactory;
import org.eclipse.osgi.util.NLS;

/**
 * An implementation of a query delegate for OCL expressions.
 * 
 * @see OCLQueryDelegateFactory
 * @since 3.1
 */
public class OCLQueryDelegate implements QueryDelegate
{
	protected final OCLDelegateDomain delegateDomain;
	protected final ExpressionInOcl specification;

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
	public OCLQueryDelegate(OCLDelegateDomain delegateDomain, ExpressionInOcl specification) {
		this.delegateDomain = delegateDomain;
		this.specification = specification;
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
		TypeManager typeManager = delegateDomain.getTypeManager();
		try {
			String expression = PivotUtil.getBody(specification);
			URI uri = typeManager.getResourceIdentifier(this, null);
			PivotUtil.resolveSpecification(typeManager, uri, specification, expression);
		} catch (Exception e) {
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
		if (specification.getBodyExpression() == null) {
			prepare();
		}
		try {
			OCL ocl = delegateDomain.getOCL();
			TypeManager typeManager = ocl.getTypeManager();
			ValueFactory valueFactory = typeManager.getValueFactory();
			Value targetValue = valueFactory.valueOf(target);
			Type targetType = targetValue.getType(typeManager, null);
			Type requiredType = specification.getContextVariable().getType();
			if (!typeManager.conformsTo(targetType, requiredType, null)) {
				String message = NLS.bind(OCLMessages.WrongContextClassifier_ERROR_, targetType, requiredType);
				throw new OCLDelegateException(message);
			}
			List<Variable> parameterVariables = specification.getParameterVariables();
			int argCount = arguments != null ? arguments.size() : 0;
			if (parameterVariables.size() != argCount) {
				String message = NLS.bind(OCLMessages.MismatchedArgumentCount_ERROR_, argCount, parameterVariables.size());
				throw new OCLDelegateException(message);
			}
			OCL.Query query = ocl.createQuery(specification);
			EvaluationEnvironment env = query.getEvaluationEnvironment();
			for (Variable parameterVariable : parameterVariables) {
				// bind arguments to parameter names
				String name = parameterVariable.getName();
				@SuppressWarnings("null")
				Object object = arguments.get(name);
				if ((object == null) && !arguments.containsKey(name)) {
					String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, PivotUtil.getBody(specification));
					throw new OCLDelegateException(message);
				}
				Value value = valueFactory.valueOf(object);
				targetType = value.getType(typeManager, null);
				requiredType = parameterVariable.getType();
				if (!typeManager.conformsTo(targetType, requiredType, null)) {
					String message = NLS.bind(OCLMessages.MismatchedArgumentType_ERROR_, new Object[]{name, targetType, requiredType});
					throw new OCLDelegateException(message);
				}
				env.add(parameterVariable, value);
			}
			Value result = query.evaluate(target);
//			if (result.isInvalid()) {
//				String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, getOperationName());
//				throw new OCLDelegateException(message);
//			}
	//		if ((result == null) / * || ocl.isInvalid(result) * /) {
	//			String message = NLS.bind(OCLMessages.EvaluationResultIsNull_ERROR_, getOperationName());
	//			throw new OCLDelegateException(message);
	//		}
	//		return converter.convert(ocl, result);
			return valueFactory.getEcoreValueOf(result);
		}
		catch (EvaluationException e) {
			String message = NLS.bind(OCLMessages.EvaluationResultIsInvalid_ERROR_, PivotUtil.getBody(specification));
			throw new InvocationTargetException(new OCLDelegateException(message));
		}
		catch (OCLDelegateException e) {
			throw new InvocationTargetException(e);
		}
	}

	@Override
	public String toString() {
		OclExpression bodyExpression = specification.getBodyExpression();
		if (bodyExpression != null) {
			return "<" + delegateDomain.getURI() + ":query> " + bodyExpression; //$NON-NLS-1$ //$NON-NLS-2$
		}
		else {
			return "<" + delegateDomain.getURI() + ":query> " + PivotUtil.getBody(specification); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
}
