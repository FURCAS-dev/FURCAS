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
 * A representation of the model object '<em><b>Or Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.OrPattern#getSimplePatterns <em>Simple Patterns</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getOrPattern()
 * @model
 * @generated
 */
public interface OrPattern extends LocatedElement {
        /**
         * Returns the value of the '<em><b>Simple Patterns</b></em>' containment reference list.
         * The list contents are of type {@link com.sap.furcas.metamodel.TCS.SimplePattern}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Simple Patterns</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Simple Patterns</em>' containment reference list.
         * @see com.sap.furcas.metamodel.TCS.TCSPackage#getOrPattern_SimplePatterns()
         * @model containment="true" required="true"
         * @generated
         */
        EList<SimplePattern> getSimplePatterns();

} // OrPattern
