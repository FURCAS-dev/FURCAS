/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.literals;

import dataaccess.expressions.ExpressionsPackage;

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
 * @see dataaccess.expressions.literals.LiteralsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://de.hpi.sam.bp2009.OCL' validationDelegates='http://de.hpi.sam.bp2009.OCL'"
 * @generated
 */
public interface LiteralsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "literals";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///dataaccess/expressions/literals.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "dataaccess.expressions.literals";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	LiteralsPackage eINSTANCE = dataaccess.expressions.literals.impl.LiteralsPackageImpl.init();

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.LiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getLiteral()
     * @generated
     */
	int LITERAL = 0;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__INIT_EXPRESSION_FOR = ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__OBJECT_BASED_EXPRESSION = ExpressionsPackage.EXPRESSION__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__ARGUMENT_OF = ExpressionsPackage.EXPRESSION__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__LEFT_OF_EQUALS = ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__RIGHT_OF_EQUALS = ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__CONDITIONAL = ExpressionsPackage.EXPRESSION__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__COLLECTION_EXPRESSION = ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__IN_ITERATOR = ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__CONDITION_OF_OQL_QUERY = ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__FROM_CLAUSE = ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__DIMENSION = ExpressionsPackage.EXPRESSION__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__TEMPLATE = ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__ALL = ExpressionsPackage.EXPRESSION__ALL;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL__LITERAL = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LITERAL_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.BinaryLiteralImpl <em>Binary Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.BinaryLiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getBinaryLiteral()
     * @generated
     */
	int BINARY_LITERAL = 1;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__OWNED_TYPE_DEFINITION = LITERAL__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__EXPRESSION_STATEMENT = LITERAL__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__INIT_EXPRESSION_FOR = LITERAL__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__ACTUAL_OBJECT_PARAMETER = LITERAL__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__OBJECT_BASED_EXPRESSION = LITERAL__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__ARGUMENT_OF = LITERAL__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__LEFT_OF_EQUALS = LITERAL__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__RIGHT_OF_EQUALS = LITERAL__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__CONDITIONAL = LITERAL__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__COLLECTION_EXPRESSION = LITERAL__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__IN_ITERATOR = LITERAL__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__CONDITION_OF_OQL_QUERY = LITERAL__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__FROM_CLAUSE = LITERAL__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__FACTS_OF_DIMENSION_EXPRESSION = LITERAL__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__DIMENSION = LITERAL__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__MAP_EXPRESSION_OF_GROUP_BY = LITERAL__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__TEMPLATE = LITERAL__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__ALL = LITERAL__ALL;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL__LITERAL = LITERAL__LITERAL;

	/**
     * The number of structural features of the '<em>Binary Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BINARY_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.StringLiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getStringLiteral()
     * @generated
     */
	int STRING_LITERAL = 2;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__OWNED_TYPE_DEFINITION = LITERAL__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__EXPRESSION_STATEMENT = LITERAL__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__INIT_EXPRESSION_FOR = LITERAL__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__ACTUAL_OBJECT_PARAMETER = LITERAL__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__OBJECT_BASED_EXPRESSION = LITERAL__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__ARGUMENT_OF = LITERAL__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__LEFT_OF_EQUALS = LITERAL__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__RIGHT_OF_EQUALS = LITERAL__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__CONDITIONAL = LITERAL__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__COLLECTION_EXPRESSION = LITERAL__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__IN_ITERATOR = LITERAL__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__CONDITION_OF_OQL_QUERY = LITERAL__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__FROM_CLAUSE = LITERAL__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__FACTS_OF_DIMENSION_EXPRESSION = LITERAL__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__DIMENSION = LITERAL__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__MAP_EXPRESSION_OF_GROUP_BY = LITERAL__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__TEMPLATE = LITERAL__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__ALL = LITERAL__ALL;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL__LITERAL = LITERAL__LITERAL;

	/**
     * The number of structural features of the '<em>String Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.NumberLiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getNumberLiteral()
     * @generated
     */
	int NUMBER_LITERAL = 3;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__OWNED_TYPE_DEFINITION = LITERAL__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__EXPRESSION_STATEMENT = LITERAL__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__INIT_EXPRESSION_FOR = LITERAL__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__ACTUAL_OBJECT_PARAMETER = LITERAL__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__OBJECT_BASED_EXPRESSION = LITERAL__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__ARGUMENT_OF = LITERAL__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__LEFT_OF_EQUALS = LITERAL__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__RIGHT_OF_EQUALS = LITERAL__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__CONDITIONAL = LITERAL__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__COLLECTION_EXPRESSION = LITERAL__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__IN_ITERATOR = LITERAL__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__CONDITION_OF_OQL_QUERY = LITERAL__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__FROM_CLAUSE = LITERAL__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__FACTS_OF_DIMENSION_EXPRESSION = LITERAL__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__DIMENSION = LITERAL__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__MAP_EXPRESSION_OF_GROUP_BY = LITERAL__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__TEMPLATE = LITERAL__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__ALL = LITERAL__ALL;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL__LITERAL = LITERAL__LITERAL;

	/**
     * The number of structural features of the '<em>Number Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NUMBER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.TimePointLiteralImpl <em>Time Point Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.TimePointLiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getTimePointLiteral()
     * @generated
     */
	int TIME_POINT_LITERAL = 4;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__OWNED_TYPE_DEFINITION = LITERAL__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__EXPRESSION_STATEMENT = LITERAL__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__INIT_EXPRESSION_FOR = LITERAL__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__ACTUAL_OBJECT_PARAMETER = LITERAL__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__OBJECT_BASED_EXPRESSION = LITERAL__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__ARGUMENT_OF = LITERAL__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__LEFT_OF_EQUALS = LITERAL__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__RIGHT_OF_EQUALS = LITERAL__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__CONDITIONAL = LITERAL__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__COLLECTION_EXPRESSION = LITERAL__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__IN_ITERATOR = LITERAL__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__CONDITION_OF_OQL_QUERY = LITERAL__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__FROM_CLAUSE = LITERAL__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__FACTS_OF_DIMENSION_EXPRESSION = LITERAL__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__DIMENSION = LITERAL__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__MAP_EXPRESSION_OF_GROUP_BY = LITERAL__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__TEMPLATE = LITERAL__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__ALL = LITERAL__ALL;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL__LITERAL = LITERAL__LITERAL;

	/**
     * The number of structural features of the '<em>Time Point Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int TIME_POINT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.BooleanLiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getBooleanLiteral()
     * @generated
     */
	int BOOLEAN_LITERAL = 5;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__OWNED_TYPE_DEFINITION = LITERAL__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__EXPRESSION_STATEMENT = LITERAL__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__INIT_EXPRESSION_FOR = LITERAL__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__ACTUAL_OBJECT_PARAMETER = LITERAL__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__OBJECT_BASED_EXPRESSION = LITERAL__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__ARGUMENT_OF = LITERAL__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__LEFT_OF_EQUALS = LITERAL__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__RIGHT_OF_EQUALS = LITERAL__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__CONDITIONAL = LITERAL__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__COLLECTION_EXPRESSION = LITERAL__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__IN_ITERATOR = LITERAL__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__CONDITION_OF_OQL_QUERY = LITERAL__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__FROM_CLAUSE = LITERAL__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__FACTS_OF_DIMENSION_EXPRESSION = LITERAL__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__DIMENSION = LITERAL__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__MAP_EXPRESSION_OF_GROUP_BY = LITERAL__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__TEMPLATE = LITERAL__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__ALL = LITERAL__ALL;

	/**
     * The feature id for the '<em><b>Literal</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL__LITERAL = LITERAL__LITERAL;

	/**
     * The number of structural features of the '<em>Boolean Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.ObjectLiteralImpl <em>Object Literal</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.ObjectLiteralImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getObjectLiteral()
     * @generated
     */
	int OBJECT_LITERAL = 6;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__INIT_EXPRESSION_FOR = ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__OBJECT_BASED_EXPRESSION = ExpressionsPackage.EXPRESSION__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__ARGUMENT_OF = ExpressionsPackage.EXPRESSION__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__LEFT_OF_EQUALS = ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__RIGHT_OF_EQUALS = ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__CONDITIONAL = ExpressionsPackage.EXPRESSION__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__COLLECTION_EXPRESSION = ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__IN_ITERATOR = ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__CONDITION_OF_OQL_QUERY = ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__FROM_CLAUSE = ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__DIMENSION = ExpressionsPackage.EXPRESSION__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__TEMPLATE = ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__ALL = ExpressionsPackage.EXPRESSION__ALL;

	/**
     * The feature id for the '<em><b>Value Class</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__VALUE_CLASS = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Property Values</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL__PROPERTY_VALUES = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Object Literal</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int OBJECT_LITERAL_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link dataaccess.expressions.literals.impl.ValueInitImpl <em>Value Init</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.literals.impl.ValueInitImpl
     * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getValueInit()
     * @generated
     */
	int VALUE_INIT = 7;

	/**
     * The feature id for the '<em><b>For End</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_INIT__FOR_END = 0;

	/**
     * The feature id for the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_INIT__VALUE = 1;

	/**
     * The number of structural features of the '<em>Value Init</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VALUE_INIT_FEATURE_COUNT = 2;


	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.Literal <em>Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Literal</em>'.
     * @see dataaccess.expressions.literals.Literal
     * @generated
     */
	EClass getLiteral();

	/**
     * Returns the meta object for the attribute '{@link dataaccess.expressions.literals.Literal#getLiteral <em>Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Literal</em>'.
     * @see dataaccess.expressions.literals.Literal#getLiteral()
     * @see #getLiteral()
     * @generated
     */
	EAttribute getLiteral_Literal();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.BinaryLiteral <em>Binary Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Binary Literal</em>'.
     * @see dataaccess.expressions.literals.BinaryLiteral
     * @generated
     */
	EClass getBinaryLiteral();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.StringLiteral <em>String Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>String Literal</em>'.
     * @see dataaccess.expressions.literals.StringLiteral
     * @generated
     */
	EClass getStringLiteral();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.NumberLiteral <em>Number Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Number Literal</em>'.
     * @see dataaccess.expressions.literals.NumberLiteral
     * @generated
     */
	EClass getNumberLiteral();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.TimePointLiteral <em>Time Point Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Time Point Literal</em>'.
     * @see dataaccess.expressions.literals.TimePointLiteral
     * @generated
     */
	EClass getTimePointLiteral();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.BooleanLiteral <em>Boolean Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Boolean Literal</em>'.
     * @see dataaccess.expressions.literals.BooleanLiteral
     * @generated
     */
	EClass getBooleanLiteral();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.ObjectLiteral <em>Object Literal</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Object Literal</em>'.
     * @see dataaccess.expressions.literals.ObjectLiteral
     * @generated
     */
	EClass getObjectLiteral();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.literals.ObjectLiteral#getValueClass <em>Value Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Value Class</em>'.
     * @see dataaccess.expressions.literals.ObjectLiteral#getValueClass()
     * @see #getObjectLiteral()
     * @generated
     */
	EReference getObjectLiteral_ValueClass();

	/**
     * Returns the meta object for the containment reference list '{@link dataaccess.expressions.literals.ObjectLiteral#getPropertyValues <em>Property Values</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property Values</em>'.
     * @see dataaccess.expressions.literals.ObjectLiteral#getPropertyValues()
     * @see #getObjectLiteral()
     * @generated
     */
	EReference getObjectLiteral_PropertyValues();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.literals.ValueInit <em>Value Init</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Init</em>'.
     * @see dataaccess.expressions.literals.ValueInit
     * @generated
     */
	EClass getValueInit();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.literals.ValueInit#getForEnd <em>For End</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>For End</em>'.
     * @see dataaccess.expressions.literals.ValueInit#getForEnd()
     * @see #getValueInit()
     * @generated
     */
	EReference getValueInit_ForEnd();

	/**
     * Returns the meta object for the containment reference '{@link dataaccess.expressions.literals.ValueInit#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Value</em>'.
     * @see dataaccess.expressions.literals.ValueInit#getValue()
     * @see #getValueInit()
     * @generated
     */
	EReference getValueInit_Value();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	LiteralsFactory getLiteralsFactory();

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
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.LiteralImpl <em>Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.LiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getLiteral()
         * @generated
         */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
         * The meta object literal for the '<em><b>Literal</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LITERAL__LITERAL = eINSTANCE.getLiteral_Literal();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.BinaryLiteralImpl <em>Binary Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.BinaryLiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getBinaryLiteral()
         * @generated
         */
		EClass BINARY_LITERAL = eINSTANCE.getBinaryLiteral();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.StringLiteralImpl <em>String Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.StringLiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getStringLiteral()
         * @generated
         */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.NumberLiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getNumberLiteral()
         * @generated
         */
		EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.TimePointLiteralImpl <em>Time Point Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.TimePointLiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getTimePointLiteral()
         * @generated
         */
		EClass TIME_POINT_LITERAL = eINSTANCE.getTimePointLiteral();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.BooleanLiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getBooleanLiteral()
         * @generated
         */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.ObjectLiteralImpl <em>Object Literal</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.ObjectLiteralImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getObjectLiteral()
         * @generated
         */
		EClass OBJECT_LITERAL = eINSTANCE.getObjectLiteral();

		/**
         * The meta object literal for the '<em><b>Value Class</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OBJECT_LITERAL__VALUE_CLASS = eINSTANCE.getObjectLiteral_ValueClass();

		/**
         * The meta object literal for the '<em><b>Property Values</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference OBJECT_LITERAL__PROPERTY_VALUES = eINSTANCE.getObjectLiteral_PropertyValues();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.literals.impl.ValueInitImpl <em>Value Init</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.literals.impl.ValueInitImpl
         * @see dataaccess.expressions.literals.impl.LiteralsPackageImpl#getValueInit()
         * @generated
         */
		EClass VALUE_INIT = eINSTANCE.getValueInit();

		/**
         * The meta object literal for the '<em><b>For End</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VALUE_INIT__FOR_END = eINSTANCE.getValueInit_ForEnd();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VALUE_INIT__VALUE = eINSTANCE.getValueInit_Value();

	}

} //LiteralsPackage
