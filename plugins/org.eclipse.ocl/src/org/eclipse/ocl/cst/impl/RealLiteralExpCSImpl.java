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
 * $Id: RealLiteralExpCSImpl.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.RealLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.RealLiteralExpCSImpl#getRealSymbol <em>Real Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RealLiteralExpCSImpl extends PrimitiveLiteralExpCSImpl implements RealLiteralExpCS {
	/**
     * The default value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRealSymbol()
     * @generated
     * @ordered
     */
	protected static final Double REAL_SYMBOL_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getRealSymbol() <em>Real Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getRealSymbol()
     * @generated
     * @ordered
     */
	protected Double realSymbol = REAL_SYMBOL_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RealLiteralExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.REAL_LITERAL_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Double getRealSymbol() {
        return realSymbol;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRealSymbol(Double newRealSymbol) {
        Double oldRealSymbol = realSymbol;
        realSymbol = newRealSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.REAL_LITERAL_EXP_CS__REAL_SYMBOL, oldRealSymbol, realSymbol));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.REAL_LITERAL_EXP_CS__REAL_SYMBOL:
                return getRealSymbol();
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
            case CSTPackage.REAL_LITERAL_EXP_CS__REAL_SYMBOL:
                setRealSymbol((Double)newValue);
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
            case CSTPackage.REAL_LITERAL_EXP_CS__REAL_SYMBOL:
                setRealSymbol(REAL_SYMBOL_EDEFAULT);
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
            case CSTPackage.REAL_LITERAL_EXP_CS__REAL_SYMBOL:
                return REAL_SYMBOL_EDEFAULT == null ? realSymbol != null : !REAL_SYMBOL_EDEFAULT.equals(realSymbol);
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
        result.append(" (realSymbol: "); //$NON-NLS-1$
        result.append(realSymbol);
        result.append(')');
        return result.toString();
    }

} //RealLiteralExpCSImpl
