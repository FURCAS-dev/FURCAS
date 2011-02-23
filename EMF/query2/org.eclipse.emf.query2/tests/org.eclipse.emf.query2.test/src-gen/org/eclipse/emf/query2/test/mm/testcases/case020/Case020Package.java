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
package org.eclipse.emf.query2.test.mm.testcases.case020;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Factory
 * @model kind="package"
 * @generated
 */
public interface Case020Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case020"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case020"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case020"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case020Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super1Impl <em>Super1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getSuper1()
	 * @generated
	 */
	int SUPER1 = 0;

	/**
	 * The number of structural features of the '<em>Super1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER1_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super2Impl <em>Super2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getSuper2()
	 * @generated
	 */
	int SUPER2 = 1;

	/**
	 * The number of structural features of the '<em>Super2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPER2_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.ChildInheritsMultiple1Impl <em>Child Inherits Multiple1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.ChildInheritsMultiple1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getChildInheritsMultiple1()
	 * @generated
	 */
	int CHILD_INHERITS_MULTIPLE1 = 2;

	/**
	 * The number of structural features of the '<em>Child Inherits Multiple1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_INHERITS_MULTIPLE1_FEATURE_COUNT = SUPER1_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl <em>A20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getA20()
	 * @generated
	 */
	int A20 = 3;

	/**
	 * The feature id for the '<em><b>Super1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A20__SUPER1 = 0;

	/**
	 * The feature id for the '<em><b>Super2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A20__SUPER2 = 1;

	/**
	 * The feature id for the '<em><b>Ref Super1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A20__REF_SUPER1 = 2;

	/**
	 * The feature id for the '<em><b>Ref Super2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A20__REF_SUPER2 = 3;

	/**
	 * The number of structural features of the '<em>A20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A20_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case020.Super1 <em>Super1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Super1
	 * @generated
	 */
	EClass getSuper1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case020.Super2 <em>Super2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Super2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Super2
	 * @generated
	 */
	EClass getSuper2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case020.ChildInheritsMultiple1 <em>Child Inherits Multiple1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Inherits Multiple1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.ChildInheritsMultiple1
	 * @generated
	 */
	EClass getChildInheritsMultiple1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20 <em>A20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A20</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.A20
	 * @generated
	 */
	EClass getA20();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper1 <em>Super1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper1()
	 * @see #getA20()
	 * @generated
	 */
	EReference getA20_Super1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper2 <em>Super2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Super2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper2()
	 * @see #getA20()
	 * @generated
	 */
	EReference getA20_Super2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper1 <em>Ref Super1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Super1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper1()
	 * @see #getA20()
	 * @generated
	 */
	EReference getA20_RefSuper1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper2 <em>Ref Super2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref Super2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper2()
	 * @see #getA20()
	 * @generated
	 */
	EReference getA20_RefSuper2();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case020Factory getCase020Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super1Impl <em>Super1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getSuper1()
		 * @generated
		 */
		EClass SUPER1 = eINSTANCE.getSuper1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super2Impl <em>Super2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Super2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getSuper2()
		 * @generated
		 */
		EClass SUPER2 = eINSTANCE.getSuper2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.ChildInheritsMultiple1Impl <em>Child Inherits Multiple1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.ChildInheritsMultiple1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getChildInheritsMultiple1()
		 * @generated
		 */
		EClass CHILD_INHERITS_MULTIPLE1 = eINSTANCE.getChildInheritsMultiple1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl <em>A20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.A20Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020PackageImpl#getA20()
		 * @generated
		 */
		EClass A20 = eINSTANCE.getA20();

		/**
		 * The meta object literal for the '<em><b>Super1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A20__SUPER1 = eINSTANCE.getA20_Super1();

		/**
		 * The meta object literal for the '<em><b>Super2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A20__SUPER2 = eINSTANCE.getA20_Super2();

		/**
		 * The meta object literal for the '<em><b>Ref Super1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A20__REF_SUPER1 = eINSTANCE.getA20_RefSuper1();

		/**
		 * The meta object literal for the '<em><b>Ref Super2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A20__REF_SUPER2 = eINSTANCE.getA20_RefSuper2();

	}

} //Case020Package
