/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.types;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.types.TypesFactory
 * @model kind="package"
 * @generated
 */
public interface TypesPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "urn:semantics.model.types.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "semantics.model.types";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	TypesPackage eINSTANCE = org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.types.impl.CollectionTypeImpl <em>Collection Type</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.CollectionTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__TAG = BridgePackage.DATA_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = BridgePackage.DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAMESPACE = BridgePackage.DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__OPERATIONS = BridgePackage.DATA_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PROCESSOR = BridgePackage.DATA_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PROPERTIES = BridgePackage.DATA_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ELEMENT_TYPE = BridgePackage.DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = BridgePackage.DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.BagTypeImpl
	 * <em>Bag Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.BagTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getBagType()
	 * @generated
	 */
	int BAG_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__TAG = COLLECTION_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__OPERATIONS = COLLECTION_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__PROCESSOR = COLLECTION_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__PROPERTIES = COLLECTION_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Bag Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BAG_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.OclAnyTypeImpl
	 * <em>Ocl Any Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.OclAnyTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getOclAnyType()
	 * @generated
	 */
	int OCL_ANY_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE__TAG = BridgePackage.DATA_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE__NAME = BridgePackage.DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE__NAMESPACE = BridgePackage.DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE__OPERATIONS = BridgePackage.DATA_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE__PROCESSOR = BridgePackage.DATA_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE__PROPERTIES = BridgePackage.DATA_TYPE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Ocl Any Type</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_ANY_TYPE_FEATURE_COUNT = BridgePackage.DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.BooleanTypeImpl
	 * <em>Boolean Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.BooleanTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__TAG = BridgePackage.PRIMITIVE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAME = BridgePackage.PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAMESPACE = BridgePackage.PRIMITIVE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__OPERATIONS = BridgePackage.PRIMITIVE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__PROCESSOR = BridgePackage.PRIMITIVE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__PROPERTIES = BridgePackage.PRIMITIVE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = BridgePackage.PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.RealTypeImpl
	 * <em>Real Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.RealTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__TAG = BridgePackage.PRIMITIVE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__NAME = BridgePackage.PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__NAMESPACE = BridgePackage.PRIMITIVE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__OPERATIONS = BridgePackage.PRIMITIVE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__PROCESSOR = BridgePackage.PRIMITIVE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__PROPERTIES = BridgePackage.PRIMITIVE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = BridgePackage.PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.IntegerTypeImpl
	 * <em>Integer Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.IntegerTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__TAG = REAL_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__NAME = REAL_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__NAMESPACE = REAL_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__OPERATIONS = REAL_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__PROCESSOR = REAL_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__PROPERTIES = REAL_TYPE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = REAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.types.impl.OclMessageTypeImpl
	 * <em>Ocl Message Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.OclMessageTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getOclMessageType()
	 * @generated
	 */
	int OCL_MESSAGE_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE__TAG = BridgePackage.CLASSIFIER__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE__NAME = BridgePackage.CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE__NAMESPACE = BridgePackage.CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE__OPERATIONS = BridgePackage.CLASSIFIER__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE__PROCESSOR = BridgePackage.CLASSIFIER__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE__PROPERTIES = BridgePackage.CLASSIFIER__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Ocl Message Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_TYPE_FEATURE_COUNT = BridgePackage.CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.types.impl.OrderedSetTypeImpl
	 * <em>Ordered Set Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.OrderedSetTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getOrderedSetType()
	 * @generated
	 */
	int ORDERED_SET_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__TAG = COLLECTION_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__OPERATIONS = COLLECTION_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__PROCESSOR = COLLECTION_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__PROPERTIES = COLLECTION_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Ordered Set Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDERED_SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.types.impl.SequenceTypeImpl <em>Sequence Type</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.SequenceTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getSequenceType()
	 * @generated
	 */
	int SEQUENCE_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__TAG = COLLECTION_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__OPERATIONS = COLLECTION_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__PROCESSOR = COLLECTION_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__PROPERTIES = COLLECTION_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Sequence Type</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.SetTypeImpl
	 * <em>Set Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.SetTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__TAG = COLLECTION_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAMESPACE = COLLECTION_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__OPERATIONS = COLLECTION_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PROCESSOR = COLLECTION_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PROPERTIES = COLLECTION_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ELEMENT_TYPE = COLLECTION_TYPE__ELEMENT_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.StringTypeImpl
	 * <em>String Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.StringTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__TAG = BridgePackage.PRIMITIVE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAME = BridgePackage.PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAMESPACE = BridgePackage.PRIMITIVE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__OPERATIONS = BridgePackage.PRIMITIVE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__PROCESSOR = BridgePackage.PRIMITIVE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__PROPERTIES = BridgePackage.PRIMITIVE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>String Type</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = BridgePackage.PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.TupleTypeImpl
	 * <em>Tuple Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.TupleTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getTupleType()
	 * @generated
	 */
	int TUPLE_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__TAG = BridgePackage.DATA_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAME = BridgePackage.DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__NAMESPACE = BridgePackage.DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__OPERATIONS = BridgePackage.DATA_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PROCESSOR = BridgePackage.DATA_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PROPERTIES = BridgePackage.DATA_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Part Type</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE__PART_TYPE = BridgePackage.DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_FEATURE_COUNT = BridgePackage.DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.TypeTypeImpl
	 * <em>Type Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypeTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getTypeType()
	 * @generated
	 */
	int TYPE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__TAG = BridgePackage.PRIMITIVE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__NAME = BridgePackage.PRIMITIVE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__NAMESPACE = BridgePackage.PRIMITIVE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__OPERATIONS = BridgePackage.PRIMITIVE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__PROCESSOR = BridgePackage.PRIMITIVE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE__PROPERTIES = BridgePackage.PRIMITIVE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Type Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_TYPE_FEATURE_COUNT = BridgePackage.PRIMITIVE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.types.impl.VoidTypeImpl
	 * <em>Void Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.types.impl.VoidTypeImpl
	 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getVoidType()
	 * @generated
	 */
	int VOID_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__TAG = STRING_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAME = STRING_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__NAMESPACE = STRING_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__OPERATIONS = STRING_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__PROCESSOR = STRING_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__PROPERTIES = STRING_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE__ELEMENT_TYPE = STRING_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Void Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VOID_TYPE_FEATURE_COUNT = STRING_TYPE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.BagType
	 * <em>Bag Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Bag Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.BagType
	 * @generated
	 */
	EClass getBagType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.BooleanType
	 * <em>Boolean Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.types.CollectionType <em>Collection Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.types.CollectionType#getElementType
	 * <em>Element Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.CollectionType#getElementType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_ElementType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.IntegerType
	 * <em>Integer Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.OclAnyType
	 * <em>Ocl Any Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Any Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.OclAnyType
	 * @generated
	 */
	EClass getOclAnyType();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.types.OclMessageType <em>Ocl Message Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Message Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.OclMessageType
	 * @generated
	 */
	EClass getOclMessageType();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.types.OrderedSetType <em>Ordered Set Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ordered Set Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.OrderedSetType
	 * @generated
	 */
	EClass getOrderedSetType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.RealType
	 * <em>Real Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.SequenceType
	 * <em>Sequence Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sequence Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.SequenceType
	 * @generated
	 */
	EClass getSequenceType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.SetType
	 * <em>Set Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.StringType
	 * <em>String Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.TupleType
	 * <em>Tuple Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tuple Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.TupleType
	 * @generated
	 */
	EClass getTupleType();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.model.types.TupleType#getPartType <em>Part Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Part Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.TupleType#getPartType()
	 * @see #getTupleType()
	 * @generated
	 */
	EReference getTupleType_PartType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.TypeType
	 * <em>Type Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.TypeType
	 * @generated
	 */
	EClass getTypeType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.types.VoidType
	 * <em>Void Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Void Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.types.VoidType
	 * @generated
	 */
	EClass getVoidType();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.BagTypeImpl <em>Bag Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.BagTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getBagType()
		 * @generated
		 */
		EClass BAG_TYPE = eINSTANCE.getBagType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.BooleanTypeImpl <em>Boolean Type</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.BooleanTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.CollectionTypeImpl
		 * <em>Collection Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.CollectionTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_TYPE__ELEMENT_TYPE = eINSTANCE.getCollectionType_ElementType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.IntegerTypeImpl <em>Integer Type</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.IntegerTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.OclAnyTypeImpl <em>Ocl Any Type</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.OclAnyTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getOclAnyType()
		 * @generated
		 */
		EClass OCL_ANY_TYPE = eINSTANCE.getOclAnyType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.OclMessageTypeImpl
		 * <em>Ocl Message Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.OclMessageTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getOclMessageType()
		 * @generated
		 */
		EClass OCL_MESSAGE_TYPE = eINSTANCE.getOclMessageType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.OrderedSetTypeImpl
		 * <em>Ordered Set Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.OrderedSetTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getOrderedSetType()
		 * @generated
		 */
		EClass ORDERED_SET_TYPE = eINSTANCE.getOrderedSetType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.RealTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.SequenceTypeImpl <em>Sequence Type</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.SequenceTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getSequenceType()
		 * @generated
		 */
		EClass SEQUENCE_TYPE = eINSTANCE.getSequenceType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.SetTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.StringTypeImpl <em>String Type</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.StringTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.TupleTypeImpl <em>Tuple Type</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.TupleTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getTupleType()
		 * @generated
		 */
		EClass TUPLE_TYPE = eINSTANCE.getTupleType();

		/**
		 * The meta object literal for the '<em><b>Part Type</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TUPLE_TYPE__PART_TYPE = eINSTANCE.getTupleType_PartType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.TypeTypeImpl <em>Type Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypeTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getTypeType()
		 * @generated
		 */
		EClass TYPE_TYPE = eINSTANCE.getTypeType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.types.impl.VoidTypeImpl <em>Void Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.types.impl.VoidTypeImpl
		 * @see org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl#getVoidType()
		 * @generated
		 */
		EClass VOID_TYPE = eINSTANCE.getVoidType();

	}

} // TypesPackage
