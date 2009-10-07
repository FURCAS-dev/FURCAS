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
package org.eclipse.emf.query2.test.mm.testcases.case007.base;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseFactory
 * @model kind="package"
 * @generated
 */
public interface BasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/base";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007base";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasePackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl#getBaseA()
	 * @generated
	 */
	int BASE_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl#getBaseB()
	 * @generated
	 */
	int BASE_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAReferencesBaseBImpl <em>AReferences Base B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAReferencesBaseBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl#getBaseAReferencesBaseB()
	 * @generated
	 */
	int BASE_AREFERENCES_BASE_B = 2;

	/**
	 * The feature id for the '<em><b>Base B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_AREFERENCES_BASE_B__BASE_B = 0;

	/**
	 * The feature id for the '<em><b>Base A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_AREFERENCES_BASE_B__BASE_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Base B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_AREFERENCES_BASE_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseA
	 * @generated
	 */
	EClass getBaseA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseB
	 * @generated
	 */
	EClass getBaseB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB <em>AReferences Base B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Base B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB
	 * @generated
	 */
	EClass getBaseAReferencesBaseB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseB <em>Base B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseB()
	 * @see #getBaseAReferencesBaseB()
	 * @generated
	 */
	EReference getBaseAReferencesBaseB_BaseB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseA <em>Base A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Base A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.BaseAReferencesBaseB#getBaseA()
	 * @see #getBaseAReferencesBaseB()
	 * @generated
	 */
	EReference getBaseAReferencesBaseB_BaseA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseFactory getBaseFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl#getBaseA()
		 * @generated
		 */
		EClass BASE_A = eINSTANCE.getBaseA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl#getBaseB()
		 * @generated
		 */
		EClass BASE_B = eINSTANCE.getBaseB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAReferencesBaseBImpl <em>AReferences Base B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BaseAReferencesBaseBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.base.impl.BasePackageImpl#getBaseAReferencesBaseB()
		 * @generated
		 */
		EClass BASE_AREFERENCES_BASE_B = eINSTANCE.getBaseAReferencesBaseB();

		/**
		 * The meta object literal for the '<em><b>Base B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_AREFERENCES_BASE_B__BASE_B = eINSTANCE.getBaseAReferencesBaseB_BaseB();

		/**
		 * The meta object literal for the '<em><b>Base A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_AREFERENCES_BASE_B__BASE_A = eINSTANCE.getBaseAReferencesBaseB_BaseA();

	}

} //BasePackage
