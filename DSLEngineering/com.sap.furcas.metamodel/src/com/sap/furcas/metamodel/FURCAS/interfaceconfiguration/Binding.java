/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.interfaceconfiguration;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.RequiredInterfaceTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequireingSyntax <em>Requireing Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidingSyntax <em>Providing Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequiredTemplate <em>Required Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidedTemplate <em>Provided Template</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#getBinding()
 * @model
 * @generated
 */
public interface Binding extends EObject {
	/**
	 * Returns the value of the '<em><b>Requireing Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requireing Syntax</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requireing Syntax</em>' reference.
	 * @see #setRequireingSyntax(ConcreteSyntax)
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#getBinding_RequireingSyntax()
	 * @model required="true"
	 * @generated
	 */
	ConcreteSyntax getRequireingSyntax();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequireingSyntax <em>Requireing Syntax</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requireing Syntax</em>' reference.
	 * @see #getRequireingSyntax()
	 * @generated
	 */
	void setRequireingSyntax(ConcreteSyntax value);

	/**
	 * Returns the value of the '<em><b>Providing Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providing Syntax</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providing Syntax</em>' reference.
	 * @see #setProvidingSyntax(ConcreteSyntax)
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#getBinding_ProvidingSyntax()
	 * @model required="true"
	 * @generated
	 */
	ConcreteSyntax getProvidingSyntax();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidingSyntax <em>Providing Syntax</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Providing Syntax</em>' reference.
	 * @see #getProvidingSyntax()
	 * @generated
	 */
	void setProvidingSyntax(ConcreteSyntax value);

	/**
	 * Returns the value of the '<em><b>Required Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Template</em>' reference.
	 * @see #setRequiredTemplate(RequiredInterfaceTemplate)
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#getBinding_RequiredTemplate()
	 * @model required="true"
	 * @generated
	 */
	RequiredInterfaceTemplate getRequiredTemplate();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getRequiredTemplate <em>Required Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Template</em>' reference.
	 * @see #getRequiredTemplate()
	 * @generated
	 */
	void setRequiredTemplate(RequiredInterfaceTemplate value);

	/**
	 * Returns the value of the '<em><b>Provided Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Template</em>' reference.
	 * @see #setProvidedTemplate(Template)
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#getBinding_ProvidedTemplate()
	 * @model required="true"
	 * @generated
	 */
	Template getProvidedTemplate();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getProvidedTemplate <em>Provided Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Template</em>' reference.
	 * @see #getProvidedTemplate()
	 * @generated
	 */
	void setProvidedTemplate(Template value);

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
	 * @see com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationPackage#getBinding_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

} // Binding
