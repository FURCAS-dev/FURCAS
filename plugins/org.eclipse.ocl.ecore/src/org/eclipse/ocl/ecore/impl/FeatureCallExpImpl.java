/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: FeatureCallExpImpl.java,v 1.2 2007/10/11 23:04:41 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.FeatureCallExp;

import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.util.ToStringVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.impl.FeatureCallExpImpl#isMarkedPre <em>Marked Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FeatureCallExpImpl extends CallExpImpl implements FeatureCallExp {
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
     * The cached value of the '{@link #isMarkedPre() <em>Marked Pre</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isMarkedPre()
     * @generated
     * @ordered
     */
	protected boolean markedPre = MARKED_PRE_EDEFAULT;

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
        return EcorePackage.Literals.FEATURE_CALL_EXP;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isMarkedPre() {
        return markedPre;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setMarkedPre(boolean newMarkedPre) {
        boolean oldMarkedPre = markedPre;
        markedPre = newMarkedPre;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.FEATURE_CALL_EXP__MARKED_PRE, oldMarkedPre, markedPre));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EcorePackage.FEATURE_CALL_EXP__MARKED_PRE:
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
            case EcorePackage.FEATURE_CALL_EXP__MARKED_PRE:
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
            case EcorePackage.FEATURE_CALL_EXP__MARKED_PRE:
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
            case EcorePackage.FEATURE_CALL_EXP__MARKED_PRE:
                return markedPre != MARKED_PRE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == org.eclipse.ocl.expressions.FeatureCallExp.class) {
            switch (derivedFeatureID) {
                case EcorePackage.FEATURE_CALL_EXP__MARKED_PRE: return ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == org.eclipse.ocl.expressions.FeatureCallExp.class) {
            switch (baseFeatureID) {
                case ExpressionsPackage.FEATURE_CALL_EXP__MARKED_PRE: return EcorePackage.FEATURE_CALL_EXP__MARKED_PRE;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}
		
		return accept(ToStringVisitor.getInstance(this));
	}

} //FeatureCallExpImpl
