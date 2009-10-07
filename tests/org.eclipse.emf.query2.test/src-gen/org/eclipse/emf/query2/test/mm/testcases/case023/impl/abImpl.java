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
import org.eclipse.emf.query2.test.mm.testcases.case023.B23;
import org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package;
import org.eclipse.emf.query2.test.mm.testcases.case023.ab;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ab</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.abImpl#getAToB <em>ATo B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.abImpl#getBToA <em>BTo A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class abImpl extends EObjectImpl implements ab {
	/**
	 * The cached value of the '{@link #getAToB() <em>ATo B</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAToB()
	 * @generated
	 * @ordered
	 */
	protected EList<B23> aToB;

	/**
	 * The cached value of the '{@link #getBToA() <em>BTo A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBToA()
	 * @generated
	 * @ordered
	 */
	protected EList<A23> bToA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected abImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case023Package.Literals.AB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B23> getAToB() {
		if (aToB == null) {
			aToB = new EObjectResolvingEList<B23>(B23.class, this, Case023Package.AB__ATO_B);
		}
		return aToB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A23> getBToA() {
		if (bToA == null) {
			bToA = new EObjectResolvingEList<A23>(A23.class, this, Case023Package.AB__BTO_A);
		}
		return bToA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case023Package.AB__ATO_B:
				return getAToB();
			case Case023Package.AB__BTO_A:
				return getBToA();
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
			case Case023Package.AB__ATO_B:
				getAToB().clear();
				getAToB().addAll((Collection<? extends B23>)newValue);
				return;
			case Case023Package.AB__BTO_A:
				getBToA().clear();
				getBToA().addAll((Collection<? extends A23>)newValue);
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
			case Case023Package.AB__ATO_B:
				getAToB().clear();
				return;
			case Case023Package.AB__BTO_A:
				getBToA().clear();
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
			case Case023Package.AB__ATO_B:
				return aToB != null && !aToB.isEmpty();
			case Case023Package.AB__BTO_A:
				return bToA != null && !bToA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //abImpl
