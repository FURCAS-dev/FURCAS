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
 * $Id: OCLstdlibCSTFactory.java,v 1.2 2010/05/16 19:20:25 ewillink Exp $
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
public interface OCLstdlibCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OCLstdlibCSTFactory eINSTANCE = org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.OCLstdlibCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Lib Bound Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Bound Class CS</em>'.
	 * @generated
	 */
	LibBoundClassCS createLibBoundClassCS();

	/**
	 * Returns a new object of class '<em>Lib Class CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Class CS</em>'.
	 * @generated
	 */
	LibClassCS createLibClassCS();

	/**
	 * Returns a new object of class '<em>Lib Document CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Document CS</em>'.
	 * @generated
	 */
	LibDocumentCS createLibDocumentCS();

	/**
	 * Returns a new object of class '<em>Lib Iteration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Iteration CS</em>'.
	 * @generated
	 */
	LibIterationCS createLibIterationCS();

	/**
	 * Returns a new object of class '<em>Lib Operation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Operation CS</em>'.
	 * @generated
	 */
	LibOperationCS createLibOperationCS();

	/**
	 * Returns a new object of class '<em>Lib Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Package CS</em>'.
	 * @generated
	 */
	LibPackageCS createLibPackageCS();

	/**
	 * Returns a new object of class '<em>Lib Property CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lib Property CS</em>'.
	 * @generated
	 */
	LibPropertyCS createLibPropertyCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OCLstdlibCSTPackage getOCLstdlibCSTPackage();

} //OCLstdlibCSTFactory
