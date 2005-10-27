/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.ENamedElement;


/**
 * author edith
 */
/**
 * @model
 */
public interface OclMessageArg extends ENamedElement{
	/**
	 * @model lowerBound=0
	 */
	public UnspecifiedValueExp getUnspecified();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OclMessageArg#getUnspecified <em>Unspecified</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unspecified</em>' reference.
	 * @see #getUnspecified()
	 * @generated
	 */
	void setUnspecified(UnspecifiedValueExp value);

	/**
	 * @model lowerBound=0
	 */
	public OclExpression getExpression();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OclMessageArg#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OclExpression value);

}
