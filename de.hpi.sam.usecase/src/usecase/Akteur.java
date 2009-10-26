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
 * A representation of the model object '<em><b>Akteur</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link usecase.Akteur#getOutgoing <em>Outgoing</em>}</li>
 * </ul>
 * </p>
 *
 * @see usecase.UsecasePackage#getAkteur()
 * @model
 * @generated
 */
public interface Akteur extends Element {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link usecase.Association}.
	 * It is bidirectional and its opposite is '{@link usecase.Association#getAkteure <em>Akteure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see usecase.UsecasePackage#getAkteur_Outgoing()
	 * @see usecase.Association#getAkteure
	 * @model opposite="akteure"
	 * @generated
	 */
	EList<Association> getOutgoing();

} // Akteur
