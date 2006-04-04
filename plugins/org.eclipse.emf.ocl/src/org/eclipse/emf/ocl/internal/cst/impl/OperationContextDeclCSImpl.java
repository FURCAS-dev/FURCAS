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
 * $Id: OperationContextDeclCSImpl.java,v 1.1 2006/04/04 18:09:05 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.OperationCS;
import org.eclipse.emf.ocl.internal.cst.OperationContextDeclCS;
import org.eclipse.emf.ocl.internal.cst.PrePostOrBodyDeclCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.OperationContextDeclCSImpl#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.OperationContextDeclCSImpl#getPrePostOrBodyDecls <em>Pre Post Or Body Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationContextDeclCSImpl extends ContextDeclCSImpl implements OperationContextDeclCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getOperationCS() <em>Operation CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationCS()
	 * @generated
	 * @ordered
	 */
	protected OperationCS operationCS = null;

	/**
	 * The cached value of the '{@link #getPrePostOrBodyDecls() <em>Pre Post Or Body Decls</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrePostOrBodyDecls()
	 * @generated
	 * @ordered
	 */
	protected EList prePostOrBodyDecls = null;

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
	protected EClass eStaticClass() {
		return CSTPackage.Literals.OPERATION_CONTEXT_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS getOperationCS() {
		if (operationCS != null && operationCS.eIsProxy()) {
			InternalEObject oldOperationCS = (InternalEObject)operationCS;
			operationCS = (OperationCS)eResolveProxy(oldOperationCS);
			if (operationCS != oldOperationCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS, oldOperationCS, operationCS));
			}
		}
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS basicGetOperationCS() {
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationCS(OperationCS newOperationCS) {
		OperationCS oldOperationCS = operationCS;
		operationCS = newOperationCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS, oldOperationCS, operationCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getPrePostOrBodyDecls() {
		if (prePostOrBodyDecls == null) {
			prePostOrBodyDecls = new EObjectResolvingEList(PrePostOrBodyDeclCS.class, this, CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS);
		}
		return prePostOrBodyDecls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
				if (resolve) return getOperationCS();
				return basicGetOperationCS();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.OPERATION_CONTEXT_DECL_CS__OPERATION_CS:
				setOperationCS((OperationCS)newValue);
				return;
			case CSTPackage.OPERATION_CONTEXT_DECL_CS__PRE_POST_OR_BODY_DECLS:
				getPrePostOrBodyDecls().clear();
				getPrePostOrBodyDecls().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
