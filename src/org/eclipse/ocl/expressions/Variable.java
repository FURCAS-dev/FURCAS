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
 * $Id: Variable.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.utilities.TypedASTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.Visitable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.Variable#getInitExpression <em>Init Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.Variable#getRepresentedParameter <em>Represented Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable<C, PM> extends TypedElement<C>, Visitable, TypedASTNode {
	/**
     * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Init Expression</em>' containment reference.
     * @see #setInitExpression(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getVariable_InitExpression()
     * @model containment="true"
     * @generated
     */
	OCLExpression<C> getInitExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.Variable#getInitExpression <em>Init Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Expression</em>' containment reference.
     * @see #getInitExpression()
     * @generated
     */
	void setInitExpression(OCLExpression<C> value);

	/**
     * Returns the value of the '<em><b>Represented Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Represented Parameter</em>' reference.
     * @see #setRepresentedParameter(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getVariable_RepresentedParameter()
     * @model kind="reference"
     * @generated
     */
	PM getRepresentedParameter();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.Variable#getRepresentedParameter <em>Represented Parameter</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Represented Parameter</em>' reference.
     * @see #getRepresentedParameter()
     * @generated
     */
	void setRepresentedParameter(PM value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * initExpression->notEmpty() implies initExpression.type.conformsTo (type)
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkInitType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Variable
