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
package org.eclipse.emf.query2.test.mm.testcases.case022;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A22 Javadoc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc#getAttributeJavadoc <em>Attribute Javadoc</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case022.Case022Package#getA22Javadoc()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case022.A22Javadoc' metaObjectMofId='47307CB11E1403D38C7611DC98C50011252D8B30' isStructureType='false'"
 * @generated
 */
public interface A22Javadoc extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute Javadoc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Javadoc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Javadoc</em>' attribute.
	 * @see #setAttributeJavadoc(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.Case022Package#getA22Javadoc_AttributeJavadoc()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAttributeJavadoc();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc#getAttributeJavadoc <em>Attribute Javadoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Javadoc</em>' attribute.
	 * @see #getAttributeJavadoc()
	 * @generated
	 */
	void setAttributeJavadoc(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void operationJavadoc();

} // A22Javadoc
