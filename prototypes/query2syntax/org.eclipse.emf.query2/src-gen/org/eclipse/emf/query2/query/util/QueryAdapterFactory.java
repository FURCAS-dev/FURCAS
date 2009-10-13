/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.query.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.query.QueryPackage
 * @generated
 */
public class QueryAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static QueryPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = QueryPackage.eINSTANCE;
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
  protected QuerySwitch<Adapter> modelSwitch =
    new QuerySwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseNamedQuery(NamedQuery object)
      {
        return createNamedQueryAdapter();
      }
      @Override
      public Adapter caseMQLquery(MQLquery object)
      {
        return createMQLqueryAdapter();
      }
      @Override
      public Adapter caseSelectEntry(SelectEntry object)
      {
        return createSelectEntryAdapter();
      }
      @Override
      public Adapter caseFromEntry(FromEntry object)
      {
        return createFromEntryAdapter();
      }
      @Override
      public Adapter caseScopeClause(ScopeClause object)
      {
        return createScopeClauseAdapter();
      }
      @Override
      public Adapter caseResourceScope(ResourceScope object)
      {
        return createResourceScopeAdapter();
      }
      @Override
      public Adapter caseElementScope(ElementScope object)
      {
        return createElementScopeAdapter();
      }
      @Override
      public Adapter caseWhereEntry(WhereEntry object)
      {
        return createWhereEntryAdapter();
      }
      @Override
      public Adapter caseAbstractAliasWhereEntry(AbstractAliasWhereEntry object)
      {
        return createAbstractAliasWhereEntryAdapter();
      }
      @Override
      public Adapter caseAttributeWhereEntry(AttributeWhereEntry object)
      {
        return createAttributeWhereEntryAdapter();
      }
      @Override
      public Adapter caseNumericAttributeWhereEntry(NumericAttributeWhereEntry object)
      {
        return createNumericAttributeWhereEntryAdapter();
      }
      @Override
      public Adapter caseDoubleWhereEntry(DoubleWhereEntry object)
      {
        return createDoubleWhereEntryAdapter();
      }
      @Override
      public Adapter caseLongWhereEntry(LongWhereEntry object)
      {
        return createLongWhereEntryAdapter();
      }
      @Override
      public Adapter caseVariableWhereEntry(VariableWhereEntry object)
      {
        return createVariableWhereEntryAdapter();
      }
      @Override
      public Adapter caseStringAttributeWhereEntry(StringAttributeWhereEntry object)
      {
        return createStringAttributeWhereEntryAdapter();
      }
      @Override
      public Adapter caseBooleanAttributeWhereEntry(BooleanAttributeWhereEntry object)
      {
        return createBooleanAttributeWhereEntryAdapter();
      }
      @Override
      public Adapter caseReferenceWhereEntry(ReferenceWhereEntry object)
      {
        return createReferenceWhereEntryAdapter();
      }
      @Override
      public Adapter caseNullWhereEntry(NullWhereEntry object)
      {
        return createNullWhereEntryAdapter();
      }
      @Override
      public Adapter caseReferenceAliasWhereEntry(ReferenceAliasWhereEntry object)
      {
        return createReferenceAliasWhereEntryAdapter();
      }
      @Override
      public Adapter caseSubselectWhereEntry(SubselectWhereEntry object)
      {
        return createSubselectWhereEntryAdapter();
      }
      @Override
      public Adapter caseAliasWhereEntry(AliasWhereEntry object)
      {
        return createAliasWhereEntryAdapter();
      }
      @Override
      public Adapter caseOrWhereEntry(OrWhereEntry object)
      {
        return createOrWhereEntryAdapter();
      }
      @Override
      public Adapter caseAndWhereEntry(AndWhereEntry object)
      {
        return createAndWhereEntryAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.NamedQuery <em>Named Query</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.NamedQuery
   * @generated
   */
  public Adapter createNamedQueryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.MQLquery <em>MQ Lquery</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.MQLquery
   * @generated
   */
  public Adapter createMQLqueryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.SelectEntry <em>Select Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.SelectEntry
   * @generated
   */
  public Adapter createSelectEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.FromEntry <em>From Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.FromEntry
   * @generated
   */
  public Adapter createFromEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.ScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.ScopeClause
   * @generated
   */
  public Adapter createScopeClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.ResourceScope <em>Resource Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.ResourceScope
   * @generated
   */
  public Adapter createResourceScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.ElementScope <em>Element Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.ElementScope
   * @generated
   */
  public Adapter createElementScopeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.WhereEntry <em>Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.WhereEntry
   * @generated
   */
  public Adapter createWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.AbstractAliasWhereEntry <em>Abstract Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.AbstractAliasWhereEntry
   * @generated
   */
  public Adapter createAbstractAliasWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.AttributeWhereEntry <em>Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.AttributeWhereEntry
   * @generated
   */
  public Adapter createAttributeWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.NumericAttributeWhereEntry <em>Numeric Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.NumericAttributeWhereEntry
   * @generated
   */
  public Adapter createNumericAttributeWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.DoubleWhereEntry <em>Double Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.DoubleWhereEntry
   * @generated
   */
  public Adapter createDoubleWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.LongWhereEntry <em>Long Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.LongWhereEntry
   * @generated
   */
  public Adapter createLongWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.VariableWhereEntry <em>Variable Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.VariableWhereEntry
   * @generated
   */
  public Adapter createVariableWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry <em>String Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.StringAttributeWhereEntry
   * @generated
   */
  public Adapter createStringAttributeWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.BooleanAttributeWhereEntry <em>Boolean Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.BooleanAttributeWhereEntry
   * @generated
   */
  public Adapter createBooleanAttributeWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.ReferenceWhereEntry <em>Reference Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.ReferenceWhereEntry
   * @generated
   */
  public Adapter createReferenceWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.NullWhereEntry <em>Null Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.NullWhereEntry
   * @generated
   */
  public Adapter createNullWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.ReferenceAliasWhereEntry <em>Reference Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.ReferenceAliasWhereEntry
   * @generated
   */
  public Adapter createReferenceAliasWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.SubselectWhereEntry <em>Subselect Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.SubselectWhereEntry
   * @generated
   */
  public Adapter createSubselectWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.AliasWhereEntry <em>Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.AliasWhereEntry
   * @generated
   */
  public Adapter createAliasWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.OrWhereEntry <em>Or Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.OrWhereEntry
   * @generated
   */
  public Adapter createOrWhereEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.emf.query2.query.AndWhereEntry <em>And Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.emf.query2.query.AndWhereEntry
   * @generated
   */
  public Adapter createAndWhereEntryAdapter()
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

} //QueryAdapterFactory
