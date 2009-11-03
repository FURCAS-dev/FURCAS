/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.model.types.TypesPackage;

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
 * @see org.oslo.ocl20.semantics.bridge.BridgeFactory
 * @model kind="package"
 * @generated
 */
public interface BridgePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "bridge";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "urn:semantics.bridge.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "semantics.bridge";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	BridgePackage eINSTANCE = org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.ModelElementImpl
	 * <em>Model Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.ModelElementImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getModelElement()
	 * @generated
	 */
	int MODEL_ELEMENT = 10;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__TAG = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT__NAME = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_ELEMENT_FEATURE_COUNT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.CallActionImpl
	 * <em>Call Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.CallActionImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getCallAction()
	 * @generated
	 */
	int CALL_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_ACTION__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_ACTION__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_ACTION__OPERATION = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Action</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_ACTION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.NamespaceImpl
	 * <em>Namespace</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.NamespaceImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 12;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAMESPACE = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl
	 * <em>Classifier</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 1;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__TAG = NAMESPACE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAMESPACE = NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__OPERATIONS = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__PROCESSOR = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__PROPERTIES = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.DataTypeImpl
	 * <em>Data Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.DataTypeImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__TAG = CLASSIFIER__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAMESPACE = CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__OPERATIONS = CLASSIFIER__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PROCESSOR = CLASSIFIER__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PROPERTIES = CLASSIFIER__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.DefinedClassImpl
	 * <em>Defined Class</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.DefinedClassImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDefinedClass()
	 * @generated
	 */
	int DEFINED_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__TAG = CLASSIFIER__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__NAMESPACE = CLASSIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__OPERATIONS = CLASSIFIER__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__PROCESSOR = CLASSIFIER__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__PROPERTIES = CLASSIFIER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__OWNED_OPERATION = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS__PACKAGE = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Defined Class</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.OperationImpl
	 * <em>Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.OperationImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 14;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_PARAMETER = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION__RETURN_TYPE = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.DefinedOperationImpl
	 * <em>Defined Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.DefinedOperationImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDefinedOperation()
	 * @generated
	 */
	int DEFINED_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__TAG = OPERATION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__NAME = OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__OWNED_PARAMETER = OPERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__RETURN_TYPE = OPERATION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__CLASS = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION__RAISED_EXCEPTION = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Defined Operation</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.DefinedPackageImpl
	 * <em>Defined Package</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.DefinedPackageImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDefinedPackage()
	 * @generated
	 */
	int DEFINED_PACKAGE = 5;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PACKAGE__TAG = NAMESPACE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PACKAGE__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PACKAGE__NAMESPACE = NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PACKAGE__OWNED_TYPE = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Package</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEFINED_PACKAGE_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.ElementImpl
	 * <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.ElementImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT__TAG = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.PropertyImpl
	 * <em>Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.PropertyImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 17;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.EnumLiteralImpl
	 * <em>Enum Literal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.EnumLiteralImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 7;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__TAG = PROPERTY__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__TYPE = PROPERTY__TYPE;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__ENUMERATION = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.EnumerationImpl
	 * <em>Enumeration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.EnumerationImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 8;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__TAG = DATA_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAMESPACE = DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OPERATIONS = DATA_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__PROCESSOR = DATA_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__PROPERTIES = DATA_TYPE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERAL = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl
	 * <em>Environment</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 9;

	/**
	 * The feature id for the '<em><b>Bridge Factory</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BRIDGE_FACTORY = 0;

	/**
	 * The feature id for the '<em><b>Named Element Entrys</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NAMED_ELEMENT_ENTRYS = 1;

	/**
	 * The feature id for the '<em><b>Namespaces</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NAMESPACES = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__PARENT = 3;

	/**
	 * The number of structural features of the '<em>Environment</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl
	 * <em>Named Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__TAG = ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>May Be Implicit</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MAY_BE_IMPLICIT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Element</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__REFERRED_ELEMENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.bridge.impl.OclModelElementTypeImpl
	 * <em>Ocl Model Element Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.OclModelElementTypeImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getOclModelElementType()
	 * @generated
	 */
	int OCL_MODEL_ELEMENT_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE__TAG = TypesPackage.OCL_ANY_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE__NAME = TypesPackage.OCL_ANY_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE__NAMESPACE = TypesPackage.OCL_ANY_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE__OPERATIONS = TypesPackage.OCL_ANY_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE__PROCESSOR = TypesPackage.OCL_ANY_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE__PROPERTIES = TypesPackage.OCL_ANY_TYPE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Ocl Model Element Type</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MODEL_ELEMENT_TYPE_FEATURE_COUNT = TypesPackage.OCL_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.ParameterImpl
	 * <em>Parameter</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.ParameterImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 15;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER__OPERATION = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.PrimitiveImpl
	 * <em>Primitive</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.PrimitiveImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 16;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__TAG = TypesPackage.OCL_ANY_TYPE__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__NAME = TypesPackage.OCL_ANY_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__NAMESPACE = TypesPackage.OCL_ANY_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__OPERATIONS = TypesPackage.OCL_ANY_TYPE__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__PROCESSOR = TypesPackage.OCL_ANY_TYPE__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE__PROPERTIES = TypesPackage.OCL_ANY_TYPE__PROPERTIES;

	/**
	 * The number of structural features of the '<em>Primitive</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_FEATURE_COUNT = TypesPackage.OCL_ANY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.SendActionImpl
	 * <em>Send Action</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.SendActionImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getSendAction()
	 * @generated
	 */
	int SEND_ACTION = 18;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__SIGNAL = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Send Action</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.SignalImpl
	 * <em>Signal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.SignalImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getSignal()
	 * @generated
	 */
	int SIGNAL = 19;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIGNAL__TAG = MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIGNAL__NAME = MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameter Names</b></em>' attribute list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIGNAL__PARAMETER_NAMES = MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIGNAL__PARAMETER_TYPES = MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Signal</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIGNAL_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.bridge.impl.TagImpl <em>Tag</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.bridge.impl.TagImpl
	 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getTag()
	 * @generated
	 */
	int TAG = 20;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG__TAG = ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG__VALUE = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG__ELEMENT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tag</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.CallAction
	 * <em>Call Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Call Action</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.CallAction
	 * @generated
	 */
	EClass getCallAction();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.CallAction#getOperation <em>Operation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.CallAction#getOperation()
	 * @see #getCallAction()
	 * @generated
	 */
	EReference getCallAction_Operation();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Classifier
	 * <em>Classifier</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.oslo.ocl20.semantics.bridge.Classifier#getOperations <em>Operations</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Operations</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Classifier#getOperations()
	 * @see #getClassifier()
	 * @generated
	 */
	EAttribute getClassifier_Operations();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.Classifier#getProcessor <em>Processor</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Processor</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Classifier#getProcessor()
	 * @see #getClassifier()
	 * @generated
	 */
	EAttribute getClassifier_Processor();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Classifier#getProperties <em>Properties</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Classifier#getProperties()
	 * @see #getClassifier()
	 * @generated
	 */
	EReference getClassifier_Properties();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.DataType
	 * <em>Data Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.DefinedClass
	 * <em>Defined Class</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Defined Class</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedClass
	 * @generated
	 */
	EClass getDefinedClass();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedClass#getOwnedOperation
	 * <em>Owned Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Owned Operation</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedClass#getOwnedOperation()
	 * @see #getDefinedClass()
	 * @generated
	 */
	EReference getDefinedClass_OwnedOperation();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedClass#getPackage <em>Package</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Package</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedClass#getPackage()
	 * @see #getDefinedClass()
	 * @generated
	 */
	EReference getDefinedClass_Package();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.DefinedOperation
	 * <em>Defined Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Defined Operation</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedOperation
	 * @generated
	 */
	EClass getDefinedOperation();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedOperation#getClass_ <em>Class</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Class</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedOperation#getClass_()
	 * @see #getDefinedOperation()
	 * @generated
	 */
	EReference getDefinedOperation_Class();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedOperation#getRaisedException
	 * <em>Raised Exception</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Raised Exception</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedOperation#getRaisedException()
	 * @see #getDefinedOperation()
	 * @generated
	 */
	EReference getDefinedOperation_RaisedException();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.DefinedPackage
	 * <em>Defined Package</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Defined Package</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedPackage
	 * @generated
	 */
	EClass getDefinedPackage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.DefinedPackage#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Owned Type</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.DefinedPackage#getOwnedType()
	 * @see #getDefinedPackage()
	 * @generated
	 */
	EReference getDefinedPackage_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Element
	 * <em>Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Element#getTag <em>Tag</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Tag</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Element#getTag()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Tag();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.EnumLiteral
	 * <em>Enum Literal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.bridge.EnumLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.EnumLiteral#getEnumeration()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EReference getEnumLiteral_Enumeration();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Enumeration
	 * <em>Enumeration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Enumeration#getLiteral <em>Literal</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Literal</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Enumeration#getLiteral()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literal();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Environment
	 * <em>Environment</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.Environment#getBridgeFactory <em>Bridge Factory</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Bridge Factory</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Environment#getBridgeFactory()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_BridgeFactory();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.Environment#getNamedElementEntrys
	 * <em>Named Element Entrys</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Named Element Entrys</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Environment#getNamedElementEntrys()
	 * @see #getEnvironment()
	 * @generated
	 */
	EAttribute getEnvironment_NamedElementEntrys();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Environment#getNamespaces <em>Namespaces</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Namespaces</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Environment#getNamespaces()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Namespaces();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.Environment#getParent <em>Parent</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Environment#getParent()
	 * @see #getEnvironment()
	 * @generated
	 */
	EReference getEnvironment_Parent();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.ModelElement
	 * <em>Model Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.ModelElement
	 * @generated
	 */
	EClass getModelElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.ModelElement#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.ModelElement#getName()
	 * @see #getModelElement()
	 * @generated
	 */
	EAttribute getModelElement_Name();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.NamedElement
	 * <em>Named Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.NamedElement#getMayBeImplicit
	 * <em>May Be Implicit</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>May Be Implicit</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.NamedElement#getMayBeImplicit()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_MayBeImplicit();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.NamedElement#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.NamedElement#getReferredElement
	 * <em>Referred Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Element</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.NamedElement#getReferredElement()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_ReferredElement();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Namespace
	 * <em>Namespace</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.Namespace#getNamespace <em>Namespace</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Namespace#getNamespace()
	 * @see #getNamespace()
	 * @generated
	 */
	EReference getNamespace_Namespace();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.bridge.OclModelElementType <em>Ocl Model Element Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Model Element Type</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.OclModelElementType
	 * @generated
	 */
	EClass getOclModelElementType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Operation
	 * <em>Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Operation#getOwnedParameter <em>Owned Parameter</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Owned Parameter</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Operation#getOwnedParameter()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedParameter();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.Operation#getReturnType <em>Return Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Return Type</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Operation#getReturnType()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Parameter
	 * <em>Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.Parameter#getType <em>Type</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.bridge.Parameter#getOperation <em>Operation</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Operation</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Parameter#getOperation()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Operation();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Primitive
	 * <em>Primitive</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Primitive</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Primitive
	 * @generated
	 */
	EClass getPrimitive();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Property
	 * <em>Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.Property#getType <em>Type</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.SendAction
	 * <em>Send Action</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Send Action</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.SendAction
	 * @generated
	 */
	EClass getSendAction();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.bridge.SendAction#getSignal <em>Signal</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Signal</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.SendAction#getSignal()
	 * @see #getSendAction()
	 * @generated
	 */
	EReference getSendAction_Signal();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Signal
	 * <em>Signal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Signal</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Signal
	 * @generated
	 */
	EClass getSignal();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link org.oslo.ocl20.semantics.bridge.Signal#getParameterNames <em>Parameter Names</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Parameter Names</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Signal#getParameterNames()
	 * @see #getSignal()
	 * @generated
	 */
	EAttribute getSignal_ParameterNames();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Signal#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Parameter Types</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Signal#getParameterTypes()
	 * @see #getSignal()
	 * @generated
	 */
	EReference getSignal_ParameterTypes();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.bridge.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.Tag#getName <em>Name</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Tag#getName()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.bridge.Tag#getValue <em>Value</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Tag#getValue()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Value();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.bridge.Tag#getElement <em>Element</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Element</em>'.
	 * @see org.oslo.ocl20.semantics.bridge.Tag#getElement()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Element();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BridgeFactory getBridgeFactory();

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
		 * {@link org.oslo.ocl20.semantics.bridge.impl.CallActionImpl <em>Call Action</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.CallActionImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getCallAction()
		 * @generated
		 */
		EClass CALL_ACTION = eINSTANCE.getCallAction();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CALL_ACTION__OPERATION = eINSTANCE.getCallAction_Operation();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.ClassifierImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CLASSIFIER__OPERATIONS = eINSTANCE.getClassifier_Operations();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CLASSIFIER__PROCESSOR = eINSTANCE.getClassifier_Processor();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CLASSIFIER__PROPERTIES = eINSTANCE.getClassifier_Properties();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.DataTypeImpl <em>Data Type</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.DataTypeImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.DefinedClassImpl <em>Defined Class</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.DefinedClassImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDefinedClass()
		 * @generated
		 */
		EClass DEFINED_CLASS = eINSTANCE.getDefinedClass();

		/**
		 * The meta object literal for the '<em><b>Owned Operation</b></em>' containment reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_CLASS__OWNED_OPERATION = eINSTANCE.getDefinedClass_OwnedOperation();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_CLASS__PACKAGE = eINSTANCE.getDefinedClass_Package();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.DefinedOperationImpl
		 * <em>Defined Operation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.DefinedOperationImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDefinedOperation()
		 * @generated
		 */
		EClass DEFINED_OPERATION = eINSTANCE.getDefinedOperation();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_OPERATION__CLASS = eINSTANCE.getDefinedOperation_Class();

		/**
		 * The meta object literal for the '<em><b>Raised Exception</b></em>' reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_OPERATION__RAISED_EXCEPTION = eINSTANCE.getDefinedOperation_RaisedException();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.DefinedPackageImpl <em>Defined Package</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.DefinedPackageImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getDefinedPackage()
		 * @generated
		 */
		EClass DEFINED_PACKAGE = eINSTANCE.getDefinedPackage();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEFINED_PACKAGE__OWNED_TYPE = eINSTANCE.getDefinedPackage_OwnedType();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.semantics.bridge.impl.ElementImpl
		 * <em>Element</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.ElementImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ELEMENT__TAG = eINSTANCE.getElement_Tag();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.EnumLiteralImpl <em>Enum Literal</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.EnumLiteralImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUM_LITERAL__ENUMERATION = eINSTANCE.getEnumLiteral_Enumeration();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.EnumerationImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUMERATION__LITERAL = eINSTANCE.getEnumeration_Literal();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.EnvironmentImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '<em><b>Bridge Factory</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENVIRONMENT__BRIDGE_FACTORY = eINSTANCE.getEnvironment_BridgeFactory();

		/**
		 * The meta object literal for the '<em><b>Named Element Entrys</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENVIRONMENT__NAMED_ELEMENT_ENTRYS = eINSTANCE.getEnvironment_NamedElementEntrys();

		/**
		 * The meta object literal for the '<em><b>Namespaces</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENVIRONMENT__NAMESPACES = eINSTANCE.getEnvironment_Namespaces();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENVIRONMENT__PARENT = eINSTANCE.getEnvironment_Parent();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.ModelElementImpl <em>Model Element</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.ModelElementImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl <em>Named Element</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>May Be Implicit</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__MAY_BE_IMPLICIT = eINSTANCE.getNamedElement_MayBeImplicit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Referred Element</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAMED_ELEMENT__REFERRED_ELEMENT = eINSTANCE.getNamedElement_ReferredElement();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.NamespaceImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NAMESPACE__NAMESPACE = eINSTANCE.getNamespace_Namespace();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.OclModelElementTypeImpl
		 * <em>Ocl Model Element Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.OclModelElementTypeImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getOclModelElementType()
		 * @generated
		 */
		EClass OCL_MODEL_ELEMENT_TYPE = eINSTANCE.getOclModelElementType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.OperationImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Parameter</b></em>' containment reference
		 * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION__OWNED_PARAMETER = eINSTANCE.getOperation_OwnedParameter();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION__RETURN_TYPE = eINSTANCE.getOperation_ReturnType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.ParameterImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARAMETER__OPERATION = eINSTANCE.getParameter_Operation();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.PrimitiveImpl <em>Primitive</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.PrimitiveImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getPrimitive()
		 * @generated
		 */
		EClass PRIMITIVE = eINSTANCE.getPrimitive();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.PropertyImpl <em>Property</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.PropertyImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.bridge.impl.SendActionImpl <em>Send Action</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.SendActionImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getSendAction()
		 * @generated
		 */
		EClass SEND_ACTION = eINSTANCE.getSendAction();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SEND_ACTION__SIGNAL = eINSTANCE.getSendAction_Signal();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.semantics.bridge.impl.SignalImpl
		 * <em>Signal</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.SignalImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getSignal()
		 * @generated
		 */
		EClass SIGNAL = eINSTANCE.getSignal();

		/**
		 * The meta object literal for the '<em><b>Parameter Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SIGNAL__PARAMETER_NAMES = eINSTANCE.getSignal_ParameterNames();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIGNAL__PARAMETER_TYPES = eINSTANCE.getSignal_ParameterTypes();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.semantics.bridge.impl.TagImpl
		 * <em>Tag</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.bridge.impl.TagImpl
		 * @see org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TAG__NAME = eINSTANCE.getTag_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TAG__VALUE = eINSTANCE.getTag_Value();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TAG__ELEMENT = eINSTANCE.getTag_Element();

	}

} // BridgePackage
