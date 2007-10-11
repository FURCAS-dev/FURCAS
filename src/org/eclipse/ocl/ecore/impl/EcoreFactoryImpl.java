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
 * $Id: EcoreFactoryImpl.java,v 1.6 2007/10/11 23:04:40 cdamus Exp $
 */
package org.eclipse.ocl.ecore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

//import org.eclipse.ocl.ecore.*;
import org.eclipse.ocl.ecore.AnyType;
import org.eclipse.ocl.ecore.AssociationClassCallExp;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionRange;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.ElementType;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.ExpressionInOCL;
import org.eclipse.ocl.ecore.IfExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.InvalidType;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.MessageExp;
import org.eclipse.ocl.ecore.MessageType;
import org.eclipse.ocl.ecore.NullLiteralExp;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.RealLiteralExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.StateExp;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.TypeType;
import org.eclipse.ocl.ecore.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.ecore.UnspecifiedValueExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.ecore.VoidType;

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
            case EcorePackage.ASSOCIATION_CLASS_CALL_EXP: return createAssociationClassCallExp();
            case EcorePackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
            case EcorePackage.COLLECTION_ITEM: return createCollectionItem();
            case EcorePackage.COLLECTION_LITERAL_EXP: return createCollectionLiteralExp();
            case EcorePackage.COLLECTION_RANGE: return createCollectionRange();
            case EcorePackage.ENUM_LITERAL_EXP: return createEnumLiteralExp();
            case EcorePackage.IF_EXP: return createIfExp();
            case EcorePackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
            case EcorePackage.UNLIMITED_NATURAL_LITERAL_EXP: return createUnlimitedNaturalLiteralExp();
            case EcorePackage.INVALID_LITERAL_EXP: return createInvalidLiteralExp();
            case EcorePackage.ITERATE_EXP: return createIterateExp();
            case EcorePackage.ITERATOR_EXP: return createIteratorExp();
            case EcorePackage.LET_EXP: return createLetExp();
            case EcorePackage.MESSAGE_EXP: return createMessageExp();
            case EcorePackage.NULL_LITERAL_EXP: return createNullLiteralExp();
            case EcorePackage.OPERATION_CALL_EXP: return createOperationCallExp();
            case EcorePackage.PROPERTY_CALL_EXP: return createPropertyCallExp();
            case EcorePackage.REAL_LITERAL_EXP: return createRealLiteralExp();
            case EcorePackage.STATE_EXP: return createStateExp();
            case EcorePackage.STRING_LITERAL_EXP: return createStringLiteralExp();
            case EcorePackage.TUPLE_LITERAL_EXP: return createTupleLiteralExp();
            case EcorePackage.TUPLE_LITERAL_PART: return createTupleLiteralPart();
            case EcorePackage.TYPE_EXP: return createTypeExp();
            case EcorePackage.UNSPECIFIED_VALUE_EXP: return createUnspecifiedValueExp();
            case EcorePackage.VARIABLE: return createVariable();
            case EcorePackage.VARIABLE_EXP: return createVariableExp();
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
	public AssociationClassCallExp createAssociationClassCallExp() {
        AssociationClassCallExpImpl associationClassCallExp = new AssociationClassCallExpImpl();
        return associationClassCallExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BooleanLiteralExp createBooleanLiteralExp() {
        BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
        return booleanLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionItem createCollectionItem() {
        CollectionItemImpl collectionItem = new CollectionItemImpl();
        return collectionItem;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionLiteralExp createCollectionLiteralExp() {
        CollectionLiteralExpImpl collectionLiteralExp = new CollectionLiteralExpImpl();
        return collectionLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CollectionRange createCollectionRange() {
        CollectionRangeImpl collectionRange = new CollectionRangeImpl();
        return collectionRange;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EnumLiteralExp createEnumLiteralExp() {
        EnumLiteralExpImpl enumLiteralExp = new EnumLiteralExpImpl();
        return enumLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IfExp createIfExp() {
        IfExpImpl ifExp = new IfExpImpl();
        return ifExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IntegerLiteralExp createIntegerLiteralExp() {
        IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
        return integerLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp() {
        UnlimitedNaturalLiteralExpImpl unlimitedNaturalLiteralExp = new UnlimitedNaturalLiteralExpImpl();
        return unlimitedNaturalLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InvalidLiteralExp createInvalidLiteralExp() {
        InvalidLiteralExpImpl invalidLiteralExp = new InvalidLiteralExpImpl();
        return invalidLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IterateExp createIterateExp() {
        IterateExpImpl iterateExp = new IterateExpImpl();
        return iterateExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IteratorExp createIteratorExp() {
        IteratorExpImpl iteratorExp = new IteratorExpImpl();
        return iteratorExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LetExp createLetExp() {
        LetExpImpl letExp = new LetExpImpl();
        return letExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MessageExp createMessageExp() {
        MessageExpImpl messageExp = new MessageExpImpl();
        return messageExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NullLiteralExp createNullLiteralExp() {
        NullLiteralExpImpl nullLiteralExp = new NullLiteralExpImpl();
        return nullLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OperationCallExp createOperationCallExp() {
        OperationCallExpImpl operationCallExp = new OperationCallExpImpl();
        return operationCallExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PropertyCallExp createPropertyCallExp() {
        PropertyCallExpImpl propertyCallExp = new PropertyCallExpImpl();
        return propertyCallExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RealLiteralExp createRealLiteralExp() {
        RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
        return realLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StateExp createStateExp() {
        StateExpImpl stateExp = new StateExpImpl();
        return stateExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StringLiteralExp createStringLiteralExp() {
        StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
        return stringLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TupleLiteralExp createTupleLiteralExp() {
        TupleLiteralExpImpl tupleLiteralExp = new TupleLiteralExpImpl();
        return tupleLiteralExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TupleLiteralPart createTupleLiteralPart() {
        TupleLiteralPartImpl tupleLiteralPart = new TupleLiteralPartImpl();
        return tupleLiteralPart;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TypeExp createTypeExp() {
        TypeExpImpl typeExp = new TypeExpImpl();
        return typeExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public UnspecifiedValueExp createUnspecifiedValueExp() {
        UnspecifiedValueExpImpl unspecifiedValueExp = new UnspecifiedValueExpImpl();
        return unspecifiedValueExp;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Variable createVariable() {
        VariableImpl variable = new VariableImpl();
        return variable;
    }

				/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public VariableExp createVariableExp() {
        VariableExpImpl variableExp = new VariableExpImpl();
        return variableExp;
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

} //EcoreFactoryImpl
