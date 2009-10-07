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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.Case004fPackage
 * @generated
 */
public interface Case004fFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Case004fFactory eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case004f.impl.Case004fFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Short Translatable Text F</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Short Translatable Text F</em>'.
	 * @generated
	 */
	ShortTranslatableTextF createShortTranslatableTextF();

	/**
	 * Returns a new object of class '<em>Very Short Translatable Text F</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Very Short Translatable Text F</em>'.
	 * @generated
	 */
	VeryShortTranslatableTextF createVeryShortTranslatableTextF();

	/**
	 * Returns a new object of class '<em>Button Text F</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Button Text F</em>'.
	 * @generated
	 */
	ButtonTextF createButtonTextF();

	/**
	 * Returns a new object of class '<em>Translatable Text F</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Translatable Text F</em>'.
	 * @generated
	 */
	TranslatableTextF createTranslatableTextF();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Case004fPackage getCase004fPackage();

} //Case004fFactory
