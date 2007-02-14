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
 * $Id: IntegerLiteralExp.java,v 1.2 2007/02/14 13:42:13 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIntegerLiteralExp()
 * @model
 * @generated
 */
public interface IntegerLiteralExp<C> extends NumericLiteralExp<C> {
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
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIntegerLiteralExp_IntegerSymbol()
	 * @model
	 * @generated
	 */
	Integer getIntegerSymbol();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Symbol</em>' attribute.
	 * @see #getIntegerSymbol()
	 * @generated
	 */
	void setIntegerSymbol(Integer value);

} // IntegerLiteralExp
