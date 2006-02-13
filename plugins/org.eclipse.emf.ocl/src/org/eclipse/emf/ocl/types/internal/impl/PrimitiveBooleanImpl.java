/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.types.internal.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Boolean</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveBooleanImpl extends PrimitiveTypeImpl implements PrimitiveBoolean {
	
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations = new BasicEList();
	/*
	 * Operations defined on Real
	 */
	protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i = 0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}
		operations.add(createBinaryOperation(OCL_BOOLEAN, "and", OCL_BOOLEAN)); //$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_BOOLEAN, "not"));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_BOOLEAN, "or", OCL_BOOLEAN));	//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_BOOLEAN, "implies", OCL_BOOLEAN));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_BOOLEAN, "xor", OCL_BOOLEAN));//$NON-NLS-1$
		return operations;
	}
	
	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected PrimitiveBooleanImpl() {
		super();
		this.setInstanceClass(Boolean.class);
		this.setClassifierID(TypesPackage.PRIMITIVE_BOOLEAN);
	}

	protected PrimitiveBooleanImpl(String name) {
		this();
		setName("Boolean");//$NON-NLS-1$
		this.setClassifierID(TypesPackage.PRIMITIVE_BOOLEAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.PRIMITIVE_BOOLEAN;
	}

} //PrimitiveBooleanImpl
