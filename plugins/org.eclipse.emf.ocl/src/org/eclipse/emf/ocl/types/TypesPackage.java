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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
 * @see org.eclipse.emf.ocl.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";//$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/OCL2/7.0.0/ocl/types";//$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ocl.types";//$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl <em>Any Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getAnyType()
	 * @generated
	 */
	int ANY_TYPE = 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__EANNOTATIONS = EcorePackage.EDATA_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__NAME = EcorePackage.EDATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__INSTANCE_CLASS_NAME = EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__INSTANCE_CLASS = EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__DEFAULT_VALUE = EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__EPACKAGE = EcorePackage.EDATA_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE__SERIALIZABLE = EcorePackage.EDATA_TYPE__SERIALIZABLE;

	/**
	 * The number of structural features of the the '<em>Any Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_TYPE_FEATURE_COUNT = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.CollectionTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EANNOTATIONS = EcorePackage.EDATA_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = EcorePackage.EDATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_CLASS_NAME = EcorePackage.EDATA_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__INSTANCE_CLASS = EcorePackage.EDATA_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__DEFAULT_VALUE = EcorePackage.EDATA_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__EPACKAGE = EcorePackage.EDATA_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__SERIALIZABLE = EcorePackage.EDATA_TYPE__SERIALIZABLE;

	/**
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__START_POSITION = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__END_POSITION = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TYPE_START_POSITION = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TYPE_END_POSITION = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_TYPE = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = EcorePackage.EDATA_TYPE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.BagTypeImpl <em>Bag Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.BagTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

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
	 * The number of structural features of the the '<em>Bag Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.OrderedSetTypeImpl <em>Ordered Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.OrderedSetTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 3;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

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
	 * The number of structural features of the the '<em>Ordered Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EANNOTATIONS = ANY_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = ANY_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__INSTANCE_CLASS_NAME = ANY_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__INSTANCE_CLASS = ANY_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__DEFAULT_VALUE = ANY_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__EPACKAGE = ANY_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__SERIALIZABLE = ANY_TYPE__SERIALIZABLE;

	/**
	 * The number of structural features of the the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.PrimitiveBooleanImpl <em>Primitive Boolean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.PrimitiveBooleanImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getPrimitiveBoolean()
	 * @generated
	 */
	int PRIMITIVE_BOOLEAN = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__EANNOTATIONS = PRIMITIVE_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__INSTANCE_CLASS = PRIMITIVE_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__EPACKAGE = PRIMITIVE_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN__SERIALIZABLE = PRIMITIVE_TYPE__SERIALIZABLE;

	/**
	 * The number of structural features of the the '<em>Primitive Boolean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_BOOLEAN_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.PrimitiveRealImpl <em>Primitive Real</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.PrimitiveRealImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getPrimitiveReal()
	 * @generated
	 */
	int PRIMITIVE_REAL = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__EANNOTATIONS = PRIMITIVE_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__INSTANCE_CLASS = PRIMITIVE_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__EPACKAGE = PRIMITIVE_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL__SERIALIZABLE = PRIMITIVE_TYPE__SERIALIZABLE;

	/**
	 * The number of structural features of the the '<em>Primitive Real</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_REAL_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.PrimitiveIntegerImpl <em>Primitive Integer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.PrimitiveIntegerImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getPrimitiveInteger()
	 * @generated
	 */
	int PRIMITIVE_INTEGER = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__EANNOTATIONS = PRIMITIVE_REAL__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__NAME = PRIMITIVE_REAL__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__INSTANCE_CLASS_NAME = PRIMITIVE_REAL__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__INSTANCE_CLASS = PRIMITIVE_REAL__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__DEFAULT_VALUE = PRIMITIVE_REAL__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__EPACKAGE = PRIMITIVE_REAL__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER__SERIALIZABLE = PRIMITIVE_REAL__SERIALIZABLE;

	/**
	 * The number of structural features of the the '<em>Primitive Integer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_INTEGER_FEATURE_COUNT = PRIMITIVE_REAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.PrimitiveStringImpl <em>Primitive String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.PrimitiveStringImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getPrimitiveString()
	 * @generated
	 */
	int PRIMITIVE_STRING = 7;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__EANNOTATIONS = PRIMITIVE_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__INSTANCE_CLASS_NAME = PRIMITIVE_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__INSTANCE_CLASS = PRIMITIVE_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__DEFAULT_VALUE = PRIMITIVE_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__EPACKAGE = PRIMITIVE_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING__SERIALIZABLE = PRIMITIVE_TYPE__SERIALIZABLE;

	/**
	 * The number of structural features of the the '<em>Primitive String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STRING_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.SequenceTypeImpl <em>Sequence Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.SequenceTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

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
	 * The number of structural features of the the '<em>Sequence Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.SetTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 10;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EANNOTATIONS = COLLECTION_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_CLASS_NAME = COLLECTION_TYPE__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__INSTANCE_CLASS = COLLECTION_TYPE__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__DEFAULT_VALUE = COLLECTION_TYPE__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__EPACKAGE = COLLECTION_TYPE__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__SERIALIZABLE = COLLECTION_TYPE__SERIALIZABLE;

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
	 * The number of structural features of the the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.TupleTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getTupleType()
	 * @generated
	 */
	int TUPLE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EANNOTATIONS = EcorePackage.ECLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAME = EcorePackage.ECLASS__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__INSTANCE_CLASS = EcorePackage.ECLASS__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__DEFAULT_VALUE = EcorePackage.ECLASS__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EPACKAGE = EcorePackage.ECLASS__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__ABSTRACT = EcorePackage.ECLASS__ABSTRACT;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__INTERFACE = EcorePackage.ECLASS__INTERFACE;

	/**
	 * The feature id for the '<em><b>ESuper Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__ESUPER_TYPES = EcorePackage.ECLASS__ESUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EOperations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EOPERATIONS = EcorePackage.ECLASS__EOPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EALL_ATTRIBUTES = EcorePackage.ECLASS__EALL_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EALL_REFERENCES = EcorePackage.ECLASS__EALL_REFERENCES;

	/**
	 * The feature id for the '<em><b>EReferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EREFERENCES = EcorePackage.ECLASS__EREFERENCES;

	/**
	 * The feature id for the '<em><b>EAttributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EATTRIBUTES = EcorePackage.ECLASS__EATTRIBUTES;

	/**
	 * The feature id for the '<em><b>EAll Containments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EALL_CONTAINMENTS = EcorePackage.ECLASS__EALL_CONTAINMENTS;

	/**
	 * The feature id for the '<em><b>EAll Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EALL_OPERATIONS = EcorePackage.ECLASS__EALL_OPERATIONS;

	/**
	 * The feature id for the '<em><b>EAll Structural Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EALL_STRUCTURAL_FEATURES = EcorePackage.ECLASS__EALL_STRUCTURAL_FEATURES;

	/**
	 * The feature id for the '<em><b>EAll Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EALL_SUPER_TYPES = EcorePackage.ECLASS__EALL_SUPER_TYPES;

	/**
	 * The feature id for the '<em><b>EID Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__EID_ATTRIBUTE = EcorePackage.ECLASS__EID_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>EStructural Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__ESTRUCTURAL_FEATURES = EcorePackage.ECLASS__ESTRUCTURAL_FEATURES;

	/**
	 * The number of structural features of the the '<em>Tuple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_FEATURE_COUNT = EcorePackage.ECLASS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.VoidTypeImpl <em>Void Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.VoidTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 12;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME = EcorePackage.ECLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

	/**
	 * The number of structural features of the the '<em>Void Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.MessageTypeImpl <em>Message Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.MessageTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getMessageType()
	 * @generated
	 */
	int MESSAGE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__NAME = EcorePackage.ECLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_OPERATION = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Signal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE__REFERRED_SIGNAL = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Message Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_TYPE_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.ModelElementTypeImpl <em>Model Element Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.ModelElementTypeImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getModelElementType()
	 * @generated
	 */
	int MODEL_ELEMENT_TYPE = 14;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__EANNOTATIONS = EcorePackage.ECLASSIFIER__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__NAME = EcorePackage.ECLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__INSTANCE_CLASS_NAME = EcorePackage.ECLASSIFIER__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Instance Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__INSTANCE_CLASS = EcorePackage.ECLASSIFIER__INSTANCE_CLASS;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__DEFAULT_VALUE = EcorePackage.ECLASSIFIER__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>EPackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE__EPACKAGE = EcorePackage.ECLASSIFIER__EPACKAGE;

	/**
	 * The number of structural features of the the '<em>Model Element Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_TYPE_FEATURE_COUNT = EcorePackage.ECLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ocl.types.internal.impl.OclStateImpl <em>Ocl State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ocl.types.internal.impl.OclStateImpl
	 * @see org.eclipse.emf.ocl.types.internal.impl.TypesPackageImpl#getOclState()
	 * @generated
	 */
	int OCL_STATE = 15;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_STATE__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_STATE__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the the '<em>Ocl State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_STATE_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.AnyType <em>Any Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Type</em>'.
	 * @see org.eclipse.emf.ocl.types.AnyType
	 * @generated
	 */
	EClass getAnyType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.BagType <em>Bag Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.eclipse.emf.ocl.types.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.eclipse.emf.ocl.types.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.types.CollectionType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipse.emf.ocl.types.CollectionType#getElementType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.OrderedSetType <em>Ordered Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.eclipse.emf.ocl.types.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.PrimitiveBoolean <em>Primitive Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Boolean</em>'.
	 * @see org.eclipse.emf.ocl.types.PrimitiveBoolean
	 * @generated
	 */
	EClass getPrimitiveBoolean();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.PrimitiveInteger <em>Primitive Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Integer</em>'.
	 * @see org.eclipse.emf.ocl.types.PrimitiveInteger
	 * @generated
	 */
	EClass getPrimitiveInteger();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.PrimitiveReal <em>Primitive Real</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Real</em>'.
	 * @see org.eclipse.emf.ocl.types.PrimitiveReal
	 * @generated
	 */
	EClass getPrimitiveReal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.PrimitiveString <em>Primitive String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive String</em>'.
	 * @see org.eclipse.emf.ocl.types.PrimitiveString
	 * @generated
	 */
	EClass getPrimitiveString();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipse.emf.ocl.types.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.SequenceType <em>Sequence Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.eclipse.emf.ocl.types.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.eclipse.emf.ocl.types.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.TupleType <em>Tuple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.eclipse.emf.ocl.types.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.VoidType <em>Void Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.eclipse.emf.ocl.types.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Type</em>'.
	 * @see org.eclipse.emf.ocl.types.MessageType
	 * @generated
	 */
	EClass getMessageType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.types.MessageType#getReferredSignal <em>Referred Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Signal</em>'.
	 * @see org.eclipse.emf.ocl.types.MessageType#getReferredSignal()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredSignal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ocl.types.MessageType#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.emf.ocl.types.MessageType#getReferredOperation()
	 * @see #getMessageType()
	 * @generated
	 */
	EReference getMessageType_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.ModelElementType <em>Model Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element Type</em>'.
	 * @see org.eclipse.emf.ocl.types.ModelElementType
	 * @generated
	 */
	EClass getModelElementType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ocl.types.OclState <em>Ocl State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl State</em>'.
	 * @see org.eclipse.emf.ocl.types.OclState
	 * @generated
	 */
	EClass getOclState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

} //TypesPackage
