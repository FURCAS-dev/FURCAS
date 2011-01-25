/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ExpressionInOcl.java,v 1.2 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression In Ocl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getResultVariable <em>Result Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getParameterVariables <em>Parameter Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOcl()
 * @model
 * @generated
 */
public interface ExpressionInOcl
		extends OpaqueExpression {

	/**
	 * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Expression</em>' containment reference.
	 * @see #setBodyExpression(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOcl_BodyExpression()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getBodyExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getBodyExpression <em>Body Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Expression</em>' containment reference.
	 * @see #getBodyExpression()
	 * @generated
	 */
	void setBodyExpression(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getBodyExpression()
	 * @generated
	 */
	OclExpression createBodyExpression(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getBodyExpression()
	 * @generated
	 */
	OclExpression createBodyExpression();

	/**
	 * Returns the value of the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Variable</em>' containment reference.
	 * @see #setContextVariable(Variable)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOcl_ContextVariable()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	Variable getContextVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getContextVariable <em>Context Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Variable</em>' containment reference.
	 * @see #getContextVariable()
	 * @generated
	 */
	void setContextVariable(Variable value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Variable} and sets the '<em><b>Context Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * @see #getContextVariable()
	 * @generated
	 */
	Variable createContextVariable();

	/**
	 * Returns the value of the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Variable</em>' containment reference.
	 * @see #setResultVariable(Variable)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOcl_ResultVariable()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	Variable getResultVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.ExpressionInOcl#getResultVariable <em>Result Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Variable</em>' containment reference.
	 * @see #getResultVariable()
	 * @generated
	 */
	void setResultVariable(Variable value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Variable} and sets the '<em><b>Result Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * @see #getResultVariable()
	 * @generated
	 */
	Variable createResultVariable();

	/**
	 * Returns the value of the '<em><b>Parameter Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Variable</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getExpressionInOcl_ParameterVariable()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Variable> getParameterVariables();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.Variable} and appends it to the '<em><b>Parameter Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.Variable}.
	 * @see #getParameterVariables()
	 * @generated
	 */
	Variable createParameterVariable();

} // ExpressionInOcl
