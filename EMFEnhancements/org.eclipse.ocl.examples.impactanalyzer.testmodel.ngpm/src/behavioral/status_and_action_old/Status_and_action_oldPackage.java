/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * Status and Action Modeling. Must be closely related to the businessobjects package and the behavioral/actions package. Decide whether this should be under behavioral or structural.
 * <!-- end-model-doc -->
 * @see behavioral.status_and_action_old.Status_and_action_oldFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface Status_and_action_oldPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "status_and_action_old";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///behavioral/status_and_action_old.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.status_and_action_old";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	Status_and_action_oldPackage eINSTANCE = behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMActionImpl <em>SAM Action</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMActionImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMAction()
     * @generated
     */
	int SAM_ACTION = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_ACTION__NAME = 0;

	/**
     * The feature id for the '<em><b>Is Agent Action</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_ACTION__IS_AGENT_ACTION = 1;

	/**
     * The feature id for the '<em><b>Business Object Node</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_ACTION__BUSINESS_OBJECT_NODE = 2;

	/**
     * The feature id for the '<em><b>Sam Schema Actions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_ACTION__SAM_SCHEMA_ACTIONS = 3;

	/**
     * The number of structural features of the '<em>SAM Action</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_ACTION_FEATURE_COUNT = 4;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl <em>SAM Status Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMStatusVariableImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMStatusVariable()
     * @generated
     */
	int SAM_STATUS_VARIABLE = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VARIABLE__NAME = 0;

	/**
     * The feature id for the '<em><b>Is Agent Variable</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE = 1;

	/**
     * The feature id for the '<em><b>Business Object Node</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE = 2;

	/**
     * The feature id for the '<em><b>Sam Status Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VARIABLE__SAM_STATUS_VALUES = 3;

	/**
     * The feature id for the '<em><b>Sam Schema Variables</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES = 4;

	/**
     * The number of structural features of the '<em>SAM Status Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VARIABLE_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMDerivatorImpl <em>SAM Derivator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMDerivatorImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMDerivator()
     * @generated
     */
	int SAM_DERIVATOR = 2;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_DERIVATOR__KIND = 0;

	/**
     * The feature id for the '<em><b>Business Object</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_DERIVATOR__BUSINESS_OBJECT = 1;

	/**
     * The feature id for the '<em><b>Sam Schema Derivators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS = 2;

	/**
     * The number of structural features of the '<em>SAM Derivator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_DERIVATOR_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMStatusValueImpl <em>SAM Status Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMStatusValueImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMStatusValue()
     * @generated
     */
	int SAM_STATUS_VALUE = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VALUE__NAME = 0;

	/**
     * The feature id for the '<em><b>Sam Status Variable</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VALUE__SAM_STATUS_VARIABLE = 1;

	/**
     * The number of structural features of the '<em>SAM Status Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_VALUE_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl <em>SAM Status Schema</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMStatusSchemaImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMStatusSchema()
     * @generated
     */
	int SAM_STATUS_SCHEMA = 4;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA__NAME = 0;

	/**
     * The feature id for the '<em><b>Business Object Node</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE = 1;

	/**
     * The feature id for the '<em><b>Sam Operators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA__SAM_OPERATORS = 2;

	/**
     * The feature id for the '<em><b>Sam Schema Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES = 3;

	/**
     * The feature id for the '<em><b>Sam Schema Actions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS = 4;

	/**
     * The feature id for the '<em><b>Sam Schema Derivators</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS = 5;

	/**
     * The number of structural features of the '<em>SAM Status Schema</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_STATUS_SCHEMA_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMOperatorImpl <em>SAM Operator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMOperatorImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMOperator()
     * @generated
     */
	int SAM_OPERATOR = 5;

	/**
     * The feature id for the '<em><b>Kind</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR__KIND = 0;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR__SAM_STATUS_SCHEMA = 1;

	/**
     * The feature id for the '<em><b>Sam Schema Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR__SAM_SCHEMA_VALUES = 2;

	/**
     * The feature id for the '<em><b>Sam Source Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR__SAM_SOURCE_OPERATORS = 3;

	/**
     * The feature id for the '<em><b>Sam Target Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR__SAM_TARGET_OPERATORS = 4;

	/**
     * The feature id for the '<em><b>Sam Schema Actions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR__SAM_SCHEMA_ACTIONS = 5;

	/**
     * The number of structural features of the '<em>SAM Operator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_OPERATOR_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl <em>SAM Schema Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMSchemaVariableImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaVariable()
     * @generated
     */
	int SAM_SCHEMA_VARIABLE = 6;

	/**
     * The feature id for the '<em><b>Has State Guard</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD = 0;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA = 1;

	/**
     * The feature id for the '<em><b>Sam Schema Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES = 2;

	/**
     * The feature id for the '<em><b>Sam Schema Value</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE = 3;

	/**
     * The feature id for the '<em><b>Sam Target Schema Derivators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS = 4;

	/**
     * The feature id for the '<em><b>Sam Source Schema Derivators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS = 5;

	/**
     * The number of structural features of the '<em>SAM Schema Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VARIABLE_FEATURE_COUNT = 6;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl <em>SAM Schema Value</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMSchemaValueImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaValue()
     * @generated
     */
	int SAM_SCHEMA_VALUE = 7;

	/**
     * The feature id for the '<em><b>Is Initial</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__IS_INITIAL = 0;

	/**
     * The feature id for the '<em><b>Is Inhibiting</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__IS_INHIBITING = 1;

	/**
     * The feature id for the '<em><b>Sam Schema Variable</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE = 2;

	/**
     * The feature id for the '<em><b>Sam Source Schema Actions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS = 3;

	/**
     * The feature id for the '<em><b>Sam Source Schema Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES = 4;

	/**
     * The feature id for the '<em><b>Sam Target Schema Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES = 5;

	/**
     * The feature id for the '<em><b>Sam Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__SAM_OPERATORS = 6;

	/**
     * The feature id for the '<em><b>Sam Schema Actions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS = 7;

	/**
     * The number of structural features of the '<em>SAM Schema Value</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_VALUE_FEATURE_COUNT = 8;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl <em>SAM Schema Action</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMSchemaActionImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaAction()
     * @generated
     */
	int SAM_SCHEMA_ACTION = 8;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA = 0;

	/**
     * The feature id for the '<em><b>Sam Action</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_ACTION__SAM_ACTION = 1;

	/**
     * The feature id for the '<em><b>Sam Target Schema Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES = 2;

	/**
     * The feature id for the '<em><b>Sam Schema Values</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES = 3;

	/**
     * The feature id for the '<em><b>Sam Schema Operators</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS = 4;

	/**
     * The number of structural features of the '<em>SAM Schema Action</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_ACTION_FEATURE_COUNT = 5;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl <em>SAM Schema Derivator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaDerivator()
     * @generated
     */
	int SAM_SCHEMA_DERIVATOR = 9;

	/**
     * The feature id for the '<em><b>Sam Derivator</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR = 0;

	/**
     * The feature id for the '<em><b>Sam Status Schema</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA = 1;

	/**
     * The feature id for the '<em><b>Sam Source Schema Variables</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES = 2;

	/**
     * The feature id for the '<em><b>Sam Target Schema Variable</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE = 3;

	/**
     * The number of structural features of the '<em>SAM Schema Derivator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SAM_SCHEMA_DERIVATOR_FEATURE_COUNT = 4;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.SAMOperatorKindEnum <em>SAM Operator Kind Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.SAMOperatorKindEnum
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMOperatorKindEnum()
     * @generated
     */
	int SAM_OPERATOR_KIND_ENUM = 10;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.SAMDerivatorKindEnum <em>SAM Derivator Kind Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.SAMDerivatorKindEnum
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMDerivatorKindEnum()
     * @generated
     */
	int SAM_DERIVATOR_KIND_ENUM = 11;

	/**
     * The meta object id for the '{@link behavioral.status_and_action_old.PreconditionKindEnum <em>Precondition Kind Enum</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action_old.PreconditionKindEnum
     * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getPreconditionKindEnum()
     * @generated
     */
	int PRECONDITION_KIND_ENUM = 12;


	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMAction <em>SAM Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Action</em>'.
     * @see behavioral.status_and_action_old.SAMAction
     * @generated
     */
	EClass getSAMAction();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMAction#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see behavioral.status_and_action_old.SAMAction#getName()
     * @see #getSAMAction()
     * @generated
     */
	EAttribute getSAMAction_Name();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMAction#isIsAgentAction <em>Is Agent Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Agent Action</em>'.
     * @see behavioral.status_and_action_old.SAMAction#isIsAgentAction()
     * @see #getSAMAction()
     * @generated
     */
	EAttribute getSAMAction_IsAgentAction();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMAction#getBusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Business Object Node</em>'.
     * @see behavioral.status_and_action_old.SAMAction#getBusinessObjectNode()
     * @see #getSAMAction()
     * @generated
     */
	EReference getSAMAction_BusinessObjectNode();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMAction#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Actions</em>'.
     * @see behavioral.status_and_action_old.SAMAction#getSamSchemaActions()
     * @see #getSAMAction()
     * @generated
     */
	EReference getSAMAction_SamSchemaActions();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMStatusVariable <em>SAM Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Status Variable</em>'.
     * @see behavioral.status_and_action_old.SAMStatusVariable
     * @generated
     */
	EClass getSAMStatusVariable();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMStatusVariable#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see behavioral.status_and_action_old.SAMStatusVariable#getName()
     * @see #getSAMStatusVariable()
     * @generated
     */
	EAttribute getSAMStatusVariable_Name();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMStatusVariable#isIsAgentVariable <em>Is Agent Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Agent Variable</em>'.
     * @see behavioral.status_and_action_old.SAMStatusVariable#isIsAgentVariable()
     * @see #getSAMStatusVariable()
     * @generated
     */
	EAttribute getSAMStatusVariable_IsAgentVariable();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMStatusVariable#getBusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Business Object Node</em>'.
     * @see behavioral.status_and_action_old.SAMStatusVariable#getBusinessObjectNode()
     * @see #getSAMStatusVariable()
     * @generated
     */
	EReference getSAMStatusVariable_BusinessObjectNode();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action_old.SAMStatusVariable#getSamStatusValues <em>Sam Status Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Status Values</em>'.
     * @see behavioral.status_and_action_old.SAMStatusVariable#getSamStatusValues()
     * @see #getSAMStatusVariable()
     * @generated
     */
	EReference getSAMStatusVariable_SamStatusValues();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMStatusVariable#getSamSchemaVariables <em>Sam Schema Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Variables</em>'.
     * @see behavioral.status_and_action_old.SAMStatusVariable#getSamSchemaVariables()
     * @see #getSAMStatusVariable()
     * @generated
     */
	EReference getSAMStatusVariable_SamSchemaVariables();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMDerivator <em>SAM Derivator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Derivator</em>'.
     * @see behavioral.status_and_action_old.SAMDerivator
     * @generated
     */
	EClass getSAMDerivator();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMDerivator#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see behavioral.status_and_action_old.SAMDerivator#getKind()
     * @see #getSAMDerivator()
     * @generated
     */
	EAttribute getSAMDerivator_Kind();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMDerivator#getBusinessObject <em>Business Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Business Object</em>'.
     * @see behavioral.status_and_action_old.SAMDerivator#getBusinessObject()
     * @see #getSAMDerivator()
     * @generated
     */
	EReference getSAMDerivator_BusinessObject();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMDerivator#getSamSchemaDerivators <em>Sam Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Derivators</em>'.
     * @see behavioral.status_and_action_old.SAMDerivator#getSamSchemaDerivators()
     * @see #getSAMDerivator()
     * @generated
     */
	EReference getSAMDerivator_SamSchemaDerivators();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMStatusValue <em>SAM Status Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Status Value</em>'.
     * @see behavioral.status_and_action_old.SAMStatusValue
     * @generated
     */
	EClass getSAMStatusValue();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMStatusValue#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see behavioral.status_and_action_old.SAMStatusValue#getName()
     * @see #getSAMStatusValue()
     * @generated
     */
	EAttribute getSAMStatusValue_Name();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMStatusValue#getSamStatusVariable <em>Sam Status Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Sam Status Variable</em>'.
     * @see behavioral.status_and_action_old.SAMStatusValue#getSamStatusVariable()
     * @see #getSAMStatusValue()
     * @generated
     */
	EReference getSAMStatusValue_SamStatusVariable();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMStatusSchema <em>SAM Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Status Schema</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema
     * @generated
     */
	EClass getSAMStatusSchema();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMStatusSchema#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema#getName()
     * @see #getSAMStatusSchema()
     * @generated
     */
	EAttribute getSAMStatusSchema_Name();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMStatusSchema#getBusinessObjectNode <em>Business Object Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Business Object Node</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema#getBusinessObjectNode()
     * @see #getSAMStatusSchema()
     * @generated
     */
	EReference getSAMStatusSchema_BusinessObjectNode();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamOperators <em>Sam Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Operators</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamOperators()
     * @see #getSAMStatusSchema()
     * @generated
     */
	EReference getSAMStatusSchema_SamOperators();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaVariables <em>Sam Schema Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Schema Variables</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaVariables()
     * @see #getSAMStatusSchema()
     * @generated
     */
	EReference getSAMStatusSchema_SamSchemaVariables();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Schema Actions</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaActions()
     * @see #getSAMStatusSchema()
     * @generated
     */
	EReference getSAMStatusSchema_SamSchemaActions();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaDerivators <em>Sam Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Schema Derivators</em>'.
     * @see behavioral.status_and_action_old.SAMStatusSchema#getSamSchemaDerivators()
     * @see #getSAMStatusSchema()
     * @generated
     */
	EReference getSAMStatusSchema_SamSchemaDerivators();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMOperator <em>SAM Operator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Operator</em>'.
     * @see behavioral.status_and_action_old.SAMOperator
     * @generated
     */
	EClass getSAMOperator();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMOperator#getKind <em>Kind</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Kind</em>'.
     * @see behavioral.status_and_action_old.SAMOperator#getKind()
     * @see #getSAMOperator()
     * @generated
     */
	EAttribute getSAMOperator_Kind();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMOperator#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Sam Status Schema</em>'.
     * @see behavioral.status_and_action_old.SAMOperator#getSamStatusSchema()
     * @see #getSAMOperator()
     * @generated
     */
	EReference getSAMOperator_SamStatusSchema();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMOperator#getSamSchemaValues <em>Sam Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Values</em>'.
     * @see behavioral.status_and_action_old.SAMOperator#getSamSchemaValues()
     * @see #getSAMOperator()
     * @generated
     */
	EReference getSAMOperator_SamSchemaValues();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMOperator#getSamSourceOperators <em>Sam Source Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Source Operators</em>'.
     * @see behavioral.status_and_action_old.SAMOperator#getSamSourceOperators()
     * @see #getSAMOperator()
     * @generated
     */
	EReference getSAMOperator_SamSourceOperators();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMOperator#getSamTargetOperators <em>Sam Target Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Target Operators</em>'.
     * @see behavioral.status_and_action_old.SAMOperator#getSamTargetOperators()
     * @see #getSAMOperator()
     * @generated
     */
	EReference getSAMOperator_SamTargetOperators();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMOperator#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Actions</em>'.
     * @see behavioral.status_and_action_old.SAMOperator#getSamSchemaActions()
     * @see #getSAMOperator()
     * @generated
     */
	EReference getSAMOperator_SamSchemaActions();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMSchemaVariable <em>SAM Schema Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Schema Variable</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable
     * @generated
     */
	EClass getSAMSchemaVariable();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMSchemaVariable#isHasStateGuard <em>Has State Guard</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Has State Guard</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable#isHasStateGuard()
     * @see #getSAMSchemaVariable()
     * @generated
     */
	EAttribute getSAMSchemaVariable_HasStateGuard();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Sam Status Schema</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamStatusSchema()
     * @see #getSAMSchemaVariable()
     * @generated
     */
	EReference getSAMSchemaVariable_SamStatusSchema();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValues <em>Sam Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Sam Schema Values</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValues()
     * @see #getSAMSchemaVariable()
     * @generated
     */
	EReference getSAMSchemaVariable_SamSchemaValues();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValue <em>Sam Schema Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Sam Schema Value</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamSchemaValue()
     * @see #getSAMSchemaVariable()
     * @generated
     */
	EReference getSAMSchemaVariable_SamSchemaValue();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamTargetSchemaDerivators <em>Sam Target Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Target Schema Derivators</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamTargetSchemaDerivators()
     * @see #getSAMSchemaVariable()
     * @generated
     */
	EReference getSAMSchemaVariable_SamTargetSchemaDerivators();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaVariable#getSamSourceSchemaDerivators <em>Sam Source Schema Derivators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Source Schema Derivators</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaVariable#getSamSourceSchemaDerivators()
     * @see #getSAMSchemaVariable()
     * @generated
     */
	EReference getSAMSchemaVariable_SamSourceSchemaDerivators();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMSchemaValue <em>SAM Schema Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Schema Value</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue
     * @generated
     */
	EClass getSAMSchemaValue();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMSchemaValue#isIsInitial <em>Is Initial</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Initial</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#isIsInitial()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EAttribute getSAMSchemaValue_IsInitial();

	/**
     * Returns the meta object for the attribute '{@link behavioral.status_and_action_old.SAMSchemaValue#isIsInhibiting <em>Is Inhibiting</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Is Inhibiting</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#isIsInhibiting()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EAttribute getSAMSchemaValue_IsInhibiting();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaVariable <em>Sam Schema Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Sam Schema Variable</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaVariable()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EReference getSAMSchemaValue_SamSchemaVariable();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaActions <em>Sam Source Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Source Schema Actions</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaActions()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EReference getSAMSchemaValue_SamSourceSchemaActions();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaValues <em>Sam Source Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Source Schema Values</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSourceSchemaValues()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EReference getSAMSchemaValue_SamSourceSchemaValues();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Target Schema Values</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamTargetSchemaValues()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EReference getSAMSchemaValue_SamTargetSchemaValues();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamOperators <em>Sam Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Operators</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamOperators()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EReference getSAMSchemaValue_SamOperators();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaActions <em>Sam Schema Actions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Actions</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaValue#getSamSchemaActions()
     * @see #getSAMSchemaValue()
     * @generated
     */
	EReference getSAMSchemaValue_SamSchemaActions();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMSchemaAction <em>SAM Schema Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Schema Action</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaAction
     * @generated
     */
	EClass getSAMSchemaAction();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Sam Status Schema</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamStatusSchema()
     * @see #getSAMSchemaAction()
     * @generated
     */
	EReference getSAMSchemaAction_SamStatusSchema();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamAction <em>Sam Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Sam Action</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamAction()
     * @see #getSAMSchemaAction()
     * @generated
     */
	EReference getSAMSchemaAction_SamAction();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamTargetSchemaValues <em>Sam Target Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Target Schema Values</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamTargetSchemaValues()
     * @see #getSAMSchemaAction()
     * @generated
     */
	EReference getSAMSchemaAction_SamTargetSchemaValues();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaValues <em>Sam Schema Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Values</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaValues()
     * @see #getSAMSchemaAction()
     * @generated
     */
	EReference getSAMSchemaAction_SamSchemaValues();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaOperators <em>Sam Schema Operators</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Schema Operators</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaAction#getSamSchemaOperators()
     * @see #getSAMSchemaAction()
     * @generated
     */
	EReference getSAMSchemaAction_SamSchemaOperators();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action_old.SAMSchemaDerivator <em>SAM Schema Derivator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>SAM Schema Derivator</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaDerivator
     * @generated
     */
	EClass getSAMSchemaDerivator();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamDerivator <em>Sam Derivator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Sam Derivator</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamDerivator()
     * @see #getSAMSchemaDerivator()
     * @generated
     */
	EReference getSAMSchemaDerivator_SamDerivator();

	/**
     * Returns the meta object for the container reference '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamStatusSchema <em>Sam Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Sam Status Schema</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamStatusSchema()
     * @see #getSAMSchemaDerivator()
     * @generated
     */
	EReference getSAMSchemaDerivator_SamStatusSchema();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamSourceSchemaVariables <em>Sam Source Schema Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Source Schema Variables</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamSourceSchemaVariables()
     * @see #getSAMSchemaDerivator()
     * @generated
     */
	EReference getSAMSchemaDerivator_SamSourceSchemaVariables();

	/**
     * Returns the meta object for the reference list '{@link behavioral.status_and_action_old.SAMSchemaDerivator#getSamTargetSchemaVariable <em>Sam Target Schema Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sam Target Schema Variable</em>'.
     * @see behavioral.status_and_action_old.SAMSchemaDerivator#getSamTargetSchemaVariable()
     * @see #getSAMSchemaDerivator()
     * @generated
     */
	EReference getSAMSchemaDerivator_SamTargetSchemaVariable();

	/**
     * Returns the meta object for enum '{@link behavioral.status_and_action_old.SAMOperatorKindEnum <em>SAM Operator Kind Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>SAM Operator Kind Enum</em>'.
     * @see behavioral.status_and_action_old.SAMOperatorKindEnum
     * @generated
     */
	EEnum getSAMOperatorKindEnum();

	/**
     * Returns the meta object for enum '{@link behavioral.status_and_action_old.SAMDerivatorKindEnum <em>SAM Derivator Kind Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>SAM Derivator Kind Enum</em>'.
     * @see behavioral.status_and_action_old.SAMDerivatorKindEnum
     * @generated
     */
	EEnum getSAMDerivatorKindEnum();

	/**
     * Returns the meta object for enum '{@link behavioral.status_and_action_old.PreconditionKindEnum <em>Precondition Kind Enum</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Precondition Kind Enum</em>'.
     * @see behavioral.status_and_action_old.PreconditionKindEnum
     * @generated
     */
	EEnum getPreconditionKindEnum();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	Status_and_action_oldFactory getStatus_and_action_oldFactory();

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
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMActionImpl <em>SAM Action</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMActionImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMAction()
         * @generated
         */
		EClass SAM_ACTION = eINSTANCE.getSAMAction();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_ACTION__NAME = eINSTANCE.getSAMAction_Name();

		/**
         * The meta object literal for the '<em><b>Is Agent Action</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_ACTION__IS_AGENT_ACTION = eINSTANCE.getSAMAction_IsAgentAction();

		/**
         * The meta object literal for the '<em><b>Business Object Node</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_ACTION__BUSINESS_OBJECT_NODE = eINSTANCE.getSAMAction_BusinessObjectNode();

		/**
         * The meta object literal for the '<em><b>Sam Schema Actions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_ACTION__SAM_SCHEMA_ACTIONS = eINSTANCE.getSAMAction_SamSchemaActions();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMStatusVariableImpl <em>SAM Status Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMStatusVariableImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMStatusVariable()
         * @generated
         */
		EClass SAM_STATUS_VARIABLE = eINSTANCE.getSAMStatusVariable();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_STATUS_VARIABLE__NAME = eINSTANCE.getSAMStatusVariable_Name();

		/**
         * The meta object literal for the '<em><b>Is Agent Variable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE = eINSTANCE.getSAMStatusVariable_IsAgentVariable();

		/**
         * The meta object literal for the '<em><b>Business Object Node</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE = eINSTANCE.getSAMStatusVariable_BusinessObjectNode();

		/**
         * The meta object literal for the '<em><b>Sam Status Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_VARIABLE__SAM_STATUS_VALUES = eINSTANCE.getSAMStatusVariable_SamStatusValues();

		/**
         * The meta object literal for the '<em><b>Sam Schema Variables</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES = eINSTANCE.getSAMStatusVariable_SamSchemaVariables();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMDerivatorImpl <em>SAM Derivator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMDerivatorImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMDerivator()
         * @generated
         */
		EClass SAM_DERIVATOR = eINSTANCE.getSAMDerivator();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_DERIVATOR__KIND = eINSTANCE.getSAMDerivator_Kind();

		/**
         * The meta object literal for the '<em><b>Business Object</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_DERIVATOR__BUSINESS_OBJECT = eINSTANCE.getSAMDerivator_BusinessObject();

		/**
         * The meta object literal for the '<em><b>Sam Schema Derivators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS = eINSTANCE.getSAMDerivator_SamSchemaDerivators();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMStatusValueImpl <em>SAM Status Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMStatusValueImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMStatusValue()
         * @generated
         */
		EClass SAM_STATUS_VALUE = eINSTANCE.getSAMStatusValue();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_STATUS_VALUE__NAME = eINSTANCE.getSAMStatusValue_Name();

		/**
         * The meta object literal for the '<em><b>Sam Status Variable</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_VALUE__SAM_STATUS_VARIABLE = eINSTANCE.getSAMStatusValue_SamStatusVariable();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMStatusSchemaImpl <em>SAM Status Schema</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMStatusSchemaImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMStatusSchema()
         * @generated
         */
		EClass SAM_STATUS_SCHEMA = eINSTANCE.getSAMStatusSchema();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_STATUS_SCHEMA__NAME = eINSTANCE.getSAMStatusSchema_Name();

		/**
         * The meta object literal for the '<em><b>Business Object Node</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE = eINSTANCE.getSAMStatusSchema_BusinessObjectNode();

		/**
         * The meta object literal for the '<em><b>Sam Operators</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_SCHEMA__SAM_OPERATORS = eINSTANCE.getSAMStatusSchema_SamOperators();

		/**
         * The meta object literal for the '<em><b>Sam Schema Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES = eINSTANCE.getSAMStatusSchema_SamSchemaVariables();

		/**
         * The meta object literal for the '<em><b>Sam Schema Actions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS = eINSTANCE.getSAMStatusSchema_SamSchemaActions();

		/**
         * The meta object literal for the '<em><b>Sam Schema Derivators</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS = eINSTANCE.getSAMStatusSchema_SamSchemaDerivators();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMOperatorImpl <em>SAM Operator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMOperatorImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMOperator()
         * @generated
         */
		EClass SAM_OPERATOR = eINSTANCE.getSAMOperator();

		/**
         * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_OPERATOR__KIND = eINSTANCE.getSAMOperator_Kind();

		/**
         * The meta object literal for the '<em><b>Sam Status Schema</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_OPERATOR__SAM_STATUS_SCHEMA = eINSTANCE.getSAMOperator_SamStatusSchema();

		/**
         * The meta object literal for the '<em><b>Sam Schema Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_OPERATOR__SAM_SCHEMA_VALUES = eINSTANCE.getSAMOperator_SamSchemaValues();

		/**
         * The meta object literal for the '<em><b>Sam Source Operators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_OPERATOR__SAM_SOURCE_OPERATORS = eINSTANCE.getSAMOperator_SamSourceOperators();

		/**
         * The meta object literal for the '<em><b>Sam Target Operators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_OPERATOR__SAM_TARGET_OPERATORS = eINSTANCE.getSAMOperator_SamTargetOperators();

		/**
         * The meta object literal for the '<em><b>Sam Schema Actions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_OPERATOR__SAM_SCHEMA_ACTIONS = eINSTANCE.getSAMOperator_SamSchemaActions();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMSchemaVariableImpl <em>SAM Schema Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMSchemaVariableImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaVariable()
         * @generated
         */
		EClass SAM_SCHEMA_VARIABLE = eINSTANCE.getSAMSchemaVariable();

		/**
         * The meta object literal for the '<em><b>Has State Guard</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD = eINSTANCE.getSAMSchemaVariable_HasStateGuard();

		/**
         * The meta object literal for the '<em><b>Sam Status Schema</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA = eINSTANCE.getSAMSchemaVariable_SamStatusSchema();

		/**
         * The meta object literal for the '<em><b>Sam Schema Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES = eINSTANCE.getSAMSchemaVariable_SamSchemaValues();

		/**
         * The meta object literal for the '<em><b>Sam Schema Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE = eINSTANCE.getSAMSchemaVariable_SamSchemaValue();

		/**
         * The meta object literal for the '<em><b>Sam Target Schema Derivators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS = eINSTANCE.getSAMSchemaVariable_SamTargetSchemaDerivators();

		/**
         * The meta object literal for the '<em><b>Sam Source Schema Derivators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS = eINSTANCE.getSAMSchemaVariable_SamSourceSchemaDerivators();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMSchemaValueImpl <em>SAM Schema Value</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMSchemaValueImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaValue()
         * @generated
         */
		EClass SAM_SCHEMA_VALUE = eINSTANCE.getSAMSchemaValue();

		/**
         * The meta object literal for the '<em><b>Is Initial</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_SCHEMA_VALUE__IS_INITIAL = eINSTANCE.getSAMSchemaValue_IsInitial();

		/**
         * The meta object literal for the '<em><b>Is Inhibiting</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SAM_SCHEMA_VALUE__IS_INHIBITING = eINSTANCE.getSAMSchemaValue_IsInhibiting();

		/**
         * The meta object literal for the '<em><b>Sam Schema Variable</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE = eINSTANCE.getSAMSchemaValue_SamSchemaVariable();

		/**
         * The meta object literal for the '<em><b>Sam Source Schema Actions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS = eINSTANCE.getSAMSchemaValue_SamSourceSchemaActions();

		/**
         * The meta object literal for the '<em><b>Sam Source Schema Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES = eINSTANCE.getSAMSchemaValue_SamSourceSchemaValues();

		/**
         * The meta object literal for the '<em><b>Sam Target Schema Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES = eINSTANCE.getSAMSchemaValue_SamTargetSchemaValues();

		/**
         * The meta object literal for the '<em><b>Sam Operators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VALUE__SAM_OPERATORS = eINSTANCE.getSAMSchemaValue_SamOperators();

		/**
         * The meta object literal for the '<em><b>Sam Schema Actions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS = eINSTANCE.getSAMSchemaValue_SamSchemaActions();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMSchemaActionImpl <em>SAM Schema Action</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMSchemaActionImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaAction()
         * @generated
         */
		EClass SAM_SCHEMA_ACTION = eINSTANCE.getSAMSchemaAction();

		/**
         * The meta object literal for the '<em><b>Sam Status Schema</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA = eINSTANCE.getSAMSchemaAction_SamStatusSchema();

		/**
         * The meta object literal for the '<em><b>Sam Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_ACTION__SAM_ACTION = eINSTANCE.getSAMSchemaAction_SamAction();

		/**
         * The meta object literal for the '<em><b>Sam Target Schema Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES = eINSTANCE.getSAMSchemaAction_SamTargetSchemaValues();

		/**
         * The meta object literal for the '<em><b>Sam Schema Values</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES = eINSTANCE.getSAMSchemaAction_SamSchemaValues();

		/**
         * The meta object literal for the '<em><b>Sam Schema Operators</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS = eINSTANCE.getSAMSchemaAction_SamSchemaOperators();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl <em>SAM Schema Derivator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.impl.SAMSchemaDerivatorImpl
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMSchemaDerivator()
         * @generated
         */
		EClass SAM_SCHEMA_DERIVATOR = eINSTANCE.getSAMSchemaDerivator();

		/**
         * The meta object literal for the '<em><b>Sam Derivator</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR = eINSTANCE.getSAMSchemaDerivator_SamDerivator();

		/**
         * The meta object literal for the '<em><b>Sam Status Schema</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA = eINSTANCE.getSAMSchemaDerivator_SamStatusSchema();

		/**
         * The meta object literal for the '<em><b>Sam Source Schema Variables</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES = eINSTANCE.getSAMSchemaDerivator_SamSourceSchemaVariables();

		/**
         * The meta object literal for the '<em><b>Sam Target Schema Variable</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE = eINSTANCE.getSAMSchemaDerivator_SamTargetSchemaVariable();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.SAMOperatorKindEnum <em>SAM Operator Kind Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.SAMOperatorKindEnum
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMOperatorKindEnum()
         * @generated
         */
		EEnum SAM_OPERATOR_KIND_ENUM = eINSTANCE.getSAMOperatorKindEnum();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.SAMDerivatorKindEnum <em>SAM Derivator Kind Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.SAMDerivatorKindEnum
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getSAMDerivatorKindEnum()
         * @generated
         */
		EEnum SAM_DERIVATOR_KIND_ENUM = eINSTANCE.getSAMDerivatorKindEnum();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action_old.PreconditionKindEnum <em>Precondition Kind Enum</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action_old.PreconditionKindEnum
         * @see behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl#getPreconditionKindEnum()
         * @generated
         */
		EEnum PRECONDITION_KIND_ENUM = eINSTANCE.getPreconditionKindEnum();

	}

} //Status_and_action_oldPackage
