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
 * $Id: ClassifierContextDeclCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.ClassifierContextDeclCS;
import org.eclipse.ocl.cst.InvOrDefCS;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.ClassifierContextDeclCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.ClassifierContextDeclCSImpl#getInvOrDefCS <em>Inv Or Def CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierContextDeclCSImpl extends ContextDeclCSImpl implements ClassifierContextDeclCS {
	/**
     * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPathNameCS()
     * @generated
     * @ordered
     */
	protected PathNameCS pathNameCS;

	/**
     * The cached value of the '{@link #getInvOrDefCS() <em>Inv Or Def CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInvOrDefCS()
     * @generated
     * @ordered
     */
	protected InvOrDefCS invOrDefCS;

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
        return pathNameCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS, NotificationChain msgs) {
        PathNameCS oldPathNameCS = pathNameCS;
        pathNameCS = newPathNameCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS, oldPathNameCS, newPathNameCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPathNameCS(PathNameCS newPathNameCS) {
        if (newPathNameCS != pathNameCS) {
            NotificationChain msgs = null;
            if (pathNameCS != null)
                msgs = ((InternalEObject)pathNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS, null, msgs);
            if (newPathNameCS != null)
                msgs = ((InternalEObject)newPathNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS, null, msgs);
            msgs = basicSetPathNameCS(newPathNameCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS, newPathNameCS, newPathNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InvOrDefCS getInvOrDefCS() {
        return invOrDefCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInvOrDefCS(InvOrDefCS newInvOrDefCS, NotificationChain msgs) {
        InvOrDefCS oldInvOrDefCS = invOrDefCS;
        invOrDefCS = newInvOrDefCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS, oldInvOrDefCS, newInvOrDefCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInvOrDefCS(InvOrDefCS newInvOrDefCS) {
        if (newInvOrDefCS != invOrDefCS) {
            NotificationChain msgs = null;
            if (invOrDefCS != null)
                msgs = ((InternalEObject)invOrDefCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS, null, msgs);
            if (newInvOrDefCS != null)
                msgs = ((InternalEObject)newInvOrDefCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS, null, msgs);
            msgs = basicSetInvOrDefCS(newInvOrDefCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS, newInvOrDefCS, newInvOrDefCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS:
                return basicSetPathNameCS(null, msgs);
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS:
                return basicSetInvOrDefCS(null, msgs);
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
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__PATH_NAME_CS:
                return getPathNameCS();
            case CSTPackage.CLASSIFIER_CONTEXT_DECL_CS__INV_OR_DEF_CS:
                return getInvOrDefCS();
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
