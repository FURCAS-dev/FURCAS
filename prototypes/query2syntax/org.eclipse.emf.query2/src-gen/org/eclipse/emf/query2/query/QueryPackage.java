/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query;

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
 * @see org.eclipse.emf.query2.query.QueryFactory
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
  QueryPackage eINSTANCE = org.eclipse.emf.query2.query.impl.QueryPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ModelImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getModel()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ImportImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getImport()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.NamedQueryImpl <em>Named Query</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.NamedQueryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNamedQuery()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.MQLqueryImpl <em>MQ Lquery</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.MQLqueryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getMQLquery()
   * @generated
   */
  int MQ_LQUERY = 3;

  /**
   * The feature id for the '<em><b>Select Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__SELECT_ENTRIES = 0;

  /**
   * The feature id for the '<em><b>From Entries</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MQ_LQUERY__FROM_ENTRIES = 1;

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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.SelectEntryImpl <em>Select Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.SelectEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getSelectEntry()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.FromEntryImpl <em>From Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.FromEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getFromEntry()
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
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__ALIAS = 2;

  /**
   * The feature id for the '<em><b>Scope Clause</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY__SCOPE_CLAUSE = 3;

  /**
   * The number of structural features of the '<em>From Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_ENTRY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ScopeClauseImpl <em>Scope Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ScopeClauseImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getScopeClause()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ResourceScopeImpl <em>Resource Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ResourceScopeImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getResourceScope()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ElementScopeImpl <em>Element Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ElementScopeImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getElementScope()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.WhereEntryImpl <em>Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.WhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getWhereEntry()
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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.AbstractAliasWhereEntryImpl <em>Abstract Alias Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.AbstractAliasWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAbstractAliasWhereEntry()
   * @generated
   */
  int ABSTRACT_ALIAS_WHERE_ENTRY = 10;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ALIAS_WHERE_ENTRY__ALIAS = WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Alias Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT = WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.AttributeWhereEntryImpl <em>Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.AttributeWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAttributeWhereEntry()
   * @generated
   */
  int ATTRIBUTE_WHERE_ENTRY = 11;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_WHERE_ENTRY__ALIAS = ABSTRACT_ALIAS_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.NumericAttributeWhereEntryImpl <em>Numeric Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.NumericAttributeWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNumericAttributeWhereEntry()
   * @generated
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY = 12;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Numeric Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.DoubleWhereEntryImpl <em>Double Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.DoubleWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getDoubleWhereEntry()
   * @generated
   */
  int DOUBLE_WHERE_ENTRY = 13;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__ALIAS = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__ATTRIBUTE = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__OPERATOR = NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY__VALUE = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Double Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOUBLE_WHERE_ENTRY_FEATURE_COUNT = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.LongWhereEntryImpl <em>Long Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.LongWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getLongWhereEntry()
   * @generated
   */
  int LONG_WHERE_ENTRY = 14;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__ALIAS = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__ATTRIBUTE = NUMERIC_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__OPERATOR = NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY__VALUE = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Long Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LONG_WHERE_ENTRY_FEATURE_COUNT = NUMERIC_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.VariableWhereEntryImpl <em>Variable Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.VariableWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getVariableWhereEntry()
   * @generated
   */
  int VARIABLE_WHERE_ENTRY = 15;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__RIGHT_ALIAS = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.StringAttributeWhereEntryImpl <em>String Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.StringAttributeWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getStringAttributeWhereEntry()
   * @generated
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY = 16;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>String Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.BooleanAttributeWhereEntryImpl <em>Boolean Attribute Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.BooleanAttributeWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getBooleanAttributeWhereEntry()
   * @generated
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY = 17;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__ALIAS = ATTRIBUTE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__OPERATOR = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY__IS_TRUE = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Boolean Attribute Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT = ATTRIBUTE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ReferenceWhereEntryImpl <em>Reference Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ReferenceWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getReferenceWhereEntry()
   * @generated
   */
  int REFERENCE_WHERE_ENTRY = 18;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_WHERE_ENTRY__ALIAS = ABSTRACT_ALIAS_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_WHERE_ENTRY__REFERENCE = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_WHERE_ENTRY_FEATURE_COUNT = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.NullWhereEntryImpl <em>Null Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.NullWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNullWhereEntry()
   * @generated
   */
  int NULL_WHERE_ENTRY = 19;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY__ALIAS = ABSTRACT_ALIAS_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY__FEATURE = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY__OPERATOR = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Null Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_WHERE_ENTRY_FEATURE_COUNT = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.ReferenceAliasWhereEntryImpl <em>Reference Alias Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.ReferenceAliasWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getReferenceAliasWhereEntry()
   * @generated
   */
  int REFERENCE_ALIAS_WHERE_ENTRY = 20;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY__ALIAS = REFERENCE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY__REFERENCE = REFERENCE_WHERE_ENTRY__REFERENCE;

  /**
   * The feature id for the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS = REFERENCE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference Alias Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_ALIAS_WHERE_ENTRY_FEATURE_COUNT = REFERENCE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.SubselectWhereEntryImpl <em>Subselect Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.SubselectWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getSubselectWhereEntry()
   * @generated
   */
  int SUBSELECT_WHERE_ENTRY = 21;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__ALIAS = REFERENCE_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__REFERENCE = REFERENCE_WHERE_ENTRY__REFERENCE;

  /**
   * The feature id for the '<em><b>Not In</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__NOT_IN = REFERENCE_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sub Query</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY__SUB_QUERY = REFERENCE_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Subselect Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSELECT_WHERE_ENTRY_FEATURE_COUNT = REFERENCE_WHERE_ENTRY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.AliasWhereEntryImpl <em>Alias Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.AliasWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAliasWhereEntry()
   * @generated
   */
  int ALIAS_WHERE_ENTRY = 22;

  /**
   * The feature id for the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_WHERE_ENTRY__ALIAS = ABSTRACT_ALIAS_WHERE_ENTRY__ALIAS;

  /**
   * The feature id for the '<em><b>Right Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_WHERE_ENTRY__RIGHT_ALIAS = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Alias Where Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIAS_WHERE_ENTRY_FEATURE_COUNT = ABSTRACT_ALIAS_WHERE_ENTRY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.OrWhereEntryImpl <em>Or Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.OrWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getOrWhereEntry()
   * @generated
   */
  int OR_WHERE_ENTRY = 23;

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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.impl.AndWhereEntryImpl <em>And Where Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.impl.AndWhereEntryImpl
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAndWhereEntry()
   * @generated
   */
  int AND_WHERE_ENTRY = 24;

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
   * The meta object id for the '{@link org.eclipse.emf.query2.query.NumericOperator <em>Numeric Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.NumericOperator
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNumericOperator()
   * @generated
   */
  int NUMERIC_OPERATOR = 25;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.StringOperator <em>String Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.StringOperator
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getStringOperator()
   * @generated
   */
  int STRING_OPERATOR = 26;

  /**
   * The meta object id for the '{@link org.eclipse.emf.query2.query.BooleanOperator <em>Boolean Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.query2.query.BooleanOperator
   * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getBooleanOperator()
   * @generated
   */
  int BOOLEAN_OPERATOR = 27;


  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.emf.query2.query.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.query.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.emf.query2.query.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.query.Model#getDefaultQuery <em>Default Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default Query</em>'.
   * @see org.eclipse.emf.query2.query.Model#getDefaultQuery()
   * @see #getModel()
   * @generated
   */
  EReference getModel_DefaultQuery();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.query.Model#getNamedQueries <em>Named Queries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Named Queries</em>'.
   * @see org.eclipse.emf.query2.query.Model#getNamedQueries()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NamedQueries();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.emf.query2.query.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.Import#getImpURI <em>Imp URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imp URI</em>'.
   * @see org.eclipse.emf.query2.query.Import#getImpURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImpURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.NamedQuery <em>Named Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Query</em>'.
   * @see org.eclipse.emf.query2.query.NamedQuery
   * @generated
   */
  EClass getNamedQuery();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.NamedQuery#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.emf.query2.query.NamedQuery#getName()
   * @see #getNamedQuery()
   * @generated
   */
  EAttribute getNamedQuery_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.query.NamedQuery#getQuery <em>Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Query</em>'.
   * @see org.eclipse.emf.query2.query.NamedQuery#getQuery()
   * @see #getNamedQuery()
   * @generated
   */
  EReference getNamedQuery_Query();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.MQLquery <em>MQ Lquery</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>MQ Lquery</em>'.
   * @see org.eclipse.emf.query2.query.MQLquery
   * @generated
   */
  EClass getMQLquery();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.query.MQLquery#getSelectEntries <em>Select Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Select Entries</em>'.
   * @see org.eclipse.emf.query2.query.MQLquery#getSelectEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_SelectEntries();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.query.MQLquery#getFromEntries <em>From Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>From Entries</em>'.
   * @see org.eclipse.emf.query2.query.MQLquery#getFromEntries()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_FromEntries();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.query.MQLquery#getWhereEntry <em>Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.MQLquery#getWhereEntry()
   * @see #getMQLquery()
   * @generated
   */
  EReference getMQLquery_WhereEntry();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.SelectEntry <em>Select Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Select Entry</em>'.
   * @see org.eclipse.emf.query2.query.SelectEntry
   * @generated
   */
  EClass getSelectEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.SelectEntry#getSelect <em>Select</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Select</em>'.
   * @see org.eclipse.emf.query2.query.SelectEntry#getSelect()
   * @see #getSelectEntry()
   * @generated
   */
  EReference getSelectEntry_Select();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.SelectEntry#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.emf.query2.query.SelectEntry#getAttribute()
   * @see #getSelectEntry()
   * @generated
   */
  EReference getSelectEntry_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.FromEntry <em>From Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>From Entry</em>'.
   * @see org.eclipse.emf.query2.query.FromEntry
   * @generated
   */
  EClass getFromEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.FromEntry#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.emf.query2.query.FromEntry#getType()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.FromEntry#isWithoutsubtypes <em>Withoutsubtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Withoutsubtypes</em>'.
   * @see org.eclipse.emf.query2.query.FromEntry#isWithoutsubtypes()
   * @see #getFromEntry()
   * @generated
   */
  EAttribute getFromEntry_Withoutsubtypes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.FromEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.emf.query2.query.FromEntry#getAlias()
   * @see #getFromEntry()
   * @generated
   */
  EAttribute getFromEntry_Alias();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.query.FromEntry#getScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope Clause</em>'.
   * @see org.eclipse.emf.query2.query.FromEntry#getScopeClause()
   * @see #getFromEntry()
   * @generated
   */
  EReference getFromEntry_ScopeClause();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.ScopeClause <em>Scope Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope Clause</em>'.
   * @see org.eclipse.emf.query2.query.ScopeClause
   * @generated
   */
  EClass getScopeClause();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.ScopeClause#isNotIn <em>Not In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not In</em>'.
   * @see org.eclipse.emf.query2.query.ScopeClause#isNotIn()
   * @see #getScopeClause()
   * @generated
   */
  EAttribute getScopeClause_NotIn();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.query.ScopeClause#getUris <em>Uris</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Uris</em>'.
   * @see org.eclipse.emf.query2.query.ScopeClause#getUris()
   * @see #getScopeClause()
   * @generated
   */
  EAttribute getScopeClause_Uris();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.ResourceScope <em>Resource Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Scope</em>'.
   * @see org.eclipse.emf.query2.query.ResourceScope
   * @generated
   */
  EClass getResourceScope();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.ElementScope <em>Element Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Scope</em>'.
   * @see org.eclipse.emf.query2.query.ElementScope
   * @generated
   */
  EClass getElementScope();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.WhereEntry <em>Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.WhereEntry
   * @generated
   */
  EClass getWhereEntry();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.AbstractAliasWhereEntry <em>Abstract Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Alias Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.AbstractAliasWhereEntry
   * @generated
   */
  EClass getAbstractAliasWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.AbstractAliasWhereEntry#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Alias</em>'.
   * @see org.eclipse.emf.query2.query.AbstractAliasWhereEntry#getAlias()
   * @see #getAbstractAliasWhereEntry()
   * @generated
   */
  EReference getAbstractAliasWhereEntry_Alias();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.AttributeWhereEntry <em>Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.AttributeWhereEntry
   * @generated
   */
  EClass getAttributeWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.AttributeWhereEntry#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see org.eclipse.emf.query2.query.AttributeWhereEntry#getAttribute()
   * @see #getAttributeWhereEntry()
   * @generated
   */
  EReference getAttributeWhereEntry_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.NumericAttributeWhereEntry <em>Numeric Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Attribute Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.NumericAttributeWhereEntry
   * @generated
   */
  EClass getNumericAttributeWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.NumericAttributeWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.query.NumericAttributeWhereEntry#getOperator()
   * @see #getNumericAttributeWhereEntry()
   * @generated
   */
  EAttribute getNumericAttributeWhereEntry_Operator();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.DoubleWhereEntry <em>Double Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Double Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.DoubleWhereEntry
   * @generated
   */
  EClass getDoubleWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.DoubleWhereEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.query.DoubleWhereEntry#getValue()
   * @see #getDoubleWhereEntry()
   * @generated
   */
  EAttribute getDoubleWhereEntry_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.LongWhereEntry <em>Long Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Long Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.LongWhereEntry
   * @generated
   */
  EClass getLongWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.LongWhereEntry#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.emf.query2.query.LongWhereEntry#getValue()
   * @see #getLongWhereEntry()
   * @generated
   */
  EAttribute getLongWhereEntry_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.VariableWhereEntry <em>Variable Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.VariableWhereEntry
   * @generated
   */
  EClass getVariableWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.VariableWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.query.VariableWhereEntry#getOperator()
   * @see #getVariableWhereEntry()
   * @generated
   */
  EAttribute getVariableWhereEntry_Operator();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.VariableWhereEntry#getRightAlias <em>Right Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Alias</em>'.
   * @see org.eclipse.emf.query2.query.VariableWhereEntry#getRightAlias()
   * @see #getVariableWhereEntry()
   * @generated
   */
  EReference getVariableWhereEntry_RightAlias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.VariableWhereEntry#getRightAttribute <em>Right Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Attribute</em>'.
   * @see org.eclipse.emf.query2.query.VariableWhereEntry#getRightAttribute()
   * @see #getVariableWhereEntry()
   * @generated
   */
  EReference getVariableWhereEntry_RightAttribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry <em>String Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Attribute Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.StringAttributeWhereEntry
   * @generated
   */
  EClass getStringAttributeWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.query.StringAttributeWhereEntry#getOperator()
   * @see #getStringAttributeWhereEntry()
   * @generated
   */
  EAttribute getStringAttributeWhereEntry_Operator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.StringAttributeWhereEntry#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pattern</em>'.
   * @see org.eclipse.emf.query2.query.StringAttributeWhereEntry#getPattern()
   * @see #getStringAttributeWhereEntry()
   * @generated
   */
  EAttribute getStringAttributeWhereEntry_Pattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.BooleanAttributeWhereEntry <em>Boolean Attribute Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Attribute Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.BooleanAttributeWhereEntry
   * @generated
   */
  EClass getBooleanAttributeWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.BooleanAttributeWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.query.BooleanAttributeWhereEntry#getOperator()
   * @see #getBooleanAttributeWhereEntry()
   * @generated
   */
  EAttribute getBooleanAttributeWhereEntry_Operator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.BooleanAttributeWhereEntry#isIsTrue <em>Is True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is True</em>'.
   * @see org.eclipse.emf.query2.query.BooleanAttributeWhereEntry#isIsTrue()
   * @see #getBooleanAttributeWhereEntry()
   * @generated
   */
  EAttribute getBooleanAttributeWhereEntry_IsTrue();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.ReferenceWhereEntry <em>Reference Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.ReferenceWhereEntry
   * @generated
   */
  EClass getReferenceWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.ReferenceWhereEntry#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.eclipse.emf.query2.query.ReferenceWhereEntry#getReference()
   * @see #getReferenceWhereEntry()
   * @generated
   */
  EReference getReferenceWhereEntry_Reference();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.NullWhereEntry <em>Null Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.NullWhereEntry
   * @generated
   */
  EClass getNullWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.NullWhereEntry#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.eclipse.emf.query2.query.NullWhereEntry#getFeature()
   * @see #getNullWhereEntry()
   * @generated
   */
  EReference getNullWhereEntry_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.NullWhereEntry#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.emf.query2.query.NullWhereEntry#getOperator()
   * @see #getNullWhereEntry()
   * @generated
   */
  EAttribute getNullWhereEntry_Operator();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.ReferenceAliasWhereEntry <em>Reference Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Alias Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.ReferenceAliasWhereEntry
   * @generated
   */
  EClass getReferenceAliasWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.ReferenceAliasWhereEntry#getRightAlias <em>Right Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Alias</em>'.
   * @see org.eclipse.emf.query2.query.ReferenceAliasWhereEntry#getRightAlias()
   * @see #getReferenceAliasWhereEntry()
   * @generated
   */
  EReference getReferenceAliasWhereEntry_RightAlias();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.SubselectWhereEntry <em>Subselect Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subselect Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.SubselectWhereEntry
   * @generated
   */
  EClass getSubselectWhereEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.query.SubselectWhereEntry#isNotIn <em>Not In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Not In</em>'.
   * @see org.eclipse.emf.query2.query.SubselectWhereEntry#isNotIn()
   * @see #getSubselectWhereEntry()
   * @generated
   */
  EAttribute getSubselectWhereEntry_NotIn();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.query.SubselectWhereEntry#getSubQuery <em>Sub Query</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Query</em>'.
   * @see org.eclipse.emf.query2.query.SubselectWhereEntry#getSubQuery()
   * @see #getSubselectWhereEntry()
   * @generated
   */
  EReference getSubselectWhereEntry_SubQuery();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.AliasWhereEntry <em>Alias Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alias Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.AliasWhereEntry
   * @generated
   */
  EClass getAliasWhereEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.emf.query2.query.AliasWhereEntry#getRightAlias <em>Right Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Alias</em>'.
   * @see org.eclipse.emf.query2.query.AliasWhereEntry#getRightAlias()
   * @see #getAliasWhereEntry()
   * @generated
   */
  EReference getAliasWhereEntry_RightAlias();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.OrWhereEntry <em>Or Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.OrWhereEntry
   * @generated
   */
  EClass getOrWhereEntry();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.query.OrWhereEntry#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.emf.query2.query.OrWhereEntry#getEntries()
   * @see #getOrWhereEntry()
   * @generated
   */
  EReference getOrWhereEntry_Entries();

  /**
   * Returns the meta object for class '{@link org.eclipse.emf.query2.query.AndWhereEntry <em>And Where Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Where Entry</em>'.
   * @see org.eclipse.emf.query2.query.AndWhereEntry
   * @generated
   */
  EClass getAndWhereEntry();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.query.AndWhereEntry#getEntries <em>Entries</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entries</em>'.
   * @see org.eclipse.emf.query2.query.AndWhereEntry#getEntries()
   * @see #getAndWhereEntry()
   * @generated
   */
  EReference getAndWhereEntry_Entries();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.query2.query.NumericOperator <em>Numeric Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Numeric Operator</em>'.
   * @see org.eclipse.emf.query2.query.NumericOperator
   * @generated
   */
  EEnum getNumericOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.query2.query.StringOperator <em>String Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>String Operator</em>'.
   * @see org.eclipse.emf.query2.query.StringOperator
   * @generated
   */
  EEnum getStringOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipse.emf.query2.query.BooleanOperator <em>Boolean Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Boolean Operator</em>'.
   * @see org.eclipse.emf.query2.query.BooleanOperator
   * @generated
   */
  EEnum getBooleanOperator();

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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ModelImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getModel()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ImportImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getImport()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.NamedQueryImpl <em>Named Query</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.NamedQueryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNamedQuery()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.MQLqueryImpl <em>MQ Lquery</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.MQLqueryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getMQLquery()
     * @generated
     */
    EClass MQ_LQUERY = eINSTANCE.getMQLquery();

    /**
     * The meta object literal for the '<em><b>Select Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__SELECT_ENTRIES = eINSTANCE.getMQLquery_SelectEntries();

    /**
     * The meta object literal for the '<em><b>From Entries</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__FROM_ENTRIES = eINSTANCE.getMQLquery_FromEntries();

    /**
     * The meta object literal for the '<em><b>Where Entry</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MQ_LQUERY__WHERE_ENTRY = eINSTANCE.getMQLquery_WhereEntry();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.SelectEntryImpl <em>Select Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.SelectEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getSelectEntry()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.FromEntryImpl <em>From Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.FromEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getFromEntry()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ScopeClauseImpl <em>Scope Clause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ScopeClauseImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getScopeClause()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ResourceScopeImpl <em>Resource Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ResourceScopeImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getResourceScope()
     * @generated
     */
    EClass RESOURCE_SCOPE = eINSTANCE.getResourceScope();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ElementScopeImpl <em>Element Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ElementScopeImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getElementScope()
     * @generated
     */
    EClass ELEMENT_SCOPE = eINSTANCE.getElementScope();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.WhereEntryImpl <em>Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.WhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getWhereEntry()
     * @generated
     */
    EClass WHERE_ENTRY = eINSTANCE.getWhereEntry();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.AbstractAliasWhereEntryImpl <em>Abstract Alias Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.AbstractAliasWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAbstractAliasWhereEntry()
     * @generated
     */
    EClass ABSTRACT_ALIAS_WHERE_ENTRY = eINSTANCE.getAbstractAliasWhereEntry();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_ALIAS_WHERE_ENTRY__ALIAS = eINSTANCE.getAbstractAliasWhereEntry_Alias();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.AttributeWhereEntryImpl <em>Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.AttributeWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAttributeWhereEntry()
     * @generated
     */
    EClass ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE_WHERE_ENTRY__ATTRIBUTE = eINSTANCE.getAttributeWhereEntry_Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.NumericAttributeWhereEntryImpl <em>Numeric Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.NumericAttributeWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNumericAttributeWhereEntry()
     * @generated
     */
    EClass NUMERIC_ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getNumericAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERIC_ATTRIBUTE_WHERE_ENTRY__OPERATOR = eINSTANCE.getNumericAttributeWhereEntry_Operator();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.DoubleWhereEntryImpl <em>Double Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.DoubleWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getDoubleWhereEntry()
     * @generated
     */
    EClass DOUBLE_WHERE_ENTRY = eINSTANCE.getDoubleWhereEntry();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOUBLE_WHERE_ENTRY__VALUE = eINSTANCE.getDoubleWhereEntry_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.LongWhereEntryImpl <em>Long Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.LongWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getLongWhereEntry()
     * @generated
     */
    EClass LONG_WHERE_ENTRY = eINSTANCE.getLongWhereEntry();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LONG_WHERE_ENTRY__VALUE = eINSTANCE.getLongWhereEntry_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.VariableWhereEntryImpl <em>Variable Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.VariableWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getVariableWhereEntry()
     * @generated
     */
    EClass VARIABLE_WHERE_ENTRY = eINSTANCE.getVariableWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_WHERE_ENTRY__OPERATOR = eINSTANCE.getVariableWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Right Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_WHERE_ENTRY__RIGHT_ALIAS = eINSTANCE.getVariableWhereEntry_RightAlias();

    /**
     * The meta object literal for the '<em><b>Right Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_WHERE_ENTRY__RIGHT_ATTRIBUTE = eINSTANCE.getVariableWhereEntry_RightAttribute();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.StringAttributeWhereEntryImpl <em>String Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.StringAttributeWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getStringAttributeWhereEntry()
     * @generated
     */
    EClass STRING_ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getStringAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_ATTRIBUTE_WHERE_ENTRY__OPERATOR = eINSTANCE.getStringAttributeWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_ATTRIBUTE_WHERE_ENTRY__PATTERN = eINSTANCE.getStringAttributeWhereEntry_Pattern();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.BooleanAttributeWhereEntryImpl <em>Boolean Attribute Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.BooleanAttributeWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getBooleanAttributeWhereEntry()
     * @generated
     */
    EClass BOOLEAN_ATTRIBUTE_WHERE_ENTRY = eINSTANCE.getBooleanAttributeWhereEntry();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_ATTRIBUTE_WHERE_ENTRY__OPERATOR = eINSTANCE.getBooleanAttributeWhereEntry_Operator();

    /**
     * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_ATTRIBUTE_WHERE_ENTRY__IS_TRUE = eINSTANCE.getBooleanAttributeWhereEntry_IsTrue();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ReferenceWhereEntryImpl <em>Reference Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ReferenceWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getReferenceWhereEntry()
     * @generated
     */
    EClass REFERENCE_WHERE_ENTRY = eINSTANCE.getReferenceWhereEntry();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_WHERE_ENTRY__REFERENCE = eINSTANCE.getReferenceWhereEntry_Reference();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.NullWhereEntryImpl <em>Null Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.NullWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNullWhereEntry()
     * @generated
     */
    EClass NULL_WHERE_ENTRY = eINSTANCE.getNullWhereEntry();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NULL_WHERE_ENTRY__FEATURE = eINSTANCE.getNullWhereEntry_Feature();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NULL_WHERE_ENTRY__OPERATOR = eINSTANCE.getNullWhereEntry_Operator();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.ReferenceAliasWhereEntryImpl <em>Reference Alias Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.ReferenceAliasWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getReferenceAliasWhereEntry()
     * @generated
     */
    EClass REFERENCE_ALIAS_WHERE_ENTRY = eINSTANCE.getReferenceAliasWhereEntry();

    /**
     * The meta object literal for the '<em><b>Right Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_ALIAS_WHERE_ENTRY__RIGHT_ALIAS = eINSTANCE.getReferenceAliasWhereEntry_RightAlias();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.SubselectWhereEntryImpl <em>Subselect Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.SubselectWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getSubselectWhereEntry()
     * @generated
     */
    EClass SUBSELECT_WHERE_ENTRY = eINSTANCE.getSubselectWhereEntry();

    /**
     * The meta object literal for the '<em><b>Not In</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBSELECT_WHERE_ENTRY__NOT_IN = eINSTANCE.getSubselectWhereEntry_NotIn();

    /**
     * The meta object literal for the '<em><b>Sub Query</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSELECT_WHERE_ENTRY__SUB_QUERY = eINSTANCE.getSubselectWhereEntry_SubQuery();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.AliasWhereEntryImpl <em>Alias Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.AliasWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAliasWhereEntry()
     * @generated
     */
    EClass ALIAS_WHERE_ENTRY = eINSTANCE.getAliasWhereEntry();

    /**
     * The meta object literal for the '<em><b>Right Alias</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIAS_WHERE_ENTRY__RIGHT_ALIAS = eINSTANCE.getAliasWhereEntry_RightAlias();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.OrWhereEntryImpl <em>Or Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.OrWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getOrWhereEntry()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.impl.AndWhereEntryImpl <em>And Where Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.impl.AndWhereEntryImpl
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getAndWhereEntry()
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
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.NumericOperator <em>Numeric Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.NumericOperator
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getNumericOperator()
     * @generated
     */
    EEnum NUMERIC_OPERATOR = eINSTANCE.getNumericOperator();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.StringOperator <em>String Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.StringOperator
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getStringOperator()
     * @generated
     */
    EEnum STRING_OPERATOR = eINSTANCE.getStringOperator();

    /**
     * The meta object literal for the '{@link org.eclipse.emf.query2.query.BooleanOperator <em>Boolean Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.query2.query.BooleanOperator
     * @see org.eclipse.emf.query2.query.impl.QueryPackageImpl#getBooleanOperator()
     * @generated
     */
    EEnum BOOLEAN_OPERATOR = eINSTANCE.getBooleanOperator();

  }

} //QueryPackage
