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
 * $Id: OpaqueExpression.java,v 1.3 2011/03/01 08:47:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opaque Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An opaque expression is an uninterpreted textual statement that denotes a (possibly empty) set of values when evaluated in a context.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getBodies <em>Body</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getLanguages <em>Language</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getMessages <em>Message</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression()
 * @model
 * @generated
 */
public interface OpaqueExpression
		extends ValueSpecification {

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The text of the expression, possibly in multiple languages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' attribute list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_Body()
	 * @model unique="false" dataType="org.eclipse.ocl.examples.pivot.String"
	 * @generated
	 */
	EList<String> getBodies();

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the languages in which the expression is stated. The interpretation of the expression body depends on the languages. If the languages are unspecified, they might be implicit from the expression body or the context. Languages are matched to body strings by order.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Language</em>' attribute list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_Language()
	 * @model dataType="org.eclipse.ocl.examples.pivot.String"
	 * @generated
	 */
	EList<String> getLanguages();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_Message()
	 * @model unique="false" dataType="org.eclipse.ocl.examples.pivot.String"
	 * @generated
	 */
	EList<String> getMessages();

	/**
	 * Returns the value of the '<em><b>Value Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression</em>' reference.
	 * @see #setValueExpression(ExpressionInOcl)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getOpaqueExpression_ValueExpression()
	 * @model transient="true" ordered="false"
	 * @generated
	 */
	ExpressionInOcl getValueExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.OpaqueExpression#getValueExpression <em>Value Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' reference.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(ExpressionInOcl value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If the language attribute is not empty, then the size of the body and language arrays must be the same.
	 * language->notEmpty() implies (body->size() = language->size())
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateLanguageBodySize(DiagnosticChain diagnostics,
			Map<Object, Object> context);
} // OpaqueExpression
