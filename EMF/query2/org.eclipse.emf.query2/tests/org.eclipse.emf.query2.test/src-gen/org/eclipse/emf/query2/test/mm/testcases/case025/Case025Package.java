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
package org.eclipse.emf.query2.test.mm.testcases.case025;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;

import org.eclipse.emf.query2.test.mm.testcases.case017.Case017Package;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case025.Case025Factory
 * @model kind="package"
 * @generated
 */
public interface Case025Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case025";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case025";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case025";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case025Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.A25Impl <em>A25</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.A25Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getA25()
	 * @generated
	 */
	int A25 = 0;

	/**
	 * The feature id for the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A25__EXTERNAL_ID = 0;

	/**
	 * The number of structural features of the '<em>A25</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A25_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.C25Impl <em>C25</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.C25Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getC25()
	 * @generated
	 */
	int C25 = 1;

	/**
	 * The feature id for the '<em><b>To End</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C25__TO_END = Case017Package.A17__TO_END;

	/**
	 * The feature id for the '<em><b>From End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C25__FROM_END = Case017Package.A17__FROM_END;

	/**
	 * The feature id for the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C25__EXTERNAL_ID = Case017Package.A17_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>C25</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C25_FEATURE_COUNT = Case017Package.A17_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.B25Impl <em>B25</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.B25Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getB25()
	 * @generated
	 */
	int B25 = 2;

	/**
	 * The feature id for the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__ONE_PRIMITIVE = Case004Package.A4__ONE_PRIMITIVE;

	/**
	 * The feature id for the '<em><b>One Primitive Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__ONE_PRIMITIVE_OPTIONAL = Case004Package.A4__ONE_PRIMITIVE_OPTIONAL;

	/**
	 * The feature id for the '<em><b>One Primitive Not Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__ONE_PRIMITIVE_NOT_CHANGEABLE = Case004Package.A4__ONE_PRIMITIVE_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Many Primitive</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE = Case004Package.A4__MANY_PRIMITIVE;

	/**
	 * The feature id for the '<em><b>Many Primitive Double</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_DOUBLE = Case004Package.A4__MANY_PRIMITIVE_DOUBLE;

	/**
	 * The feature id for the '<em><b>Many Primitive Unique</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_UNIQUE = Case004Package.A4__MANY_PRIMITIVE_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Primitive Optional</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_OPTIONAL = Case004Package.A4__MANY_PRIMITIVE_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Many Primitive Not Changeable</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_NOT_CHANGEABLE = Case004Package.A4__MANY_PRIMITIVE_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_ORDERED = Case004Package.A4__MANY_PRIMITIVE_ORDERED;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered Unique</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_ORDERED_UNIQUE = Case004Package.A4__MANY_PRIMITIVE_ORDERED_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Primitive Ordered Not Changeable</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE = Case004Package.A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>One BChangeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__ONE_BCHANGEABLE = Case004Package.A4__ONE_BCHANGEABLE;

	/**
	 * The feature id for the '<em><b>One BNot Changeable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__ONE_BNOT_CHANGEABLE = Case004Package.A4__ONE_BNOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>One BOptional</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__ONE_BOPTIONAL = Case004Package.A4__ONE_BOPTIONAL;

	/**
	 * The feature id for the '<em><b>Many Bs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS = Case004Package.A4__MANY_BS;

	/**
	 * The feature id for the '<em><b>Many Bs Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS_UNIQUE = Case004Package.A4__MANY_BS_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Bs Not Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS_NOT_UNIQUE = Case004Package.A4__MANY_BS_NOT_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS_ORDERED = Case004Package.A4__MANY_BS_ORDERED;

	/**
	 * The feature id for the '<em><b>Many Bs Ordered Unique</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS_ORDERED_UNIQUE = Case004Package.A4__MANY_BS_ORDERED_UNIQUE;

	/**
	 * The feature id for the '<em><b>Many Bs Not Ordered</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS_NOT_ORDERED = Case004Package.A4__MANY_BS_NOT_ORDERED;

	/**
	 * The feature id for the '<em><b>Many Bs Not Changeable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__MANY_BS_NOT_CHANGEABLE = Case004Package.A4__MANY_BS_NOT_CHANGEABLE;

	/**
	 * The feature id for the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25__EXTERNAL_ID = Case004Package.A4_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>B25</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B25_FEATURE_COUNT = Case004Package.A4_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl <em>D25</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getD25()
	 * @generated
	 */
	int D25 = 3;

	/**
	 * The feature id for the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__EXTERNAL_ID = A25__EXTERNAL_ID;

	/**
	 * The feature id for the '<em><b>One Enumeration E</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__ONE_ENUMERATION_E = A25_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>One Structure S</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__ONE_STRUCTURE_S = A25_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>One Structure T</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__ONE_STRUCTURE_T = A25_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>One Structure V</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__ONE_STRUCTURE_V = A25_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Many Enumeration E</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__MANY_ENUMERATION_E = A25_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Many Structure S</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25__MANY_STRUCTURE_S = A25_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>D25</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D25_FEATURE_COUNT = A25_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case025.A25 <em>A25</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A25</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.A25
	 * @generated
	 */
	EClass getA25();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case025.A25#getExternalId <em>External Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Id</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.A25#getExternalId()
	 * @see #getA25()
	 * @generated
	 */
	EAttribute getA25_ExternalId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case025.C25 <em>C25</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C25</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.C25
	 * @generated
	 */
	EClass getC25();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case025.B25 <em>B25</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B25</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.B25
	 * @generated
	 */
	EClass getB25();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case025.D25 <em>D25</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D25</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case025.D25
	 * @generated
	 */
	EClass getD25();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case025Factory getCase025Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.A25Impl <em>A25</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.A25Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getA25()
		 * @generated
		 */
		EClass A25 = eINSTANCE.getA25();

		/**
		 * The meta object literal for the '<em><b>External Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A25__EXTERNAL_ID = eINSTANCE.getA25_ExternalId();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.C25Impl <em>C25</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.C25Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getC25()
		 * @generated
		 */
		EClass C25 = eINSTANCE.getC25();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.B25Impl <em>B25</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.B25Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getB25()
		 * @generated
		 */
		EClass B25 = eINSTANCE.getB25();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl <em>D25</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case025.impl.Case025PackageImpl#getD25()
		 * @generated
		 */
		EClass D25 = eINSTANCE.getD25();

	}

} //Case025Package
