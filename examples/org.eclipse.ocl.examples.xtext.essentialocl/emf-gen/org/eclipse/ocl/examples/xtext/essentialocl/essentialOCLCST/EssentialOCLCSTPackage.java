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
 * $Id: EssentialOCLCSTPackage.java,v 1.1 2010/04/13 06:32:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

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
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OclExpressionCSImpl <em>Ocl Expression CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OclExpressionCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getOclExpressionCS()
	 * @generated
	 */
	int OCL_EXPRESSION_CS = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeCSImpl <em>Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeCS()
	 * @generated
	 */
	int TYPE_CS = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameCSImpl <em>Simple Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSimpleNameCS()
	 * @generated
	 */
	int SIMPLE_NAME_CS = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPathNameCS()
	 * @generated
	 */
	int PATH_NAME_CS = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionTypeCS()
	 * @generated
	 */
	int COLLECTION_TYPE_CS = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleTypeCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleTypeCS()
	 * @generated
	 */
	int TUPLE_TYPE_CS = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl <em>Variable CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getVariableCS()
	 * @generated
	 */
	int VARIABLE_CS = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl <em>Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.LiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getLiteralExpCS()
	 * @generated
	 */
	int LITERAL_EXP_CS = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralExpCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_EXP_CS = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralPartCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralPartCS()
	 * @generated
	 */
	int COLLECTION_LITERAL_PART_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PrimitiveLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPrimitiveLiteralExpCS()
	 * @generated
	 */
	int PRIMITIVE_LITERAL_EXP_CS = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TupleLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTupleLiteralExpCS()
	 * @generated
	 */
	int TUPLE_LITERAL_EXP_CS = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IntegerLiteralExpCSImpl <em>Integer Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IntegerLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIntegerLiteralExpCS()
	 * @generated
	 */
	int INTEGER_LITERAL_EXP_CS = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RealLiteralExpCSImpl <em>Real Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RealLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getRealLiteralExpCS()
	 * @generated
	 */
	int REAL_LITERAL_EXP_CS = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.StringLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getStringLiteralExpCS()
	 * @generated
	 */
	int STRING_LITERAL_EXP_CS = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BooleanLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBooleanLiteralExpCS()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXP_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnlimitedNaturalLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnlimitedNaturalLiteralExpCS()
	 * @generated
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.InvalidLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getInvalidLiteralExpCS()
	 * @generated
	 */
	int INVALID_LITERAL_EXP_CS = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.NullLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getNullLiteralExpCS()
	 * @generated
	 */
	int NULL_LITERAL_EXP_CS = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeLiteralExpCS()
	 * @generated
	 */
	int TYPE_LITERAL_EXP_CS = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallArgumentsCSImpl <em>Call Arguments CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallArgumentsCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCallArgumentsCS()
	 * @generated
	 */
	int CALL_ARGUMENTS_CS = 3;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ARGUMENTS_CS__PATH_NAME = 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ARGUMENTS_CS__ARGUMENTS = 1;

	/**
	 * The number of structural features of the '<em>Call Arguments CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_ARGUMENTS_CS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableExpCSImpl <em>Variable Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getVariableExpCS()
	 * @generated
	 */
	int VARIABLE_EXP_CS = 28;

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
	int LET_EXP_CS = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryExpressionCSImpl <em>Binary Expression CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryExpressionCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBinaryExpressionCS()
	 * @generated
	 */
	int BINARY_EXPRESSION_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryExpressionCSImpl <em>Unary Expression CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryExpressionCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnaryExpressionCS()
	 * @generated
	 */
	int UNARY_EXPRESSION_CS = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallExpCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCallExpCS()
	 * @generated
	 */
	int CALL_EXP_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ArrowCallArgumentsCSImpl <em>Arrow Call Arguments CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ArrowCallArgumentsCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getArrowCallArgumentsCS()
	 * @generated
	 */
	int ARROW_CALL_ARGUMENTS_CS = 0;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_CALL_ARGUMENTS_CS__PATH_NAME = CALL_ARGUMENTS_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_CALL_ARGUMENTS_CS__ARGUMENTS = CALL_ARGUMENTS_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Variable1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_CALL_ARGUMENTS_CS__VARIABLE1 = CALL_ARGUMENTS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_CALL_ARGUMENTS_CS__VARIABLE2 = CALL_ARGUMENTS_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_CALL_ARGUMENTS_CS__BODY = CALL_ARGUMENTS_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Arrow Call Arguments CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARROW_CALL_ARGUMENTS_CS_FEATURE_COUNT = CALL_ARGUMENTS_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ocl Expression CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_CS_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_CS__LEFT = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_CS__OP = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_CS__RIGHT = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Binary Expression CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_EXPRESSION_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS__VALUE = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__SOURCE = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS__CALL_ARGUMENTS = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = 0;

	/**
	 * The feature id for the '<em><b>Last Expression CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS = 1;

	/**
	 * The number of structural features of the '<em>Collection Literal Part CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_PART_CS_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_CS_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__VALUE = TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__TYPE_CS = TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS__COLLECTION_LITERAL_PARTS = TYPE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Collection Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DotIndexArgumentsCSImpl <em>Dot Index Arguments CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DotIndexArgumentsCSImpl
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getDotIndexArgumentsCS()
	 * @generated
	 */
	int DOT_INDEX_ARGUMENTS_CS = 8;

	/**
	 * The feature id for the '<em><b>Path Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_INDEX_ARGUMENTS_CS__PATH_NAME = CALL_ARGUMENTS_CS__PATH_NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_INDEX_ARGUMENTS_CS__ARGUMENTS = CALL_ARGUMENTS_CS__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_INDEX_ARGUMENTS_CS__INDEXES = CALL_ARGUMENTS_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_INDEX_ARGUMENTS_CS__IS_PRE = CALL_ARGUMENTS_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dot Index Arguments CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOT_INDEX_ARGUMENTS_CS_FEATURE_COUNT = CALL_ARGUMENTS_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__CONDITION = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__THEN_EXPRESSION = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS__ELSE_EXPRESSION = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Integer Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

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
	int LET_EXP_CS__VARIABLE = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS__IN = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Null Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Simple Names</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS__SIMPLE_NAMES = TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Path Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_NAME_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Real Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_CS__REAL_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAME_CS__VALUE = TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Literal Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAME_CS__COLLECTION_LITERAL_PARTS = TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Name CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NAME_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>String Symbol</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS__STRING_SYMBOL = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS__PART = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__VALUE = TYPE_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS__PART = TYPE_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tuple Type CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_TYPE_CS_FEATURE_COUNT = TYPE_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_EXP_CS_FEATURE_COUNT = LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Op</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_CS__OP = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_CS__SOURCE = OCL_EXPRESSION_CS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Unlimited Natural Literal Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNLIMITED_NATURAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS__INIT_EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Variable CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_CS_FEATURE_COUNT = 3;

	/**
	 * The number of structural features of the '<em>Variable Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_CS_FEATURE_COUNT = OCL_EXPRESSION_CS_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS <em>Ocl Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ocl Expression CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS
	 * @generated
	 */
	EClass getOclExpressionCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS <em>Simple Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Name CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS
	 * @generated
	 */
	EClass getSimpleNameCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS#getValue()
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	EAttribute getSimpleNameCS_Value();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS#getCollectionLiteralParts <em>Collection Literal Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Literal Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS#getCollectionLiteralParts()
	 * @see #getSimpleNameCS()
	 * @generated
	 */
	EReference getSimpleNameCS_CollectionLiteralParts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS <em>Path Name CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Name CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS
	 * @generated
	 */
	EClass getPathNameCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS#getSimpleNames <em>Simple Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Simple Names</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS#getSimpleNames()
	 * @see #getPathNameCS()
	 * @generated
	 */
	EReference getPathNameCS_SimpleNames();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeCS <em>Type CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeCS
	 * @generated
	 */
	EClass getTypeCS();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getValue()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_Value();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getCollectionLiteralParts <em>Collection Literal Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collection Literal Parts</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS#getCollectionLiteralParts()
	 * @see #getCollectionTypeCS()
	 * @generated
	 */
	EReference getCollectionTypeCS_CollectionLiteralParts();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleTypeCS#getValue()
	 * @see #getTupleTypeCS()
	 * @generated
	 */
	EAttribute getTupleTypeCS_Value();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS <em>Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS
	 * @generated
	 */
	EClass getVariableCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS#getName()
	 * @see #getVariableCS()
	 * @generated
	 */
	EReference getVariableCS_Name();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS
	 * @generated
	 */
	EClass getCollectionLiteralExpCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS <em>Integer Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS
	 * @generated
	 */
	EClass getIntegerLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IntegerLiteralExpCS#getIntegerSymbol()
	 * @see #getIntegerLiteralExpCS()
	 * @generated
	 */
	EAttribute getIntegerLiteralExpCS_IntegerSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS <em>Real Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS
	 * @generated
	 */
	EClass getRealLiteralExpCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS#getRealSymbol <em>Real Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real Symbol</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RealLiteralExpCS#getRealSymbol()
	 * @see #getRealLiteralExpCS()
	 * @generated
	 */
	EAttribute getRealLiteralExpCS_RealSymbol();

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
	 * Returns the meta object for the attribute list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS#getStringSymbol <em>String Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>String Symbol</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS#getStringSymbol()
	 * @see #getStringLiteralExpCS()
	 * @generated
	 */
	EAttribute getStringLiteralExpCS_StringSymbol();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS#getValue()
	 * @see #getBooleanLiteralExpCS()
	 * @generated
	 */
	EAttribute getBooleanLiteralExpCS_Value();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS
	 * @generated
	 */
	EClass getTypeLiteralExpCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS <em>Call Arguments CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Arguments CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS
	 * @generated
	 */
	EClass getCallArgumentsCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS#getPathName <em>Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Path Name</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS#getPathName()
	 * @see #getCallArgumentsCS()
	 * @generated
	 */
	EReference getCallArgumentsCS_PathName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallArgumentsCS#getArguments()
	 * @see #getCallArgumentsCS()
	 * @generated
	 */
	EReference getCallArgumentsCS_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableExpCS <em>Variable Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableExpCS
	 * @generated
	 */
	EClass getVariableExpCS();

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
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS <em>Binary Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Expression CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS
	 * @generated
	 */
	EClass getBinaryExpressionCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS#getLeft()
	 * @see #getBinaryExpressionCS()
	 * @generated
	 */
	EReference getBinaryExpressionCS_Left();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS#getOp()
	 * @see #getBinaryExpressionCS()
	 * @generated
	 */
	EAttribute getBinaryExpressionCS_Op();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryExpressionCS#getRight()
	 * @see #getBinaryExpressionCS()
	 * @generated
	 */
	EReference getBinaryExpressionCS_Right();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS <em>Unary Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS
	 * @generated
	 */
	EClass getUnaryExpressionCS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS#getOp <em>Op</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Op</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS#getOp()
	 * @see #getUnaryExpressionCS()
	 * @generated
	 */
	EAttribute getUnaryExpressionCS_Op();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryExpressionCS#getSource()
	 * @see #getUnaryExpressionCS()
	 * @generated
	 */
	EReference getUnaryExpressionCS_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS <em>Call Exp CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS
	 * @generated
	 */
	EClass getCallExpCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS#getSource()
	 * @see #getCallExpCS()
	 * @generated
	 */
	EReference getCallExpCS_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS#getCallArguments <em>Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Call Arguments</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CallExpCS#getCallArguments()
	 * @see #getCallExpCS()
	 * @generated
	 */
	EReference getCallExpCS_CallArguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS <em>Arrow Call Arguments CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arrow Call Arguments CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS
	 * @generated
	 */
	EClass getArrowCallArgumentsCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable1 <em>Variable1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable1</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable1()
	 * @see #getArrowCallArgumentsCS()
	 * @generated
	 */
	EReference getArrowCallArgumentsCS_Variable1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable2 <em>Variable2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable2</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable2()
	 * @see #getArrowCallArgumentsCS()
	 * @generated
	 */
	EReference getArrowCallArgumentsCS_Variable2();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getBody()
	 * @see #getArrowCallArgumentsCS()
	 * @generated
	 */
	EReference getArrowCallArgumentsCS_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS <em>Dot Index Arguments CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dot Index Arguments CS</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS
	 * @generated
	 */
	EClass getDotIndexArgumentsCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS#getIndexes <em>Indexes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Indexes</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS#getIndexes()
	 * @see #getDotIndexArgumentsCS()
	 * @generated
	 */
	EReference getDotIndexArgumentsCS_Indexes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS#isIsPre <em>Is Pre</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Pre</em>'.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotIndexArgumentsCS#isIsPre()
	 * @see #getDotIndexArgumentsCS()
	 * @generated
	 */
	EAttribute getDotIndexArgumentsCS_IsPre();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OclExpressionCSImpl <em>Ocl Expression CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.OclExpressionCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getOclExpressionCS()
		 * @generated
		 */
		EClass OCL_EXPRESSION_CS = eINSTANCE.getOclExpressionCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameCSImpl <em>Simple Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.SimpleNameCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getSimpleNameCS()
		 * @generated
		 */
		EClass SIMPLE_NAME_CS = eINSTANCE.getSimpleNameCS();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_NAME_CS__VALUE = eINSTANCE.getSimpleNameCS_Value();

		/**
		 * The meta object literal for the '<em><b>Collection Literal Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_NAME_CS__COLLECTION_LITERAL_PARTS = eINSTANCE.getSimpleNameCS_CollectionLiteralParts();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getPathNameCS()
		 * @generated
		 */
		EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

		/**
		 * The meta object literal for the '<em><b>Simple Names</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_NAME_CS__SIMPLE_NAMES = eINSTANCE.getPathNameCS_SimpleNames();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeCSImpl <em>Type CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeCS()
		 * @generated
		 */
		EClass TYPE_CS = eINSTANCE.getTypeCS();

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
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__VALUE = eINSTANCE.getCollectionTypeCS_Value();

		/**
		 * The meta object literal for the '<em><b>Type CS</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__TYPE_CS = eINSTANCE.getCollectionTypeCS_TypeCS();

		/**
		 * The meta object literal for the '<em><b>Collection Literal Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_CS__COLLECTION_LITERAL_PARTS = eINSTANCE.getCollectionTypeCS_CollectionLiteralParts();

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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TUPLE_TYPE_CS__VALUE = eINSTANCE.getTupleTypeCS_Value();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_TYPE_CS__PART = eINSTANCE.getTupleTypeCS_Part();

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
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_CS__NAME = eINSTANCE.getVariableCS_Name();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CollectionLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCollectionLiteralExpCS()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP_CS = eINSTANCE.getCollectionLiteralExpCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IntegerLiteralExpCSImpl <em>Integer Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.IntegerLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getIntegerLiteralExpCS()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP_CS = eINSTANCE.getIntegerLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP_CS__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExpCS_IntegerSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RealLiteralExpCSImpl <em>Real Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.RealLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getRealLiteralExpCS()
		 * @generated
		 */
		EClass REAL_LITERAL_EXP_CS = eINSTANCE.getRealLiteralExpCS();

		/**
		 * The meta object literal for the '<em><b>Real Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL_EXP_CS__REAL_SYMBOL = eINSTANCE.getRealLiteralExpCS_RealSymbol();

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
		 * The meta object literal for the '<em><b>String Symbol</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXP_CS__STRING_SYMBOL = eINSTANCE.getStringLiteralExpCS_StringSymbol();

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
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP_CS__VALUE = eINSTANCE.getBooleanLiteralExpCS_Value();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.TypeLiteralExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getTypeLiteralExpCS()
		 * @generated
		 */
		EClass TYPE_LITERAL_EXP_CS = eINSTANCE.getTypeLiteralExpCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallArgumentsCSImpl <em>Call Arguments CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallArgumentsCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCallArgumentsCS()
		 * @generated
		 */
		EClass CALL_ARGUMENTS_CS = eINSTANCE.getCallArgumentsCS();

		/**
		 * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_ARGUMENTS_CS__PATH_NAME = eINSTANCE.getCallArgumentsCS_PathName();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_ARGUMENTS_CS__ARGUMENTS = eINSTANCE.getCallArgumentsCS_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableExpCSImpl <em>Variable Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.VariableExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getVariableExpCS()
		 * @generated
		 */
		EClass VARIABLE_EXP_CS = eINSTANCE.getVariableExpCS();

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
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryExpressionCSImpl <em>Binary Expression CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.BinaryExpressionCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getBinaryExpressionCS()
		 * @generated
		 */
		EClass BINARY_EXPRESSION_CS = eINSTANCE.getBinaryExpressionCS();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION_CS__LEFT = eINSTANCE.getBinaryExpressionCS_Left();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINARY_EXPRESSION_CS__OP = eINSTANCE.getBinaryExpressionCS_Op();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINARY_EXPRESSION_CS__RIGHT = eINSTANCE.getBinaryExpressionCS_Right();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryExpressionCSImpl <em>Unary Expression CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.UnaryExpressionCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getUnaryExpressionCS()
		 * @generated
		 */
		EClass UNARY_EXPRESSION_CS = eINSTANCE.getUnaryExpressionCS();

		/**
		 * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION_CS__OP = eINSTANCE.getUnaryExpressionCS_Op();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION_CS__SOURCE = eINSTANCE.getUnaryExpressionCS_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallExpCSImpl <em>Call Exp CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.CallExpCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getCallExpCS()
		 * @generated
		 */
		EClass CALL_EXP_CS = eINSTANCE.getCallExpCS();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_CS__SOURCE = eINSTANCE.getCallExpCS_Source();

		/**
		 * The meta object literal for the '<em><b>Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP_CS__CALL_ARGUMENTS = eINSTANCE.getCallExpCS_CallArguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ArrowCallArgumentsCSImpl <em>Arrow Call Arguments CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ArrowCallArgumentsCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getArrowCallArgumentsCS()
		 * @generated
		 */
		EClass ARROW_CALL_ARGUMENTS_CS = eINSTANCE.getArrowCallArgumentsCS();

		/**
		 * The meta object literal for the '<em><b>Variable1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_CALL_ARGUMENTS_CS__VARIABLE1 = eINSTANCE.getArrowCallArgumentsCS_Variable1();

		/**
		 * The meta object literal for the '<em><b>Variable2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_CALL_ARGUMENTS_CS__VARIABLE2 = eINSTANCE.getArrowCallArgumentsCS_Variable2();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARROW_CALL_ARGUMENTS_CS__BODY = eINSTANCE.getArrowCallArgumentsCS_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DotIndexArgumentsCSImpl <em>Dot Index Arguments CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.DotIndexArgumentsCSImpl
		 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.EssentialOCLCSTPackageImpl#getDotIndexArgumentsCS()
		 * @generated
		 */
		EClass DOT_INDEX_ARGUMENTS_CS = eINSTANCE.getDotIndexArgumentsCS();

		/**
		 * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOT_INDEX_ARGUMENTS_CS__INDEXES = eINSTANCE.getDotIndexArgumentsCS_Indexes();

		/**
		 * The meta object literal for the '<em><b>Is Pre</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOT_INDEX_ARGUMENTS_CS__IS_PRE = eINSTANCE.getDotIndexArgumentsCS_IsPre();

	}

} //EssentialOCLCSTPackage
