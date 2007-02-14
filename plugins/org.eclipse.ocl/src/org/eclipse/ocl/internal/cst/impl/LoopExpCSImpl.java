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
 * $Id: LoopExpCSImpl.java,v 1.2 2007/02/14 14:46:06 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.LoopExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.LoopExpCSImpl#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.LoopExpCSImpl#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.LoopExpCSImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoopExpCSImpl extends CallExpCSImpl implements LoopExpCS {
	/**
     * The cached value of the '{@link #getVariable1() <em>Variable1</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariable1()
     * @generated
     * @ordered
     */
	protected VariableCS variable1 = null;

	/**
     * The cached value of the '{@link #getVariable2() <em>Variable2</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariable2()
     * @generated
     * @ordered
     */
	protected VariableCS variable2 = null;

	/**
     * The cached value of the '{@link #getBody() <em>Body</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getBody()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS body = null;

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
        if (variable1 != null && variable1.eIsProxy()) {
            InternalEObject oldVariable1 = (InternalEObject)variable1;
            variable1 = (VariableCS)eResolveProxy(oldVariable1);
            if (variable1 != oldVariable1) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.LOOP_EXP_CS__VARIABLE1, oldVariable1, variable1));
            }
        }
        return variable1;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCS basicGetVariable1() {
        return variable1;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariable1(VariableCS newVariable1) {
        VariableCS oldVariable1 = variable1;
        variable1 = newVariable1;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__VARIABLE1, oldVariable1, variable1));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCS getVariable2() {
        if (variable2 != null && variable2.eIsProxy()) {
            InternalEObject oldVariable2 = (InternalEObject)variable2;
            variable2 = (VariableCS)eResolveProxy(oldVariable2);
            if (variable2 != oldVariable2) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.LOOP_EXP_CS__VARIABLE2, oldVariable2, variable2));
            }
        }
        return variable2;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableCS basicGetVariable2() {
        return variable2;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setVariable2(VariableCS newVariable2) {
        VariableCS oldVariable2 = variable2;
        variable2 = newVariable2;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__VARIABLE2, oldVariable2, variable2));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getBody() {
        if (body != null && body.eIsProxy()) {
            InternalEObject oldBody = (InternalEObject)body;
            body = (OCLExpressionCS)eResolveProxy(oldBody);
            if (body != oldBody) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.LOOP_EXP_CS__BODY, oldBody, body));
            }
        }
        return body;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS basicGetBody() {
        return body;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBody(OCLExpressionCS newBody) {
        OCLExpressionCS oldBody = body;
        body = newBody;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LOOP_EXP_CS__BODY, oldBody, body));
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
                if (resolve) return getVariable1();
                return basicGetVariable1();
            case CSTPackage.LOOP_EXP_CS__VARIABLE2:
                if (resolve) return getVariable2();
                return basicGetVariable2();
            case CSTPackage.LOOP_EXP_CS__BODY:
                if (resolve) return getBody();
                return basicGetBody();
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
