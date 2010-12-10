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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case004.C4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.F4;
import org.eclipse.emf.query2.test.mm.testcases.case004.hasCs;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>has Cs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.hasCsImpl#getF <em>F</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.hasCsImpl#getC <em>C</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class hasCsImpl extends EObjectImpl implements hasCs {
	/**
	 * The cached value of the '{@link #getF() <em>F</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getF()
	 * @generated
	 * @ordered
	 */
	protected F4 f;

	/**
	 * The cached value of the '{@link #getC() <em>C</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC()
	 * @generated
	 * @ordered
	 */
	protected EList<C4> c;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected hasCsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.HAS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public F4 getF() {
		if (f != null && f.eIsProxy()) {
			InternalEObject oldF = (InternalEObject)f;
			f = (F4)eResolveProxy(oldF);
			if (f != oldF) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.HAS_CS__F, oldF, f));
			}
		}
		return f;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public F4 basicGetF() {
		return f;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setF(F4 newF) {
		F4 oldF = f;
		f = newF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.HAS_CS__F, oldF, f));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C4> getC() {
		if (c == null) {
			c = new EObjectResolvingEList<C4>(C4.class, this, Case004Package.HAS_CS__C);
		}
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case004Package.HAS_CS__F:
				if (resolve) return getF();
				return basicGetF();
			case Case004Package.HAS_CS__C:
				return getC();
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
			case Case004Package.HAS_CS__F:
				setF((F4)newValue);
				return;
			case Case004Package.HAS_CS__C:
				getC().clear();
				getC().addAll((Collection<? extends C4>)newValue);
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
			case Case004Package.HAS_CS__F:
				setF((F4)null);
				return;
			case Case004Package.HAS_CS__C:
				getC().clear();
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
			case Case004Package.HAS_CS__F:
				return f != null;
			case Case004Package.HAS_CS__C:
				return c != null && !c.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //hasCsImpl
