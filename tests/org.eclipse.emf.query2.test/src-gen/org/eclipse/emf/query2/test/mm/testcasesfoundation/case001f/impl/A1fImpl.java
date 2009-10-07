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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage;

import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A1f</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.A1fImpl#getTranslatableText <em>Translatable Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A1fImpl extends EObjectImpl implements A1f {
	/**
	 * The cached value of the '{@link #getTranslatableText() <em>Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranslatableText()
	 * @generated
	 * @ordered
	 */
	protected TranslatableText translatableText;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A1fImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case001fPackage.Literals.A1F;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableText getTranslatableText() {
		if (translatableText != null && translatableText.eIsProxy()) {
			InternalEObject oldTranslatableText = (InternalEObject)translatableText;
			translatableText = (TranslatableText)eResolveProxy(oldTranslatableText);
			if (translatableText != oldTranslatableText) {
				InternalEObject newTranslatableText = (InternalEObject)translatableText;
				NotificationChain msgs = oldTranslatableText.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case001fPackage.A1F__TRANSLATABLE_TEXT, null, null);
				if (newTranslatableText.eInternalContainer() == null) {
					msgs = newTranslatableText.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case001fPackage.A1F__TRANSLATABLE_TEXT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case001fPackage.A1F__TRANSLATABLE_TEXT, oldTranslatableText, translatableText));
			}
		}
		return translatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TranslatableText basicGetTranslatableText() {
		return translatableText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTranslatableText(TranslatableText newTranslatableText, NotificationChain msgs) {
		TranslatableText oldTranslatableText = translatableText;
		translatableText = newTranslatableText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case001fPackage.A1F__TRANSLATABLE_TEXT, oldTranslatableText, newTranslatableText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranslatableText(TranslatableText newTranslatableText) {
		if (newTranslatableText != translatableText) {
			NotificationChain msgs = null;
			if (translatableText != null)
				msgs = ((InternalEObject)translatableText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case001fPackage.A1F__TRANSLATABLE_TEXT, null, msgs);
			if (newTranslatableText != null)
				msgs = ((InternalEObject)newTranslatableText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case001fPackage.A1F__TRANSLATABLE_TEXT, null, msgs);
			msgs = basicSetTranslatableText(newTranslatableText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case001fPackage.A1F__TRANSLATABLE_TEXT, newTranslatableText, newTranslatableText));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case001fPackage.A1F__TRANSLATABLE_TEXT:
				return basicSetTranslatableText(null, msgs);
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
			case Case001fPackage.A1F__TRANSLATABLE_TEXT:
				if (resolve) return getTranslatableText();
				return basicGetTranslatableText();
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
			case Case001fPackage.A1F__TRANSLATABLE_TEXT:
				setTranslatableText((TranslatableText)newValue);
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
			case Case001fPackage.A1F__TRANSLATABLE_TEXT:
				setTranslatableText((TranslatableText)null);
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
			case Case001fPackage.A1F__TRANSLATABLE_TEXT:
				return translatableText != null;
		}
		return super.eIsSet(featureID);
	}

} //A1fImpl
