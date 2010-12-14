/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Syntax Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntaxImport#getMode <em>Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getConcreteSyntaxImport()
 * @model
 * @generated
 */
public interface ConcreteSyntaxImport extends ImportDeclaration {
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
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getConcreteSyntaxImport_Mode()
	 * @model
	 * @generated
	 */
    String getMode();

    /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntaxImport#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
    void setMode(String value);

} // ConcreteSyntaxImport
