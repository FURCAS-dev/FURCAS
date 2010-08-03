/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Syntax</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getK <em>K</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getTemplates <em>Templates</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getSymbols <em>Symbols</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getOperatorLists <em>Operator Lists</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getTokens <em>Tokens</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getLexer <em>Lexer</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax()
 * @model
 * @generated
 */
public interface ConcreteSyntax extends NamedElement {
	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>K</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #isSetK()
	 * @see #unsetK()
	 * @see #setK(Integer)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_K()
	 * @model unique="false" unsettable="true" ordered="false"
	 * @generated
	 */
	Integer getK();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #isSetK()
	 * @see #unsetK()
	 * @see #getK()
	 * @generated
	 */
	void setK(Integer value);

	/**
	 * Unsets the value of the '{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetK()
	 * @see #getK()
	 * @see #setK(Integer)
	 * @generated
	 */
	void unsetK();

	/**
	 * Returns whether the value of the '{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getK <em>K</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>K</em>' attribute is set.
	 * @see #unsetK()
	 * @see #getK()
	 * @see #setK(Integer)
	 * @generated
	 */
	boolean isSetK();

	/**
	 * Returns the value of the '<em><b>Templates</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Template}.
	 * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.TCS.Template#getConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Templates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Templates</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_Templates()
	 * @see com.sap.furcas.metamodel.TCS.Template#getConcreteSyntax
	 * @model opposite="concreteSyntax" containment="true"
	 * @generated
	 */
	EList<Template> getTemplates();

	/**
	 * Returns the value of the '<em><b>Keywords</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Keyword}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keywords</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keywords</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_Keywords()
	 * @model containment="true"
	 * @generated
	 */
	EList<Keyword> getKeywords();

	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Symbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_Symbols()
	 * @model containment="true"
	 * @generated
	 */
	EList<Symbol> getSymbols();

	/**
	 * Returns the value of the '<em><b>Operator Lists</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.OperatorList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator Lists</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator Lists</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_OperatorLists()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperatorList> getOperatorLists();

	/**
	 * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
	 * The list contents are of type {@link com.sap.furcas.metamodel.TCS.Token}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tokens</em>' containment reference list.
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_Tokens()
	 * @model containment="true"
	 * @generated
	 */
	EList<Token> getTokens();

	/**
	 * Returns the value of the '<em><b>Lexer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lexer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lexer</em>' attribute.
	 * @see #setLexer(String)
	 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getConcreteSyntax_Lexer()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getLexer();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.TCS.ConcreteSyntax#getLexer <em>Lexer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lexer</em>' attribute.
	 * @see #getLexer()
	 * @generated
	 */
	void setLexer(String value);

} // ConcreteSyntax
