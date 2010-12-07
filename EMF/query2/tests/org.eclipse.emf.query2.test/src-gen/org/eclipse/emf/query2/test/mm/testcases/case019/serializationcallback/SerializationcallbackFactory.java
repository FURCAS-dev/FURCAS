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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.SerializationcallbackPackage
 * @generated
 */
public interface SerializationcallbackFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializationcallbackFactory eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case019.serializationcallback.impl.SerializationcallbackFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>A19 Serialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>A19 Serialization</em>'.
	 * @generated
	 */
	A19Serialization createA19Serialization();

	/**
	 * Returns a new object of class '<em>B19 Serialization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>B19 Serialization</em>'.
	 * @generated
	 */
	B19Serialization createB19Serialization();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SerializationcallbackPackage getSerializationcallbackPackage();

} //SerializationcallbackFactory
