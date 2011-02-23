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
package org.eclipse.emf.query2.test.mm.testcases.case004.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case004.B4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4Impl#getOnePrimitive <em>One Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B4Impl extends EObjectImpl implements B4 {
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
	protected B4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.B4;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.B4__ONE_PRIMITIVE, oldOnePrimitive, onePrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case004Package.B4__ONE_PRIMITIVE:
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
			case Case004Package.B4__ONE_PRIMITIVE:
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
			case Case004Package.B4__ONE_PRIMITIVE:
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
			case Case004Package.B4__ONE_PRIMITIVE:
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
		result.append(" (onePrimitive: "); //$NON-NLS-1$
		result.append(onePrimitive);
		result.append(')');
		return result.toString();
	}

} //B4Impl
