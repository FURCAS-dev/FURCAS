/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.Place#getNoTokens <em>No Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends Node {
	/**
	 * Returns the value of the '<em><b>No Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Tokens</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Tokens</em>' attribute.
	 * @see #setNoTokens(int)
	 * @see de.hpi.sam.petriNet.PetriNetPackage#getPlace_NoTokens()
	 * @model
	 * @generated
	 */
	int getNoTokens();

	/**
	 * Sets the value of the '{@link de.hpi.sam.petriNet.Place#getNoTokens <em>No Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Tokens</em>' attribute.
	 * @see #getNoTokens()
	 * @generated
	 */
	void setNoTokens(int value);

} // Place
