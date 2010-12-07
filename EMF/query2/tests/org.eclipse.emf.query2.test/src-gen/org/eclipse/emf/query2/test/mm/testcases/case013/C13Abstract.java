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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C13 Abstract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract#getAttribute1 <em>Attribute1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package#getC13Abstract()
 * @model abstract="true"
 * @generated
 */
public interface C13Abstract extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute1</em>' attribute.
	 * @see #setAttribute1(double)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Package#getC13Abstract_Attribute1()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	double getAttribute1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract#getAttribute1 <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute1</em>' attribute.
	 * @see #getAttribute1()
	 * @generated
	 */
	void setAttribute1(double value);

} // C13Abstract
