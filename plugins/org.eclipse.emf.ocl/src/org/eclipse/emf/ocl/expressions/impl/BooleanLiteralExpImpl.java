/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: BooleanLiteralExpImpl.java,v 1.4 2007/10/11 23:05:16 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ocl.expressions.BooleanLiteralExp;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.Visitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.impl.BooleanLiteralExpImpl#getBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanLiteralExpImpl extends PrimitiveLiteralExpImpl implements BooleanLiteralExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBooleanSymbol() <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean BOOLEAN_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBooleanSymbol() <em>Boolean Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanSymbol()
	 * @ordered
	 */
	protected Boolean booleanSymbol = BOOLEAN_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.BOOLEAN_LITERAL_EXP;
	}

	@Override
    public Object accept(Visitor v) {
		return v.visitBooleanLiteralExp(this);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean getBooleanSymbol() {
		return booleanSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanSymbol(Boolean newBooleanSymbol) {
		Boolean oldBooleanSymbol = booleanSymbol;
		booleanSymbol = newBooleanSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL, oldBooleanSymbol, booleanSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
				return getBooleanSymbol();
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
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
				setBooleanSymbol((Boolean)newValue);
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
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
				setBooleanSymbol(BOOLEAN_SYMBOL_EDEFAULT);
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
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL:
				return BOOLEAN_SYMBOL_EDEFAULT == null ? booleanSymbol != null : !BOOLEAN_SYMBOL_EDEFAULT.equals(booleanSymbol);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @generated NOT
	 */
	@Override
    public String toString() {
		return ToStringVisitorImpl.toString(this);
	}

} //BooleanLiteralExpImpl
