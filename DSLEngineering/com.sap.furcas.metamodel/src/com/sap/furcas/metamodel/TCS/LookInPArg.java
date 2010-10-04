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
 * A representation of the model object '<em><b>Look In PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.LookInPArg#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getLookInPArg()
 * @model
 * @generated
 */
public interface LookInPArg extends PropertyArg {
        /**
         * Returns the value of the '<em><b>Property Name</b></em>' attribute list.
         * The list contents are of type {@link java.lang.String}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property Name</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Property Name</em>' attribute list.
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getLookInPArg_PropertyName()
         * @model
         * @generated
         */
        EList<String> getPropertyName();

} // LookInPArg
