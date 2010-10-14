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
 *   <li>{@link activityDiagram.Activity#getContainer <em>Container</em>}</li>
 *   <li>{@link activityDiagram.Activity#getFlows <em>Flows</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends Element {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link activityDiagram.Action#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference.
	 * @see #setActions(Action)
	 * @see activityDiagram.ActivityDiagramPackage#getActivity_Actions()
	 * @see activityDiagram.Action#getActivity
	 * @model opposite="activity" containment="true"
	 * @generated
	 */
	Action getActions();

	/**
	 * Sets the value of the '{@link activityDiagram.Activity#getActions <em>Actions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actions</em>' containment reference.
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

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link activityDiagram.activityDiagramContainer#getActivities <em>Activities</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(activityDiagramContainer)
	 * @see activityDiagram.ActivityDiagramPackage#getActivity_Container()
	 * @see activityDiagram.activityDiagramContainer#getActivities
	 * @model opposite="activities" transient="false"
	 * @generated
	 */
	activityDiagramContainer getContainer();

	/**
	 * Sets the value of the '{@link activityDiagram.Activity#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(activityDiagramContainer value);

	/**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link activityDiagram.ControlFlow#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flows</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference.
	 * @see #setFlows(ControlFlow)
	 * @see activityDiagram.ActivityDiagramPackage#getActivity_Flows()
	 * @see activityDiagram.ControlFlow#getActivity
	 * @model opposite="activity" containment="true"
	 * @generated
	 */
	ControlFlow getFlows();

	/**
	 * Sets the value of the '{@link activityDiagram.Activity#getFlows <em>Flows</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flows</em>' containment reference.
	 * @see #getFlows()
	 * @generated
	 */
	void setFlows(ControlFlow value);

} // Activity
