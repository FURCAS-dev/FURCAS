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
package org.eclipse.emf.query2.test.mm.testcases.case007.top;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.TopFactory
 * @model kind="package"
 * @generated
 */
public interface TopPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "top";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/top";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007top";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TopPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl#getTopA()
	 * @generated
	 */
	int TOP_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl#getTopB()
	 * @generated
	 */
	int TOP_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAReferencesTopBImpl <em>AReferences Top B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAReferencesTopBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl#getTopAReferencesTopB()
	 * @generated
	 */
	int TOP_AREFERENCES_TOP_B = 2;

	/**
	 * The feature id for the '<em><b>Top B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_AREFERENCES_TOP_B__TOP_B = 0;

	/**
	 * The feature id for the '<em><b>Top A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_AREFERENCES_TOP_B__TOP_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Top B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_AREFERENCES_TOP_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.TopA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.TopA
	 * @generated
	 */
	EClass getTopA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.TopB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.TopB
	 * @generated
	 */
	EClass getTopB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB <em>AReferences Top B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Top B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB
	 * @generated
	 */
	EClass getTopAReferencesTopB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB#getTopB <em>Top B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB#getTopB()
	 * @see #getTopAReferencesTopB()
	 * @generated
	 */
	EReference getTopAReferencesTopB_TopB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB#getTopA <em>Top A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Top A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.TopAReferencesTopB#getTopA()
	 * @see #getTopAReferencesTopB()
	 * @generated
	 */
	EReference getTopAReferencesTopB_TopA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TopFactory getTopFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl#getTopA()
		 * @generated
		 */
		EClass TOP_A = eINSTANCE.getTopA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl#getTopB()
		 * @generated
		 */
		EClass TOP_B = eINSTANCE.getTopB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAReferencesTopBImpl <em>AReferences Top B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopAReferencesTopBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.top.impl.TopPackageImpl#getTopAReferencesTopB()
		 * @generated
		 */
		EClass TOP_AREFERENCES_TOP_B = eINSTANCE.getTopAReferencesTopB();

		/**
		 * The meta object literal for the '<em><b>Top B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_AREFERENCES_TOP_B__TOP_B = eINSTANCE.getTopAReferencesTopB_TopB();

		/**
		 * The meta object literal for the '<em><b>Top A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_AREFERENCES_TOP_B__TOP_A = eINSTANCE.getTopAReferencesTopB_TopA();

	}

} //TopPackage
