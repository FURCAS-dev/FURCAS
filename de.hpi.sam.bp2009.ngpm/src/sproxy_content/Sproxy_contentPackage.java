/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import modelmanagement.ModelmanagementPackage;

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
 * @see sproxy_content.Sproxy_contentFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface Sproxy_contentPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "sproxy_content";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///sproxy_content.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "sproxy_content";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Sproxy_contentPackage eINSTANCE = sproxy_content.impl.Sproxy_contentPackageImpl.init();

  /**
   * The meta object id for the '{@link sproxy_content.impl.BOImpl <em>BO</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.BOImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getBO()
   * @generated
   */
  int BO = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Root Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO__ROOT_NODE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Status Derivators</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO__STATUS_DERIVATORS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Template</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO__TEMPLATE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Projections</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO__PROJECTIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>BO</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link sproxy_content.impl.BONodeImpl <em>BO Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.BONodeImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getBONode()
   * @generated
   */
  int BO_NODE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Node Data Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__NODE_DATA_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Bo</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__BO = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__ACTIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Status And Action Schemas</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__STATUS_AND_ACTION_SCHEMAS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Association</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__ASSOCIATION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Outbound Associations</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__OUTBOUND_ASSOCIATIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__QUERIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__PROPERTIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Field Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE__FIELD_PROPERTIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>BO Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BO_NODE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link sproxy_content.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.DataTypeImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__ELEMENTS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__ATTRIBUTES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Abap Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__ABAP_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link sproxy_content.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.OperationImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Parameter Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__PARAMETER_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__PROPERTIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link sproxy_content.impl.QueryImpl <em>Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.QueryImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getQuery()
   * @generated
   */
  int QUERY = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__NAME = OPERATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__DESCRIPTION = OPERATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Parameter Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__PARAMETER_TYPE = OPERATION__PARAMETER_TYPE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY__PROPERTIES = OPERATION__PROPERTIES;

  /**
   * The number of structural features of the '<em>Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link sproxy_content.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.ActionImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAction()
   * @generated
   */
  int ACTION = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__NAME = OPERATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__DESCRIPTION = OPERATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Parameter Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__PARAMETER_TYPE = OPERATION__PARAMETER_TYPE;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__PROPERTIES = OPERATION__PROPERTIES;

  /**
   * The feature id for the '<em><b>Cardinality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__CARDINALITY = OPERATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link sproxy_content.impl.ServiceInterfaceImpl <em>Service Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.ServiceInterfaceImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getServiceInterface()
   * @generated
   */
  int SERVICE_INTERFACE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Operations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE__OPERATIONS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Service Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link sproxy_content.impl.ServiceInterfaceOperationImpl <em>Service Interface Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.ServiceInterfaceOperationImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getServiceInterfaceOperation()
   * @generated
   */
  int SERVICE_INTERFACE_OPERATION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_OPERATION__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_OPERATION__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Request Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Response Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Fault Message Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Service Interface Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SERVICE_INTERFACE_OPERATION_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link sproxy_content.impl.ProcessAgentImpl <em>Process Agent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.ProcessAgentImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getProcessAgent()
   * @generated
   */
  int PROCESS_AGENT = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_AGENT__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_AGENT__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The number of structural features of the '<em>Process Agent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROCESS_AGENT_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link sproxy_content.impl.OutboundProcessAgentImpl <em>Outbound Process Agent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.OutboundProcessAgentImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getOutboundProcessAgent()
   * @generated
   */
  int OUTBOUND_PROCESS_AGENT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTBOUND_PROCESS_AGENT__NAME = PROCESS_AGENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTBOUND_PROCESS_AGENT__DESCRIPTION = PROCESS_AGENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Outbound Service Interface</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE = PROCESS_AGENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Outbound Process Agent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTBOUND_PROCESS_AGENT_FEATURE_COUNT = PROCESS_AGENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link sproxy_content.impl.InboundProcessAgentImpl <em>Inbound Process Agent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.InboundProcessAgentImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getInboundProcessAgent()
   * @generated
   */
  int INBOUND_PROCESS_AGENT = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INBOUND_PROCESS_AGENT__NAME = PROCESS_AGENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INBOUND_PROCESS_AGENT__DESCRIPTION = PROCESS_AGENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Inbound Service Interfaces</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES = PROCESS_AGENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inbound Process Agent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INBOUND_PROCESS_AGENT_FEATURE_COUNT = PROCESS_AGENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link sproxy_content.impl.StatusAndActionSchemaImpl <em>Status And Action Schema</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.StatusAndActionSchemaImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getStatusAndActionSchema()
   * @generated
   */
  int STATUS_AND_ACTION_SCHEMA = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_AND_ACTION_SCHEMA__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_AND_ACTION_SCHEMA__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Status Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Status And Action Schema</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_AND_ACTION_SCHEMA_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link sproxy_content.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.ElementImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__PROPERTIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link sproxy_content.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.AttributeImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__PROPERTIES = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Status Attribute</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__STATUS_ATTRIBUTE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Abap Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__ABAP_TYPE = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link sproxy_content.impl.DOImpl <em>DO</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.DOImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getDO()
   * @generated
   */
  int DO = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO__NAME = BO__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO__DESCRIPTION = BO__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Root Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO__ROOT_NODE = BO__ROOT_NODE;

  /**
   * The feature id for the '<em><b>Status Derivators</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO__STATUS_DERIVATORS = BO__STATUS_DERIVATORS;

  /**
   * The feature id for the '<em><b>Template</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO__TEMPLATE = BO__TEMPLATE;

  /**
   * The feature id for the '<em><b>Projections</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO__PROJECTIONS = BO__PROJECTIONS;

  /**
   * The number of structural features of the '<em>DO</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_FEATURE_COUNT = BO_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link sproxy_content.impl.AssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.AssociationImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAssociation()
   * @generated
   */
  int ASSOCIATION = 14;

  /**
   * The feature id for the '<em><b>Composite</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__COMPOSITE = 0;

  /**
   * The feature id for the '<em><b>Target Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__TARGET_NODE = 1;

  /**
   * The feature id for the '<em><b>Owner</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__OWNER = 2;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__PROPERTIES = 3;

  /**
   * The number of structural features of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link sproxy_content.impl.StatusDerivatorImpl <em>Status Derivator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.StatusDerivatorImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getStatusDerivator()
   * @generated
   */
  int STATUS_DERIVATOR = 16;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_DERIVATOR__SOURCE = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_DERIVATOR__TARGET = 1;

  /**
   * The number of structural features of the '<em>Status Derivator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATUS_DERIVATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link sproxy_content.impl.PopulationImpl <em>Population</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.PopulationImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getPopulation()
   * @generated
   */
  int POPULATION = 17;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POPULATION__SOURCE = STATUS_DERIVATOR__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POPULATION__TARGET = STATUS_DERIVATOR__TARGET;

  /**
   * The number of structural features of the '<em>Population</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POPULATION_FEATURE_COUNT = STATUS_DERIVATOR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link sproxy_content.impl.AggregationImpl <em>Aggregation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.AggregationImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAggregation()
   * @generated
   */
  int AGGREGATION = 18;

  /**
   * The feature id for the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION__SOURCE = STATUS_DERIVATOR__SOURCE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION__TARGET = STATUS_DERIVATOR__TARGET;

  /**
   * The number of structural features of the '<em>Aggregation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATION_FEATURE_COUNT = STATUS_DERIVATOR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link sproxy_content.impl.AssociationPropertiesImpl <em>Association Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.AssociationPropertiesImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAssociationProperties()
   * @generated
   */
  int ASSOCIATION_PROPERTIES = 19;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_PROPERTIES__ENABLED = 0;

  /**
   * The feature id for the '<em><b>Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_PROPERTIES__ENABLED_FINAL = 1;

  /**
   * The feature id for the '<em><b>Create Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_PROPERTIES__CREATE_ENABLED = 2;

  /**
   * The feature id for the '<em><b>Create Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_PROPERTIES__CREATE_ENABLED_FINAL = 3;

  /**
   * The number of structural features of the '<em>Association Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_PROPERTIES_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link sproxy_content.impl.NodePropertiesImpl <em>Node Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.NodePropertiesImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getNodeProperties()
   * @generated
   */
  int NODE_PROPERTIES = 20;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__ENABLED = 0;

  /**
   * The feature id for the '<em><b>Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__ENABLED_FINAL = 1;

  /**
   * The feature id for the '<em><b>Create Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__CREATE_ENABLED = 2;

  /**
   * The feature id for the '<em><b>Create Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__CREATE_ENABLED_FINAL = 3;

  /**
   * The feature id for the '<em><b>Update Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__UPDATE_ENABLED = 4;

  /**
   * The feature id for the '<em><b>Update Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__UPDATE_ENABLED_FINAL = 5;

  /**
   * The feature id for the '<em><b>Delete Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__DELETE_ENABLED = 6;

  /**
   * The feature id for the '<em><b>Delete Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__DELETE_ENABLED_FINAL = 7;

  /**
   * The feature id for the '<em><b>Transient Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__TRANSIENT_KEY = 8;

  /**
   * The feature id for the '<em><b>Transient Key Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES__TRANSIENT_KEY_FINAL = 9;

  /**
   * The number of structural features of the '<em>Node Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_PROPERTIES_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link sproxy_content.impl.OperationPropertiesImpl <em>Operation Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.OperationPropertiesImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getOperationProperties()
   * @generated
   */
  int OPERATION_PROPERTIES = 21;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_PROPERTIES__ENABLED = 0;

  /**
   * The feature id for the '<em><b>Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_PROPERTIES__ENABLED_FINAL = 1;

  /**
   * The number of structural features of the '<em>Operation Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_PROPERTIES_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link sproxy_content.impl.FieldPropertiesImpl <em>Field Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.FieldPropertiesImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getFieldProperties()
   * @generated
   */
  int FIELD_PROPERTIES = 22;

  /**
   * The feature id for the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__ENABLED = 0;

  /**
   * The feature id for the '<em><b>Enabled Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__ENABLED_FINAL = 1;

  /**
   * The feature id for the '<em><b>Readonly</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__READONLY = 2;

  /**
   * The feature id for the '<em><b>Readonly Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__READONLY_FINAL = 3;

  /**
   * The feature id for the '<em><b>Mandatory</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__MANDATORY = 4;

  /**
   * The feature id for the '<em><b>Mandatory Final</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__MANDATORY_FINAL = 5;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES__FIELD = 6;

  /**
   * The number of structural features of the '<em>Field Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_PROPERTIES_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link sproxy_content.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.FieldImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getField()
   * @generated
   */
  int FIELD = 23;

  /**
   * The feature id for the '<em><b>Properties</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__PROPERTIES = 0;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link sproxy_content.impl.LanguageDependentTextImpl <em>Language Dependent Text</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.impl.LanguageDependentTextImpl
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getLanguageDependentText()
   * @generated
   */
  int LANGUAGE_DEPENDENT_TEXT = 24;

  /**
   * The number of structural features of the '<em>Language Dependent Text</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LANGUAGE_DEPENDENT_TEXT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link sproxy_content.Cardinality <em>Cardinality</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see sproxy_content.Cardinality
   * @see sproxy_content.impl.Sproxy_contentPackageImpl#getCardinality()
   * @generated
   */
  int CARDINALITY = 25;


  /**
   * Returns the meta object for class '{@link sproxy_content.BO <em>BO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>BO</em>'.
   * @see sproxy_content.BO
   * @generated
   */
  EClass getBO();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.BO#getRootNode <em>Root Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root Node</em>'.
   * @see sproxy_content.BO#getRootNode()
   * @see #getBO()
   * @generated
   */
  EReference getBO_RootNode();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.BO#getStatusDerivators <em>Status Derivators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Status Derivators</em>'.
   * @see sproxy_content.BO#getStatusDerivators()
   * @see #getBO()
   * @generated
   */
  EReference getBO_StatusDerivators();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.BO#getTemplate <em>Template</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Template</em>'.
   * @see sproxy_content.BO#getTemplate()
   * @see #getBO()
   * @generated
   */
  EReference getBO_Template();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.BO#getProjections <em>Projections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Projections</em>'.
   * @see sproxy_content.BO#getProjections()
   * @see #getBO()
   * @generated
   */
  EReference getBO_Projections();

  /**
   * Returns the meta object for class '{@link sproxy_content.BONode <em>BO Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>BO Node</em>'.
   * @see sproxy_content.BONode
   * @generated
   */
  EClass getBONode();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.BONode#getNodeDataType <em>Node Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Node Data Type</em>'.
   * @see sproxy_content.BONode#getNodeDataType()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_NodeDataType();

  /**
   * Returns the meta object for the container reference '{@link sproxy_content.BONode#getBo <em>Bo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Bo</em>'.
   * @see sproxy_content.BONode#getBo()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_Bo();

  /**
   * Returns the meta object for the containment reference list '{@link sproxy_content.BONode#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see sproxy_content.BONode#getActions()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_Actions();

  /**
   * Returns the meta object for the containment reference list '{@link sproxy_content.BONode#getStatusAndActionSchemas <em>Status And Action Schemas</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Status And Action Schemas</em>'.
   * @see sproxy_content.BONode#getStatusAndActionSchemas()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_StatusAndActionSchemas();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.BONode#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Association</em>'.
   * @see sproxy_content.BONode#getAssociation()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_Association();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.BONode#getOutboundAssociations <em>Outbound Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Outbound Associations</em>'.
   * @see sproxy_content.BONode#getOutboundAssociations()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_OutboundAssociations();

  /**
   * Returns the meta object for the containment reference list '{@link sproxy_content.BONode#getQueries <em>Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Queries</em>'.
   * @see sproxy_content.BONode#getQueries()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_Queries();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.BONode#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Properties</em>'.
   * @see sproxy_content.BONode#getProperties()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_Properties();

  /**
   * Returns the meta object for the containment reference list '{@link sproxy_content.BONode#getFieldProperties <em>Field Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field Properties</em>'.
   * @see sproxy_content.BONode#getFieldProperties()
   * @see #getBONode()
   * @generated
   */
  EReference getBONode_FieldProperties();

  /**
   * Returns the meta object for class '{@link sproxy_content.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see sproxy_content.DataType
   * @generated
   */
  EClass getDataType();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.DataType#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Elements</em>'.
   * @see sproxy_content.DataType#getElements()
   * @see #getDataType()
   * @generated
   */
  EReference getDataType_Elements();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.DataType#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Attributes</em>'.
   * @see sproxy_content.DataType#getAttributes()
   * @see #getDataType()
   * @generated
   */
  EReference getDataType_Attributes();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.DataType#getAbapType <em>Abap Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Abap Type</em>'.
   * @see sproxy_content.DataType#getAbapType()
   * @see #getDataType()
   * @generated
   */
  EReference getDataType_AbapType();

  /**
   * Returns the meta object for class '{@link sproxy_content.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Query</em>'.
   * @see sproxy_content.Query
   * @generated
   */
  EClass getQuery();

  /**
   * Returns the meta object for class '{@link sproxy_content.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see sproxy_content.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for the attribute '{@link sproxy_content.Action#getCardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cardinality</em>'.
   * @see sproxy_content.Action#getCardinality()
   * @see #getAction()
   * @generated
   */
  EAttribute getAction_Cardinality();

  /**
   * Returns the meta object for class '{@link sproxy_content.ServiceInterface <em>Service Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Interface</em>'.
   * @see sproxy_content.ServiceInterface
   * @generated
   */
  EClass getServiceInterface();

  /**
   * Returns the meta object for the containment reference list '{@link sproxy_content.ServiceInterface#getOperations <em>Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operations</em>'.
   * @see sproxy_content.ServiceInterface#getOperations()
   * @see #getServiceInterface()
   * @generated
   */
  EReference getServiceInterface_Operations();

  /**
   * Returns the meta object for class '{@link sproxy_content.ServiceInterfaceOperation <em>Service Interface Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Service Interface Operation</em>'.
   * @see sproxy_content.ServiceInterfaceOperation
   * @generated
   */
  EClass getServiceInterfaceOperation();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.ServiceInterfaceOperation#getRequestMessageType <em>Request Message Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Request Message Type</em>'.
   * @see sproxy_content.ServiceInterfaceOperation#getRequestMessageType()
   * @see #getServiceInterfaceOperation()
   * @generated
   */
  EReference getServiceInterfaceOperation_RequestMessageType();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.ServiceInterfaceOperation#getResponseMessageType <em>Response Message Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Response Message Type</em>'.
   * @see sproxy_content.ServiceInterfaceOperation#getResponseMessageType()
   * @see #getServiceInterfaceOperation()
   * @generated
   */
  EReference getServiceInterfaceOperation_ResponseMessageType();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.ServiceInterfaceOperation#getFaultMessageType <em>Fault Message Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Fault Message Type</em>'.
   * @see sproxy_content.ServiceInterfaceOperation#getFaultMessageType()
   * @see #getServiceInterfaceOperation()
   * @generated
   */
  EReference getServiceInterfaceOperation_FaultMessageType();

  /**
   * Returns the meta object for class '{@link sproxy_content.ProcessAgent <em>Process Agent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Process Agent</em>'.
   * @see sproxy_content.ProcessAgent
   * @generated
   */
  EClass getProcessAgent();

  /**
   * Returns the meta object for class '{@link sproxy_content.OutboundProcessAgent <em>Outbound Process Agent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Outbound Process Agent</em>'.
   * @see sproxy_content.OutboundProcessAgent
   * @generated
   */
  EClass getOutboundProcessAgent();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.OutboundProcessAgent#getOutboundServiceInterface <em>Outbound Service Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Outbound Service Interface</em>'.
   * @see sproxy_content.OutboundProcessAgent#getOutboundServiceInterface()
   * @see #getOutboundProcessAgent()
   * @generated
   */
  EReference getOutboundProcessAgent_OutboundServiceInterface();

  /**
   * Returns the meta object for class '{@link sproxy_content.InboundProcessAgent <em>Inbound Process Agent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inbound Process Agent</em>'.
   * @see sproxy_content.InboundProcessAgent
   * @generated
   */
  EClass getInboundProcessAgent();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.InboundProcessAgent#getInboundServiceInterfaces <em>Inbound Service Interfaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Inbound Service Interfaces</em>'.
   * @see sproxy_content.InboundProcessAgent#getInboundServiceInterfaces()
   * @see #getInboundProcessAgent()
   * @generated
   */
  EReference getInboundProcessAgent_InboundServiceInterfaces();

  /**
   * Returns the meta object for class '{@link sproxy_content.StatusAndActionSchema <em>Status And Action Schema</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Status And Action Schema</em>'.
   * @see sproxy_content.StatusAndActionSchema
   * @generated
   */
  EClass getStatusAndActionSchema();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.StatusAndActionSchema#getStatusVariables <em>Status Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Status Variables</em>'.
   * @see sproxy_content.StatusAndActionSchema#getStatusVariables()
   * @see #getStatusAndActionSchema()
   * @generated
   */
  EReference getStatusAndActionSchema_StatusVariables();

  /**
   * Returns the meta object for class '{@link sproxy_content.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see sproxy_content.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Element#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see sproxy_content.Element#getType()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Type();

  /**
   * Returns the meta object for class '{@link sproxy_content.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see sproxy_content.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.Attribute#getStatusAttribute <em>Status Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Status Attribute</em>'.
   * @see sproxy_content.Attribute#getStatusAttribute()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_StatusAttribute();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Attribute#getAbapType <em>Abap Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Abap Type</em>'.
   * @see sproxy_content.Attribute#getAbapType()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_AbapType();

  /**
   * Returns the meta object for class '{@link sproxy_content.DO <em>DO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>DO</em>'.
   * @see sproxy_content.DO
   * @generated
   */
  EClass getDO();

  /**
   * Returns the meta object for class '{@link sproxy_content.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association</em>'.
   * @see sproxy_content.Association
   * @generated
   */
  EClass getAssociation();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.Association#getComposite <em>Composite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Composite</em>'.
   * @see sproxy_content.Association#getComposite()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_Composite();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Association#getTargetNode <em>Target Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Node</em>'.
   * @see sproxy_content.Association#getTargetNode()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_TargetNode();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Association#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Owner</em>'.
   * @see sproxy_content.Association#getOwner()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_Owner();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Association#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Properties</em>'.
   * @see sproxy_content.Association#getProperties()
   * @see #getAssociation()
   * @generated
   */
  EReference getAssociation_Properties();

  /**
   * Returns the meta object for class '{@link sproxy_content.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see sproxy_content.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Operation#getParameterType <em>Parameter Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter Type</em>'.
   * @see sproxy_content.Operation#getParameterType()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_ParameterType();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.Operation#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Properties</em>'.
   * @see sproxy_content.Operation#getProperties()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Properties();

  /**
   * Returns the meta object for class '{@link sproxy_content.StatusDerivator <em>Status Derivator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Status Derivator</em>'.
   * @see sproxy_content.StatusDerivator
   * @generated
   */
  EClass getStatusDerivator();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.StatusDerivator#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source</em>'.
   * @see sproxy_content.StatusDerivator#getSource()
   * @see #getStatusDerivator()
   * @generated
   */
  EReference getStatusDerivator_Source();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.StatusDerivator#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see sproxy_content.StatusDerivator#getTarget()
   * @see #getStatusDerivator()
   * @generated
   */
  EReference getStatusDerivator_Target();

  /**
   * Returns the meta object for class '{@link sproxy_content.Population <em>Population</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Population</em>'.
   * @see sproxy_content.Population
   * @generated
   */
  EClass getPopulation();

  /**
   * Returns the meta object for class '{@link sproxy_content.Aggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregation</em>'.
   * @see sproxy_content.Aggregation
   * @generated
   */
  EClass getAggregation();

  /**
   * Returns the meta object for class '{@link sproxy_content.AssociationProperties <em>Association Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Properties</em>'.
   * @see sproxy_content.AssociationProperties
   * @generated
   */
  EClass getAssociationProperties();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.AssociationProperties#getEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled</em>'.
   * @see sproxy_content.AssociationProperties#getEnabled()
   * @see #getAssociationProperties()
   * @generated
   */
  EReference getAssociationProperties_Enabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.AssociationProperties#getEnabledFinal <em>Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled Final</em>'.
   * @see sproxy_content.AssociationProperties#getEnabledFinal()
   * @see #getAssociationProperties()
   * @generated
   */
  EReference getAssociationProperties_EnabledFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.AssociationProperties#getCreateEnabled <em>Create Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Create Enabled</em>'.
   * @see sproxy_content.AssociationProperties#getCreateEnabled()
   * @see #getAssociationProperties()
   * @generated
   */
  EReference getAssociationProperties_CreateEnabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.AssociationProperties#getCreateEnabledFinal <em>Create Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Create Enabled Final</em>'.
   * @see sproxy_content.AssociationProperties#getCreateEnabledFinal()
   * @see #getAssociationProperties()
   * @generated
   */
  EReference getAssociationProperties_CreateEnabledFinal();

  /**
   * Returns the meta object for class '{@link sproxy_content.NodeProperties <em>Node Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Properties</em>'.
   * @see sproxy_content.NodeProperties
   * @generated
   */
  EClass getNodeProperties();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled</em>'.
   * @see sproxy_content.NodeProperties#getEnabled()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_Enabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getEnabledFinal <em>Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled Final</em>'.
   * @see sproxy_content.NodeProperties#getEnabledFinal()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_EnabledFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getCreateEnabled <em>Create Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Create Enabled</em>'.
   * @see sproxy_content.NodeProperties#getCreateEnabled()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_CreateEnabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getCreateEnabledFinal <em>Create Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Create Enabled Final</em>'.
   * @see sproxy_content.NodeProperties#getCreateEnabledFinal()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_CreateEnabledFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getUpdateEnabled <em>Update Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Update Enabled</em>'.
   * @see sproxy_content.NodeProperties#getUpdateEnabled()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_UpdateEnabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getUpdateEnabledFinal <em>Update Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Update Enabled Final</em>'.
   * @see sproxy_content.NodeProperties#getUpdateEnabledFinal()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_UpdateEnabledFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getDeleteEnabled <em>Delete Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delete Enabled</em>'.
   * @see sproxy_content.NodeProperties#getDeleteEnabled()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_DeleteEnabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getDeleteEnabledFinal <em>Delete Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delete Enabled Final</em>'.
   * @see sproxy_content.NodeProperties#getDeleteEnabledFinal()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_DeleteEnabledFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getTransientKey <em>Transient Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Transient Key</em>'.
   * @see sproxy_content.NodeProperties#getTransientKey()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_TransientKey();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.NodeProperties#getTransientKeyFinal <em>Transient Key Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Transient Key Final</em>'.
   * @see sproxy_content.NodeProperties#getTransientKeyFinal()
   * @see #getNodeProperties()
   * @generated
   */
  EReference getNodeProperties_TransientKeyFinal();

  /**
   * Returns the meta object for class '{@link sproxy_content.OperationProperties <em>Operation Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Properties</em>'.
   * @see sproxy_content.OperationProperties
   * @generated
   */
  EClass getOperationProperties();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.OperationProperties#getEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled</em>'.
   * @see sproxy_content.OperationProperties#getEnabled()
   * @see #getOperationProperties()
   * @generated
   */
  EReference getOperationProperties_Enabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.OperationProperties#getEnabledFinal <em>Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled Final</em>'.
   * @see sproxy_content.OperationProperties#getEnabledFinal()
   * @see #getOperationProperties()
   * @generated
   */
  EReference getOperationProperties_EnabledFinal();

  /**
   * Returns the meta object for class '{@link sproxy_content.FieldProperties <em>Field Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Properties</em>'.
   * @see sproxy_content.FieldProperties
   * @generated
   */
  EClass getFieldProperties();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.FieldProperties#getEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled</em>'.
   * @see sproxy_content.FieldProperties#getEnabled()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_Enabled();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.FieldProperties#getEnabledFinal <em>Enabled Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled Final</em>'.
   * @see sproxy_content.FieldProperties#getEnabledFinal()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_EnabledFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.FieldProperties#getReadonly <em>Readonly</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Readonly</em>'.
   * @see sproxy_content.FieldProperties#getReadonly()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_Readonly();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.FieldProperties#getReadonlyFinal <em>Readonly Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Readonly Final</em>'.
   * @see sproxy_content.FieldProperties#getReadonlyFinal()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_ReadonlyFinal();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.FieldProperties#getMandatory <em>Mandatory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mandatory</em>'.
   * @see sproxy_content.FieldProperties#getMandatory()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_Mandatory();

  /**
   * Returns the meta object for the containment reference '{@link sproxy_content.FieldProperties#getMandatoryFinal <em>Mandatory Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mandatory Final</em>'.
   * @see sproxy_content.FieldProperties#getMandatoryFinal()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_MandatoryFinal();

  /**
   * Returns the meta object for the reference '{@link sproxy_content.FieldProperties#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see sproxy_content.FieldProperties#getField()
   * @see #getFieldProperties()
   * @generated
   */
  EReference getFieldProperties_Field();

  /**
   * Returns the meta object for class '{@link sproxy_content.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see sproxy_content.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for the reference list '{@link sproxy_content.Field#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Properties</em>'.
   * @see sproxy_content.Field#getProperties()
   * @see #getField()
   * @generated
   */
  EReference getField_Properties();

  /**
   * Returns the meta object for class '{@link sproxy_content.LanguageDependentText <em>Language Dependent Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Language Dependent Text</em>'.
   * @see sproxy_content.LanguageDependentText
   * @generated
   */
  EClass getLanguageDependentText();

  /**
   * Returns the meta object for enum '{@link sproxy_content.Cardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cardinality</em>'.
   * @see sproxy_content.Cardinality
   * @generated
   */
  EEnum getCardinality();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Sproxy_contentFactory getSproxy_contentFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link sproxy_content.impl.BOImpl <em>BO</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.BOImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getBO()
     * @generated
     */
    EClass BO = eINSTANCE.getBO();

    /**
     * The meta object literal for the '<em><b>Root Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO__ROOT_NODE = eINSTANCE.getBO_RootNode();

    /**
     * The meta object literal for the '<em><b>Status Derivators</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO__STATUS_DERIVATORS = eINSTANCE.getBO_StatusDerivators();

    /**
     * The meta object literal for the '<em><b>Template</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO__TEMPLATE = eINSTANCE.getBO_Template();

    /**
     * The meta object literal for the '<em><b>Projections</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO__PROJECTIONS = eINSTANCE.getBO_Projections();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.BONodeImpl <em>BO Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.BONodeImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getBONode()
     * @generated
     */
    EClass BO_NODE = eINSTANCE.getBONode();

    /**
     * The meta object literal for the '<em><b>Node Data Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__NODE_DATA_TYPE = eINSTANCE.getBONode_NodeDataType();

    /**
     * The meta object literal for the '<em><b>Bo</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__BO = eINSTANCE.getBONode_Bo();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__ACTIONS = eINSTANCE.getBONode_Actions();

    /**
     * The meta object literal for the '<em><b>Status And Action Schemas</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__STATUS_AND_ACTION_SCHEMAS = eINSTANCE.getBONode_StatusAndActionSchemas();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__ASSOCIATION = eINSTANCE.getBONode_Association();

    /**
     * The meta object literal for the '<em><b>Outbound Associations</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__OUTBOUND_ASSOCIATIONS = eINSTANCE.getBONode_OutboundAssociations();

    /**
     * The meta object literal for the '<em><b>Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__QUERIES = eINSTANCE.getBONode_Queries();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__PROPERTIES = eINSTANCE.getBONode_Properties();

    /**
     * The meta object literal for the '<em><b>Field Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BO_NODE__FIELD_PROPERTIES = eINSTANCE.getBONode_FieldProperties();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.DataTypeImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getDataType()
     * @generated
     */
    EClass DATA_TYPE = eINSTANCE.getDataType();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_TYPE__ELEMENTS = eINSTANCE.getDataType_Elements();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_TYPE__ATTRIBUTES = eINSTANCE.getDataType_Attributes();

    /**
     * The meta object literal for the '<em><b>Abap Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_TYPE__ABAP_TYPE = eINSTANCE.getDataType_AbapType();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.QueryImpl <em>Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.QueryImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getQuery()
     * @generated
     */
    EClass QUERY = eINSTANCE.getQuery();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.ActionImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '<em><b>Cardinality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ACTION__CARDINALITY = eINSTANCE.getAction_Cardinality();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.ServiceInterfaceImpl <em>Service Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.ServiceInterfaceImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getServiceInterface()
     * @generated
     */
    EClass SERVICE_INTERFACE = eINSTANCE.getServiceInterface();

    /**
     * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_INTERFACE__OPERATIONS = eINSTANCE.getServiceInterface_Operations();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.ServiceInterfaceOperationImpl <em>Service Interface Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.ServiceInterfaceOperationImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getServiceInterfaceOperation()
     * @generated
     */
    EClass SERVICE_INTERFACE_OPERATION = eINSTANCE.getServiceInterfaceOperation();

    /**
     * The meta object literal for the '<em><b>Request Message Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE = eINSTANCE.getServiceInterfaceOperation_RequestMessageType();

    /**
     * The meta object literal for the '<em><b>Response Message Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE = eINSTANCE.getServiceInterfaceOperation_ResponseMessageType();

    /**
     * The meta object literal for the '<em><b>Fault Message Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE = eINSTANCE.getServiceInterfaceOperation_FaultMessageType();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.ProcessAgentImpl <em>Process Agent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.ProcessAgentImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getProcessAgent()
     * @generated
     */
    EClass PROCESS_AGENT = eINSTANCE.getProcessAgent();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.OutboundProcessAgentImpl <em>Outbound Process Agent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.OutboundProcessAgentImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getOutboundProcessAgent()
     * @generated
     */
    EClass OUTBOUND_PROCESS_AGENT = eINSTANCE.getOutboundProcessAgent();

    /**
     * The meta object literal for the '<em><b>Outbound Service Interface</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE = eINSTANCE.getOutboundProcessAgent_OutboundServiceInterface();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.InboundProcessAgentImpl <em>Inbound Process Agent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.InboundProcessAgentImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getInboundProcessAgent()
     * @generated
     */
    EClass INBOUND_PROCESS_AGENT = eINSTANCE.getInboundProcessAgent();

    /**
     * The meta object literal for the '<em><b>Inbound Service Interfaces</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES = eINSTANCE.getInboundProcessAgent_InboundServiceInterfaces();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.StatusAndActionSchemaImpl <em>Status And Action Schema</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.StatusAndActionSchemaImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getStatusAndActionSchema()
     * @generated
     */
    EClass STATUS_AND_ACTION_SCHEMA = eINSTANCE.getStatusAndActionSchema();

    /**
     * The meta object literal for the '<em><b>Status Variables</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES = eINSTANCE.getStatusAndActionSchema_StatusVariables();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.ElementImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__TYPE = eINSTANCE.getElement_Type();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.AttributeImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Status Attribute</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__STATUS_ATTRIBUTE = eINSTANCE.getAttribute_StatusAttribute();

    /**
     * The meta object literal for the '<em><b>Abap Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__ABAP_TYPE = eINSTANCE.getAttribute_AbapType();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.DOImpl <em>DO</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.DOImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getDO()
     * @generated
     */
    EClass DO = eINSTANCE.getDO();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.AssociationImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAssociation()
     * @generated
     */
    EClass ASSOCIATION = eINSTANCE.getAssociation();

    /**
     * The meta object literal for the '<em><b>Composite</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__COMPOSITE = eINSTANCE.getAssociation_Composite();

    /**
     * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__TARGET_NODE = eINSTANCE.getAssociation_TargetNode();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__OWNER = eINSTANCE.getAssociation_Owner();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION__PROPERTIES = eINSTANCE.getAssociation_Properties();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.OperationImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Parameter Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__PARAMETER_TYPE = eINSTANCE.getOperation_ParameterType();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__PROPERTIES = eINSTANCE.getOperation_Properties();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.StatusDerivatorImpl <em>Status Derivator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.StatusDerivatorImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getStatusDerivator()
     * @generated
     */
    EClass STATUS_DERIVATOR = eINSTANCE.getStatusDerivator();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATUS_DERIVATOR__SOURCE = eINSTANCE.getStatusDerivator_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATUS_DERIVATOR__TARGET = eINSTANCE.getStatusDerivator_Target();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.PopulationImpl <em>Population</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.PopulationImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getPopulation()
     * @generated
     */
    EClass POPULATION = eINSTANCE.getPopulation();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.AggregationImpl <em>Aggregation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.AggregationImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAggregation()
     * @generated
     */
    EClass AGGREGATION = eINSTANCE.getAggregation();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.AssociationPropertiesImpl <em>Association Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.AssociationPropertiesImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getAssociationProperties()
     * @generated
     */
    EClass ASSOCIATION_PROPERTIES = eINSTANCE.getAssociationProperties();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_PROPERTIES__ENABLED = eINSTANCE.getAssociationProperties_Enabled();

    /**
     * The meta object literal for the '<em><b>Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_PROPERTIES__ENABLED_FINAL = eINSTANCE.getAssociationProperties_EnabledFinal();

    /**
     * The meta object literal for the '<em><b>Create Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_PROPERTIES__CREATE_ENABLED = eINSTANCE.getAssociationProperties_CreateEnabled();

    /**
     * The meta object literal for the '<em><b>Create Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_PROPERTIES__CREATE_ENABLED_FINAL = eINSTANCE.getAssociationProperties_CreateEnabledFinal();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.NodePropertiesImpl <em>Node Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.NodePropertiesImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getNodeProperties()
     * @generated
     */
    EClass NODE_PROPERTIES = eINSTANCE.getNodeProperties();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__ENABLED = eINSTANCE.getNodeProperties_Enabled();

    /**
     * The meta object literal for the '<em><b>Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__ENABLED_FINAL = eINSTANCE.getNodeProperties_EnabledFinal();

    /**
     * The meta object literal for the '<em><b>Create Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__CREATE_ENABLED = eINSTANCE.getNodeProperties_CreateEnabled();

    /**
     * The meta object literal for the '<em><b>Create Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__CREATE_ENABLED_FINAL = eINSTANCE.getNodeProperties_CreateEnabledFinal();

    /**
     * The meta object literal for the '<em><b>Update Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__UPDATE_ENABLED = eINSTANCE.getNodeProperties_UpdateEnabled();

    /**
     * The meta object literal for the '<em><b>Update Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__UPDATE_ENABLED_FINAL = eINSTANCE.getNodeProperties_UpdateEnabledFinal();

    /**
     * The meta object literal for the '<em><b>Delete Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__DELETE_ENABLED = eINSTANCE.getNodeProperties_DeleteEnabled();

    /**
     * The meta object literal for the '<em><b>Delete Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__DELETE_ENABLED_FINAL = eINSTANCE.getNodeProperties_DeleteEnabledFinal();

    /**
     * The meta object literal for the '<em><b>Transient Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__TRANSIENT_KEY = eINSTANCE.getNodeProperties_TransientKey();

    /**
     * The meta object literal for the '<em><b>Transient Key Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_PROPERTIES__TRANSIENT_KEY_FINAL = eINSTANCE.getNodeProperties_TransientKeyFinal();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.OperationPropertiesImpl <em>Operation Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.OperationPropertiesImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getOperationProperties()
     * @generated
     */
    EClass OPERATION_PROPERTIES = eINSTANCE.getOperationProperties();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_PROPERTIES__ENABLED = eINSTANCE.getOperationProperties_Enabled();

    /**
     * The meta object literal for the '<em><b>Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_PROPERTIES__ENABLED_FINAL = eINSTANCE.getOperationProperties_EnabledFinal();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.FieldPropertiesImpl <em>Field Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.FieldPropertiesImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getFieldProperties()
     * @generated
     */
    EClass FIELD_PROPERTIES = eINSTANCE.getFieldProperties();

    /**
     * The meta object literal for the '<em><b>Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__ENABLED = eINSTANCE.getFieldProperties_Enabled();

    /**
     * The meta object literal for the '<em><b>Enabled Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__ENABLED_FINAL = eINSTANCE.getFieldProperties_EnabledFinal();

    /**
     * The meta object literal for the '<em><b>Readonly</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__READONLY = eINSTANCE.getFieldProperties_Readonly();

    /**
     * The meta object literal for the '<em><b>Readonly Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__READONLY_FINAL = eINSTANCE.getFieldProperties_ReadonlyFinal();

    /**
     * The meta object literal for the '<em><b>Mandatory</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__MANDATORY = eINSTANCE.getFieldProperties_Mandatory();

    /**
     * The meta object literal for the '<em><b>Mandatory Final</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__MANDATORY_FINAL = eINSTANCE.getFieldProperties_MandatoryFinal();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_PROPERTIES__FIELD = eINSTANCE.getFieldProperties_Field();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.FieldImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD__PROPERTIES = eINSTANCE.getField_Properties();

    /**
     * The meta object literal for the '{@link sproxy_content.impl.LanguageDependentTextImpl <em>Language Dependent Text</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.impl.LanguageDependentTextImpl
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getLanguageDependentText()
     * @generated
     */
    EClass LANGUAGE_DEPENDENT_TEXT = eINSTANCE.getLanguageDependentText();

    /**
     * The meta object literal for the '{@link sproxy_content.Cardinality <em>Cardinality</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see sproxy_content.Cardinality
     * @see sproxy_content.impl.Sproxy_contentPackageImpl#getCardinality()
     * @generated
     */
    EEnum CARDINALITY = eINSTANCE.getCardinality();

  }

} //Sproxy_contentPackage
