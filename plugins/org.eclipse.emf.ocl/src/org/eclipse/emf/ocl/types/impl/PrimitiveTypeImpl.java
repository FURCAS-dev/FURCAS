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
 * $Id: PrimitiveTypeImpl.java,v 1.1 2006/04/04 18:09:02 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.osgi.util.NLS;

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
		case AnyTypeImpl.GREATER_THAN:
		case AnyTypeImpl.LESS_THAN:
		case AnyTypeImpl.GREATER_THAN_EQUAL:
		case AnyTypeImpl.LESS_THAN_EQUAL:
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

		String message = NLS.bind(OCLMessages.TypeMismatch_ERROR_,
			new Object[] {this.getName(), type.getName() });
		OCLParser.ERR(message);
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
		
		if (operName.equals("plus")) return PLUS;//$NON-NLS-1$
		if (operName.equals("minus")) return MINUS;//$NON-NLS-1$
		if (operName.equals("times")) return TIMES;//$NON-NLS-1$
		if (operName.equals("divide")) return DIVIDE;//$NON-NLS-1$
		if (operName.equals("and")) return AND;//$NON-NLS-1$
		if (operName.equals("not")) return NOT;//$NON-NLS-1$
		if (operName.equals("or")) return OR;//$NON-NLS-1$
		if (operName.equals("implies")) return IMPLIES;//$NON-NLS-1$
		if (operName.equals("div")) return DIV;//$NON-NLS-1$
		if (operName.equals("abs")) return ABS;//$NON-NLS-1$
		if (operName.equals("floor")) return FLOOR;//$NON-NLS-1$
		if (operName.equals("round")) return ROUND;//$NON-NLS-1$
		if (operName.equals("max")) return MAX;//$NON-NLS-1$
		if (operName.equals("min")) return MIN;//$NON-NLS-1$
		if (operName.equals("mod")) return MOD;//$NON-NLS-1$
		if (operName.equals("substring")) return SUBSTRING;//$NON-NLS-1$
		if (operName.equals("size")) return SIZE;//$NON-NLS-1$
		if (operName.equals("concat")) return CONCAT;//$NON-NLS-1$
		if (operName.equals("xor")) return XOR;//$NON-NLS-1$
		if (operName.equals("toInteger")) return TO_INTEGER;//$NON-NLS-1$
		if (operName.equals("toReal")) return TO_REAL;//$NON-NLS-1$
		if (operName.equals("toLower")) return TO_LOWER;//$NON-NLS-1$
		if (operName.equals("toUpper")) return TO_UPPER;//$NON-NLS-1$
		
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
		
			case PLUS: return "plus";//$NON-NLS-1$
			case MINUS: return "minus";//$NON-NLS-1$
			case TIMES: return "times";//$NON-NLS-1$
			case DIVIDE: return "divide";//$NON-NLS-1$
			case AND: return "and";//$NON-NLS-1$
			case OR: return "or";//$NON-NLS-1$
			case IMPLIES: return "implies";//$NON-NLS-1$
			case DIV: return "div";//$NON-NLS-1$
			case ABS: return "abs";//$NON-NLS-1$
			case FLOOR: return "floor";//$NON-NLS-1$
			case ROUND: return "round";//$NON-NLS-1$
			case MAX: return "max";//$NON-NLS-1$
			case MIN: return "min";//$NON-NLS-1$
			case MOD: return "mod";//$NON-NLS-1$
			case SUBSTRING: return "substring";//$NON-NLS-1$
			case SIZE: return "size";//$NON-NLS-1$
			case CONCAT: return "concat";//$NON-NLS-1$
			case XOR: return "xor";//$NON-NLS-1$
			case TO_INTEGER: return "toInteger";//$NON-NLS-1$
			case TO_REAL: return "toReal";//$NON-NLS-1$
			case TO_LOWER: return "toLower";//$NON-NLS-1$
			case TO_UPPER: return "toUpper";//$NON-NLS-1$
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


	
