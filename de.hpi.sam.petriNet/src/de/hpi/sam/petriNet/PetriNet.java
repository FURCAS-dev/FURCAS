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
 *   <li>{@link de.hpi.sam.petriNet.PetriNet#getDiagramName <em>Diagram Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.petriNet.PetriNetPackage#getPetriNet()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='modelName'"
 *        annotation="http://de.hpi.sam.bp2009.OCL modelName='self.elements->notEmpty()'"
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
     * @model opposite="diagram" containment="true" lower="10"
     * @generated
     */
	EList<Element> getElements();

	/**
     * Returns the value of the '<em><b>Diagram Name</b></em>' attribute.
     * The default value is <code>"Petri Net 1.0"</code>.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Diagram Name</em>' attribute.
     * @see #setDiagramName(String)
     * @see de.hpi.sam.petriNet.PetriNetPackage#getPetriNet_DiagramName()
     * @model default="Petri Net 1.0"
     * @generated
     */
	String getDiagramName();

	/**
     * Sets the value of the '{@link de.hpi.sam.petriNet.PetriNet#getDiagramName <em>Diagram Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Diagram Name</em>' attribute.
     * @see #getDiagramName()
     * @generated
     */
	void setDiagramName(String value);

} // PetriNet
