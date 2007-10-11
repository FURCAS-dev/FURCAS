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
 * $Id: IsMarkedPreCSImpl.java,v 1.1 2007/10/11 23:05:00 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.IsMarkedPreCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Is Marked Pre CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.IsMarkedPreCSImpl#isPre <em>Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IsMarkedPreCSImpl extends CSTNodeImpl implements IsMarkedPreCS {
	/**
     * The default value of the '{@link #isPre() <em>Pre</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isPre()
     * @generated
     * @ordered
     */
	protected static final boolean PRE_EDEFAULT = false;

	/**
     * The flag representing the value of the '{@link #isPre() <em>Pre</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #isPre()
     * @generated
     * @ordered
     */
	protected static final int PRE_EFLAG = 1 << 8;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected IsMarkedPreCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.IS_MARKED_PRE_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean isPre() {
        return (eFlags & PRE_EFLAG) != 0;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPre(boolean newPre) {
        boolean oldPre = (eFlags & PRE_EFLAG) != 0;
        if (newPre) eFlags |= PRE_EFLAG; else eFlags &= ~PRE_EFLAG;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.IS_MARKED_PRE_CS__PRE, oldPre, newPre));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.IS_MARKED_PRE_CS__PRE:
                return isPre() ? Boolean.TRUE : Boolean.FALSE;
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
            case CSTPackage.IS_MARKED_PRE_CS__PRE:
                setPre(((Boolean)newValue).booleanValue());
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
            case CSTPackage.IS_MARKED_PRE_CS__PRE:
                setPre(PRE_EDEFAULT);
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
            case CSTPackage.IS_MARKED_PRE_CS__PRE:
                return ((eFlags & PRE_EFLAG) != 0) != PRE_EDEFAULT;
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
        result.append(" (pre: "); //$NON-NLS-1$
        result.append((eFlags & PRE_EFLAG) != 0);
        result.append(')');
        return result.toString();
    }

} //IsMarkedPreCSImpl
