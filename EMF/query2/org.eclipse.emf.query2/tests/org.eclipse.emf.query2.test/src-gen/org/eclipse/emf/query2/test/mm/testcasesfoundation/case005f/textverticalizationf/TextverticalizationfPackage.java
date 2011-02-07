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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf;

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
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextverticalizationfFactory
 * @model kind="package"
 * @generated
 */
public interface TextverticalizationfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "textverticalizationf"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcasesfoundation/case005f/textverticalizationf"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testcasesfoundationcase005ftv"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TextverticalizationfPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextverticalizationfPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextFImpl <em>Text F</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextFImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextverticalizationfPackageImpl#getTextF()
	 * @generated
	 */
	int TEXT_F = 0;

	/**
	 * The feature id for the '<em><b>Max Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F__MAX_WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Original Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F__ORIGINAL_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Res Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F__RES_NAME = 2;

	/**
	 * The feature id for the '<em><b>Res Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F__RES_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F__TRANSLATE = 4;

	/**
	 * The feature id for the '<em><b>Trans Unit Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F__TRANS_UNIT_ID = 5;

	/**
	 * The number of structural features of the '<em>Text F</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_F_FEATURE_COUNT = 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF <em>Text F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text F</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF
	 * @generated
	 */
	EClass getTextF();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getMaxWidth <em>Max Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Width</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getMaxWidth()
	 * @see #getTextF()
	 * @generated
	 */
	EAttribute getTextF_MaxWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getOriginalText <em>Original Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Original Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getOriginalText()
	 * @see #getTextF()
	 * @generated
	 */
	EAttribute getTextF_OriginalText();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getResName <em>Res Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Name</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getResName()
	 * @see #getTextF()
	 * @generated
	 */
	EAttribute getTextF_ResName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getResType <em>Res Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Type</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getResType()
	 * @see #getTextF()
	 * @generated
	 */
	EAttribute getTextF_ResType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#isTranslate <em>Translate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Translate</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#isTranslate()
	 * @see #getTextF()
	 * @generated
	 */
	EAttribute getTextF_Translate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getTransUnitId <em>Trans Unit Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trans Unit Id</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.TextF#getTransUnitId()
	 * @see #getTextF()
	 * @generated
	 */
	EAttribute getTextF_TransUnitId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TextverticalizationfFactory getTextverticalizationfFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextFImpl <em>Text F</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextFImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.textverticalizationf.impl.TextverticalizationfPackageImpl#getTextF()
		 * @generated
		 */
		EClass TEXT_F = eINSTANCE.getTextF();

		/**
		 * The meta object literal for the '<em><b>Max Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_F__MAX_WIDTH = eINSTANCE.getTextF_MaxWidth();

		/**
		 * The meta object literal for the '<em><b>Original Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_F__ORIGINAL_TEXT = eINSTANCE.getTextF_OriginalText();

		/**
		 * The meta object literal for the '<em><b>Res Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_F__RES_NAME = eINSTANCE.getTextF_ResName();

		/**
		 * The meta object literal for the '<em><b>Res Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_F__RES_TYPE = eINSTANCE.getTextF_ResType();

		/**
		 * The meta object literal for the '<em><b>Translate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_F__TRANSLATE = eINSTANCE.getTextF_Translate();

		/**
		 * The meta object literal for the '<em><b>Trans Unit Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_F__TRANS_UNIT_ID = eINSTANCE.getTextF_TransUnitId();

	}

} //TextverticalizationfPackage
