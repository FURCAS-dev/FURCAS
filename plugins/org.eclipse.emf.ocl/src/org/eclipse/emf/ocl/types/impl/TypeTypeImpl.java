/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TypeTypeImpl.java,v 1.7 2007/01/29 20:31:18 cdamus Exp $
 */
package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ocl.internal.parser.CompatibilityParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TypeTypeImpl extends EClassifierImpl implements TypeType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$
	
	public static final TypeType INSTANCE = new TypeTypeImpl(
			AnyTypeImpl.OCL_T, "OclType"); //$NON-NLS-1$
	
	private EClassifier type;
	
	/*
	 * Operations for TypeType
	 */
	private static EList operations = null;

	/**
	 * Initialiaze Operations defined on TypeType
	 */
	protected static EList createOperations() {
		if (operations == null) {
			operations = new BasicEList();
			
			operations.add(TypeUtil.createUnaryOperation(CollectionTypeImpl.OCL_SET,
				ALL_INSTANCES_NAME));
			
			operations.addAll(AnyTypeImpl.createAnyOperations());
		}
		
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TypeTypeImpl(EClassifier type, String name) {
		super();
		this.type = type;
		setName(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected TypeTypeImpl(EClassifier type) {
		this(type, type.getName());
	}
	
	public static TypeType createType(EClassifier type) {
		return new TypeTypeImpl(type);
	}
	
	public EClassifier getReferredType() {
		return type;
	}
	
	/**
	 * Returns type operation for the specified collection operation name. Used
	 * for efficient interpretation of OCL expressions.
	 * 
	 * @param operName
	 * @return the operation code
	 * 
	 * @generated NOT
	 */
	public int getOperationCodeFor(String operName) {
		if (operName.equals(ALL_INSTANCES_NAME))return ALL_INSTANCES;
	
		return AnyTypeImpl.getOperationCode(operName);
	}

	/**
	 * @generated NOT
	 */
	public String getOperationNameFor(int opcode) {
		switch (opcode) {
			case ALL_INSTANCES:
				return ALL_INSTANCES_NAME;
		}

		return AnyTypeImpl.getOperationName(opcode);
	}

	public EList getOperations() {
		if (operations == null)
			return createOperations();
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args) throws SemanticException {
		switch (opcode) {
			case PredefinedType.ALL_INSTANCES:
				return TypesFactory.eINSTANCE.createSetType(type);
		}
		
		return AnyTypeImpl.getResultType(ownerType, opcode, args);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getRelationshipTo(EClassifier type) {

		if (this == type)
			return SAME_TYPE;
		
		if (type == Types.OCL_TYPE)
			return STRICT_SUBTYPE;
		
		if (this == Types.OCL_TYPE && type instanceof TypeType)
			return STRICT_SUPERTYPE;
		
		return UNRELATED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getCommonSupertype(EClassifier type) throws SemanticException {
		if (this == type) {
			return this;
		}
		
		if (type instanceof TypeType) {
			return Types.OCL_TYPE;
		}

		String message = OCLMessages.bind(
				OCLMessages.TypeMismatch_ERROR_,
				this.getName(),
				TypeUtil.getName(type));
		CompatibilityParser.ERR(message);
		
		// don't get this far
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.TYPE_TYPE;
	}

} //TypeTypeImpl
