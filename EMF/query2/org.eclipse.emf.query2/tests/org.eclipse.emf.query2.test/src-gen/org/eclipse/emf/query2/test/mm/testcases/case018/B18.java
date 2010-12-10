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

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B18</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.B18#getSpecialOnePrimitive <em>Special One Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getB18()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0],test.sap.com/tc/moin/metamodel/testcases/foundation[1.0.0]' metaObject='testcases.case018.B18' metaObjectMofId='45F120A593EB7AC9D909470D3DFCFCEE58ED1378' isStructureType='false'"
 * @generated
 */
public interface B18 extends B1f {
	/**
	 * Returns the value of the '<em><b>Special One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special One Primitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special One Primitive</em>' attribute.
	 * @see #setSpecialOnePrimitive(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getB18_SpecialOnePrimitive()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getSpecialOnePrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.B18#getSpecialOnePrimitive <em>Special One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Special One Primitive</em>' attribute.
	 * @see #getSpecialOnePrimitive()
	 * @generated
	 */
	void setSpecialOnePrimitive(String value);

} // B18
