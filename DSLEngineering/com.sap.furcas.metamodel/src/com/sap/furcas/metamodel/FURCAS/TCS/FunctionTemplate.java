/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionSequence <em>Function Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFunctionTemplate()
 * @model
 * @generated
 */
public interface FunctionTemplate extends Template {
        /**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Function Name</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFunctionTemplate_FunctionName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
        String getFunctionName();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 * @generated
	 */
        void setFunctionName(String value);

        /**
	 * Returns the value of the '<em><b>Function Sequence</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getFunctionContainer <em>Function Container</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Function Sequence</em>' containment reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Sequence</em>' containment reference.
	 * @see #setFunctionSequence(Sequence)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getFunctionTemplate_FunctionSequence()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Sequence#getFunctionContainer
	 * @model opposite="functionContainer" containment="true" required="true" ordered="false"
	 * @generated
	 */
        Sequence getFunctionSequence();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate#getFunctionSequence <em>Function Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Sequence</em>' containment reference.
	 * @see #getFunctionSequence()
	 * @generated
	 */
        void setFunctionSequence(Sequence value);

} // FunctionTemplate
