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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B1f</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.B1fImpl#getOnePrimitive <em>One Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B1fImpl extends EObjectImpl implements B1f {
	/**
	 * The default value of the '{@link #getOnePrimitive() <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final String ONE_PRIMITIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOnePrimitive() <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitive()
	 * @generated
	 * @ordered
	 */
	protected String onePrimitive = ONE_PRIMITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B1fImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case001fPackage.Literals.B1F;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOnePrimitive() {
		return onePrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnePrimitive(String newOnePrimitive) {
		String oldOnePrimitive = onePrimitive;
		onePrimitive = newOnePrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case001fPackage.B1F__ONE_PRIMITIVE, oldOnePrimitive, onePrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case001fPackage.B1F__ONE_PRIMITIVE:
				return getOnePrimitive();
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
			case Case001fPackage.B1F__ONE_PRIMITIVE:
				setOnePrimitive((String)newValue);
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
			case Case001fPackage.B1F__ONE_PRIMITIVE:
				setOnePrimitive(ONE_PRIMITIVE_EDEFAULT);
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
			case Case001fPackage.B1F__ONE_PRIMITIVE:
				return ONE_PRIMITIVE_EDEFAULT == null ? onePrimitive != null : !ONE_PRIMITIVE_EDEFAULT.equals(onePrimitive);
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
		result.append(" (onePrimitive: ");
		result.append(onePrimitive);
		result.append(')');
		return result.toString();
	}

} //B1fImpl
