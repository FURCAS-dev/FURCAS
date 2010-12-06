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
package org.eclipse.emf.query2.test.mm.testcases.case013.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case013.B13;
import org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package;
import org.eclipse.emf.query2.test.mm.testcases.case013.E13;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B13</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl#getInitializedIntegerAttribute1 <em>Initialized Integer Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl#getInitializedStringAttribute1 <em>Initialized String Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl#isInitializedBooleanAttribute1 <em>Initialized Boolean Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl#getInitializedDoubleAttribute1 <em>Initialized Double Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl#getNotInitializedStringAttribute1 <em>Not Initialized String Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl#getInitializedEnumerationAttribute1 <em>Initialized Enumeration Attribute1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B13Impl extends EObjectImpl implements B13 {
	/**
	 * The default value of the '{@link #getInitializedIntegerAttribute1() <em>Initialized Integer Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedIntegerAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final int INITIALIZED_INTEGER_ATTRIBUTE1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInitializedIntegerAttribute1() <em>Initialized Integer Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedIntegerAttribute1()
	 * @generated
	 * @ordered
	 */
	protected int initializedIntegerAttribute1 = INITIALIZED_INTEGER_ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitializedStringAttribute1() <em>Initialized String Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedStringAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final String INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInitializedStringAttribute1() <em>Initialized String Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedStringAttribute1()
	 * @generated
	 * @ordered
	 */
	protected String initializedStringAttribute1 = INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #isInitializedBooleanAttribute1() <em>Initialized Boolean Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedBooleanAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIALIZED_BOOLEAN_ATTRIBUTE1_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitializedBooleanAttribute1() <em>Initialized Boolean Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitializedBooleanAttribute1()
	 * @generated
	 * @ordered
	 */
	protected boolean initializedBooleanAttribute1 = INITIALIZED_BOOLEAN_ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitializedDoubleAttribute1() <em>Initialized Double Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedDoubleAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final double INITIALIZED_DOUBLE_ATTRIBUTE1_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInitializedDoubleAttribute1() <em>Initialized Double Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedDoubleAttribute1()
	 * @generated
	 * @ordered
	 */
	protected double initializedDoubleAttribute1 = INITIALIZED_DOUBLE_ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotInitializedStringAttribute1() <em>Not Initialized String Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotInitializedStringAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final String NOT_INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotInitializedStringAttribute1() <em>Not Initialized String Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotInitializedStringAttribute1()
	 * @generated
	 * @ordered
	 */
	protected String notInitializedStringAttribute1 = NOT_INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitializedEnumerationAttribute1() <em>Initialized Enumeration Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedEnumerationAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final E13 INITIALIZED_ENUMERATION_ATTRIBUTE1_EDEFAULT = E13.ENUM_FIELD1;

	/**
	 * The cached value of the '{@link #getInitializedEnumerationAttribute1() <em>Initialized Enumeration Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedEnumerationAttribute1()
	 * @generated
	 * @ordered
	 */
	protected E13 initializedEnumerationAttribute1 = INITIALIZED_ENUMERATION_ATTRIBUTE1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B13Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case013Package.Literals.B13;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInitializedIntegerAttribute1() {
		return initializedIntegerAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedIntegerAttribute1(int newInitializedIntegerAttribute1) {
		int oldInitializedIntegerAttribute1 = initializedIntegerAttribute1;
		initializedIntegerAttribute1 = newInitializedIntegerAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.B13__INITIALIZED_INTEGER_ATTRIBUTE1, oldInitializedIntegerAttribute1, initializedIntegerAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitializedStringAttribute1() {
		return initializedStringAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedStringAttribute1(String newInitializedStringAttribute1) {
		String oldInitializedStringAttribute1 = initializedStringAttribute1;
		initializedStringAttribute1 = newInitializedStringAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.B13__INITIALIZED_STRING_ATTRIBUTE1, oldInitializedStringAttribute1, initializedStringAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInitializedBooleanAttribute1() {
		return initializedBooleanAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedBooleanAttribute1(boolean newInitializedBooleanAttribute1) {
		boolean oldInitializedBooleanAttribute1 = initializedBooleanAttribute1;
		initializedBooleanAttribute1 = newInitializedBooleanAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.B13__INITIALIZED_BOOLEAN_ATTRIBUTE1, oldInitializedBooleanAttribute1, initializedBooleanAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInitializedDoubleAttribute1() {
		return initializedDoubleAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedDoubleAttribute1(double newInitializedDoubleAttribute1) {
		double oldInitializedDoubleAttribute1 = initializedDoubleAttribute1;
		initializedDoubleAttribute1 = newInitializedDoubleAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.B13__INITIALIZED_DOUBLE_ATTRIBUTE1, oldInitializedDoubleAttribute1, initializedDoubleAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotInitializedStringAttribute1() {
		return notInitializedStringAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotInitializedStringAttribute1(String newNotInitializedStringAttribute1) {
		String oldNotInitializedStringAttribute1 = notInitializedStringAttribute1;
		notInitializedStringAttribute1 = newNotInitializedStringAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.B13__NOT_INITIALIZED_STRING_ATTRIBUTE1, oldNotInitializedStringAttribute1, notInitializedStringAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public E13 getInitializedEnumerationAttribute1() {
		return initializedEnumerationAttribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedEnumerationAttribute1(E13 newInitializedEnumerationAttribute1) {
		E13 oldInitializedEnumerationAttribute1 = initializedEnumerationAttribute1;
		initializedEnumerationAttribute1 = newInitializedEnumerationAttribute1 == null ? INITIALIZED_ENUMERATION_ATTRIBUTE1_EDEFAULT : newInitializedEnumerationAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.B13__INITIALIZED_ENUMERATION_ATTRIBUTE1, oldInitializedEnumerationAttribute1, initializedEnumerationAttribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case013Package.B13__INITIALIZED_INTEGER_ATTRIBUTE1:
				return getInitializedIntegerAttribute1();
			case Case013Package.B13__INITIALIZED_STRING_ATTRIBUTE1:
				return getInitializedStringAttribute1();
			case Case013Package.B13__INITIALIZED_BOOLEAN_ATTRIBUTE1:
				return isInitializedBooleanAttribute1();
			case Case013Package.B13__INITIALIZED_DOUBLE_ATTRIBUTE1:
				return getInitializedDoubleAttribute1();
			case Case013Package.B13__NOT_INITIALIZED_STRING_ATTRIBUTE1:
				return getNotInitializedStringAttribute1();
			case Case013Package.B13__INITIALIZED_ENUMERATION_ATTRIBUTE1:
				return getInitializedEnumerationAttribute1();
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
			case Case013Package.B13__INITIALIZED_INTEGER_ATTRIBUTE1:
				setInitializedIntegerAttribute1((Integer)newValue);
				return;
			case Case013Package.B13__INITIALIZED_STRING_ATTRIBUTE1:
				setInitializedStringAttribute1((String)newValue);
				return;
			case Case013Package.B13__INITIALIZED_BOOLEAN_ATTRIBUTE1:
				setInitializedBooleanAttribute1((Boolean)newValue);
				return;
			case Case013Package.B13__INITIALIZED_DOUBLE_ATTRIBUTE1:
				setInitializedDoubleAttribute1((Double)newValue);
				return;
			case Case013Package.B13__NOT_INITIALIZED_STRING_ATTRIBUTE1:
				setNotInitializedStringAttribute1((String)newValue);
				return;
			case Case013Package.B13__INITIALIZED_ENUMERATION_ATTRIBUTE1:
				setInitializedEnumerationAttribute1((E13)newValue);
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
			case Case013Package.B13__INITIALIZED_INTEGER_ATTRIBUTE1:
				setInitializedIntegerAttribute1(INITIALIZED_INTEGER_ATTRIBUTE1_EDEFAULT);
				return;
			case Case013Package.B13__INITIALIZED_STRING_ATTRIBUTE1:
				setInitializedStringAttribute1(INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT);
				return;
			case Case013Package.B13__INITIALIZED_BOOLEAN_ATTRIBUTE1:
				setInitializedBooleanAttribute1(INITIALIZED_BOOLEAN_ATTRIBUTE1_EDEFAULT);
				return;
			case Case013Package.B13__INITIALIZED_DOUBLE_ATTRIBUTE1:
				setInitializedDoubleAttribute1(INITIALIZED_DOUBLE_ATTRIBUTE1_EDEFAULT);
				return;
			case Case013Package.B13__NOT_INITIALIZED_STRING_ATTRIBUTE1:
				setNotInitializedStringAttribute1(NOT_INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT);
				return;
			case Case013Package.B13__INITIALIZED_ENUMERATION_ATTRIBUTE1:
				setInitializedEnumerationAttribute1(INITIALIZED_ENUMERATION_ATTRIBUTE1_EDEFAULT);
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
			case Case013Package.B13__INITIALIZED_INTEGER_ATTRIBUTE1:
				return initializedIntegerAttribute1 != INITIALIZED_INTEGER_ATTRIBUTE1_EDEFAULT;
			case Case013Package.B13__INITIALIZED_STRING_ATTRIBUTE1:
				return INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT == null ? initializedStringAttribute1 != null : !INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT.equals(initializedStringAttribute1);
			case Case013Package.B13__INITIALIZED_BOOLEAN_ATTRIBUTE1:
				return initializedBooleanAttribute1 != INITIALIZED_BOOLEAN_ATTRIBUTE1_EDEFAULT;
			case Case013Package.B13__INITIALIZED_DOUBLE_ATTRIBUTE1:
				return initializedDoubleAttribute1 != INITIALIZED_DOUBLE_ATTRIBUTE1_EDEFAULT;
			case Case013Package.B13__NOT_INITIALIZED_STRING_ATTRIBUTE1:
				return NOT_INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT == null ? notInitializedStringAttribute1 != null : !NOT_INITIALIZED_STRING_ATTRIBUTE1_EDEFAULT.equals(notInitializedStringAttribute1);
			case Case013Package.B13__INITIALIZED_ENUMERATION_ATTRIBUTE1:
				return initializedEnumerationAttribute1 != INITIALIZED_ENUMERATION_ATTRIBUTE1_EDEFAULT;
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
		result.append(" (initializedIntegerAttribute1: ");
		result.append(initializedIntegerAttribute1);
		result.append(", initializedStringAttribute1: ");
		result.append(initializedStringAttribute1);
		result.append(", initializedBooleanAttribute1: ");
		result.append(initializedBooleanAttribute1);
		result.append(", initializedDoubleAttribute1: ");
		result.append(initializedDoubleAttribute1);
		result.append(", notInitializedStringAttribute1: ");
		result.append(notInitializedStringAttribute1);
		result.append(", initializedEnumerationAttribute1: ");
		result.append(initializedEnumerationAttribute1);
		result.append(')');
		return result.toString();
	}

} //B13Impl
