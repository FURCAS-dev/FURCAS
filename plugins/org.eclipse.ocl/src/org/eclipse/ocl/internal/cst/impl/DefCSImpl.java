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
 * $Id: DefCSImpl.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.DefCS;
import org.eclipse.ocl.internal.cst.DefExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.DefCSImpl#getDefExpressionCS <em>Def Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefCSImpl extends InvOrDefCSImpl implements DefCS {
	/**
     * The cached value of the '{@link #getDefExpressionCS() <em>Def Expression CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getDefExpressionCS()
     * @generated
     * @ordered
     */
	protected DefExpressionCS defExpressionCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected DefCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.DEF_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DefExpressionCS getDefExpressionCS() {
        if (defExpressionCS != null && defExpressionCS.eIsProxy()) {
            InternalEObject oldDefExpressionCS = (InternalEObject)defExpressionCS;
            defExpressionCS = (DefExpressionCS)eResolveProxy(oldDefExpressionCS);
            if (defExpressionCS != oldDefExpressionCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.DEF_CS__DEF_EXPRESSION_CS, oldDefExpressionCS, defExpressionCS));
            }
        }
        return defExpressionCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DefExpressionCS basicGetDefExpressionCS() {
        return defExpressionCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDefExpressionCS(DefExpressionCS newDefExpressionCS) {
        DefExpressionCS oldDefExpressionCS = defExpressionCS;
        defExpressionCS = newDefExpressionCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_CS__DEF_EXPRESSION_CS, oldDefExpressionCS, defExpressionCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.DEF_CS__DEF_EXPRESSION_CS:
                if (resolve) return getDefExpressionCS();
                return basicGetDefExpressionCS();
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
            case CSTPackage.DEF_CS__DEF_EXPRESSION_CS:
                setDefExpressionCS((DefExpressionCS)newValue);
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
            case CSTPackage.DEF_CS__DEF_EXPRESSION_CS:
                setDefExpressionCS((DefExpressionCS)null);
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
            case CSTPackage.DEF_CS__DEF_EXPRESSION_CS:
                return defExpressionCS != null;
        }
        return super.eIsSet(featureID);
    }

} //DefCSImpl
