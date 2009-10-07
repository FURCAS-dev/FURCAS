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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredA;
import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB;
import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredB;
import org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Clustered B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAReferencesClusteredBImpl#getClusteredB <em>Clustered B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAReferencesClusteredBImpl#getClusteredA <em>Clustered A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClusteredAReferencesClusteredBImpl extends EObjectImpl implements ClusteredAReferencesClusteredB {
	/**
	 * The cached value of the '{@link #getClusteredB() <em>Clustered B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusteredB()
	 * @generated
	 * @ordered
	 */
	protected ClusteredB clusteredB;

	/**
	 * The cached value of the '{@link #getClusteredA() <em>Clustered A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusteredA()
	 * @generated
	 * @ordered
	 */
	protected EList<ClusteredA> clusteredA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClusteredAReferencesClusteredBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClusteredPackage.Literals.CLUSTERED_AREFERENCES_CLUSTERED_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredB getClusteredB() {
		if (clusteredB != null && clusteredB.eIsProxy()) {
			InternalEObject oldClusteredB = (InternalEObject)clusteredB;
			clusteredB = (ClusteredB)eResolveProxy(oldClusteredB);
			if (clusteredB != oldClusteredB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B, oldClusteredB, clusteredB));
			}
		}
		return clusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusteredB basicGetClusteredB() {
		return clusteredB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusteredB(ClusteredB newClusteredB) {
		ClusteredB oldClusteredB = clusteredB;
		clusteredB = newClusteredB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B, oldClusteredB, clusteredB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClusteredA> getClusteredA() {
		if (clusteredA == null) {
			clusteredA = new EObjectResolvingEList<ClusteredA>(ClusteredA.class, this, ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A);
		}
		return clusteredA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B:
				if (resolve) return getClusteredB();
				return basicGetClusteredB();
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A:
				return getClusteredA();
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
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B:
				setClusteredB((ClusteredB)newValue);
				return;
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A:
				getClusteredA().clear();
				getClusteredA().addAll((Collection<? extends ClusteredA>)newValue);
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
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B:
				setClusteredB((ClusteredB)null);
				return;
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A:
				getClusteredA().clear();
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
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B:
				return clusteredB != null;
			case ClusteredPackage.CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A:
				return clusteredA != null && !clusteredA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClusteredAReferencesClusteredBImpl
