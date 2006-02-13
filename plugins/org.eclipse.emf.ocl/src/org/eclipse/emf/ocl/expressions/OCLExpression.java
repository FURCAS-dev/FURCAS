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
 * $Id: OCLExpression.java,v 1.1 2006/02/13 16:11:58 cdamus Exp $
 */

package org.eclipse.emf.ocl.expressions;


import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ocl.internal.utilities.ASTNode;
import org.eclipse.emf.ocl.internal.utilities.Visitable;

/**
 * @author Edith Schonberg (edith)
 *
 * @model abstract="true"
 */
public interface OCLExpression extends ENamedElement, Visitable, ASTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	public EClassifier getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OCLExpression#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassifier value);

	/**
	 * @model type="PropertyCallExp" opposite="source" lowerBound=0 upperBound=1
	 */
	public PropertyCallExp getAppliedProperty();
	

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OCLExpression#getAppliedProperty <em>Applied Property</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Property</em>' container reference.
	 * @see #getAppliedProperty()
	 * @generated
	 */
	void setAppliedProperty(PropertyCallExp value);

	/**
	 * Returns the value of the '<em><b>Initialized Variable</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialized Variable</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialized Variable</em>' container reference.
	 * @see #setInitializedVariable(VariableDeclaration)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getOCLExpression_InitializedVariable()
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getInitExpression
	 * @model opposite="initExpression"
	 * @generated
	 */
	VariableDeclaration getInitializedVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OCLExpression#getInitializedVariable <em>Initialized Variable</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialized Variable</em>' container reference.
	 * @see #getInitializedVariable()
	 * @generated
	 */
	void setInitializedVariable(VariableDeclaration value);

	/**
	 * @model opposite="arguments" lowerBound=0 upperBound=1
	 */
	 
	public OperationCallExp getParentOperation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OCLExpression#getParentOperation <em>Parent Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Operation</em>' container reference.
	 * @see #getParentOperation()
	 * @generated
	 */
	void setParentOperation(OperationCallExp value);

	public Object accept(Visitor v);

}
