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
package org.eclipse.emf.query2.test.mm.testcases.case013;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.emf.query2.test.mm.testcases.case013.Case013Factory
 * @model kind="package"
 * @generated
 */
public interface Case013Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case013"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case013"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case013"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case013Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.A13Impl <em>A13</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.A13Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getA13()
	 * @generated
	 */
	int A13 = 0;

	/**
	 * The feature id for the '<em><b>Constrained Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A13__CONSTRAINED_ATTRIBUTE1 = 0;

	/**
	 * The feature id for the '<em><b>Constrained Attribute Many1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A13__CONSTRAINED_ATTRIBUTE_MANY1 = 1;

	/**
	 * The number of structural features of the '<em>A13</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A13_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl <em>B13</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13()
	 * @generated
	 */
	int B13 = 1;

	/**
	 * The feature id for the '<em><b>Initialized Integer Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13__INITIALIZED_INTEGER_ATTRIBUTE1 = 0;

	/**
	 * The feature id for the '<em><b>Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13__INITIALIZED_STRING_ATTRIBUTE1 = 1;

	/**
	 * The feature id for the '<em><b>Initialized Boolean Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13__INITIALIZED_BOOLEAN_ATTRIBUTE1 = 2;

	/**
	 * The feature id for the '<em><b>Initialized Double Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13__INITIALIZED_DOUBLE_ATTRIBUTE1 = 3;

	/**
	 * The feature id for the '<em><b>Not Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13__NOT_INITIALIZED_STRING_ATTRIBUTE1 = 4;

	/**
	 * The feature id for the '<em><b>Initialized Enumeration Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13__INITIALIZED_ENUMERATION_ATTRIBUTE1 = 5;

	/**
	 * The number of structural features of the '<em>B13</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2Impl <em>B13 Sub2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub2()
	 * @generated
	 */
	int B13_SUB2 = 2;

	/**
	 * The feature id for the '<em><b>Initialized Integer Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2__INITIALIZED_INTEGER_ATTRIBUTE1 = B13__INITIALIZED_INTEGER_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2__INITIALIZED_STRING_ATTRIBUTE1 = B13__INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Boolean Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2__INITIALIZED_BOOLEAN_ATTRIBUTE1 = B13__INITIALIZED_BOOLEAN_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Double Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2__INITIALIZED_DOUBLE_ATTRIBUTE1 = B13__INITIALIZED_DOUBLE_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Not Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2__NOT_INITIALIZED_STRING_ATTRIBUTE1 = B13__NOT_INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Enumeration Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2__INITIALIZED_ENUMERATION_ATTRIBUTE1 = B13__INITIALIZED_ENUMERATION_ATTRIBUTE1;

	/**
	 * The number of structural features of the '<em>B13 Sub2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_FEATURE_COUNT = B13_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2SubImpl <em>B13 Sub2 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub2Sub()
	 * @generated
	 */
	int B13_SUB2_SUB = 3;

	/**
	 * The feature id for the '<em><b>Initialized Integer Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB__INITIALIZED_INTEGER_ATTRIBUTE1 = B13_SUB2__INITIALIZED_INTEGER_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB__INITIALIZED_STRING_ATTRIBUTE1 = B13_SUB2__INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Boolean Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB__INITIALIZED_BOOLEAN_ATTRIBUTE1 = B13_SUB2__INITIALIZED_BOOLEAN_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Double Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB__INITIALIZED_DOUBLE_ATTRIBUTE1 = B13_SUB2__INITIALIZED_DOUBLE_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Not Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB__NOT_INITIALIZED_STRING_ATTRIBUTE1 = B13_SUB2__NOT_INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Enumeration Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB__INITIALIZED_ENUMERATION_ATTRIBUTE1 = B13_SUB2__INITIALIZED_ENUMERATION_ATTRIBUTE1;

	/**
	 * The number of structural features of the '<em>B13 Sub2 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB2_SUB_FEATURE_COUNT = B13_SUB2_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Impl <em>B13 Sub1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub1()
	 * @generated
	 */
	int B13_SUB1 = 4;

	/**
	 * The feature id for the '<em><b>Initialized Integer Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1__INITIALIZED_INTEGER_ATTRIBUTE1 = B13__INITIALIZED_INTEGER_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1__INITIALIZED_STRING_ATTRIBUTE1 = B13__INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Boolean Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1__INITIALIZED_BOOLEAN_ATTRIBUTE1 = B13__INITIALIZED_BOOLEAN_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Double Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1__INITIALIZED_DOUBLE_ATTRIBUTE1 = B13__INITIALIZED_DOUBLE_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Not Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1__NOT_INITIALIZED_STRING_ATTRIBUTE1 = B13__NOT_INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Enumeration Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1__INITIALIZED_ENUMERATION_ATTRIBUTE1 = B13__INITIALIZED_ENUMERATION_ATTRIBUTE1;

	/**
	 * The number of structural features of the '<em>B13 Sub1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_FEATURE_COUNT = B13_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Sub2Impl <em>B13 Sub1 Sub2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Sub2Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub1Sub2()
	 * @generated
	 */
	int B13_SUB1_SUB2 = 5;

	/**
	 * The feature id for the '<em><b>Initialized Integer Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2__INITIALIZED_INTEGER_ATTRIBUTE1 = B13_SUB1__INITIALIZED_INTEGER_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2__INITIALIZED_STRING_ATTRIBUTE1 = B13_SUB1__INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Boolean Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2__INITIALIZED_BOOLEAN_ATTRIBUTE1 = B13_SUB1__INITIALIZED_BOOLEAN_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Double Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2__INITIALIZED_DOUBLE_ATTRIBUTE1 = B13_SUB1__INITIALIZED_DOUBLE_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Not Initialized String Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2__NOT_INITIALIZED_STRING_ATTRIBUTE1 = B13_SUB1__NOT_INITIALIZED_STRING_ATTRIBUTE1;

	/**
	 * The feature id for the '<em><b>Initialized Enumeration Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2__INITIALIZED_ENUMERATION_ATTRIBUTE1 = B13_SUB1__INITIALIZED_ENUMERATION_ATTRIBUTE1;

	/**
	 * The number of structural features of the '<em>B13 Sub1 Sub2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B13_SUB1_SUB2_FEATURE_COUNT = B13_SUB1_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13AbstractImpl <em>C13 Abstract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13AbstractImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getC13Abstract()
	 * @generated
	 */
	int C13_ABSTRACT = 6;

	/**
	 * The feature id for the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C13_ABSTRACT__ATTRIBUTE1 = 0;

	/**
	 * The number of structural features of the '<em>C13 Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C13_ABSTRACT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13SubImpl <em>C13 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getC13Sub()
	 * @generated
	 */
	int C13_SUB = 7;

	/**
	 * The feature id for the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C13_SUB__ATTRIBUTE1 = C13_ABSTRACT__ATTRIBUTE1;

	/**
	 * The number of structural features of the '<em>C13 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C13_SUB_FEATURE_COUNT = C13_ABSTRACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.E13 <em>E13</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.E13
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getE13()
	 * @generated
	 */
	int E13 = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.A13 <em>A13</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A13</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.A13
	 * @generated
	 */
	EClass getA13();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttribute1 <em>Constrained Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constrained Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttribute1()
	 * @see #getA13()
	 * @generated
	 */
	EAttribute getA13_ConstrainedAttribute1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttributeMany1 <em>Constrained Attribute Many1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constrained Attribute Many1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.A13#getConstrainedAttributeMany1()
	 * @see #getA13()
	 * @generated
	 */
	EReference getA13_ConstrainedAttributeMany1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13 <em>B13</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B13</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13
	 * @generated
	 */
	EClass getB13();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedIntegerAttribute1 <em>Initialized Integer Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Integer Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedIntegerAttribute1()
	 * @see #getB13()
	 * @generated
	 */
	EAttribute getB13_InitializedIntegerAttribute1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedStringAttribute1 <em>Initialized String Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized String Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedStringAttribute1()
	 * @see #getB13()
	 * @generated
	 */
	EAttribute getB13_InitializedStringAttribute1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13#isInitializedBooleanAttribute1 <em>Initialized Boolean Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Boolean Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13#isInitializedBooleanAttribute1()
	 * @see #getB13()
	 * @generated
	 */
	EAttribute getB13_InitializedBooleanAttribute1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedDoubleAttribute1 <em>Initialized Double Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Double Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedDoubleAttribute1()
	 * @see #getB13()
	 * @generated
	 */
	EAttribute getB13_InitializedDoubleAttribute1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13#getNotInitializedStringAttribute1 <em>Not Initialized String Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Initialized String Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13#getNotInitializedStringAttribute1()
	 * @see #getB13()
	 * @generated
	 */
	EAttribute getB13_NotInitializedStringAttribute1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedEnumerationAttribute1 <em>Initialized Enumeration Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialized Enumeration Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13#getInitializedEnumerationAttribute1()
	 * @see #getB13()
	 * @generated
	 */
	EAttribute getB13_InitializedEnumerationAttribute1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub2 <em>B13 Sub2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B13 Sub2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub2
	 * @generated
	 */
	EClass getB13Sub2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub2Sub <em>B13 Sub2 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B13 Sub2 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub2Sub
	 * @generated
	 */
	EClass getB13Sub2Sub();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub1 <em>B13 Sub1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B13 Sub1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub1
	 * @generated
	 */
	EClass getB13Sub1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub1Sub2 <em>B13 Sub1 Sub2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B13 Sub1 Sub2</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.B13Sub1Sub2
	 * @generated
	 */
	EClass getB13Sub1Sub2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract <em>C13 Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C13 Abstract</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract
	 * @generated
	 */
	EClass getC13Abstract();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract#getAttribute1 <em>Attribute1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.C13Abstract#getAttribute1()
	 * @see #getC13Abstract()
	 * @generated
	 */
	EAttribute getC13Abstract_Attribute1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case013.C13Sub <em>C13 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C13 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.C13Sub
	 * @generated
	 */
	EClass getC13Sub();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.query2.test.mm.testcases.case013.E13 <em>E13</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>E13</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case013.E13
	 * @generated
	 */
	EEnum getE13();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case013Factory getCase013Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.A13Impl <em>A13</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.A13Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getA13()
		 * @generated
		 */
		EClass A13 = eINSTANCE.getA13();

		/**
		 * The meta object literal for the '<em><b>Constrained Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A13__CONSTRAINED_ATTRIBUTE1 = eINSTANCE.getA13_ConstrainedAttribute1();

		/**
		 * The meta object literal for the '<em><b>Constrained Attribute Many1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A13__CONSTRAINED_ATTRIBUTE_MANY1 = eINSTANCE.getA13_ConstrainedAttributeMany1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl <em>B13</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13()
		 * @generated
		 */
		EClass B13 = eINSTANCE.getB13();

		/**
		 * The meta object literal for the '<em><b>Initialized Integer Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B13__INITIALIZED_INTEGER_ATTRIBUTE1 = eINSTANCE.getB13_InitializedIntegerAttribute1();

		/**
		 * The meta object literal for the '<em><b>Initialized String Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B13__INITIALIZED_STRING_ATTRIBUTE1 = eINSTANCE.getB13_InitializedStringAttribute1();

		/**
		 * The meta object literal for the '<em><b>Initialized Boolean Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B13__INITIALIZED_BOOLEAN_ATTRIBUTE1 = eINSTANCE.getB13_InitializedBooleanAttribute1();

		/**
		 * The meta object literal for the '<em><b>Initialized Double Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B13__INITIALIZED_DOUBLE_ATTRIBUTE1 = eINSTANCE.getB13_InitializedDoubleAttribute1();

		/**
		 * The meta object literal for the '<em><b>Not Initialized String Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B13__NOT_INITIALIZED_STRING_ATTRIBUTE1 = eINSTANCE.getB13_NotInitializedStringAttribute1();

		/**
		 * The meta object literal for the '<em><b>Initialized Enumeration Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B13__INITIALIZED_ENUMERATION_ATTRIBUTE1 = eINSTANCE.getB13_InitializedEnumerationAttribute1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2Impl <em>B13 Sub2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub2()
		 * @generated
		 */
		EClass B13_SUB2 = eINSTANCE.getB13Sub2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2SubImpl <em>B13 Sub2 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub2SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub2Sub()
		 * @generated
		 */
		EClass B13_SUB2_SUB = eINSTANCE.getB13Sub2Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Impl <em>B13 Sub1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub1()
		 * @generated
		 */
		EClass B13_SUB1 = eINSTANCE.getB13Sub1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Sub2Impl <em>B13 Sub1 Sub2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.B13Sub1Sub2Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getB13Sub1Sub2()
		 * @generated
		 */
		EClass B13_SUB1_SUB2 = eINSTANCE.getB13Sub1Sub2();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13AbstractImpl <em>C13 Abstract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13AbstractImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getC13Abstract()
		 * @generated
		 */
		EClass C13_ABSTRACT = eINSTANCE.getC13Abstract();

		/**
		 * The meta object literal for the '<em><b>Attribute1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute C13_ABSTRACT__ATTRIBUTE1 = eINSTANCE.getC13Abstract_Attribute1();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13SubImpl <em>C13 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.C13SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getC13Sub()
		 * @generated
		 */
		EClass C13_SUB = eINSTANCE.getC13Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case013.E13 <em>E13</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.E13
		 * @see org.eclipse.emf.query2.test.mm.testcases.case013.impl.Case013PackageImpl#getE13()
		 * @generated
		 */
		EEnum E13 = eINSTANCE.getE13();

	}

} //Case013Package
