/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics;

import data.classes.ClassesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * <!-- begin-model-doc -->
 * Describes how types can be parameterized. Parameterizable types include classes and tuples. Classes can be declared to have a list of DataType arguments. Those arguments can then be used within a class definition wherever a DataType is allowed. If a type argument is a class, it may be used wherever a class is allowed.
 * <!-- end-model-doc -->
 * @see data.generics.GenericsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface GenericsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "generics";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///data/generics.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.generics";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	GenericsPackage eINSTANCE = data.generics.impl.GenericsPackageImpl.init();

	/**
     * The meta object id for the '{@link data.generics.impl.FormalTypeParameterImpl <em>Formal Type Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.generics.impl.FormalTypeParameterImpl
     * @see data.generics.impl.GenericsPackageImpl#getFormalTypeParameter()
     * @generated
     */
	int FORMAL_TYPE_PARAMETER = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__NAME = ClassesPackage.SAP_CLASS__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__DESCRIPTION = ClassesPackage.SAP_CLASS__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__OWNED_SIGNATURES = ClassesPackage.SAP_CLASS__OWNED_SIGNATURES;

	/**
     * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SUBSCRIPTIONS = ClassesPackage.SAP_CLASS__SUBSCRIPTIONS;

	/**
     * The feature id for the '<em><b>Notification Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__NOTIFICATION_SIGNATURES = ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES;

	/**
     * The feature id for the '<em><b>Subscription</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SUBSCRIPTION = ClassesPackage.SAP_CLASS__SUBSCRIPTION;

	/**
     * The feature id for the '<em><b>Sam Actions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SAM_ACTIONS = ClassesPackage.SAP_CLASS__SAM_ACTIONS;

	/**
     * The feature id for the '<em><b>Sam Status Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SAM_STATUS_VARIABLES = ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES;

	/**
     * The feature id for the '<em><b>Sam Derivators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SAM_DERIVATORS = ClassesPackage.SAP_CLASS__SAM_DERIVATORS;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SAM_STATUS_SCHEMA = ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA;

	/**
     * The feature id for the '<em><b>Behavioural Model</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__BEHAVIOURAL_MODEL = ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL;

	/**
     * The feature id for the '<em><b>Value Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__VALUE_TYPE = ClassesPackage.SAP_CLASS__VALUE_TYPE;

	/**
     * The feature id for the '<em><b>Signatures With Fault</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__SIGNATURES_WITH_FAULT = ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT;

	/**
     * The feature id for the '<em><b>Elements Of Type</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__ELEMENTS_OF_TYPE = ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE;

	/**
     * The feature id for the '<em><b>Package </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__PACKAGE_ = ClassesPackage.SAP_CLASS__PACKAGE_;

	/**
     * The feature id for the '<em><b>Adapted By</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__ADAPTED_BY = ClassesPackage.SAP_CLASS__ADAPTED_BY;

	/**
     * The feature id for the '<em><b>Adapters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__ADAPTERS = ClassesPackage.SAP_CLASS__ADAPTERS;

	/**
     * The feature id for the '<em><b>Formal Object Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__FORMAL_OBJECT_PARAMETERS = ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS;

	/**
     * The feature id for the '<em><b>Converter Between Parametrizations</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__CONVERTER_BETWEEN_PARAMETRIZATIONS = ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS;

	/**
     * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__CONSTRAINTS = ClassesPackage.SAP_CLASS__CONSTRAINTS;

	/**
     * The feature id for the '<em><b>Time Dependency</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__TIME_DEPENDENCY = ClassesPackage.SAP_CLASS__TIME_DEPENDENCY;

	/**
     * The feature id for the '<em><b>Parameterization</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__PARAMETERIZATION = ClassesPackage.SAP_CLASS__PARAMETERIZATION;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__ABAP_ANNOTATION = ClassesPackage.SAP_CLASS__ABAP_ANNOTATION;

	/**
     * The feature id for the '<em><b>Parameter Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__PARAMETER_OF = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type Constraint</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Actual Type Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Formal Type Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FORMAL_TYPE_PARAMETER_FEATURE_COUNT = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link data.generics.impl.ParameterizedClassInstantiationImpl <em>Parameterized Class Instantiation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.generics.impl.ParameterizedClassInstantiationImpl
     * @see data.generics.impl.GenericsPackageImpl#getParameterizedClassInstantiation()
     * @generated
     */
	int PARAMETERIZED_CLASS_INSTANTIATION = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__NAME = ClassesPackage.SAP_CLASS__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__DESCRIPTION = ClassesPackage.SAP_CLASS__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__OWNED_SIGNATURES = ClassesPackage.SAP_CLASS__OWNED_SIGNATURES;

	/**
     * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SUBSCRIPTIONS = ClassesPackage.SAP_CLASS__SUBSCRIPTIONS;

	/**
     * The feature id for the '<em><b>Notification Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__NOTIFICATION_SIGNATURES = ClassesPackage.SAP_CLASS__NOTIFICATION_SIGNATURES;

	/**
     * The feature id for the '<em><b>Subscription</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SUBSCRIPTION = ClassesPackage.SAP_CLASS__SUBSCRIPTION;

	/**
     * The feature id for the '<em><b>Sam Actions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SAM_ACTIONS = ClassesPackage.SAP_CLASS__SAM_ACTIONS;

	/**
     * The feature id for the '<em><b>Sam Status Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SAM_STATUS_VARIABLES = ClassesPackage.SAP_CLASS__SAM_STATUS_VARIABLES;

	/**
     * The feature id for the '<em><b>Sam Derivators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SAM_DERIVATORS = ClassesPackage.SAP_CLASS__SAM_DERIVATORS;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SAM_STATUS_SCHEMA = ClassesPackage.SAP_CLASS__SAM_STATUS_SCHEMA;

	/**
     * The feature id for the '<em><b>Behavioural Model</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__BEHAVIOURAL_MODEL = ClassesPackage.SAP_CLASS__BEHAVIOURAL_MODEL;

	/**
     * The feature id for the '<em><b>Value Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__VALUE_TYPE = ClassesPackage.SAP_CLASS__VALUE_TYPE;

	/**
     * The feature id for the '<em><b>Signatures With Fault</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__SIGNATURES_WITH_FAULT = ClassesPackage.SAP_CLASS__SIGNATURES_WITH_FAULT;

	/**
     * The feature id for the '<em><b>Elements Of Type</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__ELEMENTS_OF_TYPE = ClassesPackage.SAP_CLASS__ELEMENTS_OF_TYPE;

	/**
     * The feature id for the '<em><b>Package </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__PACKAGE_ = ClassesPackage.SAP_CLASS__PACKAGE_;

	/**
     * The feature id for the '<em><b>Adapted By</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__ADAPTED_BY = ClassesPackage.SAP_CLASS__ADAPTED_BY;

	/**
     * The feature id for the '<em><b>Adapters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__ADAPTERS = ClassesPackage.SAP_CLASS__ADAPTERS;

	/**
     * The feature id for the '<em><b>Formal Object Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__FORMAL_OBJECT_PARAMETERS = ClassesPackage.SAP_CLASS__FORMAL_OBJECT_PARAMETERS;

	/**
     * The feature id for the '<em><b>Converter Between Parametrizations</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__CONVERTER_BETWEEN_PARAMETRIZATIONS = ClassesPackage.SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS;

	/**
     * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__CONSTRAINTS = ClassesPackage.SAP_CLASS__CONSTRAINTS;

	/**
     * The feature id for the '<em><b>Time Dependency</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__TIME_DEPENDENCY = ClassesPackage.SAP_CLASS__TIME_DEPENDENCY;

	/**
     * The feature id for the '<em><b>Parameterization</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZATION = ClassesPackage.SAP_CLASS__PARAMETERIZATION;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__ABAP_ANNOTATION = ClassesPackage.SAP_CLASS__ABAP_ANNOTATION;

	/**
     * The feature id for the '<em><b>Actual Type Parameters For Instantiation</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Parameterized Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Parameterized Class Instantiation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETERIZED_CLASS_INSTANTIATION_FEATURE_COUNT = ClassesPackage.SAP_CLASS_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link data.generics.impl.ClassParameterizationImpl <em>Class Parameterization</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.generics.impl.ClassParameterizationImpl
     * @see data.generics.impl.GenericsPackageImpl#getClassParameterization()
     * @generated
     */
	int CLASS_PARAMETERIZATION = 2;

	/**
     * The feature id for the '<em><b>Formal Type Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS = 0;

	/**
     * The feature id for the '<em><b>Owning Class Definition</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION = 1;

	/**
     * The feature id for the '<em><b>Package </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_PARAMETERIZATION__PACKAGE_ = 2;

	/**
     * The number of structural features of the '<em>Class Parameterization</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_PARAMETERIZATION_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link data.generics.impl.ActualTypeParameterImpl <em>Actual Type Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.generics.impl.ActualTypeParameterImpl
     * @see data.generics.impl.GenericsPackageImpl#getActualTypeParameter()
     * @generated
     */
	int ACTUAL_TYPE_PARAMETER = 3;

	/**
     * The feature id for the '<em><b>Parameterized Class Instantiation</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION = 0;

	/**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_TYPE_PARAMETER__TYPE = 1;

	/**
     * The feature id for the '<em><b>Formal Type Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER = 2;

	/**
     * The number of structural features of the '<em>Actual Type Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_TYPE_PARAMETER_FEATURE_COUNT = 3;


	/**
     * Returns the meta object for class '{@link data.generics.FormalTypeParameter <em>Formal Type Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Formal Type Parameter</em>'.
     * @see data.generics.FormalTypeParameter
     * @generated
     */
	EClass getFormalTypeParameter();

	/**
     * Returns the meta object for the container reference '{@link data.generics.FormalTypeParameter#getParameterOf <em>Parameter Of</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parameter Of</em>'.
     * @see data.generics.FormalTypeParameter#getParameterOf()
     * @see #getFormalTypeParameter()
     * @generated
     */
	EReference getFormalTypeParameter_ParameterOf();

	/**
     * Returns the meta object for the reference '{@link data.generics.FormalTypeParameter#getTypeConstraint <em>Type Constraint</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type Constraint</em>'.
     * @see data.generics.FormalTypeParameter#getTypeConstraint()
     * @see #getFormalTypeParameter()
     * @generated
     */
	EReference getFormalTypeParameter_TypeConstraint();

	/**
     * Returns the meta object for the reference list '{@link data.generics.FormalTypeParameter#getActualTypeParameters <em>Actual Type Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Actual Type Parameters</em>'.
     * @see data.generics.FormalTypeParameter#getActualTypeParameters()
     * @see #getFormalTypeParameter()
     * @generated
     */
	EReference getFormalTypeParameter_ActualTypeParameters();

	/**
     * Returns the meta object for class '{@link data.generics.ParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameterized Class Instantiation</em>'.
     * @see data.generics.ParameterizedClassInstantiation
     * @generated
     */
	EClass getParameterizedClassInstantiation();

	/**
     * Returns the meta object for the containment reference list '{@link data.generics.ParameterizedClassInstantiation#getActualTypeParametersForInstantiation <em>Actual Type Parameters For Instantiation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Actual Type Parameters For Instantiation</em>'.
     * @see data.generics.ParameterizedClassInstantiation#getActualTypeParametersForInstantiation()
     * @see #getParameterizedClassInstantiation()
     * @generated
     */
	EReference getParameterizedClassInstantiation_ActualTypeParametersForInstantiation();

	/**
     * Returns the meta object for the reference '{@link data.generics.ParameterizedClassInstantiation#getParameterizedClass <em>Parameterized Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parameterized Class</em>'.
     * @see data.generics.ParameterizedClassInstantiation#getParameterizedClass()
     * @see #getParameterizedClassInstantiation()
     * @generated
     */
	EReference getParameterizedClassInstantiation_ParameterizedClass();

	/**
     * Returns the meta object for class '{@link data.generics.ClassParameterization <em>Class Parameterization</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Class Parameterization</em>'.
     * @see data.generics.ClassParameterization
     * @generated
     */
	EClass getClassParameterization();

	/**
     * Returns the meta object for the containment reference list '{@link data.generics.ClassParameterization#getFormalTypeParameters <em>Formal Type Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Formal Type Parameters</em>'.
     * @see data.generics.ClassParameterization#getFormalTypeParameters()
     * @see #getClassParameterization()
     * @generated
     */
	EReference getClassParameterization_FormalTypeParameters();

	/**
     * Returns the meta object for the container reference '{@link data.generics.ClassParameterization#getOwningClassDefinition <em>Owning Class Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owning Class Definition</em>'.
     * @see data.generics.ClassParameterization#getOwningClassDefinition()
     * @see #getClassParameterization()
     * @generated
     */
	EReference getClassParameterization_OwningClassDefinition();

	/**
     * Returns the meta object for the container reference '{@link data.generics.ClassParameterization#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Package </em>'.
     * @see data.generics.ClassParameterization#getPackage_()
     * @see #getClassParameterization()
     * @generated
     */
	EReference getClassParameterization_Package_();

	/**
     * Returns the meta object for class '{@link data.generics.ActualTypeParameter <em>Actual Type Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Actual Type Parameter</em>'.
     * @see data.generics.ActualTypeParameter
     * @generated
     */
	EClass getActualTypeParameter();

	/**
     * Returns the meta object for the container reference '{@link data.generics.ActualTypeParameter#getParameterizedClassInstantiation <em>Parameterized Class Instantiation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parameterized Class Instantiation</em>'.
     * @see data.generics.ActualTypeParameter#getParameterizedClassInstantiation()
     * @see #getActualTypeParameter()
     * @generated
     */
	EReference getActualTypeParameter_ParameterizedClassInstantiation();

	/**
     * Returns the meta object for the reference '{@link data.generics.ActualTypeParameter#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see data.generics.ActualTypeParameter#getType()
     * @see #getActualTypeParameter()
     * @generated
     */
	EReference getActualTypeParameter_Type();

	/**
     * Returns the meta object for the reference '{@link data.generics.ActualTypeParameter#getFormalTypeParameter <em>Formal Type Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Formal Type Parameter</em>'.
     * @see data.generics.ActualTypeParameter#getFormalTypeParameter()
     * @see #getActualTypeParameter()
     * @generated
     */
	EReference getActualTypeParameter_FormalTypeParameter();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	GenericsFactory getGenericsFactory();

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
         * The meta object literal for the '{@link data.generics.impl.FormalTypeParameterImpl <em>Formal Type Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.generics.impl.FormalTypeParameterImpl
         * @see data.generics.impl.GenericsPackageImpl#getFormalTypeParameter()
         * @generated
         */
		EClass FORMAL_TYPE_PARAMETER = eINSTANCE.getFormalTypeParameter();

		/**
         * The meta object literal for the '<em><b>Parameter Of</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FORMAL_TYPE_PARAMETER__PARAMETER_OF = eINSTANCE.getFormalTypeParameter_ParameterOf();

		/**
         * The meta object literal for the '<em><b>Type Constraint</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FORMAL_TYPE_PARAMETER__TYPE_CONSTRAINT = eINSTANCE.getFormalTypeParameter_TypeConstraint();

		/**
         * The meta object literal for the '<em><b>Actual Type Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FORMAL_TYPE_PARAMETER__ACTUAL_TYPE_PARAMETERS = eINSTANCE.getFormalTypeParameter_ActualTypeParameters();

		/**
         * The meta object literal for the '{@link data.generics.impl.ParameterizedClassInstantiationImpl <em>Parameterized Class Instantiation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.generics.impl.ParameterizedClassInstantiationImpl
         * @see data.generics.impl.GenericsPackageImpl#getParameterizedClassInstantiation()
         * @generated
         */
		EClass PARAMETERIZED_CLASS_INSTANTIATION = eINSTANCE.getParameterizedClassInstantiation();

		/**
         * The meta object literal for the '<em><b>Actual Type Parameters For Instantiation</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PARAMETERIZED_CLASS_INSTANTIATION__ACTUAL_TYPE_PARAMETERS_FOR_INSTANTIATION = eINSTANCE.getParameterizedClassInstantiation_ActualTypeParametersForInstantiation();

		/**
         * The meta object literal for the '<em><b>Parameterized Class</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PARAMETERIZED_CLASS_INSTANTIATION__PARAMETERIZED_CLASS = eINSTANCE.getParameterizedClassInstantiation_ParameterizedClass();

		/**
         * The meta object literal for the '{@link data.generics.impl.ClassParameterizationImpl <em>Class Parameterization</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.generics.impl.ClassParameterizationImpl
         * @see data.generics.impl.GenericsPackageImpl#getClassParameterization()
         * @generated
         */
		EClass CLASS_PARAMETERIZATION = eINSTANCE.getClassParameterization();

		/**
         * The meta object literal for the '<em><b>Formal Type Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_PARAMETERIZATION__FORMAL_TYPE_PARAMETERS = eINSTANCE.getClassParameterization_FormalTypeParameters();

		/**
         * The meta object literal for the '<em><b>Owning Class Definition</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_PARAMETERIZATION__OWNING_CLASS_DEFINITION = eINSTANCE.getClassParameterization_OwningClassDefinition();

		/**
         * The meta object literal for the '<em><b>Package </b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_PARAMETERIZATION__PACKAGE_ = eINSTANCE.getClassParameterization_Package_();

		/**
         * The meta object literal for the '{@link data.generics.impl.ActualTypeParameterImpl <em>Actual Type Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.generics.impl.ActualTypeParameterImpl
         * @see data.generics.impl.GenericsPackageImpl#getActualTypeParameter()
         * @generated
         */
		EClass ACTUAL_TYPE_PARAMETER = eINSTANCE.getActualTypeParameter();

		/**
         * The meta object literal for the '<em><b>Parameterized Class Instantiation</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_TYPE_PARAMETER__PARAMETERIZED_CLASS_INSTANTIATION = eINSTANCE.getActualTypeParameter_ParameterizedClassInstantiation();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_TYPE_PARAMETER__TYPE = eINSTANCE.getActualTypeParameter_Type();

		/**
         * The meta object literal for the '<em><b>Formal Type Parameter</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_TYPE_PARAMETER__FORMAL_TYPE_PARAMETER = eINSTANCE.getActualTypeParameter_FormalTypeParameter();

	}

} //GenericsPackage
