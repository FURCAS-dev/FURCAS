/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: IntegerLiteralExpCS.java,v 1.2 2008/10/04 00:54:09 cdamus Exp $
 */
package org.eclipse.ocl.cst;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.IntegerLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getIntegerLiteralExpCS()
 * @model
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IntegerLiteralExpCS extends PrimitiveLiteralExpCS {
	/**
	 * Returns the value of the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Symbol</em>' attribute.
	 * @see #setIntegerSymbol(Integer)
	 * @see org.eclipse.ocl.cst.CSTPackage#getIntegerLiteralExpCS_IntegerSymbol()
	 * @model
	 * @generated
	 */
	Integer getIntegerSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.IntegerLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Symbol</em>' attribute.
	 * @see #getIntegerSymbol()
	 * @generated
	 */
	void setIntegerSymbol(Integer value);

} // IntegerLiteralExpCS
