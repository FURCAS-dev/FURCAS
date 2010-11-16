/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTemplateName <em>Template Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isDefault <em>Default</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTokenName <em>Token Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getSerializer <em>Serializer</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isOrKeyword <em>Or Keyword</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate()
 * @model
 * @generated
 */
public interface PrimitiveTemplate extends Template {
        /**
     * Returns the value of the '<em><b>Template Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Template Name</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Template Name</em>' attribute.
     * @see #setTemplateName(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate_TemplateName()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getTemplateName();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTemplateName <em>Template Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template Name</em>' attribute.
     * @see #getTemplateName()
     * @generated
     */
        void setTemplateName(String value);

        /**
     * Returns the value of the '<em><b>Default</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default</em>' attribute.
     * @see #setDefault(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate_Default()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
    boolean isDefault();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isDefault <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default</em>' attribute.
     * @see #isDefault()
     * @generated
     */
    void setDefault(boolean value);

        /**
     * Returns the value of the '<em><b>Token Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Token Name</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Token Name</em>' attribute.
     * @see #setTokenName(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate_TokenName()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getTokenName();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getTokenName <em>Token Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Token Name</em>' attribute.
     * @see #getTokenName()
     * @generated
     */
        void setTokenName(String value);

        /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Value</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate_Value()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getValue();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
        void setValue(String value);

        /**
     * Returns the value of the '<em><b>Serializer</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Serializer</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Serializer</em>' attribute.
     * @see #setSerializer(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate_Serializer()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getSerializer();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#getSerializer <em>Serializer</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Serializer</em>' attribute.
     * @see #getSerializer()
     * @generated
     */
        void setSerializer(String value);

        /**
     * Returns the value of the '<em><b>Or Keyword</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Or Keyword</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Or Keyword</em>' attribute.
     * @see #setOrKeyword(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPrimitiveTemplate_OrKeyword()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isOrKeyword();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate#isOrKeyword <em>Or Keyword</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Or Keyword</em>' attribute.
     * @see #isOrKeyword()
     * @generated
     */
        void setOrKeyword(boolean value);

} // PrimitiveTemplate
