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
package org.eclipse.emf.query2.test.mm.testcases.case018.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case018.A18;
import org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package;
import org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>uses A1 From Foundation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.usesA1FromFoundationImpl#getA1FromFoundation <em>A1 From Foundation</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.usesA1FromFoundationImpl#getA18 <em>A18</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class usesA1FromFoundationImpl extends EObjectImpl implements usesA1FromFoundation {
	/**
	 * The cached value of the '{@link #getA1FromFoundation() <em>A1 From Foundation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA1FromFoundation()
	 * @generated
	 * @ordered
	 */
	protected A1f a1FromFoundation;

	/**
	 * The cached value of the '{@link #getA18() <em>A18</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getA18()
	 * @generated
	 * @ordered
	 */
	protected A18 a18;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected usesA1FromFoundationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case018Package.Literals.USES_A1_FROM_FOUNDATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A1f getA1FromFoundation() {
		if (a1FromFoundation != null && a1FromFoundation.eIsProxy()) {
			InternalEObject oldA1FromFoundation = (InternalEObject)a1FromFoundation;
			a1FromFoundation = (A1f)eResolveProxy(oldA1FromFoundation);
			if (a1FromFoundation != oldA1FromFoundation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case018Package.USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION, oldA1FromFoundation, a1FromFoundation));
			}
		}
		return a1FromFoundation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A1f basicGetA1FromFoundation() {
		return a1FromFoundation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setA1FromFoundation(A1f newA1FromFoundation) {
		A1f oldA1FromFoundation = a1FromFoundation;
		a1FromFoundation = newA1FromFoundation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case018Package.USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION, oldA1FromFoundation, a1FromFoundation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A18 getA18() {
		if (a18 != null && a18.eIsProxy()) {
			InternalEObject oldA18 = (InternalEObject)a18;
			a18 = (A18)eResolveProxy(oldA18);
			if (a18 != oldA18) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case018Package.USES_A1_FROM_FOUNDATION__A18, oldA18, a18));
			}
		}
		return a18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A18 basicGetA18() {
		return a18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setA18(A18 newA18) {
		A18 oldA18 = a18;
		a18 = newA18;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case018Package.USES_A1_FROM_FOUNDATION__A18, oldA18, a18));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case018Package.USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION:
				if (resolve) return getA1FromFoundation();
				return basicGetA1FromFoundation();
			case Case018Package.USES_A1_FROM_FOUNDATION__A18:
				if (resolve) return getA18();
				return basicGetA18();
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
			case Case018Package.USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION:
				setA1FromFoundation((A1f)newValue);
				return;
			case Case018Package.USES_A1_FROM_FOUNDATION__A18:
				setA18((A18)newValue);
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
			case Case018Package.USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION:
				setA1FromFoundation((A1f)null);
				return;
			case Case018Package.USES_A1_FROM_FOUNDATION__A18:
				setA18((A18)null);
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
			case Case018Package.USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION:
				return a1FromFoundation != null;
			case Case018Package.USES_A1_FROM_FOUNDATION__A18:
				return a18 != null;
		}
		return super.eIsSet(featureID);
	}

} //usesA1FromFoundationImpl
