/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.impactanalysis.example.signature_and_call;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getStringLiteral()
 * @model
 * @generated
 */
public interface StringLiteral extends Expression {
    /**
     * Returns the value of the '<em><b>Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Symbol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Symbol</em>' attribute.
     * @see #setSymbol(String)
     * @see com.sap.emf.ocl.impactanalysis.example.signature_and_call.Signature_and_callPackage#getStringLiteral_Symbol()
     * @model required="true"
     * @generated
     */
    String getSymbol();

    /**
     * Sets the value of the '{@link com.sap.emf.ocl.impactanalysis.example.signature_and_call.StringLiteral#getSymbol <em>Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Symbol</em>' attribute.
     * @see #getSymbol()
     * @generated
     */
    void setSymbol(String value);

} // StringLiteral
