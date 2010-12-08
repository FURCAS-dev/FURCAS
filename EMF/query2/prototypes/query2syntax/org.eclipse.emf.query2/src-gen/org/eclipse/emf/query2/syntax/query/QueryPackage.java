/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.syntax.query;

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
 * @see org.eclipse.emf.query2.syntax.query.QueryFactory
 * @model kind="package"
 * @generated
 */
public interface QueryPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "query";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/emf/query2/Query";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "query";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  QueryPackage eINSTANCE = org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ModelImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Default Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DEFAULT_QUERY = 1;

  /**
   * The feature id for the '<em><b>Named Queries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAMED_QUERIES = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ImportImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Imp URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMP_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.NamedQueryImpl <em>Named Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.NamedQueryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getNamedQuery()
   * @generated
   */
  int NAMED_QUERY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_QUERY__NAME = 0;

  /**
   * The feature id for the '<em><b>Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_QUERY__QUERY = 1;

  /**
   * The number of structural features of the '<em>Named Query</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_QUERY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl <em>MQ Lquery</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getMQLquery()
   * @generated
   */
  int MQ_LQUERY = 3;

  /**
   * The feature id for the '<em><b>From Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__FROM_ENTRIES = 0;

  /**
   * The feature id for the '<em><b>Select Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__SELECT_ENTRIES = 1;

  /**
   * The feature id for the '<em><b>Where Entry</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__WHERE_ENTRY = 2;

  /**
   * The number of structural features of the '<em>MQ Lquery</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.SelectEntryImpl <em>Select Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.SelectEntryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getSelectEntry()
   * @generated
   */
  int SELECT_ENTRY = 4;

  /**
   * The feature id for the '<em><b>Select</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_ENTRY__SELECT = 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_ENTRY__ATTRIBUTE = 1;

  /**
   * The number of structural features of the '<em>Select Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECT_ENTRY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl <em>From Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getFromEntry()
   * @generated
   */
  int FROM_ENTRY = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__TYPE = 0;

  /**
   * The feature id for the '<em><b>Withoutsubtypes</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__WITHOUTSUBTYPES = 1;

  /**
   * The feature id for the '<em><b>Withoutsubtypes Types</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__WITHOUTSUBTYPES_TYPES = 2;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__ALIAS = 3;

  /**
   * The feature id for the '<em><b>Scope Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__SCOPE_CLAUSE = 4;

  /**
   * The number of structural features of the '<em>From Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ScopeClauseImpl <em>Scope Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ScopeClauseImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getScopeClause()
   * @generated
   */
  int SCOPE_CLAUSE = 6;

  /**
   * The feature id for the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_CLAUSE__NOT_IN = 0;

  /**
   * The feature id for the '<em><b>Uris</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_CLAUSE__URIS = 1;

  /**
   * The number of structural features of the '<em>Scope Clause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_CLAUSE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ResourceScopeImpl <em>Resource Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ResourceScopeImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getResourceScope()
   * @generated
   */
  int RESOURCE_SCOPE = 7;

  /**
   * The feature id for the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_SCOPE__NOT_IN = SCOPE_CLAUSE__NOT_IN;

  /**
   * The feature id for the '<em><b>Uris</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_SCOPE__URIS = SCOPE_CLAUSE__URIS;

  /**
   * The number of structural features of the '<em>Resource Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_SCOPE_FEATURE_COUNT = SCOPE_CLAUSE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ElementScopeImpl <em>Element Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ElementScopeImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getElementScope()
   * @generated
   */
  int ELEMENT_SCOPE = 8;

  /**
   * The feature id for the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SCOPE__NOT_IN = SCOPE_CLAUSE__NOT_IN;

  /**
   * The feature id for the '<em><b>Uris</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SCOPE__URIS = SCOPE_CLAUSE__URIS;

  /**
   * The number of structural features of the '<em>Element Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_SCOPE_FEATURE_COUNT = SCOPE_CLAUSE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.WhereEntryImpl <em>Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.WhereEntryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getWhereEntry()
   * @generated
   */
  int WHERE_ENTRY = 9;

  /**
   * The number of structural features of the '<em>Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHERE_ENTRY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ExpressionWhereEntryImpl <em>Expression Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ExpressionWhereEntryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getExpressionWhereEntry()
   * @generated
   */
  int EXPRESSION_WHERE_ENTRY = 10;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_WHERE_ENTRY__LHS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_WHERE_ENTRY__OPERATOR = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_WHERE_ENTRY__RHS = WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expression Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 12;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.AliasAttributeExpressionImpl <em>Alias Attribute Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.AliasAttributeExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getAliasAttributeExpression()
   * @generated
   */
  int ALIAS_ATTRIBUTE_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_ATTRIBUTE_EXPRESSION__ALIAS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_ATTRIBUTE_EXPRESSION__ATTRIBUTE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Alias Attribute Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_ATTRIBUTE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.ReplacableValueImpl <em>Replacable Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.ReplacableValueImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getReplacableValue()
   * @generated
   */
  int REPLACABLE_VALUE = 13;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPLACABLE_VALUE__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Replacable Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPLACABLE_VALUE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.DoubleExpressionImpl <em>Double Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.DoubleExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getDoubleExpression()
   * @generated
   */
  int DOUBLE_EXPRESSION = 14;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.LongExpressionImpl <em>Long Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.LongExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getLongExpression()
   * @generated
   */
  int LONG_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Long Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.StringExpressionImpl <em>String Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.StringExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getStringExpression()
   * @generated
   */
  int STRING_EXPRESSION = 16;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.NullExpressionImpl <em>Null Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.NullExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getNullExpression()
   * @generated
   */
  int NULL_EXPRESSION = 17;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Null Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.BooleanExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getBooleanExpression()
   * @generated
   */
  int BOOLEAN_EXPRESSION = 18;

  /**
   * The feature id for the '<em><b>True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION__TRUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.QueryExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryExpressionImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getQueryExpression()
   * @generated
   */
  int QUERY_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUERY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.OrWhereEntryImpl <em>Or Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.OrWhereEntryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getOrWhereEntry()
   * @generated
   */
  int OR_WHERE_ENTRY = 20;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_WHERE_ENTRY__ENTRIES = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Or Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.impl.AndWhereEntryImpl <em>And Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.impl.AndWhereEntryImpl
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getAndWhereEntry()
   * @generated
   */
  int AND_WHERE_ENTRY = 21;

  /**
   * The feature id for the '<em><b>Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_WHERE_ENTRY__ENTRIES = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>And Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.syntax.query.Operator <em>Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.syntax.query.Operator
   * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getOperator()
   * @generated
   */
  int OPERATOR = 22;


  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.syntax.query.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.Model#getDefaultQuery <em>Default Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default Query</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Model#getDefaultQuery()
   * @see #getModel()
   * @generated
   */
  EReference getModel_DefaultQuery();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.syntax.query.Model#getNamedQueries <em>Named Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Named Queries</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Model#getNamedQueries()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NamedQueries();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.Import#getImpURI <em>Imp URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imp URI</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Import#getImpURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImpURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.NamedQuery <em>Named Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Query</em>'.
   * @see org.eclipse.emf.query2.syntax.query.NamedQuery
   * @generated
   */
  EClass getNamedQuery();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.NamedQuery#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.query2.syntax.query.NamedQuery#getName()
   * @see #getNamedQuery()
   * @generated
   */
  EAttribute getNamedQuery_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.NamedQuery#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see org.eclipse.emf.query2.syntax.query.NamedQuery#getQuery()
   * @see #getNamedQuery()
   * @generated
   */
  EReference getNamedQuery_Query();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.MQLquery <em>MQ Lquery</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MQ Lquery</em>'.
   * @see org.eclipse.emf.query2.syntax.query.MQLquery
   * @generated
   */
  EClass getMQLquery();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.syntax.query.MQLquery#getFromEntries <em>From Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>From Entries</em>'.
   * @see org.eclipse.emf.query2.syntax.query.MQLquery#getFromEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_FromEntries();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.syntax.query.MQLquery#getSelectEntries <em>Select Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Select Entries</em>'.
   * @see org.eclipse.emf.query2.syntax.query.MQLquery#getSelectEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_SelectEntries();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.MQLquery#getWhereEntry <em>Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Where Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.MQLquery#getWhereEntry()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_WhereEntry();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.SelectEntry <em>Select Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Select Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.SelectEntry
   * @generated
   */
  EClass getSelectEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.syntax.query.SelectEntry#getSelect <em>Select</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Select</em>'.
   * @see org.eclipse.emf.query2.syntax.query.SelectEntry#getSelect()
   * @see #getSelectEntry()
   * @generated
   */
  EReference getSelectEntry_Select();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.syntax.query.SelectEntry#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.emf.query2.syntax.query.SelectEntry#getAttribute()
   * @see #getSelectEntry()
   * @generated
   */
  EReference getSelectEntry_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.FromEntry <em>From Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>From Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.FromEntry
   * @generated
   */
  EClass getFromEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.emf.query2.syntax.query.FromEntry#getType()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.FromEntry#isWithoutsubtypes <em>Withoutsubtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Withoutsubtypes</em>'.
   * @see org.eclipse.emf.query2.syntax.query.FromEntry#isWithoutsubtypes()
   * @see #getFromEntry()
   * @generated
   */
  EAttribute getFromEntry_Withoutsubtypes();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getWithoutsubtypesTypes <em>Withoutsubtypes Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Withoutsubtypes Types</em>'.
   * @see org.eclipse.emf.query2.syntax.query.FromEntry#getWithoutsubtypesTypes()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_WithoutsubtypesTypes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.emf.query2.syntax.query.FromEntry#getAlias()
   * @see #getFromEntry()
   * @generated
   */
  EAttribute getFromEntry_Alias();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.FromEntry#getScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope Clause</em>'.
   * @see org.eclipse.emf.query2.syntax.query.FromEntry#getScopeClause()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_ScopeClause();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.ScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope Clause</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ScopeClause
   * @generated
   */
  EClass getScopeClause();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.ScopeClause#isNotIn <em>Not In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not In</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ScopeClause#isNotIn()
   * @see #getScopeClause()
   * @generated
   */
  EAttribute getScopeClause_NotIn();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.syntax.query.ScopeClause#getUris <em>Uris</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Uris</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ScopeClause#getUris()
   * @see #getScopeClause()
   * @generated
   */
  EAttribute getScopeClause_Uris();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.ResourceScope <em>Resource Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Scope</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ResourceScope
   * @generated
   */
  EClass getResourceScope();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.ElementScope <em>Element Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Scope</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ElementScope
   * @generated
   */
  EClass getElementScope();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.WhereEntry <em>Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Where Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.WhereEntry
   * @generated
   */
  EClass getWhereEntry();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry <em>Expression Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Where Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry
   * @generated
   */
  EClass getExpressionWhereEntry();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getLhs()
   * @see #getExpressionWhereEntry()
   * @generated
   */
  EReference getExpressionWhereEntry_Lhs();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getOperator()
   * @see #getExpressionWhereEntry()
   * @generated
   */
  EAttribute getExpressionWhereEntry_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getRhs <em>Rhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rhs</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ExpressionWhereEntry#getRhs()
   * @see #getExpressionWhereEntry()
   * @generated
   */
  EReference getExpressionWhereEntry_Rhs();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression <em>Alias Attribute Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alias Attribute Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.AliasAttributeExpression
   * @generated
   */
  EClass getAliasAttributeExpression();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAlias()
   * @see #getAliasAttributeExpression()
   * @generated
   */
  EReference getAliasAttributeExpression_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.emf.query2.syntax.query.AliasAttributeExpression#getAttribute()
   * @see #getAliasAttributeExpression()
   * @generated
   */
  EReference getAliasAttributeExpression_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.ReplacableValue <em>Replacable Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Replacable Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ReplacableValue
   * @generated
   */
  EClass getReplacableValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.ReplacableValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.ReplacableValue#getValue()
   * @see #getReplacableValue()
   * @generated
   */
  EAttribute getReplacableValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.DoubleExpression <em>Double Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.DoubleExpression
   * @generated
   */
  EClass getDoubleExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.DoubleExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.DoubleExpression#getValue()
   * @see #getDoubleExpression()
   * @generated
   */
  EAttribute getDoubleExpression_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.LongExpression <em>Long Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Long Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.LongExpression
   * @generated
   */
  EClass getLongExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.LongExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.LongExpression#getValue()
   * @see #getLongExpression()
   * @generated
   */
  EAttribute getLongExpression_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.StringExpression <em>String Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.StringExpression
   * @generated
   */
  EClass getStringExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.StringExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.StringExpression#getValue()
   * @see #getStringExpression()
   * @generated
   */
  EAttribute getStringExpression_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.NullExpression <em>Null Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.NullExpression
   * @generated
   */
  EClass getNullExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.NullExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.NullExpression#getValue()
   * @see #getNullExpression()
   * @generated
   */
  EAttribute getNullExpression_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.BooleanExpression <em>Boolean Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.BooleanExpression
   * @generated
   */
  EClass getBooleanExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.syntax.query.BooleanExpression#isTrue <em>True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>True</em>'.
   * @see org.eclipse.emf.query2.syntax.query.BooleanExpression#isTrue()
   * @see #getBooleanExpression()
   * @generated
   */
  EAttribute getBooleanExpression_True();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.QueryExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.emf.query2.syntax.query.QueryExpression
   * @generated
   */
  EClass getQueryExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.syntax.query.QueryExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.emf.query2.syntax.query.QueryExpression#getValue()
   * @see #getQueryExpression()
   * @generated
   */
  EReference getQueryExpression_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.OrWhereEntry <em>Or Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Where Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.OrWhereEntry
   * @generated
   */
  EClass getOrWhereEntry();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.syntax.query.OrWhereEntry#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.emf.query2.syntax.query.OrWhereEntry#getEntries()
   * @see #getOrWhereEntry()
   * @generated
   */
  EReference getOrWhereEntry_Entries();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.syntax.query.AndWhereEntry <em>And Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Where Entry</em>'.
   * @see org.eclipse.emf.query2.syntax.query.AndWhereEntry
   * @generated
   */
  EClass getAndWhereEntry();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.syntax.query.AndWhereEntry#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.emf.query2.syntax.query.AndWhereEntry#getEntries()
   * @see #getAndWhereEntry()
   * @generated
   */
  EReference getAndWhereEntry_Entries();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.query2.syntax.query.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.syntax.query.Operator
   * @generated
   */
  EEnum getOperator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  QueryFactory getQueryFactory();

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
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ModelImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '<em><b>Default Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DEFAULT_QUERY = eINSTANCE.getModel_DefaultQuery();

    /**
     * The meta object literal for the '<em><b>Named Queries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__NAMED_QUERIES = eINSTANCE.getModel_NamedQueries();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ImportImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imp URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMP_URI = eINSTANCE.getImport_ImpURI();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.NamedQueryImpl <em>Named Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.NamedQueryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getNamedQuery()
     * @generated
     */
    EClass NAMED_QUERY = eINSTANCE.getNamedQuery();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_QUERY__NAME = eINSTANCE.getNamedQuery_Name();

    /**
     * The meta object literal for the '<em><b>Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_QUERY__QUERY = eINSTANCE.getNamedQuery_Query();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl <em>MQ Lquery</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.MQLqueryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getMQLquery()
     * @generated
     */
    EClass MQ_LQUERY = eINSTANCE.getMQLquery();

    /**
     * The meta object literal for the '<em><b>From Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__FROM_ENTRIES = eINSTANCE.getMQLquery_FromEntries();

    /**
     * The meta object literal for the '<em><b>Select Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__SELECT_ENTRIES = eINSTANCE.getMQLquery_SelectEntries();

    /**
     * The meta object literal for the '<em><b>Where Entry</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__WHERE_ENTRY = eINSTANCE.getMQLquery_WhereEntry();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.SelectEntryImpl <em>Select Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.SelectEntryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getSelectEntry()
     * @generated
     */
    EClass SELECT_ENTRY = eINSTANCE.getSelectEntry();

    /**
     * The meta object literal for the '<em><b>Select</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECT_ENTRY__SELECT = eINSTANCE.getSelectEntry_Select();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECT_ENTRY__ATTRIBUTE = eINSTANCE.getSelectEntry_Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl <em>From Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.FromEntryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getFromEntry()
     * @generated
     */
    EClass FROM_ENTRY = eINSTANCE.getFromEntry();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FROM_ENTRY__TYPE = eINSTANCE.getFromEntry_Type();

    /**
     * The meta object literal for the '<em><b>Withoutsubtypes</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FROM_ENTRY__WITHOUTSUBTYPES = eINSTANCE.getFromEntry_Withoutsubtypes();

    /**
     * The meta object literal for the '<em><b>Withoutsubtypes Types</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FROM_ENTRY__WITHOUTSUBTYPES_TYPES = eINSTANCE.getFromEntry_WithoutsubtypesTypes();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FROM_ENTRY__ALIAS = eINSTANCE.getFromEntry_Alias();

    /**
     * The meta object literal for the '<em><b>Scope Clause</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FROM_ENTRY__SCOPE_CLAUSE = eINSTANCE.getFromEntry_ScopeClause();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ScopeClauseImpl <em>Scope Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ScopeClauseImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getScopeClause()
     * @generated
     */
    EClass SCOPE_CLAUSE = eINSTANCE.getScopeClause();

    /**
     * The meta object literal for the '<em><b>Not In</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCOPE_CLAUSE__NOT_IN = eINSTANCE.getScopeClause_NotIn();

    /**
     * The meta object literal for the '<em><b>Uris</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCOPE_CLAUSE__URIS = eINSTANCE.getScopeClause_Uris();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ResourceScopeImpl <em>Resource Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ResourceScopeImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getResourceScope()
     * @generated
     */
    EClass RESOURCE_SCOPE = eINSTANCE.getResourceScope();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ElementScopeImpl <em>Element Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ElementScopeImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getElementScope()
     * @generated
     */
    EClass ELEMENT_SCOPE = eINSTANCE.getElementScope();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.WhereEntryImpl <em>Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.WhereEntryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getWhereEntry()
     * @generated
     */
    EClass WHERE_ENTRY = eINSTANCE.getWhereEntry();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ExpressionWhereEntryImpl <em>Expression Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ExpressionWhereEntryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getExpressionWhereEntry()
     * @generated
     */
    EClass EXPRESSION_WHERE_ENTRY = eINSTANCE.getExpressionWhereEntry();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_WHERE_ENTRY__LHS = eINSTANCE.getExpressionWhereEntry_Lhs();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_WHERE_ENTRY__OPERATOR = eINSTANCE.getExpressionWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_WHERE_ENTRY__RHS = eINSTANCE.getExpressionWhereEntry_Rhs();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.AliasAttributeExpressionImpl <em>Alias Attribute Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.AliasAttributeExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getAliasAttributeExpression()
     * @generated
     */
    EClass ALIAS_ATTRIBUTE_EXPRESSION = eINSTANCE.getAliasAttributeExpression();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIAS_ATTRIBUTE_EXPRESSION__ALIAS = eINSTANCE.getAliasAttributeExpression_Alias();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIAS_ATTRIBUTE_EXPRESSION__ATTRIBUTE = eINSTANCE.getAliasAttributeExpression_Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.ReplacableValueImpl <em>Replacable Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.ReplacableValueImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getReplacableValue()
     * @generated
     */
    EClass REPLACABLE_VALUE = eINSTANCE.getReplacableValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPLACABLE_VALUE__VALUE = eINSTANCE.getReplacableValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.DoubleExpressionImpl <em>Double Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.DoubleExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getDoubleExpression()
     * @generated
     */
    EClass DOUBLE_EXPRESSION = eINSTANCE.getDoubleExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_EXPRESSION__VALUE = eINSTANCE.getDoubleExpression_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.LongExpressionImpl <em>Long Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.LongExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getLongExpression()
     * @generated
     */
    EClass LONG_EXPRESSION = eINSTANCE.getLongExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LONG_EXPRESSION__VALUE = eINSTANCE.getLongExpression_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.StringExpressionImpl <em>String Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.StringExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getStringExpression()
     * @generated
     */
    EClass STRING_EXPRESSION = eINSTANCE.getStringExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_EXPRESSION__VALUE = eINSTANCE.getStringExpression_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.NullExpressionImpl <em>Null Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.NullExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getNullExpression()
     * @generated
     */
    EClass NULL_EXPRESSION = eINSTANCE.getNullExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NULL_EXPRESSION__VALUE = eINSTANCE.getNullExpression_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.BooleanExpressionImpl <em>Boolean Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.BooleanExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getBooleanExpression()
     * @generated
     */
    EClass BOOLEAN_EXPRESSION = eINSTANCE.getBooleanExpression();

    /**
     * The meta object literal for the '<em><b>True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_EXPRESSION__TRUE = eINSTANCE.getBooleanExpression_True();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.QueryExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryExpressionImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getQueryExpression()
     * @generated
     */
    EClass QUERY_EXPRESSION = eINSTANCE.getQueryExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUERY_EXPRESSION__VALUE = eINSTANCE.getQueryExpression_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.OrWhereEntryImpl <em>Or Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.OrWhereEntryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getOrWhereEntry()
     * @generated
     */
    EClass OR_WHERE_ENTRY = eINSTANCE.getOrWhereEntry();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_WHERE_ENTRY__ENTRIES = eINSTANCE.getOrWhereEntry_Entries();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.impl.AndWhereEntryImpl <em>And Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.impl.AndWhereEntryImpl
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getAndWhereEntry()
     * @generated
     */
    EClass AND_WHERE_ENTRY = eINSTANCE.getAndWhereEntry();

    /**
     * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_WHERE_ENTRY__ENTRIES = eINSTANCE.getAndWhereEntry_Entries();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.syntax.query.Operator <em>Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.syntax.query.Operator
     * @see org.eclipse.emf.query2.syntax.query.impl.QueryPackageImpl#getOperator()
     * @generated
     */
    EEnum OPERATOR = eINSTANCE.getOperator();

  }

} //QueryPackage
