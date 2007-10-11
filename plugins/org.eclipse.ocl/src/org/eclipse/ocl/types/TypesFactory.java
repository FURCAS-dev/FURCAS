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
 * $Id: TypesFactory.java,v 1.4 2007/10/11 23:04:57 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory {
	/**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TypesFactory eINSTANCE = org.eclipse.ocl.types.impl.TypesFactoryImpl.init();

	/**
     * Returns a new object of class '<em>Any Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Any Type</em>'.
     * @generated
     */
	<O> AnyType<O> createAnyType();

	/**
     * Returns a new object of class '<em>Bag Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Bag Type</em>'.
     * @generated
     */
	<C, O> BagType<C, O> createBagType();

	/**
     * Returns a new object of class '<em>Collection Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Collection Type</em>'.
     * @generated
     */
	<C, O> CollectionType<C, O> createCollectionType();

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
	<O> InvalidType<O> createInvalidType();

	/**
     * Returns a new object of class '<em>Message Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Message Type</em>'.
     * @generated
     */
	<C, O, P> MessageType<C, O, P> createMessageType();

	/**
     * Returns a new object of class '<em>Ordered Set Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Ordered Set Type</em>'.
     * @generated
     */
	<C, O> OrderedSetType<C, O> createOrderedSetType();

	/**
     * Returns a new object of class '<em>Primitive Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Primitive Type</em>'.
     * @generated
     */
    <O> PrimitiveType<O> createPrimitiveType();

    /**
     * Returns a new object of class '<em>Sequence Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Sequence Type</em>'.
     * @generated
     */
	<C, O> SequenceType<C, O> createSequenceType();

	/**
     * Returns a new object of class '<em>Set Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Set Type</em>'.
     * @generated
     */
	<C, O> SetType<C, O> createSetType();

	/**
     * Returns a new object of class '<em>Tuple Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Tuple Type</em>'.
     * @generated
     */
	<O, P> TupleType<O, P> createTupleType();

	/**
     * Returns a new object of class '<em>Type Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Type Type</em>'.
     * @generated
     */
	<C, O> TypeType<C, O> createTypeType();

	/**
     * Returns a new object of class '<em>Void Type</em>'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return a new object of class '<em>Void Type</em>'.
     * @generated
     */
	<O> VoidType<O> createVoidType();

	/**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
	TypesPackage getTypesPackage();

} //TypesFactory
