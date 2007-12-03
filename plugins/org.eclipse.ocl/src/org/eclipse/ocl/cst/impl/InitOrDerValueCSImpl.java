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
 * $Id: InitOrDerValueCSImpl.java,v 1.2 2007/12/03 18:44:41 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.InitOrDerValueCS;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init Or Der Value CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.InitOrDerValueCSImpl#getInitOrDerValueCS <em>Init Or Der Value CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.InitOrDerValueCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InitOrDerValueCSImpl extends CSTNodeImpl implements InitOrDerValueCS {
	/**
     * The cached value of the '{@link #getInitOrDerValueCS() <em>Init Or Der Value CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInitOrDerValueCS()
     * @generated
     * @ordered
     */
	protected InitOrDerValueCS initOrDerValueCS;

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
	protected InitOrDerValueCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.INIT_OR_DER_VALUE_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InitOrDerValueCS getInitOrDerValueCS() {
        return initOrDerValueCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitOrDerValueCS(InitOrDerValueCS newInitOrDerValueCS, NotificationChain msgs) {
        InitOrDerValueCS oldInitOrDerValueCS = initOrDerValueCS;
        initOrDerValueCS = newInitOrDerValueCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS, oldInitOrDerValueCS, newInitOrDerValueCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInitOrDerValueCS(InitOrDerValueCS newInitOrDerValueCS) {
        if (newInitOrDerValueCS != initOrDerValueCS) {
            NotificationChain msgs = null;
            if (initOrDerValueCS != null)
                msgs = ((InternalEObject)initOrDerValueCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS, null, msgs);
            if (newInitOrDerValueCS != null)
                msgs = ((InternalEObject)newInitOrDerValueCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS, null, msgs);
            msgs = basicSetInitOrDerValueCS(newInitOrDerValueCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS, newInitOrDerValueCS, newInitOrDerValueCS));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS, oldExpressionCS, newExpressionCS);
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
                msgs = ((InternalEObject)expressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS, null, msgs);
            if (newExpressionCS != null)
                msgs = ((InternalEObject)newExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS, null, msgs);
            msgs = basicSetExpressionCS(newExpressionCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS, newExpressionCS, newExpressionCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS:
                return basicSetInitOrDerValueCS(null, msgs);
            case CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS:
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
            case CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS:
                return getInitOrDerValueCS();
            case CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS:
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
            case CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS:
                setInitOrDerValueCS((InitOrDerValueCS)newValue);
                return;
            case CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS:
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
            case CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS:
                setInitOrDerValueCS((InitOrDerValueCS)null);
                return;
            case CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS:
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
            case CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS:
                return initOrDerValueCS != null;
            case CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS:
                return expressionCS != null;
        }
        return super.eIsSet(featureID);
    }

} //InitOrDerValueCSImpl
