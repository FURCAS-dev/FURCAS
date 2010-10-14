/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.Arc#getSource <em>Source</em>}</li>
 *   <li>{@link de.hpi.sam.petriNet.Arc#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends Element {
	/**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * It is bidirectional and its opposite is '{@link de.hpi.sam.petriNet.Node#getOutgoingArcs <em>Outgoing Arcs</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(Node)
     * @see de.hpi.sam.petriNet.PetriNetPackage#getArc_Source()
     * @see de.hpi.sam.petriNet.Node#getOutgoingArcs
     * @model opposite="outgoingArcs" required="true"
     * @generated
     */
	Node getSource();

	/**
     * Sets the value of the '{@link de.hpi.sam.petriNet.Arc#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
	void setSource(Node value);

	/**
     * Returns the value of the '<em><b>Target</b></em>' reference.
     * It is bidirectional and its opposite is '{@link de.hpi.sam.petriNet.Node#getIncomingArcs <em>Incoming Arcs</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Target</em>' reference.
     * @see #setTarget(Node)
     * @see de.hpi.sam.petriNet.PetriNetPackage#getArc_Target()
     * @see de.hpi.sam.petriNet.Node#getIncomingArcs
     * @model opposite="incomingArcs" required="true"
     * @generated
     */
	Node getTarget();

	/**
     * Sets the value of the '{@link de.hpi.sam.petriNet.Arc#getTarget <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target</em>' reference.
     * @see #getTarget()
     * @generated
     */
	void setTarget(Node value);

} // Arc
