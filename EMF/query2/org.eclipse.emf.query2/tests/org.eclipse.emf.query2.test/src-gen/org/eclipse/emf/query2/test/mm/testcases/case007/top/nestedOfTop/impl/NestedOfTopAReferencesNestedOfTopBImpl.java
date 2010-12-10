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
package org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopA;
import org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB;
import org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopB;
import org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Nested Of Top B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAReferencesNestedOfTopBImpl#getNestedOfTopB <em>Nested Of Top B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAReferencesNestedOfTopBImpl#getNestedOfTopA <em>Nested Of Top A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NestedOfTopAReferencesNestedOfTopBImpl extends EObjectImpl implements NestedOfTopAReferencesNestedOfTopB {
	/**
	 * The cached value of the '{@link #getNestedOfTopB() <em>Nested Of Top B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedOfTopB()
	 * @generated
	 * @ordered
	 */
	protected NestedOfTopB nestedOfTopB;

	/**
	 * The cached value of the '{@link #getNestedOfTopA() <em>Nested Of Top A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedOfTopA()
	 * @generated
	 * @ordered
	 */
	protected EList<NestedOfTopA> nestedOfTopA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NestedOfTopAReferencesNestedOfTopBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NestedOfTopPackage.Literals.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedOfTopB getNestedOfTopB() {
		if (nestedOfTopB != null && nestedOfTopB.eIsProxy()) {
			InternalEObject oldNestedOfTopB = (InternalEObject)nestedOfTopB;
			nestedOfTopB = (NestedOfTopB)eResolveProxy(oldNestedOfTopB);
			if (nestedOfTopB != oldNestedOfTopB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B, oldNestedOfTopB, nestedOfTopB));
			}
		}
		return nestedOfTopB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedOfTopB basicGetNestedOfTopB() {
		return nestedOfTopB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedOfTopB(NestedOfTopB newNestedOfTopB) {
		NestedOfTopB oldNestedOfTopB = nestedOfTopB;
		nestedOfTopB = newNestedOfTopB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B, oldNestedOfTopB, nestedOfTopB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NestedOfTopA> getNestedOfTopA() {
		if (nestedOfTopA == null) {
			nestedOfTopA = new EObjectResolvingEList<NestedOfTopA>(NestedOfTopA.class, this, NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A);
		}
		return nestedOfTopA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B:
				if (resolve) return getNestedOfTopB();
				return basicGetNestedOfTopB();
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A:
				return getNestedOfTopA();
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
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B:
				setNestedOfTopB((NestedOfTopB)newValue);
				return;
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A:
				getNestedOfTopA().clear();
				getNestedOfTopA().addAll((Collection<? extends NestedOfTopA>)newValue);
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
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B:
				setNestedOfTopB((NestedOfTopB)null);
				return;
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A:
				getNestedOfTopA().clear();
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
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B:
				return nestedOfTopB != null;
			case NestedOfTopPackage.NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A:
				return nestedOfTopA != null && !nestedOfTopA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NestedOfTopAReferencesNestedOfTopBImpl
