/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *   Borland - Bug 242880
 *
 * </copyright>
 *
 * $Id: StringLiteralExpCS.java,v 1.5 2009/12/22 18:42:30 ewillink Exp $
 */
package org.eclipse.ocl.cst;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.StringLiteralExpCS#getStringSymbol <em>String Symbol</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.StringLiteralExpCS#getUnescapedStringSymbol <em>Unescaped String Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getStringLiteralExpCS()
 * @model
 * @generated
 */
public interface StringLiteralExpCS
		extends PrimitiveLiteralExpCS {

	/**
	 * Returns the value of the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Symbol</em>' attribute.
	 * @see #setStringSymbol(String)
	 * @see org.eclipse.ocl.cst.CSTPackage#getStringLiteralExpCS_StringSymbol()
	 * @model
	 * @generated
	 */
	String getStringSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.StringLiteralExpCS#getStringSymbol <em>String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Symbol</em>' attribute.
	 * @see #getStringSymbol()
	 * @generated
	 */
	void setStringSymbol(String value);

	/**
	 * Returns the value of the '<em><b>Unescaped String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unescaped String Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unescaped String Symbol</em>' attribute.
	 * @see #setUnescapedStringSymbol(String)
	 * @see org.eclipse.ocl.cst.CSTPackage#getStringLiteralExpCS_UnescapedStringSymbol()
	 * @model
	 * @generated
	 */
	String getUnescapedStringSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.StringLiteralExpCS#getUnescapedStringSymbol <em>Unescaped String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unescaped String Symbol</em>' attribute.
	 * @see #getUnescapedStringSymbol()
	 * @generated
	 */
	void setUnescapedStringSymbol(String value);

} // StringLiteralExpCS
