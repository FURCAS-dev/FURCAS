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
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.TypesPackage;

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
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/*
	 * Operations defined on String
	 */
	 
	private static EList operations = new BasicEList();
	
    protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i = 0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}
		operations.add(createUnaryOperation(OCL_INTEGER, "size"));	//$NON-NLS-1$
		operations.add(createBinaryOperation(OCL_STRING, "concat", OCL_STRING));//$NON-NLS-1$
		operations.add(createTernaryOperation(OCL_STRING, "substring", OCL_INTEGER, OCL_INTEGER));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_INTEGER, "toInteger"));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_REAL, "toReal"));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_STRING, "toLower"));//$NON-NLS-1$
		operations.add(createUnaryOperation(OCL_STRING, "toUpper"));//$NON-NLS-1$
		return operations;			
    }
	
	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}
	
	protected PrimitiveStringImpl() {
		super();
		setInstanceClass(String.class);
		this.setClassifierID(TypesPackage.PRIMITIVE_STRING);
	}

	protected PrimitiveStringImpl(String name) {
		this();
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
