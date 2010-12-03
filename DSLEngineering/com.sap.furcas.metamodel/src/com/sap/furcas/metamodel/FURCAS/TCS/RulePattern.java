/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.RulePattern#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getRulePattern()
 * @model
 * @generated
 */
public interface RulePattern extends SimplePattern {
        /**
	 * Returns the value of the '<em><b>Rule</b></em>' containment reference.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Rule</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' containment reference.
	 * @see #setRule(Rule)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getRulePattern_Rule()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
        Rule getRule();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.RulePattern#getRule <em>Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' containment reference.
	 * @see #getRule()
	 * @generated
	 */
        void setRule(Rule value);

} // RulePattern
