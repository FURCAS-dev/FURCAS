/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.oclwithhiddenopposites.utilities;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage
 * @generated
 */
public interface UtilitiesFactory extends EFactory {
	/**
         * The singleton instance of the factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	UtilitiesFactory eINSTANCE = com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl.UtilitiesFactoryImpl.init();

	/**
         * Returns the package supported by this factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @return the package supported by this factory.
         * @generated
         */
	UtilitiesPackage getUtilitiesPackage();

} //UtilitiesFactory
