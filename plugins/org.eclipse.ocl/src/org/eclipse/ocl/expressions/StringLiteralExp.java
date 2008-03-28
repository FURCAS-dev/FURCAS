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
 * $Id: StringLiteralExp.java,v 1.4 2008/03/28 20:33:35 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.StringLiteralExp#getStringSymbol <em>String Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getStringLiteralExp()
 * @model
 * @generated
 */
public interface StringLiteralExp<C> extends PrimitiveLiteralExp<C> {
	/**
     * Returns the value of the '<em><b>String Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>String Symbol</em>' attribute.
     * @see #setStringSymbol(String)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getStringLiteralExp_StringSymbol()
     * @model
     * @generated
     */
	String getStringSymbol();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.StringLiteralExp#getStringSymbol <em>String Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>String Symbol</em>' attribute.
     * @see #getStringSymbol()
     * @generated
     */
	void setStringSymbol(String value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * self.type.name = 'String'
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkStringType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // StringLiteralExp
