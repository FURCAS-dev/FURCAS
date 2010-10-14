/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.analytics;

import data.classes.ClassesPackage;

import dataaccess.expressions.ExpressionsPackage;

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
 * <!-- begin-model-doc -->
 * This is the home for the definitions of what InfoObjects, InfoCubes, extractors, queries and views are.
 * <!-- end-model-doc -->
 * @see dataaccess.analytics.AnalyticsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface AnalyticsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "analytics";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///dataaccess/analytics.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "dataaccess.analytics";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	AnalyticsPackage eINSTANCE = dataaccess.analytics.impl.AnalyticsPackageImpl.init();

	/**
     * The meta object id for the '{@link dataaccess.analytics.impl.DimensionImpl <em>Dimension</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.analytics.impl.DimensionImpl
     * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getDimension()
     * @generated
     */
	int DIMENSION = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Cell Set</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION__CELL_SET = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Characteristic Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION__CHARACTERISTIC_FUNCTION = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Dimension</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.analytics.impl.CellSetImpl <em>Cell Set</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.analytics.impl.CellSetImpl
     * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getCellSet()
     * @generated
     */
	int CELL_SET = 1;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET__IMPLEMENTS_ = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>Function Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET__FUNCTION_SIGNATURE = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE;

	/**
     * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET__DIMENSIONS = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Value Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET__VALUE_FUNCTION = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Aggregation Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET__AGGREGATION_FUNCTION = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Facts Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET__FACTS_TYPE = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Cell Set</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CELL_SET_FEATURE_COUNT = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link dataaccess.analytics.impl.DimensionExpressionImpl <em>Dimension Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.analytics.impl.DimensionExpressionImpl
     * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getDimensionExpression()
     * @generated
     */
	int DIMENSION_EXPRESSION = 2;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__INIT_EXPRESSION_FOR = ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__OBJECT_BASED_EXPRESSION = ExpressionsPackage.EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__ARGUMENT_OF = ExpressionsPackage.EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__LEFT_OF_EQUALS = ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__RIGHT_OF_EQUALS = ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__CONDITIONAL = ExpressionsPackage.EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__COLLECTION_EXPRESSION = ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__IN_ITERATOR = ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__CONDITION_OF_OQL_QUERY = ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__FROM_CLAUSE = ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__DIMENSION = ExpressionsPackage.EXPRESSION__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__TEMPLATE = ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int DIMENSION_EXPRESSION__ALL = ExpressionsPackage.EXPRESSION__ALL;

	/**
     * The feature id for the '<em><b>Cell Set</b></em>' containment reference.
     * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
     * @generated
     * @ordered
     */
