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
package org.eclipse.emf.query2.test.mm.testcases.case012.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case012.A12;
import org.eclipse.emf.query2.test.mm.testcases.case012.Case012Package;
import org.eclipse.emf.query2.test.mm.testcases.case012.D12;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A12</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.A12Impl#getAttributeD12 <em>Attribute D12</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A12Impl extends EObjectImpl implements A12 {
	/**
	 * The cached value of the '{@link #getAttributeD12() <em>Attribute D12</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeD12()
	 * @generated
	 * @ordered
	 */
	protected D12 attributeD12;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A12Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case012Package.Literals.A12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D12 getAttributeD12() {
		if (attributeD12 != null && attributeD12.eIsProxy()) {
			InternalEObject oldAttributeD12 = (InternalEObject)attributeD12;
			attributeD12 = (D12)eResolveProxy(oldAttributeD12);
			if (attributeD12 != oldAttributeD12) {
				InternalEObject newAttributeD12 = (InternalEObject)attributeD12;
				NotificationChain msgs = oldAttributeD12.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case012Package.A12__ATTRIBUTE_D12, null, null);
				if (newAttributeD12.eInternalContainer() == null) {
					msgs = newAttributeD12.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case012Package.A12__ATTRIBUTE_D12, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case012Package.A12__ATTRIBUTE_D12, oldAttributeD12, attributeD12));
			}
		}
		return attributeD12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D12 basicGetAttributeD12() {
		return attributeD12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAttributeD12(D12 newAttributeD12, NotificationChain msgs) {
		D12 oldAttributeD12 = attributeD12;
		attributeD12 = newAttributeD12;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case012Package.A12__ATTRIBUTE_D12, oldAttributeD12, newAttributeD12);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeD12(D12 newAttributeD12) {
		if (newAttributeD12 != attributeD12) {
			NotificationChain msgs = null;
			if (attributeD12 != null)
				msgs = ((InternalEObject)attributeD12).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case012Package.A12__ATTRIBUTE_D12, null, msgs);
			if (newAttributeD12 != null)
				msgs = ((InternalEObject)newAttributeD12).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case012Package.A12__ATTRIBUTE_D12, null, msgs);
			msgs = basicSetAttributeD12(newAttributeD12, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case012Package.A12__ATTRIBUTE_D12, newAttributeD12, newAttributeD12));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D12 operationWithObjectParameters(D12 paramD12) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A12 operationWithThisAsReturnParameter() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D12 operationGetAttributeD12() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case012Package.A12__ATTRIBUTE_D12:
				return basicSetAttributeD12(null, msgs);
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
			case Case012Package.A12__ATTRIBUTE_D12:
				if (resolve) return getAttributeD12();
				return basicGetAttributeD12();
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
			case Case012Package.A12__ATTRIBUTE_D12:
				setAttributeD12((D12)newValue);
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
			case Case012Package.A12__ATTRIBUTE_D12:
				setAttributeD12((D12)null);
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
			case Case012Package.A12__ATTRIBUTE_D12:
				return attributeD12 != null;
		}
		return super.eIsSet(featureID);
	}

} //A12Impl
