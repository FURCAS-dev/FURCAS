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

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;

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

	private static EList operations = new BasicEList();

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
	 * @throws antlr.SemanticException
	 */
	public EClassifier getResultType(int opcode, EList args)
		throws antlr.SemanticException {

		EClassifier elemType = getElementType();

		switch (opcode) {

			case CollectionTypeImpl.COUNT:
			case CollectionTypeImpl.INDEX_OF:
				return PrimitiveTypeImpl.OCL_INTEGER;
			case CollectionTypeImpl.EQUALS:
			case CollectionTypeImpl.NOT_EQUAL:
				return PrimitiveTypeImpl.OCL_BOOLEAN;
			case CollectionTypeImpl.UNION:
				OCLExpression arg = (OCLExpression) args.get(0);
				CollectionType argType = (CollectionType) arg.getType();
				EClassifier argElementType = argType.getElementType();
				CollectionType resultType = TypesFactory.eINSTANCE
					.createSequenceType();
				resultType.setElementType(AnyTypeImpl.commonSuperType(
					elemType, argElementType));
				return resultType;
			case CollectionTypeImpl.INCLUDING:
			case CollectionTypeImpl.APPEND:
			case CollectionTypeImpl.PREPEND:
				arg = (OCLExpression) args.get(0);
				EClassifier eArgType = arg.getType();
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(AnyTypeImpl.commonSuperType(
					elemType, eArgType));
				return resultType;
			case CollectionTypeImpl.INSERT_AT:
				arg = (OCLExpression) args.get(1); // arg 0 is the index
				eArgType = arg.getType();
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(AnyTypeImpl.commonSuperType(
					elemType, eArgType));
				return resultType;
			case CollectionTypeImpl.EXCLUDING:
				return this;
			case CollectionTypeImpl.FLATTEN:
				if (!(elemType instanceof CollectionType))
					return this;
				resultType = TypesFactory.eINSTANCE.createSequenceType();
				resultType.setElementType(((CollectionType) elemType)
					.getElementType());
				return resultType;
			case CollectionTypeImpl.AT:
			case CollectionTypeImpl.FIRST:
			case CollectionTypeImpl.LAST:
				return elemType;
			case CollectionTypeImpl.AS_BAG:
				return TypesFactory.eINSTANCE.createBagType(elemType);
			case CollectionTypeImpl.AS_SEQUENCE:
			case CollectionTypeImpl.SUB_SEQUENCE:
				return this;
			case CollectionTypeImpl.AS_SET:
				return TypesFactory.eINSTANCE.createSetType(elemType);
			case CollectionTypeImpl.AS_ORDERED_SET:
				return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
		}

		return (super.getResultType(opcode, args));
	}

	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected EList initOperations() {

		EList parentOperations = super.initOperations();
		for (int i = 0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}
		operations.add(AnyTypeImpl.createBinaryOperation(
			PrimitiveTypeImpl.OCL_BOOLEAN, "oclEquals", OCL_SEQUENCE));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(
			PrimitiveTypeImpl.OCL_BOOLEAN, "oclNotEquals", OCL_SEQUENCE)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"union", OCL_SEQUENCE)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"append", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"prepend", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createTernaryOperation(OCL_SEQUENCE,
			"insertAt", PrimitiveTypeImpl.OCL_INTEGER, AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations
			.add(AnyTypeImpl
				.createTernaryOperation(
					OCL_SEQUENCE,
					"subSequence", PrimitiveTypeImpl.OCL_INTEGER, PrimitiveTypeImpl.OCL_INTEGER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(
			AnyTypeImpl.OCL_ECLASSIFIER, "at", PrimitiveTypeImpl.OCL_INTEGER)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(
			PrimitiveTypeImpl.OCL_INTEGER,
			"indexOf", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"including", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SEQUENCE,
			"excluding", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(
			AnyTypeImpl.OCL_ECLASSIFIER, "first"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(
			AnyTypeImpl.OCL_ECLASSIFIER, "last"));//$NON-NLS-1$
		operations.add(AnyTypeImpl
			.createUnaryOperation(OCL_SEQUENCE, "flatten"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "asBag"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SET, "asSet"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SEQUENCE,
			"asSequence"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_ORDERED_SET,
			"asOrderedSet"));//$NON-NLS-1$
		return operations;
	}

	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}

} //SequenceTypeImpl
