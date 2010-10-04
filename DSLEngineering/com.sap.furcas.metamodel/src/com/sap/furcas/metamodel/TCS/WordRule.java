/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Word Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.WordRule#getStart <em>Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.WordRule#getPart <em>Part</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.WordRule#getEnd <em>End</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.WordRule#getWords <em>Words</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWordRule()
 * @model
 * @generated
 */
public interface WordRule extends Rule {
        /**
         * Returns the value of the '<em><b>Start</b></em>' containment reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Start</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Start</em>' containment reference.
         * @see #setStart(OrPattern)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWordRule_Start()
         * @model containment="true" required="true" ordered="false"
         * @generated
         */
        OrPattern getStart();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.WordRule#getStart <em>Start</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Start</em>' containment reference.
         * @see #getStart()
         * @generated
         */
        void setStart(OrPattern value);

        /**
         * Returns the value of the '<em><b>Part</b></em>' containment reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Part</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Part</em>' containment reference.
         * @see #setPart(OrPattern)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWordRule_Part()
         * @model containment="true" required="true" ordered="false"
         * @generated
         */
        OrPattern getPart();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.WordRule#getPart <em>Part</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Part</em>' containment reference.
         * @see #getPart()
         * @generated
         */
        void setPart(OrPattern value);

        /**
         * Returns the value of the '<em><b>End</b></em>' containment reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>End</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>End</em>' containment reference.
         * @see #setEnd(OrPattern)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWordRule_End()
         * @model containment="true" ordered="false"
         * @generated
         */
        OrPattern getEnd();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.WordRule#getEnd <em>End</em>}' containment reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>End</em>' containment reference.
         * @see #getEnd()
         * @generated
         */
        void setEnd(OrPattern value);

        /**
         * Returns the value of the '<em><b>Words</b></em>' containment reference list.
         * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Word}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Words</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Words</em>' containment reference list.
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getWordRule_Words()
         * @model containment="true" ordered="false"
         * @generated
         */
        EList<Word> getWords();

} // WordRule
