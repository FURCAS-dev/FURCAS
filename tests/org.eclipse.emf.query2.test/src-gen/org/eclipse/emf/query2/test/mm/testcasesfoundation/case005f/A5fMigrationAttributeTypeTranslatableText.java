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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.GeneralTranslatableText;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.SpecializedTranslatableText;

import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A5f Migration Attribute Type Translatable Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getTranslatableText <em>Translatable Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getGeneralTranslatableText <em>General Translatable Text</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getSpecializedTranslatableText <em>Specialized Translatable Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage#getA5fMigrationAttributeTypeTranslatableText()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases/foundation[1.0.0]' metaObject='testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText' metaObjectMofId='48FEDD2F3CDD1BABA00F11DD8C38001558C93B47' isStructureType='false'"
 * @generated
 */
public interface A5fMigrationAttributeTypeTranslatableText extends EObject {
	/**
	 * Returns the value of the '<em><b>Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translatable Text</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translatable Text</em>' containment reference.
	 * @see #setTranslatableText(TranslatableText)
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage#getA5fMigrationAttributeTypeTranslatableText_TranslatableText()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='48FEDD2F3CDD1BA8A00F11DD8747001558C93B47'"
	 * @generated
	 */
	TranslatableText getTranslatableText();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getTranslatableText <em>Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translatable Text</em>' containment reference.
	 * @see #getTranslatableText()
	 * @generated
	 */
	void setTranslatableText(TranslatableText value);

	/**
	 * Returns the value of the '<em><b>General Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>General Translatable Text</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>General Translatable Text</em>' containment reference.
	 * @see #setGeneralTranslatableText(GeneralTranslatableText)
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage#getA5fMigrationAttributeTypeTranslatableText_GeneralTranslatableText()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='48FEDD2F3CDD1BA9A00F11DD9C8E001558C93B47'"
	 * @generated
	 */
	GeneralTranslatableText getGeneralTranslatableText();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getGeneralTranslatableText <em>General Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>General Translatable Text</em>' containment reference.
	 * @see #getGeneralTranslatableText()
	 * @generated
	 */
	void setGeneralTranslatableText(GeneralTranslatableText value);

	/**
	 * Returns the value of the '<em><b>Specialized Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Translatable Text</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialized Translatable Text</em>' containment reference.
	 * @see #setSpecializedTranslatableText(SpecializedTranslatableText)
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fPackage#getA5fMigrationAttributeTypeTranslatableText_SpecializedTranslatableText()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='48FEDD2F3CDD1BAAA00F11DDAAC8001558C93B47'"
	 * @generated
	 */
	SpecializedTranslatableText getSpecializedTranslatableText();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getSpecializedTranslatableText <em>Specialized Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialized Translatable Text</em>' containment reference.
	 * @see #getSpecializedTranslatableText()
	 * @generated
	 */
	void setSpecializedTranslatableText(SpecializedTranslatableText value);

} // A5fMigrationAttributeTypeTranslatableText
