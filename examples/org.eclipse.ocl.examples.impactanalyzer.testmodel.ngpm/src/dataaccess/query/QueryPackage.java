/**
 * <copyright>
 * </copyright>
 *
 * $Id: QueryPackage.java,v 1.1 2011/02/07 16:53:52 auhl Exp $
 */
package dataaccess.query;

import dataaccess.expressions.ExpressionsPackage;

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
 * <!-- begin-model-doc -->
 * A query language (overlap with rules package?) based on the structural package (BO, BONodes, associations, attributes). The language is independent of the mapping to the persistence layer but can be mapped to efficient queries in the persistence layer for those BOs that have a declared persistence mapping. Look closely at FSI, its query and view builder and how they have structured their metadata.
 * 
 * Should this be a subset of the expression language?
 * Note the particular issues around *retrieval* (as opposed to just querying IDs) as mentioned by Maic Wintel. Modeling of aspects to retrieve by a query?
 * 
 * What about regular expressions?
 * 
 * TODO: Most queries by means of their projection (SELECT) clause will implicitly define a tuple type, and the value returned by the query is a multi-object of that tuple type. We need to think about what these types exactly are (currently we don't support tuple types). Are they classes that are implicitly defined by the query? Or does a class explicitly have to be defined whose associations then can assume the values of the individual columns? Can that class somehow be referenced otherwise? What happens when the result of a query is assigned to a variable that uses type inference? I would hope that the implicit result class of the query is used as the variable's type. But is there / should there also be explicit ways of referencing this type?
 * <!-- end-model-doc -->
 * @see dataaccess.query.QueryFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface QueryPackage extends EPackage {
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
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/query.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "dataaccess.query";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	QueryPackage eINSTANCE = dataaccess.query.impl.QueryPackageImpl.init();

	/**
     * The meta object id for the '{@link dataaccess.query.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.query.impl.SelectionImpl
     * @see dataaccess.query.impl.QueryPackageImpl#getSelection()
     * @generated
     */
	int SELECTION = 0;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__OWNED_TYPE_DEFINITION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__EXPRESSION_STATEMENT = ExpressionsPackage.OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__INIT_EXPRESSION_FOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__OBJECT_BASED_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__ARGUMENT_OF = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__LEFT_OF_EQUALS = ExpressionsPackage.OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__RIGHT_OF_EQUALS = ExpressionsPackage.OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__CONDITIONAL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__COLLECTION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__IN_ITERATOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__CONDITION_OF_OQL_QUERY = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__FROM_CLAUSE = ExpressionsPackage.OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__DIMENSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__TEMPLATE = ExpressionsPackage.OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SELECTION__ALL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__OBJECT = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__ITERATOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Selection Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION__SELECTION_EXPR = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Selection</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SELECTION_FEATURE_COUNT = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.query.impl.OqlQueryImpl <em>Oql Query</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.query.impl.OqlQueryImpl
     * @see dataaccess.query.impl.QueryPackageImpl#getOqlQuery()
     * @generated
     */
	int OQL_QUERY = 1;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__INIT_EXPRESSION_FOR = ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__OBJECT_BASED_EXPRESSION = ExpressionsPackage.EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__ARGUMENT_OF = ExpressionsPackage.EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__LEFT_OF_EQUALS = ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__RIGHT_OF_EQUALS = ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__CONDITIONAL = ExpressionsPackage.EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__COLLECTION_EXPRESSION = ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__IN_ITERATOR = ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__CONDITION_OF_OQL_QUERY = ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__FROM_CLAUSE = ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__DIMENSION = ExpressionsPackage.EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__TEMPLATE = ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OQL_QUERY__ALL = ExpressionsPackage.EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__CONDITION = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>From Clauses</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__FROM_CLAUSES = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Selected</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY__SELECTED = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Oql Query</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OQL_QUERY_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link dataaccess.query.impl.FromClauseImpl <em>From Clause</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.query.impl.FromClauseImpl
     * @see dataaccess.query.impl.QueryPackageImpl#getFromClause()
     * @generated
     */
	int FROM_CLAUSE = 2;

	/**
     * The feature id for the '<em><b>From Clause Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY = 0;

	/**
     * The feature id for the '<em><b>From Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FROM_CLAUSE__FROM_EXPRESSION = 1;

	/**
     * The feature id for the '<em><b>Alias</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FROM_CLAUSE__ALIAS = 2;

	/**
     * The number of structural features of the '<em>From Clause</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FROM_CLAUSE_FEATURE_COUNT = 3;


	/**
     * Returns the meta object for class '{@link dataaccess.query.Selection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Selection</em>'.
     * @see dataaccess.query.Selection
     * @generated
     */
	EClass getSelection();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.query.Selection#getIterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Iterator</em>'.
     * @see dataaccess.query.Selection#getIterator()
     * @see #getSelection()
     * @generated
     */
	EReference getSelection_Iterator();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.query.Selection#getSelectionExpr <em>Selection Expr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Selection Expr</em>'.
     * @see dataaccess.query.Selection#getSelectionExpr()
     * @see #getSelection()
     * @generated
     */
	EReference getSelection_SelectionExpr();

	/**
     * Returns the meta object for class '{@link dataaccess.query.OqlQuery <em>Oql Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Oql Query</em>'.
     * @see dataaccess.query.OqlQuery
     * @generated
     */
	EClass getOqlQuery();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.query.OqlQuery#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see dataaccess.query.OqlQuery#getCondition()
     * @see #getOqlQuery()
     * @generated
     */
	EReference getOqlQuery_Condition();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.query.OqlQuery#getFromClauses <em>From Clauses</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>From Clauses</em>'.
     * @see dataaccess.query.OqlQuery#getFromClauses()
     * @see #getOqlQuery()
     * @generated
     */
	EReference getOqlQuery_FromClauses();

	/**
     * Returns the meta object for the reference list '{@link dataaccess.query.OqlQuery#getSelected <em>Selected</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Selected</em>'.
     * @see dataaccess.query.OqlQuery#getSelected()
     * @see #getOqlQuery()
     * @generated
     */
	EReference getOqlQuery_Selected();

	/**
     * Returns the meta object for class '{@link dataaccess.query.FromClause <em>From Clause</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>From Clause</em>'.
     * @see dataaccess.query.FromClause
     * @generated
     */
	EClass getFromClause();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.query.FromClause#getFromClauseOfOqlQuery <em>From Clause Of Oql Query</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>From Clause Of Oql Query</em>'.
     * @see dataaccess.query.FromClause#getFromClauseOfOqlQuery()
     * @see #getFromClause()
     * @generated
     */
	EReference getFromClause_FromClauseOfOqlQuery();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.query.FromClause#getFromExpression <em>From Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>From Expression</em>'.
     * @see dataaccess.query.FromClause#getFromExpression()
     * @see #getFromClause()
     * @generated
     */
	EReference getFromClause_FromExpression();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.query.FromClause#getAlias <em>Alias</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Alias</em>'.
     * @see dataaccess.query.FromClause#getAlias()
     * @see #getFromClause()
     * @generated
     */
	EReference getFromClause_Alias();

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
	interface Literals {
		/**
         * The meta object literal for the '{@link dataaccess.query.impl.SelectionImpl <em>Selection</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.query.impl.SelectionImpl
         * @see dataaccess.query.impl.QueryPackageImpl#getSelection()
         * @generated
         */
		EClass SELECTION = eINSTANCE.getSelection();

		/**
         * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SELECTION__ITERATOR = eINSTANCE.getSelection_Iterator();

		/**
         * The meta object literal for the '<em><b>Selection Expr</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SELECTION__SELECTION_EXPR = eINSTANCE.getSelection_SelectionExpr();

		/**
         * The meta object literal for the '{@link dataaccess.query.impl.OqlQueryImpl <em>Oql Query</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.query.impl.OqlQueryImpl
         * @see dataaccess.query.impl.QueryPackageImpl#getOqlQuery()
         * @generated
         */
		EClass OQL_QUERY = eINSTANCE.getOqlQuery();

		/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OQL_QUERY__CONDITION = eINSTANCE.getOqlQuery_Condition();

		/**
         * The meta object literal for the '<em><b>From Clauses</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OQL_QUERY__FROM_CLAUSES = eINSTANCE.getOqlQuery_FromClauses();

		/**
         * The meta object literal for the '<em><b>Selected</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OQL_QUERY__SELECTED = eINSTANCE.getOqlQuery_Selected();

		/**
         * The meta object literal for the '{@link dataaccess.query.impl.FromClauseImpl <em>From Clause</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.query.impl.FromClauseImpl
         * @see dataaccess.query.impl.QueryPackageImpl#getFromClause()
         * @generated
         */
		EClass FROM_CLAUSE = eINSTANCE.getFromClause();

		/**
         * The meta object literal for the '<em><b>From Clause Of Oql Query</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FROM_CLAUSE__FROM_CLAUSE_OF_OQL_QUERY = eINSTANCE.getFromClause_FromClauseOfOqlQuery();

		/**
         * The meta object literal for the '<em><b>From Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FROM_CLAUSE__FROM_EXPRESSION = eINSTANCE.getFromClause_FromExpression();

		/**
         * The meta object literal for the '<em><b>Alias</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FROM_CLAUSE__ALIAS = eINSTANCE.getFromClause_Alias();

	}

} //QueryPackage
