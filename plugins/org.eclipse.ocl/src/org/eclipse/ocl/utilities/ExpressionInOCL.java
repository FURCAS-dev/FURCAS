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
 * $Id: ExpressionInOCL.java,v 1.4 2007/10/11 23:05:05 cdamus Exp $
 */
package org.eclipse.ocl.utilities;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression In OCL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.ExpressionInOCL#getBodyExpression <em>Body Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.ExpressionInOCL#getContextVariable <em>Context Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.ExpressionInOCL#getResultVariable <em>Result Variable</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.ExpressionInOCL#getParameterVariable <em>Parameter Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.utilities.UtilitiesPackage#getExpressionInOCL()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='ExpressionInOcl'"
 * @generated
 */
public interface ExpressionInOCL<C, PM> extends Visitable {
	/**
     * Returns the value of the '<em><b>Body Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Body Expression</em>' containment reference.
     * @see #setBodyExpression(OCLExpression)
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getExpressionInOCL_BodyExpression()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpression<C> getBodyExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.ExpressionInOCL#getBodyExpression <em>Body Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Body Expression</em>' containment reference.
     * @see #getBodyExpression()
     * @generated
     */
	void setBodyExpression(OCLExpression<C> value);

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
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getExpressionInOCL_ContextVariable()
     * @model containment="true" required="true"
     * @generated
     */
	Variable<C, PM> getContextVariable();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.ExpressionInOCL#getContextVariable <em>Context Variable</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Variable</em>' containment reference.
     * @see #getContextVariable()
     * @generated
     */
	void setContextVariable(Variable<C, PM> value);

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
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getExpressionInOCL_ResultVariable()
     * @model containment="true"
     * @generated
     */
	Variable<C, PM> getResultVariable();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.utilities.ExpressionInOCL#getResultVariable <em>Result Variable</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Result Variable</em>' containment reference.
     * @see #getResultVariable()
     * @generated
     */
	void setResultVariable(Variable<C, PM> value);

	/**
     * Returns the value of the '<em><b>Parameter Variable</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.expressions.Variable}&lt;C, PM>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter Variable</em>' containment reference list.
     * @see org.eclipse.ocl.utilities.UtilitiesPackage#getExpressionInOCL_ParameterVariable()
     * @model containment="true"
     * @generated
     */
	EList<Variable<C, PM>> getParameterVariable();

} // ExpressionInOCL
