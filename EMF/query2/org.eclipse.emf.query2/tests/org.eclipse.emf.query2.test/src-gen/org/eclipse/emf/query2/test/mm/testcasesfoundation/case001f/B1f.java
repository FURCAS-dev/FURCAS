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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B1f</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f#getOnePrimitive <em>One Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage#getB1f()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases/foundation[1.0.0]' metaObject='testcasesfoundation.case001f.B1f' metaObjectMofId='45ED922C4E128103DEF54D250988D90DD9621BAE' isStructureType='false'"
 * @generated
 */
public interface B1f extends EObject {
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
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage#getB1f_OnePrimitive()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getOnePrimitive();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f#getOnePrimitive <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Primitive</em>' attribute.
	 * @see #getOnePrimitive()
	 * @generated
	 */
	void setOnePrimitive(String value);

} // B1f
