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
 * $Id: AnyTypeImpl.java,v 1.4 2006/04/13 12:06:35 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassifierImpl;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.osgi.util.NLS;

/**
 * @author Edith Schonberg (edith)
 * @generated
 */
public class AnyTypeImpl
	extends EClassifierImpl
	implements AnyType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	public static AnyType INSTANCE = new AnyTypeImpl("OclAny");//$NON-NLS-1$
	
	/** Special type denoting the type parameter T in generic operations. */
	public static EClassifier OCL_T = new AnyTypeImpl("T");//$NON-NLS-1$

	/** Special type denoting the type parameter T2 in generic operations. */
	public static EClassifier OCL_T2 = new AnyTypeImpl("T2");//$NON-NLS-1$

	public static EClassifier UML_CLASSIFIER = EcorePackage.Literals.ECLASSIFIER;
	
	/*
	 * Operations for AnyType
	 */
	private static EList anyOperations = null;
	private static EList operations = null;

	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected static EList createAnyOperations() {
		if (anyOperations == null) {
			anyOperations = new BasicEList();
			
			anyOperations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				EQUAL_NAME, Types.OCL_ANY_TYPE, "object")); //$NON-NLS-1$
			anyOperations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				NOT_EQUAL_NAME, Types.OCL_ANY_TYPE, "object")); //$NON-NLS-1$
			anyOperations.add(TypeUtil.createBinaryOperation(OCL_T,
				OCL_AS_TYPE_NAME, Types.OCL_TYPE, "typespec")); //$NON-NLS-1$
			anyOperations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				OCL_IS_KIND_OF_NAME, Types.OCL_TYPE, "typespec"));//$NON-NLS-1$
			anyOperations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				OCL_IS_TYPE_OF_NAME, Types.OCL_TYPE, "typespec"));//$NON-NLS-1$
			anyOperations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
				OCL_IS_UNDEFINED_NAME));
			anyOperations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
				OCL_IS_INVALID_NAME));
			anyOperations.add(TypeUtil.createUnaryOperation(Types.OCL_BOOLEAN,
				OCL_IS_NEW_NAME));
			anyOperations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				OCL_IS_IN_STATE_NAME, Types.STATE, "statespec")); //$NON-NLS-1$
		}
		return anyOperations;
	}

	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected static EList createOperations() {
		if (operations == null) {
			operations = new BasicEList();
			operations.addAll(createAnyOperations());
			
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				LESS_THAN_NAME, OCL_T, "object"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				GREATER_THAN_NAME, OCL_T, "object"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				LESS_THAN_EQUAL_NAME, OCL_T, "object"));//$NON-NLS-1$
			operations.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				GREATER_THAN_EQUAL_NAME, OCL_T, "object"));//$NON-NLS-1$
		}
		return operations;
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
		return getOperationCode(operName);
	}
	
	public static int getOperationCode(String operName) {
		if (operName.equals(EQUAL_NAME))return EQUAL;
		if (operName.equals(NOT_EQUAL_NAME))return NOT_EQUAL;
		if (operName.equals(OCL_AS_TYPE_NAME))return OCL_AS_TYPE;
		if (operName.equals(OCL_IS_KIND_OF_NAME))return OCL_IS_KIND_OF;
		if (operName.equals(OCL_IS_TYPE_OF_NAME))return OCL_IS_TYPE_OF;
		if (operName.equals(OCL_IS_UNDEFINED_NAME))return OCL_IS_UNDEFINED;
		if (operName.equals(OCL_IS_INVALID_NAME))return OCL_IS_INVALID;
		if (operName.equals(LESS_THAN_NAME))return LESS_THAN;
		if (operName.equals(GREATER_THAN_NAME))return GREATER_THAN;
		if (operName.equals(LESS_THAN_EQUAL_NAME))return LESS_THAN_EQUAL;
		if (operName.equals(GREATER_THAN_EQUAL_NAME))return GREATER_THAN_EQUAL;
		if (operName.equals(OCL_IS_NEW_NAME))return OCL_IS_NEW;
		if (operName.equals(OCL_IS_IN_STATE_NAME))return OCL_IS_IN_STATE;
	
		return 0;
	}

	/**
	 * @generated NOT
	 */
	public String getOperationNameFor(int opcode) {
		return getOperationName(opcode);
	}
	
	/**
	 * Returns the operation name corresponding to the opcode
	 * 
	 * @param opcode
	 * @return the name corresponding to the opcode
	 */
	public static String getOperationName(int opcode) {

		switch (opcode) {

			case EQUAL:
				return EQUAL_NAME;
			case NOT_EQUAL:
				return NOT_EQUAL_NAME;
			case OCL_AS_TYPE:
				return OCL_AS_TYPE_NAME;
			case OCL_IS_KIND_OF:
				return OCL_IS_KIND_OF_NAME;
			case OCL_IS_TYPE_OF:
				return OCL_IS_TYPE_OF_NAME;
			case OCL_IS_UNDEFINED:
				return OCL_IS_UNDEFINED_NAME;
			case OCL_IS_INVALID:
				return OCL_IS_INVALID_NAME;
			case LESS_THAN:
				return LESS_THAN_NAME;
			case GREATER_THAN:
				return GREATER_THAN_NAME;
			case LESS_THAN_EQUAL:
				return LESS_THAN_EQUAL_NAME;
			case GREATER_THAN_EQUAL:
				return GREATER_THAN_EQUAL_NAME;
			case OCL_IS_NEW:
				return OCL_IS_NEW_NAME;
			case OCL_IS_IN_STATE:
				return OCL_IS_IN_STATE_NAME;
		}

		return "";//$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args) throws SemanticException {
		return getResultType(ownerType, opcode, args);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getRelationshipTo(EClassifier type) {
		if (this == type) {
			return SAME_TYPE;
		}
		
		if (type == AnyTypeImpl.UML_CLASSIFIER) {
			return STRICT_SUBTYPE;
		}
		
		if (!(type instanceof CollectionType)) {
			return STRICT_SUPERTYPE;
		}
		
		return UNRELATED_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClassifier getCommonSupertype(EClassifier type) throws SemanticException {

		if (type == AnyTypeImpl.UML_CLASSIFIER) {
			return AnyTypeImpl.UML_CLASSIFIER;
		}
		
		if (!(type instanceof CollectionType)) {
			return this;
		}

		String message = NLS.bind(OCLMessages.TypeMismatch_ERROR_,
			new Object[] {this.getName(), type.getName() });
		OCLParser.ERR(message);
		return null;
	}

	/**
	 * Obtain the result type on an AnyType type operation. Note: This type is
	 * static since EClass and EEnum are not items of AnyType in EMF.
	 * 
	 * @param type source type
	 * @param opcode the operation code
	 * @param args the operation arguments
	 * @return the result type
	 */
	public static EClassifier getResultType(EClassifier type, int opcode,
		EList args) throws SemanticException {

		switch (opcode) {
			case NOT_EQUAL:
			case EQUAL:
				/*
				 * Performs a conformance test for primitives, EClass, EEnum,
				 * TupleType
				 */
				OCLExpression arg = (OCLExpression) args.get(0);
				EClassifier argType = arg.getType();
				if (type == Types.INVALID) {
					return Types.OCL_BOOLEAN;
				} else if (type instanceof EEnum) {
					if (type != argType && argType != Types.OCL_ANY_TYPE) {
						String message = NLS.bind(
								OCLMessages.Noncomforming_ERROR_,
								new Object[] {type.getName(),
								getOperationName(opcode) });
						OCLParser.ERR(message);
					}
				} else if (type instanceof TupleType) {
					((TupleTypeImpl) type).getCommonSupertype(argType);
				} else if (type instanceof PrimitiveType) {
					arg = (OCLExpression) args.get(0);
					argType = arg.getType();
					
					// Invalid and OclVoid types are defined as subtypes of
					//    all other types
					if (!(argType instanceof PrimitiveType)
						&& !((argType == Types.OCL_ANY_TYPE)
								|| (argType == Types.INVALID)
								|| (argType == Types.OCL_VOID))) {
						String message = NLS.bind(
								OCLMessages.Noncomforming_ERROR_,
								new Object[] {type.getName(),
								getOperationName(opcode) });
						OCLParser.ERR(message);
					} /*
					 * else if (argType instanceof PrimitiveType) { // Do
					 * conformance test commonSuperType(type, argType); }
					 */
				}
				return Types.OCL_BOOLEAN;
			case LESS_THAN:
			case GREATER_THAN:
			case LESS_THAN_EQUAL:
			case GREATER_THAN_EQUAL:
				// source must either be an EDataType that is Comparable, or
				//    else be an EClass, with a method: int compareTo(object)
				//    or <(), <=(), etc.
				if (!(type instanceof EClass)) {
					if (TypeUtil.isComparable(type)) {
						return Types.OCL_BOOLEAN;
					}
					
					String message = NLS.bind(OCLMessages.SourceEClass_ERROR_,
						new Object[] {getOperationName(opcode) });
					OCLParser.ERR(message);
				}
				
				EOperation oper = null;
				try {
					oper = TypeUtil.findOperationMatching(type,
							PrimitiveTypeImpl.getOperationName(opcode), args);
					
					if (oper == null) {
						// Check that the type has a method named "compareTo"
						oper = TypeUtil.findOperationMatching(type,
							"compareTo", args);//$NON-NLS-1$
					}
				} catch (Exception e) {
					String message = NLS.bind(
							OCLMessages.SourceOperationCompareTo_ERROR_,
						new Object[] {getOperationName(opcode) });
					OCLParser.ERR(message);
				}
				
				if ((oper != null) && "compareTo".equals(oper.getName()) //$NON-NLS-1$
						&& (TypeUtil.getOCLType(oper) != Types.OCL_INTEGER)) {
					OCLParser.ERR(OCLMessages.ResultCompareToInt_ERROR_);
				}
			// NEED TO CHECK CONFORMANCE OF ARGS if ECLASS...

			case OCL_IS_KIND_OF:
			case OCL_IS_TYPE_OF:
			case OCL_IS_NEW:
			case OCL_IS_IN_STATE:
				return Types.OCL_BOOLEAN;
			case OCL_AS_TYPE:
				TypeExp typeExp = (TypeExp) args.get(0);
				EClassifier argEType = typeExp.getReferredType();
				if (type instanceof CollectionType) {
					String message = NLS.bind(OCLMessages.Noncomforming_ERROR_,
						new Object[] {type.getName(),
							getOperationName(opcode) });
					OCLParser.ERR(message);
				}
				// we can require neither a common supertype nor that type2
				// and type1 have any conformance relationship whatsoever
				// because the run-time 'type' may conform to 'arg'
				//				commonSuperType(argEType, type);
				//type1AsType2(type, argEType);
				return argEType;
			case OCL_IS_UNDEFINED:
			case OCL_IS_INVALID:
				return Types.OCL_BOOLEAN;
		}
		return null;
	}

	/**
     * Computes the equivalence of two objects, accounting for primtive numeric
     * values that OCL considers equal but Java does not.
     * 
     * @param anObject an object
     * @param anotherObject another object
     * 
     * @return whether they are equivalent as far as OCL is concerned
     */
	public static boolean equal(Object anObject, Object anotherObject) {
		// if either value is undefined, the result is true just if both are
		// undefined and
		// false otherwise.
		if (anObject == null || anotherObject == null)
			return anObject == anotherObject;

		// likewise if either value is invalid.
		if (anObject == Types.OCL_INVALID || anotherObject == Types.OCL_INVALID)
			return anObject == anotherObject;

		// primitive types
		if (TypeUtil.isPrimitive(anObject) || TypeUtil.isPrimitive(anotherObject)) {
			if (anObject instanceof Integer && anotherObject instanceof Integer)
				return ((Integer) anObject).intValue()
					== ((Integer) anotherObject).intValue();
			else if (anObject instanceof Integer && anotherObject instanceof Double)
				return ((Integer) anObject).intValue()
					== ((Double) anotherObject).doubleValue();
			else if (anObject instanceof Double && anotherObject instanceof Integer)
				return ((Double) anObject).doubleValue()
					== ((Integer) anotherObject).intValue();
			else if (anObject instanceof Double && anotherObject instanceof Double)
				return ((Double) anObject).doubleValue()
					== ((Double) anotherObject).doubleValue();
			else if (anObject instanceof String && anotherObject instanceof String)
				return ((String) anObject).equals(anotherObject);
			else if (anObject instanceof Boolean && anotherObject instanceof Boolean)
				return anObject == anotherObject;

			// if the types are incompatible the result is false
			return false;
		}

		if ((anObject instanceof EEnumLiteral) && (anotherObject instanceof EEnumLiteral)) {
			return anObject == anotherObject;
		}
		
		if ((anObject instanceof Collection) && (anotherObject instanceof Collection)) {
			return CollectionTypeImpl.equals(
					(Collection) anObject, (Collection) anotherObject);
		}

		return anObject.equals(anotherObject);
	}
	
    /**
     * Computes hash of an object, accounting for the similar
     * hashing of primitive numeric values that OCL considers equal but Java
     * does not.
     * 
     * @param anObject an object
     * 
     * @return its OCL hash
     */
	public static int hashCode(Object anObject) {
		if (anObject == null) {
			return 0;
		}

		if (TypeUtil.isPrimitive(anObject)) {
			// equal double and integer should hash the same 
			if (anObject instanceof Integer)
				return 37 * ((Integer) anObject).intValue();
			else if (anObject instanceof Double)
				return 37 * ((Double) anObject).intValue();
			else if (anObject instanceof String)
				return anObject.hashCode();
			else if (anObject instanceof Boolean)
				return anObject.hashCode();

			// shouldn't get here (there are no other OCL primitives)
			return 0;
		}

		if (anObject instanceof EEnumLiteral) {
			return ((EEnumLiteral) anObject).getInstance().hashCode();
		}
		
		if ((anObject instanceof Collection)) {
			return CollectionTypeImpl.hashCode((Collection) anObject);
		}

		return anObject.hashCode();
	}

	public EList getOperations() {
		if (operations == null)
			return createOperations();
		return operations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected AnyTypeImpl() {
		super();
		setInstanceClass(Object.class);
	}

	protected AnyTypeImpl(String name) {
		this();
		setName(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.ANY_TYPE;
	}

}