/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Arg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyArg()
 * @model abstract="true"
 * @generated
 */
public interface PropertyArg extends LocatedElement {
        /**
	 * Returns the value of the '<em><b>Property</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyArgs <em>Property Args</em>}'.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Property</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' container reference.
	 * @see #setProperty(Property)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getPropertyArg_Property()
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.Property#getPropertyArgs
	 * @model opposite="propertyArgs" required="true" transient="false" ordered="false"
	 * @generated
	 */
        Property getProperty();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg#getProperty <em>Property</em>}' container reference.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' container reference.
	 * @see #getProperty()
	 * @generated
	 */
        void setProperty(Property value);

} // PropertyArg
