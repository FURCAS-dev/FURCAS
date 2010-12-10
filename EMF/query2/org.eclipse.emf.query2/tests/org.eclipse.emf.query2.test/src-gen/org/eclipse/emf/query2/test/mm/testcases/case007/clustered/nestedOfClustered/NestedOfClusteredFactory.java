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
package org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.NestedOfClusteredPackage
 * @generated
 */
public interface NestedOfClusteredFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NestedOfClusteredFactory eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case007.clustered.nestedOfClustered.impl.NestedOfClusteredFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>nested Of Clustered A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>nested Of Clustered A</em>'.
	 * @generated
	 */
	nestedOfClusteredA createnestedOfClusteredA();

	/**
	 * Returns a new object of class '<em>nested Of Clustered B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>nested Of Clustered B</em>'.
	 * @generated
	 */
	nestedOfClusteredB createnestedOfClusteredB();

	/**
	 * Returns a new object of class '<em>AReferences Nested Of Clustered B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>AReferences Nested Of Clustered B</em>'.
	 * @generated
	 */
	NestedOfClusteredAReferencesNestedOfClusteredB createNestedOfClusteredAReferencesNestedOfClusteredB();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NestedOfClusteredPackage getNestedOfClusteredPackage();

} //NestedOfClusteredFactory
