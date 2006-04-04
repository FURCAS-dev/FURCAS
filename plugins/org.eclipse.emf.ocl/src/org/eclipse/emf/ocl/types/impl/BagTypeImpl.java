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
 * $Id: BagTypeImpl.java,v 1.1 2006/04/04 18:09:02 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsPackage;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;


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

	private static EList operations;
	private static EList iterators;
	
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CollectionKind getKind() {
		return CollectionKind.BAG_LITERAL;
	}
	
	/**
	 * Return result type of Bag operation based on the sourceType and args.
	 * Conformance rules are applied.  It is assumed that operation signature
	 * is already checked by the time this method is called.
	 * @param opcode
	 * @param args
	 * @return the result type
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args)
					throws SemanticException {
		
									
		EClassifier elemType = getElementType();
		
		switch (opcode) {
			
		case EQUAL:
		case NOT_EQUAL:
			return Types.OCL_BOOLEAN;
		case UNION:
			OCLExpression arg = (OCLExpression) args.get(0); 
			CollectionType argType = (CollectionType) arg.getType();
			EClassifier argElementType = argType.getElementType();
			return TypesFactory.eINSTANCE.createBagType(TypeUtil.commonSuperType(elemType, argElementType));	
		case INCLUDING:
			arg = (OCLExpression) args.get(0);
			EClassifier eArgType = arg.getType();			 
			return TypesFactory.eINSTANCE.createBagType(TypeUtil.commonSuperType(elemType, eArgType));
		case INTERSECTION:

			arg = (OCLExpression) args.get(0);  
			argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			if (argType instanceof SetType) {
				return TypesFactory.eINSTANCE.createSetType(TypeUtil.commonSuperType(elemType, argElementType));				
			} else {
				return TypesFactory.eINSTANCE.createBagType(TypeUtil.commonSuperType(elemType, argElementType));
			}
		case EXCLUDING:
			return this;
		case COUNT:
			return Types.OCL_INTEGER;
		case  FLATTEN:
			if (!(elemType instanceof CollectionType))
				return this;
			return TypesFactory.eINSTANCE.createBagType(((CollectionType) elemType).getElementType());
		case AS_BAG:
			return this;
		case AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);
		case AS_SET:
			return  TypesFactory.eINSTANCE.createSetType(elemType);
		case AS_ORDERED_SET:
			return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
        case SELECT:
        case REJECT:
        	return this;
        case SORTED_BY:
        	return TypesFactory.eINSTANCE.createSequenceType(getElementType());
        case COLLECT_NESTED:
        	return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.OCL_T2);
		}
		return super.getResultTypeFor(ownerType, opcode, args);	
	}
	
	
	/**
	 * Initialiaze Operations defined on BagType
	 */
	protected static EList createOperations() {
		EList result = new BasicEList();
		
		result.addAll(CollectionTypeImpl.createOperations());
		
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				EQUAL_NAME, OCL_BAG, "bag"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				NOT_EQUAL_NAME, OCL_BAG, "bag")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_BAG,
				UNION_NAME, OCL_BAG, "bag")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_BAG,
				UNION_NAME, OCL_SET, "set"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_BAG,
				INTERSECTION_NAME, OCL_BAG, "bag"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				INTERSECTION_NAME, OCL_SET, "set"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_BAG,
				INCLUDING_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_BAG,
				EXCLUDING_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createUnaryOperation(new BagTypeImpl(AnyTypeImpl.OCL_T2),
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
                CollectionTypeImpl.OCL_BAG,
                SELECT_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_BAG,
                REJECT_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_SEQUENCE,
                SORTED_BY_NAME, ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.OCL_T2),
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.BAG_TYPE;
	}

} //BagTypeImpl
