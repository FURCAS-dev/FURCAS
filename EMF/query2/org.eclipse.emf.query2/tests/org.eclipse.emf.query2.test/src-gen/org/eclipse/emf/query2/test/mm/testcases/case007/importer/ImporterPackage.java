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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterFactory
 * @model kind="package"
 * @generated
 */
public interface ImporterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "importer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/importer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007importer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImporterPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl#getImporterA()
	 * @generated
	 */
	int IMPORTER_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTER_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl#getImporterB()
	 * @generated
	 */
	int IMPORTER_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTER_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAReferencesImporterBImpl <em>AReferences Importer B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAReferencesImporterBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl#getImporterAReferencesImporterB()
	 * @generated
	 */
	int IMPORTER_AREFERENCES_IMPORTER_B = 2;

	/**
	 * The feature id for the '<em><b>Importer B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B = 0;

	/**
	 * The feature id for the '<em><b>Importer A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Importer B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORTER_AREFERENCES_IMPORTER_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterA
	 * @generated
	 */
	EClass getImporterA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterB
	 * @generated
	 */
	EClass getImporterB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB <em>AReferences Importer B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Importer B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB
	 * @generated
	 */
	EClass getImporterAReferencesImporterB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterB <em>Importer B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Importer B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterB()
	 * @see #getImporterAReferencesImporterB()
	 * @generated
	 */
	EReference getImporterAReferencesImporterB_ImporterB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterA <em>Importer A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Importer A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.ImporterAReferencesImporterB#getImporterA()
	 * @see #getImporterAReferencesImporterB()
	 * @generated
	 */
	EReference getImporterAReferencesImporterB_ImporterA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImporterFactory getImporterFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl#getImporterA()
		 * @generated
		 */
		EClass IMPORTER_A = eINSTANCE.getImporterA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl#getImporterB()
		 * @generated
		 */
		EClass IMPORTER_B = eINSTANCE.getImporterB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAReferencesImporterBImpl <em>AReferences Importer B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterAReferencesImporterBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.importer.impl.ImporterPackageImpl#getImporterAReferencesImporterB()
		 * @generated
		 */
		EClass IMPORTER_AREFERENCES_IMPORTER_B = eINSTANCE.getImporterAReferencesImporterB();

		/**
		 * The meta object literal for the '<em><b>Importer B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_B = eINSTANCE.getImporterAReferencesImporterB_ImporterB();

		/**
		 * The meta object literal for the '<em><b>Importer A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORTER_AREFERENCES_IMPORTER_B__IMPORTER_A = eINSTANCE.getImporterAReferencesImporterB_ImporterA();

	}

} //ImporterPackage
