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
 * $Id: IntegerLiteralExpCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.IntegerLiteralExpCSImpl#getIntegerSymbol <em>Integer Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegerLiteralExpCSImpl extends PrimitiveLiteralExpCSImpl implements IntegerLiteralExpCS {
	/**
     * The default value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIntegerSymbol()
     * @generated
     * @ordered
     */
	protected static final Integer INTEGER_SYMBOL_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getIntegerSymbol() <em>Integer Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIntegerSymbol()
     * @generated
     * @ordered
     */
	protected Integer integerSymbol = INTEGER_SYMBOL_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected IntegerLiteralExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.INTEGER_LITERAL_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Integer getIntegerSymbol() {
        return integerSymbol;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIntegerSymbol(Integer newIntegerSymbol) {
        Integer oldIntegerSymbol = integerSymbol;
        integerSymbol = newIntegerSymbol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL, oldIntegerSymbol, integerSymbol));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL:
                return getIntegerSymbol();
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
            case CSTPackage.INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL:
                setIntegerSymbol((Integer)newValue);
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
            case CSTPackage.INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL:
                setIntegerSymbol(INTEGER_SYMBOL_EDEFAULT);
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
            case CSTPackage.INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL:
                return INTEGER_SYMBOL_EDEFAULT == null ? integerSymbol != null : !INTEGER_SYMBOL_EDEFAULT.equals(integerSymbol);
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
        result.append(" (integerSymbol: "); //$NON-NLS-1$
        result.append(integerSymbol);
        result.append(')');
        return result.toString();
    }

} //IntegerLiteralExpCSImpl
