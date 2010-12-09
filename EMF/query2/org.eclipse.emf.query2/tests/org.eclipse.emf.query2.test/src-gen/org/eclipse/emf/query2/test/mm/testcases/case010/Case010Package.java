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
package org.eclipse.emf.query2.test.mm.testcases.case010;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Factory
 * @model kind="package"
 * @generated
 */
public interface Case010Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case010";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case010";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case010";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case010Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl <em>A10</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getA10()
	 * @generated
	 */
	int A10 = 0;

	/**
	 * The feature id for the '<em><b>Many Bs Not Changeable</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10__MANY_BS_NOT_CHANGEABLE = 0;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10__MANY_BS_ORDERED = 1;

	/**
	 * The feature id for the '<em><b>Many Bs Changeable</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10__MANY_BS_CHANGEABLE = 2;

	/**
	 * The feature id for the '<em><b>Navigable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10__NAVIGABLE = 3;

	/**
	 * The number of structural features of the '<em>A10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A10_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.B10Impl <em>B10</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.B10Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getB10()
	 * @generated
	 */
	int B10 = 1;

	/**
	 * The feature id for the '<em><b>One AChangeable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B10__ONE_ACHANGEABLE = 0;

	/**
	 * The feature id for the '<em><b>One ANot Changeable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B10__ONE_ANOT_CHANGEABLE = 1;

	/**
	 * The number of structural features of the '<em>B10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B10_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.C10Impl <em>C10</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.C10Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getC10()
	 * @generated
	 */
	int C10 = 2;

	/**
	 * The feature id for the '<em><b>First</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C10__FIRST = 0;

	/**
	 * The feature id for the '<em><b>Second</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C10__SECOND = 1;

	/**
	 * The number of structural features of the '<em>C10</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C10_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotNavigableToNotNavigableImpl <em>Not Navigable To Not Navigable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotNavigableToNotNavigableImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getNotNavigableToNotNavigable()
	 * @generated
	 */
	int NOT_NAVIGABLE_TO_NOT_NAVIGABLE = 3;

	/**
	 * The feature id for the '<em><b>Not Navigable From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM = 0;

	/**
	 * The feature id for the '<em><b>Not Navigable To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO = 1;

	/**
	 * The number of structural features of the '<em>Not Navigable To Not Navigable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_NAVIGABLE_TO_NOT_NAVIGABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableToNotChangeableImpl <em>Not Changeable To Not Changeable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableToNotChangeableImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getNotChangeableToNotChangeable()
	 * @generated
	 */
	int NOT_CHANGEABLE_TO_NOT_CHANGEABLE = 4;

	/**
	 * The feature id for the '<em><b>Not Changeable From B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B = 0;

	/**
	 * The feature id for the '<em><b>Not Changeable From A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A = 1;

	/**
	 * The number of structural features of the '<em>Not Changeable To Not Changeable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CHANGEABLE_TO_NOT_CHANGEABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableAndNavigableToNotChangeableAndNavigableImpl <em>Not Changeable And Navigable To Not Changeable And Navigable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableAndNavigableToNotChangeableAndNavigableImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getNotChangeableAndNavigableToNotChangeableAndNavigable()
	 * @generated
	 */
	int NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE = 5;

	/**
	 * The feature id for the '<em><b>Not Changeable And Navigable From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM = 0;

	/**
	 * The feature id for the '<em><b>Not Changeable And Navigable To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO = 1;

	/**
	 * The number of structural features of the '<em>Not Changeable And Navigable To Not Changeable And Navigable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10 <em>A10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A10</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10
	 * @generated
	 */
	EClass getA10();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Many Bs Not Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsNotChangeable()
	 * @see #getA10()
	 * @generated
	 */
	EReference getA10_ManyBsNotChangeable();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsOrdered <em>Many Bs Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Many Bs Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsOrdered()
	 * @see #getA10()
	 * @generated
	 */
	EReference getA10_ManyBsOrdered();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsChangeable <em>Many Bs Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Many Bs Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsChangeable()
	 * @see #getA10()
	 * @generated
	 */
	EReference getA10_ManyBsChangeable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getNavigable <em>Navigable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Navigable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10#getNavigable()
	 * @see #getA10()
	 * @generated
	 */
	EReference getA10_Navigable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10 <em>B10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B10</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.B10
	 * @generated
	 */
	EClass getB10();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneAChangeable <em>One AChangeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>One AChangeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneAChangeable()
	 * @see #getB10()
	 * @generated
	 */
	EReference getB10_OneAChangeable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneANotChangeable <em>One ANot Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>One ANot Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneANotChangeable()
	 * @see #getB10()
	 * @generated
	 */
	EReference getB10_OneANotChangeable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case010.C10 <em>C10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C10</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.C10
	 * @generated
	 */
	EClass getC10();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case010.C10#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>First</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.C10#getFirst()
	 * @see #getC10()
	 * @generated
	 */
	EReference getC10_First();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case010.C10#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Second</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.C10#getSecond()
	 * @see #getC10()
	 * @generated
	 */
	EReference getC10_Second();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable <em>Not Navigable To Not Navigable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Navigable To Not Navigable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable
	 * @generated
	 */
	EClass getNotNavigableToNotNavigable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableFrom <em>Not Navigable From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Not Navigable From</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableFrom()
	 * @see #getNotNavigableToNotNavigable()
	 * @generated
	 */
	EReference getNotNavigableToNotNavigable_NotNavigableFrom();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableTo <em>Not Navigable To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Not Navigable To</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableTo()
	 * @see #getNotNavigableToNotNavigable()
	 * @generated
	 */
	EReference getNotNavigableToNotNavigable_NotNavigableTo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable <em>Not Changeable To Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Changeable To Not Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable
	 * @generated
	 */
	EClass getNotChangeableToNotChangeable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromB <em>Not Changeable From B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Not Changeable From B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromB()
	 * @see #getNotChangeableToNotChangeable()
	 * @generated
	 */
	EReference getNotChangeableToNotChangeable_NotChangeableFromB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromA <em>Not Changeable From A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Not Changeable From A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromA()
	 * @see #getNotChangeableToNotChangeable()
	 * @generated
	 */
	EReference getNotChangeableToNotChangeable_NotChangeableFromA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable <em>Not Changeable And Navigable To Not Changeable And Navigable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Changeable And Navigable To Not Changeable And Navigable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable
	 * @generated
	 */
	EClass getNotChangeableAndNavigableToNotChangeableAndNavigable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable#getNotChangeableAndNavigableFrom <em>Not Changeable And Navigable From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Not Changeable And Navigable From</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable#getNotChangeableAndNavigableFrom()
	 * @see #getNotChangeableAndNavigableToNotChangeableAndNavigable()
	 * @generated
	 */
	EReference getNotChangeableAndNavigableToNotChangeableAndNavigable_NotChangeableAndNavigableFrom();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable#getNotChangeableAndNavigableTo <em>Not Changeable And Navigable To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Not Changeable And Navigable To</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableAndNavigableToNotChangeableAndNavigable#getNotChangeableAndNavigableTo()
	 * @see #getNotChangeableAndNavigableToNotChangeableAndNavigable()
	 * @generated
	 */
	EReference getNotChangeableAndNavigableToNotChangeableAndNavigable_NotChangeableAndNavigableTo();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case010Factory getCase010Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl <em>A10</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.A10Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getA10()
		 * @generated
		 */
		EClass A10 = eINSTANCE.getA10();

		/**
		 * The meta object literal for the '<em><b>Many Bs Not Changeable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A10__MANY_BS_NOT_CHANGEABLE = eINSTANCE.getA10_ManyBsNotChangeable();

		/**
		 * The meta object literal for the '<em><b>Many Bs Ordered</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A10__MANY_BS_ORDERED = eINSTANCE.getA10_ManyBsOrdered();

		/**
		 * The meta object literal for the '<em><b>Many Bs Changeable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A10__MANY_BS_CHANGEABLE = eINSTANCE.getA10_ManyBsChangeable();

		/**
		 * The meta object literal for the '<em><b>Navigable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A10__NAVIGABLE = eINSTANCE.getA10_Navigable();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.B10Impl <em>B10</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.B10Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getB10()
		 * @generated
		 */
		EClass B10 = eINSTANCE.getB10();

		/**
		 * The meta object literal for the '<em><b>One AChangeable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B10__ONE_ACHANGEABLE = eINSTANCE.getB10_OneAChangeable();

		/**
		 * The meta object literal for the '<em><b>One ANot Changeable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B10__ONE_ANOT_CHANGEABLE = eINSTANCE.getB10_OneANotChangeable();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.C10Impl <em>C10</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.C10Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getC10()
		 * @generated
		 */
		EClass C10 = eINSTANCE.getC10();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C10__FIRST = eINSTANCE.getC10_First();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C10__SECOND = eINSTANCE.getC10_Second();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotNavigableToNotNavigableImpl <em>Not Navigable To Not Navigable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotNavigableToNotNavigableImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getNotNavigableToNotNavigable()
		 * @generated
		 */
		EClass NOT_NAVIGABLE_TO_NOT_NAVIGABLE = eINSTANCE.getNotNavigableToNotNavigable();

		/**
		 * The meta object literal for the '<em><b>Not Navigable From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_FROM = eINSTANCE.getNotNavigableToNotNavigable_NotNavigableFrom();

		/**
		 * The meta object literal for the '<em><b>Not Navigable To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_NAVIGABLE_TO_NOT_NAVIGABLE__NOT_NAVIGABLE_TO = eINSTANCE.getNotNavigableToNotNavigable_NotNavigableTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableToNotChangeableImpl <em>Not Changeable To Not Changeable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableToNotChangeableImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getNotChangeableToNotChangeable()
		 * @generated
		 */
		EClass NOT_CHANGEABLE_TO_NOT_CHANGEABLE = eINSTANCE.getNotChangeableToNotChangeable();

		/**
		 * The meta object literal for the '<em><b>Not Changeable From B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_B = eINSTANCE.getNotChangeableToNotChangeable_NotChangeableFromB();

		/**
		 * The meta object literal for the '<em><b>Not Changeable From A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_CHANGEABLE_TO_NOT_CHANGEABLE__NOT_CHANGEABLE_FROM_A = eINSTANCE.getNotChangeableToNotChangeable_NotChangeableFromA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableAndNavigableToNotChangeableAndNavigableImpl <em>Not Changeable And Navigable To Not Changeable And Navigable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.NotChangeableAndNavigableToNotChangeableAndNavigableImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010PackageImpl#getNotChangeableAndNavigableToNotChangeableAndNavigable()
		 * @generated
		 */
		EClass NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE = eINSTANCE.getNotChangeableAndNavigableToNotChangeableAndNavigable();

		/**
		 * The meta object literal for the '<em><b>Not Changeable And Navigable From</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_FROM = eINSTANCE.getNotChangeableAndNavigableToNotChangeableAndNavigable_NotChangeableAndNavigableFrom();

		/**
		 * The meta object literal for the '<em><b>Not Changeable And Navigable To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_CHANGEABLE_AND_NAVIGABLE_TO_NOT_CHANGEABLE_AND_NAVIGABLE__NOT_CHANGEABLE_AND_NAVIGABLE_TO = eINSTANCE.getNotChangeableAndNavigableToNotChangeableAndNavigable_NotChangeableAndNavigableTo();

	}

} //Case010Package