int DIMENSION_EXPRESSION__CELL_SET = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Dimension Parameter</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__DIMENSION_PARAMETER = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Facts</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION__FACTS = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Dimension Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link dataaccess.analytics.impl.GroupByImpl <em>Group By</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.analytics.impl.GroupByImpl
     * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getGroupBy()
     * @generated
     */
	int GROUP_BY = 3;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__OWNED_TYPE_DEFINITION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__EXPRESSION_STATEMENT = ExpressionsPackage.OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__INIT_EXPRESSION_FOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__OBJECT_BASED_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__ARGUMENT_OF = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__LEFT_OF_EQUALS = ExpressionsPackage.OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__RIGHT_OF_EQUALS = ExpressionsPackage.OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__CONDITIONAL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__COLLECTION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__IN_ITERATOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__CONDITION_OF_OQL_QUERY = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__FROM_CLAUSE = ExpressionsPackage.OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__DIMENSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__TEMPLATE = ExpressionsPackage.OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int GROUP_BY__ALL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__OBJECT = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__DIMENSIONS = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Fact</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__FACT = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Map Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__MAP_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Grouped Facts</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY__GROUPED_FACTS = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Group By</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GROUP_BY_FEATURE_COUNT = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link dataaccess.analytics.impl.DimensionDefinitionImpl <em>Dimension Definition</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.analytics.impl.DimensionDefinitionImpl
     * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getDimensionDefinition()
     * @generated
     */
	int DIMENSION_DEFINITION = 4;

	/**
     * The feature id for the '<em><b>Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_DEFINITION__GROUP_BY = 0;

	/**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_DEFINITION__EXPRESSION = 1;

	/**
     * The feature id for the '<em><b>Iterator</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_DEFINITION__ITERATOR = 2;

	/**
     * The number of structural features of the '<em>Dimension Definition</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int DIMENSION_DEFINITION_FEATURE_COUNT = 3;


	/**
     * Returns the meta object for class '{@link dataaccess.analytics.Dimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dimension</em>'.
     * @see dataaccess.analytics.Dimension
     * @generated
     */
	EClass getDimension();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.analytics.Dimension#getCellSet <em>Cell Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Cell Set</em>'.
     * @see dataaccess.analytics.Dimension#getCellSet()
     * @see #getDimension()
     * @generated
     */
	EReference getDimension_CellSet();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.Dimension#getCharacteristicFunction <em>Characteristic Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Characteristic Function</em>'.
     * @see dataaccess.analytics.Dimension#getCharacteristicFunction()
     * @see #getDimension()
     * @generated
     */
	EReference getDimension_CharacteristicFunction();

	/**
     * Returns the meta object for class '{@link dataaccess.analytics.CellSet <em>Cell Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cell Set</em>'.
     * @see dataaccess.analytics.CellSet
     * @generated
     */
	EClass getCellSet();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.analytics.CellSet#getDimensions <em>Dimensions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Dimensions</em>'.
     * @see dataaccess.analytics.CellSet#getDimensions()
     * @see #getCellSet()
     * @generated
     */
	EReference getCellSet_Dimensions();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.CellSet#getValueFunction <em>Value Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value Function</em>'.
     * @see dataaccess.analytics.CellSet#getValueFunction()
     * @see #getCellSet()
     * @generated
     */
	EReference getCellSet_ValueFunction();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.CellSet#getAggregationFunction <em>Aggregation Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Aggregation Function</em>'.
     * @see dataaccess.analytics.CellSet#getAggregationFunction()
     * @see #getCellSet()
     * @generated
     */
	EReference getCellSet_AggregationFunction();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.CellSet#getFactsType <em>Facts Type</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Facts Type</em>'.
     * @see dataaccess.analytics.CellSet#getFactsType()
     * @see #getCellSet()
     * @generated
     */
	EReference getCellSet_FactsType();

	/**
     * Returns the meta object for class '{@link dataaccess.analytics.DimensionExpression <em>Dimension Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dimension Expression</em>'.
     * @see dataaccess.analytics.DimensionExpression
     * @generated
     */
	EClass getDimensionExpression();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.DimensionExpression#getCellSet <em>Cell Set</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Cell Set</em>'.
     * @see dataaccess.analytics.DimensionExpression#getCellSet()
     * @see #getDimensionExpression()
     * @generated
     */
	EReference getDimensionExpression_CellSet();

	/**
     * Returns the meta object for the reference '{@link dataaccess.analytics.DimensionExpression#getDimensionParameter <em>Dimension Parameter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Dimension Parameter</em>'.
     * @see dataaccess.analytics.DimensionExpression#getDimensionParameter()
     * @see #getDimensionExpression()
     * @generated
     */
	EReference getDimensionExpression_DimensionParameter();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.DimensionExpression#getFacts <em>Facts</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Facts</em>'.
     * @see dataaccess.analytics.DimensionExpression#getFacts()
     * @see #getDimensionExpression()
     * @generated
     */
	EReference getDimensionExpression_Facts();

	/**
     * Returns the meta object for class '{@link dataaccess.analytics.GroupBy <em>Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Group By</em>'.
     * @see dataaccess.analytics.GroupBy
     * @generated
     */
	EClass getGroupBy();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.analytics.GroupBy#getDimensions <em>Dimensions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Dimensions</em>'.
     * @see dataaccess.analytics.GroupBy#getDimensions()
     * @see #getGroupBy()
     * @generated
     */
	EReference getGroupBy_Dimensions();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.GroupBy#getFact <em>Fact</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Fact</em>'.
     * @see dataaccess.analytics.GroupBy#getFact()
     * @see #getGroupBy()
     * @generated
     */
	EReference getGroupBy_Fact();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.GroupBy#getMapExpression <em>Map Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Map Expression</em>'.
     * @see dataaccess.analytics.GroupBy#getMapExpression()
     * @see #getGroupBy()
     * @generated
     */
	EReference getGroupBy_MapExpression();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.GroupBy#getGroupedFacts <em>Grouped Facts</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Grouped Facts</em>'.
     * @see dataaccess.analytics.GroupBy#getGroupedFacts()
     * @see #getGroupBy()
     * @generated
     */
	EReference getGroupBy_GroupedFacts();

	/**
     * Returns the meta object for class '{@link dataaccess.analytics.DimensionDefinition <em>Dimension Definition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dimension Definition</em>'.
     * @see dataaccess.analytics.DimensionDefinition
     * @generated
     */
	EClass getDimensionDefinition();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.analytics.DimensionDefinition#getGroupBy <em>Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Group By</em>'.
     * @see dataaccess.analytics.DimensionDefinition#getGroupBy()
     * @see #getDimensionDefinition()
     * @generated
     */
	EReference getDimensionDefinition_GroupBy();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.DimensionDefinition#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see dataaccess.analytics.DimensionDefinition#getExpression()
     * @see #getDimensionDefinition()
     * @generated
     */
	EReference getDimensionDefinition_Expression();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.analytics.DimensionDefinition#getIterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Iterator</em>'.
     * @see dataaccess.analytics.DimensionDefinition#getIterator()
     * @see #getDimensionDefinition()
     * @generated
     */
	EReference getDimensionDefinition_Iterator();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	AnalyticsFactory getAnalyticsFactory();

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
         * The meta object literal for the '{@link dataaccess.analytics.impl.DimensionImpl <em>Dimension</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.analytics.impl.DimensionImpl
         * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getDimension()
         * @generated
         */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
         * The meta object literal for the '<em><b>Cell Set</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION__CELL_SET = eINSTANCE.getDimension_CellSet();

		/**
         * The meta object literal for the '<em><b>Characteristic Function</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION__CHARACTERISTIC_FUNCTION = eINSTANCE.getDimension_CharacteristicFunction();

		/**
         * The meta object literal for the '{@link dataaccess.analytics.impl.CellSetImpl <em>Cell Set</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.analytics.impl.CellSetImpl
         * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getCellSet()
         * @generated
         */
		EClass CELL_SET = eINSTANCE.getCellSet();

		/**
         * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CELL_SET__DIMENSIONS = eINSTANCE.getCellSet_Dimensions();

		/**
         * The meta object literal for the '<em><b>Value Function</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CELL_SET__VALUE_FUNCTION = eINSTANCE.getCellSet_ValueFunction();

		/**
         * The meta object literal for the '<em><b>Aggregation Function</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CELL_SET__AGGREGATION_FUNCTION = eINSTANCE.getCellSet_AggregationFunction();

		/**
         * The meta object literal for the '<em><b>Facts Type</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CELL_SET__FACTS_TYPE = eINSTANCE.getCellSet_FactsType();

		/**
         * The meta object literal for the '{@link dataaccess.analytics.impl.DimensionExpressionImpl <em>Dimension Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.analytics.impl.DimensionExpressionImpl
         * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getDimensionExpression()
         * @generated
         */
		EClass DIMENSION_EXPRESSION = eINSTANCE.getDimensionExpression();

		/**
         * The meta object literal for the '<em><b>Cell Set</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION_EXPRESSION__CELL_SET = eINSTANCE.getDimensionExpression_CellSet();

		/**
         * The meta object literal for the '<em><b>Dimension Parameter</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION_EXPRESSION__DIMENSION_PARAMETER = eINSTANCE.getDimensionExpression_DimensionParameter();

		/**
         * The meta object literal for the '<em><b>Facts</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION_EXPRESSION__FACTS = eINSTANCE.getDimensionExpression_Facts();

		/**
         * The meta object literal for the '{@link dataaccess.analytics.impl.GroupByImpl <em>Group By</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.analytics.impl.GroupByImpl
         * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getGroupBy()
         * @generated
         */
		EClass GROUP_BY = eINSTANCE.getGroupBy();

		/**
         * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GROUP_BY__DIMENSIONS = eINSTANCE.getGroupBy_Dimensions();

		/**
         * The meta object literal for the '<em><b>Fact</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GROUP_BY__FACT = eINSTANCE.getGroupBy_Fact();

		/**
         * The meta object literal for the '<em><b>Map Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GROUP_BY__MAP_EXPRESSION = eINSTANCE.getGroupBy_MapExpression();

		/**
         * The meta object literal for the '<em><b>Grouped Facts</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GROUP_BY__GROUPED_FACTS = eINSTANCE.getGroupBy_GroupedFacts();

		/**
         * The meta object literal for the '{@link dataaccess.analytics.impl.DimensionDefinitionImpl <em>Dimension Definition</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.analytics.impl.DimensionDefinitionImpl
         * @see dataaccess.analytics.impl.AnalyticsPackageImpl#getDimensionDefinition()
         * @generated
         */
		EClass DIMENSION_DEFINITION = eINSTANCE.getDimensionDefinition();

		/**
         * The meta object literal for the '<em><b>Group By</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION_DEFINITION__GROUP_BY = eINSTANCE.getDimensionDefinition_GroupBy();

		/**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION_DEFINITION__EXPRESSION = eINSTANCE.getDimensionDefinition_Expression();

		/**
         * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference DIMENSION_DEFINITION__ITERATOR = eINSTANCE.getDimensionDefinition_Iterator();

	}

} //AnalyticsPackage
