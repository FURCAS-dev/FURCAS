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

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.TranslatableTextF;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A19 Serialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization#getTestTranslatableTextF <em>Test Translatable Text F</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage#getA19Serialization()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case019.serializationcallback.A19Serialization' metaObjectMofId='48D8F70A4F2F1772897811DDA8430019993BAD15' isStructureType='false'"
 * @generated
 */
public interface A19Serialization extends EObject {
	/**
	 * Returns the value of the '<em><b>Test Translatable Text F</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Translatable Text F</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Translatable Text F</em>' containment reference.
	 * @see #setTestTranslatableTextF(TranslatableTextF)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage#getA19Serialization_TestTranslatableTextF()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='48DA2D8A6172FFA08A3111DDACFF0019993BAD15'"
	 * @generated
	 */
	TranslatableTextF getTestTranslatableTextF();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization#getTestTranslatableTextF <em>Test Translatable Text F</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Translatable Text F</em>' containment reference.
	 * @see #getTestTranslatableTextF()
	 * @generated
	 */
	void setTestTranslatableTextF(TranslatableTextF value);

} // A19Serialization
