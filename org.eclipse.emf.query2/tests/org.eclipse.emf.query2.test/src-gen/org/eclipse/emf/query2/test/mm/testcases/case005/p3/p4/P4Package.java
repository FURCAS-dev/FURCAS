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
package org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.P4Factory
 * @model kind="package"
 * @generated
 */
public interface P4Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "p4"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case005/p3/p4"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case005p3p4"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	P4Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.P4PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.D5Impl <em>D5</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.D5Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.P4PackageImpl#getD5()
	 * @generated
	 */
	int D5 = 0;

	/**
	 * The number of structural features of the '<em>D5</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D5_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.Association2Impl <em>Association2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.Association2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.P4PackageImpl#getAssociation2()
	 * @generated
	 */
	int ASSOCIATION2 = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION2__Y = 0;

	/**
	 * The feature id for the '<em><b>D5</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION2__D5 = 1;

	/**
	 * The number of structural features of the '<em>Association2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION2_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.D5 <em>D5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D5</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.D5
	 * @generated
	 */
	EClass getD5();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2 <em>Association2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2
	 * @generated
	 */
	EClass getAssociation2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Y</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getY()
	 * @see #getAssociation2()
	 * @generated
	 */
	EReference getAssociation2_Y();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getD5 <em>D5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D5</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getD5()
	 * @see #getAssociation2()
	 * @generated
	 */
	EReference getAssociation2_D5();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	P4Factory getP4Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.D5Impl <em>D5</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.D5Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.P4PackageImpl#getD5()
		 * @generated
		 */
		EClass D5 = eINSTANCE.getD5();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.Association2Impl <em>Association2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.Association2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.impl.P4PackageImpl#getAssociation2()
		 * @generated
		 */
		EClass ASSOCIATION2 = eINSTANCE.getAssociation2();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION2__Y = eINSTANCE.getAssociation2_Y();

		/**
		 * The meta object literal for the '<em><b>D5</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION2__D5 = eINSTANCE.getAssociation2_D5();

	}

} //P4Package
