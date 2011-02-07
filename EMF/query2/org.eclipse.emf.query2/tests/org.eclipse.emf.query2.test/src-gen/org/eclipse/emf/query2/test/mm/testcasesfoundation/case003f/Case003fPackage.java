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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationPackage;

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
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.Case003fFactory
 * @model kind="package"
 * @generated
 */
public interface Case003fPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case003f"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcasesfoundation/case003f"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testcasesfoundationcase003f"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case003fPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.Case003fPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.B3fImpl <em>B3f</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.B3fImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.Case003fPackageImpl#getB3f()
	 * @generated
	 */
	int B3F = 0;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__MAX_WIDTH = TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__ORIGINAL_TEXT = TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__RES_TYPE = TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__TRANSLATE = TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__TRANS_UNIT_ID = TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__RES_NAME = TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME;

	/**
	 * The feature id for the '<em><b>Text Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F__TEXT_NAME = TextverticalizationPackage.TRANSLATABLE_TEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>B3f</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3F_FEATURE_COUNT = TextverticalizationPackage.TRANSLATABLE_TEXT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f <em>B3f</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B3f</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f
	 * @generated
	 */
	EClass getB3f();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f#getTextName <em>Text Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.B3f#getTextName()
	 * @see #getB3f()
	 * @generated
	 */
	EAttribute getB3f_TextName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case003fFactory getCase003fFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.B3fImpl <em>B3f</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.B3fImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case003f.impl.Case003fPackageImpl#getB3f()
		 * @generated
		 */
		EClass B3F = eINSTANCE.getB3f();

		/**
		 * The meta object literal for the '<em><b>Text Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B3F__TEXT_NAME = eINSTANCE.getB3f_TextName();

	}

} //Case003fPackage
