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
package org.eclipse.emf.query2.test.mm.testcases.case023.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case023.C23;
import org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package;
import org.eclipse.emf.query2.test.mm.testcases.case023.cc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>cc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.ccImpl#getDependents <em>Dependents</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.ccImpl#getC23 <em>C23</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ccImpl extends EObjectImpl implements cc {
	/**
	 * The cached value of the '{@link #getDependents() <em>Dependents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependents()
	 * @generated
	 * @ordered
	 */
	protected EList<C23> dependents;

	/**
	 * The cached value of the '{@link #getC23() <em>C23</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getC23()
	 * @generated
	 * @ordered
	 */
	protected C23 c23;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ccImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case023Package.Literals.CC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C23> getDependents() {
		if (dependents == null) {
			dependents = new EObjectResolvingEList<C23>(C23.class, this, Case023Package.CC__DEPENDENTS);
		}
		return dependents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C23 getC23() {
		if (c23 != null && c23.eIsProxy()) {
			InternalEObject oldC23 = (InternalEObject)c23;
			c23 = (C23)eResolveProxy(oldC23);
			if (c23 != oldC23) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case023Package.CC__C23, oldC23, c23));
			}
		}
		return c23;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C23 basicGetC23() {
		return c23;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setC23(C23 newC23) {
		C23 oldC23 = c23;
		c23 = newC23;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case023Package.CC__C23, oldC23, c23));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case023Package.CC__DEPENDENTS:
				return getDependents();
			case Case023Package.CC__C23:
				if (resolve) return getC23();
				return basicGetC23();
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
			case Case023Package.CC__DEPENDENTS:
				getDependents().clear();
				getDependents().addAll((Collection<? extends C23>)newValue);
				return;
			case Case023Package.CC__C23:
				setC23((C23)newValue);
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
			case Case023Package.CC__DEPENDENTS:
				getDependents().clear();
				return;
			case Case023Package.CC__C23:
				setC23((C23)null);
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
			case Case023Package.CC__DEPENDENTS:
				return dependents != null && !dependents.isEmpty();
			case Case023Package.CC__C23:
				return c23 != null;
		}
		return super.eIsSet(featureID);
	}

} //ccImpl
