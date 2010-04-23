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
 * $Id: ExpressionInOCLImpl.java,v 1.12 2010/04/23 05:52:14 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.utilities.UtilitiesPackage;
import org.eclipse.ocl.utilities.Visitable;
import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.internal.impl.OpaqueExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression In OCL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl#getResultVariable <em>Result Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl#getParameterVariable <em>Parameter Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.uml.impl.ExpressionInOCLImpl#getGeneratedType <em>Generated Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class ExpressionInOCLImpl
		extends OpaqueExpressionImpl
		implements ExpressionInOCL {

	/**
	 * The cached value of the '{@link #getBodyExpression() <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<Classifier> bodyExpression;

	/**
	 * The cached value of the '{@link #getContextVariable() <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContextVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable<Classifier, Parameter> contextVariable;

	/**
	 * The cached value of the '{@link #getResultVariable() <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable<Classifier, Parameter> resultVariable;

	/**
	 * The cached value of the '{@link #getParameterVariable() <em>Parameter Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable<Classifier, Parameter>> parameterVariable;

	/**
	 * The cached value of the '{@link #getGeneratedType() <em>Generated Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getGeneratedType()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> generatedType;

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
		return UMLPackage.Literals.EXPRESSION_IN_OCL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<Classifier> getBodyExpression() {
		return bodyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExpression(
			OCLExpression<Classifier> newBodyExpression, NotificationChain msgs) {
		OCLExpression<Classifier> oldBodyExpression = bodyExpression;
		bodyExpression = newBodyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION,
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
	public void setBodyExpression(OCLExpression<Classifier> newBodyExpression) {
		if (newBodyExpression != bodyExpression) {
			NotificationChain msgs = null;
			if (bodyExpression != null)
				msgs = ((InternalEObject) bodyExpression).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null,
					msgs);
			if (newBodyExpression != null)
				msgs = ((InternalEObject) newBodyExpression).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION, null,
					msgs);
			msgs = basicSetBodyExpression(newBodyExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION,
				newBodyExpression, newBodyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable<Classifier, Parameter> getContextVariable() {
		return contextVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContextVariable(
			Variable<Classifier, Parameter> newContextVariable,
			NotificationChain msgs) {
		Variable<Classifier, Parameter> oldContextVariable = contextVariable;
		contextVariable = newContextVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
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
			Variable<Classifier, Parameter> newContextVariable) {
		if (newContextVariable != contextVariable) {
			NotificationChain msgs = null;
			if (contextVariable != null)
				msgs = ((InternalEObject) contextVariable).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null,
					msgs);
			if (newContextVariable != null)
				msgs = ((InternalEObject) newContextVariable).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE, null,
					msgs);
			msgs = basicSetContextVariable(newContextVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE,
				newContextVariable, newContextVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable<Classifier, Parameter> getResultVariable() {
		return resultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultVariable(
			Variable<Classifier, Parameter> newResultVariable,
			NotificationChain msgs) {
		Variable<Classifier, Parameter> oldResultVariable = resultVariable;
		resultVariable = newResultVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET,
				UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE,
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
			Variable<Classifier, Parameter> newResultVariable) {
		if (newResultVariable != resultVariable) {
			NotificationChain msgs = null;
			if (resultVariable != null)
				msgs = ((InternalEObject) resultVariable).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null,
					msgs);
			if (newResultVariable != null)
				msgs = ((InternalEObject) newResultVariable).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE, null,
					msgs);
			msgs = basicSetResultVariable(newResultVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE,
				newResultVariable, newResultVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable<Classifier, Parameter>> getParameterVariable() {
		if (parameterVariable == null) {
			parameterVariable = new EObjectContainmentEList<Variable<Classifier, Parameter>>(
				Variable.class, this,
				UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE);
		}
		return parameterVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getGeneratedType() {
		if (generatedType == null) {
			generatedType = new EObjectContainmentEList<Classifier>(
				EObject.class, this,
				UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE);
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
		return ((Visitor<T, Classifier, ?, ?, ?, Parameter, ?, ?, ?, ?>) v)
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
			case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				return basicSetBodyExpression(null, msgs);
			case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				return basicSetContextVariable(null, msgs);
			case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				return basicSetResultVariable(null, msgs);
			case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				return ((InternalEList<?>) getParameterVariable()).basicRemove(
					otherEnd, msgs);
			case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
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
			case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				return getBodyExpression();
			case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				return getContextVariable();
			case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				return getResultVariable();
			case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				return getParameterVariable();
			case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
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
			case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				setBodyExpression((OCLExpression<Classifier>) newValue);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				setContextVariable((Variable<Classifier, Parameter>) newValue);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				setResultVariable((Variable<Classifier, Parameter>) newValue);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				getParameterVariable().clear();
				getParameterVariable()
					.addAll(
						(Collection<? extends Variable<Classifier, Parameter>>) newValue);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				getGeneratedType().clear();
				getGeneratedType().addAll(
					(Collection<? extends Classifier>) newValue);
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
			case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				setBodyExpression((OCLExpression<Classifier>) null);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				setContextVariable((Variable<Classifier, Parameter>) null);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				setResultVariable((Variable<Classifier, Parameter>) null);
				return;
			case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				getParameterVariable().clear();
				return;
			case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
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
			case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
				return bodyExpression != null;
			case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
				return contextVariable != null;
			case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
				return resultVariable != null;
			case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
				return parameterVariable != null
					&& !parameterVariable.isEmpty();
			case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
				return generatedType != null && !generatedType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Visitable.class) {
			switch (derivedFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.utilities.ExpressionInOCL.class) {
			switch (derivedFeatureID) {
				case UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
					return UtilitiesPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION;
				case UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
					return UtilitiesPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE;
				case UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
					return UtilitiesPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE;
				case UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
					return UtilitiesPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE;
				case UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
					return UtilitiesPackage.EXPRESSION_IN_OCL__GENERATED_TYPE;
				default :
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Visitable.class) {
			switch (baseFeatureID) {
				default :
					return -1;
			}
		}
		if (baseClass == org.eclipse.ocl.utilities.ExpressionInOCL.class) {
			switch (baseFeatureID) {
				case UtilitiesPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION :
					return UMLPackage.EXPRESSION_IN_OCL__BODY_EXPRESSION;
				case UtilitiesPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE :
					return UMLPackage.EXPRESSION_IN_OCL__CONTEXT_VARIABLE;
				case UtilitiesPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE :
					return UMLPackage.EXPRESSION_IN_OCL__RESULT_VARIABLE;
				case UtilitiesPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE :
					return UMLPackage.EXPRESSION_IN_OCL__PARAMETER_VARIABLE;
				case UtilitiesPackage.EXPRESSION_IN_OCL__GENERATED_TYPE :
					return UMLPackage.EXPRESSION_IN_OCL__GENERATED_TYPE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ExpressionInOCLImpl
