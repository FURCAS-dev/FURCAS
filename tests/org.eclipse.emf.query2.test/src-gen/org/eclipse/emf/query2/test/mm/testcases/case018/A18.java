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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A18</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.A18#getFoundationAttributeA1f <em>Foundation Attribute A1f</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getA18()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case018.A18' metaObjectMofId='45F120A5586264A51AA744663E0998A4A0E295C1' isStructureType='false' ova='foundationAttributeA1f'"
 * @generated
 */
public interface A18 extends EObject {
	/**
	 * Returns the value of the '<em><b>Foundation Attribute A1f</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foundation Attribute A1f</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foundation Attribute A1f</em>' containment reference.
	 * @see #setFoundationAttributeA1f(A1f)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getA18_FoundationAttributeA1f()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A53BEC7E6098C3418531ADC9567AD8027B'"
	 * @generated
	 */
	A1f getFoundationAttributeA1f();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.A18#getFoundationAttributeA1f <em>Foundation Attribute A1f</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foundation Attribute A1f</em>' containment reference.
	 * @see #getFoundationAttributeA1f()
	 * @generated
	 */
	void setFoundationAttributeA1f(A1f value);

} // A18
