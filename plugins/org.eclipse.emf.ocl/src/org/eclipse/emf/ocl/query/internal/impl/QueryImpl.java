/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

package org.eclipse.emf.ocl.query.internal.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ocl.expressions.EvaluationVisitor;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.internal.impl.EvaluationVisitorImpl;
import org.eclipse.emf.ocl.expressions.internal.impl.ToStringVisitorImpl;
import org.eclipse.emf.ocl.expressions.internal.impl.ValidationVisitorImpl;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.parser.EvaluationEnvironment;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryPackage;
import org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.query.internal.impl.QueryImpl#getExtentMap <em>Extent Map</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.query.internal.impl.QueryImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl extends EObjectImpl implements Query {

	private static final String NullArgExpectlist_ERROR_ =
		OclMessages.NullArgExpectlist_ERROR_;

	private static final String CheckBool_ERROR_ =
		OclMessages.CheckBool_ERROR_;

	private static final String NullArgExpectEObj_ERROR_ =
		OclMessages.NullArgExpectEObj_ERROR_;

	private static final String BooleanQuery_ERROR_ =
		OclMessages.BooleanQuery_ERROR_;

	/**
	 * The default value of the '{@link #getExtentMap() <em>Extent Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtentMap()
	 * @generated
	 * @ordered
	 */
	protected static final Map EXTENT_MAP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtentMap() <em>Extent Map</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtentMap()
	 * @generated
	 * @ordered
	 */
	protected Map extentMap = EXTENT_MAP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression expression = null;

	/**
	 * @generated NOT
	 */
	private EvaluationEnvironment env;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected QueryImpl() {
		super();
		env = new EvalEnvironment();
	}

	/**
	 * Parses and validates the query according to the well-formedness rules.
	 * The query string must be of the form "context a::b::c inv: oclexpression"
	 * or, optionally, "package a::b context c inv: oclexpression endpackage".
	 * 
	 * @param qs the query string
	 * 
	 * @throws antlr.SemanticException in case of well-formedness problems
	 * @throws antlr.TokenStreamException in case of an error in tokenizing the input
	 * @throws antlr.RecognitionException on any problem in recognizing structures
	 * 
	 * @generated NOT
	 */
	protected QueryImpl(String qs) throws antlr.SemanticException,
		antlr.TokenStreamException, antlr.RecognitionException {
		expression = ExpressionsFactory.eINSTANCE.createOclExpression(qs);
		env = new EvalEnvironment();
		//validate(); -- parser validates
	}

	/**
	 * Creates a query from an {@link OclExpression} (constraint or query).
	 * The query is validated according to OCL well-formedness rules.
	 * 
	 * @param expr the ocl expression
	 * 
	 * @throws antlr.SemanticException in case of well-formedness problems
	 * 
	 * @generated NOT
	 */
	protected QueryImpl(OclExpression expr) throws antlr.SemanticException {
		expression = expr;
		env = new EvalEnvironment();
		validate();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QueryPackage.eINSTANCE.getQuery();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Map getExtentMap() {
		if (extentMap == EXTENT_MAP_EDEFAULT) {
			extentMap = new HashMap();
		}
		
		return extentMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtentMap(Map newExtentMap) {
		Map oldExtentMap = extentMap;
		extentMap = newExtentMap;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.QUERY__EXTENT_MAP, oldExtentMap, extentMap));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getExpression() {
		if (expression != null && expression.eIsProxy()) {
			OclExpression oldExpression = expression;
			expression = (OclExpression)eResolveProxy((InternalEObject)expression);
			if (expression != oldExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QueryPackage.QUERY__EXPRESSION, oldExpression, expression));
			}
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetExpression() {
		return expression;
	}

	/**
	 * @generated NOT
	 */
	public Object evaluate(Object obj) {
		if (obj == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				NullArgExpectEObj_ERROR_);
			OclEnginePlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}
		EvaluationVisitor ev = EvaluationVisitorImpl
			.getInstance(env, extentMap);
		env = ((EvaluationVisitorImpl) ev).getEvalEnvironment();
		// env.clear();
		env.add("self", obj);//$NON-NLS-1$
		Object result = expression.accept(ev);
		env.remove("self");//$NON-NLS-1$
		return result;
	}

	/**
	 * @generated NOT
	 */
	public Object evaluate() {
		Visitor ev = EvaluationVisitorImpl.getInstance(env, extentMap);
		env = ((EvaluationVisitorImpl) ev).getEvalEnvironment();
		env.clear();
		return expression.accept(ev);
	}

	/**
	 * @generated NOT
	 */
	public boolean check(Object obj) {
		if (resultType() != PrimitiveTypeImpl.OCL_BOOLEAN) {
			IllegalArgumentException error = new IllegalArgumentException(
				BooleanQuery_ERROR_);
			OclEnginePlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		
		Boolean result;
		
		if (obj == null) {
			result = (Boolean) evaluate();
		} else {
			result = (Boolean) evaluate(obj);
		}
		
		return result.booleanValue();
	}

	/**
	 * @generated NOT
	 */
	public List evaluate(List objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				NullArgExpectlist_ERROR_);
			OclEnginePlugin.throwing(getClass(), "evaluate", error);//$NON-NLS-1$
			throw error;
		}
		List result = new BasicEList();
		Iterator iter = objList.iterator();
		while (iter.hasNext()) {
			result.add(evaluate(iter.next()));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public boolean check(List objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				NullArgExpectlist_ERROR_);
			OclEnginePlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		if (resultType() != PrimitiveTypeImpl.OCL_BOOLEAN) {
			IllegalArgumentException error = new IllegalArgumentException(
				CheckBool_ERROR_);
			OclEnginePlugin.throwing(getClass(), "check", error);//$NON-NLS-1$
			throw error;
		}
		Iterator iter = objList.iterator();
		while (iter.hasNext()) {
			if (!check(iter.next()))
				return false;
		}
		return true;
	}

	/**
	 * @generated NOT
	 */
	public List select(List objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				NullArgExpectlist_ERROR_);
			OclEnginePlugin.throwing(getClass(), "select", error);//$NON-NLS-1$
			throw error;
		}
		List result = new BasicEList();
		Iterator iter = objList.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (!check(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public List reject(List objList) {
		if (objList == null) {
			IllegalArgumentException error = new IllegalArgumentException(
				NullArgExpectlist_ERROR_);
			OclEnginePlugin.throwing(getClass(), "reject", error);//$NON-NLS-1$
			throw error;
		}
		List result = new BasicEList();
		Iterator iter = objList.iterator();
		while (iter.hasNext()) {
			Object obj = iter.next();
			if (!check(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public EClassifier resultType() {
		return expression.getType();
	}

	/**
	 * @generated NOT
	 */
	public String queryText() {
		Visitor tsv = ToStringVisitorImpl.getInstance();
		return (String) expression.accept(tsv);
	}

	/**
	 * Validates me according to the rules for OCL well-formedness.
	 * 
	 * @generated NOT
	 */
	protected void validate() {
		Visitor validationVisitor = ValidationVisitorImpl.getInstance();
		expression.accept(validationVisitor);
	}
	
	/**
	 * @param env my environment
	 * 
	 * @generated NOT
	 */
	public void setEvaluationEnvironment(EvaluationEnvironment env) {
		this.env = env;
	}
	
	/**
	 * @return my environment
	 * 
	 * @generated NOT
	 */
	public EvaluationEnvironment getEvaluationEnvironment() {
		if (env == null) {
			env = new EvalEnvironment();
		}
		
		return env;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case QueryPackage.QUERY__EXTENT_MAP:
				return getExtentMap();
			case QueryPackage.QUERY__EXPRESSION:
				if (resolve) return getExpression();
				return basicGetExpression();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case QueryPackage.QUERY__EXTENT_MAP:
				setExtentMap((Map)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case QueryPackage.QUERY__EXTENT_MAP:
				setExtentMap(EXTENT_MAP_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case QueryPackage.QUERY__EXTENT_MAP:
				return EXTENT_MAP_EDEFAULT == null ? extentMap != null : !EXTENT_MAP_EDEFAULT.equals(extentMap);
			case QueryPackage.QUERY__EXPRESSION:
				return expression != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (expression: "); //$NON-NLS-1$
		result.append(queryText());
		result.append(')');
		return result.toString();
	}

} //QueryImpl
