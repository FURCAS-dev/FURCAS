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
package org.eclipse.emf.query2.test.mm.testcases.case007.importer;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences Importer B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterB <em>Importer B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterA <em>Importer A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterPackage#getImporterAReferencesImporterB()
 * @model
 * @generated
 */
public interface ImporterAReferencesImporterB extends EObject {
	/**
	 * Returns the value of the '<em><b>Importer B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Importer B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Importer B</em>' reference.
	 * @see #setImporterB(ImporterB)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterPackage#getImporterAReferencesImporterB_ImporterB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.importer.ImporterAReferencesImporterB' metaObjectMofId='476118E36F917588A96F11DC8DBC001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	ImporterB getImporterB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterB <em>Importer B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Importer B</em>' reference.
	 * @see #getImporterB()
	 * @generated
	 */
	void setImporterB(ImporterB value);

	/**
	 * Returns the value of the '<em><b>Importer A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Importer A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Importer A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterPackage#getImporterAReferencesImporterB_ImporterA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.importer.ImporterAReferencesImporterB' metaObjectMofId='476118E36F917588A96F11DC8DBC001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<ImporterA> getImporterA();

} // ImporterAReferencesImporterB
