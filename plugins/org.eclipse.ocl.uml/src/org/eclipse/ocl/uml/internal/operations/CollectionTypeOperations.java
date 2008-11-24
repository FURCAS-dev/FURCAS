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
 * $Id: CollectionTypeOperations.java,v 1.1 2008/11/24 00:23:33 cdamus Exp $
 */
package org.eclipse.ocl.uml.internal.operations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.uml.CollectionType;

import org.eclipse.uml2.uml.Operation;

import org.eclipse.uml2.uml.internal.operations.DataTypeOperations;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Collection Type</b></em>' model objects.
 * @since 2.0
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.utilities.PredefinedType#getName() <em>Get Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.utilities.PredefinedType#oclOperations() <em>Ocl Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class CollectionTypeOperations
		extends DataTypeOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static String getName(CollectionType collectionType) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static EList<Operation> oclOperations(CollectionType collectionType) {
		throw new UnsupportedOperationException();
	}

} // CollectionTypeOperations