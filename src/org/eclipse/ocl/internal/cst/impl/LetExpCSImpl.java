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
 * $Id: LetExpCSImpl.java,v 1.2 2007/02/14 14:46:04 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.ocl.internal.cst.CSTPackage;
import org.eclipse.ocl.internal.cst.LetExpCS;
import org.eclipse.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.ocl.internal.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Let Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.LetExpCSImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.LetExpCSImpl#getInExpression <em>In Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetExpCSImpl extends OCLExpressionCSImpl implements LetExpCS {
	/**
     * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getVariables()
     * @generated
     * @ordered
     */
	protected EList<VariableCS> variables = null;

	/**
     * The cached value of the '{@link #getInExpression() <em>In Expression</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getInExpression()
     * @generated
     * @ordered
     */
	protected OCLExpressionCS inExpression = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected LetExpCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.LET_EXP_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<VariableCS> getVariables() {
        if (variables == null) {
            variables = new EObjectResolvingEList<VariableCS>(VariableCS.class, this, CSTPackage.LET_EXP_CS__VARIABLES);
        }
        return variables;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS getInExpression() {
        if (inExpression != null && inExpression.eIsProxy()) {
            InternalEObject oldInExpression = (InternalEObject)inExpression;
            inExpression = (OCLExpressionCS)eResolveProxy(oldInExpression);
            if (inExpression != oldInExpression) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.LET_EXP_CS__IN_EXPRESSION, oldInExpression, inExpression));
            }
        }
        return inExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpressionCS basicGetInExpression() {
        return inExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setInExpression(OCLExpressionCS newInExpression) {
        OCLExpressionCS oldInExpression = inExpression;
        inExpression = newInExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.LET_EXP_CS__IN_EXPRESSION, oldInExpression, inExpression));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.LET_EXP_CS__VARIABLES:
                return getVariables();
            case CSTPackage.LET_EXP_CS__IN_EXPRESSION:
                if (resolve) return getInExpression();
                return basicGetInExpression();
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
            case CSTPackage.LET_EXP_CS__VARIABLES:
                getVariables().clear();
                getVariables().addAll((Collection<? extends VariableCS>)newValue);
                return;
            case CSTPackage.LET_EXP_CS__IN_EXPRESSION:
                setInExpression((OCLExpressionCS)newValue);
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
            case CSTPackage.LET_EXP_CS__VARIABLES:
                getVariables().clear();
                return;
            case CSTPackage.LET_EXP_CS__IN_EXPRESSION:
                setInExpression((OCLExpressionCS)null);
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
            case CSTPackage.LET_EXP_CS__VARIABLES:
                return variables != null && !variables.isEmpty();
            case CSTPackage.LET_EXP_CS__IN_EXPRESSION:
                return inExpression != null;
        }
        return super.eIsSet(featureID);
    }

} //LetExpCSImpl
