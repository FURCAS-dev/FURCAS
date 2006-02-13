/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions;


import org.eclipse.emf.common.util.EList;

/**
 * @author Edith Schonberg (edith)
 */
public interface CollectionLiteralExp extends LiteralExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public CollectionKind getKind();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.CollectionLiteralExp#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.emf.ocl.expressions.CollectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CollectionKind value);

	/*** ordered **/
	/**
	 * @model type="CollectionLiteralPart" lowerBound=0
	 */
	public EList getParts();
	
	/**
	 * Returns true if there is only one part, which is a range expression.
	 * @return true or false
	 */
	public boolean isSimpleRange();

}