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
package org.eclipse.emf.query2.test.mm.testcases.case001;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package
 * @generated
 */
public interface Case001Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case001Factory eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case001.impl.Case001FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>A1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>A1</em>'.
	 * @generated
	 */
	A1 createA1();

	/**
	 * Returns a new object of class '<em>B1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>B1</em>'.
	 * @generated
	 */
	B1 createB1();

	/**
	 * Returns a new object of class '<em>Super</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super</em>'.
	 * @generated
	 */
	Super createSuper();

	/**
	 * Returns a new object of class '<em>AReferences B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AReferences B</em>'.
	 * @generated
	 */
	AReferencesB createAReferencesB();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Case001Package getCase001Package();

} //Case001Factory