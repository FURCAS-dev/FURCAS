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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case004.C4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.F4;
import org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>composes Cs Ordered</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsOrderedImpl#getMyF <em>My F</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsOrderedImpl#getMyCsOrdered <em>My Cs Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class composesCsOrderedImpl extends EObjectImpl implements composesCsOrdered {
	/**
	 * The cached value of the '{@link #getMyF() <em>My F</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyF()
	 * @generated
	 * @ordered
	 */
	protected F4 myF;

	/**
	 * The cached value of the '{@link #getMyCsOrdered() <em>My Cs Ordered</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyCsOrdered()
	 * @generated
	 * @ordered
	 */
	protected EList<C4> myCsOrdered;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected composesCsOrderedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.COMPOSES_CS_ORDERED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public F4 getMyF() {
		if (myF != null && myF.eIsProxy()) {
			InternalEObject oldMyF = (InternalEObject)myF;
			myF = (F4)eResolveProxy(oldMyF);
			if (myF != oldMyF) {
				InternalEObject newMyF = (InternalEObject)myF;
				NotificationChain msgs = oldMyF.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_CS_ORDERED__MY_F, null, null);
				if (newMyF.eInternalContainer() == null) {
					msgs = newMyF.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_CS_ORDERED__MY_F, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.COMPOSES_CS_ORDERED__MY_F, oldMyF, myF));
			}
		}
		return myF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public F4 basicGetMyF() {
		return myF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMyF(F4 newMyF, NotificationChain msgs) {
		F4 oldMyF = myF;
		myF = newMyF;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.COMPOSES_CS_ORDERED__MY_F, oldMyF, newMyF);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyF(F4 newMyF) {
		if (newMyF != myF) {
			NotificationChain msgs = null;
			if (myF != null)
				msgs = ((InternalEObject)myF).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_CS_ORDERED__MY_F, null, msgs);
			if (newMyF != null)
				msgs = ((InternalEObject)newMyF).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_CS_ORDERED__MY_F, null, msgs);
			msgs = basicSetMyF(newMyF, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.COMPOSES_CS_ORDERED__MY_F, newMyF, newMyF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C4> getMyCsOrdered() {
		if (myCsOrdered == null) {
			myCsOrdered = new EObjectResolvingEList<C4>(C4.class, this, Case004Package.COMPOSES_CS_ORDERED__MY_CS_ORDERED);
		}
		return myCsOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case004Package.COMPOSES_CS_ORDERED__MY_F:
				return basicSetMyF(null, msgs);
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
			case Case004Package.COMPOSES_CS_ORDERED__MY_F:
				if (resolve) return getMyF();
				return basicGetMyF();
			case Case004Package.COMPOSES_CS_ORDERED__MY_CS_ORDERED:
				return getMyCsOrdered();
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
			case Case004Package.COMPOSES_CS_ORDERED__MY_F:
				setMyF((F4)newValue);
				return;
			case Case004Package.COMPOSES_CS_ORDERED__MY_CS_ORDERED:
				getMyCsOrdered().clear();
				getMyCsOrdered().addAll((Collection<? extends C4>)newValue);
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
			case Case004Package.COMPOSES_CS_ORDERED__MY_F:
				setMyF((F4)null);
				return;
			case Case004Package.COMPOSES_CS_ORDERED__MY_CS_ORDERED:
				getMyCsOrdered().clear();
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
			case Case004Package.COMPOSES_CS_ORDERED__MY_F:
				return myF != null;
			case Case004Package.COMPOSES_CS_ORDERED__MY_CS_ORDERED:
				return myCsOrdered != null && !myCsOrdered.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //composesCsOrderedImpl
