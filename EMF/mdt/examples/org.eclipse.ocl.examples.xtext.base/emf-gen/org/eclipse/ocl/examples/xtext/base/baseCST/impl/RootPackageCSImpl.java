/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: RootPackageCSImpl.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Package CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.RootPackageCSImpl#getOwnedImport <em>Owned Import</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.RootPackageCSImpl#getOwnedLibrary <em>Owned Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RootPackageCSImpl extends PackageCSImpl implements RootPackageCS
{
	/**
	 * The cached value of the '{@link #getOwnedImport() <em>Owned Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImport()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> ownedImport;

	/**
	 * The cached value of the '{@link #getOwnedLibrary() <em>Owned Library</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLibrary()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryCS> ownedLibrary;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootPackageCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return BaseCSTPackage.Literals.ROOT_PACKAGE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportCS> getOwnedImport()
	{
		if (ownedImport == null)
		{
			ownedImport = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT);
		}
		return ownedImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryCS> getOwnedLibrary()
	{
		if (ownedLibrary == null)
		{
			ownedLibrary = new EObjectContainmentEList<LibraryCS>(LibraryCS.class, this, BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY);
		}
		return ownedLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT:
				return ((InternalEList<?>)getOwnedImport()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY:
				return ((InternalEList<?>)getOwnedLibrary()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT:
				return getOwnedImport();
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY:
				return getOwnedLibrary();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT:
				getOwnedImport().clear();
				getOwnedImport().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY:
				getOwnedLibrary().clear();
				getOwnedLibrary().addAll((Collection<? extends LibraryCS>)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT:
				getOwnedImport().clear();
				return;
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY:
				getOwnedLibrary().clear();
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT:
				return ownedImport != null && !ownedImport.isEmpty();
			case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY:
				return ownedLibrary != null && !ownedLibrary.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (derivedFeatureID)
			{
				case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT: return BaseCSTPackage.ROOT_CS__OWNED_IMPORT;
				case BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY: return BaseCSTPackage.ROOT_CS__OWNED_LIBRARY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (baseFeatureID)
			{
				case BaseCSTPackage.ROOT_CS__OWNED_IMPORT: return BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_IMPORT;
				case BaseCSTPackage.ROOT_CS__OWNED_LIBRARY: return BaseCSTPackage.ROOT_PACKAGE_CS__OWNED_LIBRARY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitRootPackageCS(this);
	}
} //RootPackageCSImpl
