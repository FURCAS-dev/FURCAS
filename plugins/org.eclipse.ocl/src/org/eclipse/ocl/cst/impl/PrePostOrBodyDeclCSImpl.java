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
 * $Id: PrePostOrBodyDeclCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PrePostOrBodyDeclCS;
import org.eclipse.ocl.cst.PrePostOrBodyEnum;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pre Post Or Body Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PrePostOrBodyDeclCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrePostOrBodyDeclCSImpl extends CSTNodeImpl implements PrePostOrBodyDeclCS {
	/**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final PrePostOrBodyEnum KIND_EDEFAULT = PrePostOrBodyEnum.PRE_LITERAL;

	/**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected PrePostOrBodyEnum kind = KIND_EDEFAULT;

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
     * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getExpressionCS()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS expressionCS;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PrePostOrBodyDeclCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.PRE_POST_OR_BODY_DECL_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PrePostOrBodyEnum getKind() {
        return kind;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKind(PrePostOrBodyEnum newKind) {
        PrePostOrBodyEnum oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PRE_POST_OR_BODY_DECL_CS__KIND, oldKind, kind));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
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
                msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS, null, msgs);
            if (newSimpleNameCS != null)
                msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS, null, msgs);
            msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getExpressionCS() {
        return expressionCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetExpressionCS(OCLExpressionCS newExpressionCS, NotificationChain msgs) {
        OCLExpressionCS oldExpressionCS = expressionCS;
        expressionCS = newExpressionCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS, oldExpressionCS, newExpressionCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setExpressionCS(OCLExpressionCS newExpressionCS) {
        if (newExpressionCS != expressionCS) {
            NotificationChain msgs = null;
            if (expressionCS != null)
                msgs = ((InternalEObject)expressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS, null, msgs);
            if (newExpressionCS != null)
                msgs = ((InternalEObject)newExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS, null, msgs);
            msgs = basicSetExpressionCS(newExpressionCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS, newExpressionCS, newExpressionCS));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS:
                return basicSetSimpleNameCS(null, msgs);
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS:
                return basicSetExpressionCS(null, msgs);
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
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__KIND:
                return getKind();
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS:
                return getSimpleNameCS();
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS:
                return getExpressionCS();
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
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__KIND:
                setKind((PrePostOrBodyEnum)newValue);
                return;
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)newValue);
                return;
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS:
                setExpressionCS((OCLExpressionCS)newValue);
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
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)null);
                return;
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS:
                setExpressionCS((OCLExpressionCS)null);
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
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__KIND:
                return kind != KIND_EDEFAULT;
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__SIMPLE_NAME_CS:
                return simpleNameCS != null;
            case CSTPackage.PRE_POST_OR_BODY_DECL_CS__EXPRESSION_CS:
                return expressionCS != null;
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
        result.append(" (kind: "); //$NON-NLS-1$
        result.append(kind);
        result.append(')');
        return result.toString();
    }

} //PrePostOrBodyDeclCSImpl
