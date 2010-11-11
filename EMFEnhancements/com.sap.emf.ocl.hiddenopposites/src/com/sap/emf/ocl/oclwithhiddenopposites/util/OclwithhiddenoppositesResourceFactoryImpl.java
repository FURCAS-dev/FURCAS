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
package com.sap.emf.ocl.oclwithhiddenopposites.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.oclwithhiddenopposites.util.OclwithhiddenoppositesResourceImpl
 * @generated
 */
public class OclwithhiddenoppositesResourceFactoryImpl extends ResourceFactoryImpl {
	/**
         * Creates an instance of the resource factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public OclwithhiddenoppositesResourceFactoryImpl() {
                super();
        }

	/**
         * Creates an instance of the resource.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Resource createResource(URI uri) {
                Resource result = new OclwithhiddenoppositesResourceImpl(uri);
                return result;
        }

} //OclwithhiddenoppositesResourceFactoryImpl
