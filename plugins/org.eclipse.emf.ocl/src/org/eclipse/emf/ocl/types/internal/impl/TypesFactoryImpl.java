/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.types.internal.impl;

import org.eclipse.emf.ocl.types.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.ModelElementType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.VoidType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl
	extends EFactoryImpl
	implements TypesFactory {

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TypesPackage.ANY_TYPE: return createAnyType();
			case TypesPackage.BAG_TYPE: return createBagType();
			case TypesPackage.COLLECTION_TYPE: return createCollectionType();
			case TypesPackage.ORDERED_SET_TYPE: return createOrderedSetType();
			case TypesPackage.PRIMITIVE_BOOLEAN: return createPrimitiveBoolean();
			case TypesPackage.PRIMITIVE_INTEGER: return createPrimitiveInteger();
			case TypesPackage.PRIMITIVE_REAL: return createPrimitiveReal();
			case TypesPackage.PRIMITIVE_STRING: return createPrimitiveString();
			case TypesPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case TypesPackage.SEQUENCE_TYPE: return createSequenceType();
			case TypesPackage.SET_TYPE: return createSetType();
			case TypesPackage.TUPLE_TYPE: return createTupleType();
			case TypesPackage.VOID_TYPE: return createVoidType();
			case TypesPackage.MESSAGE_TYPE: return createMessageType();
			case TypesPackage.MODEL_ELEMENT_TYPE: return createModelElementType();
			case TypesPackage.OCL_STATE: return createOclState();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	public BagType createBagType() {
		return new BagTypeImpl();
	}

	public CollectionType createCollectionType() {
		return new CollectionTypeImpl();
	}

	public BagType createBagType(EClassifier elementType) {
		return new BagTypeImpl(elementType);
	}

	public CollectionType createCollectionType(EClassifier elementType) {
		return new CollectionTypeImpl(elementType);
	}

	public TupleType createTupleType(EList vdcls) {
		TupleType result = new TupleTypeImpl(vdcls);
		// Test whether this tuple type already exists.
		// Return the existing tuple type, or the new tuple type if doesn't exist.
		// Add to the tuple EMF package if type is new.
		result = TupleTypeImpl.addToTuplePackage(result);
		return result;
	}

	public OrderedSetType createOrderedSetType() {
		return new OrderedSetTypeImpl();
	}

	public OrderedSetType createOrderedSetType(EClassifier elementType) {
		return new OrderedSetTypeImpl(elementType);
	}

	public SequenceType createSequenceType() {
		return new SequenceTypeImpl();
	}

	public SequenceType createSequenceType(EClassifier elementType) {
		return new SequenceTypeImpl(elementType);
	}

	public SetType createSetType() {
		return new SetTypeImpl();
	}

	public SetType createSetType(EClassifier elementType) {
		return new SetTypeImpl(elementType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleType createTupleType() {
		TupleTypeImpl tupleType = new TupleTypeImpl();
		return tupleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VoidType createVoidType() {
		VoidTypeImpl voidType = new VoidTypeImpl();
		return voidType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageType createMessageType() {
		MessageTypeImpl messageType = new MessageTypeImpl();
		return messageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementType createModelElementType() {
		ModelElementTypeImpl modelElementType = new ModelElementTypeImpl();
		return modelElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclState createOclState() {
		OclStateImpl oclState = new OclStateImpl();
		return oclState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveBoolean createPrimitiveBoolean() {
		PrimitiveBooleanImpl primitiveBoolean = new PrimitiveBooleanImpl();
		return primitiveBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveInteger createPrimitiveInteger() {
		PrimitiveIntegerImpl primitiveInteger = new PrimitiveIntegerImpl();
		return primitiveInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveReal createPrimitiveReal() {
		PrimitiveRealImpl primitiveReal = new PrimitiveRealImpl();
		return primitiveReal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveString createPrimitiveString() {
		PrimitiveStringImpl primitiveString = new PrimitiveStringImpl();
		return primitiveString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyType createAnyType() {
		AnyTypeImpl anyType = new AnyTypeImpl();
		return anyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesPackage getTypesPackage() {
		return (TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static TypesPackage getPackage() {
		return TypesPackage.eINSTANCE;
	}

} //TypesFactoryImpl
