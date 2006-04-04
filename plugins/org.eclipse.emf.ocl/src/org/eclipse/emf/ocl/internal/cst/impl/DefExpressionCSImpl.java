/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id: DefExpressionCSImpl.java,v 1.1 2006/04/04 18:09:05 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ocl.internal.cst.CSTPackage;
import org.eclipse.emf.ocl.internal.cst.DefExpressionCS;
import org.eclipse.emf.ocl.internal.cst.OCLExpressionCS;
import org.eclipse.emf.ocl.internal.cst.OperationCS;
import org.eclipse.emf.ocl.internal.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def Expression CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.DefExpressionCSImpl#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.DefExpressionCSImpl#getVariableCS <em>Variable CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.impl.DefExpressionCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefExpressionCSImpl extends CSTNodeImpl implements DefExpressionCS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getOperationCS() <em>Operation CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationCS()
	 * @generated
	 * @ordered
	 */
	protected OperationCS operationCS = null;

	/**
	 * The cached value of the '{@link #getVariableCS() <em>Variable CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCS()
	 * @generated
	 * @ordered
	 */
	protected VariableCS variableCS = null;

	/**
	 * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS expressionCS = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefExpressionCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CSTPackage.Literals.DEF_EXPRESSION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS getOperationCS() {
		if (operationCS != null && operationCS.eIsProxy()) {
			InternalEObject oldOperationCS = (InternalEObject)operationCS;
			operationCS = (OperationCS)eResolveProxy(oldOperationCS);
			if (operationCS != oldOperationCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS, oldOperationCS, operationCS));
			}
		}
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCS basicGetOperationCS() {
		return operationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationCS(OperationCS newOperationCS) {
		OperationCS oldOperationCS = operationCS;
		operationCS = newOperationCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS, oldOperationCS, operationCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS getVariableCS() {
		if (variableCS != null && variableCS.eIsProxy()) {
			InternalEObject oldVariableCS = (InternalEObject)variableCS;
			variableCS = (VariableCS)eResolveProxy(oldVariableCS);
			if (variableCS != oldVariableCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS, oldVariableCS, variableCS));
			}
		}
		return variableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS basicGetVariableCS() {
		return variableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableCS(VariableCS newVariableCS) {
		VariableCS oldVariableCS = variableCS;
		variableCS = newVariableCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS, oldVariableCS, variableCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getExpressionCS() {
		if (expressionCS != null && expressionCS.eIsProxy()) {
			InternalEObject oldExpressionCS = (InternalEObject)expressionCS;
			expressionCS = (OCLExpressionCS)eResolveProxy(oldExpressionCS);
			if (expressionCS != oldExpressionCS) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS, oldExpressionCS, expressionCS));
			}
		}
		return expressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS basicGetExpressionCS() {
		return expressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionCS(OCLExpressionCS newExpressionCS) {
		OCLExpressionCS oldExpressionCS = expressionCS;
		expressionCS = newExpressionCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS, oldExpressionCS, expressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
				if (resolve) return getOperationCS();
				return basicGetOperationCS();
			case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
				if (resolve) return getVariableCS();
				return basicGetVariableCS();
			case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
				if (resolve) return getExpressionCS();
				return basicGetExpressionCS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
				setOperationCS((OperationCS)newValue);
				return;
			case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
				setVariableCS((VariableCS)newValue);
				return;
			case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
				setOperationCS((OperationCS)null);
				return;
			case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
				setVariableCS((VariableCS)null);
				return;
			case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CSTPackage.DEF_EXPRESSION_CS__OPERATION_CS:
				return operationCS != null;
			case CSTPackage.DEF_EXPRESSION_CS__VARIABLE_CS:
				return variableCS != null;
			case CSTPackage.DEF_EXPRESSION_CS__EXPRESSION_CS:
				return expressionCS != null;
		}
		return super.eIsSet(featureID);
	}

} //DefExpressionCSImpl
