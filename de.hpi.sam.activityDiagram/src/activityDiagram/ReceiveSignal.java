/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.ReceiveSignal#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link activityDiagram.ReceiveSignal#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getReceiveSignal()
 * @model
 * @generated
 */
public interface ReceiveSignal extends Element {
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
	 * @see activityDiagram.ActivityDiagramPackage#getReceiveSignal_Outgoing()
	 * @model
	 * @generated
	 */
	ControlFlow getOutgoing();

	/**
	 * Sets the value of the '{@link activityDiagram.ReceiveSignal#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(ControlFlow value);

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
	 * @see activityDiagram.ActivityDiagramPackage#getReceiveSignal_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link activityDiagram.ReceiveSignal#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ReceiveSignal
