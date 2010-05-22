/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSTPackage.java,v 1.6 2010/05/22 18:51:44 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;

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
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTFactory
 * @model kind="package"
 * @generated
 */
public interface EssentialOCLCSTPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "essentialOCLCST";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/3.0.0/EssentialOCLCST";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essentialOCLCST";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EssentialOCLCSTPackage eINSTANCE = org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl <em>Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getExpCS()
	 * @generated
	 */
	int EXP_CS = 4;

	/**
	 * The number of structural features of the '<em>Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SubExpCSImpl <em>Sub Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SubExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSubExpCS()
	 * @generated
	 */
	int SUB_EXP_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorExpCSImpl <em>Operator Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getOperatorExpCS()
	 * @generated
	 */
	int OPERATOR_EXP_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionTypeCS()
	 * @generated
	 */
	int COLLECTION_TYPE_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleTypeCS()
	 * @generated
	 */
	int TUPLE_TYPE_CS = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl <em>Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getVariableCS()
	 * @generated
	 */
	int VARIABLE_CS = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLiteralExpCS()
	 * @generated
	 */
	int LITERAL_EXP_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralExpCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralPartCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrimitiveLiteralExpCS()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleLiteralExpCS()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP_CS = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getStringLiteralExpCS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBooleanLiteralExpCS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInvalidLiteralExpCS()
	 * @generated
	 */
	int INVALID_LITERAL_EXP_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNullLiteralExpCS()
	 * @generated
	 */
	int NULL_LITERAL_EXP_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IfExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIfExpCS()
	 * @generated
	 */
	int IF_EXP_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLetExpCS()
	 * @generated
	 */
	int LET_EXP_CS = 8;

	/**
	 * The number of structural features of the '<em>Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__NAME = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__TYPE_CS = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS_FEATURE_COUNT = BaseCSTPackage.ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__ANNOTATIONS = BaseCSTPackage.NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__ORIGINAL_OBJECT = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__TYPE_CS = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__CONDITION = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__THEN_EXPRESSION = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__ELSE_EXPRESSION = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_EXP_CS__SOURCE = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sub Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXP_CS__SOURCE = SUB_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXP_CS__OP = SUB_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operator Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_EXP_CS_FEATURE_COUNT = SUB_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInfixExpCS()
	 * @generated
	 */
	int INFIX_EXP_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeExpCSImpl <em>Type Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeExpCS()
	 * @generated
	 */
	int TYPE_EXP_CS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNameExpCS()
	 * @generated
	 */
	int NAME_EXP_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NamedExpCSImpl <em>Named Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NamedExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNamedExpCS()
	 * @generated
	 */
	int NAMED_EXP_CS = 11;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__SOURCE = OPERATOR_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OP = OPERATOR_EXP_CS__OP;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__ARGUMENT = OPERATOR_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Infix Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS_FEATURE_COUNT = OPERATOR_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Invalid Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__VARIABLE = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__IN = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS_FEATURE_COUNT = TYPE_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__NAME = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NestedExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNestedExpCS()
	 * @generated
	 */
	int NESTED_EXP_CS = 12;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__SOURCE = SUB_EXP_CS__SOURCE;

	/**
	 * The number of structural features of the '<em>Nested Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS_FEATURE_COUNT = SUB_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Null Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NumberLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNumberLiteralExpCS()
	 * @generated
	 */
	int NUMBER_LITERAL_EXP_CS = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__NAME = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Number Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl <em>Path Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPathNameExpCS()
	 * @generated
	 */
	int PATH_NAME_EXP_CS = 16;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_CS__ANNOTATIONS = NAME_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_CS__ORIGINAL_OBJECT = NAME_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_CS__ORIGINAL_XMI_ID = NAME_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_CS__NAMESPACE = NAME_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_CS__ELEMENT = NAME_EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Path Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_EXP_CS_FEATURE_COUNT = NAME_EXP_CS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PreExpCSImpl <em>Pre Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PreExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPreExpCS()
	 * @generated
	 */
	int PRE_EXP_CS = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_EXP_CS__NAME = NAMED_EXP_CS__NAME;

	/**
	 * The number of structural features of the '<em>Pre Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_EXP_CS_FEATURE_COUNT = NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrefixExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrefixExpCS()
	 * @generated
	 */
	int PREFIX_EXP_CS = 18;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__SOURCE = SUB_EXP_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OP = SUB_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Prefix Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS_FEATURE_COUNT = SUB_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrimitiveTypeCS()
	 * @generated
	 */
	int PRIMITIVE_TYPE_CS = 20;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__ANNOTATIONS = BaseCSTPackage.NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__ORIGINAL_OBJECT = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The number of structural features of the '<em>Primitive Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl <em>Round Bracket Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getRoundBracketExpCS()
	 * @generated
	 */
	int ROUND_BRACKET_EXP_CS = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKET_EXP_CS__NAME = NAMED_EXP_CS__NAME;

	/**
	 * The feature id for the '<em><b>Variable1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKET_EXP_CS__VARIABLE1 = NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKET_EXP_CS__VARIABLE2 = NAMED_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKET_EXP_CS__ARGUMENTS = NAMED_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKET_EXP_CS__PRE = NAMED_EXP_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Round Bracket Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_BRACKET_EXP_CS_FEATURE_COUNT = NAMED_EXP_CS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SelfExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSelfExpCS()
	 * @generated
	 */
	int SELF_EXP_CS = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__NAME = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Self Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameExpCSImpl <em>Simple Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSimpleNameExpCS()
	 * @generated
	 */
	int SIMPLE_NAME_EXP_CS = 23;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAME_EXP_CS__ELEMENT = NAME_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAME_EXP_CS_FEATURE_COUNT = NAME_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SquareBracketExpCSImpl <em>Square Bracket Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SquareBracketExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSquareBracketExpCS()
	 * @generated
	 */
	int SQUARE_BRACKET_EXP_CS = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKET_EXP_CS__NAME = NAMED_EXP_CS__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKET_EXP_CS__ARGUMENTS = NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKET_EXP_CS__PRE = NAMED_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Square Bracket Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SQUARE_BRACKET_EXP_CS_FEATURE_COUNT = NAMED_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__NAME = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__ANNOTATIONS = BaseCSTPackage.CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__ORIGINAL_OBJECT = BaseCSTPackage.CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__NAME = BaseCSTPackage.CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__TYPE_PARAMETERS = BaseCSTPackage.CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__OWNER = BaseCSTPackage.CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__PART = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS_FEATURE_COUNT = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__ANNOTATIONS = BaseCSTPackage.CLASSIFIER_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__ORIGINAL_OBJECT = BaseCSTPackage.CLASSIFIER_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CLASSIFIER_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__NAME = BaseCSTPackage.CLASSIFIER_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__TYPE_PARAMETERS = BaseCSTPackage.CLASSIFIER_CS__TYPE_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__OWNER = BaseCSTPackage.CLASSIFIER_CS__OWNER;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__PART = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS_FEATURE_COUNT = BaseCSTPackage.CLASSIFIER_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__ANNOTATIONS = BaseCSTPackage.NAMED_ELEMENT_CS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Original Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__ORIGINAL_OBJECT = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_OBJECT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__TYPE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__INIT_EXPRESSION = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '<em>Big Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBigNumber()
	 * @generated
	 */
	int BIG_NUMBER = 31;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS <em>Path Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS
	 * @generated
	 */
	EClass getPathNameExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PreExpCS <em>Pre Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PreExpCS
	 * @generated
	 */
	EClass getPreExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS <em>Prefix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prefix Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS
	 * @generated
	 */
	EClass getPrefixExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOp()
	 * @see #getPrefixExpCS()
	 * @generated
	 */
	EAttribute getPrefixExpCS_Op();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS <em>Collection Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS
	 * @generated
	 */
	EClass getCollectionTypeCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getTypeCS()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_TypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS <em>Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS
	 * @generated
	 */
	EClass getExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS <em>Tuple Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS
	 * @generated
	 */
	EClass getTupleTypeCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS#getPart()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EReference getTupleTypeCS_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeExpCS <em>Type Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeExpCS
	 * @generated
	 */
	EClass getTypeExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS
	 * @generated
	 */
	EClass getVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getType()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getInitExpression <em>Init Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getInitExpression()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_InitExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS <em>Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS
	 * @generated
	 */
	EClass getLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS <em>Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS
	 * @generated
	 */
	EClass getNameExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS <em>Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS
	 * @generated
	 */
	EClass getNamedExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS#getName()
	 * @see #getNamedExpCS()
	 * @generated
	 */
	EReference getNamedExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS <em>Nested Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nested Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS
	 * @generated
	 */
	EClass getNestedExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS
	 * @generated
	 */
	EClass getCollectionLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getTypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getTypeCS()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_TypeCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getCollectionLiteralParts <em>Collection Literal Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Literal Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getCollectionLiteralParts()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_CollectionLiteralParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS
	 * @generated
	 */
	EClass getCollectionLiteralPartCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getExpressionCS()
	 * @see #getCollectionLiteralPartCS()
	 * @generated
	 */
	EReference getCollectionLiteralPartCS_ExpressionCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getLastExpressionCS <em>Last Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Last Expression CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS#getLastExpressionCS()
	 * @see #getCollectionLiteralPartCS()
	 * @generated
	 */
	EReference getCollectionLiteralPartCS_LastExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS
	 * @generated
	 */
	EClass getPrimitiveLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveTypeCS
	 * @generated
	 */
	EClass getPrimitiveTypeCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS <em>Round Bracket Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round Bracket Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS
	 * @generated
	 */
	EClass getRoundBracketExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#getVariable1 <em>Variable1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable1</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#getVariable1()
	 * @see #getRoundBracketExpCS()
	 * @generated
	 */
	EReference getRoundBracketExpCS_Variable1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#getVariable2 <em>Variable2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable2</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#getVariable2()
	 * @see #getRoundBracketExpCS()
	 * @generated
	 */
	EReference getRoundBracketExpCS_Variable2();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#getArguments()
	 * @see #getRoundBracketExpCS()
	 * @generated
	 */
	EReference getRoundBracketExpCS_Arguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#isPre <em>Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS#isPre()
	 * @see #getRoundBracketExpCS()
	 * @generated
	 */
	EAttribute getRoundBracketExpCS_Pre();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS <em>Self Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS
	 * @generated
	 */
	EClass getSelfExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS#getName()
	 * @see #getSelfExpCS()
	 * @generated
	 */
	EAttribute getSelfExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS <em>Simple Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Name Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS
	 * @generated
	 */
	EClass getSimpleNameExpCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS#getElement()
	 * @see #getSimpleNameExpCS()
	 * @generated
	 */
	EReference getSimpleNameExpCS_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS <em>Square Bracket Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Square Bracket Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS
	 * @generated
	 */
	EClass getSquareBracketExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS#getArguments()
	 * @see #getSquareBracketExpCS()
	 * @generated
	 */
	EReference getSquareBracketExpCS_Arguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS#isPre <em>Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pre</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS#isPre()
	 * @see #getSquareBracketExpCS()
	 * @generated
	 */
	EAttribute getSquareBracketExpCS_Pre();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SubExpCS <em>Sub Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SubExpCS
	 * @generated
	 */
	EClass getSubExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SubExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SubExpCS#getSource()
	 * @see #getSubExpCS()
	 * @generated
	 */
	EReference getSubExpCS_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS
	 * @generated
	 */
	EClass getTupleLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS#getPart()
	 * @see #getTupleLiteralExpCS()
	 * @generated
	 */
	EReference getTupleLiteralExpCS_Part();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS
	 * @generated
	 */
	EClass getStringLiteralExpCS();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS#getName()
	 * @see #getStringLiteralExpCS()
	 * @generated
	 */
	EAttribute getStringLiteralExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS
	 * @generated
	 */
	EClass getBooleanLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS#getName()
	 * @see #getBooleanLiteralExpCS()
	 * @generated
	 */
	EAttribute getBooleanLiteralExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS
	 * @generated
	 */
	EClass getInvalidLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS
	 * @generated
	 */
	EClass getNullLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS
	 * @generated
	 */
	EClass getNumberLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS#getName()
	 * @see #getNumberLiteralExpCS()
	 * @generated
	 */
	EAttribute getNumberLiteralExpCS_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS <em>Operator Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS
	 * @generated
	 */
	EClass getOperatorExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorExpCS#getOp()
	 * @see #getOperatorExpCS()
	 * @generated
	 */
	EAttribute getOperatorExpCS_Op();

	/**
	 * Returns the meta object for data type '{@link java.lang.Number <em>Big Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Big Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getBigNumber();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS <em>If Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS
	 * @generated
	 */
	EClass getIfExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS#getCondition()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS#getThenExpression()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS#getElseExpression()
	 * @see #getIfExpCS()
	 * @generated
	 */
	EReference getIfExpCS_ElseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS <em>Infix Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infix Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS
	 * @generated
	 */
	EClass getInfixExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS#getArgument()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_Argument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS <em>Let Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS
	 * @generated
	 */
	EClass getLetExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS#getVariable()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EReference getLetExpCS_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS#getIn()
	 * @see #getLetExpCS()
	 * @generated
	 */
	EReference getLetExpCS_In();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EssentialOCLCSTFactory getEssentialOCLCSTFactory();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl <em>Path Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPathNameExpCS()
		 * @generated
		 */
		EClass PATH_NAME_EXP_CS = eINSTANCE.getPathNameExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PreExpCSImpl <em>Pre Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PreExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPreExpCS()
		 * @generated
		 */
		EClass PRE_EXP_CS = eINSTANCE.getPreExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrefixExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrefixExpCS()
		 * @generated
		 */
		EClass PREFIX_EXP_CS = eINSTANCE.getPrefixExpCS();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREFIX_EXP_CS__OP = eINSTANCE.getPrefixExpCS_Op();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionTypeCS()
		 * @generated
		 */
		EClass COLLECTION_TYPE_CS = eINSTANCE.getCollectionTypeCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__TYPE_CS = eINSTANCE.getCollectionTypeCS_TypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl <em>Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getExpCS()
		 * @generated
		 */
		EClass EXP_CS = eINSTANCE.getExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleTypeCS()
		 * @generated
		 */
		EClass TUPLE_TYPE_CS = eINSTANCE.getTupleTypeCS();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE_CS__PART = eINSTANCE.getTupleTypeCS_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeExpCSImpl <em>Type Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeExpCS()
		 * @generated
		 */
		EClass TYPE_EXP_CS = eINSTANCE.getTypeExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl <em>Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getVariableCS()
		 * @generated
		 */
		EClass VARIABLE_CS = eINSTANCE.getVariableCS();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__TYPE = eINSTANCE.getVariableCS_Type();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__INIT_EXPRESSION = eINSTANCE.getVariableCS_InitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLiteralExpCS()
		 * @generated
		 */
		EClass LITERAL_EXP_CS = eINSTANCE.getLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NameExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNameExpCS()
		 * @generated
		 */
		EClass NAME_EXP_CS = eINSTANCE.getNameExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NamedExpCSImpl <em>Named Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NamedExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNamedExpCS()
		 * @generated
		 */
		EClass NAMED_EXP_CS = eINSTANCE.getNamedExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_EXP_CS__NAME = eINSTANCE.getNamedExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NestedExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNestedExpCS()
		 * @generated
		 */
		EClass NESTED_EXP_CS = eINSTANCE.getNestedExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralExpCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP_CS = eINSTANCE.getCollectionLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__TYPE_CS = eINSTANCE.getCollectionLiteralExpCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Collection Literal Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS = eINSTANCE.getCollectionLiteralExpCS_CollectionLiteralParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralPartCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART_CS = eINSTANCE.getCollectionLiteralPartCS();

		/**
		 * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = eINSTANCE.getCollectionLiteralPartCS_ExpressionCS();

		/**
		 * The meta object literal for the '<em><b>Last Expression CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS = eINSTANCE.getCollectionLiteralPartCS_LastExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrimitiveLiteralExpCS()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP_CS = eINSTANCE.getPrimitiveLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveTypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrimitiveTypeCS()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE_CS = eINSTANCE.getPrimitiveTypeCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl <em>Round Bracket Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RoundBracketExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getRoundBracketExpCS()
		 * @generated
		 */
		EClass ROUND_BRACKET_EXP_CS = eINSTANCE.getRoundBracketExpCS();

		/**
		 * The meta object literal for the '<em><b>Variable1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKET_EXP_CS__VARIABLE1 = eINSTANCE.getRoundBracketExpCS_Variable1();

		/**
		 * The meta object literal for the '<em><b>Variable2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKET_EXP_CS__VARIABLE2 = eINSTANCE.getRoundBracketExpCS_Variable2();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_BRACKET_EXP_CS__ARGUMENTS = eINSTANCE.getRoundBracketExpCS_Arguments();

		/**
		 * The meta object literal for the '<em><b>Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND_BRACKET_EXP_CS__PRE = eINSTANCE.getRoundBracketExpCS_Pre();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SelfExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSelfExpCS()
		 * @generated
		 */
		EClass SELF_EXP_CS = eINSTANCE.getSelfExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELF_EXP_CS__NAME = eINSTANCE.getSelfExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameExpCSImpl <em>Simple Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSimpleNameExpCS()
		 * @generated
		 */
		EClass SIMPLE_NAME_EXP_CS = eINSTANCE.getSimpleNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_NAME_EXP_CS__ELEMENT = eINSTANCE.getSimpleNameExpCS_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SquareBracketExpCSImpl <em>Square Bracket Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SquareBracketExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSquareBracketExpCS()
		 * @generated
		 */
		EClass SQUARE_BRACKET_EXP_CS = eINSTANCE.getSquareBracketExpCS();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SQUARE_BRACKET_EXP_CS__ARGUMENTS = eINSTANCE.getSquareBracketExpCS_Arguments();

		/**
		 * The meta object literal for the '<em><b>Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SQUARE_BRACKET_EXP_CS__PRE = eINSTANCE.getSquareBracketExpCS_Pre();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SubExpCSImpl <em>Sub Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SubExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSubExpCS()
		 * @generated
		 */
		EClass SUB_EXP_CS = eINSTANCE.getSubExpCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_EXP_CS__SOURCE = eINSTANCE.getSubExpCS_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleLiteralExpCS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_EXP_CS = eINSTANCE.getTupleLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP_CS__PART = eINSTANCE.getTupleLiteralExpCS_Part();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getStringLiteralExpCS()
		 * @generated
		 */
		EClass STRING_LITERAL_EXP_CS = eINSTANCE.getStringLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP_CS__NAME = eINSTANCE.getStringLiteralExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBooleanLiteralExpCS()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP_CS = eINSTANCE.getBooleanLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP_CS__NAME = eINSTANCE.getBooleanLiteralExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInvalidLiteralExpCS()
		 * @generated
		 */
		EClass INVALID_LITERAL_EXP_CS = eINSTANCE.getInvalidLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNullLiteralExpCS()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP_CS = eINSTANCE.getNullLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NumberLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNumberLiteralExpCS()
		 * @generated
		 */
		EClass NUMBER_LITERAL_EXP_CS = eINSTANCE.getNumberLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_LITERAL_EXP_CS__NAME = eINSTANCE.getNumberLiteralExpCS_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorExpCSImpl <em>Operator Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getOperatorExpCS()
		 * @generated
		 */
		EClass OPERATOR_EXP_CS = eINSTANCE.getOperatorExpCS();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATOR_EXP_CS__OP = eINSTANCE.getOperatorExpCS_Op();

		/**
		 * The meta object literal for the '<em>Big Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBigNumber()
		 * @generated
		 */
		EDataType BIG_NUMBER = eINSTANCE.getBigNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IfExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIfExpCS()
		 * @generated
		 */
		EClass IF_EXP_CS = eINSTANCE.getIfExpCS();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__CONDITION = eINSTANCE.getIfExpCS_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__THEN_EXPRESSION = eINSTANCE.getIfExpCS_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXP_CS__ELSE_EXPRESSION = eINSTANCE.getIfExpCS_ElseExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInfixExpCS()
		 * @generated
		 */
		EClass INFIX_EXP_CS = eINSTANCE.getInfixExpCS();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__ARGUMENT = eINSTANCE.getInfixExpCS_Argument();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLetExpCS()
		 * @generated
		 */
		EClass LET_EXP_CS = eINSTANCE.getLetExpCS();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_CS__VARIABLE = eINSTANCE.getLetExpCS_Variable();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP_CS__IN = eINSTANCE.getLetExpCS_In();

	}

} //EssentialOCLCSTPackage
