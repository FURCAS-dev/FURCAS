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
 * $Id: CallExpCSImpl.java,v 1.2 2007/02/14 14:46:04 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.CallExpCS;
import org.eclipse.ocl.internal.cst.DotOrArrowEnum;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.CallExpCSImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.CallExpCSImpl#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.CallExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallExpCSImpl extends OCLExpressionCSImpl implements CallExpCS {
	/**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS source = null;

	/**
     * The default value of the '{@link #getAccessor() <em>Accessor</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAccessor()
     * @generated
     * @ordered
     */
	protected static final DotOrArrowEnum ACCESSOR_EDEFAULT = DotOrArrowEnum.NONE_LITERAL;

	/**
     * The cached value of the '{@link #getAccessor() <em>Accessor</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getAccessor()
     * @generated
     * @ordered
     */
	protected DotOrArrowEnum accessor = ACCESSOR_EDEFAULT;

	/**
     * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSimpleNameCS()
     * @generated
     * @ordered
     */
	protected SimpleNameCS simpleNameCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected CallExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.CALL_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getSource() {
        if (source != null && source.eIsProxy()) {
            InternalEObject oldSource = (InternalEObject)source;
            source = (OCLExpressionCS)eResolveProxy(oldSource);
            if (source != oldSource) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.CALL_EXP_CS__SOURCE, oldSource, source));
            }
        }
        return source;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS basicGetSource() {
        return source;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(OCLExpressionCS newSource) {
        OCLExpressionCS oldSource = source;
        source = newSource;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__SOURCE, oldSource, source));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DotOrArrowEnum getAccessor() {
        return accessor;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAccessor(DotOrArrowEnum newAccessor) {
        DotOrArrowEnum oldAccessor = accessor;
        accessor = newAccessor == null ? ACCESSOR_EDEFAULT : newAccessor;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__ACCESSOR, oldAccessor, accessor));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleNameCS getSimpleNameCS() {
        if (simpleNameCS != null && simpleNameCS.eIsProxy()) {
            InternalEObject oldSimpleNameCS = (InternalEObject)simpleNameCS;
            simpleNameCS = (SimpleNameCS)eResolveProxy(oldSimpleNameCS);
            if (simpleNameCS != oldSimpleNameCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
            }
        }
        return simpleNameCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SimpleNameCS basicGetSimpleNameCS() {
        return simpleNameCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
        SimpleNameCS oldSimpleNameCS = simpleNameCS;
        simpleNameCS = newSimpleNameCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.CALL_EXP_CS__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case CSTPackage.CALL_EXP_CS__ACCESSOR:
                return getAccessor();
            case CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS:
                if (resolve) return getSimpleNameCS();
                return basicGetSimpleNameCS();
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
            case CSTPackage.CALL_EXP_CS__SOURCE:
                setSource((OCLExpressionCS)newValue);
                return;
            case CSTPackage.CALL_EXP_CS__ACCESSOR:
                setAccessor((DotOrArrowEnum)newValue);
                return;
            case CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)newValue);
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
            case CSTPackage.CALL_EXP_CS__SOURCE:
                setSource((OCLExpressionCS)null);
                return;
            case CSTPackage.CALL_EXP_CS__ACCESSOR:
                setAccessor(ACCESSOR_EDEFAULT);
                return;
            case CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)null);
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
            case CSTPackage.CALL_EXP_CS__SOURCE:
                return source != null;
            case CSTPackage.CALL_EXP_CS__ACCESSOR:
                return accessor != ACCESSOR_EDEFAULT;
            case CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS:
                return simpleNameCS != null;
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
        result.append(" (accessor: "); //$NON-NLS-1$
        result.append(accessor);
        result.append(')');
        return result.toString();
    }

} //PropertyCallExpCSImpl
