/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBaseFactory
 * @model kind="package"
 * @generated
 */
public interface QvtBasePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "qvtbase";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "urn:semanticsQvt.model.qvtbase.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "semanticsQvt.model.qvtbase";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	QvtBasePackage eINSTANCE = de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl <em>Domain</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__TAG = BridgePackage.NAMED_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>May Be Implicit</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__MAY_BE_IMPLICIT = BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__NAME = BridgePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Referred Element</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__REFERRED_ELEMENT = BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__IS_CHECKABLE = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Enforcable</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__IS_ENFORCABLE = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN__TYPED_MODEL = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionImpl <em>Function</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.FunctionImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 1;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__TAG = BridgePackage.DEFINED_OPERATION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = BridgePackage.DEFINED_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Parameter</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_PARAMETER = BridgePackage.DEFINED_OPERATION__OWNED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RETURN_TYPE = BridgePackage.DEFINED_OPERATION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Class</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__CLASS = BridgePackage.DEFINED_OPERATION__CLASS;

	/**
	 * The feature id for the '<em><b>Raised Exception</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RAISED_EXCEPTION = BridgePackage.DEFINED_OPERATION__RAISED_EXCEPTION;

	/**
	 * The feature id for the '<em><b>Query Expression</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION__QUERY_EXPRESSION = BridgePackage.DEFINED_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = BridgePackage.DEFINED_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl <em>Function Parameter</em>}' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getFunctionParameter()
	 * @generated
	 */
	int FUNCTION_PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__TAG = BridgePackage.PARAMETER__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__NAME = BridgePackage.PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__OPERATION = BridgePackage.PARAMETER__OPERATION;

	/**
	 * The feature id for the '<em><b>Variable Exps</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__VARIABLE_EXPS = BridgePackage.PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tuple Literal Exp</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__TUPLE_LITERAL_EXP = BridgePackage.PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Loop Expr</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__LOOP_EXPR = BridgePackage.PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__TYPE = BridgePackage.PARAMETER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__BASE_EXP = BridgePackage.PARAMETER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__INIT_EXPRESSION = BridgePackage.PARAMETER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Function Parameter</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER_FEATURE_COUNT = BridgePackage.PARAMETER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl <em>Pattern</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__TAG = BridgePackage.ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Where Owner</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__WHERE_OWNER = BridgePackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>When Owner</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__WHEN_OWNER = BridgePackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__PREDICATE = BridgePackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN__BINDS_TO = BridgePackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = BridgePackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl <em>Predicate</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 4;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PREDICATE__TAG = BridgePackage.ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Contition Expression</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PREDICATE__CONTITION_EXPRESSION = BridgePackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PREDICATE__PATTERN = BridgePackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = BridgePackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl <em>Rule</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getRule()
	 * @generated
	 */
	int RULE = 5;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__TAG = BridgePackage.NAMED_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>May Be Implicit</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__MAY_BE_IMPLICIT = BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = BridgePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Referred Element</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__REFERRED_ELEMENT = BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__DOMAIN = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__OVERRIDES = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overriden</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__OVERRIDEN = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE__TRANSFORMATION = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rule</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.TransformationImpl <em>Transformation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.TransformationImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 6;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__TAG = BridgePackage.DEFINED_CLASS__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = BridgePackage.DEFINED_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAMESPACE = BridgePackage.DEFINED_CLASS__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OPERATIONS = BridgePackage.DEFINED_CLASS__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__PROCESSOR = BridgePackage.DEFINED_CLASS__PROCESSOR;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__PROPERTIES = BridgePackage.DEFINED_CLASS__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Operation</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_OPERATION = BridgePackage.DEFINED_CLASS__OWNED_OPERATION;

	/**
	 * The feature id for the '<em><b>Package</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__PACKAGE = BridgePackage.DEFINED_CLASS__PACKAGE;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_TYPE = BridgePackage.DEFINED_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Tag</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_TAG = BridgePackage.DEFINED_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__MODEL_PARAMETER = BridgePackage.DEFINED_CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__EXTENDS = BridgePackage.DEFINED_CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__RULE = BridgePackage.DEFINED_CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = BridgePackage.DEFINED_CLASS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl <em>Typed Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl
	 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getTypedModel()
	 * @generated
	 */
	int TYPED_MODEL = 7;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__TAG = BridgePackage.NAMED_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>May Be Implicit</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__MAY_BE_IMPLICIT = BridgePackage.NAMED_ELEMENT__MAY_BE_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__NAME = BridgePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Referred Element</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__REFERRED_ELEMENT = BridgePackage.NAMED_ELEMENT__REFERRED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__DEPENDS_ON = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Used Package</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__USED_PACKAGE = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL_FEATURE_COUNT = BridgePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.Domain <em>Domain</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.qvt.model.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Is Checkable</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Domain#isIsCheckable()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_IsCheckable();

	/**
	 * Returns the meta object for the attribute '{@link de.ikv.medini.qvt.model.qvtbase.Domain#isIsEnforcable <em>Is Enforcable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Is Enforcable</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Domain#isIsEnforcable()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_IsEnforcable();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvtbase.Domain#getTypedModel <em>Typed Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Domain#getTypedModel()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_TypedModel();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.Function <em>Function</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference '{@link de.ikv.medini.qvt.model.qvtbase.Function#getQueryExpression <em>Query Expression</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Query Expression</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Function#getQueryExpression()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_QueryExpression();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.FunctionParameter <em>Function Parameter</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Function Parameter</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.FunctionParameter
	 * @generated
	 */
	EClass getFunctionParameter();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.Pattern <em>Pattern</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the container reference '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhereOwner <em>Where Owner</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Where Owner</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getWhereOwner()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_WhereOwner();

	/**
	 * Returns the meta object for the container reference '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhenOwner <em>When Owner</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>When Owner</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getWhenOwner()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_WhenOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getPredicate <em>Predicate</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Predicate</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getPredicate()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Predicate();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getBindsTo <em>Binds To</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '<em>Binds To</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getBindsTo()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_BindsTo();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.Predicate <em>Predicate</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getContitionExpression <em>Contition Expression</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Contition Expression</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Predicate#getContitionExpression()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_ContitionExpression();

	/**
	 * Returns the meta object for the container reference '{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getPattern <em>Pattern</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Predicate#getPattern()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Pattern();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.Rule <em>Rule</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getDomain <em>Domain</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Domain</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getDomain()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Domain();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverrides <em>Overrides</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Overrides</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getOverrides()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Overrides();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getOverriden <em>Overriden</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference list '<em>Overriden</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getOverriden()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Overriden();

	/**
	 * Returns the meta object for the container reference '{@link de.ikv.medini.qvt.model.qvtbase.Rule#getTransformation <em>Transformation</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Rule#getTransformation()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Transformation();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.Transformation <em>Transformation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getOwnedTag <em>Owned Tag</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Owned Tag</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation#getOwnedTag()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_OwnedTag();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getModelParameter <em>Model Parameter</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Model Parameter</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation#getModelParameter()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_ModelParameter();

	/**
	 * Returns the meta object for the reference '{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getExtends <em>Extends</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Extends</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation#getExtends()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link de.ikv.medini.qvt.model.qvtbase.Transformation#getRule <em>Rule</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.Transformation#getRule()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Rule();

	/**
	 * Returns the meta object for class '{@link de.ikv.medini.qvt.model.qvtbase.TypedModel <em>Typed Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Typed Model</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.TypedModel
	 * @generated
	 */
	EClass getTypedModel();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.qvt.model.qvtbase.TypedModel#getDependsOn <em>Depends On</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.TypedModel#getDependsOn()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_DependsOn();

	/**
	 * Returns the meta object for the reference list '{@link de.ikv.medini.qvt.model.qvtbase.TypedModel#getUsedPackage <em>Used Package</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Used Package</em>'.
	 * @see de.ikv.medini.qvt.model.qvtbase.TypedModel#getUsedPackage()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_UsedPackage();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QvtBaseFactory getQvtBaseFactory();

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
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl <em>Domain</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.DomainImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = QvtBasePackage.eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Is Checkable</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN__IS_CHECKABLE = QvtBasePackage.eINSTANCE.getDomain_IsCheckable();

		/**
		 * The meta object literal for the '<em><b>Is Enforcable</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DOMAIN__IS_ENFORCABLE = QvtBasePackage.eINSTANCE.getDomain_IsEnforcable();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DOMAIN__TYPED_MODEL = QvtBasePackage.eINSTANCE.getDomain_TypedModel();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionImpl <em>Function</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.FunctionImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = QvtBasePackage.eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Query Expression</b></em>' containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FUNCTION__QUERY_EXPRESSION = QvtBasePackage.eINSTANCE.getFunction_QueryExpression();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl <em>Function Parameter</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.FunctionParameterImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getFunctionParameter()
		 * @generated
		 */
		EClass FUNCTION_PARAMETER = QvtBasePackage.eINSTANCE.getFunctionParameter();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl <em>Pattern</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.PatternImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = QvtBasePackage.eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Where Owner</b></em>' container reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PATTERN__WHERE_OWNER = QvtBasePackage.eINSTANCE.getPattern_WhereOwner();

		/**
		 * The meta object literal for the '<em><b>When Owner</b></em>' container reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PATTERN__WHEN_OWNER = QvtBasePackage.eINSTANCE.getPattern_WhenOwner();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PATTERN__PREDICATE = QvtBasePackage.eINSTANCE.getPattern_Predicate();

		/**
		 * The meta object literal for the '<em><b>Binds To</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PATTERN__BINDS_TO = QvtBasePackage.eINSTANCE.getPattern_BindsTo();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl <em>Predicate</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = QvtBasePackage.eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Contition Expression</b></em>' containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PREDICATE__CONTITION_EXPRESSION = QvtBasePackage.eINSTANCE.getPredicate_ContitionExpression();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PREDICATE__PATTERN = QvtBasePackage.eINSTANCE.getPredicate_Pattern();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl <em>Rule</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = QvtBasePackage.eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RULE__DOMAIN = QvtBasePackage.eINSTANCE.getRule_Domain();

		/**
		 * The meta object literal for the '<em><b>Overrides</b></em>' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RULE__OVERRIDES = QvtBasePackage.eINSTANCE.getRule_Overrides();

		/**
		 * The meta object literal for the '<em><b>Overriden</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RULE__OVERRIDEN = QvtBasePackage.eINSTANCE.getRule_Overriden();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RULE__TRANSFORMATION = QvtBasePackage.eINSTANCE.getRule_Transformation();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.TransformationImpl <em>Transformation</em>}' class. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.TransformationImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = QvtBasePackage.eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Owned Tag</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSFORMATION__OWNED_TAG = QvtBasePackage.eINSTANCE.getTransformation_OwnedTag();

		/**
		 * The meta object literal for the '<em><b>Model Parameter</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSFORMATION__MODEL_PARAMETER = QvtBasePackage.eINSTANCE.getTransformation_ModelParameter();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSFORMATION__EXTENDS = QvtBasePackage.eINSTANCE.getTransformation_Extends();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSFORMATION__RULE = QvtBasePackage.eINSTANCE.getTransformation_Rule();

		/**
		 * The meta object literal for the '{@link de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl <em>Typed Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.TypedModelImpl
		 * @see de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl#getTypedModel()
		 * @generated
		 */
		EClass TYPED_MODEL = QvtBasePackage.eINSTANCE.getTypedModel();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TYPED_MODEL__DEPENDS_ON = QvtBasePackage.eINSTANCE.getTypedModel_DependsOn();

		/**
		 * The meta object literal for the '<em><b>Used Package</b></em>' reference list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TYPED_MODEL__USED_PACKAGE = QvtBasePackage.eINSTANCE.getTypedModel_UsedPackage();

	}

} // QvtBasePackage
