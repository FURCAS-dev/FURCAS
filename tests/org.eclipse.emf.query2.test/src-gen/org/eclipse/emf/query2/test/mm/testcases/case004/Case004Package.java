/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case004;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Factory
 * @model kind="package"
 * @generated
 */
public interface Case004Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case004";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case004";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case004";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case004Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl <em>A4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getA4()
	 * @generated
	 */
	int A4 = 0;

	/**
	 * The feature id for the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__ONE_PRIMITIVE = 0;

	/**
	 * The feature id for the '<em><b>One Primitive Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__ONE_PRIMITIVE_OPTIONAL = 1;

	/**
	 * The feature id for the '<em><b>One Primitive Not Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__ONE_PRIMITIVE_NOT_CHANGEABLE = 2;

	/**
	 * The feature id for the '<em><b>Many Primitive</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE = 3;

	/**
	 * The feature id for the '<em><b>Many Primitive Double</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_DOUBLE = 4;

	/**
	 * The feature id for the '<em><b>Many Primitive Unique</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_UNIQUE = 5;

	/**
	 * The feature id for the '<em><b>Many Primitive Optional</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_OPTIONAL = 6;

	/**
	 * The feature id for the '<em><b>Many Primitive Not Changeable</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_NOT_CHANGEABLE = 7;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_ORDERED = 8;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered Unique</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_ORDERED_UNIQUE = 9;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered Not Changeable</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE = 10;

	/**
	 * The feature id for the '<em><b>One BChangeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__ONE_BCHANGEABLE = 11;

	/**
	 * The feature id for the '<em><b>One BNot Changeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__ONE_BNOT_CHANGEABLE = 12;

	/**
	 * The feature id for the '<em><b>One BOptional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__ONE_BOPTIONAL = 13;

	/**
	 * The feature id for the '<em><b>Many Bs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS = 14;

	/**
	 * The feature id for the '<em><b>Many Bs Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS_UNIQUE = 15;

	/**
	 * The feature id for the '<em><b>Many Bs Not Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS_NOT_UNIQUE = 16;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS_ORDERED = 17;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS_ORDERED_UNIQUE = 18;

	/**
	 * The feature id for the '<em><b>Many Bs Not Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS_NOT_ORDERED = 19;

	/**
	 * The feature id for the '<em><b>Many Bs Not Changeable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4__MANY_BS_NOT_CHANGEABLE = 20;

	/**
	 * The number of structural features of the '<em>A4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_FEATURE_COUNT = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4HasConstantImpl <em>B4 Has Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4HasConstantImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getB4HasConstant()
	 * @generated
	 */
	int B4_HAS_CONSTANT = 1;

	/**
	 * The number of structural features of the '<em>B4 Has Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B4_HAS_CONSTANT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4Impl <em>C4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getC4()
	 * @generated
	 */
	int C4 = 2;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4__PRIMITIVE = 0;

	/**
	 * The feature id for the '<em><b>Complex</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4__COMPLEX = 1;

	/**
	 * The number of structural features of the '<em>C4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl <em>D4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getD4()
	 * @generated
	 */
	int D4 = 3;

	/**
	 * The feature id for the '<em><b>Attribute Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_BOOLEAN = 0;

	/**
	 * The feature id for the '<em><b>Attribute Boolean Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_BOOLEAN_OPTIONAL = 1;

	/**
	 * The feature id for the '<em><b>Attribute Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_DOUBLE = 2;

	/**
	 * The feature id for the '<em><b>Attribute Double Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_DOUBLE_OPTIONAL = 3;

	/**
	 * The feature id for the '<em><b>Attribute Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_FLOAT = 4;

	/**
	 * The feature id for the '<em><b>Attribute Float Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_FLOAT_OPTIONAL = 5;

	/**
	 * The feature id for the '<em><b>Attribute Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_INTEGER = 6;

	/**
	 * The feature id for the '<em><b>Attribute Integer Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_INTEGER_OPTIONAL = 7;

	/**
	 * The feature id for the '<em><b>Attribute Long</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_LONG = 8;

	/**
	 * The feature id for the '<em><b>Attribute Long Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_LONG_OPTIONAL = 9;

	/**
	 * The feature id for the '<em><b>Attribute String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_STRING = 10;

	/**
	 * The feature id for the '<em><b>Attribute String Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4__ATTRIBUTE_STRING_OPTIONAL = 11;

	/**
	 * The number of structural features of the '<em>D4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4Impl <em>B4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getB4()
	 * @generated
	 */
	int B4 = 4;

	/**
	 * The feature id for the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B4__ONE_PRIMITIVE = 0;

	/**
	 * The number of structural features of the '<em>B4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B4_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl <em>F4</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getF4()
	 * @generated
	 */
	int F4 = 5;

	/**
	 * The feature id for the '<em><b>One C</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4__ONE_C = 0;

	/**
	 * The feature id for the '<em><b>Many Cs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4__MANY_CS = 1;

	/**
	 * The feature id for the '<em><b>Many Cs Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4__MANY_CS_ORDERED = 2;

	/**
	 * The number of structural features of the '<em>F4</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4SubImpl <em>A4 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getA4Sub()
	 * @generated
	 */
	int A4_SUB = 6;

	/**
	 * The feature id for the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__ONE_PRIMITIVE = A4__ONE_PRIMITIVE;

	/**
	 * The feature id for the '<em><b>One Primitive Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__ONE_PRIMITIVE_OPTIONAL = A4__ONE_PRIMITIVE_OPTIONAL;

	/**
	 * The feature id for the '<em><b>One Primitive Not Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__ONE_PRIMITIVE_NOT_CHANGEABLE = A4__ONE_PRIMITIVE_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Many Primitive</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE = A4__MANY_PRIMITIVE;

	/**
	 * The feature id for the '<em><b>Many Primitive Double</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_DOUBLE = A4__MANY_PRIMITIVE_DOUBLE;

	/**
	 * The feature id for the '<em><b>Many Primitive Unique</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_UNIQUE = A4__MANY_PRIMITIVE_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Primitive Optional</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_OPTIONAL = A4__MANY_PRIMITIVE_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Many Primitive Not Changeable</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_NOT_CHANGEABLE = A4__MANY_PRIMITIVE_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_ORDERED = A4__MANY_PRIMITIVE_ORDERED;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered Unique</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_ORDERED_UNIQUE = A4__MANY_PRIMITIVE_ORDERED_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered Not Changeable</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE = A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>One BChangeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__ONE_BCHANGEABLE = A4__ONE_BCHANGEABLE;

	/**
	 * The feature id for the '<em><b>One BNot Changeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__ONE_BNOT_CHANGEABLE = A4__ONE_BNOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>One BOptional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__ONE_BOPTIONAL = A4__ONE_BOPTIONAL;

	/**
	 * The feature id for the '<em><b>Many Bs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS = A4__MANY_BS;

	/**
	 * The feature id for the '<em><b>Many Bs Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS_UNIQUE = A4__MANY_BS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Bs Not Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS_NOT_UNIQUE = A4__MANY_BS_NOT_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS_ORDERED = A4__MANY_BS_ORDERED;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS_ORDERED_UNIQUE = A4__MANY_BS_ORDERED_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Bs Not Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS_NOT_ORDERED = A4__MANY_BS_NOT_ORDERED;

	/**
	 * The feature id for the '<em><b>Many Bs Not Changeable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB__MANY_BS_NOT_CHANGEABLE = A4__MANY_BS_NOT_CHANGEABLE;

	/**
	 * The number of structural features of the '<em>A4 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A4_SUB_FEATURE_COUNT = A4_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4SubImpl <em>D4 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getD4Sub()
	 * @generated
	 */
	int D4_SUB = 7;

	/**
	 * The feature id for the '<em><b>Attribute Boolean</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_BOOLEAN = D4__ATTRIBUTE_BOOLEAN;

	/**
	 * The feature id for the '<em><b>Attribute Boolean Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_BOOLEAN_OPTIONAL = D4__ATTRIBUTE_BOOLEAN_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Attribute Double</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_DOUBLE = D4__ATTRIBUTE_DOUBLE;

	/**
	 * The feature id for the '<em><b>Attribute Double Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_DOUBLE_OPTIONAL = D4__ATTRIBUTE_DOUBLE_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Attribute Float</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_FLOAT = D4__ATTRIBUTE_FLOAT;

	/**
	 * The feature id for the '<em><b>Attribute Float Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_FLOAT_OPTIONAL = D4__ATTRIBUTE_FLOAT_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Attribute Integer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_INTEGER = D4__ATTRIBUTE_INTEGER;

	/**
	 * The feature id for the '<em><b>Attribute Integer Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_INTEGER_OPTIONAL = D4__ATTRIBUTE_INTEGER_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Attribute Long</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_LONG = D4__ATTRIBUTE_LONG;

	/**
	 * The feature id for the '<em><b>Attribute Long Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_LONG_OPTIONAL = D4__ATTRIBUTE_LONG_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Attribute String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_STRING = D4__ATTRIBUTE_STRING;

	/**
	 * The feature id for the '<em><b>Attribute String Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB__ATTRIBUTE_STRING_OPTIONAL = D4__ATTRIBUTE_STRING_OPTIONAL;

	/**
	 * The number of structural features of the '<em>D4 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D4_SUB_FEATURE_COUNT = D4_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4SubImpl <em>C4 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getC4Sub()
	 * @generated
	 */
	int C4_SUB = 8;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4_SUB__PRIMITIVE = C4__PRIMITIVE;

	/**
	 * The feature id for the '<em><b>Complex</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4_SUB__COMPLEX = C4__COMPLEX;

	/**
	 * The number of structural features of the '<em>C4 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C4_SUB_FEATURE_COUNT = C4_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4SubImpl <em>F4 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getF4Sub()
	 * @generated
	 */
	int F4_SUB = 9;

	/**
	 * The feature id for the '<em><b>One C</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4_SUB__ONE_C = F4__ONE_C;

	/**
	 * The feature id for the '<em><b>Many Cs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4_SUB__MANY_CS = F4__MANY_CS;

	/**
	 * The feature id for the '<em><b>Many Cs Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4_SUB__MANY_CS_ORDERED = F4__MANY_CS_ORDERED;

	/**
	 * The number of structural features of the '<em>F4 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F4_SUB_FEATURE_COUNT = F4_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.hasCsImpl <em>has Cs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.hasCsImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#gethasCs()
	 * @generated
	 */
	int HAS_CS = 10;

	/**
	 * The feature id for the '<em><b>F</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_CS__F = 0;

	/**
	 * The feature id for the '<em><b>C</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_CS__C = 1;

	/**
	 * The number of structural features of the '<em>has Cs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_CS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsImpl <em>composes Cs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getcomposesCs()
	 * @generated
	 */
	int COMPOSES_CS = 11;

	/**
	 * The feature id for the '<em><b>My F</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_CS__MY_F = 0;

	/**
	 * The feature id for the '<em><b>My Cs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_CS__MY_CS = 1;

	/**
	 * The number of structural features of the '<em>composes Cs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_CS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesBImpl <em>composes B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesBImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getcomposesB()
	 * @generated
	 */
	int COMPOSES_B = 12;

	/**
	 * The feature id for the '<em><b>My B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_B__MY_B = 0;

	/**
	 * The feature id for the '<em><b>My F</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_B__MY_F = 1;

	/**
	 * The number of structural features of the '<em>composes B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_B_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsOrderedImpl <em>composes Cs Ordered</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsOrderedImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getcomposesCsOrdered()
	 * @generated
	 */
	int COMPOSES_CS_ORDERED = 13;

	/**
	 * The feature id for the '<em><b>My F</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_CS_ORDERED__MY_F = 0;

	/**
	 * The feature id for the '<em><b>My Cs Ordered</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_CS_ORDERED__MY_CS_ORDERED = 1;

	/**
	 * The number of structural features of the '<em>composes Cs Ordered</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSES_CS_ORDERED_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4 <em>A4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A4</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4
	 * @generated
	 */
	EClass getA4();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitive <em>One Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Primitive</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitive()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_OnePrimitive();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveOptional <em>One Primitive Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Primitive Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveOptional()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_OnePrimitiveOptional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveNotChangeable <em>One Primitive Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Primitive Not Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOnePrimitiveNotChangeable()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_OnePrimitiveNotChangeable();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitive <em>Many Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitive()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitive();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveDouble <em>Many Primitive Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Double</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveDouble()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveDouble();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveUnique <em>Many Primitive Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Unique</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveUnique()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveUnique();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOptional <em>Many Primitive Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOptional()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveOptional();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveNotChangeable <em>Many Primitive Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Not Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveNotChangeable()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveNotChangeable();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrdered <em>Many Primitive Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrdered()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveOrdered();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrderedUnique <em>Many Primitive Ordered Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Ordered Unique</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrderedUnique()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveOrderedUnique();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrderedNotChangeable <em>Many Primitive Ordered Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Many Primitive Ordered Not Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyPrimitiveOrderedNotChangeable()
	 * @see #getA4()
	 * @generated
	 */
	EAttribute getA4_ManyPrimitiveOrderedNotChangeable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBChangeable <em>One BChangeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One BChangeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBChangeable()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_OneBChangeable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBNotChangeable <em>One BNot Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One BNot Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBNotChangeable()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_OneBNotChangeable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBOptional <em>One BOptional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One BOptional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getOneBOptional()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_OneBOptional();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBs <em>Many Bs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBs()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsUnique <em>Many Bs Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs Unique</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsUnique()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBsUnique();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotUnique <em>Many Bs Not Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs Not Unique</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotUnique()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBsNotUnique();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsOrdered <em>Many Bs Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsOrdered()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBsOrdered();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsOrderedUnique <em>Many Bs Ordered Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs Ordered Unique</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsOrderedUnique()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBsOrderedUnique();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotOrdered <em>Many Bs Not Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs Not Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotOrdered()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBsNotOrdered();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Bs Not Changeable</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4#getManyBsNotChangeable()
	 * @see #getA4()
	 * @generated
	 */
	EReference getA4_ManyBsNotChangeable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.B4HasConstant <em>B4 Has Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B4 Has Constant</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.B4HasConstant
	 * @generated
	 */
	EClass getB4HasConstant();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4 <em>C4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C4</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.C4
	 * @generated
	 */
	EClass getC4();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.C4#getPrimitive()
	 * @see #getC4()
	 * @generated
	 */
	EAttribute getC4_Primitive();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4#getComplex <em>Complex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Complex</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.C4#getComplex()
	 * @see #getC4()
	 * @generated
	 */
	EReference getC4_Complex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4 <em>D4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D4</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4
	 * @generated
	 */
	EClass getD4();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#isAttributeBoolean <em>Attribute Boolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Boolean</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#isAttributeBoolean()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeBoolean();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeBooleanOptional <em>Attribute Boolean Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Boolean Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeBooleanOptional()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeBooleanOptional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeDouble <em>Attribute Double</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Double</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeDouble()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeDouble();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeDoubleOptional <em>Attribute Double Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Double Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeDoubleOptional()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeDoubleOptional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeFloat <em>Attribute Float</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Float</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeFloat()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeFloat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeFloatOptional <em>Attribute Float Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Float Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeFloatOptional()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeFloatOptional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeInteger <em>Attribute Integer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Integer</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeInteger()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeInteger();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeIntegerOptional <em>Attribute Integer Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Integer Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeIntegerOptional()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeIntegerOptional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeLong <em>Attribute Long</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Long</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeLong()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeLong();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeLongOptional <em>Attribute Long Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Long Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeLongOptional()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeLongOptional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeString <em>Attribute String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute String</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeString()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeString();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeStringOptional <em>Attribute String Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute String Optional</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4#getAttributeStringOptional()
	 * @see #getD4()
	 * @generated
	 */
	EAttribute getD4_AttributeStringOptional();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.B4 <em>B4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B4</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.B4
	 * @generated
	 */
	EClass getB4();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case004.B4#getOnePrimitive <em>One Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Primitive</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.B4#getOnePrimitive()
	 * @see #getB4()
	 * @generated
	 */
	EAttribute getB4_OnePrimitive();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4 <em>F4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>F4</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.F4
	 * @generated
	 */
	EClass getF4();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getOneC <em>One C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>One C</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.F4#getOneC()
	 * @see #getF4()
	 * @generated
	 */
	EReference getF4_OneC();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getManyCs <em>Many Cs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Cs</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.F4#getManyCs()
	 * @see #getF4()
	 * @generated
	 */
	EReference getF4_ManyCs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4#getManyCsOrdered <em>Many Cs Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Many Cs Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.F4#getManyCsOrdered()
	 * @see #getF4()
	 * @generated
	 */
	EReference getF4_ManyCsOrdered();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.A4Sub <em>A4 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A4 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.A4Sub
	 * @generated
	 */
	EClass getA4Sub();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.D4Sub <em>D4 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D4 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.D4Sub
	 * @generated
	 */
	EClass getD4Sub();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.C4Sub <em>C4 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C4 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.C4Sub
	 * @generated
	 */
	EClass getC4Sub();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.F4Sub <em>F4 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>F4 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.F4Sub
	 * @generated
	 */
	EClass getF4Sub();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.hasCs <em>has Cs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>has Cs</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.hasCs
	 * @generated
	 */
	EClass gethasCs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getF <em>F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>F</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getF()
	 * @see #gethasCs()
	 * @generated
	 */
	EReference gethasCs_F();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>C</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getC()
	 * @see #gethasCs()
	 * @generated
	 */
	EReference gethasCs_C();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCs <em>composes Cs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>composes Cs</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesCs
	 * @generated
	 */
	EClass getcomposesCs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyF <em>My F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>My F</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyF()
	 * @see #getcomposesCs()
	 * @generated
	 */
	EReference getcomposesCs_MyF();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyCs <em>My Cs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>My Cs</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyCs()
	 * @see #getcomposesCs()
	 * @generated
	 */
	EReference getcomposesCs_MyCs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesB <em>composes B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>composes B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesB
	 * @generated
	 */
	EClass getcomposesB();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesB#getMyB <em>My B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>My B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesB#getMyB()
	 * @see #getcomposesB()
	 * @generated
	 */
	EReference getcomposesB_MyB();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesB#getMyF <em>My F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>My F</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesB#getMyF()
	 * @see #getcomposesB()
	 * @generated
	 */
	EReference getcomposesB_MyF();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered <em>composes Cs Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>composes Cs Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered
	 * @generated
	 */
	EClass getcomposesCsOrdered();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyF <em>My F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>My F</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyF()
	 * @see #getcomposesCsOrdered()
	 * @generated
	 */
	EReference getcomposesCsOrdered_MyF();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyCsOrdered <em>My Cs Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>My Cs Ordered</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyCsOrdered()
	 * @see #getcomposesCsOrdered()
	 * @generated
	 */
	EReference getcomposesCsOrdered_MyCsOrdered();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case004Factory getCase004Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl <em>A4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getA4()
		 * @generated
		 */
		EClass A4 = eINSTANCE.getA4();

		/**
		 * The meta object literal for the '<em><b>One Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__ONE_PRIMITIVE = eINSTANCE.getA4_OnePrimitive();

		/**
		 * The meta object literal for the '<em><b>One Primitive Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__ONE_PRIMITIVE_OPTIONAL = eINSTANCE.getA4_OnePrimitiveOptional();

		/**
		 * The meta object literal for the '<em><b>One Primitive Not Changeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__ONE_PRIMITIVE_NOT_CHANGEABLE = eINSTANCE.getA4_OnePrimitiveNotChangeable();

		/**
		 * The meta object literal for the '<em><b>Many Primitive</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE = eINSTANCE.getA4_ManyPrimitive();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Double</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_DOUBLE = eINSTANCE.getA4_ManyPrimitiveDouble();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Unique</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_UNIQUE = eINSTANCE.getA4_ManyPrimitiveUnique();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Optional</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_OPTIONAL = eINSTANCE.getA4_ManyPrimitiveOptional();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Not Changeable</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_NOT_CHANGEABLE = eINSTANCE.getA4_ManyPrimitiveNotChangeable();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Ordered</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_ORDERED = eINSTANCE.getA4_ManyPrimitiveOrdered();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Ordered Unique</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_ORDERED_UNIQUE = eINSTANCE.getA4_ManyPrimitiveOrderedUnique();

		/**
		 * The meta object literal for the '<em><b>Many Primitive Ordered Not Changeable</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE = eINSTANCE.getA4_ManyPrimitiveOrderedNotChangeable();

		/**
		 * The meta object literal for the '<em><b>One BChangeable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__ONE_BCHANGEABLE = eINSTANCE.getA4_OneBChangeable();

		/**
		 * The meta object literal for the '<em><b>One BNot Changeable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__ONE_BNOT_CHANGEABLE = eINSTANCE.getA4_OneBNotChangeable();

		/**
		 * The meta object literal for the '<em><b>One BOptional</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__ONE_BOPTIONAL = eINSTANCE.getA4_OneBOptional();

		/**
		 * The meta object literal for the '<em><b>Many Bs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS = eINSTANCE.getA4_ManyBs();

		/**
		 * The meta object literal for the '<em><b>Many Bs Unique</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS_UNIQUE = eINSTANCE.getA4_ManyBsUnique();

		/**
		 * The meta object literal for the '<em><b>Many Bs Not Unique</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS_NOT_UNIQUE = eINSTANCE.getA4_ManyBsNotUnique();

		/**
		 * The meta object literal for the '<em><b>Many Bs Ordered</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS_ORDERED = eINSTANCE.getA4_ManyBsOrdered();

		/**
		 * The meta object literal for the '<em><b>Many Bs Ordered Unique</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS_ORDERED_UNIQUE = eINSTANCE.getA4_ManyBsOrderedUnique();

		/**
		 * The meta object literal for the '<em><b>Many Bs Not Ordered</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS_NOT_ORDERED = eINSTANCE.getA4_ManyBsNotOrdered();

		/**
		 * The meta object literal for the '<em><b>Many Bs Not Changeable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A4__MANY_BS_NOT_CHANGEABLE = eINSTANCE.getA4_ManyBsNotChangeable();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4HasConstantImpl <em>B4 Has Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4HasConstantImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getB4HasConstant()
		 * @generated
		 */
		EClass B4_HAS_CONSTANT = eINSTANCE.getB4HasConstant();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4Impl <em>C4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getC4()
		 * @generated
		 */
		EClass C4 = eINSTANCE.getC4();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute C4__PRIMITIVE = eINSTANCE.getC4_Primitive();

		/**
		 * The meta object literal for the '<em><b>Complex</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C4__COMPLEX = eINSTANCE.getC4_Complex();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl <em>D4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getD4()
		 * @generated
		 */
		EClass D4 = eINSTANCE.getD4();

		/**
		 * The meta object literal for the '<em><b>Attribute Boolean</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_BOOLEAN = eINSTANCE.getD4_AttributeBoolean();

		/**
		 * The meta object literal for the '<em><b>Attribute Boolean Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_BOOLEAN_OPTIONAL = eINSTANCE.getD4_AttributeBooleanOptional();

		/**
		 * The meta object literal for the '<em><b>Attribute Double</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_DOUBLE = eINSTANCE.getD4_AttributeDouble();

		/**
		 * The meta object literal for the '<em><b>Attribute Double Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_DOUBLE_OPTIONAL = eINSTANCE.getD4_AttributeDoubleOptional();

		/**
		 * The meta object literal for the '<em><b>Attribute Float</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_FLOAT = eINSTANCE.getD4_AttributeFloat();

		/**
		 * The meta object literal for the '<em><b>Attribute Float Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_FLOAT_OPTIONAL = eINSTANCE.getD4_AttributeFloatOptional();

		/**
		 * The meta object literal for the '<em><b>Attribute Integer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_INTEGER = eINSTANCE.getD4_AttributeInteger();

		/**
		 * The meta object literal for the '<em><b>Attribute Integer Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_INTEGER_OPTIONAL = eINSTANCE.getD4_AttributeIntegerOptional();

		/**
		 * The meta object literal for the '<em><b>Attribute Long</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_LONG = eINSTANCE.getD4_AttributeLong();

		/**
		 * The meta object literal for the '<em><b>Attribute Long Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_LONG_OPTIONAL = eINSTANCE.getD4_AttributeLongOptional();

		/**
		 * The meta object literal for the '<em><b>Attribute String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_STRING = eINSTANCE.getD4_AttributeString();

		/**
		 * The meta object literal for the '<em><b>Attribute String Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute D4__ATTRIBUTE_STRING_OPTIONAL = eINSTANCE.getD4_AttributeStringOptional();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4Impl <em>B4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.B4Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getB4()
		 * @generated
		 */
		EClass B4 = eINSTANCE.getB4();

		/**
		 * The meta object literal for the '<em><b>One Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B4__ONE_PRIMITIVE = eINSTANCE.getB4_OnePrimitive();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl <em>F4</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getF4()
		 * @generated
		 */
		EClass F4 = eINSTANCE.getF4();

		/**
		 * The meta object literal for the '<em><b>One C</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference F4__ONE_C = eINSTANCE.getF4_OneC();

		/**
		 * The meta object literal for the '<em><b>Many Cs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference F4__MANY_CS = eINSTANCE.getF4_ManyCs();

		/**
		 * The meta object literal for the '<em><b>Many Cs Ordered</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference F4__MANY_CS_ORDERED = eINSTANCE.getF4_ManyCsOrdered();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4SubImpl <em>A4 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getA4Sub()
		 * @generated
		 */
		EClass A4_SUB = eINSTANCE.getA4Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4SubImpl <em>D4 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getD4Sub()
		 * @generated
		 */
		EClass D4_SUB = eINSTANCE.getD4Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4SubImpl <em>C4 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.C4SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getC4Sub()
		 * @generated
		 */
		EClass C4_SUB = eINSTANCE.getC4Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4SubImpl <em>F4 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.F4SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getF4Sub()
		 * @generated
		 */
		EClass F4_SUB = eINSTANCE.getF4Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.hasCsImpl <em>has Cs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.hasCsImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#gethasCs()
		 * @generated
		 */
		EClass HAS_CS = eINSTANCE.gethasCs();

		/**
		 * The meta object literal for the '<em><b>F</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_CS__F = eINSTANCE.gethasCs_F();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_CS__C = eINSTANCE.gethasCs_C();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsImpl <em>composes Cs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getcomposesCs()
		 * @generated
		 */
		EClass COMPOSES_CS = eINSTANCE.getcomposesCs();

		/**
		 * The meta object literal for the '<em><b>My F</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSES_CS__MY_F = eINSTANCE.getcomposesCs_MyF();

		/**
		 * The meta object literal for the '<em><b>My Cs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSES_CS__MY_CS = eINSTANCE.getcomposesCs_MyCs();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesBImpl <em>composes B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesBImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getcomposesB()
		 * @generated
		 */
		EClass COMPOSES_B = eINSTANCE.getcomposesB();

		/**
		 * The meta object literal for the '<em><b>My B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSES_B__MY_B = eINSTANCE.getcomposesB_MyB();

		/**
		 * The meta object literal for the '<em><b>My F</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSES_B__MY_F = eINSTANCE.getcomposesB_MyF();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsOrderedImpl <em>composes Cs Ordered</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.composesCsOrderedImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case004.impl.Case004PackageImpl#getcomposesCsOrdered()
		 * @generated
		 */
		EClass COMPOSES_CS_ORDERED = eINSTANCE.getcomposesCsOrdered();

		/**
		 * The meta object literal for the '<em><b>My F</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSES_CS_ORDERED__MY_F = eINSTANCE.getcomposesCsOrdered_MyF();

		/**
		 * The meta object literal for the '<em><b>My Cs Ordered</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSES_CS_ORDERED__MY_CS_ORDERED = eINSTANCE.getcomposesCsOrdered_MyCsOrdered();

	}

} //Case004Package
