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
 * A representation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.Join#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link activityDiagram.Join#getIncomings <em>Incomings</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getJoin()
 * @model
 * @generated
 */
public interface Join extends Element {
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
	 * @see activityDiagram.ActivityDiagramPackage#getJoin_Outgoing()
	 * @model
	 * @generated
	 */
	ControlFlow getOutgoing();

	/**
	 * Sets the value of the '{@link activityDiagram.Join#getOutgoing <em>Outgoing</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing</em>' reference.
	 * @see #getOutgoing()
	 * @generated
	 */
	void setOutgoing(ControlFlow value);

	/**
	 * Returns the value of the '<em><b>Incomings</b></em>' reference list.
	 * The list contents are of type {@link activityDiagram.ControlFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incomings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incomings</em>' reference list.
	 * @see activityDiagram.ActivityDiagramPackage#getJoin_Incomings()
	 * @model
	 * @generated
	 */
	EList<ControlFlow> getIncomings();

} // Join
