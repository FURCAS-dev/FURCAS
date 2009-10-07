/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.query2.query.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryFactoryImpl extends EFactoryImpl implements QueryFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static QueryFactory init()
  {
    try
    {
      QueryFactory theQueryFactory = (QueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/query2/Query"); 
      if (theQueryFactory != null)
      {
        return theQueryFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new QueryFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryFactoryImpl()
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
      case QueryPackage.MODEL: return createModel();
      case QueryPackage.IMPORT: return createImport();
      case QueryPackage.NAMED_QUERY: return createNamedQuery();
      case QueryPackage.MQ_LQUERY: return createMQLquery();
      case QueryPackage.SELECT_ENTRY: return createSelectEntry();
      case QueryPackage.FROM_ENTRY: return createFromEntry();
      case QueryPackage.SCOPE_CLAUSE: return createScopeClause();
      case QueryPackage.RESOURCE_SCOPE: return createResourceScope();
      case QueryPackage.ELEMENT_SCOPE: return createElementScope();
      case QueryPackage.WHERE_ENTRY: return createWhereEntry();
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY: return createAttributeWhereEntry();
      case QueryPackage.NUMERIC_ATTRIBUTE_WHERE_ENTRY: return createNumericAttributeWhereEntry();
      case QueryPackage.DOUBLE_WHERE_ENTRY: return createDoubleWhereEntry();
      case QueryPackage.LONG_WHERE_ENTRY: return createLongWhereEntry();
      case QueryPackage.VARIABLE_WHERE_ENTRY: return createVariableWhereEntry();
      case QueryPackage.STRING_ATTRIBUTE_WHERE_ENTRY: return createStringAttributeWhereEntry();
      case QueryPackage.BOOLEAN_ATTRIBUTE_WHERE_ENTRY: return createBooleanAttributeWhereEntry();
      case QueryPackage.REFERENCE_WHERE_ENTRY: return createReferenceWhereEntry();
      case QueryPackage.NULL_WHERE_ENTRY: return createNullWhereEntry();
      case QueryPackage.REFERENCE_ALIAS_WHERE_ENTRY: return createReferenceAliasWhereEntry();
      case QueryPackage.SUBSELECT_WHERE_ENTRY: return createSubselectWhereEntry();
      case QueryPackage.ALIAS_WHERE_ENTRY: return createAliasWhereEntry();
      case QueryPackage.OR_WHERE_ENTRY: return createOrWhereEntry();
      case QueryPackage.AND_WHERE_ENTRY: return createAndWhereEntry();
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
      case QueryPackage.NUMERIC_OPERATOR:
        return createNumericOperatorFromString(eDataType, initialValue);
      case QueryPackage.STRING_OPERATOR:
        return createStringOperatorFromString(eDataType, initialValue);
      case QueryPackage.BOOLEAN_OPERATOR:
        return createBooleanOperatorFromString(eDataType, initialValue);
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
      case QueryPackage.NUMERIC_OPERATOR:
        return convertNumericOperatorToString(eDataType, instanceValue);
      case QueryPackage.STRING_OPERATOR:
        return convertStringOperatorToString(eDataType, instanceValue);
      case QueryPackage.BOOLEAN_OPERATOR:
        return convertBooleanOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedQuery createNamedQuery()
  {
    NamedQueryImpl namedQuery = new NamedQueryImpl();
    return namedQuery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MQLquery createMQLquery()
  {
    MQLqueryImpl mqLquery = new MQLqueryImpl();
    return mqLquery;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelectEntry createSelectEntry()
  {
    SelectEntryImpl selectEntry = new SelectEntryImpl();
    return selectEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FromEntry createFromEntry()
  {
    FromEntryImpl fromEntry = new FromEntryImpl();
    return fromEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScopeClause createScopeClause()
  {
    ScopeClauseImpl scopeClause = new ScopeClauseImpl();
    return scopeClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResourceScope createResourceScope()
  {
    ResourceScopeImpl resourceScope = new ResourceScopeImpl();
    return resourceScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementScope createElementScope()
  {
    ElementScopeImpl elementScope = new ElementScopeImpl();
    return elementScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhereEntry createWhereEntry()
  {
    WhereEntryImpl whereEntry = new WhereEntryImpl();
    return whereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeWhereEntry createAttributeWhereEntry()
  {
    AttributeWhereEntryImpl attributeWhereEntry = new AttributeWhereEntryImpl();
    return attributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericAttributeWhereEntry createNumericAttributeWhereEntry()
  {
    NumericAttributeWhereEntryImpl numericAttributeWhereEntry = new NumericAttributeWhereEntryImpl();
    return numericAttributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoubleWhereEntry createDoubleWhereEntry()
  {
    DoubleWhereEntryImpl doubleWhereEntry = new DoubleWhereEntryImpl();
    return doubleWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongWhereEntry createLongWhereEntry()
  {
    LongWhereEntryImpl longWhereEntry = new LongWhereEntryImpl();
    return longWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableWhereEntry createVariableWhereEntry()
  {
    VariableWhereEntryImpl variableWhereEntry = new VariableWhereEntryImpl();
    return variableWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringAttributeWhereEntry createStringAttributeWhereEntry()
  {
    StringAttributeWhereEntryImpl stringAttributeWhereEntry = new StringAttributeWhereEntryImpl();
    return stringAttributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAttributeWhereEntry createBooleanAttributeWhereEntry()
  {
    BooleanAttributeWhereEntryImpl booleanAttributeWhereEntry = new BooleanAttributeWhereEntryImpl();
    return booleanAttributeWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceWhereEntry createReferenceWhereEntry()
  {
    ReferenceWhereEntryImpl referenceWhereEntry = new ReferenceWhereEntryImpl();
    return referenceWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullWhereEntry createNullWhereEntry()
  {
    NullWhereEntryImpl nullWhereEntry = new NullWhereEntryImpl();
    return nullWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceAliasWhereEntry createReferenceAliasWhereEntry()
  {
    ReferenceAliasWhereEntryImpl referenceAliasWhereEntry = new ReferenceAliasWhereEntryImpl();
    return referenceAliasWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SubselectWhereEntry createSubselectWhereEntry()
  {
    SubselectWhereEntryImpl subselectWhereEntry = new SubselectWhereEntryImpl();
    return subselectWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AliasWhereEntry createAliasWhereEntry()
  {
    AliasWhereEntryImpl aliasWhereEntry = new AliasWhereEntryImpl();
    return aliasWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrWhereEntry createOrWhereEntry()
  {
    OrWhereEntryImpl orWhereEntry = new OrWhereEntryImpl();
    return orWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndWhereEntry createAndWhereEntry()
  {
    AndWhereEntryImpl andWhereEntry = new AndWhereEntryImpl();
    return andWhereEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericOperator createNumericOperatorFromString(EDataType eDataType, String initialValue)
  {
    NumericOperator result = NumericOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertNumericOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringOperator createStringOperatorFromString(EDataType eDataType, String initialValue)
  {
    StringOperator result = StringOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStringOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOperator createBooleanOperatorFromString(EDataType eDataType, String initialValue)
  {
    BooleanOperator result = BooleanOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QueryPackage getQueryPackage()
  {
    return (QueryPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static QueryPackage getPackage()
  {
    return QueryPackage.eINSTANCE;
  }

} //QueryFactoryImpl
