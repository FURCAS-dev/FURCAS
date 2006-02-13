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

import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ordered Set Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OrderedSetTypeImpl extends CollectionTypeImpl implements OrderedSetType {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations = new BasicEList();
	
	protected OrderedSetTypeImpl() {
		super();
		setInstanceClass(LinkedHashSet.class);
		this.setClassifierID(TypesPackage.ORDERED_SET_TYPE);
	}

	protected OrderedSetTypeImpl(EClassifier elementType) {
		super();
		this.elementType = elementType;
		setInstanceClass(LinkedHashSet.class);
		this.setClassifierID(TypesPackage.ORDERED_SET_TYPE);
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
			
		case CollectionTypeImpl.EQUALS:
		case CollectionTypeImpl.NOT_EQUAL:
			return PrimitiveTypeImpl.OCL_BOOLEAN;
			
		case CollectionTypeImpl.INDEX_OF:
			return PrimitiveTypeImpl.OCL_INTEGER;
		
		case CollectionTypeImpl.APPEND:
		case CollectionTypeImpl.PREPEND:
		case CollectionTypeImpl.INSERT_AT:
			OCLExpression arg = (OCLExpression) args.get(0);
			EClassifier eArgType = arg.getType();
			OrderedSetType resultType = TypesFactory.eINSTANCE.createOrderedSetType();
			resultType.setElementType(AnyTypeImpl.commonSuperType(elemType, eArgType));
			return resultType;
			
		case CollectionTypeImpl.SUB_ORDERED_SET:
			return this;
		
		case CollectionTypeImpl.AT:
		case CollectionTypeImpl.FIRST:
		case CollectionTypeImpl.LAST:
			return elemType;
			
		case CollectionTypeImpl.AS_SET:
			return TypesFactory.eINSTANCE.createSetType(elemType);
		case CollectionTypeImpl.AS_BAG:
			return TypesFactory.eINSTANCE.createBagType(elemType);
		case CollectionTypeImpl.AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);				
		}				
		return (super.getResultType(opcode, args));
	}
	
	protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i=0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}	
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclEquals", OCL_ORDERED_SET));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclNotEquals", OCL_ORDERED_SET)); 		//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_ORDERED_SET, "append", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(AnyTypeImpl.OCL_ECLASSIFIER, "at", PrimitiveTypeImpl.OCL_INTEGER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_INTEGER, "indexOf", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_ORDERED_SET, "insertAt", PrimitiveTypeImpl.OCL_INTEGER));	//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_ORDERED_SET, "prepend", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createTernaryOperation(OCL_ORDERED_SET, "subOrderedSet", PrimitiveTypeImpl.OCL_INTEGER, PrimitiveTypeImpl.OCL_INTEGER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(AnyTypeImpl.OCL_ECLASSIFIER, "first"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(AnyTypeImpl.OCL_ECLASSIFIER, "last"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "asBag"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SET, "asSet"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_SEQUENCE, "asSequence"));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_ORDERED_SET, "asOrderedSet"));//$NON-NLS-1$
		return operations;
	}
	
	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}		


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getOrderedSetType();
	}

} //OrderedSetTypeImpl
