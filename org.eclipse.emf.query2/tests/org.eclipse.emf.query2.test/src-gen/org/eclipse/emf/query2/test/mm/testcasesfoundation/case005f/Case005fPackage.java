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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f;

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
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.Case005fFactory
 * @model kind="package"
 * @generated
 */
public interface Case005fPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case005f";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcasesfoundation/case005f";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testcasesfoundationcase005f";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case005fPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.Case005fPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl <em>A5f Migration Attribute Type Translatable Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.Case005fPackageImpl#getA5fMigrationAttributeTypeTranslatableText()
	 * @generated
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT = 0;

	/**
	 * The feature id for the '<em><b>Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT = 0;

	/**
	 * The feature id for the '<em><b>General Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Specialized Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT = 2;

	/**
	 * The number of structural features of the '<em>A5f Migration Attribute Type Translatable Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl <em>A5f Migration Attribute Type Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.Case005fPackageImpl#getA5fMigrationAttributeTypeText()
	 * @generated
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT = 0;

	/**
	 * The feature id for the '<em><b>General Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT = 1;

	/**
	 * The feature id for the '<em><b>Specialized Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT = 2;

	/**
	 * The number of structural features of the '<em>A5f Migration Attribute Type Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText <em>A5f Migration Attribute Type Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A5f Migration Attribute Type Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText
	 * @generated
	 */
	EClass getA5fMigrationAttributeTypeTranslatableText();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getTranslatableText <em>Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getTranslatableText()
	 * @see #getA5fMigrationAttributeTypeTranslatableText()
	 * @generated
	 */
	EReference getA5fMigrationAttributeTypeTranslatableText_TranslatableText();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getGeneralTranslatableText <em>General Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>General Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getGeneralTranslatableText()
	 * @see #getA5fMigrationAttributeTypeTranslatableText()
	 * @generated
	 */
	EReference getA5fMigrationAttributeTypeTranslatableText_GeneralTranslatableText();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getSpecializedTranslatableText <em>Specialized Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specialized Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeTranslatableText#getSpecializedTranslatableText()
	 * @see #getA5fMigrationAttributeTypeTranslatableText()
	 * @generated
	 */
	EReference getA5fMigrationAttributeTypeTranslatableText_SpecializedTranslatableText();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText <em>A5f Migration Attribute Type Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A5f Migration Attribute Type Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText
	 * @generated
	 */
	EClass getA5fMigrationAttributeTypeText();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText#getTranslatableText <em>Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText#getTranslatableText()
	 * @see #getA5fMigrationAttributeTypeText()
	 * @generated
	 */
	EReference getA5fMigrationAttributeTypeText_TranslatableText();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText#getGeneralText <em>General Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>General Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText#getGeneralText()
	 * @see #getA5fMigrationAttributeTypeText()
	 * @generated
	 */
	EReference getA5fMigrationAttributeTypeText_GeneralText();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText#getSpecializedText <em>Specialized Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specialized Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.A5fMigrationAttributeTypeText#getSpecializedText()
	 * @see #getA5fMigrationAttributeTypeText()
	 * @generated
	 */
	EReference getA5fMigrationAttributeTypeText_SpecializedText();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case005fFactory getCase005fFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl <em>A5f Migration Attribute Type Translatable Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTranslatableTextImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.Case005fPackageImpl#getA5fMigrationAttributeTypeTranslatableText()
		 * @generated
		 */
		EClass A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT = eINSTANCE.getA5fMigrationAttributeTypeTranslatableText();

		/**
		 * The meta object literal for the '<em><b>Translatable Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__TRANSLATABLE_TEXT = eINSTANCE.getA5fMigrationAttributeTypeTranslatableText_TranslatableText();

		/**
		 * The meta object literal for the '<em><b>General Translatable Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__GENERAL_TRANSLATABLE_TEXT = eINSTANCE.getA5fMigrationAttributeTypeTranslatableText_GeneralTranslatableText();

		/**
		 * The meta object literal for the '<em><b>Specialized Translatable Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A5F_MIGRATION_ATTRIBUTE_TYPE_TRANSLATABLE_TEXT__SPECIALIZED_TRANSLATABLE_TEXT = eINSTANCE.getA5fMigrationAttributeTypeTranslatableText_SpecializedTranslatableText();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl <em>A5f Migration Attribute Type Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.A5fMigrationAttributeTypeTextImpl
		 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.impl.Case005fPackageImpl#getA5fMigrationAttributeTypeText()
		 * @generated
		 */
		EClass A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT = eINSTANCE.getA5fMigrationAttributeTypeText();

		/**
		 * The meta object literal for the '<em><b>Translatable Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__TRANSLATABLE_TEXT = eINSTANCE.getA5fMigrationAttributeTypeText_TranslatableText();

		/**
		 * The meta object literal for the '<em><b>General Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__GENERAL_TEXT = eINSTANCE.getA5fMigrationAttributeTypeText_GeneralText();

		/**
		 * The meta object literal for the '<em><b>Specialized Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A5F_MIGRATION_ATTRIBUTE_TYPE_TEXT__SPECIALIZED_TEXT = eINSTANCE.getA5fMigrationAttributeTypeText_SpecializedText();

	}

} //Case005fPackage
