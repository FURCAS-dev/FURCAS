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
package org.eclipse.emf.query2.test.mm.testcases.case002;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case002.Case002Factory
 * @model kind="package"
 * @generated
 */
public interface Case002Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case002"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case002"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case002"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case002Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.A2Impl <em>A2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.A2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getA2()
	 * @generated
	 */
	int A2 = 0;

	/**
	 * The number of structural features of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.B2Impl <em>B2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.B2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getB2()
	 * @generated
	 */
	int B2 = 1;

	/**
	 * The number of structural features of the '<em>B2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B2_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.C2Impl <em>C2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.C2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getC2()
	 * @generated
	 */
	int C2 = 2;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C2__B = A2_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>C2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C2_FEATURE_COUNT = A2_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.D2Impl <em>D2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.D2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getD2()
	 * @generated
	 */
	int D2 = 3;

	/**
	 * The number of structural features of the '<em>D2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D2_FEATURE_COUNT = A2_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.E2Impl <em>E2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.E2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getE2()
	 * @generated
	 */
	int E2 = 4;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int E2__B = A2_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>E2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int E2_FEATURE_COUNT = A2_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case002.A2 <em>A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.A2
	 * @generated
	 */
	EClass getA2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case002.B2 <em>B2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.B2
	 * @generated
	 */
	EClass getB2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case002.C2 <em>C2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.C2
	 * @generated
	 */
	EClass getC2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case002.C2#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.C2#getB()
	 * @see #getC2()
	 * @generated
	 */
	EReference getC2_B();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case002.D2 <em>D2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.D2
	 * @generated
	 */
	EClass getD2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case002.E2 <em>E2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>E2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.E2
	 * @generated
	 */
	EClass getE2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case002.E2#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case002.E2#getB()
	 * @see #getE2()
	 * @generated
	 */
	EReference getE2_B();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case002Factory getCase002Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.A2Impl <em>A2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.A2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getA2()
		 * @generated
		 */
		EClass A2 = eINSTANCE.getA2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.B2Impl <em>B2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.B2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getB2()
		 * @generated
		 */
		EClass B2 = eINSTANCE.getB2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.C2Impl <em>C2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.C2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getC2()
		 * @generated
		 */
		EClass C2 = eINSTANCE.getC2();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C2__B = eINSTANCE.getC2_B();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.D2Impl <em>D2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.D2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getD2()
		 * @generated
		 */
		EClass D2 = eINSTANCE.getD2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case002.impl.E2Impl <em>E2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.E2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case002.impl.Case002PackageImpl#getE2()
		 * @generated
		 */
		EClass E2 = eINSTANCE.getE2();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference E2__B = eINSTANCE.getE2_B();

	}

} //Case002Package
