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
package org.eclipse.emf.query2.test.mm.testcases.case010.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case010.A10;
import org.eclipse.emf.query2.test.mm.testcases.case010.B10;
import org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package;
import org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Changeable To Not Changeable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableToNotChangeableImpl#getNotChangeableFromB <em>Not Changeable From B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableToNotChangeableImpl#getNotChangeableFromA <em>Not Changeable From A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotChangeableToNotChangeableImpl extends EObjectImpl implements NotChangeableToNotChangeable {
	/**
	 * The cached value of the '{@link #getNotChangeableFromB() <em>Not Changeable From B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotChangeableFromB()
	 * @generated
	 * @ordered
	 */
	protected A10 notChangeableFromB;

	/**
	 * The cached value of the '{@link #getNotChangeableFromA() <em>Not Changeable From A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotChangeableFromA()
	 * @generated
	 * @ordered
	 */
	protected B10 notChangeableFromA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotChangeableToNotChangeableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case010Package.Literals.NOT_CHANGEABLE_TO_NOT_CHANGEABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 getNotChangeableFromB() {
		if (notChangeableFromB != null && notChangeableFromB.eIsProxy()) {
			InternalEObject oldNotChangeableFromB = (InternalEObject)notChangeableFromB;
			notChangeableFromB = (A10)eResolveProxy(oldNotChangeableFromB);
			if (notChangeableFromB != oldNotChangeableFromB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B, oldNotChangeableFromB, notChangeableFromB));
			}
		}
		return notChangeableFromB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 basicGetNotChangeableFromB() {
		return notChangeableFromB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotChangeableFromB(A10 newNotChangeableFromB) {
		A10 oldNotChangeableFromB = notChangeableFromB;
		notChangeableFromB = newNotChangeableFromB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B, oldNotChangeableFromB, notChangeableFromB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 getNotChangeableFromA() {
		if (notChangeableFromA != null && notChangeableFromA.eIsProxy()) {
			InternalEObject oldNotChangeableFromA = (InternalEObject)notChangeableFromA;
			notChangeableFromA = (B10)eResolveProxy(oldNotChangeableFromA);
			if (notChangeableFromA != oldNotChangeableFromA) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A, oldNotChangeableFromA, notChangeableFromA));
			}
		}
		return notChangeableFromA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 basicGetNotChangeableFromA() {
		return notChangeableFromA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotChangeableFromA(B10 newNotChangeableFromA) {
		B10 oldNotChangeableFromA = notChangeableFromA;
		notChangeableFromA = newNotChangeableFromA;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A, oldNotChangeableFromA, notChangeableFromA));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B:
				if (resolve) return getNotChangeableFromB();
				return basicGetNotChangeableFromB();
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A:
				if (resolve) return getNotChangeableFromA();
				return basicGetNotChangeableFromA();
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
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B:
				setNotChangeableFromB((A10)newValue);
				return;
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A:
				setNotChangeableFromA((B10)newValue);
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
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B:
				setNotChangeableFromB((A10)null);
				return;
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A:
				setNotChangeableFromA((B10)null);
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
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B:
				return notChangeableFromB != null;
			case Case010Package.NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A:
				return notChangeableFromA != null;
		}
		return super.eIsSet(featureID);
	}

} //NotChangeableToNotChangeableImpl
