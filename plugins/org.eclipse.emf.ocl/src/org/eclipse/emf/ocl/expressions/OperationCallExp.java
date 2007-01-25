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
import org.eclipse.emf.ecore.EOperation;

/**
 * @deprecated Use the {@link org.eclipse.ocl.expressions.OperationCallExp} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 */
public interface OperationCallExp extends FeatureCallExp {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.expressions.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getOperationCallExp_Argument()
	 * @model type="org.eclipse.emf.ocl.expressions.OCLExpression" containment="true"
	 * @generated
	 */
	EList getArgument();

	/**
	 * @generated
	 */
	EOperation getReferredOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(EOperation value);

	public int getOperationCode();
	
	public void setOperationCode(int opCode);
}
