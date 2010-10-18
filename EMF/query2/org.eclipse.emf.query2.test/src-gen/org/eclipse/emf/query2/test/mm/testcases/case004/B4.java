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
 * A representation of the model object '<em><b>B4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.B4#getOnePrimitive <em>One Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getB4()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.B4' metaObjectMofId='45F120A5CE8778345E6E45142026DF2289212782' isStructureType='false'"
 * @generated
 */
public interface B4 extends EObject {
	/**
	 * Returns the value of the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Primitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Primitive</em>' attribute.
	 * @see #setOnePrimitive(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getB4_OnePrimitive()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getOnePrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.B4#getOnePrimitive <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Primitive</em>' attribute.
	 * @see #getOnePrimitive()
	 * @generated
	 */
	void setOnePrimitive(String value);

} // B4
