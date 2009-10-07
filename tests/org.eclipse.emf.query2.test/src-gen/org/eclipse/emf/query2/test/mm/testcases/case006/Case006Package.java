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
package org.eclipse.emf.query2.test.mm.testcases.case006;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case006.Case006Factory
 * @model kind="package"
 * @generated
 */
public interface Case006Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case006";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case006";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case006";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case006Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.B6Impl <em>B6</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.B6Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl#getB6()
	 * @generated
	 */
	int B6 = 0;

	/**
	 * The number of structural features of the '<em>B6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B6_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.C6Impl <em>C6</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.C6Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl#getC6()
	 * @generated
	 */
	int C6 = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C6__X = 0;

	/**
	 * The feature id for the '<em><b>W</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C6__W = 1;

	/**
	 * The number of structural features of the '<em>C6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C6_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.D6Impl <em>D6</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.D6Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl#getD6()
	 * @generated
	 */
	int D6 = 2;

	/**
	 * The number of structural features of the '<em>D6</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D6_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case006.B6 <em>B6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B6</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.B6
	 * @generated
	 */
	EClass getB6();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6 <em>C6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C6</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.C6
	 * @generated
	 */
	EClass getC6();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>X</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.C6#getX()
	 * @see #getC6()
	 * @generated
	 */
	EReference getC6_X();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6#getW <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>W</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.C6#getW()
	 * @see #getC6()
	 * @generated
	 */
	EReference getC6_W();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case006.D6 <em>D6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D6</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.D6
	 * @generated
	 */
	EClass getD6();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case006Factory getCase006Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.B6Impl <em>B6</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.B6Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl#getB6()
		 * @generated
		 */
		EClass B6 = eINSTANCE.getB6();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.C6Impl <em>C6</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.C6Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl#getC6()
		 * @generated
		 */
		EClass C6 = eINSTANCE.getC6();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C6__X = eINSTANCE.getC6_X();

		/**
		 * The meta object literal for the '<em><b>W</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C6__W = eINSTANCE.getC6_W();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.impl.D6Impl <em>D6</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.D6Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case006.impl.Case006PackageImpl#getD6()
		 * @generated
		 */
		EClass D6 = eINSTANCE.getD6();

	}

} //Case006Package
