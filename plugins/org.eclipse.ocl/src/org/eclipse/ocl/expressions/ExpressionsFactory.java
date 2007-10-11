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
 * $Id: ExpressionsFactory.java,v 1.5 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.expressions.ExpressionsPackage
 * @generated
 */
public interface ExpressionsFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ExpressionsFactory eINSTANCE = org.eclipse.ocl.expressions.impl.ExpressionsFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Association Class Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Association Class Call Exp</em>'.
     * @generated
     */
	<C, P> AssociationClassCallExp<C, P> createAssociationClassCallExp();

	/**
     * Returns a new object of class '<em>Boolean Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Boolean Literal Exp</em>'.
     * @generated
     */
	<C> BooleanLiteralExp<C> createBooleanLiteralExp();

	/**
     * Returns a new object of class '<em>Collection Item</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Item</em>'.
     * @generated
     */
	<C> CollectionItem<C> createCollectionItem();

	/**
     * Returns a new object of class '<em>Collection Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Literal Exp</em>'.
     * @generated
     */
	<C> CollectionLiteralExp<C> createCollectionLiteralExp();

	/**
     * Returns a new object of class '<em>Collection Range</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Range</em>'.
     * @generated
     */
	<C> CollectionRange<C> createCollectionRange();

	/**
     * Returns a new object of class '<em>Enum Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Enum Literal Exp</em>'.
     * @generated
     */
	<C, EL> EnumLiteralExp<C, EL> createEnumLiteralExp();

	/**
     * Returns a new object of class '<em>If Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>If Exp</em>'.
     * @generated
     */
	<C> IfExp<C> createIfExp();

	/**
     * Returns a new object of class '<em>Integer Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Integer Literal Exp</em>'.
     * @generated
     */
	<C> IntegerLiteralExp<C> createIntegerLiteralExp();

	/**
     * Returns a new object of class '<em>Unlimited Natural Literal Exp</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Unlimited Natural Literal Exp</em>'.
     * @generated
     */
    <C> UnlimitedNaturalLiteralExp<C> createUnlimitedNaturalLiteralExp();

    /**
     * Returns a new object of class '<em>Invalid Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Invalid Literal Exp</em>'.
     * @generated
     */
	<C> InvalidLiteralExp<C> createInvalidLiteralExp();

	/**
     * Returns a new object of class '<em>Iterate Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterate Exp</em>'.
     * @generated
     */
	<C, PM> IterateExp<C, PM> createIterateExp();

	/**
     * Returns a new object of class '<em>Iterator Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Iterator Exp</em>'.
     * @generated
     */
	<C, PM> IteratorExp<C, PM> createIteratorExp();

	/**
     * Returns a new object of class '<em>Let Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Let Exp</em>'.
     * @generated
     */
	<C, PM> LetExp<C, PM> createLetExp();

	/**
     * Returns a new object of class '<em>Message Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Exp</em>'.
     * @generated
     */
	<C, COA, SSA> MessageExp<C, COA, SSA> createMessageExp();

	/**
     * Returns a new object of class '<em>Null Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Null Literal Exp</em>'.
     * @generated
     */
	<C> NullLiteralExp<C> createNullLiteralExp();

	/**
     * Returns a new object of class '<em>Operation Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Operation Call Exp</em>'.
     * @generated
     */
	<C, O> OperationCallExp<C, O> createOperationCallExp();

	/**
     * Returns a new object of class '<em>Property Call Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Property Call Exp</em>'.
     * @generated
     */
	<C, P> PropertyCallExp<C, P> createPropertyCallExp();

	/**
     * Returns a new object of class '<em>Real Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Real Literal Exp</em>'.
     * @generated
     */
	<C> RealLiteralExp<C> createRealLiteralExp();

	/**
     * Returns a new object of class '<em>State Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>State Exp</em>'.
     * @generated
     */
	<C, S> StateExp<C, S> createStateExp();

	/**
     * Returns a new object of class '<em>String Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>String Literal Exp</em>'.
     * @generated
     */
	<C> StringLiteralExp<C> createStringLiteralExp();

	/**
     * Returns a new object of class '<em>Tuple Literal Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Literal Exp</em>'.
     * @generated
     */
	<C, P> TupleLiteralExp<C, P> createTupleLiteralExp();

	/**
     * Returns a new object of class '<em>Tuple Literal Part</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Literal Part</em>'.
     * @generated
     */
	<C, P> TupleLiteralPart<C, P> createTupleLiteralPart();

	/**
     * Returns a new object of class '<em>Type Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Exp</em>'.
     * @generated
     */
	<C> TypeExp<C> createTypeExp();

	/**
     * Returns a new object of class '<em>Unspecified Value Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Unspecified Value Exp</em>'.
     * @generated
     */
	<C> UnspecifiedValueExp<C> createUnspecifiedValueExp();

	/**
     * Returns a new object of class '<em>Variable</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable</em>'.
     * @generated
     */
	<C, PM> Variable<C, PM> createVariable();

	/**
     * Returns a new object of class '<em>Variable Exp</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Variable Exp</em>'.
     * @generated
     */
	<C, PM> VariableExp<C, PM> createVariableExp();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	ExpressionsPackage getExpressionsPackage();

} //ExpressionsFactory
