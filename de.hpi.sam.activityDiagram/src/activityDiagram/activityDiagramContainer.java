/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>activity Diagram Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.activityDiagramContainer#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getactivityDiagramContainer()
 * @model
 * @generated
 */
public interface activityDiagramContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link activityDiagram.Element}.
	 * It is bidirectional and its opposite is '{@link activityDiagram.Element#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see activityDiagram.ActivityDiagramPackage#getactivityDiagramContainer_Elements()
	 * @see activityDiagram.Element#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Element> getElements();

} // activityDiagramContainer
