/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id: TypesFactoryImpl.java,v 1.4 2007/02/14 14:45:42 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.BagType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.ElementType;
import org.eclipse.emf.ocl.types.InvalidType;
import org.eclipse.emf.ocl.types.MessageType;
import org.eclipse.emf.ocl.types.OrderedSetType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.SequenceType;
import org.eclipse.emf.ocl.types.SetType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypeType;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesFactory init() {
		try {
			TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/OCL2/1.0.0/ocl/types"); //$NON-NLS-1$ 
			if (theTypesFactory != null) {
				return theTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesFactoryImpl();
	}

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
			case TypesPackage.ELEMENT_TYPE: return createElementType();
			case TypesPackage.INVALID_TYPE: return createInvalidType();
			case TypesPackage.MESSAGE_TYPE: return createMessageType();
			case TypesPackage.ORDERED_SET_TYPE: return createOrderedSetType();
			case TypesPackage.PRIMITIVE_BOOLEAN: return createPrimitiveBoolean();
			case TypesPackage.PRIMITIVE_INTEGER: return createPrimitiveInteger();
			case TypesPackage.PRIMITIVE_REAL: return createPrimitiveReal();
			case TypesPackage.PRIMITIVE_STRING: return createPrimitiveString();
			case TypesPackage.SEQUENCE_TYPE: return createSequenceType();
			case TypesPackage.SET_TYPE: return createSetType();
			case TypesPackage.TUPLE_TYPE: return createTupleType();
			case TypesPackage.TYPE_TYPE: return createTypeType();
			case TypesPackage.VOID_TYPE: return createVoidType();
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

	public CollectionType createCollectionType(CollectionKind kind, EClassifier elementType) {
		switch (kind.getValue()) {
		case CollectionKind.BAG:
			return createBagType(elementType);
		case CollectionKind.SET:
			return createSetType(elementType);
		case CollectionKind.SEQUENCE:
			return createSequenceType(elementType);
		case CollectionKind.ORDERED_SET:
			return createOrderedSetType(elementType);
		default:
			return createCollectionType(elementType);
		}
	}

	public TupleType createTupleType(List parts) {
		return new TupleTypeImpl(parts);
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

	public MessageType createMessageType(ENamedElement behavioralFeature) {
		return MessageTypeImpl.createMessageType(behavioralFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType createElementType() {
		ElementTypeImpl elementType = new ElementTypeImpl();
		return elementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidType createInvalidType() {
		InvalidTypeImpl invalidType = new InvalidTypeImpl();
		return invalidType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeType createTypeType() {
		TypeTypeImpl typeType = new TypeTypeImpl();
		return typeType;
	}

	public TypeType createTypeType(EClassifier type) {
		return TypeTypeImpl.createType(type);
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
