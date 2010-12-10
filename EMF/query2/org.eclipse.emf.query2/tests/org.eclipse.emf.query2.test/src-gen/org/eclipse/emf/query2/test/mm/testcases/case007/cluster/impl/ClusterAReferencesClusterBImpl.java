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
package org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterA;
import org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB;
import org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterB;
import org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Cluster B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAReferencesClusterBImpl#getClusterB <em>Cluster B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAReferencesClusterBImpl#getClusterA <em>Cluster A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClusterAReferencesClusterBImpl extends EObjectImpl implements ClusterAReferencesClusterB {
	/**
	 * The cached value of the '{@link #getClusterB() <em>Cluster B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterB()
	 * @generated
	 * @ordered
	 */
	protected ClusterB clusterB;

	/**
	 * The cached value of the '{@link #getClusterA() <em>Cluster A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClusterA()
	 * @generated
	 * @ordered
	 */
	protected EList<ClusterA> clusterA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClusterAReferencesClusterBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClusterPackage.Literals.CLUSTER_AREFERENCES_CLUSTER_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterB getClusterB() {
		if (clusterB != null && clusterB.eIsProxy()) {
			InternalEObject oldClusterB = (InternalEObject)clusterB;
			clusterB = (ClusterB)eResolveProxy(oldClusterB);
			if (clusterB != oldClusterB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B, oldClusterB, clusterB));
			}
		}
		return clusterB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClusterB basicGetClusterB() {
		return clusterB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClusterB(ClusterB newClusterB) {
		ClusterB oldClusterB = clusterB;
		clusterB = newClusterB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B, oldClusterB, clusterB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClusterA> getClusterA() {
		if (clusterA == null) {
			clusterA = new EObjectResolvingEList<ClusterA>(ClusterA.class, this, ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A);
		}
		return clusterA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B:
				if (resolve) return getClusterB();
				return basicGetClusterB();
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A:
				return getClusterA();
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
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B:
				setClusterB((ClusterB)newValue);
				return;
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A:
				getClusterA().clear();
				getClusterA().addAll((Collection<? extends ClusterA>)newValue);
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
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B:
				setClusterB((ClusterB)null);
				return;
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A:
				getClusterA().clear();
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
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B:
				return clusterB != null;
			case ClusterPackage.CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A:
				return clusterA != null && !clusterA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClusterAReferencesClusterBImpl
