/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getStrucfeature <em>Strucfeature</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyReference()
 * @model
 * @generated
 */
public interface PropertyReference extends EObject {
        /**
     * Returns the value of the '<em><b>Strucfeature</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Strucfeature</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Strucfeature</em>' reference.
     * @see #setStrucfeature(EStructuralFeature)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyReference_Strucfeature()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='furcasPropertyReference'"
     * @generated
     */
        EStructuralFeature getStrucfeature();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getStrucfeature <em>Strucfeature</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Strucfeature</em>' reference.
     * @see #getStrucfeature()
     * @generated
     */
        void setStrucfeature(EStructuralFeature value);

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
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyReference_Name()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
        String getName();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
        void setName(String value);

} // PropertyReference
