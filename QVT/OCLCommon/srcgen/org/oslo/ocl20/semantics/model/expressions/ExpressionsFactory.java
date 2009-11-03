/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ExpressionsFactory eINSTANCE = org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Boolean Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Boolean Literal Exp</em>'.
	 * @generated
	 */
	BooleanLiteralExp createBooleanLiteralExp();

	/**
	 * Returns a new object of class '<em>Call Exp</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Call Exp</em>'.
	 * @generated
	 */
	CallExp createCallExp();

	/**
	 * Returns a new object of class '<em>Collection Item</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collection Item</em>'.
	 * @generated
	 */
	CollectionItem createCollectionItem();

	/**
	 * Returns a new object of class '<em>Collection Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collection Literal Exp</em>'.
	 * @generated
	 */
	CollectionLiteralExp createCollectionLiteralExp();

	/**
	 * Returns a new object of class '<em>Collection Literal Part</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collection Literal Part</em>'.
	 * @generated
	 */
	CollectionLiteralPart createCollectionLiteralPart();

	/**
	 * Returns a new object of class '<em>Collection Range</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Collection Range</em>'.
	 * @generated
	 */
	CollectionRange createCollectionRange();

	/**
	 * Returns a new object of class '<em>Enum Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Enum Literal Exp</em>'.
	 * @generated
	 */
	EnumLiteralExp createEnumLiteralExp();

	/**
	 * Returns a new object of class '<em>If Exp</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>If Exp</em>'.
	 * @generated
	 */
	IfExp createIfExp();

	/**
	 * Returns a new object of class '<em>Integer Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Integer Literal Exp</em>'.
	 * @generated
	 */
	IntegerLiteralExp createIntegerLiteralExp();

	/**
	 * Returns a new object of class '<em>Iterate Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Iterate Exp</em>'.
	 * @generated
	 */
	IterateExp createIterateExp();

	/**
	 * Returns a new object of class '<em>Iterator Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Iterator Exp</em>'.
	 * @generated
	 */
	IteratorExp createIteratorExp();

	/**
	 * Returns a new object of class '<em>Let Exp</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Let Exp</em>'.
	 * @generated
	 */
	LetExp createLetExp();

	/**
	 * Returns a new object of class '<em>Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Literal Exp</em>'.
	 * @generated
	 */
	LiteralExp createLiteralExp();

	/**
	 * Returns a new object of class '<em>Loop Exp</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Loop Exp</em>'.
	 * @generated
	 */
	LoopExp createLoopExp();

	/**
	 * Returns a new object of class '<em>Model Property Call Exp</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Model Property Call Exp</em>'.
	 * @generated
	 */
	ModelPropertyCallExp createModelPropertyCallExp();

	/**
	 * Returns a new object of class '<em>Numerical Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Numerical Literal Exp</em>'.
	 * @generated
	 */
	NumericalLiteralExp createNumericalLiteralExp();

	/**
	 * Returns a new object of class '<em>Ocl Expression</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Ocl Expression</em>'.
	 * @generated
	 */
	OclExpression createOclExpression();

	/**
	 * Returns a new object of class '<em>Ocl Message Arg</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Ocl Message Arg</em>'.
	 * @generated
	 */
	OclMessageArg createOclMessageArg();

	/**
	 * Returns a new object of class '<em>Ocl Message Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Ocl Message Exp</em>'.
	 * @generated
	 */
	OclMessageExp createOclMessageExp();

	/**
	 * Returns a new object of class '<em>Operation Call Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Operation Call Exp</em>'.
	 * @generated
	 */
	OperationCallExp createOperationCallExp();

	/**
	 * Returns a new object of class '<em>Property Call Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Property Call Exp</em>'.
	 * @generated
	 */
	PropertyCallExp createPropertyCallExp();

	/**
	 * Returns a new object of class '<em>Real Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Real Literal Exp</em>'.
	 * @generated
	 */
	RealLiteralExp createRealLiteralExp();

	/**
	 * Returns a new object of class '<em>String Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>String Literal Exp</em>'.
	 * @generated
	 */
	StringLiteralExp createStringLiteralExp();

	/**
	 * Returns a new object of class '<em>Tuple Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Tuple Literal Exp</em>'.
	 * @generated
	 */
	TupleLiteralExp createTupleLiteralExp();

	/**
	 * Returns a new object of class '<em>Type Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Type Literal Exp</em>'.
	 * @generated
	 */
	TypeLiteralExp createTypeLiteralExp();

	/**
	 * Returns a new object of class '<em>Undefined Literal Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Undefined Literal Exp</em>'.
	 * @generated
	 */
	UndefinedLiteralExp createUndefinedLiteralExp();

	/**
	 * Returns a new object of class '<em>Unspecified Value Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Unspecified Value Exp</em>'.
	 * @generated
	 */
	UnspecifiedValueExp createUnspecifiedValueExp();

	/**
	 * Returns a new object of class '<em>Variable Declaration</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Variable Declaration</em>'.
	 * @generated
	 */
	VariableDeclaration createVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Variable Exp</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Variable Exp</em>'.
	 * @generated
	 */
	VariableExp createVariableExp();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionsPackage getExpressionsPackage();

} // ExpressionsFactory
