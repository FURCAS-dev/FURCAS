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
package org.eclipse.emf.query2.test.mm.testcases.case020;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package
 * @generated
 */
public interface Case020Factory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case020Factory eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case020.impl.Case020FactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Super1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super1</em>'.
	 * @generated
	 */
	Super1 createSuper1();

	/**
	 * Returns a new object of class '<em>Super2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super2</em>'.
	 * @generated
	 */
	Super2 createSuper2();

	/**
	 * Returns a new object of class '<em>Child Inherits Multiple1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child Inherits Multiple1</em>'.
	 * @generated
	 */
	ChildInheritsMultiple1 createChildInheritsMultiple1();

	/**
	 * Returns a new object of class '<em>A20</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>A20</em>'.
	 * @generated
	 */
	A20 createA20();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Case020Package getCase020Package();

} //Case020Factory
