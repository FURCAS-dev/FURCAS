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
 *   <li>{@link de.hpi.sam.petriNet.Place#getHiddenOpposite <em>Hidden Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getPlace()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='numberOfTokens'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL numberOfTokens='self.noTokens > 3'"
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

	/**
     * Returns the value of the '<em><b>Hidden Opposite</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hidden Opposite</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hidden Opposite</em>' reference.
     * @see #setHiddenOpposite(Transition)
     * @see de.hpi.sam.petriNet.PetriNetPackage#getPlace_HiddenOpposite()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='transition2Place'"
     * @generated
     */
    Transition getHiddenOpposite();

    /**
     * Sets the value of the '{@link de.hpi.sam.petriNet.Place#getHiddenOpposite <em>Hidden Opposite</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hidden Opposite</em>' reference.
     * @see #getHiddenOpposite()
     * @generated
     */
    void setHiddenOpposite(Transition value);

} // Place
