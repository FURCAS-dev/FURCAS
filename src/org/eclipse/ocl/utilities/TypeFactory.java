/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: TypeFactory.java,v 1.1 2007/01/25 18:24:32 cdamus Exp $
 */

package org.eclipse.ocl.utilities;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.MessageType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.types.TypeType;

/**
 * @author cdamus
 *
 */
public interface TypeFactory {

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
	 * @param behavioralFeature either an {@link EOperation} or an 
	 *    {@link EClass} representing the received signal
	 * 
	 * @return the message type
	 * @generated NOT
	 */
	<C, O, P> MessageType<C, O, P> createSignalMessageType(C signal);

	/**
	 * Creates the type for the messages representing invocation of the
	 * specified operation.
	 * 
	 * @param behavioralFeature either an {@link EOperation} or an 
	 *    {@link EClass} representing the received signal
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

}
