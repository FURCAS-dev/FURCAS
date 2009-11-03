/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.oslo.ocl20.syntax.ast.AstPackage;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;

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
 * @see org.oslo.ocl20.syntax.ast.qvt.QvtFactory
 * @model kind="package"
 * @generated
 */
public interface QvtPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:ast.qvt.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ast.qvt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QvtPackage eINSTANCE = org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.TemplateASImpl <em>Template AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.TemplateASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getTemplateAS()
	 * @generated
	 */
	int TEMPLATE_AS = 13;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_AS__IS_MARKED_PRE = ExpressionsPackage.OCL_EXPRESSION_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_AS__PARENT = ExpressionsPackage.OCL_EXPRESSION_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_AS__IF_EXP_AS = ExpressionsPackage.OCL_EXPRESSION_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_AS__NAME = ExpressionsPackage.OCL_EXPRESSION_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_AS__TYPE = ExpressionsPackage.OCL_EXPRESSION_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Template AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_AS_FEATURE_COUNT = ExpressionsPackage.OCL_EXPRESSION_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.CollectionTemplateASImpl <em>Collection Template AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.CollectionTemplateASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getCollectionTemplateAS()
	 * @generated
	 */
	int COLLECTION_TEMPLATE_AS = 0;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__IS_MARKED_PRE = TEMPLATE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__PARENT = TEMPLATE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__IF_EXP_AS = TEMPLATE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__NAME = TEMPLATE_AS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__TYPE = TEMPLATE_AS__TYPE;

	/**
	 * The feature id for the '<em><b>Collection Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__COLLECTION_KIND = TEMPLATE_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Selection Expressions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS = TEMPLATE_AS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expressions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS = TEMPLATE_AS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Set Comprehension Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION = TEMPLATE_AS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the the '<em>Collection Template AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TEMPLATE_AS_FEATURE_COUNT = TEMPLATE_AS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.GeneralDomainASImpl <em>General Domain AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.GeneralDomainASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getGeneralDomainAS()
	 * @generated
	 */
	int GENERAL_DOMAIN_AS = 2;

	/**
	 * The number of structural features of the the '<em>General Domain AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_DOMAIN_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl <em>Domain AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.DomainASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getDomainAS()
	 * @generated
	 */
	int DOMAIN_AS = 1;

	/**
	 * The feature id for the '<em><b>Execution Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__EXECUTION_KIND = GENERAL_DOMAIN_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__MODEL_ID = GENERAL_DOMAIN_AS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__NAME = GENERAL_DOMAIN_AS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implemented By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__IMPLEMENTED_BY = GENERAL_DOMAIN_AS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Property Templates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__PROPERTY_TEMPLATES = GENERAL_DOMAIN_AS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__TYPE = GENERAL_DOMAIN_AS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS__BODY = GENERAL_DOMAIN_AS_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the the '<em>Domain AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_AS_FEATURE_COUNT = GENERAL_DOMAIN_AS_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.KeyDeclarationASImpl <em>Key Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.KeyDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getKeyDeclarationAS()
	 * @generated
	 */
	int KEY_DECLARATION_AS = 3;

	/**
	 * The feature id for the '<em><b>Class Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECLARATION_AS__CLASS_ID = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECLARATION_AS__PROPERTY_IDS = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Key Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.MemberSelectionExpressionASImpl <em>Member Selection Expression AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.MemberSelectionExpressionASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getMemberSelectionExpressionAS()
	 * @generated
	 */
	int MEMBER_SELECTION_EXPRESSION_AS = 4;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Object Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Member Selection Expression AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_SELECTION_EXPRESSION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.ModelDeclarationASImpl <em>Model Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.ModelDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getModelDeclarationAS()
	 * @generated
	 */
	int MODEL_DECLARATION_AS = 5;

	/**
	 * The feature id for the '<em><b>Model Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_AS__MODEL_ID = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Meta Model Ids</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_AS__META_MODEL_IDS = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Model Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.ObjectTemplateASImpl <em>Object Template AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.ObjectTemplateASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getObjectTemplateAS()
	 * @generated
	 */
	int OBJECT_TEMPLATE_AS = 6;

	/**
	 * The feature id for the '<em><b>Is Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS__IS_MARKED_PRE = TEMPLATE_AS__IS_MARKED_PRE;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS__PARENT = TEMPLATE_AS__PARENT;

	/**
	 * The feature id for the '<em><b>If Exp AS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS__IF_EXP_AS = TEMPLATE_AS__IF_EXP_AS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS__NAME = TEMPLATE_AS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS__TYPE = TEMPLATE_AS__TYPE;

	/**
	 * The feature id for the '<em><b>Property Templates</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES = TEMPLATE_AS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the the '<em>Object Template AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TEMPLATE_AS_FEATURE_COUNT = TEMPLATE_AS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.ParameterDeclarationASImpl <em>Parameter Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.ParameterDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getParameterDeclarationAS()
	 * @generated
	 */
	int PARAMETER_DECLARATION_AS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_AS__TYPE = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Parameter Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.PrimitiveDomainASImpl <em>Primitive Domain AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.PrimitiveDomainASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getPrimitiveDomainAS()
	 * @generated
	 */
	int PRIMITIVE_DOMAIN_AS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DOMAIN_AS__NAME = GENERAL_DOMAIN_AS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DOMAIN_AS__TYPE = GENERAL_DOMAIN_AS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Primitive Domain AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DOMAIN_AS_FEATURE_COUNT = GENERAL_DOMAIN_AS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.PropertyTemplateASImpl <em>Property Template AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.PropertyTemplateASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getPropertyTemplateAS()
	 * @generated
	 */
	int PROPERTY_TEMPLATE_AS = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_AS__BODY = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Property Template AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TEMPLATE_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.QueryASImpl <em>Query AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QueryASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getQueryAS()
	 * @generated
	 */
	int QUERY_AS = 10;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_AS__PATH_NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_AS__PARAMETERS = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_AS__TYPE = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_AS__BODY = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the the '<em>Query AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUERY_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl <em>Relation AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.RelationASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getRelationAS()
	 * @generated
	 */
	int RELATION_AS = 11;

	/**
	 * The feature id for the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__IS_TOP_LEVEL = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__OVERRIDES = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Where</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__WHERE = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Variable Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__VARIABLE_DECLARATIONS = AstPackage.VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__DOMAINS = AstPackage.VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>When</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS__WHEN = AstPackage.VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the the '<em>Relation AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.SetComprehensionExpressionASImpl <em>Set Comprehension Expression AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.SetComprehensionExpressionASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getSetComprehensionExpressionAS()
	 * @generated
	 */
	int SET_COMPREHENSION_EXPRESSION_AS = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPREHENSION_EXPRESSION_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the the '<em>Set Comprehension Expression AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPREHENSION_EXPRESSION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.TopLevelASImpl <em>Top Level AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.TopLevelASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getTopLevelAS()
	 * @generated
	 */
	int TOP_LEVEL_AS = 14;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_AS__IMPORTS = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transformations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_AS__TRANSFORMATIONS = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Top Level AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOP_LEVEL_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl <em>Transformation AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.TransformationASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getTransformationAS()
	 * @generated
	 */
	int TRANSFORMATION_AS = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS__NAME = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS__EXTENDS = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS__KEY_DECLARATIONS = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS__RELATIONS = AstPackage.VISITABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Model Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS__MODEL_DECLARATIONS = AstPackage.VISITABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Query</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS__QUERY = AstPackage.VISITABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the the '<em>Transformation AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.impl.VariableDeclarationASImpl <em>Variable Declaration AS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.VariableDeclarationASImpl
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getVariableDeclarationAS()
	 * @generated
	 */
	int VARIABLE_DECLARATION_AS = 16;

	/**
	 * The feature id for the '<em><b>Names</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS__NAMES = AstPackage.VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS__TYPE = AstPackage.VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the the '<em>Variable Declaration AS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_AS_FEATURE_COUNT = AstPackage.VISITABLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS <em>Execution Kind AS</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS
	 * @see org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl#getExecutionKindAS()
	 * @generated
	 */
	int EXECUTION_KIND_AS = 17;


	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS <em>Collection Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Template AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS
	 * @generated
	 */
	EClass getCollectionTemplateAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getCollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Collection Kind</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getCollectionKind()
	 * @see #getCollectionTemplateAS()
	 * @generated
	 */
	EAttribute getCollectionTemplateAS_CollectionKind();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getSetComprehensionExpression <em>Set Comprehension Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Set Comprehension Expression</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getSetComprehensionExpression()
	 * @see #getCollectionTemplateAS()
	 * @generated
	 */
	EReference getCollectionTemplateAS_SetComprehensionExpression();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getOclExpressions <em>Ocl Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ocl Expressions</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getOclExpressions()
	 * @see #getCollectionTemplateAS()
	 * @generated
	 */
	EReference getCollectionTemplateAS_OclExpressions();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getMemberSelectionExpressions <em>Member Selection Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member Selection Expressions</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS#getMemberSelectionExpressions()
	 * @see #getCollectionTemplateAS()
	 * @generated
	 */
	EReference getCollectionTemplateAS_MemberSelectionExpressions();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS <em>Domain AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS
	 * @generated
	 */
	EClass getDomainAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getExecutionKind <em>Execution Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Kind</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getExecutionKind()
	 * @see #getDomainAS()
	 * @generated
	 */
	EAttribute getDomainAS_ExecutionKind();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getModelId <em>Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Id</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getModelId()
	 * @see #getDomainAS()
	 * @generated
	 */
	EAttribute getDomainAS_ModelId();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getName()
	 * @see #getDomainAS()
	 * @generated
	 */
	EAttribute getDomainAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getImplementedBy <em>Implemented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implemented By</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getImplementedBy()
	 * @see #getDomainAS()
	 * @generated
	 */
	EReference getDomainAS_ImplementedBy();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getType()
	 * @see #getDomainAS()
	 * @generated
	 */
	EReference getDomainAS_Type();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getBody()
	 * @see #getDomainAS()
	 * @generated
	 */
	EReference getDomainAS_Body();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS <em>General Domain AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Domain AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS
	 * @generated
	 */
	EClass getGeneralDomainAS();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.DomainAS#getPropertyTemplates <em>Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Templates</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.DomainAS#getPropertyTemplates()
	 * @see #getDomainAS()
	 * @generated
	 */
	EReference getDomainAS_PropertyTemplates();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS <em>Key Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS
	 * @generated
	 */
	EClass getKeyDeclarationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getClassId <em>Class Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Id</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getClassId()
	 * @see #getKeyDeclarationAS()
	 * @generated
	 */
	EAttribute getKeyDeclarationAS_ClassId();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getPropertyIds <em>Property Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property Ids</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS#getPropertyIds()
	 * @see #getKeyDeclarationAS()
	 * @generated
	 */
	EAttribute getKeyDeclarationAS_PropertyIds();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS <em>Member Selection Expression AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member Selection Expression AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS
	 * @generated
	 */
	EClass getMemberSelectionExpressionAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getFirstName()
	 * @see #getMemberSelectionExpressionAS()
	 * @generated
	 */
	EAttribute getMemberSelectionExpressionAS_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getSecondName <em>Second Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getSecondName()
	 * @see #getMemberSelectionExpressionAS()
	 * @generated
	 */
	EAttribute getMemberSelectionExpressionAS_SecondName();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getObjectTemplate <em>Object Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object Template</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS#getObjectTemplate()
	 * @see #getMemberSelectionExpressionAS()
	 * @generated
	 */
	EReference getMemberSelectionExpressionAS_ObjectTemplate();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS <em>Model Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS
	 * @generated
	 */
	EClass getModelDeclarationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getModelId <em>Model Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Id</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getModelId()
	 * @see #getModelDeclarationAS()
	 * @generated
	 */
	EAttribute getModelDeclarationAS_ModelId();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getMetaModelIds <em>Meta Model Ids</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Model Ids</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS#getMetaModelIds()
	 * @see #getModelDeclarationAS()
	 * @generated
	 */
	EAttribute getModelDeclarationAS_MetaModelIds();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS <em>Object Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Template AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS
	 * @generated
	 */
	EClass getObjectTemplateAS();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS#getPropertyTemplates <em>Property Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Property Templates</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS#getPropertyTemplates()
	 * @see #getObjectTemplateAS()
	 * @generated
	 */
	EReference getObjectTemplateAS_PropertyTemplates();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS <em>Parameter Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS
	 * @generated
	 */
	EClass getParameterDeclarationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS#getName()
	 * @see #getParameterDeclarationAS()
	 * @generated
	 */
	EAttribute getParameterDeclarationAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS#getType()
	 * @see #getParameterDeclarationAS()
	 * @generated
	 */
	EReference getParameterDeclarationAS_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS <em>Primitive Domain AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Domain AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS
	 * @generated
	 */
	EClass getPrimitiveDomainAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS#getName()
	 * @see #getPrimitiveDomainAS()
	 * @generated
	 */
	EAttribute getPrimitiveDomainAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS#getType()
	 * @see #getPrimitiveDomainAS()
	 * @generated
	 */
	EReference getPrimitiveDomainAS_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS <em>Property Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Template AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS
	 * @generated
	 */
	EClass getPropertyTemplateAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS#getName()
	 * @see #getPropertyTemplateAS()
	 * @generated
	 */
	EAttribute getPropertyTemplateAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS#getBody()
	 * @see #getPropertyTemplateAS()
	 * @generated
	 */
	EReference getPropertyTemplateAS_Body();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS <em>Query AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Query AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.QueryAS
	 * @generated
	 */
	EClass getQueryAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.QueryAS#getPathName()
	 * @see #getQueryAS()
	 * @generated
	 */
	EAttribute getQueryAS_PathName();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.QueryAS#getBody()
	 * @see #getQueryAS()
	 * @generated
	 */
	EReference getQueryAS_Body();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.QueryAS#getType()
	 * @see #getQueryAS()
	 * @generated
	 */
	EReference getQueryAS_Type();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.QueryAS#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.QueryAS#getParameters()
	 * @see #getQueryAS()
	 * @generated
	 */
	EReference getQueryAS_Parameters();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS <em>Relation AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS
	 * @generated
	 */
	EClass getRelationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getIsTopLevel <em>Is Top Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Top Level</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getIsTopLevel()
	 * @see #getRelationAS()
	 * @generated
	 */
	EAttribute getRelationAS_IsTopLevel();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getName()
	 * @see #getRelationAS()
	 * @generated
	 */
	EAttribute getRelationAS_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overrides</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getOverrides()
	 * @see #getRelationAS()
	 * @generated
	 */
	EAttribute getRelationAS_Overrides();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domains</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getDomains()
	 * @see #getRelationAS()
	 * @generated
	 */
	EReference getRelationAS_Domains();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getVariableDeclarations <em>Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variable Declarations</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getVariableDeclarations()
	 * @see #getRelationAS()
	 * @generated
	 */
	EReference getRelationAS_VariableDeclarations();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Where</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getWhere()
	 * @see #getRelationAS()
	 * @generated
	 */
	EReference getRelationAS_Where();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.RelationAS#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>When</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.RelationAS#getWhen()
	 * @see #getRelationAS()
	 * @generated
	 */
	EReference getRelationAS_When();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS <em>Set Comprehension Expression AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Comprehension Expression AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS
	 * @generated
	 */
	EClass getSetComprehensionExpressionAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getName()
	 * @see #getSetComprehensionExpressionAS()
	 * @generated
	 */
	EAttribute getSetComprehensionExpressionAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getObjectTemplate <em>Object Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object Template</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getObjectTemplate()
	 * @see #getSetComprehensionExpressionAS()
	 * @generated
	 */
	EReference getSetComprehensionExpressionAS_ObjectTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getOclExpression <em>Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ocl Expression</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS#getOclExpression()
	 * @see #getSetComprehensionExpressionAS()
	 * @generated
	 */
	EReference getSetComprehensionExpressionAS_OclExpression();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.TemplateAS <em>Template AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TemplateAS
	 * @generated
	 */
	EClass getTemplateAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.TemplateAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TemplateAS#getName()
	 * @see #getTemplateAS()
	 * @generated
	 */
	EAttribute getTemplateAS_Name();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.TemplateAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TemplateAS#getType()
	 * @see #getTemplateAS()
	 * @generated
	 */
	EReference getTemplateAS_Type();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS <em>Top Level AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top Level AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TopLevelAS
	 * @generated
	 */
	EClass getTopLevelAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imports</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getImports()
	 * @see #getTopLevelAS()
	 * @generated
	 */
	EAttribute getTopLevelAS_Imports();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getTransformations <em>Transformations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transformations</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TopLevelAS#getTransformations()
	 * @see #getTopLevelAS()
	 * @generated
	 */
	EReference getTopLevelAS_Transformations();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS <em>Transformation AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS
	 * @generated
	 */
	EClass getTransformationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getName()
	 * @see #getTransformationAS()
	 * @generated
	 */
	EAttribute getTransformationAS_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extends</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getExtends()
	 * @see #getTransformationAS()
	 * @generated
	 */
	EAttribute getTransformationAS_Extends();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Relations</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getRelations()
	 * @see #getTransformationAS()
	 * @generated
	 */
	EReference getTransformationAS_Relations();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getModelDeclarations <em>Model Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Model Declarations</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getModelDeclarations()
	 * @see #getTransformationAS()
	 * @generated
	 */
	EReference getTransformationAS_ModelDeclarations();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Query</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getQuery()
	 * @see #getTransformationAS()
	 * @generated
	 */
	EReference getTransformationAS_Query();

	/**
	 * Returns the meta object for the reference list '{@link org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getKeyDeclarations <em>Key Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Key Declarations</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.TransformationAS#getKeyDeclarations()
	 * @see #getTransformationAS()
	 * @generated
	 */
	EReference getTransformationAS_KeyDeclarations();

	/**
	 * Returns the meta object for class '{@link org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS <em>Variable Declaration AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS
	 * @generated
	 */
	EClass getVariableDeclarationAS();

	/**
	 * Returns the meta object for the attribute '{@link org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS#getNames <em>Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Names</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS#getNames()
	 * @see #getVariableDeclarationAS()
	 * @generated
	 */
	EAttribute getVariableDeclarationAS_Names();

	/**
	 * Returns the meta object for the reference '{@link org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS#getType()
	 * @see #getVariableDeclarationAS()
	 * @generated
	 */
	EReference getVariableDeclarationAS_Type();

	/**
	 * Returns the meta object for enum '{@link org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS <em>Execution Kind AS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Kind AS</em>'.
	 * @see org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS
	 * @generated
	 */
	EEnum getExecutionKindAS();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QvtFactory getQvtFactory();

} //QvtPackage
