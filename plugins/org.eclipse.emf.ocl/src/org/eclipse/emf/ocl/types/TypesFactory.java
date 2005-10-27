/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ocl.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesFactory eINSTANCE = new org.eclipse.emf.ocl.types.internal.impl.TypesFactoryImpl();

	/**
	 * Returns a new object of class '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bag Type</em>'.
	 * @generated
	 */
	BagType createBagType();

	BagType createBagType(EClassifier elementType);
	
	/**
	 * Returns a new object of class '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type</em>'.
	 * @generated
	 */
	CollectionType createCollectionType();

	CollectionType createCollectionType(EClassifier elementType);
	
	/**
	 * Returns a new object of class '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordered Set Type</em>'.
	 * @generated
	 */
	OrderedSetType createOrderedSetType();

	OrderedSetType createOrderedSetType(EClassifier elementType);

	/**
	 * Returns a new object of class '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Type</em>'.
	 * @generated
	 */
	SequenceType createSequenceType();

	SequenceType createSequenceType(EClassifier elementType);

	/**
	 * Returns a new object of class '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type</em>'.
	 * @generated
	 */
	SetType createSetType();

	SetType createSetType(EClassifier elementType);
	
	/**
	 * Returns a new object of class '<em>Tuple Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type</em>'.
	 * @generated
	 */
	TupleType createTupleType();

	TupleType createTupleType(EList variableDeclarations);

	/**
	 * Returns a new object of class '<em>Void Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Void Type</em>'.
	 * @generated
	 */
	VoidType createVoidType();

	/**
	 * Returns a new object of class '<em>Message Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message Type</em>'.
	 * @generated
	 */
	MessageType createMessageType();

	/**
	 * Returns a new object of class '<em>Model Element Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Type</em>'.
	 * @generated
	 */
	ModelElementType createModelElementType();

	/**
	 * Returns a new object of class '<em>Ocl State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl State</em>'.
	 * @generated
	 */
	OclState createOclState();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>Primitive Boolean</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Boolean</em>'.
	 * @generated
	 */
	PrimitiveBoolean createPrimitiveBoolean();

	/**
	 * Returns a new object of class '<em>Primitive Integer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Integer</em>'.
	 * @generated
	 */
	PrimitiveInteger createPrimitiveInteger();

	/**
	 * Returns a new object of class '<em>Primitive Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Real</em>'.
	 * @generated
	 */
	PrimitiveReal createPrimitiveReal();

	/**
	 * Returns a new object of class '<em>Primitive String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive String</em>'.
	 * @generated
	 */
	PrimitiveString createPrimitiveString();

	/**
	 * Returns a new object of class '<em>Any Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Type</em>'.
	 * @generated
	 */
	AnyType createAnyType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesPackage getTypesPackage();

} //TypesFactory
