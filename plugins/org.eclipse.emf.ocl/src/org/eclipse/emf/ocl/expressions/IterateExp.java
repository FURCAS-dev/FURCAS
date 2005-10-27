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

/**
 * @author edith
 *
 */
/**
 * @model
 **/
public interface IterateExp extends LoopExp{
	/**
	 * @model opposite="baseExp" containment="true"
	 */
	public VariableDeclaration getResult();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.IterateExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(VariableDeclaration value);

}
