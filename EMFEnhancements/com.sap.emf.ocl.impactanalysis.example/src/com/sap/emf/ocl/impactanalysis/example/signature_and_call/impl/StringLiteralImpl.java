/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl;

import com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage;
import com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.StringLiteralImpl#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringLiteralImpl extends ExpressionImpl implements StringLiteral {
    /**
     * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSymbol()
     * @generated
     * @ordered
     */
    protected static final String SYMBOL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSymbol()
     * @generated
     * @ordered
     */
    protected String symbol = SYMBOL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StringLiteralImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return Signature_and_callPackage.Literals.STRING_LITERAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSymbol(String newSymbol) {
        String oldSymbol = symbol;
        symbol = newSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, Signature_and_callPackage.STRING_LITERAL__SYMBOL, oldSymbol, symbol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case Signature_and_callPackage.STRING_LITERAL__SYMBOL:
                return getSymbol();
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
            case Signature_and_callPackage.STRING_LITERAL__SYMBOL:
                setSymbol((String)newValue);
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
            case Signature_and_callPackage.STRING_LITERAL__SYMBOL:
                setSymbol(SYMBOL_EDEFAULT);
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
            case Signature_and_callPackage.STRING_LITERAL__SYMBOL:
                return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
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
        result.append(" (symbol: ");
        result.append(symbol);
        result.append(')');
        return result.toString();
    }

} //StringLiteralImpl
