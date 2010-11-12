/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: UMLFactoryImpl.java,v 1.9 2009/12/06 18:21:24 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.uml.AnyType;
import org.eclipse.ocl.uml.AssociationClassCallExp;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.BooleanLiteralExp;
import org.eclipse.ocl.uml.CollectionItem;
import org.eclipse.ocl.uml.CollectionLiteralExp;
import org.eclipse.ocl.uml.CollectionRange;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.ElementType;
import org.eclipse.ocl.uml.EnumLiteralExp;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.IfExp;
import org.eclipse.ocl.uml.IntegerLiteralExp;
import org.eclipse.ocl.uml.InvalidLiteralExp;
import org.eclipse.ocl.uml.InvalidType;
import org.eclipse.ocl.uml.IterateExp;
import org.eclipse.ocl.uml.IteratorExp;
import org.eclipse.ocl.uml.LetExp;
import org.eclipse.ocl.uml.MessageExp;
import org.eclipse.ocl.uml.MessageType;
import org.eclipse.ocl.uml.NullLiteralExp;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.OrderedSetType;
import org.eclipse.ocl.uml.PrimitiveType;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.RealLiteralExp;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.StateExp;
import org.eclipse.ocl.uml.StringLiteralExp;
import org.eclipse.ocl.uml.TemplateParameterType;
import org.eclipse.ocl.uml.TupleLiteralExp;
import org.eclipse.ocl.uml.TupleLiteralPart;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.TypeExp;
import org.eclipse.ocl.uml.TypeType;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.uml.UnspecifiedValueExp;
import org.eclipse.ocl.uml.Variable;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.ocl.uml.VoidType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLFactoryImpl
		extends EFactoryImpl
		implements UMLFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLFactory init() {
		try {
			UMLFactory theUMLFactory = (UMLFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://www.eclipse.org/ocl/1.1.0/UML"); //$NON-NLS-1$ 
			if (theUMLFactory != null) {
				return theUMLFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLFactoryImpl() {
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
			case UMLPackage.ANY_TYPE :
				return createAnyType();
			case UMLPackage.VOID_TYPE :
				return createVoidType();
			case UMLPackage.INVALID_TYPE :
				return createInvalidType();
			case UMLPackage.ELEMENT_TYPE :
				return createElementType();
			case UMLPackage.TYPE_TYPE :
				return createTypeType();
			case UMLPackage.MESSAGE_TYPE :
				return createMessageType();
			case UMLPackage.PRIMITIVE_TYPE :
				return createPrimitiveType();
			case UMLPackage.COLLECTION_TYPE :
				return createCollectionType();
			case UMLPackage.TUPLE_TYPE :
				return createTupleType();
			case UMLPackage.BAG_TYPE :
				return createBagType();
			case UMLPackage.SET_TYPE :
				return createSetType();
			case UMLPackage.ORDERED_SET_TYPE :
				return createOrderedSetType();
			case UMLPackage.SEQUENCE_TYPE :
				return createSequenceType();
			case UMLPackage.EXPRESSION_IN_OCL :
				return createExpressionInOCL();
			case UMLPackage.ASSOCIATION_CLASS_CALL_EXP :
				return createAssociationClassCallExp();
			case UMLPackage.BOOLEAN_LITERAL_EXP :
				return createBooleanLiteralExp();
			case UMLPackage.COLLECTION_ITEM :
				return createCollectionItem();
			case UMLPackage.COLLECTION_LITERAL_EXP :
				return createCollectionLiteralExp();
			case UMLPackage.COLLECTION_RANGE :
				return createCollectionRange();
			case UMLPackage.ENUM_LITERAL_EXP :
				return createEnumLiteralExp();
			case UMLPackage.IF_EXP :
				return createIfExp();
			case UMLPackage.INTEGER_LITERAL_EXP :
				return createIntegerLiteralExp();
			case UMLPackage.UNLIMITED_NATURAL_LITERAL_EXP :
				return createUnlimitedNaturalLiteralExp();
			case UMLPackage.INVALID_LITERAL_EXP :
				return createInvalidLiteralExp();
			case UMLPackage.ITERATE_EXP :
				return createIterateExp();
			case UMLPackage.ITERATOR_EXP :
				return createIteratorExp();
			case UMLPackage.LET_EXP :
				return createLetExp();
			case UMLPackage.MESSAGE_EXP :
				return createMessageExp();
			case UMLPackage.NULL_LITERAL_EXP :
				return createNullLiteralExp();
			case UMLPackage.OPERATION_CALL_EXP :
				return createOperationCallExp();
			case UMLPackage.PROPERTY_CALL_EXP :
				return createPropertyCallExp();
			case UMLPackage.REAL_LITERAL_EXP :
				return createRealLiteralExp();
			case UMLPackage.STATE_EXP :
				return createStateExp();
			case UMLPackage.STRING_LITERAL_EXP :
				return createStringLiteralExp();
			case UMLPackage.TUPLE_LITERAL_EXP :
				return createTupleLiteralExp();
			case UMLPackage.TUPLE_LITERAL_PART :
				return createTupleLiteralPart();
			case UMLPackage.TYPE_EXP :
				return createTypeExp();
			case UMLPackage.UNSPECIFIED_VALUE_EXP :
				return createUnspecifiedValueExp();
			case UMLPackage.VARIABLE :
				return createVariable();
			case UMLPackage.VARIABLE_EXP :
				return createVariableExp();
			case UMLPackage.TEMPLATE_PARAMETER_TYPE :
				return createTemplateParameterType();
			default :
				throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
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
	public VoidType createVoidType() {
		VoidTypeImpl voidType = new VoidTypeImpl();
		return voidType;
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
	public ElementType createElementType() {
		ElementTypeImpl elementType = new ElementTypeImpl();
		return elementType;
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
	public MessageType createMessageType() {
		MessageTypeImpl messageType = new MessageTypeImpl();
		return messageType;
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
	public CollectionType createCollectionType() {
		CollectionTypeImpl collectionType = new CollectionTypeImpl();
		return collectionType;
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
	public BagType createBagType() {
		BagTypeImpl bagType = new BagTypeImpl();
		return bagType;
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
	public OrderedSetType createOrderedSetType() {
		OrderedSetTypeImpl orderedSetType = new OrderedSetTypeImpl();
		return orderedSetType;
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
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameterType createTemplateParameterType() {
		TemplateParameterTypeImpl templateParameterType = new TemplateParameterTypeImpl();
		return templateParameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLPackage getUMLPackage() {
		return (UMLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMLPackage getPackage() {
		return UMLPackage.eINSTANCE;
	}

} //UMLFactoryImpl
