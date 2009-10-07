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
package org.eclipse.emf.query2.test.mm.testcases.case008;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>V8</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.V8#getStructure1 <em>Structure1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getV8()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.V8' metaObjectMofId='49675BF2EEC91723DE5711DD86870019993BAD15' isStructureType='true'"
 * @generated
 */
public interface V8 extends EObject {
	/**
	 * Returns the value of the '<em><b>Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structure1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure1</em>' containment reference.
	 * @see #setStructure1(V8)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getV8_Structure1()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	V8 getStructure1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.V8#getStructure1 <em>Structure1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure1</em>' containment reference.
	 * @see #getStructure1()
	 * @generated
	 */
	void setStructure1(V8 value);

} // V8
