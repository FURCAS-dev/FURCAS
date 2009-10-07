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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage
 * @generated
 */
public interface InheritanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InheritanceFactory eINSTANCE = org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.impl.InheritanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Super Structure1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Structure1</em>'.
	 * @generated
	 */
	SuperStructure1 createSuperStructure1();

	/**
	 * Returns a new object of class '<em>Sub Structure1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Structure1</em>'.
	 * @generated
	 */
	SubStructure1 createSubStructure1();

	/**
	 * Returns a new object of class '<em>Sub Structure2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Structure2</em>'.
	 * @generated
	 */
	SubStructure2 createSubStructure2();

	/**
	 * Returns a new object of class '<em>Super Structure2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Super Structure2</em>'.
	 * @generated
	 */
	SuperStructure2 createSuperStructure2();

	/**
	 * Returns a new object of class '<em>Sub Structure Without Fields</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sub Structure Without Fields</em>'.
	 * @generated
	 */
	SubStructureWithoutFields createSubStructureWithoutFields();

	/**
	 * Returns a new object of class '<em>A8 Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>A8 Inheritance</em>'.
	 * @generated
	 */
	A8Inheritance createA8Inheritance();

	/**
	 * Returns a new object of class '<em>B8 Inheritance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>B8 Inheritance</em>'.
	 * @generated
	 */
	B8Inheritance createB8Inheritance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InheritancePackage getInheritancePackage();

} //InheritanceFactory
