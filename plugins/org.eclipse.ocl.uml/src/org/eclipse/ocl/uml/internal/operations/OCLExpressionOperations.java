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
 * $Id: OCLExpressionOperations.java,v 1.1 2008/11/24 00:24:04 cdamus Exp $
 */
package org.eclipse.ocl.uml.internal.operations;

import org.eclipse.ocl.uml.OCLExpression;

import org.eclipse.ocl.utilities.Visitor;

import org.eclipse.uml2.uml.Classifier;

import org.eclipse.uml2.uml.internal.operations.NamedElementOperations;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>OCL Expression</b></em>' model objects.
 * @since 2.0
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#getName() <em>Get Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#getType() <em>Get Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#setName(java.lang.String) <em>Set Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.TypedElement#setType(java.lang.Object) <em>Set Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.Visitable#accept(org.eclipse.ocl.utilities.Visitor) <em>Accept</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class OCLExpressionOperations
		extends NamedElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OCLExpressionOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static String getName(OCLExpression oclExpression) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Classifier getType(OCLExpression oclExpression) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static void setName(OCLExpression oclExpression, String name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static void setType(OCLExpression oclExpression, Classifier type) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(
			OCLExpression oclExpression, U v) {
		throw new UnsupportedOperationException();
	}

} // OCLExpressionOperations