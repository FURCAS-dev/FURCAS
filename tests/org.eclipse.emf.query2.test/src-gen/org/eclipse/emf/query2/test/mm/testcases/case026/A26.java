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
package org.eclipse.emf.query2.test.mm.testcases.case026;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A26</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToOne <em>Reflect To One</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToMany <em>Reflect To Many</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case026.Case026Package#getA26()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case026.A26' metaObjectMofId='48B56701E13930D2744511DDA0DF0019992F8D38' isStructureType='false' ova='reflectToOne,reflectToMany'"
 * @generated
 */
public interface A26 extends EObject {
	/**
	 * Returns the value of the '<em><b>Reflect To One</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflect To One</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflect To One</em>' containment reference.
	 * @see #setReflectToOne(EObject)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.Case026Package#getA26_ReflectToOne()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='48B56701E13930D0744511DDA3AE0019992F8D38'"
	 * @generated
	 */
	EObject getReflectToOne();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case026.A26#getReflectToOne <em>Reflect To One</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reflect To One</em>' containment reference.
	 * @see #getReflectToOne()
	 * @generated
	 */
	void setReflectToOne(EObject value);

	/**
	 * Returns the value of the '<em><b>Reflect To Many</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reflect To Many</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reflect To Many</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case026.Case026Package#getA26_ReflectToMany()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="http://sap.com/MOIN ovaMofId='48B56701E13930D1744511DD88330019992F8D38'"
	 * @generated
	 */
	EList<EObject> getReflectToMany();

} // A26
