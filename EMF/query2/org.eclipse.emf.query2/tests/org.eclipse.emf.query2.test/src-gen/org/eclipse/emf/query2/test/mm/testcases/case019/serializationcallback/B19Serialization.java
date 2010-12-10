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
package org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcases.case019.translatabletexts.A19TranslatableText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B19 Serialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization#getTestTranslatableText <em>Test Translatable Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage#getB19Serialization()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case019.serializationcallback.B19Serialization' metaObjectMofId='48DA2D8A6172FFA48A3111DDC8DD0019993BAD15' isStructureType='false'"
 * @generated
 */
public interface B19Serialization extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Translatable Text</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Translatable Text</em>' containment reference.
	 * @see #setTestTranslatableText(A19TranslatableText)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage#getB19Serialization_TestTranslatableText()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='48DA2D8A6172FFA28A3111DD8ADF0019993BAD15'"
	 * @generated
	 */
	A19TranslatableText getTestTranslatableText();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization#getTestTranslatableText <em>Test Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Translatable Text</em>' containment reference.
	 * @see #getTestTranslatableText()
	 * @generated
	 */
	void setTestTranslatableText(A19TranslatableText value);

} // B19Serialization
