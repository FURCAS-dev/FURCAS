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
 * $Id: OCLFactory.java,v 1.2 2007/05/17 17:06:22 cdamus Exp $
 */

package org.eclipse.ocl.utilities;

import java.util.List;

import org.eclipse.ocl.expressions.AssociationClassCallExp;
import org.eclipse.ocl.expressions.BooleanLiteralExp;
import org.eclipse.ocl.expressions.CollectionItem;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.CollectionRange;
import org.eclipse.ocl.expressions.EnumLiteralExp;
import org.eclipse.ocl.expressions.IfExp;
import org.eclipse.ocl.expressions.IntegerLiteralExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.MessageExp;
import org.eclipse.ocl.expressions.NullLiteralExp;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.RealLiteralExp;
import org.eclipse.ocl.expressions.StateExp;
import org.eclipse.ocl.expressions.StringLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralExp;
import org.eclipse.ocl.expressions.TupleLiteralPart;
import org.eclipse.ocl.expressions.TypeExp;
import org.eclipse.ocl.expressions.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.VariableExp;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;

/**
 * Interface for a factory of OCl Abstract Syntax elements.
 * 
 * @author Christian W. Damus (cdamus
 */
public interface OCLFactory {

	/**
	 * Returns a new object of class '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bag Type</em>'.
	 * @generated NOT
	 */
	<C, O> BagType<C, O> createBagType(C elementType);

	/**
	 * Returns a new object of class '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type</em>'.
	 * @generated NOT
	 */
	<C, O> CollectionType<C, O> createCollectionType(C elementType);

	/**
	 * Returns a new object of class '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type</em>'.
	 * @generated NOT
	 */
	<C, O> CollectionType<C, O>	createCollectionType(CollectionKind kind, C elementType);

	/**
	 * Returns a new object of class '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordered Set Type</em>'.
	 * @generated NOT
	 */
	<C, O> OrderedSetType<C, O> createOrderedSetType(C elementType);

	/**
	 * Returns a new object of class '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Type</em>'.
	 * @generated NOT
	 */
	<C, O> SequenceType<C, O> createSequenceType(C elementType);

	/**
	 * Returns a new object of class '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type</em>'.
	 * @generated NOT
	 */
	<C, O> SetType<C, O> createSetType(C elementType);

	/**
	 * Creates the type for the messages representing invocation of the
	 * specified signal.
	 * 
	 * @param signal either a sent signal
	 * 
	 * @return the message type
	 * @generated NOT
	 */
	<C, O, P> MessageType<C, O, P> createSignalMessageType(C signal);

	/**
	 * Creates the type for the messages representing invocation of the
	 * specified operation.
	 * 
	 * @param operation a called operation
	 * 
	 * @return the message type
	 * @generated NOT
	 */
	<C, O, P> MessageType<C, O, P> createOperationMessageType(O operation);

	/**
	 * Creates a tuple type based on tthe specified part descriptions.
	 * 
	 * @param parts a list of {@link TypedElement}s describing the tuple parts
	 * 
	 * @return the new tuple type
	 * @generated NOT
	 */
	<C, O, P> TupleType<O, P> createTupleType(List<? extends TypedElement<C>> parts);

	/**
	 * Returns a new object of class '<em>Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Type</em>'.
	 * @generated NOT
	 */
	<C, O> TypeType<C, O> createTypeType(C type);

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

}
