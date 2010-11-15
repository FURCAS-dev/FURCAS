/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.expressions;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * @since 3.1
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOppositePropertyCallExp()
 * @model
 * @generated
 */
public interface OppositePropertyCallExp<C, P>
		extends NavigationCallExp<C, P> {

	/**
	 * Returns the value of the '<em><b>Referred Opposite Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Opposite Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #setReferredOppositeProperty(Object)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getOppositePropertyCallExp_ReferredOppositeProperty()
	 * @model kind="reference"
	 * @generated
	 */
	P getReferredOppositeProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #getReferredOppositeProperty()
	 * @generated
	 */
	void setReferredOppositeProperty(P value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * type = referredOppositeProperty.opposite.type
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean checkOppositePropertyType(DiagnosticChain diagnostics,
			Map<Object, Object> context);

} // OppositePropertyCallExp
