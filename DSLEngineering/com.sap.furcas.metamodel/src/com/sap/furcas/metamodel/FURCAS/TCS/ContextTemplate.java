/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsContext <em>Is Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsAddToContext <em>Is Add To Context</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsReferenceOnly <em>Is Reference Only</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getContextTags <em>Context Tags</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTemplate()
 * @model
 * @generated
 */
public interface ContextTemplate extends Template {
        /**
         * Returns the value of the '<em><b>Is Context</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Context</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Is Context</em>' attribute.
         * @see #setIsContext(boolean)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTemplate_IsContext()
         * @model unique="false" required="true" ordered="false"
         * @generated
         */
        boolean isIsContext();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsContext <em>Is Context</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Is Context</em>' attribute.
         * @see #isIsContext()
         * @generated
         */
        void setIsContext(boolean value);

        /**
         * Returns the value of the '<em><b>Is Add To Context</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Add To Context</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Is Add To Context</em>' attribute.
         * @see #setIsAddToContext(boolean)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTemplate_IsAddToContext()
         * @model unique="false" required="true" ordered="false"
         * @generated
         */
        boolean isIsAddToContext();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsAddToContext <em>Is Add To Context</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Is Add To Context</em>' attribute.
         * @see #isIsAddToContext()
         * @generated
         */
        void setIsAddToContext(boolean value);

        /**
         * Returns the value of the '<em><b>Is Reference Only</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Reference Only</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Is Reference Only</em>' attribute.
         * @see #setIsReferenceOnly(boolean)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTemplate_IsReferenceOnly()
         * @model required="true"
         * @generated
         */
        boolean isIsReferenceOnly();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#isIsReferenceOnly <em>Is Reference Only</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Is Reference Only</em>' attribute.
         * @see #isIsReferenceOnly()
         * @generated
         */
        void setIsReferenceOnly(boolean value);

        /**
         * Returns the value of the '<em><b>Context Tags</b></em>' reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Context Tags</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Context Tags</em>' reference.
         * @see #setContextTags(ContextTags)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTemplate_ContextTags()
         * @model
         * @generated
         */
        ContextTags getContextTags();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getContextTags <em>Context Tags</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Context Tags</em>' reference.
         * @see #getContextTags()
         * @generated
         */
        void setContextTags(ContextTags value);

        /**
         * Returns the value of the '<em><b>Scope</b></em>' containment reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Scope</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Scope</em>' containment reference.
         * @see #setScope(ScopeArg)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTemplate_Scope()
         * @model containment="true"
         * @generated
         */
        ScopeArg getScope();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate#getScope <em>Scope</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Scope</em>' containment reference.
         * @see #getScope()
         * @generated
         */
        void setScope(ScopeArg value);

} // ContextTemplate
