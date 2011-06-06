/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyArgs <em>Property Args</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyReference <em>Property Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends SequenceElement {
        /**
     * Returns the value of the '<em><b>Property Args</b></em>' containment reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg}.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property Args</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Property Args</em>' containment reference list.
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getProperty_PropertyArgs()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg#getProperty
     * @model opposite="property" containment="true"
     * @generated
     */
        EList<PropertyArg> getPropertyArgs();

        /**
     * Returns the value of the '<em><b>Property Reference</b></em>' containment reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property Reference</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Property Reference</em>' containment reference.
     * @see #setPropertyReference(PropertyReference)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getProperty_PropertyReference()
     * @model containment="true" required="true"
     * @generated
     */
        PropertyReference getPropertyReference();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyReference <em>Property Reference</em>}' containment reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property Reference</em>' containment reference.
     * @see #getPropertyReference()
     * @generated
     */
        void setPropertyReference(PropertyReference value);

} // Property
