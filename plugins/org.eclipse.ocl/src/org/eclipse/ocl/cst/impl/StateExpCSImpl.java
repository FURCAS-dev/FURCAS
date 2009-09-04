/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: StateExpCSImpl.java,v 1.4 2009/09/04 13:40:43 ewillink Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StateExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.StateExpCSImpl#getSimpleNames <em>Simple Names</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateExpCSImpl
		extends TypeCSImpl
		implements StateExpCS {

	/**
	 * The cached value of the '{@link #getSimpleNames() <em>Simple Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @see #getSimpleNames()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleNameCS> simpleNames;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.STATE_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SimpleNameCS> getSimpleNames() {
		if (simpleNames == null) {
			simpleNames = new EObjectContainmentEList<SimpleNameCS>(
				SimpleNameCS.class, this, CSTPackage.STATE_EXP_CS__SIMPLE_NAMES);
		}
		return simpleNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.STATE_EXP_CS__SIMPLE_NAMES :
				return ((InternalEList<?>) getSimpleNames()).basicRemove(
					otherEnd, msgs);
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
			case CSTPackage.STATE_EXP_CS__SIMPLE_NAMES :
				return getSimpleNames();
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
			case CSTPackage.STATE_EXP_CS__SIMPLE_NAMES :
				getSimpleNames().clear();
				getSimpleNames().addAll(
					(Collection<? extends SimpleNameCS>) newValue);
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
			case CSTPackage.STATE_EXP_CS__SIMPLE_NAMES :
				getSimpleNames().clear();
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
			case CSTPackage.STATE_EXP_CS__SIMPLE_NAMES :
				return simpleNames != null && !simpleNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateExpCSImpl
