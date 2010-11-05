/**
 * <copyright>
 *
 * Copyright (c) 2008 Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zeligsoft - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLDocumentCSImpl.java,v 1.2 2009/10/15 19:38:06 ewillink Exp $
 */
package org.eclipse.ocl.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.ocl.cst.OCLDocumentCS;
import org.eclipse.ocl.cst.PackageDeclarationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OCL Document CS</b></em>'.
 * @since 1.3
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.OCLDocumentCSImpl#getPackageDeclarations <em>Package Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OCLDocumentCSImpl
		extends CSTNodeImpl
		implements OCLDocumentCS {

	/**
	 * The cached value of the '{@link #getPackageDeclarations() <em>Package Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageDeclarationCS> packageDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLDocumentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.OCL_DOCUMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageDeclarationCS> getPackageDeclarations() {
		if (packageDeclarations == null) {
			packageDeclarations = new EObjectContainmentEList<PackageDeclarationCS>(
				PackageDeclarationCS.class, this,
				CSTPackage.OCL_DOCUMENT_CS__PACKAGE_DECLARATIONS);
		}
		return packageDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CSTPackage.OCL_DOCUMENT_CS__PACKAGE_DECLARATIONS :
				return ((InternalEList<?>) getPackageDeclarations())
					.basicRemove(otherEnd, msgs);
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
			case CSTPackage.OCL_DOCUMENT_CS__PACKAGE_DECLARATIONS :
				return getPackageDeclarations();
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
			case CSTPackage.OCL_DOCUMENT_CS__PACKAGE_DECLARATIONS :
				getPackageDeclarations().clear();
				getPackageDeclarations().addAll(
					(Collection<? extends PackageDeclarationCS>) newValue);
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
			case CSTPackage.OCL_DOCUMENT_CS__PACKAGE_DECLARATIONS :
				getPackageDeclarations().clear();
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
			case CSTPackage.OCL_DOCUMENT_CS__PACKAGE_DECLARATIONS :
				return packageDeclarations != null
					&& !packageDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OCLDocumentCSImpl
