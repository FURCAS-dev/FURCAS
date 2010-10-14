/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package usecase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link usecase.Actor#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see usecase.UsecasePackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends Element {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link usecase.Association}.
	 * It is bidirectional and its opposite is '{@link usecase.Association#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see usecase.UsecasePackage#getActor_Outgoing()
	 * @see usecase.Association#getActors
	 * @model opposite="actors"
	 * @generated
	 */
	EList<Association> getOutgoing();

} // Actor
