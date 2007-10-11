/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 * 
 * </copyright>
 *
 * $Id: FeatureCallExpImpl.java,v 1.3 2007/10/11 23:04:56 cdamus Exp $
 */
package org.eclipse.ocl.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.FeatureCallExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.impl.FeatureCallExpImpl#isMarkedPre <em>Marked Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureCallExpImpl<C> extends CallExpImpl<C> implements FeatureCallExp<C> {
	/**
     * The default value of the '{@link #isMarkedPre() <em>Marked Pre</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMarkedPre()
     * @generated
     * @ordered
     */
	protected static final boolean MARKED_PRE_EDEFAULT = false;

	/**
     * The flag representing the value of the '{@link #isMarkedPre() <em>Marked Pre</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMarkedPre()
     * @generated
     * @ordered
     */
	protected static final int MARKED_PRE_EFLAG = 1 << 8;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected FeatureCallExpImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExpressionsPackage.Literals.FEATURE_CALL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isMarkedPre() {
        return (eFlags & MARKED_PRE_EFLAG) != 0;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMarkedPre(boolean newMarkedPre) {
        boolean oldMarkedPre = (eFlags & MARKED_PRE_EFLAG) != 0;
        if (newMarkedPre) eFlags |= MARKED_PRE_EFLAG; else eFlags &= ~MARKED_PRE_EFLAG;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE, oldMarkedPre, newMarkedPre));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                return isMarkedPre() ? Boolean.TRUE : Boolean.FALSE;
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
            case ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                setMarkedPre(((Boolean)newValue).booleanValue());
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
            case ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                setMarkedPre(MARKED_PRE_EDEFAULT);
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
            case ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE:
                return ((eFlags & MARKED_PRE_EFLAG) != 0) != MARKED_PRE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

} //FeatureCallExpImpl
