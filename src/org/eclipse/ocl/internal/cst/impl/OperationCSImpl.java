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
 * $Id: OperationCSImpl.java,v 1.2 2007/02/14 14:46:04 cdamus Exp $
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
import org.eclipse.ocl.internal.cst.OperationCS;
import org.eclipse.ocl.internal.cst.PathNameCS;
import org.eclipse.ocl.internal.cst.SimpleNameCS;
import org.eclipse.ocl.internal.cst.TypeCS;
import org.eclipse.ocl.internal.cst.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.OperationCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.OperationCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.OperationCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.OperationCSImpl#getTypeCS <em>Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationCSImpl extends CSTNodeImpl implements OperationCS {
	/**
     * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPathNameCS()
     * @generated
     * @ordered
     */
	protected PathNameCS pathNameCS = null;

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
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
	protected EList<VariableCS> parameters = null;

	/**
     * The cached value of the '{@link #getTypeCS() <em>Type CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTypeCS()
     * @generated
     * @ordered
     */
	protected TypeCS typeCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected OperationCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.OPERATION_CS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PathNameCS getPathNameCS() {
        if (pathNameCS != null && pathNameCS.eIsProxy()) {
            InternalEObject oldPathNameCS = (InternalEObject)pathNameCS;
            pathNameCS = (PathNameCS)eResolveProxy(oldPathNameCS);
            if (pathNameCS != oldPathNameCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.OPERATION_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
            }
        }
        return pathNameCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PathNameCS basicGetPathNameCS() {
        return pathNameCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPathNameCS(PathNameCS newPathNameCS) {
        PathNameCS oldPathNameCS = pathNameCS;
        pathNameCS = newPathNameCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OPERATION_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.OPERATION_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OPERATION_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<VariableCS> getParameters() {
        if (parameters == null) {
            parameters = new EObjectResolvingEList<VariableCS>(VariableCS.class, this, CSTPackage.OPERATION_CS__PARAMETERS);
        }
        return parameters;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeCS getTypeCS() {
        if (typeCS != null && typeCS.eIsProxy()) {
            InternalEObject oldTypeCS = (InternalEObject)typeCS;
            typeCS = (TypeCS)eResolveProxy(oldTypeCS);
            if (typeCS != oldTypeCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.OPERATION_CS__TYPE_CS, oldTypeCS, typeCS));
            }
        }
        return typeCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeCS basicGetTypeCS() {
        return typeCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTypeCS(TypeCS newTypeCS) {
        TypeCS oldTypeCS = typeCS;
        typeCS = newTypeCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.OPERATION_CS__TYPE_CS, oldTypeCS, typeCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.OPERATION_CS__PATH_NAME_CS:
                if (resolve) return getPathNameCS();
                return basicGetPathNameCS();
            case CSTPackage.OPERATION_CS__SIMPLE_NAME_CS:
                if (resolve) return getSimpleNameCS();
                return basicGetSimpleNameCS();
            case CSTPackage.OPERATION_CS__PARAMETERS:
                return getParameters();
            case CSTPackage.OPERATION_CS__TYPE_CS:
                if (resolve) return getTypeCS();
                return basicGetTypeCS();
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
            case CSTPackage.OPERATION_CS__PATH_NAME_CS:
                setPathNameCS((PathNameCS)newValue);
                return;
            case CSTPackage.OPERATION_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)newValue);
                return;
            case CSTPackage.OPERATION_CS__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends VariableCS>)newValue);
                return;
            case CSTPackage.OPERATION_CS__TYPE_CS:
                setTypeCS((TypeCS)newValue);
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
            case CSTPackage.OPERATION_CS__PATH_NAME_CS:
                setPathNameCS((PathNameCS)null);
                return;
            case CSTPackage.OPERATION_CS__SIMPLE_NAME_CS:
                setSimpleNameCS((SimpleNameCS)null);
                return;
            case CSTPackage.OPERATION_CS__PARAMETERS:
                getParameters().clear();
                return;
            case CSTPackage.OPERATION_CS__TYPE_CS:
                setTypeCS((TypeCS)null);
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
            case CSTPackage.OPERATION_CS__PATH_NAME_CS:
                return pathNameCS != null;
            case CSTPackage.OPERATION_CS__SIMPLE_NAME_CS:
                return simpleNameCS != null;
            case CSTPackage.OPERATION_CS__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case CSTPackage.OPERATION_CS__TYPE_CS:
                return typeCS != null;
        }
        return super.eIsSet(featureID);
    }

} //OperationCSImpl
