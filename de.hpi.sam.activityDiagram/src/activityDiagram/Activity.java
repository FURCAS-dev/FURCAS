/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.Activity#getActions <em>Actions</em>}</li>
 *   <li>{@link activityDiagram.Activity#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends Element {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link activityDiagram.Action#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' container reference.
	 * @see #setActions(Action)
	 * @see activityDiagram.ActivityDiagramPackage#getActivity_Actions()
	 * @see activityDiagram.Action#getActivity
	 * @model opposite="activity" transient="false"
	 * @generated
	 */
	Action getActions();

	/**
	 * Sets the value of the '{@link activityDiagram.Activity#getActions <em>Actions</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actions</em>' container reference.
	 * @see #getActions()
	 * @generated
	 */
	void setActions(Action value);

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
	 * @see activityDiagram.ActivityDiagramPackage#getActivity_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link activityDiagram.Activity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Activity
