/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.ecore.EPackage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getTemplate <em>Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getMode <em>Mode</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getTemplatePackage <em>Template Package</em>}</li>
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

				/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplateImport_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

				/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

				/**
	 * Returns the value of the '<em><b>Template Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Package</em>' reference.
	 * @see #setTemplatePackage(EPackage)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplateImport_TemplatePackage()
	 * @model
	 * @generated
	 */
	EPackage getTemplatePackage();

				/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport#getTemplatePackage <em>Template Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Package</em>' reference.
	 * @see #getTemplatePackage()
	 * @generated
	 */
	void setTemplatePackage(EPackage value);
} // TemplateImport
