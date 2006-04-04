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
 * $Id: InitOrDerValueCSImpl.java,v 1.1 2006/04/04 18:09:04 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.InitOrDerValueCS;
import org.eclipse.emf.ocl.internal.cst.OCLExpressionCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Init Or Der Value CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.InitOrDerValueCSImpl#getInitOrDerValueCS <em>Init Or Der Value CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.InitOrDerValueCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InitOrDerValueCSImpl extends CSTNodeImpl implements InitOrDerValueCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getInitOrDerValueCS() <em>Init Or Der Value CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitOrDerValueCS()
	 * @generated
	 * @ordered
	 */
	protected InitOrDerValueCS initOrDerValueCS = null;

	/**
	 * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS expressionCS = null;

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
	protected EClass eStaticClass() {
		return CSTPackage.Literals.INIT_OR_DER_VALUE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitOrDerValueCS getInitOrDerValueCS() {
		if (initOrDerValueCS != null && initOrDerValueCS.eIsProxy()) {
			InternalEObject oldInitOrDerValueCS = (InternalEObject)initOrDerValueCS;
			initOrDerValueCS = (InitOrDerValueCS)eResolveProxy(oldInitOrDerValueCS);
			if (initOrDerValueCS != oldInitOrDerValueCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS, oldInitOrDerValueCS, initOrDerValueCS));
			}
		}
		return initOrDerValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitOrDerValueCS basicGetInitOrDerValueCS() {
		return initOrDerValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitOrDerValueCS(InitOrDerValueCS newInitOrDerValueCS) {
		InitOrDerValueCS oldInitOrDerValueCS = initOrDerValueCS;
		initOrDerValueCS = newInitOrDerValueCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS, oldInitOrDerValueCS, initOrDerValueCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getExpressionCS() {
		if (expressionCS != null && expressionCS.eIsProxy()) {
			InternalEObject oldExpressionCS = (InternalEObject)expressionCS;
			expressionCS = (OCLExpressionCS)eResolveProxy(oldExpressionCS);
			if (expressionCS != oldExpressionCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS, oldExpressionCS, expressionCS));
			}
		}
		return expressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS basicGetExpressionCS() {
		return expressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionCS(OCLExpressionCS newExpressionCS) {
		OCLExpressionCS oldExpressionCS = expressionCS;
		expressionCS = newExpressionCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS, oldExpressionCS, expressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.INIT_OR_DER_VALUE_CS__INIT_OR_DER_VALUE_CS:
				if (resolve) return getInitOrDerValueCS();
				return basicGetInitOrDerValueCS();
			case CSTPackage.INIT_OR_DER_VALUE_CS__EXPRESSION_CS:
				if (resolve) return getExpressionCS();
				return basicGetExpressionCS();
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
