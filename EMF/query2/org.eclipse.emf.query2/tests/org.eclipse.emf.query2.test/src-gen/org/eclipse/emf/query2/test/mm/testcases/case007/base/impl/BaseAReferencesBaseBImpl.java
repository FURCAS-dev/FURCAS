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
package org.eclipse.emf.query2.test.mm.testcases.case007.base.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseA;
import org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB;
import org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseB;
import org.eclipse.emf.query2.test.mm.testcases.case007.base.BasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Base B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAReferencesBaseBImpl#getBaseB <em>Base B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAReferencesBaseBImpl#getBaseA <em>Base A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseAReferencesBaseBImpl extends EObjectImpl implements BaseAReferencesBaseB {
	/**
	 * The cached value of the '{@link #getBaseB() <em>Base B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseB()
	 * @generated
	 * @ordered
	 */
	protected BaseB baseB;

	/**
	 * The cached value of the '{@link #getBaseA() <em>Base A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseA()
	 * @generated
	 * @ordered
	 */
	protected EList<BaseA> baseA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseAReferencesBaseBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.BASE_AREFERENCES_BASE_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseB getBaseB() {
		if (baseB != null && baseB.eIsProxy()) {
			InternalEObject oldBaseB = (InternalEObject)baseB;
			baseB = (BaseB)eResolveProxy(oldBaseB);
			if (baseB != oldBaseB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BasePackage.BASE_AREFERENCES_BASE_B__BASE_B, oldBaseB, baseB));
			}
		}
		return baseB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseB basicGetBaseB() {
		return baseB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseB(BaseB newBaseB) {
		BaseB oldBaseB = baseB;
		baseB = newBaseB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.BASE_AREFERENCES_BASE_B__BASE_B, oldBaseB, baseB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BaseA> getBaseA() {
		if (baseA == null) {
			baseA = new EObjectResolvingEList<BaseA>(BaseA.class, this, BasePackage.BASE_AREFERENCES_BASE_B__BASE_A);
		}
		return baseA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_B:
				if (resolve) return getBaseB();
				return basicGetBaseB();
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_A:
				return getBaseA();
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
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_B:
				setBaseB((BaseB)newValue);
				return;
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_A:
				getBaseA().clear();
				getBaseA().addAll((Collection<? extends BaseA>)newValue);
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
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_B:
				setBaseB((BaseB)null);
				return;
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_A:
				getBaseA().clear();
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
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_B:
				return baseB != null;
			case BasePackage.BASE_AREFERENCES_BASE_B__BASE_A:
				return baseA != null && !baseA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BaseAReferencesBaseBImpl
