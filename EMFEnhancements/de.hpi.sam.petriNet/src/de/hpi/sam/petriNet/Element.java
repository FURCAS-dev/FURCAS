/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.petriNet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.petriNet.Element#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
     * Returns the value of the '<em><b>Diagram</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.hpi.sam.petriNet.PetriNet#getElements <em>Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Diagram</em>' container reference.
     * @see #setDiagram(PetriNet)
     * @see de.hpi.sam.petriNet.PetriNetPackage#getElement_Diagram()
     * @see de.hpi.sam.petriNet.PetriNet#getElements
     * @model opposite="elements" required="true" transient="false"
     * @generated
     */
	PetriNet getDiagram();

	/**
     * Sets the value of the '{@link de.hpi.sam.petriNet.Element#getDiagram <em>Diagram</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Diagram</em>' container reference.
     * @see #getDiagram()
     * @generated
     */
	void setDiagram(PetriNet value);

} // Element
