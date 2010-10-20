/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.ocl.ecore.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Property Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOclPropertyInit()
 * @model
 * @generated
 */
public interface OclPropertyInit extends PropertyInit {
        /**
         * Returns the value of the '<em><b>Ocl Expression</b></em>' reference.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Ocl Expression</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Ocl Expression</em>' reference.
         * @see #setOclExpression(OCLExpression)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOclPropertyInit_OclExpression()
         * @model
         * @generated
         */
        OCLExpression getOclExpression();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit#getOclExpression <em>Ocl Expression</em>}' reference.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Ocl Expression</em>' reference.
         * @see #getOclExpression()
         * @generated
         */
        void setOclExpression(OCLExpression value);

} // OclPropertyInit
