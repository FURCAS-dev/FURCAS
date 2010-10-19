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
 * A representation of the model object '<em><b>Located Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getLocation <em>Location</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getCommentsBefore <em>Comments Before</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getCommentsAfter <em>Comments After</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLocatedElement()
 * @model abstract="true"
 * @generated
 */
public interface LocatedElement extends EObject {
        /**
         * Returns the value of the '<em><b>Location</b></em>' attribute.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Location</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Location</em>' attribute.
         * @see #setLocation(String)
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLocatedElement_Location()
         * @model unique="false" ordered="false"
         * @generated
         */
        String getLocation();

        /**
         * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement#getLocation <em>Location</em>}' attribute.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @param value the new value of the '<em>Location</em>' attribute.
         * @see #getLocation()
         * @generated
         */
        void setLocation(String value);

        /**
         * Returns the value of the '<em><b>Comments Before</b></em>' attribute list.
         * The list contents are of type {@link java.lang.String}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Comments Before</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Comments Before</em>' attribute list.
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLocatedElement_CommentsBefore()
         * @model unique="false"
         * @generated
         */
        EList<String> getCommentsBefore();

        /**
         * Returns the value of the '<em><b>Comments After</b></em>' attribute list.
         * The list contents are of type {@link java.lang.String}.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Comments After</em>' attribute list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @return the value of the '<em>Comments After</em>' attribute list.
         * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getLocatedElement_CommentsAfter()
         * @model unique="false"
         * @generated
         */
        EList<String> getCommentsAfter();

} // LocatedElement
