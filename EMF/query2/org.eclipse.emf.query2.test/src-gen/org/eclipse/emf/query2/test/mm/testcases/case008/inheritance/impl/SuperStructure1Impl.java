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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Structure1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure1Impl#getSuperField1From1 <em>Super Field1 From1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure1Impl#getSuperField2From1 <em>Super Field2 From1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperStructure1Impl extends EObjectImpl implements SuperStructure1 {
	/**
	 * The default value of the '{@link #getSuperField1From1() <em>Super Field1 From1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField1From1()
	 * @generated
	 * @ordered
	 */
	protected static final int SUPER_FIELD1_FROM1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSuperField1From1() <em>Super Field1 From1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField1From1()
	 * @generated
	 * @ordered
	 */
	protected int superField1From1 = SUPER_FIELD1_FROM1_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperField2From1() <em>Super Field2 From1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField2From1()
	 * @generated
	 * @ordered
	 */
	protected static final int SUPER_FIELD2_FROM1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSuperField2From1() <em>Super Field2 From1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField2From1()
	 * @generated
	 * @ordered
	 */
	protected int superField2From1 = SUPER_FIELD2_FROM1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperStructure1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InheritancePackage.Literals.SUPER_STRUCTURE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSuperField1From1() {
		return superField1From1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperField1From1(int newSuperField1From1) {
		int oldSuperField1From1 = superField1From1;
		superField1From1 = newSuperField1From1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD1_FROM1, oldSuperField1From1, superField1From1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSuperField2From1() {
		return superField2From1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperField2From1(int newSuperField2From1) {
		int oldSuperField2From1 = superField2From1;
		superField2From1 = newSuperField2From1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD2_FROM1, oldSuperField2From1, superField2From1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD1_FROM1:
				return getSuperField1From1();
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD2_FROM1:
				return getSuperField2From1();
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
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD1_FROM1:
				setSuperField1From1((Integer)newValue);
				return;
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD2_FROM1:
				setSuperField2From1((Integer)newValue);
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
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD1_FROM1:
				setSuperField1From1(SUPER_FIELD1_FROM1_EDEFAULT);
				return;
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD2_FROM1:
				setSuperField2From1(SUPER_FIELD2_FROM1_EDEFAULT);
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
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD1_FROM1:
				return superField1From1 != SUPER_FIELD1_FROM1_EDEFAULT;
			case InheritancePackage.SUPER_STRUCTURE1__SUPER_FIELD2_FROM1:
				return superField2From1 != SUPER_FIELD2_FROM1_EDEFAULT;
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
		result.append(" (superField1From1: ");
		result.append(superField1From1);
		result.append(", superField2From1: ");
		result.append(superField2From1);
		result.append(')');
		return result.toString();
	}

} //SuperStructure1Impl
