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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f;

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
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.Case001fFactory
 * @model kind="package"
 * @generated
 */
public interface Case001fPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case001f";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcasesfoundation/case001f";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testcasesfoundationcase001f";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case001fPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.Case001fPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.A1fImpl <em>A1f</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.A1fImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.Case001fPackageImpl#getA1f()
	 * @generated
	 */
	int A1F = 0;

	/**
	 * The feature id for the '<em><b>Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1F__TRANSLATABLE_TEXT = 0;

	/**
	 * The number of structural features of the '<em>A1f</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1F_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.B1fImpl <em>B1f</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.B1fImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.Case001fPackageImpl#getB1f()
	 * @generated
	 */
	int B1F = 1;

	/**
	 * The feature id for the '<em><b>One Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B1F__ONE_PRIMITIVE = 0;

	/**
	 * The number of structural features of the '<em>B1f</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B1F_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f <em>A1f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A1f</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f
	 * @generated
	 */
	EClass getA1f();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f#getTranslatableText <em>Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f#getTranslatableText()
	 * @see #getA1f()
	 * @generated
	 */
	EReference getA1f_TranslatableText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f <em>B1f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B1f</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f
	 * @generated
	 */
	EClass getB1f();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f#getOnePrimitive <em>One Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>One Primitive</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.B1f#getOnePrimitive()
	 * @see #getB1f()
	 * @generated
	 */
	EAttribute getB1f_OnePrimitive();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case001fFactory getCase001fFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.A1fImpl <em>A1f</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.A1fImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.Case001fPackageImpl#getA1f()
		 * @generated
		 */
		EClass A1F = eINSTANCE.getA1f();

		/**
		 * The meta object literal for the '<em><b>Translatable Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A1F__TRANSLATABLE_TEXT = eINSTANCE.getA1f_TranslatableText();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.B1fImpl <em>B1f</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.B1fImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.impl.Case001fPackageImpl#getB1f()
		 * @generated
		 */
		EClass B1F = eINSTANCE.getB1f();

		/**
		 * The meta object literal for the '<em><b>One Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B1F__ONE_PRIMITIVE = eINSTANCE.getB1f_OnePrimitive();

	}

} //Case001fPackage
