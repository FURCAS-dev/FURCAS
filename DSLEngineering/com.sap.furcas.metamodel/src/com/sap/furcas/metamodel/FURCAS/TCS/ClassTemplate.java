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
 * A representation of the model object '<em><b>Class Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getModifiers <em>Modifiers</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsDeep <em>Is Deep</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsOperatored <em>Is Operatored</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getOperatorList <em>Operator List</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMain <em>Is Main</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMulti <em>Is Multi</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsNonPrimary <em>Is Non Primary</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate()
 * @model
 * @generated
 */
public interface ClassTemplate extends ContextTemplate {
        /**
     * Returns the value of the '<em><b>Modifiers</b></em>' attribute list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers}.
     * The literals are from the enumeration {@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Modifiers</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Modifiers</em>' attribute list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_Modifiers()
     * @model unique="false" ordered="false"
     * @generated
     */
        EList<TemplateModifiers> getModifiers();

        /**
     * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Is Abstract</em>' attribute.
     * @see #setIsAbstract(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_IsAbstract()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isIsAbstract();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsAbstract <em>Is Abstract</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Abstract</em>' attribute.
     * @see #isIsAbstract()
     * @generated
     */
        void setIsAbstract(boolean value);

        /**
     * Returns the value of the '<em><b>Is Deep</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Deep</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Is Deep</em>' attribute.
     * @see #setIsDeep(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_IsDeep()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isIsDeep();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsDeep <em>Is Deep</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Deep</em>' attribute.
     * @see #isIsDeep()
     * @generated
     */
        void setIsDeep(boolean value);

        /**
     * Returns the value of the '<em><b>Is Operatored</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Operatored</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Is Operatored</em>' attribute.
     * @see #setIsOperatored(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_IsOperatored()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isIsOperatored();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsOperatored <em>Is Operatored</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Operatored</em>' attribute.
     * @see #isIsOperatored()
     * @generated
     */
        void setIsOperatored(boolean value);

        /**
     * Returns the value of the '<em><b>Operator List</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Operator List</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Operator List</em>' reference.
     * @see #setOperatorList(OperatorList)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_OperatorList()
     * @model ordered="false"
     * @generated
     */
        OperatorList getOperatorList();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getOperatorList <em>Operator List</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operator List</em>' reference.
     * @see #getOperatorList()
     * @generated
     */
        void setOperatorList(OperatorList value);

        /**
     * Returns the value of the '<em><b>Is Main</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Main</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Is Main</em>' attribute.
     * @see #setIsMain(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_IsMain()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isIsMain();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMain <em>Is Main</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Main</em>' attribute.
     * @see #isIsMain()
     * @generated
     */
        void setIsMain(boolean value);

        /**
     * Returns the value of the '<em><b>Is Multi</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Multi</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Is Multi</em>' attribute.
     * @see #setIsMulti(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_IsMulti()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isIsMulti();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsMulti <em>Is Multi</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Multi</em>' attribute.
     * @see #isIsMulti()
     * @generated
     */
        void setIsMulti(boolean value);

        /**
     * Returns the value of the '<em><b>Is Non Primary</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Non Primary</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Is Non Primary</em>' attribute.
     * @see #setIsNonPrimary(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_IsNonPrimary()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        boolean isIsNonPrimary();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#isIsNonPrimary <em>Is Non Primary</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Non Primary</em>' attribute.
     * @see #isIsNonPrimary()
     * @generated
     */
        void setIsNonPrimary(boolean value);

        /**
     * Returns the value of the '<em><b>Mode</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Mode</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Mode</em>' attribute.
     * @see #setMode(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getClassTemplate_Mode()
     * @model unique="false" ordered="false"
     * @generated
     */
        String getMode();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate#getMode <em>Mode</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mode</em>' attribute.
     * @see #getMode()
     * @generated
     */
        void setMode(String value);

} // ClassTemplate
