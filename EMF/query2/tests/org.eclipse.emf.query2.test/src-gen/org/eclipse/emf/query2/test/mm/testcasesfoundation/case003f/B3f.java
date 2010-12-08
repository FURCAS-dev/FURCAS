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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f;

import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B3f</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f#getTextName <em>Text Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.Case003fPackage#getB3f()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases/foundation[1.0.0],sap.com/tc/moin/textverticalization[2.0.0],sap.com/tc/moin/textverticalization[2.0.0]' metaObject='testcasesfoundation.case003f.B3f' metaObjectMofId='487D5B821B76A2C152DE11DDCB02C4DEC0A80165' isStructureType='true'"
 * @generated
 */
public interface B3f extends TranslatableText {
	/**
	 * Returns the value of the '<em><b>Text Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Name</em>' attribute.
	 * @see #setTextName(String)
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.Case003fPackage#getB3f_TextName()
	 * @model required="true"
	 * @generated
	 */
	String getTextName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f#getTextName <em>Text Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Name</em>' attribute.
	 * @see #getTextName()
	 * @generated
	 */
	void setTextName(String value);

} // B3f
