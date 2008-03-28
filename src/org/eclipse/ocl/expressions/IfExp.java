/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: IfExp.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.IfExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IfExp#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.IfExp#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIfExp()
 * @model
 * @generated
 */
public interface IfExp<C> extends OCLExpression<C> {
	/**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIfExp_Condition()
     * @model containment="true"
     * @generated
     */
	OCLExpression<C> getCondition();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.IfExp#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
	void setCondition(OCLExpression<C> value);

	/**
     * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Then Expression</em>' containment reference.
     * @see #setThenExpression(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIfExp_ThenExpression()
     * @model containment="true"
     * @generated
     */
	OCLExpression<C> getThenExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.IfExp#getThenExpression <em>Then Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Then Expression</em>' containment reference.
     * @see #getThenExpression()
     * @generated
     */
	void setThenExpression(OCLExpression<C> value);

	/**
     * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Else Expression</em>' containment reference.
     * @see #setElseExpression(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getIfExp_ElseExpression()
     * @model containment="true"
     * @generated
     */
	OCLExpression<C> getElseExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.IfExp#getElseExpression <em>Else Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Else Expression</em>' containment reference.
     * @see #getElseExpression()
     * @generated
     */
	void setElseExpression(OCLExpression<C> value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.condition.type.oclIsKindOf(PrimitiveType) and self.condition.type.name = 'Boolean'
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkBooleanCondition(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.type = thenExpression.type.commonSuperType(elseExpression.type)
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkIfType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // IfExp
