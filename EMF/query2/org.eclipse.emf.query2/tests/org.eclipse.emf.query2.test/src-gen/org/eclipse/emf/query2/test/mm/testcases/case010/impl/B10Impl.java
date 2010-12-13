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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case010.A10;
import org.eclipse.emf.query2.test.mm.testcases.case010.B10;
import org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B10</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.B10Impl#getOneAChangeable <em>One AChangeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.B10Impl#getOneANotChangeable <em>One ANot Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B10Impl extends EObjectImpl implements B10 {
	/**
	 * The cached value of the '{@link #getOneAChangeable() <em>One AChangeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneAChangeable()
	 * @generated
	 * @ordered
	 */
	protected A10 oneAChangeable;

	/**
	 * The cached value of the '{@link #getOneANotChangeable() <em>One ANot Changeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneANotChangeable()
	 * @generated
	 * @ordered
	 */
	protected A10 oneANotChangeable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B10Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case010Package.Literals.B10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 getOneAChangeable() {
		if (oneAChangeable != null && oneAChangeable.eIsProxy()) {
			InternalEObject oldOneAChangeable = (InternalEObject)oneAChangeable;
			oneAChangeable = (A10)eResolveProxy(oldOneAChangeable);
			if (oneAChangeable != oldOneAChangeable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.B10__ONE_ACHANGEABLE, oldOneAChangeable, oneAChangeable));
			}
		}
		return oneAChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 basicGetOneAChangeable() {
		return oneAChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneAChangeable(A10 newOneAChangeable, NotificationChain msgs) {
		A10 oldOneAChangeable = oneAChangeable;
		oneAChangeable = newOneAChangeable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case010Package.B10__ONE_ACHANGEABLE, oldOneAChangeable, newOneAChangeable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneAChangeable(A10 newOneAChangeable) {
		if (newOneAChangeable != oneAChangeable) {
			NotificationChain msgs = null;
			if (oneAChangeable != null)
				msgs = ((InternalEObject)oneAChangeable).eInverseRemove(this, Case010Package.A10__MANY_BS_CHANGEABLE, A10.class, msgs);
			if (newOneAChangeable != null)
				msgs = ((InternalEObject)newOneAChangeable).eInverseAdd(this, Case010Package.A10__MANY_BS_CHANGEABLE, A10.class, msgs);
			msgs = basicSetOneAChangeable(newOneAChangeable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.B10__ONE_ACHANGEABLE, newOneAChangeable, newOneAChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 getOneANotChangeable() {
		if (oneANotChangeable != null && oneANotChangeable.eIsProxy()) {
			InternalEObject oldOneANotChangeable = (InternalEObject)oneANotChangeable;
			oneANotChangeable = (A10)eResolveProxy(oldOneANotChangeable);
			if (oneANotChangeable != oldOneANotChangeable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.B10__ONE_ANOT_CHANGEABLE, oldOneANotChangeable, oneANotChangeable));
			}
		}
		return oneANotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 basicGetOneANotChangeable() {
		return oneANotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneANotChangeable(A10 newOneANotChangeable, NotificationChain msgs) {
		A10 oldOneANotChangeable = oneANotChangeable;
		oneANotChangeable = newOneANotChangeable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case010Package.B10__ONE_ANOT_CHANGEABLE, oldOneANotChangeable, newOneANotChangeable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneANotChangeable(A10 newOneANotChangeable) {
		if (newOneANotChangeable != oneANotChangeable) {
			NotificationChain msgs = null;
			if (oneANotChangeable != null)
				msgs = ((InternalEObject)oneANotChangeable).eInverseRemove(this, Case010Package.A10__MANY_BS_NOT_CHANGEABLE, A10.class, msgs);
			if (newOneANotChangeable != null)
				msgs = ((InternalEObject)newOneANotChangeable).eInverseAdd(this, Case010Package.A10__MANY_BS_NOT_CHANGEABLE, A10.class, msgs);
			msgs = basicSetOneANotChangeable(newOneANotChangeable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.B10__ONE_ANOT_CHANGEABLE, newOneANotChangeable, newOneANotChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case010Package.B10__ONE_ACHANGEABLE:
				if (oneAChangeable != null)
					msgs = ((InternalEObject)oneAChangeable).eInverseRemove(this, Case010Package.A10__MANY_BS_CHANGEABLE, A10.class, msgs);
				return basicSetOneAChangeable((A10)otherEnd, msgs);
			case Case010Package.B10__ONE_ANOT_CHANGEABLE:
				if (oneANotChangeable != null)
					msgs = ((InternalEObject)oneANotChangeable).eInverseRemove(this, Case010Package.A10__MANY_BS_NOT_CHANGEABLE, A10.class, msgs);
				return basicSetOneANotChangeable((A10)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case010Package.B10__ONE_ACHANGEABLE:
				return basicSetOneAChangeable(null, msgs);
			case Case010Package.B10__ONE_ANOT_CHANGEABLE:
				return basicSetOneANotChangeable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case010Package.B10__ONE_ACHANGEABLE:
				if (resolve) return getOneAChangeable();
				return basicGetOneAChangeable();
			case Case010Package.B10__ONE_ANOT_CHANGEABLE:
				if (resolve) return getOneANotChangeable();
				return basicGetOneANotChangeable();
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
			case Case010Package.B10__ONE_ACHANGEABLE:
				setOneAChangeable((A10)newValue);
				return;
			case Case010Package.B10__ONE_ANOT_CHANGEABLE:
				setOneANotChangeable((A10)newValue);
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
			case Case010Package.B10__ONE_ACHANGEABLE:
				setOneAChangeable((A10)null);
				return;
			case Case010Package.B10__ONE_ANOT_CHANGEABLE:
				setOneANotChangeable((A10)null);
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
			case Case010Package.B10__ONE_ACHANGEABLE:
				return oneAChangeable != null;
			case Case010Package.B10__ONE_ANOT_CHANGEABLE:
				return oneANotChangeable != null;
		}
		return super.eIsSet(featureID);
	}

} //B10Impl
