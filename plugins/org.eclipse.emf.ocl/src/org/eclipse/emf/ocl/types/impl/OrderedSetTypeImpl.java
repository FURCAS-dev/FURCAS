/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OrderedSetTypeImpl.java,v 1.6 2007/10/11 23:05:17 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;

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

	private static EList operations;
	private static EList iterators;
	
	private SetTypeImpl supertype;
	
	protected OrderedSetTypeImpl() {
		super();
		setInstanceClass(LinkedHashSet.class);
		this.setClassifierID(TypesPackage.ORDERED_SET_TYPE);
		
		supertype = new SetTypeImpl();
	}

	protected OrderedSetTypeImpl(EClassifier elementType) {
		super();
		this.elementType = elementType;
		setInstanceClass(LinkedHashSet.class);
		this.setClassifierID(TypesPackage.ORDERED_SET_TYPE);
		
		supertype = new SetTypeImpl(elementType);
	}
	
	@Override
    public String getName() {
		if (name == null) {
			if (elementType != null) {
				name = "OrderedSet(" + elementType.getName() + ')'; //$NON-NLS-1$
			} else {
				name = "OrderedSet(?)"; //$NON-NLS-1$
			}
		}
		
		return super.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
    public CollectionKind getKind() {
		return CollectionKind.ORDERED_SET_LITERAL;
	}
	
	/**
	 * Extends the superclass implementation to propagate the element type to
	 * my Set supertype.
	 * 
	 * @generated NOT
	 */
	@Override
    public void setElementType(EClassifier newElementType) {
		super.setElementType(newElementType);
		
		supertype.setElementType(newElementType);
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
	@Override
    public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args)
											 throws SemanticException {
		
		EClassifier elemType = getElementType();
		
		switch (opcode) {
			
		case EQUAL:
		case NOT_EQUAL:
			return Types.OCL_BOOLEAN;
			
		case INDEX_OF:
			return Types.OCL_INTEGER;
		
		case APPEND:
		case PREPEND:
			OCLExpression arg = (OCLExpression) args.get(0);
			EClassifier eArgType = arg.getType();
			OrderedSetType resultType = TypesFactory.eINSTANCE.createOrderedSetType();
			resultType.setElementType(TypeUtil.commonSuperType(elemType, eArgType));
			return resultType;
			
		case INSERT_AT:
			arg = (OCLExpression) args.get(1); // arg 0 is the index
			eArgType = arg.getType();
			resultType = TypesFactory.eINSTANCE.createOrderedSetType();
			resultType.setElementType(TypeUtil.commonSuperType(elemType, eArgType));
			return resultType;
			
		case SUB_ORDERED_SET:
			return this;
		
		case AT:
		case FIRST:
		case LAST:
			return elemType;
			
		case AS_SET:
			return TypesFactory.eINSTANCE.createSetType(elemType);
		case AS_BAG:
			return TypesFactory.eINSTANCE.createBagType(elemType);
		case AS_SEQUENCE:
			return TypesFactory.eINSTANCE.createSequenceType(elemType);				
		}
		
		return (supertype.getResultTypeFor(ownerType, opcode, args));
	}
	
	protected static EList createOperations() {
		EList result = new BasicEList();
		
		result.addAll(CollectionTypeImpl.createOperations());
		
		// OrderedSets are Sets
		result.addAll(SetTypeImpl.createSetOperations());
		
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				EQUAL_NAME, OCL_ORDERED_SET, "s"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_BOOLEAN,
				NOT_EQUAL_NAME, OCL_ORDERED_SET, "s"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_ORDERED_SET,
				APPEND_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(AnyTypeImpl.OCL_T,
				AT_NAME, Types.OCL_INTEGER, "index"));//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(Types.OCL_INTEGER,
				INDEX_OF_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createTernaryOperation(OCL_ORDERED_SET,
				INSERT_AT_NAME, Types.OCL_INTEGER, "index", //$NON-NLS-1$
				AnyTypeImpl.OCL_T, "object"));	//$NON-NLS-1$
		result.add(TypeUtil.createBinaryOperation(OCL_ORDERED_SET,
				PREPEND_NAME, AnyTypeImpl.OCL_T, "object"));//$NON-NLS-1$
		result.add(TypeUtil.createTernaryOperation(OCL_ORDERED_SET,
				SUB_ORDERED_SET_NAME, Types.OCL_INTEGER, "lower", //$NON-NLS-1$
				Types.OCL_INTEGER, "upper"));//$NON-NLS-1$
		result.add(TypeUtil.createUnaryOperation(AnyTypeImpl.OCL_T,
				FIRST_NAME));
		result.add(TypeUtil.createUnaryOperation(AnyTypeImpl.OCL_T,
				LAST_NAME));
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
	
	@Override
    public EList getOperations() {
		if (operations == null)
			operations = createOperations();
		return operations;
	}		

	@Override
    public EList getIterators() {
		if (iterators == null) {
			iterators = SetTypeImpl.createIterators();
		}
		
		return iterators;
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
	@Override
    protected EClass eStaticClass() {
        return TypesPackage.Literals.ORDERED_SET_TYPE;
    }

} //OrderedSetTypeImpl
