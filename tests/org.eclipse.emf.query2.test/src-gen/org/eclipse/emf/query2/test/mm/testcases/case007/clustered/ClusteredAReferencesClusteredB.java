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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences Clustered B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredB <em>Clustered B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredA <em>Clustered A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredPackage#getClusteredAReferencesClusteredB()
 * @model
 * @generated
 */
public interface ClusteredAReferencesClusteredB extends EObject {
	/**
	 * Returns the value of the '<em><b>Clustered B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clustered B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clustered B</em>' reference.
	 * @see #setClusteredB(ClusteredB)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredPackage#getClusteredAReferencesClusteredB_ClusteredB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.clustered.ClusteredAReferencesClusteredB' metaObjectMofId='476118E36F917563A96F11DCBC3B001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	ClusteredB getClusteredB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredAReferencesClusteredB#getClusteredB <em>Clustered B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clustered B</em>' reference.
	 * @see #getClusteredB()
	 * @generated
	 */
	void setClusteredB(ClusteredB value);

	/**
	 * Returns the value of the '<em><b>Clustered A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clustered A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clustered A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.ClusteredPackage#getClusteredAReferencesClusteredB_ClusteredA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case007.clustered.ClusteredAReferencesClusteredB' metaObjectMofId='476118E36F917563A96F11DCBC3B001558C93B47' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<ClusteredA> getClusteredA();

} // ClusteredAReferencesClusteredB
