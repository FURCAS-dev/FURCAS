/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference By PArg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg#getReferenceBy <em>Reference By</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getReferenceByPArg()
 * @model
 * @generated
 */
public interface ReferenceByPArg extends PropertyArg {
    /**
     * Returns the value of the '<em><b>Reference By</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The {@link ReferenceByPArg} property argument allows to reference properties by a specific feature (typicially an identifier). This attribute defines the particular feature of potential candidates in scope (see {@link LookupScopePArg}) that shall be compared to the token value for this property.
     * 
     * This argument can either contain an OCL expression or a property name. Both have to be valid in the context of the type of this property.
     * 
     * 
     * 
     * <!-- end-model-doc -->
     * @return the value of the '<em>Reference By</em>' attribute.
     * @see #setReferenceBy(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getReferenceByPArg_ReferenceBy()
     * @model required="true"
     * @generated
     */
    String getReferenceBy();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg#getReferenceBy <em>Reference By</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reference By</em>' attribute.
     * @see #getReferenceBy()
     * @generated
     */
    void setReferenceBy(String value);

} // ReferenceByPArg
