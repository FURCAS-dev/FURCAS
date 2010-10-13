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
 * A representation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Priority#getList <em>List</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Priority#getValue <em>Value</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Priority#getAssociativity <em>Associativity</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.Priority#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPriority()
 * @model
 * @generated
 */
public interface Priority extends LocatedElement {
        /**
         * Returns the value of the '<em><b>List</b></em>' container reference.
         * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.OperatorList#getPriorities <em>Priorities</em>}'.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>List</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>List</em>' container reference.
         * @see #setList(OperatorList)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPriority_List()
         * @see com.sap.furcas.metamodel.TCS.OperatorList#getPriorities
         * @model opposite="priorities" required="true" transient="false" ordered="false"
         * @generated
         */
        OperatorList getList();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.Priority#getList <em>List</em>}' container reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>List</em>' container reference.
         * @see #getList()
         * @generated
         */
        void setList(OperatorList value);

        /**
         * Returns the value of the '<em><b>Value</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Value</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Value</em>' attribute.
         * @see #setValue(int)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPriority_Value()
         * @model unique="false" required="true" ordered="false"
         * @generated
         */
        int getValue();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.Priority#getValue <em>Value</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Value</em>' attribute.
         * @see #getValue()
         * @generated
         */
        void setValue(int value);

        /**
         * Returns the value of the '<em><b>Associativity</b></em>' attribute.
         * The literals are from the enumeration {@link com.sap.furcas.metamodel.TCS.Associativity}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Associativity</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Associativity</em>' attribute.
         * @see com.sap.furcas.metamodel.TCS.Associativity
         * @see #setAssociativity(Associativity)
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPriority_Associativity()
         * @model unique="false" required="true" ordered="false"
         * @generated
         */
        Associativity getAssociativity();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.Priority#getAssociativity <em>Associativity</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Associativity</em>' attribute.
         * @see com.sap.furcas.metamodel.TCS.Associativity
         * @see #getAssociativity()
         * @generated
         */
        void setAssociativity(Associativity value);

        /**
         * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
         * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Operator}.
         * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.Operator#getPriority <em>Priority</em>}'.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Operators</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Operators</em>' containment reference list.
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getPriority_Operators()
         * @see com.sap.furcas.metamodel.TCS.Operator#getPriority
         * @model opposite="priority" containment="true" ordered="false"
         * @generated
         */
        EList<Operator> getOperators();

} // Priority
