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
 * $Id: EnumLiteralExp.java,v 1.5 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getEnumLiteralExp()
 * @model
 * @generated
 */
public interface EnumLiteralExp<C, EL> extends LiteralExp<C> {
	/**
     * Returns the value of the '<em><b>Referred Enum Literal</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Enum Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Enum Literal</em>' reference.
     * @see #setReferredEnumLiteral(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getEnumLiteralExp_ReferredEnumLiteral()
     * @model kind="reference"
     * @generated
     */
	EL getReferredEnumLiteral();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.EnumLiteralExp#getReferredEnumLiteral <em>Referred Enum Literal</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Enum Literal</em>' reference.
     * @see #getReferredEnumLiteral()
     * @generated
     */
	void setReferredEnumLiteral(EL value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.type = referredEnumLiteral.enumeration
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkEnumType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EnumLiteralExp
