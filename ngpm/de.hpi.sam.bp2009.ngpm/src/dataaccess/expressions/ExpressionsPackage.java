/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions;

import data.classes.ClassesPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * Specifies an expression language that allows its users for form expressions over objects and values, producing other objects and values.
 * <!-- end-model-doc -->
 * @see dataaccess.expressions.ExpressionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "expressions";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///dataaccess/expressions.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "dataaccess.expressions";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ExpressionsPackage eINSTANCE = dataaccess.expressions.impl.ExpressionsPackageImpl.init();

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getExpression()
     * @generated
     */
	int EXPRESSION = 0;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__OWNED_TYPE_DEFINITION = ClassesPackage.TYPED_ELEMENT__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__EXPRESSION_STATEMENT = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__INIT_EXPRESSION_FOR = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 1;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__ACTUAL_OBJECT_PARAMETER = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 2;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__OBJECT_BASED_EXPRESSION = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 3;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__ARGUMENT_OF = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 4;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 5;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__LEFT_OF_EQUALS = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 6;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 7;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__RIGHT_OF_EQUALS = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 8;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__CONDITIONAL = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 9;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__COLLECTION_EXPRESSION = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 10;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__IN_ITERATOR = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 11;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__CONDITION_OF_OQL_QUERY = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 12;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__FROM_CLAUSE = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 13;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 14;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 15;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__DIMENSION = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 16;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 17;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION__TEMPLATE = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 18;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION__ALL = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 19;

  /**
     * The number of structural features of the '<em>Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_FEATURE_COUNT = ClassesPackage.TYPED_ELEMENT_FEATURE_COUNT + 20;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.VariableExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getVariableExpression()
     * @generated
     */
	int VARIABLE_EXPRESSION = 1;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE_EXPRESSION__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Variable</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION__VARIABLE = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Variable Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ObjectBasedExpressionImpl <em>Object Based Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ObjectBasedExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getObjectBasedExpression()
     * @generated
     */
	int OBJECT_BASED_EXPRESSION = 3;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_BASED_EXPRESSION__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION__OBJECT = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Object Based Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_BASED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.MethodCallExpressionImpl <em>Method Call Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.MethodCallExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getMethodCallExpression()
     * @generated
     */
	int METHOD_CALL_EXPRESSION = 2;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int METHOD_CALL_EXPRESSION__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__PARAMETERS = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Asynchronous</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__ASYNCHRONOUS = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Method Signature</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__METHOD_SIGNATURE = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Creation Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION__CREATION_EXPRESSION = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Method Call Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int METHOD_CALL_EXPRESSION_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 4;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ObjectCreationExpressionImpl <em>Object Creation Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ObjectCreationExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getObjectCreationExpression()
     * @generated
     */
	int OBJECT_CREATION_EXPRESSION = 4;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_CREATION_EXPRESSION__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Class To Instantiate</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Initializers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION__INITIALIZERS = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Object Creation Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_CREATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.SignatureCallExpressionImpl <em>Signature Call Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.SignatureCallExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getSignatureCallExpression()
     * @generated
     */
	int SIGNATURE_CALL_EXPRESSION = 10;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int SIGNATURE_CALL_EXPRESSION__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION__PARAMETERS = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Signature Call Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIGNATURE_CALL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.FunctionCallExpressionImpl <em>Function Call Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.FunctionCallExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getFunctionCallExpression()
     * @generated
     */
	int FUNCTION_CALL_EXPRESSION = 5;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__OWNED_TYPE_DEFINITION = SIGNATURE_CALL_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__EXPRESSION_STATEMENT = SIGNATURE_CALL_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__INIT_EXPRESSION_FOR = SIGNATURE_CALL_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__ACTUAL_OBJECT_PARAMETER = SIGNATURE_CALL_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__OBJECT_BASED_EXPRESSION = SIGNATURE_CALL_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__ARGUMENT_OF = SIGNATURE_CALL_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = SIGNATURE_CALL_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__LEFT_OF_EQUALS = SIGNATURE_CALL_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = SIGNATURE_CALL_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__RIGHT_OF_EQUALS = SIGNATURE_CALL_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__CONDITIONAL = SIGNATURE_CALL_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__COLLECTION_EXPRESSION = SIGNATURE_CALL_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__IN_ITERATOR = SIGNATURE_CALL_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__CONDITION_OF_OQL_QUERY = SIGNATURE_CALL_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__FROM_CLAUSE = SIGNATURE_CALL_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = SIGNATURE_CALL_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = SIGNATURE_CALL_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__DIMENSION = SIGNATURE_CALL_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = SIGNATURE_CALL_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__TEMPLATE = SIGNATURE_CALL_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int FUNCTION_CALL_EXPRESSION__ALL = SIGNATURE_CALL_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__PARAMETERS = SIGNATURE_CALL_EXPRESSION__PARAMETERS;

	/**
     * The feature id for the '<em><b>Called Block</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION__CALLED_BLOCK = SIGNATURE_CALL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Function Call Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_CALL_EXPRESSION_FEATURE_COUNT = SIGNATURE_CALL_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.WithArgumentImpl <em>With Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.WithArgumentImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getWithArgument()
     * @generated
     */
	int WITH_ARGUMENT = 6;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WITH_ARGUMENT__ARGUMENT = 0;

	/**
     * The number of structural features of the '<em>With Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WITH_ARGUMENT_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ThisImpl <em>This</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ThisImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getThis()
     * @generated
     */
	int THIS = 7;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int THIS__ALL = EXPRESSION__ALL;

  /**
     * The number of structural features of the '<em>This</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int THIS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.EqualsImpl <em>Equals</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.EqualsImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getEquals()
     * @generated
     */
	int EQUALS = 8;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EQUALS__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Left</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__LEFT = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Right</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Equals</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EQUALS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.AssociationEndNavigationExpressionImpl <em>Association End Navigation Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.AssociationEndNavigationExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getAssociationEndNavigationExpression()
     * @generated
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION = 9;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int ASSOCIATION_END_NAVIGATION_EXPRESSION__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The feature id for the '<em><b>To End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Association End Navigation Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSOCIATION_END_NAVIGATION_EXPRESSION_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ObjectCountImpl <em>Object Count</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ObjectCountImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getObjectCount()
     * @generated
     */
	int OBJECT_COUNT = 11;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int OBJECT_COUNT__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The number of structural features of the '<em>Object Count</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_COUNT_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ReplaceImpl <em>Replace</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ReplaceImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getReplace()
     * @generated
     */
	int REPLACE = 12;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int REPLACE__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The feature id for the '<em><b>Steps</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__STEPS = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>With</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE__WITH = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Replace</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REPLACE_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.NavigationStepImpl <em>Navigation Step</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.NavigationStepImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getNavigationStep()
     * @generated
     */
	int NAVIGATION_STEP = 13;

	/**
     * The feature id for the '<em><b>Replace</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_STEP__REPLACE = 0;

	/**
     * The feature id for the '<em><b>To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_STEP__TO = 1;

	/**
     * The feature id for the '<em><b>Filter Function</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_STEP__FILTER_FUNCTION = 2;

	/**
     * The number of structural features of the '<em>Navigation Step</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAVIGATION_STEP_FEATURE_COUNT = 3;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.HeadImpl <em>Head</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.HeadImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getHead()
     * @generated
     */
	int HEAD = 14;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int HEAD__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The number of structural features of the '<em>Head</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int HEAD_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.TailImpl <em>Tail</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.TailImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getTail()
     * @generated
     */
	int TAIL = 15;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TAIL__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The number of structural features of the '<em>Tail</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TAIL_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.AsListImpl <em>As List</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.AsListImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getAsList()
     * @generated
     */
	int AS_LIST = 16;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__OWNED_TYPE_DEFINITION = OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__EXPRESSION_STATEMENT = OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__INIT_EXPRESSION_FOR = OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__ACTUAL_OBJECT_PARAMETER = OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__OBJECT_BASED_EXPRESSION = OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__ARGUMENT_OF = OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__BLOCK_OF_FUNCTION_CALL_EXPRESSION = OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__LEFT_OF_EQUALS = OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__RIGHT_OF_EQUALS = OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__CONDITIONAL = OBJECT_BASED_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__COLLECTION_EXPRESSION = OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__IN_ITERATOR = OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__CONDITION_OF_OQL_QUERY = OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__FROM_CLAUSE = OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__CELL_SET_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__FACTS_OF_DIMENSION_EXPRESSION = OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__DIMENSION = OBJECT_BASED_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__MAP_EXPRESSION_OF_GROUP_BY = OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__TEMPLATE = OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int AS_LIST__ALL = OBJECT_BASED_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST__OBJECT = OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The number of structural features of the '<em>As List</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int AS_LIST_FEATURE_COUNT = OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ConditionalImpl <em>Conditional</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ConditionalImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getConditional()
     * @generated
     */
	int CONDITIONAL = 17;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL__CONDITION = 0;

	/**
     * The number of structural features of the '<em>Conditional</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_FEATURE_COUNT = 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ConditionalExpressionImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getConditionalExpression()
     * @generated
     */
	int CONDITIONAL_EXPRESSION = 21;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONDITIONAL_EXPRESSION__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Conditional Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.TernaryImpl <em>Ternary</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.TernaryImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getTernary()
     * @generated
     */
	int TERNARY = 18;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__OWNED_TYPE_DEFINITION = CONDITIONAL_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__EXPRESSION_STATEMENT = CONDITIONAL_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__INIT_EXPRESSION_FOR = CONDITIONAL_EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__ACTUAL_OBJECT_PARAMETER = CONDITIONAL_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__OBJECT_BASED_EXPRESSION = CONDITIONAL_EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__ARGUMENT_OF = CONDITIONAL_EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__BLOCK_OF_FUNCTION_CALL_EXPRESSION = CONDITIONAL_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__LEFT_OF_EQUALS = CONDITIONAL_EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = CONDITIONAL_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__RIGHT_OF_EQUALS = CONDITIONAL_EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__CONDITIONAL = CONDITIONAL_EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__COLLECTION_EXPRESSION = CONDITIONAL_EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__IN_ITERATOR = CONDITIONAL_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__CONDITION_OF_OQL_QUERY = CONDITIONAL_EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__FROM_CLAUSE = CONDITIONAL_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__CELL_SET_OF_DIMENSION_EXPRESSION = CONDITIONAL_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__FACTS_OF_DIMENSION_EXPRESSION = CONDITIONAL_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__DIMENSION = CONDITIONAL_EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__MAP_EXPRESSION_OF_GROUP_BY = CONDITIONAL_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__TEMPLATE = CONDITIONAL_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int TERNARY__ALL = CONDITIONAL_EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__CONDITION = CONDITIONAL_EXPRESSION__CONDITION;

	/**
     * The feature id for the '<em><b>False Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__FALSE_EXPR = CONDITIONAL_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>True Expr</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY__TRUE_EXPR = CONDITIONAL_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Ternary</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TERNARY_FEATURE_COUNT = CONDITIONAL_EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ContentEqualsImpl <em>Content Equals</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ContentEqualsImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getContentEquals()
     * @generated
     */
	int CONTENT_EQUALS = 19;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__OWNED_TYPE_DEFINITION = EQUALS__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__EXPRESSION_STATEMENT = EQUALS__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__INIT_EXPRESSION_FOR = EQUALS__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__ACTUAL_OBJECT_PARAMETER = EQUALS__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__OBJECT_BASED_EXPRESSION = EQUALS__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__ARGUMENT_OF = EQUALS__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EQUALS__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__LEFT_OF_EQUALS = EQUALS__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EQUALS__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__RIGHT_OF_EQUALS = EQUALS__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__CONDITIONAL = EQUALS__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__COLLECTION_EXPRESSION = EQUALS__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__IN_ITERATOR = EQUALS__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__CONDITION_OF_OQL_QUERY = EQUALS__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__FROM_CLAUSE = EQUALS__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__CELL_SET_OF_DIMENSION_EXPRESSION = EQUALS__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__FACTS_OF_DIMENSION_EXPRESSION = EQUALS__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__DIMENSION = EQUALS__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__MAP_EXPRESSION_OF_GROUP_BY = EQUALS__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__TEMPLATE = EQUALS__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONTENT_EQUALS__ALL = EQUALS__ALL;

  /**
     * The feature id for the '<em><b>Left</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__LEFT = EQUALS__LEFT;

	/**
     * The feature id for the '<em><b>Right</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS__RIGHT = EQUALS__RIGHT;

	/**
     * The number of structural features of the '<em>Content Equals</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONTENT_EQUALS_FEATURE_COUNT = EQUALS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.ExpressionWithArgumentImpl <em>Expression With Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.ExpressionWithArgumentImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getExpressionWithArgument()
     * @generated
     */
	int EXPRESSION_WITH_ARGUMENT = 20;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__OWNED_TYPE_DEFINITION = EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__EXPRESSION_STATEMENT = EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__INIT_EXPRESSION_FOR = EXPRESSION__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__ACTUAL_OBJECT_PARAMETER = EXPRESSION__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__OBJECT_BASED_EXPRESSION = EXPRESSION__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__ARGUMENT_OF = EXPRESSION__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__LEFT_OF_EQUALS = EXPRESSION__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__RIGHT_OF_EQUALS = EXPRESSION__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__CONDITIONAL = EXPRESSION__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__COLLECTION_EXPRESSION = EXPRESSION__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__IN_ITERATOR = EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__CONDITION_OF_OQL_QUERY = EXPRESSION__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__FROM_CLAUSE = EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__DIMENSION = EXPRESSION__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__TEMPLATE = EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int EXPRESSION_WITH_ARGUMENT__ALL = EXPRESSION__ALL;

  /**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT__ARGUMENT = EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Expression With Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.impl.MapImpl <em>Map</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.impl.MapImpl
     * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getMap()
     * @generated
     */
	int MAP = 22;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__OWNED_TYPE_DEFINITION = EXPRESSION_WITH_ARGUMENT__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__EXPRESSION_STATEMENT = EXPRESSION_WITH_ARGUMENT__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__INIT_EXPRESSION_FOR = EXPRESSION_WITH_ARGUMENT__INIT_EXPRESSION_FOR;

  /**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__ACTUAL_OBJECT_PARAMETER = EXPRESSION_WITH_ARGUMENT__ACTUAL_OBJECT_PARAMETER;

  /**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__OBJECT_BASED_EXPRESSION = EXPRESSION_WITH_ARGUMENT__OBJECT_BASED_EXPRESSION;

		/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__ARGUMENT_OF = EXPRESSION_WITH_ARGUMENT__ARGUMENT_OF;

  /**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__BLOCK_OF_FUNCTION_CALL_EXPRESSION = EXPRESSION_WITH_ARGUMENT__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

		/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__LEFT_OF_EQUALS = EXPRESSION_WITH_ARGUMENT__LEFT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = EXPRESSION_WITH_ARGUMENT__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

		/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__RIGHT_OF_EQUALS = EXPRESSION_WITH_ARGUMENT__RIGHT_OF_EQUALS;

  /**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__CONDITIONAL = EXPRESSION_WITH_ARGUMENT__CONDITIONAL;

  /**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__COLLECTION_EXPRESSION = EXPRESSION_WITH_ARGUMENT__COLLECTION_EXPRESSION;

  /**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__IN_ITERATOR = EXPRESSION_WITH_ARGUMENT__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__CONDITION_OF_OQL_QUERY = EXPRESSION_WITH_ARGUMENT__CONDITION_OF_OQL_QUERY;

  /**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__FROM_CLAUSE = EXPRESSION_WITH_ARGUMENT__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__CELL_SET_OF_DIMENSION_EXPRESSION = EXPRESSION_WITH_ARGUMENT__CELL_SET_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__FACTS_OF_DIMENSION_EXPRESSION = EXPRESSION_WITH_ARGUMENT__FACTS_OF_DIMENSION_EXPRESSION;

		/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__DIMENSION = EXPRESSION_WITH_ARGUMENT__DIMENSION;

		/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__MAP_EXPRESSION_OF_GROUP_BY = EXPRESSION_WITH_ARGUMENT__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__TEMPLATE = EXPRESSION_WITH_ARGUMENT__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int MAP__ALL = EXPRESSION_WITH_ARGUMENT__ALL;

  /**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__ARGUMENT = EXPRESSION_WITH_ARGUMENT__ARGUMENT;

	/**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP__OBJECT = EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Map</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int MAP_FEATURE_COUNT = EXPRESSION_WITH_ARGUMENT_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Expression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression</em>'.
     * @see dataaccess.expressions.Expression
     * @generated
     */
	EClass getExpression();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getExpressionStatement <em>Expression Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Expression Statement</em>'.
     * @see dataaccess.expressions.Expression#getExpressionStatement()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_ExpressionStatement();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getInitExpressionFor <em>Init Expression For</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Init Expression For</em>'.
     * @see dataaccess.expressions.Expression#getInitExpressionFor()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_InitExpressionFor();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getActualObjectParameter <em>Actual Object Parameter</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Actual Object Parameter</em>'.
     * @see dataaccess.expressions.Expression#getActualObjectParameter()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_ActualObjectParameter();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getObjectBasedExpression <em>Object Based Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Object Based Expression</em>'.
     * @see dataaccess.expressions.Expression#getObjectBasedExpression()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_ObjectBasedExpression();

		/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getArgumentOf <em>Argument Of</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Argument Of</em>'.
     * @see dataaccess.expressions.Expression#getArgumentOf()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_ArgumentOf();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getBlockOfFunctionCallExpression <em>Block Of Function Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Block Of Function Call Expression</em>'.
     * @see dataaccess.expressions.Expression#getBlockOfFunctionCallExpression()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_BlockOfFunctionCallExpression();

		/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getLeftOfEquals <em>Left Of Equals</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Left Of Equals</em>'.
     * @see dataaccess.expressions.Expression#getLeftOfEquals()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_LeftOfEquals();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getUsedAsArgumentInSignatureCall <em>Used As Argument In Signature Call</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Used As Argument In Signature Call</em>'.
     * @see dataaccess.expressions.Expression#getUsedAsArgumentInSignatureCall()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_UsedAsArgumentInSignatureCall();

		/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getRightOfEquals <em>Right Of Equals</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Right Of Equals</em>'.
     * @see dataaccess.expressions.Expression#getRightOfEquals()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_RightOfEquals();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getConditional <em>Conditional</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Conditional</em>'.
     * @see dataaccess.expressions.Expression#getConditional()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_Conditional();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getCollectionExpression <em>Collection Expression</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Collection Expression</em>'.
     * @see dataaccess.expressions.Expression#getCollectionExpression()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_CollectionExpression();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getInIterator <em>In Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>In Iterator</em>'.
     * @see dataaccess.expressions.Expression#getInIterator()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_InIterator();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getConditionOfOqlQuery <em>Condition Of Oql Query</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Condition Of Oql Query</em>'.
     * @see dataaccess.expressions.Expression#getConditionOfOqlQuery()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_ConditionOfOqlQuery();

  /**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getFromClause <em>From Clause</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>From Clause</em>'.
     * @see dataaccess.expressions.Expression#getFromClause()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_FromClause();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getCellSetOfDimensionExpression <em>Cell Set Of Dimension Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Cell Set Of Dimension Expression</em>'.
     * @see dataaccess.expressions.Expression#getCellSetOfDimensionExpression()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_CellSetOfDimensionExpression();

		/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getFactsOfDimensionExpression <em>Facts Of Dimension Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Facts Of Dimension Expression</em>'.
     * @see dataaccess.expressions.Expression#getFactsOfDimensionExpression()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_FactsOfDimensionExpression();

		/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Dimension</em>'.
     * @see dataaccess.expressions.Expression#getDimension()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_Dimension();

		/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getMapExpressionOfGroupBy <em>Map Expression Of Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Map Expression Of Group By</em>'.
     * @see dataaccess.expressions.Expression#getMapExpressionOfGroupBy()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_MapExpressionOfGroupBy();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getTemplate <em>Template</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Template</em>'.
     * @see dataaccess.expressions.Expression#getTemplate()
     * @see #getExpression()
     * @generated
     */
	EReference getExpression_Template();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.Expression#getAll <em>All</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>All</em>'.
     * @see dataaccess.expressions.Expression#getAll()
     * @see #getExpression()
     * @generated
     */
  EReference getExpression_All();

  /**
     * Returns the meta object for class '{@link dataaccess.expressions.VariableExpression <em>Variable Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable Expression</em>'.
     * @see dataaccess.expressions.VariableExpression
     * @generated
     */
	EClass getVariableExpression();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.VariableExpression#getVariable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Variable</em>'.
     * @see dataaccess.expressions.VariableExpression#getVariable()
     * @see #getVariableExpression()
     * @generated
     */
	EReference getVariableExpression_Variable();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.MethodCallExpression <em>Method Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Method Call Expression</em>'.
     * @see dataaccess.expressions.MethodCallExpression
     * @generated
     */
	EClass getMethodCallExpression();

	/**
     * Returns the meta object for the attribute '{@link dataaccess.expressions.MethodCallExpression#isAsynchronous <em>Asynchronous</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Asynchronous</em>'.
     * @see dataaccess.expressions.MethodCallExpression#isAsynchronous()
     * @see #getMethodCallExpression()
     * @generated
     */
	EAttribute getMethodCallExpression_Asynchronous();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.MethodCallExpression#getMethodSignature <em>Method Signature</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Method Signature</em>'.
     * @see dataaccess.expressions.MethodCallExpression#getMethodSignature()
     * @see #getMethodCallExpression()
     * @generated
     */
	EReference getMethodCallExpression_MethodSignature();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.MethodCallExpression#getCreationExpression <em>Creation Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Creation Expression</em>'.
     * @see dataaccess.expressions.MethodCallExpression#getCreationExpression()
     * @see #getMethodCallExpression()
     * @generated
     */
	EReference getMethodCallExpression_CreationExpression();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.ObjectBasedExpression <em>Object Based Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object Based Expression</em>'.
     * @see dataaccess.expressions.ObjectBasedExpression
     * @generated
     */
	EClass getObjectBasedExpression();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.ObjectBasedExpression#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Object</em>'.
     * @see dataaccess.expressions.ObjectBasedExpression#getObject()
     * @see #getObjectBasedExpression()
     * @generated
     */
	EReference getObjectBasedExpression_Object();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.ObjectCreationExpression <em>Object Creation Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object Creation Expression</em>'.
     * @see dataaccess.expressions.ObjectCreationExpression
     * @generated
     */
	EClass getObjectCreationExpression();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.ObjectCreationExpression#getClassToInstantiate <em>Class To Instantiate</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Class To Instantiate</em>'.
     * @see dataaccess.expressions.ObjectCreationExpression#getClassToInstantiate()
     * @see #getObjectCreationExpression()
     * @generated
     */
	EReference getObjectCreationExpression_ClassToInstantiate();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.expressions.ObjectCreationExpression#getInitializers <em>Initializers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Initializers</em>'.
     * @see dataaccess.expressions.ObjectCreationExpression#getInitializers()
     * @see #getObjectCreationExpression()
     * @generated
     */
	EReference getObjectCreationExpression_Initializers();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.FunctionCallExpression <em>Function Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function Call Expression</em>'.
     * @see dataaccess.expressions.FunctionCallExpression
     * @generated
     */
	EClass getFunctionCallExpression();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.FunctionCallExpression#getCalledBlock <em>Called Block</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Called Block</em>'.
     * @see dataaccess.expressions.FunctionCallExpression#getCalledBlock()
     * @see #getFunctionCallExpression()
     * @generated
     */
	EReference getFunctionCallExpression_CalledBlock();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.WithArgument <em>With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>With Argument</em>'.
     * @see dataaccess.expressions.WithArgument
     * @generated
     */
	EClass getWithArgument();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.WithArgument#getArgument <em>Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Argument</em>'.
     * @see dataaccess.expressions.WithArgument#getArgument()
     * @see #getWithArgument()
     * @generated
     */
	EReference getWithArgument_Argument();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.This <em>This</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>This</em>'.
     * @see dataaccess.expressions.This
     * @generated
     */
	EClass getThis();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Equals <em>Equals</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Equals</em>'.
     * @see dataaccess.expressions.Equals
     * @generated
     */
	EClass getEquals();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.Equals#getLeft <em>Left</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Left</em>'.
     * @see dataaccess.expressions.Equals#getLeft()
     * @see #getEquals()
     * @generated
     */
	EReference getEquals_Left();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.Equals#getRight <em>Right</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Right</em>'.
     * @see dataaccess.expressions.Equals#getRight()
     * @see #getEquals()
     * @generated
     */
	EReference getEquals_Right();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.AssociationEndNavigationExpression <em>Association End Navigation Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Association End Navigation Expression</em>'.
     * @see dataaccess.expressions.AssociationEndNavigationExpression
     * @generated
     */
	EClass getAssociationEndNavigationExpression();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.AssociationEndNavigationExpression#getToEnd <em>To End</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To End</em>'.
     * @see dataaccess.expressions.AssociationEndNavigationExpression#getToEnd()
     * @see #getAssociationEndNavigationExpression()
     * @generated
     */
	EReference getAssociationEndNavigationExpression_ToEnd();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.SignatureCallExpression <em>Signature Call Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signature Call Expression</em>'.
     * @see dataaccess.expressions.SignatureCallExpression
     * @generated
     */
	EClass getSignatureCallExpression();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.expressions.SignatureCallExpression#getParameters <em>Parameters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Parameters</em>'.
     * @see dataaccess.expressions.SignatureCallExpression#getParameters()
     * @see #getSignatureCallExpression()
     * @generated
     */
	EReference getSignatureCallExpression_Parameters();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.ObjectCount <em>Object Count</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object Count</em>'.
     * @see dataaccess.expressions.ObjectCount
     * @generated
     */
	EClass getObjectCount();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Replace <em>Replace</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Replace</em>'.
     * @see dataaccess.expressions.Replace
     * @generated
     */
	EClass getReplace();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.expressions.Replace#getSteps <em>Steps</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Steps</em>'.
     * @see dataaccess.expressions.Replace#getSteps()
     * @see #getReplace()
     * @generated
     */
	EReference getReplace_Steps();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.Replace#getWith <em>With</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>With</em>'.
     * @see dataaccess.expressions.Replace#getWith()
     * @see #getReplace()
     * @generated
     */
	EReference getReplace_With();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.NavigationStep <em>Navigation Step</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Navigation Step</em>'.
     * @see dataaccess.expressions.NavigationStep
     * @generated
     */
	EClass getNavigationStep();

	/**
     * Returns the meta object for the container reference '{@link dataaccess.expressions.NavigationStep#getReplace <em>Replace</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Replace</em>'.
     * @see dataaccess.expressions.NavigationStep#getReplace()
     * @see #getNavigationStep()
     * @generated
     */
	EReference getNavigationStep_Replace();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.NavigationStep#getTo <em>To</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To</em>'.
     * @see dataaccess.expressions.NavigationStep#getTo()
     * @see #getNavigationStep()
     * @generated
     */
	EReference getNavigationStep_To();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.NavigationStep#getFilterFunction <em>Filter Function</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Filter Function</em>'.
     * @see dataaccess.expressions.NavigationStep#getFilterFunction()
     * @see #getNavigationStep()
     * @generated
     */
	EReference getNavigationStep_FilterFunction();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Head <em>Head</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Head</em>'.
     * @see dataaccess.expressions.Head
     * @generated
     */
	EClass getHead();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Tail <em>Tail</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Tail</em>'.
     * @see dataaccess.expressions.Tail
     * @generated
     */
	EClass getTail();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.AsList <em>As List</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>As List</em>'.
     * @see dataaccess.expressions.AsList
     * @generated
     */
	EClass getAsList();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Conditional <em>Conditional</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conditional</em>'.
     * @see dataaccess.expressions.Conditional
     * @generated
     */
	EClass getConditional();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.Conditional#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Condition</em>'.
     * @see dataaccess.expressions.Conditional#getCondition()
     * @see #getConditional()
     * @generated
     */
	EReference getConditional_Condition();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Ternary <em>Ternary</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ternary</em>'.
     * @see dataaccess.expressions.Ternary
     * @generated
     */
	EClass getTernary();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.Ternary#getFalseExpr <em>False Expr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>False Expr</em>'.
     * @see dataaccess.expressions.Ternary#getFalseExpr()
     * @see #getTernary()
     * @generated
     */
	EReference getTernary_FalseExpr();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.Ternary#getTrueExpr <em>True Expr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>True Expr</em>'.
     * @see dataaccess.expressions.Ternary#getTrueExpr()
     * @see #getTernary()
     * @generated
     */
	EReference getTernary_TrueExpr();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.ContentEquals <em>Content Equals</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Content Equals</em>'.
     * @see dataaccess.expressions.ContentEquals
     * @generated
     */
	EClass getContentEquals();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.ExpressionWithArgument <em>Expression With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression With Argument</em>'.
     * @see dataaccess.expressions.ExpressionWithArgument
     * @generated
     */
	EClass getExpressionWithArgument();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.ConditionalExpression <em>Conditional Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conditional Expression</em>'.
     * @see dataaccess.expressions.ConditionalExpression
     * @generated
     */
	EClass getConditionalExpression();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.Map <em>Map</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Map</em>'.
     * @see dataaccess.expressions.Map
     * @generated
     */
	EClass getMap();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ExpressionsFactory getExpressionsFactory();

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
         * The meta object literal for the '{@link dataaccess.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getExpression()
         * @generated
         */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
         * The meta object literal for the '<em><b>Expression Statement</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__EXPRESSION_STATEMENT = eINSTANCE.getExpression_ExpressionStatement();

		/**
         * The meta object literal for the '<em><b>Init Expression For</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__INIT_EXPRESSION_FOR = eINSTANCE.getExpression_InitExpressionFor();

    /**
         * The meta object literal for the '<em><b>Actual Object Parameter</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__ACTUAL_OBJECT_PARAMETER = eINSTANCE.getExpression_ActualObjectParameter();

    /**
         * The meta object literal for the '<em><b>Object Based Expression</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__OBJECT_BASED_EXPRESSION = eINSTANCE.getExpression_ObjectBasedExpression();

				/**
         * The meta object literal for the '<em><b>Argument Of</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__ARGUMENT_OF = eINSTANCE.getExpression_ArgumentOf();

    /**
         * The meta object literal for the '<em><b>Block Of Function Call Expression</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION = eINSTANCE.getExpression_BlockOfFunctionCallExpression();

				/**
         * The meta object literal for the '<em><b>Left Of Equals</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__LEFT_OF_EQUALS = eINSTANCE.getExpression_LeftOfEquals();

    /**
         * The meta object literal for the '<em><b>Used As Argument In Signature Call</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = eINSTANCE.getExpression_UsedAsArgumentInSignatureCall();

				/**
         * The meta object literal for the '<em><b>Right Of Equals</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__RIGHT_OF_EQUALS = eINSTANCE.getExpression_RightOfEquals();

    /**
         * The meta object literal for the '<em><b>Conditional</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__CONDITIONAL = eINSTANCE.getExpression_Conditional();

    /**
         * The meta object literal for the '<em><b>Collection Expression</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__COLLECTION_EXPRESSION = eINSTANCE.getExpression_CollectionExpression();

    /**
         * The meta object literal for the '<em><b>In Iterator</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__IN_ITERATOR = eINSTANCE.getExpression_InIterator();

		/**
         * The meta object literal for the '<em><b>Condition Of Oql Query</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__CONDITION_OF_OQL_QUERY = eINSTANCE.getExpression_ConditionOfOqlQuery();

    /**
         * The meta object literal for the '<em><b>From Clause</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__FROM_CLAUSE = eINSTANCE.getExpression_FromClause();

		/**
         * The meta object literal for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION = eINSTANCE.getExpression_CellSetOfDimensionExpression();

				/**
         * The meta object literal for the '<em><b>Facts Of Dimension Expression</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION = eINSTANCE.getExpression_FactsOfDimensionExpression();

				/**
         * The meta object literal for the '<em><b>Dimension</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__DIMENSION = eINSTANCE.getExpression_Dimension();

				/**
         * The meta object literal for the '<em><b>Map Expression Of Group By</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY = eINSTANCE.getExpression_MapExpressionOfGroupBy();

		/**
         * The meta object literal for the '<em><b>Template</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION__TEMPLATE = eINSTANCE.getExpression_Template();

		/**
         * The meta object literal for the '<em><b>All</b></em>' container reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference EXPRESSION__ALL = eINSTANCE.getExpression_All();

    /**
         * The meta object literal for the '{@link dataaccess.expressions.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.VariableExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getVariableExpression()
         * @generated
         */
		EClass VARIABLE_EXPRESSION = eINSTANCE.getVariableExpression();

		/**
         * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE_EXPRESSION__VARIABLE = eINSTANCE.getVariableExpression_Variable();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.MethodCallExpressionImpl <em>Method Call Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.MethodCallExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getMethodCallExpression()
         * @generated
         */
		EClass METHOD_CALL_EXPRESSION = eINSTANCE.getMethodCallExpression();

		/**
         * The meta object literal for the '<em><b>Asynchronous</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute METHOD_CALL_EXPRESSION__ASYNCHRONOUS = eINSTANCE.getMethodCallExpression_Asynchronous();

		/**
         * The meta object literal for the '<em><b>Method Signature</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD_CALL_EXPRESSION__METHOD_SIGNATURE = eINSTANCE.getMethodCallExpression_MethodSignature();

		/**
         * The meta object literal for the '<em><b>Creation Expression</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference METHOD_CALL_EXPRESSION__CREATION_EXPRESSION = eINSTANCE.getMethodCallExpression_CreationExpression();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ObjectBasedExpressionImpl <em>Object Based Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ObjectBasedExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getObjectBasedExpression()
         * @generated
         */
		EClass OBJECT_BASED_EXPRESSION = eINSTANCE.getObjectBasedExpression();

		/**
         * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OBJECT_BASED_EXPRESSION__OBJECT = eINSTANCE.getObjectBasedExpression_Object();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ObjectCreationExpressionImpl <em>Object Creation Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ObjectCreationExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getObjectCreationExpression()
         * @generated
         */
		EClass OBJECT_CREATION_EXPRESSION = eINSTANCE.getObjectCreationExpression();

		/**
         * The meta object literal for the '<em><b>Class To Instantiate</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE = eINSTANCE.getObjectCreationExpression_ClassToInstantiate();

		/**
         * The meta object literal for the '<em><b>Initializers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OBJECT_CREATION_EXPRESSION__INITIALIZERS = eINSTANCE.getObjectCreationExpression_Initializers();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.FunctionCallExpressionImpl <em>Function Call Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.FunctionCallExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getFunctionCallExpression()
         * @generated
         */
		EClass FUNCTION_CALL_EXPRESSION = eINSTANCE.getFunctionCallExpression();

		/**
         * The meta object literal for the '<em><b>Called Block</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_CALL_EXPRESSION__CALLED_BLOCK = eINSTANCE.getFunctionCallExpression_CalledBlock();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.WithArgumentImpl <em>With Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.WithArgumentImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getWithArgument()
         * @generated
         */
		EClass WITH_ARGUMENT = eINSTANCE.getWithArgument();

		/**
         * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference WITH_ARGUMENT__ARGUMENT = eINSTANCE.getWithArgument_Argument();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ThisImpl <em>This</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ThisImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getThis()
         * @generated
         */
		EClass THIS = eINSTANCE.getThis();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.EqualsImpl <em>Equals</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.EqualsImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getEquals()
         * @generated
         */
		EClass EQUALS = eINSTANCE.getEquals();

		/**
         * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EQUALS__LEFT = eINSTANCE.getEquals_Left();

		/**
         * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EQUALS__RIGHT = eINSTANCE.getEquals_Right();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.AssociationEndNavigationExpressionImpl <em>Association End Navigation Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.AssociationEndNavigationExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getAssociationEndNavigationExpression()
         * @generated
         */
		EClass ASSOCIATION_END_NAVIGATION_EXPRESSION = eINSTANCE.getAssociationEndNavigationExpression();

		/**
         * The meta object literal for the '<em><b>To End</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END = eINSTANCE.getAssociationEndNavigationExpression_ToEnd();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.SignatureCallExpressionImpl <em>Signature Call Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.SignatureCallExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getSignatureCallExpression()
         * @generated
         */
		EClass SIGNATURE_CALL_EXPRESSION = eINSTANCE.getSignatureCallExpression();

		/**
         * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SIGNATURE_CALL_EXPRESSION__PARAMETERS = eINSTANCE.getSignatureCallExpression_Parameters();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ObjectCountImpl <em>Object Count</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ObjectCountImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getObjectCount()
         * @generated
         */
		EClass OBJECT_COUNT = eINSTANCE.getObjectCount();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ReplaceImpl <em>Replace</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ReplaceImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getReplace()
         * @generated
         */
		EClass REPLACE = eINSTANCE.getReplace();

		/**
         * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPLACE__STEPS = eINSTANCE.getReplace_Steps();

		/**
         * The meta object literal for the '<em><b>With</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference REPLACE__WITH = eINSTANCE.getReplace_With();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.NavigationStepImpl <em>Navigation Step</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.NavigationStepImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getNavigationStep()
         * @generated
         */
		EClass NAVIGATION_STEP = eINSTANCE.getNavigationStep();

		/**
         * The meta object literal for the '<em><b>Replace</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAVIGATION_STEP__REPLACE = eINSTANCE.getNavigationStep_Replace();

		/**
         * The meta object literal for the '<em><b>To</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAVIGATION_STEP__TO = eINSTANCE.getNavigationStep_To();

		/**
         * The meta object literal for the '<em><b>Filter Function</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAVIGATION_STEP__FILTER_FUNCTION = eINSTANCE.getNavigationStep_FilterFunction();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.HeadImpl <em>Head</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.HeadImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getHead()
         * @generated
         */
		EClass HEAD = eINSTANCE.getHead();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.TailImpl <em>Tail</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.TailImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getTail()
         * @generated
         */
		EClass TAIL = eINSTANCE.getTail();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.AsListImpl <em>As List</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.AsListImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getAsList()
         * @generated
         */
		EClass AS_LIST = eINSTANCE.getAsList();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ConditionalImpl <em>Conditional</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ConditionalImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getConditional()
         * @generated
         */
		EClass CONDITIONAL = eINSTANCE.getConditional();

		/**
         * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONDITIONAL__CONDITION = eINSTANCE.getConditional_Condition();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.TernaryImpl <em>Ternary</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.TernaryImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getTernary()
         * @generated
         */
		EClass TERNARY = eINSTANCE.getTernary();

		/**
         * The meta object literal for the '<em><b>False Expr</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TERNARY__FALSE_EXPR = eINSTANCE.getTernary_FalseExpr();

		/**
         * The meta object literal for the '<em><b>True Expr</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference TERNARY__TRUE_EXPR = eINSTANCE.getTernary_TrueExpr();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ContentEqualsImpl <em>Content Equals</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ContentEqualsImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getContentEquals()
         * @generated
         */
		EClass CONTENT_EQUALS = eINSTANCE.getContentEquals();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ExpressionWithArgumentImpl <em>Expression With Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ExpressionWithArgumentImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getExpressionWithArgument()
         * @generated
         */
		EClass EXPRESSION_WITH_ARGUMENT = eINSTANCE.getExpressionWithArgument();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.ConditionalExpressionImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getConditionalExpression()
         * @generated
         */
		EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.impl.MapImpl <em>Map</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.impl.MapImpl
         * @see dataaccess.expressions.impl.ExpressionsPackageImpl#getMap()
         * @generated
         */
		EClass MAP = eINSTANCE.getMap();

	}

} //ExpressionsPackage
