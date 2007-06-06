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
 * $Id: PrimitiveIntegerImpl.java,v 1.5 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Integer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveIntegerImpl extends PrimitiveRealImpl implements PrimitiveInteger {
	
	public static PrimitiveInteger INSTANCE = new PrimitiveIntegerImpl();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations;
	
	/**
	 * Initialize Operations defined on Integer
	 */
	protected static EList createOperations() {
		if (operations == null) {
			operations = new BasicEList();
			
			EList parentOperations = PrimitiveRealImpl.createOperations();
			operations.addAll(parentOperations);
			
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				LESS_THAN_NAME, Types.OCL_INTEGER, "i"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				GREATER_THAN_NAME, Types.OCL_INTEGER, "i"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				LESS_THAN_EQUAL_NAME, Types.OCL_INTEGER, "i"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				GREATER_THAN_EQUAL_NAME, Types.OCL_INTEGER, "i"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_INTEGER,
				DIV_NAME, Types.OCL_INTEGER, "i"));	//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_INTEGER,
				MOD_NAME, Types.OCL_INTEGER, "i")); //$NON-NLS-1$
		}
		
		return operations;
	}
	
	public EList getOperations() {
		if (operations == null)
			return createOperations();
		return operations;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected PrimitiveIntegerImpl() {
		super();
		setInstanceClass(Integer.class);
		setName("Integer");//$NON-NLS-1$
		this.setClassifierID(TypesPackage.PRIMITIVE_INTEGER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.PRIMITIVE_INTEGER;
	}

} //PrimitiveIntegerImpl
