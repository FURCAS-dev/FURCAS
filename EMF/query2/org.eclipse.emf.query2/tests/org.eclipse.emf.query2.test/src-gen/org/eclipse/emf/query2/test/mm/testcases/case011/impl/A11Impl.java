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
package org.eclipse.emf.query2.test.mm.testcases.case011.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case011.A11;
import org.eclipse.emf.query2.test.mm.testcases.case011.Case011Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A11</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case011.impl.A11Impl#getAttribute1 <em>Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case011.impl.A11Impl#getAttribute2 <em>Attribute2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A11Impl extends EObjectImpl implements A11 {
	/**
	 * The default value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected String attribute1 = ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttribute2() <em>Attribute2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute2()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute2() <em>Attribute2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute2()
	 * @generated
	 * @ordered
	 */
	protected String attribute2 = ATTRIBUTE2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A11Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case011Package.Literals.A11;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute1() {
		return attribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute1(String newAttribute1) {
		String oldAttribute1 = attribute1;
		attribute1 = newAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case011Package.A11__ATTRIBUTE1, oldAttribute1, attribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute2() {
		return attribute2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute2(String newAttribute2) {
		String oldAttribute2 = attribute2;
		attribute2 = newAttribute2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case011Package.A11__ATTRIBUTE2, oldAttribute2, attribute2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void callMultipleSetter(boolean throwRuntimeExceptionBetweenTheCalls, String attribute1, String attribute2) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String callMultipleGetter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case011Package.A11__ATTRIBUTE1:
				return getAttribute1();
			case Case011Package.A11__ATTRIBUTE2:
				return getAttribute2();
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
			case Case011Package.A11__ATTRIBUTE1:
				setAttribute1((String)newValue);
				return;
			case Case011Package.A11__ATTRIBUTE2:
				setAttribute2((String)newValue);
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
			case Case011Package.A11__ATTRIBUTE1:
				setAttribute1(ATTRIBUTE1_EDEFAULT);
				return;
			case Case011Package.A11__ATTRIBUTE2:
				setAttribute2(ATTRIBUTE2_EDEFAULT);
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
			case Case011Package.A11__ATTRIBUTE1:
				return ATTRIBUTE1_EDEFAULT == null ? attribute1 != null : !ATTRIBUTE1_EDEFAULT.equals(attribute1);
			case Case011Package.A11__ATTRIBUTE2:
				return ATTRIBUTE2_EDEFAULT == null ? attribute2 != null : !ATTRIBUTE2_EDEFAULT.equals(attribute2);
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
		result.append(" (attribute1: "); //$NON-NLS-1$
		result.append(attribute1);
		result.append(", attribute2: "); //$NON-NLS-1$
		result.append(attribute2);
		result.append(')');
		return result.toString();
	}

} //A11Impl
