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
 * $Id: IfExpImpl.java,v 1.8 2009/01/23 17:16:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.operations.IfExpOperations;
import org.eclipse.ocl.utilities.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.IfExpImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.IfExpImpl#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.impl.IfExpImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfExpImpl<C>
		extends OCLExpressionImpl<C>
		implements IfExp<C> {

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<C> condition;

	/**
	 * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<C> thenExpression;

	/**
	 * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression<C> elseExpression;

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
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.IF_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<C> getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(OCLExpression<C> newCondition,
			NotificationChain msgs) {
		OCLExpression<C> oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, ExpressionsPackage.IF_EXP__CONDITION,
				oldCondition, newCondition);
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
	public void setCondition(OCLExpression<C> newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- ExpressionsPackage.IF_EXP__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- ExpressionsPackage.IF_EXP__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				ExpressionsPackage.IF_EXP__CONDITION, newCondition,
				newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<C> getThenExpression() {
		return thenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenExpression(
			OCLExpression<C> newThenExpression, NotificationChain msgs) {
		OCLExpression<C> oldThenExpression = thenExpression;
		thenExpression = newThenExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, ExpressionsPackage.IF_EXP__THEN_EXPRESSION,
				oldThenExpression, newThenExpression);
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
	public void setThenExpression(OCLExpression<C> newThenExpression) {
		if (newThenExpression != thenExpression) {
			NotificationChain msgs = null;
			if (thenExpression != null)
				msgs = ((InternalEObject) thenExpression).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- ExpressionsPackage.IF_EXP__THEN_EXPRESSION, null,
					msgs);
			if (newThenExpression != null)
				msgs = ((InternalEObject) newThenExpression).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- ExpressionsPackage.IF_EXP__THEN_EXPRESSION, null,
					msgs);
			msgs = basicSetThenExpression(newThenExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				ExpressionsPackage.IF_EXP__THEN_EXPRESSION, newThenExpression,
				newThenExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression<C> getElseExpression() {
		return elseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseExpression(
			OCLExpression<C> newElseExpression, NotificationChain msgs) {
		OCLExpression<C> oldElseExpression = elseExpression;
		elseExpression = newElseExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
				Notification.SET, ExpressionsPackage.IF_EXP__ELSE_EXPRESSION,
				oldElseExpression, newElseExpression);
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
	public void setElseExpression(OCLExpression<C> newElseExpression) {
		if (newElseExpression != elseExpression) {
			NotificationChain msgs = null;
			if (elseExpression != null)
				msgs = ((InternalEObject) elseExpression).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE
						- ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, null,
					msgs);
			if (newElseExpression != null)
				msgs = ((InternalEObject) newElseExpression).eInverseAdd(this,
					EOPPOSITE_FEATURE_BASE
						- ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, null,
					msgs);
			msgs = basicSetElseExpression(newElseExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				ExpressionsPackage.IF_EXP__ELSE_EXPRESSION, newElseExpression,
				newElseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkBooleanCondition(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return IfExpOperations
			.checkBooleanCondition(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean checkIfType(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return IfExpOperations.checkIfType(this, diagnostics, context);
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
			case ExpressionsPackage.IF_EXP__CONDITION :
				return basicSetCondition(null, msgs);
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION :
				return basicSetThenExpression(null, msgs);
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION :
				return basicSetElseExpression(null, msgs);
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
			case ExpressionsPackage.IF_EXP__CONDITION :
				return getCondition();
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION :
				return getThenExpression();
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION :
				return getElseExpression();
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
			case ExpressionsPackage.IF_EXP__CONDITION :
				setCondition((OCLExpression<C>) newValue);
				return;
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION :
				setThenExpression((OCLExpression<C>) newValue);
				return;
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION :
				setElseExpression((OCLExpression<C>) newValue);
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
			case ExpressionsPackage.IF_EXP__CONDITION :
				setCondition((OCLExpression<C>) null);
				return;
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION :
				setThenExpression((OCLExpression<C>) null);
				return;
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION :
				setElseExpression((OCLExpression<C>) null);
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
			case ExpressionsPackage.IF_EXP__CONDITION :
				return condition != null;
			case ExpressionsPackage.IF_EXP__THEN_EXPRESSION :
				return thenExpression != null;
			case ExpressionsPackage.IF_EXP__ELSE_EXPRESSION :
				return elseExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		return ((Visitor<T, C, ?, ?, ?, ?, ?, ?, ?, ?>) v).visitIfExp(this);
	}

} //IfExpImpl
