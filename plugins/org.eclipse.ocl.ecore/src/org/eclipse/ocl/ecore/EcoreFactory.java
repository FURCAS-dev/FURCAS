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
 * $Id: EcoreFactory.java,v 1.5 2007/10/11 23:04:41 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.ecore.EcorePackage
 * @generated
 */
public interface EcoreFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EcoreFactory eINSTANCE = org.eclipse.ocl.ecore.impl.EcoreFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Any Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Any Type</em>'.
     * @generated
     */
    AnyType createAnyType();

    /**
     * Returns a new object of class '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bag Type</em>'.
     * @generated
     */
    BagType createBagType();

    /**
     * Returns a new object of class '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Type</em>'.
     * @generated
     */
    CollectionType createCollectionType();

    /**
     * Returns a new object of class '<em>Element Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Element Type</em>'.
     * @generated
     */
    ElementType createElementType();

    /**
     * Returns a new object of class '<em>Invalid Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Invalid Type</em>'.
     * @generated
     */
    InvalidType createInvalidType();

    /**
     * Returns a new object of class '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Type</em>'.
     * @generated
     */
    MessageType createMessageType();

    /**
     * Returns a new object of class '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ordered Set Type</em>'.
     * @generated
     */
    OrderedSetType createOrderedSetType();

    /**
     * Returns a new object of class '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Type</em>'.
     * @generated
     */
    PrimitiveType createPrimitiveType();

    /**
     * Returns a new object of class '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sequence Type</em>'.
     * @generated
     */
    SequenceType createSequenceType();

    /**
     * Returns a new object of class '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Set Type</em>'.
     * @generated
     */
    SetType createSetType();

    /**
     * Returns a new object of class '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Type</em>'.
     * @generated
     */
    TupleType createTupleType();

    /**
     * Returns a new object of class '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Type</em>'.
     * @generated
     */
    TypeType createTypeType();

    /**
     * Returns a new object of class '<em>Void Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Void Type</em>'.
     * @generated
     */
    VoidType createVoidType();

    /**
     * Returns a new object of class '<em>Call Operation Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Call Operation Action</em>'.
     * @generated
     */
    CallOperationAction createCallOperationAction();

    /**
     * Returns a new object of class '<em>Constraint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Constraint</em>'.
     * @generated
     */
    Constraint createConstraint();

    /**
     * Returns a new object of class '<em>Send Signal Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Send Signal Action</em>'.
     * @generated
     */
    SendSignalAction createSendSignalAction();

    /**
     * Returns a new object of class '<em>Expression In OCL</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Expression In OCL</em>'.
     * @generated
     */
    ExpressionInOCL createExpressionInOCL();

    /**
     * Returns a new object of class '<em>Association Class Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Association Class Call Exp</em>'.
     * @generated
     */
	AssociationClassCallExp createAssociationClassCallExp();

	/**
     * Returns a new object of class '<em>Boolean Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Boolean Literal Exp</em>'.
     * @generated
     */
	BooleanLiteralExp createBooleanLiteralExp();

	/**
     * Returns a new object of class '<em>Collection Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Item</em>'.
     * @generated
     */
	CollectionItem createCollectionItem();

	/**
     * Returns a new object of class '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Literal Exp</em>'.
     * @generated
     */
	CollectionLiteralExp createCollectionLiteralExp();

	/**
     * Returns a new object of class '<em>Collection Range</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Range</em>'.
     * @generated
     */
	CollectionRange createCollectionRange();

	/**
     * Returns a new object of class '<em>Enum Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Literal Exp</em>'.
     * @generated
     */
	EnumLiteralExp createEnumLiteralExp();

	/**
     * Returns a new object of class '<em>If Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>If Exp</em>'.
     * @generated
     */
	IfExp createIfExp();

	/**
     * Returns a new object of class '<em>Integer Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Integer Literal Exp</em>'.
     * @generated
     */
	IntegerLiteralExp createIntegerLiteralExp();

    /**
     * Returns a new object of class '<em>Unlimited Natural Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Unlimited Natural Literal Exp</em>'.
     * @generated
     */
	UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp();

	/**
     * Returns a new object of class '<em>Invalid Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Invalid Literal Exp</em>'.
     * @generated
     */
	InvalidLiteralExp createInvalidLiteralExp();

	/**
     * Returns a new object of class '<em>Iterate Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterate Exp</em>'.
     * @generated
     */
	IterateExp createIterateExp();

	/**
     * Returns a new object of class '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterator Exp</em>'.
     * @generated
     */
	IteratorExp createIteratorExp();

	/**
     * Returns a new object of class '<em>Let Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Let Exp</em>'.
     * @generated
     */
	LetExp createLetExp();

	/**
     * Returns a new object of class '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Exp</em>'.
     * @generated
     */
	MessageExp createMessageExp();

	/**
     * Returns a new object of class '<em>Null Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Null Literal Exp</em>'.
     * @generated
     */
	NullLiteralExp createNullLiteralExp();

	/**
     * Returns a new object of class '<em>Operation Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Call Exp</em>'.
     * @generated
     */
	OperationCallExp createOperationCallExp();

	/**
     * Returns a new object of class '<em>Property Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Property Call Exp</em>'.
     * @generated
     */
	PropertyCallExp createPropertyCallExp();

	/**
     * Returns a new object of class '<em>Real Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Real Literal Exp</em>'.
     * @generated
     */
	RealLiteralExp createRealLiteralExp();

	/**
     * Returns a new object of class '<em>State Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>State Exp</em>'.
     * @generated
     */
	StateExp createStateExp();

	/**
     * Returns a new object of class '<em>String Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>String Literal Exp</em>'.
     * @generated
     */
	StringLiteralExp createStringLiteralExp();

	/**
     * Returns a new object of class '<em>Tuple Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Literal Exp</em>'.
     * @generated
     */
	TupleLiteralExp createTupleLiteralExp();

	/**
     * Returns a new object of class '<em>Tuple Literal Part</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Literal Part</em>'.
     * @generated
     */
	TupleLiteralPart createTupleLiteralPart();

	/**
     * Returns a new object of class '<em>Type Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Exp</em>'.
     * @generated
     */
	TypeExp createTypeExp();

	/**
     * Returns a new object of class '<em>Unspecified Value Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Unspecified Value Exp</em>'.
     * @generated
     */
	UnspecifiedValueExp createUnspecifiedValueExp();

	/**
     * Returns a new object of class '<em>Variable</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable</em>'.
     * @generated
     */
	Variable createVariable();

	/**
     * Returns a new object of class '<em>Variable Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable Exp</em>'.
     * @generated
     */
	VariableExp createVariableExp();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    EcorePackage getEcorePackage();

} //EcoreFactory
