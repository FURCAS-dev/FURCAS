/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getCondition <em>Condition</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getThenSequence <em>Then Sequence</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getElseSequence <em>Else Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getConditionalElement()
 * @model
 * @generated
 */
public interface ConditionalElement extends SequenceElement {
        /**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Expression#getConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getConditionalElement_Condition()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Expression#getConditionalElement
	 * @model opposite="conditionalElement" containment="true" required="true" ordered="false"
	 * @generated
	 */
        Expression getCondition();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
        void setCondition(Expression value);

        /**
	 * Returns the value of the '<em><b>Then Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getThenContainer <em>Then Container</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Then Sequence</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Sequence</em>' containment reference.
	 * @see #setThenSequence(Sequence)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getConditionalElement_ThenSequence()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getThenContainer
	 * @model opposite="thenContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
        Sequence getThenSequence();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getThenSequence <em>Then Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Sequence</em>' containment reference.
	 * @see #getThenSequence()
	 * @generated
	 */
        void setThenSequence(Sequence value);

        /**
	 * Returns the value of the '<em><b>Else Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElseContainer <em>Else Container</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Else Sequence</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Sequence</em>' containment reference.
	 * @see #setElseSequence(Sequence)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getConditionalElement_ElseSequence()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getElseContainer
	 * @model opposite="elseContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
        Sequence getElseSequence();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement#getElseSequence <em>Else Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Sequence</em>' containment reference.
	 * @see #getElseSequence()
	 * @generated
	 */
        void setElseSequence(Sequence value);

} // ConditionalElement
