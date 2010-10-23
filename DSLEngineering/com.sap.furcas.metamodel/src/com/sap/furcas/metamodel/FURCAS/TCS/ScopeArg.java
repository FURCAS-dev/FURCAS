/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope Arg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getScopeArg()
 * @model
 * @generated
 */
public interface ScopeArg extends EObject {
        /**
     * Returns the value of the '<em><b>Scope</b></em>' attribute.
     * The literals are from the enumeration {@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Scope</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Scope</em>' attribute.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind
     * @see #setScope(ScopeKind)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getScopeArg_Scope()
     * @model required="true"
     * @generated
     */
        ScopeKind getScope();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg#getScope <em>Scope</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scope</em>' attribute.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind
     * @see #getScope()
     * @generated
     */
        void setScope(ScopeKind value);

} // ScopeArg
