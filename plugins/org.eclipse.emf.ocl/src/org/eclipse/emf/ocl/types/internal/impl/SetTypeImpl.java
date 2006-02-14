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
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SetTypeImpl extends CollectionTypeImpl implements SetType {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations = new BasicEList();
	
	protected SetTypeImpl(){
		super();
		setInstanceClass(Set.class);
		this.setClassifierID(TypesPackage.SET_TYPE);
	}
	
	protected SetTypeImpl(EClassifier elementType){
		super();
		this.elementType = elementType;
		setInstanceClass(Set.class);		
		this.setClassifierID(TypesPackage.SET_TYPE);
	}
	
	/**
	 * Returns the result type of Set operation based on the sourceType and args.
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
			
		case CollectionTypeImpl.UNION:  
			OCLExpression arg = (OCLExpression) args.get(0);
			CollectionType argType = (CollectionType) arg.getType();
			EClassifier argElementType = argType.getElementType();
			CollectionType resultType = TypesFactory.eINSTANCE.createSetType();
			if (argType instanceof BagType) {
				resultType = TypesFactory.eINSTANCE.createBagType();
			}
			resultType.setElementType(AnyTypeImpl.commonSuperType(elemType, argElementType));
			return resultType;
			
		case CollectionTypeImpl.SYMMETRIC_DIFFERENCE:
			arg = (OCLExpression) args.get(0);
			argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			resultType = TypesFactory.eINSTANCE.createSetType();				
			resultType.setElementType(AnyTypeImpl.commonSuperType(elemType, argElementType));
			return resultType;
			
		case CollectionTypeImpl.INCLUDING:
			arg = (OCLExpression) args.get(0);
			EClassifier eArgType = arg.getType();
			resultType = TypesFactory.eINSTANCE.createSetType();
			resultType.setElementType(AnyTypeImpl.commonSuperType(elemType, eArgType));
			return resultType;	
			
		case CollectionTypeImpl.INTERSECTION:
			arg = (OCLExpression) args.get(0);
		    argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			AnyTypeImpl.commonSuperType(elemType, argElementType);
			return this;
			
		case CollectionTypeImpl.EXCLUDING:
			return this;
		case CollectionTypeImpl.COUNT:
			return PrimitiveTypeImpl.OCL_INTEGER;
		case CollectionTypeImpl.FLATTEN:
			if (!(elemType instanceof CollectionType)) return this;
			resultType = TypesFactory.eINSTANCE.createSetType();
			resultType.setElementType(((CollectionType) elemType).getElementType());
			return resultType;
		case CollectionTypeImpl.AS_BAG:
			return TypesFactory.eINSTANCE.createBagType(elemType);
		case CollectionTypeImpl.AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);
		case CollectionTypeImpl.AS_SET:
			return  this;
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
		for (int i=0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}	
		operations.addAll(createSetOperations());
		return operations;
	}
	
	/**
	 * Creates the operations applicable to sets.
	 * 
	 * @return a list of new set operations
	 */
	static List createSetOperations() {
		List result = new java.util.ArrayList();
		
		result.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclEquals", OCL_SET));//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclNotEquals", OCL_SET)); //$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "union", OCL_BAG)); //$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "union", OCL_SET));//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "minus", OCL_SET));//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "intersection", OCL_BAG));//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "intersection", OCL_SET));//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "including", AnyTypeImpl.OCL_ECLASSIFIER));	//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "excluding", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		result.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "symmetricDifference", OCL_SET));//$NON-NLS-1$
		result.add(AnyTypeImpl.createUnaryOperation(OCL_SET, "flatten"));//$NON-NLS-1$
		result.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "asBag"));//$NON-NLS-1$
		result.add(AnyTypeImpl.createUnaryOperation(OCL_SET, "asSet"));//$NON-NLS-1$
		result.add(AnyTypeImpl.createUnaryOperation(OCL_SEQUENCE, "asSequence"));//$NON-NLS-1$
		result.add(AnyTypeImpl.createUnaryOperation(OCL_ORDERED_SET, "asOrderedSet"));//$NON-NLS-1$
		
		return result;
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
	protected EClass eStaticClass() {
		return TypesPackage.Literals.SET_TYPE;
	}

} //SetTypeImpl
