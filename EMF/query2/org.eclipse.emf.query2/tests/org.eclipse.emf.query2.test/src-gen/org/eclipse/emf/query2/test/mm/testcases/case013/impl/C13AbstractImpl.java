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

import org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract;
import org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C13 Abstract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13AbstractImpl#getAttribute1 <em>Attribute1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class C13AbstractImpl extends EObjectImpl implements C13Abstract {
	/**
	 * The default value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTRIBUTE1_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected double attribute1 = ATTRIBUTE1_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected C13AbstractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case013Package.Literals.C13_ABSTRACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttribute1() {
		return attribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute1(double newAttribute1) {
		double oldAttribute1 = attribute1;
		attribute1 = newAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case013Package.C13_ABSTRACT__ATTRIBUTE1, oldAttribute1, attribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case013Package.C13_ABSTRACT__ATTRIBUTE1:
				return getAttribute1();
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
			case Case013Package.C13_ABSTRACT__ATTRIBUTE1:
				setAttribute1((Double)newValue);
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
			case Case013Package.C13_ABSTRACT__ATTRIBUTE1:
				setAttribute1(ATTRIBUTE1_EDEFAULT);
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
			case Case013Package.C13_ABSTRACT__ATTRIBUTE1:
				return attribute1 != ATTRIBUTE1_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //C13AbstractImpl
