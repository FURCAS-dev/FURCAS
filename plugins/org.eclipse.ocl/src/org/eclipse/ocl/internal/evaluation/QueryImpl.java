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
 * $Id: QueryImpl.java,v 1.3 2007/10/11 23:05:05 cdamus Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import static org.eclipse.ocl.Environment.SELF_VARIABLE_NAME;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.helper.HelperUtil;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.query.impl.QueryImpl#getExtentMap <em>Extent Map</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.query.impl.QueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		implements Query<C, CLS, E> {
	
	private Map<CLS, ? extends Set<? extends E>> extentMap = null;

	private final OCLExpression<C> expression;

	private final Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment;
	private EvaluationEnvironment<C, O, P, CLS, E> evalEnv;

	/**
	 * 
	 * @param environment
	 * @param expr
	 * @param extentMap may be <code>null</code>, in which case I will use my
	 *     evaluation environment to create a dynamic extent map
	 */
	public QueryImpl(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment,
			OCLExpression<C> expr,
			Map<CLS, ? extends Set<? extends E>> extentMap) {
		
		this.environment = environment;
		this.expression = expr;
		this.extentMap = extentMap;
	}

	public Map<CLS, ? extends Set<? extends E>> getExtentMap() {
		if (extentMap == null) {
			EvaluationEnvironment<C, O, P, CLS, E> myEnv =
				getEvaluationEnvironment();
			
			Object context = myEnv.getValueOf(SELF_VARIABLE_NAME);
			
			extentMap = myEnv.createExtentMap(context);
		}
		
		return extentMap;
	}

	public OCLExpression<C> getExpression() {
		return expression;
	}

	public Object evaluate(Object obj) {
		if (obj == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				OCLMessages.NullArgExpectEObj_ERROR_);
			OCLPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}

		// can determine a more appropriate context from the context
		//   variable of the expression, to account for stereotype constraints
		obj = HelperUtil.getConstraintContext(
				environment, obj, expression);
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  Initialize it with the "self" context variable
		EvaluationEnvironment<C, O, P, CLS, E> myEnv = getEvaluationEnvironment();
		myEnv.add(SELF_VARIABLE_NAME, obj);
		
		EvaluationVisitor<?, C, O, P, ?, ?, ?, ?, ?, CT, CLS, E> ev =
			environment.getFactory().createEvaluationVisitor(
					environment, myEnv, getExtentMap());
		
		Object result;
		
		try {
			result = ev.visitExpression(expression);
		} finally {
			myEnv.remove(SELF_VARIABLE_NAME);
		}
		
		return result;
	}

	public Object evaluate() {
		// lazily create the evaluation environment, if not already done by
		//    the client.  There is no "self" context variable
		EvaluationVisitor<?, C, O, P, ?, ?, ?, ?, ?, CT, CLS, E> ev =
			environment.getFactory().createEvaluationVisitor(
					environment, getEvaluationEnvironment(), getExtentMap());
		
		return ev.visitExpression(expression);
	}

	public boolean check(Object obj) {
		if (resultType() != environment.getOCLStandardLibrary().getBoolean()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			OCLPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		Object result;
		
		if (obj == null) {
			result = evaluate();
		} else {
			result = evaluate(obj);
		}
		
		return Boolean.TRUE.equals(result);
	}

	public List<?> evaluate(List<?> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			OCLPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}
		
		List<Object> result = new BasicEList<Object>();
		Iterator<?> iter = objList.iterator();
		while (iter.hasNext()) {
			result.add(evaluate(iter.next()));
		}
		
		return result;
	}

	public boolean check(List<?> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			OCLPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		if (resultType() != environment.getOCLStandardLibrary().getBoolean()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			OCLPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		Iterator <?>iter = objList.iterator();
		while (iter.hasNext()) {
			if (!check(iter.next())) {
				return false;
			}
		}
		
		return true;
	}

	public <T> List<T> select(List<T> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			OCLPlugin.throwing(getClass(), "select", error);//$NON-NLS-1$
			throw error;
		}
		
		List<T> result = new BasicEList<T>();
		for (T obj : objList) {
			if (check(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public <T> List<T> reject(List<T> objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.NullArgExpectlist_ERROR_);
			OCLPlugin.throwing(getClass(), "reject", error);//$NON-NLS-1$
			throw error;
		}
		
		List<T> result = new BasicEList<T>();
		for (T obj : objList) {
			if (!check(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public C resultType() {
		return expression.getType();
	}

	public String queryText() {
		return expression.toString();
	}

	public EvaluationEnvironment<C, O, P, CLS, E> getEvaluationEnvironment() {
		if (evalEnv == null) {
			evalEnv = environment.getFactory().createEvaluationEnvironment();
		}
		
		return evalEnv;
	}

	@Override
    public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Query["); //$NON-NLS-1$
		result.append(queryText());
		result.append(']');
		
		return result.toString();
	}

} //QueryImpl
