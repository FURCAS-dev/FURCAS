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
package org.eclipse.emf.query2.test.mm.testcases.case008.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package;
import org.eclipse.emf.query2.test.mm.testcases.case008.V8;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>V8</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.impl.V8Impl#getStructure1 <em>Structure1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class V8Impl extends EObjectImpl implements V8 {
	/**
	 * The cached value of the '{@link #getStructure1() <em>Structure1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructure1()
	 * @generated
	 * @ordered
	 */
	protected V8 structure1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected V8Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case008Package.Literals.V8;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public V8 getStructure1() {
		if (structure1 != null && structure1.eIsProxy()) {
			InternalEObject oldStructure1 = (InternalEObject)structure1;
			structure1 = (V8)eResolveProxy(oldStructure1);
			if (structure1 != oldStructure1) {
				InternalEObject newStructure1 = (InternalEObject)structure1;
				NotificationChain msgs = oldStructure1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case008Package.V8__STRUCTURE1, null, null);
				if (newStructure1.eInternalContainer() == null) {
					msgs = newStructure1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case008Package.V8__STRUCTURE1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case008Package.V8__STRUCTURE1, oldStructure1, structure1));
			}
		}
		return structure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public V8 basicGetStructure1() {
		return structure1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructure1(V8 newStructure1, NotificationChain msgs) {
		V8 oldStructure1 = structure1;
		structure1 = newStructure1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case008Package.V8__STRUCTURE1, oldStructure1, newStructure1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructure1(V8 newStructure1) {
		if (newStructure1 != structure1) {
			NotificationChain msgs = null;
			if (structure1 != null)
				msgs = ((InternalEObject)structure1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case008Package.V8__STRUCTURE1, null, msgs);
			if (newStructure1 != null)
				msgs = ((InternalEObject)newStructure1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case008Package.V8__STRUCTURE1, null, msgs);
			msgs = basicSetStructure1(newStructure1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case008Package.V8__STRUCTURE1, newStructure1, newStructure1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case008Package.V8__STRUCTURE1:
				return basicSetStructure1(null, msgs);
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
			case Case008Package.V8__STRUCTURE1:
				if (resolve) return getStructure1();
				return basicGetStructure1();
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
			case Case008Package.V8__STRUCTURE1:
				setStructure1((V8)newValue);
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
			case Case008Package.V8__STRUCTURE1:
				setStructure1((V8)null);
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
			case Case008Package.V8__STRUCTURE1:
				return structure1 != null;
		}
		return super.eIsSet(featureID);
	}

} //V8Impl
