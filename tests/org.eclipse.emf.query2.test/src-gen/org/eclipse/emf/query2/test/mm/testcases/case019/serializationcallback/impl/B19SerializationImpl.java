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

import org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization;
import org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage;

import org.eclipse.emf.query2.test.mm.testcases.case019.translatabletexts.A19TranslatableText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B19 Serialization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.B19SerializationImpl#getTestTranslatableText <em>Test Translatable Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B19SerializationImpl extends EObjectImpl implements B19Serialization {
	/**
	 * The cached value of the '{@link #getTestTranslatableText() <em>Test Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestTranslatableText()
	 * @generated
	 * @ordered
	 */
	protected A19TranslatableText testTranslatableText;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B19SerializationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SerializationcallbackPackage.Literals.B19_SERIALIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A19TranslatableText getTestTranslatableText() {
		if (testTranslatableText != null && testTranslatableText.eIsProxy()) {
			InternalEObject oldTestTranslatableText = (InternalEObject)testTranslatableText;
			testTranslatableText = (A19TranslatableText)eResolveProxy(oldTestTranslatableText);
			if (testTranslatableText != oldTestTranslatableText) {
				InternalEObject newTestTranslatableText = (InternalEObject)testTranslatableText;
				NotificationChain msgs = oldTestTranslatableText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, null, null);
				if (newTestTranslatableText.eInternalContainer() == null) {
					msgs = newTestTranslatableText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, oldTestTranslatableText, testTranslatableText));
			}
		}
		return testTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A19TranslatableText basicGetTestTranslatableText() {
		return testTranslatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTestTranslatableText(A19TranslatableText newTestTranslatableText, NotificationChain msgs) {
		A19TranslatableText oldTestTranslatableText = testTranslatableText;
		testTranslatableText = newTestTranslatableText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, oldTestTranslatableText, newTestTranslatableText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestTranslatableText(A19TranslatableText newTestTranslatableText) {
		if (newTestTranslatableText != testTranslatableText) {
			NotificationChain msgs = null;
			if (testTranslatableText != null)
				msgs = ((InternalEObject)testTranslatableText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, null, msgs);
			if (newTestTranslatableText != null)
				msgs = ((InternalEObject)newTestTranslatableText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, null, msgs);
			msgs = basicSetTestTranslatableText(newTestTranslatableText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT, newTestTranslatableText, newTestTranslatableText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT:
				return basicSetTestTranslatableText(null, msgs);
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
			case SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT:
				if (resolve) return getTestTranslatableText();
				return basicGetTestTranslatableText();
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
			case SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT:
				setTestTranslatableText((A19TranslatableText)newValue);
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
			case SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT:
				setTestTranslatableText((A19TranslatableText)null);
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
			case SerializationcallbackPackage.B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT:
				return testTranslatableText != null;
		}
		return super.eIsSet(featureID);
	}

} //B19SerializationImpl
