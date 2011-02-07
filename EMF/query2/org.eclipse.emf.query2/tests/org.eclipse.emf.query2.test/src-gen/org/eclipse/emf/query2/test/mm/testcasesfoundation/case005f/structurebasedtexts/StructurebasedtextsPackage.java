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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts;

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
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.StructurebasedtextsFactory
 * @model kind="package"
 * @generated
 */
public interface StructurebasedtextsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "structurebasedtexts"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcasesfoundation/case005f/structurebasedtexts"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testcasesfoundationcase005fsbt"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StructurebasedtextsPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.StructurebasedtextsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.GeneralTranslatableTextImpl <em>General Translatable Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.GeneralTranslatableTextImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.StructurebasedtextsPackageImpl#getGeneralTranslatableText()
	 * @generated
	 */
	int GENERAL_TRANSLATABLE_TEXT = 0;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT__MAX_WIDTH = TextverticalizationPackage.TRANSLATABLE_TEXT__MAX_WIDTH;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT__ORIGINAL_TEXT = TextverticalizationPackage.TRANSLATABLE_TEXT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT__RES_TYPE = TextverticalizationPackage.TRANSLATABLE_TEXT__RES_TYPE;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT__TRANSLATE = TextverticalizationPackage.TRANSLATABLE_TEXT__TRANSLATE;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT__TRANS_UNIT_ID = TextverticalizationPackage.TRANSLATABLE_TEXT__TRANS_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT__RES_NAME = TextverticalizationPackage.TRANSLATABLE_TEXT__RES_NAME;

	/**
	 * The number of structural features of the '<em>General Translatable Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERAL_TRANSLATABLE_TEXT_FEATURE_COUNT = TextverticalizationPackage.TRANSLATABLE_TEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.SpecializedTranslatableTextImpl <em>Specialized Translatable Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.SpecializedTranslatableTextImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.StructurebasedtextsPackageImpl#getSpecializedTranslatableText()
	 * @generated
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT__MAX_WIDTH = GENERAL_TRANSLATABLE_TEXT__MAX_WIDTH;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT__ORIGINAL_TEXT = GENERAL_TRANSLATABLE_TEXT__ORIGINAL_TEXT;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT__RES_TYPE = GENERAL_TRANSLATABLE_TEXT__RES_TYPE;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT__TRANSLATE = GENERAL_TRANSLATABLE_TEXT__TRANSLATE;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT__TRANS_UNIT_ID = GENERAL_TRANSLATABLE_TEXT__TRANS_UNIT_ID;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT__RES_NAME = GENERAL_TRANSLATABLE_TEXT__RES_NAME;

	/**
	 * The number of structural features of the '<em>Specialized Translatable Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZED_TRANSLATABLE_TEXT_FEATURE_COUNT = GENERAL_TRANSLATABLE_TEXT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.GeneralTranslatableText <em>General Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>General Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.GeneralTranslatableText
	 * @generated
	 */
	EClass getGeneralTranslatableText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.SpecializedTranslatableText <em>Specialized Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialized Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.SpecializedTranslatableText
	 * @generated
	 */
	EClass getSpecializedTranslatableText();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StructurebasedtextsFactory getStructurebasedtextsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.GeneralTranslatableTextImpl <em>General Translatable Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.GeneralTranslatableTextImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.StructurebasedtextsPackageImpl#getGeneralTranslatableText()
		 * @generated
		 */
		EClass GENERAL_TRANSLATABLE_TEXT = eINSTANCE.getGeneralTranslatableText();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.SpecializedTranslatableTextImpl <em>Specialized Translatable Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.SpecializedTranslatableTextImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.structurebasedtexts.impl.StructurebasedtextsPackageImpl#getSpecializedTranslatableText()
		 * @generated
		 */
		EClass SPECIALIZED_TRANSLATABLE_TEXT = eINSTANCE.getSpecializedTranslatableText();

	}

} //StructurebasedtextsPackage
