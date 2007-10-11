/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TypeExp.java,v 1.4 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.TypeExp#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTypeExp()
 * @model
 * @generated
 */
public interface TypeExp<C> extends OCLExpression<C> {
	/**
     * Returns the value of the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Type</em>' reference.
     * @see #setReferredType(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getTypeExp_ReferredType()
     * @model kind="reference"
     * @generated
     */
	C getReferredType();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.TypeExp#getReferredType <em>Referred Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Type</em>' reference.
     * @see #getReferredType()
     * @generated
     */
	void setReferredType(C value);

} // TypeExp
