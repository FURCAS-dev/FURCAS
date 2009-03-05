/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *   Borland - Bug 242880
 *
 * </copyright>
 *
 * $Id: StringLiteralExpCSImpl.java,v 1.4 2009/03/05 14:12:13 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.StringLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.StringLiteralExpCSImpl#getStringSymbol <em>String Symbol</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.StringLiteralExpCSImpl#getUnescapedStringSymbol <em>Unescaped String Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringLiteralExpCSImpl
		extends PrimitiveLiteralExpCSImpl
		implements StringLiteralExpCS {

	/**
	 * The default value of the '{@link #getStringSymbol() <em>String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringSymbol() <em>String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringSymbol()
	 * @generated
	 * @ordered
	 */
	protected String stringSymbol = STRING_SYMBOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnescapedStringSymbol() <em>Unescaped String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getUnescapedStringSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String UNESCAPED_STRING_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnescapedStringSymbol() <em>Unescaped String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getUnescapedStringSymbol()
	 * @generated
	 * @ordered
	 */
	protected String unescapedStringSymbol = UNESCAPED_STRING_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringLiteralExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.STRING_LITERAL_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringSymbol() {
		return stringSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringSymbol(String newStringSymbol) {
		String oldStringSymbol = stringSymbol;
		stringSymbol = newStringSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.STRING_LITERAL_EXP_CS__STRING_SYMBOL,
				oldStringSymbol, stringSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnescapedStringSymbol() {
		return unescapedStringSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnescapedStringSymbol(String newUnescapedStringSymbol) {
		String oldUnescapedStringSymbol = unescapedStringSymbol;
		unescapedStringSymbol = newUnescapedStringSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.STRING_LITERAL_EXP_CS__UNESCAPED_STRING_SYMBOL,
				oldUnescapedStringSymbol, unescapedStringSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.STRING_LITERAL_EXP_CS__STRING_SYMBOL :
				return getStringSymbol();
			case CSTPackage.STRING_LITERAL_EXP_CS__UNESCAPED_STRING_SYMBOL :
				return getUnescapedStringSymbol();
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
			case CSTPackage.STRING_LITERAL_EXP_CS__STRING_SYMBOL :
				setStringSymbol((String) newValue);
				return;
			case CSTPackage.STRING_LITERAL_EXP_CS__UNESCAPED_STRING_SYMBOL :
				setUnescapedStringSymbol((String) newValue);
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
			case CSTPackage.STRING_LITERAL_EXP_CS__STRING_SYMBOL :
				setStringSymbol(STRING_SYMBOL_EDEFAULT);
				return;
			case CSTPackage.STRING_LITERAL_EXP_CS__UNESCAPED_STRING_SYMBOL :
				setUnescapedStringSymbol(UNESCAPED_STRING_SYMBOL_EDEFAULT);
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
			case CSTPackage.STRING_LITERAL_EXP_CS__STRING_SYMBOL :
				return STRING_SYMBOL_EDEFAULT == null
					? stringSymbol != null
					: !STRING_SYMBOL_EDEFAULT.equals(stringSymbol);
			case CSTPackage.STRING_LITERAL_EXP_CS__UNESCAPED_STRING_SYMBOL :
				return UNESCAPED_STRING_SYMBOL_EDEFAULT == null
					? unescapedStringSymbol != null
					: !UNESCAPED_STRING_SYMBOL_EDEFAULT
						.equals(unescapedStringSymbol);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stringSymbol: "); //$NON-NLS-1$
		result.append(stringSymbol);
		result.append(", unescapedStringSymbol: "); //$NON-NLS-1$
		result.append(unescapedStringSymbol);
		result.append(')');
		return result.toString();
	}

} //StringLiteralExpCSImpl
