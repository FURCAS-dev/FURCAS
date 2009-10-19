/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Petri Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.PetriNet#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getPetriNet()
 * @model
 * @generated
 */
public interface PetriNet extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.hpi.sam.petriNet.Element}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.petriNet.Element#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.hpi.sam.petriNet.PetriNetPackage#getPetriNet_Elements()
	 * @see de.hpi.sam.petriNet.Element#getDiagram
	 * @model opposite="diagram" containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // PetriNet
