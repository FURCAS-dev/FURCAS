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
 * $Id: OperationContextDeclCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
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
import org.eclipse.ocl.cst.OperationCS;
import org.eclipse.ocl.cst.OperationContextDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.OperationContextDeclCSImpl#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.OperationContextDeclCSImpl#getPrePostOrBodyDecls <em>Pre Post Or Body Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationContextDeclCSImpl extends ContextDeclCSImpl implements OperationContextDeclCS {
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
     * The cached value of the '{@link #getPrePostOrBodyDecls() <em>Pre Post Or Body Decls</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPrePostOrBodyDecls()
     * @generated
     * @ordered
     */
	protected EList<PrePostOrBodyDeclCS> prePostOrBodyDecls;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OperationContextDeclCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.OPERATION_CONTEXT_DECL_CS;
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS, oldOperationCS, newOperationCS);
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
                msgs = ((InternalEObject)operationCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS, null, msgs);
            if (newOperationCS != null)
                msgs = ((InternalEObject)newOperationCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS, null, msgs);
            msgs = basicSetOperationCS(newOperationCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS, newOperationCS, newOperationCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<PrePostOrBodyDeclCS> getPrePostOrBodyDecls() {
        if (prePostOrBodyDecls == null) {
            prePostOrBodyDecls = new EObjectContainmentEList<PrePostOrBodyDeclCS>(PrePostOrBodyDeclCS.class, this, CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS);
        }
        return prePostOrBodyDecls;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
                return basicSetOperationCS(null, msgs);
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS:
                return ((InternalEList<?>)getPrePostOrBodyDecls()).basicRemove(otherEnd, msgs);
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
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
                return getOperationCS();
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS:
                return getPrePostOrBodyDecls();
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
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
                setOperationCS((OperationCS)newValue);
                return;
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS:
                getPrePostOrBodyDecls().clear();
                getPrePostOrBodyDecls().addAll((Collection<? extends PrePostOrBodyDeclCS>)newValue);
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
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
                setOperationCS((OperationCS)null);
                return;
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS:
                getPrePostOrBodyDecls().clear();
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
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
                return operationCS != null;
            case CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS:
                return prePostOrBodyDecls != null && !prePostOrBodyDecls.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //OperationContextDeclCSImpl
