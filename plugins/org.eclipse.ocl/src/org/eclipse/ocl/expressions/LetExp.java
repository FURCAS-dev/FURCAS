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
 * $Id: LetExp.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.LetExp#getIn <em>In</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.LetExp#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getLetExp()
 * @model
 * @generated
 */
public interface LetExp<C, PM> extends OCLExpression<C> {
	/**
     * Returns the value of the '<em><b>In</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>In</em>' containment reference.
     * @see #setIn(OCLExpression)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getLetExp_In()
     * @model containment="true"
     * @generated
     */
	OCLExpression<C> getIn();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.LetExp#getIn <em>In</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>In</em>' containment reference.
     * @see #getIn()
     * @generated
     */
	void setIn(OCLExpression<C> value);

	/**
     * Returns the value of the '<em><b>Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variable</em>' containment reference.
     * @see #setVariable(Variable)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getLetExp_Variable()
     * @model containment="true"
     * @generated
     */
	Variable<C, PM> getVariable();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.LetExp#getVariable <em>Variable</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variable</em>' containment reference.
     * @see #getVariable()
     * @generated
     */
	void setVariable(Variable<C, PM> value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = in.type
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkLetType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // LetExp
