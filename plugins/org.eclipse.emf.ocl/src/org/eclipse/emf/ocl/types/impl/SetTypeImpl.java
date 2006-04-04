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
 * $Id: SetTypeImpl.java,v 1.2 2006/04/04 19:07:00 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.List;
import java.util.Set;

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

	private static EList operations;
	private static EList iterators;
	
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
	
	public String getName() {
		if (name == null) {
			if (elementType != null) {
				name = "Set(" + elementType.getName() + ')'; //$NON-NLS-1$
			} else {
				name = "Set(?)"; //$NON-NLS-1$
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
		return CollectionKind.SET_LITERAL;
	}
	
	/**
	 * Returns the result type of Set operation based on the sourceType and args.
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
			
		case EQUAL:
		case NOT_EQUAL:
			return Types.OCL_BOOLEAN;
			
		case UNION:  
			OCLExpression arg = (OCLExpression) args.get(0);
			CollectionType argType = (CollectionType) arg.getType();
			EClassifier argElementType = argType.getElementType();
			CollectionType resultType;
			if (argType instanceof BagType) {
				resultType = TypesFactory.eINSTANCE.createBagType();
			} else {
				resultType = TypesFactory.eINSTANCE.createSetType();
			}
			resultType.setElementType(TypeUtil.commonSuperType(elemType, argElementType));
			return resultType;
			
		case MINUS:
		case SYMMETRIC_DIFFERENCE:
			arg = (OCLExpression) args.get(0);
			argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			resultType = TypesFactory.eINSTANCE.createSetType();				
			resultType.setElementType(TypeUtil.commonSuperType(elemType, argElementType));
			return resultType;
			
		case INCLUDING:
			arg = (OCLExpression) args.get(0);
			EClassifier eArgType = arg.getType();
			resultType = TypesFactory.eINSTANCE.createSetType();
			resultType.setElementType(TypeUtil.commonSuperType(elemType, eArgType));
			return resultType;	
			
		case INTERSECTION:
			arg = (OCLExpression) args.get(0);
		    argType = (CollectionType) arg.getType();
			argElementType = argType.getElementType();
			resultType = TypesFactory.eINSTANCE.createSetType();				
			resultType.setElementType(TypeUtil.commonSuperType(elemType, argElementType));
			return this;
			
		case EXCLUDING:
			return this;
		case COUNT:
			return Types.OCL_INTEGER;
		case FLATTEN:
			if (!(elemType instanceof CollectionType)) return this;
			resultType = TypesFactory.eINSTANCE.createSetType();
			resultType.setElementType(((CollectionType) elemType).getElementType());
			return resultType;
		case AS_BAG:
			return TypesFactory.eINSTANCE.createBagType(elemType);
		case AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);
		case AS_SET:
			return  this;
		case AS_ORDERED_SET:
			return TypesFactory.eINSTANCE.createOrderedSetType(elemType);
        case SELECT:
        case REJECT:
        	return this;
        case SORTED_BY:
        	return TypesFactory.eINSTANCE.createOrderedSetType(getElementType());
        case COLLECT_NESTED:
        	return TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.OCL_T2);
		}
				
		return (super.getResultTypeFor(ownerType, opcode, args));
	}
	
	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected static EList createOperations() {
		EList result = new BasicEList();
		
		result.addAll(CollectionTypeImpl.createOperations());
		result.addAll(createSetOperations());
		
		return result;
	}
	
	/**
	 * Creates the operations applicable to sets.
	 * 
	 * @return a list of new set operations
	 */
	static List createSetOperations() {
		List result = new java.util.ArrayList();
		
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				EQUAL_NAME, OCL_SET, "set"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				NOT_EQUAL_NAME, OCL_SET, "set")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_BAG,
				UNION_NAME, OCL_BAG, "bag")); //$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				UNION_NAME, OCL_SET, "set"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				MINUS_NAME, OCL_SET, "set"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				INTERSECTION_NAME, OCL_BAG, "bag"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				INTERSECTION_NAME, OCL_SET, "set"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				INCLUDING_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				EXCLUDING_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_SET,
				SYMMETRIC_DIFFERENCE_NAME, OCL_SET, "s"));//$NON-NLS-1$
		result.add(TypeUtil.createUnaryOperation(new SetTypeImpl(AnyTypeImpl.OCL_T2),
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
                CollectionTypeImpl.OCL_SET,
                SELECT_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_SET,
                REJECT_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
                CollectionTypeImpl.OCL_ORDERED_SET,
                SORTED_BY_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
    	result.add(TypeUtil.createBinaryOperation(
    			TypesFactory.eINSTANCE.createBagType(AnyTypeImpl.OCL_T2),
                COLLECT_NESTED_NAME,
                ExpressionsPackage.Literals.OCL_EXPRESSION, "expr")); //$NON-NLS-1$
    	
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
		return TypesPackage.Literals.SET_TYPE;
	}

} //SetTypeImpl
