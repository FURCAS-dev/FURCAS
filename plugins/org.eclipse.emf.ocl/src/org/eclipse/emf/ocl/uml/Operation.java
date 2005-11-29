/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.Operation#isQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.uml.UmlPackage#getOperation()
 *
 * @generated
 */
public interface Operation extends EObject, EOperation {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(boolean)
	 * @see org.eclipse.emf.ocl.uml.UmlPackage#getOperation_Query()
	 * @model default="true"
	 * @generated
	 */
	boolean isQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.Operation#isQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #isQuery()
	 * @generated
	 */
	void setQuery(boolean value);

} // Operation
