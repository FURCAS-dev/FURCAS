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
 * $Id: PrimitiveStringImpl.java,v 1.3 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive String</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveStringImpl extends PrimitiveTypeImpl implements PrimitiveString {
	public static final PrimitiveString INSTANCE = new PrimitiveStringImpl();
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/*
	 * Operations defined on String
	 */
	 
	private static EList operations;
	
    protected static EList createOperations() {
		if (operations == null) {
			operations = new BasicEList();
				
			EList parentOperations = AnyTypeImpl.createAnyOperations();
			for (int i = 0; i < parentOperations.size(); i++) {
				operations.add(parentOperations.get(i));
			}
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				LESS_THAN_NAME, Types.OCL_STRING, "s"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				GREATER_THAN_NAME, Types.OCL_STRING, "s"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				LESS_THAN_EQUAL_NAME, Types.OCL_STRING, "s"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				GREATER_THAN_EQUAL_NAME, Types.OCL_STRING, "s"));//$NON-NLS-1$
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_INTEGER,
				SIZE_NAME));
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_STRING,
				CONCAT_NAME, Types.OCL_STRING, "s"));//$NON-NLS-1$
			operations.add(TypeUtil.createTernaryOperation(Types.OCL_STRING,
				SUBSTRING_NAME, Types.OCL_INTEGER, "lower", Types.OCL_INTEGER, "upper"));//$NON-NLS-1$ //$NON-NLS-2$
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_INTEGER,
				TO_INTEGER_NAME));
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_REAL,
				TO_REAL_NAME));
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_STRING,
				TO_LOWER_NAME));
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_STRING,
				TO_UPPER_NAME));
		}
		
		return operations;			
    }
	
	public EList getOperations() {
		if (operations == null)
			return createOperations();
		return operations;
	}
	
	protected PrimitiveStringImpl() {
		super();
		setInstanceClass(String.class);
		setName("String");//$NON-NLS-1$
		this.setClassifierID(TypesPackage.PRIMITIVE_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.PRIMITIVE_STRING;
	}

} //PrimitiveStringImpl
