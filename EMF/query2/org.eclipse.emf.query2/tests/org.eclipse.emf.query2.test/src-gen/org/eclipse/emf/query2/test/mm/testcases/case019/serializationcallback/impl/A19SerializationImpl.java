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
package org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization;
import org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.TranslatableTextF;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A19 Serialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.A19SerializationImpl#getTestTranslatableTextF <em>Test Translatable Text F</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A19SerializationImpl extends EObjectImpl implements A19Serialization {
	/**
	 * The cached value of the '{@link #getTestTranslatableTextF() <em>Test Translatable Text F</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestTranslatableTextF()
	 * @generated
	 * @ordered
	 */
	protected TranslatableTextF testTranslatableTextF;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A19SerializationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SerializationcallbackPackage.Literals.A19_SERIALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableTextF getTestTranslatableTextF() {
		if (testTranslatableTextF != null && testTranslatableTextF.eIsProxy()) {
			InternalEObject oldTestTranslatableTextF = (InternalEObject)testTranslatableTextF;
			testTranslatableTextF = (TranslatableTextF)eResolveProxy(oldTestTranslatableTextF);
			if (testTranslatableTextF != oldTestTranslatableTextF) {
				InternalEObject newTestTranslatableTextF = (InternalEObject)testTranslatableTextF;
				NotificationChain msgs = oldTestTranslatableTextF.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, null, null);
				if (newTestTranslatableTextF.eInternalContainer() == null) {
					msgs = newTestTranslatableTextF.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, oldTestTranslatableTextF, testTranslatableTextF));
			}
		}
		return testTranslatableTextF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableTextF basicGetTestTranslatableTextF() {
		return testTranslatableTextF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestTranslatableTextF(TranslatableTextF newTestTranslatableTextF, NotificationChain msgs) {
		TranslatableTextF oldTestTranslatableTextF = testTranslatableTextF;
		testTranslatableTextF = newTestTranslatableTextF;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, oldTestTranslatableTextF, newTestTranslatableTextF);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestTranslatableTextF(TranslatableTextF newTestTranslatableTextF) {
		if (newTestTranslatableTextF != testTranslatableTextF) {
			NotificationChain msgs = null;
			if (testTranslatableTextF != null)
				msgs = ((InternalEObject)testTranslatableTextF).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, null, msgs);
			if (newTestTranslatableTextF != null)
				msgs = ((InternalEObject)newTestTranslatableTextF).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, null, msgs);
			msgs = basicSetTestTranslatableTextF(newTestTranslatableTextF, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F, newTestTranslatableTextF, newTestTranslatableTextF));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F:
				return basicSetTestTranslatableTextF(null, msgs);
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
			case SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F:
				if (resolve) return getTestTranslatableTextF();
				return basicGetTestTranslatableTextF();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F:
				setTestTranslatableTextF((TranslatableTextF)newValue);
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
			case SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F:
				setTestTranslatableTextF((TranslatableTextF)null);
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
			case SerializationcallbackPackage.A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F:
				return testTranslatableTextF != null;
		}
		return super.eIsSet(featureID);
	}

} //A19SerializationImpl
