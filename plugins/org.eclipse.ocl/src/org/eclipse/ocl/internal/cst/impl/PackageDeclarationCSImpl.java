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
 * $Id: PackageDeclarationCSImpl.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
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
import org.eclipse.ocl.internal.cst.ContextDeclCS;
import org.eclipse.ocl.internal.cst.PackageDeclarationCS;
import org.eclipse.ocl.internal.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.PackageDeclarationCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.PackageDeclarationCSImpl#getContextDecls <em>Context Decls</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.impl.PackageDeclarationCSImpl#getPackageDeclarationCS <em>Package Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageDeclarationCSImpl extends CSTNodeImpl implements PackageDeclarationCS {
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
     * The cached value of the '{@link #getContextDecls() <em>Context Decls</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getContextDecls()
     * @generated
     * @ordered
     */
	protected EList<ContextDeclCS> contextDecls = null;

	/**
     * The cached value of the '{@link #getPackageDeclarationCS() <em>Package Declaration CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPackageDeclarationCS()
     * @generated
     * @ordered
     */
	protected PackageDeclarationCS packageDeclarationCS = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected PackageDeclarationCSImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return CSTPackage.Literals.PACKAGE_DECLARATION_CS;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
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
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS, oldPathNameCS, pathNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContextDeclCS> getContextDecls() {
        if (contextDecls == null) {
            contextDecls = new EObjectResolvingEList<ContextDeclCS>(ContextDeclCS.class, this, CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS);
        }
        return contextDecls;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PackageDeclarationCS getPackageDeclarationCS() {
        if (packageDeclarationCS != null && packageDeclarationCS.eIsProxy()) {
            InternalEObject oldPackageDeclarationCS = (InternalEObject)packageDeclarationCS;
            packageDeclarationCS = (PackageDeclarationCS)eResolveProxy(oldPackageDeclarationCS);
            if (packageDeclarationCS != oldPackageDeclarationCS) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, CSTPackage.PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS, oldPackageDeclarationCS, packageDeclarationCS));
            }
        }
        return packageDeclarationCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PackageDeclarationCS basicGetPackageDeclarationCS() {
        return packageDeclarationCS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPackageDeclarationCS(PackageDeclarationCS newPackageDeclarationCS) {
        PackageDeclarationCS oldPackageDeclarationCS = packageDeclarationCS;
        packageDeclarationCS = newPackageDeclarationCS;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS, oldPackageDeclarationCS, packageDeclarationCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS:
                if (resolve) return getPathNameCS();
                return basicGetPathNameCS();
            case CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS:
                return getContextDecls();
            case CSTPackage.PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS:
                if (resolve) return getPackageDeclarationCS();
                return basicGetPackageDeclarationCS();
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
            case CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS:
                setPathNameCS((PathNameCS)newValue);
                return;
            case CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS:
                getContextDecls().clear();
                getContextDecls().addAll((Collection<? extends ContextDeclCS>)newValue);
                return;
            case CSTPackage.PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS:
                setPackageDeclarationCS((PackageDeclarationCS)newValue);
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
            case CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS:
                setPathNameCS((PathNameCS)null);
                return;
            case CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS:
                getContextDecls().clear();
                return;
            case CSTPackage.PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS:
                setPackageDeclarationCS((PackageDeclarationCS)null);
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
            case CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS:
                return pathNameCS != null;
            case CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS:
                return contextDecls != null && !contextDecls.isEmpty();
            case CSTPackage.PACKAGE_DECLARATION_CS__PACKAGE_DECLARATION_CS:
                return packageDeclarationCS != null;
        }
        return super.eIsSet(featureID);
    }

} //PackageDeclarationCSImpl
