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

import org.eclipse.emf.ecore.EAttribute;

/**
 * @author edith
 */
/**
 * @model
 */
public interface AttributeCallExp extends ModelPropertyCallExp{
	/**
	 * @model
	 */
	public EAttribute getReferredAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.AttributeCallExp#getReferredAttribute <em>Referred Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Attribute</em>' reference.
	 * @see #getReferredAttribute()
	 * @generated
	 */
	void setReferredAttribute(EAttribute value);

}
