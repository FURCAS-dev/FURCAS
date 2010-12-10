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
package org.eclipse.emf.query2.test.mm.testcases.case010;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package
 * @generated
 */
public interface Case010Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case010Factory eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case010.impl.Case010FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>A10</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>A10</em>'.
	 * @generated
	 */
	A10 createA10();

	/**
	 * Returns a new object of class '<em>B10</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>B10</em>'.
	 * @generated
	 */
	B10 createB10();

	/**
	 * Returns a new object of class '<em>C10</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>C10</em>'.
	 * @generated
	 */
	C10 createC10();

	/**
	 * Returns a new object of class '<em>Not Navigable To Not Navigable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Navigable To Not Navigable</em>'.
	 * @generated
	 */
	NotNavigableToNotNavigable createNotNavigableToNotNavigable();

	/**
	 * Returns a new object of class '<em>Not Changeable To Not Changeable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Changeable To Not Changeable</em>'.
	 * @generated
	 */
	NotChangeableToNotChangeable createNotChangeableToNotChangeable();

	/**
	 * Returns a new object of class '<em>Not Changeable And Navigable To Not Changeable And Navigable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Changeable And Navigable To Not Changeable And Navigable</em>'.
	 * @generated
	 */
	NotChangeableAndNavigableToNotChangeableAndNavigable createNotChangeableAndNavigableToNotChangeableAndNavigable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Case010Package getCase010Package();

} //Case010Factory
