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
import org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not Changeable And Navigable To Not Changeable And Navigable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableAndNavigableToNotChangeableAndNavigableImpl#getNotChangeableAndNavigableFrom <em>Not Changeable And Navigable From</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableAndNavigableToNotChangeableAndNavigableImpl#getNotChangeableAndNavigableTo <em>Not Changeable And Navigable To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotChangeableAndNavigableToNotChangeableAndNavigableImpl extends EObjectImpl implements NotChangeableAndNavigableToNotChangeableAndNavigable {
	/**
	 * The cached value of the '{@link #getNotChangeableAndNavigableFrom() <em>Not Changeable And Navigable From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotChangeableAndNavigableFrom()
	 * @generated
	 * @ordered
	 */
	protected A10 notChangeableAndNavigableFrom;

	/**
	 * The cached value of the '{@link #getNotChangeableAndNavigableTo() <em>Not Changeable And Navigable To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotChangeableAndNavigableTo()
	 * @generated
	 * @ordered
	 */
	protected B10 notChangeableAndNavigableTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotChangeableAndNavigableToNotChangeableAndNavigableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case010Package.Literals.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 getNotChangeableAndNavigableFrom() {
		if (notChangeableAndNavigableFrom != null && notChangeableAndNavigableFrom.eIsProxy()) {
			InternalEObject oldNotChangeableAndNavigableFrom = (InternalEObject)notChangeableAndNavigableFrom;
			notChangeableAndNavigableFrom = (A10)eResolveProxy(oldNotChangeableAndNavigableFrom);
			if (notChangeableAndNavigableFrom != oldNotChangeableAndNavigableFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM, oldNotChangeableAndNavigableFrom, notChangeableAndNavigableFrom));
			}
		}
		return notChangeableAndNavigableFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A10 basicGetNotChangeableAndNavigableFrom() {
		return notChangeableAndNavigableFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotChangeableAndNavigableFrom(A10 newNotChangeableAndNavigableFrom) {
		A10 oldNotChangeableAndNavigableFrom = notChangeableAndNavigableFrom;
		notChangeableAndNavigableFrom = newNotChangeableAndNavigableFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM, oldNotChangeableAndNavigableFrom, notChangeableAndNavigableFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 getNotChangeableAndNavigableTo() {
		if (notChangeableAndNavigableTo != null && notChangeableAndNavigableTo.eIsProxy()) {
			InternalEObject oldNotChangeableAndNavigableTo = (InternalEObject)notChangeableAndNavigableTo;
			notChangeableAndNavigableTo = (B10)eResolveProxy(oldNotChangeableAndNavigableTo);
			if (notChangeableAndNavigableTo != oldNotChangeableAndNavigableTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO, oldNotChangeableAndNavigableTo, notChangeableAndNavigableTo));
			}
		}
		return notChangeableAndNavigableTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 basicGetNotChangeableAndNavigableTo() {
		return notChangeableAndNavigableTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotChangeableAndNavigableTo(B10 newNotChangeableAndNavigableTo) {
		B10 oldNotChangeableAndNavigableTo = notChangeableAndNavigableTo;
		notChangeableAndNavigableTo = newNotChangeableAndNavigableTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO, oldNotChangeableAndNavigableTo, notChangeableAndNavigableTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM:
				if (resolve) return getNotChangeableAndNavigableFrom();
				return basicGetNotChangeableAndNavigableFrom();
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO:
				if (resolve) return getNotChangeableAndNavigableTo();
				return basicGetNotChangeableAndNavigableTo();
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
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM:
				setNotChangeableAndNavigableFrom((A10)newValue);
				return;
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO:
				setNotChangeableAndNavigableTo((B10)newValue);
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
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM:
				setNotChangeableAndNavigableFrom((A10)null);
				return;
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO:
				setNotChangeableAndNavigableTo((B10)null);
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
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM:
				return notChangeableAndNavigableFrom != null;
			case Case010Package.NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO:
				return notChangeableAndNavigableTo != null;
		}
		return super.eIsSet(featureID);
	}

} //NotChangeableAndNavigableToNotChangeableAndNavigableImpl
