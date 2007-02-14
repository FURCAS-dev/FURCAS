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
 * $Id: UnlimitedNaturalLiteralExp.java,v 1.2 2007/02/14 13:42:14 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unlimited Natural Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#isUnlimited <em>Unlimited</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getUnlimitedNaturalLiteralExp()
 * @model
 * @generated
 */
public interface UnlimitedNaturalLiteralExp<C> extends NumericLiteralExp<C> {
    /** Java value denoting the OCL unlimited value. */
    int UNLIMITED = -1;
    
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
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getUnlimitedNaturalLiteralExp_IntegerSymbol()
     * @model
     * @generated
     */
    Integer getIntegerSymbol();

    /**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Integer Symbol</em>' attribute.
     * @see #getIntegerSymbol()
     * @generated
     */
    void setIntegerSymbol(Integer value);

    /**
     * Returns the value of the '<em><b>Unlimited</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Unlimited</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Unlimited</em>' attribute.
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getUnlimitedNaturalLiteralExp_Unlimited()
     * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    boolean isUnlimited();

} // UnlimitedNaturalLiteralExp
