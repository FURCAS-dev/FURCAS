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
package com.sap.emf.ocl.impactanalysis.example.signature_and_call;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage
 * @generated
 */
public interface Signature_and_callFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    Signature_and_callFactory eINSTANCE = com.sap.emf.ocl.impactanalysis.example.signature_and_call.impl.Signature_and_callFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Signature</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signature</em>'.
     * @generated
     */
    Signature createSignature();

    /**
     * Returns a new object of class '<em>Parameter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Parameter</em>'.
     * @generated
     */
    Parameter createParameter();

    /**
     * Returns a new object of class '<em>Named</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Named</em>'.
     * @generated
     */
    Named createNamed();

    /**
     * Returns a new object of class '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Call</em>'.
     * @generated
     */
    Call createCall();

    /**
     * Returns a new object of class '<em>String Literal</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>String Literal</em>'.
     * @generated
     */
    StringLiteral createStringLiteral();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    Signature_and_callPackage getSignature_and_callPackage();

} //Signature_and_callFactory
