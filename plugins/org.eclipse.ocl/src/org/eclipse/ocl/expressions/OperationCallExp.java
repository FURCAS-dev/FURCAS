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
 * $Id: OperationCallExp.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.OperationCallExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.OperationCallExp#getOperationCode <em>Operation Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp<C, O> extends FeatureCallExp<C> {
	/**
     * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.expressions.OCLExpression}&lt;C>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Argument</em>' containment reference list.
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOperationCallExp_Argument()
     * @model containment="true"
     * @generated
     */
	EList<OCLExpression<C>> getArgument();

	/**
     * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation</em>' reference.
     * @see #setReferredOperation(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOperationCallExp_ReferredOperation()
     * @model kind="reference"
     * @generated
     */
	O getReferredOperation();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Operation</em>' reference.
     * @see #getReferredOperation()
     * @generated
     */
	void setReferredOperation(O value);

	/**
     * Returns the value of the '<em><b>Operation Code</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Code</em>' attribute.
     * @see #setOperationCode(int)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOperationCallExp_OperationCode()
     * @model transient="true" volatile="true"
     * @generated
     */
	int getOperationCode();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.OperationCallExp#getOperationCode <em>Operation Code</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Code</em>' attribute.
     * @see #getOperationCode()
     * @generated
     */
	void setOperationCode(int value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * arguments->forall (a | a.type.conformsTo
     * (self.refParams->at (arguments->indexOf (a)).type))
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkArgumentsConform(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * arguments->size() = refParams->size()
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkArgumentCount(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OperationCallExp
