/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.umlClassDiagram;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.umlClassDiagram.Element#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hpi.sam.umlClassDiagram.UmlClassDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' container reference.
	 * @see #setDiagram(UmlClassDiagram)
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagramPackage#getElement_Diagram()
	 * @see de.hpi.sam.umlClassDiagram.UmlClassDiagram#getElements
	 * @model opposite="elements" transient="false"
	 * @generated
	 */
	UmlClassDiagram getDiagram();

	/**
	 * Sets the value of the '{@link de.hpi.sam.umlClassDiagram.Element#getDiagram <em>Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram</em>' container reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(UmlClassDiagram value);

} // Element
