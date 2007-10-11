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
 * $Id: CallExpCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.CallExpCSImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CallExpCSImpl#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CallExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallExpCSImpl extends OCLExpressionCSImpl implements CallExpCS {
	/**
     * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS source;

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
     * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSimpleNameCS()
     * @generated
     * @ordered
     */
	protected SimpleNameCS simpleNameCS;

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
        return source;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSource(OCLExpressionCS newSource, NotificationChain msgs) {
        OCLExpressionCS oldSource = source;
        source = newSource;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__SOURCE, oldSource, newSource);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSource(OCLExpressionCS newSource) {
        if (newSource != source) {
            NotificationChain msgs = null;
            if (source != null)
                msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CALL_EXP_CS__SOURCE, null, msgs);
            if (newSource != null)
                msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CALL_EXP_CS__SOURCE, null, msgs);
            msgs = basicSetSource(newSource, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__SOURCE, newSource, newSource));
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
        return simpleNameCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSimpleNameCS(SimpleNameCS newSimpleNameCS, NotificationChain msgs) {
        SimpleNameCS oldSimpleNameCS = simpleNameCS;
        simpleNameCS = newSimpleNameCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSimpleNameCS(SimpleNameCS newSimpleNameCS) {
        if (newSimpleNameCS != simpleNameCS) {
            NotificationChain msgs = null;
            if (simpleNameCS != null)
                msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS, null, msgs);
            if (newSimpleNameCS != null)
                msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS, null, msgs);
            msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.CALL_EXP_CS__SOURCE:
                return basicSetSource(null, msgs);
            case CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS:
                return basicSetSimpleNameCS(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
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
                return getSource();
            case CSTPackage.CALL_EXP_CS__ACCESSOR:
                return getAccessor();
            case CSTPackage.CALL_EXP_CS__SIMPLE_NAME_CS:
                return getSimpleNameCS();
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
