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
 * $Id: FeatureCallExpCSImpl.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.FeatureCallExpCS;
import org.eclipse.ocl.internal.cst.IsMarkedPreCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.FeatureCallExpCSImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.FeatureCallExpCSImpl#getIsMarkedPreCS <em>Is Marked Pre CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureCallExpCSImpl extends CallExpCSImpl implements FeatureCallExpCS {
	/**
     * The cached value of the '{@link #getArguments() <em>Arguments</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArguments()
     * @generated
     * @ordered
     */
	protected EList<OCLExpressionCS> arguments = null;

	/**
     * The cached value of the '{@link #getIsMarkedPreCS() <em>Is Marked Pre CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIsMarkedPreCS()
     * @generated
     * @ordered
     */
	protected IsMarkedPreCS isMarkedPreCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FeatureCallExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.FEATURE_CALL_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<OCLExpressionCS> getArguments() {
        if (arguments == null) {
            arguments = new EObjectResolvingEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS);
        }
        return arguments;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IsMarkedPreCS getIsMarkedPreCS() {
        if (isMarkedPreCS != null && isMarkedPreCS.eIsProxy()) {
            InternalEObject oldIsMarkedPreCS = (InternalEObject)isMarkedPreCS;
            isMarkedPreCS = (IsMarkedPreCS)eResolveProxy(oldIsMarkedPreCS);
            if (isMarkedPreCS != oldIsMarkedPreCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS, oldIsMarkedPreCS, isMarkedPreCS));
            }
        }
        return isMarkedPreCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IsMarkedPreCS basicGetIsMarkedPreCS() {
        return isMarkedPreCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsMarkedPreCS(IsMarkedPreCS newIsMarkedPreCS) {
        IsMarkedPreCS oldIsMarkedPreCS = isMarkedPreCS;
        isMarkedPreCS = newIsMarkedPreCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS, oldIsMarkedPreCS, isMarkedPreCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS:
                return getArguments();
            case CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS:
                if (resolve) return getIsMarkedPreCS();
                return basicGetIsMarkedPreCS();
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
            case CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS:
                getArguments().clear();
                getArguments().addAll((Collection<? extends OCLExpressionCS>)newValue);
                return;
            case CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS:
                setIsMarkedPreCS((IsMarkedPreCS)newValue);
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
            case CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS:
                getArguments().clear();
                return;
            case CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS:
                setIsMarkedPreCS((IsMarkedPreCS)null);
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
            case CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS:
                return arguments != null && !arguments.isEmpty();
            case CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS:
                return isMarkedPreCS != null;
        }
        return super.eIsSet(featureID);
    }

} //ModelPropertyCallExpCSImpl
