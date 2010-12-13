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

import org.eclipse.emf.query2.test.mm.testcases.case023.B23;
import org.eclipse.emf.query2.test.mm.testcases.case023.C23;
import org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package;
import org.eclipse.emf.query2.test.mm.testcases.case023.bc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>bc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.bcImpl#getBToC <em>BTo C</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.bcImpl#getCToB <em>CTo B</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class bcImpl extends EObjectImpl implements bc {
	/**
	 * The cached value of the '{@link #getBToC() <em>BTo C</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBToC()
	 * @generated
	 * @ordered
	 */
	protected EList<C23> bToC;

	/**
	 * The cached value of the '{@link #getCToB() <em>CTo B</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCToB()
	 * @generated
	 * @ordered
	 */
	protected EList<B23> cToB;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected bcImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case023Package.Literals.BC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<C23> getBToC() {
		if (bToC == null) {
			bToC = new EObjectResolvingEList<C23>(C23.class, this, Case023Package.BC__BTO_C);
		}
		return bToC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B23> getCToB() {
		if (cToB == null) {
			cToB = new EObjectResolvingEList<B23>(B23.class, this, Case023Package.BC__CTO_B);
		}
		return cToB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case023Package.BC__BTO_C:
				return getBToC();
			case Case023Package.BC__CTO_B:
				return getCToB();
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
			case Case023Package.BC__BTO_C:
				getBToC().clear();
				getBToC().addAll((Collection<? extends C23>)newValue);
				return;
			case Case023Package.BC__CTO_B:
				getCToB().clear();
				getCToB().addAll((Collection<? extends B23>)newValue);
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
			case Case023Package.BC__BTO_C:
				getBToC().clear();
				return;
			case Case023Package.BC__CTO_B:
				getCToB().clear();
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
			case Case023Package.BC__BTO_C:
				return bToC != null && !bToC.isEmpty();
			case Case023Package.BC__CTO_B:
				return cToB != null && !cToB.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //bcImpl
