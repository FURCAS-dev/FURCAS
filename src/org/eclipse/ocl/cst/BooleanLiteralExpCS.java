/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: BooleanLiteralExpCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.BooleanLiteralExpCS#getBooleanSymbol <em>Boolean Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getBooleanLiteralExpCS()
 * @model
 * @generated
 */
public interface BooleanLiteralExpCS extends PrimitiveLiteralExpCS {
	/**
     * Returns the value of the '<em><b>Boolean Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Boolean Symbol</em>' attribute.
     * @see #setBooleanSymbol(Boolean)
     * @see org.eclipse.ocl.cst.CSTPackage#getBooleanLiteralExpCS_BooleanSymbol()
     * @model
     * @generated
     */
	Boolean getBooleanSymbol();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.BooleanLiteralExpCS#getBooleanSymbol <em>Boolean Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Boolean Symbol</em>' attribute.
     * @see #getBooleanSymbol()
     * @generated
     */
	void setBooleanSymbol(Boolean value);

} // BooleanLiteralExpCS
