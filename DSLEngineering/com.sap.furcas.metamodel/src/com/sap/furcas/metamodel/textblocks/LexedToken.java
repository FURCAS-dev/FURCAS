/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.textblocks;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lexed Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.textblocks.LexedToken#isOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getLexedToken()
 * @model
 * @generated
 */
public interface LexedToken extends AbstractToken {

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see #setOperator(boolean)
	 * @see com.sap.furcas.metamodel.textblocks.TextblocksPackage#getLexedToken_Operator()
	 * @model
	 * @generated
	 */
	boolean isOperator();

	/**
	 * Sets the value of the '{@link com.sap.furcas.metamodel.textblocks.LexedToken#isOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see #isOperator()
	 * @generated
	 */
	void setOperator(boolean value);
} // LexedToken
