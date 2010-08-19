/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * BOs, BONodes, associations, regardless the association implementation (foreign keys, persistence structures, IDs, ...). Nodes have attributes that have types. Resulting is a datatype for the node that can be used, e.g., in the action language.
 * <!-- end-model-doc -->
 * @see data.classes.ClassesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface ClassesPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "classes";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///data/classes.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "data.classes";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ClassesPackage eINSTANCE = data.classes.impl.ClassesPackageImpl.init();

	/**
     * The meta object id for the '{@link data.classes.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.AssociationImpl
     * @see data.classes.impl.ClassesPackageImpl#getAssociation()
     * @generated
     */
	int ASSOCIATION = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Ends</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION__ENDS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Package </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION__PACKAGE_ = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Time Dependency</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION__TIME_DEPENDENCY = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION__ABAP_ANNOTATION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Association</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link data.classes.impl.SignatureImpl <em>Signature</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.SignatureImpl
     * @see data.classes.impl.ClassesPackageImpl#getSignature()
     * @generated
     */
	int SIGNATURE = 1;

	/**
     * The feature id for the '<em><b>Side Effect Free</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__SIDE_EFFECT_FREE = 0;

	/**
     * The feature id for the '<em><b>Faults</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__FAULTS = 1;

	/**
     * The feature id for the '<em><b>Output</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__OUTPUT = 2;

	/**
     * The feature id for the '<em><b>Owned Type Definitions</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__OWNED_TYPE_DEFINITIONS = 3;

	/**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__INPUT = 4;

	/**
     * The feature id for the '<em><b>Type Definition</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__TYPE_DEFINITION = 5;

	/**
     * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__PRECONDITIONS = 6;

	/**
     * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__POSTCONDITIONS = 7;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE__ABAP_ANNOTATION = 8;

	/**
     * The number of structural features of the '<em>Signature</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_FEATURE_COUNT = 9;

	/**
     * The meta object id for the '{@link data.classes.impl.AssociationEndImpl <em>Association End</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.AssociationEndImpl
     * @see data.classes.impl.ClassesPackageImpl#getAssociationEnd()
     * @generated
     */
	int ASSOCIATION_END = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Navigable</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__NAVIGABLE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Composite</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__COMPOSITE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Contributes To Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Association</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__ASSOCIATION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Delegation</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__DELEGATION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Signature Implementations</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END__ABAP_ANNOTATION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
     * The number of structural features of the '<em>Association End</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
     * The meta object id for the '{@link data.classes.impl.SignatureOwnerImpl <em>Signature Owner</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.SignatureOwnerImpl
     * @see data.classes.impl.ClassesPackageImpl#getSignatureOwner()
     * @generated
     */
	int SIGNATURE_OWNER = 25;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_OWNER__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_OWNER__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_OWNER__OWNED_SIGNATURES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Signature Owner</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_OWNER_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link data.classes.impl.SapClassImpl <em>Sap Class</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.SapClassImpl
     * @see data.classes.impl.ClassesPackageImpl#getSapClass()
     * @generated
     */
	int SAP_CLASS = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__NAME = SIGNATURE_OWNER__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__DESCRIPTION = SIGNATURE_OWNER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__OWNED_SIGNATURES = SIGNATURE_OWNER__OWNED_SIGNATURES;

	/**
     * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SUBSCRIPTIONS = SIGNATURE_OWNER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Notification Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__NOTIFICATION_SIGNATURES = SIGNATURE_OWNER_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Subscription</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SUBSCRIPTION = SIGNATURE_OWNER_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Sam Actions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SAM_ACTIONS = SIGNATURE_OWNER_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Sam Status Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SAM_STATUS_VARIABLES = SIGNATURE_OWNER_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Sam Derivators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SAM_DERIVATORS = SIGNATURE_OWNER_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SAM_STATUS_SCHEMA = SIGNATURE_OWNER_FEATURE_COUNT + 6;

	/**
     * The feature id for the '<em><b>Behavioural Model</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__BEHAVIOURAL_MODEL = SIGNATURE_OWNER_FEATURE_COUNT + 7;

	/**
     * The feature id for the '<em><b>Value Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__VALUE_TYPE = SIGNATURE_OWNER_FEATURE_COUNT + 8;

	/**
     * The feature id for the '<em><b>Signatures With Fault</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__SIGNATURES_WITH_FAULT = SIGNATURE_OWNER_FEATURE_COUNT + 9;

	/**
     * The feature id for the '<em><b>Elements Of Type</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__ELEMENTS_OF_TYPE = SIGNATURE_OWNER_FEATURE_COUNT + 10;

	/**
     * The feature id for the '<em><b>Package </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__PACKAGE_ = SIGNATURE_OWNER_FEATURE_COUNT + 11;

	/**
     * The feature id for the '<em><b>Adapted By</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__ADAPTED_BY = SIGNATURE_OWNER_FEATURE_COUNT + 12;

	/**
     * The feature id for the '<em><b>Adapters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__ADAPTERS = SIGNATURE_OWNER_FEATURE_COUNT + 13;

	/**
     * The feature id for the '<em><b>Formal Object Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__FORMAL_OBJECT_PARAMETERS = SIGNATURE_OWNER_FEATURE_COUNT + 14;

	/**
     * The feature id for the '<em><b>Converter Between Parametrizations</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS = SIGNATURE_OWNER_FEATURE_COUNT + 15;

	/**
     * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__CONSTRAINTS = SIGNATURE_OWNER_FEATURE_COUNT + 16;

	/**
     * The feature id for the '<em><b>Time Dependency</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__TIME_DEPENDENCY = SIGNATURE_OWNER_FEATURE_COUNT + 17;

	/**
     * The feature id for the '<em><b>Parameterization</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__PARAMETERIZATION = SIGNATURE_OWNER_FEATURE_COUNT + 18;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS__ABAP_ANNOTATION = SIGNATURE_OWNER_FEATURE_COUNT + 19;

	/**
     * The number of structural features of the '<em>Sap Class</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAP_CLASS_FEATURE_COUNT = SIGNATURE_OWNER_FEATURE_COUNT + 20;

	/**
     * The meta object id for the '{@link data.classes.impl.DelegationImpl <em>Delegation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.DelegationImpl
     * @see data.classes.impl.ClassesPackageImpl#getDelegation()
     * @generated
     */
	int DELEGATION = 4;

	/**
     * The feature id for the '<em><b>All Features</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELEGATION__ALL_FEATURES = 0;

	/**
     * The feature id for the '<em><b>From</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELEGATION__FROM = 1;

	/**
     * The number of structural features of the '<em>Delegation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DELEGATION_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link data.classes.impl.TypedElementImpl <em>Typed Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.TypedElementImpl
     * @see data.classes.impl.ClassesPackageImpl#getTypedElement()
     * @generated
     */
	int TYPED_ELEMENT = 5;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPED_ELEMENT__OWNED_TYPE_DEFINITION = 0;

	/**
     * The number of structural features of the '<em>Typed Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPED_ELEMENT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link data.classes.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.ContextImpl
     * @see data.classes.impl.ClassesPackageImpl#getContext()
     * @generated
     */
	int CONTEXT = 6;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>For </b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT__FOR_ = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT__CONSTRAINTS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT__CONDITION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Context</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTEXT_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link data.classes.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.MultiplicityImpl
     * @see data.classes.impl.ClassesPackageImpl#getMultiplicity()
     * @generated
     */
	int MULTIPLICITY = 7;

	/**
     * The feature id for the '<em><b>Lower Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MULTIPLICITY__LOWER_MULTIPLICITY = 0;

	/**
     * The feature id for the '<em><b>Upper Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MULTIPLICITY__UPPER_MULTIPLICITY = 1;

	/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MULTIPLICITY__ORDERED = 2;

	/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MULTIPLICITY__UNIQUE = 3;

	/**
     * The number of structural features of the '<em>Multiplicity</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MULTIPLICITY_FEATURE_COUNT = 4;

	/**
     * The meta object id for the '{@link data.classes.impl.SignatureImplementationImpl <em>Signature Implementation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.SignatureImplementationImpl
     * @see data.classes.impl.ClassesPackageImpl#getSignatureImplementation()
     * @generated
     */
	int SIGNATURE_IMPLEMENTATION = 8;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_IMPLEMENTATION__IMPLEMENTS_ = 0;

	/**
     * The number of structural features of the '<em>Signature Implementation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_IMPLEMENTATION_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link data.classes.impl.AssociationEndSignatureImplementationImpl <em>Association End Signature Implementation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.AssociationEndSignatureImplementationImpl
     * @see data.classes.impl.ClassesPackageImpl#getAssociationEndSignatureImplementation()
     * @generated
     */
	int ASSOCIATION_END_SIGNATURE_IMPLEMENTATION = 12;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_ = SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END = SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Association End Signature Implementation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT = SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link data.classes.impl.LinkTraversalImpl <em>Link Traversal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.LinkTraversalImpl
     * @see data.classes.impl.ClassesPackageImpl#getLinkTraversal()
     * @generated
     */
	int LINK_TRAVERSAL = 9;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_TRAVERSAL__IMPLEMENTS_ = ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_TRAVERSAL__END = ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END;

	/**
     * The number of structural features of the '<em>Link Traversal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_TRAVERSAL_FEATURE_COUNT = ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link data.classes.impl.ExtentModifyingAssociationEndSignatureImplementationImpl <em>Extent Modifying Association End Signature Implementation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.ExtentModifyingAssociationEndSignatureImplementationImpl
     * @see data.classes.impl.ClassesPackageImpl#getExtentModifyingAssociationEndSignatureImplementation()
     * @generated
     */
	int EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION = 26;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_ = ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END = ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END;

	/**
     * The number of structural features of the '<em>Extent Modifying Association End Signature Implementation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT = ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link data.classes.impl.LinkManipulationAtPositionImpl <em>Link Manipulation At Position</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.LinkManipulationAtPositionImpl
     * @see data.classes.impl.ClassesPackageImpl#getLinkManipulationAtPosition()
     * @generated
     */
	int LINK_MANIPULATION_AT_POSITION = 30;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_AT_POSITION__IMPLEMENTS_ = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_AT_POSITION__END = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END;

	/**
     * The feature id for the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_AT_POSITION__AT = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Link Manipulation At Position</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_AT_POSITION_FEATURE_COUNT = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link data.classes.impl.LinkAdditionImpl <em>Link Addition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.LinkAdditionImpl
     * @see data.classes.impl.ClassesPackageImpl#getLinkAddition()
     * @generated
     */
	int LINK_ADDITION = 10;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_ADDITION__IMPLEMENTS_ = LINK_MANIPULATION_AT_POSITION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_ADDITION__END = LINK_MANIPULATION_AT_POSITION__END;

	/**
     * The feature id for the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_ADDITION__AT = LINK_MANIPULATION_AT_POSITION__AT;

	/**
     * The number of structural features of the '<em>Link Addition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_ADDITION_FEATURE_COUNT = LINK_MANIPULATION_AT_POSITION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link data.classes.impl.LinkRemovalImpl <em>Link Removal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.LinkRemovalImpl
     * @see data.classes.impl.ClassesPackageImpl#getLinkRemoval()
     * @generated
     */
	int LINK_REMOVAL = 11;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_REMOVAL__IMPLEMENTS_ = LINK_MANIPULATION_AT_POSITION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_REMOVAL__END = LINK_MANIPULATION_AT_POSITION__END;

	/**
     * The feature id for the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_REMOVAL__AT = LINK_MANIPULATION_AT_POSITION__AT;

	/**
     * The number of structural features of the '<em>Link Removal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_REMOVAL_FEATURE_COUNT = LINK_MANIPULATION_AT_POSITION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link data.classes.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.TypeDefinitionImpl
     * @see data.classes.impl.ClassesPackageImpl#getTypeDefinition()
     * @generated
     */
	int TYPE_DEFINITION = 14;

	/**
     * The feature id for the '<em><b>Lower Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__LOWER_MULTIPLICITY = MULTIPLICITY__LOWER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Upper Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__UPPER_MULTIPLICITY = MULTIPLICITY__UPPER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__ORDERED = MULTIPLICITY__ORDERED;

	/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__UNIQUE = MULTIPLICITY__UNIQUE;

	/**
     * The feature id for the '<em><b>Signatures With Output</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT = MULTIPLICITY_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Owner Typed Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__OWNER_TYPED_ELEMENT = MULTIPLICITY_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Owner Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION__OWNER_SIGNATURE = MULTIPLICITY_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Type Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_DEFINITION_FEATURE_COUNT = MULTIPLICITY_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link data.classes.impl.ClassTypeDefinitionImpl <em>Class Type Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.ClassTypeDefinitionImpl
     * @see data.classes.impl.ClassesPackageImpl#getClassTypeDefinition()
     * @generated
     */
	int CLASS_TYPE_DEFINITION = 13;

	/**
     * The feature id for the '<em><b>Lower Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__LOWER_MULTIPLICITY = TYPE_DEFINITION__LOWER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Upper Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__UPPER_MULTIPLICITY = TYPE_DEFINITION__UPPER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__ORDERED = TYPE_DEFINITION__ORDERED;

	/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__UNIQUE = TYPE_DEFINITION__UNIQUE;

	/**
     * The feature id for the '<em><b>Signatures With Output</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT = TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT;

	/**
     * The feature id for the '<em><b>Owner Typed Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__OWNER_TYPED_ELEMENT = TYPE_DEFINITION__OWNER_TYPED_ELEMENT;

	/**
     * The feature id for the '<em><b>Owner Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__OWNER_SIGNATURE = TYPE_DEFINITION__OWNER_SIGNATURE;

	/**
     * The feature id for the '<em><b>Clazz</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__CLAZZ = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Association End</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__ASSOCIATION_END = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Object Parameters</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS = TYPE_DEFINITION_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Owned Object Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS = TYPE_DEFINITION_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Class Type Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CLASS_TYPE_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link data.classes.impl.NestedTypeDefinitionImpl <em>Nested Type Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.NestedTypeDefinitionImpl
     * @see data.classes.impl.ClassesPackageImpl#getNestedTypeDefinition()
     * @generated
     */
	int NESTED_TYPE_DEFINITION = 15;

	/**
     * The feature id for the '<em><b>Lower Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__LOWER_MULTIPLICITY = TYPE_DEFINITION__LOWER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Upper Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__UPPER_MULTIPLICITY = TYPE_DEFINITION__UPPER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__ORDERED = TYPE_DEFINITION__ORDERED;

	/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__UNIQUE = TYPE_DEFINITION__UNIQUE;

	/**
     * The feature id for the '<em><b>Signatures With Output</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT = TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT;

	/**
     * The feature id for the '<em><b>Owner Typed Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__OWNER_TYPED_ELEMENT = TYPE_DEFINITION__OWNER_TYPED_ELEMENT;

	/**
     * The feature id for the '<em><b>Owner Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__OWNER_SIGNATURE = TYPE_DEFINITION__OWNER_SIGNATURE;

	/**
     * The feature id for the '<em><b>Op</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__OP = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__TYPE = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION = TYPE_DEFINITION_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Nested Type Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NESTED_TYPE_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link data.classes.impl.FunctionSignatureTypeDefinitionImpl <em>Function Signature Type Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.FunctionSignatureTypeDefinitionImpl
     * @see data.classes.impl.ClassesPackageImpl#getFunctionSignatureTypeDefinition()
     * @generated
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION = 16;

	/**
     * The feature id for the '<em><b>Lower Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__LOWER_MULTIPLICITY = TYPE_DEFINITION__LOWER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Upper Multiplicity</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__UPPER_MULTIPLICITY = TYPE_DEFINITION__UPPER_MULTIPLICITY;

	/**
     * The feature id for the '<em><b>Ordered</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__ORDERED = TYPE_DEFINITION__ORDERED;

	/**
     * The feature id for the '<em><b>Unique</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__UNIQUE = TYPE_DEFINITION__UNIQUE;

	/**
     * The feature id for the '<em><b>Signatures With Output</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT = TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT;

	/**
     * The feature id for the '<em><b>Owner Typed Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNER_TYPED_ELEMENT = TYPE_DEFINITION__OWNER_TYPED_ELEMENT;

	/**
     * The feature id for the '<em><b>Owner Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNER_SIGNATURE = TYPE_DEFINITION__OWNER_SIGNATURE;

	/**
     * The feature id for the '<em><b>Signature</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Function Signature Type Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_TYPE_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link data.classes.impl.MethodSignatureImpl <em>Method Signature</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.MethodSignatureImpl
     * @see data.classes.impl.ClassesPackageImpl#getMethodSignature()
     * @generated
     */
	int METHOD_SIGNATURE = 17;

	/**
     * The feature id for the '<em><b>Side Effect Free</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__SIDE_EFFECT_FREE = SIGNATURE__SIDE_EFFECT_FREE;

	/**
     * The feature id for the '<em><b>Faults</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__FAULTS = SIGNATURE__FAULTS;

	/**
     * The feature id for the '<em><b>Output</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__OUTPUT = SIGNATURE__OUTPUT;

	/**
     * The feature id for the '<em><b>Owned Type Definitions</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__OWNED_TYPE_DEFINITIONS = SIGNATURE__OWNED_TYPE_DEFINITIONS;

	/**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__INPUT = SIGNATURE__INPUT;

	/**
     * The feature id for the '<em><b>Type Definition</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__TYPE_DEFINITION = SIGNATURE__TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__PRECONDITIONS = SIGNATURE__PRECONDITIONS;

	/**
     * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__POSTCONDITIONS = SIGNATURE__POSTCONDITIONS;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__ABAP_ANNOTATION = SIGNATURE__ABAP_ANNOTATION;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__NAME = SIGNATURE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__DESCRIPTION = SIGNATURE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Producer</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__PRODUCER = SIGNATURE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Implementation</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__IMPLEMENTATION = SIGNATURE_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__OWNER = SIGNATURE_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Converter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE__CONVERTER = SIGNATURE_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Method Signature</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_SIGNATURE_FEATURE_COUNT = SIGNATURE_FEATURE_COUNT + 6;

	/**
     * The meta object id for the '{@link data.classes.impl.FunctionSignatureImpl <em>Function Signature</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.FunctionSignatureImpl
     * @see data.classes.impl.ClassesPackageImpl#getFunctionSignature()
     * @generated
     */
	int FUNCTION_SIGNATURE = 18;

	/**
     * The feature id for the '<em><b>Side Effect Free</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__SIDE_EFFECT_FREE = SIGNATURE__SIDE_EFFECT_FREE;

	/**
     * The feature id for the '<em><b>Faults</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__FAULTS = SIGNATURE__FAULTS;

	/**
     * The feature id for the '<em><b>Output</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__OUTPUT = SIGNATURE__OUTPUT;

	/**
     * The feature id for the '<em><b>Owned Type Definitions</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__OWNED_TYPE_DEFINITIONS = SIGNATURE__OWNED_TYPE_DEFINITIONS;

	/**
     * The feature id for the '<em><b>Input</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__INPUT = SIGNATURE__INPUT;

	/**
     * The feature id for the '<em><b>Type Definition</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__TYPE_DEFINITION = SIGNATURE__TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__PRECONDITIONS = SIGNATURE__PRECONDITIONS;

	/**
     * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__POSTCONDITIONS = SIGNATURE__POSTCONDITIONS;

	/**
     * The feature id for the '<em><b>Abap Annotation</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__ABAP_ANNOTATION = SIGNATURE__ABAP_ANNOTATION;

	/**
     * The feature id for the '<em><b>Implementation</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__IMPLEMENTATION = SIGNATURE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__DIMENSION = SIGNATURE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Cell Set For Value Function</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION = SIGNATURE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Cell Set For Aggregation Function</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION = SIGNATURE_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Function Signature</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_FEATURE_COUNT = SIGNATURE_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link data.classes.impl.LinkSettingImpl <em>Link Setting</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.LinkSettingImpl
     * @see data.classes.impl.ClassesPackageImpl#getLinkSetting()
     * @generated
     */
	int LINK_SETTING = 19;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_SETTING__IMPLEMENTS_ = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_SETTING__END = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END;

	/**
     * The number of structural features of the '<em>Link Setting</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_SETTING_FEATURE_COUNT = EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link data.classes.impl.TypeAdapterImpl <em>Type Adapter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.TypeAdapterImpl
     * @see data.classes.impl.ClassesPackageImpl#getTypeAdapter()
     * @generated
     */
	int TYPE_ADAPTER = 20;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_ADAPTER__NAME = SIGNATURE_OWNER__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_ADAPTER__DESCRIPTION = SIGNATURE_OWNER__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_ADAPTER__OWNED_SIGNATURES = SIGNATURE_OWNER__OWNED_SIGNATURES;

	/**
     * The feature id for the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_ADAPTER__TO = SIGNATURE_OWNER_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Adapted</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_ADAPTER__ADAPTED = SIGNATURE_OWNER_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Type Adapter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TYPE_ADAPTER_FEATURE_COUNT = SIGNATURE_OWNER_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link data.classes.impl.NamedValueImpl <em>Named Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.NamedValueImpl
     * @see data.classes.impl.ClassesPackageImpl#getNamedValue()
     * @generated
     */
	int NAMED_VALUE = 22;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE__OWNED_TYPE_DEFINITION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE__OWNER = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Named Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link data.classes.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.ParameterImpl
     * @see data.classes.impl.ClassesPackageImpl#getParameter()
     * @generated
     */
	int PARAMETER = 21;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__NAME = NAMED_VALUE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__DESCRIPTION = NAMED_VALUE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__OWNED_TYPE_DEFINITION = NAMED_VALUE__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__OWNER = NAMED_VALUE__OWNER;

	/**
     * The feature id for the '<em><b>Owner Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__OWNER_SIGNATURE = NAMED_VALUE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Parameter Of Class</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int PARAMETER__PARAMETER_OF_CLASS = NAMED_VALUE_FEATURE_COUNT + 1;

  /**
     * The feature id for the '<em><b>Default Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER__DEFAULT_VALUE = NAMED_VALUE_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PARAMETER_FEATURE_COUNT = NAMED_VALUE_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link data.classes.impl.PlatformSpecificImplementationImpl <em>Platform Specific Implementation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.PlatformSpecificImplementationImpl
     * @see data.classes.impl.ClassesPackageImpl#getPlatformSpecificImplementation()
     * @generated
     */
	int PLATFORM_SPECIFIC_IMPLEMENTATION = 23;

	/**
     * The feature id for the '<em><b>Target Platform</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM = 0;

	/**
     * The feature id for the '<em><b>Implementation</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION = 1;

	/**
     * The number of structural features of the '<em>Platform Specific Implementation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PLATFORM_SPECIFIC_IMPLEMENTATION_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link data.classes.impl.NativeImplImpl <em>Native Impl</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.NativeImplImpl
     * @see data.classes.impl.ClassesPackageImpl#getNativeImpl()
     * @generated
     */
	int NATIVE_IMPL = 24;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NATIVE_IMPL__IMPLEMENTS_ = SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>Platform Specific Implementaiton</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON = SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Native Impl</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NATIVE_IMPL_FEATURE_COUNT = SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link data.classes.impl.FunctionSignatureImplementationImpl <em>Function Signature Implementation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.FunctionSignatureImplementationImpl
     * @see data.classes.impl.ClassesPackageImpl#getFunctionSignatureImplementation()
     * @generated
     */
	int FUNCTION_SIGNATURE_IMPLEMENTATION = 27;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_ = SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>Function Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE = SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Function Signature Implementation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT = SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link data.classes.impl.ActualObjectParameterImpl <em>Actual Object Parameter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.ActualObjectParameterImpl
     * @see data.classes.impl.ClassesPackageImpl#getActualObjectParameter()
     * @generated
     */
	int ACTUAL_OBJECT_PARAMETER = 28;

	/**
     * The feature id for the '<em><b>Formal Object Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER = 0;

	/**
     * The feature id for the '<em><b>Class Type Definitions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS = 1;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_OBJECT_PARAMETER__VALUE = 2;

	/**
     * The feature id for the '<em><b>Owning Class Type Definition</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION = 3;

	/**
     * The number of structural features of the '<em>Actual Object Parameter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTUAL_OBJECT_PARAMETER_FEATURE_COUNT = 4;

	/**
     * The meta object id for the '{@link data.classes.impl.ConverterBetweenParametrizationsImpl <em>Converter Between Parametrizations</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.ConverterBetweenParametrizationsImpl
     * @see data.classes.impl.ClassesPackageImpl#getConverterBetweenParametrizations()
     * @generated
     */
	int CONVERTER_BETWEEN_PARAMETRIZATIONS = 29;

	/**
     * The feature id for the '<em><b>Clazz</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ = 0;

	/**
     * The feature id for the '<em><b>Conversion Method</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD = 1;

	/**
     * The number of structural features of the '<em>Converter Between Parametrizations</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONVERTER_BETWEEN_PARAMETRIZATIONS_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link data.classes.impl.InScopeImpl <em>In Scope</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see data.classes.impl.InScopeImpl
     * @see data.classes.impl.ClassesPackageImpl#getInScope()
     * @generated
     */
	int IN_SCOPE = 31;

	/**
     * The number of structural features of the '<em>In Scope</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IN_SCOPE_FEATURE_COUNT = 0;


	/**
     * Returns the meta object for class '{@link data.classes.Association <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association</em>'.
     * @see data.classes.Association
     * @generated
     */
	EClass getAssociation();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.Association#getEnds <em>Ends</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Ends</em>'.
     * @see data.classes.Association#getEnds()
     * @see #getAssociation()
     * @generated
     */
	EReference getAssociation_Ends();

	/**
     * Returns the meta object for the container reference '{@link data.classes.Association#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Package </em>'.
     * @see data.classes.Association#getPackage_()
     * @see #getAssociation()
     * @generated
     */
	EReference getAssociation_Package_();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.Association#getTimeDependency <em>Time Dependency</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Time Dependency</em>'.
     * @see data.classes.Association#getTimeDependency()
     * @see #getAssociation()
     * @generated
     */
	EReference getAssociation_TimeDependency();

	/**
     * Returns the meta object for the reference '{@link data.classes.Association#getAbapAnnotation <em>Abap Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Abap Annotation</em>'.
     * @see data.classes.Association#getAbapAnnotation()
     * @see #getAssociation()
     * @generated
     */
	EReference getAssociation_AbapAnnotation();

	/**
     * Returns the meta object for class '{@link data.classes.Signature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signature</em>'.
     * @see data.classes.Signature
     * @generated
     */
	EClass getSignature();

	/**
     * Returns the meta object for the attribute '{@link data.classes.Signature#isSideEffectFree <em>Side Effect Free</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Side Effect Free</em>'.
     * @see data.classes.Signature#isSideEffectFree()
     * @see #getSignature()
     * @generated
     */
	EAttribute getSignature_SideEffectFree();

	/**
     * Returns the meta object for the reference '{@link data.classes.Signature#getFaults <em>Faults</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Faults</em>'.
     * @see data.classes.Signature#getFaults()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_Faults();

	/**
     * Returns the meta object for the reference '{@link data.classes.Signature#getOutput <em>Output</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Output</em>'.
     * @see data.classes.Signature#getOutput()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_Output();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.Signature#getOwnedTypeDefinitions <em>Owned Type Definitions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Owned Type Definitions</em>'.
     * @see data.classes.Signature#getOwnedTypeDefinitions()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_OwnedTypeDefinitions();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.Signature#getInput <em>Input</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Input</em>'.
     * @see data.classes.Signature#getInput()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_Input();

	/**
     * Returns the meta object for the reference list '{@link data.classes.Signature#getTypeDefinition <em>Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Type Definition</em>'.
     * @see data.classes.Signature#getTypeDefinition()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_TypeDefinition();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.Signature#getPreconditions <em>Preconditions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Preconditions</em>'.
     * @see data.classes.Signature#getPreconditions()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_Preconditions();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.Signature#getPostconditions <em>Postconditions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Postconditions</em>'.
     * @see data.classes.Signature#getPostconditions()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_Postconditions();

	/**
     * Returns the meta object for the reference '{@link data.classes.Signature#getAbapAnnotation <em>Abap Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Abap Annotation</em>'.
     * @see data.classes.Signature#getAbapAnnotation()
     * @see #getSignature()
     * @generated
     */
	EReference getSignature_AbapAnnotation();

	/**
     * Returns the meta object for class '{@link data.classes.AssociationEnd <em>Association End</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association End</em>'.
     * @see data.classes.AssociationEnd
     * @generated
     */
	EClass getAssociationEnd();

	/**
     * Returns the meta object for the attribute '{@link data.classes.AssociationEnd#isNavigable <em>Navigable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Navigable</em>'.
     * @see data.classes.AssociationEnd#isNavigable()
     * @see #getAssociationEnd()
     * @generated
     */
	EAttribute getAssociationEnd_Navigable();

	/**
     * Returns the meta object for the attribute '{@link data.classes.AssociationEnd#isComposite <em>Composite</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Composite</em>'.
     * @see data.classes.AssociationEnd#isComposite()
     * @see #getAssociationEnd()
     * @generated
     */
	EAttribute getAssociationEnd_Composite();

	/**
     * Returns the meta object for the attribute '{@link data.classes.AssociationEnd#isContributesToEquality <em>Contributes To Equality</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Contributes To Equality</em>'.
     * @see data.classes.AssociationEnd#isContributesToEquality()
     * @see #getAssociationEnd()
     * @generated
     */
	EAttribute getAssociationEnd_ContributesToEquality();

	/**
     * Returns the meta object for the container reference '{@link data.classes.AssociationEnd#getAssociation <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Association</em>'.
     * @see data.classes.AssociationEnd#getAssociation()
     * @see #getAssociationEnd()
     * @generated
     */
	EReference getAssociationEnd_Association();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.AssociationEnd#getDelegation <em>Delegation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Delegation</em>'.
     * @see data.classes.AssociationEnd#getDelegation()
     * @see #getAssociationEnd()
     * @generated
     */
	EReference getAssociationEnd_Delegation();

	/**
     * Returns the meta object for the reference list '{@link data.classes.AssociationEnd#getSignatureImplementations <em>Signature Implementations</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Signature Implementations</em>'.
     * @see data.classes.AssociationEnd#getSignatureImplementations()
     * @see #getAssociationEnd()
     * @generated
     */
	EReference getAssociationEnd_SignatureImplementations();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.AssociationEnd#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Type</em>'.
     * @see data.classes.AssociationEnd#getType()
     * @see #getAssociationEnd()
     * @generated
     */
	EReference getAssociationEnd_Type();

	/**
     * Returns the meta object for the reference '{@link data.classes.AssociationEnd#getAbapAnnotation <em>Abap Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Abap Annotation</em>'.
     * @see data.classes.AssociationEnd#getAbapAnnotation()
     * @see #getAssociationEnd()
     * @generated
     */
	EReference getAssociationEnd_AbapAnnotation();

	/**
     * Returns the meta object for class '{@link data.classes.SapClass <em>Sap Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sap Class</em>'.
     * @see data.classes.SapClass
     * @generated
     */
	EClass getSapClass();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getSubscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Subscription</em>'.
     * @see data.classes.SapClass#getSubscription()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_Subscription();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getSamActions <em>Sam Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Actions</em>'.
     * @see data.classes.SapClass#getSamActions()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_SamActions();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getSamStatusVariables <em>Sam Status Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Status Variables</em>'.
     * @see data.classes.SapClass#getSamStatusVariables()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_SamStatusVariables();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getSamDerivators <em>Sam Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Derivators</em>'.
     * @see data.classes.SapClass#getSamDerivators()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_SamDerivators();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Status Schema</em>'.
     * @see data.classes.SapClass#getSamStatusSchema()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_SamStatusSchema();

	/**
     * Returns the meta object for the reference list '{@link data.classes.SapClass#getBehaviouralModel <em>Behavioural Model</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Behavioural Model</em>'.
     * @see data.classes.SapClass#getBehaviouralModel()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_BehaviouralModel();

	/**
     * Returns the meta object for the attribute '{@link data.classes.SapClass#isValueType <em>Value Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value Type</em>'.
     * @see data.classes.SapClass#isValueType()
     * @see #getSapClass()
     * @generated
     */
	EAttribute getSapClass_ValueType();

	/**
     * Returns the meta object for the reference list '{@link data.classes.SapClass#getSignaturesWithFault <em>Signatures With Fault</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Signatures With Fault</em>'.
     * @see data.classes.SapClass#getSignaturesWithFault()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_SignaturesWithFault();

	/**
     * Returns the meta object for the reference list '{@link data.classes.SapClass#getElementsOfType <em>Elements Of Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Elements Of Type</em>'.
     * @see data.classes.SapClass#getElementsOfType()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_ElementsOfType();

	/**
     * Returns the meta object for the container reference '{@link data.classes.SapClass#getPackage_ <em>Package </em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Package </em>'.
     * @see data.classes.SapClass#getPackage_()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_Package_();

	/**
     * Returns the meta object for the reference list '{@link data.classes.SapClass#getAdaptedBy <em>Adapted By</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Adapted By</em>'.
     * @see data.classes.SapClass#getAdaptedBy()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_AdaptedBy();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getAdapters <em>Adapters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Adapters</em>'.
     * @see data.classes.SapClass#getAdapters()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_Adapters();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getFormalObjectParameters <em>Formal Object Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Formal Object Parameters</em>'.
     * @see data.classes.SapClass#getFormalObjectParameters()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_FormalObjectParameters();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.SapClass#getConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Converter Between Parametrizations</em>'.
     * @see data.classes.SapClass#getConverterBetweenParametrizations()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_ConverterBetweenParametrizations();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SapClass#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Constraints</em>'.
     * @see data.classes.SapClass#getConstraints()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_Constraints();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.SapClass#getTimeDependency <em>Time Dependency</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Time Dependency</em>'.
     * @see data.classes.SapClass#getTimeDependency()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_TimeDependency();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.SapClass#getParameterization <em>Parameterization</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Parameterization</em>'.
     * @see data.classes.SapClass#getParameterization()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_Parameterization();

	/**
     * Returns the meta object for the reference '{@link data.classes.SapClass#getAbapAnnotation <em>Abap Annotation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Abap Annotation</em>'.
     * @see data.classes.SapClass#getAbapAnnotation()
     * @see #getSapClass()
     * @generated
     */
	EReference getSapClass_AbapAnnotation();

	/**
     * Returns the meta object for class '{@link data.classes.Delegation <em>Delegation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Delegation</em>'.
     * @see data.classes.Delegation
     * @generated
     */
	EClass getDelegation();

	/**
     * Returns the meta object for the attribute '{@link data.classes.Delegation#isAllFeatures <em>All Features</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>All Features</em>'.
     * @see data.classes.Delegation#isAllFeatures()
     * @see #getDelegation()
     * @generated
     */
	EAttribute getDelegation_AllFeatures();

	/**
     * Returns the meta object for the container reference '{@link data.classes.Delegation#getFrom <em>From</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>From</em>'.
     * @see data.classes.Delegation#getFrom()
     * @see #getDelegation()
     * @generated
     */
	EReference getDelegation_From();

	/**
     * Returns the meta object for class '{@link data.classes.TypedElement <em>Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Typed Element</em>'.
     * @see data.classes.TypedElement
     * @generated
     */
	EClass getTypedElement();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.TypedElement#getOwnedTypeDefinition <em>Owned Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Owned Type Definition</em>'.
     * @see data.classes.TypedElement#getOwnedTypeDefinition()
     * @see #getTypedElement()
     * @generated
     */
	EReference getTypedElement_OwnedTypeDefinition();

	/**
     * Returns the meta object for class '{@link data.classes.Context <em>Context</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Context</em>'.
     * @see data.classes.Context
     * @generated
     */
	EClass getContext();

	/**
     * Returns the meta object for the reference '{@link data.classes.Context#getFor_ <em>For </em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>For </em>'.
     * @see data.classes.Context#getFor_()
     * @see #getContext()
     * @generated
     */
	EReference getContext_For_();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.Context#getConstraints <em>Constraints</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Constraints</em>'.
     * @see data.classes.Context#getConstraints()
     * @see #getContext()
     * @generated
     */
	EReference getContext_Constraints();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.Context#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see data.classes.Context#getCondition()
     * @see #getContext()
     * @generated
     */
	EReference getContext_Condition();

	/**
     * Returns the meta object for class '{@link data.classes.Multiplicity <em>Multiplicity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Multiplicity</em>'.
     * @see data.classes.Multiplicity
     * @generated
     */
	EClass getMultiplicity();

	/**
     * Returns the meta object for the attribute '{@link data.classes.Multiplicity#getLowerMultiplicity <em>Lower Multiplicity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Lower Multiplicity</em>'.
     * @see data.classes.Multiplicity#getLowerMultiplicity()
     * @see #getMultiplicity()
     * @generated
     */
	EAttribute getMultiplicity_LowerMultiplicity();

	/**
     * Returns the meta object for the attribute '{@link data.classes.Multiplicity#getUpperMultiplicity <em>Upper Multiplicity</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Upper Multiplicity</em>'.
     * @see data.classes.Multiplicity#getUpperMultiplicity()
     * @see #getMultiplicity()
     * @generated
     */
	EAttribute getMultiplicity_UpperMultiplicity();

	/**
     * Returns the meta object for the attribute '{@link data.classes.Multiplicity#isOrdered <em>Ordered</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ordered</em>'.
     * @see data.classes.Multiplicity#isOrdered()
     * @see #getMultiplicity()
     * @generated
     */
	EAttribute getMultiplicity_Ordered();

	/**
     * Returns the meta object for the attribute '{@link data.classes.Multiplicity#isUnique <em>Unique</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Unique</em>'.
     * @see data.classes.Multiplicity#isUnique()
     * @see #getMultiplicity()
     * @generated
     */
	EAttribute getMultiplicity_Unique();

	/**
     * Returns the meta object for class '{@link data.classes.SignatureImplementation <em>Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signature Implementation</em>'.
     * @see data.classes.SignatureImplementation
     * @generated
     */
	EClass getSignatureImplementation();

	/**
     * Returns the meta object for the container reference '{@link data.classes.SignatureImplementation#getImplements_ <em>Implements </em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Implements </em>'.
     * @see data.classes.SignatureImplementation#getImplements_()
     * @see #getSignatureImplementation()
     * @generated
     */
	EReference getSignatureImplementation_Implements_();

	/**
     * Returns the meta object for class '{@link data.classes.LinkTraversal <em>Link Traversal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Traversal</em>'.
     * @see data.classes.LinkTraversal
     * @generated
     */
	EClass getLinkTraversal();

	/**
     * Returns the meta object for class '{@link data.classes.LinkAddition <em>Link Addition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Addition</em>'.
     * @see data.classes.LinkAddition
     * @generated
     */
	EClass getLinkAddition();

	/**
     * Returns the meta object for class '{@link data.classes.LinkRemoval <em>Link Removal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Removal</em>'.
     * @see data.classes.LinkRemoval
     * @generated
     */
	EClass getLinkRemoval();

	/**
     * Returns the meta object for class '{@link data.classes.AssociationEndSignatureImplementation <em>Association End Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association End Signature Implementation</em>'.
     * @see data.classes.AssociationEndSignatureImplementation
     * @generated
     */
	EClass getAssociationEndSignatureImplementation();

	/**
     * Returns the meta object for the reference '{@link data.classes.AssociationEndSignatureImplementation#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>End</em>'.
     * @see data.classes.AssociationEndSignatureImplementation#getEnd()
     * @see #getAssociationEndSignatureImplementation()
     * @generated
     */
	EReference getAssociationEndSignatureImplementation_End();

	/**
     * Returns the meta object for class '{@link data.classes.ClassTypeDefinition <em>Class Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Class Type Definition</em>'.
     * @see data.classes.ClassTypeDefinition
     * @generated
     */
	EClass getClassTypeDefinition();

	/**
     * Returns the meta object for the reference '{@link data.classes.ClassTypeDefinition#getClazz <em>Clazz</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Clazz</em>'.
     * @see data.classes.ClassTypeDefinition#getClazz()
     * @see #getClassTypeDefinition()
     * @generated
     */
	EReference getClassTypeDefinition_Clazz();

	/**
     * Returns the meta object for the container reference '{@link data.classes.ClassTypeDefinition#getAssociationEnd <em>Association End</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Association End</em>'.
     * @see data.classes.ClassTypeDefinition#getAssociationEnd()
     * @see #getClassTypeDefinition()
     * @generated
     */
	EReference getClassTypeDefinition_AssociationEnd();

	/**
     * Returns the meta object for the reference list '{@link data.classes.ClassTypeDefinition#getObjectParameters <em>Object Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Object Parameters</em>'.
     * @see data.classes.ClassTypeDefinition#getObjectParameters()
     * @see #getClassTypeDefinition()
     * @generated
     */
	EReference getClassTypeDefinition_ObjectParameters();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.ClassTypeDefinition#getOwnedObjectParameters <em>Owned Object Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Object Parameters</em>'.
     * @see data.classes.ClassTypeDefinition#getOwnedObjectParameters()
     * @see #getClassTypeDefinition()
     * @generated
     */
	EReference getClassTypeDefinition_OwnedObjectParameters();

	/**
     * Returns the meta object for class '{@link data.classes.TypeDefinition <em>Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Definition</em>'.
     * @see data.classes.TypeDefinition
     * @generated
     */
	EClass getTypeDefinition();

	/**
     * Returns the meta object for the reference list '{@link data.classes.TypeDefinition#getSignaturesWithOutput <em>Signatures With Output</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Signatures With Output</em>'.
     * @see data.classes.TypeDefinition#getSignaturesWithOutput()
     * @see #getTypeDefinition()
     * @generated
     */
	EReference getTypeDefinition_SignaturesWithOutput();

	/**
     * Returns the meta object for the container reference '{@link data.classes.TypeDefinition#getOwnerTypedElement <em>Owner Typed Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner Typed Element</em>'.
     * @see data.classes.TypeDefinition#getOwnerTypedElement()
     * @see #getTypeDefinition()
     * @generated
     */
	EReference getTypeDefinition_OwnerTypedElement();

	/**
     * Returns the meta object for the container reference '{@link data.classes.TypeDefinition#getOwnerSignature <em>Owner Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner Signature</em>'.
     * @see data.classes.TypeDefinition#getOwnerSignature()
     * @see #getTypeDefinition()
     * @generated
     */
	EReference getTypeDefinition_OwnerSignature();

	/**
     * Returns the meta object for class '{@link data.classes.NestedTypeDefinition <em>Nested Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Nested Type Definition</em>'.
     * @see data.classes.NestedTypeDefinition
     * @generated
     */
	EClass getNestedTypeDefinition();

	/**
     * Returns the meta object for the attribute '{@link data.classes.NestedTypeDefinition#getOp <em>Op</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Op</em>'.
     * @see data.classes.NestedTypeDefinition#getOp()
     * @see #getNestedTypeDefinition()
     * @generated
     */
	EAttribute getNestedTypeDefinition_Op();

	/**
     * Returns the meta object for the reference '{@link data.classes.NestedTypeDefinition#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type</em>'.
     * @see data.classes.NestedTypeDefinition#getType()
     * @see #getNestedTypeDefinition()
     * @generated
     */
	EReference getNestedTypeDefinition_Type();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.NestedTypeDefinition#getOwnedTypeDefinition <em>Owned Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Owned Type Definition</em>'.
     * @see data.classes.NestedTypeDefinition#getOwnedTypeDefinition()
     * @see #getNestedTypeDefinition()
     * @generated
     */
	EReference getNestedTypeDefinition_OwnedTypeDefinition();

	/**
     * Returns the meta object for class '{@link data.classes.FunctionSignatureTypeDefinition <em>Function Signature Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Signature Type Definition</em>'.
     * @see data.classes.FunctionSignatureTypeDefinition
     * @generated
     */
	EClass getFunctionSignatureTypeDefinition();

	/**
     * Returns the meta object for the reference '{@link data.classes.FunctionSignatureTypeDefinition#getSignature <em>Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Signature</em>'.
     * @see data.classes.FunctionSignatureTypeDefinition#getSignature()
     * @see #getFunctionSignatureTypeDefinition()
     * @generated
     */
	EReference getFunctionSignatureTypeDefinition_Signature();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.FunctionSignatureTypeDefinition#getOwnedSignature <em>Owned Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Owned Signature</em>'.
     * @see data.classes.FunctionSignatureTypeDefinition#getOwnedSignature()
     * @see #getFunctionSignatureTypeDefinition()
     * @generated
     */
	EReference getFunctionSignatureTypeDefinition_OwnedSignature();

	/**
     * Returns the meta object for class '{@link data.classes.MethodSignature <em>Method Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Method Signature</em>'.
     * @see data.classes.MethodSignature
     * @generated
     */
	EClass getMethodSignature();

	/**
     * Returns the meta object for the container reference '{@link data.classes.MethodSignature#getProducer <em>Producer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Producer</em>'.
     * @see data.classes.MethodSignature#getProducer()
     * @see #getMethodSignature()
     * @generated
     */
	EReference getMethodSignature_Producer();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.MethodSignature#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Implementation</em>'.
     * @see data.classes.MethodSignature#getImplementation()
     * @see #getMethodSignature()
     * @generated
     */
	EReference getMethodSignature_Implementation();

	/**
     * Returns the meta object for the container reference '{@link data.classes.MethodSignature#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner</em>'.
     * @see data.classes.MethodSignature#getOwner()
     * @see #getMethodSignature()
     * @generated
     */
	EReference getMethodSignature_Owner();

	/**
     * Returns the meta object for the reference '{@link data.classes.MethodSignature#getConverter <em>Converter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Converter</em>'.
     * @see data.classes.MethodSignature#getConverter()
     * @see #getMethodSignature()
     * @generated
     */
	EReference getMethodSignature_Converter();

	/**
     * Returns the meta object for class '{@link data.classes.FunctionSignature <em>Function Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Signature</em>'.
     * @see data.classes.FunctionSignature
     * @generated
     */
	EClass getFunctionSignature();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.FunctionSignature#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Implementation</em>'.
     * @see data.classes.FunctionSignature#getImplementation()
     * @see #getFunctionSignature()
     * @generated
     */
	EReference getFunctionSignature_Implementation();

	/**
     * Returns the meta object for the container reference '{@link data.classes.FunctionSignature#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Dimension</em>'.
     * @see data.classes.FunctionSignature#getDimension()
     * @see #getFunctionSignature()
     * @generated
     */
	EReference getFunctionSignature_Dimension();

	/**
     * Returns the meta object for the container reference '{@link data.classes.FunctionSignature#getCellSetForValueFunction <em>Cell Set For Value Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Cell Set For Value Function</em>'.
     * @see data.classes.FunctionSignature#getCellSetForValueFunction()
     * @see #getFunctionSignature()
     * @generated
     */
	EReference getFunctionSignature_CellSetForValueFunction();

	/**
     * Returns the meta object for the container reference '{@link data.classes.FunctionSignature#getCellSetForAggregationFunction <em>Cell Set For Aggregation Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Cell Set For Aggregation Function</em>'.
     * @see data.classes.FunctionSignature#getCellSetForAggregationFunction()
     * @see #getFunctionSignature()
     * @generated
     */
	EReference getFunctionSignature_CellSetForAggregationFunction();

	/**
     * Returns the meta object for class '{@link data.classes.LinkSetting <em>Link Setting</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Setting</em>'.
     * @see data.classes.LinkSetting
     * @generated
     */
	EClass getLinkSetting();

	/**
     * Returns the meta object for class '{@link data.classes.TypeAdapter <em>Type Adapter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Type Adapter</em>'.
     * @see data.classes.TypeAdapter
     * @generated
     */
	EClass getTypeAdapter();

	/**
     * Returns the meta object for the reference '{@link data.classes.TypeAdapter#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To</em>'.
     * @see data.classes.TypeAdapter#getTo()
     * @see #getTypeAdapter()
     * @generated
     */
	EReference getTypeAdapter_To();

	/**
     * Returns the meta object for the container reference '{@link data.classes.TypeAdapter#getAdapted <em>Adapted</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Adapted</em>'.
     * @see data.classes.TypeAdapter#getAdapted()
     * @see #getTypeAdapter()
     * @generated
     */
	EReference getTypeAdapter_Adapted();

	/**
     * Returns the meta object for class '{@link data.classes.Parameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Parameter</em>'.
     * @see data.classes.Parameter
     * @generated
     */
	EClass getParameter();

	/**
     * Returns the meta object for the container reference '{@link data.classes.Parameter#getOwnerSignature <em>Owner Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner Signature</em>'.
     * @see data.classes.Parameter#getOwnerSignature()
     * @see #getParameter()
     * @generated
     */
	EReference getParameter_OwnerSignature();

	/**
     * Returns the meta object for the container reference '{@link data.classes.Parameter#getParameterOfClass <em>Parameter Of Class</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Parameter Of Class</em>'.
     * @see data.classes.Parameter#getParameterOfClass()
     * @see #getParameter()
     * @generated
     */
  EReference getParameter_ParameterOfClass();

  /**
     * Returns the meta object for the containment reference '{@link data.classes.Parameter#getDefaultValue <em>Default Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Default Value</em>'.
     * @see data.classes.Parameter#getDefaultValue()
     * @see #getParameter()
     * @generated
     */
	EReference getParameter_DefaultValue();

	/**
     * Returns the meta object for class '{@link data.classes.NamedValue <em>Named Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Value</em>'.
     * @see data.classes.NamedValue
     * @generated
     */
	EClass getNamedValue();

	/**
     * Returns the meta object for the container reference '{@link data.classes.NamedValue#getOwner <em>Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owner</em>'.
     * @see data.classes.NamedValue#getOwner()
     * @see #getNamedValue()
     * @generated
     */
	EReference getNamedValue_Owner();

	/**
     * Returns the meta object for class '{@link data.classes.PlatformSpecificImplementation <em>Platform Specific Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Platform Specific Implementation</em>'.
     * @see data.classes.PlatformSpecificImplementation
     * @generated
     */
	EClass getPlatformSpecificImplementation();

	/**
     * Returns the meta object for the attribute '{@link data.classes.PlatformSpecificImplementation#getTargetPlatform <em>Target Platform</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Target Platform</em>'.
     * @see data.classes.PlatformSpecificImplementation#getTargetPlatform()
     * @see #getPlatformSpecificImplementation()
     * @generated
     */
	EAttribute getPlatformSpecificImplementation_TargetPlatform();

	/**
     * Returns the meta object for the attribute '{@link data.classes.PlatformSpecificImplementation#getImplementation <em>Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Implementation</em>'.
     * @see data.classes.PlatformSpecificImplementation#getImplementation()
     * @see #getPlatformSpecificImplementation()
     * @generated
     */
	EAttribute getPlatformSpecificImplementation_Implementation();

	/**
     * Returns the meta object for class '{@link data.classes.NativeImpl <em>Native Impl</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Native Impl</em>'.
     * @see data.classes.NativeImpl
     * @generated
     */
	EClass getNativeImpl();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.NativeImpl#getPlatformSpecificImplementaiton <em>Platform Specific Implementaiton</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Platform Specific Implementaiton</em>'.
     * @see data.classes.NativeImpl#getPlatformSpecificImplementaiton()
     * @see #getNativeImpl()
     * @generated
     */
	EReference getNativeImpl_PlatformSpecificImplementaiton();

	/**
     * Returns the meta object for class '{@link data.classes.SignatureOwner <em>Signature Owner</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signature Owner</em>'.
     * @see data.classes.SignatureOwner
     * @generated
     */
	EClass getSignatureOwner();

	/**
     * Returns the meta object for the containment reference list '{@link data.classes.SignatureOwner#getOwnedSignatures <em>Owned Signatures</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Owned Signatures</em>'.
     * @see data.classes.SignatureOwner#getOwnedSignatures()
     * @see #getSignatureOwner()
     * @generated
     */
	EReference getSignatureOwner_OwnedSignatures();

	/**
     * Returns the meta object for class '{@link data.classes.ExtentModifyingAssociationEndSignatureImplementation <em>Extent Modifying Association End Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Extent Modifying Association End Signature Implementation</em>'.
     * @see data.classes.ExtentModifyingAssociationEndSignatureImplementation
     * @generated
     */
	EClass getExtentModifyingAssociationEndSignatureImplementation();

	/**
     * Returns the meta object for class '{@link data.classes.FunctionSignatureImplementation <em>Function Signature Implementation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Signature Implementation</em>'.
     * @see data.classes.FunctionSignatureImplementation
     * @generated
     */
	EClass getFunctionSignatureImplementation();

	/**
     * Returns the meta object for the container reference '{@link data.classes.FunctionSignatureImplementation#getFunctionSignature <em>Function Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Function Signature</em>'.
     * @see data.classes.FunctionSignatureImplementation#getFunctionSignature()
     * @see #getFunctionSignatureImplementation()
     * @generated
     */
	EReference getFunctionSignatureImplementation_FunctionSignature();

	/**
     * Returns the meta object for class '{@link data.classes.ActualObjectParameter <em>Actual Object Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Actual Object Parameter</em>'.
     * @see data.classes.ActualObjectParameter
     * @generated
     */
	EClass getActualObjectParameter();

	/**
     * Returns the meta object for the reference '{@link data.classes.ActualObjectParameter#getFormalObjectParameter <em>Formal Object Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Formal Object Parameter</em>'.
     * @see data.classes.ActualObjectParameter#getFormalObjectParameter()
     * @see #getActualObjectParameter()
     * @generated
     */
	EReference getActualObjectParameter_FormalObjectParameter();

	/**
     * Returns the meta object for the reference list '{@link data.classes.ActualObjectParameter#getClassTypeDefinitions <em>Class Type Definitions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Class Type Definitions</em>'.
     * @see data.classes.ActualObjectParameter#getClassTypeDefinitions()
     * @see #getActualObjectParameter()
     * @generated
     */
	EReference getActualObjectParameter_ClassTypeDefinitions();

	/**
     * Returns the meta object for the containment reference '{@link data.classes.ActualObjectParameter#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see data.classes.ActualObjectParameter#getValue()
     * @see #getActualObjectParameter()
     * @generated
     */
	EReference getActualObjectParameter_Value();

	/**
     * Returns the meta object for the container reference '{@link data.classes.ActualObjectParameter#getOwningClassTypeDefinition <em>Owning Class Type Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owning Class Type Definition</em>'.
     * @see data.classes.ActualObjectParameter#getOwningClassTypeDefinition()
     * @see #getActualObjectParameter()
     * @generated
     */
	EReference getActualObjectParameter_OwningClassTypeDefinition();

	/**
     * Returns the meta object for class '{@link data.classes.ConverterBetweenParametrizations <em>Converter Between Parametrizations</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Converter Between Parametrizations</em>'.
     * @see data.classes.ConverterBetweenParametrizations
     * @generated
     */
	EClass getConverterBetweenParametrizations();

	/**
     * Returns the meta object for the container reference '{@link data.classes.ConverterBetweenParametrizations#getClazz <em>Clazz</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Clazz</em>'.
     * @see data.classes.ConverterBetweenParametrizations#getClazz()
     * @see #getConverterBetweenParametrizations()
     * @generated
     */
	EReference getConverterBetweenParametrizations_Clazz();

	/**
     * Returns the meta object for the reference '{@link data.classes.ConverterBetweenParametrizations#getConversionMethod <em>Conversion Method</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Conversion Method</em>'.
     * @see data.classes.ConverterBetweenParametrizations#getConversionMethod()
     * @see #getConverterBetweenParametrizations()
     * @generated
     */
	EReference getConverterBetweenParametrizations_ConversionMethod();

	/**
     * Returns the meta object for class '{@link data.classes.LinkManipulationAtPosition <em>Link Manipulation At Position</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Manipulation At Position</em>'.
     * @see data.classes.LinkManipulationAtPosition
     * @generated
     */
	EClass getLinkManipulationAtPosition();

	/**
     * Returns the meta object for the attribute '{@link data.classes.LinkManipulationAtPosition#getAt <em>At</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>At</em>'.
     * @see data.classes.LinkManipulationAtPosition#getAt()
     * @see #getLinkManipulationAtPosition()
     * @generated
     */
	EAttribute getLinkManipulationAtPosition_At();

	/**
     * Returns the meta object for class '{@link data.classes.InScope <em>In Scope</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>In Scope</em>'.
     * @see data.classes.InScope
     * @generated
     */
	EClass getInScope();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ClassesFactory getClassesFactory();

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
         * The meta object literal for the '{@link data.classes.impl.AssociationImpl <em>Association</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.AssociationImpl
         * @see data.classes.impl.ClassesPackageImpl#getAssociation()
         * @generated
         */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
         * The meta object literal for the '<em><b>Ends</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION__ENDS = eINSTANCE.getAssociation_Ends();

		/**
         * The meta object literal for the '<em><b>Package </b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION__PACKAGE_ = eINSTANCE.getAssociation_Package_();

		/**
         * The meta object literal for the '<em><b>Time Dependency</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION__TIME_DEPENDENCY = eINSTANCE.getAssociation_TimeDependency();

		/**
         * The meta object literal for the '<em><b>Abap Annotation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION__ABAP_ANNOTATION = eINSTANCE.getAssociation_AbapAnnotation();

		/**
         * The meta object literal for the '{@link data.classes.impl.SignatureImpl <em>Signature</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.SignatureImpl
         * @see data.classes.impl.ClassesPackageImpl#getSignature()
         * @generated
         */
		EClass SIGNATURE = eINSTANCE.getSignature();

		/**
         * The meta object literal for the '<em><b>Side Effect Free</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIGNATURE__SIDE_EFFECT_FREE = eINSTANCE.getSignature_SideEffectFree();

		/**
         * The meta object literal for the '<em><b>Faults</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__FAULTS = eINSTANCE.getSignature_Faults();

		/**
         * The meta object literal for the '<em><b>Output</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__OUTPUT = eINSTANCE.getSignature_Output();

		/**
         * The meta object literal for the '<em><b>Owned Type Definitions</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__OWNED_TYPE_DEFINITIONS = eINSTANCE.getSignature_OwnedTypeDefinitions();

		/**
         * The meta object literal for the '<em><b>Input</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__INPUT = eINSTANCE.getSignature_Input();

		/**
         * The meta object literal for the '<em><b>Type Definition</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__TYPE_DEFINITION = eINSTANCE.getSignature_TypeDefinition();

		/**
         * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__PRECONDITIONS = eINSTANCE.getSignature_Preconditions();

		/**
         * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__POSTCONDITIONS = eINSTANCE.getSignature_Postconditions();

		/**
         * The meta object literal for the '<em><b>Abap Annotation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE__ABAP_ANNOTATION = eINSTANCE.getSignature_AbapAnnotation();

		/**
         * The meta object literal for the '{@link data.classes.impl.AssociationEndImpl <em>Association End</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.AssociationEndImpl
         * @see data.classes.impl.ClassesPackageImpl#getAssociationEnd()
         * @generated
         */
		EClass ASSOCIATION_END = eINSTANCE.getAssociationEnd();

		/**
         * The meta object literal for the '<em><b>Navigable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ASSOCIATION_END__NAVIGABLE = eINSTANCE.getAssociationEnd_Navigable();

		/**
         * The meta object literal for the '<em><b>Composite</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ASSOCIATION_END__COMPOSITE = eINSTANCE.getAssociationEnd_Composite();

		/**
         * The meta object literal for the '<em><b>Contributes To Equality</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY = eINSTANCE.getAssociationEnd_ContributesToEquality();

		/**
         * The meta object literal for the '<em><b>Association</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END__ASSOCIATION = eINSTANCE.getAssociationEnd_Association();

		/**
         * The meta object literal for the '<em><b>Delegation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END__DELEGATION = eINSTANCE.getAssociationEnd_Delegation();

		/**
         * The meta object literal for the '<em><b>Signature Implementations</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS = eINSTANCE.getAssociationEnd_SignatureImplementations();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END__TYPE = eINSTANCE.getAssociationEnd_Type();

		/**
         * The meta object literal for the '<em><b>Abap Annotation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END__ABAP_ANNOTATION = eINSTANCE.getAssociationEnd_AbapAnnotation();

		/**
         * The meta object literal for the '{@link data.classes.impl.SapClassImpl <em>Sap Class</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.SapClassImpl
         * @see data.classes.impl.ClassesPackageImpl#getSapClass()
         * @generated
         */
		EClass SAP_CLASS = eINSTANCE.getSapClass();

		/**
         * The meta object literal for the '<em><b>Subscription</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__SUBSCRIPTION = eINSTANCE.getSapClass_Subscription();

		/**
         * The meta object literal for the '<em><b>Sam Actions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__SAM_ACTIONS = eINSTANCE.getSapClass_SamActions();

		/**
         * The meta object literal for the '<em><b>Sam Status Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__SAM_STATUS_VARIABLES = eINSTANCE.getSapClass_SamStatusVariables();

		/**
         * The meta object literal for the '<em><b>Sam Derivators</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__SAM_DERIVATORS = eINSTANCE.getSapClass_SamDerivators();

		/**
         * The meta object literal for the '<em><b>Sam Status Schema</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__SAM_STATUS_SCHEMA = eINSTANCE.getSapClass_SamStatusSchema();

		/**
         * The meta object literal for the '<em><b>Behavioural Model</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__BEHAVIOURAL_MODEL = eINSTANCE.getSapClass_BehaviouralModel();

		/**
         * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAP_CLASS__VALUE_TYPE = eINSTANCE.getSapClass_ValueType();

		/**
         * The meta object literal for the '<em><b>Signatures With Fault</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__SIGNATURES_WITH_FAULT = eINSTANCE.getSapClass_SignaturesWithFault();

		/**
         * The meta object literal for the '<em><b>Elements Of Type</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__ELEMENTS_OF_TYPE = eINSTANCE.getSapClass_ElementsOfType();

		/**
         * The meta object literal for the '<em><b>Package </b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__PACKAGE_ = eINSTANCE.getSapClass_Package_();

		/**
         * The meta object literal for the '<em><b>Adapted By</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__ADAPTED_BY = eINSTANCE.getSapClass_AdaptedBy();

		/**
         * The meta object literal for the '<em><b>Adapters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__ADAPTERS = eINSTANCE.getSapClass_Adapters();

		/**
         * The meta object literal for the '<em><b>Formal Object Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__FORMAL_OBJECT_PARAMETERS = eINSTANCE.getSapClass_FormalObjectParameters();

		/**
         * The meta object literal for the '<em><b>Converter Between Parametrizations</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS = eINSTANCE.getSapClass_ConverterBetweenParametrizations();

		/**
         * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__CONSTRAINTS = eINSTANCE.getSapClass_Constraints();

		/**
         * The meta object literal for the '<em><b>Time Dependency</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__TIME_DEPENDENCY = eINSTANCE.getSapClass_TimeDependency();

		/**
         * The meta object literal for the '<em><b>Parameterization</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__PARAMETERIZATION = eINSTANCE.getSapClass_Parameterization();

		/**
         * The meta object literal for the '<em><b>Abap Annotation</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAP_CLASS__ABAP_ANNOTATION = eINSTANCE.getSapClass_AbapAnnotation();

		/**
         * The meta object literal for the '{@link data.classes.impl.DelegationImpl <em>Delegation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.DelegationImpl
         * @see data.classes.impl.ClassesPackageImpl#getDelegation()
         * @generated
         */
		EClass DELEGATION = eINSTANCE.getDelegation();

		/**
         * The meta object literal for the '<em><b>All Features</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute DELEGATION__ALL_FEATURES = eINSTANCE.getDelegation_AllFeatures();

		/**
         * The meta object literal for the '<em><b>From</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DELEGATION__FROM = eINSTANCE.getDelegation_From();

		/**
         * The meta object literal for the '{@link data.classes.impl.TypedElementImpl <em>Typed Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.TypedElementImpl
         * @see data.classes.impl.ClassesPackageImpl#getTypedElement()
         * @generated
         */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
         * The meta object literal for the '<em><b>Owned Type Definition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPED_ELEMENT__OWNED_TYPE_DEFINITION = eINSTANCE.getTypedElement_OwnedTypeDefinition();

		/**
         * The meta object literal for the '{@link data.classes.impl.ContextImpl <em>Context</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.ContextImpl
         * @see data.classes.impl.ClassesPackageImpl#getContext()
         * @generated
         */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
         * The meta object literal for the '<em><b>For </b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT__FOR_ = eINSTANCE.getContext_For_();

		/**
         * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT__CONSTRAINTS = eINSTANCE.getContext_Constraints();

		/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONTEXT__CONDITION = eINSTANCE.getContext_Condition();

		/**
         * The meta object literal for the '{@link data.classes.impl.MultiplicityImpl <em>Multiplicity</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.MultiplicityImpl
         * @see data.classes.impl.ClassesPackageImpl#getMultiplicity()
         * @generated
         */
		EClass MULTIPLICITY = eINSTANCE.getMultiplicity();

		/**
         * The meta object literal for the '<em><b>Lower Multiplicity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MULTIPLICITY__LOWER_MULTIPLICITY = eINSTANCE.getMultiplicity_LowerMultiplicity();

		/**
         * The meta object literal for the '<em><b>Upper Multiplicity</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MULTIPLICITY__UPPER_MULTIPLICITY = eINSTANCE.getMultiplicity_UpperMultiplicity();

		/**
         * The meta object literal for the '<em><b>Ordered</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MULTIPLICITY__ORDERED = eINSTANCE.getMultiplicity_Ordered();

		/**
         * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute MULTIPLICITY__UNIQUE = eINSTANCE.getMultiplicity_Unique();

		/**
         * The meta object literal for the '{@link data.classes.impl.SignatureImplementationImpl <em>Signature Implementation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.SignatureImplementationImpl
         * @see data.classes.impl.ClassesPackageImpl#getSignatureImplementation()
         * @generated
         */
		EClass SIGNATURE_IMPLEMENTATION = eINSTANCE.getSignatureImplementation();

		/**
         * The meta object literal for the '<em><b>Implements </b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE_IMPLEMENTATION__IMPLEMENTS_ = eINSTANCE.getSignatureImplementation_Implements_();

		/**
         * The meta object literal for the '{@link data.classes.impl.LinkTraversalImpl <em>Link Traversal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.LinkTraversalImpl
         * @see data.classes.impl.ClassesPackageImpl#getLinkTraversal()
         * @generated
         */
		EClass LINK_TRAVERSAL = eINSTANCE.getLinkTraversal();

		/**
         * The meta object literal for the '{@link data.classes.impl.LinkAdditionImpl <em>Link Addition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.LinkAdditionImpl
         * @see data.classes.impl.ClassesPackageImpl#getLinkAddition()
         * @generated
         */
		EClass LINK_ADDITION = eINSTANCE.getLinkAddition();

		/**
         * The meta object literal for the '{@link data.classes.impl.LinkRemovalImpl <em>Link Removal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.LinkRemovalImpl
         * @see data.classes.impl.ClassesPackageImpl#getLinkRemoval()
         * @generated
         */
		EClass LINK_REMOVAL = eINSTANCE.getLinkRemoval();

		/**
         * The meta object literal for the '{@link data.classes.impl.AssociationEndSignatureImplementationImpl <em>Association End Signature Implementation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.AssociationEndSignatureImplementationImpl
         * @see data.classes.impl.ClassesPackageImpl#getAssociationEndSignatureImplementation()
         * @generated
         */
		EClass ASSOCIATION_END_SIGNATURE_IMPLEMENTATION = eINSTANCE.getAssociationEndSignatureImplementation();

		/**
         * The meta object literal for the '<em><b>End</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END = eINSTANCE.getAssociationEndSignatureImplementation_End();

		/**
         * The meta object literal for the '{@link data.classes.impl.ClassTypeDefinitionImpl <em>Class Type Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.ClassTypeDefinitionImpl
         * @see data.classes.impl.ClassesPackageImpl#getClassTypeDefinition()
         * @generated
         */
		EClass CLASS_TYPE_DEFINITION = eINSTANCE.getClassTypeDefinition();

		/**
         * The meta object literal for the '<em><b>Clazz</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_TYPE_DEFINITION__CLAZZ = eINSTANCE.getClassTypeDefinition_Clazz();

		/**
         * The meta object literal for the '<em><b>Association End</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_TYPE_DEFINITION__ASSOCIATION_END = eINSTANCE.getClassTypeDefinition_AssociationEnd();

		/**
         * The meta object literal for the '<em><b>Object Parameters</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS = eINSTANCE.getClassTypeDefinition_ObjectParameters();

		/**
         * The meta object literal for the '<em><b>Owned Object Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS = eINSTANCE.getClassTypeDefinition_OwnedObjectParameters();

		/**
         * The meta object literal for the '{@link data.classes.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.TypeDefinitionImpl
         * @see data.classes.impl.ClassesPackageImpl#getTypeDefinition()
         * @generated
         */
		EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

		/**
         * The meta object literal for the '<em><b>Signatures With Output</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT = eINSTANCE.getTypeDefinition_SignaturesWithOutput();

		/**
         * The meta object literal for the '<em><b>Owner Typed Element</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_DEFINITION__OWNER_TYPED_ELEMENT = eINSTANCE.getTypeDefinition_OwnerTypedElement();

		/**
         * The meta object literal for the '<em><b>Owner Signature</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_DEFINITION__OWNER_SIGNATURE = eINSTANCE.getTypeDefinition_OwnerSignature();

		/**
         * The meta object literal for the '{@link data.classes.impl.NestedTypeDefinitionImpl <em>Nested Type Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.NestedTypeDefinitionImpl
         * @see data.classes.impl.ClassesPackageImpl#getNestedTypeDefinition()
         * @generated
         */
		EClass NESTED_TYPE_DEFINITION = eINSTANCE.getNestedTypeDefinition();

		/**
         * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute NESTED_TYPE_DEFINITION__OP = eINSTANCE.getNestedTypeDefinition_Op();

		/**
         * The meta object literal for the '<em><b>Type</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NESTED_TYPE_DEFINITION__TYPE = eINSTANCE.getNestedTypeDefinition_Type();

		/**
         * The meta object literal for the '<em><b>Owned Type Definition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION = eINSTANCE.getNestedTypeDefinition_OwnedTypeDefinition();

		/**
         * The meta object literal for the '{@link data.classes.impl.FunctionSignatureTypeDefinitionImpl <em>Function Signature Type Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.FunctionSignatureTypeDefinitionImpl
         * @see data.classes.impl.ClassesPackageImpl#getFunctionSignatureTypeDefinition()
         * @generated
         */
		EClass FUNCTION_SIGNATURE_TYPE_DEFINITION = eINSTANCE.getFunctionSignatureTypeDefinition();

		/**
         * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE = eINSTANCE.getFunctionSignatureTypeDefinition_Signature();

		/**
         * The meta object literal for the '<em><b>Owned Signature</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE = eINSTANCE.getFunctionSignatureTypeDefinition_OwnedSignature();

		/**
         * The meta object literal for the '{@link data.classes.impl.MethodSignatureImpl <em>Method Signature</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.MethodSignatureImpl
         * @see data.classes.impl.ClassesPackageImpl#getMethodSignature()
         * @generated
         */
		EClass METHOD_SIGNATURE = eINSTANCE.getMethodSignature();

		/**
         * The meta object literal for the '<em><b>Producer</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD_SIGNATURE__PRODUCER = eINSTANCE.getMethodSignature_Producer();

		/**
         * The meta object literal for the '<em><b>Implementation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD_SIGNATURE__IMPLEMENTATION = eINSTANCE.getMethodSignature_Implementation();

		/**
         * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD_SIGNATURE__OWNER = eINSTANCE.getMethodSignature_Owner();

		/**
         * The meta object literal for the '<em><b>Converter</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD_SIGNATURE__CONVERTER = eINSTANCE.getMethodSignature_Converter();

		/**
         * The meta object literal for the '{@link data.classes.impl.FunctionSignatureImpl <em>Function Signature</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.FunctionSignatureImpl
         * @see data.classes.impl.ClassesPackageImpl#getFunctionSignature()
         * @generated
         */
		EClass FUNCTION_SIGNATURE = eINSTANCE.getFunctionSignature();

		/**
         * The meta object literal for the '<em><b>Implementation</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE__IMPLEMENTATION = eINSTANCE.getFunctionSignature_Implementation();

		/**
         * The meta object literal for the '<em><b>Dimension</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE__DIMENSION = eINSTANCE.getFunctionSignature_Dimension();

		/**
         * The meta object literal for the '<em><b>Cell Set For Value Function</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION = eINSTANCE.getFunctionSignature_CellSetForValueFunction();

		/**
         * The meta object literal for the '<em><b>Cell Set For Aggregation Function</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION = eINSTANCE.getFunctionSignature_CellSetForAggregationFunction();

		/**
         * The meta object literal for the '{@link data.classes.impl.LinkSettingImpl <em>Link Setting</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.LinkSettingImpl
         * @see data.classes.impl.ClassesPackageImpl#getLinkSetting()
         * @generated
         */
		EClass LINK_SETTING = eINSTANCE.getLinkSetting();

		/**
         * The meta object literal for the '{@link data.classes.impl.TypeAdapterImpl <em>Type Adapter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.TypeAdapterImpl
         * @see data.classes.impl.ClassesPackageImpl#getTypeAdapter()
         * @generated
         */
		EClass TYPE_ADAPTER = eINSTANCE.getTypeAdapter();

		/**
         * The meta object literal for the '<em><b>To</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_ADAPTER__TO = eINSTANCE.getTypeAdapter_To();

		/**
         * The meta object literal for the '<em><b>Adapted</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TYPE_ADAPTER__ADAPTED = eINSTANCE.getTypeAdapter_Adapted();

		/**
         * The meta object literal for the '{@link data.classes.impl.ParameterImpl <em>Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.ParameterImpl
         * @see data.classes.impl.ClassesPackageImpl#getParameter()
         * @generated
         */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
         * The meta object literal for the '<em><b>Owner Signature</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PARAMETER__OWNER_SIGNATURE = eINSTANCE.getParameter_OwnerSignature();

		/**
         * The meta object literal for the '<em><b>Parameter Of Class</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference PARAMETER__PARAMETER_OF_CLASS = eINSTANCE.getParameter_ParameterOfClass();

    /**
         * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PARAMETER__DEFAULT_VALUE = eINSTANCE.getParameter_DefaultValue();

		/**
         * The meta object literal for the '{@link data.classes.impl.NamedValueImpl <em>Named Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.NamedValueImpl
         * @see data.classes.impl.ClassesPackageImpl#getNamedValue()
         * @generated
         */
		EClass NAMED_VALUE = eINSTANCE.getNamedValue();

		/**
         * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAMED_VALUE__OWNER = eINSTANCE.getNamedValue_Owner();

		/**
         * The meta object literal for the '{@link data.classes.impl.PlatformSpecificImplementationImpl <em>Platform Specific Implementation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.PlatformSpecificImplementationImpl
         * @see data.classes.impl.ClassesPackageImpl#getPlatformSpecificImplementation()
         * @generated
         */
		EClass PLATFORM_SPECIFIC_IMPLEMENTATION = eINSTANCE.getPlatformSpecificImplementation();

		/**
         * The meta object literal for the '<em><b>Target Platform</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM = eINSTANCE.getPlatformSpecificImplementation_TargetPlatform();

		/**
         * The meta object literal for the '<em><b>Implementation</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION = eINSTANCE.getPlatformSpecificImplementation_Implementation();

		/**
         * The meta object literal for the '{@link data.classes.impl.NativeImplImpl <em>Native Impl</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.NativeImplImpl
         * @see data.classes.impl.ClassesPackageImpl#getNativeImpl()
         * @generated
         */
		EClass NATIVE_IMPL = eINSTANCE.getNativeImpl();

		/**
         * The meta object literal for the '<em><b>Platform Specific Implementaiton</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON = eINSTANCE.getNativeImpl_PlatformSpecificImplementaiton();

		/**
         * The meta object literal for the '{@link data.classes.impl.SignatureOwnerImpl <em>Signature Owner</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.SignatureOwnerImpl
         * @see data.classes.impl.ClassesPackageImpl#getSignatureOwner()
         * @generated
         */
		EClass SIGNATURE_OWNER = eINSTANCE.getSignatureOwner();

		/**
         * The meta object literal for the '<em><b>Owned Signatures</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE_OWNER__OWNED_SIGNATURES = eINSTANCE.getSignatureOwner_OwnedSignatures();

		/**
         * The meta object literal for the '{@link data.classes.impl.ExtentModifyingAssociationEndSignatureImplementationImpl <em>Extent Modifying Association End Signature Implementation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.ExtentModifyingAssociationEndSignatureImplementationImpl
         * @see data.classes.impl.ClassesPackageImpl#getExtentModifyingAssociationEndSignatureImplementation()
         * @generated
         */
		EClass EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION = eINSTANCE.getExtentModifyingAssociationEndSignatureImplementation();

		/**
         * The meta object literal for the '{@link data.classes.impl.FunctionSignatureImplementationImpl <em>Function Signature Implementation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.FunctionSignatureImplementationImpl
         * @see data.classes.impl.ClassesPackageImpl#getFunctionSignatureImplementation()
         * @generated
         */
		EClass FUNCTION_SIGNATURE_IMPLEMENTATION = eINSTANCE.getFunctionSignatureImplementation();

		/**
         * The meta object literal for the '<em><b>Function Signature</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE = eINSTANCE.getFunctionSignatureImplementation_FunctionSignature();

		/**
         * The meta object literal for the '{@link data.classes.impl.ActualObjectParameterImpl <em>Actual Object Parameter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.ActualObjectParameterImpl
         * @see data.classes.impl.ClassesPackageImpl#getActualObjectParameter()
         * @generated
         */
		EClass ACTUAL_OBJECT_PARAMETER = eINSTANCE.getActualObjectParameter();

		/**
         * The meta object literal for the '<em><b>Formal Object Parameter</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER = eINSTANCE.getActualObjectParameter_FormalObjectParameter();

		/**
         * The meta object literal for the '<em><b>Class Type Definitions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS = eINSTANCE.getActualObjectParameter_ClassTypeDefinitions();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_OBJECT_PARAMETER__VALUE = eINSTANCE.getActualObjectParameter_Value();

		/**
         * The meta object literal for the '<em><b>Owning Class Type Definition</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION = eINSTANCE.getActualObjectParameter_OwningClassTypeDefinition();

		/**
         * The meta object literal for the '{@link data.classes.impl.ConverterBetweenParametrizationsImpl <em>Converter Between Parametrizations</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.ConverterBetweenParametrizationsImpl
         * @see data.classes.impl.ClassesPackageImpl#getConverterBetweenParametrizations()
         * @generated
         */
		EClass CONVERTER_BETWEEN_PARAMETRIZATIONS = eINSTANCE.getConverterBetweenParametrizations();

		/**
         * The meta object literal for the '<em><b>Clazz</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ = eINSTANCE.getConverterBetweenParametrizations_Clazz();

		/**
         * The meta object literal for the '<em><b>Conversion Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD = eINSTANCE.getConverterBetweenParametrizations_ConversionMethod();

		/**
         * The meta object literal for the '{@link data.classes.impl.LinkManipulationAtPositionImpl <em>Link Manipulation At Position</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.LinkManipulationAtPositionImpl
         * @see data.classes.impl.ClassesPackageImpl#getLinkManipulationAtPosition()
         * @generated
         */
		EClass LINK_MANIPULATION_AT_POSITION = eINSTANCE.getLinkManipulationAtPosition();

		/**
         * The meta object literal for the '<em><b>At</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LINK_MANIPULATION_AT_POSITION__AT = eINSTANCE.getLinkManipulationAtPosition_At();

		/**
         * The meta object literal for the '{@link data.classes.impl.InScopeImpl <em>In Scope</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see data.classes.impl.InScopeImpl
         * @see data.classes.impl.ClassesPackageImpl#getInScope()
         * @generated
         */
		EClass IN_SCOPE = eINSTANCE.getInScope();

	}

} //ClassesPackage
