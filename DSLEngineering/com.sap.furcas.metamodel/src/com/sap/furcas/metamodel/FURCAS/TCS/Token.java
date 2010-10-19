/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Token#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Token#isOmitted <em>Omitted</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends NamedElement {
        /**
         * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Pattern</em>' containment reference.
         * @see #setPattern(OrPattern)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getToken_Pattern()
         * @model containment="true" required="true" ordered="false"
         * @generated
         */
        OrPattern getPattern();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Token#getPattern <em>Pattern</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Pattern</em>' containment reference.
         * @see #getPattern()
         * @generated
         */
        void setPattern(OrPattern value);

        /**
         * Returns the value of the '<em><b>Omitted</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Omitted</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Omitted</em>' attribute.
         * @see #setOmitted(boolean)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getToken_Omitted()
         * @model
         * @generated
         */
        boolean isOmitted();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Token#isOmitted <em>Omitted</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Omitted</em>' attribute.
         * @see #isOmitted()
         * @generated
         */
        void setOmitted(boolean value);

} // Token
