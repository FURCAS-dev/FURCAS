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
package org.eclipse.ocl.expressions.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.expressions.OppositePropertyCallExp;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Opposite Property Call Exp</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.OppositePropertyCallExp#checkPropertyType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Property Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 * @since 3.1
 */
public class OppositePropertyCallExpOperations
		extends OCLExpressionOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OppositePropertyCallExpOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * type = referredProperty.opposite.type
	 * @param oppositePropertyCallExp The receiving '<em><b>Opposite Property Call Exp</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static <C, P> boolean checkPropertyType(
			OppositePropertyCallExp<C, P> oppositePropertyCallExp,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		return true;
	}

} // OppositePropertyCallExpOperations