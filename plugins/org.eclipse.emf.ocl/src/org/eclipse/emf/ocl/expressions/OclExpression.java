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


import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;

import org.eclipse.emf.ocl.internal.utilities.AstNode;
import org.eclipse.emf.ocl.internal.utilities.Visitable;

/**
 * author edith
 */
/**
 * @model abstract="true"
 */
public interface OclExpression extends ENamedElement, Visitable, AstNode{
	/**
	 * @model
	 */
	public EClassifier getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OclExpression#getType <em>Type</em>}' reference.
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
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OclExpression#getAppliedProperty <em>Applied Property</em>}' container reference.
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
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getOclExpression_InitializedVariable()
	 * @see org.eclipse.emf.ocl.expressions.VariableDeclaration#getInitExpression
	 * @model opposite="initExpression"
	 * @generated
	 */
	VariableDeclaration getInitializedVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OclExpression#getInitializedVariable <em>Initialized Variable</em>}' container reference.
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
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.OclExpression#getParentOperation <em>Parent Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Operation</em>' container reference.
	 * @see #getParentOperation()
	 * @generated
	 */
	void setParentOperation(OperationCallExp value);

	public Object accept(Visitor v);

}
