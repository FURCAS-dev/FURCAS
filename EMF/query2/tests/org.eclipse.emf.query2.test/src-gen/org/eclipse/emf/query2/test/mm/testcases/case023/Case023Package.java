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
package org.eclipse.emf.query2.test.mm.testcases.case023;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Factory
 * @model kind="package"
 * @generated
 */
public interface Case023Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case023";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case023";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case023";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case023Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23Impl <em>A23</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getA23()
	 * @generated
	 */
	int A23 = 0;

	/**
	 * The number of structural features of the '<em>A23</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A23_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.B23Impl <em>B23</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.B23Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getB23()
	 * @generated
	 */
	int B23 = 1;

	/**
	 * The number of structural features of the '<em>B23</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B23_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.C23Impl <em>C23</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.C23Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getC23()
	 * @generated
	 */
	int C23 = 2;

	/**
	 * The number of structural features of the '<em>C23</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C23_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23SubImpl <em>A23 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getA23Sub()
	 * @generated
	 */
	int A23_SUB = 3;

	/**
	 * The number of structural features of the '<em>A23 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A23_SUB_FEATURE_COUNT = A23_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.aaImpl <em>aa</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.aaImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getaa()
	 * @generated
	 */
	int AA = 4;

	/**
	 * The feature id for the '<em><b>ADown</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AA__ADOWN = 0;

	/**
	 * The feature id for the '<em><b>AUp</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AA__AUP = 1;

	/**
	 * The number of structural features of the '<em>aa</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.abImpl <em>ab</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.abImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getab()
	 * @generated
	 */
	int AB = 5;

	/**
	 * The feature id for the '<em><b>ATo B</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AB__ATO_B = 0;

	/**
	 * The feature id for the '<em><b>BTo A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AB__BTO_A = 1;

	/**
	 * The number of structural features of the '<em>ab</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AB_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.bcImpl <em>bc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.bcImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getbc()
	 * @generated
	 */
	int BC = 6;

	/**
	 * The feature id for the '<em><b>BTo C</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BC__BTO_C = 0;

	/**
	 * The feature id for the '<em><b>CTo B</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BC__CTO_B = 1;

	/**
	 * The number of structural features of the '<em>bc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BC_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.acImpl <em>ac</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.acImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getac()
	 * @generated
	 */
	int AC = 7;

	/**
	 * The feature id for the '<em><b>ATo C</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC__ATO_C = 0;

	/**
	 * The feature id for the '<em><b>CTo A</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC__CTO_A = 1;

	/**
	 * The number of structural features of the '<em>ac</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AC_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.ccImpl <em>cc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.ccImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getcc()
	 * @generated
	 */
	int CC = 8;

	/**
	 * The feature id for the '<em><b>Dependents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CC__DEPENDENTS = 0;

	/**
	 * The feature id for the '<em><b>C23</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CC__C23 = 1;

	/**
	 * The number of structural features of the '<em>cc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CC_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.A23 <em>A23</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A23</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.A23
	 * @generated
	 */
	EClass getA23();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.B23 <em>B23</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B23</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.B23
	 * @generated
	 */
	EClass getB23();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.C23 <em>C23</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C23</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.C23
	 * @generated
	 */
	EClass getC23();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.A23Sub <em>A23 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A23 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.A23Sub
	 * @generated
	 */
	EClass getA23Sub();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.aa <em>aa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>aa</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.aa
	 * @generated
	 */
	EClass getaa();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.aa#getADown <em>ADown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>ADown</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.aa#getADown()
	 * @see #getaa()
	 * @generated
	 */
	EReference getaa_ADown();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.aa#getAUp <em>AUp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>AUp</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.aa#getAUp()
	 * @see #getaa()
	 * @generated
	 */
	EReference getaa_AUp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.ab <em>ab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ab</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.ab
	 * @generated
	 */
	EClass getab();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.ab#getAToB <em>ATo B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>ATo B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.ab#getAToB()
	 * @see #getab()
	 * @generated
	 */
	EReference getab_AToB();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.ab#getBToA <em>BTo A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>BTo A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.ab#getBToA()
	 * @see #getab()
	 * @generated
	 */
	EReference getab_BToA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.bc <em>bc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>bc</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.bc
	 * @generated
	 */
	EClass getbc();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.bc#getBToC <em>BTo C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>BTo C</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.bc#getBToC()
	 * @see #getbc()
	 * @generated
	 */
	EReference getbc_BToC();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.bc#getCToB <em>CTo B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>CTo B</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.bc#getCToB()
	 * @see #getbc()
	 * @generated
	 */
	EReference getbc_CToB();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.ac <em>ac</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ac</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.ac
	 * @generated
	 */
	EClass getac();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.ac#getAToC <em>ATo C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>ATo C</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.ac#getAToC()
	 * @see #getac()
	 * @generated
	 */
	EReference getac_AToC();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.ac#getCToA <em>CTo A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>CTo A</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.ac#getCToA()
	 * @see #getac()
	 * @generated
	 */
	EReference getac_CToA();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case023.cc <em>cc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>cc</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.cc
	 * @generated
	 */
	EClass getcc();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case023.cc#getDependents <em>Dependents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependents</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.cc#getDependents()
	 * @see #getcc()
	 * @generated
	 */
	EReference getcc_Dependents();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case023.cc#getC23 <em>C23</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>C23</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.cc#getC23()
	 * @see #getcc()
	 * @generated
	 */
	EReference getcc_C23();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case023Factory getCase023Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23Impl <em>A23</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getA23()
		 * @generated
		 */
		EClass A23 = eINSTANCE.getA23();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.B23Impl <em>B23</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.B23Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getB23()
		 * @generated
		 */
		EClass B23 = eINSTANCE.getB23();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.C23Impl <em>C23</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.C23Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getC23()
		 * @generated
		 */
		EClass C23 = eINSTANCE.getC23();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23SubImpl <em>A23 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.A23SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getA23Sub()
		 * @generated
		 */
		EClass A23_SUB = eINSTANCE.getA23Sub();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.aaImpl <em>aa</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.aaImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getaa()
		 * @generated
		 */
		EClass AA = eINSTANCE.getaa();

		/**
		 * The meta object literal for the '<em><b>ADown</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AA__ADOWN = eINSTANCE.getaa_ADown();

		/**
		 * The meta object literal for the '<em><b>AUp</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AA__AUP = eINSTANCE.getaa_AUp();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.abImpl <em>ab</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.abImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getab()
		 * @generated
		 */
		EClass AB = eINSTANCE.getab();

		/**
		 * The meta object literal for the '<em><b>ATo B</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AB__ATO_B = eINSTANCE.getab_AToB();

		/**
		 * The meta object literal for the '<em><b>BTo A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AB__BTO_A = eINSTANCE.getab_BToA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.bcImpl <em>bc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.bcImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getbc()
		 * @generated
		 */
		EClass BC = eINSTANCE.getbc();

		/**
		 * The meta object literal for the '<em><b>BTo C</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BC__BTO_C = eINSTANCE.getbc_BToC();

		/**
		 * The meta object literal for the '<em><b>CTo B</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BC__CTO_B = eINSTANCE.getbc_CToB();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.acImpl <em>ac</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.acImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getac()
		 * @generated
		 */
		EClass AC = eINSTANCE.getac();

		/**
		 * The meta object literal for the '<em><b>ATo C</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC__ATO_C = eINSTANCE.getac_AToC();

		/**
		 * The meta object literal for the '<em><b>CTo A</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AC__CTO_A = eINSTANCE.getac_CToA();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.impl.ccImpl <em>cc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.ccImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case023.impl.Case023PackageImpl#getcc()
		 * @generated
		 */
		EClass CC = eINSTANCE.getcc();

		/**
		 * The meta object literal for the '<em><b>Dependents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CC__DEPENDENTS = eINSTANCE.getcc_Dependents();

		/**
		 * The meta object literal for the '<em><b>C23</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CC__C23 = eINSTANCE.getcc_C23();

	}

} //Case023Package
