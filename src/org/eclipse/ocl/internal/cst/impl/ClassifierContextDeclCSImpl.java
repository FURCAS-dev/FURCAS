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
 * $Id: ClassifierContextDeclCSImpl.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.internal.cst.InvOrDefCS;
import org.eclipse.ocl.internal.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.ClassifierContextDeclCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.ClassifierContextDeclCSImpl#getInvOrDefCS <em>Inv Or Def CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclCSImpl extends ContextDeclCSImpl implements ClassifierContextDeclCS {
	/**
     * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPathNameCS()
     * @generated
     * @ordered
     */
	protected PathNameCS pathNameCS = null;

	/**
     * The cached value of the '{@link #getInvOrDefCS() <em>Inv Or Def CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInvOrDefCS()
     * @generated
     * @ordered
     */
	protected InvOrDefCS invOrDefCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ClassifierContextDeclCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.CLASSIFIER_CONTEXT_DECL_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PathNameCS getPathNameCS() {
        if (pathNameCS != null && pathNameCS.eIsProxy()) {
            InternalEObject oldPathNameCS = (InternalEObject)pathNameCS;
            pathNameCS = (PathNameCS)eResolveProxy(oldPathNameCS);
            if (pathNameCS != oldPathNameCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
            }
        }
        return pathNameCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PathNameCS basicGetPathNameCS() {
        return pathNameCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPathNameCS(PathNameCS newPathNameCS) {
        PathNameCS oldPathNameCS = pathNameCS;
        pathNameCS = newPathNameCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InvOrDefCS getInvOrDefCS() {
        if (invOrDefCS != null && invOrDefCS.eIsProxy()) {
            InternalEObject oldInvOrDefCS = (InternalEObject)invOrDefCS;
            invOrDefCS = (InvOrDefCS)eResolveProxy(oldInvOrDefCS);
            if (invOrDefCS != oldInvOrDefCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS, oldInvOrDefCS, invOrDefCS));
            }
        }
        return invOrDefCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InvOrDefCS basicGetInvOrDefCS() {
        return invOrDefCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInvOrDefCS(InvOrDefCS newInvOrDefCS) {
        InvOrDefCS oldInvOrDefCS = invOrDefCS;
        invOrDefCS = newInvOrDefCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS, oldInvOrDefCS, invOrDefCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS:
                if (resolve) return getPathNameCS();
                return basicGetPathNameCS();
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS:
                if (resolve) return getInvOrDefCS();
                return basicGetInvOrDefCS();
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
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS:
                setPathNameCS((PathNameCS)newValue);
                return;
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS:
                setInvOrDefCS((InvOrDefCS)newValue);
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
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS:
                setPathNameCS((PathNameCS)null);
                return;
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS:
                setInvOrDefCS((InvOrDefCS)null);
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
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS:
                return pathNameCS != null;
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS:
                return invOrDefCS != null;
        }
        return super.eIsSet(featureID);
    }

} //ClassifierContextDeclCSImpl
