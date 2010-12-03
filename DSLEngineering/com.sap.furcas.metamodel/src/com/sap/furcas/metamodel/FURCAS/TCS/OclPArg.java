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
 * A representation of the model object '<em><b>Ocl PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQueryExpression <em>Query Expression</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOclPArg()
 * @model abstract="true"
 * @generated
 */
public interface OclPArg extends PropertyArg {
        /**
	 * Returns the value of the '<em><b>Query Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Query Expression</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Query Expression</em>' reference.
	 * @see #setQueryExpression(OCLExpression)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOclPArg_QueryExpression()
	 * @model
	 * @generated
	 */
        OCLExpression getQueryExpression();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQueryExpression <em>Query Expression</em>}' reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query Expression</em>' reference.
	 * @see #getQueryExpression()
	 * @generated
	 */
        void setQueryExpression(OCLExpression value);

        /**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Query</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getOclPArg_Query()
	 * @model required="true"
	 * @generated
	 */
        String getQuery();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.OclPArg#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
        void setQuery(String value);

} // OclPArg
