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
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link usecase.Association#getActors <em>Actors</em>}</li>
 *   <li>{@link usecase.Association#getUsecase <em>Usecase</em>}</li>
 * </ul>
 * </p>
 *
 * @see usecase.UsecasePackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends Element {
	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list.
	 * The list contents are of type {@link usecase.Actor}.
	 * It is bidirectional and its opposite is '{@link usecase.Actor#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see usecase.UsecasePackage#getAssociation_Actors()
	 * @see usecase.Actor#getOutgoing
	 * @model opposite="outgoing"
	 * @generated
	 */
	EList<Actor> getActors();

	/**
	 * Returns the value of the '<em><b>Usecase</b></em>' reference list.
	 * The list contents are of type {@link usecase.Usecase}.
	 * It is bidirectional and its opposite is '{@link usecase.Usecase#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usecase</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usecase</em>' reference list.
	 * @see usecase.UsecasePackage#getAssociation_Usecase()
	 * @see usecase.Usecase#getIncoming
	 * @model opposite="incoming"
	 * @generated
	 */
	EList<Usecase> getUsecase();

} // Association
