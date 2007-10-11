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
 * $Id: FeatureCallExpCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.FeatureCallExpCSImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.FeatureCallExpCSImpl#getIsMarkedPreCS <em>Is Marked Pre CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureCallExpCSImpl extends CallExpCSImpl implements FeatureCallExpCS {
	/**
     * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArguments()
     * @generated
     * @ordered
     */
	protected EList<OCLExpressionCS> arguments;

	/**
     * The cached value of the '{@link #getIsMarkedPreCS() <em>Is Marked Pre CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIsMarkedPreCS()
     * @generated
     * @ordered
     */
	protected IsMarkedPreCS isMarkedPreCS;

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
            arguments = new EObjectContainmentEList<OCLExpressionCS>(OCLExpressionCS.class, this, CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS);
        }
        return arguments;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IsMarkedPreCS getIsMarkedPreCS() {
        return isMarkedPreCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetIsMarkedPreCS(IsMarkedPreCS newIsMarkedPreCS, NotificationChain msgs) {
        IsMarkedPreCS oldIsMarkedPreCS = isMarkedPreCS;
        isMarkedPreCS = newIsMarkedPreCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS, oldIsMarkedPreCS, newIsMarkedPreCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIsMarkedPreCS(IsMarkedPreCS newIsMarkedPreCS) {
        if (newIsMarkedPreCS != isMarkedPreCS) {
            NotificationChain msgs = null;
            if (isMarkedPreCS != null)
                msgs = ((InternalEObject)isMarkedPreCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS, null, msgs);
            if (newIsMarkedPreCS != null)
                msgs = ((InternalEObject)newIsMarkedPreCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS, null, msgs);
            msgs = basicSetIsMarkedPreCS(newIsMarkedPreCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS, newIsMarkedPreCS, newIsMarkedPreCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS:
                return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
            case CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS:
                return basicSetIsMarkedPreCS(null, msgs);
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
            case CSTPackage.FEATURE_CALL_EXP_CS__ARGUMENTS:
                return getArguments();
            case CSTPackage.FEATURE_CALL_EXP_CS__IS_MARKED_PRE_CS:
                return getIsMarkedPreCS();
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
