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
 * A representation of the model object '<em><b>Multi Line Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getStart <em>Start</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getEnd <em>End</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getEsc <em>Esc</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getEscMappings <em>Esc Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getMultiLineRule()
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
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getMultiLineRule_Start()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	StringPattern getStart();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getStart <em>Start</em>}' containment reference.
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
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getMultiLineRule_End()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	StringPattern getEnd();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getEnd <em>End</em>}' containment reference.
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
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getMultiLineRule_Esc()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StringPattern getEsc();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.MultiLineRule#getEsc <em>Esc</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Esc</em>' containment reference.
	 * @see #getEsc()
	 * @generated
	 */
	void setEsc(StringPattern value);

	/**
	 * Returns the value of the '<em><b>Esc Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Mapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Esc Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Esc Mappings</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getMultiLineRule_EscMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Mapping> getEscMappings();

} // MultiLineRule
