/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * @deprecated Use the {@link org.eclipse.ocl.expressions.CollectionLiteralExp} interface,
 * instead.
 * 
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

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.expressions.CollectionLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getCollectionLiteralExp_Part()
	 * @model type="org.eclipse.emf.ocl.expressions.CollectionLiteralPart" containment="true"
	 * @generated
	 */
	EList getPart();

	/**
	 * Returns true if there is only one part, which is a range expression.
	 * @return true or false
	 */
	public boolean isSimpleRange();

}