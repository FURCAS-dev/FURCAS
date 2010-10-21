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
 * A representation of the model object '<em><b>Operator List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getName <em>Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getPriorities <em>Priorities</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorList()
 * @model
 * @generated
 */
public interface OperatorList extends LocatedElement {
        /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Name</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorList_Name()
     * @model unique="false" ordered="false"
     * @generated
     */
        String getName();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OperatorList#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
        void setName(String value);

        /**
     * Returns the value of the '<em><b>Priorities</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.Priority}.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Priority#getList <em>List</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Priorities</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Priorities</em>' containment reference list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOperatorList_Priorities()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.Priority#getList
     * @model opposite="list" containment="true"
     * @generated
     */
        EList<Priority> getPriorities();

} // OperatorList
