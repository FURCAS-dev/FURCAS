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
 * $Id: MessageExpCSImpl.java,v 1.1 2007/10/11 23:05:01 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.MessageExpKind;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Message Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.MessageExpCSImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.MessageExpCSImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.MessageExpCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.MessageExpCSImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageExpCSImpl extends OCLExpressionCSImpl implements MessageExpCS {
	/**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS target;

	/**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected static final MessageExpKind KIND_EDEFAULT = MessageExpKind.HAS_SENT_LITERAL;

	/**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
	protected MessageExpKind kind = KIND_EDEFAULT;

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
     * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getArguments()
     * @generated
     * @ordered
     */
	protected EList<OCLMessageArgCS> arguments;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected MessageExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.MESSAGE_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getTarget() {
        return target;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTarget(OCLExpressionCS newTarget, NotificationChain msgs) {
        OCLExpressionCS oldTarget = target;
        target = newTarget;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MESSAGE_EXP_CS__TARGET, oldTarget, newTarget);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTarget(OCLExpressionCS newTarget) {
        if (newTarget != target) {
            NotificationChain msgs = null;
            if (target != null)
                msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MESSAGE_EXP_CS__TARGET, null, msgs);
            if (newTarget != null)
                msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MESSAGE_EXP_CS__TARGET, null, msgs);
            msgs = basicSetTarget(newTarget, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MESSAGE_EXP_CS__TARGET, newTarget, newTarget));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MessageExpKind getKind() {
        return kind;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setKind(MessageExpKind newKind) {
        MessageExpKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MESSAGE_EXP_CS__KIND, oldKind, kind));
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS, oldSimpleNameCS, newSimpleNameCS);
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
                msgs = ((InternalEObject)simpleNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS, null, msgs);
            if (newSimpleNameCS != null)
                msgs = ((InternalEObject)newSimpleNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS, null, msgs);
            msgs = basicSetSimpleNameCS(newSimpleNameCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS, newSimpleNameCS, newSimpleNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<OCLMessageArgCS> getArguments() {
        if (arguments == null) {
            arguments = new EObjectContainmentEList<OCLMessageArgCS>(OCLMessageArgCS.class, this, CSTPackage.MESSAGE_EXP_CS__ARGUMENTS);
        }
        return arguments;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.MESSAGE_EXP_CS__TARGET:
                return basicSetTarget(null, msgs);
            case CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS:
                return basicSetSimpleNameCS(null, msgs);
            case CSTPackage.MESSAGE_EXP_CS__ARGUMENTS:
                return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
            case CSTPackage.MESSAGE_EXP_CS__TARGET:
                return getTarget();
            case CSTPackage.MESSAGE_EXP_CS__KIND:
                return getKind();
            case CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS:
                return getSimpleNameCS();
            case CSTPackage.MESSAGE_EXP_CS__ARGUMENTS:
                return getArguments();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
		@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case CSTPackage.MESSAGE_EXP_CS__TARGET:
                setTarget((OCLExpressionCS)newValue);
                return;
            case CSTPackage.MESSAGE_EXP_CS__KIND:
                setKind((MessageExpKind)newValue);
                return;
            case CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)newValue);
                return;
            case CSTPackage.MESSAGE_EXP_CS__ARGUMENTS:
                getArguments().clear();
                getArguments().addAll((Collection<? extends OCLMessageArgCS>)newValue);
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
            case CSTPackage.MESSAGE_EXP_CS__TARGET:
                setTarget((OCLExpressionCS)null);
                return;
            case CSTPackage.MESSAGE_EXP_CS__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)null);
                return;
            case CSTPackage.MESSAGE_EXP_CS__ARGUMENTS:
                getArguments().clear();
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
            case CSTPackage.MESSAGE_EXP_CS__TARGET:
                return target != null;
            case CSTPackage.MESSAGE_EXP_CS__KIND:
                return kind != KIND_EDEFAULT;
            case CSTPackage.MESSAGE_EXP_CS__SIMPLE_NAME_CS:
                return simpleNameCS != null;
            case CSTPackage.MESSAGE_EXP_CS__ARGUMENTS:
                return arguments != null && !arguments.isEmpty();
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

} //OCLMessageExpCSImpl
