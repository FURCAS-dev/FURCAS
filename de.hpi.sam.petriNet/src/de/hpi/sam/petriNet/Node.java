/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.Node#getOutgoingArcs <em>Outgoing Arcs</em>}</li>
 *   <li>{@link de.hpi.sam.petriNet.Node#getIncomingArcs <em>Incoming Arcs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends Element {
	/**
	 * Returns the value of the '<em><b>Outgoing Arcs</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.petriNet.Arc}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.petriNet.Arc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Arcs</em>' reference list.
	 * @see de.hpi.sam.petriNet.PetriNetPackage#getNode_OutgoingArcs()
	 * @see de.hpi.sam.petriNet.Arc#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Arc> getOutgoingArcs();

	/**
	 * Returns the value of the '<em><b>Incoming Arcs</b></em>' reference list.
	 * The list contents are of type {@link de.hpi.sam.petriNet.Arc}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.petriNet.Arc#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Arcs</em>' reference list.
	 * @see de.hpi.sam.petriNet.PetriNetPackage#getNode_IncomingArcs()
	 * @see de.hpi.sam.petriNet.Arc#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Arc> getIncomingArcs();

} // Node
