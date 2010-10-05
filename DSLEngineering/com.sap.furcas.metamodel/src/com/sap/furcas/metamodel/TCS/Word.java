/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Word#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWord()
 * @model
 * @generated
 */
public interface Word extends NamedElement {
        /**
         * Returns the value of the '<em><b>Token</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Token</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Token</em>' attribute.
         * @see #setToken(String)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWord_Token()
         * @model unique="false" required="true" ordered="false"
         * @generated
         */
        String getToken();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.Word#getToken <em>Token</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Token</em>' attribute.
         * @see #getToken()
         * @generated
         */
        void setToken(String value);

} // Word
