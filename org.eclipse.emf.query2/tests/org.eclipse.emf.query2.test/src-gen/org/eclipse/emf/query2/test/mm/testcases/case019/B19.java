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
package org.eclipse.emf.query2.test.mm.testcases.case019;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.ButtonTextF;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.ShortTranslatableTextF;
import org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.VeryShortTranslatableTextF;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B19</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextShort1 <em>Translatable Text Short1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextVeryShort1 <em>Translatable Text Very Short1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableButtons <em>Translatable Buttons</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case019.Case019Package#getB19()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case019.B19' metaObjectMofId='488462FAAC487011570E11DDBB95001558C93B47' isStructureType='false'"
 * @generated
 */
public interface B19 extends EObject {
	/**
	 * Returns the value of the '<em><b>Translatable Text Short1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translatable Text Short1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translatable Text Short1</em>' containment reference.
	 * @see #setTranslatableTextShort1(ShortTranslatableTextF)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.Case019Package#getB19_TranslatableTextShort1()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='488462FAAC45FF10570E11DD81D6001558C93B47'"
	 * @generated
	 */
	ShortTranslatableTextF getTranslatableTextShort1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextShort1 <em>Translatable Text Short1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translatable Text Short1</em>' containment reference.
	 * @see #getTranslatableTextShort1()
	 * @generated
	 */
	void setTranslatableTextShort1(ShortTranslatableTextF value);

	/**
	 * Returns the value of the '<em><b>Translatable Text Very Short1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translatable Text Very Short1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translatable Text Very Short1</em>' containment reference.
	 * @see #setTranslatableTextVeryShort1(VeryShortTranslatableTextF)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.Case019Package#getB19_TranslatableTextVeryShort1()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36CF3BD0573F11DDC371001B776F88F3'"
	 * @generated
	 */
	VeryShortTranslatableTextF getTranslatableTextVeryShort1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextVeryShort1 <em>Translatable Text Very Short1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translatable Text Very Short1</em>' containment reference.
	 * @see #getTranslatableTextVeryShort1()
	 * @generated
	 */
	void setTranslatableTextVeryShort1(VeryShortTranslatableTextF value);

	/**
	 * Returns the value of the '<em><b>Translatable Buttons</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.ButtonTextF}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Translatable Buttons</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Translatable Buttons</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.Case019Package#getB19_TranslatableButtons()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36CF3BD1573F11DD8111001B776F88F3'"
	 * @generated
	 */
	EList<ButtonTextF> getTranslatableButtons();

} // B19
