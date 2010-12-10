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
package org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackFactory
 * @model kind="package"
 * @generated
 */
public interface SerializationcallbackPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "serializationcallback";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case019/serializationcallback";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case019serializationcallback";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializationcallbackPackage eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.A19SerializationImpl <em>A19 Serialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.A19SerializationImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackPackageImpl#getA19Serialization()
	 * @generated
	 */
	int A19_SERIALIZATION = 0;

	/**
	 * The feature id for the '<em><b>Test Translatable Text F</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F = 0;

	/**
	 * The number of structural features of the '<em>A19 Serialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A19_SERIALIZATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.B19SerializationImpl <em>B19 Serialization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.B19SerializationImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackPackageImpl#getB19Serialization()
	 * @generated
	 */
	int B19_SERIALIZATION = 1;

	/**
	 * The feature id for the '<em><b>Test Translatable Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT = 0;

	/**
	 * The number of structural features of the '<em>B19 Serialization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B19_SERIALIZATION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization <em>A19 Serialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A19 Serialization</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization
	 * @generated
	 */
	EClass getA19Serialization();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization#getTestTranslatableTextF <em>Test Translatable Text F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Test Translatable Text F</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.A19Serialization#getTestTranslatableTextF()
	 * @see #getA19Serialization()
	 * @generated
	 */
	EReference getA19Serialization_TestTranslatableTextF();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization <em>B19 Serialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B19 Serialization</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization
	 * @generated
	 */
	EClass getB19Serialization();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization#getTestTranslatableText <em>Test Translatable Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Test Translatable Text</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.B19Serialization#getTestTranslatableText()
	 * @see #getB19Serialization()
	 * @generated
	 */
	EReference getB19Serialization_TestTranslatableText();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SerializationcallbackFactory getSerializationcallbackFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.A19SerializationImpl <em>A19 Serialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.A19SerializationImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackPackageImpl#getA19Serialization()
		 * @generated
		 */
		EClass A19_SERIALIZATION = eINSTANCE.getA19Serialization();

		/**
		 * The meta object literal for the '<em><b>Test Translatable Text F</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A19_SERIALIZATION__TEST_TRANSLATABLE_TEXT_F = eINSTANCE.getA19Serialization_TestTranslatableTextF();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.B19SerializationImpl <em>B19 Serialization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.B19SerializationImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackPackageImpl#getB19Serialization()
		 * @generated
		 */
		EClass B19_SERIALIZATION = eINSTANCE.getB19Serialization();

		/**
		 * The meta object literal for the '<em><b>Test Translatable Text</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B19_SERIALIZATION__TEST_TRANSLATABLE_TEXT = eINSTANCE.getB19Serialization_TestTranslatableText();

	}

} //SerializationcallbackPackage
