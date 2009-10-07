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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredFactory
 * @model kind="package"
 * @generated
 */
public interface NestedOfClusteredPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nestedOfClustered";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/clustered/nestedOfClustered";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007clusterednestedOfClustered";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NestedOfClusteredPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredAImpl <em>nested Of Clustered A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl#getnestedOfClusteredA()
	 * @generated
	 */
	int NESTED_OF_CLUSTERED_A = 0;

	/**
	 * The number of structural features of the '<em>nested Of Clustered A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_CLUSTERED_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredBImpl <em>nested Of Clustered B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl#getnestedOfClusteredB()
	 * @generated
	 */
	int NESTED_OF_CLUSTERED_B = 1;

	/**
	 * The number of structural features of the '<em>nested Of Clustered B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_CLUSTERED_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredAReferencesNestedOfClusteredBImpl <em>AReferences Nested Of Clustered B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredAReferencesNestedOfClusteredBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl#getNestedOfClusteredAReferencesNestedOfClusteredB()
	 * @generated
	 */
	int NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B = 2;

	/**
	 * The feature id for the '<em><b>Nested Of Clustered B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B = 0;

	/**
	 * The feature id for the '<em><b>Nested Of Clustered A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Nested Of Clustered B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredA <em>nested Of Clustered A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>nested Of Clustered A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredA
	 * @generated
	 */
	EClass getnestedOfClusteredA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredB <em>nested Of Clustered B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>nested Of Clustered B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredB
	 * @generated
	 */
	EClass getnestedOfClusteredB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB <em>AReferences Nested Of Clustered B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Nested Of Clustered B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB
	 * @generated
	 */
	EClass getNestedOfClusteredAReferencesNestedOfClusteredB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredB <em>Nested Of Clustered B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Nested Of Clustered B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredB()
	 * @see #getNestedOfClusteredAReferencesNestedOfClusteredB()
	 * @generated
	 */
	EReference getNestedOfClusteredAReferencesNestedOfClusteredB_NestedOfClusteredB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredA <em>Nested Of Clustered A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nested Of Clustered A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredA()
	 * @see #getNestedOfClusteredAReferencesNestedOfClusteredB()
	 * @generated
	 */
	EReference getNestedOfClusteredAReferencesNestedOfClusteredB_NestedOfClusteredA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NestedOfClusteredFactory getNestedOfClusteredFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredAImpl <em>nested Of Clustered A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl#getnestedOfClusteredA()
		 * @generated
		 */
		EClass NESTED_OF_CLUSTERED_A = eINSTANCE.getnestedOfClusteredA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredBImpl <em>nested Of Clustered B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.nestedOfClusteredBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl#getnestedOfClusteredB()
		 * @generated
		 */
		EClass NESTED_OF_CLUSTERED_B = eINSTANCE.getnestedOfClusteredB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredAReferencesNestedOfClusteredBImpl <em>AReferences Nested Of Clustered B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredAReferencesNestedOfClusteredBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredPackageImpl#getNestedOfClusteredAReferencesNestedOfClusteredB()
		 * @generated
		 */
		EClass NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B = eINSTANCE.getNestedOfClusteredAReferencesNestedOfClusteredB();

		/**
		 * The meta object literal for the '<em><b>Nested Of Clustered B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_B = eINSTANCE.getNestedOfClusteredAReferencesNestedOfClusteredB_NestedOfClusteredB();

		/**
		 * The meta object literal for the '<em><b>Nested Of Clustered A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_OF_CLUSTERED_AREFERENCES_NESTED_OF_CLUSTERED_B__NESTED_OF_CLUSTERED_A = eINSTANCE.getNestedOfClusteredAReferencesNestedOfClusteredB_NestedOfClusteredA();

	}

} //NestedOfClusteredPackage
