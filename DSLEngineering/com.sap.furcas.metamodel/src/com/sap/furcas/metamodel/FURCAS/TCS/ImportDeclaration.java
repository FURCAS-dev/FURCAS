/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration#isIsPartImport <em>Is Part Import</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getImportDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface ImportDeclaration extends EObject {
    /**
	 * Returns the value of the '<em><b>Concrete Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Concrete Syntax</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Syntax</em>' reference.
	 * @see #setConcreteSyntax(ConcreteSyntax)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getImportDeclaration_ConcreteSyntax()
	 * @model required="true"
	 * @generated
	 */
    ConcreteSyntax getConcreteSyntax();

    /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration#getConcreteSyntax <em>Concrete Syntax</em>}' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concrete Syntax</em>' reference.
	 * @see #getConcreteSyntax()
	 * @generated
	 */
    void setConcreteSyntax(ConcreteSyntax value);

    /**
	 * Returns the value of the '<em><b>Is Part Import</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Is Part Import</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Part Import</em>' attribute.
	 * @see #setIsPartImport(boolean)
	 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getImportDeclaration_IsPartImport()
	 * @model
	 * @generated
	 */
    boolean isIsPartImport();

    /**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration#isIsPartImport <em>Is Part Import</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Part Import</em>' attribute.
	 * @see #isIsPartImport()
	 * @generated
	 */
    void setIsPartImport(boolean value);

} // ImportDeclaration
