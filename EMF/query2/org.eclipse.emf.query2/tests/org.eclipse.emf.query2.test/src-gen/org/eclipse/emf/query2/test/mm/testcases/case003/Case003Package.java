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
package org.eclipse.emf.query2.test.mm.testcases.case003;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case003.Case003Factory
 * @model kind="package"
 * @generated
 */
public interface Case003Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case003"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case003"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case003"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case003Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.A3Impl <em>A3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.A3Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getA3()
	 * @generated
	 */
	int A3 = 0;

	/**
	 * The number of structural features of the '<em>A3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3Impl <em>B3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getB3()
	 * @generated
	 */
	int B3 = 1;

	/**
	 * The feature id for the '<em><b>Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3__Z = 0;

	/**
	 * The number of structural features of the '<em>B3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.C3Impl <em>C3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.C3Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getC3()
	 * @generated
	 */
	int C3 = 2;

	/**
	 * The feature id for the '<em><b>Y</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C3__Y = A3_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>C3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C3_FEATURE_COUNT = A3_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.D3Impl <em>D3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.D3Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getD3()
	 * @generated
	 */
	int D3 = 3;

	/**
	 * The feature id for the '<em><b>Ref D3 To Y</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D3__REF_D3_TO_Y = A3_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>D3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D3_FEATURE_COUNT = A3_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.E3Impl <em>E3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.E3Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getE3()
	 * @generated
	 */
	int E3 = 4;

	/**
	 * The feature id for the '<em><b>Ref D3 To Y</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int E3__REF_D3_TO_Y = D3__REF_D3_TO_Y;

	/**
	 * The number of structural features of the '<em>E3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int E3_FEATURE_COUNT = D3_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.F3Impl <em>F3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.F3Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getF3()
	 * @generated
	 */
	int F3 = 5;

	/**
	 * The feature id for the '<em><b>Y</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F3__Y = C3__Y;

	/**
	 * The feature id for the '<em><b>Ref D3 To Y</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F3__REF_D3_TO_Y = C3_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>F3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int F3_FEATURE_COUNT = C3_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3SubImpl <em>B3 Sub</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3SubImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getB3Sub()
	 * @generated
	 */
	int B3_SUB = 6;

	/**
	 * The feature id for the '<em><b>Z</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_SUB__Z = B3__Z;

	/**
	 * The number of structural features of the '<em>B3 Sub</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_SUB_FEATURE_COUNT = B3_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.A3 <em>A3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.A3
	 * @generated
	 */
	EClass getA3();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.B3 <em>B3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.B3
	 * @generated
	 */
	EClass getB3();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.query2.test.mm.testcases.case003.B3#getZ <em>Z</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Z</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.B3#getZ()
	 * @see #getB3()
	 * @generated
	 */
	EReference getB3_Z();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.C3 <em>C3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.C3
	 * @generated
	 */
	EClass getC3();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case003.C3#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Y</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.C3#getY()
	 * @see #getC3()
	 * @generated
	 */
	EReference getC3_Y();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.D3 <em>D3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.D3
	 * @generated
	 */
	EClass getD3();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case003.D3#getRefD3ToY <em>Ref D3 To Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ref D3 To Y</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.D3#getRefD3ToY()
	 * @see #getD3()
	 * @generated
	 */
	EReference getD3_RefD3ToY();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.E3 <em>E3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>E3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.E3
	 * @generated
	 */
	EClass getE3();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.F3 <em>F3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>F3</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.F3
	 * @generated
	 */
	EClass getF3();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case003.B3Sub <em>B3 Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B3 Sub</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.B3Sub
	 * @generated
	 */
	EClass getB3Sub();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case003Factory getCase003Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.A3Impl <em>A3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.A3Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getA3()
		 * @generated
		 */
		EClass A3 = eINSTANCE.getA3();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3Impl <em>B3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getB3()
		 * @generated
		 */
		EClass B3 = eINSTANCE.getB3();

		/**
		 * The meta object literal for the '<em><b>Z</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B3__Z = eINSTANCE.getB3_Z();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.C3Impl <em>C3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.C3Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getC3()
		 * @generated
		 */
		EClass C3 = eINSTANCE.getC3();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C3__Y = eINSTANCE.getC3_Y();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.D3Impl <em>D3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.D3Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getD3()
		 * @generated
		 */
		EClass D3 = eINSTANCE.getD3();

		/**
		 * The meta object literal for the '<em><b>Ref D3 To Y</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference D3__REF_D3_TO_Y = eINSTANCE.getD3_RefD3ToY();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.E3Impl <em>E3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.E3Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getE3()
		 * @generated
		 */
		EClass E3 = eINSTANCE.getE3();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.F3Impl <em>F3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.F3Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getF3()
		 * @generated
		 */
		EClass F3 = eINSTANCE.getF3();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3SubImpl <em>B3 Sub</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.B3SubImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case003.impl.Case003PackageImpl#getB3Sub()
		 * @generated
		 */
		EClass B3_SUB = eINSTANCE.getB3Sub();

	}

} //Case003Package
