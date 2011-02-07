/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case018.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.query2.test.mm.testcases.case018.B18;
import org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.B1fImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B18</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.B18Impl#getSpecialOnePrimitive <em>Special One Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B18Impl extends B1fImpl implements B18 {
	/**
	 * The default value of the '{@link #getSpecialOnePrimitive() <em>Special One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialOnePrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIAL_ONE_PRIMITIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecialOnePrimitive() <em>Special One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialOnePrimitive()
	 * @generated
	 * @ordered
	 */
	protected String specialOnePrimitive = SPECIAL_ONE_PRIMITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B18Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case018Package.Literals.B18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecialOnePrimitive() {
		return specialOnePrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecialOnePrimitive(String newSpecialOnePrimitive) {
		String oldSpecialOnePrimitive = specialOnePrimitive;
		specialOnePrimitive = newSpecialOnePrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case018Package.B18__SPECIAL_ONE_PRIMITIVE, oldSpecialOnePrimitive, specialOnePrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case018Package.B18__SPECIAL_ONE_PRIMITIVE:
				return getSpecialOnePrimitive();
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
			case Case018Package.B18__SPECIAL_ONE_PRIMITIVE:
				setSpecialOnePrimitive((String)newValue);
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
			case Case018Package.B18__SPECIAL_ONE_PRIMITIVE:
				setSpecialOnePrimitive(SPECIAL_ONE_PRIMITIVE_EDEFAULT);
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
			case Case018Package.B18__SPECIAL_ONE_PRIMITIVE:
				return SPECIAL_ONE_PRIMITIVE_EDEFAULT == null ? specialOnePrimitive != null : !SPECIAL_ONE_PRIMITIVE_EDEFAULT.equals(specialOnePrimitive);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (specialOnePrimitive: "); //$NON-NLS-1$
		result.append(specialOnePrimitive);
		result.append(')');
		return result.toString();
	}

} //B18Impl
