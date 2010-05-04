/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sproxy_content.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Sproxy_contentFactoryImpl extends EFactoryImpl implements Sproxy_contentFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Sproxy_contentFactory init()
  {
    try
    {
      Sproxy_contentFactory theSproxy_contentFactory = (Sproxy_contentFactory)EPackage.Registry.INSTANCE.getEFactory("http:///sproxy_content.ecore"); 
      if (theSproxy_contentFactory != null)
      {
        return theSproxy_contentFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Sproxy_contentFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sproxy_contentFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case Sproxy_contentPackage.BO: return createBO();
      case Sproxy_contentPackage.BO_NODE: return createBONode();
      case Sproxy_contentPackage.DATA_TYPE: return createDataType();
      case Sproxy_contentPackage.QUERY: return createQuery();
      case Sproxy_contentPackage.ACTION: return createAction();
      case Sproxy_contentPackage.SERVICE_INTERFACE: return createServiceInterface();
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION: return createServiceInterfaceOperation();
      case Sproxy_contentPackage.PROCESS_AGENT: return createProcessAgent();
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT: return createOutboundProcessAgent();
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT: return createInboundProcessAgent();
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA: return createStatusAndActionSchema();
      case Sproxy_contentPackage.ELEMENT: return createElement();
      case Sproxy_contentPackage.ATTRIBUTE: return createAttribute();
      case Sproxy_contentPackage.DO: return createDO();
      case Sproxy_contentPackage.ASSOCIATION: return createAssociation();
      case Sproxy_contentPackage.OPERATION: return createOperation();
      case Sproxy_contentPackage.STATUS_DERIVATOR: return createStatusDerivator();
      case Sproxy_contentPackage.POPULATION: return createPopulation();
      case Sproxy_contentPackage.AGGREGATION: return createAggregation();
      case Sproxy_contentPackage.ASSOCIATION_PROPERTIES: return createAssociationProperties();
      case Sproxy_contentPackage.NODE_PROPERTIES: return createNodeProperties();
      case Sproxy_contentPackage.OPERATION_PROPERTIES: return createOperationProperties();
      case Sproxy_contentPackage.FIELD_PROPERTIES: return createFieldProperties();
      case Sproxy_contentPackage.FIELD: return createField();
      case Sproxy_contentPackage.LANGUAGE_DEPENDENT_TEXT: return createLanguageDependentText();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Sproxy_contentPackage.CARDINALITY:
        return createCardinalityFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case Sproxy_contentPackage.CARDINALITY:
        return convertCardinalityToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BO createBO()
  {
    BOImpl bo = new BOImpl();
    return bo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BONode createBONode()
  {
    BONodeImpl boNode = new BONodeImpl();
    return boNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataType createDataType()
  {
    DataTypeImpl dataType = new DataTypeImpl();
    return dataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Query createQuery()
  {
    QueryImpl query = new QueryImpl();
    return query;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceInterface createServiceInterface()
  {
    ServiceInterfaceImpl serviceInterface = new ServiceInterfaceImpl();
    return serviceInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServiceInterfaceOperation createServiceInterfaceOperation()
  {
    ServiceInterfaceOperationImpl serviceInterfaceOperation = new ServiceInterfaceOperationImpl();
    return serviceInterfaceOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProcessAgent createProcessAgent()
  {
    ProcessAgentImpl processAgent = new ProcessAgentImpl();
    return processAgent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutboundProcessAgent createOutboundProcessAgent()
  {
    OutboundProcessAgentImpl outboundProcessAgent = new OutboundProcessAgentImpl();
    return outboundProcessAgent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InboundProcessAgent createInboundProcessAgent()
  {
    InboundProcessAgentImpl inboundProcessAgent = new InboundProcessAgentImpl();
    return inboundProcessAgent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatusAndActionSchema createStatusAndActionSchema()
  {
    StatusAndActionSchemaImpl statusAndActionSchema = new StatusAndActionSchemaImpl();
    return statusAndActionSchema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Element createElement()
  {
    ElementImpl element = new ElementImpl();
    return element;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DO createDO()
  {
    DOImpl do_ = new DOImpl();
    return do_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association createAssociation()
  {
    AssociationImpl association = new AssociationImpl();
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatusDerivator createStatusDerivator()
  {
    StatusDerivatorImpl statusDerivator = new StatusDerivatorImpl();
    return statusDerivator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Population createPopulation()
  {
    PopulationImpl population = new PopulationImpl();
    return population;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Aggregation createAggregation()
  {
    AggregationImpl aggregation = new AggregationImpl();
    return aggregation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationProperties createAssociationProperties()
  {
    AssociationPropertiesImpl associationProperties = new AssociationPropertiesImpl();
    return associationProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NodeProperties createNodeProperties()
  {
    NodePropertiesImpl nodeProperties = new NodePropertiesImpl();
    return nodeProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationProperties createOperationProperties()
  {
    OperationPropertiesImpl operationProperties = new OperationPropertiesImpl();
    return operationProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FieldProperties createFieldProperties()
  {
    FieldPropertiesImpl fieldProperties = new FieldPropertiesImpl();
    return fieldProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Field createField()
  {
    FieldImpl field = new FieldImpl();
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LanguageDependentText createLanguageDependentText()
  {
    LanguageDependentTextImpl languageDependentText = new LanguageDependentTextImpl();
    return languageDependentText;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cardinality createCardinalityFromString(EDataType eDataType, String initialValue)
  {
    Cardinality result = Cardinality.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCardinalityToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sproxy_contentPackage getSproxy_contentPackage()
  {
    return (Sproxy_contentPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Sproxy_contentPackage getPackage()
  {
    return Sproxy_contentPackage.eINSTANCE;
  }

} //Sproxy_contentFactoryImpl
