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
package org.eclipse.emf.query2.test.mm.testcases.case020.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case020.A20;
import org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package;
import org.eclipse.emf.query2.test.mm.testcases.case020.Super1;
import org.eclipse.emf.query2.test.mm.testcases.case020.Super2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A20</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl#getSuper1 <em>Super1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl#getSuper2 <em>Super2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl#getRefSuper1 <em>Ref Super1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl#getRefSuper2 <em>Ref Super2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A20Impl extends EObjectImpl implements A20 {
	/**
	 * The cached value of the '{@link #getSuper1() <em>Super1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper1()
	 * @generated
	 * @ordered
	 */
	protected Super1 super1;

	/**
	 * The cached value of the '{@link #getSuper2() <em>Super2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper2()
	 * @generated
	 * @ordered
	 */
	protected Super2 super2;

	/**
	 * The cached value of the '{@link #getRefSuper1() <em>Ref Super1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefSuper1()
	 * @generated
	 * @ordered
	 */
	protected Super1 refSuper1;

	/**
	 * The cached value of the '{@link #getRefSuper2() <em>Ref Super2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefSuper2()
	 * @generated
	 * @ordered
	 */
	protected Super2 refSuper2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A20Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case020Package.Literals.A20;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super1 getSuper1() {
		if (super1 != null && super1.eIsProxy()) {
			InternalEObject oldSuper1 = (InternalEObject)super1;
			super1 = (Super1)eResolveProxy(oldSuper1);
			if (super1 != oldSuper1) {
				InternalEObject newSuper1 = (InternalEObject)super1;
				NotificationChain msgs = oldSuper1.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER1, null, null);
				if (newSuper1.eInternalContainer() == null) {
					msgs = newSuper1.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER1, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case020Package.A20__SUPER1, oldSuper1, super1));
			}
		}
		return super1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super1 basicGetSuper1() {
		return super1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuper1(Super1 newSuper1, NotificationChain msgs) {
		Super1 oldSuper1 = super1;
		super1 = newSuper1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case020Package.A20__SUPER1, oldSuper1, newSuper1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuper1(Super1 newSuper1) {
		if (newSuper1 != super1) {
			NotificationChain msgs = null;
			if (super1 != null)
				msgs = ((InternalEObject)super1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER1, null, msgs);
			if (newSuper1 != null)
				msgs = ((InternalEObject)newSuper1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER1, null, msgs);
			msgs = basicSetSuper1(newSuper1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case020Package.A20__SUPER1, newSuper1, newSuper1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super2 getSuper2() {
		if (super2 != null && super2.eIsProxy()) {
			InternalEObject oldSuper2 = (InternalEObject)super2;
			super2 = (Super2)eResolveProxy(oldSuper2);
			if (super2 != oldSuper2) {
				InternalEObject newSuper2 = (InternalEObject)super2;
				NotificationChain msgs = oldSuper2.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER2, null, null);
				if (newSuper2.eInternalContainer() == null) {
					msgs = newSuper2.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER2, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case020Package.A20__SUPER2, oldSuper2, super2));
			}
		}
		return super2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super2 basicGetSuper2() {
		return super2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuper2(Super2 newSuper2, NotificationChain msgs) {
		Super2 oldSuper2 = super2;
		super2 = newSuper2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case020Package.A20__SUPER2, oldSuper2, newSuper2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuper2(Super2 newSuper2) {
		if (newSuper2 != super2) {
			NotificationChain msgs = null;
			if (super2 != null)
				msgs = ((InternalEObject)super2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER2, null, msgs);
			if (newSuper2 != null)
				msgs = ((InternalEObject)newSuper2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case020Package.A20__SUPER2, null, msgs);
			msgs = basicSetSuper2(newSuper2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case020Package.A20__SUPER2, newSuper2, newSuper2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super1 getRefSuper1() {
		if (refSuper1 != null && refSuper1.eIsProxy()) {
			InternalEObject oldRefSuper1 = (InternalEObject)refSuper1;
			refSuper1 = (Super1)eResolveProxy(oldRefSuper1);
			if (refSuper1 != oldRefSuper1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case020Package.A20__REF_SUPER1, oldRefSuper1, refSuper1));
			}
		}
		return refSuper1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super1 basicGetRefSuper1() {
		return refSuper1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefSuper1(Super1 newRefSuper1) {
		Super1 oldRefSuper1 = refSuper1;
		refSuper1 = newRefSuper1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case020Package.A20__REF_SUPER1, oldRefSuper1, refSuper1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super2 getRefSuper2() {
		if (refSuper2 != null && refSuper2.eIsProxy()) {
			InternalEObject oldRefSuper2 = (InternalEObject)refSuper2;
			refSuper2 = (Super2)eResolveProxy(oldRefSuper2);
			if (refSuper2 != oldRefSuper2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case020Package.A20__REF_SUPER2, oldRefSuper2, refSuper2));
			}
		}
		return refSuper2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Super2 basicGetRefSuper2() {
		return refSuper2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefSuper2(Super2 newRefSuper2) {
		Super2 oldRefSuper2 = refSuper2;
		refSuper2 = newRefSuper2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case020Package.A20__REF_SUPER2, oldRefSuper2, refSuper2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case020Package.A20__SUPER1:
				return basicSetSuper1(null, msgs);
			case Case020Package.A20__SUPER2:
				return basicSetSuper2(null, msgs);
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
			case Case020Package.A20__SUPER1:
				if (resolve) return getSuper1();
				return basicGetSuper1();
			case Case020Package.A20__SUPER2:
				if (resolve) return getSuper2();
				return basicGetSuper2();
			case Case020Package.A20__REF_SUPER1:
				if (resolve) return getRefSuper1();
				return basicGetRefSuper1();
			case Case020Package.A20__REF_SUPER2:
				if (resolve) return getRefSuper2();
				return basicGetRefSuper2();
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
			case Case020Package.A20__SUPER1:
				setSuper1((Super1)newValue);
				return;
			case Case020Package.A20__SUPER2:
				setSuper2((Super2)newValue);
				return;
			case Case020Package.A20__REF_SUPER1:
				setRefSuper1((Super1)newValue);
				return;
			case Case020Package.A20__REF_SUPER2:
				setRefSuper2((Super2)newValue);
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
			case Case020Package.A20__SUPER1:
				setSuper1((Super1)null);
				return;
			case Case020Package.A20__SUPER2:
				setSuper2((Super2)null);
				return;
			case Case020Package.A20__REF_SUPER1:
				setRefSuper1((Super1)null);
				return;
			case Case020Package.A20__REF_SUPER2:
				setRefSuper2((Super2)null);
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
			case Case020Package.A20__SUPER1:
				return super1 != null;
			case Case020Package.A20__SUPER2:
				return super2 != null;
			case Case020Package.A20__REF_SUPER1:
				return refSuper1 != null;
			case Case020Package.A20__REF_SUPER2:
				return refSuper2 != null;
		}
		return super.eIsSet(featureID);
	}

} //A20Impl
