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
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Real</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveRealImpl extends PrimitiveTypeImpl implements PrimitiveReal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected PrimitiveRealImpl() {
		super();
		setInstanceClass(Double.class);
		this.setClassifierID(TypesPackage.PRIMITIVE_REAL);
	}

	protected PrimitiveRealImpl(String name) {
		this();
		setName("Real");//$NON-NLS-1$
		this.setClassifierID(TypesPackage.PRIMITIVE_REAL);
	}
	
	
	private static EList operations = new BasicEList();
	
	/*
	 * Operations defined on Real
	 */
	protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i = 0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}	
		
		operations.add(createBinaryOperation(OCL_REAL, "plus", OCL_REAL)); //$NON-NLS-1$
	    operations.add(createBinaryOperation(OCL_REAL, "minus", OCL_REAL));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_REAL, "minus")); //$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "times", OCL_REAL));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "divide", OCL_REAL));	//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "greaterThan", OCL_REAL));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "greaterThanEqual", OCL_REAL));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "lessThan", OCL_REAL));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "lessThanEqual", OCL_REAL));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "min", OCL_REAL));//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_REAL, "max", OCL_REAL)); //$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_REAL, "abs"));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_INTEGER, "floor"));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_INTEGER, "round"));	//$NON-NLS-1$
		return operations;
	}
		
	public EList getOperations() {
		if (operations == null || operations.size() == 0) 
			return this.initOperations();
		return operations;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.PRIMITIVE_REAL;
	}

} //PrimitiveRealImpl
