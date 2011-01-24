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
 * $Id: EssentialOCLCSTPackage.java,v 1.7 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
	String eNS_URI = "http://www.eclipse.org/ocl/3.1.0/EssentialOCLCST";

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
	int EXP_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionTypeCS()
	 * @generated
	 */
	int COLLECTION_TYPE_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLiteralExpCS()
	 * @generated
	 */
	int LITERAL_EXP_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralExpCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralPartCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART_CS = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrimitiveLiteralExpCS()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleLiteralExpCS()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP_CS = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getStringLiteralExpCS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_CS = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBooleanLiteralExpCS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInvalidLiteralExpCS()
	 * @generated
	 */
	int INVALID_LITERAL_EXP_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNullLiteralExpCS()
	 * @generated
	 */
	int NULL_LITERAL_EXP_CS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IfExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIfExpCS()
	 * @generated
	 */
	int IF_EXP_CS = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLetExpCS()
	 * @generated
	 */
	int LET_EXP_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl <em>Infix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InfixExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInfixExpCS()
	 * @generated
	 */
	int INFIX_EXP_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNameExpCS()
	 * @generated
	 */
	int NAME_EXP_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS <em>Named Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNamedExpCS()
	 * @generated
	 */
	int NAMED_EXP_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingExpCSImpl <em>Navigating Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigatingExpCS()
	 * @generated
	 */
	int NAVIGATING_EXP_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IndexExpCSImpl <em>Index Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IndexExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIndexExpCS()
	 * @generated
	 */
	int INDEX_EXP_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeNameExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeNameExpCS()
	 * @generated
	 */
	int TYPE_NAME_EXP_CS = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingArgCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigatingArgCS()
	 * @generated
	 */
	int NAVIGATING_ARG_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NestedExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNestedExpCS()
	 * @generated
	 */
	int NESTED_EXP_CS = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NumberLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNumberLiteralExpCS()
	 * @generated
	 */
	int NUMBER_LITERAL_EXP_CS = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorCSImpl <em>Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getOperatorCS()
	 * @generated
	 */
	int OPERATOR_CS = 24;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__ERROR = BaseCSTPackage.NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__MONIKER = BaseCSTPackage.NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__PARENT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS__SOURCE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryOperatorCSImpl <em>Binary Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryOperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBinaryOperatorCS()
	 * @generated
	 */
	int BINARY_OPERATOR_CS = 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__OWNED_ANNOTATION = OPERATOR_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__PIVOT = OPERATOR_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__ORIGINAL_XMI_ID = OPERATOR_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__ERROR = OPERATOR_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__MONIKER = OPERATOR_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__NAME = OPERATOR_CS__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__PARENT = OPERATOR_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__SOURCE = OPERATOR_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS__ARGUMENT = OPERATOR_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binary Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_OPERATOR_CS_FEATURE_COUNT = OPERATOR_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__OWNED_ANNOTATION = BaseCSTPackage.MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__PIVOT = BaseCSTPackage.MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__ERROR = BaseCSTPackage.MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__MONIKER = BaseCSTPackage.MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS__PARENT = BaseCSTPackage.MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CS_FEATURE_COUNT = BaseCSTPackage.MONIKERED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION = LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__ERROR = LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__MONIKER = LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__ERROR = PRIMITIVE_LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__MONIKER = PRIMITIVE_LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

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
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__OWNED_ANNOTATION = LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__ERROR = LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__MONIKER = LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__OWNED_ANNOTATION = BaseCSTPackage.MONIKERED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__PIVOT = BaseCSTPackage.MONIKERED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MONIKERED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__ERROR = BaseCSTPackage.MONIKERED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__MONIKER = BaseCSTPackage.MONIKERED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = BaseCSTPackage.MONIKERED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Last Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS = BaseCSTPackage.MONIKERED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS_FEATURE_COUNT = BaseCSTPackage.MONIKERED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__ERROR = BaseCSTPackage.NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__MONIKER = BaseCSTPackage.NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__OWNED_TYPE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl <em>Context CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getContextCS()
	 * @generated
	 */
	int CONTEXT_CS = 5;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__ERROR = BaseCSTPackage.NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__MONIKER = BaseCSTPackage.NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_IMPORT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Library</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_LIBRARY = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS__OWNED_EXPRESSION = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Context CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_CS_FEATURE_COUNT = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpConstraintCSImpl <em>Exp Constraint CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpConstraintCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getExpConstraintCS()
	 * @generated
	 */
	int EXP_CONSTRAINT_CS = 8;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Named Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DecoratedNamedExpCSImpl <em>Decorated Named Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DecoratedNamedExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getDecoratedNamedExpCS()
	 * @generated
	 */
	int DECORATED_NAMED_EXP_CS = 6;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__OWNED_ANNOTATION = NAMED_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__PIVOT = NAMED_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__ORIGINAL_XMI_ID = NAMED_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__ERROR = NAMED_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__MONIKER = NAMED_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__PARENT = NAMED_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Named Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS__NAMED_EXP = NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decorated Named Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_NAMED_EXP_CS_FEATURE_COUNT = NAMED_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__OWNED_ANNOTATION = BaseCSTPackage.CONSTRAINT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__PIVOT = BaseCSTPackage.CONSTRAINT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__ORIGINAL_XMI_ID = BaseCSTPackage.CONSTRAINT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__ERROR = BaseCSTPackage.CONSTRAINT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__MONIKER = BaseCSTPackage.CONSTRAINT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__NAME = BaseCSTPackage.CONSTRAINT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__STEREOTYPE = BaseCSTPackage.CONSTRAINT_CS__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Expr String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__EXPR_STRING = BaseCSTPackage.CONSTRAINT_CS__EXPR_STRING;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__OWNED_EXPRESSION = BaseCSTPackage.CONSTRAINT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Reason</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS__OWNED_REASON = BaseCSTPackage.CONSTRAINT_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exp Constraint CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXP_CONSTRAINT_CS_FEATURE_COUNT = BaseCSTPackage.CONSTRAINT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__PARENT = EXP_CS__PARENT;

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
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__OWNED_ANNOTATION = DECORATED_NAMED_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__PIVOT = DECORATED_NAMED_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__ORIGINAL_XMI_ID = DECORATED_NAMED_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__ERROR = DECORATED_NAMED_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__MONIKER = DECORATED_NAMED_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__PARENT = DECORATED_NAMED_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Named Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__NAMED_EXP = DECORATED_NAMED_EXP_CS__NAMED_EXP;

	/**
	 * The feature id for the '<em><b>First Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__FIRST_INDEXES = DECORATED_NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS__SECOND_INDEXES = DECORATED_NAMED_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Index Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDEX_EXP_CS_FEATURE_COUNT = DECORATED_NAMED_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OWNED_EXPRESSION = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS__OWNED_OPERATOR = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Infix Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFIX_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__ERROR = PRIMITIVE_LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__MONIKER = PRIMITIVE_LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Invalid Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__PARENT = EXP_CS__PARENT;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl <em>Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getVariableCS()
	 * @generated
	 */
	int VARIABLE_CS = 36;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__OWNED_ANNOTATION = BaseCSTPackage.NAMED_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__PIVOT = BaseCSTPackage.NAMED_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__ORIGINAL_XMI_ID = BaseCSTPackage.NAMED_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__ERROR = BaseCSTPackage.NAMED_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__MONIKER = BaseCSTPackage.NAMED_ELEMENT_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__NAME = BaseCSTPackage.NAMED_ELEMENT_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__OWNED_TYPE = BaseCSTPackage.NAMED_ELEMENT_CS_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetVariableCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLetVariableCS()
	 * @generated
	 */
	int LET_VARIABLE_CS = 14;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNED_ANNOTATION = VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__PIVOT = VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__ORIGINAL_XMI_ID = VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__ERROR = VARIABLE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__MONIKER = VARIABLE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__NAME = VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__OWNED_TYPE = VARIABLE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__INIT_EXPRESSION = VARIABLE_CS__INIT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__PARENT = VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Let Expression</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS__LET_EXPRESSION = VARIABLE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_VARIABLE_CS_FEATURE_COUNT = VARIABLE_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS <em>Simple Named Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSimpleNamedExpCS()
	 * @generated
	 */
	int SIMPLE_NAMED_EXP_CS = 28;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS__OWNED_ANNOTATION = NAMED_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS__PIVOT = NAMED_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS__ORIGINAL_XMI_ID = NAMED_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS__ERROR = NAMED_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS__MONIKER = NAMED_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS__PARENT = NAMED_EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Simple Named Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAMED_EXP_CS_FEATURE_COUNT = NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__OWNED_ANNOTATION = SIMPLE_NAMED_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__PIVOT = SIMPLE_NAMED_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__ORIGINAL_XMI_ID = SIMPLE_NAMED_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__ERROR = SIMPLE_NAMED_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__MONIKER = SIMPLE_NAMED_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__PARENT = SIMPLE_NAMED_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__NAMESPACE = SIMPLE_NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS__ELEMENT = SIMPLE_NAMED_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_EXP_CS_FEATURE_COUNT = SIMPLE_NAMED_EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNED_ANNOTATION = BaseCSTPackage.MODEL_ELEMENT_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__PIVOT = BaseCSTPackage.MODEL_ELEMENT_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__ORIGINAL_XMI_ID = BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__ERROR = BaseCSTPackage.MODEL_ELEMENT_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Navigating Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__NAVIGATING_EXP = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__ROLE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__PREFIX = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__NAME = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__OWNED_TYPE = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS__INIT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Navigating Arg CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_ARG_CS_FEATURE_COUNT = BaseCSTPackage.MODEL_ELEMENT_CS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__OWNED_ANNOTATION = DECORATED_NAMED_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__PIVOT = DECORATED_NAMED_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__ORIGINAL_XMI_ID = DECORATED_NAMED_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__ERROR = DECORATED_NAMED_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__MONIKER = DECORATED_NAMED_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__PARENT = DECORATED_NAMED_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Named Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__NAMED_EXP = DECORATED_NAMED_EXP_CS__NAMED_EXP;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS__ARGUMENT = DECORATED_NAMED_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Navigating Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATING_EXP_CS_FEATURE_COUNT = DECORATED_NAMED_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigationOperatorCSImpl <em>Navigation Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigationOperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigationOperatorCS()
	 * @generated
	 */
	int NAVIGATION_OPERATOR_CS = 20;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__OWNED_ANNOTATION = BINARY_OPERATOR_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__PIVOT = BINARY_OPERATOR_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__ORIGINAL_XMI_ID = BINARY_OPERATOR_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__ERROR = BINARY_OPERATOR_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__MONIKER = BINARY_OPERATOR_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__NAME = BINARY_OPERATOR_CS__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__PARENT = BINARY_OPERATOR_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__SOURCE = BINARY_OPERATOR_CS__SOURCE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS__ARGUMENT = BINARY_OPERATOR_CS__ARGUMENT;

	/**
	 * The number of structural features of the '<em>Navigation Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_OPERATOR_CS_FEATURE_COUNT = BINARY_OPERATOR_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS__SOURCE = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Nested Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NESTED_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__ERROR = PRIMITIVE_LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__MONIKER = PRIMITIVE_LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Null Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__ERROR = PRIMITIVE_LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__MONIKER = PRIMITIVE_LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrefixExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrefixExpCS()
	 * @generated
	 */
	int PREFIX_EXP_CS = 25;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__PARENT = EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Owned Operator</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OWNED_OPERATOR = EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS__OWNED_EXPRESSION = EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Prefix Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREFIX_EXP_CS_FEATURE_COUNT = EXP_CS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SelfExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSelfExpCS()
	 * @generated
	 */
	int SELF_EXP_CS = 27;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__OWNED_ANNOTATION = EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__PIVOT = EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__ORIGINAL_XMI_ID = EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__ERROR = EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__MONIKER = EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_EXP_CS__PARENT = EXP_CS__PARENT;

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
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__ERROR = PRIMITIVE_LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__MONIKER = PRIMITIVE_LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

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
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__OWNED_ANNOTATION = LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__ERROR = LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__MONIKER = LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__OWNED_PARTS = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleLiteralPartCS()
	 * @generated
	 */
	int TUPLE_LITERAL_PART_CS = 31;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__OWNED_ANNOTATION = VARIABLE_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__PIVOT = VARIABLE_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__ORIGINAL_XMI_ID = VARIABLE_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__ERROR = VARIABLE_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__MONIKER = VARIABLE_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__NAME = VARIABLE_CS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__OWNED_TYPE = VARIABLE_CS__OWNED_TYPE;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS__INIT_EXPRESSION = VARIABLE_CS__INIT_EXPRESSION;

	/**
	 * The number of structural features of the '<em>Tuple Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_PART_CS_FEATURE_COUNT = VARIABLE_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeLiteralExpCS()
	 * @generated
	 */
	int TYPE_LITERAL_EXP_CS = 32;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__OWNED_ANNOTATION = LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__PIVOT = LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__ORIGINAL_XMI_ID = LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__ERROR = LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__MONIKER = LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__PARENT = LITERAL_EXP_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS__OWNED_TYPE = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__OWNED_ANNOTATION = BaseCSTPackage.TYPED_REF_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__PIVOT = BaseCSTPackage.TYPED_REF_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__ORIGINAL_XMI_ID = BaseCSTPackage.TYPED_REF_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__ERROR = BaseCSTPackage.TYPED_REF_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__MONIKER = BaseCSTPackage.TYPED_REF_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__PARENT = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__NAMESPACE = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS__ELEMENT = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_EXP_CS_FEATURE_COUNT = BaseCSTPackage.TYPED_REF_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryOperatorCSImpl <em>Unary Operator CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryOperatorCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnaryOperatorCS()
	 * @generated
	 */
	int UNARY_OPERATOR_CS = 34;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__OWNED_ANNOTATION = OPERATOR_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__PIVOT = OPERATOR_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__ORIGINAL_XMI_ID = OPERATOR_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__ERROR = OPERATOR_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__MONIKER = OPERATOR_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__NAME = OPERATOR_CS__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__PARENT = OPERATOR_CS__PARENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS__SOURCE = OPERATOR_CS__SOURCE;

	/**
	 * The number of structural features of the '<em>Unary Operator CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_OPERATOR_CS_FEATURE_COUNT = OPERATOR_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnlimitedNaturalLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnlimitedNaturalLiteralExpCS()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS = 35;

	/**
	 * The feature id for the '<em><b>Owned Annotation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__OWNED_ANNOTATION = PRIMITIVE_LITERAL_EXP_CS__OWNED_ANNOTATION;

	/**
	 * The feature id for the '<em><b>Pivot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__PIVOT = PRIMITIVE_LITERAL_EXP_CS__PIVOT;

	/**
	 * The feature id for the '<em><b>Original Xmi Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__ORIGINAL_XMI_ID = PRIMITIVE_LITERAL_EXP_CS__ORIGINAL_XMI_ID;

	/**
	 * The feature id for the '<em><b>Error</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__ERROR = PRIMITIVE_LITERAL_EXP_CS__ERROR;

	/**
	 * The feature id for the '<em><b>Moniker</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__MONIKER = PRIMITIVE_LITERAL_EXP_CS__MONIKER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS__PARENT = PRIMITIVE_LITERAL_EXP_CS__PARENT;

	/**
	 * The number of structural features of the '<em>Unlimited Natural Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole <em>Navigation Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigationRole()
	 * @generated
	 */
	int NAVIGATION_ROLE = 37;

	/**
	 * The meta object id for the '<em>Big Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBigNumber()
	 * @generated
	 */
	int BIG_NUMBER = 38;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS <em>Binary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS
	 * @generated
	 */
	EClass getBinaryOperatorCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS#getArgument()
	 * @see #getBinaryOperatorCS()
	 * @generated
	 */
	EReference getBinaryOperatorCS_Argument();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedOperator <em>Owned Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operator</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedOperator()
	 * @see #getPrefixExpCS()
	 * @generated
	 */
	EReference getPrefixExpCS_OwnedOperator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedExpression()
	 * @see #getPrefixExpCS()
	 * @generated
	 */
	EReference getPrefixExpCS_OwnedExpression();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getOwnedType()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS <em>Context CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS
	 * @generated
	 */
	EClass getContextCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS#getOwnedExpression()
	 * @see #getContextCS()
	 * @generated
	 */
	EReference getContextCS_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS <em>Decorated Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decorated Named Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS
	 * @generated
	 */
	EClass getDecoratedNamedExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS#getNamedExp <em>Named Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Named Exp</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DecoratedNamedExpCS#getNamedExp()
	 * @see #getDecoratedNamedExpCS()
	 * @generated
	 */
	EReference getDecoratedNamedExpCS_NamedExp();

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
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS#getParent()
	 * @see #getExpCS()
	 * @generated
	 */
	EReference getExpCS_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS <em>Exp Constraint CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exp Constraint CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS
	 * @generated
	 */
	EClass getExpConstraintCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS#getOwnedExpression()
	 * @see #getExpConstraintCS()
	 * @generated
	 */
	EReference getExpConstraintCS_OwnedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS#getOwnedReason <em>Owned Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Reason</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS#getOwnedReason()
	 * @see #getExpConstraintCS()
	 * @generated
	 */
	EReference getExpConstraintCS_OwnedReason();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS
	 * @generated
	 */
	EClass getTypeLiteralExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS#getOwnedType()
	 * @see #getTypeLiteralExpCS()
	 * @generated
	 */
	EReference getTypeLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS <em>Type Name Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Name Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS
	 * @generated
	 */
	EClass getTypeNameExpCS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS#getNamespace()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_Namespace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS#getElement()
	 * @see #getTypeNameExpCS()
	 * @generated
	 */
	EReference getTypeNameExpCS_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS <em>Unary Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS
	 * @generated
	 */
	EClass getUnaryOperatorCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unlimited Natural Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS
	 * @generated
	 */
	EClass getUnlimitedNaturalLiteralExpCS();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getOwnedType()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_OwnedType();

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
	 * Returns the meta object for enum '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole <em>Navigation Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Navigation Role</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole
	 * @generated
	 */
	EEnum getNavigationRole();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Namespace</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS#getNamespace()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_Namespace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS#getElement()
	 * @see #getNameExpCS()
	 * @generated
	 */
	EReference getNameExpCS_Element();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS <em>Navigating Arg CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigating Arg CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS
	 * @generated
	 */
	EClass getNavigatingArgCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getNavigatingExp <em>Navigating Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Navigating Exp</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getNavigatingExp()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_NavigatingExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getRole()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EAttribute getNavigatingArgCS_Role();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getPrefix()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EAttribute getNavigatingArgCS_Prefix();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getName()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getOwnedType()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS#getInit()
	 * @see #getNavigatingArgCS()
	 * @generated
	 */
	EReference getNavigatingArgCS_Init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS <em>Navigating Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigating Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS
	 * @generated
	 */
	EClass getNavigatingExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS#getArgument()
	 * @see #getNavigatingExpCS()
	 * @generated
	 */
	EReference getNavigatingExpCS_Argument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS <em>Navigation Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS
	 * @generated
	 */
	EClass getNavigationOperatorCS();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS#getSource()
	 * @see #getNestedExpCS()
	 * @generated
	 */
	EReference getNestedExpCS_Source();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Type</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getOwnedType()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_OwnedType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS#getOwnedParts()
	 * @see #getCollectionLiteralExpCS()
	 * @generated
	 */
	EReference getCollectionLiteralExpCS_OwnedParts();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS <em>Simple Named Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Named Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS
	 * @generated
	 */
	EClass getSimpleNamedExpCS();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS#getOwnedParts()
	 * @see #getTupleLiteralExpCS()
	 * @generated
	 */
	EReference getTupleLiteralExpCS_OwnedParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Part CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS
	 * @generated
	 */
	EClass getTupleLiteralPartCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS <em>Operator CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS
	 * @generated
	 */
	EClass getOperatorCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OperatorCS#getSource()
	 * @see #getOperatorCS()
	 * @generated
	 */
	EReference getOperatorCS_Source();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS <em>Index Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Index Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS
	 * @generated
	 */
	EClass getIndexExpCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS#getFirstIndexes <em>First Indexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>First Indexes</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS#getFirstIndexes()
	 * @see #getIndexExpCS()
	 * @generated
	 */
	EReference getIndexExpCS_FirstIndexes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS#getSecondIndexes <em>Second Indexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Second Indexes</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS#getSecondIndexes()
	 * @see #getIndexExpCS()
	 * @generated
	 */
	EReference getIndexExpCS_SecondIndexes();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS#getOwnedExpression()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_OwnedExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS#getOwnedOperator <em>Owned Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operator</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS#getOwnedOperator()
	 * @see #getInfixExpCS()
	 * @generated
	 */
	EReference getInfixExpCS_OwnedOperator();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS <em>Let Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Variable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS
	 * @generated
	 */
	EClass getLetVariableCS();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS#getLetExpression <em>Let Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Let Expression</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS#getLetExpression()
	 * @see #getLetVariableCS()
	 * @generated
	 */
	EReference getLetVariableCS_LetExpression();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryOperatorCSImpl <em>Binary Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryOperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBinaryOperatorCS()
		 * @generated
		 */
		EClass BINARY_OPERATOR_CS = eINSTANCE.getBinaryOperatorCS();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_OPERATOR_CS__ARGUMENT = eINSTANCE.getBinaryOperatorCS_Argument();

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
		 * The meta object literal for the '<em><b>Owned Operator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFIX_EXP_CS__OWNED_OPERATOR = eINSTANCE.getPrefixExpCS_OwnedOperator();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREFIX_EXP_CS__OWNED_EXPRESSION = eINSTANCE.getPrefixExpCS_OwnedExpression();

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
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__OWNED_TYPE = eINSTANCE.getCollectionTypeCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl <em>Context CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getContextCS()
		 * @generated
		 */
		EClass CONTEXT_CS = eINSTANCE.getContextCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXT_CS__OWNED_EXPRESSION = eINSTANCE.getContextCS_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DecoratedNamedExpCSImpl <em>Decorated Named Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DecoratedNamedExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getDecoratedNamedExpCS()
		 * @generated
		 */
		EClass DECORATED_NAMED_EXP_CS = eINSTANCE.getDecoratedNamedExpCS();

		/**
		 * The meta object literal for the '<em><b>Named Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECORATED_NAMED_EXP_CS__NAMED_EXP = eINSTANCE.getDecoratedNamedExpCS_NamedExp();

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
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CS__PARENT = eINSTANCE.getExpCS_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpConstraintCSImpl <em>Exp Constraint CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ExpConstraintCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getExpConstraintCS()
		 * @generated
		 */
		EClass EXP_CONSTRAINT_CS = eINSTANCE.getExpConstraintCS();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CONSTRAINT_CS__OWNED_EXPRESSION = eINSTANCE.getExpConstraintCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Reason</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXP_CONSTRAINT_CS__OWNED_REASON = eINSTANCE.getExpConstraintCS_OwnedReason();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeLiteralExpCS()
		 * @generated
		 */
		EClass TYPE_LITERAL_EXP_CS = eINSTANCE.getTypeLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getTypeLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeNameExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeNameExpCS()
		 * @generated
		 */
		EClass TYPE_NAME_EXP_CS = eINSTANCE.getTypeNameExpCS();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__NAMESPACE = eINSTANCE.getTypeNameExpCS_Namespace();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NAME_EXP_CS__ELEMENT = eINSTANCE.getTypeNameExpCS_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryOperatorCSImpl <em>Unary Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryOperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnaryOperatorCS()
		 * @generated
		 */
		EClass UNARY_OPERATOR_CS = eINSTANCE.getUnaryOperatorCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnlimitedNaturalLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnlimitedNaturalLiteralExpCS()
		 * @generated
		 */
		EClass UNLIMITED_NATURAL_LITERAL_EXP_CS = eINSTANCE.getUnlimitedNaturalLiteralExpCS();

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
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__OWNED_TYPE = eINSTANCE.getVariableCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__INIT_EXPRESSION = eINSTANCE.getVariableCS_InitExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole <em>Navigation Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigationRole()
		 * @generated
		 */
		EEnum NAVIGATION_ROLE = eINSTANCE.getNavigationRole();

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
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__NAMESPACE = eINSTANCE.getNameExpCS_Namespace();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAME_EXP_CS__ELEMENT = eINSTANCE.getNameExpCS_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS <em>Named Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NamedExpCS
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNamedExpCS()
		 * @generated
		 */
		EClass NAMED_EXP_CS = eINSTANCE.getNamedExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingArgCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigatingArgCS()
		 * @generated
		 */
		EClass NAVIGATING_ARG_CS = eINSTANCE.getNavigatingArgCS();

		/**
		 * The meta object literal for the '<em><b>Navigating Exp</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__NAVIGATING_EXP = eINSTANCE.getNavigatingArgCS_NavigatingExp();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATING_ARG_CS__ROLE = eINSTANCE.getNavigatingArgCS_Role();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATING_ARG_CS__PREFIX = eINSTANCE.getNavigatingArgCS_Prefix();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__NAME = eINSTANCE.getNavigatingArgCS_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__OWNED_TYPE = eINSTANCE.getNavigatingArgCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_ARG_CS__INIT = eINSTANCE.getNavigatingArgCS_Init();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingExpCSImpl <em>Navigating Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigatingExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigatingExpCS()
		 * @generated
		 */
		EClass NAVIGATING_EXP_CS = eINSTANCE.getNavigatingExpCS();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATING_EXP_CS__ARGUMENT = eINSTANCE.getNavigatingExpCS_Argument();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigationOperatorCSImpl <em>Navigation Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NavigationOperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNavigationOperatorCS()
		 * @generated
		 */
		EClass NAVIGATION_OPERATOR_CS = eINSTANCE.getNavigationOperatorCS();

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
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NESTED_EXP_CS__SOURCE = eINSTANCE.getNestedExpCS_Source();

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
		 * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getCollectionLiteralExpCS_OwnedType();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getCollectionLiteralExpCS_OwnedParts();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS <em>Simple Named Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNamedExpCS
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSimpleNamedExpCS()
		 * @generated
		 */
		EClass SIMPLE_NAMED_EXP_CS = eINSTANCE.getSimpleNamedExpCS();

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
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getTupleLiteralExpCS_OwnedParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralPartCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleLiteralPartCS()
		 * @generated
		 */
		EClass TUPLE_LITERAL_PART_CS = eINSTANCE.getTupleLiteralPartCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorCSImpl <em>Operator CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OperatorCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getOperatorCS()
		 * @generated
		 */
		EClass OPERATOR_CS = eINSTANCE.getOperatorCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR_CS__SOURCE = eINSTANCE.getOperatorCS_Source();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IndexExpCSImpl <em>Index Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IndexExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIndexExpCS()
		 * @generated
		 */
		EClass INDEX_EXP_CS = eINSTANCE.getIndexExpCS();

		/**
		 * The meta object literal for the '<em><b>First Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_EXP_CS__FIRST_INDEXES = eINSTANCE.getIndexExpCS_FirstIndexes();

		/**
		 * The meta object literal for the '<em><b>Second Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDEX_EXP_CS__SECOND_INDEXES = eINSTANCE.getIndexExpCS_SecondIndexes();

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
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__OWNED_EXPRESSION = eINSTANCE.getInfixExpCS_OwnedExpression();

		/**
		 * The meta object literal for the '<em><b>Owned Operator</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFIX_EXP_CS__OWNED_OPERATOR = eINSTANCE.getInfixExpCS_OwnedOperator();

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

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LetVariableCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLetVariableCS()
		 * @generated
		 */
		EClass LET_VARIABLE_CS = eINSTANCE.getLetVariableCS();

		/**
		 * The meta object literal for the '<em><b>Let Expression</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_VARIABLE_CS__LET_EXPRESSION = eINSTANCE.getLetVariableCS_LetExpression();

	}

} //EssentialOCLCSTPackage
