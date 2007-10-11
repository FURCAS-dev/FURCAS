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
 * $Id: DefExpressionCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.DefExpressionCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.DefExpressionCSImpl#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.DefExpressionCSImpl#getVariableCS <em>Variable CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.DefExpressionCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefExpressionCSImpl extends CSTNodeImpl implements DefExpressionCS {
	/**
     * The cached value of the '{@link #getOperationCS() <em>Operation CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getOperationCS()
     * @generated
     * @ordered
     */
	protected OperationCS operationCS;

	/**
     * The cached value of the '{@link #getVariableCS() <em>Variable CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariableCS()
     * @generated
     * @ordered
     */
	protected VariableCS variableCS;

	/**
     * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExpressionCS()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS expressionCS;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DefExpressionCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.DEF_EXPRESSION_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OperationCS getOperationCS() {
        return operationCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationCS(OperationCS newOperationCS, NotificationChain msgs) {
        OperationCS oldOperationCS = operationCS;
        operationCS = newOperationCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS, oldOperationCS, newOperationCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setOperationCS(OperationCS newOperationCS) {
        if (newOperationCS != operationCS) {
            NotificationChain msgs = null;
            if (operationCS != null)
                msgs = ((InternalEObject)operationCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS, null, msgs);
            if (newOperationCS != null)
                msgs = ((InternalEObject)newOperationCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS, null, msgs);
            msgs = basicSetOperationCS(newOperationCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS, newOperationCS, newOperationCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCS getVariableCS() {
        return variableCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVariableCS(VariableCS newVariableCS, NotificationChain msgs) {
        VariableCS oldVariableCS = variableCS;
        variableCS = newVariableCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS, oldVariableCS, newVariableCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariableCS(VariableCS newVariableCS) {
        if (newVariableCS != variableCS) {
            NotificationChain msgs = null;
            if (variableCS != null)
                msgs = ((InternalEObject)variableCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS, null, msgs);
            if (newVariableCS != null)
                msgs = ((InternalEObject)newVariableCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS, null, msgs);
            msgs = basicSetVariableCS(newVariableCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS, newVariableCS, newVariableCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getExpressionCS() {
        return expressionCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExpressionCS(OCLExpressionCS newExpressionCS, NotificationChain msgs) {
        OCLExpressionCS oldExpressionCS = expressionCS;
        expressionCS = newExpressionCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS, oldExpressionCS, newExpressionCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExpressionCS(OCLExpressionCS newExpressionCS) {
        if (newExpressionCS != expressionCS) {
            NotificationChain msgs = null;
            if (expressionCS != null)
                msgs = ((InternalEObject)expressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS, null, msgs);
            if (newExpressionCS != null)
                msgs = ((InternalEObject)newExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS, null, msgs);
            msgs = basicSetExpressionCS(newExpressionCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS, newExpressionCS, newExpressionCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
                return basicSetOperationCS(null, msgs);
            case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
                return basicSetVariableCS(null, msgs);
            case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
                return basicSetExpressionCS(null, msgs);
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
            case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
                return getOperationCS();
            case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
                return getVariableCS();
            case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
                return getExpressionCS();
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
            case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
                setOperationCS((OperationCS)newValue);
                return;
            case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
                setVariableCS((VariableCS)newValue);
                return;
            case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
                setExpressionCS((OCLExpressionCS)newValue);
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
            case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
                setOperationCS((OperationCS)null);
                return;
            case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
                setVariableCS((VariableCS)null);
                return;
            case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
                setExpressionCS((OCLExpressionCS)null);
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
            case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
                return operationCS != null;
            case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
                return variableCS != null;
            case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
                return expressionCS != null;
        }
        return super.eIsSet(featureID);
    }

} //DefExpressionCSImpl
