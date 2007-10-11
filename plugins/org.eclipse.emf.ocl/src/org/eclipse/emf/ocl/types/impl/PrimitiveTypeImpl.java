/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: PrimitiveTypeImpl.java,v 1.8 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.internal.parser.CompatibilityParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class PrimitiveTypeImpl extends EDataTypeImpl implements PrimitiveType {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

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
		
		switch (opcode) {
			
		case PLUS:
		case TIMES:
			OCLExpression arg = (OCLExpression)args.get(0);
			EClassifier argType = arg.getType();
			return TypeUtil.commonSuperType(argType, this);
		case DIVIDE:
			arg = (OCLExpression)args.get(0);
			argType = arg.getType();
			TypeUtil.commonSuperType(argType, this);
			return Types.OCL_REAL;
		case MINUS:
			if (args == null || args.size() == 0) return this;
			arg = (OCLExpression)args.get(0);
			argType = arg.getType();
			return TypeUtil.commonSuperType(argType, this);
		case PredefinedType.GREATER_THAN:
		case PredefinedType.LESS_THAN:
		case PredefinedType.GREATER_THAN_EQUAL:
		case PredefinedType.LESS_THAN_EQUAL:
		case IMPLIES:
		case XOR:
		case NOT:
		case AND:
		case OR:
			return Types.OCL_BOOLEAN;			
		case MIN:
		case MAX:
		case ABS:
		case DIV:
		case MOD:
		case SUBSTRING:
		case CONCAT:
			return this;
		case FLOOR:
		case TO_INTEGER:
		case SIZE:
		case ROUND:
			return Types.OCL_INTEGER; 
		case TO_REAL:
			return Types.OCL_REAL;
		case TO_LOWER:
		case TO_UPPER:
			return Types.OCL_STRING;
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

		if (this == Types.OCL_INTEGER
				&& type == Types.OCL_REAL)
				return STRICT_SUBTYPE;
		if (type == Types.OCL_INTEGER
				&& this == Types.OCL_REAL)
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

		if (this == Types.OCL_INTEGER
				&& type == Types.OCL_REAL)
				return Types.OCL_REAL;
		if (type == Types.OCL_INTEGER
				&& this == Types.OCL_REAL)
				return Types.OCL_REAL;

		String message = OCLMessages.bind(
				OCLMessages.TypeMismatch_ERROR_,
				this.getName(),
				TypeUtil.getName(type));
		CompatibilityParser.ERR(message);
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
		return getOperationCode(operName);
	}

	public static int getOperationCode(String operName) {
		if (operName.equals(PLUS_NAME)) return PLUS;
		if (operName.equals(MINUS_NAME)) return MINUS;
		if (operName.equals(TIMES_NAME)) return TIMES;
		if (operName.equals(DIVIDE_NAME)) return DIVIDE;
		if (operName.equals(NOT_NAME)) return NOT;
		if (operName.equals(AND_NAME)) return AND;
		if (operName.equals(OR_NAME)) return OR;
		if (operName.equals(XOR_NAME)) return XOR;
		if (operName.equals(IMPLIES_NAME)) return IMPLIES;
		if (operName.equals(ABS_NAME)) return ABS;
		if (operName.equals(FLOOR_NAME)) return FLOOR;
		if (operName.equals(ROUND_NAME)) return ROUND;
		if (operName.equals(MAX_NAME)) return MAX;
		if (operName.equals(MIN_NAME)) return MIN;
		if (operName.equals(DIV_NAME)) return DIV;
		if (operName.equals(MOD_NAME)) return MOD;
		if (operName.equals(SUBSTRING_NAME)) return SUBSTRING;
		if (operName.equals(SIZE_NAME)) return SIZE;
		if (operName.equals(CONCAT_NAME)) return CONCAT;
		if (operName.equals(TO_INTEGER_NAME)) return TO_INTEGER;
		if (operName.equals(TO_REAL_NAME)) return TO_REAL;
		if (operName.equals(TO_LOWER_NAME)) return TO_LOWER;
		if (operName.equals(TO_UPPER_NAME)) return TO_UPPER;
		
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
		return getOperationName(opcode);
	}
	
	public static String getOperationName(int opcode) {
		switch (opcode) {
		
			case PLUS: return PLUS_NAME;
			case MINUS: return MINUS_NAME;
			case TIMES: return TIMES_NAME;
			case DIVIDE: return DIVIDE_NAME;
			case NOT: return NOT_NAME;
			case AND: return AND_NAME;
			case OR: return OR_NAME;
			case XOR: return XOR_NAME;
			case IMPLIES: return IMPLIES_NAME;
			case ABS: return ABS_NAME;
			case FLOOR: return FLOOR_NAME;
			case ROUND: return ROUND_NAME;
			case MAX: return MAX_NAME;
			case MIN: return MIN_NAME;
			case DIV: return DIV_NAME;
			case MOD: return MOD_NAME;
			case SUBSTRING: return SUBSTRING_NAME;
			case SIZE: return SIZE_NAME;
			case CONCAT: return CONCAT_NAME;
			case TO_INTEGER: return TO_INTEGER_NAME;
			case TO_REAL: return TO_REAL_NAME;
			case TO_LOWER: return TO_LOWER_NAME;
			case TO_UPPER: return TO_UPPER_NAME;
		}
		
		return AnyTypeImpl.getOperationName(opcode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	protected PrimitiveTypeImpl(String name) {
		super();
		setName(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
    protected EClass eStaticClass() {
		return TypesPackage.Literals.PRIMITIVE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getOperations() {
		throw new UnsupportedOperationException();
	}

}	


	
