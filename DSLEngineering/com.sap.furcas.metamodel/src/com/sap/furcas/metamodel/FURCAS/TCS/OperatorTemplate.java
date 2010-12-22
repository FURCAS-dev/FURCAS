/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOperators <em>Operators</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getSource <em>Source</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOpTo <em>Store Op To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightTo <em>Store Right To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOperatorTo <em>Store Operator To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreLeftSideTo <em>Store Left Side To</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightSideTo <em>Store Right Side To</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate()
 * @model
 * @generated
 */
public interface OperatorTemplate extends ContextTemplate {
        /**
     * Returns the value of the '<em><b>Operators</b></em>' reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.Operator}.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getTemplates <em>Templates</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Operators</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Operators</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_Operators()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Operator#getTemplates
     * @model opposite="templates" ordered="false"
     * @generated
     */
        EList<Operator> getOperators();

        /**
     * Returns the value of the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Source</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' attribute.
     * @see #setSource(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_Source()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getSource();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getSource <em>Source</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' attribute.
     * @see #getSource()
     * @generated
     */
        void setSource(String value);

        /**
     * Returns the value of the '<em><b>Store Op To</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Store Op To</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Store Op To</em>' attribute.
     * @see #setStoreOpTo(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_StoreOpTo()
     * @model unique="false" ordered="false"
     * @generated
     */
        String getStoreOpTo();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOpTo <em>Store Op To</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Store Op To</em>' attribute.
     * @see #getStoreOpTo()
     * @generated
     */
        void setStoreOpTo(String value);

        /**
     * Returns the value of the '<em><b>Store Right To</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Store Right To</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Store Right To</em>' attribute.
     * @see #setStoreRightTo(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_StoreRightTo()
     * @model unique="false" ordered="false"
     * @generated
     */
        String getStoreRightTo();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightTo <em>Store Right To</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Store Right To</em>' attribute.
     * @see #getStoreRightTo()
     * @generated
     */
        void setStoreRightTo(String value);

        /**
     * Returns the value of the '<em><b>Store Operator To</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Store Operator To</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Store Operator To</em>' containment reference.
     * @see #setStoreOperatorTo(PropertyReference)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_StoreOperatorTo()
     * @model containment="true"
     * @generated
     */
        PropertyReference getStoreOperatorTo();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreOperatorTo <em>Store Operator To</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Store Operator To</em>' containment reference.
     * @see #getStoreOperatorTo()
     * @generated
     */
        void setStoreOperatorTo(PropertyReference value);

        /**
     * Returns the value of the '<em><b>Store Left Side To</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Store Left Side To</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Store Left Side To</em>' containment reference.
     * @see #setStoreLeftSideTo(PropertyReference)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_StoreLeftSideTo()
     * @model containment="true"
     * @generated
     */
        PropertyReference getStoreLeftSideTo();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreLeftSideTo <em>Store Left Side To</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Store Left Side To</em>' containment reference.
     * @see #getStoreLeftSideTo()
     * @generated
     */
        void setStoreLeftSideTo(PropertyReference value);

        /**
     * Returns the value of the '<em><b>Store Right Side To</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Store Right Side To</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Store Right Side To</em>' containment reference.
     * @see #setStoreRightSideTo(PropertyReference)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorTemplate_StoreRightSideTo()
     * @model containment="true"
     * @generated
     */
        PropertyReference getStoreRightSideTo();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getStoreRightSideTo <em>Store Right Side To</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Store Right Side To</em>' containment reference.
     * @see #getStoreRightSideTo()
     * @generated
     */
        void setStoreRightSideTo(PropertyReference value);

} // OperatorTemplate
