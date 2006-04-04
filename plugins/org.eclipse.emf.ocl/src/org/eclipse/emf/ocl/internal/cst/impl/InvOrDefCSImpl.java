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
 * $Id: InvOrDefCSImpl.java,v 1.1 2006/04/04 18:09:05 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.InvOrDefCS;
import org.eclipse.emf.ocl.internal.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inv Or Def CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.InvOrDefCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.InvOrDefCSImpl#getInvOrDefCS <em>Inv Or Def CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InvOrDefCSImpl extends CSTNodeImpl implements InvOrDefCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected SimpleNameCS simpleNameCS = null;

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
	protected InvOrDefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CSTPackage.Literals.INV_OR_DEF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS getSimpleNameCS() {
		if (simpleNameCS != null && simpleNameCS.eIsProxy()) {
			InternalEObject oldSimpleNameCS = (InternalEObject)simpleNameCS;
			simpleNameCS = (SimpleNameCS)eResolveProxy(oldSimpleNameCS);
			if (simpleNameCS != oldSimpleNameCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.INV_OR_DEF_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
			}
		}
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleNameCS basicGetSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
		SimpleNameCS oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INV_OR_DEF_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.INV_OR_DEF_CS__INV_OR_DEF_CS, oldInvOrDefCS, invOrDefCS));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INV_OR_DEF_CS__INV_OR_DEF_CS, oldInvOrDefCS, invOrDefCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.INV_OR_DEF_CS__SIMPLE_NAME_CS:
				if (resolve) return getSimpleNameCS();
				return basicGetSimpleNameCS();
			case CSTPackage.INV_OR_DEF_CS__INV_OR_DEF_CS:
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.INV_OR_DEF_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)newValue);
				return;
			case CSTPackage.INV_OR_DEF_CS__INV_OR_DEF_CS:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CSTPackage.INV_OR_DEF_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((SimpleNameCS)null);
				return;
			case CSTPackage.INV_OR_DEF_CS__INV_OR_DEF_CS:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CSTPackage.INV_OR_DEF_CS__SIMPLE_NAME_CS:
				return simpleNameCS != null;
			case CSTPackage.INV_OR_DEF_CS__INV_OR_DEF_CS:
				return invOrDefCS != null;
		}
		return super.eIsSet(featureID);
	}

} //InvOrDefCSImpl
