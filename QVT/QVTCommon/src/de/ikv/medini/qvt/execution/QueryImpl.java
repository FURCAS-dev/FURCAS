/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt.execution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.oslo.ocl20.OclProcessorImpl;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.synthesis.RuntimeEnvironment;
import org.oslo.ocl20.synthesis.RuntimeEnvironmentImpl;

/**
 * This class is based on org.eclipse.ocl.internal.evaluation.QueryImpl, adjusted for the medini OCL engine.
 * 
 * @author kiegeland
 * 
 */
public class QueryImpl implements Query {

	private OclProcessorImpl ev;

	private static final String SELF_VARIABLE_NAME = "self";

	private Map extentMap = null;

	private final ContextDeclaration expression;

	private final Environment environment;

	private RuntimeEnvironment evalEnv;

	/**
	 * 
	 * @param environment
	 * @param declaration
	 * @param extentMap
	 *            may be <code>null</code>, in which case I will use my evaluation environment to create a dynamic extent map
	 */
	public QueryImpl(Environment environment, ContextDeclaration declaration, Map extentMap, OclProcessorImpl ev) {

		this.environment = environment;
		this.expression = declaration;
		this.extentMap = extentMap;
		this.ev = ev;
	}

	public Map getExtentMap() {
		// if (extentMap == null) {
		// RuntimeEnvironment myEnv =
		// getRuntimeEnvironment();
		//			
		// Object context = myEnv.getValue(SELF_VARIABLE_NAME);
		//			
		// extentMap = myEnv.createExtentMap(context);
		// }
		//		
		return this.extentMap;
	}

	public ContextDeclaration getExpression() {
		return this.expression;
	}

	public Object evaluate(Object obj) {
		// if (obj == null) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.NullArgExpectEObj_ERROR_);
		// OCLPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
		// throw error;
		// }

		// can determine a more appropriate context from the context
		// variable of the expression, to account for stereotype constraints
		// obj = HelperUtil.getConstraintContext(
		// environment, obj, expression);

		// lazily create the evaluation environment, if not already done by
		// the client. Initialize it with the "self" context variable
		RuntimeEnvironment myEnv = this.getRuntimeEnvironment();
		myEnv.setValue(QueryImpl.SELF_VARIABLE_NAME, obj);

		if (obj instanceof EObject) {
			EObject eobj = (EObject) obj;
			if (eobj.eResource() != null) {
				ArrayList models = new ArrayList();
				models.add(eobj.eResource());
				this.ev.setModels(models);
			}
		}

		// EvaluationVisitor ev =
		// environment.getFactory().createEvaluationVisitor(
		// environment, myEnv, getExtentMap());

		Object result = null;

		try {
			result = this.evaluate(myEnv);
		} finally {
			myEnv.setValue(QueryImpl.SELF_VARIABLE_NAME, null);
		}

		return result;
	}

	public Object evaluate() {
		// lazily create the evaluation environment, if not already done by
		// the client. There is no "self" context variable
		// EvaluationVisitor ev =
		// environment.getFactory().createEvaluationVisitor(
		// environment, getRuntimeEnvironment(), getExtentMap());

		return this.evaluate(this.getRuntimeEnvironment());
	}

	public Object evaluate(RuntimeEnvironment myEnv) {
		// lazily create the evaluation environment, if not already done by
		// the client. There is no "self" context variable
		// EvaluationVisitor ev =
		// environment.getFactory().createEvaluationVisitor(
		// environment, getRuntimeEnvironment(), getExtentMap());

		List expressions = new ArrayList();
		expressions.add(this.expression);
		List list = this.ev.evaluate(expressions, myEnv, this.ev.getLog());
		if (list instanceof List && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public boolean check(Object obj) {
		// if (resultType() != ev.getTypeFactory().buildBooleanType()) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.BooleanQuery_ERROR_);
		// OCLPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
		// throw error;
		// }

		Object result;

		if (obj == null) {
			result = this.evaluate();
		} else {
			result = this.evaluate(obj);
		}

		return Boolean.TRUE.equals(result);
	}

	public List evaluate(List objList) {
		// if (objList == null) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.NullArgExpectlist_ERROR_);
		// OCLPlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
		// throw error;
		// }

		List result = new BasicEList();
		Iterator iter = objList.iterator();
		while (iter.hasNext()) {
			result.add(this.evaluate(iter.next()));
		}

		return result;
	}

	public boolean check(List objList) {
		// if (objList == null) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.NullArgExpectlist_ERROR_);
		// OCLPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
		// throw error;
		// }
		//		
		// if (resultType() != environment.getOCLStandardLibrary().getBoolean()) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.BooleanQuery_ERROR_);
		// OCLPlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
		// throw error;
		// }

		Iterator iter = objList.iterator();
		while (iter.hasNext()) {
			if (!this.check(iter.next())) {
				return false;
			}
		}

		return true;
	}

	public List select(List objList) {
		// if (objList == null) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.NullArgExpectlist_ERROR_);
		// OCLPlugin.throwing(getClass(), "select", error);//$NON-NLS-1$
		// throw error;
		// }

		List result = new BasicEList();
		for (Iterator iter = objList.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (this.check(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public List reject(List objList) {
		// if (objList == null) {
		// IllegalArgumentException error = new IllegalArgumentException(
		// OCLMessages.NullArgExpectlist_ERROR_);
		// OCLPlugin.throwing(getClass(), "reject", error);//$NON-NLS-1$
		// throw error;
		// }

		List result = new BasicEList();
		for (Iterator iter = objList.iterator(); iter.hasNext();) {
			Object obj = iter.next();
			if (!this.check(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public Object resultType() {
		return ((Constraint) this.expression.getConstraint().get(0)).getBodyExpression().getType();
	}

	public String queryText() {
		return this.expression.toString();
	}

	public RuntimeEnvironment getRuntimeEnvironment() {
		if (this.evalEnv == null) {
			this.evalEnv = new RuntimeEnvironmentImpl();
		}

		return this.evalEnv;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();

		result.append("Query["); //$NON-NLS-1$
		result.append(this.queryText());
		result.append(']');

		return result.toString();
	}

}
