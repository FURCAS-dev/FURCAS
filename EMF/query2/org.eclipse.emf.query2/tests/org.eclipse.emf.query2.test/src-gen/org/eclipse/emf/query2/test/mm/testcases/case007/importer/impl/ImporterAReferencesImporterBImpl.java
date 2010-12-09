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
package org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterA;
import org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB;
import org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterB;
import org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>AReferences Importer B</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAReferencesImporterBImpl#getImporterB <em>Importer B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAReferencesImporterBImpl#getImporterA <em>Importer A</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImporterAReferencesImporterBImpl extends EObjectImpl implements ImporterAReferencesImporterB {
	/**
	 * The cached value of the '{@link #getImporterB() <em>Importer B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImporterB()
	 * @generated
	 * @ordered
	 */
	protected ImporterB importerB;

	/**
	 * The cached value of the '{@link #getImporterA() <em>Importer A</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImporterA()
	 * @generated
	 * @ordered
	 */
	protected EList<ImporterA> importerA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImporterAReferencesImporterBImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImporterPackage.Literals.IMPORTER_AREFERENCES_IMPORTER_B;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImporterB getImporterB() {
		if (importerB != null && importerB.eIsProxy()) {
			InternalEObject oldImporterB = (InternalEObject)importerB;
			importerB = (ImporterB)eResolveProxy(oldImporterB);
			if (importerB != oldImporterB) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B, oldImporterB, importerB));
			}
		}
		return importerB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImporterB basicGetImporterB() {
		return importerB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImporterB(ImporterB newImporterB) {
		ImporterB oldImporterB = importerB;
		importerB = newImporterB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B, oldImporterB, importerB));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImporterA> getImporterA() {
		if (importerA == null) {
			importerA = new EObjectResolvingEList<ImporterA>(ImporterA.class, this, ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A);
		}
		return importerA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B:
				if (resolve) return getImporterB();
				return basicGetImporterB();
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A:
				return getImporterA();
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
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B:
				setImporterB((ImporterB)newValue);
				return;
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A:
				getImporterA().clear();
				getImporterA().addAll((Collection<? extends ImporterA>)newValue);
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
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B:
				setImporterB((ImporterB)null);
				return;
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A:
				getImporterA().clear();
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
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B:
				return importerB != null;
			case ImporterPackage.IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A:
				return importerA != null && !importerA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ImporterAReferencesImporterBImpl
