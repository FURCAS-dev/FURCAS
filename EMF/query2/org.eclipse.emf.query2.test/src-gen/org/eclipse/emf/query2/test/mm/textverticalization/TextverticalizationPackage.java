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
package org.eclipse.emf.query2.test.mm.textverticalization;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see org.eclipse.emf.query2.test.mm.textverticalization.TextverticalizationFactory
 * @model kind="package"
 *        annotation="http://sap.com/MOIN textverticalization.TranslatableTextFragment='//TranslatableTextFragment' textverticalization.TranslatableText='//TranslatableText'"
 * @generated
 */
public interface TextverticalizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "textverticalization";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/textverticalization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tv";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TextverticalizationPackage eINSTANCE = org.eclipse.emf.query2.test.mm.textverticalization.impl.TextverticalizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl <em>Translatable Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.impl.TextverticalizationPackageImpl#getTranslatableText()
	 * @generated
	 */
	int TRANSLATABLE_TEXT = 0;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT__MAX_WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT__ORIGINAL_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT__RES_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT__TRANSLATE = 3;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT__TRANS_UNIT_ID = 4;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT__RES_NAME = 5;

	/**
	 * The number of structural features of the '<em>Translatable Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSLATABLE_TEXT_FEATURE_COUNT = 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText <em>Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText
	 * @generated
	 */
	EClass getTranslatableText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getMaxWidth <em>Max Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Width</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getMaxWidth()
	 * @see #getTranslatableText()
	 * @generated
	 */
	EAttribute getTranslatableText_MaxWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getOriginalText <em>Original Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getOriginalText()
	 * @see #getTranslatableText()
	 * @generated
	 */
	EAttribute getTranslatableText_OriginalText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResType <em>Res Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Type</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResType()
	 * @see #getTranslatableText()
	 * @generated
	 */
	EAttribute getTranslatableText_ResType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#isTranslate <em>Translate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Translate</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#isTranslate()
	 * @see #getTranslatableText()
	 * @generated
	 */
	EAttribute getTranslatableText_Translate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getTransUnitId <em>Trans Unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trans Unit Id</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getTransUnitId()
	 * @see #getTranslatableText()
	 * @generated
	 */
	EAttribute getTranslatableText_TransUnitId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResName <em>Res Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.textverticalization.TranslatableText#getResName()
	 * @see #getTranslatableText()
	 * @generated
	 */
	EAttribute getTranslatableText_ResName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TextverticalizationFactory getTextverticalizationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl <em>Translatable Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.textverticalization.impl.TranslatableTextImpl
		 * @see org.eclipse.emf.query2.test.mm.textverticalization.impl.TextverticalizationPackageImpl#getTranslatableText()
		 * @generated
		 */
		EClass TRANSLATABLE_TEXT = eINSTANCE.getTranslatableText();

		/**
		 * The meta object literal for the '<em><b>Max Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATABLE_TEXT__MAX_WIDTH = eINSTANCE.getTranslatableText_MaxWidth();

		/**
		 * The meta object literal for the '<em><b>Original Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATABLE_TEXT__ORIGINAL_TEXT = eINSTANCE.getTranslatableText_OriginalText();

		/**
		 * The meta object literal for the '<em><b>Res Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATABLE_TEXT__RES_TYPE = eINSTANCE.getTranslatableText_ResType();

		/**
		 * The meta object literal for the '<em><b>Translate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATABLE_TEXT__TRANSLATE = eINSTANCE.getTranslatableText_Translate();

		/**
		 * The meta object literal for the '<em><b>Trans Unit Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATABLE_TEXT__TRANS_UNIT_ID = eINSTANCE.getTranslatableText_TransUnitId();

		/**
		 * The meta object literal for the '<em><b>Res Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSLATABLE_TEXT__RES_NAME = eINSTANCE.getTranslatableText_ResName();

	}

} //TextverticalizationPackage
