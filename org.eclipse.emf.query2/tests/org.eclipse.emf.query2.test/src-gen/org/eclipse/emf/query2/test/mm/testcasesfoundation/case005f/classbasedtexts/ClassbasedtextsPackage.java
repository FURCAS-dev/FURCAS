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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextverticalizationfPackage;

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
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsFactory
 * @model kind="package"
 * @generated
 */
public interface ClassbasedtextsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classbasedtexts"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcasesfoundation/case005f/classbasedtexts"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testcasesfoundationcase005fcbt"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassbasedtextsPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.GeneralTextImpl <em>General Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.GeneralTextImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsPackageImpl#getGeneralText()
	 * @generated
	 */
	int GENERAL_TEXT = 0;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT__MAX_WIDTH = TextverticalizationfPackage.TEXT_F__MAX_WIDTH;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT__ORIGINAL_TEXT = TextverticalizationfPackage.TEXT_F__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT__RES_NAME = TextverticalizationfPackage.TEXT_F__RES_NAME;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT__RES_TYPE = TextverticalizationfPackage.TEXT_F__RES_TYPE;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT__TRANSLATE = TextverticalizationfPackage.TEXT_F__TRANSLATE;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT__TRANS_UNIT_ID = TextverticalizationfPackage.TEXT_F__TRANS_UNIT_ID;

	/**
	 * The number of structural features of the '<em>General Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TEXT_FEATURE_COUNT = TextverticalizationfPackage.TEXT_F_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.SpecializedTextImpl <em>Specialized Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.SpecializedTextImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsPackageImpl#getSpecializedText()
	 * @generated
	 */
	int SPECIALIZED_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT__MAX_WIDTH = GENERAL_TEXT__MAX_WIDTH;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT__ORIGINAL_TEXT = GENERAL_TEXT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT__RES_NAME = GENERAL_TEXT__RES_NAME;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT__RES_TYPE = GENERAL_TEXT__RES_TYPE;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT__TRANSLATE = GENERAL_TEXT__TRANSLATE;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT__TRANS_UNIT_ID = GENERAL_TEXT__TRANS_UNIT_ID;

	/**
	 * The number of structural features of the '<em>Specialized Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TEXT_FEATURE_COUNT = GENERAL_TEXT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.GeneralText <em>General Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.GeneralText
	 * @generated
	 */
	EClass getGeneralText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.SpecializedText <em>Specialized Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialized Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.SpecializedText
	 * @generated
	 */
	EClass getSpecializedText();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassbasedtextsFactory getClassbasedtextsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.GeneralTextImpl <em>General Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.GeneralTextImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsPackageImpl#getGeneralText()
		 * @generated
		 */
		EClass GENERAL_TEXT = eINSTANCE.getGeneralText();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.SpecializedTextImpl <em>Specialized Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.SpecializedTextImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsPackageImpl#getSpecializedText()
		 * @generated
		 */
		EClass SPECIALIZED_TEXT = eINSTANCE.getSpecializedText();

	}

} //ClassbasedtextsPackage
