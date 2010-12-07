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
import org.eclipse.emf.query2.test.mm.testcases.case023.C23;
import org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package;
import org.eclipse.emf.query2.test.mm.testcases.case023.ac;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ac</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.acImpl#getAToC <em>ATo C</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.acImpl#getCToA <em>CTo A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class acImpl extends EObjectImpl implements ac {
	/**
	 * The cached value of the '{@link #getAToC() <em>ATo C</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAToC()
	 * @generated
	 * @ordered
	 */
	protected EList<C23> aToC;

	/**
	 * The cached value of the '{@link #getCToA() <em>CTo A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCToA()
	 * @generated
	 * @ordered
	 */
	protected EList<A23> cToA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected acImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case023Package.Literals.AC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C23> getAToC() {
		if (aToC == null) {
			aToC = new EObjectResolvingEList<C23>(C23.class, this, Case023Package.AC__ATO_C);
		}
		return aToC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<A23> getCToA() {
		if (cToA == null) {
			cToA = new EObjectResolvingEList<A23>(A23.class, this, Case023Package.AC__CTO_A);
		}
		return cToA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case023Package.AC__ATO_C:
				return getAToC();
			case Case023Package.AC__CTO_A:
				return getCToA();
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
			case Case023Package.AC__ATO_C:
				getAToC().clear();
				getAToC().addAll((Collection<? extends C23>)newValue);
				return;
			case Case023Package.AC__CTO_A:
				getCToA().clear();
				getCToA().addAll((Collection<? extends A23>)newValue);
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
			case Case023Package.AC__ATO_C:
				getAToC().clear();
				return;
			case Case023Package.AC__CTO_A:
				getCToA().clear();
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
			case Case023Package.AC__ATO_C:
				return aToC != null && !aToC.isEmpty();
			case Case023Package.AC__CTO_A:
				return cToA != null && !cToA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //acImpl
