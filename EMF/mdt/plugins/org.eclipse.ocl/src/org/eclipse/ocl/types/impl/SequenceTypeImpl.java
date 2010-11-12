/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: SequenceTypeImpl.java,v 1.7 2010/04/23 05:53:02 ewillink Exp $
 */
package org.eclipse.ocl.types.impl;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.operations.SequenceTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SequenceTypeImpl<C, O>
		extends CollectionTypeImpl<C, O>
		implements SequenceType<C, O> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceTypeImpl() {
		super();
	}

	protected SequenceTypeImpl(C elementType) {
		super(elementType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.SEQUENCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean checkCollectionTypeName(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return SequenceTypeOperations.checkCollectionTypeName(this,
			diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public CollectionKind getKind() {
		return CollectionKind.SEQUENCE_LITERAL;
	}

} //SequenceTypeImpl
