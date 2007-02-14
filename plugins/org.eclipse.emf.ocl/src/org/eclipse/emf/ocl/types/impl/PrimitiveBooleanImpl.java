/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: PrimitiveBooleanImpl.java,v 1.2 2007/02/14 14:45:42 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

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
	
	public static final PrimitiveBoolean INSTANCE = new PrimitiveBooleanImpl();
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations;
	
	/*
	 * Operations defined on Real
	 */
	protected static EList createOperations() {
		if (operations == null) {
			operations = new BasicEList();
			
			EList parentOperations = AnyTypeImpl.createAnyOperations();
			for (int i = 0; i < parentOperations.size(); i++) {
				operations.add(parentOperations.get(i));
			}
			operations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
				NOT_NAME));
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				AND_NAME, Types.OCL_BOOLEAN, "b")); //$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				OR_NAME, Types.OCL_BOOLEAN, "b"));	//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				IMPLIES_NAME, Types.OCL_BOOLEAN, "b"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				XOR_NAME, Types.OCL_BOOLEAN, "b"));//$NON-NLS-1$
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
	protected PrimitiveBooleanImpl() {
		super();
		this.setInstanceClass(Boolean.class);
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
