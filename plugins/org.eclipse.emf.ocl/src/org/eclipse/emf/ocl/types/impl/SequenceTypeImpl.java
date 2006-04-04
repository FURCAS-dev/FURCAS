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
 * $Id: SequenceTypeImpl.java,v 1.2 2006/04/04 19:07:00 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SequenceTypeImpl
	extends CollectionTypeImpl
	implements SequenceType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations;
	private static EList iterators;

	protected SequenceTypeImpl() {
		super();
		setInstanceClass(List.class);
		this.setClassifierID(TypesPackage.SEQUENCE_TYPE);
	}

	protected SequenceTypeImpl(EClassifier elementType) {
		super();
		this.elementType = elementType;
		setInstanceClass(List.class);
		this.setClassifierID(TypesPackage.SEQUENCE_TYPE);
	}
	
	public String getName() {
		if (name == null) {
			if (elementType != null) {
				name = "Sequence(" + elementType.getName() + ')'; //$NON-NLS-1$
			} else {
				name = "Sequence(?)"; //$NON-NLS-1$
			}
		}
		
		return super.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.SEQUENCE_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.SEQUENCE_TYPE;
	}

	/**
	 * Return result type of  operation based on the sourceType and args.
	 * Conformance rules are applied.  It is assumed that operation signature
	 * is already checked by the time this method is called.
	 * @param opcode
	 * @param args
	 * @return the result type
	 * @throws SemanticException
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args)
		throws SemanticException {

		EClassifier elemType = getElementType();

		switch (opcode) {

			case COUNT:
			case INDEX_OF:
				return Types.OCL_INTEGER;
			case EQUAL:
			case NOT_EQUAL:
				return Types.OCL_BOOLEAN;
			case UNION:
				OCLExpression arg = (OCLExpression) args.get(0);
				CollectionType argType = (CollectionType) arg.getType();
				EClassifier argElementType = argType.getElementType();
				CollectionType resultType = TypesFactory.eINSTANCE
					.createSequenceType();
				resultType.setElementType(TypeUtil.commonSuperType(
					elemType, argElementType));
				return resultType;
			case INCLUDING:
			case APPEND:
			case PREPEND:
				arg = (OCLExpression) args.get(0);
				EClassifier eArgType = arg.getType();
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(TypeUtil.commonSuperType(
					elemType, eArgType));
				return resultType;
			case INSERT_AT:
				arg = (OCLExpression) args.get(1); // arg 0 is the index
				eArgType = arg.getType();
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(TypeUtil.commonSuperType(
					elemType, eArgType));
				return resultType;
			case EXCLUDING:
				return this;
			case FLATTEN:
				if (!(elemType instanceof CollectionType))
					return this;
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(((CollectionType) elemType)
					.getElementType());
				return resultType;
			case AT:
			case FIRST:
			case LAST:
				return elemType;
			case AS_BAG:
				return TypesFactory.eINSTANCE.createBagType(elemType);
			case AS_SEQUENCE:
			case SUB_SEQUENCE:
				return this;
			case AS_SET:
				return TypesFactory.eINSTANCE.createSetType(elemType);
			case AS_ORDERED_SET:
				return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
	        case SELECT:
	        case REJECT:
	        	return this;
	        case SORTED_BY:
	        	return TypesFactory.eINSTANCE.createSequenceType(getElementType());
	        case COLLECT_NESTED:
	        	return TypesFactory.eINSTANCE.createSequenceType(AnyTypeImpl.OCL_T2);
		}

		return (super.getResultTypeFor(ownerType, opcode, args));
	}

	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected static EList createOperations() {
		EList result = new BasicEList();
		
		result.addAll(CollectionTypeImpl.createOperations());
		
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
			EQUAL_NAME, OCL_SEQUENCE, "s"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
			NOT_EQUAL_NAME, OCL_SEQUENCE, "s")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SEQUENCE,
			UNION_NAME, OCL_SEQUENCE, "s")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SEQUENCE,
			APPEND_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SEQUENCE,
			PREPEND_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createTernaryOperation(OCL_SEQUENCE,
			INSERT_AT_NAME, Types.OCL_INTEGER, "index", //$NON-NLS-1$
			AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createTernaryOperation(OCL_SEQUENCE,
			SUB_SEQUENCE_NAME, Types.OCL_INTEGER, "lower", //$NON-NLS-1$
			Types.OCL_INTEGER, "upper"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(AnyTypeImpl.OCL_T,
			AT_NAME, Types.OCL_INTEGER, "index")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_INTEGER,
			INDEX_OF_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SEQUENCE,
			INCLUDING_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SEQUENCE,
			EXCLUDING_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createUnaryOperation(AnyTypeImpl.OCL_T,
			FIRST_NAME));
		result.add(TypeUtil.createUnaryOperation(AnyTypeImpl.OCL_T,
			LAST_NAME));
		result.add(TypeUtil.createUnaryOperation(new SequenceTypeImpl(AnyTypeImpl.OCL_T2),
			FLATTEN_NAME));
		result.add(TypeUtil.createUnaryOperation(OCL_BAG,
			AS_BAG_NAME));
		result.add(TypeUtil.createUnaryOperation(OCL_SET,
			AS_SET_NAME));
		result.add(TypeUtil.createUnaryOperation(OCL_SEQUENCE,
			AS_SEQUENCE_NAME));
		result.add(TypeUtil.createUnaryOperation(OCL_ORDERED_SET,
			AS_ORDERED_SET_NAME));
		
		return result;
	}
    
    protected static EList createIterators() {
    	EList result = new BasicEList();
    	
    	result.addAll(CollectionTypeImpl.createIterators());
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_SEQUENCE,
                SELECT_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_SEQUENCE,
                REJECT_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_SEQUENCE,
                SORTED_BY_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                TypesFactory.eINSTANCE.createSequenceType(AnyTypeImpl.OCL_T2),
                COLLECT_NESTED_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	return result;
    }

	public EList getOperations() {
		if (operations == null)
			operations = createOperations();
		return operations;
	}
	
	public EList getIterators() {
		if (iterators == null) {
			iterators = createIterators();
		}
		
		return iterators;
	}

} //SequenceTypeImpl
