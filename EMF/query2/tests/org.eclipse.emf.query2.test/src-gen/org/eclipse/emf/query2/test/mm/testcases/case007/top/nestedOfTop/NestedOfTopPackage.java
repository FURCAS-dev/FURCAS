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
package org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopFactory
 * @model kind="package"
 * @generated
 */
public interface NestedOfTopPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "nestedOfTop";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/top/nestedOfTop";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007nestedOfTop";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NestedOfTopPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl#getNestedOfTopA()
	 * @generated
	 */
	int NESTED_OF_TOP_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_TOP_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl#getNestedOfTopB()
	 * @generated
	 */
	int NESTED_OF_TOP_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_TOP_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAReferencesNestedOfTopBImpl <em>AReferences Nested Of Top B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAReferencesNestedOfTopBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl#getNestedOfTopAReferencesNestedOfTopB()
	 * @generated
	 */
	int NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B = 2;

	/**
	 * The feature id for the '<em><b>Nested Of Top B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B = 0;

	/**
	 * The feature id for the '<em><b>Nested Of Top A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Nested Of Top B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopA
	 * @generated
	 */
	EClass getNestedOfTopA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopB
	 * @generated
	 */
	EClass getNestedOfTopB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB <em>AReferences Nested Of Top B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Nested Of Top B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB
	 * @generated
	 */
	EClass getNestedOfTopAReferencesNestedOfTopB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB#getNestedOfTopB <em>Nested Of Top B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Nested Of Top B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB#getNestedOfTopB()
	 * @see #getNestedOfTopAReferencesNestedOfTopB()
	 * @generated
	 */
	EReference getNestedOfTopAReferencesNestedOfTopB_NestedOfTopB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB#getNestedOfTopA <em>Nested Of Top A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Nested Of Top A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.NestedOfTopAReferencesNestedOfTopB#getNestedOfTopA()
	 * @see #getNestedOfTopAReferencesNestedOfTopB()
	 * @generated
	 */
	EReference getNestedOfTopAReferencesNestedOfTopB_NestedOfTopA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NestedOfTopFactory getNestedOfTopFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl#getNestedOfTopA()
		 * @generated
		 */
		EClass NESTED_OF_TOP_A = eINSTANCE.getNestedOfTopA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl#getNestedOfTopB()
		 * @generated
		 */
		EClass NESTED_OF_TOP_B = eINSTANCE.getNestedOfTopB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAReferencesNestedOfTopBImpl <em>AReferences Nested Of Top B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopAReferencesNestedOfTopBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.nestedOfTop.impl.NestedOfTopPackageImpl#getNestedOfTopAReferencesNestedOfTopB()
		 * @generated
		 */
		EClass NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B = eINSTANCE.getNestedOfTopAReferencesNestedOfTopB();

		/**
		 * The meta object literal for the '<em><b>Nested Of Top B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_B = eINSTANCE.getNestedOfTopAReferencesNestedOfTopB_NestedOfTopB();

		/**
		 * The meta object literal for the '<em><b>Nested Of Top A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_OF_TOP_AREFERENCES_NESTED_OF_TOP_B__NESTED_OF_TOP_A = eINSTANCE.getNestedOfTopAReferencesNestedOfTopB_NestedOfTopA();

	}

} //NestedOfTopPackage
