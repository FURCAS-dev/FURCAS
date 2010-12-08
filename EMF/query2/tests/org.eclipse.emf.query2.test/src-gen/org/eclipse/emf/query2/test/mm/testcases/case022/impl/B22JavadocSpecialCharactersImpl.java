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
package org.eclipse.emf.query2.test.mm.testcases.case022.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters;
import org.eclipse.emf.query2.test.mm.testcases.case022.Case022Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B22 Javadoc Special Characters</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.B22JavadocSpecialCharactersImpl#getJavadocCommentEndSign <em>Javadoc Comment End Sign</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.B22JavadocSpecialCharactersImpl#getHttpAddress <em>Http Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B22JavadocSpecialCharactersImpl extends EObjectImpl implements B22JavadocSpecialCharacters {
	/**
	 * The default value of the '{@link #getJavadocCommentEndSign() <em>Javadoc Comment End Sign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavadocCommentEndSign()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVADOC_COMMENT_END_SIGN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavadocCommentEndSign() <em>Javadoc Comment End Sign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavadocCommentEndSign()
	 * @generated
	 * @ordered
	 */
	protected String javadocCommentEndSign = JAVADOC_COMMENT_END_SIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #getHttpAddress() <em>Http Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String HTTP_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHttpAddress() <em>Http Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHttpAddress()
	 * @generated
	 * @ordered
	 */
	protected String httpAddress = HTTP_ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B22JavadocSpecialCharactersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case022Package.Literals.B22_JAVADOC_SPECIAL_CHARACTERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJavadocCommentEndSign() {
		return javadocCommentEndSign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavadocCommentEndSign(String newJavadocCommentEndSign) {
		String oldJavadocCommentEndSign = javadocCommentEndSign;
		javadocCommentEndSign = newJavadocCommentEndSign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN, oldJavadocCommentEndSign, javadocCommentEndSign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHttpAddress() {
		return httpAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHttpAddress(String newHttpAddress) {
		String oldHttpAddress = httpAddress;
		httpAddress = newHttpAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS, oldHttpAddress, httpAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN:
				return getJavadocCommentEndSign();
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS:
				return getHttpAddress();
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
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN:
				setJavadocCommentEndSign((String)newValue);
				return;
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS:
				setHttpAddress((String)newValue);
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
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN:
				setJavadocCommentEndSign(JAVADOC_COMMENT_END_SIGN_EDEFAULT);
				return;
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS:
				setHttpAddress(HTTP_ADDRESS_EDEFAULT);
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
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN:
				return JAVADOC_COMMENT_END_SIGN_EDEFAULT == null ? javadocCommentEndSign != null : !JAVADOC_COMMENT_END_SIGN_EDEFAULT.equals(javadocCommentEndSign);
			case Case022Package.B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS:
				return HTTP_ADDRESS_EDEFAULT == null ? httpAddress != null : !HTTP_ADDRESS_EDEFAULT.equals(httpAddress);
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
		result.append(" (javadocCommentEndSign: ");
		result.append(javadocCommentEndSign);
		result.append(", httpAddress: ");
		result.append(httpAddress);
		result.append(')');
		return result.toString();
	}

} //B22JavadocSpecialCharactersImpl
