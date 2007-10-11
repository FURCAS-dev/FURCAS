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
 * $Id: PackageDeclarationCSImpl.java,v 1.1 2007/10/11 23:05:02 cdamus Exp $
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
import org.eclipse.ocl.cst.ContextDeclCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl#getContextDecls <em>Context Decls</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.PackageDeclarationCSImpl#getPackageDeclarationCS <em>Package Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageDeclarationCSImpl extends CSTNodeImpl implements PackageDeclarationCS {
	/**
     * The cached value of the '{@link #getPathNameCS() <em>Path Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPathNameCS()
     * @generated
     * @ordered
     */
	protected PathNameCS pathNameCS;

	/**
     * The cached value of the '{@link #getContextDecls() <em>Context Decls</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getContextDecls()
     * @generated
     * @ordered
     */
	protected EList<ContextDeclCS> contextDecls;

	/**
     * The cached value of the '{@link #getPackageDeclarationCS() <em>Package Declaration CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getPackageDeclarationCS()
     * @generated
     * @ordered
     */
	protected PackageDeclarationCS packageDeclarationCS;

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
        return pathNameCS;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPathNameCS(PathNameCS newPathNameCS, NotificationChain msgs) {
        PathNameCS oldPathNameCS = pathNameCS;
        pathNameCS = newPathNameCS;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS, oldPathNameCS, newPathNameCS);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setPathNameCS(PathNameCS newPathNameCS) {
        if (newPathNameCS != pathNameCS) {
            NotificationChain msgs = null;
            if (pathNameCS != null)
                msgs = ((InternalEObject)pathNameCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS, null, msgs);
            if (newPathNameCS != null)
                msgs = ((InternalEObject)newPathNameCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS, null, msgs);
            msgs = basicSetPathNameCS(newPathNameCS, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS, newPathNameCS, newPathNameCS));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ContextDeclCS> getContextDecls() {
        if (contextDecls == null) {
            contextDecls = new EObjectContainmentEList<ContextDeclCS>(ContextDeclCS.class, this, CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS);
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
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS:
                return basicSetPathNameCS(null, msgs);
            case CSTPackage.PACKAGE_DECLARATION_CS__CONTEXT_DECLS:
                return ((InternalEList<?>)getContextDecls()).basicRemove(otherEnd, msgs);
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
            case CSTPackage.PACKAGE_DECLARATION_CS__PATH_NAME_CS:
                return getPathNameCS();
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
