/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.util;

import java.util.List;

import modelmanagement.NamedElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import sproxy_content.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see sproxy_content.Sproxy_contentPackage
 * @generated
 */
public class Sproxy_contentSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Sproxy_contentPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sproxy_contentSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = Sproxy_contentPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case Sproxy_contentPackage.BO:
      {
        BO bo = (BO)theEObject;
        T result = caseBO(bo);
        if (result == null) result = caseNamedElement(bo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.BO_NODE:
      {
        BONode boNode = (BONode)theEObject;
        T result = caseBONode(boNode);
        if (result == null) result = caseNamedElement(boNode);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.DATA_TYPE:
      {
        DataType dataType = (DataType)theEObject;
        T result = caseDataType(dataType);
        if (result == null) result = caseNamedElement(dataType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.QUERY:
      {
        Query query = (Query)theEObject;
        T result = caseQuery(query);
        if (result == null) result = caseOperation(query);
        if (result == null) result = caseNamedElement(query);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.ACTION:
      {
        Action action = (Action)theEObject;
        T result = caseAction(action);
        if (result == null) result = caseOperation(action);
        if (result == null) result = caseNamedElement(action);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.SERVICE_INTERFACE:
      {
        ServiceInterface serviceInterface = (ServiceInterface)theEObject;
        T result = caseServiceInterface(serviceInterface);
        if (result == null) result = caseNamedElement(serviceInterface);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION:
      {
        ServiceInterfaceOperation serviceInterfaceOperation = (ServiceInterfaceOperation)theEObject;
        T result = caseServiceInterfaceOperation(serviceInterfaceOperation);
        if (result == null) result = caseNamedElement(serviceInterfaceOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.PROCESS_AGENT:
      {
        ProcessAgent processAgent = (ProcessAgent)theEObject;
        T result = caseProcessAgent(processAgent);
        if (result == null) result = caseNamedElement(processAgent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT:
      {
        OutboundProcessAgent outboundProcessAgent = (OutboundProcessAgent)theEObject;
        T result = caseOutboundProcessAgent(outboundProcessAgent);
        if (result == null) result = caseProcessAgent(outboundProcessAgent);
        if (result == null) result = caseNamedElement(outboundProcessAgent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT:
      {
        InboundProcessAgent inboundProcessAgent = (InboundProcessAgent)theEObject;
        T result = caseInboundProcessAgent(inboundProcessAgent);
        if (result == null) result = caseProcessAgent(inboundProcessAgent);
        if (result == null) result = caseNamedElement(inboundProcessAgent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA:
      {
        StatusAndActionSchema statusAndActionSchema = (StatusAndActionSchema)theEObject;
        T result = caseStatusAndActionSchema(statusAndActionSchema);
        if (result == null) result = caseNamedElement(statusAndActionSchema);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.ELEMENT:
      {
        Element element = (Element)theEObject;
        T result = caseElement(element);
        if (result == null) result = caseNamedElement(element);
        if (result == null) result = caseField(element);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = caseNamedElement(attribute);
        if (result == null) result = caseField(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.DO:
      {
        DO do_ = (DO)theEObject;
        T result = caseDO(do_);
        if (result == null) result = caseBO(do_);
        if (result == null) result = caseNamedElement(do_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.ASSOCIATION:
      {
        Association association = (Association)theEObject;
        T result = caseAssociation(association);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = caseNamedElement(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.STATUS_DERIVATOR:
      {
        StatusDerivator statusDerivator = (StatusDerivator)theEObject;
        T result = caseStatusDerivator(statusDerivator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.POPULATION:
      {
        Population population = (Population)theEObject;
        T result = casePopulation(population);
        if (result == null) result = caseStatusDerivator(population);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.AGGREGATION:
      {
        Aggregation aggregation = (Aggregation)theEObject;
        T result = caseAggregation(aggregation);
        if (result == null) result = caseStatusDerivator(aggregation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.ASSOCIATION_PROPERTIES:
      {
        AssociationProperties associationProperties = (AssociationProperties)theEObject;
        T result = caseAssociationProperties(associationProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.NODE_PROPERTIES:
      {
        NodeProperties nodeProperties = (NodeProperties)theEObject;
        T result = caseNodeProperties(nodeProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.OPERATION_PROPERTIES:
      {
        OperationProperties operationProperties = (OperationProperties)theEObject;
        T result = caseOperationProperties(operationProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.FIELD_PROPERTIES:
      {
        FieldProperties fieldProperties = (FieldProperties)theEObject;
        T result = caseFieldProperties(fieldProperties);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.FIELD:
      {
        Field field = (Field)theEObject;
        T result = caseField(field);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case Sproxy_contentPackage.LANGUAGE_DEPENDENT_TEXT:
      {
        LanguageDependentText languageDependentText = (LanguageDependentText)theEObject;
        T result = caseLanguageDependentText(languageDependentText);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>BO</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BO</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBO(BO object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>BO Node</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BO Node</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBONode(BONode object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataType(DataType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Query</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuery(Query object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction(Action object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Interface</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Interface</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceInterface(ServiceInterface object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Service Interface Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Service Interface Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseServiceInterfaceOperation(ServiceInterfaceOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Process Agent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Process Agent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProcessAgent(ProcessAgent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Outbound Process Agent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Outbound Process Agent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOutboundProcessAgent(OutboundProcessAgent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inbound Process Agent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inbound Process Agent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInboundProcessAgent(InboundProcessAgent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Status And Action Schema</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Status And Action Schema</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatusAndActionSchema(StatusAndActionSchema object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElement(Element object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>DO</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DO</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDO(DO object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociation(Association object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Status Derivator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Status Derivator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatusDerivator(StatusDerivator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Population</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Population</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePopulation(Population object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aggregation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aggregation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAggregation(Aggregation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationProperties(AssociationProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeProperties(NodeProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationProperties(OperationProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field Properties</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field Properties</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFieldProperties(FieldProperties object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseField(Field object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Language Dependent Text</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Language Dependent Text</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLanguageDependentText(LanguageDependentText object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //Sproxy_contentSwitch
