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
 * $Id: CallExp.java,v 1.3 2007/10/11 23:05:15 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ocl.utilities.CallingASTNode;

/**
 * @deprecated Use the {@link org.eclipse.ocl.expressions.CallExp} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 * @model abstract="true"
 */
@Deprecated
public interface CallExp extends OCLExpression, CallingASTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * @model opposite="appliedProperty" lowerBound=0 upperBound=1 
	 */
	public OCLExpression getSource();
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.CallExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OCLExpression value);

}