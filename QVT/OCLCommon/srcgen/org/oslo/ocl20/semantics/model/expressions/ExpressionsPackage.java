/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "urn:semantics.model.expressions.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "semantics.model.expressions";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl
	 * <em>Ocl Expression</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOclExpression()
	 * @generated
	 */
	int OCL_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TAG = BridgePackage.MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__NAME = BridgePackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__IS_MARKED_PRE = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__LOOP_EXP = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__OPERATION_CALL_EXP = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__PROPERTY_CALL_EXP = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TYPE = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__APPLIED_PROPERTY = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__INITIALISED_VARIABLE = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Ocl Expression</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_FEATURE_COUNT = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.LiteralExpImpl <em>Literal Exp</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.LiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getLiteralExp()
	 * @generated
	 */
	int LITERAL_EXP = 12;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The number of structural features of the '<em>Literal Exp</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.BooleanLiteralExpImpl
	 * <em>Boolean Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.BooleanLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getBooleanLiteralExp()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Boolean Symbol</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CallExpImpl <em>Call Exp</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.CallExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCallExp()
	 * @generated
	 */
	int CALL_EXP = 1;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Exp</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralPartImpl
	 * <em>Collection Literal Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralPartImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralPart()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART = 4;

	/**
	 * The feature id for the '<em><b>Collection Literal Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART__TYPE = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Part</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_FEATURE_COUNT = SemanticsPackage.SEMANTICS_VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionItemImpl
	 * <em>Collection Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionItemImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionItem()
	 * @generated
	 */
	int COLLECTION_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Collection Literal Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__COLLECTION_LITERAL_EXP = COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>Item</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM__ITEM = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Item</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_ITEM_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralExpImpl
	 * <em>Collection Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralExp()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__KIND = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP__PARTS = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionRangeImpl
	 * <em>Collection Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionRangeImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionRange()
	 * @generated
	 */
	int COLLECTION_RANGE = 5;

	/**
	 * The feature id for the '<em><b>Collection Literal Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__COLLECTION_LITERAL_EXP = COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__TYPE = COLLECTION_LITERAL_PART__TYPE;

	/**
	 * The feature id for the '<em><b>Last</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__LAST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE__FIRST = COLLECTION_LITERAL_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Range</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_FEATURE_COUNT = COLLECTION_LITERAL_PART_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.EnumLiteralExpImpl
	 * <em>Enum Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.EnumLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getEnumLiteralExp()
	 * @generated
	 */
	int ENUM_LITERAL_EXP = 6;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Referred Enum Literal</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.expressions.impl.IfExpImpl
	 * <em>If Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.IfExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIfExp()
	 * @generated
	 */
	int IF_EXP = 7;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__ELSE_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__THEN_EXPRESSION = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP__CONDITION = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IF_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.NumericalLiteralExpImpl
	 * <em>Numerical Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.NumericalLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getNumericalLiteralExp()
	 * @generated
	 */
	int NUMERICAL_LITERAL_EXP = 15;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The number of structural features of the '<em>Numerical Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IntegerLiteralExpImpl
	 * <em>Integer Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.IntegerLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIntegerLiteralExp()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP = 8;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__TAG = NUMERICAL_LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__NAME = NUMERICAL_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__IS_MARKED_PRE = NUMERICAL_LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__LOOP_EXP = NUMERICAL_LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__OPERATION_CALL_EXP = NUMERICAL_LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__PROPERTY_CALL_EXP = NUMERICAL_LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__TYPE = NUMERICAL_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__APPLIED_PROPERTY = NUMERICAL_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INITIALISED_VARIABLE = NUMERICAL_LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP__INTEGER_SYMBOL = NUMERICAL_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_FEATURE_COUNT = NUMERICAL_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.LoopExpImpl <em>Loop Exp</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.LoopExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getLoopExp()
	 * @generated
	 */
	int LOOP_EXP = 13;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__TAG = CALL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__IS_MARKED_PRE = CALL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__LOOP_EXP = CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__OPERATION_CALL_EXP = CALL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__PROPERTY_CALL_EXP = CALL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__APPLIED_PROPERTY = CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__INITIALISED_VARIABLE = CALL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__BODY = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP__ITERATORS = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop Exp</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOOP_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IterateExpImpl <em>Iterate Exp</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.IterateExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIterateExp()
	 * @generated
	 */
	int ITERATE_EXP = 9;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__TAG = LOOP_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__IS_MARKED_PRE = LOOP_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__LOOP_EXP = LOOP_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__OPERATION_CALL_EXP = LOOP_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__PROPERTY_CALL_EXP = LOOP_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__APPLIED_PROPERTY = LOOP_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__INITIALISED_VARIABLE = LOOP_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__ITERATORS = LOOP_EXP__ITERATORS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP__RESULT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iterate Exp</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATE_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IteratorExpImpl <em>Iterator Exp</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.IteratorExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIteratorExp()
	 * @generated
	 */
	int ITERATOR_EXP = 10;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__TAG = LOOP_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__NAME = LOOP_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__IS_MARKED_PRE = LOOP_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__LOOP_EXP = LOOP_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__OPERATION_CALL_EXP = LOOP_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__PROPERTY_CALL_EXP = LOOP_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__TYPE = LOOP_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__APPLIED_PROPERTY = LOOP_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__INITIALISED_VARIABLE = LOOP_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__SOURCE = LOOP_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__BODY = LOOP_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP__ITERATORS = LOOP_EXP__ITERATORS;

	/**
	 * The number of structural features of the '<em>Iterator Exp</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITERATOR_EXP_FEATURE_COUNT = LOOP_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.LetExpImpl <em>Let Exp</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.LetExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getLetExp()
	 * @generated
	 */
	int LET_EXP = 11;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__IN = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP__VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LET_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.ModelPropertyCallExpImpl
	 * <em>Model Property Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ModelPropertyCallExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getModelPropertyCallExp()
	 * @generated
	 */
	int MODEL_PROPERTY_CALL_EXP = 14;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__TAG = CALL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__NAME = CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__IS_MARKED_PRE = CALL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__LOOP_EXP = CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__OPERATION_CALL_EXP = CALL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__PROPERTY_CALL_EXP = CALL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY = CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__INITIALISED_VARIABLE = CALL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP__SOURCE = CALL_EXP__SOURCE;

	/**
	 * The number of structural features of the '<em>Model Property Call Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclMessageArgImpl
	 * <em>Ocl Message Arg</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.OclMessageArgImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOclMessageArg()
	 * @generated
	 */
	int OCL_MESSAGE_ARG = 17;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Unspecified</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG__UNSPECIFIED = 1;

	/**
	 * The number of structural features of the '<em>Ocl Message Arg</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_ARG_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclMessageExpImpl
	 * <em>Ocl Message Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.OclMessageExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOclMessageExp()
	 * @generated
	 */
	int OCL_MESSAGE_EXP = 18;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__ARGUMENTS = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP__TARGET = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ocl Message Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OCL_MESSAGE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OperationCallExpImpl
	 * <em>Operation Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.OperationCallExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 19;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TAG = MODEL_PROPERTY_CALL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__NAME = MODEL_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__IS_MARKED_PRE = MODEL_PROPERTY_CALL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__LOOP_EXP = MODEL_PROPERTY_CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OPERATION_CALL_EXP = MODEL_PROPERTY_CALL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__PROPERTY_CALL_EXP = MODEL_PROPERTY_CALL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TYPE = MODEL_PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__APPLIED_PROPERTY = MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__INITIALISED_VARIABLE = MODEL_PROPERTY_CALL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__SOURCE = MODEL_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__ARGUMENTS = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Call Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.PropertyCallExpImpl
	 * <em>Property Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.PropertyCallExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getPropertyCallExp()
	 * @generated
	 */
	int PROPERTY_CALL_EXP = 20;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TAG = MODEL_PROPERTY_CALL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__NAME = MODEL_PROPERTY_CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__IS_MARKED_PRE = MODEL_PROPERTY_CALL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__LOOP_EXP = MODEL_PROPERTY_CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OPERATION_CALL_EXP = MODEL_PROPERTY_CALL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__PROPERTY_CALL_EXP = MODEL_PROPERTY_CALL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TYPE = MODEL_PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__APPLIED_PROPERTY = MODEL_PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__INITIALISED_VARIABLE = MODEL_PROPERTY_CALL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__SOURCE = MODEL_PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Qualifiers</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__QUALIFIERS = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Call Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = MODEL_PROPERTY_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.RealLiteralExpImpl
	 * <em>Real Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.RealLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getRealLiteralExp()
	 * @generated
	 */
	int REAL_LITERAL_EXP = 21;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__TAG = NUMERICAL_LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__NAME = NUMERICAL_LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__IS_MARKED_PRE = NUMERICAL_LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__LOOP_EXP = NUMERICAL_LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__OPERATION_CALL_EXP = NUMERICAL_LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__PROPERTY_CALL_EXP = NUMERICAL_LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__TYPE = NUMERICAL_LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__APPLIED_PROPERTY = NUMERICAL_LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__INITIALISED_VARIABLE = NUMERICAL_LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP__REAL_SYMBOL = NUMERICAL_LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_FEATURE_COUNT = NUMERICAL_LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.StringLiteralExpImpl
	 * <em>String Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.StringLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getStringLiteralExp()
	 * @generated
	 */
	int STRING_LITERAL_EXP = 22;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP__STRING_SYMBOL = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.TupleLiteralExpImpl
	 * <em>Tuple Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.TupleLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getTupleLiteralExp()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP = 23;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Tuple Part</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP__TUPLE_PART = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.TypeLiteralExpImpl
	 * <em>Type Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.TypeLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getTypeLiteralExp()
	 * @generated
	 */
	int TYPE_LITERAL_EXP = 24;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Literal Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP__LITERAL_TYPE = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.UndefinedLiteralExpImpl
	 * <em>Undefined Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.UndefinedLiteralExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getUndefinedLiteralExp()
	 * @generated
	 */
	int UNDEFINED_LITERAL_EXP = 25;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__TAG = LITERAL_EXP__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__NAME = LITERAL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__IS_MARKED_PRE = LITERAL_EXP__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__LOOP_EXP = LITERAL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__OPERATION_CALL_EXP = LITERAL_EXP__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__PROPERTY_CALL_EXP = LITERAL_EXP__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__TYPE = LITERAL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__APPLIED_PROPERTY = LITERAL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP__INITIALISED_VARIABLE = LITERAL_EXP__INITIALISED_VARIABLE;

	/**
	 * The number of structural features of the '<em>Undefined Literal Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNDEFINED_LITERAL_EXP_FEATURE_COUNT = LITERAL_EXP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.UnspecifiedValueExpImpl
	 * <em>Unspecified Value Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.UnspecifiedValueExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getUnspecifiedValueExp()
	 * @generated
	 */
	int UNSPECIFIED_VALUE_EXP = 26;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The number of structural features of the '<em>Unspecified Value Exp</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNSPECIFIED_VALUE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.VariableDeclarationImpl
	 * <em>Variable Declaration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.VariableDeclarationImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 27;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TAG = BridgePackage.MODEL_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = BridgePackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Variable Exps</b></em>' reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VARIABLE_EXPS = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tuple Literal Exp</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TUPLE_LITERAL_EXP = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Loop Expr</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__LOOP_EXPR = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__BASE_EXP = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INIT_EXPRESSION = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = BridgePackage.MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.impl.VariableExpImpl <em>Variable Exp</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.VariableExpImpl
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 28;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TAG = OCL_EXPRESSION__TAG;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__NAME = OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__IS_MARKED_PRE = OCL_EXPRESSION__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__LOOP_EXP = OCL_EXPRESSION__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__OPERATION_CALL_EXP = OCL_EXPRESSION__OPERATION_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Property Call Exp</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__PROPERTY_CALL_EXP = OCL_EXPRESSION__PROPERTY_CALL_EXP;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__APPLIED_PROPERTY = OCL_EXPRESSION__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Initialised Variable</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__INITIALISED_VARIABLE = OCL_EXPRESSION__INITIALISED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.semantics.model.expressions.CollectionKind
	 * <em>Collection Kind</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionKind
	 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionKind()
	 * @generated
	 */
	int COLLECTION_KIND = 29;

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp
	 * <em>Boolean Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp#isBooleanSymbol
	 * <em>Boolean Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp#isBooleanSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.expressions.CallExp
	 * <em>Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CallExp#getSource <em>Source</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CallExp#getSource()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_Source();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionItem
	 * @generated
	 */
	EClass getCollectionItem();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionItem#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Item</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionItem#getItem()
	 * @see #getCollectionItem()
	 * @generated
	 */
	EReference getCollectionItem_Item();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp
	 * <em>Collection Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getKind <em>Kind</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getKind()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EAttribute getCollectionLiteralExp_Kind();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getParts
	 * <em>Parts</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getParts()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EReference getCollectionLiteralExp_Parts();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart
	 * <em>Collection Literal Part</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart
	 * @generated
	 */
	EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getCollectionLiteralExp
	 * <em>Collection Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Collection Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getCollectionLiteralExp()
	 * @see #getCollectionLiteralPart()
	 * @generated
	 */
	EReference getCollectionLiteralPart_CollectionLiteralExp();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getType
	 * <em>Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getType()
	 * @see #getCollectionLiteralPart()
	 * @generated
	 */
	EReference getCollectionLiteralPart_Type();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionRange <em>Collection Range</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionRange
	 * @generated
	 */
	EClass getCollectionRange();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionRange#getLast <em>Last</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Last</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionRange#getLast()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_Last();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionRange#getFirst <em>First</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>First</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionRange#getFirst()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_First();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp <em>Enum Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Enum Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp
	 * @generated
	 */
	EClass getEnumLiteralExp();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp#getReferredEnumLiteral
	 * <em>Referred Enum Literal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Enum Literal</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp#getReferredEnumLiteral()
	 * @see #getEnumLiteralExp()
	 * @generated
	 */
	EReference getEnumLiteralExp_ReferredEnumLiteral();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.expressions.IfExp
	 * <em>If Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>If Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IfExp
	 * @generated
	 */
	EClass getIfExp();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IfExp#getElseExpression
	 * <em>Else Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IfExp#getElseExpression()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_ElseExpression();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IfExp#getThenExpression
	 * <em>Then Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IfExp#getThenExpression()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IfExp#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IfExp#getCondition()
	 * @see #getIfExp()
	 * @generated
	 */
	EReference getIfExp_Condition();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp
	 * <em>Integer Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp#getIntegerSymbol
	 * <em>Integer Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IterateExp <em>Iterate Exp</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Iterate Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IterateExp
	 * @generated
	 */
	EClass getIterateExp();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IterateExp#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IterateExp#getResult()
	 * @see #getIterateExp()
	 * @generated
	 */
	EReference getIterateExp_Result();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.IteratorExp <em>Iterator Exp</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Iterator Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.IteratorExp
	 * @generated
	 */
	EClass getIteratorExp();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.expressions.LetExp
	 * <em>Let Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LetExp#getIn <em>In</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LetExp#getIn()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_In();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LetExp#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LetExp#getVariable()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_Variable();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LiteralExp <em>Literal Exp</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.semantics.model.expressions.LoopExp
	 * <em>Loop Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Loop Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LoopExp
	 * @generated
	 */
	EClass getLoopExp();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LoopExp#getBody <em>Body</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LoopExp#getBody()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_Body();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.LoopExp#getIterators <em>Iterators</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Iterators</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.LoopExp#getIterators()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_Iterators();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.ModelPropertyCallExp
	 * <em>Model Property Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Model Property Call Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.ModelPropertyCallExp
	 * @generated
	 */
	EClass getModelPropertyCallExp();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.NumericalLiteralExp
	 * <em>Numerical Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Numerical Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.NumericalLiteralExp
	 * @generated
	 */
	EClass getNumericalLiteralExp();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Expression</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression
	 * @generated
	 */
	EClass getOclExpression();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#isIsMarkedPre
	 * <em>Is Marked Pre</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Marked Pre</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#isIsMarkedPre()
	 * @see #getOclExpression()
	 * @generated
	 */
	EAttribute getOclExpression_IsMarkedPre();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getLoopExp <em>Loop Exp</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Loop Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getLoopExp()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_LoopExp();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getOperationCallExp
	 * <em>Operation Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Operation Call Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getOperationCallExp()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_OperationCallExp();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getPropertyCallExp
	 * <em>Property Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Property Call Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getPropertyCallExp()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_PropertyCallExp();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getType <em>Type</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getType()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_Type();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getAppliedProperty
	 * <em>Applied Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Applied Property</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getAppliedProperty()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_AppliedProperty();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getInitialisedVariable
	 * <em>Initialised Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Initialised Variable</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getInitialisedVariable()
	 * @see #getOclExpression()
	 * @generated
	 */
	EReference getOclExpression_InitialisedVariable();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg <em>Ocl Message Arg</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Message Arg</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageArg
	 * @generated
	 */
	EClass getOclMessageArg();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getExpression
	 * <em>Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getExpression()
	 * @see #getOclMessageArg()
	 * @generated
	 */
	EReference getOclMessageArg_Expression();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getUnspecified
	 * <em>Unspecified</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Unspecified</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageArg#getUnspecified()
	 * @see #getOclMessageArg()
	 * @generated
	 */
	EReference getOclMessageArg_Unspecified();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp <em>Ocl Message Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ocl Message Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageExp
	 * @generated
	 */
	EClass getOclMessageExp();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getArguments
	 * <em>Arguments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getArguments()
	 * @see #getOclMessageExp()
	 * @generated
	 */
	EReference getOclMessageExp_Arguments();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OclMessageExp#getTarget()
	 * @see #getOclMessageExp()
	 * @generated
	 */
	EReference getOclMessageExp_Target();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp
	 * <em>Operation Call Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getReferredOperation
	 * <em>Referred Operation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getArguments
	 * <em>Arguments</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getArguments()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_Arguments();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp <em>Property Call Exp</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getQualifiers
	 * <em>Qualifiers</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Qualifiers</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getQualifiers()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_Qualifiers();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getReferredProperty
	 * <em>Referred Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getReferredProperty()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.RealLiteralExp <em>Real Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Real Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.RealLiteralExp
	 * @generated
	 */
	EClass getRealLiteralExp();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.expressions.RealLiteralExp#getRealSymbol
	 * <em>Real Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.RealLiteralExp#getRealSymbol()
	 * @see #getRealLiteralExp()
	 * @generated
	 */
	EAttribute getRealLiteralExp_RealSymbol();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.StringLiteralExp
	 * <em>String Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>String Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.StringLiteralExp
	 * @generated
	 */
	EClass getStringLiteralExp();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.oslo.ocl20.semantics.model.expressions.StringLiteralExp#getStringSymbol
	 * <em>String Symbol</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>String Symbol</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.StringLiteralExp#getStringSymbol()
	 * @see #getStringLiteralExp()
	 * @generated
	 */
	EAttribute getStringLiteralExp_StringSymbol();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp <em>Tuple Literal Exp</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tuple Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp
	 * @generated
	 */
	EClass getTupleLiteralExp();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp#getTuplePart
	 * <em>Tuple Part</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Tuple Part</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp#getTuplePart()
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
	EReference getTupleLiteralExp_TuplePart();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp <em>Type Literal Exp</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Type Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp
	 * @generated
	 */
	EClass getTypeLiteralExp();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp#getLiteralType
	 * <em>Literal Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Literal Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp#getLiteralType()
	 * @see #getTypeLiteralExp()
	 * @generated
	 */
	EReference getTypeLiteralExp_LiteralType();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp
	 * <em>Undefined Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Undefined Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp
	 * @generated
	 */
	EClass getUndefinedLiteralExp();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp
	 * <em>Unspecified Value Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Unspecified Value Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp
	 * @generated
	 */
	EClass getUnspecifiedValueExp();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration
	 * <em>Variable Declaration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the reference list '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getVariableExps
	 * <em>Variable Exps</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Variable Exps</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getVariableExps()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_VariableExps();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getTupleLiteralExp
	 * <em>Tuple Literal Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Tuple Literal Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getTupleLiteralExp()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_TupleLiteralExp();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getLoopExpr
	 * <em>Loop Expr</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Loop Expr</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getLoopExpr()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_LoopExpr();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getType <em>Type</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Type();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getBaseExp
	 * <em>Base Exp</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Base Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getBaseExp()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_BaseExp();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getInitExpression
	 * <em>Init Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getInitExpression()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_InitExpression();

	/**
	 * Returns the meta object for class '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableExp <em>Variable Exp</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableExp#getReferredVariable
	 * <em>Referred Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for enum '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionKind
	 * @generated
	 */
	EEnum getCollectionKind();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.BooleanLiteralExpImpl
		 * <em>Boolean Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.BooleanLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExp_BooleanSymbol();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CallExpImpl <em>Call Exp</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.CallExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CALL_EXP__SOURCE = eINSTANCE.getCallExp_Source();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionItemImpl
		 * <em>Collection Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionItemImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionItem()
		 * @generated
		 */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_ITEM__ITEM = eINSTANCE.getCollectionItem_Item();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralExpImpl
		 * <em>Collection Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP__KIND = eINSTANCE.getCollectionLiteralExp_Kind();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP__PARTS = eINSTANCE.getCollectionLiteralExp_Parts();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralPartImpl
		 * <em>Collection Literal Part</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionLiteralPartImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionLiteralPart()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
		 * The meta object literal for the '<em><b>Collection Literal Exp</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP = eINSTANCE
		        .getCollectionLiteralPart_CollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART__TYPE = eINSTANCE.getCollectionLiteralPart_Type();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.CollectionRangeImpl
		 * <em>Collection Range</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.CollectionRangeImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionRange()
		 * @generated
		 */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
		 * The meta object literal for the '<em><b>Last</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_RANGE__LAST = eINSTANCE.getCollectionRange_Last();

		/**
		 * The meta object literal for the '<em><b>First</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLLECTION_RANGE__FIRST = eINSTANCE.getCollectionRange_First();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.EnumLiteralExpImpl
		 * <em>Enum Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.EnumLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getEnumLiteralExp()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXP = eINSTANCE.getEnumLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Referred Enum Literal</b></em>' reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL = eINSTANCE.getEnumLiteralExp_ReferredEnumLiteral();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IfExpImpl <em>If Exp</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.IfExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIfExp()
		 * @generated
		 */
		EClass IF_EXP = eINSTANCE.getIfExp();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IF_EXP__ELSE_EXPRESSION = eINSTANCE.getIfExp_ElseExpression();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IF_EXP__THEN_EXPRESSION = eINSTANCE.getIfExp_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference IF_EXP__CONDITION = eINSTANCE.getIfExp_Condition();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IntegerLiteralExpImpl
		 * <em>Integer Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.IntegerLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IterateExpImpl
		 * <em>Iterate Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.IterateExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIterateExp()
		 * @generated
		 */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ITERATE_EXP__RESULT = eINSTANCE.getIterateExp_Result();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.IteratorExpImpl
		 * <em>Iterator Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.IteratorExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getIteratorExp()
		 * @generated
		 */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.LetExpImpl <em>Let Exp</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.LetExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LET_EXP__IN = eINSTANCE.getLetExp_In();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LET_EXP__VARIABLE = eINSTANCE.getLetExp_Variable();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.LiteralExpImpl
		 * <em>Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.LiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.LoopExpImpl <em>Loop Exp</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.LoopExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getLoopExp()
		 * @generated
		 */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOOP_EXP__BODY = eINSTANCE.getLoopExp_Body();

		/**
		 * The meta object literal for the '<em><b>Iterators</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference LOOP_EXP__ITERATORS = eINSTANCE.getLoopExp_Iterators();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.ModelPropertyCallExpImpl
		 * <em>Model Property Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ModelPropertyCallExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getModelPropertyCallExp()
		 * @generated
		 */
		EClass MODEL_PROPERTY_CALL_EXP = eINSTANCE.getModelPropertyCallExp();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.NumericalLiteralExpImpl
		 * <em>Numerical Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.NumericalLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getNumericalLiteralExp()
		 * @generated
		 */
		EClass NUMERICAL_LITERAL_EXP = eINSTANCE.getNumericalLiteralExp();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl
		 * <em>Ocl Expression</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.OclExpressionImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOclExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOclExpression();

		/**
		 * The meta object literal for the '<em><b>Is Marked Pre</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OCL_EXPRESSION__IS_MARKED_PRE = eINSTANCE.getOclExpression_IsMarkedPre();

		/**
		 * The meta object literal for the '<em><b>Loop Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_EXPRESSION__LOOP_EXP = eINSTANCE.getOclExpression_LoopExp();

		/**
		 * The meta object literal for the '<em><b>Operation Call Exp</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_EXPRESSION__OPERATION_CALL_EXP = eINSTANCE.getOclExpression_OperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Property Call Exp</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_EXPRESSION__PROPERTY_CALL_EXP = eINSTANCE.getOclExpression_PropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_EXPRESSION__TYPE = eINSTANCE.getOclExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Applied Property</b></em>' container reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_EXPRESSION__APPLIED_PROPERTY = eINSTANCE.getOclExpression_AppliedProperty();

		/**
		 * The meta object literal for the '<em><b>Initialised Variable</b></em>' container
		 * reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_EXPRESSION__INITIALISED_VARIABLE = eINSTANCE.getOclExpression_InitialisedVariable();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclMessageArgImpl
		 * <em>Ocl Message Arg</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.OclMessageArgImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOclMessageArg()
		 * @generated
		 */
		EClass OCL_MESSAGE_ARG = eINSTANCE.getOclMessageArg();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_MESSAGE_ARG__EXPRESSION = eINSTANCE.getOclMessageArg_Expression();

		/**
		 * The meta object literal for the '<em><b>Unspecified</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_MESSAGE_ARG__UNSPECIFIED = eINSTANCE.getOclMessageArg_Unspecified();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OclMessageExpImpl
		 * <em>Ocl Message Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.OclMessageExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOclMessageExp()
		 * @generated
		 */
		EClass OCL_MESSAGE_EXP = eINSTANCE.getOclMessageExp();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_MESSAGE_EXP__ARGUMENTS = eINSTANCE.getOclMessageExp_Arguments();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OCL_MESSAGE_EXP__TARGET = eINSTANCE.getOclMessageExp_Target();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.OperationCallExpImpl
		 * <em>Operation Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.OperationCallExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__ARGUMENTS = eINSTANCE.getOperationCallExp_Arguments();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.PropertyCallExpImpl
		 * <em>Property Call Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.PropertyCallExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Qualifiers</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__QUALIFIERS = eINSTANCE.getPropertyCallExp_Qualifiers();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.RealLiteralExpImpl
		 * <em>Real Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.RealLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getRealLiteralExp()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP = eINSTANCE.getRealLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP__REAL_SYMBOL = eINSTANCE.getRealLiteralExp_RealSymbol();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.StringLiteralExpImpl
		 * <em>String Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.StringLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getStringLiteralExp()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP = eINSTANCE.getStringLiteralExp();

		/**
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP__STRING_SYMBOL = eINSTANCE.getStringLiteralExp_StringSymbol();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.TupleLiteralExpImpl
		 * <em>Tuple Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.TupleLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getTupleLiteralExp()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP = eINSTANCE.getTupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Tuple Part</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP__TUPLE_PART = eINSTANCE.getTupleLiteralExp_TuplePart();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.TypeLiteralExpImpl
		 * <em>Type Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.TypeLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getTypeLiteralExp()
		 * @generated
		 */
		EClass TYPE_LITERAL_EXP = eINSTANCE.getTypeLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Literal Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TYPE_LITERAL_EXP__LITERAL_TYPE = eINSTANCE.getTypeLiteralExp_LiteralType();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.UndefinedLiteralExpImpl
		 * <em>Undefined Literal Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.UndefinedLiteralExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getUndefinedLiteralExp()
		 * @generated
		 */
		EClass UNDEFINED_LITERAL_EXP = eINSTANCE.getUndefinedLiteralExp();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.UnspecifiedValueExpImpl
		 * <em>Unspecified Value Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.UnspecifiedValueExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getUnspecifiedValueExp()
		 * @generated
		 */
		EClass UNSPECIFIED_VALUE_EXP = eINSTANCE.getUnspecifiedValueExp();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.VariableDeclarationImpl
		 * <em>Variable Declaration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.VariableDeclarationImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Variable Exps</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__VARIABLE_EXPS = eINSTANCE.getVariableDeclaration_VariableExps();

		/**
		 * The meta object literal for the '<em><b>Tuple Literal Exp</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TUPLE_LITERAL_EXP = eINSTANCE.getVariableDeclaration_TupleLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Loop Expr</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__LOOP_EXPR = eINSTANCE.getVariableDeclaration_LoopExpr();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Base Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__BASE_EXP = eINSTANCE.getVariableDeclaration_BaseExp();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INIT_EXPRESSION = eINSTANCE.getVariableDeclaration_InitExpression();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.impl.VariableExpImpl
		 * <em>Variable Exp</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.VariableExpImpl
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '
		 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionKind
		 * <em>Collection Kind</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.oslo.ocl20.semantics.model.expressions.CollectionKind
		 * @see org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl#getCollectionKind()
		 * @generated
		 */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

	}

} // ExpressionsPackage
