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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences Nested Of Clustered B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredB <em>Nested Of Clustered B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredA <em>Nested Of Clustered A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredPackage#getNestedOfClusteredAReferencesNestedOfClusteredB()
 * @model
 * @generated
 */
public interface NestedOfClusteredAReferencesNestedOfClusteredB extends EObject {
	/**
	 * Returns the value of the '<em><b>Nested Of Clustered B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Of Clustered B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Of Clustered B</em>' reference.
	 * @see #setNestedOfClusteredB(nestedOfClusteredB)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredPackage#getNestedOfClusteredAReferencesNestedOfClusteredB_NestedOfClusteredB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB' metaObjectMofId='476118E36F8F0464A96F11DC9D45001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	nestedOfClusteredB getNestedOfClusteredB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB#getNestedOfClusteredB <em>Nested Of Clustered B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nested Of Clustered B</em>' reference.
	 * @see #getNestedOfClusteredB()
	 * @generated
	 */
	void setNestedOfClusteredB(nestedOfClusteredB value);

	/**
	 * Returns the value of the '<em><b>Nested Of Clustered A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.nestedOfClusteredA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nested Of Clustered A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nested Of Clustered A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredPackage#getNestedOfClusteredAReferencesNestedOfClusteredB_NestedOfClusteredA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.clustered.nestedOfClustered.NestedOfClusteredAReferencesNestedOfClusteredB' metaObjectMofId='476118E36F8F0464A96F11DC9D45001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<nestedOfClusteredA> getNestedOfClusteredA();

} // NestedOfClusteredAReferencesNestedOfClusteredB
