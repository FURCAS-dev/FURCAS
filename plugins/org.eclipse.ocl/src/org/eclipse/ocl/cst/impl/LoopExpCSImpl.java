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
 * $Id: LoopExpCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
 */
package org.eclipse.ocl.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.LoopExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.LoopExpCSImpl#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.LoopExpCSImpl#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.LoopExpCSImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopExpCSImpl extends CallExpCSImpl implements LoopExpCS {
	/**
     * The cached value of the '{@link #getVariable1() <em>Variable1</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariable1()
     * @generated
     * @ordered
     */
	protected VariableCS variable1;

	/**
     * The cached value of the '{@link #getVariable2() <em>Variable2</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariable2()
     * @generated
     * @ordered
     */
	protected VariableCS variable2;

	/**
     * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBody()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS body;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LoopExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.LOOP_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCS getVariable1() {
        return variable1;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVariable1(VariableCS newVariable1, NotificationChain msgs) {
        VariableCS oldVariable1 = variable1;
        variable1 = newVariable1;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__VARIABLE1, oldVariable1, newVariable1);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariable1(VariableCS newVariable1) {
        if (newVariable1 != variable1) {
            NotificationChain msgs = null;
            if (variable1 != null)
                msgs = ((InternalEObject)variable1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.LOOP_EXP_CS__VARIABLE1, null, msgs);
            if (newVariable1 != null)
                msgs = ((InternalEObject)newVariable1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.LOOP_EXP_CS__VARIABLE1, null, msgs);
            msgs = basicSetVariable1(newVariable1, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__VARIABLE1, newVariable1, newVariable1));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCS getVariable2() {
        return variable2;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVariable2(VariableCS newVariable2, NotificationChain msgs) {
        VariableCS oldVariable2 = variable2;
        variable2 = newVariable2;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__VARIABLE2, oldVariable2, newVariable2);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariable2(VariableCS newVariable2) {
        if (newVariable2 != variable2) {
            NotificationChain msgs = null;
            if (variable2 != null)
                msgs = ((InternalEObject)variable2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.LOOP_EXP_CS__VARIABLE2, null, msgs);
            if (newVariable2 != null)
                msgs = ((InternalEObject)newVariable2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.LOOP_EXP_CS__VARIABLE2, null, msgs);
            msgs = basicSetVariable2(newVariable2, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__VARIABLE2, newVariable2, newVariable2));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getBody() {
        return body;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBody(OCLExpressionCS newBody, NotificationChain msgs) {
        OCLExpressionCS oldBody = body;
        body = newBody;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__BODY, oldBody, newBody);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBody(OCLExpressionCS newBody) {
        if (newBody != body) {
            NotificationChain msgs = null;
            if (body != null)
                msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.LOOP_EXP_CS__BODY, null, msgs);
            if (newBody != null)
                msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.LOOP_EXP_CS__BODY, null, msgs);
            msgs = basicSetBody(newBody, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__BODY, newBody, newBody));
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.LOOP_EXP_CS__VARIABLE1:
                return basicSetVariable1(null, msgs);
            case CSTPackage.LOOP_EXP_CS__VARIABLE2:
                return basicSetVariable2(null, msgs);
            case CSTPackage.LOOP_EXP_CS__BODY:
                return basicSetBody(null, msgs);
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
            case CSTPackage.LOOP_EXP_CS__VARIABLE1:
                return getVariable1();
            case CSTPackage.LOOP_EXP_CS__VARIABLE2:
                return getVariable2();
            case CSTPackage.LOOP_EXP_CS__BODY:
                return getBody();
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
            case CSTPackage.LOOP_EXP_CS__VARIABLE1:
                setVariable1((VariableCS)newValue);
                return;
            case CSTPackage.LOOP_EXP_CS__VARIABLE2:
                setVariable2((VariableCS)newValue);
                return;
            case CSTPackage.LOOP_EXP_CS__BODY:
                setBody((OCLExpressionCS)newValue);
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
            case CSTPackage.LOOP_EXP_CS__VARIABLE1:
                setVariable1((VariableCS)null);
                return;
            case CSTPackage.LOOP_EXP_CS__VARIABLE2:
                setVariable2((VariableCS)null);
                return;
            case CSTPackage.LOOP_EXP_CS__BODY:
                setBody((OCLExpressionCS)null);
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
            case CSTPackage.LOOP_EXP_CS__VARIABLE1:
                return variable1 != null;
            case CSTPackage.LOOP_EXP_CS__VARIABLE2:
                return variable2 != null;
            case CSTPackage.LOOP_EXP_CS__BODY:
                return body != null;
        }
        return super.eIsSet(featureID);
    }

}
