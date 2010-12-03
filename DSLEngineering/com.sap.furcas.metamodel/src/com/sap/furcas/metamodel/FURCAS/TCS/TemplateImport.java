/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplateImport()
 * @model
 * @generated
 */
public interface TemplateImport extends ImportDeclaration {

    /**
     * Returns the value of the '<em><b>Template</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Template</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Template</em>' reference.
     * @see #setTemplate(Template)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplateImport_Template()
     * @model required="true"
     * @generated
     */
    Template getTemplate();

    /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getTemplate <em>Template</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Template</em>' reference.
     * @see #getTemplate()
     * @generated
     */
    void setTemplate(Template value);
} // TemplateImport
