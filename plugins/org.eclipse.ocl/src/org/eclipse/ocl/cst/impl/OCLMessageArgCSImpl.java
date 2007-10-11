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
 * $Id: OCLMessageArgCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Message Arg CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.OCLMessageArgCSImpl#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.OCLMessageArgCSImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OCLMessageArgCSImpl extends CSTNodeImpl implements OCLMessageArgCS {
	/**
     * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeCS()
     * @generated
     * @ordered
     */
	protected TypeCS typeCS;

	/**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS expression;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OCLMessageArgCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.OCL_MESSAGE_ARG_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeCS getTypeCS() {
        return typeCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTypeCS(TypeCS newTypeCS, NotificationChain msgs) {
        TypeCS oldTypeCS = typeCS;
        typeCS = newTypeCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS, oldTypeCS, newTypeCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeCS(TypeCS newTypeCS) {
        if (newTypeCS != typeCS) {
            NotificationChain msgs = null;
            if (typeCS != null)
                msgs = ((InternalEObject)typeCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS, null, msgs);
            if (newTypeCS != null)
                msgs = ((InternalEObject)newTypeCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS, null, msgs);
            msgs = basicSetTypeCS(newTypeCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS, newTypeCS, newTypeCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getExpression() {
        return expression;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExpression(OCLExpressionCS newExpression, NotificationChain msgs) {
        OCLExpressionCS oldExpression = expression;
        expression = newExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION, oldExpression, newExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExpression(OCLExpressionCS newExpression) {
        if (newExpression != expression) {
            NotificationChain msgs = null;
            if (expression != null)
                msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION, null, msgs);
            if (newExpression != null)
                msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION, null, msgs);
            msgs = basicSetExpression(newExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION, newExpression, newExpression));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS:
                return basicSetTypeCS(null, msgs);
            case CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION:
                return basicSetExpression(null, msgs);
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
            case CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS:
                return getTypeCS();
            case CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION:
                return getExpression();
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
            case CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS:
                setTypeCS((TypeCS)newValue);
                return;
            case CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION:
                setExpression((OCLExpressionCS)newValue);
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
            case CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS:
                setTypeCS((TypeCS)null);
                return;
            case CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION:
                setExpression((OCLExpressionCS)null);
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
            case CSTPackage.OCL_MESSAGE_ARG_CS__TYPE_CS:
                return typeCS != null;
            case CSTPackage.OCL_MESSAGE_ARG_CS__EXPRESSION:
                return expression != null;
        }
        return super.eIsSet(featureID);
    }

} //OCLMessageArgCSImpl
