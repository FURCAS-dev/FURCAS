/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uml Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.UmlClassDiagram#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getUmlClassDiagram()
 * @model
 * @generated
 */
public interface UmlClassDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.hpi.sam.umlClassDiagram.Element}.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.Element#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getUmlClassDiagram_Elements()
	 * @see de.hpi.sam.umlClassDiagram.Element#getDiagram
	 * @model opposite="diagram" containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // UmlClassDiagram
