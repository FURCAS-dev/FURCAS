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
 * A representation of the model object '<em><b>Multi Line Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getStart <em>Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEnd <em>End</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEsc <em>Esc</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEscMappings <em>Esc Mappings</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropStart <em>Drop Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropEnd <em>Drop End</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule()
 * @model
 * @generated
 */
public interface MultiLineRule extends Rule {
        /**
     * Returns the value of the '<em><b>Start</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Start</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Start</em>' containment reference.
     * @see #setStart(StringPattern)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule_Start()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
        StringPattern getStart();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getStart <em>Start</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start</em>' containment reference.
     * @see #getStart()
     * @generated
     */
        void setStart(StringPattern value);

        /**
     * Returns the value of the '<em><b>End</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>End</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>End</em>' containment reference.
     * @see #setEnd(StringPattern)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule_End()
     * @model containment="true" required="true" ordered="false"
     * @generated
     */
        StringPattern getEnd();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEnd <em>End</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>End</em>' containment reference.
     * @see #getEnd()
     * @generated
     */
        void setEnd(StringPattern value);

        /**
     * Returns the value of the '<em><b>Esc</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Esc</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Esc</em>' containment reference.
     * @see #setEsc(StringPattern)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule_Esc()
     * @model containment="true" ordered="false"
     * @generated
     */
        StringPattern getEsc();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#getEsc <em>Esc</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Esc</em>' containment reference.
     * @see #getEsc()
     * @generated
     */
        void setEsc(StringPattern value);

        /**
     * Returns the value of the '<em><b>Esc Mappings</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.Mapping}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Esc Mappings</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Esc Mappings</em>' containment reference list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule_EscMappings()
     * @model containment="true" ordered="false"
     * @generated
     */
        EList<Mapping> getEscMappings();

        /**
     * Returns the value of the '<em><b>Drop Start</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Drop Start</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Drop Start</em>' attribute.
     * @see #setDropStart(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule_DropStart()
     * @model
     * @generated
     */
        boolean isDropStart();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropStart <em>Drop Start</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Drop Start</em>' attribute.
     * @see #isDropStart()
     * @generated
     */
        void setDropStart(boolean value);

        /**
     * Returns the value of the '<em><b>Drop End</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Drop End</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Drop End</em>' attribute.
     * @see #setDropEnd(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getMultiLineRule_DropEnd()
     * @model
     * @generated
     */
        boolean isDropEnd();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule#isDropEnd <em>Drop End</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Drop End</em>' attribute.
     * @see #isDropEnd()
     * @generated
     */
        void setDropEnd(boolean value);

} // MultiLineRule
