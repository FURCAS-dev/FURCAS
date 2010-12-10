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
package org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences Imported B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedB <em>Imported B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedA <em>Imported A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedPackage#getImportedAReferencesImportedB()
 * @model
 * @generated
 */
public interface ImportedAReferencesImportedB extends EObject {
	/**
	 * Returns the value of the '<em><b>Imported B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported B</em>' reference.
	 * @see #setImportedB(ImportedB)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedPackage#getImportedAReferencesImportedB_ImportedB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.importer.imported.ImportedAReferencesImportedB' metaObjectMofId='476118E36F917582A96F11DC8455001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	ImportedB getImportedB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedB <em>Imported B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported B</em>' reference.
	 * @see #getImportedB()
	 * @generated
	 */
	void setImportedB(ImportedB value);

	/**
	 * Returns the value of the '<em><b>Imported A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedPackage#getImportedAReferencesImportedB_ImportedA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.importer.imported.ImportedAReferencesImportedB' metaObjectMofId='476118E36F917582A96F11DC8455001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<ImportedA> getImportedA();

} // ImportedAReferencesImportedB
