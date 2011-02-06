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
package org.eclipse.emf.query2.test.mm.testcases.case018;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Factory
 * @model kind="package"
 * @generated
 */
public interface Case018Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case018"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case018"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case018"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case018Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.A18Impl <em>A18</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.A18Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl#getA18()
	 * @generated
	 */
	int A18 = 0;

	/**
	 * The feature id for the '<em><b>Foundation Attribute A1f</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A18__FOUNDATION_ATTRIBUTE_A1F = 0;

	/**
	 * The number of structural features of the '<em>A18</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A18_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.B18Impl <em>B18</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.B18Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl#getB18()
	 * @generated
	 */
	int B18 = 1;

	/**
	 * The feature id for the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B18__ONE_PRIMITIVE = Case001fPackage.B1F__ONE_PRIMITIVE;

	/**
	 * The feature id for the '<em><b>Special One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B18__SPECIAL_ONE_PRIMITIVE = Case001fPackage.B1F_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>B18</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B18_FEATURE_COUNT = Case001fPackage.B1F_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.usesA1FromFoundationImpl <em>uses A1 From Foundation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.usesA1FromFoundationImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl#getusesA1FromFoundation()
	 * @generated
	 */
	int USES_A1_FROM_FOUNDATION = 2;

	/**
	 * The feature id for the '<em><b>A1 From Foundation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION = 0;

	/**
	 * The feature id for the '<em><b>A18</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USES_A1_FROM_FOUNDATION__A18 = 1;

	/**
	 * The number of structural features of the '<em>uses A1 From Foundation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USES_A1_FROM_FOUNDATION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case018.A18 <em>A18</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A18</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.A18
	 * @generated
	 */
	EClass getA18();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case018.A18#getFoundationAttributeA1f <em>Foundation Attribute A1f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foundation Attribute A1f</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.A18#getFoundationAttributeA1f()
	 * @see #getA18()
	 * @generated
	 */
	EReference getA18_FoundationAttributeA1f();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case018.B18 <em>B18</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B18</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.B18
	 * @generated
	 */
	EClass getB18();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case018.B18#getSpecialOnePrimitive <em>Special One Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Special One Primitive</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.B18#getSpecialOnePrimitive()
	 * @see #getB18()
	 * @generated
	 */
	EAttribute getB18_SpecialOnePrimitive();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation <em>uses A1 From Foundation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>uses A1 From Foundation</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation
	 * @generated
	 */
	EClass getusesA1FromFoundation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA1FromFoundation <em>A1 From Foundation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A1 From Foundation</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA1FromFoundation()
	 * @see #getusesA1FromFoundation()
	 * @generated
	 */
	EReference getusesA1FromFoundation_A1FromFoundation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA18 <em>A18</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A18</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA18()
	 * @see #getusesA1FromFoundation()
	 * @generated
	 */
	EReference getusesA1FromFoundation_A18();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case018Factory getCase018Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.A18Impl <em>A18</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.A18Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl#getA18()
		 * @generated
		 */
		EClass A18 = eINSTANCE.getA18();

		/**
		 * The meta object literal for the '<em><b>Foundation Attribute A1f</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A18__FOUNDATION_ATTRIBUTE_A1F = eINSTANCE.getA18_FoundationAttributeA1f();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.B18Impl <em>B18</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.B18Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl#getB18()
		 * @generated
		 */
		EClass B18 = eINSTANCE.getB18();

		/**
		 * The meta object literal for the '<em><b>Special One Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B18__SPECIAL_ONE_PRIMITIVE = eINSTANCE.getB18_SpecialOnePrimitive();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.impl.usesA1FromFoundationImpl <em>uses A1 From Foundation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.usesA1FromFoundationImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case018.impl.Case018PackageImpl#getusesA1FromFoundation()
		 * @generated
		 */
		EClass USES_A1_FROM_FOUNDATION = eINSTANCE.getusesA1FromFoundation();

		/**
		 * The meta object literal for the '<em><b>A1 From Foundation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USES_A1_FROM_FOUNDATION__A1_FROM_FOUNDATION = eINSTANCE.getusesA1FromFoundation_A1FromFoundation();

		/**
		 * The meta object literal for the '<em><b>A18</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USES_A1_FROM_FOUNDATION__A18 = eINSTANCE.getusesA1FromFoundation_A18();

	}

} //Case018Package
