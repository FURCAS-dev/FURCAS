/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getNamed()
 * @model
 * @generated
 */
public interface Named extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getNamed_Name()
     * @model
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.Named#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

} // Named
