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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ocl.internal.utilities.TypedASTNode;
import org.eclipse.emf.ocl.internal.utilities.Visitable;


/**
* @author Edith Schonberg (edith)
 */
/**
 *
 */
public interface VariableDeclaration extends ENamedElement, Visitable, TypedASTNode {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 *
	 */
	String getVarName();
	
	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getVarName <em>Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var Name</em>' attribute.
	 * @see #getVarName()
	 * @generated
	 */
	void setVarName(String value);

	/**
	 * @model opposite="iterators"  lowerBound=0 upperBound=1
	 */
	public LoopExp getLoopExpr();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getLoopExpr <em>Loop Expr</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Expr</em>' container reference.
	 * @see #getLoopExpr()
	 * @generated
	 */
	void setLoopExpr(LoopExp value);

	/**
	 * @model opposite="initializeVariable" lowerBound=0 upperBound=1 containment="true"
	 */
	public OCLExpression getInitExpression();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getInitExpression <em>Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OCLExpression value);

	/**
	 *
	 */
	public EClassifier getType();



	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassifier value);

	/**
	 * @model opposite="result" lowerBound=1 upperBound=1
	 */
	public IterateExp getBaseExp();
	

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.VariableDeclaration#getBaseExp <em>Base Exp</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Exp</em>' container reference.
	 * @see #getBaseExp()
	 * @generated
	 */
	void setBaseExp(IterateExp value);

	public Object accept(Visitor v);


}
