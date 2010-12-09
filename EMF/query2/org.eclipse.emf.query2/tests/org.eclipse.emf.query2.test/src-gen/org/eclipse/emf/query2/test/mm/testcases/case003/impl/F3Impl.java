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
package org.eclipse.emf.query2.test.mm.testcases.case003.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case003.B3;
import org.eclipse.emf.query2.test.mm.testcases.case003.Case003Package;
import org.eclipse.emf.query2.test.mm.testcases.case003.D3;
import org.eclipse.emf.query2.test.mm.testcases.case003.E3;
import org.eclipse.emf.query2.test.mm.testcases.case003.F3;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>F3</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.F3Impl#getRefD3ToY <em>Ref D3 To Y</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class F3Impl extends C3Impl implements F3 {
	/**
	 * The cached value of the '{@link #getRefD3ToY() <em>Ref D3 To Y</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefD3ToY()
	 * @generated
	 * @ordered
	 */
	protected EList<B3> refD3ToY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected F3Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case003Package.Literals.F3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B3> getRefD3ToY() {
		if (refD3ToY == null) {
			refD3ToY = new EObjectResolvingEList<B3>(B3.class, this, Case003Package.F3__REF_D3_TO_Y);
		}
		return refD3ToY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case003Package.F3__REF_D3_TO_Y:
				return getRefD3ToY();
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
			case Case003Package.F3__REF_D3_TO_Y:
				getRefD3ToY().clear();
				getRefD3ToY().addAll((Collection<? extends B3>)newValue);
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
			case Case003Package.F3__REF_D3_TO_Y:
				getRefD3ToY().clear();
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
			case Case003Package.F3__REF_D3_TO_Y:
				return refD3ToY != null && !refD3ToY.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == D3.class) {
			switch (derivedFeatureID) {
				case Case003Package.F3__REF_D3_TO_Y: return Case003Package.D3__REF_D3_TO_Y;
				default: return -1;
			}
		}
		if (baseClass == E3.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == D3.class) {
			switch (baseFeatureID) {
				case Case003Package.D3__REF_D3_TO_Y: return Case003Package.F3__REF_D3_TO_Y;
				default: return -1;
			}
		}
		if (baseClass == E3.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //F3Impl
