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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB;
import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredPackage;
import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredA;
import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Nested Of Clustered B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredAReferencesNestedOfClusteredBImpl#getNestedOfClusteredB <em>Nested Of Clustered B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredAReferencesNestedOfClusteredBImpl#getNestedOfClusteredA <em>Nested Of Clustered A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NestedOfClusteredAReferencesNestedOfClusteredBImpl extends EObjectImpl implements NestedOfClusteredAReferencesNestedOfClusteredB {
	/**
	 * The cached value of the '{@link #getNestedOfClusteredB() <em>Nested Of Clustered B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedOfClusteredB()
	 * @generated
	 * @ordered
	 */
	protected nestedOfClusteredB nestedOfClusteredB;

	/**
	 * The cached value of the '{@link #getNestedOfClusteredA() <em>Nested Of Clustered A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNestedOfClusteredA()
	 * @generated
	 * @ordered
	 */
	protected EList<nestedOfClusteredA> nestedOfClusteredA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NestedOfClusteredAReferencesNestedOfClusteredBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NestedOfClusteredPackage.Literals.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public nestedOfClusteredB getNestedOfClusteredB() {
		if (nestedOfClusteredB != null && nestedOfClusteredB.eIsProxy()) {
			InternalEObject oldNestedOfClusteredB = (InternalEObject)nestedOfClusteredB;
			nestedOfClusteredB = (nestedOfClusteredB)eResolveProxy(oldNestedOfClusteredB);
			if (nestedOfClusteredB != oldNestedOfClusteredB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B, oldNestedOfClusteredB, nestedOfClusteredB));
			}
		}
		return nestedOfClusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public nestedOfClusteredB basicGetNestedOfClusteredB() {
		return nestedOfClusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNestedOfClusteredB(nestedOfClusteredB newNestedOfClusteredB) {
		nestedOfClusteredB oldNestedOfClusteredB = nestedOfClusteredB;
		nestedOfClusteredB = newNestedOfClusteredB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B, oldNestedOfClusteredB, nestedOfClusteredB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<nestedOfClusteredA> getNestedOfClusteredA() {
		if (nestedOfClusteredA == null) {
			nestedOfClusteredA = new EObjectResolvingEList<nestedOfClusteredA>(nestedOfClusteredA.class, this, NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A);
		}
		return nestedOfClusteredA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B:
				if (resolve) return getNestedOfClusteredB();
				return basicGetNestedOfClusteredB();
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A:
				return getNestedOfClusteredA();
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
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B:
				setNestedOfClusteredB((nestedOfClusteredB)newValue);
				return;
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A:
				getNestedOfClusteredA().clear();
				getNestedOfClusteredA().addAll((Collection<? extends nestedOfClusteredA>)newValue);
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
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B:
				setNestedOfClusteredB((nestedOfClusteredB)null);
				return;
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A:
				getNestedOfClusteredA().clear();
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
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B:
				return nestedOfClusteredB != null;
			case NestedOfClusteredPackage.NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A:
				return nestedOfClusteredA != null && !nestedOfClusteredA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NestedOfClusteredAReferencesNestedOfClusteredBImpl
