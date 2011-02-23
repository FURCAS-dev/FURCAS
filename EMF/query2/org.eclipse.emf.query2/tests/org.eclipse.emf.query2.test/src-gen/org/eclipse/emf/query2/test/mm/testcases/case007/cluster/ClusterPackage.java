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
package org.eclipse.emf.query2.test.mm.testcases.case007.cluster;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterFactory
 * @model kind="package"
 * @generated
 */
public interface ClusterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cluster"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case007/cluster"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case007cluster"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClusterPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl#getClusterA()
	 * @generated
	 */
	int CLUSTER_A = 0;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_A_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterBImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl#getClusterB()
	 * @generated
	 */
	int CLUSTER_B = 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_B_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAReferencesClusterBImpl <em>AReferences Cluster B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAReferencesClusterBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl#getClusterAReferencesClusterB()
	 * @generated
	 */
	int CLUSTER_AREFERENCES_CLUSTER_B = 2;

	/**
	 * The feature id for the '<em><b>Cluster B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B = 0;

	/**
	 * The feature id for the '<em><b>Cluster A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A = 1;

	/**
	 * The number of structural features of the '<em>AReferences Cluster B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_AREFERENCES_CLUSTER_B_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterA
	 * @generated
	 */
	EClass getClusterA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterB
	 * @generated
	 */
	EClass getClusterB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB <em>AReferences Cluster B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>AReferences Cluster B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB
	 * @generated
	 */
	EClass getClusterAReferencesClusterB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterB <em>Cluster B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cluster B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterB()
	 * @see #getClusterAReferencesClusterB()
	 * @generated
	 */
	EReference getClusterAReferencesClusterB_ClusterB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterA <em>Cluster A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Cluster A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterA()
	 * @see #getClusterAReferencesClusterB()
	 * @generated
	 */
	EReference getClusterAReferencesClusterB_ClusterA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClusterFactory getClusterFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl#getClusterA()
		 * @generated
		 */
		EClass CLUSTER_A = eINSTANCE.getClusterA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterBImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl#getClusterB()
		 * @generated
		 */
		EClass CLUSTER_B = eINSTANCE.getClusterB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAReferencesClusterBImpl <em>AReferences Cluster B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterAReferencesClusterBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.impl.ClusterPackageImpl#getClusterAReferencesClusterB()
		 * @generated
		 */
		EClass CLUSTER_AREFERENCES_CLUSTER_B = eINSTANCE.getClusterAReferencesClusterB();

		/**
		 * The meta object literal for the '<em><b>Cluster B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_B = eINSTANCE.getClusterAReferencesClusterB_ClusterB();

		/**
		 * The meta object literal for the '<em><b>Cluster A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER_AREFERENCES_CLUSTER_B__CLUSTER_A = eINSTANCE.getClusterAReferencesClusterB_ClusterA();

	}

} //ClusterPackage
