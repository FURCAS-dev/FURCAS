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
 * $Id: VariableExp.java,v 1.4 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.VariableExp#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getVariableExp()
 * @model
 * @generated
 */
public interface VariableExp<C, PM> extends OCLExpression<C> {
	/**
     * Returns the value of the '<em><b>Referred Variable</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Variable</em>' reference.
     * @see #setReferredVariable(Variable)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getVariableExp_ReferredVariable()
     * @model
     * @generated
     */
	Variable<C, PM> getReferredVariable();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.VariableExp#getReferredVariable <em>Referred Variable</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Variable</em>' reference.
     * @see #getReferredVariable()
     * @generated
     */
	void setReferredVariable(Variable<C, PM> value);

} // VariableExp
