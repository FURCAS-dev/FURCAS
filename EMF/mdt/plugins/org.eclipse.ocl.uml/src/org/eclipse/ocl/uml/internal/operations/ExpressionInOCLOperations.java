/**
 * <copyright>
 *  
 * Copyright (c) 2008 Zeligsoft Inc. and others.
 *  All rights reserved.   This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *    Zeligsoft - Initial API and implementation
 *    
 * </copyright>
 *
 * $Id: ExpressionInOCLOperations.java,v 1.1 2008/11/24 00:24:12 cdamus Exp $
 */
package org.eclipse.ocl.uml.internal.operations;

import org.eclipse.ocl.uml.ExpressionInOCL;

import org.eclipse.ocl.utilities.Visitor;

import org.eclipse.uml2.uml.internal.operations.OpaqueExpressionOperations;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Expression In OCL</b></em>' model objects.
 * @since 2.0
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.Visitable#accept(org.eclipse.ocl.utilities.Visitor) <em>Accept</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class ExpressionInOCLOperations
		extends OpaqueExpressionOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionInOCLOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(
			ExpressionInOCL expressionInOCL, U v) {
		throw new UnsupportedOperationException();
	}

} // ExpressionInOCLOperations