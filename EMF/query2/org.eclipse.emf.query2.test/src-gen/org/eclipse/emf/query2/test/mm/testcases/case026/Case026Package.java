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
package org.eclipse.emf.query2.test.mm.testcases.case026;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case026.Case026Factory
 * @model kind="package"
 * @generated
 */
public interface Case026Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case026";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case026";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case026";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case026Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case026.impl.Case026PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case026.impl.A26Impl <em>A26</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.impl.A26Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.impl.Case026PackageImpl#getA26()
	 * @generated
	 */
	int A26 = 0;

	/**
	 * The feature id for the '<em><b>Reflect To One</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A26__REFLECT_TO_ONE = 0;

	/**
	 * The feature id for the '<em><b>Reflect To Many</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A26__REFLECT_TO_MANY = 1;

	/**
	 * The number of structural features of the '<em>A26</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A26_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case026.A26 <em>A26</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A26</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.A26
	 * @generated
	 */
	EClass getA26();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToOne <em>Reflect To One</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reflect To One</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToOne()
	 * @see #getA26()
	 * @generated
	 */
	EReference getA26_ReflectToOne();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToMany <em>Reflect To Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reflect To Many</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToMany()
	 * @see #getA26()
	 * @generated
	 */
	EReference getA26_ReflectToMany();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case026Factory getCase026Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case026.impl.A26Impl <em>A26</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case026.impl.A26Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case026.impl.Case026PackageImpl#getA26()
		 * @generated
		 */
		EClass A26 = eINSTANCE.getA26();

		/**
		 * The meta object literal for the '<em><b>Reflect To One</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A26__REFLECT_TO_ONE = eINSTANCE.getA26_ReflectToOne();

		/**
		 * The meta object literal for the '<em><b>Reflect To Many</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A26__REFLECT_TO_MANY = eINSTANCE.getA26_ReflectToMany();

	}

} //Case026Package
