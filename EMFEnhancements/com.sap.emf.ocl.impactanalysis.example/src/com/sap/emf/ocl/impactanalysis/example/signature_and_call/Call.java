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

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getSignature <em>Signature</em>}</li>
 *   <li>{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getCall()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ArgumentsMustMatchParameterList'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL ArgumentsMustMatchParameterList='self.arguments->size() = self.signature.parameters->size()'"
 * @generated
 */
public interface Call extends Expression {
    /**
     * Returns the value of the '<em><b>Signature</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signature</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Signature</em>' reference.
     * @see #setSignature(Signature)
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getCall_Signature()
     * @model required="true"
     * @generated
     */
    Signature getSignature();

    /**
     * Sets the value of the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Call#getSignature <em>Signature</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Signature</em>' reference.
     * @see #getSignature()
     * @generated
     */
    void setSignature(Signature value);

    /**
     * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Expression}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Arguments</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Arguments</em>' containment reference list.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getCall_Arguments()
     * @model containment="true"
     * @generated
     */
    EList<Expression> getArguments();

} // Call