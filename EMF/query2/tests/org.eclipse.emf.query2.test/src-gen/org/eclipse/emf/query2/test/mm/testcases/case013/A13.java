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
package org.eclipse.emf.query2.test.mm.testcases.case013;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A13</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttribute1 <em>Constrained Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttributeMany1 <em>Constrained Attribute Many1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package#getA13()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case013.A13' metaObjectMofId='45F120A5C6BFBFBB23B1451E20B5B97F60DBFB94' isStructureType='false' ova='constrainedAttributeMany1'"
 * @generated
 */
public interface A13 extends EObject {
	/**
	 * Returns the value of the '<em><b>Constrained Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Attribute1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Attribute1</em>' attribute.
	 * @see #setConstrainedAttribute1(int)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package#getA13_ConstrainedAttribute1()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int getConstrainedAttribute1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttribute1 <em>Constrained Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constrained Attribute1</em>' attribute.
	 * @see #getConstrainedAttribute1()
	 * @generated
	 */
	void setConstrainedAttribute1(int value);

	/**
	 * Returns the value of the '<em><b>Constrained Attribute Many1</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case013.A13}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constrained Attribute Many1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constrained Attribute Many1</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package#getA13_ConstrainedAttributeMany1()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A56E30F4B0AACE47743FBA8A7C90994FEA'"
	 * @generated
	 */
	EList<A13> getConstrainedAttributeMany1();

} // A13
