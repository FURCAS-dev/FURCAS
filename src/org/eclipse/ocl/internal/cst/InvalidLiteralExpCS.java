/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: InvalidLiteralExpCS.java,v 1.2 2007/02/14 14:46:02 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invalid Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.InvalidLiteralExpCS#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getInvalidLiteralExpCS()
 * @model
 * @generated
 */
public interface InvalidLiteralExpCS extends LiteralExpCS {
	/**
     * Returns the value of the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Symbol</em>' attribute.
     * @see #setSymbol(String)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getInvalidLiteralExpCS_Symbol()
     * @model
     * @generated
     */
	String getSymbol();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.InvalidLiteralExpCS#getSymbol <em>Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Symbol</em>' attribute.
     * @see #getSymbol()
     * @generated
     */
	void setSymbol(String value);

} // InvalidLiteralExpCS
