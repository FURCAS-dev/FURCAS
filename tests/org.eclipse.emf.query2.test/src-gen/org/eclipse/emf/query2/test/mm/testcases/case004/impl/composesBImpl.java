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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case004.B4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.F4;
import org.eclipse.emf.query2.test.mm.testcases.case004.composesB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>composes B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesBImpl#getMyB <em>My B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesBImpl#getMyF <em>My F</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class composesBImpl extends EObjectImpl implements composesB {
	/**
	 * The cached value of the '{@link #getMyB() <em>My B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMyB()
	 * @generated
	 * @ordered
	 */
	protected B4 myB;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected composesBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.COMPOSES_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 getMyB() {
		if (myB != null && myB.eIsProxy()) {
			InternalEObject oldMyB = (InternalEObject)myB;
			myB = (B4)eResolveProxy(oldMyB);
			if (myB != oldMyB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.COMPOSES_B__MY_B, oldMyB, myB));
			}
		}
		return myB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 basicGetMyB() {
		return myB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMyB(B4 newMyB) {
		B4 oldMyB = myB;
		myB = newMyB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.COMPOSES_B__MY_B, oldMyB, myB));
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
				NotificationChain msgs = oldMyF.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_B__MY_F, null, null);
				if (newMyF.eInternalContainer() == null) {
					msgs = newMyF.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_B__MY_F, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.COMPOSES_B__MY_F, oldMyF, myF));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.COMPOSES_B__MY_F, oldMyF, newMyF);
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
				msgs = ((InternalEObject)myF).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_B__MY_F, null, msgs);
			if (newMyF != null)
				msgs = ((InternalEObject)newMyF).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.COMPOSES_B__MY_F, null, msgs);
			msgs = basicSetMyF(newMyF, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.COMPOSES_B__MY_F, newMyF, newMyF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case004Package.COMPOSES_B__MY_F:
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
			case Case004Package.COMPOSES_B__MY_B:
				if (resolve) return getMyB();
				return basicGetMyB();
			case Case004Package.COMPOSES_B__MY_F:
				if (resolve) return getMyF();
				return basicGetMyF();
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
			case Case004Package.COMPOSES_B__MY_B:
				setMyB((B4)newValue);
				return;
			case Case004Package.COMPOSES_B__MY_F:
				setMyF((F4)newValue);
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
			case Case004Package.COMPOSES_B__MY_B:
				setMyB((B4)null);
				return;
			case Case004Package.COMPOSES_B__MY_F:
				setMyF((F4)null);
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
			case Case004Package.COMPOSES_B__MY_B:
				return myB != null;
			case Case004Package.COMPOSES_B__MY_F:
				return myF != null;
		}
		return super.eIsSet(featureID);
	}

} //composesBImpl
