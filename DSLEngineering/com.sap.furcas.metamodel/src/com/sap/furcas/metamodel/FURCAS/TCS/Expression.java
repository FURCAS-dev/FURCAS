/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Expression#getConditionalElement <em>Conditional Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends LocatedElement {
        /**
     * Returns the value of the '<em><b>Conditional Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getCondition <em>Condition</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Conditional Element</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Conditional Element</em>' container reference.
     * @see #setConditionalElement(ConditionalElement)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getExpression_ConditionalElement()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getCondition
     * @model opposite="condition" required="true" transient="false" ordered="false"
     * @generated
     */
        ConditionalElement getConditionalElement();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Expression#getConditionalElement <em>Conditional Element</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Conditional Element</em>' container reference.
     * @see #getConditionalElement()
     * @generated
     */
        void setConditionalElement(ConditionalElement value);

} // Expression
