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
import org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Navigable To Not Navigable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotNavigableToNotNavigableImpl#getNotNavigableFrom <em>Not Navigable From</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotNavigableToNotNavigableImpl#getNotNavigableTo <em>Not Navigable To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotNavigableToNotNavigableImpl extends EObjectImpl implements NotNavigableToNotNavigable {
	/**
	 * The cached value of the '{@link #getNotNavigableFrom() <em>Not Navigable From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotNavigableFrom()
	 * @generated
	 * @ordered
	 */
	protected A10 notNavigableFrom;

	/**
	 * The cached value of the '{@link #getNotNavigableTo() <em>Not Navigable To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotNavigableTo()
	 * @generated
	 * @ordered
	 */
	protected B10 notNavigableTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotNavigableToNotNavigableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case010Package.Literals.NOT_NAVIGABLE_TO_NOT_NAVIGABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 getNotNavigableFrom() {
		if (notNavigableFrom != null && notNavigableFrom.eIsProxy()) {
			InternalEObject oldNotNavigableFrom = (InternalEObject)notNavigableFrom;
			notNavigableFrom = (A10)eResolveProxy(oldNotNavigableFrom);
			if (notNavigableFrom != oldNotNavigableFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM, oldNotNavigableFrom, notNavigableFrom));
			}
		}
		return notNavigableFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 basicGetNotNavigableFrom() {
		return notNavigableFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotNavigableFrom(A10 newNotNavigableFrom) {
		A10 oldNotNavigableFrom = notNavigableFrom;
		notNavigableFrom = newNotNavigableFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM, oldNotNavigableFrom, notNavigableFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 getNotNavigableTo() {
		if (notNavigableTo != null && notNavigableTo.eIsProxy()) {
			InternalEObject oldNotNavigableTo = (InternalEObject)notNavigableTo;
			notNavigableTo = (B10)eResolveProxy(oldNotNavigableTo);
			if (notNavigableTo != oldNotNavigableTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO, oldNotNavigableTo, notNavigableTo));
			}
		}
		return notNavigableTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 basicGetNotNavigableTo() {
		return notNavigableTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotNavigableTo(B10 newNotNavigableTo) {
		B10 oldNotNavigableTo = notNavigableTo;
		notNavigableTo = newNotNavigableTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO, oldNotNavigableTo, notNavigableTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM:
				if (resolve) return getNotNavigableFrom();
				return basicGetNotNavigableFrom();
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO:
				if (resolve) return getNotNavigableTo();
				return basicGetNotNavigableTo();
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
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM:
				setNotNavigableFrom((A10)newValue);
				return;
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO:
				setNotNavigableTo((B10)newValue);
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
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM:
				setNotNavigableFrom((A10)null);
				return;
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO:
				setNotNavigableTo((B10)null);
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
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM:
				return notNavigableFrom != null;
			case Case010Package.NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO:
				return notNavigableTo != null;
		}
		return super.eIsSet(featureID);
	}

} //NotNavigableToNotNavigableImpl
