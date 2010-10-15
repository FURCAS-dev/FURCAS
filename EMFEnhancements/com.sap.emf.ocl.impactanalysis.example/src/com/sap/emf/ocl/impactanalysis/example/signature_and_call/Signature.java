/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getSignature()
 * @model
 * @generated
 */
public interface Signature extends Named {
    /**
     * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Parameter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameters</em>' containment reference list.
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getSignature_Parameters()
     * @model containment="true"
     * @generated
     */
    EList<Parameter> getParameters();

} // Signature
