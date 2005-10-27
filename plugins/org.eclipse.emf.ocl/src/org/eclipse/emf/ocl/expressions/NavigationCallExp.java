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
import org.eclipse.emf.ecore.EReference;


/**
 * author edith
 */

/**
 * @model abstract="true"
 */
public interface NavigationCallExp extends ModelPropertyCallExp{
	
	/**
	 * @model type="OclExpression" containment="true" lowerBound=0 
	 */
	public EList getQualifiers();
	
	/**
	 * @model 
	 */
	public EReference getNavigationSource();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.NavigationCallExp#getNavigationSource <em>Navigation Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigation Source</em>' reference.
	 * @see #getNavigationSource()
	 * @generated
	 */
	void setNavigationSource(EReference value);

}
