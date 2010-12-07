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
package org.eclipse.emf.query2.test.mm.testcases.case004.impl;

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

import org.eclipse.emf.query2.test.mm.testcases.case004.C4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.F4;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>F4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl#getOneC <em>One C</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl#getManyCs <em>Many Cs</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl#getManyCsOrdered <em>Many Cs Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class F4Impl extends EObjectImpl implements F4 {
	/**
	 * The cached value of the '{@link #getOneC() <em>One C</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneC()
	 * @generated
	 * @ordered
	 */
	protected C4 oneC;

	/**
	 * The cached value of the '{@link #getManyCs() <em>Many Cs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyCs()
	 * @generated
	 * @ordered
	 */
	protected EList<C4> manyCs;

	/**
	 * The cached value of the '{@link #getManyCsOrdered() <em>Many Cs Ordered</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyCsOrdered()
	 * @generated
	 * @ordered
	 */
	protected EList<C4> manyCsOrdered;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected F4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.F4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C4 getOneC() {
		if (oneC != null && oneC.eIsProxy()) {
			InternalEObject oldOneC = (InternalEObject)oneC;
			oneC = (C4)eResolveProxy(oldOneC);
			if (oneC != oldOneC) {
				InternalEObject newOneC = (InternalEObject)oneC;
				NotificationChain msgs = oldOneC.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.F4__ONE_C, null, null);
				if (newOneC.eInternalContainer() == null) {
					msgs = newOneC.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.F4__ONE_C, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.F4__ONE_C, oldOneC, oneC));
			}
		}
		return oneC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C4 basicGetOneC() {
		return oneC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneC(C4 newOneC, NotificationChain msgs) {
		C4 oldOneC = oneC;
		oneC = newOneC;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.F4__ONE_C, oldOneC, newOneC);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneC(C4 newOneC) {
		if (newOneC != oneC) {
			NotificationChain msgs = null;
			if (oneC != null)
				msgs = ((InternalEObject)oneC).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.F4__ONE_C, null, msgs);
			if (newOneC != null)
				msgs = ((InternalEObject)newOneC).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.F4__ONE_C, null, msgs);
			msgs = basicSetOneC(newOneC, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.F4__ONE_C, newOneC, newOneC));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C4> getManyCs() {
		if (manyCs == null) {
			manyCs = new EObjectContainmentEList.Resolving<C4>(C4.class, this, Case004Package.F4__MANY_CS);
		}
		return manyCs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C4> getManyCsOrdered() {
		if (manyCsOrdered == null) {
			manyCsOrdered = new EObjectContainmentEList.Resolving<C4>(C4.class, this, Case004Package.F4__MANY_CS_ORDERED);
		}
		return manyCsOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case004Package.F4__ONE_C:
				return basicSetOneC(null, msgs);
			case Case004Package.F4__MANY_CS:
				return ((InternalEList<?>)getManyCs()).basicRemove(otherEnd, msgs);
			case Case004Package.F4__MANY_CS_ORDERED:
				return ((InternalEList<?>)getManyCsOrdered()).basicRemove(otherEnd, msgs);
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
			case Case004Package.F4__ONE_C:
				if (resolve) return getOneC();
				return basicGetOneC();
			case Case004Package.F4__MANY_CS:
				return getManyCs();
			case Case004Package.F4__MANY_CS_ORDERED:
				return getManyCsOrdered();
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
			case Case004Package.F4__ONE_C:
				setOneC((C4)newValue);
				return;
			case Case004Package.F4__MANY_CS:
				getManyCs().clear();
				getManyCs().addAll((Collection<? extends C4>)newValue);
				return;
			case Case004Package.F4__MANY_CS_ORDERED:
				getManyCsOrdered().clear();
				getManyCsOrdered().addAll((Collection<? extends C4>)newValue);
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
			case Case004Package.F4__ONE_C:
				setOneC((C4)null);
				return;
			case Case004Package.F4__MANY_CS:
				getManyCs().clear();
				return;
			case Case004Package.F4__MANY_CS_ORDERED:
				getManyCsOrdered().clear();
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
			case Case004Package.F4__ONE_C:
				return oneC != null;
			case Case004Package.F4__MANY_CS:
				return manyCs != null && !manyCs.isEmpty();
			case Case004Package.F4__MANY_CS_ORDERED:
				return manyCsOrdered != null && !manyCsOrdered.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //F4Impl
