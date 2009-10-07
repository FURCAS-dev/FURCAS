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
package org.eclipse.emf.query2.test.mm.testcases.case019;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case019.Case019Factory
 * @model kind="package"
 * @generated
 */
public interface Case019Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case019";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case019";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case019";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case019Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case019.impl.Case019PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl <em>B19</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.impl.Case019PackageImpl#getB19()
	 * @generated
	 */
	int B19 = 0;

	/**
	 * The feature id for the '<em><b>Translatable Text Short1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B19__TRANSLATABLE_TEXT_SHORT1 = 0;

	/**
	 * The feature id for the '<em><b>Translatable Text Very Short1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B19__TRANSLATABLE_TEXT_VERY_SHORT1 = 1;

	/**
	 * The feature id for the '<em><b>Translatable Buttons</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B19__TRANSLATABLE_BUTTONS = 2;

	/**
	 * The number of structural features of the '<em>B19</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B19_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19 <em>B19</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B19</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.B19
	 * @generated
	 */
	EClass getB19();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextShort1 <em>Translatable Text Short1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Translatable Text Short1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextShort1()
	 * @see #getB19()
	 * @generated
	 */
	EReference getB19_TranslatableTextShort1();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextVeryShort1 <em>Translatable Text Very Short1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Translatable Text Very Short1</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableTextVeryShort1()
	 * @see #getB19()
	 * @generated
	 */
	EReference getB19_TranslatableTextVeryShort1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableButtons <em>Translatable Buttons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Translatable Buttons</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.B19#getTranslatableButtons()
	 * @see #getB19()
	 * @generated
	 */
	EReference getB19_TranslatableButtons();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case019Factory getCase019Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl <em>B19</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case019.impl.B19Impl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case019.impl.Case019PackageImpl#getB19()
		 * @generated
		 */
		EClass B19 = eINSTANCE.getB19();

		/**
		 * The meta object literal for the '<em><b>Translatable Text Short1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B19__TRANSLATABLE_TEXT_SHORT1 = eINSTANCE.getB19_TranslatableTextShort1();

		/**
		 * The meta object literal for the '<em><b>Translatable Text Very Short1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B19__TRANSLATABLE_TEXT_VERY_SHORT1 = eINSTANCE.getB19_TranslatableTextVeryShort1();

		/**
		 * The meta object literal for the '<em><b>Translatable Buttons</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B19__TRANSLATABLE_BUTTONS = eINSTANCE.getB19_TranslatableButtons();

	}

} //Case019Package
