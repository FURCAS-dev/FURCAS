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

package org.eclipse.emf.ocl.expressions;

/**
 * @author Edith Schonberg (edith)
 */
public interface CollectionRange extends CollectionLiteralPart{
	/**
	 *
	 */
	public OclExpression getFirst();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.CollectionRange#getFirst <em>First</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First</em>' containment reference.
	 * @see #getFirst()
	 * @generated
	 */
	void setFirst(OclExpression value);

	/**
	 *
	 */
	public OclExpression getLast();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.CollectionRange#getLast <em>Last</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last</em>' containment reference.
	 * @see #getLast()
	 * @generated
	 */
	void setLast(OclExpression value);

}
