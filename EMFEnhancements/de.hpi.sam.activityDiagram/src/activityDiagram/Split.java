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
 * A representation of the model object '<em><b>Split</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link activityDiagram.Split#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link activityDiagram.Split#getOutgoings <em>Outgoings</em>}</li>
 * </ul>
 * </p>
 *
 * @see activityDiagram.ActivityDiagramPackage#getSplit()
 * @model
 * @generated
 */
public interface Split extends Element {
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
	 * @see activityDiagram.ActivityDiagramPackage#getSplit_Incoming()
	 * @model
	 * @generated
	 */
	ControlFlow getIncoming();

	/**
	 * Sets the value of the '{@link activityDiagram.Split#getIncoming <em>Incoming</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming</em>' reference.
	 * @see #getIncoming()
	 * @generated
	 */
	void setIncoming(ControlFlow value);

	/**
	 * Returns the value of the '<em><b>Outgoings</b></em>' reference list.
	 * The list contents are of type {@link activityDiagram.ControlFlow}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoings</em>' reference list.
	 * @see activityDiagram.ActivityDiagramPackage#getSplit_Outgoings()
	 * @model
	 * @generated
	 */
	EList<ControlFlow> getOutgoings();

} // Split
