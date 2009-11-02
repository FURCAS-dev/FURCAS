/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package vortrag;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link vortrag.Container#getPerson <em>Person</em>}</li>
 *   <li>{@link vortrag.Container#getAuto <em>Auto</em>}</li>
 * </ul>
 * </p>
 *
 * @see vortrag.VortragPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' containment reference list.
	 * The list contents are of type {@link vortrag.Person}.
	 * It is bidirectional and its opposite is '{@link vortrag.Person#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' containment reference list.
	 * @see vortrag.VortragPackage#getContainer_Person()
	 * @see vortrag.Person#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Person> getPerson();

	/**
	 * Returns the value of the '<em><b>Auto</b></em>' containment reference list.
	 * The list contents are of type {@link vortrag.Auto}.
	 * It is bidirectional and its opposite is '{@link vortrag.Auto#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto</em>' containment reference list.
	 * @see vortrag.VortragPackage#getContainer_Auto()
	 * @see vortrag.Auto#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<Auto> getAuto();

} // Container
