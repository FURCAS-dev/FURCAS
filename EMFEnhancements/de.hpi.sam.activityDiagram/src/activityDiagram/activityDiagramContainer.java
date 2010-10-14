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
 *   <li>{@link activityDiagram.activityDiagramContainer#getActivities <em>Activities</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see activityDiagram.ActivityDiagramPackage#getactivityDiagramContainer_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Element> getElements();

	/**
	 * Returns the value of the '<em><b>Activities</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link activityDiagram.Activity#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activities</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activities</em>' containment reference.
	 * @see #setActivities(Activity)
	 * @see activityDiagram.ActivityDiagramPackage#getactivityDiagramContainer_Activities()
	 * @see activityDiagram.Activity#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	Activity getActivities();

	/**
	 * Sets the value of the '{@link activityDiagram.activityDiagramContainer#getActivities <em>Activities</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activities</em>' containment reference.
	 * @see #getActivities()
	 * @generated
	 */
	void setActivities(Activity value);

} // activityDiagramContainer
