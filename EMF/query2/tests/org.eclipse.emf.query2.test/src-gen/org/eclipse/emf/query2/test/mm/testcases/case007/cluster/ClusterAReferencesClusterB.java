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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences Cluster B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterB <em>Cluster B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterA <em>Cluster A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterPackage#getClusterAReferencesClusterB()
 * @model
 * @generated
 */
public interface ClusterAReferencesClusterB extends EObject {
	/**
	 * Returns the value of the '<em><b>Cluster B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster B</em>' reference.
	 * @see #setClusterB(ClusterB)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterPackage#getClusterAReferencesClusterB_ClusterB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.cluster.ClusterAReferencesClusterB' metaObjectMofId='476118E36F91757CA96F11DC9CBD001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	ClusterB getClusterB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterAReferencesClusterB#getClusterB <em>Cluster B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster B</em>' reference.
	 * @see #getClusterB()
	 * @generated
	 */
	void setClusterB(ClusterB value);

	/**
	 * Returns the value of the '<em><b>Cluster A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cluster A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.cluster.ClusterPackage#getClusterAReferencesClusterB_ClusterA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.cluster.ClusterAReferencesClusterB' metaObjectMofId='476118E36F91757CA96F11DC9CBD001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<ClusterA> getClusterA();

} // ClusterAReferencesClusterB
