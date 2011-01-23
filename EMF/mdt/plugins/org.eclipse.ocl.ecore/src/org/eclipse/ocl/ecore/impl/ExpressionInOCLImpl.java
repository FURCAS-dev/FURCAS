/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 *   
 * </copyright>
 *
 * $Id: ExpressionInOCLImpl.java,v 1.11 2010/04/23 05:52:40 ewillink Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression In OCL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl#getResultVariable <em>Result Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl#getParameterVariable <em>Parameter Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.ecore.impl.ExpressionInOCLImpl#getGeneratedType <em>Generated Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionInOCLImpl
		extends EObjectImpl
		implements ExpressionInOCL {

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<EClassifier> bodyExpression;

	/**
	 * The cached value of the '{@link #getContextVariable() <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable<EClassifier, EParameter> contextVariable;

	/**
	 * The cached value of the '{@link #getResultVariable() <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable<EClassifier, EParameter> resultVariable;

	/**
	 * The cached value of the '{@link #getParameterVariable() <em>Parameter Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable<EClassifier, EParameter>> parameterVariable;

	/**
	 * The cached value of the '{@link #getGeneratedType() <em>Generated Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getGeneratedType()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> generatedType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionInOCLImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EcorePackage.Literals.EXPRESSION_IN_OCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<EClassifier> getBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(
			OCLExpression<EClassifier> newBodyExpression, NotificationChain msgs) {
		OCLExpression<EClassifier> oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				oldBodyExpression, newBodyExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExpression(OCLExpression<EClassifier> newBodyExpression) {
		if (newBodyExpression != bodyExpression) {
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject) bodyExpression).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION,
					null, msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject) newBodyExpression).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION,
					null, msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable<EClassifier, EParameter> getContextVariable() {
		return contextVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextVariable(
			Variable<EClassifier, EParameter> newContextVariable,
			NotificationChain msgs) {
		Variable<EClassifier, EParameter> oldContextVariable = contextVariable;
		contextVariable = newContextVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
				oldContextVariable, newContextVariable);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContextVariable(
			Variable<EClassifier, EParameter> newContextVariable) {
		if (newContextVariable != contextVariable) {
			NotificationChain msgs = null;
			if (contextVariable != null)
				msgs = ((InternalEObject) contextVariable).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
					null, msgs);
			if (newContextVariable != null)
				msgs = ((InternalEObject) newContextVariable).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
					null, msgs);
			msgs = basicSetContextVariable(newContextVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
				newContextVariable, newContextVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable<EClassifier, EParameter> getResultVariable() {
		return resultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultVariable(
			Variable<EClassifier, EParameter> newResultVariable,
			NotificationChain msgs) {
		Variable<EClassifier, EParameter> oldResultVariable = resultVariable;
		resultVariable = newResultVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				oldResultVariable, newResultVariable);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultVariable(
			Variable<EClassifier, EParameter> newResultVariable) {
		if (newResultVariable != resultVariable) {
			NotificationChain msgs = null;
			if (resultVariable != null)
				msgs = ((InternalEObject) resultVariable).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE,
					null, msgs);
			if (newResultVariable != null)
				msgs = ((InternalEObject) newResultVariable).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE,
					null, msgs);
			msgs = basicSetResultVariable(newResultVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				newResultVariable, newResultVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable<EClassifier, EParameter>> getParameterVariable() {
		if (parameterVariable == null) {
			parameterVariable = new EObjectContainmentEList<Variable<EClassifier, EParameter>>(
				Variable.class, this,
				EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		}
		return parameterVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassifier> getGeneratedType() {
		if (generatedType == null) {
			generatedType = new EObjectContainmentEList<EClassifier>(
				EObject.class, this,
				EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE);
		}
		return generatedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((Visitor<T, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?>) v)
			.visitExpressionInOCL(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				return basicSetBodyExpression(null, msgs);
			case EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				return basicSetContextVariable(null, msgs);
			case EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				return basicSetResultVariable(null, msgs);
			case EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				return ((InternalEList<?>) getParameterVariable()).basicRemove(
					otherEnd, msgs);
			case EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				return ((InternalEList<?>) getGeneratedType()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				return getBodyExpression();
			case EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				return getContextVariable();
			case EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				return getResultVariable();
			case EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				return getParameterVariable();
			case EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				return getGeneratedType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				setBodyExpression((OCLExpression<EClassifier>) newValue);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				setContextVariable((Variable<EClassifier, EParameter>) newValue);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				setResultVariable((Variable<EClassifier, EParameter>) newValue);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				getParameterVariable().clear();
				getParameterVariable()
					.addAll(
						(Collection<? extends Variable<EClassifier, EParameter>>) newValue);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				getGeneratedType().clear();
				getGeneratedType().addAll(
					(Collection<? extends EClassifier>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				setBodyExpression((OCLExpression<EClassifier>) null);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				setContextVariable((Variable<EClassifier, EParameter>) null);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				setResultVariable((Variable<EClassifier, EParameter>) null);
				return;
			case EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				getParameterVariable().clear();
				return;
			case EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				getGeneratedType().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EcorePackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				return bodyExpression != null;
			case EcorePackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				return contextVariable != null;
			case EcorePackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				return resultVariable != null;
			case EcorePackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				return parameterVariable != null
					&& !parameterVariable.isEmpty();
			case EcorePackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				return generatedType != null && !generatedType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExpressionInOCLImpl
