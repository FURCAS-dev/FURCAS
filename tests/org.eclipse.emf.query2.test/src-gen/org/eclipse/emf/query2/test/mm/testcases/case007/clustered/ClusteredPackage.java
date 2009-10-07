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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredFactory
 * @model kind="package"
 * @generated
 */
public interface ClusteredPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "clustered";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/clustered";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007clustered";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClusteredPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl#getClusteredA()
	 * @generated
	 */
	int CLUSTERED_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTERED_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl#getClusteredB()
	 * @generated
	 */
	int CLUSTERED_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTERED_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAReferencesClusteredBImpl <em>AReferences Clustered B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAReferencesClusteredBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl#getClusteredAReferencesClusteredB()
	 * @generated
	 */
	int CLUSTERED_AREFERENCES_CLUSTERED_B = 2;

	/**
	 * The feature id for the '<em><b>Clustered B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B = 0;

	/**
	 * The feature id for the '<em><b>Clustered A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Clustered B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTERED_AREFERENCES_CLUSTERED_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredA
	 * @generated
	 */
	EClass getClusteredA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredB
	 * @generated
	 */
	EClass getClusteredB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB <em>AReferences Clustered B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Clustered B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB
	 * @generated
	 */
	EClass getClusteredAReferencesClusteredB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredB <em>Clustered B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clustered B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredB()
	 * @see #getClusteredAReferencesClusteredB()
	 * @generated
	 */
	EReference getClusteredAReferencesClusteredB_ClusteredB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredA <em>Clustered A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Clustered A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredA()
	 * @see #getClusteredAReferencesClusteredB()
	 * @generated
	 */
	EReference getClusteredAReferencesClusteredB_ClusteredA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClusteredFactory getClusteredFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl#getClusteredA()
		 * @generated
		 */
		EClass CLUSTERED_A = eINSTANCE.getClusteredA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl#getClusteredB()
		 * @generated
		 */
		EClass CLUSTERED_B = eINSTANCE.getClusteredB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAReferencesClusteredBImpl <em>AReferences Clustered B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredAReferencesClusteredBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.impl.ClusteredPackageImpl#getClusteredAReferencesClusteredB()
		 * @generated
		 */
		EClass CLUSTERED_AREFERENCES_CLUSTERED_B = eINSTANCE.getClusteredAReferencesClusteredB();

		/**
		 * The meta object literal for the '<em><b>Clustered B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_B = eINSTANCE.getClusteredAReferencesClusteredB_ClusteredB();

		/**
		 * The meta object literal for the '<em><b>Clustered A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTERED_AREFERENCES_CLUSTERED_B__CLUSTERED_A = eINSTANCE.getClusteredAReferencesClusteredB_ClusteredA();

	}

} //ClusteredPackage
