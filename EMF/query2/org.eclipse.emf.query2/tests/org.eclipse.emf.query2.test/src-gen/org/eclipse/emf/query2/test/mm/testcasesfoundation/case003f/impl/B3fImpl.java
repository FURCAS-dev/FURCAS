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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.Case003fPackage;

import org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B3f</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.B3fImpl#getTextName <em>Text Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B3fImpl extends TranslatableTextImpl implements B3f {
	/**
	 * The default value of the '{@link #getTextName() <em>Text Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextName()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextName() <em>Text Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextName()
	 * @generated
	 * @ordered
	 */
	protected String textName = TEXT_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B3fImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case003fPackage.Literals.B3F;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextName() {
		return textName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextName(String newTextName) {
		String oldTextName = textName;
		textName = newTextName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case003fPackage.B3F__TEXT_NAME, oldTextName, textName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case003fPackage.B3F__TEXT_NAME:
				return getTextName();
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
			case Case003fPackage.B3F__TEXT_NAME:
				setTextName((String)newValue);
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
			case Case003fPackage.B3F__TEXT_NAME:
				setTextName(TEXT_NAME_EDEFAULT);
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
			case Case003fPackage.B3F__TEXT_NAME:
				return TEXT_NAME_EDEFAULT == null ? textName != null : !TEXT_NAME_EDEFAULT.equals(textName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (textName: ");
		result.append(textName);
		result.append(')');
		return result.toString();
	}

} //B3fImpl
