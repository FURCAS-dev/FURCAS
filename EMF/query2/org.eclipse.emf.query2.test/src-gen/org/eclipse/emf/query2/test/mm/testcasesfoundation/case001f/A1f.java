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

import org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A1f</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f#getTranslatableText <em>Translatable Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage#getA1f()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases/foundation[1.0.0]' metaObject='testcasesfoundation.case001f.A1f' metaObjectMofId='45ED922CA5D2947E0EE543701D54E6B7BF726A50' isStructureType='false'"
 * @generated
 */
public interface A1f extends EObject {
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
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fPackage#getA1f_TranslatableText()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='487D5B821B7458D052DE11DDB515C4DEC0A80165'"
	 * @generated
	 */
	TranslatableText getTranslatableText();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f#getTranslatableText <em>Translatable Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Translatable Text</em>' containment reference.
	 * @see #getTranslatableText()
	 * @generated
	 */
	void setTranslatableText(TranslatableText value);

} // A1f
