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
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Super Structure2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SuperStructure2Impl#getSuperField1From2 <em>Super Field1 From2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuperStructure2Impl extends EObjectImpl implements SuperStructure2 {
	/**
	 * The default value of the '{@link #getSuperField1From2() <em>Super Field1 From2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField1From2()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_FIELD1_FROM2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperField1From2() <em>Super Field1 From2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperField1From2()
	 * @generated
	 * @ordered
	 */
	protected String superField1From2 = SUPER_FIELD1_FROM2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SuperStructure2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InheritancePackage.Literals.SUPER_STRUCTURE2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSuperField1From2() {
		return superField1From2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperField1From2(String newSuperField1From2) {
		String oldSuperField1From2 = superField1From2;
		superField1From2 = newSuperField1From2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2, oldSuperField1From2, superField1From2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2:
				return getSuperField1From2();
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
			case InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2:
				setSuperField1From2((String)newValue);
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
			case InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2:
				setSuperField1From2(SUPER_FIELD1_FROM2_EDEFAULT);
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
			case InheritancePackage.SUPER_STRUCTURE2__SUPER_FIELD1_FROM2:
				return SUPER_FIELD1_FROM2_EDEFAULT == null ? superField1From2 != null : !SUPER_FIELD1_FROM2_EDEFAULT.equals(superField1From2);
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
		result.append(" (superField1From2: ");
		result.append(superField1From2);
		result.append(')');
		return result.toString();
	}

} //SuperStructure2Impl
