/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.StartNode#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getStartNode()
 * @model
 * @generated
 */
public interface StartNode extends Node {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference.
	 * @see #setOutgoing(ControlFlow)
	 * @see activityDiagram.ActivityDiagramPackage#getStartNode_Outgoing()
	 * @model
	 * @generated
	 */
	ControlFlow getOutgoing();

	/**
	 * Sets the value of the '{@link activityDiagram.StartNode#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(ControlFlow value);

} // StartNode
