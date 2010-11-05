/**
 * <copyright>
 *
 * Copyright (c) 2005, 2009 IBM Corporation, Borland Software Corporation, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: QueryImpl.java,v 1.7 2010/05/03 09:32:33 ewillink Exp $
 */

package org.eclipse.ocl.internal.evaluation;

import static org.eclipse.ocl.Environment.SELF_VARIABLE_NAME;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.helper.HelperUtil;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.ProblemAware;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.evaluation.QueryImpl#getExtentMap <em>Extent Map</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.evaluation.QueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		implements Query<C, CLS, E>, ProblemAware {
	
	private Map<CLS, ? extends Set<? extends E>> extentMap = null;

	private final OCLExpression<C> expression;

	private final Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment;
	private EvaluationEnvironment<C, O, P, CLS, E> evalEnv;
	private Diagnostic evalProblems;
	private BasicDiagnostic batchEvalProblems;
	
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
		evalProblems = null;
		
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
		} catch (EvaluationHaltedException e) {
			evalProblems = e.getDiagnostic();
			result = environment.getOCLStandardLibrary().getInvalid(); 			
		} finally {
			myEnv.remove(SELF_VARIABLE_NAME);
		}
		
		return result;
	}

	public Object evaluate() {
		evalProblems = null;
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  There is no "self" context variable
		EvaluationVisitor<?, C, O, P, ?, ?, ?, ?, ?, CT, CLS, E> ev =
			environment.getFactory().createEvaluationVisitor(
					environment, getEvaluationEnvironment(), getExtentMap());
		
		Object result;
		
		try {
			result = ev.visitExpression(expression);
		} catch (EvaluationHaltedException e) {
			evalProblems = e.getDiagnostic();
			result = environment.getOCLStandardLibrary().getInvalid();
		}
		
		return result;
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
		try {
			while (iter.hasNext()) {
				result.add(evaluate(iter.next()));
				
				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
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
		try {
			for (T obj : objList) {
				if (check(obj)) {
					result.add(obj);
				}

				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
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
		try {
			for (T obj : objList) {
				if (!check(obj)) {
					result.add(obj);
				}

				handleNextEvaluateProblems();
			}
		} finally {
			commitBatchEvaluateProblems();
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

	public Diagnostic getProblems() {
		return evalProblems;
	}
	
	@Override
    public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("Query["); //$NON-NLS-1$
		result.append(queryText());
		result.append(']');
		
		return result.toString();
	}

	/**
	 * Assigns collected interim diagnostics of batch evaluation to the
	 * resulting evaluation problems.
	 */
	private void commitBatchEvaluateProblems() {
		evalProblems = batchEvalProblems;
		batchEvalProblems = null;
	}

	/**
	 * Handles problems of single evaluation performed on behalf of batch
	 * evaluate invocation.
	 */
	private void handleNextEvaluateProblems() {
		Diagnostic nextEvalProblems = getProblems();
		if (nextEvalProblems != null) {
			if (batchEvalProblems == null) {
				BasicDiagnostic rootDiagnostic = new BasicDiagnostic(
					nextEvalProblems.getSeverity(), OCLPlugin.getPluginId(),
					nextEvalProblems.getCode(), nextEvalProblems.getMessage(),
					null);

				batchEvalProblems = rootDiagnostic;
			}
			
			batchEvalProblems.add(nextEvalProblems);
		}
	}
		
} //QueryImpl
