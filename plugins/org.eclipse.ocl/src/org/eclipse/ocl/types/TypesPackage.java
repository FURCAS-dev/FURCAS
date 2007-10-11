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
 * $Id: TypesPackage.java,v 1.4 2007/10/11 23:04:56 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "types"; //$NON-NLS-1$

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://www.eclipse.org/ocl/1.1.0/OCL/Types"; //$NON-NLS-1$

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "ocl.types"; //$NON-NLS-1$

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	TypesPackage eINSTANCE = org.eclipse.ocl.types.impl.TypesPackageImpl.init();

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.AnyTypeImpl <em>Any Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.AnyTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getAnyType()
     * @generated
     */
	int ANY_TYPE = 0;

	/**
     * The number of structural features of the '<em>Any Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANY_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.CollectionTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getCollectionType()
     * @generated
     */
	int COLLECTION_TYPE = 2;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE__START_POSITION = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE__END_POSITION = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE__TYPE_START_POSITION = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE__TYPE_END_POSITION = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE__ELEMENT_TYPE = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE__KIND = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Collection Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COLLECTION_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 6;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.BagTypeImpl <em>Bag Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.BagTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getBagType()
     * @generated
     */
	int BAG_TYPE = 1;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
     * The number of structural features of the '<em>Bag Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.ElementTypeImpl <em>Element Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.ElementTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getElementType()
     * @generated
     */
	int ELEMENT_TYPE = 3;

	/**
     * The number of structural features of the '<em>Element Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ELEMENT_TYPE_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.InvalidTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getInvalidType()
     * @generated
     */
	int INVALID_TYPE = 4;

	/**
     * The number of structural features of the '<em>Invalid Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INVALID_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.MessageTypeImpl <em>Message Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.MessageTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getMessageType()
     * @generated
     */
	int MESSAGE_TYPE = 5;

	/**
     * The feature id for the '<em><b>Referred Operation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_TYPE__REFERRED_OPERATION = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Referred Signal</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_TYPE__REFERRED_SIGNAL = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Message Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MESSAGE_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.OrderedSetTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getOrderedSetType()
     * @generated
     */
	int ORDERED_SET_TYPE = 6;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
     * The number of structural features of the '<em>Ordered Set Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.PrimitiveTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getPrimitiveType()
     * @generated
     */
	int PRIMITIVE_TYPE = 7;

	/**
     * The number of structural features of the '<em>Primitive Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRIMITIVE_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.SequenceTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getSequenceType()
     * @generated
     */
	int SEQUENCE_TYPE = 8;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
     * The number of structural features of the '<em>Sequence Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.SetTypeImpl <em>Set Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.SetTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getSetType()
     * @generated
     */
	int SET_TYPE = 9;

	/**
     * The feature id for the '<em><b>Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE__START_POSITION = COLLECTION_TYPE__START_POSITION;

	/**
     * The feature id for the '<em><b>End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE__END_POSITION = COLLECTION_TYPE__END_POSITION;

	/**
     * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE__TYPE_START_POSITION = COLLECTION_TYPE__TYPE_START_POSITION;

	/**
     * The feature id for the '<em><b>Type End Position</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE__TYPE_END_POSITION = COLLECTION_TYPE__TYPE_END_POSITION;

	/**
     * The feature id for the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE__KIND = COLLECTION_TYPE__KIND;

	/**
     * The number of structural features of the '<em>Set Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.TupleTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getTupleType()
     * @generated
     */
	int TUPLE_TYPE = 10;

	/**
     * The number of structural features of the '<em>Tuple Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TUPLE_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.TypeTypeImpl <em>Type Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.TypeTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getTypeType()
     * @generated
     */
	int TYPE_TYPE = 11;

	/**
     * The feature id for the '<em><b>Referred Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_TYPE__REFERRED_TYPE = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Type Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link org.eclipse.ocl.types.impl.VoidTypeImpl <em>Void Type</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see org.eclipse.ocl.types.impl.VoidTypeImpl
     * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getVoidType()
     * @generated
     */
	int VOID_TYPE = 12;

	/**
     * The number of structural features of the '<em>Void Type</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VOID_TYPE_FEATURE_COUNT = UtilitiesPackage.PREDEFINED_TYPE_FEATURE_COUNT + 0;


	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.AnyType <em>Any Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Any Type</em>'.
     * @see org.eclipse.ocl.types.AnyType
     * @generated
     */
	EClass getAnyType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.BagType <em>Bag Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Bag Type</em>'.
     * @see org.eclipse.ocl.types.BagType
     * @generated
     */
	EClass getBagType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.CollectionType <em>Collection Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Collection Type</em>'.
     * @see org.eclipse.ocl.types.CollectionType
     * @generated
     */
	EClass getCollectionType();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.types.CollectionType#getElementType <em>Element Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Element Type</em>'.
     * @see org.eclipse.ocl.types.CollectionType#getElementType()
     * @see #getCollectionType()
     * @generated
     */
	EReference getCollectionType_ElementType();

	/**
     * Returns the meta object for the attribute '{@link org.eclipse.ocl.types.CollectionType#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see org.eclipse.ocl.types.CollectionType#getKind()
     * @see #getCollectionType()
     * @generated
     */
	EAttribute getCollectionType_Kind();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.ElementType <em>Element Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Element Type</em>'.
     * @see org.eclipse.ocl.types.ElementType
     * @generated
     */
	EClass getElementType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.InvalidType <em>Invalid Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Invalid Type</em>'.
     * @see org.eclipse.ocl.types.InvalidType
     * @generated
     */
	EClass getInvalidType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.MessageType <em>Message Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Message Type</em>'.
     * @see org.eclipse.ocl.types.MessageType
     * @generated
     */
	EClass getMessageType();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Operation</em>'.
     * @see org.eclipse.ocl.types.MessageType#getReferredOperation()
     * @see #getMessageType()
     * @generated
     */
	EReference getMessageType_ReferredOperation();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Signal</em>'.
     * @see org.eclipse.ocl.types.MessageType#getReferredSignal()
     * @see #getMessageType()
     * @generated
     */
	EReference getMessageType_ReferredSignal();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.OrderedSetType <em>Ordered Set Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ordered Set Type</em>'.
     * @see org.eclipse.ocl.types.OrderedSetType
     * @generated
     */
	EClass getOrderedSetType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.PrimitiveType <em>Primitive Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive Type</em>'.
     * @see org.eclipse.ocl.types.PrimitiveType
     * @generated
     */
	EClass getPrimitiveType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.SequenceType <em>Sequence Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sequence Type</em>'.
     * @see org.eclipse.ocl.types.SequenceType
     * @generated
     */
	EClass getSequenceType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.SetType <em>Set Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Set Type</em>'.
     * @see org.eclipse.ocl.types.SetType
     * @generated
     */
	EClass getSetType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.TupleType <em>Tuple Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tuple Type</em>'.
     * @see org.eclipse.ocl.types.TupleType
     * @generated
     */
	EClass getTupleType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.TypeType <em>Type Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Type</em>'.
     * @see org.eclipse.ocl.types.TypeType
     * @generated
     */
	EClass getTypeType();

	/**
     * Returns the meta object for the reference '{@link org.eclipse.ocl.types.TypeType#getReferredType <em>Referred Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Referred Type</em>'.
     * @see org.eclipse.ocl.types.TypeType#getReferredType()
     * @see #getTypeType()
     * @generated
     */
	EReference getTypeType_ReferredType();

	/**
     * Returns the meta object for class '{@link org.eclipse.ocl.types.VoidType <em>Void Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Void Type</em>'.
     * @see org.eclipse.ocl.types.VoidType
     * @generated
     */
	EClass getVoidType();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	TypesFactory getTypesFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.AnyTypeImpl <em>Any Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.AnyTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getAnyType()
         * @generated
         */
		EClass ANY_TYPE = eINSTANCE.getAnyType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.BagTypeImpl <em>Bag Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.BagTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getBagType()
         * @generated
         */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.CollectionTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getCollectionType()
         * @generated
         */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
         * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference COLLECTION_TYPE__ELEMENT_TYPE = eINSTANCE.getCollectionType_ElementType();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COLLECTION_TYPE__KIND = eINSTANCE.getCollectionType_Kind();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.ElementTypeImpl <em>Element Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.ElementTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getElementType()
         * @generated
         */
		EClass ELEMENT_TYPE = eINSTANCE.getElementType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.InvalidTypeImpl <em>Invalid Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.InvalidTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getInvalidType()
         * @generated
         */
		EClass INVALID_TYPE = eINSTANCE.getInvalidType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.MessageTypeImpl <em>Message Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.MessageTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getMessageType()
         * @generated
         */
		EClass MESSAGE_TYPE = eINSTANCE.getMessageType();

		/**
         * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_TYPE__REFERRED_OPERATION = eINSTANCE.getMessageType_ReferredOperation();

		/**
         * The meta object literal for the '<em><b>Referred Signal</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference MESSAGE_TYPE__REFERRED_SIGNAL = eINSTANCE.getMessageType_ReferredSignal();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.OrderedSetTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getOrderedSetType()
         * @generated
         */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.PrimitiveTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getPrimitiveType()
         * @generated
         */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.SequenceTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getSequenceType()
         * @generated
         */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.SetTypeImpl <em>Set Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.SetTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getSetType()
         * @generated
         */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.TupleTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getTupleType()
         * @generated
         */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.TypeTypeImpl <em>Type Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.TypeTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getTypeType()
         * @generated
         */
		EClass TYPE_TYPE = eINSTANCE.getTypeType();

		/**
         * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_TYPE__REFERRED_TYPE = eINSTANCE.getTypeType_ReferredType();

		/**
         * The meta object literal for the '{@link org.eclipse.ocl.types.impl.VoidTypeImpl <em>Void Type</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see org.eclipse.ocl.types.impl.VoidTypeImpl
         * @see org.eclipse.ocl.types.impl.TypesPackageImpl#getVoidType()
         * @generated
         */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

	}

} //TypesPackage
