/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.syntax.ast.AstPackage;

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
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage{
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
	String eNS_URI = "urn:ast.expressions.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ast.expressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl <em>Ocl Expression AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclExpressionAS()
	 * @generated
	 */
	int OCL_EXPRESSION_AS = 21;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_AS__IS_MARKED_PRE = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_AS__PARENT = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_AS__IF_EXP_AS = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Ocl Expression AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LogicalExpASImpl <em>Logical Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LogicalExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLogicalExpAS()
	 * @generated
	 */
	int LOGICAL_EXP_AS = 18;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXP_AS__RIGHT_OPERAND = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXP_AS__LEFT_OPERAND = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Logical Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.AndExpASImpl <em>And Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.AndExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getAndExpAS()
	 * @generated
	 */
	int AND_EXP_AS = 0;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_AS__IS_MARKED_PRE = LOGICAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_AS__PARENT = LOGICAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_AS__IF_EXP_AS = LOGICAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_AS__RIGHT_OPERAND = LOGICAL_EXP_AS__RIGHT_OPERAND;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_AS__LEFT_OPERAND = LOGICAL_EXP_AS__LEFT_OPERAND;

	/**
	 * The number of structural features of the '<em>And Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_EXP_AS_FEATURE_COUNT = LOGICAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.SelectionExpASImpl <em>Selection Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.SelectionExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getSelectionExpAS()
	 * @generated
	 */
	int SELECTION_EXP_AS = 30;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_EXP_AS__NAME = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_EXP_AS__SOURCE = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Selection Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.ArrowSelectionExpASImpl <em>Arrow Selection Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ArrowSelectionExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getArrowSelectionExpAS()
	 * @generated
	 */
	int ARROW_SELECTION_EXP_AS = 1;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_SELECTION_EXP_AS__IS_MARKED_PRE = SELECTION_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_SELECTION_EXP_AS__PARENT = SELECTION_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_SELECTION_EXP_AS__IF_EXP_AS = SELECTION_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_SELECTION_EXP_AS__NAME = SELECTION_EXP_AS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_SELECTION_EXP_AS__SOURCE = SELECTION_EXP_AS__SOURCE;

	/**
	 * The number of structural features of the '<em>Arrow Selection Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_SELECTION_EXP_AS_FEATURE_COUNT = SELECTION_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CallExpASImpl <em>Call Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CallExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCallExpAS()
	 * @generated
	 */
	int CALL_EXP_AS = 4;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_AS__ARGUMENTS = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_AS__SOURCE = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.AssociationCallExpASImpl <em>Association Call Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.AssociationCallExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getAssociationCallExpAS()
	 * @generated
	 */
	int ASSOCIATION_CALL_EXP_AS = 2;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CALL_EXP_AS__IS_MARKED_PRE = CALL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CALL_EXP_AS__PARENT = CALL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CALL_EXP_AS__IF_EXP_AS = CALL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CALL_EXP_AS__ARGUMENTS = CALL_EXP_AS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CALL_EXP_AS__SOURCE = CALL_EXP_AS__SOURCE;

	/**
	 * The number of structural features of the '<em>Association Call Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CALL_EXP_AS_FEATURE_COUNT = CALL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.PrimaryExpASImpl <em>Primary Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.PrimaryExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getPrimaryExpAS()
	 * @generated
	 */
	int PRIMARY_EXP_AS = 27;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The number of structural features of the '<em>Primary Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LiteralExpASImpl <em>Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLiteralExpAS()
	 * @generated
	 */
	int LITERAL_EXP_AS = 17;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_AS__IS_MARKED_PRE = PRIMARY_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_AS__PARENT = PRIMARY_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_AS__IF_EXP_AS = PRIMARY_EXP_AS__IF_EXP_AS;

	/**
	 * The number of structural features of the '<em>Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_AS_FEATURE_COUNT = PRIMARY_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.PrimitiveLiteralExpASImpl <em>Primitive Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.PrimitiveLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getPrimitiveLiteralExpAS()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP_AS = 28;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_AS__IS_MARKED_PRE = LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_AS__PARENT = LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_AS__IF_EXP_AS = LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT = LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.BooleanLiteralExpASImpl <em>Boolean Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.BooleanLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getBooleanLiteralExpAS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_AS = 3;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_AS__IS_MARKED_PRE = PRIMITIVE_LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_AS__PARENT = PRIMITIVE_LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_AS__IF_EXP_AS = PRIMITIVE_LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_AS__VALUE = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_AS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralPartASImpl <em>Collection Literal Part AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralPartASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralPartAS()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART_AS = 7;

	/**
	 * The number of structural features of the '<em>Collection Literal Part AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionItemASImpl <em>Collection Item AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionItemASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionItemAS()
	 * @generated
	 */
	int COLLECTION_ITEM_AS = 5;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_AS__ITEM = COLLECTION_LITERAL_PART_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Item AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_AS_FEATURE_COUNT = COLLECTION_LITERAL_PART_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralExpASImpl <em>Collection Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralExpAS()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP_AS = 6;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_AS__IS_MARKED_PRE = LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_AS__PARENT = LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_AS__IF_EXP_AS = LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_AS__KIND = LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS = LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_AS_FEATURE_COUNT = LITERAL_EXP_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionRangeASImpl <em>Collection Range AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionRangeASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionRangeAS()
	 * @generated
	 */
	int COLLECTION_RANGE_AS = 8;

	/**
	 * The feature id for the '<em><b>Last</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_AS__LAST = COLLECTION_LITERAL_PART_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_AS__FIRST = COLLECTION_LITERAL_PART_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Range AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_AS_FEATURE_COUNT = COLLECTION_LITERAL_PART_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.DotSelectionExpASImpl <em>Dot Selection Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.DotSelectionExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getDotSelectionExpAS()
	 * @generated
	 */
	int DOT_SELECTION_EXP_AS = 9;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_SELECTION_EXP_AS__IS_MARKED_PRE = SELECTION_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_SELECTION_EXP_AS__PARENT = SELECTION_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_SELECTION_EXP_AS__IF_EXP_AS = SELECTION_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_SELECTION_EXP_AS__NAME = SELECTION_EXP_AS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_SELECTION_EXP_AS__SOURCE = SELECTION_EXP_AS__SOURCE;

	/**
	 * The number of structural features of the '<em>Dot Selection Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_SELECTION_EXP_AS_FEATURE_COUNT = SELECTION_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.EnumLiteralExpASImpl <em>Enum Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.EnumLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getEnumLiteralExpAS()
	 * @generated
	 */
	int ENUM_LITERAL_EXP_AS = 10;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_AS__IS_MARKED_PRE = LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_AS__PARENT = LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_AS__IF_EXP_AS = LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_AS__PATH_NAME = LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_AS_FEATURE_COUNT = LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IfExpASImpl <em>If Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IfExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIfExpAS()
	 * @generated
	 */
	int IF_EXP_AS = 11;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS__CONDITION = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS__THEN_EXPRESSION = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS__ELSE_EXPRESSION = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.ImpliesExpASImpl <em>Implies Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ImpliesExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getImpliesExpAS()
	 * @generated
	 */
	int IMPLIES_EXP_AS = 12;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXP_AS__IS_MARKED_PRE = LOGICAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXP_AS__PARENT = LOGICAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXP_AS__IF_EXP_AS = LOGICAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXP_AS__RIGHT_OPERAND = LOGICAL_EXP_AS__RIGHT_OPERAND;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXP_AS__LEFT_OPERAND = LOGICAL_EXP_AS__LEFT_OPERAND;

	/**
	 * The number of structural features of the '<em>Implies Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXP_AS_FEATURE_COUNT = LOGICAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IntegerLiteralExpASImpl <em>Integer Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IntegerLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIntegerLiteralExpAS()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP_AS = 13;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_AS__IS_MARKED_PRE = PRIMITIVE_LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_AS__PARENT = PRIMITIVE_LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_AS__IF_EXP_AS = PRIMITIVE_LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_AS__VALUE = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_AS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LoopExpASImpl <em>Loop Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LoopExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLoopExpAS()
	 * @generated
	 */
	int LOOP_EXP_AS = 19;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__NAME = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__SOURCE = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__BODY = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__ITERATOR = OCL_EXPRESSION_AS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS__RESULT = OCL_EXPRESSION_AS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Loop Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IterateExpASImpl <em>Iterate Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IterateExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIterateExpAS()
	 * @generated
	 */
	int ITERATE_EXP_AS = 14;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__IS_MARKED_PRE = LOOP_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__PARENT = LOOP_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__IF_EXP_AS = LOOP_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__NAME = LOOP_EXP_AS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__SOURCE = LOOP_EXP_AS__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__BODY = LOOP_EXP_AS__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__ITERATOR = LOOP_EXP_AS__ITERATOR;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS__RESULT = LOOP_EXP_AS__RESULT;

	/**
	 * The number of structural features of the '<em>Iterate Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_AS_FEATURE_COUNT = LOOP_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IteratorExpASImpl <em>Iterator Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IteratorExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIteratorExpAS()
	 * @generated
	 */
	int ITERATOR_EXP_AS = 15;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__IS_MARKED_PRE = LOOP_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__PARENT = LOOP_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__IF_EXP_AS = LOOP_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__NAME = LOOP_EXP_AS__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__SOURCE = LOOP_EXP_AS__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__BODY = LOOP_EXP_AS__BODY;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__ITERATOR = LOOP_EXP_AS__ITERATOR;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS__RESULT = LOOP_EXP_AS__RESULT;

	/**
	 * The number of structural features of the '<em>Iterator Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_AS_FEATURE_COUNT = LOOP_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LetExpASImpl <em>Let Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LetExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLetExpAS()
	 * @generated
	 */
	int LET_EXP_AS = 16;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_AS__VARIABLES = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_AS__IN = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.NotExpASImpl <em>Not Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.NotExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getNotExpAS()
	 * @generated
	 */
	int NOT_EXP_AS = 20;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_AS__IS_MARKED_PRE = LOGICAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_AS__PARENT = LOGICAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_AS__IF_EXP_AS = LOGICAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_AS__RIGHT_OPERAND = LOGICAL_EXP_AS__RIGHT_OPERAND;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_AS__LEFT_OPERAND = LOGICAL_EXP_AS__LEFT_OPERAND;

	/**
	 * The number of structural features of the '<em>Not Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_EXP_AS_FEATURE_COUNT = LOGICAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageArgASImpl <em>Ocl Message Arg AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageArgASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclMessageArgAS()
	 * @generated
	 */
	int OCL_MESSAGE_ARG_AS = 22;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_AS__EXPRESSION = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_AS__TYPE = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ocl Message Arg AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageExpASImpl <em>Ocl Message Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclMessageExpAS()
	 * @generated
	 */
	int OCL_MESSAGE_EXP_AS = 23;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__IS_MARKED_PRE = OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__PARENT = OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__IF_EXP_AS = OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__NAME = OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__KIND = OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__ARGUMENTS = OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS__TARGET = OCL_EXPRESSION_AS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ocl Message Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_AS_FEATURE_COUNT = OCL_EXPRESSION_AS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OperationCallExpASImpl <em>Operation Call Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OperationCallExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOperationCallExpAS()
	 * @generated
	 */
	int OPERATION_CALL_EXP_AS = 24;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_AS__IS_MARKED_PRE = CALL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_AS__PARENT = CALL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_AS__IF_EXP_AS = CALL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_AS__ARGUMENTS = CALL_EXP_AS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_AS__SOURCE = CALL_EXP_AS__SOURCE;

	/**
	 * The number of structural features of the '<em>Operation Call Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_AS_FEATURE_COUNT = CALL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OrExpASImpl <em>Or Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OrExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOrExpAS()
	 * @generated
	 */
	int OR_EXP_AS = 25;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_AS__IS_MARKED_PRE = LOGICAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_AS__PARENT = LOGICAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_AS__IF_EXP_AS = LOGICAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_AS__RIGHT_OPERAND = LOGICAL_EXP_AS__RIGHT_OPERAND;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_AS__LEFT_OPERAND = LOGICAL_EXP_AS__LEFT_OPERAND;

	/**
	 * The number of structural features of the '<em>Or Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_EXP_AS_FEATURE_COUNT = LOGICAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.PathNameExpASImpl <em>Path Name Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.PathNameExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getPathNameExpAS()
	 * @generated
	 */
	int PATH_NAME_EXP_AS = 26;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_AS__IS_MARKED_PRE = PRIMARY_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_AS__PARENT = PRIMARY_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_AS__IF_EXP_AS = PRIMARY_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_AS__PATH_NAME = PRIMARY_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Name Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_AS_FEATURE_COUNT = PRIMARY_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.RealLiteralExpASImpl <em>Real Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.RealLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getRealLiteralExpAS()
	 * @generated
	 */
	int REAL_LITERAL_EXP_AS = 29;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_AS__IS_MARKED_PRE = PRIMITIVE_LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_AS__PARENT = PRIMITIVE_LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_AS__IF_EXP_AS = PRIMITIVE_LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_AS__VALUE = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_AS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.StringLiteralExpASImpl <em>String Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.StringLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getStringLiteralExpAS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_AS = 31;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_AS__IS_MARKED_PRE = PRIMITIVE_LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_AS__PARENT = PRIMITIVE_LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_AS__IF_EXP_AS = PRIMITIVE_LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_AS__VALUE = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_AS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.TupleLiteralExpASImpl <em>Tuple Literal Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.TupleLiteralExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getTupleLiteralExpAS()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP_AS = 32;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_AS__IS_MARKED_PRE = LITERAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_AS__PARENT = LITERAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_AS__IF_EXP_AS = LITERAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Tuple Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_AS__TUPLE_PARTS = LITERAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_AS_FEATURE_COUNT = LITERAL_EXP_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.XorExpASImpl <em>Xor Exp AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.XorExpASImpl
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getXorExpAS()
	 * @generated
	 */
	int XOR_EXP_AS = 33;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_AS__IS_MARKED_PRE = LOGICAL_EXP_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_AS__PARENT = LOGICAL_EXP_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_AS__IF_EXP_AS = LOGICAL_EXP_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_AS__RIGHT_OPERAND = LOGICAL_EXP_AS__RIGHT_OPERAND;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_AS__LEFT_OPERAND = LOGICAL_EXP_AS__LEFT_OPERAND;

	/**
	 * The number of structural features of the '<em>Xor Exp AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XOR_EXP_AS_FEATURE_COUNT = LOGICAL_EXP_AS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS <em>Collection Kind AS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionKindAS()
	 * @generated
	 */
	int COLLECTION_KIND_AS = 34;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS <em>Ocl Message Kind AS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS
	 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclMessageKindAS()
	 * @generated
	 */
	int OCL_MESSAGE_KIND_AS = 35;


	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.AndExpAS <em>And Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.AndExpAS
	 * @generated
	 */
	EClass getAndExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.ArrowSelectionExpAS <em>Arrow Selection Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arrow Selection Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ArrowSelectionExpAS
	 * @generated
	 */
	EClass getArrowSelectionExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.AssociationCallExpAS <em>Association Call Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Call Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.AssociationCallExpAS
	 * @generated
	 */
	EClass getAssociationCallExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS <em>Boolean Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS
	 * @generated
	 */
	EClass getBooleanLiteralExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS#getValue()
	 * @see #getBooleanLiteralExpAS()
	 * @generated
	 */
	EAttribute getBooleanLiteralExpAS_Value();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.CallExpAS <em>Call Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CallExpAS
	 * @generated
	 */
	EClass getCallExpAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.CallExpAS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CallExpAS#getSource()
	 * @see #getCallExpAS()
	 * @generated
	 */
	EReference getCallExpAS_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.expressions.CallExpAS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CallExpAS#getArguments()
	 * @see #getCallExpAS()
	 * @generated
	 */
	EReference getCallExpAS_Arguments();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS <em>Collection Item AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS
	 * @generated
	 */
	EClass getCollectionItemAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Item</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS#getItem()
	 * @see #getCollectionItemAS()
	 * @generated
	 */
	EReference getCollectionItemAS_Item();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS <em>Collection Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS
	 * @generated
	 */
	EClass getCollectionLiteralExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getKind()
	 * @see #getCollectionLiteralExpAS()
	 * @generated
	 */
	EAttribute getCollectionLiteralExpAS_Kind();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getCollectionParts <em>Collection Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Collection Parts</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS#getCollectionParts()
	 * @see #getCollectionLiteralExpAS()
	 * @generated
	 */
	EReference getCollectionLiteralExpAS_CollectionParts();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS <em>Collection Literal Part AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS
	 * @generated
	 */
	EClass getCollectionLiteralPartAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS <em>Collection Range AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS
	 * @generated
	 */
	EClass getCollectionRangeAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>First</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getFirst()
	 * @see #getCollectionRangeAS()
	 * @generated
	 */
	EReference getCollectionRangeAS_First();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS#getLast()
	 * @see #getCollectionRangeAS()
	 * @generated
	 */
	EReference getCollectionRangeAS_Last();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS <em>Dot Selection Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dot Selection Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS
	 * @generated
	 */
	EClass getDotSelectionExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS <em>Enum Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS
	 * @generated
	 */
	EClass getEnumLiteralExpAS();

	/**
	 * Returns the meta object for the attribute list '{@link org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS#getPathName()
	 * @see #getEnumLiteralExpAS()
	 * @generated
	 */
	EAttribute getEnumLiteralExpAS_PathName();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS <em>If Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IfExpAS
	 * @generated
	 */
	EClass getIfExpAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Then Expression</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getThenExpression()
	 * @see #getIfExpAS()
	 * @generated
	 */
	EReference getIfExpAS_ThenExpression();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getCondition()
	 * @see #getIfExpAS()
	 * @generated
	 */
	EReference getIfExpAS_Condition();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else Expression</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IfExpAS#getElseExpression()
	 * @see #getIfExpAS()
	 * @generated
	 */
	EReference getIfExpAS_ElseExpression();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.ImpliesExpAS <em>Implies Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implies Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.ImpliesExpAS
	 * @generated
	 */
	EClass getImpliesExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS <em>Integer Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS
	 * @generated
	 */
	EClass getIntegerLiteralExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS#getValue()
	 * @see #getIntegerLiteralExpAS()
	 * @generated
	 */
	EAttribute getIntegerLiteralExpAS_Value();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.IterateExpAS <em>Iterate Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IterateExpAS
	 * @generated
	 */
	EClass getIterateExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.IteratorExpAS <em>Iterator Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.IteratorExpAS
	 * @generated
	 */
	EClass getIteratorExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS <em>Let Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LetExpAS
	 * @generated
	 */
	EClass getLetExpAS();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getVariables()
	 * @see #getLetExpAS()
	 * @generated
	 */
	EReference getLetExpAS_Variables();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LetExpAS#getIn()
	 * @see #getLetExpAS()
	 * @generated
	 */
	EReference getLetExpAS_In();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS <em>Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS
	 * @generated
	 */
	EClass getLiteralExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS <em>Logical Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS
	 * @generated
	 */
	EClass getLogicalExpAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Operand</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS#getRightOperand()
	 * @see #getLogicalExpAS()
	 * @generated
	 */
	EReference getLogicalExpAS_RightOperand();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Operand</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS#getLeftOperand()
	 * @see #getLogicalExpAS()
	 * @generated
	 */
	EReference getLogicalExpAS_LeftOperand();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS <em>Loop Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS
	 * @generated
	 */
	EClass getLoopExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getName()
	 * @see #getLoopExpAS()
	 * @generated
	 */
	EAttribute getLoopExpAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getResult()
	 * @see #getLoopExpAS()
	 * @generated
	 */
	EReference getLoopExpAS_Result();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getBody()
	 * @see #getLoopExpAS()
	 * @generated
	 */
	EReference getLoopExpAS_Body();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getSource()
	 * @see #getLoopExpAS()
	 * @generated
	 */
	EReference getLoopExpAS_Source();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Iterator</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.LoopExpAS#getIterator()
	 * @see #getLoopExpAS()
	 * @generated
	 */
	EReference getLoopExpAS_Iterator();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.NotExpAS <em>Not Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.NotExpAS
	 * @generated
	 */
	EClass getNotExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS <em>Ocl Expression AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Expression AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS
	 * @generated
	 */
	EClass getOclExpressionAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIsMarkedPre <em>Is Marked Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Marked Pre</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIsMarkedPre()
	 * @see #getOclExpressionAS()
	 * @generated
	 */
	EAttribute getOclExpressionAS_IsMarkedPre();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getParent()
	 * @see #getOclExpressionAS()
	 * @generated
	 */
	EReference getOclExpressionAS_Parent();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIfExpAS <em>If Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS#getIfExpAS()
	 * @see #getOclExpressionAS()
	 * @generated
	 */
	EReference getOclExpressionAS_IfExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS <em>Ocl Message Arg AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Message Arg AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS
	 * @generated
	 */
	EClass getOclMessageArgAS();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getType()
	 * @see #getOclMessageArgAS()
	 * @generated
	 */
	EReference getOclMessageArgAS_Type();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS#getExpression()
	 * @see #getOclMessageArgAS()
	 * @generated
	 */
	EReference getOclMessageArgAS_Expression();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS <em>Ocl Message Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Message Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS
	 * @generated
	 */
	EClass getOclMessageExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getName()
	 * @see #getOclMessageExpAS()
	 * @generated
	 */
	EAttribute getOclMessageExpAS_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getKind()
	 * @see #getOclMessageExpAS()
	 * @generated
	 */
	EAttribute getOclMessageExpAS_Kind();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getArguments()
	 * @see #getOclMessageExpAS()
	 * @generated
	 */
	EReference getOclMessageExpAS_Arguments();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS#getTarget()
	 * @see #getOclMessageExpAS()
	 * @generated
	 */
	EReference getOclMessageExpAS_Target();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS <em>Operation Call Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS
	 * @generated
	 */
	EClass getOperationCallExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.OrExpAS <em>Or Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OrExpAS
	 * @generated
	 */
	EClass getOrExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS <em>Path Name Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS
	 * @generated
	 */
	EClass getPathNameExpAS();

	/**
	 * Returns the meta object for the attribute list '{@link org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS#getPathName()
	 * @see #getPathNameExpAS()
	 * @generated
	 */
	EAttribute getPathNameExpAS_PathName();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS <em>Primary Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS
	 * @generated
	 */
	EClass getPrimaryExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.PrimitiveLiteralExpAS <em>Primitive Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.PrimitiveLiteralExpAS
	 * @generated
	 */
	EClass getPrimitiveLiteralExpAS();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS <em>Real Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS
	 * @generated
	 */
	EClass getRealLiteralExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS#getValue()
	 * @see #getRealLiteralExpAS()
	 * @generated
	 */
	EAttribute getRealLiteralExpAS_Value();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS <em>Selection Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS
	 * @generated
	 */
	EClass getSelectionExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getName()
	 * @see #getSelectionExpAS()
	 * @generated
	 */
	EAttribute getSelectionExpAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS#getSource()
	 * @see #getSelectionExpAS()
	 * @generated
	 */
	EReference getSelectionExpAS_Source();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS <em>String Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS
	 * @generated
	 */
	EClass getStringLiteralExpAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS#getValue()
	 * @see #getStringLiteralExpAS()
	 * @generated
	 */
	EAttribute getStringLiteralExpAS_Value();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS <em>Tuple Literal Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS
	 * @generated
	 */
	EClass getTupleLiteralExpAS();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS#getTupleParts <em>Tuple Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tuple Parts</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS#getTupleParts()
	 * @see #getTupleLiteralExpAS()
	 * @generated
	 */
	EReference getTupleLiteralExpAS_TupleParts();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.expressions.XorExpAS <em>Xor Exp AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xor Exp AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.XorExpAS
	 * @generated
	 */
	EClass getXorExpAS();

	/**
	 * Returns the meta object for enum '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS <em>Collection Kind AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
	 * @generated
	 */
	EEnum getCollectionKindAS();

	/**
	 * Returns the meta object for enum '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS <em>Ocl Message Kind AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ocl Message Kind AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS
	 * @generated
	 */
	EEnum getOclMessageKindAS();

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
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.AndExpASImpl <em>And Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.AndExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getAndExpAS()
		 * @generated
		 */
		EClass AND_EXP_AS = eINSTANCE.getAndExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.ArrowSelectionExpASImpl <em>Arrow Selection Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ArrowSelectionExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getArrowSelectionExpAS()
		 * @generated
		 */
		EClass ARROW_SELECTION_EXP_AS = eINSTANCE.getArrowSelectionExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.AssociationCallExpASImpl <em>Association Call Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.AssociationCallExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getAssociationCallExpAS()
		 * @generated
		 */
		EClass ASSOCIATION_CALL_EXP_AS = eINSTANCE.getAssociationCallExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.BooleanLiteralExpASImpl <em>Boolean Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.BooleanLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getBooleanLiteralExpAS()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP_AS = eINSTANCE.getBooleanLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP_AS__VALUE = eINSTANCE.getBooleanLiteralExpAS_Value();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CallExpASImpl <em>Call Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CallExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCallExpAS()
		 * @generated
		 */
		EClass CALL_EXP_AS = eINSTANCE.getCallExpAS();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_AS__ARGUMENTS = eINSTANCE.getCallExpAS_Arguments();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_AS__SOURCE = eINSTANCE.getCallExpAS_Source();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionItemASImpl <em>Collection Item AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionItemASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionItemAS()
		 * @generated
		 */
		EClass COLLECTION_ITEM_AS = eINSTANCE.getCollectionItemAS();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_ITEM_AS__ITEM = eINSTANCE.getCollectionItemAS_Item();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralExpASImpl <em>Collection Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralExpAS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP_AS = eINSTANCE.getCollectionLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP_AS__KIND = eINSTANCE.getCollectionLiteralExpAS_Kind();

		/**
		 * The meta object literal for the '<em><b>Collection Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS = eINSTANCE.getCollectionLiteralExpAS_CollectionParts();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralPartASImpl <em>Collection Literal Part AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionLiteralPartASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralPartAS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART_AS = eINSTANCE.getCollectionLiteralPartAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.CollectionRangeASImpl <em>Collection Range AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.CollectionRangeASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionRangeAS()
		 * @generated
		 */
		EClass COLLECTION_RANGE_AS = eINSTANCE.getCollectionRangeAS();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE_AS__LAST = eINSTANCE.getCollectionRangeAS_Last();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE_AS__FIRST = eINSTANCE.getCollectionRangeAS_First();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.DotSelectionExpASImpl <em>Dot Selection Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.DotSelectionExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getDotSelectionExpAS()
		 * @generated
		 */
		EClass DOT_SELECTION_EXP_AS = eINSTANCE.getDotSelectionExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.EnumLiteralExpASImpl <em>Enum Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.EnumLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getEnumLiteralExpAS()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP_AS = eINSTANCE.getEnumLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_EXP_AS__PATH_NAME = eINSTANCE.getEnumLiteralExpAS_PathName();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IfExpASImpl <em>If Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IfExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIfExpAS()
		 * @generated
		 */
		EClass IF_EXP_AS = eINSTANCE.getIfExpAS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_AS__CONDITION = eINSTANCE.getIfExpAS_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_AS__THEN_EXPRESSION = eINSTANCE.getIfExpAS_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_AS__ELSE_EXPRESSION = eINSTANCE.getIfExpAS_ElseExpression();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.ImpliesExpASImpl <em>Implies Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ImpliesExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getImpliesExpAS()
		 * @generated
		 */
		EClass IMPLIES_EXP_AS = eINSTANCE.getImpliesExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IntegerLiteralExpASImpl <em>Integer Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IntegerLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIntegerLiteralExpAS()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP_AS = eINSTANCE.getIntegerLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP_AS__VALUE = eINSTANCE.getIntegerLiteralExpAS_Value();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IterateExpASImpl <em>Iterate Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IterateExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIterateExpAS()
		 * @generated
		 */
		EClass ITERATE_EXP_AS = eINSTANCE.getIterateExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.IteratorExpASImpl <em>Iterator Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.IteratorExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getIteratorExpAS()
		 * @generated
		 */
		EClass ITERATOR_EXP_AS = eINSTANCE.getIteratorExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LetExpASImpl <em>Let Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LetExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLetExpAS()
		 * @generated
		 */
		EClass LET_EXP_AS = eINSTANCE.getLetExpAS();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_AS__VARIABLES = eINSTANCE.getLetExpAS_Variables();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_AS__IN = eINSTANCE.getLetExpAS_In();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LiteralExpASImpl <em>Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLiteralExpAS()
		 * @generated
		 */
		EClass LITERAL_EXP_AS = eINSTANCE.getLiteralExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LogicalExpASImpl <em>Logical Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LogicalExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLogicalExpAS()
		 * @generated
		 */
		EClass LOGICAL_EXP_AS = eINSTANCE.getLogicalExpAS();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_EXP_AS__RIGHT_OPERAND = eINSTANCE.getLogicalExpAS_RightOperand();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_EXP_AS__LEFT_OPERAND = eINSTANCE.getLogicalExpAS_LeftOperand();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.LoopExpASImpl <em>Loop Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.LoopExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getLoopExpAS()
		 * @generated
		 */
		EClass LOOP_EXP_AS = eINSTANCE.getLoopExpAS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_EXP_AS__NAME = eINSTANCE.getLoopExpAS_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP_AS__SOURCE = eINSTANCE.getLoopExpAS_Source();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP_AS__BODY = eINSTANCE.getLoopExpAS_Body();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP_AS__ITERATOR = eINSTANCE.getLoopExpAS_Iterator();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP_AS__RESULT = eINSTANCE.getLoopExpAS_Result();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.NotExpASImpl <em>Not Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.NotExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getNotExpAS()
		 * @generated
		 */
		EClass NOT_EXP_AS = eINSTANCE.getNotExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl <em>Ocl Expression AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OclExpressionASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclExpressionAS()
		 * @generated
		 */
		EClass OCL_EXPRESSION_AS = eINSTANCE.getOclExpressionAS();

		/**
		 * The meta object literal for the '<em><b>Is Marked Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_EXPRESSION_AS__IS_MARKED_PRE = eINSTANCE.getOclExpressionAS_IsMarkedPre();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_EXPRESSION_AS__PARENT = eINSTANCE.getOclExpressionAS_Parent();

		/**
		 * The meta object literal for the '<em><b>If Exp AS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_EXPRESSION_AS__IF_EXP_AS = eINSTANCE.getOclExpressionAS_IfExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageArgASImpl <em>Ocl Message Arg AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageArgASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclMessageArgAS()
		 * @generated
		 */
		EClass OCL_MESSAGE_ARG_AS = eINSTANCE.getOclMessageArgAS();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_ARG_AS__EXPRESSION = eINSTANCE.getOclMessageArgAS_Expression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_ARG_AS__TYPE = eINSTANCE.getOclMessageArgAS_Type();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageExpASImpl <em>Ocl Message Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OclMessageExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclMessageExpAS()
		 * @generated
		 */
		EClass OCL_MESSAGE_EXP_AS = eINSTANCE.getOclMessageExpAS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_MESSAGE_EXP_AS__NAME = eINSTANCE.getOclMessageExpAS_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OCL_MESSAGE_EXP_AS__KIND = eINSTANCE.getOclMessageExpAS_Kind();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_EXP_AS__ARGUMENTS = eINSTANCE.getOclMessageExpAS_Arguments();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OCL_MESSAGE_EXP_AS__TARGET = eINSTANCE.getOclMessageExpAS_Target();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OperationCallExpASImpl <em>Operation Call Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OperationCallExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOperationCallExpAS()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP_AS = eINSTANCE.getOperationCallExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.OrExpASImpl <em>Or Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.OrExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOrExpAS()
		 * @generated
		 */
		EClass OR_EXP_AS = eINSTANCE.getOrExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.PathNameExpASImpl <em>Path Name Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.PathNameExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getPathNameExpAS()
		 * @generated
		 */
		EClass PATH_NAME_EXP_AS = eINSTANCE.getPathNameExpAS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATH_NAME_EXP_AS__PATH_NAME = eINSTANCE.getPathNameExpAS_PathName();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.PrimaryExpASImpl <em>Primary Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.PrimaryExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getPrimaryExpAS()
		 * @generated
		 */
		EClass PRIMARY_EXP_AS = eINSTANCE.getPrimaryExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.PrimitiveLiteralExpASImpl <em>Primitive Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.PrimitiveLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getPrimitiveLiteralExpAS()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP_AS = eINSTANCE.getPrimitiveLiteralExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.RealLiteralExpASImpl <em>Real Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.RealLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getRealLiteralExpAS()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP_AS = eINSTANCE.getRealLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP_AS__VALUE = eINSTANCE.getRealLiteralExpAS_Value();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.SelectionExpASImpl <em>Selection Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.SelectionExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getSelectionExpAS()
		 * @generated
		 */
		EClass SELECTION_EXP_AS = eINSTANCE.getSelectionExpAS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION_EXP_AS__NAME = eINSTANCE.getSelectionExpAS_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_EXP_AS__SOURCE = eINSTANCE.getSelectionExpAS_Source();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.StringLiteralExpASImpl <em>String Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.StringLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getStringLiteralExpAS()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP_AS = eINSTANCE.getStringLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP_AS__VALUE = eINSTANCE.getStringLiteralExpAS_Value();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.TupleLiteralExpASImpl <em>Tuple Literal Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.TupleLiteralExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getTupleLiteralExpAS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP_AS = eINSTANCE.getTupleLiteralExpAS();

		/**
		 * The meta object literal for the '<em><b>Tuple Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP_AS__TUPLE_PARTS = eINSTANCE.getTupleLiteralExpAS_TupleParts();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.impl.XorExpASImpl <em>Xor Exp AS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.XorExpASImpl
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getXorExpAS()
		 * @generated
		 */
		EClass XOR_EXP_AS = eINSTANCE.getXorExpAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS <em>Collection Kind AS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getCollectionKindAS()
		 * @generated
		 */
		EEnum COLLECTION_KIND_AS = eINSTANCE.getCollectionKindAS();

		/**
		 * The meta object literal for the '{@link org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS <em>Ocl Message Kind AS</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS
		 * @see org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl#getOclMessageKindAS()
		 * @generated
		 */
		EEnum OCL_MESSAGE_KIND_AS = eINSTANCE.getOclMessageKindAS();

	}

} //ExpressionsPackage
