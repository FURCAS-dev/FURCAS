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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case023.A23;
import org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package;
import org.eclipse.emf.query2.test.mm.testcases.case023.aa;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>aa</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.aaImpl#getADown <em>ADown</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.aaImpl#getAUp <em>AUp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class aaImpl extends EObjectImpl implements aa {
	/**
	 * The cached value of the '{@link #getADown() <em>ADown</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getADown()
	 * @generated
	 * @ordered
	 */
	protected EList<A23> aDown;

	/**
	 * The cached value of the '{@link #getAUp() <em>AUp</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAUp()
	 * @generated
	 * @ordered
	 */
	protected EList<A23> aUp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected aaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case023Package.Literals.AA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A23> getADown() {
		if (aDown == null) {
			aDown = new EObjectResolvingEList<A23>(A23.class, this, Case023Package.AA__ADOWN);
		}
		return aDown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A23> getAUp() {
		if (aUp == null) {
			aUp = new EObjectResolvingEList<A23>(A23.class, this, Case023Package.AA__AUP);
		}
		return aUp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case023Package.AA__ADOWN:
				return getADown();
			case Case023Package.AA__AUP:
				return getAUp();
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
			case Case023Package.AA__ADOWN:
				getADown().clear();
				getADown().addAll((Collection<? extends A23>)newValue);
				return;
			case Case023Package.AA__AUP:
				getAUp().clear();
				getAUp().addAll((Collection<? extends A23>)newValue);
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
			case Case023Package.AA__ADOWN:
				getADown().clear();
				return;
			case Case023Package.AA__AUP:
				getAUp().clear();
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
			case Case023Package.AA__ADOWN:
				return aDown != null && !aDown.isEmpty();
			case Case023Package.AA__AUP:
				return aUp != null && !aUp.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //aaImpl
