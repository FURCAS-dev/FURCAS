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
package org.eclipse.emf.query2.test.mm.testcases.case022;

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
 * @see org.eclipse.emf.query2.test.mm.testcases.case022.Case022Factory
 * @model kind="package"
 * @generated
 */
public interface Case022Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "case022"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.com/moin/testcases/case022"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "case022"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case022Package eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case022.impl.Case022PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.A22JavadocImpl <em>A22 Javadoc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.A22JavadocImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.Case022PackageImpl#getA22Javadoc()
	 * @generated
	 */
	int A22_JAVADOC = 0;

	/**
	 * The feature id for the '<em><b>Attribute Javadoc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A22_JAVADOC__ATTRIBUTE_JAVADOC = 0;

	/**
	 * The number of structural features of the '<em>A22 Javadoc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A22_JAVADOC_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.B22JavadocSpecialCharactersImpl <em>B22 Javadoc Special Characters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.B22JavadocSpecialCharactersImpl
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.Case022PackageImpl#getB22JavadocSpecialCharacters()
	 * @generated
	 */
	int B22_JAVADOC_SPECIAL_CHARACTERS = 1;

	/**
	 * The feature id for the '<em><b>Javadoc Comment End Sign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN = 0;

	/**
	 * The feature id for the '<em><b>Http Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>B22 Javadoc Special Characters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B22_JAVADOC_SPECIAL_CHARACTERS_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc <em>A22 Javadoc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A22 Javadoc</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc
	 * @generated
	 */
	EClass getA22Javadoc();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc#getAttributeJavadoc <em>Attribute Javadoc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Javadoc</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.A22Javadoc#getAttributeJavadoc()
	 * @see #getA22Javadoc()
	 * @generated
	 */
	EAttribute getA22Javadoc_AttributeJavadoc();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters <em>B22 Javadoc Special Characters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B22 Javadoc Special Characters</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters
	 * @generated
	 */
	EClass getB22JavadocSpecialCharacters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters#getJavadocCommentEndSign <em>Javadoc Comment End Sign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Javadoc Comment End Sign</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters#getJavadocCommentEndSign()
	 * @see #getB22JavadocSpecialCharacters()
	 * @generated
	 */
	EAttribute getB22JavadocSpecialCharacters_JavadocCommentEndSign();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters#getHttpAddress <em>Http Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Http Address</em>'.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case022.B22JavadocSpecialCharacters#getHttpAddress()
	 * @see #getB22JavadocSpecialCharacters()
	 * @generated
	 */
	EAttribute getB22JavadocSpecialCharacters_HttpAddress();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Case022Factory getCase022Factory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.A22JavadocImpl <em>A22 Javadoc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.A22JavadocImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.Case022PackageImpl#getA22Javadoc()
		 * @generated
		 */
		EClass A22_JAVADOC = eINSTANCE.getA22Javadoc();

		/**
		 * The meta object literal for the '<em><b>Attribute Javadoc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A22_JAVADOC__ATTRIBUTE_JAVADOC = eINSTANCE.getA22Javadoc_AttributeJavadoc();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.query2.test.mm.testcases.case022.impl.B22JavadocSpecialCharactersImpl <em>B22 Javadoc Special Characters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.B22JavadocSpecialCharactersImpl
		 * @see org.eclipse.emf.query2.test.mm.testcases.case022.impl.Case022PackageImpl#getB22JavadocSpecialCharacters()
		 * @generated
		 */
		EClass B22_JAVADOC_SPECIAL_CHARACTERS = eINSTANCE.getB22JavadocSpecialCharacters();

		/**
		 * The meta object literal for the '<em><b>Javadoc Comment End Sign</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B22_JAVADOC_SPECIAL_CHARACTERS__JAVADOC_COMMENT_END_SIGN = eINSTANCE.getB22JavadocSpecialCharacters_JavadocCommentEndSign();

		/**
		 * The meta object literal for the '<em><b>Http Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B22_JAVADOC_SPECIAL_CHARACTERS__HTTP_ADDRESS = eINSTANCE.getB22JavadocSpecialCharacters_HttpAddress();

	}

} //Case022Package
