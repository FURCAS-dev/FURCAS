/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package activityDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Send Signal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.SendSignal#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link activityDiagram.SendSignal#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getSendSignal()
 * @model
 * @generated
 */
public interface SendSignal extends Element {
	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference.
	 * @see #setIncoming(ControlFlow)
	 * @see activityDiagram.ActivityDiagramPackage#getSendSignal_Incoming()
	 * @model
	 * @generated
	 */
	ControlFlow getIncoming();

	/**
	 * Sets the value of the '{@link activityDiagram.SendSignal#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(ControlFlow value);

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
	 * @see activityDiagram.ActivityDiagramPackage#getSendSignal_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link activityDiagram.SendSignal#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SendSignal
