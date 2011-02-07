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
package org.eclipse.emf.query2.test.mm.testcases.case009;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case009.Case009Factory
 * @model kind="package"
 * @generated
 */
public interface Case009Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case009"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case009"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case009"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case009Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case009.impl.Case009PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case009.impl.ClassThrowsExceptionImpl <em>Class Throws Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.ClassThrowsExceptionImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.Case009PackageImpl#getClassThrowsException()
	 * @generated
	 */
	int CLASS_THROWS_EXCEPTION = 0;

	/**
	 * The number of structural features of the '<em>Class Throws Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_THROWS_EXCEPTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case009.impl.A9Impl <em>A9</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.A9Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.Case009PackageImpl#getA9()
	 * @generated
	 */
	int A9 = 1;

	/**
	 * The number of structural features of the '<em>A9</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A9_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case009.ClassThrowsException <em>Class Throws Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Throws Exception</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case009.ClassThrowsException
	 * @generated
	 */
	EClass getClassThrowsException();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case009.A9 <em>A9</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A9</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case009.A9
	 * @generated
	 */
	EClass getA9();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case009Factory getCase009Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case009.impl.ClassThrowsExceptionImpl <em>Class Throws Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.ClassThrowsExceptionImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.Case009PackageImpl#getClassThrowsException()
		 * @generated
		 */
		EClass CLASS_THROWS_EXCEPTION = eINSTANCE.getClassThrowsException();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case009.impl.A9Impl <em>A9</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.A9Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case009.impl.Case009PackageImpl#getA9()
		 * @generated
		 */
		EClass A9 = eINSTANCE.getA9();

	}

} //Case009Package
