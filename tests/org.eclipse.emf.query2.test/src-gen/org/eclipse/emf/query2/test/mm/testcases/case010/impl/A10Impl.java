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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case010.A10;
import org.eclipse.emf.query2.test.mm.testcases.case010.B10;
import org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A10</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl#getManyBsOrdered <em>Many Bs Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl#getManyBsChangeable <em>Many Bs Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl#getNavigable <em>Navigable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A10Impl extends EObjectImpl implements A10 {
	/**
	 * The cached value of the '{@link #getManyBsNotChangeable() <em>Many Bs Not Changeable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected EList<B10> manyBsNotChangeable;

	/**
	 * The cached value of the '{@link #getManyBsOrdered() <em>Many Bs Ordered</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsOrdered()
	 * @generated
	 * @ordered
	 */
	protected EList<B10> manyBsOrdered;

	/**
	 * The cached value of the '{@link #getManyBsChangeable() <em>Many Bs Changeable</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsChangeable()
	 * @generated
	 * @ordered
	 */
	protected EList<B10> manyBsChangeable;

	/**
	 * The cached value of the '{@link #getNavigable() <em>Navigable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNavigable()
	 * @generated
	 * @ordered
	 */
	protected B10 navigable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A10Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case010Package.Literals.A10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B10> getManyBsNotChangeable() {
		if (manyBsNotChangeable == null) {
			manyBsNotChangeable = new EObjectWithInverseResolvingEList<B10>(B10.class, this, Case010Package.A10__MANY_BS_NOT_CHANGEABLE, Case010Package.B10__ONE_ANOT_CHANGEABLE);
		}
		return manyBsNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B10> getManyBsOrdered() {
		if (manyBsOrdered == null) {
			manyBsOrdered = new EObjectResolvingEList<B10>(B10.class, this, Case010Package.A10__MANY_BS_ORDERED);
		}
		return manyBsOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B10> getManyBsChangeable() {
		if (manyBsChangeable == null) {
			manyBsChangeable = new EObjectWithInverseResolvingEList<B10>(B10.class, this, Case010Package.A10__MANY_BS_CHANGEABLE, Case010Package.B10__ONE_ACHANGEABLE);
		}
		return manyBsChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 getNavigable() {
		if (navigable != null && navigable.eIsProxy()) {
			InternalEObject oldNavigable = (InternalEObject)navigable;
			navigable = (B10)eResolveProxy(oldNavigable);
			if (navigable != oldNavigable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case010Package.A10__NAVIGABLE, oldNavigable, navigable));
			}
		}
		return navigable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B10 basicGetNavigable() {
		return navigable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNavigable(B10 newNavigable) {
		B10 oldNavigable = navigable;
		navigable = newNavigable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case010Package.A10__NAVIGABLE, oldNavigable, navigable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case010Package.A10__MANY_BS_NOT_CHANGEABLE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getManyBsNotChangeable()).basicAdd(otherEnd, msgs);
			case Case010Package.A10__MANY_BS_CHANGEABLE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getManyBsChangeable()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case010Package.A10__MANY_BS_NOT_CHANGEABLE:
				return ((InternalEList<?>)getManyBsNotChangeable()).basicRemove(otherEnd, msgs);
			case Case010Package.A10__MANY_BS_CHANGEABLE:
				return ((InternalEList<?>)getManyBsChangeable()).basicRemove(otherEnd, msgs);
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
			case Case010Package.A10__MANY_BS_NOT_CHANGEABLE:
				return getManyBsNotChangeable();
			case Case010Package.A10__MANY_BS_ORDERED:
				return getManyBsOrdered();
			case Case010Package.A10__MANY_BS_CHANGEABLE:
				return getManyBsChangeable();
			case Case010Package.A10__NAVIGABLE:
				if (resolve) return getNavigable();
				return basicGetNavigable();
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
			case Case010Package.A10__MANY_BS_NOT_CHANGEABLE:
				getManyBsNotChangeable().clear();
				getManyBsNotChangeable().addAll((Collection<? extends B10>)newValue);
				return;
			case Case010Package.A10__MANY_BS_ORDERED:
				getManyBsOrdered().clear();
				getManyBsOrdered().addAll((Collection<? extends B10>)newValue);
				return;
			case Case010Package.A10__MANY_BS_CHANGEABLE:
				getManyBsChangeable().clear();
				getManyBsChangeable().addAll((Collection<? extends B10>)newValue);
				return;
			case Case010Package.A10__NAVIGABLE:
				setNavigable((B10)newValue);
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
			case Case010Package.A10__MANY_BS_NOT_CHANGEABLE:
				getManyBsNotChangeable().clear();
				return;
			case Case010Package.A10__MANY_BS_ORDERED:
				getManyBsOrdered().clear();
				return;
			case Case010Package.A10__MANY_BS_CHANGEABLE:
				getManyBsChangeable().clear();
				return;
			case Case010Package.A10__NAVIGABLE:
				setNavigable((B10)null);
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
			case Case010Package.A10__MANY_BS_NOT_CHANGEABLE:
				return manyBsNotChangeable != null && !manyBsNotChangeable.isEmpty();
			case Case010Package.A10__MANY_BS_ORDERED:
				return manyBsOrdered != null && !manyBsOrdered.isEmpty();
			case Case010Package.A10__MANY_BS_CHANGEABLE:
				return manyBsChangeable != null && !manyBsChangeable.isEmpty();
			case Case010Package.A10__NAVIGABLE:
				return navigable != null;
		}
		return super.eIsSet(featureID);
	}

} //A10Impl
