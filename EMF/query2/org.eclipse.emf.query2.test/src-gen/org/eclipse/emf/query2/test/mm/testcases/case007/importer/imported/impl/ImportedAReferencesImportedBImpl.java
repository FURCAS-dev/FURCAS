/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedA;
import org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB;
import org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedB;
import org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Imported B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAReferencesImportedBImpl#getImportedB <em>Imported B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAReferencesImportedBImpl#getImportedA <em>Imported A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportedAReferencesImportedBImpl extends EObjectImpl implements ImportedAReferencesImportedB {
	/**
	 * The cached value of the '{@link #getImportedB() <em>Imported B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedB()
	 * @generated
	 * @ordered
	 */
	protected ImportedB importedB;

	/**
	 * The cached value of the '{@link #getImportedA() <em>Imported A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedA()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportedA> importedA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportedAReferencesImportedBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImportedPackage.Literals.IMPORTED_AREFERENCES_IMPORTED_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportedB getImportedB() {
		if (importedB != null && importedB.eIsProxy()) {
			InternalEObject oldImportedB = (InternalEObject)importedB;
			importedB = (ImportedB)eResolveProxy(oldImportedB);
			if (importedB != oldImportedB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B, oldImportedB, importedB));
			}
		}
		return importedB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportedB basicGetImportedB() {
		return importedB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportedB(ImportedB newImportedB) {
		ImportedB oldImportedB = importedB;
		importedB = newImportedB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B, oldImportedB, importedB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportedA> getImportedA() {
		if (importedA == null) {
			importedA = new EObjectResolvingEList<ImportedA>(ImportedA.class, this, ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A);
		}
		return importedA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B:
				if (resolve) return getImportedB();
				return basicGetImportedB();
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A:
				return getImportedA();
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
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B:
				setImportedB((ImportedB)newValue);
				return;
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A:
				getImportedA().clear();
				getImportedA().addAll((Collection<? extends ImportedA>)newValue);
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
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B:
				setImportedB((ImportedB)null);
				return;
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A:
				getImportedA().clear();
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
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B:
				return importedB != null;
			case ImportedPackage.IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A:
				return importedA != null && !importedA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ImportedAReferencesImportedBImpl
