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

import java.util.Collection;

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
 * @generated
 */
public class BagTypeImpl extends CollectionTypeImpl implements BagType {
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	private static EList operations = new BasicEList();
	
	protected BagTypeImpl() {
		super();
		setInstanceClass(Collection.class);
		this.setClassifierID(TypesPackage.BAG_TYPE);
	}
	
	/**
	 * Create a BagTypeImpl with the specified element type.
	 * @param elementType
	 */
	protected BagTypeImpl(EClassifier elementType) {
		super(elementType);
		setInstanceClass(Collection.class);				
		this.setClassifierID(TypesPackage.BAG_TYPE);
	}
	
	public String getName() {
		if (name == null) {
			if (elementType != null) {
				name = "Bag(" + elementType.getName() + ')'; //$NON-NLS-1$
			} else {
				name = "Bag(?)"; //$NON-NLS-1$
			}
		}
		
		return super.getName();
	}
	
	/**
	 * Return result type of Bag operation based on the sourceType and args.
	 * Conformance rules are applied.  It is assumed that operation signature
	 * is already checked by the time this method is called.
	 * @param opcode
	 * @param args
	 * @return the result type
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
			return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.commonSuperType(elemType, argElementType));	
		case CollectionTypeImpl.INCLUDING:
			arg = (OCLExpression) args.get(0);
			EClassifier eArgType = arg.getType();			 
			return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.commonSuperType(elemType, eArgType));
		case CollectionTypeImpl.INTERSECTION:

			arg = (OCLExpression) args.get(0);  
			argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			if (argType instanceof SetType) {
				return TypesFactory.eINSTANCE.createSetType(AnyTypeImpl.commonSuperType(elemType, argElementType));				
			} else {
				return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.commonSuperType(elemType, argElementType));
			}
		case  CollectionTypeImpl.EXCLUDING:
			return this;
		case CollectionTypeImpl.COUNT:
			return PrimitiveTypeImpl.OCL_INTEGER;
		case  CollectionTypeImpl.FLATTEN:
			if (!(elemType instanceof CollectionType)) return this;
				return TypesFactory.eINSTANCE.createBagType(((CollectionType) elemType).getElementType());
		case CollectionTypeImpl.AS_BAG:
			return this;
		case CollectionTypeImpl.AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);
		case CollectionTypeImpl.AS_SET:
			return  TypesFactory.eINSTANCE.createSetType(elemType);
		case CollectionTypeImpl.AS_ORDERED_SET:
			return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
		}
		return super.getResultType(opcode, args);	
	}
	
	
	/**
	 * Initialiaze Operations defined on BagType
	 */
	protected EList initOperations() {
		
		EList parentOperations = super.initOperations();
		for (int i=0; i < parentOperations.size(); i++) {
			operations.add(parentOperations.get(i));
		}	
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclEquals", OCL_BAG));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN, "oclNotEquals", OCL_BAG)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "union", OCL_BAG)); //$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "union", OCL_SET));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "intersection", OCL_BAG));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_SET, "intersection", OCL_SET));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "including", AnyTypeImpl.OCL_ECLASSIFIER));	//$NON-NLS-1$
		operations.add(AnyTypeImpl.createBinaryOperation(OCL_BAG, "excluding", AnyTypeImpl.OCL_ECLASSIFIER));//$NON-NLS-1$
		operations.add(AnyTypeImpl.createUnaryOperation(OCL_BAG, "flatten"));//$NON-NLS-1$
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
	protected EClass eStaticClass() {
		return TypesPackage.Literals.BAG_TYPE;
	}

} //BagTypeImpl
