/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.Action#getActivity <em>Activity</em>}</li>
 *   <li>{@link activityDiagram.Action#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends Element {
	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference list.
	 * The list contents are of type {@link activityDiagram.Activity}.
	 * It is bidirectional and its opposite is '{@link activityDiagram.Activity#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference list.
	 * @see activityDiagram.ActivityDiagramPackage#getAction_Activity()
	 * @see activityDiagram.Activity#getActions
	 * @model opposite="actions" containment="true"
	 * @generated
	 */
	EList<Activity> getActivity();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see activityDiagram.ActivityDiagramPackage#getAction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link activityDiagram.Action#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Action
