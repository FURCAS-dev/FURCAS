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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case018.A18;
import org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A18</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.A18Impl#getFoundationAttributeA1f <em>Foundation Attribute A1f</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A18Impl extends EObjectImpl implements A18 {
	/**
	 * The cached value of the '{@link #getFoundationAttributeA1f() <em>Foundation Attribute A1f</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFoundationAttributeA1f()
	 * @generated
	 * @ordered
	 */
	protected A1f foundationAttributeA1f;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A18Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case018Package.Literals.A18;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A1f getFoundationAttributeA1f() {
		if (foundationAttributeA1f != null && foundationAttributeA1f.eIsProxy()) {
			InternalEObject oldFoundationAttributeA1f = (InternalEObject)foundationAttributeA1f;
			foundationAttributeA1f = (A1f)eResolveProxy(oldFoundationAttributeA1f);
			if (foundationAttributeA1f != oldFoundationAttributeA1f) {
				InternalEObject newFoundationAttributeA1f = (InternalEObject)foundationAttributeA1f;
				NotificationChain msgs = oldFoundationAttributeA1f.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, null, null);
				if (newFoundationAttributeA1f.eInternalContainer() == null) {
					msgs = newFoundationAttributeA1f.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, oldFoundationAttributeA1f, foundationAttributeA1f));
			}
		}
		return foundationAttributeA1f;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A1f basicGetFoundationAttributeA1f() {
		return foundationAttributeA1f;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFoundationAttributeA1f(A1f newFoundationAttributeA1f, NotificationChain msgs) {
		A1f oldFoundationAttributeA1f = foundationAttributeA1f;
		foundationAttributeA1f = newFoundationAttributeA1f;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, oldFoundationAttributeA1f, newFoundationAttributeA1f);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFoundationAttributeA1f(A1f newFoundationAttributeA1f) {
		if (newFoundationAttributeA1f != foundationAttributeA1f) {
			NotificationChain msgs = null;
			if (foundationAttributeA1f != null)
				msgs = ((InternalEObject)foundationAttributeA1f).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, null, msgs);
			if (newFoundationAttributeA1f != null)
				msgs = ((InternalEObject)newFoundationAttributeA1f).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, null, msgs);
			msgs = basicSetFoundationAttributeA1f(newFoundationAttributeA1f, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F, newFoundationAttributeA1f, newFoundationAttributeA1f));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F:
				return basicSetFoundationAttributeA1f(null, msgs);
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
			case Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F:
				if (resolve) return getFoundationAttributeA1f();
				return basicGetFoundationAttributeA1f();
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
			case Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F:
				setFoundationAttributeA1f((A1f)newValue);
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
			case Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F:
				setFoundationAttributeA1f((A1f)null);
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
			case Case018Package.A18__FOUNDATION_ATTRIBUTE_A1F:
				return foundationAttributeA1f != null;
		}
		return super.eIsSet(featureID);
	}

} //A18Impl
