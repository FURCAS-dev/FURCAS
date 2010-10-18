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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A12</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case012.A12#getAttributeD12 <em>Attribute D12</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case012.Case012Package#getA12()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case012.A12' metaObjectMofId='47A97A49D1BBA958D49311DC8EB7001558C93B47' isStructureType='false' ova='attributeD12'"
 * @generated
 */
public interface A12 extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute D12</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute D12</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute D12</em>' containment reference.
	 * @see #setAttributeD12(D12)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case012.Case012Package#getA12_AttributeD12()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='47A97A49D1BBA950D49311DC81A3001558C93B47'"
	 * @generated
	 */
	D12 getAttributeD12();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case012.A12#getAttributeD12 <em>Attribute D12</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute D12</em>' containment reference.
	 * @see #getAttributeD12()
	 * @generated
	 */
	void setAttributeD12(D12 value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" paramD12Unique="false" paramD12Required="true" paramD12Ordered="false"
	 * @generated
	 */
	D12 operationWithObjectParameters(D12 paramD12);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	A12 operationWithThisAsReturnParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	D12 operationGetAttributeD12();

} // A12
