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
 * $Id: CollectionRangeCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Range CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.CollectionRangeCSImpl#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionRangeCSImpl extends CollectionLiteralPartCSImpl implements CollectionRangeCS {
	/**
     * The cached value of the '{@link #getLastExpressionCS() <em>Last Expression CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getLastExpressionCS()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS lastExpressionCS;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CollectionRangeCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.COLLECTION_RANGE_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getLastExpressionCS() {
        return lastExpressionCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLastExpressionCS(OCLExpressionCS newLastExpressionCS, NotificationChain msgs) {
        OCLExpressionCS oldLastExpressionCS = lastExpressionCS;
        lastExpressionCS = newLastExpressionCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS, oldLastExpressionCS, newLastExpressionCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setLastExpressionCS(OCLExpressionCS newLastExpressionCS) {
        if (newLastExpressionCS != lastExpressionCS) {
            NotificationChain msgs = null;
            if (lastExpressionCS != null)
                msgs = ((InternalEObject)lastExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS, null, msgs);
            if (newLastExpressionCS != null)
                msgs = ((InternalEObject)newLastExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS, null, msgs);
            msgs = basicSetLastExpressionCS(newLastExpressionCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS, newLastExpressionCS, newLastExpressionCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
                return basicSetLastExpressionCS(null, msgs);
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
            case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
                return getLastExpressionCS();
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
            case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
                setLastExpressionCS((OCLExpressionCS)newValue);
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
            case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
                setLastExpressionCS((OCLExpressionCS)null);
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
            case CSTPackage.COLLECTION_RANGE_CS__LAST_EXPRESSION_CS:
                return lastExpressionCS != null;
        }
        return super.eIsSet(featureID);
    }

} //CollectionRangeCSImpl
