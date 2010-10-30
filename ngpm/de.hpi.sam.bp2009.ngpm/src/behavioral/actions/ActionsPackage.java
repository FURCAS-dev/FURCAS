/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions;

import data.classes.ClassesPackage;

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
 * <!-- begin-model-doc -->
 * Some action language that talks in the concepts of BOs, BONodes, invoking services, sending messages, explicitly declaring that an event occurred, triggering actions, evaluating rules, ...
 * 
 * The language can be used, e.g., to specify the behavior of an action (part of a BO or BONode) or a service implementation.
 * <!-- end-model-doc -->
 * @see behavioral.actions.ActionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface ActionsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "actions";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http:///behavioral/actions.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.actions";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	ActionsPackage eINSTANCE = behavioral.actions.impl.ActionsPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.actions.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.StatementImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getStatement()
     * @generated
     */
	int STATEMENT = 1;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT__BLOCK = ClassesPackage.IN_SCOPE_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Statement</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_FEATURE_COUNT = ClassesPackage.IN_SCOPE_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.StatementWithArgumentImpl <em>Statement With Argument</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.StatementWithArgumentImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getStatementWithArgument()
     * @generated
     */
	int STATEMENT_WITH_ARGUMENT = 19;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_ARGUMENT__BLOCK = STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_ARGUMENT__ARGUMENT = STATEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Statement With Argument</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_ARGUMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.AssignmentImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getAssignment()
     * @generated
     */
	int ASSIGNMENT = 0;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSIGNMENT__BLOCK = STATEMENT_WITH_ARGUMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSIGNMENT__ARGUMENT = STATEMENT_WITH_ARGUMENT__ARGUMENT;

	/**
     * The feature id for the '<em><b>Assign To</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSIGNMENT__ASSIGN_TO = STATEMENT_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Assignment</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ASSIGNMENT_FEATURE_COUNT = STATEMENT_WITH_ARGUMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.BlockImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getBlock()
     * @generated
     */
	int BLOCK = 2;

	/**
     * The feature id for the '<em><b>Implements </b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK__IMPLEMENTS_ = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__IMPLEMENTS_;

	/**
     * The feature id for the '<em><b>Function Signature</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK__FUNCTION_SIGNATURE = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE;

	/**
     * The feature id for the '<em><b>Statements</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK__STATEMENTS = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Variables</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK__VARIABLES = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Owning Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK__OWNING_STATEMENT = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Block</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int BLOCK_FEATURE_COUNT = ClassesPackage.FUNCTION_SIGNATURE_IMPLEMENTATION_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.ConditionalStatementImpl <em>Conditional Statement</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.ConditionalStatementImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getConditionalStatement()
     * @generated
     */
	int CONDITIONAL_STATEMENT = 21;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_STATEMENT__CONDITION = ExpressionsPackage.CONDITIONAL__CONDITION;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_STATEMENT__BLOCK = ExpressionsPackage.CONDITIONAL_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Conditional Statement</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONDITIONAL_STATEMENT_FEATURE_COUNT = ExpressionsPackage.CONDITIONAL_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.IfElseImpl <em>If Else</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.IfElseImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getIfElse()
     * @generated
     */
	int IF_ELSE = 3;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_ELSE__CONDITION = CONDITIONAL_STATEMENT__CONDITION;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_ELSE__BLOCK = CONDITIONAL_STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Nested Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_ELSE__NESTED_BLOCKS = CONDITIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>If Else</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IF_ELSE_FEATURE_COUNT = CONDITIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.WhileLoopImpl <em>While Loop</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.WhileLoopImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getWhileLoop()
     * @generated
     */
	int WHILE_LOOP = 4;

	/**
     * The feature id for the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WHILE_LOOP__CONDITION = CONDITIONAL_STATEMENT__CONDITION;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WHILE_LOOP__BLOCK = CONDITIONAL_STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Nested Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WHILE_LOOP__NESTED_BLOCKS = CONDITIONAL_STATEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>While Loop</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int WHILE_LOOP_FEATURE_COUNT = CONDITIONAL_STATEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.StatementWithNestedBlocksImpl <em>Statement With Nested Blocks</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.StatementWithNestedBlocksImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getStatementWithNestedBlocks()
     * @generated
     */
	int STATEMENT_WITH_NESTED_BLOCKS = 17;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_NESTED_BLOCKS__BLOCK = STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Nested Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS = STATEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Statement With Nested Blocks</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int STATEMENT_WITH_NESTED_BLOCKS_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.SingleBlockStatementImpl <em>Single Block Statement</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.SingleBlockStatementImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getSingleBlockStatement()
     * @generated
     */
	int SINGLE_BLOCK_STATEMENT = 18;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SINGLE_BLOCK_STATEMENT__BLOCK = STATEMENT_WITH_NESTED_BLOCKS__BLOCK;

	/**
     * The feature id for the '<em><b>Nested Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SINGLE_BLOCK_STATEMENT__NESTED_BLOCKS = STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS;

	/**
     * The number of structural features of the '<em>Single Block Statement</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SINGLE_BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_WITH_NESTED_BLOCKS_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.ForeachImpl <em>Foreach</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.ForeachImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getForeach()
     * @generated
     */
	int FOREACH = 5;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FOREACH__BLOCK = SINGLE_BLOCK_STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Nested Blocks</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FOREACH__NESTED_BLOCKS = SINGLE_BLOCK_STATEMENT__NESTED_BLOCKS;

	/**
     * The feature id for the '<em><b>Parallel</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FOREACH__PARALLEL = SINGLE_BLOCK_STATEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Collection</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FOREACH__COLLECTION = SINGLE_BLOCK_STATEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>For Variable</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FOREACH__FOR_VARIABLE = SINGLE_BLOCK_STATEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Foreach</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FOREACH_FEATURE_COUNT = SINGLE_BLOCK_STATEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.ReturnImpl <em>Return</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.ReturnImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getReturn()
     * @generated
     */
	int RETURN = 6;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RETURN__BLOCK = STATEMENT_WITH_ARGUMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Argument</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RETURN__ARGUMENT = STATEMENT_WITH_ARGUMENT__ARGUMENT;

	/**
     * The number of structural features of the '<em>Return</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int RETURN_FEATURE_COUNT = STATEMENT_WITH_ARGUMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.LinkManipulationStatementImpl <em>Link Manipulation Statement</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.LinkManipulationStatementImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getLinkManipulationStatement()
     * @generated
     */
	int LINK_MANIPULATION_STATEMENT = 9;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_STATEMENT__BLOCK = STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_STATEMENT__AT = STATEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Association</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_STATEMENT__ASSOCIATION = STATEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Objects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_STATEMENT__OBJECTS = STATEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Link Manipulation Statement</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LINK_MANIPULATION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.AddLinkImpl <em>Add Link</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.AddLinkImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getAddLink()
     * @generated
     */
	int ADD_LINK = 7;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ADD_LINK__BLOCK = LINK_MANIPULATION_STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ADD_LINK__AT = LINK_MANIPULATION_STATEMENT__AT;

	/**
     * The feature id for the '<em><b>Association</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ADD_LINK__ASSOCIATION = LINK_MANIPULATION_STATEMENT__ASSOCIATION;

	/**
     * The feature id for the '<em><b>Objects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ADD_LINK__OBJECTS = LINK_MANIPULATION_STATEMENT__OBJECTS;

	/**
     * The number of structural features of the '<em>Add Link</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ADD_LINK_FEATURE_COUNT = LINK_MANIPULATION_STATEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.RemoveLinkImpl <em>Remove Link</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.RemoveLinkImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getRemoveLink()
     * @generated
     */
	int REMOVE_LINK = 8;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOVE_LINK__BLOCK = LINK_MANIPULATION_STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>At</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOVE_LINK__AT = LINK_MANIPULATION_STATEMENT__AT;

	/**
     * The feature id for the '<em><b>Association</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOVE_LINK__ASSOCIATION = LINK_MANIPULATION_STATEMENT__ASSOCIATION;

	/**
     * The feature id for the '<em><b>Objects</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOVE_LINK__OBJECTS = LINK_MANIPULATION_STATEMENT__OBJECTS;

	/**
     * The number of structural features of the '<em>Remove Link</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int REMOVE_LINK_FEATURE_COUNT = LINK_MANIPULATION_STATEMENT_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.ExpressionStatementImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getExpressionStatement()
     * @generated
     */
	int EXPRESSION_STATEMENT = 10;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_STATEMENT__BLOCK = STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Expression Statement</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.SortImpl <em>Sort</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.SortImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getSort()
     * @generated
     */
	int SORT = 11;

	/**
     * The number of structural features of the '<em>Sort</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SORT_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.QueryInvocationImpl <em>Query Invocation</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.QueryInvocationImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getQueryInvocation()
     * @generated
     */
	int QUERY_INVOCATION = 12;

	/**
     * The number of structural features of the '<em>Query Invocation</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int QUERY_INVOCATION_FEATURE_COUNT = 0;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.NamedValueWithOptionalInitExpressionImpl <em>Named Value With Optional Init Expression</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.NamedValueWithOptionalInitExpressionImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getNamedValueWithOptionalInitExpression()
     * @generated
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION = 20;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAME = ClassesPackage.NAMED_VALUE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__DESCRIPTION = ClassesPackage.NAMED_VALUE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__OWNED_TYPE_DEFINITION = ClassesPackage.NAMED_VALUE__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__OWNER = ClassesPackage.NAMED_VALUE__OWNER;

	/**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Named Value Declaration</b></em>' reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 1;

  /**
     * The number of structural features of the '<em>Named Value With Optional Init Expression</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION_FEATURE_COUNT = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 2;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.ConstantImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getConstant()
     * @generated
     */
	int CONSTANT = 13;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT__NAME = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT__DESCRIPTION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT__OWNED_TYPE_DEFINITION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT__OWNER = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__OWNER;

	/**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT__INIT_EXPRESSION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION;

	/**
     * The feature id for the '<em><b>Named Value Declaration</b></em>' reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int CONSTANT__NAMED_VALUE_DECLARATION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION;

  /**
     * The feature id for the '<em><b>Iterate</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT__ITERATE = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Constant</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int CONSTANT_FEATURE_COUNT = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.VariableImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getVariable()
     * @generated
     */
	int VARIABLE = 14;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__NAME = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__DESCRIPTION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__OWNED_TYPE_DEFINITION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__OWNER = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__OWNER;

	/**
     * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__INIT_EXPRESSION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION;

	/**
     * The feature id for the '<em><b>Named Value Declaration</b></em>' reference.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
  int VARIABLE__NAMED_VALUE_DECLARATION = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION;

  /**
     * The feature id for the '<em><b>Assignments</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE__ASSIGNMENTS = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Variable</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int VARIABLE_FEATURE_COUNT = NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.IteratorImpl <em>Iterator</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.IteratorImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getIterator()
     * @generated
     */
	int ITERATOR = 15;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__NAME = ClassesPackage.NAMED_VALUE__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__DESCRIPTION = ClassesPackage.NAMED_VALUE__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__OWNED_TYPE_DEFINITION = ClassesPackage.NAMED_VALUE__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Owner</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__OWNER = ClassesPackage.NAMED_VALUE__OWNER;

	/**
     * The feature id for the '<em><b>Bound To For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__BOUND_TO_FOR = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Iterate</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__ITERATE = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Selection</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__SELECTION = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__FROM_CLAUSE = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Fact Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__FACT_OF_GROUP_BY = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__DIMENSION = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Grouped Facts Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR__GROUPED_FACTS_OF_GROUP_BY = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 6;

	/**
     * The number of structural features of the '<em>Iterator</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ITERATOR_FEATURE_COUNT = ClassesPackage.NAMED_VALUE_FEATURE_COUNT + 7;

	/**
     * The meta object id for the '{@link behavioral.actions.impl.NamedValueDeclarationImpl <em>Named Value Declaration</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.actions.impl.NamedValueDeclarationImpl
     * @see behavioral.actions.impl.ActionsPackageImpl#getNamedValueDeclaration()
     * @generated
     */
	int NAMED_VALUE_DECLARATION = 16;

	/**
     * The feature id for the '<em><b>Block</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_DECLARATION__BLOCK = STATEMENT__BLOCK;

	/**
     * The feature id for the '<em><b>Named Value</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_DECLARATION__NAMED_VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Named Value Declaration</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NAMED_VALUE_DECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link behavioral.actions.Assignment <em>Assignment</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Assignment</em>'.
     * @see behavioral.actions.Assignment
     * @generated
     */
	EClass getAssignment();

	/**
     * Returns the meta object for the reference '{@link behavioral.actions.Assignment#getAssignTo <em>Assign To</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Assign To</em>'.
     * @see behavioral.actions.Assignment#getAssignTo()
     * @see #getAssignment()
     * @generated
     */
	EReference getAssignment_AssignTo();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Statement <em>Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Statement</em>'.
     * @see behavioral.actions.Statement
     * @generated
     */
	EClass getStatement();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Statement#getBlock <em>Block</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Block</em>'.
     * @see behavioral.actions.Statement#getBlock()
     * @see #getStatement()
     * @generated
     */
	EReference getStatement_Block();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Block <em>Block</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Block</em>'.
     * @see behavioral.actions.Block
     * @generated
     */
	EClass getBlock();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.actions.Block#getStatements <em>Statements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Statements</em>'.
     * @see behavioral.actions.Block#getStatements()
     * @see #getBlock()
     * @generated
     */
	EReference getBlock_Statements();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.actions.Block#getVariables <em>Variables</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Variables</em>'.
     * @see behavioral.actions.Block#getVariables()
     * @see #getBlock()
     * @generated
     */
	EReference getBlock_Variables();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Block#getOwningStatement <em>Owning Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Owning Statement</em>'.
     * @see behavioral.actions.Block#getOwningStatement()
     * @see #getBlock()
     * @generated
     */
	EReference getBlock_OwningStatement();

	/**
     * Returns the meta object for class '{@link behavioral.actions.IfElse <em>If Else</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>If Else</em>'.
     * @see behavioral.actions.IfElse
     * @generated
     */
	EClass getIfElse();

	/**
     * Returns the meta object for class '{@link behavioral.actions.WhileLoop <em>While Loop</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>While Loop</em>'.
     * @see behavioral.actions.WhileLoop
     * @generated
     */
	EClass getWhileLoop();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Foreach <em>Foreach</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Foreach</em>'.
     * @see behavioral.actions.Foreach
     * @generated
     */
	EClass getForeach();

	/**
     * Returns the meta object for the attribute '{@link behavioral.actions.Foreach#isParallel <em>Parallel</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Parallel</em>'.
     * @see behavioral.actions.Foreach#isParallel()
     * @see #getForeach()
     * @generated
     */
	EAttribute getForeach_Parallel();

	/**
     * Returns the meta object for the reference '{@link behavioral.actions.Foreach#getCollection <em>Collection</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Collection</em>'.
     * @see behavioral.actions.Foreach#getCollection()
     * @see #getForeach()
     * @generated
     */
	EReference getForeach_Collection();

	/**
     * Returns the meta object for the containment reference '{@link behavioral.actions.Foreach#getForVariable <em>For Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>For Variable</em>'.
     * @see behavioral.actions.Foreach#getForVariable()
     * @see #getForeach()
     * @generated
     */
	EReference getForeach_ForVariable();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Return <em>Return</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Return</em>'.
     * @see behavioral.actions.Return
     * @generated
     */
	EClass getReturn();

	/**
     * Returns the meta object for class '{@link behavioral.actions.AddLink <em>Add Link</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Add Link</em>'.
     * @see behavioral.actions.AddLink
     * @generated
     */
	EClass getAddLink();

	/**
     * Returns the meta object for class '{@link behavioral.actions.RemoveLink <em>Remove Link</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Remove Link</em>'.
     * @see behavioral.actions.RemoveLink
     * @generated
     */
	EClass getRemoveLink();

	/**
     * Returns the meta object for class '{@link behavioral.actions.LinkManipulationStatement <em>Link Manipulation Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Link Manipulation Statement</em>'.
     * @see behavioral.actions.LinkManipulationStatement
     * @generated
     */
	EClass getLinkManipulationStatement();

	/**
     * Returns the meta object for the attribute '{@link behavioral.actions.LinkManipulationStatement#getAt <em>At</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>At</em>'.
     * @see behavioral.actions.LinkManipulationStatement#getAt()
     * @see #getLinkManipulationStatement()
     * @generated
     */
	EAttribute getLinkManipulationStatement_At();

	/**
     * Returns the meta object for the reference '{@link behavioral.actions.LinkManipulationStatement#getAssociation <em>Association</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Association</em>'.
     * @see behavioral.actions.LinkManipulationStatement#getAssociation()
     * @see #getLinkManipulationStatement()
     * @generated
     */
	EReference getLinkManipulationStatement_Association();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.actions.LinkManipulationStatement#getObjects <em>Objects</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Objects</em>'.
     * @see behavioral.actions.LinkManipulationStatement#getObjects()
     * @see #getLinkManipulationStatement()
     * @generated
     */
	EReference getLinkManipulationStatement_Objects();

	/**
     * Returns the meta object for class '{@link behavioral.actions.ExpressionStatement <em>Expression Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Expression Statement</em>'.
     * @see behavioral.actions.ExpressionStatement
     * @generated
     */
	EClass getExpressionStatement();

	/**
     * Returns the meta object for the containment reference '{@link behavioral.actions.ExpressionStatement#getExpression <em>Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Expression</em>'.
     * @see behavioral.actions.ExpressionStatement#getExpression()
     * @see #getExpressionStatement()
     * @generated
     */
	EReference getExpressionStatement_Expression();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Sort <em>Sort</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sort</em>'.
     * @see behavioral.actions.Sort
     * @generated
     */
	EClass getSort();

	/**
     * Returns the meta object for class '{@link behavioral.actions.QueryInvocation <em>Query Invocation</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Query Invocation</em>'.
     * @see behavioral.actions.QueryInvocation
     * @generated
     */
	EClass getQueryInvocation();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Constant <em>Constant</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Constant</em>'.
     * @see behavioral.actions.Constant
     * @generated
     */
	EClass getConstant();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Constant#getIterate <em>Iterate</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Iterate</em>'.
     * @see behavioral.actions.Constant#getIterate()
     * @see #getConstant()
     * @generated
     */
	EReference getConstant_Iterate();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Variable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Variable</em>'.
     * @see behavioral.actions.Variable
     * @generated
     */
	EClass getVariable();

	/**
     * Returns the meta object for the reference list '{@link behavioral.actions.Variable#getAssignments <em>Assignments</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Assignments</em>'.
     * @see behavioral.actions.Variable#getAssignments()
     * @see #getVariable()
     * @generated
     */
	EReference getVariable_Assignments();

	/**
     * Returns the meta object for class '{@link behavioral.actions.Iterator <em>Iterator</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Iterator</em>'.
     * @see behavioral.actions.Iterator
     * @generated
     */
	EClass getIterator();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getBoundToFor <em>Bound To For</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Bound To For</em>'.
     * @see behavioral.actions.Iterator#getBoundToFor()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_BoundToFor();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getIterate <em>Iterate</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Iterate</em>'.
     * @see behavioral.actions.Iterator#getIterate()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_Iterate();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getSelection <em>Selection</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Selection</em>'.
     * @see behavioral.actions.Iterator#getSelection()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_Selection();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getFromClause <em>From Clause</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>From Clause</em>'.
     * @see behavioral.actions.Iterator#getFromClause()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_FromClause();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getFactOfGroupBy <em>Fact Of Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Fact Of Group By</em>'.
     * @see behavioral.actions.Iterator#getFactOfGroupBy()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_FactOfGroupBy();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Dimension</em>'.
     * @see behavioral.actions.Iterator#getDimension()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_Dimension();

	/**
     * Returns the meta object for the container reference '{@link behavioral.actions.Iterator#getGroupedFactsOfGroupBy <em>Grouped Facts Of Group By</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Grouped Facts Of Group By</em>'.
     * @see behavioral.actions.Iterator#getGroupedFactsOfGroupBy()
     * @see #getIterator()
     * @generated
     */
	EReference getIterator_GroupedFactsOfGroupBy();

	/**
     * Returns the meta object for class '{@link behavioral.actions.NamedValueDeclaration <em>Named Value Declaration</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Value Declaration</em>'.
     * @see behavioral.actions.NamedValueDeclaration
     * @generated
     */
	EClass getNamedValueDeclaration();

	/**
     * Returns the meta object for the reference '{@link behavioral.actions.NamedValueDeclaration#getNamedValue <em>Named Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Named Value</em>'.
     * @see behavioral.actions.NamedValueDeclaration#getNamedValue()
     * @see #getNamedValueDeclaration()
     * @generated
     */
	EReference getNamedValueDeclaration_NamedValue();

	/**
     * Returns the meta object for class '{@link behavioral.actions.StatementWithNestedBlocks <em>Statement With Nested Blocks</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Statement With Nested Blocks</em>'.
     * @see behavioral.actions.StatementWithNestedBlocks
     * @generated
     */
	EClass getStatementWithNestedBlocks();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.actions.StatementWithNestedBlocks#getNestedBlocks <em>Nested Blocks</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nested Blocks</em>'.
     * @see behavioral.actions.StatementWithNestedBlocks#getNestedBlocks()
     * @see #getStatementWithNestedBlocks()
     * @generated
     */
	EReference getStatementWithNestedBlocks_NestedBlocks();

	/**
     * Returns the meta object for class '{@link behavioral.actions.SingleBlockStatement <em>Single Block Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Single Block Statement</em>'.
     * @see behavioral.actions.SingleBlockStatement
     * @generated
     */
	EClass getSingleBlockStatement();

	/**
     * Returns the meta object for class '{@link behavioral.actions.StatementWithArgument <em>Statement With Argument</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Statement With Argument</em>'.
     * @see behavioral.actions.StatementWithArgument
     * @generated
     */
	EClass getStatementWithArgument();

	/**
     * Returns the meta object for class '{@link behavioral.actions.NamedValueWithOptionalInitExpression <em>Named Value With Optional Init Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Value With Optional Init Expression</em>'.
     * @see behavioral.actions.NamedValueWithOptionalInitExpression
     * @generated
     */
	EClass getNamedValueWithOptionalInitExpression();

	/**
     * Returns the meta object for the containment reference '{@link behavioral.actions.NamedValueWithOptionalInitExpression#getInitExpression <em>Init Expression</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Init Expression</em>'.
     * @see behavioral.actions.NamedValueWithOptionalInitExpression#getInitExpression()
     * @see #getNamedValueWithOptionalInitExpression()
     * @generated
     */
	EReference getNamedValueWithOptionalInitExpression_InitExpression();

	/**
     * Returns the meta object for the reference '{@link behavioral.actions.NamedValueWithOptionalInitExpression#getNamedValueDeclaration <em>Named Value Declaration</em>}'.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Named Value Declaration</em>'.
     * @see behavioral.actions.NamedValueWithOptionalInitExpression#getNamedValueDeclaration()
     * @see #getNamedValueWithOptionalInitExpression()
     * @generated
     */
  EReference getNamedValueWithOptionalInitExpression_NamedValueDeclaration();

  /**
     * Returns the meta object for class '{@link behavioral.actions.ConditionalStatement <em>Conditional Statement</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Conditional Statement</em>'.
     * @see behavioral.actions.ConditionalStatement
     * @generated
     */
	EClass getConditionalStatement();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	ActionsFactory getActionsFactory();

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
         * The meta object literal for the '{@link behavioral.actions.impl.AssignmentImpl <em>Assignment</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.AssignmentImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getAssignment()
         * @generated
         */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
         * The meta object literal for the '<em><b>Assign To</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ASSIGNMENT__ASSIGN_TO = eINSTANCE.getAssignment_AssignTo();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.StatementImpl <em>Statement</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.StatementImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getStatement()
         * @generated
         */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
         * The meta object literal for the '<em><b>Block</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATEMENT__BLOCK = eINSTANCE.getStatement_Block();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.BlockImpl <em>Block</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.BlockImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getBlock()
         * @generated
         */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
         * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

		/**
         * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BLOCK__VARIABLES = eINSTANCE.getBlock_Variables();

		/**
         * The meta object literal for the '<em><b>Owning Statement</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference BLOCK__OWNING_STATEMENT = eINSTANCE.getBlock_OwningStatement();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.IfElseImpl <em>If Else</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.IfElseImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getIfElse()
         * @generated
         */
		EClass IF_ELSE = eINSTANCE.getIfElse();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.WhileLoopImpl <em>While Loop</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.WhileLoopImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getWhileLoop()
         * @generated
         */
		EClass WHILE_LOOP = eINSTANCE.getWhileLoop();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.ForeachImpl <em>Foreach</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.ForeachImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getForeach()
         * @generated
         */
		EClass FOREACH = eINSTANCE.getForeach();

		/**
         * The meta object literal for the '<em><b>Parallel</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute FOREACH__PARALLEL = eINSTANCE.getForeach_Parallel();

		/**
         * The meta object literal for the '<em><b>Collection</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FOREACH__COLLECTION = eINSTANCE.getForeach_Collection();

		/**
         * The meta object literal for the '<em><b>For Variable</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FOREACH__FOR_VARIABLE = eINSTANCE.getForeach_ForVariable();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.ReturnImpl <em>Return</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.ReturnImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getReturn()
         * @generated
         */
		EClass RETURN = eINSTANCE.getReturn();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.AddLinkImpl <em>Add Link</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.AddLinkImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getAddLink()
         * @generated
         */
		EClass ADD_LINK = eINSTANCE.getAddLink();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.RemoveLinkImpl <em>Remove Link</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.RemoveLinkImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getRemoveLink()
         * @generated
         */
		EClass REMOVE_LINK = eINSTANCE.getRemoveLink();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.LinkManipulationStatementImpl <em>Link Manipulation Statement</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.LinkManipulationStatementImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getLinkManipulationStatement()
         * @generated
         */
		EClass LINK_MANIPULATION_STATEMENT = eINSTANCE.getLinkManipulationStatement();

		/**
         * The meta object literal for the '<em><b>At</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LINK_MANIPULATION_STATEMENT__AT = eINSTANCE.getLinkManipulationStatement_At();

		/**
         * The meta object literal for the '<em><b>Association</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LINK_MANIPULATION_STATEMENT__ASSOCIATION = eINSTANCE.getLinkManipulationStatement_Association();

		/**
         * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LINK_MANIPULATION_STATEMENT__OBJECTS = eINSTANCE.getLinkManipulationStatement_Objects();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.ExpressionStatementImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getExpressionStatement()
         * @generated
         */
		EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

		/**
         * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.SortImpl <em>Sort</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.SortImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getSort()
         * @generated
         */
		EClass SORT = eINSTANCE.getSort();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.QueryInvocationImpl <em>Query Invocation</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.QueryInvocationImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getQueryInvocation()
         * @generated
         */
		EClass QUERY_INVOCATION = eINSTANCE.getQueryInvocation();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.ConstantImpl <em>Constant</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.ConstantImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getConstant()
         * @generated
         */
		EClass CONSTANT = eINSTANCE.getConstant();

		/**
         * The meta object literal for the '<em><b>Iterate</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference CONSTANT__ITERATE = eINSTANCE.getConstant_Iterate();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.VariableImpl <em>Variable</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.VariableImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getVariable()
         * @generated
         */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
         * The meta object literal for the '<em><b>Assignments</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference VARIABLE__ASSIGNMENTS = eINSTANCE.getVariable_Assignments();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.IteratorImpl <em>Iterator</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.IteratorImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getIterator()
         * @generated
         */
		EClass ITERATOR = eINSTANCE.getIterator();

		/**
         * The meta object literal for the '<em><b>Bound To For</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__BOUND_TO_FOR = eINSTANCE.getIterator_BoundToFor();

		/**
         * The meta object literal for the '<em><b>Iterate</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__ITERATE = eINSTANCE.getIterator_Iterate();

		/**
         * The meta object literal for the '<em><b>Selection</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__SELECTION = eINSTANCE.getIterator_Selection();

		/**
         * The meta object literal for the '<em><b>From Clause</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__FROM_CLAUSE = eINSTANCE.getIterator_FromClause();

		/**
         * The meta object literal for the '<em><b>Fact Of Group By</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__FACT_OF_GROUP_BY = eINSTANCE.getIterator_FactOfGroupBy();

		/**
         * The meta object literal for the '<em><b>Dimension</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__DIMENSION = eINSTANCE.getIterator_Dimension();

		/**
         * The meta object literal for the '<em><b>Grouped Facts Of Group By</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference ITERATOR__GROUPED_FACTS_OF_GROUP_BY = eINSTANCE.getIterator_GroupedFactsOfGroupBy();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.NamedValueDeclarationImpl <em>Named Value Declaration</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.NamedValueDeclarationImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getNamedValueDeclaration()
         * @generated
         */
		EClass NAMED_VALUE_DECLARATION = eINSTANCE.getNamedValueDeclaration();

		/**
         * The meta object literal for the '<em><b>Named Value</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAMED_VALUE_DECLARATION__NAMED_VALUE = eINSTANCE.getNamedValueDeclaration_NamedValue();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.StatementWithNestedBlocksImpl <em>Statement With Nested Blocks</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.StatementWithNestedBlocksImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getStatementWithNestedBlocks()
         * @generated
         */
		EClass STATEMENT_WITH_NESTED_BLOCKS = eINSTANCE.getStatementWithNestedBlocks();

		/**
         * The meta object literal for the '<em><b>Nested Blocks</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS = eINSTANCE.getStatementWithNestedBlocks_NestedBlocks();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.SingleBlockStatementImpl <em>Single Block Statement</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.SingleBlockStatementImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getSingleBlockStatement()
         * @generated
         */
		EClass SINGLE_BLOCK_STATEMENT = eINSTANCE.getSingleBlockStatement();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.StatementWithArgumentImpl <em>Statement With Argument</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.StatementWithArgumentImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getStatementWithArgument()
         * @generated
         */
		EClass STATEMENT_WITH_ARGUMENT = eINSTANCE.getStatementWithArgument();

		/**
         * The meta object literal for the '{@link behavioral.actions.impl.NamedValueWithOptionalInitExpressionImpl <em>Named Value With Optional Init Expression</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.NamedValueWithOptionalInitExpressionImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getNamedValueWithOptionalInitExpression()
         * @generated
         */
		EClass NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION = eINSTANCE.getNamedValueWithOptionalInitExpression();

		/**
         * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION = eINSTANCE.getNamedValueWithOptionalInitExpression_InitExpression();

		/**
         * The meta object literal for the '<em><b>Named Value Declaration</b></em>' reference feature.
         * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
         * @generated
         */
    EReference NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__NAMED_VALUE_DECLARATION = eINSTANCE.getNamedValueWithOptionalInitExpression_NamedValueDeclaration();

    /**
         * The meta object literal for the '{@link behavioral.actions.impl.ConditionalStatementImpl <em>Conditional Statement</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.actions.impl.ConditionalStatementImpl
         * @see behavioral.actions.impl.ActionsPackageImpl#getConditionalStatement()
         * @generated
         */
		EClass CONDITIONAL_STATEMENT = eINSTANCE.getConditionalStatement();

	}

} //ActionsPackage
