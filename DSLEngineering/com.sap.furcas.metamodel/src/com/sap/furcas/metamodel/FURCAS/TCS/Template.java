/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguate <em>Disambiguate</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguateV3 <em>Disambiguate V3</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getSemDisambiguate <em>Sem Disambiguate</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplate()
 * @model abstract="true"
 * @generated
 */
public interface Template extends QualifiedNamedElement {
        /**
     * Returns the value of the '<em><b>Concrete Syntax</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getTemplates <em>Templates</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Concrete Syntax</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Concrete Syntax</em>' container reference.
     * @see #setConcreteSyntax(ConcreteSyntax)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplate_ConcreteSyntax()
     * @see com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax#getTemplates
     * @model opposite="templates" required="true" transient="false" ordered="false"
     * @generated
     */
        ConcreteSyntax getConcreteSyntax();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getConcreteSyntax <em>Concrete Syntax</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Concrete Syntax</em>' container reference.
     * @see #getConcreteSyntax()
     * @generated
     */
        void setConcreteSyntax(ConcreteSyntax value);

        /**
     * Returns the value of the '<em><b>Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Disambiguate</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Disambiguate</em>' attribute.
     * @see #setDisambiguate(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplate_Disambiguate()
     * @model unique="false" ordered="false"
     * @generated
     */
        String getDisambiguate();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguate <em>Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Disambiguate</em>' attribute.
     * @see #getDisambiguate()
     * @generated
     */
        void setDisambiguate(String value);

        /**
     * Returns the value of the '<em><b>Disambiguate V3</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Disambiguate V3</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Disambiguate V3</em>' attribute.
     * @see #setDisambiguateV3(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplate_DisambiguateV3()
     * @model unique="false" ordered="false"
     * @generated
     */
        String getDisambiguateV3();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getDisambiguateV3 <em>Disambiguate V3</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Disambiguate V3</em>' attribute.
     * @see #getDisambiguateV3()
     * @generated
     */
        void setDisambiguateV3(String value);

								/**
     * Returns the value of the '<em><b>Sem Disambiguate</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sem Disambiguate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Sem Disambiguate</em>' attribute.
     * @see #setSemDisambiguate(String)
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplate_SemDisambiguate()
     * @model
     * @generated
     */
	String getSemDisambiguate();

								/**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.TCS.Template#getSemDisambiguate <em>Sem Disambiguate</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sem Disambiguate</em>' attribute.
     * @see #getSemDisambiguate()
     * @generated
     */
	void setSemDisambiguate(String value);

} // Template
