/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PostfixPArg#getPostfix <em>Postfix</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPostfixPArg()
 * @model
 * @generated
 */
public interface PostfixPArg extends PropertyArg {
    /**
     * Returns the value of the '<em><b>Postfix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Postfix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Postfix</em>' attribute.
     * @see #setPostfix(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPostfixPArg_Postfix()
     * @model required="true"
     * @generated
     */
    String getPostfix();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PostfixPArg#getPostfix <em>Postfix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Postfix</em>' attribute.
     * @see #getPostfix()
     * @generated
     */
    void setPostfix(String value);

} // PostfixPArg
