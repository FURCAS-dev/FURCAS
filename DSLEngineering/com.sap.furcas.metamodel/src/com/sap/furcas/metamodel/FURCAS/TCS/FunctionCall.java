/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall#getCalledFunction <em>Called Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends SequenceElement {
        /**
         * Returns the value of the '<em><b>Called Function</b></em>' reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Called Function</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Called Function</em>' reference.
         * @see #setCalledFunction(FunctionTemplate)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFunctionCall_CalledFunction()
         * @model required="true" ordered="false"
         * @generated
         */
        FunctionTemplate getCalledFunction();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall#getCalledFunction <em>Called Function</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Called Function</em>' reference.
         * @see #getCalledFunction()
         * @generated
         */
        void setCalledFunction(FunctionTemplate value);

} // FunctionCall
