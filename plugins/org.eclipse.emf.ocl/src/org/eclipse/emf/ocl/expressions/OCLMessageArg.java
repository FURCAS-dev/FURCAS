/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: OCLMessageArg.java,v 1.1 2006/02/13 16:11:58 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.ENamedElement;


/**
 * @author Edith Schonberg (edith)
 */
public interface OCLMessageArg extends ENamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * @model lowerBound=0
	 */
	public UnspecifiedValueExp getUnspecified();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OCLMessageArg#getUnspecified <em>Unspecified</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unspecified</em>' containment reference.
	 * @see #getUnspecified()
	 * @generated
	 */
	void setUnspecified(UnspecifiedValueExp value);

	/**
	 * @model lowerBound=0
	 */
	public OCLExpression getExpression();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OCLMessageArg#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(OCLExpression value);

}
