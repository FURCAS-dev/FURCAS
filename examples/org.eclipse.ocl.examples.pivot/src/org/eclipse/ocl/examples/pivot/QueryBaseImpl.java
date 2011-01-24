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
 *   Radek Dvorak - Bug 261128
 *
 * </copyright>
 *
 * $Id: QueryBaseImpl.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import static org.eclipse.ocl.Environment.SELF_VARIABLE_NAME;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.EvaluationHaltedException;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.ModelManager;
import org.eclipse.ocl.examples.pivot.helper.HelperUtil;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;
import org.eclipse.ocl.util.ProblemAware;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.QueryImpl#getModelManager <em>Extent Map</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.QueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryBaseImpl implements QueryBase, ProblemAware {
	
	private ModelManager modelManager = null;

	private final OclExpression expression;

	private final Environment environment;
	private EvaluationEnvironment evalEnv;
	private Diagnostic evalProblems;
	private BasicDiagnostic batchEvalProblems;
	
	/**
	 * 
	 * @param environment
	 * @param expr
	 * @param modelManager may be <code>null</code>, in which case I will use my
	 *     evaluation environment to create a dynamic extent map
	 */
	public QueryBaseImpl(Environment environment,
			OclExpression expr,
			ModelManager modelManager) {
		
		this.environment = environment;
		this.expression = expr;
		this.modelManager = modelManager;
	}

	public ModelManager getModelManager() {
		if (modelManager == null) {
			EvaluationEnvironment myEnv = getEvaluationEnvironment();
			
			Object context = myEnv.getValueOf(SELF_VARIABLE_NAME);
			
			modelManager = myEnv.createModelManager(context);
		}
		
		return modelManager;
	}

	public OclExpression getExpression() {
		return expression;
	}

	public Object evaluate(Object obj) {
		evalProblems = null;
		
		if (obj == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				OCLMessages.NullArgExpectEObj_ERROR_);
			PivotPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}

		// can determine a more appropriate context from the context
		//   variable of the expression, to account for stereotype constraints
		obj = HelperUtil.getConstraintContext(
				environment, obj, expression);
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  Initialize it with the "self" context variable
		EvaluationEnvironment myEnv = getEvaluationEnvironment();
		myEnv.add(SELF_VARIABLE_NAME, myEnv.getValueFactory().createObjectValue(obj));
		
		EvaluationVisitor ev =
			environment.getFactory().createEvaluationVisitor(
					environment, myEnv, getModelManager());
		
		Object result;
		
		try {
			result = ev.visitExpression(expression);
		} catch (EvaluationHaltedException e) {
			evalProblems = e.getDiagnostic();
			result = myEnv.getValueFactory().createInvalidValue(obj, null, evalProblems.toString(), e); 			
		} finally {
			myEnv.remove(SELF_VARIABLE_NAME);
		}
		
		return result;
	}

	public Object evaluate() {
		evalProblems = null;
		
		// lazily create the evaluation environment, if not already done by
		//    the client.  There is no "self" context variable
		EvaluationVisitor ev =
			environment.getFactory().createEvaluationVisitor(
					environment, getEvaluationEnvironment(), getModelManager());
		
		Object result;
		
		try {
			result = ev.visitExpression(expression);
		} catch (EvaluationHaltedException e) {
			evalProblems = e.getDiagnostic();
			result = environment.getTypeManager().getValueFactory().createInvalidValue(null, null, evalProblems.toString(), e);
		}
		
		return result;
	}

	public boolean check(Object obj) {
		if (resultType() != environment.getOCLStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			PivotPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
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
			PivotPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
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
			PivotPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		if (resultType() != environment.getOCLStandardLibrary().getBooleanType()) {
			IllegalArgumentException error = new IllegalArgumentException(
					OCLMessages.BooleanQuery_ERROR_);
			PivotPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
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
			PivotPlugin.throwing(getClass(), "select", error);//$NON-NLS-1$
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
			PivotPlugin.throwing(getClass(), "reject", error);//$NON-NLS-1$
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

	public Type resultType() {
		return expression.getType();
	}

	public String queryText() {
		return expression.toString();
	}

	public EvaluationEnvironment getEvaluationEnvironment() {
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
					nextEvalProblems.getSeverity(), PivotPlugin.getPluginId(),
					nextEvalProblems.getCode(), nextEvalProblems.getMessage(),
					null);

				batchEvalProblems = rootDiagnostic;
			}
			
			batchEvalProblems.add(nextEvalProblems);
		}
	}
		
} //QueryImpl
