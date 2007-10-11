/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IfExpCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.IfExpCSImpl#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.IfExpCSImpl#getElseExpression <em>Else Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.IfExpCSImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfExpCSImpl extends OCLExpressionCSImpl implements IfExpCS {
	/**
     * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getThenExpression()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS thenExpression;

	/**
     * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getElseExpression()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS elseExpression;

	/**
     * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getCondition()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS condition;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected IfExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.IF_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getThenExpression() {
        return thenExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetThenExpression(OCLExpressionCS newThenExpression, NotificationChain msgs) {
        OCLExpressionCS oldThenExpression = thenExpression;
        thenExpression = newThenExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.IF_EXP_CS__THEN_EXPRESSION, oldThenExpression, newThenExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setThenExpression(OCLExpressionCS newThenExpression) {
        if (newThenExpression != thenExpression) {
            NotificationChain msgs = null;
            if (thenExpression != null)
                msgs = ((InternalEObject)thenExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.IF_EXP_CS__THEN_EXPRESSION, null, msgs);
            if (newThenExpression != null)
                msgs = ((InternalEObject)newThenExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.IF_EXP_CS__THEN_EXPRESSION, null, msgs);
            msgs = basicSetThenExpression(newThenExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.IF_EXP_CS__THEN_EXPRESSION, newThenExpression, newThenExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getElseExpression() {
        return elseExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetElseExpression(OCLExpressionCS newElseExpression, NotificationChain msgs) {
        OCLExpressionCS oldElseExpression = elseExpression;
        elseExpression = newElseExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.IF_EXP_CS__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setElseExpression(OCLExpressionCS newElseExpression) {
        if (newElseExpression != elseExpression) {
            NotificationChain msgs = null;
            if (elseExpression != null)
                msgs = ((InternalEObject)elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.IF_EXP_CS__ELSE_EXPRESSION, null, msgs);
            if (newElseExpression != null)
                msgs = ((InternalEObject)newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.IF_EXP_CS__ELSE_EXPRESSION, null, msgs);
            msgs = basicSetElseExpression(newElseExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.IF_EXP_CS__ELSE_EXPRESSION, newElseExpression, newElseExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getCondition() {
        return condition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetCondition(OCLExpressionCS newCondition, NotificationChain msgs) {
        OCLExpressionCS oldCondition = condition;
        condition = newCondition;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.IF_EXP_CS__CONDITION, oldCondition, newCondition);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setCondition(OCLExpressionCS newCondition) {
        if (newCondition != condition) {
            NotificationChain msgs = null;
            if (condition != null)
                msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.IF_EXP_CS__CONDITION, null, msgs);
            if (newCondition != null)
                msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.IF_EXP_CS__CONDITION, null, msgs);
            msgs = basicSetCondition(newCondition, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.IF_EXP_CS__CONDITION, newCondition, newCondition));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.IF_EXP_CS__THEN_EXPRESSION:
                return basicSetThenExpression(null, msgs);
            case CSTPackage.IF_EXP_CS__ELSE_EXPRESSION:
                return basicSetElseExpression(null, msgs);
            case CSTPackage.IF_EXP_CS__CONDITION:
                return basicSetCondition(null, msgs);
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
            case CSTPackage.IF_EXP_CS__THEN_EXPRESSION:
                return getThenExpression();
            case CSTPackage.IF_EXP_CS__ELSE_EXPRESSION:
                return getElseExpression();
            case CSTPackage.IF_EXP_CS__CONDITION:
                return getCondition();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CSTPackage.IF_EXP_CS__THEN_EXPRESSION:
                setThenExpression((OCLExpressionCS)newValue);
                return;
            case CSTPackage.IF_EXP_CS__ELSE_EXPRESSION:
                setElseExpression((OCLExpressionCS)newValue);
                return;
            case CSTPackage.IF_EXP_CS__CONDITION:
                setCondition((OCLExpressionCS)newValue);
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
            case CSTPackage.IF_EXP_CS__THEN_EXPRESSION:
                setThenExpression((OCLExpressionCS)null);
                return;
            case CSTPackage.IF_EXP_CS__ELSE_EXPRESSION:
                setElseExpression((OCLExpressionCS)null);
                return;
            case CSTPackage.IF_EXP_CS__CONDITION:
                setCondition((OCLExpressionCS)null);
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
            case CSTPackage.IF_EXP_CS__THEN_EXPRESSION:
                return thenExpression != null;
            case CSTPackage.IF_EXP_CS__ELSE_EXPRESSION:
                return elseExpression != null;
            case CSTPackage.IF_EXP_CS__CONDITION:
                return condition != null;
        }
        return super.eIsSet(featureID);
    }

} //IfExpCSImpl
