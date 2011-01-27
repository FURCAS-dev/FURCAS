/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotFactory.java,v 1.3 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.pivot.PivotPackage
 * @generated
 */
public interface PivotFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PivotFactory eINSTANCE = org.eclipse.ocl.examples.pivot.internal.impl.PivotFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class</em>'.
	 * @generated
	 */
	Class createClass();

	/**
	 * Returns a new object of class '<em>Template Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Binding</em>'.
	 * @generated
	 */
	TemplateBinding createTemplateBinding();

	/**
	 * Returns a new object of class '<em>Template Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Signature</em>'.
	 * @generated
	 */
	TemplateSignature createTemplateSignature();

	/**
	 * Returns a new object of class '<em>Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter</em>'.
	 * @generated
	 */
	TemplateParameter createTemplateParameter();

	/**
	 * Returns a new object of class '<em>Template Parameter Substitution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Substitution</em>'.
	 * @generated
	 */
	TemplateParameterSubstitution createTemplateParameterSubstitution();

	/**
	 * Returns a new object of class '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package</em>'.
	 * @generated
	 */
	Package createPackage();

	/**
	 * Returns a new object of class '<em>Precedence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precedence</em>'.
	 * @generated
	 */
	Precedence createPrecedence();

	/**
	 * Returns a new object of class '<em>Type Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Template Parameter</em>'.
	 * @generated
	 */
	TypeTemplateParameter createTypeTemplateParameter();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Association Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Class</em>'.
	 * @generated
	 */
	AssociationClass createAssociationClass();

	/**
	 * Returns a new object of class '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation</em>'.
	 * @generated
	 */
	Operation createOperation();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Operation Template Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Template Parameter</em>'.
	 * @generated
	 */
	OperationTemplateParameter createOperationTemplateParameter();

	/**
	 * Returns a new object of class '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment</em>'.
	 * @generated
	 */
	Comment createComment();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	Constraint createConstraint();

	/**
	 * Returns a new object of class '<em>Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Detail</em>'.
	 * @generated
	 */
	Detail createDetail();

	/**
	 * Returns a new object of class '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Type</em>'.
	 * @generated
	 */
	AnyType createAnyType();

	/**
	 * Returns a new object of class '<em>Association Class Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Association Class Call Exp</em>'.
	 * @generated
	 */
	AssociationClassCallExp createAssociationClassCallExp();

	/**
	 * Returns a new object of class '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Expression</em>'.
	 * @generated
	 */
	OclExpression createOclExpression();

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
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	DataType createDataType();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Exp</em>'.
	 * @generated
	 */
	BooleanLiteralExp createBooleanLiteralExp();

	/**
	 * Returns a new object of class '<em>Call Operation Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call Operation Action</em>'.
	 * @generated
	 */
	CallOperationAction createCallOperationAction();

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
	 * Returns a new object of class '<em>Complete Environment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Environment</em>'.
	 * @generated
	 */
	CompleteEnvironment createCompleteEnvironment();

	/**
	 * Returns a new object of class '<em>Complete Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Iteration</em>'.
	 * @generated
	 */
	CompleteIteration createCompleteIteration();

	/**
	 * Returns a new object of class '<em>Complete Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Operation</em>'.
	 * @generated
	 */
	CompleteOperation createCompleteOperation();

	/**
	 * Returns a new object of class '<em>Complete Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Package</em>'.
	 * @generated
	 */
	CompletePackage createCompletePackage();

	/**
	 * Returns a new object of class '<em>Complete Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Property</em>'.
	 * @generated
	 */
	CompleteProperty createCompleteProperty();

	/**
	 * Returns a new object of class '<em>Complete Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complete Type</em>'.
	 * @generated
	 */
	CompleteType createCompleteType();

	/**
	 * Returns a new object of class '<em>Enum Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Exp</em>'.
	 * @generated
	 */
	EnumLiteralExp createEnumLiteralExp();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration</em>'.
	 * @generated
	 */
	Enumeration createEnumeration();

	/**
	 * Returns a new object of class '<em>Expression In Ocl</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression In Ocl</em>'.
	 * @generated
	 */
	ExpressionInOcl createExpressionInOcl();

	/**
	 * Returns a new object of class '<em>Opaque Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opaque Expression</em>'.
	 * @generated
	 */
	OpaqueExpression createOpaqueExpression();

	/**
	 * Returns a new object of class '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable</em>'.
	 * @generated
	 */
	Variable createVariable();

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
	 * Returns a new object of class '<em>Invalid Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Literal Exp</em>'.
	 * @generated
	 */
	InvalidLiteralExp createInvalidLiteralExp();

	/**
	 * Returns a new object of class '<em>Invalid Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Type</em>'.
	 * @generated
	 */
	InvalidType createInvalidType();

	/**
	 * Returns a new object of class '<em>Iterate Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterate Exp</em>'.
	 * @generated
	 */
	IterateExp createIterateExp();

	/**
	 * Returns a new object of class '<em>Iteration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration</em>'.
	 * @generated
	 */
	Iteration createIteration();

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
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	Library createLibrary();

	/**
	 * Returns a new object of class '<em>Message Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Exp</em>'.
	 * @generated
	 */
	MessageExp createMessageExp();

	/**
	 * Returns a new object of class '<em>Send Signal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Send Signal Action</em>'.
	 * @generated
	 */
	SendSignalAction createSendSignalAction();

	/**
	 * Returns a new object of class '<em>Signal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal</em>'.
	 * @generated
	 */
	Signal createSignal();

	/**
	 * Returns a new object of class '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Type</em>'.
	 * @generated
	 */
	MessageType createMessageType();

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
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

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
	 * Returns a new object of class '<em>Template Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Parameter Type</em>'.
	 * @generated
	 */
	TemplateParameterType createTemplateParameterType();

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
	 * Returns a new object of class '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type</em>'.
	 * @generated
	 */
	TupleType createTupleType();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	Type createType();

	/**
	 * Returns a new object of class '<em>Type Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Exp</em>'.
	 * @generated
	 */
	TypeExp createTypeExp();

	/**
	 * Returns a new object of class '<em>Unlimited Natural Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unlimited Natural Literal Exp</em>'.
	 * @generated
	 */
	UnlimitedNaturalLiteralExp createUnlimitedNaturalLiteralExp();

	/**
	 * Returns a new object of class '<em>Unspecified Value Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unspecified Value Exp</em>'.
	 * @generated
	 */
	UnspecifiedValueExp createUnspecifiedValueExp();

	/**
	 * Returns a new object of class '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Exp</em>'.
	 * @generated
	 */
	VariableExp createVariableExp();

	/**
	 * Returns a new object of class '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Void Type</em>'.
	 * @generated
	 */
	VoidType createVoidType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PivotPackage getPivotPackage();

} //PivotFactory
