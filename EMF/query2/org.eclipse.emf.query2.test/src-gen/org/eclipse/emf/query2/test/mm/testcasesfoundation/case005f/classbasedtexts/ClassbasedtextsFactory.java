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
package org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.ClassbasedtextsPackage
 * @generated
 */
public interface ClassbasedtextsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassbasedtextsFactory eINSTANCE = org.eclipse.emf.query2.test.mm.testcasesfoundation.case005f.classbasedtexts.impl.ClassbasedtextsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>General Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>General Text</em>'.
	 * @generated
	 */
	GeneralText createGeneralText();

	/**
	 * Returns a new object of class '<em>Specialized Text</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specialized Text</em>'.
	 * @generated
	 */
	SpecializedText createSpecializedText();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ClassbasedtextsPackage getClassbasedtextsPackage();

} //ClassbasedtextsFactory