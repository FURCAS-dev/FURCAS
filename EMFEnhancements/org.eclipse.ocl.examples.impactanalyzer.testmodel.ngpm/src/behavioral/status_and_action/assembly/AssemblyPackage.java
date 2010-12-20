/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action.assembly;

import behavioral.status_and_action.design.DesignPackage;

import modelmanagement.ModelmanagementPackage;

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
 * @see behavioral.status_and_action.assembly.AssemblyFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface AssemblyPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "assembly";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/status_and_action/assembly.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.status_and_action.assembly";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	AssemblyPackage eINSTANCE = behavioral.status_and_action.assembly.impl.AssemblyPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.StatusSchemaImpl <em>Status Schema</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.StatusSchemaImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStatusSchema()
     * @generated
     */
	int STATUS_SCHEMA = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_SCHEMA__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_SCHEMA__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_SCHEMA__NODE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Elements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_SCHEMA__ELEMENTS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Status Schema</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_SCHEMA_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.SchemaElementImpl <em>Schema Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.SchemaElementImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getSchemaElement()
     * @generated
     */
	int SCHEMA_ELEMENT = 17;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SCHEMA_ELEMENT__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SCHEMA_ELEMENT__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The number of structural features of the '<em>Schema Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SCHEMA_ELEMENT_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.ConnectorImpl <em>Connector</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.ConnectorImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getConnector()
     * @generated
     */
	int CONNECTOR = 1;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTOR__NAME = SCHEMA_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTOR__DESCRIPTION = SCHEMA_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTOR__SOURCE = SCHEMA_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTOR__TARGET = SCHEMA_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Connector</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTOR_FEATURE_COUNT = SCHEMA_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.ConnectableElementImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getConnectableElement()
     * @generated
     */
	int CONNECTABLE_ELEMENT = 3;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTABLE_ELEMENT__NAME = SCHEMA_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTABLE_ELEMENT__DESCRIPTION = SCHEMA_ELEMENT__DESCRIPTION;

	/**
     * The number of structural features of the '<em>Connectable Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONNECTABLE_ELEMENT_FEATURE_COUNT = SCHEMA_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.OperatorImpl <em>Operator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.OperatorImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getOperator()
     * @generated
     */
	int OPERATOR = 2;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATOR__NAME = CONNECTABLE_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATOR__DESCRIPTION = CONNECTABLE_ELEMENT__DESCRIPTION;

	/**
     * The number of structural features of the '<em>Operator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OPERATOR_FEATURE_COUNT = CONNECTABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.ActionProxyImpl <em>Action Proxy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.ActionProxyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getActionProxy()
     * @generated
     */
	int ACTION_PROXY = 4;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_PROXY__NAME = DesignPackage.ABSTRACT_ACTION__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_PROXY__DESCRIPTION = DesignPackage.ABSTRACT_ACTION__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_PROXY__IS_AGENT = DesignPackage.ABSTRACT_ACTION__IS_AGENT;

	/**
     * The feature id for the '<em><b>Is Precondition Fixed</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_PROXY__IS_PRECONDITION_FIXED = DesignPackage.ABSTRACT_ACTION__IS_PRECONDITION_FIXED;

	/**
     * The feature id for the '<em><b>Action</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_PROXY__ACTION = DesignPackage.ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Action Proxy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ACTION_PROXY_FEATURE_COUNT = DesignPackage.ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.StatusValueProxyImpl <em>Status Value Proxy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.StatusValueProxyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStatusValueProxy()
     * @generated
     */
	int STATUS_VALUE_PROXY = 5;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY__NAME = DesignPackage.ABSTRACT_STATUS_VALUE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY__DESCRIPTION = DesignPackage.ABSTRACT_STATUS_VALUE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Initial</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY__IS_INITIAL = DesignPackage.ABSTRACT_STATUS_VALUE__IS_INITIAL;

	/**
     * The feature id for the '<em><b>Is Inhibiting</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY__IS_INHIBITING = DesignPackage.ABSTRACT_STATUS_VALUE__IS_INHIBITING;

	/**
     * The feature id for the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY__IS_STATE_GUARDED = DesignPackage.ABSTRACT_STATUS_VALUE__IS_STATE_GUARDED;

	/**
     * The feature id for the '<em><b>Value</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY__VALUE = DesignPackage.ABSTRACT_STATUS_VALUE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Status Value Proxy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VALUE_PROXY_FEATURE_COUNT = DesignPackage.ABSTRACT_STATUS_VALUE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.TransitionImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getTransition()
     * @generated
     */
	int TRANSITION = 6;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__NAME = CONNECTOR__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__DESCRIPTION = CONNECTOR__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__SOURCE = CONNECTOR__SOURCE;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION__TARGET = CONNECTOR__TARGET;

	/**
     * The number of structural features of the '<em>Transition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TRANSITION_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.SynchroniserImpl <em>Synchroniser</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.SynchroniserImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getSynchroniser()
     * @generated
     */
	int SYNCHRONISER = 7;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SYNCHRONISER__NAME = CONNECTOR__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SYNCHRONISER__DESCRIPTION = CONNECTOR__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SYNCHRONISER__SOURCE = CONNECTOR__SOURCE;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SYNCHRONISER__TARGET = CONNECTOR__TARGET;

	/**
     * The number of structural features of the '<em>Synchroniser</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SYNCHRONISER_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.PreconditionImpl <em>Precondition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.PreconditionImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getPrecondition()
     * @generated
     */
	int PRECONDITION = 8;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECONDITION__NAME = CONNECTOR__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECONDITION__DESCRIPTION = CONNECTOR__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECONDITION__SOURCE = CONNECTOR__SOURCE;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECONDITION__TARGET = CONNECTOR__TARGET;

	/**
     * The feature id for the '<em><b>Strategy</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECONDITION__STRATEGY = CONNECTOR_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Precondition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int PRECONDITION_FEATURE_COUNT = CONNECTOR_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.StatusVariableProxyImpl <em>Status Variable Proxy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.StatusVariableProxyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStatusVariableProxy()
     * @generated
     */
	int STATUS_VARIABLE_PROXY = 9;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY__NAME = DesignPackage.ABSTRACT_STATUS_VARIABLE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY__DESCRIPTION = DesignPackage.ABSTRACT_STATUS_VARIABLE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Is Agent</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY__IS_AGENT = DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_AGENT;

	/**
     * The feature id for the '<em><b>Is State Guarded</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY__IS_STATE_GUARDED = DesignPackage.ABSTRACT_STATUS_VARIABLE__IS_STATE_GUARDED;

	/**
     * The feature id for the '<em><b>Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY__VALUES = DesignPackage.ABSTRACT_STATUS_VARIABLE__VALUES;

	/**
     * The feature id for the '<em><b>Variable</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY__VARIABLE = DesignPackage.ABSTRACT_STATUS_VARIABLE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Status Variable Proxy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATUS_VARIABLE_PROXY_FEATURE_COUNT = DesignPackage.ABSTRACT_STATUS_VARIABLE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.AndOperatorImpl <em>And Operator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.AndOperatorImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getAndOperator()
     * @generated
     */
	int AND_OPERATOR = 10;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AND_OPERATOR__NAME = OPERATOR__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AND_OPERATOR__DESCRIPTION = OPERATOR__DESCRIPTION;

	/**
     * The number of structural features of the '<em>And Operator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AND_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.OrOperatorImpl <em>Or Operator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.OrOperatorImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getOrOperator()
     * @generated
     */
	int OR_OPERATOR = 11;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OR_OPERATOR__NAME = OPERATOR__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OR_OPERATOR__DESCRIPTION = OPERATOR__DESCRIPTION;

	/**
     * The number of structural features of the '<em>Or Operator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OR_OPERATOR_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.StrategyImpl <em>Strategy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.StrategyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStrategy()
     * @generated
     */
	int STRATEGY = 16;

	/**
     * The number of structural features of the '<em>Strategy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRATEGY_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.RequiredStrategyImpl <em>Required Strategy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.RequiredStrategyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getRequiredStrategy()
     * @generated
     */
	int REQUIRED_STRATEGY = 12;

	/**
     * The number of structural features of the '<em>Required Strategy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REQUIRED_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.NeutralStrategyImpl <em>Neutral Strategy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.NeutralStrategyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getNeutralStrategy()
     * @generated
     */
	int NEUTRAL_STRATEGY = 13;

	/**
     * The number of structural features of the '<em>Neutral Strategy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NEUTRAL_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.EnablingStrategyImpl <em>Enabling Strategy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.EnablingStrategyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getEnablingStrategy()
     * @generated
     */
	int ENABLING_STRATEGY = 14;

	/**
     * The number of structural features of the '<em>Enabling Strategy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ENABLING_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.status_and_action.assembly.impl.InhibitingStrategyImpl <em>Inhibiting Strategy</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.status_and_action.assembly.impl.InhibitingStrategyImpl
     * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getInhibitingStrategy()
     * @generated
     */
	int INHIBITING_STRATEGY = 15;

	/**
     * The number of structural features of the '<em>Inhibiting Strategy</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INHIBITING_STRATEGY_FEATURE_COUNT = STRATEGY_FEATURE_COUNT + 0;


	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.StatusSchema <em>Status Schema</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status Schema</em>'.
     * @see behavioral.status_and_action.assembly.StatusSchema
     * @generated
     */
	EClass getStatusSchema();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.StatusSchema#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Node</em>'.
     * @see behavioral.status_and_action.assembly.StatusSchema#getNode()
     * @see #getStatusSchema()
     * @generated
     */
	EReference getStatusSchema_Node();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.status_and_action.assembly.StatusSchema#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Elements</em>'.
     * @see behavioral.status_and_action.assembly.StatusSchema#getElements()
     * @see #getStatusSchema()
     * @generated
     */
	EReference getStatusSchema_Elements();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.Connector <em>Connector</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connector</em>'.
     * @see behavioral.status_and_action.assembly.Connector
     * @generated
     */
	EClass getConnector();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.Connector#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see behavioral.status_and_action.assembly.Connector#getSource()
     * @see #getConnector()
     * @generated
     */
	EReference getConnector_Source();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.Connector#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see behavioral.status_and_action.assembly.Connector#getTarget()
     * @see #getConnector()
     * @generated
     */
	EReference getConnector_Target();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.Operator <em>Operator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operator</em>'.
     * @see behavioral.status_and_action.assembly.Operator
     * @generated
     */
	EClass getOperator();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.ConnectableElement <em>Connectable Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connectable Element</em>'.
     * @see behavioral.status_and_action.assembly.ConnectableElement
     * @generated
     */
	EClass getConnectableElement();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.ActionProxy <em>Action Proxy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Action Proxy</em>'.
     * @see behavioral.status_and_action.assembly.ActionProxy
     * @generated
     */
	EClass getActionProxy();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.ActionProxy#getAction <em>Action</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Action</em>'.
     * @see behavioral.status_and_action.assembly.ActionProxy#getAction()
     * @see #getActionProxy()
     * @generated
     */
	EReference getActionProxy_Action();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.StatusValueProxy <em>Status Value Proxy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status Value Proxy</em>'.
     * @see behavioral.status_and_action.assembly.StatusValueProxy
     * @generated
     */
	EClass getStatusValueProxy();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.StatusValueProxy#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value</em>'.
     * @see behavioral.status_and_action.assembly.StatusValueProxy#getValue()
     * @see #getStatusValueProxy()
     * @generated
     */
	EReference getStatusValueProxy_Value();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.Transition <em>Transition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Transition</em>'.
     * @see behavioral.status_and_action.assembly.Transition
     * @generated
     */
	EClass getTransition();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.Synchroniser <em>Synchroniser</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Synchroniser</em>'.
     * @see behavioral.status_and_action.assembly.Synchroniser
     * @generated
     */
	EClass getSynchroniser();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.Precondition <em>Precondition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Precondition</em>'.
     * @see behavioral.status_and_action.assembly.Precondition
     * @generated
     */
	EClass getPrecondition();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.Precondition#getStrategy <em>Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Strategy</em>'.
     * @see behavioral.status_and_action.assembly.Precondition#getStrategy()
     * @see #getPrecondition()
     * @generated
     */
	EReference getPrecondition_Strategy();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.StatusVariableProxy <em>Status Variable Proxy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status Variable Proxy</em>'.
     * @see behavioral.status_and_action.assembly.StatusVariableProxy
     * @generated
     */
	EClass getStatusVariableProxy();

	/**
     * Returns the meta object for the reference '{@link behavioral.status_and_action.assembly.StatusVariableProxy#getVariable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Variable</em>'.
     * @see behavioral.status_and_action.assembly.StatusVariableProxy#getVariable()
     * @see #getStatusVariableProxy()
     * @generated
     */
	EReference getStatusVariableProxy_Variable();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.AndOperator <em>And Operator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>And Operator</em>'.
     * @see behavioral.status_and_action.assembly.AndOperator
     * @generated
     */
	EClass getAndOperator();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.OrOperator <em>Or Operator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Or Operator</em>'.
     * @see behavioral.status_and_action.assembly.OrOperator
     * @generated
     */
	EClass getOrOperator();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.RequiredStrategy <em>Required Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Required Strategy</em>'.
     * @see behavioral.status_and_action.assembly.RequiredStrategy
     * @generated
     */
	EClass getRequiredStrategy();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.NeutralStrategy <em>Neutral Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Neutral Strategy</em>'.
     * @see behavioral.status_and_action.assembly.NeutralStrategy
     * @generated
     */
	EClass getNeutralStrategy();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.EnablingStrategy <em>Enabling Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Enabling Strategy</em>'.
     * @see behavioral.status_and_action.assembly.EnablingStrategy
     * @generated
     */
	EClass getEnablingStrategy();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.InhibitingStrategy <em>Inhibiting Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Inhibiting Strategy</em>'.
     * @see behavioral.status_and_action.assembly.InhibitingStrategy
     * @generated
     */
	EClass getInhibitingStrategy();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.Strategy <em>Strategy</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Strategy</em>'.
     * @see behavioral.status_and_action.assembly.Strategy
     * @generated
     */
	EClass getStrategy();

	/**
     * Returns the meta object for class '{@link behavioral.status_and_action.assembly.SchemaElement <em>Schema Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Schema Element</em>'.
     * @see behavioral.status_and_action.assembly.SchemaElement
     * @generated
     */
	EClass getSchemaElement();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	AssemblyFactory getAssemblyFactory();

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
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.StatusSchemaImpl <em>Status Schema</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.StatusSchemaImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStatusSchema()
         * @generated
         */
		EClass STATUS_SCHEMA = eINSTANCE.getStatusSchema();

		/**
         * The meta object literal for the '<em><b>Node</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATUS_SCHEMA__NODE = eINSTANCE.getStatusSchema_Node();

		/**
         * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATUS_SCHEMA__ELEMENTS = eINSTANCE.getStatusSchema_Elements();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.ConnectorImpl <em>Connector</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.ConnectorImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getConnector()
         * @generated
         */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONNECTOR__SOURCE = eINSTANCE.getConnector_Source();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONNECTOR__TARGET = eINSTANCE.getConnector_Target();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.OperatorImpl <em>Operator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.OperatorImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getOperator()
         * @generated
         */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.ConnectableElementImpl <em>Connectable Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.ConnectableElementImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getConnectableElement()
         * @generated
         */
		EClass CONNECTABLE_ELEMENT = eINSTANCE.getConnectableElement();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.ActionProxyImpl <em>Action Proxy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.ActionProxyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getActionProxy()
         * @generated
         */
		EClass ACTION_PROXY = eINSTANCE.getActionProxy();

		/**
         * The meta object literal for the '<em><b>Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ACTION_PROXY__ACTION = eINSTANCE.getActionProxy_Action();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.StatusValueProxyImpl <em>Status Value Proxy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.StatusValueProxyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStatusValueProxy()
         * @generated
         */
		EClass STATUS_VALUE_PROXY = eINSTANCE.getStatusValueProxy();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATUS_VALUE_PROXY__VALUE = eINSTANCE.getStatusValueProxy_Value();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.TransitionImpl <em>Transition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.TransitionImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getTransition()
         * @generated
         */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.SynchroniserImpl <em>Synchroniser</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.SynchroniserImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getSynchroniser()
         * @generated
         */
		EClass SYNCHRONISER = eINSTANCE.getSynchroniser();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.PreconditionImpl <em>Precondition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.PreconditionImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getPrecondition()
         * @generated
         */
		EClass PRECONDITION = eINSTANCE.getPrecondition();

		/**
         * The meta object literal for the '<em><b>Strategy</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference PRECONDITION__STRATEGY = eINSTANCE.getPrecondition_Strategy();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.StatusVariableProxyImpl <em>Status Variable Proxy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.StatusVariableProxyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStatusVariableProxy()
         * @generated
         */
		EClass STATUS_VARIABLE_PROXY = eINSTANCE.getStatusVariableProxy();

		/**
         * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATUS_VARIABLE_PROXY__VARIABLE = eINSTANCE.getStatusVariableProxy_Variable();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.AndOperatorImpl <em>And Operator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.AndOperatorImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getAndOperator()
         * @generated
         */
		EClass AND_OPERATOR = eINSTANCE.getAndOperator();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.OrOperatorImpl <em>Or Operator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.OrOperatorImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getOrOperator()
         * @generated
         */
		EClass OR_OPERATOR = eINSTANCE.getOrOperator();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.RequiredStrategyImpl <em>Required Strategy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.RequiredStrategyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getRequiredStrategy()
         * @generated
         */
		EClass REQUIRED_STRATEGY = eINSTANCE.getRequiredStrategy();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.NeutralStrategyImpl <em>Neutral Strategy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.NeutralStrategyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getNeutralStrategy()
         * @generated
         */
		EClass NEUTRAL_STRATEGY = eINSTANCE.getNeutralStrategy();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.EnablingStrategyImpl <em>Enabling Strategy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.EnablingStrategyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getEnablingStrategy()
         * @generated
         */
		EClass ENABLING_STRATEGY = eINSTANCE.getEnablingStrategy();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.InhibitingStrategyImpl <em>Inhibiting Strategy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.InhibitingStrategyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getInhibitingStrategy()
         * @generated
         */
		EClass INHIBITING_STRATEGY = eINSTANCE.getInhibitingStrategy();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.StrategyImpl <em>Strategy</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.StrategyImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getStrategy()
         * @generated
         */
		EClass STRATEGY = eINSTANCE.getStrategy();

		/**
         * The meta object literal for the '{@link behavioral.status_and_action.assembly.impl.SchemaElementImpl <em>Schema Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.status_and_action.assembly.impl.SchemaElementImpl
         * @see behavioral.status_and_action.assembly.impl.AssemblyPackageImpl#getSchemaElement()
         * @generated
         */
		EClass SCHEMA_ELEMENT = eINSTANCE.getSchemaElement();

	}

} //AssemblyPackage
