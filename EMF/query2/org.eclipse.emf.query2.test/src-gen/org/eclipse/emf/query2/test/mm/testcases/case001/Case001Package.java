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
package org.eclipse.emf.query2.test.mm.testcases.case001;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Factory
 * @model kind="package"
 * @generated
 */
public interface Case001Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case001";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case001";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case001";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case001Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.SuperImpl <em>Super</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.SuperImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getSuper()
	 * @generated
	 */
	int SUPER = 2;

	/**
	 * The number of structural features of the '<em>Super</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.A1Impl <em>A1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.A1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getA1()
	 * @generated
	 */
	int A1 = 0;

	/**
	 * The feature id for the '<em><b>Bs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1__BS = SUPER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>A1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1_FEATURE_COUNT = SUPER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.B1Impl <em>B1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.B1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getB1()
	 * @generated
	 */
	int B1 = 1;

	/**
	 * The number of structural features of the '<em>B1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B1_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.AReferencesBImpl <em>AReferences B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.AReferencesBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getAReferencesB()
	 * @generated
	 */
	int AREFERENCES_B = 3;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREFERENCES_B__B = 0;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREFERENCES_B__A = 1;

	/**
	 * The number of structural features of the '<em>AReferences B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREFERENCES_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case001.A1 <em>A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.A1
	 * @generated
	 */
	EClass getA1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case001.A1#getBs <em>Bs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bs</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.A1#getBs()
	 * @see #getA1()
	 * @generated
	 */
	EReference getA1_Bs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case001.B1 <em>B1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.B1
	 * @generated
	 */
	EClass getB1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case001.Super <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Super
	 * @generated
	 */
	EClass getSuper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB <em>AReferences B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB
	 * @generated
	 */
	EClass getAReferencesB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getB()
	 * @see #getAReferencesB()
	 * @generated
	 */
	EReference getAReferencesB_B();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getA()
	 * @see #getAReferencesB()
	 * @generated
	 */
	EReference getAReferencesB_A();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case001Factory getCase001Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.A1Impl <em>A1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.A1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getA1()
		 * @generated
		 */
		EClass A1 = eINSTANCE.getA1();

		/**
		 * The meta object literal for the '<em><b>Bs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A1__BS = eINSTANCE.getA1_Bs();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.B1Impl <em>B1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.B1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getB1()
		 * @generated
		 */
		EClass B1 = eINSTANCE.getB1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.SuperImpl <em>Super</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.SuperImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getSuper()
		 * @generated
		 */
		EClass SUPER = eINSTANCE.getSuper();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.impl.AReferencesBImpl <em>AReferences B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.AReferencesBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001PackageImpl#getAReferencesB()
		 * @generated
		 */
		EClass AREFERENCES_B = eINSTANCE.getAReferencesB();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREFERENCES_B__B = eINSTANCE.getAReferencesB_B();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREFERENCES_B__A = eINSTANCE.getAReferencesB_A();

	}

} //Case001Package
