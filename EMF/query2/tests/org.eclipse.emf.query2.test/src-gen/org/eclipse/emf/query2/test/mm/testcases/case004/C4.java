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
package org.eclipse.emf.query2.test.mm.testcases.case004;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4#getComplex <em>Complex</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getC4()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.C4' metaObjectMofId='45F120A5D3165AD162A141EB0547FC4EA865B99D' isStructureType='false' ova='complex'"
 * @generated
 */
public interface C4 extends EObject {
	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' attribute.
	 * @see #setPrimitive(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getC4_Primitive()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getPrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4#getPrimitive <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' attribute.
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(String value);

	/**
	 * Returns the value of the '<em><b>Complex</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex</em>' containment reference.
	 * @see #setComplex(B4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getC4_Complex()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4761229E3CA757E0A97511DCBB6F001558C93B47'"
	 * @generated
	 */
	B4 getComplex();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4#getComplex <em>Complex</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complex</em>' containment reference.
	 * @see #getComplex()
	 * @generated
	 */
	void setComplex(B4 value);

} // C4
