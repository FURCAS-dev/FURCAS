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
 * $Id: PropertyCallExp.java,v 1.5 2008/03/28 20:33:34 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.PropertyCallExp#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getPropertyCallExp()
 * @model
 * @generated
 */
public interface PropertyCallExp<C, P> extends NavigationCallExp<C, P> {
	/**
     * Returns the value of the '<em><b>Referred Property</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Property</em>' reference.
     * @see #setReferredProperty(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getPropertyCallExp_ReferredProperty()
     * @model kind="reference"
     * @generated
     */
	P getReferredProperty();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.PropertyCallExp#getReferredProperty <em>Referred Property</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Property</em>' reference.
     * @see #getReferredProperty()
     * @generated
     */
	void setReferredProperty(P value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * type = referredProperty.type
     * @param diagnostics The chain of diagnostics to which problems are to be appended.
     * @param context The cache of context-specific information.
     * <!-- end-model-doc -->
     * @model
     * @generated
     */
    boolean checkPropertyType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PropertyCallExp
