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
package org.eclipse.emf.query2.test.mm.testcases.case016;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case016.Case016Factory
 * @model kind="package"
 * @generated
 */
public interface Case016Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case016";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case016";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case016";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case016Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case016.impl.Case016PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case016.impl.A16Impl <em>A16</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.A16Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.Case016PackageImpl#getA16()
	 * @generated
	 */
	int A16 = 0;

	/**
	 * The feature id for the '<em><b>B</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A16__B = 0;

	/**
	 * The number of structural features of the '<em>A16</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A16_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case016.impl.B16Impl <em>B16</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.B16Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.Case016PackageImpl#getB16()
	 * @generated
	 */
	int B16 = 1;

	/**
	 * The number of structural features of the '<em>B16</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B16_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case016.A16 <em>A16</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A16</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.A16
	 * @generated
	 */
	EClass getA16();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case016.A16#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.A16#getB()
	 * @see #getA16()
	 * @generated
	 */
	EReference getA16_B();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case016.B16 <em>B16</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B16</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case016.B16
	 * @generated
	 */
	EClass getB16();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case016Factory getCase016Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case016.impl.A16Impl <em>A16</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.A16Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.Case016PackageImpl#getA16()
		 * @generated
		 */
		EClass A16 = eINSTANCE.getA16();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A16__B = eINSTANCE.getA16_B();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case016.impl.B16Impl <em>B16</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.B16Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case016.impl.Case016PackageImpl#getB16()
		 * @generated
		 */
		EClass B16 = eINSTANCE.getB16();

	}

} //Case016Package
