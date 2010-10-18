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
package org.eclipse.emf.query2.test.mm.testcases.case026.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case026.A26;
import org.eclipse.emf.query2.test.mm.testcases.case026.Case026Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A26</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case026.impl.A26Impl#getReflectToOne <em>Reflect To One</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case026.impl.A26Impl#getReflectToMany <em>Reflect To Many</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A26Impl extends EObjectImpl implements A26 {
	/**
	 * The cached value of the '{@link #getReflectToOne() <em>Reflect To One</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflectToOne()
	 * @generated
	 * @ordered
	 */
	protected EObject reflectToOne;

	/**
	 * The cached value of the '{@link #getReflectToMany() <em>Reflect To Many</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflectToMany()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> reflectToMany;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A26Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case026Package.Literals.A26;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getReflectToOne() {
		if (reflectToOne != null && reflectToOne.eIsProxy()) {
			InternalEObject oldReflectToOne = (InternalEObject)reflectToOne;
			reflectToOne = eResolveProxy(oldReflectToOne);
			if (reflectToOne != oldReflectToOne) {
				InternalEObject newReflectToOne = (InternalEObject)reflectToOne;
				NotificationChain msgs = oldReflectToOne.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case026Package.A26__REFLECT_TO_ONE, null, null);
				if (newReflectToOne.eInternalContainer() == null) {
					msgs = newReflectToOne.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case026Package.A26__REFLECT_TO_ONE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case026Package.A26__REFLECT_TO_ONE, oldReflectToOne, reflectToOne));
			}
		}
		return reflectToOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetReflectToOne() {
		return reflectToOne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReflectToOne(EObject newReflectToOne, NotificationChain msgs) {
		EObject oldReflectToOne = reflectToOne;
		reflectToOne = newReflectToOne;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case026Package.A26__REFLECT_TO_ONE, oldReflectToOne, newReflectToOne);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectToOne(EObject newReflectToOne) {
		if (newReflectToOne != reflectToOne) {
			NotificationChain msgs = null;
			if (reflectToOne != null)
				msgs = ((InternalEObject)reflectToOne).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case026Package.A26__REFLECT_TO_ONE, null, msgs);
			if (newReflectToOne != null)
				msgs = ((InternalEObject)newReflectToOne).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case026Package.A26__REFLECT_TO_ONE, null, msgs);
			msgs = basicSetReflectToOne(newReflectToOne, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case026Package.A26__REFLECT_TO_ONE, newReflectToOne, newReflectToOne));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getReflectToMany() {
		if (reflectToMany == null) {
			reflectToMany = new EObjectContainmentEList.Resolving<EObject>(EObject.class, this, Case026Package.A26__REFLECT_TO_MANY);
		}
		return reflectToMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case026Package.A26__REFLECT_TO_ONE:
				return basicSetReflectToOne(null, msgs);
			case Case026Package.A26__REFLECT_TO_MANY:
				return ((InternalEList<?>)getReflectToMany()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case026Package.A26__REFLECT_TO_ONE:
				if (resolve) return getReflectToOne();
				return basicGetReflectToOne();
			case Case026Package.A26__REFLECT_TO_MANY:
				return getReflectToMany();
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
			case Case026Package.A26__REFLECT_TO_ONE:
				setReflectToOne((EObject)newValue);
				return;
			case Case026Package.A26__REFLECT_TO_MANY:
				getReflectToMany().clear();
				getReflectToMany().addAll((Collection<? extends EObject>)newValue);
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
			case Case026Package.A26__REFLECT_TO_ONE:
				setReflectToOne((EObject)null);
				return;
			case Case026Package.A26__REFLECT_TO_MANY:
				getReflectToMany().clear();
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
			case Case026Package.A26__REFLECT_TO_ONE:
				return reflectToOne != null;
			case Case026Package.A26__REFLECT_TO_MANY:
				return reflectToMany != null && !reflectToMany.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //A26Impl
