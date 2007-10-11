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
 * $Id: RealLiteralExp.java,v 1.3 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getRealLiteralExp()
 * @model
 * @generated
 */
public interface RealLiteralExp<C> extends NumericLiteralExp<C> {
	/**
     * Returns the value of the '<em><b>Real Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Real Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Real Symbol</em>' attribute.
     * @see #setRealSymbol(Double)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getRealLiteralExp_RealSymbol()
     * @model
     * @generated
     */
	Double getRealSymbol();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.RealLiteralExp#getRealSymbol <em>Real Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Real Symbol</em>' attribute.
     * @see #getRealSymbol()
     * @generated
     */
	void setRealSymbol(Double value);

} // RealLiteralExp
