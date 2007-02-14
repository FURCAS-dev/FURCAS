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
 * $Id: EcoreFactoryImpl.java,v 1.2 2007/02/14 13:42:01 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.ElementType;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.InvalidType;
import org.eclipse.ocl.ecore.MessageType;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.VoidType;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EcoreFactoryImpl extends EFactoryImpl implements EcoreFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static EcoreFactory init() {
        try {
            EcoreFactory theEcoreFactory = (EcoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/1.1.0/Ecore"); //$NON-NLS-1$ 
            if (theEcoreFactory != null) {
                return theEcoreFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new EcoreFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EcoreFactoryImpl() {
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
            case EcorePackage.ANY_TYPE: return createAnyType();
            case EcorePackage.BAG_TYPE: return createBagType();
            case EcorePackage.COLLECTION_TYPE: return createCollectionType();
            case EcorePackage.ELEMENT_TYPE: return createElementType();
            case EcorePackage.INVALID_TYPE: return createInvalidType();
            case EcorePackage.MESSAGE_TYPE: return createMessageType();
            case EcorePackage.ORDERED_SET_TYPE: return createOrderedSetType();
            case EcorePackage.PRIMITIVE_TYPE: return createPrimitiveType();
            case EcorePackage.SEQUENCE_TYPE: return createSequenceType();
            case EcorePackage.SET_TYPE: return createSetType();
            case EcorePackage.TUPLE_TYPE: return createTupleType();
            case EcorePackage.TYPE_TYPE: return createTypeType();
            case EcorePackage.VOID_TYPE: return createVoidType();
            case EcorePackage.CALL_OPERATION_ACTION: return createCallOperationAction();
            case EcorePackage.CONSTRAINT: return createConstraint();
            case EcorePackage.SEND_SIGNAL_ACTION: return createSendSignalAction();
            case EcorePackage.EXPRESSION_IN_OCL: return createExpressionInOCL();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
        }
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
    public BagType createBagType() {
        BagTypeImpl bagType = new BagTypeImpl();
        return bagType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CollectionType createCollectionType() {
        CollectionTypeImpl collectionType = new CollectionTypeImpl();
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
    public InvalidType createInvalidType() {
        InvalidTypeImpl invalidType = new InvalidTypeImpl();
        return invalidType;
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
    public OrderedSetType createOrderedSetType() {
        OrderedSetTypeImpl orderedSetType = new OrderedSetTypeImpl();
        return orderedSetType;
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
    public SequenceType createSequenceType() {
        SequenceTypeImpl sequenceType = new SequenceTypeImpl();
        return sequenceType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetType createSetType() {
        SetTypeImpl setType = new SetTypeImpl();
        return setType;
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
    public TypeType createTypeType() {
        TypeTypeImpl typeType = new TypeTypeImpl();
        return typeType;
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
    public CallOperationAction createCallOperationAction() {
        CallOperationActionImpl callOperationAction = new CallOperationActionImpl();
        return callOperationAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Constraint createConstraint() {
        ConstraintImpl constraint = new ConstraintImpl();
        return constraint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SendSignalAction createSendSignalAction() {
        SendSignalActionImpl sendSignalAction = new SendSignalActionImpl();
        return sendSignalAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExpressionInOCL createExpressionInOCL() {
        ExpressionInOCLImpl expressionInOCL = new ExpressionInOCLImpl();
        return expressionInOCL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EcorePackage getEcorePackage() {
        return (EcorePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static EcorePackage getPackage() {
        return EcorePackage.eINSTANCE;
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.BagType<C, O> createBagType(C elementType) {
        return (org.eclipse.ocl.types.BagType<C, O>)
            new BagTypeImpl((EClassifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.OrderedSetType<C, O> createOrderedSetType(C elementType) {
        return (org.eclipse.ocl.types.OrderedSetType<C, O>)
        new OrderedSetTypeImpl((EClassifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.SequenceType<C, O> createSequenceType(C elementType) {
        return (org.eclipse.ocl.types.SequenceType<C, O>)
        new SequenceTypeImpl((EClassifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.SetType<C, O> createSetType(C elementType) {
        return (org.eclipse.ocl.types.SetType<C, O>)
        new SetTypeImpl((EClassifier) elementType);
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.CollectionType<C, O> createCollectionType(C elementType) {
        return (org.eclipse.ocl.types.CollectionType<C, O>)
        new CollectionTypeImpl((EClassifier) elementType);
    }

    public <C, O> org.eclipse.ocl.types.CollectionType<C, O> createCollectionType(
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

    @SuppressWarnings("unchecked")
    public <C, O, P> org.eclipse.ocl.types.MessageType<C, O, P> createOperationMessageType(O operation) {
        MessageType result = createMessageType();
        result.setReferredOperation((EOperation) operation);
        result.oclProperties(); // ensure that the structural features are created
        return (org.eclipse.ocl.types.MessageType<C, O, P>) result;
    }

    @SuppressWarnings("unchecked")
    public <C, O, P> org.eclipse.ocl.types.MessageType<C, O, P> createSignalMessageType(C signal) {
        MessageType result = createMessageType();
        result.setReferredSignal((EClassifier) signal);
        result.oclProperties(); // ensure that the structural features are created
        return (org.eclipse.ocl.types.MessageType<C, O, P>) result;
    }

    @SuppressWarnings("unchecked")
    public <C, O, P> org.eclipse.ocl.types.TupleType<O, P> createTupleType(
            List<? extends TypedElement<C>> parts) {
        TupleType result = createTupleType();
        
        if (!parts.isEmpty()) {
            Environment<?, C, O, P, ?, ?, ?, ?, ?, ?, ?, ?> env =
                Environment.Registry.INSTANCE.getEnvironmentFor(parts.get(0));
            UMLReflection<?, C, O, P, ?, ?, ?, ?, ?, ?>
            uml = env.getUMLReflection();
            
            EList<EStructuralFeature> properties = result.oclProperties();
            
            for (TypedElement<C> part : parts) {
                properties.add((EStructuralFeature) uml.createProperty(
                        part.getName(), part.getType()));
            }
        }
        
        return (org.eclipse.ocl.types.TupleType<O, P>) result;
    }

    @SuppressWarnings("unchecked")
    public <C, O> org.eclipse.ocl.types.TypeType<C, O> createTypeType(
            C type) {
        return (org.eclipse.ocl.types.TypeType<C, O>)
            new TypeTypeImpl((EClassifier) type);
    }

} //EcoreFactoryImpl
