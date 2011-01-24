/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLstdlibCSTFactory.java,v 1.3 2011/01/24 22:28:25 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage
 * @generated
 */
public interface OCLstdlibCSTFactory
		extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSTFactory eINSTANCE = org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Lib Accumulator CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Accumulator CS</em>'.
	 * @generated
	 */
	LibAccumulatorCS createLibAccumulatorCS();

	/**
	 * Returns a new object of class '<em>Lib Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Class CS</em>'.
	 * @generated
	 */
	LibClassCS createLibClassCS();

	/**
	 * Returns a new object of class '<em>Lib Constraint CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Constraint CS</em>'.
	 * @generated
	 */
	LibConstraintCS createLibConstraintCS();

	/**
	 * Returns a new object of class '<em>Lib Iteration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Iteration CS</em>'.
	 * @generated
	 */
	LibIterationCS createLibIterationCS();

	/**
	 * Returns a new object of class '<em>Lib Iterator CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Iterator CS</em>'.
	 * @generated
	 */
	LibIteratorCS createLibIteratorCS();

	/**
	 * Returns a new object of class '<em>Lib Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Operation CS</em>'.
	 * @generated
	 */
	LibOperationCS createLibOperationCS();

	/**
	 * Returns a new object of class '<em>Lib Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Property CS</em>'.
	 * @generated
	 */
	LibPropertyCS createLibPropertyCS();

	/**
	 * Returns a new object of class '<em>Lib Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Root Package CS</em>'.
	 * @generated
	 */
	LibRootPackageCS createLibRootPackageCS();

	/**
	 * Returns a new object of class '<em>Precedence CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precedence CS</em>'.
	 * @generated
	 */
	PrecedenceCS createPrecedenceCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCLstdlibCSTPackage getOCLstdlibCSTPackage();

} //OCLstdlibCSTFactory
