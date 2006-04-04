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
 * $Id: Variable.java,v 1.1 2006/04/04 18:09:06 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.utilities.TypedASTNode;
import org.eclipse.emf.ocl.utilities.Visitable;


/**
* @author Edith Schonberg (edith)
* @generated
 */
public interface Variable extends TypedElement, Visitable, TypedASTNode {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * @model opposite="initializeVariable" lowerBound=0 upperBound=1 containment="true"
	 */
	public OCLExpression getInitExpression();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.Variable#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Parameter</em>' reference.
	 * @see #setRepresentedParameter(EParameter)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getVariable_RepresentedParameter()
	 * @model
	 * @generated
	 */
	EParameter getRepresentedParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.Variable#getRepresentedParameter <em>Represented Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Parameter</em>' reference.
	 * @see #getRepresentedParameter()
	 * @generated
	 */
	void setRepresentedParameter(EParameter value);

}
