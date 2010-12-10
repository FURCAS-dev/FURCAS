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
package org.eclipse.emf.query2.test.mm.testcases.case007.top.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.top.TopA;
import org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB;
import org.eclipse.emf.query2.test.mm.testcases.case007.top.TopB;
import org.eclipse.emf.query2.test.mm.testcases.case007.top.TopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Top B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAReferencesTopBImpl#getTopB <em>Top B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAReferencesTopBImpl#getTopA <em>Top A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopAReferencesTopBImpl extends EObjectImpl implements TopAReferencesTopB {
	/**
	 * The cached value of the '{@link #getTopB() <em>Top B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopB()
	 * @generated
	 * @ordered
	 */
	protected TopB topB;

	/**
	 * The cached value of the '{@link #getTopA() <em>Top A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopA()
	 * @generated
	 * @ordered
	 */
	protected EList<TopA> topA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopAReferencesTopBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopPackage.Literals.TOP_AREFERENCES_TOP_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopB getTopB() {
		if (topB != null && topB.eIsProxy()) {
			InternalEObject oldTopB = (InternalEObject)topB;
			topB = (TopB)eResolveProxy(oldTopB);
			if (topB != oldTopB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TopPackage.TOP_AREFERENCES_TOP_B__TOP_B, oldTopB, topB));
			}
		}
		return topB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopB basicGetTopB() {
		return topB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopB(TopB newTopB) {
		TopB oldTopB = topB;
		topB = newTopB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopPackage.TOP_AREFERENCES_TOP_B__TOP_B, oldTopB, topB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TopA> getTopA() {
		if (topA == null) {
			topA = new EObjectResolvingEList<TopA>(TopA.class, this, TopPackage.TOP_AREFERENCES_TOP_B__TOP_A);
		}
		return topA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_B:
				if (resolve) return getTopB();
				return basicGetTopB();
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_A:
				return getTopA();
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
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_B:
				setTopB((TopB)newValue);
				return;
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_A:
				getTopA().clear();
				getTopA().addAll((Collection<? extends TopA>)newValue);
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
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_B:
				setTopB((TopB)null);
				return;
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_A:
				getTopA().clear();
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
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_B:
				return topB != null;
			case TopPackage.TOP_AREFERENCES_TOP_B__TOP_A:
				return topA != null && !topA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TopAReferencesTopBImpl
