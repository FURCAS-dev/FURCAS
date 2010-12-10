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
package org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.A5;

import org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2;
import org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.D5;
import org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.P4Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.Association2Impl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.Association2Impl#getD5 <em>D5</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Association2Impl extends EObjectImpl implements Association2 {
	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected A5 y;

	/**
	 * The cached value of the '{@link #getD5() <em>D5</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getD5()
	 * @generated
	 * @ordered
	 */
	protected D5 d5;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Association2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P4Package.Literals.ASSOCIATION2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A5 getY() {
		if (y != null && y.eIsProxy()) {
			InternalEObject oldY = (InternalEObject)y;
			y = (A5)eResolveProxy(oldY);
			if (y != oldY) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P4Package.ASSOCIATION2__Y, oldY, y));
			}
		}
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A5 basicGetY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(A5 newY) {
		A5 oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P4Package.ASSOCIATION2__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D5 getD5() {
		if (d5 != null && d5.eIsProxy()) {
			InternalEObject oldD5 = (InternalEObject)d5;
			d5 = (D5)eResolveProxy(oldD5);
			if (d5 != oldD5) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P4Package.ASSOCIATION2__D5, oldD5, d5));
			}
		}
		return d5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D5 basicGetD5() {
		return d5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setD5(D5 newD5) {
		D5 oldD5 = d5;
		d5 = newD5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P4Package.ASSOCIATION2__D5, oldD5, d5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P4Package.ASSOCIATION2__Y:
				if (resolve) return getY();
				return basicGetY();
			case P4Package.ASSOCIATION2__D5:
				if (resolve) return getD5();
				return basicGetD5();
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
			case P4Package.ASSOCIATION2__Y:
				setY((A5)newValue);
				return;
			case P4Package.ASSOCIATION2__D5:
				setD5((D5)newValue);
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
			case P4Package.ASSOCIATION2__Y:
				setY((A5)null);
				return;
			case P4Package.ASSOCIATION2__D5:
				setD5((D5)null);
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
			case P4Package.ASSOCIATION2__Y:
				return y != null;
			case P4Package.ASSOCIATION2__D5:
				return d5 != null;
		}
		return super.eIsSet(featureID);
	}

} //Association2Impl
