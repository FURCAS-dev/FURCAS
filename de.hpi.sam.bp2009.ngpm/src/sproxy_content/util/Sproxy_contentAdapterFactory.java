/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.util;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import sproxy_content.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see sproxy_content.Sproxy_contentPackage
 * @generated
 */
public class Sproxy_contentAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Sproxy_contentPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sproxy_contentAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Sproxy_contentPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Sproxy_contentSwitch<Adapter> modelSwitch =
    new Sproxy_contentSwitch<Adapter>()
    {
      @Override
      public Adapter caseBO(BO object)
      {
        return createBOAdapter();
      }
      @Override
      public Adapter caseBONode(BONode object)
      {
        return createBONodeAdapter();
      }
      @Override
      public Adapter caseDataType(DataType object)
      {
        return createDataTypeAdapter();
      }
      @Override
      public Adapter caseQuery(Query object)
      {
        return createQueryAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseServiceInterface(ServiceInterface object)
      {
        return createServiceInterfaceAdapter();
      }
      @Override
      public Adapter caseServiceInterfaceOperation(ServiceInterfaceOperation object)
      {
        return createServiceInterfaceOperationAdapter();
      }
      @Override
      public Adapter caseProcessAgent(ProcessAgent object)
      {
        return createProcessAgentAdapter();
      }
      @Override
      public Adapter caseOutboundProcessAgent(OutboundProcessAgent object)
      {
        return createOutboundProcessAgentAdapter();
      }
      @Override
      public Adapter caseInboundProcessAgent(InboundProcessAgent object)
      {
        return createInboundProcessAgentAdapter();
      }
      @Override
      public Adapter caseStatusAndActionSchema(StatusAndActionSchema object)
      {
        return createStatusAndActionSchemaAdapter();
      }
      @Override
      public Adapter caseElement(Element object)
      {
        return createElementAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseDO(DO object)
      {
        return createDOAdapter();
      }
      @Override
      public Adapter caseAssociation(Association object)
      {
        return createAssociationAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object)
      {
        return createOperationAdapter();
      }
      @Override
      public Adapter caseStatusDerivator(StatusDerivator object)
      {
        return createStatusDerivatorAdapter();
      }
      @Override
      public Adapter casePopulation(Population object)
      {
        return createPopulationAdapter();
      }
      @Override
      public Adapter caseAggregation(Aggregation object)
      {
        return createAggregationAdapter();
      }
      @Override
      public Adapter caseAssociationProperties(AssociationProperties object)
      {
        return createAssociationPropertiesAdapter();
      }
      @Override
      public Adapter caseNodeProperties(NodeProperties object)
      {
        return createNodePropertiesAdapter();
      }
      @Override
      public Adapter caseOperationProperties(OperationProperties object)
      {
        return createOperationPropertiesAdapter();
      }
      @Override
      public Adapter caseFieldProperties(FieldProperties object)
      {
        return createFieldPropertiesAdapter();
      }
      @Override
      public Adapter caseField(Field object)
      {
        return createFieldAdapter();
      }
      @Override
      public Adapter caseLanguageDependentText(LanguageDependentText object)
      {
        return createLanguageDependentTextAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.BO <em>BO</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.BO
   * @generated
   */
  public Adapter createBOAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.BONode <em>BO Node</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.BONode
   * @generated
   */
  public Adapter createBONodeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.DataType
   * @generated
   */
  public Adapter createDataTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Query <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Query
   * @generated
   */
  public Adapter createQueryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.ServiceInterface <em>Service Interface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.ServiceInterface
   * @generated
   */
  public Adapter createServiceInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.ServiceInterfaceOperation <em>Service Interface Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.ServiceInterfaceOperation
   * @generated
   */
  public Adapter createServiceInterfaceOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.ProcessAgent <em>Process Agent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.ProcessAgent
   * @generated
   */
  public Adapter createProcessAgentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.OutboundProcessAgent <em>Outbound Process Agent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.OutboundProcessAgent
   * @generated
   */
  public Adapter createOutboundProcessAgentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.InboundProcessAgent <em>Inbound Process Agent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.InboundProcessAgent
   * @generated
   */
  public Adapter createInboundProcessAgentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.StatusAndActionSchema <em>Status And Action Schema</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.StatusAndActionSchema
   * @generated
   */
  public Adapter createStatusAndActionSchemaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Element
   * @generated
   */
  public Adapter createElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.DO <em>DO</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.DO
   * @generated
   */
  public Adapter createDOAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Association
   * @generated
   */
  public Adapter createAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Operation
   * @generated
   */
  public Adapter createOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.StatusDerivator <em>Status Derivator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.StatusDerivator
   * @generated
   */
  public Adapter createStatusDerivatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Population <em>Population</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Population
   * @generated
   */
  public Adapter createPopulationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Aggregation <em>Aggregation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Aggregation
   * @generated
   */
  public Adapter createAggregationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.AssociationProperties <em>Association Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.AssociationProperties
   * @generated
   */
  public Adapter createAssociationPropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.NodeProperties <em>Node Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.NodeProperties
   * @generated
   */
  public Adapter createNodePropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.OperationProperties <em>Operation Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.OperationProperties
   * @generated
   */
  public Adapter createOperationPropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.FieldProperties <em>Field Properties</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.FieldProperties
   * @generated
   */
  public Adapter createFieldPropertiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.Field
   * @generated
   */
  public Adapter createFieldAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link sproxy_content.LanguageDependentText <em>Language Dependent Text</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see sproxy_content.LanguageDependentText
   * @generated
   */
  public Adapter createLanguageDependentTextAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link modelmanagement.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see modelmanagement.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //Sproxy_contentAdapterFactory
