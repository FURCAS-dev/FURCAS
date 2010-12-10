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

import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage;
import org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Structure1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.SubStructure1Impl#getSubField1 <em>Sub Field1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubStructure1Impl extends SuperStructure1Impl implements SubStructure1 {
	/**
	 * The default value of the '{@link #getSubField1() <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField1()
	 * @generated
	 * @ordered
	 */
	protected static final float SUB_FIELD1_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSubField1() <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubField1()
	 * @generated
	 * @ordered
	 */
	protected float subField1 = SUB_FIELD1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubStructure1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InheritancePackage.Literals.SUB_STRUCTURE1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSubField1() {
		return subField1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubField1(float newSubField1) {
		float oldSubField1 = subField1;
		subField1 = newSubField1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InheritancePackage.SUB_STRUCTURE1__SUB_FIELD1, oldSubField1, subField1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InheritancePackage.SUB_STRUCTURE1__SUB_FIELD1:
				return getSubField1();
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
			case InheritancePackage.SUB_STRUCTURE1__SUB_FIELD1:
				setSubField1((Float)newValue);
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
			case InheritancePackage.SUB_STRUCTURE1__SUB_FIELD1:
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
			case InheritancePackage.SUB_STRUCTURE1__SUB_FIELD1:
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

} //SubStructure1Impl
