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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedFactory
 * @model kind="package"
 * @generated
 */
public interface ImportedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "imported"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/importer/imported"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007imported"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImportedPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl#getImportedA()
	 * @generated
	 */
	int IMPORTED_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl#getImportedB()
	 * @generated
	 */
	int IMPORTED_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAReferencesImportedBImpl <em>AReferences Imported B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAReferencesImportedBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl#getImportedAReferencesImportedB()
	 * @generated
	 */
	int IMPORTED_AREFERENCES_IMPORTED_B = 2;

	/**
	 * The feature id for the '<em><b>Imported B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B = 0;

	/**
	 * The feature id for the '<em><b>Imported A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Imported B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTED_AREFERENCES_IMPORTED_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedA
	 * @generated
	 */
	EClass getImportedA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedB
	 * @generated
	 */
	EClass getImportedB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB <em>AReferences Imported B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Imported B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB
	 * @generated
	 */
	EClass getImportedAReferencesImportedB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedB <em>Imported B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Imported B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedB()
	 * @see #getImportedAReferencesImportedB()
	 * @generated
	 */
	EReference getImportedAReferencesImportedB_ImportedB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedA <em>Imported A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imported A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.ImportedAReferencesImportedB#getImportedA()
	 * @see #getImportedAReferencesImportedB()
	 * @generated
	 */
	EReference getImportedAReferencesImportedB_ImportedA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImportedFactory getImportedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl#getImportedA()
		 * @generated
		 */
		EClass IMPORTED_A = eINSTANCE.getImportedA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl#getImportedB()
		 * @generated
		 */
		EClass IMPORTED_B = eINSTANCE.getImportedB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAReferencesImportedBImpl <em>AReferences Imported B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedAReferencesImportedBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.imported.impl.ImportedPackageImpl#getImportedAReferencesImportedB()
		 * @generated
		 */
		EClass IMPORTED_AREFERENCES_IMPORTED_B = eINSTANCE.getImportedAReferencesImportedB();

		/**
		 * The meta object literal for the '<em><b>Imported B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_B = eINSTANCE.getImportedAReferencesImportedB_ImportedB();

		/**
		 * The meta object literal for the '<em><b>Imported A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTED_AREFERENCES_IMPORTED_B__IMPORTED_A = eINSTANCE.getImportedAReferencesImportedB_ImportedA();

	}

} //ImportedPackage
