/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.fp;

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
 * @see dataaccess.expressions.fp.FpFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface FpPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "fp";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/expressions/fp.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "dataaccess.expressions.fp";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	FpPackage eINSTANCE = dataaccess.expressions.fp.impl.FpPackageImpl.init();

	/**
     * The meta object id for the '{@link dataaccess.expressions.fp.impl.AnonymousFunctionExprImpl <em>Anonymous Function Expr</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.fp.impl.AnonymousFunctionExprImpl
     * @see dataaccess.expressions.fp.impl.FpPackageImpl#getAnonymousFunctionExpr()
     * @generated
     */
	int ANONYMOUS_FUNCTION_EXPR = 0;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__OWNED_TYPE_DEFINITION = ExpressionsPackage.EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__EXPRESSION_STATEMENT = ExpressionsPackage.EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__INIT_EXPRESSION_FOR = ExpressionsPackage.EXPRESSION__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.EXPRESSION__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__OBJECT_BASED_EXPRESSION = ExpressionsPackage.EXPRESSION__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__ARGUMENT_OF = ExpressionsPackage.EXPRESSION__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__LEFT_OF_EQUALS = ExpressionsPackage.EXPRESSION__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__RIGHT_OF_EQUALS = ExpressionsPackage.EXPRESSION__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__CONDITIONAL = ExpressionsPackage.EXPRESSION__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__COLLECTION_EXPRESSION = ExpressionsPackage.EXPRESSION__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__IN_ITERATOR = ExpressionsPackage.EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__CONDITION_OF_OQL_QUERY = ExpressionsPackage.EXPRESSION__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__FROM_CLAUSE = ExpressionsPackage.EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__DIMENSION = ExpressionsPackage.EXPRESSION__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__TEMPLATE = ExpressionsPackage.EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR__ALL = ExpressionsPackage.EXPRESSION__ALL;

	/**
     * The number of structural features of the '<em>Anonymous Function Expr</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int ANONYMOUS_FUNCTION_EXPR_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The meta object id for the '{@link dataaccess.expressions.fp.impl.FunctionFromMethodExprImpl <em>Function From Method Expr</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see dataaccess.expressions.fp.impl.FunctionFromMethodExprImpl
     * @see dataaccess.expressions.fp.impl.FpPackageImpl#getFunctionFromMethodExpr()
     * @generated
     */
	int FUNCTION_FROM_METHOD_EXPR = 1;

	/**
     * The feature id for the '<em><b>Owned Type Definition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__OWNED_TYPE_DEFINITION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OWNED_TYPE_DEFINITION;

	/**
     * The feature id for the '<em><b>Expression Statement</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__EXPRESSION_STATEMENT = ExpressionsPackage.OBJECT_BASED_EXPRESSION__EXPRESSION_STATEMENT;

	/**
     * The feature id for the '<em><b>Init Expression For</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__INIT_EXPRESSION_FOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION__INIT_EXPRESSION_FOR;

	/**
     * The feature id for the '<em><b>Actual Object Parameter</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__ACTUAL_OBJECT_PARAMETER = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ACTUAL_OBJECT_PARAMETER;

	/**
     * The feature id for the '<em><b>Object Based Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__OBJECT_BASED_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT_BASED_EXPRESSION;

	/**
     * The feature id for the '<em><b>Argument Of</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__ARGUMENT_OF = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ARGUMENT_OF;

	/**
     * The feature id for the '<em><b>Block Of Function Call Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__BLOCK_OF_FUNCTION_CALL_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__BLOCK_OF_FUNCTION_CALL_EXPRESSION;

	/**
     * The feature id for the '<em><b>Left Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__LEFT_OF_EQUALS = ExpressionsPackage.OBJECT_BASED_EXPRESSION__LEFT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Used As Argument In Signature Call</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__USED_AS_ARGUMENT_IN_SIGNATURE_CALL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__USED_AS_ARGUMENT_IN_SIGNATURE_CALL;

	/**
     * The feature id for the '<em><b>Right Of Equals</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__RIGHT_OF_EQUALS = ExpressionsPackage.OBJECT_BASED_EXPRESSION__RIGHT_OF_EQUALS;

	/**
     * The feature id for the '<em><b>Conditional</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__CONDITIONAL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CONDITIONAL;

	/**
     * The feature id for the '<em><b>Collection Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__COLLECTION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__COLLECTION_EXPRESSION;

	/**
     * The feature id for the '<em><b>In Iterator</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__IN_ITERATOR = ExpressionsPackage.OBJECT_BASED_EXPRESSION__IN_ITERATOR;

	/**
     * The feature id for the '<em><b>Condition Of Oql Query</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__CONDITION_OF_OQL_QUERY = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CONDITION_OF_OQL_QUERY;

	/**
     * The feature id for the '<em><b>From Clause</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__FROM_CLAUSE = ExpressionsPackage.OBJECT_BASED_EXPRESSION__FROM_CLAUSE;

	/**
     * The feature id for the '<em><b>Cell Set Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__CELL_SET_OF_DIMENSION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__CELL_SET_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Facts Of Dimension Expression</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__FACTS_OF_DIMENSION_EXPRESSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__FACTS_OF_DIMENSION_EXPRESSION;

	/**
     * The feature id for the '<em><b>Dimension</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__DIMENSION = ExpressionsPackage.OBJECT_BASED_EXPRESSION__DIMENSION;

	/**
     * The feature id for the '<em><b>Map Expression Of Group By</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__MAP_EXPRESSION_OF_GROUP_BY = ExpressionsPackage.OBJECT_BASED_EXPRESSION__MAP_EXPRESSION_OF_GROUP_BY;

	/**
     * The feature id for the '<em><b>Template</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__TEMPLATE = ExpressionsPackage.OBJECT_BASED_EXPRESSION__TEMPLATE;

	/**
     * The feature id for the '<em><b>All</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__ALL = ExpressionsPackage.OBJECT_BASED_EXPRESSION__ALL;

	/**
     * The feature id for the '<em><b>Object</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__OBJECT = ExpressionsPackage.OBJECT_BASED_EXPRESSION__OBJECT;

	/**
     * The feature id for the '<em><b>Method</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR__METHOD = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Function From Method Expr</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int FUNCTION_FROM_METHOD_EXPR_FEATURE_COUNT = ExpressionsPackage.OBJECT_BASED_EXPRESSION_FEATURE_COUNT + 1;


	/**
     * Returns the meta object for class '{@link dataaccess.expressions.fp.AnonymousFunctionExpr <em>Anonymous Function Expr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Anonymous Function Expr</em>'.
     * @see dataaccess.expressions.fp.AnonymousFunctionExpr
     * @generated
     */
	EClass getAnonymousFunctionExpr();

	/**
     * Returns the meta object for class '{@link dataaccess.expressions.fp.FunctionFromMethodExpr <em>Function From Method Expr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Function From Method Expr</em>'.
     * @see dataaccess.expressions.fp.FunctionFromMethodExpr
     * @generated
     */
	EClass getFunctionFromMethodExpr();

	/**
     * Returns the meta object for the reference '{@link dataaccess.expressions.fp.FunctionFromMethodExpr#getMethod <em>Method</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Method</em>'.
     * @see dataaccess.expressions.fp.FunctionFromMethodExpr#getMethod()
     * @see #getFunctionFromMethodExpr()
     * @generated
     */
	EReference getFunctionFromMethodExpr_Method();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	FpFactory getFpFactory();

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
         * The meta object literal for the '{@link dataaccess.expressions.fp.impl.AnonymousFunctionExprImpl <em>Anonymous Function Expr</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.fp.impl.AnonymousFunctionExprImpl
         * @see dataaccess.expressions.fp.impl.FpPackageImpl#getAnonymousFunctionExpr()
         * @generated
         */
		EClass ANONYMOUS_FUNCTION_EXPR = eINSTANCE.getAnonymousFunctionExpr();

		/**
         * The meta object literal for the '{@link dataaccess.expressions.fp.impl.FunctionFromMethodExprImpl <em>Function From Method Expr</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see dataaccess.expressions.fp.impl.FunctionFromMethodExprImpl
         * @see dataaccess.expressions.fp.impl.FpPackageImpl#getFunctionFromMethodExpr()
         * @generated
         */
		EClass FUNCTION_FROM_METHOD_EXPR = eINSTANCE.getFunctionFromMethodExpr();

		/**
         * The meta object literal for the '<em><b>Method</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference FUNCTION_FROM_METHOD_EXPR__METHOD = eINSTANCE.getFunctionFromMethodExpr_Method();

	}

} //FpPackage
