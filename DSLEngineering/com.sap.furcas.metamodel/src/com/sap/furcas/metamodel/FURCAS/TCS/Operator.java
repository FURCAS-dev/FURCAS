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
 * A representation of the model object '<em><b>Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#isIsPostfix <em>Is Postfix</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getArity <em>Arity</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getLiteral <em>Literal</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getTemplates <em>Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperator()
 * @model
 * @generated
 */
public interface Operator extends NamedElement {
        /**
	 * Returns the value of the '<em><b>Is Postfix</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Is Postfix</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Postfix</em>' attribute.
	 * @see #setIsPostfix(boolean)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperator_IsPostfix()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
        boolean isIsPostfix();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#isIsPostfix <em>Is Postfix</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Postfix</em>' attribute.
	 * @see #isIsPostfix()
	 * @generated
	 */
        void setIsPostfix(boolean value);

        /**
	 * Returns the value of the '<em><b>Arity</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Arity</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Arity</em>' attribute.
	 * @see #setArity(int)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperator_Arity()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
        int getArity();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getArity <em>Arity</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arity</em>' attribute.
	 * @see #getArity()
	 * @generated
	 */
        void setArity(int value);

        /**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Literal#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Literal</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(Literal)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperator_Literal()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Literal#getOperators
	 * @model opposite="operators" ordered="false"
	 * @generated
	 */
        Literal getLiteral();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
        void setLiteral(Literal value);

        /**
	 * Returns the value of the '<em><b>Priority</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Priority</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' container reference.
	 * @see #setPriority(Priority)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperator_Priority()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority#getOperators
	 * @model opposite="operators" required="true" transient="false" ordered="false"
	 * @generated
	 */
        Priority getPriority();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Operator#getPriority <em>Priority</em>}' container reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' container reference.
	 * @see #getPriority()
	 * @generated
	 */
        void setPriority(Priority value);

        /**
	 * Returns the value of the '<em><b>Templates</b></em>' reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate}.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Templates</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Templates</em>' reference list.
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperator_Templates()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate#getOperators
	 * @model opposite="operators" ordered="false"
	 * @generated
	 */
        EList<OperatorTemplate> getTemplates();

} // Operator
