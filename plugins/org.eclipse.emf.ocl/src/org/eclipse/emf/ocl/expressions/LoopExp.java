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

import org.eclipse.emf.common.util.EList;

/**
 * @author edith
 */
/**
 * @model
 */
public interface LoopExp  extends PropertyCallExp{
	/**
	 * @model containment="true"
	 */
    public OclExpression getBody();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.LoopExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpression value);

    /**
     * @model type="VariableDeclaration" opposite="loopExpr" containment="true"
     */
    public EList getIterators();

    
    // Fred Blooggs
	
}
