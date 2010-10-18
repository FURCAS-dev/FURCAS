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
package org.eclipse.emf.query2.test.mm.testcases.case005.p1;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.p2.B5;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A5</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case005.p1.A5#getX <em>X</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p1.P1Package#getA5()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case005.p1.A5' metaObjectMofId='45F120A5B59540790C3D4028147F97C97EB53C5B' isStructureType='false'"
 * @generated
 */
public interface A5 extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' containment reference.
	 * @see #setX(B5)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p1.P1Package#getA5_X()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case005.p1.Association1' metaObjectMofId='45F120A577C9AFF3347749E41D1DDF655E2D1C1B' storedEnd='1' compositeEnd='1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	B5 getX();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p1.A5#getX <em>X</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' containment reference.
	 * @see #getX()
	 * @generated
	 */
	void setX(B5 value);

} // A5
