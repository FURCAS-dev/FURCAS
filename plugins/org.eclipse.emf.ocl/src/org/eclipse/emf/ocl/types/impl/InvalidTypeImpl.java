/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: InvalidTypeImpl.java,v 1.5 2006/04/20 20:04:44 cdamus Exp $
 */
package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.InvalidType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invalid Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InvalidTypeImpl extends EClassifierImpl implements InvalidType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/** The single instance (OclInvalid) of the Invalid type. */
	public static final Object OCL_INVALID = new EObjectImpl() {
	
		public EClass eClass() {
			return (EClass) Types.INVALID;
		}
	
		public String toString() {
			return "OclInvalid"; //$NON-NLS-1$
		}
	};
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvalidTypeImpl() {
		super();
	}

	public InvalidTypeImpl(String name) {
		super();
		setName(name);
		this.setClassifierID(TypesPackage.INVALID_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.INVALID_TYPE;
	}

	/**
	 * Obtain the result type on a collection type operation. A conformance
	 * test is performed, and the result type may be the common supertype of 
	 * the source and argument types, depending on the operation.
	 * @param opcode
	 * @param args
	 * @return the result type
	 * 
	 * @generated NOT
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args)
					throws SemanticException {
		
		return AnyTypeImpl.getResultType(ownerType, opcode, args);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getRelationshipTo(EClassifier type) {
		if (type == Types.INVALID) {
			return SAME_TYPE;
		}
		
		if (type != Types.OCL_VOID) {
			return STRICT_SUBTYPE;
		}
		
		return UNRELATED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getCommonSupertype(EClassifier type) throws SemanticException {
		if (type == Types.INVALID) {
			return Types.INVALID;
		}
		
		if (type != Types.OCL_VOID) {
			return (EClassifier) type;
		}

		String message = OCLMessages.bind(
				OCLMessages.TypeMismatch_ERROR_,
				this.getName(),
				TypeUtil.getName(type));
		OCLParser.ERR(message);
		
		// don't get this far
		return null;
	}

	/**
	 * Returns primitive type operation for the specified primitive operation
	 * name.  Used for efficient interpretation of OCL expressions.
	 * @param operName
	 * @return the opcode
	 * 
	 * @generated NOT
	 */
	public int getOperationCodeFor(String operName) {
		return AnyTypeImpl.getOperationCode(operName);
	}
	
	
	/**
	 * converts an opcode to a string
	 * @param opcode
	 * @return the corresponding name
	 * 
	 * @generated NOT
	 */
	public String getOperationNameFor(int opcode) {
		return AnyTypeImpl.getOperationName(opcode);
	}

	public EList getOperations() {
		return AnyTypeImpl.createAnyOperations();
	}

} //InvalidTypeImpl
