/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PrimitiveRealImpl.java,v 1.4 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

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
	public static final PrimitiveReal INSTANCE = new PrimitiveRealImpl();
	
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
		setName("Real");//$NON-NLS-1$
		this.setClassifierID(TypesPackage.PRIMITIVE_REAL);
	}
	
	
	private static EList operations;
	
	/*
	 * Operations defined on Real
	 */
	protected static EList createOperations() {
		EList result = new BasicEList();
		
		EList parentOperations = AnyTypeImpl.createAnyOperations();
		result.addAll(parentOperations);
		
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
			LESS_THAN_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
			GREATER_THAN_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
			LESS_THAN_EQUAL_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
			GREATER_THAN_EQUAL_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_REAL,
			PLUS_NAME, Types.OCL_REAL, "r")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_REAL,
	    	MINUS_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createUnaryOperation(Types.OCL_REAL,
			MINUS_NAME));
		result.add(TypeUtil.createBinaryOperation(Types.OCL_REAL,
			TIMES_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_REAL,
			DIVIDE_NAME, Types.OCL_REAL, "r"));	//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_REAL,
			MIN_NAME, Types.OCL_REAL, "r"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_REAL,
			MAX_NAME, Types.OCL_REAL, "r")); //$NON-NLS-1$
		result.add(TypeUtil.createUnaryOperation(Types.OCL_REAL,
			ABS_NAME));
		result.add(TypeUtil.createUnaryOperation(Types.OCL_INTEGER,
			FLOOR_NAME));
		result.add(TypeUtil.createUnaryOperation(Types.OCL_INTEGER,
			ROUND_NAME));
		
		return result;
	}
		
	public EList getOperations() {
		if (operations == null) { 
			operations = createOperations();
		}
		
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
