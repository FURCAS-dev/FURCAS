/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.IfExp;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.OperationCallExp;
import org.eclipse.emf.ocl.expressions.PropertyCallExp;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.IfExpImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.IfExpImpl#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.expressions.internal.impl.IfExpImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfExpImpl extends OclExpressionImpl implements IfExp {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected OclExpression condition = null;

	/**
	 * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression thenExpression = null;

	/**
	 * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression elseExpression = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.eINSTANCE.getIfExp();
	}

	public Object accept(Visitor v) {
		return v.visitIfExp(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(OclExpression newCondition, NotificationChain msgs) {
		OclExpression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.IF_EXP__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(OclExpression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.IF_EXP__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.IF_EXP__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.IF_EXP__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getThenExpression() {
		return thenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenExpression(OclExpression newThenExpression, NotificationChain msgs) {
		OclExpression oldThenExpression = thenExpression;
		thenExpression = newThenExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.IF_EXP__THEN_EXPRESSION, oldThenExpression, newThenExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenExpression(OclExpression newThenExpression) {
		if (newThenExpression != thenExpression) {
			NotificationChain msgs = null;
			if (thenExpression != null)
				msgs = ((InternalEObject)thenExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.IF_EXP__THEN_EXPRESSION, null, msgs);
			if (newThenExpression != null)
				msgs = ((InternalEObject)newThenExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.IF_EXP__THEN_EXPRESSION, null, msgs);
			msgs = basicSetThenExpression(newThenExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.IF_EXP__THEN_EXPRESSION, newThenExpression, newThenExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getElseExpression() {
		return elseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseExpression(OclExpression newElseExpression, NotificationChain msgs) {
		OclExpression oldElseExpression = elseExpression;
		elseExpression = newElseExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseExpression(OclExpression newElseExpression) {
		if (newElseExpression != elseExpression) {
			NotificationChain msgs = null;
			if (elseExpression != null)
				msgs = ((InternalEObject)elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, null, msgs);
			if (newElseExpression != null)
				msgs = ((InternalEObject)newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, null, msgs);
			msgs = basicSetElseExpression(newElseExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, newElseExpression, newElseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.IF_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.IF_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, ExpressionsPackage.IF_EXP__PARENT_OPERATION, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case ExpressionsPackage.IF_EXP__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
					return eBasicSetContainer(null, ExpressionsPackage.IF_EXP__APPLIED_PROPERTY, msgs);
				case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
					return eBasicSetContainer(null, ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE, msgs);
				case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
					return eBasicSetContainer(null, ExpressionsPackage.IF_EXP__PARENT_OPERATION, msgs);
				case ExpressionsPackage.IF_EXP__CONDITION:
					return basicSetCondition(null, msgs);
				case ExpressionsPackage.IF_EXP__THEN_EXPRESSION:
					return basicSetThenExpression(null, msgs);
				case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION:
					return basicSetElseExpression(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
					return eContainer.eInverseRemove(this, ExpressionsPackage.PROPERTY_CALL_EXP__SOURCE, PropertyCallExp.class, msgs);
				case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
					return eContainer.eInverseRemove(this, ExpressionsPackage.VARIABLE_DECLARATION__INIT_EXPRESSION, VariableDeclaration.class, msgs);
				case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
					return eContainer.eInverseRemove(this, ExpressionsPackage.OPERATION_CALL_EXP__ARGUMENTS, OperationCallExp.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case ExpressionsPackage.IF_EXP__EANNOTATIONS:
				return getEAnnotations();
			case ExpressionsPackage.IF_EXP__NAME:
				return getName();
			case ExpressionsPackage.IF_EXP__START_POSITION:
				return new Integer(getStartPosition());
			case ExpressionsPackage.IF_EXP__END_POSITION:
				return new Integer(getEndPosition());
			case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
				return getAppliedProperty();
			case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable();
			case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
				return getParentOperation();
			case ExpressionsPackage.IF_EXP__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionsPackage.IF_EXP__CONDITION:
				return getCondition();
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION:
				return getThenExpression();
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION:
				return getElseExpression();
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
			case ExpressionsPackage.IF_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case ExpressionsPackage.IF_EXP__NAME:
				setName((String)newValue);
				return;
			case ExpressionsPackage.IF_EXP__START_POSITION:
				setStartPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.IF_EXP__END_POSITION:
				setEndPosition(((Integer)newValue).intValue());
				return;
			case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)newValue);
				return;
			case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)newValue);
				return;
			case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)newValue);
				return;
			case ExpressionsPackage.IF_EXP__TYPE:
				setType((EClassifier)newValue);
				return;
			case ExpressionsPackage.IF_EXP__CONDITION:
				setCondition((OclExpression)newValue);
				return;
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION:
				setThenExpression((OclExpression)newValue);
				return;
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION:
				setElseExpression((OclExpression)newValue);
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
			case ExpressionsPackage.IF_EXP__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case ExpressionsPackage.IF_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpressionsPackage.IF_EXP__START_POSITION:
				setStartPosition(START_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.IF_EXP__END_POSITION:
				setEndPosition(END_POSITION_EDEFAULT);
				return;
			case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
				setAppliedProperty((PropertyCallExp)null);
				return;
			case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
				setInitializedVariable((VariableDeclaration)null);
				return;
			case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
				setParentOperation((OperationCallExp)null);
				return;
			case ExpressionsPackage.IF_EXP__TYPE:
				setType((EClassifier)null);
				return;
			case ExpressionsPackage.IF_EXP__CONDITION:
				setCondition((OclExpression)null);
				return;
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION:
				setThenExpression((OclExpression)null);
				return;
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION:
				setElseExpression((OclExpression)null);
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
			case ExpressionsPackage.IF_EXP__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case ExpressionsPackage.IF_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpressionsPackage.IF_EXP__START_POSITION:
				return startPosition != START_POSITION_EDEFAULT;
			case ExpressionsPackage.IF_EXP__END_POSITION:
				return endPosition != END_POSITION_EDEFAULT;
			case ExpressionsPackage.IF_EXP__APPLIED_PROPERTY:
				return getAppliedProperty() != null;
			case ExpressionsPackage.IF_EXP__INITIALIZED_VARIABLE:
				return getInitializedVariable() != null;
			case ExpressionsPackage.IF_EXP__PARENT_OPERATION:
				return getParentOperation() != null;
			case ExpressionsPackage.IF_EXP__TYPE:
				return type != null;
			case ExpressionsPackage.IF_EXP__CONDITION:
				return condition != null;
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION:
				return thenExpression != null;
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION:
				return elseExpression != null;
		}
		return eDynamicIsSet(eFeature);
	}

} //IfExpImpl
