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
package org.eclipse.emf.query2.test.mm.testcases.case006.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case006.B6;
import org.eclipse.emf.query2.test.mm.testcases.case006.C6;
import org.eclipse.emf.query2.test.mm.testcases.case006.Case006Package;
import org.eclipse.emf.query2.test.mm.testcases.case006.D6;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>C6</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.C6Impl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.C6Impl#getW <em>W</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class C6Impl extends EObjectImpl implements C6 {
	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected B6 x;

	/**
	 * The cached value of the '{@link #getW() <em>W</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getW()
	 * @generated
	 * @ordered
	 */
	protected D6 w;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected C6Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case006Package.Literals.C6;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B6 getX() {
		if (x != null && x.eIsProxy()) {
			InternalEObject oldX = (InternalEObject)x;
			x = (B6)eResolveProxy(oldX);
			if (x != oldX) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case006Package.C6__X, oldX, x));
			}
		}
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B6 basicGetX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(B6 newX) {
		B6 oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case006Package.C6__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D6 getW() {
		if (w != null && w.eIsProxy()) {
			InternalEObject oldW = (InternalEObject)w;
			w = (D6)eResolveProxy(oldW);
			if (w != oldW) {
				InternalEObject newW = (InternalEObject)w;
				NotificationChain msgs = oldW.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case006Package.C6__W, null, null);
				if (newW.eInternalContainer() == null) {
					msgs = newW.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case006Package.C6__W, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case006Package.C6__W, oldW, w));
			}
		}
		return w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public D6 basicGetW() {
		return w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetW(D6 newW, NotificationChain msgs) {
		D6 oldW = w;
		w = newW;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case006Package.C6__W, oldW, newW);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setW(D6 newW) {
		if (newW != w) {
			NotificationChain msgs = null;
			if (w != null)
				msgs = ((InternalEObject)w).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case006Package.C6__W, null, msgs);
			if (newW != null)
				msgs = ((InternalEObject)newW).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case006Package.C6__W, null, msgs);
			msgs = basicSetW(newW, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case006Package.C6__W, newW, newW));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case006Package.C6__W:
				return basicSetW(null, msgs);
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
			case Case006Package.C6__X:
				if (resolve) return getX();
				return basicGetX();
			case Case006Package.C6__W:
				if (resolve) return getW();
				return basicGetW();
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
			case Case006Package.C6__X:
				setX((B6)newValue);
				return;
			case Case006Package.C6__W:
				setW((D6)newValue);
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
			case Case006Package.C6__X:
				setX((B6)null);
				return;
			case Case006Package.C6__W:
				setW((D6)null);
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
			case Case006Package.C6__X:
				return x != null;
			case Case006Package.C6__W:
				return w != null;
		}
		return super.eIsSet(featureID);
	}

} //C6Impl
