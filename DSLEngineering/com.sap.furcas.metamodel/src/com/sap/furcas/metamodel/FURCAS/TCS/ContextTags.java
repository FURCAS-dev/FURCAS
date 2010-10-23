/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Tags</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ContextTags#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTags()
 * @model
 * @generated
 */
public interface ContextTags extends EObject {
        /**
     * Returns the value of the '<em><b>Tags</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Tags</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Tags</em>' attribute list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getContextTags_Tags()
     * @model
     * @generated
     */
        EList<String> getTags();

} // ContextTags
