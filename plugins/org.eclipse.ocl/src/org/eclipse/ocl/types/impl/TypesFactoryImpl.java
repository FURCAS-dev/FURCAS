/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: TypesFactoryImpl.java,v 1.4 2007/10/11 23:04:56 cdamus Exp $
 */
package org.eclipse.ocl.types.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

//import org.eclipse.ocl.types.*;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.AnyType;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.ElementType;
import org.eclipse.ocl.types.InvalidType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.types.TypesFactory;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static TypesFactory init() {
        try {
            TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/1.1.0/OCL/Types"); //$NON-NLS-1$ 
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
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case TypesPackage.ANY_TYPE: return createAnyType();
            case TypesPackage.BAG_TYPE: return createBagType();
            case TypesPackage.COLLECTION_TYPE: return createCollectionType();
            case TypesPackage.ELEMENT_TYPE: return createElementType();
            case TypesPackage.INVALID_TYPE: return createInvalidType();
            case TypesPackage.MESSAGE_TYPE: return createMessageType();
            case TypesPackage.ORDERED_SET_TYPE: return createOrderedSetType();
            case TypesPackage.PRIMITIVE_TYPE: return createPrimitiveType();
            case TypesPackage.SEQUENCE_TYPE: return createSequenceType();
            case TypesPackage.SET_TYPE: return createSetType();
            case TypesPackage.TUPLE_TYPE: return createTupleType();
            case TypesPackage.TYPE_TYPE: return createTypeType();
            case TypesPackage.VOID_TYPE: return createVoidType();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <O> AnyType<O> createAnyType() {
        AnyTypeImpl<O> anyType = new AnyTypeImpl<O>();
        return anyType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> BagType<C, O> createBagType() {
        BagTypeImpl<C, O> bagType = new BagTypeImpl<C, O>();
        return bagType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> CollectionType<C, O> createCollectionType() {
        CollectionTypeImpl<C, O> collectionType = new CollectionTypeImpl<C, O>();
        return collectionType;
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
	public <O> InvalidType<O> createInvalidType() {
        InvalidTypeImpl<O> invalidType = new InvalidTypeImpl<O>();
        return invalidType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O, P> MessageType<C, O, P> createMessageType() {
        MessageTypeImpl<C, O, P> messageType = new MessageTypeImpl<C, O, P>();
        return messageType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> OrderedSetType<C, O> createOrderedSetType() {
        OrderedSetTypeImpl<C, O> orderedSetType = new OrderedSetTypeImpl<C, O>();
        return orderedSetType;
    }

	/**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public <O> PrimitiveType<O> createPrimitiveType() {
        PrimitiveTypeImpl<O> primitiveType = new PrimitiveTypeImpl<O>();
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> SequenceType<C, O> createSequenceType() {
        SequenceTypeImpl<C, O> sequenceType = new SequenceTypeImpl<C, O>();
        return sequenceType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> SetType<C, O> createSetType() {
        SetTypeImpl<C, O> setType = new SetTypeImpl<C, O>();
        return setType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <O, P> TupleType<O, P> createTupleType() {
        TupleTypeImpl<O, P> tupleType = new TupleTypeImpl<O, P>();
        return tupleType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <C, O> TypeType<C, O> createTypeType() {
        TypeTypeImpl<C, O> typeType = new TypeTypeImpl<C, O>();
        return typeType;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public <O> VoidType<O> createVoidType() {
        VoidTypeImpl<O> voidType = new VoidTypeImpl<O>();
        return voidType;
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
	@Deprecated
	public static TypesPackage getPackage() {
        return TypesPackage.eINSTANCE;
    }

	public <C, O> BagType<C, O> createBagType(C elementType) {
		return new BagTypeImpl<C, O>(elementType);
	}

	public <C, O> CollectionType<C, O> createCollectionType(C elementType) {
		return new CollectionTypeImpl<C, O>(elementType);
	}

	public <C, O> CollectionType<C, O> createCollectionType(
			CollectionKind kind, C elementType) {
		switch (kind) {
		case BAG_LITERAL:
			return createBagType(elementType);
		case SET_LITERAL:
			return createSetType(elementType);
		case SEQUENCE_LITERAL:
			return createSequenceType(elementType);
		case ORDERED_SET_LITERAL:
			return createOrderedSetType(elementType);
		default:
			return createCollectionType(elementType);
		}
	}

	public <C, O, P> MessageType<C, O, P> createOperationMessageType(O operation) {
		MessageType<C, O, P> result = createMessageType();
		result.setReferredOperation(operation);
		return result;
	}

	public <C, O> OrderedSetType<C, O> createOrderedSetType(C elementType) {
		return new OrderedSetTypeImpl<C, O>(elementType);
	}

	public <C, O> SequenceType<C, O> createSequenceType(C elementType) {
		return new SequenceTypeImpl<C, O>(elementType);
	}

	public <C, O> SetType<C, O> createSetType(C elementType) {
		return new SetTypeImpl<C, O>(elementType);
	}

	public <C, O, P> MessageType<C, O, P> createSignalMessageType(C signal) {
		MessageType<C, O, P> result = createMessageType();
		result.setReferredSignal(signal);
		return result;
	}

	public <C, O, P> TupleType<O, P> createTupleType(
			List<? extends TypedElement<C>> parts) {
		TupleType<O, P> result = createTupleType();
		
		if (!parts.isEmpty()) {
			Environment<?, C, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env =
				Environment.Registry.INSTANCE.getEnvironmentFor(parts.get(0));
            UMLReflection<?, C, O, P, ?, ?, ?, ?, ?, ?> uml = env.getUMLReflection();

			EList<P> properties = result.oclProperties();
			
			for (TypedElement<C> part : parts) {
				properties.add(uml.createProperty(part.getName(), part.getType()));
			}
		}
		
		return result;
	}

	public <C, O> TypeType<C, O> createTypeType(
			C type) {
		return new TypeTypeImpl<C, O>(type);
	}

} //TypesFactoryImpl
