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
package org.eclipse.emf.query2.test.mm.testcases.case012;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case012.Case012Factory
 * @model kind="package"
 * @generated
 */
public interface Case012Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case012";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case012";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case012";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case012Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.C12Impl <em>C12</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.C12Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getC12()
	 * @generated
	 */
	int C12 = 0;

	/**
	 * The number of structural features of the '<em>C12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C12_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.D12Impl <em>D12</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.D12Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getD12()
	 * @generated
	 */
	int D12 = 1;

	/**
	 * The number of structural features of the '<em>D12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D12_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.A12Impl <em>A12</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.A12Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getA12()
	 * @generated
	 */
	int A12 = 2;

	/**
	 * The feature id for the '<em><b>Attribute D12</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A12__ATTRIBUTE_D12 = 0;

	/**
	 * The number of structural features of the '<em>A12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A12_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.B12Impl <em>B12</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.B12Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getB12()
	 * @generated
	 */
	int B12 = 3;

	/**
	 * The number of structural features of the '<em>B12</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B12_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case012.C12 <em>C12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C12</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.C12
	 * @generated
	 */
	EClass getC12();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case012.D12 <em>D12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D12</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.D12
	 * @generated
	 */
	EClass getD12();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case012.A12 <em>A12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A12</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.A12
	 * @generated
	 */
	EClass getA12();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case012.A12#getAttributeD12 <em>Attribute D12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute D12</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.A12#getAttributeD12()
	 * @see #getA12()
	 * @generated
	 */
	EReference getA12_AttributeD12();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case012.B12 <em>B12</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B12</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.B12
	 * @generated
	 */
	EClass getB12();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case012Factory getCase012Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.C12Impl <em>C12</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.C12Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getC12()
		 * @generated
		 */
		EClass C12 = eINSTANCE.getC12();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.D12Impl <em>D12</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.D12Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getD12()
		 * @generated
		 */
		EClass D12 = eINSTANCE.getD12();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.A12Impl <em>A12</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.A12Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getA12()
		 * @generated
		 */
		EClass A12 = eINSTANCE.getA12();

		/**
		 * The meta object literal for the '<em><b>Attribute D12</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A12__ATTRIBUTE_D12 = eINSTANCE.getA12_AttributeD12();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.impl.B12Impl <em>B12</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.B12Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case012.impl.Case012PackageImpl#getB12()
		 * @generated
		 */
		EClass B12 = eINSTANCE.getB12();

	}

} //Case012Package
