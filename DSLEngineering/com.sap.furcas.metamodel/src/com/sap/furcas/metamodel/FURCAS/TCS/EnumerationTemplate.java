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
 * A representation of the model object '<em><b>Enumeration Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#isAutomatic <em>Automatic</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getEnumerationTemplate()
 * @model
 * @generated
 */
public interface EnumerationTemplate extends Template {
        /**
	 * Returns the value of the '<em><b>Automatic</b></em>' attribute.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Automatic</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Automatic</em>' attribute.
	 * @see #setAutomatic(boolean)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getEnumerationTemplate_Automatic()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
        boolean isAutomatic();

        /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate#isAutomatic <em>Automatic</em>}' attribute.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Automatic</em>' attribute.
	 * @see #isAutomatic()
	 * @generated
	 */
        void setAutomatic(boolean value);

        /**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping}.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getEnumerationTemplate_Mappings()
	 * @model containment="true"
	 * @generated
	 */
        EList<EnumLiteralMapping> getMappings();

} // EnumerationTemplate
