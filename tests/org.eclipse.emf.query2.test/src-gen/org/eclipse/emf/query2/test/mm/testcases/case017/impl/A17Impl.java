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
package org.eclipse.emf.query2.test.mm.testcases.case017.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case017.A17;
import org.eclipse.emf.query2.test.mm.testcases.case017.Case017Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A17</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case017.impl.A17Impl#getToEnd <em>To End</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case017.impl.A17Impl#getFromEnd <em>From End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A17Impl extends EObjectImpl implements A17 {
	/**
	 * The cached value of the '{@link #getToEnd() <em>To End</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<A17> toEnd;

	/**
	 * The cached value of the '{@link #getFromEnd() <em>From End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromEnd()
	 * @generated
	 * @ordered
	 */
	protected A17 fromEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A17Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case017Package.Literals.A17;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A17> getToEnd() {
		if (toEnd == null) {
			toEnd = new EObjectContainmentEList.Resolving<A17>(A17.class, this, Case017Package.A17__TO_END);
		}
		return toEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A17 getFromEnd() {
		if (fromEnd != null && fromEnd.eIsProxy()) {
			InternalEObject oldFromEnd = (InternalEObject)fromEnd;
			fromEnd = (A17)eResolveProxy(oldFromEnd);
			if (fromEnd != oldFromEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case017Package.A17__FROM_END, oldFromEnd, fromEnd));
			}
		}
		return fromEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A17 basicGetFromEnd() {
		return fromEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromEnd(A17 newFromEnd) {
		A17 oldFromEnd = fromEnd;
		fromEnd = newFromEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case017Package.A17__FROM_END, oldFromEnd, fromEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case017Package.A17__TO_END:
				return ((InternalEList<?>)getToEnd()).basicRemove(otherEnd, msgs);
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
			case Case017Package.A17__TO_END:
				return getToEnd();
			case Case017Package.A17__FROM_END:
				if (resolve) return getFromEnd();
				return basicGetFromEnd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Case017Package.A17__TO_END:
				getToEnd().clear();
				getToEnd().addAll((Collection<? extends A17>)newValue);
				return;
			case Case017Package.A17__FROM_END:
				setFromEnd((A17)newValue);
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
			case Case017Package.A17__TO_END:
				getToEnd().clear();
				return;
			case Case017Package.A17__FROM_END:
				setFromEnd((A17)null);
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
			case Case017Package.A17__TO_END:
				return toEnd != null && !toEnd.isEmpty();
			case Case017Package.A17__FROM_END:
				return fromEnd != null;
		}
		return super.eIsSet(featureID);
	}

} //A17Impl
