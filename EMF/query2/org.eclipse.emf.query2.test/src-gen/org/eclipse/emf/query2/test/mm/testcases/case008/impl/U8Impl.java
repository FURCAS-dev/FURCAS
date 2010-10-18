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
package org.eclipse.emf.query2.test.mm.testcases.case008.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package;
import org.eclipse.emf.query2.test.mm.testcases.case008.U8;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>U8</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.U8Impl#isSubField1 <em>Sub Field1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class U8Impl extends T8Impl implements U8 {
	/**
	 * The default value of the '{@link #isSubField1() <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubField1()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUB_FIELD1_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSubField1() <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSubField1()
	 * @generated
	 * @ordered
	 */
	protected boolean subField1 = SUB_FIELD1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected U8Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case008Package.Literals.U8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubField1() {
		return subField1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField1(boolean newSubField1) {
		boolean oldSubField1 = subField1;
		subField1 = newSubField1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case008Package.U8__SUB_FIELD1, oldSubField1, subField1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case008Package.U8__SUB_FIELD1:
				return isSubField1();
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
			case Case008Package.U8__SUB_FIELD1:
				setSubField1((Boolean)newValue);
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
			case Case008Package.U8__SUB_FIELD1:
				setSubField1(SUB_FIELD1_EDEFAULT);
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
			case Case008Package.U8__SUB_FIELD1:
				return subField1 != SUB_FIELD1_EDEFAULT;
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
		result.append(" (subField1: ");
		result.append(subField1);
		result.append(')');
		return result.toString();
	}

} //U8Impl
