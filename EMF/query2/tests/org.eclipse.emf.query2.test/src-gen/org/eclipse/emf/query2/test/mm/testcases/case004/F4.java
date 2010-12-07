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
package org.eclipse.emf.query2.test.mm.testcases.case004;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>F4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getOneC <em>One C</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getManyCs <em>Many Cs</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getManyCsOrdered <em>Many Cs Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getF4()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.F4' metaObjectMofId='45F120A57E4CF493F2554D201E5B9259CB1A21D7' isStructureType='false' ova='oneC,manyCs,manyCsOrdered'"
 * @generated
 */
public interface F4 extends EObject {
	/**
	 * Returns the value of the '<em><b>One C</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One C</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One C</em>' containment reference.
	 * @see #setOneC(C4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getF4_OneC()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A51A63D23BE4E54B8621B9EEB51955EEB3'"
	 * @generated
	 */
	C4 getOneC();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getOneC <em>One C</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One C</em>' containment reference.
	 * @see #getOneC()
	 * @generated
	 */
	void setOneC(C4 value);

	/**
	 * Returns the value of the '<em><b>Many Cs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.C4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Cs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Cs</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getF4_ManyCs()
	 * @model containment="true" resolveProxies="true" upper="6" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A538562EABE12843AB3230C31F8795F1E7'"
	 * @generated
	 */
	EList<C4> getManyCs();

	/**
	 * Returns the value of the '<em><b>Many Cs Ordered</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.C4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Cs Ordered</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Cs Ordered</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getF4_ManyCsOrdered()
	 * @model containment="true" resolveProxies="true" lower="2" upper="6"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F574532E5DE60511534D7226BCA43F235EFDF9'"
	 * @generated
	 */
	EList<C4> getManyCsOrdered();

} // F4
